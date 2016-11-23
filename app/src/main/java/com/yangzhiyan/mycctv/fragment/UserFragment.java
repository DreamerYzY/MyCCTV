package com.yangzhiyan.mycctv.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.activity.LoginActivity;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    @ViewInject(R.id.user_linearlayout)
    LinearLayout user_linearlayout;
    @ViewInject(R.id.user_head)
    ImageView user_head;
    @ViewInject(R.id.user_login)
    TextView user_login;

    private ImageView user_pic;
    private TextView user_text;
    private ImageView user_state;

    private int[] icons = {R.mipmap.icon_setting_history,R.mipmap.icon_setting_my_fav,
            R.mipmap.icon_setting_news_push,R.mipmap.icon_setting_net_alert,
            R.mipmap.icon_setting_clear_cache,R.mipmap.icon_setting_app_recommend,
            R.mipmap.icon_setting_feedback,R.mipmap.icon_setting_update,
            R.mipmap.icon_setting_attention,R.mipmap.icon_setting_about
    };
    private String[] titles = {"历史记录","我的收藏","要闻推送","使用移动网络不再提醒",
            "清除缓存","应用推荐","意见反馈","检测新版本","关注央视新闻","关于"};

    private View view;
    private boolean flag1;
    private boolean flag2;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user,container,false);
        x.view().inject(this,view);

        for (int i=0;i<icons.length;i++){

            View itemview = getActivity().getLayoutInflater().inflate(
                    R.layout.user_item,null
            );
            user_text = (TextView) itemview.findViewById(R.id.user_text);
            user_pic = (ImageView) itemview.findViewById(R.id.user_pic);
            user_state = (ImageButton) itemview.findViewById(R.id.user_state);

            user_pic.setImageResource(icons[i]);
            user_text.setText(titles[i]);

            if (i==2||i==3){
                user_state.setVisibility(View.VISIBLE);
                user_state.setBackgroundResource(R.mipmap.setting_btn_off);
                if (i == 2){
                    user_state.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (flag1){
                                user_state.setBackgroundResource(R.mipmap.setting_btn_off);
                                Toast.makeText(getContext(), "要闻推送关闭", Toast.LENGTH_SHORT).show();
                            }else {
                                user_state.setBackgroundResource(R.mipmap.setting_btn_on);
                                Toast.makeText(getContext(), "要闻推送开启", Toast.LENGTH_SHORT).show();
                            }
                            flag1 = !flag1;
                            Log.i("Tag",flag1+"");
                        }
                    });

                }
                if (i == 3){
                    user_state.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (flag2){
                                user_state.setBackgroundResource(R.mipmap.setting_btn_off);
                                Toast.makeText(getContext(), "移动网络开关已关闭", Toast.LENGTH_SHORT).show();
                            }else {
                                user_state.setBackgroundResource(R.mipmap.setting_btn_on);
                                Toast.makeText(getContext(), "移动网络开关已开启，使用移动网络" +
                                        "播放音视频将不再提醒", Toast.LENGTH_SHORT).show();
                            }
                            flag2 = !flag2;
                            Log.i("Tag",flag2+"");
                        }
                    });
                }
            }
            user_linearlayout.addView(itemview);
        }

        user_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                startActivityForResult(intent,20);
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == 30){
            String nickname = data.getStringExtra("nickname");
            user_login.setText(nickname);
            user_head.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getContext()).load(data.getStringExtra("imgurl")).into(user_head);
        }
    }
}
