package com.pandatv.ui.live;

import android.os.Bundle;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.LiveVideoBean;
import com.pandatv.ui.live.entity.WonderfulBean;
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


        WonderfulBean.VideoBean videoBean = getIntent().getParcelableExtra("videoBean");
        final String title = videoBean.getT();
        String vid = videoBean.getVid();
        String img = videoBean.getImg();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}