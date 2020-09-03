package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.network.HttpHelper;
import com.example.myapplication.network.okhttp.OKHttpProcessor;
import com.example.myapplication.network.volley.VolleyProcessor;
import com.example.myapplication.network.volley.XUtilProcessor;

import leakcanary.LeakCanary;

/**
 * Created by Tao.ZT.Zhang on 2017/8/29.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        HttpHelper.init(new VolleyProcessor(this));
        HttpHelper.init(new XUtilProcessor(this));
//        HttpHelper.init(new OKHttpProcessor());
//        LeakCanary.install(this);

    }

}
