package com.example.a7yan.imageloader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a7yan.imageloader.Constants;
import com.example.a7yan.imageloader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by 7Yan on 2017/1/5.
 */

public class ImageLoaderListViewAdapter extends BaseAdapter {
    private final ImageLoader imageLoader;
    private Context mContext;
    private DisplayImageOptions options=new DisplayImageOptions.Builder()
            .showStubImage(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(new RoundedBitmapDisplayer(20))
            .build();
    public  ImageLoaderListViewAdapter(Context context){
        this.mContext=context;
        //初始化图片插件
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
            convertView = View.inflate(mContext, R.layout.item_imageloader_listview,null);
            viewHolder = new ViewHolder();
            viewHolder.lv_iv = (ImageView) convertView.findViewById(R.id.lv_iv);
            viewHolder.lv_tv = (TextView) convertView.findViewById(R.id.lv_tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.lv_tv.setText("Item"+position);
        imageLoader.displayImage(Constants.images[position],viewHolder.lv_iv,options);
        return convertView;
    }
    static class ViewHolder{
        ImageView lv_iv;
        TextView lv_tv;
    }
}
