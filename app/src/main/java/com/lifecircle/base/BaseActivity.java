package com.lifecircle.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * Created by lenovo on 2017/11/6.
 */

public class BaseActivity extends AppCompatActivity {

    /*** 创建存放activity 椎 */
    private static Stack<BaseActivity> sActivities = new Stack<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        addActivity(this);
        super.onCreate(savedInstanceState);
        //禁止activity横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
    }

    /**
     * 界面Activity入栈
     * @param activity
     */
    private static void addActivity(BaseActivity activity) {
        if (activity == null) {
            return;
        }
        sActivities.push(activity);
    }

    /**
     * 界面Activity移出栈
     *
     * @param activity
     */
    private static void removeActivity(BaseActivity activity) {
        if (activity == null) {
            return;
        }
        if (sActivities.contains(activity)) {
            sActivities.remove(activity);
        }
    }

    /**
     * 关闭客户端
     */
    public static void closeApplication() {
        if (!sActivities.empty()) {
            for (BaseActivity activity : sActivities) {
                if (activity != null && !activity.isFinishing())
                    activity.finish();
            }
            sActivities.clear();
        }
    }

    @Override
    protected void onDestroy() {
        removeActivity(this);
        super.onDestroy();
    }

}
