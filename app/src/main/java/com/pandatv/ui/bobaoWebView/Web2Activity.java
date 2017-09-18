package com.pandatv.ui.bobaoWebView;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pandatv.R;
import com.pandatv.entity.Xiongmao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Web2Activity extends AppCompatActivity {
    @BindView(R.id.tv_content)
    TextView content;
    @BindView(R.id.web2_title2)
    TextView web2Title2;
    @BindView(R.id.web2_timer2)
    TextView web2Timer2;
    @BindView(R.id.web2_sc)
    Button web2Sc;
    @BindView(R.id.web2_fx)
    Button web2Fx;
    private String url;
    private Handler handler;
    private RequestQueue queue;
    private List<Xiongmao> lists =new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);
        ButterKnife.bind(this);



        Intent intent = getIntent();
     String id =   intent.getStringExtra("id");
              url = intent.getStringExtra("url");

        String title = intent.getStringExtra("title");
      String time = intent.getStringExtra("time");
         // String  time =  intent.getLongExtra("time",0);

        String s = "http://api.cntv.cn/article/contentinfo?id=" + id + "&serviceId=panda";

        Log.e("TAG",s );
        web2Title2.setText(title);

        web2Timer2.setText(time);


       /* runOnUiThread(new Runnable() {
            @Override
            public void run() {


                WebSettings webSettings = webView.getSettings();

                //设置WebView属性，能够执行Javascript脚本
                webSettings.setJavaScriptEnabled(true);
                //设置可以访问文件
                webSettings.setAllowFileAccess(true);
                //设置支持缩放
                webSettings.setBuiltInZoomControls(true);
                //加载需要显示的网页

                webView.loadUrl(url);
                //设置Web视图
                webView.setWebViewClient(new webViewClient());
            }
        });*/
        queue = Volley.newRequestQueue(this);

        StringRequest request =new StringRequest(Request.Method.GET, s, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                    String ss =response.toString();
                Gson gson =new Gson();

                Xiongmao xiongmao = gson.fromJson(ss, Xiongmao.class);
                String contents = xiongmao.getContent();

               final String text = contents;

                content.setMovementMethod(ScrollingMovementMethod.getInstance());
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 0 * 101) {
                            content.setText((CharSequence) msg.obj);
                        }
                    }
                };

                Thread t = new Thread(new Runnable() {
                    Message msg = Message.obtain();

                    @Override
                    public void run() {
                        Html.ImageGetter imageGetter = new Html.ImageGetter() {
                            @Override
                            public Drawable getDrawable(String s) {
                                URL url;
                                Drawable drawable = null;
                                try {
                                    url = new URL(s);
                                    drawable = Drawable.createFromStream(url.openStream(), null);
                                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                                return drawable;
                            }
                        };


                        CharSequence test = Html.fromHtml(text, imageGetter, null);
                        msg.what = 0 * 101;
                        msg.obj = test;
                        handler.sendMessage(msg);
                    }

                });
                t.start();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        queue.add(request);





    }

}
