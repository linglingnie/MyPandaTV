package com.pandatv.main;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.widget.ImageView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;

public class WelcomeActivity extends BaseActivity implements Animator.AnimatorListener {

    @BindView(R.id.mWelcomeImg)
    ImageView mWelcomeImg;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        initAnim();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    private void initAnim() {
        ObjectAnimator oa = ObjectAnimator.ofFloat(mWelcomeImg, "alpha", 1f);
        oa.setDuration(2000);
        oa.start();
        oa.addListener(this);
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
