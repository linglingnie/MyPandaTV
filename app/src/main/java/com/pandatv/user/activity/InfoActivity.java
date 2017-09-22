package com.pandatv.user.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static android.R.attr.name;

public class InfoActivity extends BaseActivity {

    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.headIcon)
    ImageView headIcon;
    @BindView(R.id.person_have_login_layout)
    RelativeLayout personHaveLoginLayout;
    @BindView(R.id.nickName)
    TextView nickName;
    @BindView(R.id.personal_nickname_layout)
    RelativeLayout personalNicknameLayout;
    @BindView(R.id.activity_info)
    LinearLayout activity_info;
    @BindView(R.id.btn_login_out)
    TextView btnLoginOut;
    private String uid;
    private String icon;
    private Bitmap photo;
    private static int TAKE_PHOTO = 1;
    private static int RESULT_LOAD_IMAGE = 1;
    private String mName;
    private String name;

    @Override
    protected void initData() {


        if (mName != null) {
            nickName.setText(mName);

        } else if (name != null) {
            nickName.setText(name);
        } else {
            Glide.with(this).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(headIcon) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(InfoActivity.this.getResources(), resource);
                    ciDrawable.setCircular(true);
                    headIcon.setImageDrawable(ciDrawable);
                }
            });

            nickName.setText(uid);
        }
    }

    @Override
    protected void initView() {
        uid = getIntent().getStringExtra("uid");
        icon = getIntent().getStringExtra("icon");
        mName = getIntent().getStringExtra("mName");
        name = getIntent().getStringExtra("name");


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_info;
    }

    @OnClick({R.id.mBack, R.id.person_have_login_layout, R.id.personal_nickname_layout, R.id.btn_login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                if (mName != null) {
                    startActivity(new Intent(this, UserActivity.class).putExtra("mName", mName));

                } else if (name != null) {
                    startActivity(new Intent(this, UserActivity.class).putExtra("mName", name));
                }else {
                    startActivity(new Intent(this, UserActivity.class).putExtra("mName", uid));
                }

                finish();
                break;
            case R.id.person_have_login_layout:
                initPop();
                break;
            case R.id.personal_nickname_layout:
                if (mName != null) {
                    startActivity(new Intent(this, ChangeActivity.class).putExtra("mName", mName));
                    finish();
                } else {
                    startActivity(new Intent(this, ChangeActivity.class).putExtra("uid", uid));
                    finish();
                }
                break;
            case R.id.btn_login_out:
                UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(InfoActivity.this, "yes", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                    }
                });
                break;
        }
    }

    private void initPop() {
        final View pop = View.inflate(this, R.layout.personal_photo_tips, null);
        final PopupWindow popupWindow = new PopupWindow(pop, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, true);

        popupWindow.setBackgroundDrawable(new ColorDrawable(0x55000000));

        popupWindow.showAtLocation(activity_info, Gravity.BOTTOM, 0, 0);
        Button selectPhoto = (Button) pop.findViewById(R.id.selectPhoto);
        Button makePhoto = (Button) pop.findViewById(R.id.makePhoto);
        Button photoCancel = (Button) pop.findViewById(R.id.photoCancel);
        selectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhoto();
                popupWindow.dismiss();
            }
        });
        makePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTakePhoto();
                popupWindow.dismiss();
            }
        });
        photoCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                popupWindow.dismiss();
            }


        });
    }

    private void openTakePhoto() {
        /**
         * 在启动拍照之前最好先判断一下sdcard是否可用
         */
        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
        if (state.equals(Environment.MEDIA_MOUNTED)) {   //如果可用
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, TAKE_PHOTO);
        } else {
            Toast.makeText(this, "sdcard不可用", Toast.LENGTH_SHORT).show();
        }
    }

    private void openPhoto() {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case 1: //拍摄图片并选择
                    //两种方式 获取拍好的图片
                    if (data.getData() != null || data.getExtras() != null) { //防止没有返回结果
                        Uri uri = data.getData();
                        if (uri != null) {
                            photo = BitmapFactory.decodeFile(uri.getPath()); //拿到图片
                        }
                        if (photo == null) {
                            Bundle bundle = data.getExtras();
                            if (bundle != null) {
                                photo = (Bitmap) bundle.get("data");
                            } else {
                                Toast.makeText(getApplicationContext(), "找不到图片", Toast.LENGTH_SHORT).show();
                            }
                        }
                        //处理图片
                        //裁剪图片
                    }
                    break;
            }
        }

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            headIcon.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
