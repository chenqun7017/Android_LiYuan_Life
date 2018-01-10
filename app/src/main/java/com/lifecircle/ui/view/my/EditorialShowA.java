package com.lifecircle.ui.view.my;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.EditorialShowABean;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.List;

import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by lenovo on 2017/11/21.
 */

public class EditorialShowA extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    private  ImageView iv_editorialshowa;
    private EditText tv_edit_addtitle;
    private EditText tv_edit_addcontext;
    private Bitmap bm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_editorialshowa);
        String state=getIntent().getStringExtra("state");
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("编缉展示位");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("保存");
        
        iv_editorialshowa=findViewById(R.id.iv_editorialshowa);
        iv_editorialshowa.setOnClickListener(this);
        tv_edit_addtitle = findViewById(R.id.tv_edit_addtitle);
        tv_edit_addcontext = findViewById(R.id.tv_edit_addcontext);
        toolbar_right_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkGo.<String>post(GlobalHttpUrl.PERSONAL)
                        .tag(EditorialShowA.this)
                        .params("title",tv_edit_addtitle.getText()+"")
                        .params("uid", "88")
                        .params("des",tv_edit_addcontext.getText()+"")
                        .params("img","")
                        .params("link","")
                        .params("phone","18514469734")
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Gson gson=new Gson();
                                String sar=response.body().toString();
                                Type type = new TypeToken<EditorialShowABean>(){}.getType();
                                EditorialShowABean editorialShowABean=gson.fromJson(sar,type);
                                Log.e("gerenzhanshi",sar+"");
                                if (editorialShowABean.getResult().equals("200")){
                                    finish();
                                    ToastUtils.showToast(editorialShowABean.getMsg());
                                }
                            }
                        });
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.iv_editorialshowa:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                }else {
                    MultiImageSelector.create(this)
                            .single() // 单选模式
                            .start(this, 1);
                }
                break;
        }

    }

    private void initSave(String title,String des) {
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                // 获取返回的图片列表
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                if (path!=null){
                    bm = BitmapFactory.decodeFile(path.get(0));
                    iv_editorialshowa.setImageBitmap(bm);
                }

            }
        }
    }
}
