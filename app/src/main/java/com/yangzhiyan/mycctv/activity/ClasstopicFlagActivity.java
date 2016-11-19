package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.CustomWidget.MyListview;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.ClasstopicListviewAdapter;
import com.yangzhiyan.mycctv.been.ClasstopicFlagBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class ClasstopicFlagActivity extends AppCompatActivity {
    @ViewInject(R.id.classtopic_toppic)
    ImageView classtopic_toppic;
    @ViewInject(R.id.classtopic_ll)
    LinearLayout classtopic_ll;

    private ClasstopicFlagBean classtopicFlag;
    private View listview;
    private View headview;
    private MyListview myListview;

    private TextView classtopic_listview_title;
    private Button classtopic_listview_more;
    private ClasstopicListviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classtopic_flag);
        x.view().inject(this);

        getData();
    }
    @Event(value = {R.id.item_return,R.id.item_share},type = View.OnClickListener.class)
    private void OnClick(View view){
        switch (view.getId()){
            case R.id.item_return:
                ClasstopicFlagActivity.this.finish();
                break;
            case R.id.item_share:
                break;
        }
    }

    private void getData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("detailUrl");
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        classtopicFlag = gson.fromJson(result,ClasstopicFlagBean.class);
                        bindData(classtopicFlag);
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

    private void bindData(ClasstopicFlagBean classtopicFlag1) {
        classtopicFlag = classtopicFlag1;
        if (!classtopicFlag.data.topicInfo.topicImg.isEmpty()){
            classtopic_toppic.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(this).load(classtopicFlag.data.topicInfo.topicImg).into(classtopic_toppic);
        }
        for (int i=0;i<classtopicFlag.data.topicList.size();i++){
            listview = LayoutInflater.from(this).inflate(
                    R.layout.classtopic_listview,null,false
            );
            headview = LayoutInflater.from(this).inflate(
                    R.layout.classtopic_listview_headview,null,false
            );
            myListview = (MyListview) listview.findViewById(R.id.classtopic_listview);
            classtopic_listview_title = (TextView) headview.findViewById(R.id.classtopic_listview_title);
            classtopic_listview_more = (Button) headview.findViewById(R.id.classtopic_listview_more);

            classtopic_ll.addView(headview);

            classtopic_listview_title.setText(classtopicFlag.data.topicList.get(i).forumName);

            if (Integer.parseInt(classtopicFlag.data.topicList.get(i).forumTotal)>4){
                classtopic_listview_more.setVisibility(View.VISIBLE);
            }else {
                classtopic_listview_more.setVisibility(View.GONE);
            }
            adapter = new ClasstopicListviewAdapter(this,classtopicFlag.data.topicList.get(i).list);
            myListview.setAdapter(adapter);
            classtopic_ll.addView(listview);
        }
    }
}
