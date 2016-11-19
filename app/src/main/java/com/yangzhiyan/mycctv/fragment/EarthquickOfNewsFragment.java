package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yangzhiyan.mycctv.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class EarthquickOfNewsFragment extends Fragment {
    @ViewInject(R.id.earthauick_web)
    WebView earthquick_web;

    private View view;
    private String datauri = "http://app.cntv.cn/special/news/earthquake/index.html";

    public EarthquickOfNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_earthquick_of_news, container, false);
        x.view().inject(this,view);
        earthquick_web.getSettings().setJavaScriptEnabled(true);
        earthquick_web.setWebViewClient(new WebViewClient());
        earthquick_web.loadUrl(datauri);
        return view;
    }

}
