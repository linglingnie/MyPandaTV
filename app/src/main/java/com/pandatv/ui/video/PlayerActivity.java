package com.pandatv.ui.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pandatv.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView palyerTitle;
    private Toolbar bar;
    private JCVideoPlayer videocontroller1;
    private ImageButton play_image_butt;
    private TextView play_text;
    int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initView();
        initIntent();
    }

    private void initIntent() {
        Intent intent=getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        palyerTitle.setText(title);
        play_text.setText(content);
    }
    private void initView() {

        palyerTitle = (TextView) findViewById(R.id.palyerTitle);
        bar = (Toolbar) findViewById(R.id.bar);
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        play_image_butt = (ImageButton) findViewById(R.id.play_image_butt);


        play_image_butt.setOnClickListener(this);
        play_text = (TextView) findViewById(R.id.play_text);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_image_butt:
                count++;
                if (count % 2 == 1) {
                    play_text.setVisibility(View.VISIBLE);
                } else if (count % 2 == 0) {
                    play_text.setVisibility(View.GONE);
                }
                break;
        }
    }
}
