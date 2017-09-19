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
        //获取ImageLoader对象
        ImageLoader imageloader = ImageLoader.getInstance();
//使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
//初始化ImageLoader的配置
        imageloader.init(configuration);
        videocontroller1.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096","http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096",title);
    }
    private void initView() {
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
    }
}
