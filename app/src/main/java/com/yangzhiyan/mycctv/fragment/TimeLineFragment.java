package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.TimelineListAdapter;
import com.yangzhiyan.mycctv.been.Timeline;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLineFragment extends Fragment {
    private PullToRefreshListView timeline_pulllistview;
    private TimelineListAdapter adapter;
    private TextView timeline_data;
    private String url = "http://hot.news.cntv.cn/index.php?controller=list&action=scrollList&n=20";
    private int page = 1;
    private Timeline timeline;
    private List<Timeline.ItemListBean> itemList;

    private View view;

    public TimeLineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null){
            return view;
        }
        view = inflater.inflate(R.layout.fragment_time_line, container, false);
        timeline_pulllistview = (PullToRefreshListView) view.findViewById(R.id.timeline_pulllistview);
        View headview = getActivity().getLayoutInflater().inflate(
                R.layout.timeline_headerview_textview,null
        );
        timeline_data = (TextView) headview.findViewById(R.id.timeline_data);
        timeline_pulllistview.getRefreshableView().addHeaderView(headview);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String time = sd.format(new Date(System.currentTimeMillis()));
        timeline_data.setText(time);

        timeline_pulllistview.setMode(PullToRefreshBase.Mode.BOTH);
        timeline_pulllistview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                itemList.clear();
                page = 1;
                getData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                getData();
            }
        });

        getData();
        return view;
    }

    private void getData(){
        RequestParams requestParams = new RequestParams(url);
        requestParams.addQueryStringParameter("p",page+"");
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        itemList = new ArrayList<>();
                        Gson gson = new Gson();
                        timeline = gson.fromJson(result,Timeline.class);
                        itemList.addAll(timeline.itemList);
                        adapter = new TimelineListAdapter(getContext(),itemList);
                        timeline_pulllistview.setAdapter(adapter);
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
        if (timeline_pulllistview.isRefreshing()){
            timeline_pulllistview.onRefreshComplete();
        }
    }

}
