package com.pandatv.ui.video;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.modle.net.OkBaseHttpImpl;
import com.pandatv.modle.net.callback.NetWorkCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, VideoContract.View{
    private View view;
    private List<PandaCulture.ListBean> list;
    private List<PandaCulture.BigImgBean> big;
    private ProgressDialog dialog;
    private SwipeRefreshLayout swipeRefresh;
    private String URL = "http://www.ipanda.com/kehuduan/video/index.json";
    private PandaCulture culture = new PandaCulture();
    private VideoAdapter adapter;
    private ImageButton person;
    private ListView mListView;
    private View inflate;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutRes(), null);
        initView(view);
        initData();
        showHomeListData(culture);
        initAdapter();
        initListener();
        return view;
    }
    private void initListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),PlayerActivity.class);
                intent.putExtra("title",list.get(position-1).getTitle());
                intent.putExtra("content",list.get(position-1).getBrief());
                intent.putExtra("url",list.get(position-1).getUrl());
                startActivity(intent);
            }
        });
    }


    private void showData() {


    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initData() {

        list = new ArrayList<>();
        big = new ArrayList<>();



    }

    @Override
    protected void initView(View view) {

        mListView = (ListView) view.findViewById(R.id.mListView);
        dialog = new ProgressDialog(getContext());
        person = (ImageButton) view.findViewById(R.id.person);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        inflate = view.inflate(getContext(), R.layout.video_header, null);

    }
    @Override
    public void setBundle(Bundle bundle) {

    }
    @Override
    public void onRefresh() {
        swipeRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void showHomeListData(PandaCulture pandaCulture) {
        OkBaseHttpImpl.getInstance().get(URL, null, new NetWorkCallBack<PandaCulture>() {


            @Override
            public void onSuccess(PandaCulture pandaCulture) {
                //列表数据
                final List<PandaCulture.ListBean> lists = pandaCulture.getList();
                list.addAll(lists);
                //图片集合
                final List<PandaCulture.BigImgBean> bigImg = pandaCulture.getBigImg();
                big.addAll(bigImg);
                ImageView video_Image=video_Image= (ImageView) inflate.findViewById(R.id.video_Image);

                Glide.with(getContext()).load(big.get(0).getImage()).into(video_Image);

                mListView.addHeaderView(inflate);
                adapter=new VideoAdapter(getContext(),list);
                mListView.setAdapter(adapter);
                showProgress();

                video_Image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getContext(),VideosActivity.class);
                        intent.putExtra("title",big.get(0).getTitle());

                        startActivity(intent);
                    }
                });


                dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });


    }
    private void initAdapter() {





    }

    @Override
    public void playVideo() {


    }

    @Override
    public void loadWebView() {

    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void dismissProgress() {
        dialog.cancel();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(VideoContract.Presenter presenter) {

    }
}
