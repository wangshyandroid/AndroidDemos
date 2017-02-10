package com.wangshy.androiddemo.animation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wangshy.androiddemo.R;

import static android.R.id.button1;
import static android.R.id.button2;
import static android.R.id.button3;

public class AnimationActivity extends AppCompatActivity {
    public static void AnimationActivity(Context context, int p) {
        context.startActivity(new Intent(context, AnimationActivity.class).putExtra("JAVA", p));
    }

    private TextView tv_show_anim, tv_show_anim1, tv_show_anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        tv_show_anim = (TextView) findViewById(R.id.Animation_text);
        tv_show_anim1 = (TextView) findViewById(R.id.Animation_text1);
        tv_show_anim2 = (TextView) findViewById(R.id.Animation_text2);
        tv_show_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnimationActivity.this, "-----------", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OnClick(View view) {
        switch (getIntent().getIntExtra("JAVA", 0)) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                execAnimator();
                break;
            case 3:
                setScaleX();
                break;
            case 4:
                setTranslationY();
                break;
            case 5:
                setRotationX();
                break;
            case 6:
                BackgroundColor();
                tv_show_anim.setTextColor(0XFF000000);
                break;
            case 7:
                tv_show_anim1.setVisibility(View.VISIBLE);
                tv_show_anim2.setVisibility(View.VISIBLE);
                tv_show_anim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animatorSet.cancel();
                        playTogether(0);
                    }
                });
                tv_show_anim1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animatorSet.cancel();
                        playTogether(1);
                    }
                });
                tv_show_anim2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animatorSet.cancel();
                        playTogether1();
                    }
                });
                tv_show_anim.setText("顺序动画");
                tv_show_anim1.setText("一起动画");
                tv_show_anim2.setText("循环动画");
                playTogether1();
                break;
        }
    }

    AnimatorSet animatorSet;

    private void playTogether1() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(tv_show_anim, "translationY", 60, 400, 400, 60);
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tv_show_anim1, "translationY", 60, -400, -400, 60);
        objectAnimator2.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(tv_show_anim2, "translationY", 60, 400, 400, 60);
        objectAnimator3.setRepeatCount(ValueAnimator.INFINITE);
        animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    private void playTogether(int a) {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(tv_show_anim, "translationY", 60, 400);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tv_show_anim1, "translationY", 0, -400);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(tv_show_anim2, "translationY", 60, 400);

        animatorSet = new AnimatorSet();
        if (a == 0)
            animatorSet.playSequentially(objectAnimator1, objectAnimator2, objectAnimator3);
        else
            animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    private void BackgroundColor() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(tv_show_anim, "BackgroundColor", 0xffffffff, 0xffffff00, 0xff00ffff);
        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatCount(5);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.start();
    }

    private void setRotationX() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv_show_anim, "rotationX", 0, 180, 180, 0, 0, 180);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    private void setTranslationY() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv_show_anim, "translationY", 0, 300, 300, 100, 100, 300, 300, 200, 200, 300);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    private void setScaleX() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv_show_anim, "scaleX", 1, 2, 2, 0, 0, 1);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    public void execAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv_show_anim, "alpha", 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
