package com.pandatv.ui.bobao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.entity.bobaoBean.BoBaoEntity1;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BoBaoFragment extends BaseFragment implements BoBaoControct.view, XRecyclerView.LoadingListener {

    @BindView(R.id.bobao_xrecycler)
    XRecyclerView bobaoXrecycler;
    Unbinder unbinder;
    private BobaoPresenter presenters;
    private ImageView headview_picture;
    private ImageView headview_iv;
    private TextView headview_title;
    private List<BoBaoEntity2.ListBean> listdata =new ArrayList<>();
    /**
     * BaseFragment
     */
    @Override
    protected int getLayoutRes() {

        return R.layout.fragment_bobao;
    }

    /**
     * BaseFragment
     */


    @Override
    protected void initData() {

    }

    /**
     * BaseFragment
     */
    @Override
    protected void initView(View view) {

        presenters = new BobaoPresenter(this);
        presenters.start();

        View inflater = LayoutInflater.from(getContext()).inflate(R.layout.headview_item, null);


        headview_picture = (ImageView) inflater.findViewById(R.id.headview_picture);
        headview_title = (TextView) inflater.findViewById(R.id.headview_title);



    }

    /**
     * BaseFragment
     */

    @Override
    public void setBundle(Bundle bundle) {


    }


    /**
     * BoBaoControct.view
     */
    @Override
    public void showBoBaolist(BoBaoEntity1 boBaoEntity1) {

        headview_title.setText(boBaoEntity1.getData().getBigImg().get(0).getTitle());
        Glide.with(headview_picture.getContext()).load(boBaoEntity1.getData().getBigImg().get(0).getImage()).into(headview_picture);
        headview_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转页面，传值传数据
            }
        });

    }

    /**
     * BoBaoControct.view
     */
    @Override
    public void shouBoBaolistto(List<BoBaoEntity2.ListBean> list) {

    }

    /**
     * BoBaoControct.view
     */
    @Override
    public void showProgress() {

    }

    /**
     * BoBaoControct.view
     */
    @Override
    public void dismissProgress() {

    }


    /**
     * BoBaoControct.view
     */
    @Override
    public void showMessage(String msg) {

    }

    /**
     * BoBaoControct.view
     */
    @Override
    public void setPresenter(BoBaoControct.presenters presenters) {

    }

    /**
     * 手写
     **/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = super.onCreateView(inflater, container, savedInstanceState);

        unbinder = ButterKnife.bind(this, rootview);

        initView(rootview);
        return rootview;
    }

    /**
     * 手写
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * XRecyclerview刷新
     */
    @Override
    public void onRefresh() {

    }

    /**
     * XRecyclerview 加载跟多
     */
    @Override
    public void onLoadMore() {

    }
}
