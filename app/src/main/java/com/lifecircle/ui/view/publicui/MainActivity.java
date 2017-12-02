package com.lifecircle.ui.view.publicui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.view.fragmemt.GuangChangFragment;
import com.lifecircle.ui.view.fragmemt.LinJuFragment;
import com.lifecircle.ui.view.fragmemt.MyFragment;
import com.lifecircle.ui.view.fragmemt.ZhouBianServiceFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    // 底部标签切换的Fragment
    private Fragment guangChangFragment,zhouBianServices, linJuFragment,myFragment,
            currentFragment;

    private ImageView iv_guangchang;
    private ImageView iv_zhoubianservices;
    private ImageView iv_linju;
    private ImageView iv_my;

    private TextView tv_guangchang;
    private TextView tv_zhoubianservices;
    private TextView tv_linju;
    private TextView tv_my;


    private RelativeLayout rl_guangchang;
    private RelativeLayout rl_zhoubianservices;
    private RelativeLayout rl_linju;
    private RelativeLayout rl_my;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTab();
    }
    private void initView() {
        iv_guangchang= findViewById(R.id.iv_guangchang);
        iv_zhoubianservices= findViewById(R.id.iv_zhoubianservices);
        iv_linju= findViewById(R.id.iv_linju);
        iv_my=  findViewById(R.id.iv_my);

        tv_guangchang= findViewById(R.id.tv_guangchang);
        tv_zhoubianservices= findViewById(R.id.tv_zhoubianservices);
        tv_linju= findViewById(R.id.tv_linju);
        tv_my=  findViewById(R.id.tv_my);

        rl_guangchang=findViewById(R.id.rl_guangchang);
        rl_zhoubianservices=findViewById(R.id.rl_zhoubianservices);
        rl_linju= findViewById(R.id.rl_linju);
        rl_my= findViewById(R.id.rl_my);

        rl_guangchang.setOnClickListener(this);
        rl_zhoubianservices.setOnClickListener(this);
        rl_linju.setOnClickListener(this);
        rl_my.setOnClickListener(this);
    }

    private void initTab() {
        if (guangChangFragment == null) {
            guangChangFragment = new GuangChangFragment();
        }

        if (!guangChangFragment.isAdded()) {// 如果当前fragment未被添加，则添加到Fragment管理器中
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, guangChangFragment).commit();
            // 记录当前Fragment
            currentFragment = guangChangFragment;

            // 设置图片文本的变化
            iv_guangchang.setImageResource(R.drawable.guangchang_pre);
            tv_guangchang.setTextColor(getResources().getColor(R.color.colorPrimary));

            iv_zhoubianservices.setImageResource(R.drawable.zhoubianfuwu_nor);
            tv_zhoubianservices.setTextColor(getResources().getColor(R.color.black));

            iv_linju.setImageResource(R.drawable.linju_nor);
            tv_linju.setTextColor(getResources().getColor(R.color.black));

            iv_my.setImageResource(R.drawable.my_nor);
            tv_my.setTextColor(getResources().getColor(R.color.black));

        }

    }

    private void clickTabToGuangChangFragment() {
        if (guangChangFragment == null) {
            guangChangFragment = new GuangChangFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), guangChangFragment);
        // 设置图片文本的变化
        iv_guangchang.setImageResource(R.drawable.guangchang_pre);
        tv_guangchang.setTextColor(getResources().getColor(R.color.colorPrimary));

        iv_zhoubianservices.setImageResource(R.drawable.zhoubianfuwu_nor);
        tv_zhoubianservices.setTextColor(getResources().getColor(R.color.black));

        iv_linju.setImageResource(R.drawable.linju_nor);
        tv_linju.setTextColor(getResources().getColor(R.color.black));

        iv_my.setImageResource(R.drawable.my_nor);
        tv_my.setTextColor(getResources().getColor(R.color.black));

    }

    private void clickTabToZhouBianServices() {
        if (zhouBianServices == null) {
            zhouBianServices = new ZhouBianServiceFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), zhouBianServices);
        // 设置图片文本的变化
        iv_guangchang.setImageResource(R.drawable.guangchang_nor);
        tv_guangchang.setTextColor(getResources().getColor(R.color.black));

        iv_zhoubianservices.setImageResource(R.drawable.zhoubianfuwu_pre);
        tv_zhoubianservices.setTextColor(getResources().getColor(R.color.colorPrimary));

        iv_linju.setImageResource(R.drawable.linju_nor);
        tv_linju.setTextColor(getResources().getColor(R.color.black));

        iv_my.setImageResource(R.drawable.my_nor);
        tv_my.setTextColor(getResources().getColor(R.color.black));
    }

    private void clickTabToLinJuFragment() {
        if (linJuFragment == null) {
            linJuFragment = new LinJuFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), linJuFragment);

        // 设置图片文本的变化
        iv_guangchang.setImageResource(R.drawable.guangchang_nor);
        tv_guangchang.setTextColor(getResources().getColor(R.color.black));

        iv_zhoubianservices.setImageResource(R.drawable.zhoubianfuwu_nor);
        tv_zhoubianservices.setTextColor(getResources().getColor(R.color.black));

        iv_linju.setImageResource(R.drawable.linju_pre);
        tv_linju.setTextColor(getResources().getColor(R.color.colorPrimary));

        iv_my.setImageResource(R.drawable.my_nor);
        tv_my.setTextColor(getResources().getColor(R.color.black));
    }

    private void clickTabToMyFragment() {
        if (myFragment == null) {
            myFragment = new MyFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), myFragment);
        // 设置图片文本的变化
        iv_guangchang.setImageResource(R.drawable.guangchang_nor);
        tv_guangchang.setTextColor(getResources().getColor(R.color.black));

        iv_zhoubianservices.setImageResource(R.drawable.zhoubianfuwu_nor);
        tv_zhoubianservices.setTextColor(getResources().getColor(R.color.black));

        iv_linju.setImageResource(R.drawable.linju_nor);
        tv_linju.setTextColor(getResources().getColor(R.color.black));

        iv_my.setImageResource(R.drawable.my_pre);
        tv_my.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    private void addOrShowFragment(FragmentTransaction transaction,
                                   Fragment fragment) {
        if (currentFragment == fragment)
            return;

        if (!fragment.isAdded()) {
            transaction.hide(currentFragment)
                    .add(R.id.content_layout, fragment).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }

        currentFragment = fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_guangchang:
                clickTabToGuangChangFragment();
                break;
            case R.id.rl_zhoubianservices:
                clickTabToZhouBianServices();
                break;
            case R.id.rl_linju:
                clickTabToLinJuFragment();
                break;
            case R.id.rl_my:
                clickTabToMyFragment();
                break;
                default:
                    break;
        }
    }
}
