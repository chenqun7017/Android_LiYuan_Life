package com.lifecircle.adapter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.view.my.m.DataTime;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.TimeDataUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/11/30.
 */

public class MySingAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {
    private  List<String> singList;
    private Context context;
    private  String yearMonth;
    public ProgressDialog dialog;

    public MySingAdapter(int layoutResId, @Nullable List<Integer> data,List<String> singList,String yearMonth,Context context) {
        super(layoutResId, data);
        this.singList=singList;
        this.context=context;
        this.yearMonth=yearMonth;
        initDialog();
    }
    public  void initDialog(){
        dialog=new ProgressDialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("签到中...");
    }

    @TargetApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(final BaseViewHolder helper, Integer item) {
        if (item==0){
            helper.setText(R.id.text,"");
            helper.setVisible(R.id.text_oval, false);
        }else {
            helper.setText(R.id.text,item+"");
            if (singList.size()>0){
                for (int j=0;j<singList.size();j++){
                    if (singList.get(j).equals(item+"")){
                        helper.setVisible(R.id.text_oval, true);
                        helper.setTextColor(R.id.text,context.getColor(R.color.white));
                    }else {
                        helper.setVisible(R.id.text_oval, false);
                        helper.setTextColor(R.id.text,context.getColor(R.color.black));
                        helper.addOnLongClickListener(R.id.text);
                        helper.getView(R.id.text).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //当前时间
                                String str= TimeDataUtils.getTodayDateTimes();
                                //点击的时间
                                TextView tv=helper.getView(R.id.text);
                                String  c=yearMonth+tv.getText().toString().trim();
                                String b=c.replace("年","-");
                                String d=b.replace("月","-");
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                try {
                                    long date = format.parse(str).getTime();
                                    long oldDate = format.parse(d).getTime();
                                    if (date>oldDate){
                                        int days = (int) ((date - oldDate) / (1000*3600*24));
                                        if (days<=7){
                                            OkGo.<String>post(GlobalHttpUrl.SING_UP)
                                                    .tag(this)
                                                    .params("uid", GlobalVariable.uid)
                                                    .params("date", d)
                                                    .execute(new StringCallback() {
                                                        @Override
                                                        public void onSuccess(Response<String> response) {
                                                            try {
                                                                JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                                                                if (jsonObject.getString("result").equals("200")){
                                                                    String points=jsonObject.getJSONObject("data").getString("points");
                                                                    SharedPreferencesUtils.setParam(context, "points", points);
                                                                }
                                                                ToastUtils.showToast(jsonObject.getString("msg"));
                                                            } catch (JSONException e) {
                                                                e.printStackTrace();
                                                            }
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
                                        }
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }


                            }
                        });
                    }
                }
            }else {
                helper.setVisible(R.id.text_oval, false);
                helper.setTextColor(R.id.text,context.getColor(R.color.black));
                helper.getView(R.id.text).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        }

    }
}
