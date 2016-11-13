package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.FocusnewsListAdapter;
import com.yangzhiyan.mycctv.adapter.FocusnewsViewpagerAdapter;
import com.yangzhiyan.mycctv.been.Focusnews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class FocusnewsOfNewsFragment extends Fragment {

    private PullToRefreshListView focusnews_pulllistview;
    private ViewPager focusnews_viewpager;
    private LinearLayout focusnews_lldots;
    private TextView focusnews_viewpager_text;

    private FocusnewsListAdapter listAdapter;
    private FocusnewsViewpagerAdapter viewpagerAdapter;

    private Focusnews focusnews;
    private List<ImageView> imageViewList;
    private List<Focusnews.DataBean.ItemListBean> itemListBeen;
    private ImageView[] dots;

    private String url = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandData" +
            "InfoNew&handdata_id=TDAT1372928688333145&n2=20&toutuNum=3";
    private int page = 1;
    public static int n1 = 3;


    private View view;
    public FocusnewsOfNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null){
            return view;
        }
        view = inflater.inflate(R.layout.fragment_focusnews_of_news, container, false);
        focusnews_pulllistview = (PullToRefreshListView) view.findViewById(R.id.focusnews_pulllistview);
        View headview = getActivity().getLayoutInflater().inflate(R.layout.focusnews_headerview_viewpager,
                null);
        focusnews_pulllistview.getRefreshableView().addHeaderView(headview);

        focusnews_viewpager = (ViewPager) headview.findViewById(R.id.focusnews_viewpager);
        focusnews_lldots = (LinearLayout) headview.findViewById(R.id.focusnews_lldots);
        focusnews_viewpager_text = (TextView) headview.findViewById(R.id.focusnews_viewpager_text);


        imageViewList = new ArrayList<>();
        viewpagerAdapter = new FocusnewsViewpagerAdapter(imageViewList);
        focusnews_viewpager.setAdapter(viewpagerAdapter);

        getData();

        focusnews_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                focusnews_viewpager_text.setText(focusnews.data.bigImg.get(position).itemTitle);
                for (int i = 0; i < dots.length; i++) {
                    dots[i].setEnabled(true);
                }
                dots[position].setEnabled(false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        focusnews_pulllistview.setMode(PullToRefreshBase.Mode.BOTH);

        focusnews_pulllistview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                focusnews_lldots.removeAllViews();
                itemListBeen.clear();
                page = 1;
                n1 = 3;
                getData();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                url = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandDataListInfo" +
                        "New&handdata_id=TDAT1372928688333145&n2=20&toutuNum=3";
                page++;
                getNewData();
            }
        });
        return view;
    }

    private void getData() {
        RequestParams requestParams = new RequestParams(url);
        requestParams.addQueryStringParameter("n1", n1 + "");
        requestParams.addQueryStringParameter("p", page + "");
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        itemListBeen = new ArrayList<>();
                        Gson gson = new Gson();
                        focusnews = gson.fromJson(result, Focusnews.class);
                        initData(focusnews);
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


    private void initData(Focusnews focusnews1) {
        focusnews = focusnews1;

        itemListBeen.addAll(focusnews.data.itemList);
        listAdapter = new FocusnewsListAdapter(getContext(), itemListBeen);
        focusnews_pulllistview.setAdapter(listAdapter);

        dots = new ImageView[focusnews.data.bigImg.size()];
        focusnews_viewpager_text.setText(focusnews.data.bigImg.get(0).itemTitle);

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getContext());
            dots[i].setImageResource(R.drawable.dot);
            dots[i].setEnabled(true);
            focusnews_lldots.addView(dots[i]);

            String imgurl = focusnews.data.bigImg.get(i).itemImage;
            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext()).load(imgurl).into(imageView);
            imageViewList.add(imageView);
        }
        viewpagerAdapter.notifyDataSetChanged();
        dots[0].setEnabled(false);


        if (focusnews_pulllistview.isRefreshing()) {
            focusnews_pulllistview.onRefreshComplete();
        }

    }

    private void getNewData() {
        RequestParams requestParams = new RequestParams(url);
        requestParams.addQueryStringParameter("p", page + "");

        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        List<Focusnews.DataBean.ItemListBean> newitemlist;
                        newitemlist = new ArrayList<>();
                        try {
                            JSONObject jobj = new JSONObject(result);
                            JSONArray jitemlist = jobj.optJSONArray("itemList");
                            for (int i=0;i<jitemlist.length();i++){
                                Focusnews.DataBean.ItemListBean listbeen =
                                        new Focusnews.DataBean.ItemListBean();
                                JSONObject jdatas = jitemlist.optJSONObject(i);
                                listbeen.itemID = jdatas.optString("itemID");
                                listbeen.itemType = jdatas.optString("itemType");
                                listbeen.itemTitle = jdatas.optString("itemTitle");
                                JSONObject jurls = jdatas.optJSONObject("itemImage");
                                Focusnews.DataBean.ItemListBean.ItemImageBean imageBean =
                                        new Focusnews.DataBean.ItemListBean.ItemImageBean();
                                imageBean.imgUrl1 = jurls.optString("imgUrl1");
                                imageBean.imgUrl2 = jurls.optString("imgUrl2");
                                imageBean.imgUrl3 = jurls.optString("imgUrl3");
                                listbeen.itemImage = imageBean;
                                newitemlist.add(listbeen);
                            }
                            itemListBeen.addAll(newitemlist);
                            listAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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
        if (focusnews_pulllistview.isRefreshing()) {
            focusnews_pulllistview.onRefreshComplete();
        }
    }

}

