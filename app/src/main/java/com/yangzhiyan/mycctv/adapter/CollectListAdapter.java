package com.yangzhiyan.mycctv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangzhiyan.mycctv.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;
import java.util.Map;

/**
 * Created by YZY on 2016/11/23.
 */

public class CollectListAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,String>> datalist;

    public CollectListAdapter(Context context, List<Map<String, String>> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
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
                    R.layout.collect_list_item_layout,null
            );
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Map<String,String> map = datalist.get(position);
        holder.collect_item_title.setText(map.get("itemTitle"));
        switch (map.get("itemType")){
            case "album_flag":
                holder.collect_item_pic.setImageResource(R.mipmap.hotlist_photo);
                break;
            default:
                holder.collect_item_pic.setImageResource(R.mipmap.hotlist_text);
                break;
        }
        return convertView;
    }

    class ViewHolder{
        @ViewInject(R.id.collect_item_pic)
        ImageView collect_item_pic;
        @ViewInject(R.id.collect_item_title)
        TextView collect_item_title;

        ViewHolder(View view){
            x.view().inject(this,view);
        }
    }
}
