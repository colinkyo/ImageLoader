package com.example.a7yan.imageloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a7yan.imageloader.R;
import com.example.a7yan.imageloader.adapter.ImageLoaderListViewAdapter;

public class ImageLoaderListViewActivity extends Activity {
    private ListView lv;
    private ImageLoaderListViewAdapter imageLoaderListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_list_view);
        //getWindow().setTitle("ImageLoader图片到ListView");
        lv = (ListView) findViewById(R.id.lv_imageloader_listview);
        imageLoaderListViewAdapter =  new ImageLoaderListViewAdapter(this);
        lv.setAdapter(imageLoaderListViewAdapter);
    }
}
