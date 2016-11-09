package com.yangzhiyan.mycctv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yangzhiyan.mycctv.been.News;

import java.util.List;

/**
 * Created by YZY on 2016/11/9.
 */

public class NewsViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<News.DataBean> dataBeanList;

    public NewsViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList,
                                List<News.DataBean> dataBeanList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position%fragmentList.size()).toString();
    }
}
