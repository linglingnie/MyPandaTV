package com.pandatv.main;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class InteractionDetailsActivity extends BaseActivity {


    @BindView(R.id.details_webView)
    WebView detailsWebView;
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.details_title)
    TextView detailsTitle;
    @BindView(R.id.details_share)
    ImageView detailsShare;

    @Override
    protected void initData() {
        String urlhtml = getIntent().getStringExtra("urlhtml");
        String title = getIntent().getStringExtra("webtitle");
        Log.e("TAG",urlhtml+"<<===========>>"+title);
        detailsTitle.setText(title);

        if (detailsWebView==null){
            detailsWebView.loadUrl(urlhtml);
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
                Toast.makeText(this, "点击了分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }

//    private class webViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            detailsWebView.loadUrl(url);
//            return true;
//        }
//    }
}
