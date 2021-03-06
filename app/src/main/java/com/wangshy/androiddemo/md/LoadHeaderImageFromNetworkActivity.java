package com.wangshy.androiddemo.md;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangshy.androiddemo.R;
import com.wangshy.androiddemo.adapter.MyPagerAdapter;
import com.wangshy.androiddemo.fragment.MainFragment;

import java.util.ArrayList;

import com.wangshy.androiddemo.md.listener.LoadHeaderImagesListener;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 17/2/9 13:32
 */
public class LoadHeaderImageFromNetworkActivity extends AppCompatActivity {
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mColorArray;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"Android", "Web", "iOS", "Other"};
    private ViewPager mViewPager;

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, LoadHeaderImageFromNetworkActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.loadheaderimagefromnetwork_layout);
        initFragments();
        initViewPager();
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTitle("Demo")
                .setBackEnable(true)
                .setContentScrimColorArray(mColorArray)
                .setLoadHeaderImagesListener(new LoadHeaderImagesListener() {
                    @Override
                    public void loadHeaderImages(ImageView imageView, TabLayout.Tab tab) {
                        switch (tab.getPosition()) {
                            case 0:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_android.jpg");
                                break;
                            case 1:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_js.jpg");
                                break;
                            case 2:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_ios.jpg");
                                break;
                            case 3:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_other.jpg");
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setupWithViewPager(mViewPager);
    }

    private void loadImages(ImageView imageView, String url) {
        Glide.with(LoadHeaderImageFromNetworkActivity.this).load(url).into(imageView);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(MainFragment.getInstance(title));
        }
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }
}
