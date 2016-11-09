package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
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
    @ViewInject(R.id.news_tab) TabLayout news_tab;
    @ViewInject(R.id.news_viewpager) ViewPager news_viewpager;
    private News news;
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
        x.view().inject(view);
        getTab();
        fragmentList = new ArrayList<>();
        newFragment();
        adapter = new NewsViewPagerAdapter(getChildFragmentManager(),fragmentList,news.data);
        news_viewpager.setAdapter(adapter);
        news_tab.setupWithViewPager(news_viewpager);
        return view;
    }

    private void getTab(){
        RequestParams requestParams = new RequestParams(dataurl);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        news = gson.fromJson(result,News.class);
                        bindTab();
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

    private void bindTab(){
        for (int i=0;i<news.data.size();i++){
            news_tab.addTab(news_tab.newTab().setText(news.data.get(i).toString()));
        }
    }

    private void newFragment(){
        Bundle bundle;
        for (int i=0;i<news.data.size();i++){
            switch (news.data.get(i).title){
                case "要闻":
                    FocusnewsOfNewsFragment focusnewsOfNewsFragment = new FocusnewsOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(i).url);
                    focusnewsOfNewsFragment.setArguments(bundle);
                    fragmentList.add(focusnewsOfNewsFragment);
                    break;
                case "直播":
                    LiveOfNewsFragment liveOfNewsFragment = new LiveOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(i).url);
                    liveOfNewsFragment.setArguments(bundle);
                    fragmentList.add(liveOfNewsFragment);
                    break;
                case "财经":
                    FinanceOfNewsFragment financeOfNewsFragment = new FinanceOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(i).url);
                    financeOfNewsFragment.setArguments(bundle);
                    fragmentList.add(financeOfNewsFragment);
                    break;
                case "地震":
                    EarthquickOfNewsFragment earthquickOfNewsFragment = new EarthquickOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(i).url);
                    earthquickOfNewsFragment.setArguments(bundle);
                    fragmentList.add(earthquickOfNewsFragment);
                    break;
                default:
                    OtherOfNewsFragment otherOfNewsFragmentV = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(2).url);
                    bundle.putInt("id",2);
                    fragmentList.add(otherOfNewsFragmentV);

                    OtherOfNewsFragment otherOfNewsFragmentNightread = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(3).url);
                    bundle.putInt("id",3);
                    fragmentList.add(otherOfNewsFragmentNightread);

                    OtherOfNewsFragment otherOfNewsFragmentInternational = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(4).url);
                    bundle.putInt("id",4);
                    fragmentList.add(otherOfNewsFragmentInternational);

                    OtherOfNewsFragment otherOfNewsFragmentPE = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(5).url);
                    bundle.putInt("id",5);
                    fragmentList.add(otherOfNewsFragmentPE);

                    OtherOfNewsFragment otherOfNewsFragmentTaiwan = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(6).url);
                    bundle.putInt("id",6);
                    fragmentList.add(otherOfNewsFragmentTaiwan);

                    OtherOfNewsFragment otherOfNewsFragmentArmy = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(7).url);
                    bundle.putInt("id",7);
                    fragmentList.add(otherOfNewsFragmentArmy);

                    OtherOfNewsFragment otherOfNewsFragmentComment = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(8).url);
                    bundle.putInt("id",8);
                    fragmentList.add(otherOfNewsFragmentComment);

                    OtherOfNewsFragment otherOfNewsFragmentSocial = new OtherOfNewsFragment();
                    bundle = new Bundle();
                    bundle.putString("url",news.data.get(10).url);
                    bundle.putInt("id",10);
                    fragmentList.add(otherOfNewsFragmentSocial);

                    break;
            }
        }
    }

}
