package com.wangshy.androiddemo.activity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangshy.androiddemo.R;

public class SecondActivity extends AppCompatActivity {
    private AlphaAnimation alphaAnimation;

    public static void SecondActivity(Context context) {
        context.startActivity(new Intent(context, SecondActivity.class));
    }

    private TextView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        img = (TextView) findViewById(R.id.img);
        final TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(false);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img.startAnimation(translateAnimation);
            }
        });
    }

    public void onClick(View view) {
//        execAnimator();
//        alphaAnimation.start();
    }

    //    public void execAnimator() {
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img, "alpha", 0, 1, 1, 0, 0, 1, 1, 0);
//        objectAnimator.setDuration(3000);
//        objectAnimator.start();
//    }
//    public void execAnimator() {
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img, "scaleX", 1, 3);
//        objectAnimator.setDuration(200);
//        objectAnimator.start();
//    }


    public void execAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(img, "BackgroundColor", 0xffffffff, 0xffffff00, 0xff00ffff);
        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.start();
    }
}
