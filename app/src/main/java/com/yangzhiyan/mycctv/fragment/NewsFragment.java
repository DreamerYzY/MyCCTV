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
    private String[] tabs = {"要闻","直播","V观","夜读","国际","体育","看台湾","军事",
            "评论","财经","社会","地震"};
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
        fragmentList = new ArrayList<>();
        for (int i=0;i<tabs.length;i++){
            news_tab.addTab(news_tab.newTab().setText(tabs[i]));
        }
        newFragment();
        news_tab.setupWithViewPager(news_viewpager);
        return view;
    }


    private void newFragment() {
        Bundle bundle;
        FocusnewsOfNewsFragment focusnewsOfNewsFragment = new FocusnewsOfNewsFragment();
        fragmentList.add(focusnewsOfNewsFragment);

        LiveOfNewsFragment liveOfNewsFragment = new LiveOfNewsFragment();
        fragmentList.add(liveOfNewsFragment);

        OtherOfNewsFragment otherOfNewsFragmentV = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1462415765890287");
        otherOfNewsFragmentV.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentV);

        OtherOfNewsFragment otherOfNewsFragmentNightread = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1456119001862969");
        otherOfNewsFragmentNightread.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentNightread);

        OtherOfNewsFragment otherOfNewsFragmentInternational = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1463463402222747");
        otherOfNewsFragmentInternational.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentInternational);

        OtherOfNewsFragment otherOfNewsFragmentPE = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1383126274316527");
        otherOfNewsFragmentPE.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentPE);

        OtherOfNewsFragment otherOfNewsFragmentTaiwan = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1451446462471933");
        otherOfNewsFragmentTaiwan.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentTaiwan);

        OtherOfNewsFragment otherOfNewsFragmentArmy = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1383125722766236");
        otherOfNewsFragmentArmy.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentArmy);

        OtherOfNewsFragment otherOfNewsFragmentComment = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1452495392395454");
        otherOfNewsFragmentComment.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentComment);

        OtherOfNewsFragment otherOfNewsFragmentFinance = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1383126577835657");
        otherOfNewsFragmentFinance.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentFinance);

        OtherOfNewsFragment otherOfNewsFragmentSocial = new OtherOfNewsFragment();
        bundle = new Bundle();
        bundle.putString("id","TDAT1383126850500788");
        otherOfNewsFragmentSocial.setArguments(bundle);
        fragmentList.add(otherOfNewsFragmentSocial);

        EarthquickOfNewsFragment earthquickOfNewsFragment = new EarthquickOfNewsFragment();
        fragmentList.add(earthquickOfNewsFragment);


        adapter=new NewsViewPagerAdapter(getChildFragmentManager(),fragmentList,tabs);
        news_viewpager.setAdapter(adapter);
    }
}

