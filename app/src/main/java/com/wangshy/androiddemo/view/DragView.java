package com.wangshy.androiddemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangshy on 17/2/13.
 */

public class DragView extends View {

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int lastX = 0; //横坐标
    private int lastY = 0; //纵坐标
    //移动方法一

    //    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
////        int x = (int) event.getX();
////        int y = (int) event.getY();
//
//        int rawX = (int) event.getRawX();
//        int rawY = (int) event.getRawY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = rawX;
//                lastY = rawY;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = rawX - lastX;
//                int offsetY = rawY - lastY;
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                lastX = rawX;
//                lastY = rawY;
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        return true;
//    }
    //移动方法二

    //    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = x - lastX;
//                int offsetY = y - lastY;
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }
    //移动方法三
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = x - lastX;
//                int offsetY = y - lastY;
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
////            layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }
    //移动方法四

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int top = 0;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;

                setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
