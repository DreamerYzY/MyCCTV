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
import com.yangzhiyan.mycctv.been.Timeline;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by YZY on 2016/11/11.
 */

public class TimelineListAdapter extends BaseAdapter {
    private Context context;
    private List<Timeline.ItemListBean> itemList;

    public TimelineListAdapter(Context context, List<Timeline.ItemListBean> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
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
        ViewHolder holder =null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.timeline_list_item_layout
            ,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Timeline.ItemListBean listBean = itemList.get(position);
        holder.timeline_text.setText(listBean.itemTitle);
        String imgurl = listBean.itemImage.imgUrl1;
        if (!imgurl.equals("")){
            holder.timeline_pic.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(context).load(imgurl).into(holder.timeline_pic);

        }
        long currenttime = System.currentTimeMillis();
        long newstime = listBean.pubDate;
        long time = currenttime-newstime;
        long min = time/60000;
        if (min<60){
            holder.timeline_time.setText((int)min+"分钟前");
        }else if (min/60<=24){
            holder.timeline_time.setText((int)(min/60)+"小时前");
        }else {
            holder.timeline_time.setText("1天前");
        }

        return convertView;
    }

    class ViewHolder{
        @ViewInject(R.id.timeline_time)
        TextView timeline_time;

        @ViewInject(R.id.timeline_pic)
        ImageView timeline_pic;

        @ViewInject(R.id.timeline_text)
        TextView timeline_text;

        ViewHolder(View view){
            x.view().inject(this,view);
        }

    }
}
