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
import com.yangzhiyan.mycctv.been.ItemItFlagBean;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by YZY on 2016/11/18.
 */

public class ItemItFlagRecyclerviewAdapter extends RecyclerView.
        Adapter<ItemItFlagRecyclerviewAdapter.MyRecyclerViewHolder> {

    private Context context;
    private List<ItemItFlagBean.MsgListBean> msgListBeen;

    public ItemItFlagRecyclerviewAdapter(Context context, List<ItemItFlagBean.MsgListBean> msgListBeen) {
        this.context = context;
        this.msgListBeen = msgListBeen;
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_it_flag_recyclerview_item_layout,parent,false
        );
        MyRecyclerViewHolder myRecyclerViewHolder = new MyRecyclerViewHolder(view);

        return myRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        ItemItFlagBean.MsgListBean msgListBean1 = msgListBeen.get(position);
        holder.it_msg.setText(msgListBean1.msg);
        if (!msgListBean1.msgImage.isEmpty()){
            holder.it_pic.setVisibility(View.VISIBLE);
            holder.it_pic.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(context).load(msgListBean1.msgImage).into(holder.it_pic);
        }else {
            holder.it_pic.setVisibility(View.GONE);
        }
        long currenttime = System.currentTimeMillis();
        long newstime = msgListBean1.msgTime;
        long time = currenttime-newstime;
        long min = time/60000;
        if (min<60){
            if (min<1){
                holder.it_time.setText("刚刚");
            }else {
                holder.it_time.setText((int) min + "分钟前");
            }
        }else if (min/60<=24){
            holder.it_time.setText((int)(min/60)+"小时前");
        }else {
            holder.it_time.setText("1天前");
        }
    }

    @Override
    public int getItemCount() {
        return msgListBeen.size();
    }

    class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        @ViewInject(R.id.it_time)
        TextView it_time;
        @ViewInject(R.id.it_msg)
        TextView it_msg;
        @ViewInject(R.id.it_pic)
        ImageView it_pic;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            x.view().inject(this,itemView);
        }
    }
}
