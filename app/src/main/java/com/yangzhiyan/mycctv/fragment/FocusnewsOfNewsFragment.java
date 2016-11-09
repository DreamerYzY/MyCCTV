package com.yangzhiyan.mycctv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangzhiyan.mycctv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FocusnewsOfNewsFragment extends Fragment {


    public FocusnewsOfNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_focusnews_of_news, container, false);
    }

}
