package com.pandatv.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.modle.dataModel.InteractionPresenterImp;
import com.pandatv.ui.home.HomeContract;
import com.pandatv.ui.home.adapter.InteractionAdapter;
import com.pandatv.ui.home.bean.InteractionBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static com.pandatv.manager.ActivityCollector.getActivity;


public class InteractionActivity extends BaseActivity implements HomeContract.InteractionView {

    @BindView(R.id.interaction_listView)
    ListView interactionListView;
    @BindView(R.id.interaction_ptr)
    PtrFrameLayout interactionPtr;
    private ProgressDialog diaLog;
    private InteractionPresenterImp interactionPresenterImp;

    @Override
    protected void initData() {
        interactionPresenterImp = new InteractionPresenterImp(this);
        diaLog = new ProgressDialog(InteractionActivity.this);
        diaLog.setMessage("正在加载......");
        diaLog.show();
        interactionPresenterImp.start();

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interaction;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showInteraction(final InteractionBean interactionBean) {
        final List<InteractionBean.InteractiveBean> interactive = interactionBean.getInteractive();
        InteractionAdapter adapter = new InteractionAdapter(InteractionActivity.this, interactive);
        interactionListView.setAdapter(adapter);
        interactionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InteractionBean.InteractiveBean interactiveBean = interactive.get(position);
                Intent intent=new Intent(InteractionActivity.this,InteractionDetailsActivity.class);
                intent.putExtra("urlhtml",interactiveBean.getUrl());
                intent.putExtra("webtitle",interactiveBean.getTitle());
                startActivity(intent);
            }
        });

        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        interactionPtr.setHeaderView(header);
        interactionPtr.addPtrUIHandler(header);
        interactionPtr.setFooterView(footer);
        interactionPtr.addPtrUIHandler(footer);

        interactionPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                interactionPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                interactionPtr.refreshComplete();
            }
        });
    }

    @Override
    public void goToDetails() {

    }

    @Override
    public void showProgress() {
        diaLog.show();
    }

    @Override
    public void dismissProgress() {
        diaLog.dismiss();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }


}
