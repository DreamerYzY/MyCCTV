package com.yangzhiyan.mycctv.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.activity.DiscoverLinkActivity;
import com.yangzhiyan.mycctv.adapter.DiscoverRecycleviewAdapter;
import com.yangzhiyan.mycctv.been.Discover;
import com.yangzhiyan.mycctv.interfaces.MyItemListener;
import com.yangzhiyan.mycctv.utils.SpaceItemDecoration;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment implements MyItemListener {

    @ViewInject(R.id.discover_pic)
    ImageView discover_pic;
    @ViewInject(R.id.discover_text)
    TextView discover_text;
    @ViewInject(R.id.discover_recycleview)
    RecyclerView discover_recycleview;

    private String dataurl = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandData" +
            "InfoNew&handdata_id=TDAT1451469760457759&n1=1&n2=10&toutuNum=1";
    private Discover discover;
    private DiscoverRecycleviewAdapter adapter;
    private View view;


    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null){
            return view;
        }
        view =inflater.inflate(R.layout.fragment_discover, container, false);
        x.view().inject(this,view);
        int space = 80;
        discover_recycleview.addItemDecoration(new SpaceItemDecoration(space));
        getData();
        discover_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), DiscoverLinkActivity.class);
                intent.putExtra("detailUrl",discover.data.bigImg.get(0).detailUrl);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getData(){
        RequestParams requestParams = new RequestParams(dataurl);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        discover = gson.fromJson(result,Discover.class);
                        if (!discover.data.bigImg.get(0).itemImage.equals("")){
                            discover_pic.setScaleType(ImageView.ScaleType.FIT_XY);
                            Picasso.with(getContext()).load(discover.data.bigImg.get(0).itemImage).
                                    into(discover_pic);
                        }
                        discover_text.setText(discover.data.bigImg.get(0).itemTitle);
                        GridLayoutManager layoutManager = new GridLayoutManager(
                                getContext(),1, LinearLayoutManager.HORIZONTAL,false
                        );
                        discover_recycleview.setLayoutManager(layoutManager);
                        adapter = new DiscoverRecycleviewAdapter(getContext(),discover.data.itemList);
                        discover_recycleview.setAdapter(adapter);
                        adapter.setOnItemClickListener(DiscoverFragment.this);

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent();
        intent.setClass(getContext(),DiscoverLinkActivity.class);
        intent.putExtra("detailUrl",discover.data.itemList.get(position).detailUrl);
        startActivity(intent);
    }
}
