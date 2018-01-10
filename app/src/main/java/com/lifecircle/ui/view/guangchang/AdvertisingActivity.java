package com.lifecircle.ui.view.guangchang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.utils.ToastUtils;

/**
 * Created by lenovo on 2018/1/3.
 */

public class AdvertisingActivity extends BaseActivity {

    private WebView web_advertising;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertising);
        web_advertising = findViewById(R.id.web_advertising);
        Intent intent=getIntent();
        final String advertising=getIntent().getStringExtra("advertising");
        ToastUtils.showToast(advertising+"");
        WebSettings settings = web_advertising.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小 
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        web_advertising.loadUrl(advertising);
        web_advertising.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(advertising);
                return true;
            }
        });
    }
}
