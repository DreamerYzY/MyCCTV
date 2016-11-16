package com.yangzhiyan.mycctv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.been.LiveBean;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by YZY on 2016/11/15.
 */

public class LiveListAdapter extends BaseAdapter {

    private Context context;
    private List<LiveBean.DataBean.ItemListBean> itemList;

    public LiveListAdapter(Context context, List<LiveBean.DataBean.ItemListBean> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        if (itemList.size()!=0){
         return itemList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.live_listview_item_layout,null
            );
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        LiveBean.DataBean.ItemListBean listBean = itemList.get(position);
        holder.live_item_text.setText(listBean.itemTitle);
        if (!listBean.itemImage.imgUrl1.isEmpty()){
            holder.live_item_pic.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(context).load(listBean.itemImage.imgUrl1).into(holder.live_item_pic);
        }
        String type = listBean.tagDesc;
        holder.live_item_state.setScaleType(ImageView.ScaleType.FIT_XY);
        switch (type){
            case "0":
                holder.live_item_state.setImageResource(R.mipmap.photolive_img_begin);
                break;
            case "1":
                holder.live_item_state.setImageResource(R.mipmap.photolive_img_live);
                break;
            case "2":
                holder.live_item_state.setImageResource(R.mipmap.photolive_img_sustain);
                break;
            case "3":
                holder.live_item_state.setImageResource(R.mipmap.photolive_img_lookback);
                break;
        }

        return convertView;
    }
    class ViewHolder{
        @ViewInject(R.id.live_item_pic)
        ImageView live_item_pic;
        @ViewInject(R.id.live_item_text)
        TextView live_item_text;
        @ViewInject(R.id.live_item_state)
        ImageView live_item_state;

        ViewHolder(View view){
            x.view().inject(this,view);
        }
    }
}
