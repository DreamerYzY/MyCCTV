package com.yangzhiyan.mycctv.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.activity.ClasstopicFlagActivity;
import com.yangzhiyan.mycctv.activity.FocusItemArticleActivity;
import com.yangzhiyan.mycctv.activity.ItemItFlagActivity;
import com.yangzhiyan.mycctv.adapter.OtherListAdapter;
import com.yangzhiyan.mycctv.been.Focusnews;
import com.yangzhiyan.mycctv.been.OtherBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherOfNewsFragment extends Fragment {
    @ViewInject(R.id.other_list)
    PullToRefreshListView other_list;

    private ImageView other_pic;
    private TextView other_text;

    private String url = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandData" +
            "InfoNew&n1=1&n2=20&toutuNum=1";

    private String newurl = "http://hot.news.cntv.cn/index.php?controller=list&action=getHandData" +
            "ListInfoNew&toutuNum=1&n=20";

    private int page = 1;
    private String id;
    private View view;

    private OtherBean otherBean;
    private List<OtherBean.DataBean.ItemListBean> itemList;
    private OtherListAdapter adapter;

    public OtherOfNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_other_of_news, container, false);
        x.view().inject(this,view);

        View headview = getActivity().getLayoutInflater().inflate(
                R.layout.other_headview_layout,null
        );
        other_pic = (ImageView) headview.findViewById(R.id.other_pic);
        other_text = (TextView) headview.findViewById(R.id.other_text);

        other_list.getRefreshableView().addHeaderView(headview);

        itemList = new ArrayList<>();
        adapter = new OtherListAdapter(getContext(),itemList);
        other_list.setAdapter(adapter);

        Bundle bundle = getArguments();
        id = bundle.getString("id");
        getData();

        other_list.setMode(PullToRefreshBase.Mode.BOTH);
        other_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                itemList.clear();
                getData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                getNewData();
            }
        });
        other_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OtherBean.DataBean.ItemListBean itemListBean1 = itemList.get(position-2);
                Log.i("Tag",position-2+"");
                switch (itemListBean1.itemType){
                    case "it_flag":
                        intent = new Intent();
                        intent.setClass(getContext(), ItemItFlagActivity.class);
                        intent.putExtra("detailUrl",itemListBean1.detailUrl);
                        Log.i("Tag","detailUrl is "+itemListBean1.detailUrl );
                        startActivity(intent);
                        break;
                    case "classtopic_flag":
                        intent = new Intent();
                        intent.setClass(getContext(), ClasstopicFlagActivity.class);
                        intent.putExtra("detailUrl",itemListBean1.detailUrl);
                        Log.i("Tag","detailUrl is "+itemListBean1.detailUrl );
                        startActivity(intent);
                        break;
                    case "vod_flag":
                        break;
                    default:
                        intent = new Intent();
                        intent.setClass(getContext(), FocusItemArticleActivity.class);
                        intent.putExtra("itemID",itemListBean1.itemID);
                        intent.putExtra("detailUrl",itemListBean1.detailUrl);
                        intent.putExtra("itemType",itemListBean1.itemType);
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;
    }

    private void getData() {
        RequestParams requestParams = new RequestParams(url);
        requestParams.addQueryStringParameter("handdata_id",id);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Gson gson = new Gson();
                        otherBean = gson.fromJson(result,OtherBean.class);
                        bindData(otherBean);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                        ex.printStackTrace();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                        cex.printStackTrace();
                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    private void bindData(OtherBean otherBean1) {
        otherBean = otherBean1;
        OtherBean.DataBean.BigImgBean bigImgBean = otherBean.data.bigImg.get(0);
        if (!bigImgBean.itemImage.isEmpty()){
            other_pic.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getContext()).load(bigImgBean.itemImage).into(other_pic);
        }
        other_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (otherBean.data.bigImg.get(0).itemType){
                    case "it_flag":
                        Intent intent1 = new Intent();
                        intent1.setClass(getContext(), ItemItFlagActivity.class);
                        intent1.putExtra("detailUrl",otherBean.data.bigImg.get(0).detailUrl);
                        startActivity(intent1);
                        break;
                    case "classtopic_flag":
                        Intent intent2 = new Intent();
                        intent2.setClass(getContext(), ClasstopicFlagActivity.class);
                        intent2.putExtra("detailUrl",otherBean.data.bigImg.get(0).detailUrl);
                        startActivity(intent2);
                        break;
                    case "void_flag":
                        break;
                    default:
                        Intent intent = new Intent();
                        intent.setClass(getContext(), FocusItemArticleActivity.class);
                        intent.putExtra("detailUrl",otherBean.data.bigImg.get(0).detailUrl);
                        intent.putExtra("type",otherBean.data.bigImg.get(0).itemType);
                        startActivity(intent);
                        break;
                }
            }
        });
        other_text.setText(bigImgBean.itemTitle);
        itemList.addAll(otherBean.data.itemList);
        adapter.notifyDataSetChanged();
        if (other_list.isRefreshing()){
            other_list.onRefreshComplete();
        }
    }

    public void getNewData() {
        RequestParams requestParams = new RequestParams(newurl);
        requestParams.addQueryStringParameter("handdata_id",id);
        requestParams.addQueryStringParameter("p",page+"");
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        List<OtherBean.DataBean.ItemListBean> newitemList =
                                new ArrayList<OtherBean.DataBean.ItemListBean>();
                        try {
                            JSONObject jobj = new JSONObject(result);
                            JSONArray jitemlist = jobj.optJSONArray("itemList");
                            for (int i=0;i<jitemlist.length();i++){
                                OtherBean.DataBean.ItemListBean listbeen =
                                        new OtherBean.DataBean.ItemListBean();
                                JSONObject jdatas = jitemlist.optJSONObject(i);
                                listbeen.itemID = jdatas.optString("itemID");
                                listbeen.detailUrl = jdatas.optString("detailUrl");
                                listbeen.itemType = jdatas.optString("itemType");
                                listbeen.itemTitle = jdatas.optString("itemTitle");
                                JSONObject jurls = jdatas.optJSONObject("itemImage");
                                OtherBean.DataBean.ItemListBean.ItemImageBean imageBean =
                                        new OtherBean.DataBean.ItemListBean.ItemImageBean();
                                imageBean.imgUrl1 = jurls.optString("imgUrl1");
                                imageBean.imgUrl2 = jurls.optString("imgUrl2");
                                imageBean.imgUrl3 = jurls.optString("imgUrl3");
                                listbeen.itemImage = imageBean;
                                newitemList.add(listbeen);
                            }
                            itemList.addAll(newitemList);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                        ex.printStackTrace();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                        cex.printStackTrace();
                    }

                    @Override
                    public void onFinished() {

                    }
                });
        if (other_list.isRefreshing()) {
            other_list.onRefreshComplete();
        }
    }
}
