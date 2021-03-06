package com.pandatv.ui.home.activity;


import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.config.Urls;
import com.pandatv.main.MainActivity;
import com.pandatv.modle.dataModel.PandaHomeModelImpl;
import com.pandatv.modle.net.OkBaseHttpImpl;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.home.bean.WheelBean;

import java.io.IOException;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.media.CamcorderProfile.get;


public class VideoActivity extends BaseActivity {

    @BindView(R.id.mVideoController)
    JCVideoPlayer mVideoController;
    private String wheelPid;
    private String broadPid;
    private String castPid;
    private String momentPid;
    private String videoPid;

    @Override
    protected void initData() {

        wheelPid = getIntent().getStringExtra("wheelPid");
        broadPid = getIntent().getStringExtra("broadPid");
        castPid = getIntent().getStringExtra("castPid");
        momentPid = getIntent().getStringExtra("momentPid");
        videoPid = getIntent().getStringExtra("videoPid");

   //     mVideoController.setUp("http://3811.liveplay.myqcloud.com/live/flv/3811_channel349.flv?AUTH=/h/gBtQU7WOQaFzNwVypMUmXngZAAqdEH6wPHyLaaaaocGqSiOu8wkxB92D0ImGGSXH6nlJncdJe8P3TMidUkA==", "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", "直播");
        initVideo();


    }

    private void initPop() {
        final View pop = View.inflate(VideoActivity.this, R.layout.player_tip, null);
        final PopupWindow popupWindow = new PopupWindow(pop, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x55000000));
        popupWindow.showAtLocation(pop, Gravity.CENTER, 0, 0);

        TextView cancel = (TextView) pop.findViewById(R.id.btn_cancel);
        TextView ok = (TextView) pop.findViewById(R.id.btn_ok);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                initVideo();
            }
        });
    }

    private void initVideo() {
        if (wheelPid != null) {
            new PandaHomeModelImpl().loadWheel(Urls.PINJIE3 + wheelPid, new NetWorkCallBack<WheelBean>() {
                @Override
                public void onSuccess(WheelBean wheelBean) {

                    mVideoController.setUp(wheelBean.getVideo().getLowChapters().get(0).getUrl(), "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", wheelBean.getTitle());
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }

                @Override
                public void onFail(String netOff) {

                }
            });
        } else if (broadPid != null) {
            new PandaHomeModelImpl().loadWheel(Urls.PINJIE3 + broadPid, new NetWorkCallBack<WheelBean>() {
                @Override
                public void onSuccess(WheelBean wheelBean) {

                    mVideoController.setUp(wheelBean.getVideo().getLowChapters().get(0).getUrl(), "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", wheelBean.getTitle());
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }

                @Override
                public void onFail(String netOff) {

                }
            });
        } else if (castPid != null) {
            new PandaHomeModelImpl().loadWheel(Urls.PINJIE3 + castPid, new NetWorkCallBack<WheelBean>() {
                @Override
                public void onSuccess(WheelBean wheelBean) {

                    mVideoController.setUp(wheelBean.getVideo().getLowChapters().get(0).getUrl(), "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", wheelBean.getTitle());
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }

                @Override
                public void onFail(String netOff) {

                }
            });
        } else if (momentPid != null) {
            new PandaHomeModelImpl().loadWheel(Urls.PINJIE3 + momentPid, new NetWorkCallBack<WheelBean>() {
                @Override
                public void onSuccess(WheelBean wheelBean) {

                    mVideoController.setUp(wheelBean.getVideo().getLowChapters().get(0).getUrl(), "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", wheelBean.getTitle());
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }

                @Override
                public void onFail(String netOff) {

                }
            });
        } else if (videoPid != null) {
            new PandaHomeModelImpl().loadWheel(Urls.PINJIE3 + videoPid, new NetWorkCallBack<WheelBean>() {
                @Override
                public void onSuccess(WheelBean wheelBean) {

                    mVideoController.setUp(wheelBean.getVideo().getLowChapters().get(0).getUrl(), "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", wheelBean.getTitle());
                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }

                @Override
                public void onFail(String netOff) {

                }
            });
        } else {
            mVideoController.setUp("http://3811.liveplay.myqcloud.com/live/flv/3811_channel349.flv?AUTH=/h/gBtQU7WOQaFzNwVypMUmXngZAAqdEH6wPHyLaaaaocGqSiOu8wkxB92D0ImGGSXH6nlJncdJe8P3TMidUkA==", "https://imgsa.baidu.com/forum/w%3D580/sign=99f9e2f88acb39dbc1c0675ee01609a7/6c086e061d950a7b4635c8d601d162d9f2d3c9a4.jpg", "直播");

        }
    }

    @Override
    protected void initView() {

        //获取ImageLoader对象
        ImageLoader imageloader = ImageLoader.getInstance();
        //使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
        //初始化ImageLoader的配置
        imageloader.init(configuration);
    }

    @Override
    protected int getLayoutId() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_home_video;
    }

    @Override
    protected void onResume() {

        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        super.onResume();
    }
}
