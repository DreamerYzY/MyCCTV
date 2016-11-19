package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.ItemItFlagRecyclerviewAdapter;
import com.yangzhiyan.mycctv.been.ItemItFlagBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class ItemItFlagActivity extends AppCompatActivity {

    @ViewInject(R.id.itflag_pic)
    ImageView itflag_pic;
    @ViewInject(R.id.itflag_title)
    TextView itflag_text;
    @ViewInject(R.id.itflag_recyclerView)
    RecyclerView itflag_recycleView;

    private String url;

    private ItemItFlagBean itemItFlagBean;
    private ItemItFlagRecyclerviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_it_flag);
        x.view().inject(this);

        Intent intent = getIntent();
        url = intent.getStringExtra("detailUrl");

        getData();


    }
    @Event(value = {R.id.item_return,R.id.item_share,R.id.itflag_play},type = View.OnClickListener.class)
    private void onCLick(View v){
        switch (v.getId()){
            case R.id.item_return:
                ItemItFlagActivity.this.finish();
                break;
            case R.id.item_share:
                break;
            case R.id.itflag_play:
                break;
        }
    }

    private void getData(){
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        itemItFlagBean = gson.fromJson(result,ItemItFlagBean.class);
                        bindData(itemItFlagBean);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                        ex.printStackTrace();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                        cex.printStackTrace();
                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    private void bindData(ItemItFlagBean itemItFlagBean1) {
        itemItFlagBean = itemItFlagBean1;
        itflag_text.setText(itemItFlagBean.data.liveList.get(0).liveTitle);
        String imgurl = itemItFlagBean.data.liveList.get(0).liveImage;
        if (!imgurl.isEmpty()){
            Picasso.with(this).load(imgurl).into(itflag_pic);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false);
        adapter = new ItemItFlagRecyclerviewAdapter(this,itemItFlagBean.msgList);
        itflag_recycleView.setLayoutManager(layoutManager);
        itflag_recycleView.setAdapter(adapter);
    }
}
