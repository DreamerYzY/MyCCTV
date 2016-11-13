package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.GuidePageAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    private ViewPager guideViewPager;
    private List<ImageView> imageList;
    private GuidePageAdapter guideAdapter;
    private int[] icons = {R.mipmap.launch_0,R.mipmap.launch_1,R.mipmap.launch_2,R.mipmap.launch_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        guideViewPager = (ViewPager) findViewById(R.id.guideViewPager);
        imageList = new ArrayList<>();

        for (int i=0;i<icons.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(icons[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageList.add(imageView);
        }
        guideAdapter = new GuidePageAdapter(imageList);
        guideViewPager.setAdapter(guideAdapter);

        guideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == imageList.size()-1){
                    imageList.get(position).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(GuideActivity.this,MainActivity.class));
                            GuideActivity.this.finish();
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
