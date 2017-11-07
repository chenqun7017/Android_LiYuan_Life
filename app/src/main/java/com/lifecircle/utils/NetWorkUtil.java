package com.lifecircle.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by chenqun on 2017/8/10.
 */

public class NetWorkUtil {
    /**
     * 判断是否有网络
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {

        final ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean mbEdgeConn = false;
        final NetworkInfo[] info = manager.getAllNetworkInfo();
        for (int i = 0; i < info.length; ++i) {
            if (info[i].getState().equals(NetworkInfo.State.CONNECTED)) {

                String value = info[i].getTypeName();
                if ((info[i].getTypeName().equalsIgnoreCase("mobile"))
                        && (info[i].getSubtypeName().equalsIgnoreCase("EDGE"))) {
                    mbEdgeConn = true;
                }
                return true;
            }
        }

        return false;
    }


}
