package com.pandatv.ui.bobaoWebView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.RelativeLayout;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.entity.bobaoBean.Web2Entity1;
import com.pandatv.entity.bobaoBean.Web2Entity2;
import com.pandatv.entity.bobaoBean.Web2Entity3;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends BaseActivity implements WebToContract.view {


    @BindView(R.id.videoactivity_jc)
    JCVideoPlayer videoactivityJc;
    @BindView(R.id.activity_video)
    RelativeLayout activityVideo;

    private WebToContract.presenter presenter;
    /**
     * byx
     * BaseActivity
     **/
    @Override
    protected void initData() {

    }

    /**
     * BaseActivity
     **/
    @Override
    protected void initView() {

        Intent intent =getIntent();
    String stringextra= intent.getStringExtra("pid");
    presenter=new WebTopresenter(this);
        presenter.second(stringextra);
    }

    /**
     * BaseActivity
     *
     **/

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ButterKnife.bind(this);

    }



    @Override
    public void ShowWeb2list1(Web2Entity1 list1) {



    }

    @Override
    public void ShowWeb2list2(Web2Entity2 list2) {

       String url= list2.getVideo().getChapters().get(0).getUrl();
        videoactivityJc.setUpForFullscreen(url, "视频/MP3标题");
    }

    @Override
    public void ShowWeb2list3(Web2Entity3 list3) {

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(WebToContract.presenter presenter) {
        this.presenter=presenter;

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
