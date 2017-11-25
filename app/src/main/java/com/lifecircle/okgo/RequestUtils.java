package com.lifecircle.okgo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

import com.google.gson.Gson;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.mvp.model.LoginBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovo on 2017/11/25.
 */

public class RequestUtils {

    public interface BeanDataListener
    {
        void StringDataComplete(String str);
    }

    public  static ProgressDialog dialog;

    public static  void initDialog(Activity activity){
        dialog=new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");
    }
    //无返值post请求
    public static void Get(String url, Context context){
        initDialog((Activity) context);
        OkGo.<String>get(url)
                .tag(context)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            String result=jsonObject.getString("result");
                            if (result.equals("200")){

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
    //post请求
    public static void Post(String url, HttpParams p, final Context context){
        initDialog((Activity) context);
        OkGo.<String>post(url)
                .tag(context)
                .params(p)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        BeanDataListener beanDataListener=(BeanDataListener)context;
                        beanDataListener.StringDataComplete(response.body().toString());
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
