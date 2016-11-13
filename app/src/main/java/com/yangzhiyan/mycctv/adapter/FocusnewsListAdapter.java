package com.yangzhiyan.mycctv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.been.Focusnews;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by YZY on 2016/11/10.
 */

public class FocusnewsListAdapter extends BaseAdapter {
    private Context context;
    private List<Focusnews.DataBean.ItemListBean> itemList;

    public FocusnewsListAdapter(Context context, List<Focusnews.DataBean.ItemListBean> itemList) {
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
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        String type = itemList.get(position).itemType;
        int result = 8;
        switch (type){
            case "article_flag":
                result = 0;
                break;
            case "classtopic_flag":case "it_flag":
                result = 1;
                break;
            case "album_flag":
                result = 2;
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Focusnews.DataBean.ItemListBean itemListBean = itemList.get(position);
        String type = itemListBean.itemType;
        String imgurl;

        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;

        if (convertView == null){
            switch (type){
                case "article_flag":
                    convertView = LayoutInflater.from(context).inflate(
                            R.layout.focusnews_list_item_article_flag_layout,null
                    );
                    holder1 = new ViewHolder1(convertView);
                    convertView.setTag(holder1);
                    break;
                case "classtopic_flag":case "it_flag":
                    convertView = LayoutInflater.from(context).inflate(
                            R.layout.focusnews_list_item_classtopic_flag_layout,null
                    );
                    holder2 = new ViewHolder2(convertView);
                    convertView.setTag(holder2);
                    break;
                case "album_flag":
                    convertView = LayoutInflater.from(context).inflate(
                            R.layout.focusnews_list_item_album_flag_layout,null
                    );
                    holder3 = new ViewHolder3(convertView);
                    convertView.setTag(holder3);
                    break;
                default:
                    break;
            }
        }else {
            switch (type){
                case "article_flag":
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case "classtopic_flag":case "it_flag":
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
                case "album_flag":
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
                default:
                    break;
            }
        }
        switch (type){
            case "article_flag":
                holder1.article_text.setText(itemListBean.itemTitle);
                imgurl = itemListBean.itemImage.imgUrl1;
                holder1.article_pic.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(context).load(imgurl).into(holder1.article_pic);
                break;
            case "classtopic_flag":case "it_flag":
                if (type.equals("classtopic_flag")){
                    holder2.pic_type.setImageResource(R.mipmap.zhuan_ti);
                }else {
                    holder2.pic_type.setImageResource(R.mipmap.live);
                }
                holder2.classtopic_title.setText(itemListBean.itemTitle);
                imgurl = itemListBean.itemImage.imgUrl1;
                holder2.classtopic_pic.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(context).load(imgurl).into(holder2.classtopic_pic);
                break;
            case "album_flag":
                holder3.album_text.setText(itemListBean.itemTitle);
                imgurl = itemListBean.itemImage.imgUrl1;
                holder3.album_pic1.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(context).load(imgurl).into(holder3.album_pic1);
                String imgurl2 = itemListBean.itemImage.imgUrl2;
                holder3.album_pic2.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(context).load(imgurl2).into(holder3.album_pic2);
                String imgurl3 = itemListBean.itemImage.imgUrl3;
                holder3.album_pic3.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(context).load(imgurl3).into(holder3.album_pic3);
                break;
            default:
                break;
        }

        return convertView;
    }

    private class ViewHolder1{
        @ViewInject(R.id.article_pic)
        ImageView article_pic;
        @ViewInject(R.id.article_title)
        TextView article_text;
        ViewHolder1(View view){
            x.view().inject(this,view);
        }
    }

    private class ViewHolder2{
        @ViewInject(R.id.classtopic_pic)
        ImageView classtopic_pic;

        @ViewInject(R.id.classtopic_title)
        TextView classtopic_title;

        @ViewInject(R.id.pic_type)
        ImageView pic_type;

        ViewHolder2(View view){
            x.view().inject(this,view);
        }
    }

    private class ViewHolder3{
        @ViewInject(R.id.album_text)
        TextView album_text;
        @ViewInject(R.id.album_pic1)
        ImageView album_pic1;
        @ViewInject(R.id.album_pic2)
        ImageView album_pic2;
        @ViewInject(R.id.album_pic3)
        ImageView album_pic3;

        ViewHolder3(View view){
            x.view().inject(this,view);
        }
    }
}
