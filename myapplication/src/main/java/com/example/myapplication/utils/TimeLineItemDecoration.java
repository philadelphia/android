package com.example.myapplication.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by Tao.ZT.Zhang on 2017/8/16.
 */

public class TimeLineItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paint;
//    距离左边的距离
    private int mOffsetLeft;
    //距离上部的距离
    private float mOffsetTop;

    private static final String TAG = "TimeLineItemDecoration";
//    圆半径
    private float mRadius;

    public TimeLineItemDecoration() {

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        mRadius = 30;
        mOffsetLeft = 100;
    }

    //设置条目周边的偏移量
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.top = 20;
                mOffsetTop = outRect.top;
            }
        outRect.left = mOffsetLeft;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(child);
            float deiverTop = child.getTop() - mOffsetTop;
            if (index == 0){
                deiverTop = 0;
            }

            float dividerLeft = parent.getPaddingLeft();
            float dividerBottom = child.getBottom();
            float dividerRight = parent.getWidth() - parent.getPaddingRight();
            float centralX = dividerLeft  + mOffsetLeft / 2 ;
            float centralY = child.getY() + child.getHeight() /2;
//            float centralY = deiverTop + (dividerBottom - deiverTop) / 2;

            float upLineTopX = centralX;
            float upLineTopY= deiverTop;
            float upLineBottomX = centralX;
            float upLineBottomY = centralY - mRadius;
            if (index != 0){
                c.drawLine(upLineTopX, upLineTopY, upLineBottomX, upLineBottomY, paint);
            }

            paint.reset();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(ContextCompat.getColor(parent.getContext(),R.color.colorAccent));
            c.drawCircle(centralX, centralY, mRadius,paint);

            paint.reset();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            float downLineTopX = centralX;
            float downLineTopY= centralY + mRadius;
            float downLineBottomX = centralX;
            float downLineBottomY = dividerBottom ;
            c.drawLine(downLineTopX, downLineTopY, downLineBottomX, downLineBottomY, paint);

        }

    }

    /**
     * 该方法在item之上进行绘制，会遮挡ItemView。
     * @param c
     * @param parent
     * @param state
     */
//    @Override
//    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDrawOver(c, parent, state);
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View child = parent.getChildAt(i);
//            int width = parent.getChildAt(i).getWidth();
//            int heigth = parent.getChildAt(i).getHeight();
//            c.drawRect(child.getWidth() / 2,child.getTop() + child.getHeight() /2, child.getRight() ,child.getBottom(),paint );
//        }
//
//    }
}
