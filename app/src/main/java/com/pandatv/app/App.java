package com.pandatv.app;


import com.pandatv.base.BaseActivity;
import com.pandatv.base.BaseFragment;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by chj on 2017/8/20.
 */

public class App extends  BaseApplication implements Thread.UncaughtExceptionHandler{

    public static BaseActivity mBaseActivity;
    public static BaseFragment lastFragment;
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("2147601933", "0144a3a1e2add943947942501a81dbca",
                "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(getApplicationContext());
//        Config.DEBUG = true;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}
