package com.yangzhiyan.mycctv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.been.Discover;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by YZY on 2016/11/12.
 */

public class DiscoverRecycleviewAdapter extends RecyclerView.
        Adapter<DiscoverRecycleviewAdapter.MyRecycleViewHolder> {
    private Context context;
    private List<Discover.DataBean.ItemListBean> itemList;

    public DiscoverRecycleviewAdapter(Context context, List<Discover.DataBean.ItemListBean> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public MyRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.discover_recycleview_item_layout,null);
        MyRecycleViewHolder myRecycleViewHolder = new MyRecycleViewHolder(view);
        return myRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecycleViewHolder holder, int position) {
        Discover.DataBean.ItemListBean listBean = itemList.get(position);
        if (!listBean.itemImage.imgUrl1.equals("")){

            Picasso.with(context).load(listBean.itemImage.imgUrl1).into(holder.discover_recycle_pic);
            holder.discover_recycle_pic.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        holder.discover_recycle_text.setText(listBean.itemTitle);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyRecycleViewHolder extends RecyclerView.ViewHolder{
        @ViewInject(R.id.discover_recycle_pic)
        ImageView discover_recycle_pic;

        @ViewInject(R.id.discover_recycle_text)
        TextView discover_recycle_text;

        public MyRecycleViewHolder(View itemView) {
            super(itemView);
            x.view().inject(this,itemView);
        }
    }
}
