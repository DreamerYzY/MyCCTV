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
import com.yangzhiyan.mycctv.been.ClasstopicFlagBean;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;


/**
 * Created by YZY on 2016/11/18.
 */

public class ClasstopicListviewAdapter extends BaseAdapter {
    private Context context;
    private List<ClasstopicFlagBean.DataBean.TopicListBean.ListBean> topicList;

    public ClasstopicListviewAdapter(Context context, List<ClasstopicFlagBean.DataBean.TopicListBean.ListBean> topicList) {
        this.context = context;
        this.topicList = topicList;
    }

    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public Object getItem(int position) {
        return topicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.classtopic_item_layout,null
            );
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ClasstopicFlagBean.DataBean.TopicListBean.ListBean listBean = topicList.get(position);
        if (!listBean.itemImage.imgUrl1.isEmpty()){
            Picasso.with(context).load(listBean.itemImage.imgUrl1).into(holder.classtopic_item_pic);
        }
        holder.classtopic_item_title.setText(listBean.itemTitle);
        return convertView;
    }

    class ViewHolder{
        @ViewInject(R.id.classtopic_item_pic)
        ImageView classtopic_item_pic;
        @ViewInject(R.id.classtopic_item_title)
        TextView classtopic_item_title;

        ViewHolder(View view){
            x.view().inject(this,view);
        }
    }
}
