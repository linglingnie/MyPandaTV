package com.pandatv.user.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.modle.net.OkBaseHttpImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.name;
import static android.R.id.list;
import static com.umeng.qq.handler.a.p;
import static com.umeng.socialize.utils.DeviceConfig.context;

public class UserActivity extends BaseActivity {

    @BindView(R.id.person_have_login_layout)
    RelativeLayout personLoginLayout;
    @BindView(R.id.personal_history_layout)
    RelativeLayout personalHistoryLayout;
    @BindView(R.id.personal_shoucang_layout)
    RelativeLayout personalShoucangLayout;
    @BindView(R.id.personal_set_layout)
    RelativeLayout personalSetLayout;
    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.personNickname)
    TextView personNickname;
    @BindView(R.id.nickImg)
    ImageView nickImg;
    @BindView(R.id.personal_callback_layout)
    RelativeLayout personalCallbackLayout;
    private String uid;
    private String icon;
    private String mName;

    @Override
    protected void initData() {
        uid = getIntent().getStringExtra("uid");
        icon = getIntent().getStringExtra("icon");
        if (uid != null) {
            personNickname.setText(uid);
            Glide.with(this).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(nickImg) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(UserActivity.this.getResources(), resource);
                    ciDrawable.setCircular(true);
                    nickImg.setImageDrawable(ciDrawable);
                }
            });

        }
    }

    @Override
    protected void initView() {
        mName = getIntent().getStringExtra("mName");
        uid = getIntent().getStringExtra("uid");
        icon = getIntent().getStringExtra("icon");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;

    }

    @OnClick({R.id.mBack, R.id.person_have_login_layout, R.id.personal_history_layout, R.id.personal_shoucang_layout, R.id.personal_set_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                finish();
                break;
            case R.id.person_have_login_layout:
                finish();
                if (personNickname.getText().equals("昵称")) {
                    personNickname.setText("昵称");
                    startActivity(new Intent(this, LoginActivity.class));
                } else {

                    startActivity(new Intent(this, InfoActivity.class).putExtra("uid", uid).putExtra("icon", icon));
                }
                if (mName != null) {
                    personNickname.setText(mName);
                }
                personNickname.setText(uid);
                Glide.with(this).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(nickImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(UserActivity.this.getResources(), resource);
                        ciDrawable.setCircular(true);
                        nickImg.setImageDrawable(ciDrawable);
                    }
                });

                break;
            case R.id.personal_history_layout:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.personal_shoucang_layout:
                startActivity(new Intent(this, UserCollectActivity.class));
                break;
            case R.id.personal_set_layout:
                startActivity(new Intent(this, SetActivity.class));
                break;
        }
    }

}
