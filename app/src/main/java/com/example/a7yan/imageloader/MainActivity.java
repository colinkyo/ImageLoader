package com.example.a7yan.imageloader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.a7yan.imageloader.activity.ImageLoaderGridViewActivity;
import com.example.a7yan.imageloader.activity.ImageLoaderListViewActivity;
import com.example.a7yan.imageloader.activity.ImageLoaderViewPageActivity;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageLoader(this);
    }

    private void initImageLoader(Context context)
    {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY-2)  //线程优先级
                .denyCacheImageMultipleSizesInMemory()  //
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
    }

    public void onClick(View view){
        Intent intent=null;
        switch (view.getId()){
            case R.id.btn_lv:
                intent=new Intent(MainActivity.this,ImageLoaderListViewActivity.class);
                break;
            case R.id.btn_gv:
                intent=new Intent(MainActivity.this,ImageLoaderGridViewActivity.class);
                break;
            case R.id.btn_vp:
                intent=new Intent(MainActivity.this,ImageLoaderViewPageActivity.class);
                break;
        }
        startActivity(intent);
    }
}
