package com.pandatv.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.VideoView;

/**
 * Created by Administrator on 2017/8/25.
 */
//自定义一个videoview控件 实现占满全屏

public class fullScreen extends VideoView {
    GestureDetector mGesture;

    public fullScreen(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
// TODO Auto-generated constructor stub
    }

    public fullScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
// TODO Auto-generated constructor stub
    }

    public fullScreen(Context context) {
        super(context);
// TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//这里重写onMeasure的方法
// TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(0, widthMeasureSpec);//得到默认的大小（0，宽度测量规范）
        int height = getDefaultSize(0, heightMeasureSpec);//得到默认的大小（0，高度度测量规范）
        setMeasuredDimension(width, height); //设置测量尺寸,将高和宽放进去
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mGesture != null){
            mGesture.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                @Override
                //点击
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return true;
                }

                @Override
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return false;
                }

                @Override
                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }
            });
        }

        return super.onTouchEvent(ev);
    }


}

