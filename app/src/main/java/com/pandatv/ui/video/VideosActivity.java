package com.pandatv.ui.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pandatv.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideosActivity extends AppCompatActivity {
    private JCVideoPlayer videocontroller1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        initView();
        initData();
    }
    private void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String pid = intent.getStringExtra("pid");
        //获取ImageLoader对象
        ImageLoader imageloader = ImageLoader.getInstance();
//使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
//初始化ImageLoader的配置
        imageloader.init(configuration);
        videocontroller1.setUp("http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/19/41f6ae4c38c7478baabcf0944e0f31d1_h2642000000nero_aac16.mp4"
        ,"http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/19/41f6ae4c38c7478baabcf0944e0f31d1_h2642000000nero_aac16.mp4",title);
    }
    private void initView() {
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
    }
}
