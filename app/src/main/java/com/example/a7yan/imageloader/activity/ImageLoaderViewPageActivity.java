package com.example.a7yan.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.a7yan.imageloader.R;
import com.example.a7yan.imageloader.adapter.ImageLoaderViewPageAdapter;

public class ImageLoaderViewPageActivity extends Activity {
    private ViewPager viewPager;
    private ImageLoaderViewPageAdapter imageLoaderViewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_view_page);
        viewPager = (ViewPager) findViewById(R.id.vp_imageloader_viewpage);

        imageLoaderViewPageAdapter = new ImageLoaderViewPageAdapter(this);

        viewPager.setAdapter(imageLoaderViewPageAdapter);

    }
}
