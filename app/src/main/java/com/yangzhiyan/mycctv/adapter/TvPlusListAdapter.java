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
import com.yangzhiyan.mycctv.been.TvPlus;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;


/**
 * Created by YZY on 2016/11/10.
 */

public class TvPlusListAdapter extends BaseAdapter {
    private Context context;
    private List<TvPlus.DataBean.ColumnListBean> columnList;

    public TvPlusListAdapter(Context context, List<TvPlus.DataBean.ColumnListBean> columnList) {
        this.context = context;
        this.columnList = columnList;
    }

    @Override
    public int getCount() {
        if (columnList.size()!=0){

            return columnList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return columnList.get(position);
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
                    R.layout.tv_plus_list_item,null
            );
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_list_text.setText(columnList.get(position).columnName);
        Picasso.with(context).load(columnList.get(position).columnImage).into(holder.tv_list_pic);
        return convertView;
    }

    class ViewHolder{
        @ViewInject(R.id.tv_list_pic)
        ImageView tv_list_pic;
        @ViewInject(R.id.tv_list_text)
        TextView tv_list_text;

        public ViewHolder(View view){
            x.view().inject(this,view);
        }
    }
}
