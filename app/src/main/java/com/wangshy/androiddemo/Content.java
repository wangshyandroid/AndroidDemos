package com.wangshy.androiddemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshy on 17/2/8. Animation
 */

public class Content {

    public enum type {
        ANIMATION,
        ACTIVITY,
        XFERMODE
    }

    public static List<String> getList(type s) {
        List<String> mList = new ArrayList<>();
        switch (s) {
            case ACTIVITY:
                mList.add("基本动画");
                mList.add("Xfermode学习");
                mList.add("广播学习");
                mList.add("数据持久化");
                mList.add("自定义View练习");
                mList.add("MD风格");
                mList.add("图片选择");
                break;
            case XFERMODE:
                break;
            case ANIMATION:
                mList.add("ScaleAnimation:渐变缩放尺寸效果");
                mList.add("RotateAnimation view旋转效果");
                mList.add("属性动画 setAlpha()");
                mList.add("属性动画 setScaleX()");
                mList.add("属性动画 setTranslationY()");
                mList.add("属性动画 setRotationX()");
                mList.add("属性动画 BackgroundColor()");
                mList.add("属性动画 组合动画");
                break;
        }
        return mList;
    }
}
