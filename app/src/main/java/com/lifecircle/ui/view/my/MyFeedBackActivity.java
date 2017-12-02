package com.lifecircle.ui.view.my;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovo on 2017/11/11.
 */

public class MyFeedBackActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    private RelativeLayout rl_back;
    private  TextView tv_submit;
    private EditText et_back_content;
    private  EditText tv_my_feedback_center;
    //反馈内容
    private  String  back_content;
    //邮箱
    private  String emails;

    public ProgressDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfeedback);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("意见反馈");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("关于");
        toolbar_right_text.setOnClickListener(this);
        rl_back=findViewById(R.id.rl_back);
        rl_back.setOnClickListener(this);
        tv_submit=findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);
        et_back_content=findViewById(R.id.et_back_content);
        tv_my_feedback_center=findViewById(R.id.tv_my_feedback_center);
        initDialog();
    }

    public  void initDialog(){
        dialog=new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("数据提交中...");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;

            case R.id.rl_back:

                break;
            case R.id.tv_submit:
                back_content=et_back_content.getText().toString().trim();
                emails=tv_my_feedback_center.getText().toString().trim();
                OkGo.<String>post(GlobalHttpUrl.MY_BACK)
                        .tag(this)
                        .params("back_uid", GlobalVariable.uid)
                        .params("back_content", back_content)
                        .params("back_email", emails)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                String str = response.body().toString();
                                try {
                                    JSONObject jsonObject = new JSONObject(response.body().toString());
                                    if (jsonObject.getString("result").equals("200")) {

                                    }
                                    ToastUtils.showToast(jsonObject.getString("msg"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                finish();

                            }
                            @Override
                            public void onStart(Request<String, ? extends Request> request) {
                                super.onStart(request);
                                if (dialog!=null&&!dialog.isShowing()){
                                    dialog.show();
                                }
                            }

                            @Override
                            public void onFinish() {
                                super.onFinish();
                                if (dialog!=null&&dialog.isShowing()){
                                    dialog.dismiss();
                                }
                            }
                        });
                break;
        }

    }
}
