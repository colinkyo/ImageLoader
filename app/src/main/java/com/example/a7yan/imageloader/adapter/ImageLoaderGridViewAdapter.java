package com.example.a7yan.imageloader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.a7yan.imageloader.Constants;
import com.example.a7yan.imageloader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by 7Yan on 2017/1/5.
 */

public class ImageLoaderGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options=new DisplayImageOptions.Builder()
            .showStubImage(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            //.displayer(new RoundedBitmapDisplayer(20))//不可以用于GridView
            .bitmapConfig(Bitmap.Config.RGB_565) //设置解码类型
            .build();
    public ImageLoaderGridViewAdapter(Context context){
        this.mContext=context;
        imageLoader = ImageLoader.getInstance();
    }
    @Override
    public int getCount() {
        return Constants.images.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_imageloader_gridview,null);
            viewHolder = new ViewHolder();
            viewHolder.gv_iv = (ImageView) convertView.findViewById(R.id.gv_iv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        imageLoader.displayImage(Constants.images[position],viewHolder.gv_iv,options);
        return convertView;
    }
    static class ViewHolder{
        ImageView gv_iv;
    }
}
