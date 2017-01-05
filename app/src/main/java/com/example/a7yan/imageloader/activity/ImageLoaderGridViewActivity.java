package com.example.a7yan.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.a7yan.imageloader.R;
import com.example.a7yan.imageloader.adapter.ImageLoaderGridViewAdapter;

/**
 * Created by 7Yan on 2017/1/5.
 */
public class ImageLoaderGridViewActivity extends Activity {
    private GridView gv;
    private ImageLoaderGridViewAdapter imageLoaderGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_grid_view);
        gv = (GridView) findViewById(R.id.gv_imageloader_gridview);
        imageLoaderGridViewAdapter = new ImageLoaderGridViewAdapter(this);
        gv.setAdapter(imageLoaderGridViewAdapter);
    }
}
