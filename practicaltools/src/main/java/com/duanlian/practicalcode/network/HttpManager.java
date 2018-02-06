package com.duanlian.practicalcode.network;

/**
 * Created by duanlian on 2018/1/31.
 */

public class HttpManager {
    private static HttpManager mInstance;

    private HttpManager() {
    }

    public static HttpManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpManager();
                }
            }
        }
        return mInstance;
    }
}
