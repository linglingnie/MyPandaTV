package com.pandatv.user.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.x;

public class SetActivity extends AppCompatActivity {

    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.pe_set_push_view)
    ImageView peSetPushView;
    @BindView(R.id.pe_set_play_view)
    ImageView peSetPlayView;
    @BindView(R.id.mClearNum)
    TextView mClearNum;
    @BindView(R.id.mClear)
    TextView mClear;
    @BindView(R.id.mFeedback)
    RelativeLayout mFeedback;
    @BindView(R.id.mSetUpdate)
    RelativeLayout mSetUpdate;
    @BindView(R.id.mSetPing)
    RelativeLayout mSetPing;
    @BindView(R.id.mSetAbout)
    RelativeLayout mSetAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mBack, R.id.pe_set_push_view, R.id.pe_set_play_view, R.id.mClearNum, R.id.mClear, R.id.mFeedback, R.id.mSetUpdate, R.id.mSetPing, R.id.mSetAbout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                finish();
                break;
            case R.id.pe_set_push_view:
                break;
            case R.id.pe_set_play_view:
                break;
            case R.id.mClearNum:
                break;
            case R.id.mClear:
                mClearNum.setText(" ");
                break;
            case R.id.mFeedback:
                startActivity(new Intent(this, BackActivity.class));
                break;
            case R.id.mSetUpdate:
                Toast.makeText(this, "没有更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSetPing:
                View pop = View.inflate(this, R.layout.item_set_popup, null);
                final PopupWindow popupWindow = new PopupWindow(pop, 800, ActionBar.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x77191970));
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                TextView mLike = (TextView) pop.findViewById(R.id.mLike);
                TextView mCommon = (TextView) pop.findViewById(R.id.mCommon);
                TextView mDisLike = (TextView) pop.findViewById(R.id.mDisLike);

                mLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SetActivity.this, "感谢使用", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
                mCommon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SetActivity.this, "感谢使用", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
                mDisLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SetActivity.this, "感谢使用", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });

                break;
            case R.id.mSetAbout:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }
    }
}
