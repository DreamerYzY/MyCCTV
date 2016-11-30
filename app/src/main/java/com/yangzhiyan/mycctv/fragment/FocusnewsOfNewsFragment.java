package com.yangzhiyan.mycctv.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.activity.ClasstopicFlagActivity;
import com.yangzhiyan.mycctv.activity.FocusItemArticleActivity;
import com.yangzhiyan.mycctv.activity.ItemItFlagActivity;
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
    private String url2;

    private int page = 1;
    public static int n1 = 3;


    private View view;
    public FocusnewsOfNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
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
                imageViewList.clear();
                page = 1;
                n1 = 3;
                getData();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                url2 = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandDataListInfo" +
                        "New&handdata_id=TDAT1372928688333145&n2=20&toutuNum=3";
                page++;
                getNewData();

            }
        });
        focusnews_pulllistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Focusnews.DataBean.ItemListBean itemListBean1 = itemListBeen.get(position-2);
                Log.i("Tag",position-2+"");
                switch (itemListBean1.itemType){
                    case "it_flag":
                        intent = new Intent();
                        intent.setClass(getContext(), ItemItFlagActivity.class);
                        intent.putExtra("detailUrl",itemListBean1.detailUrl);
                        Log.i("Tag","detailUrl is "+itemListBean1.detailUrl );
                        startActivity(intent);
                        break;
                    case "classtopic_flag":
                        intent = new Intent();
                        intent.setClass(getContext(), ClasstopicFlagActivity.class);
                        intent.putExtra("detailUrl",itemListBean1.detailUrl);
                        Log.i("Tag","detailUrl is "+itemListBean1.detailUrl );
                        startActivity(intent);
                        break;
                    case "vod_flag":
                        break;
                    default:
                        intent = new Intent();
                        intent.setClass(getContext(), FocusItemArticleActivity.class);
                        intent.putExtra("detailUrl",itemListBean1.detailUrl);
                        intent.putExtra("itemType",itemListBean1.itemType);
                        intent.putExtra("itemID",itemListBean1.itemID);
                        intent.putExtra("itemTitle",itemListBean1.itemTitle);
                        startActivity(intent);
                        break;
                }
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

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25,25);
        params.setMargins(0,0,30,0);

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getContext());
            dots[i].setImageResource(R.drawable.dot);
            dots[i].setEnabled(true);
            dots[i].setLayoutParams(params);
            focusnews_lldots.addView(dots[i]);
            String imgurl = focusnews.data.bigImg.get(i).itemImage;
            ImageView imageView = new ImageView(getContext());
            if (!imgurl.isEmpty()){
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(getContext()).load(imgurl).into(imageView);
            }
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (focusnews.data.bigImg.get(finalI).itemType){
                        case "it_flag":
                            Intent intent1 = new Intent();
                            intent1.setClass(getContext(), ItemItFlagActivity.class);
                            intent1.putExtra("detailUrl",focusnews.data.bigImg.get(finalI).detailUrl);
                            startActivity(intent1);
                            break;
                        case "classtopic_flag":
                            Intent intent2 = new Intent();
                            intent2.setClass(getContext(), ClasstopicFlagActivity.class);
                            intent2.putExtra("detailUrl",focusnews.data.bigImg.get(finalI).detailUrl);
                            startActivity(intent2);
                            break;
                        case "void_flag":
                            break;
                        default:
                            Intent intent = new Intent();
                            intent.setClass(getContext(), FocusItemArticleActivity.class);
                            intent.putExtra("detailUrl",focusnews.data.bigImg.get(finalI).detailUrl);
                            intent.putExtra("itemType",focusnews.data.bigImg.get(finalI).itemType);
                            intent.putExtra("itemID",focusnews.data.bigImg.get(finalI).itemID);
                            startActivity(intent);
                            break;
                    }
                }
            });

            imageViewList.add(imageView);
        }
        dots[0].setEnabled(false);
        viewpagerAdapter.notifyDataSetChanged();
        focusnews_viewpager.setCurrentItem(0);


        if (focusnews_pulllistview.isRefreshing()) {
            focusnews_pulllistview.onRefreshComplete();
        }

    }

    private void getNewData() {
        RequestParams requestParams = new RequestParams(url2);
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
                                listbeen.detailUrl = jdatas.optString("detailUrl");
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

