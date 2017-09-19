package com.pandatv.ui.live;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.LiveVideoBean;
import com.pandatv.ui.live.liveContract.LiveModelImp;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class LiveVideoActivity extends BaseActivity{

    @BindView(R.id.video_jcvideoplayer)
    JCVideoPlayer videoJcvideoplayer;


    @Override
    protected void initData() {
//获取ImageLoader对象
        ImageLoader imageloader= ImageLoader.getInstance();
//使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this.getApplicationContext());
//初始化ImageLoader的配置
        imageloader.init(configuration);


        final String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String url = getIntent().getStringExtra("url");
        String vid = getIntent().getStringExtra("vid");


        LiveModelImp liveModelImp = new LiveModelImp();
        liveModelImp.loadVideoActivity(new NetWorkCallBack<LiveVideoBean>() {
            @Override
            public void onSuccess(LiveVideoBean videoBean) {
                LiveVideoBean.VideoBean video = videoBean.getVideo();
                String url = video.getChapters().get(0).getUrl();
                String image = video.getChapters().get(0).getImage();
                videoJcvideoplayer.setUp(url,image,title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        },vid);



    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_live_video;
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
