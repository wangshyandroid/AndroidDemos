package com.wangshy.androiddemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.tangxiaolv.telegramgallery.GalleryActivity;

import java.util.List;

public class PngActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, PngActivity.class));
    }

    private List<String> photos;
    private BaseAdapter adapter;

    @SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.png_layout);
        Button btn = (Button) findViewById(R.id.btn);
        Button btn2 = (Button) findViewById(R.id.btn2);
        GridView gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return photos == null ? 0 : photos.size();
            }

            @Override
            public Object getItem(int position) {
                if (photos == null) {
                    return null;
                }
                return photos.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView view = new ImageView(PngActivity.this);
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 256));
                String path = (String) getItem(position);
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inPreferredConfig = Bitmap.Config.ARGB_4444;
                opts.inSampleSize = 4;
                Bitmap bitmap = BitmapFactory.decodeFile(path, opts);
                view.setImageBitmap(bitmap);
                return view;
            }
        });

        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryActivity.openActivity(PngActivity.this, false, 9, 12);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryActivity.openActivity(PngActivity.this, true, 9, 12);
            }
        });
    }

    @SuppressWarnings("all")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (12 == requestCode && resultCode == Activity.RESULT_OK) {
            photos = (List<String>) data.getSerializableExtra(GalleryActivity.PHOTOS);
            adapter.notifyDataSetChanged();
        }
    }
}
