package com.mingxiu.scrollviewscrollbars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.apkfuns.logutils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtils.d("事件消费 onTouchEvent");
        return super.onTouchEvent(event);
    }

    /**
     * 事件分发
     *
     * @param ev 触摸事件对象
     * @return false 默认
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtils.d("事件分发 dispatchTouchEvent ");
        return super.dispatchTouchEvent(ev);
    }
}
