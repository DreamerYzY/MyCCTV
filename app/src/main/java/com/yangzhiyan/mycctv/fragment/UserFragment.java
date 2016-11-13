package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.UserListAdapter;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    @ViewInject(R.id.user_listview)
    ListView user_listview;

    private View view;
    private int[] icons = {R.mipmap.icon_setting_history,R.mipmap.icon_setting_my_fav,
            R.mipmap.icon_setting_news_push,R.mipmap.icon_setting_net_alert,
            R.mipmap.icon_setting_clear_cache,R.mipmap.icon_setting_app_recommend,
            R.mipmap.icon_setting_feedback,R.mipmap.icon_setting_update,
            R.mipmap.icon_setting_attention,R.mipmap.icon_setting_about};
    private String[] texts ={"历史记录","我的收藏","要闻推送","使用移动网络不再提醒","清除缓存",
            "应用推荐","意见反馈","检测新版本","关注央视新闻","关于"};

    private UserListAdapter adapter;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view!=null){
            return view;
        }
        view = inflater.inflate(R.layout.fragment_user, container, false);
        user_listview = (ListView) view.findViewById(R.id.user_listview);

        adapter = new UserListAdapter(getContext(),texts,icons);
        user_listview.setAdapter(adapter);

        user_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

}
