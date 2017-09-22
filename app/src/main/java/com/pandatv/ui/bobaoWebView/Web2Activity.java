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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pandatv.R;
import com.pandatv.entity.Xiongmao;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Web2Activity extends AppCompatActivity implements View.OnClickListener {
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
    private String s ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);
        ButterKnife.bind(this);



        Intent intent = getIntent();
     String id =   intent.getStringExtra("id");
              url = intent.getStringExtra("url");

        String title = intent.getStringExtra("title");
      String time = intent.getStringExtra("time");
        web2Sc.setOnClickListener(this);
        web2Fx.setOnClickListener(this);
         // String  time =  intent.getLongExtra("time",0);

         s = "http://api.cntv.cn/article/contentinfo?id=" + id + "&serviceId=panda";

        Log.e("TAG",s );
        web2Title2.setText(title);

        web2Timer2.setText(time);



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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.web2_sc:
                Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.web2_fx:
                new ShareAction(Web2Activity.this)
                        .withText(s)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {

                            }
                        })
                        .open();
                break;
        }
    }
}
