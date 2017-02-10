package com.wangshy.androiddemo;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wangshy.androiddemo.adapter.MainAdapter;
import com.wangshy.androiddemo.animation.AnimationActivity;

public class SecondActivity extends AppCompatActivity {
    private RecyclerView mreycler;

    public static void SecondActivity(Context context) {
        context.startActivity(new Intent(context, SecondActivity.class));
    }

    private TextView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mreycler = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mreycler.setLayoutManager(linearLayoutManager);
        mreycler.setAdapter(new MainAdapter(Content.getList(Content.type.ANIMATION))
                .setOn(new MainAdapter.IRecyclerView() {
                    @Override
                    public void onCheck(int position) {
                        AnimationActivity.AnimationActivity(SecondActivity.this, position);
                    }
                }));
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
