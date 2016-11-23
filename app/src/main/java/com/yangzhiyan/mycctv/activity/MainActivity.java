package com.yangzhiyan.mycctv.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.fragment.DiscoverFragment;
import com.yangzhiyan.mycctv.fragment.NewsFragment;
import com.yangzhiyan.mycctv.fragment.TVFragment;
import com.yangzhiyan.mycctv.fragment.TimeLineFragment;
import com.yangzhiyan.mycctv.fragment.UserFragment;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.rbnews) RadioButton rbnews;
    @ViewInject(R.id.rbtimeline) RadioButton rbtimeline;
    @ViewInject(R.id.rbtv) RadioButton rbtv;
    @ViewInject(R.id.rbdiscover) RadioButton rbdiscover;
    @ViewInject(R.id.rbuser) RadioButton rbuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        Drawable drawable = getResources().getDrawable(R.drawable.rbnews);
        drawable.setBounds(0,0,90,80);
        rbnews.setCompoundDrawables(null,drawable,null,null);

        drawable = getResources().getDrawable(R.drawable.rbtimeline);
        drawable.setBounds(0,0,90,80);
        rbtimeline.setCompoundDrawables(null,drawable,null,null);

        drawable = getResources().getDrawable(R.drawable.rbtv);
        drawable.setBounds(0,0,90,80);
        rbtv.setCompoundDrawables(null,drawable,null,null);

        drawable = getResources().getDrawable(R.drawable.rbdiscover);
        drawable.setBounds(0,0,90,80);
        rbdiscover.setCompoundDrawables(null,drawable,null,null);

        drawable = getResources().getDrawable(R.drawable.rbuser);
        drawable.setBounds(0,0,90,80);
        rbuser.setCompoundDrawables(null,drawable,null,null);


        getSupportFragmentManager().beginTransaction().replace(
                R.id.myframelayout,new NewsFragment()
        ).commit();
    }

    @Event(
            value = {R.id.rbuser,R.id.rbdiscover,R.id.rbtv,R.id.rbtimeline,R.id.rbnews},
            type = CompoundButton.OnCheckedChangeListener.class
    )
    private void OnCheckedChanged(CompoundButton compoundButton,boolean isChecked){
        if (isChecked){
            switch (compoundButton.getId()){
                case R.id.rbnews:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.myframelayout,new NewsFragment()
                    ).commit();
                    break;
                case R.id.rbtimeline:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.myframelayout,new TimeLineFragment()
                    ).commit();
                    break;
                case R.id.rbtv:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.myframelayout,new TVFragment()
                    ).commit();
                    break;
                case R.id.rbdiscover:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.myframelayout,new DiscoverFragment()
                    ).commit();
                    break;
                case R.id.rbuser:
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.myframelayout,new UserFragment()
                    ).commit();
                    break;
            }
        }
    }
}
