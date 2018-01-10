package com.lifecircle.ui.view.my;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.PayWXBean;
import com.lifecircle.ui.model.PayZFBBean;
import com.lifecircle.ui.model.PaymentBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.PayResult;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2017/11/13.
 */

public class MyRechargeActivity extends BaseActivity implements View.OnClickListener {
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private ImageView iv_recharge_weixi;
    private ImageView iv_recharge_pay;

    private  TextView rv_recharge_submit;
    
    private  String  PAY="0";
    private EditText et_recharge;
    private static final int SDK_PAY_FLAG = 1;
    private String payInfo;
    private IWXAPI iwxapi;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(MyRechargeActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        ActivityUtil.startMyWalletActivity(MyRechargeActivity.this);
                        finish();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(MyRechargeActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(MyRechargeActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

    };
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecharge);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("充值");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        iv_recharge_weixi=findViewById(R.id.iv_recharge_weixi);
        iv_recharge_weixi.setOnClickListener(this);
        iv_recharge_pay=findViewById(R.id.iv_recharge_pay);
        iv_recharge_pay.setOnClickListener(this);

        rv_recharge_submit=findViewById(R.id.rv_recharge_submit);
        rv_recharge_submit.setOnClickListener(this);
        et_recharge = findViewById(R.id.et_recharge);
        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                ActivityUtil.startMyWalletActivity(MyRechargeActivity.this);
                break;
            case R.id.iv_recharge_weixi:
                rv_recharge_submit.setBackgroundResource(R.color.colorPrimary);
                PAY="1";
                iv_recharge_weixi.setImageResource(R.drawable.yixuanzhe);
                iv_recharge_pay.setImageResource(R.drawable.weixuanzhe);
                break;
            case R.id.iv_recharge_pay:
                rv_recharge_submit.setBackgroundResource(R.color.colorPrimary);
                PAY="2";
                iv_recharge_weixi.setImageResource(R.drawable.weixuanzhe);
                iv_recharge_pay.setImageResource(R.drawable.yixuanzhe);
                break;
            case R.id.rv_recharge_submit:
                initPay();
                break;
        }
    }

    private void initPay() {
        OkGo.<String>post(GlobalHttpUrl.PAYMENT)
                .tag(MyRechargeActivity.this)
                .params("uid", GlobalVariable.uid)
                .params("paymoney",et_recharge.getText()+"")
                .params("pay_type",PAY+"")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<PaymentBean>() {
                        }.getType();
                        PaymentBean paymentBean = gson.fromJson(str, type);
                        if (paymentBean.getResult().equals("200")){
                            Log.e("jiaoyi",paymentBean.getData().getPay()+"!!!!!!!"+paymentBean.getData().getBody());
                            if (paymentBean.getData().getPay().equals("2")){
                                initPayss(paymentBean.getData().getPay(),paymentBean.getData().getTrade_no(),paymentBean.getData().getTotal_fee(),paymentBean.getData().getBody());
                            }if (paymentBean.getData().getPay().equals("1")){
                                ToastUtils.showToast("shiyongweixinchongzhi");
                                initPays(paymentBean.getData().getPay(),paymentBean.getData().getTrade_no(),paymentBean.getData().getTotal_fee(),paymentBean.getData().getBody());
                            }
                        }
                    }
                });
    }

    private void initPayss(String pay,String tradeNo,String totalFee ,String body) {
        OkGo.<String>post(GlobalHttpUrl.PAYMENTS)
                .tag(MyRechargeActivity.this)
                .params("pay_type",pay+"")
                .params("trade_no",tradeNo+"")
                .params("body",body+"")
                .params("total_fee",totalFee+"")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<PayZFBBean>() {
                        }.getType();
                        PayZFBBean payZFBBean = gson.fromJson(str, type);
                        if (payZFBBean.getResult().equals("200")){
                            payInfo=payZFBBean.getData()+"";
                            // 必须异步调用
                            Thread payThread = new Thread(payRunnable);
                            payThread.start();
                        }
                    }
                });
    }

    private void initPays(final String pay, String tradeNo, String totalFee , String body) {
        OkGo.<String>post(GlobalHttpUrl.PAYMENTS)
                .tag(MyRechargeActivity.this)
                .params("pay_type",pay+"")
                .params("trade_no",tradeNo+"")
                .params("body",body+"")
                .params("total_fee",totalFee+"")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<PayWXBean>() {
                        }.getType();
                        PayWXBean payWXBean = gson.fromJson(str, type);
                        Log.e("weixinaaaa",str+"");
                        if (payWXBean.getResult().equals("200")){
                            toWXPay(payWXBean.getData().getAppid(),payWXBean.getData().getSign(),payWXBean.getData().getPartnerid(),payWXBean.getData().getPrepayid(),payWXBean.getData().getNoncestr(),payWXBean.getData().getTimestamp());
                        
                        }
                    }
                });
    }

    private void toWXPay(final String appid, final String sign, final String partnerId, final String prepayId, final String nonceStr, final int timeStamp) {
        iwxapi = WXAPIFactory.createWXAPI(this, null,true); //初始化微信api
        iwxapi.registerApp(appid); //注册appid  appid可以在开发平台获取

        Runnable payWXRunnable = new Runnable() {  //这里注意要放在子线程
            @Override
            public void run() {
                PayReq request = new PayReq(); //调起微信APP的对象
                //下面是设置必要的参数，也就是前面说的参数,这几个参数从何而来请看上面说明
                request.appId = appid;
                request.partnerId = partnerId;
                request.prepayId = prepayId;
                request.packageValue = "Sign=WXPay";
                request.nonceStr = nonceStr;
                request.timeStamp = timeStamp+"";
                request.sign = sign;
                iwxapi.sendReq(request);//发送调起微信的请求
            }
        };
        Thread payWXThread = new Thread(payWXRunnable);
        payWXThread.start();
    }
    
    
    Runnable payRunnable = new Runnable() {
        @Override
        public void run() {
            // 构造PayTask 对象
            PayTask alipay = new PayTask(MyRechargeActivity.this);
            // 调用支付接口，获取支付结果
            String result = alipay.pay(payInfo, true);
            Message msg = new Message();
            msg.what = SDK_PAY_FLAG;
            msg.obj = result;
            mHandler.sendMessage(msg);
        }
    };
    
}
