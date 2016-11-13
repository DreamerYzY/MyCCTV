package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.yangzhiyan.mycctv.CustomWidget.MyListview;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.TvPlusListAdapter;
import com.yangzhiyan.mycctv.been.TvPlus;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment implements View.OnClickListener {
    private ImageView tv_see;
    private ImageView tv_listen;
    private CardView tv_search;
    private ListView tv_list;
    private TvPlusListAdapter adapter;
    private List<TvPlus.DataBean.ColumnListBean> columnList;
    private String url = "http://m.news.cntv.cn/special/json/lm/list61/index.json";

    private View view;


    public TVFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null){
            return view;
        }
        view = inflater.inflate(R.layout.fragment_tv, container, false);
        tv_list = (ListView) view.findViewById(R.id.tv_list);
        tv_listen = (ImageView) view.findViewById(R.id.tv_listen);
        tv_see = (ImageView) view.findViewById(R.id.tv_see);
        tv_search = (CardView) view.findViewById(R.id.tv_search);

        tv_see.setOnClickListener(this);
        tv_listen.setOnClickListener(this);
        tv_search.setOnClickListener(this);

        columnList = new ArrayList<>();
        adapter = new TvPlusListAdapter(getContext(), columnList);
        tv_list.setAdapter(adapter);
        getData();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    private void getData() {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        TvPlus tvPlus = gson.fromJson(result, TvPlus.class);
                        columnList.addAll(tvPlus.data.columnList);
                        adapter.notifyDataSetChanged();
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
}
