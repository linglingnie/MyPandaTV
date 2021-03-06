package com.pandatv.user.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeActivity extends BaseActivity {


    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.mConfirm)
    TextView mConfirm;
    @BindView(R.id.edit_nickmane)
    EditText editNickname;
    private String uid;
    private String mName;
    private String name;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        uid = getIntent().getStringExtra("uid");
        mName = getIntent().getStringExtra("mName");
        // name = getIntent().getStringExtra("name");
        if (uid != null) {
            editNickname.setText(uid);
        } else if (mName != null) {
            editNickname.setText(mName);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.personal_change_nickname;
    }


    @OnClick({R.id.mBack, R.id.mConfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                startActivity(new Intent(this, InfoActivity.class).putExtra("uid",uid));
                finish();
                break;
            case R.id.mConfirm:
                final String trim = editNickname.getText().toString().trim();
                if (editNickname.getText().toString().trim().equals(uid)) {

                    Toast.makeText(this, "没有修改", Toast.LENGTH_SHORT).show();
                } else {
                    View pop = View.inflate(this, R.layout.item_changename, null);
                    PopupWindow popupWindow = new PopupWindow(pop, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, true);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(0x55000000));
                    popupWindow.showAtLocation(pop, Gravity.CENTER, 0, 0);
                    TextView can = (TextView) pop.findViewById(R.id.cancel);
                    can.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(ChangeActivity.this, InfoActivity.class).putExtra("name", trim));
                            finish();
                        }
                    });
                }
                //跳出一个您的昵称。。。 我知道啦 回到info
                break;
        }
    }
}
