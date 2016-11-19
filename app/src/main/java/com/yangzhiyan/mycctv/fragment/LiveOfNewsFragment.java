package com.yangzhiyan.mycctv.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.activity.ItemItFlagActivity;
import com.yangzhiyan.mycctv.adapter.LiveListAdapter;
import com.yangzhiyan.mycctv.been.LiveBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveOfNewsFragment extends Fragment {
    @ViewInject(R.id.live_pulllistview)
    PullToRefreshListView live_pulllistview;

    private View view;

    private String url = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandData" +
            "InfoNew&handdata_id=TDAT1471405480888405&n1=1&n2=20&toutuNum=1";
    private String newurl = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandData" +
            "ListInfoNew&handdata_id=TDAT1471405480888405&toutuNum=1";

    private int page = 1;

    private LiveBean liveBean;
    private List<LiveBean.DataBean.ItemListBean> itemList;
    private List<LiveBean.DataBean.ItemListBean> newitemList;

    private LiveListAdapter adapter;

    public LiveOfNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view!=null){
            return view;
        }
        view = inflater.inflate(R.layout.fragment_live_of_news, container, false);
        x.view().inject(this,view);

        live_pulllistview.getRefreshableView().setDividerHeight(30);
        itemList = new ArrayList<>();

        getData();
        live_pulllistview.setMode(PullToRefreshBase.Mode.BOTH);
        live_pulllistview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                itemList.clear();
                getData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                getNewData();
            }
        });

        live_pulllistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getContext(), ItemItFlagActivity.class);
                Log.i("Tag","detailUrl is "+itemList.get(position-1).detailUrl);
                intent.putExtra("detailUrl",itemList.get(position-1).detailUrl);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getData() {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        liveBean = gson.fromJson(result,LiveBean.class);
                        bindData(liveBean);
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

    private void bindData(LiveBean liveBean1) {
        liveBean = liveBean1;
        itemList.addAll(liveBean1.data.itemList);
        adapter = new LiveListAdapter(getContext(),itemList);
        live_pulllistview.setAdapter(adapter);
        if (live_pulllistview.isRefreshing()){
            live_pulllistview.onRefreshComplete();
        }
    }

    private void getNewData() {
        RequestParams requestParams = new RequestParams(newurl);
        requestParams.addQueryStringParameter("p",page+"");
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        newitemList = new ArrayList<LiveBean.DataBean.ItemListBean>();
                        try {
                            JSONObject jobj = new JSONObject(result);
                            JSONArray jitemlist = jobj.optJSONArray("itemList");
                            for (int i=0;i<jitemlist.length();i++){
                                LiveBean.DataBean.ItemListBean itemListBean =
                                        new LiveBean.DataBean.ItemListBean();
                                JSONObject jdata = jitemlist.optJSONObject(i);
                                itemListBean.itemID = jdata.optString("itemID");
                                itemListBean.detailUrl = jdata.optString("detailUrl");
                                itemListBean.tagDesc = jdata.optString("tagDesc");
                                itemListBean.itemTitle = jdata.optString("itemTitle");
                                JSONObject jurl = jdata.optJSONObject("itemImage");
                                LiveBean.DataBean.ItemListBean.ItemImageBean imageBean =
                                        new LiveBean.DataBean.ItemListBean.ItemImageBean();
                                imageBean.imgUrl1 = jurl.optString("imgUrl1");
                                itemListBean.itemImage = imageBean;
                                newitemList.add(itemListBean);
                            }
                            itemList.addAll(newitemList);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
        if (live_pulllistview.isRefreshing()){
            live_pulllistview.onRefreshComplete();
        }
    }


}
