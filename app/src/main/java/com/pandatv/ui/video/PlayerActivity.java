package com.pandatv.ui.video;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pandatv.R;
import com.pandatv.modle.net.OkBaseHttpImpl;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.video.user.VideoUrl;
import com.pandatv.ui.video.user.Videoset;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView palyerTitle;
    private Toolbar bar;
    private JCVideoPlayer videocontroller1;
    private ImageButton play_image_butt;
    private TextView play_text;

    private ImageButton return_butt;
    private String URL = "http://api.cntv.cn/video/videolistById?vsid=";
    List<Videoset.VideoBean> list;




    //按钮点击次数的初始化值
    private int count = 0;
    //列表刷新时间
   int refreshTime = 0;
    private XRecyclerView X_recyler;
    private ImageButton collect;
    private ImageButton share;
    private PlayerAdapter adapter;
   List<Videoset.VideosetBean._$0Bean> lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initView();
        initList();
        initData();



    }

    private void initList() {
        list=new ArrayList<>();
        lists=new ArrayList<>();

    }


    protected void initData() {

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String id = intent.getStringExtra("id");
        palyerTitle.setText(title);
        ImageLoader imageloader = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(PlayerActivity.this);
        imageloader.init(configuration);
        videocontroller1.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096","http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096",title);
        //解析视屏数据


        //解析二层列表
        OkBaseHttpImpl.getInstance().get(URL + id + "&n=7&serviceId=panda&o=desc&of=time&p=", null, new NetWorkCallBack<Videoset>() {
            @Override
            public void onSuccess(Videoset set) {
                Videoset.VideosetBean bean = set.getVideoset();
                Videoset.VideosetBean._$0Bean bean_$0 = bean.get_$0();
                lists.add(bean_$0);


                List<Videoset.VideoBean> video = set.getVideo();
                list.addAll(video);


                adapter= new PlayerAdapter();
                LinearLayoutManager manger = new LinearLayoutManager(PlayerActivity.this);
                manger.setOrientation(LinearLayoutManager.VERTICAL);
                X_recyler.setLayoutManager(manger);
                X_recyler.setAdapter(adapter);
                //上拉加载下拉刷新
                X_recyler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
                X_recyler.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
                X_recyler.setLoadingListener(new XRecyclerView.LoadingListener() {
                    public void onRefresh() {
                        refreshTime++;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                X_recyler.refreshComplete();
                            }
                        }, 3000);
                    }

                    @Override
                    public void onLoadMore() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                list.clear();
                                initData();
                                adapter.notifyDataSetChanged();
                                X_recyler.loadMoreComplete();
                            }
                        }, 3000);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {


            }

            @Override
            public void onFail(String netOff) {

            }
        });


    }
    protected void initView() {
        palyerTitle = (TextView) findViewById(R.id.palyerTitle);
        bar = (Toolbar) findViewById(R.id.bar);
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        play_image_butt = (ImageButton) findViewById(R.id.play_image_butt);

        play_text = (TextView) findViewById(R.id.play_text);
        return_butt = (ImageButton) findViewById(R.id.return_butt);

        X_recyler = (XRecyclerView) findViewById(R.id.X_recyler);
        collect = (ImageButton) findViewById(R.id.collect);
        share = (ImageButton) findViewById(R.id.share);
//点击事件
        play_image_butt.setOnClickListener(this);
        return_butt.setOnClickListener(this);
        collect.setOnClickListener(this);
        share.setOnClickListener(this);

    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_image_butt:
                count++;
                if (count == 1) {
                    play_image_butt.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    play_text.setText("熊猫视频");
                    play_text.setVisibility(View.VISIBLE);

                } else {
                    play_image_butt.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    play_text.setVisibility(View.GONE);
                    count = 0;
                }
                break;
            case R.id.return_butt:
                finish();
                break;
            case R.id.collect:
                count++;
                if (count==1){
                    collect.setImageResource(R.drawable.collect_yes);
                    Toast.makeText(this,"收藏成功",Toast.LENGTH_SHORT).show();
                }else{
                    collect.setImageResource(R.drawable.collect_no);
                    Toast.makeText(this,"取消收藏",Toast.LENGTH_SHORT).show();
                    count=0;
                }
                break;
            case R.id.share:
                new ShareAction(PlayerActivity.this)
                        .withText(list.get(0).getT())
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(PlayerActivity.this,"成功了",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(PlayerActivity.this,"失败了",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(PlayerActivity.this,"取消了",Toast.LENGTH_LONG).show();
                            }
                        })
                        .open();
                break;
        }
    }

    //内部类实现适配器
    class PlayerAdapter extends XRecyclerView.Adapter<PlayerAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = View.inflate(PlayerActivity.this, R.layout.player_item, null);
            ViewHolder holder = new ViewHolder(inflate);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Glide.with(PlayerActivity.this).load(list.get(position).getImg()).into(holder.player_Image);
            holder.player_Text.setText(list.get(position).getT());
            holder.player_Time.setText(list.get(position).getLen());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                        //http://115.182.35.91/api/getVideoInfoForCBox.do?pid=a0848bf7d1ea482794b2449b1d62b009
                        OkBaseHttpImpl.getInstance().get("http://115.182.35.91/api/getVideoInfoForCBox.do?pid=" +list.get(position).getVid(), null, new NetWorkCallBack<VideoUrl>() {


                            @Override
                            public void onSuccess(VideoUrl videoUrl) {
                                //http://115.182.35.91/api/getVideoInfoForCBox.do?pid=VSET100284428835

                                VideoUrl.VideoBean video = videoUrl.getVideo();
                                String url = video.getChapters().get(0).getUrl();
                                Log.e("111111111","2222222222"+url);
                                videocontroller1.setUp(url,url,"");

                            }

                            @Override
                            public void onError(int errorCode, String errorMsg) {

                            }

                            @Override
                            public void onFail(String netOff) {

                            }

                        });



                }
            });
        }
        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView player_Image;
            private TextView player_Text;
            private TextView player_Time;

            public ViewHolder(View itemView) {
                super(itemView);
                player_Image = (ImageView) itemView.findViewById(R.id.player_item_image);
                player_Text = (TextView) itemView.findViewById(R.id.player_item_content);
                player_Time= (TextView) itemView.findViewById(R.id.video_time_size);
            }
        }
    }
}
