package com.pandatv.main;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.BindView;
import butterknife.OnClick;

public class InteractionDetailsActivity extends BaseActivity implements UMShareListener{

//
//    @BindView(R.id.details_webView)
//    WebView detailsWebView;
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.details_title)
    TextView detailsTitle;
    @BindView(R.id.details_share)
    ImageView detailsShare;
    private WebView webView;
    private String urlhtml;

    @Override
    protected void initData() {
        urlhtml = getIntent().getStringExtra("urlhtml");
        String title = getIntent().getStringExtra("webtitle");
        Log.e("TAG", urlhtml +"<<===========>>"+title);
        detailsTitle.setText(title);
        ProgressDialog dialog=new ProgressDialog(InteractionDetailsActivity.this);
        dialog.setMessage("正在加载......");
        dialog.show();

        webView = (WebView) findViewById(R.id.details_webView);//获取WebView
        WebSettings webSettings = webView.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);//设置适应Html5的一些方法
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //设置缓存

        //加载需要显示的网页
        webView.loadUrl(urlhtml);
        //设置Web视图
        webView.setWebViewClient(new webViewClient());
        dialog.dismiss();
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {
        Toast.makeText(this, "分享开始", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        Toast.makeText(this, "分享失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        Toast.makeText(this, "分享取消", Toast.LENGTH_SHORT).show();
    }

    private class webViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interaction_details;
    }


    @OnClick({R.id.details_back, R.id.details_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_back:
                finish();
                break;
            case R.id.details_share:
                new ShareAction(this)
                        .withText(urlhtml)
                        .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.SINA,SHARE_MEDIA.WEIXIN)
                        .setCallback(this).open();
                break;
        }
    }
    //    设置回退
//    覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        finish();//结束退出程序
        return false;
    }

}
