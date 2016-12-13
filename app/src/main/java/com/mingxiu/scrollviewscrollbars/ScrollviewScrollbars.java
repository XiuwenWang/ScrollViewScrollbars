package com.mingxiu.scrollviewscrollbars;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.apkfuns.logutils.LogUtils;

import static android.R.attr.mode;

/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * 版权所有：个人
 * 作者：Created by a.wen.
 * 创建时间：2016/12/12
 * Email：13872829574@163.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */
public class ScrollviewScrollbars extends ScrollView {
    public ScrollviewScrollbars(Context context) {
        super(context);
        init(context);
    }

    public ScrollviewScrollbars(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollviewScrollbars(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }


    /**
     * 事件分发                 事件拦截                    事件消费
     * dispatchTouchEvent ---> onInterceptTouchEvent ---> onTouchEvent
     */

    /** 事件分发 @param ev 触摸事件对象 @return false 默认*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtils.d("事件分发 dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    /** 事件拦截 ev 触摸事件对象 @return false 默认 */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtils.d("事件拦截 onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    /** 事件消费 @return false 默认*/
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LogUtils.d("事件消费 onTouchEvent");
        final int actionMasked = ev.getActionMasked();
        if (actionMasked == MotionEvent.ACTION_DOWN) {
        }
        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
        }
        return super.onTouchEvent(ev);
    }

    /** 测量测量 模式 UNSPECIFIED，EXACTLY，AT_MOST */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {/**父容器没有对当前View有任何限制，当前View可以任意取尺寸*/
                //如果没有指定大小，就设置为默认大小
                break;
            }
            case MeasureSpec.AT_MOST: {/**当前的尺寸就是当前View应该取的尺寸*/
                //如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                break;
            }
            case MeasureSpec.EXACTLY: {/**当前尺寸是当前View能取的最大尺寸*/
                //如果是固定的大小，那就不要去改变它
                break;
            }
        }
        //setMeasuredDimension(width, height);
        try {
            //最大高度显示为屏幕内容高度的一半
            Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            DisplayMetrics d = new DisplayMetrics();
            display.getMetrics(d);
            //此处是关键，设置控件高度不能超过屏幕高度一半（d.heightPixels / 2）（在此替换成自己需要的高度）
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(d.heightPixels / 4, MeasureSpec.AT_MOST);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //重新计算控件高、宽
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /** 放置 布局*/
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    /**绘制View*/
    @Override
    protected void onDraw(Canvas canvas) {
        //调用父View的onDraw函数，因为View这个类帮我们实现了一些
        // 基本的而绘制功能，比如绘制背景颜色、背景图片等
        super.onDraw(canvas);
        int r = getMeasuredWidth() / 2;//也可以是getMeasuredHeight()/2,本例中我们已经将宽高设置相等了
        //圆心的横坐标为当前的View的左边起始位置+半径
        int centerX = getLeft() + r;
        //圆心的纵坐标为当前的View的顶部起始位置+半径
        int centerY = getTop() + r;

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        //开始绘制
        canvas.drawCircle(centerX, centerY, r, paint);

    }


}
