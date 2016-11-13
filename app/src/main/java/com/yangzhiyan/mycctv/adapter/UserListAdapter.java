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

/**
 * Created by YZY on 2016/11/13.
 */

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private String[] texts;
    private int[] icons;
    private boolean flag;
    private boolean flag2;
    private ViewHolder holder;

    public UserListAdapter(Context context, String[] texts, int[] icons) {
        this.context = context;
        this.texts = texts;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public Object getItem(int position) {
        return texts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.user_list_item_layout,null
            );
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.user_item_pic.setImageResource(icons[position]);
        holder.user_item_text.setText(texts[position]);
        holder.user_turn.setImageResource(R.mipmap.setting_btn_off);

        return convertView;
    }

    class ViewHolder{
        @ViewInject(R.id.user_item_pic)
        ImageView user_item_pic;

        @ViewInject(R.id.user_item_text)
        TextView user_item_text;

        @ViewInject(R.id.user_turn)
        ImageView user_turn;

        ViewHolder(View view){
            x.view().inject(this,view);
        }
    }
}
