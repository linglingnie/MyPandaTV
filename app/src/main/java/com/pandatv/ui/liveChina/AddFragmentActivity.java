package com.pandatv.ui.liveChina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.ui.liveChina.model.MyGridLayout;

import java.util.ArrayList;

public class AddFragmentActivity extends AppCompatActivity{



    private ImageView imageView;
    private LinearLayout mGridLayout_ll;
    private boolean mFlag = true;
    private RelativeLayout layoutGridTitle;

    private MyGridLayout gridlayoutDrageable;
    private MyGridLayout gridlayoutUndrageable;
    private TextView bianjiTv;
    private int a =2;
    private int b =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_fragment);

        initView();
        initGridLayout();


    }

    private void initGridLayout() {
        gridlayoutDrageable.setEnableDrag(true);
        final ArrayList<String> list = new ArrayList<String>();
        list.add("八达岭");
        list.add("泰山");
        list.add("黄山");
        list.add("凤凰古城");
        list.add("峨眉山");
        list.add("黔县");

        //  gridlayoutDrageable.addItems(list);
        gridlayoutDrageable.setItems(list);

        gridlayoutUndrageable.setEnableDrag(false);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("张家界");
        list2.add("中央电视塔");
        list2.add("恒山悬空寺");
        list2.add("黄果树");
        list2.add("黄龙");
        list2.add("武夷山");
        list2.add("龙虎山");
        list2.add("嵩山少林寺");
        list2.add("承德避暑山庄");
        list2.add("敦煌月牙泉");
        list2.add("都江堰");
        list2.add("山海关");
        list2.add("水长城");
        list2.add("嘉峪关");
        list2.add("天山");
        list2.add("乌镇");
        list2.add("青海湖鸟岛");
        list2.add("金丝猴");
        list2.add("朱鹮");
        list2.add("丹霞山");
        list2.add("天涯海角");
        list2.add("雪乡");
        list2.add("乐山大佛");
        list2.add("哈尼梯田");
        //   gridlayoutUndrageable.addItems(list2);
        gridlayoutUndrageable.setItems(list2);

        gridlayoutDrageable.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                gridlayoutDrageable.removeView(tv);
                gridlayoutUndrageable.addItem(tv.getText().toString());
            }

        });

        gridlayoutUndrageable.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                gridlayoutUndrageable.removeView(tv);
                gridlayoutDrageable.addItem(tv.getText().toString());
            }
        });

        bianjiTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (a>1){
                   bianjiTv.setText("完成");

               }



            }
        });
    }

    private void initView() {
       // vp= (ViewPager) view.findViewById(R.id.vw_pager);
        imageView= (ImageView)findViewById(R.id.img_jiahao);
       // tabLayout= (TabLayout)view. findViewById(R.id.tb_tablay);
       bianjiTv =(TextView) findViewById(R.id.bianji);

        mGridLayout_ll= (LinearLayout) findViewById(R.id.gridlayout_ll);

       layoutGridTitle= (RelativeLayout) findViewById(R.id.layout_grid_title);
        gridlayoutDrageable = (MyGridLayout)findViewById(R.id.gridlayout_drageable);
        gridlayoutUndrageable = (MyGridLayout) findViewById(R.id.gridlayout_undrageable);

        if (mFlag) {
            mGridLayout_ll.setVisibility(View.VISIBLE);
            layoutGridTitle.setVisibility(View.VISIBLE);


            // tabLayout.setVisibility(View.GONE);
            Broadcast();

            // 加号旋转动画 打开 顺时针
            Animation anim = AnimationUtils.loadAnimation(AddFragmentActivity.this,
                    R.anim.jiahao_shunshizhen_anim);
            imageView.startAnimation(anim);

            // 标题动画(由完全透明 ----完全不透明)
            AlphaAnimation aa = new AlphaAnimation(0.0F, 1.0F);
            aa.setDuration(500);
            aa.setFillAfter(true);
            layoutGridTitle.startAnimation(aa);

            // 从上往下平移动画
            Animation translateAnim = AnimationUtils.loadAnimation(
                    AddFragmentActivity.this, R.anim.top2bottom_anim);
            mGridLayout_ll.startAnimation(translateAnim);

            mFlag = false;
        } else {
            Intent intent1 = new Intent();
            intent1.putExtra("ss", 1);
            intent1.setAction("com.jiyun.add");
            AddFragmentActivity.this.sendBroadcast(intent1);
            mGridLayout_ll.setVisibility(View.GONE);
            layoutGridTitle.setVisibility(View.GONE);
            //    vp.setVisibility(View.VISIBLE);
            // tabLayout.setVisibility(View.VISIBLE);
            // 逆时针旋转动画
            Animation anim = AnimationUtils.loadAnimation(AddFragmentActivity.this,
                    R.anim.jiahao_nishi_anim);
            imageView.startAnimation(anim);

            // 标题动画(由完全不透明 ----完全透明)
            AlphaAnimation aa = new AlphaAnimation(1.0F, 0.0F);
            aa.setDuration(500);
            aa.setFillAfter(true);
            layoutGridTitle.startAnimation(aa);

            // 从下往上平移动画
            Animation translateAnim = AnimationUtils.loadAnimation(
                    AddFragmentActivity.this, R.anim.bottom2top_anim);
            mGridLayout_ll.startAnimation(translateAnim);

            mFlag = true;
        }


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Broadcast() {
        Intent intent = new Intent();
        intent.putExtra("ss", 0);
        intent.setAction("com.jiyun.add");
        AddFragmentActivity.this.sendBroadcast(intent);
    }


}
