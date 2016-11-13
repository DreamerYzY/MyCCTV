package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.NewsViewPagerAdapter;
import com.yangzhiyan.mycctv.been.News;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    @ViewInject(R.id.news_tab)
    TabLayout news_tab;
    @ViewInject(R.id.news_viewpager)
    ViewPager news_viewpager;
    private News news;
    private String[] tabs;
    private String dataurl = "http://m.news.cntv.cn/special/json/fenleiv2/index.json";
    private List<Fragment> fragmentList;
    private NewsViewPagerAdapter adapter;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        x.view().inject(this, view);
        getTab();
        fragmentList = new ArrayList<>();
        news_tab.setupWithViewPager(news_viewpager);
        return view;
    }

    private void getTab() {
        RequestParams requestParams = new RequestParams(dataurl);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        news = gson.fromJson(result, News.class);
                        bindTab(news);
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

    private void bindTab(News news1) {
        news = news1;
        tabs = new String[news.data.size()];
        for (int i = 0; i < news.data.size(); i++) {
            tabs[i] = news.data.get(i).title;
        }
        newFragment();
    }

    private void newFragment() {
        Bundle bundle;
        FocusnewsOfNewsFragment focusnewsOfNewsFragment = new FocusnewsOfNewsFragment();
        fragmentList.add(focusnewsOfNewsFragment);

        LiveOfNewsFragment liveOfNewsFragment = new LiveOfNewsFragment();
        fragmentList.add(liveOfNewsFragment);

        FinanceOfNewsFragment financeOfNewsFragment = new FinanceOfNewsFragment();
        fragmentList.add(financeOfNewsFragment);

        EarthquickOfNewsFragment earthquickOfNewsFragment = new EarthquickOfNewsFragment();
        fragmentList.add(earthquickOfNewsFragment);

        OtherOfNewsFragment otherOfNewsFragmentV = new OtherOfNewsFragment();
        fragmentList.add(otherOfNewsFragmentV);

        OtherOfNewsFragment otherOfNewsFragmentNightread = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(3).url);
        bundle.putInt("id", 3);
        fragmentList.add(otherOfNewsFragmentNightread);

        OtherOfNewsFragment otherOfNewsFragmentInternational = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(4).url);
        bundle.putInt("id", 4);
        fragmentList.add(otherOfNewsFragmentInternational);

        OtherOfNewsFragment otherOfNewsFragmentPE = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(5).url);
        bundle.putInt("id", 5);
        fragmentList.add(otherOfNewsFragmentPE);

        OtherOfNewsFragment otherOfNewsFragmentTaiwan = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(6).url);
        bundle.putInt("id", 6);
        fragmentList.add(otherOfNewsFragmentTaiwan);

        OtherOfNewsFragment otherOfNewsFragmentArmy = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(7).url);
        bundle.putInt("id", 7);
        fragmentList.add(otherOfNewsFragmentArmy);

        OtherOfNewsFragment otherOfNewsFragmentComment = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(8).url);
        bundle.putInt("id", 8);
        fragmentList.add(otherOfNewsFragmentComment);

        OtherOfNewsFragment otherOfNewsFragmentSocial = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("url", news.data.get(10).url);
        bundle.putInt("id", 10);
        fragmentList.add(otherOfNewsFragmentSocial);

        adapter=new NewsViewPagerAdapter(getChildFragmentManager(),fragmentList,tabs);
        news_viewpager.setAdapter(adapter);
    }
}

