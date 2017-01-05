package com.example.a7yan.imageloader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ImageView;

import com.example.a7yan.imageloader.Constants;
import com.example.a7yan.imageloader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by 7Yan on 2017/1/5.
 */

public class ImageLoaderViewPageAdapter extends PagerAdapter{
    private Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options=new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.mipmap.ic_launcher)   //设置图片url为空货错误时显示的图片
            .showImageOnFail(R.mipmap.ic_launcher) //图片加载或者解码出错的图片
            .resetViewBeforeLoading(true)//设置图片加载前是否重置或者复位
            .cacheOnDisc(true)//设置是否缓存SD卡
            .imageScaleType(ImageScaleType.EXACTLY)//设置图片以如何的编码方式显示
            .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型
            .displayer(new FadeInBitmapDisplayer(300))//设置图片渐变显示
            .build();

    public ImageLoaderViewPageAdapter(Context context)
    {
        this.mContext=context;
        imageLoader = ImageLoader.getInstance();
    }
    @Override
    public int getCount() {
        return Constants.images.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View view = View.inflate(mContext, R.layout.item_imageloader_viewpage,null);
        ImageView iv=(ImageView) view.findViewById(R.id.vp_iv);
        imageLoader.displayImage(Constants.images[position],iv,options);
        ((ViewPager)container).addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
