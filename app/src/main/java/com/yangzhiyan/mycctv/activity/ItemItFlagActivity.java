package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.constant.WBConstants;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.adapter.ItemItFlagRecyclerviewAdapter;
import com.yangzhiyan.mycctv.been.ItemItFlagBean;
import com.yangzhiyan.mycctv.interfaces.Constants;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class ItemItFlagActivity extends AppCompatActivity {

    @ViewInject(R.id.itflag_pic)
    ImageView itflag_pic;
    @ViewInject(R.id.itflag_title)
    TextView itflag_text;
    @ViewInject(R.id.itflag_recyclerView)
    RecyclerView itflag_recycleView;
    @ViewInject(R.id.itflag_play)
    ImageView itflag_play;
    @ViewInject(R.id.itflag_container_other)
    RelativeLayout itflag_container_other;
    @ViewInject(R.id.itflag_video)
    VideoView itflag_video;

    private String url;

    private ItemItFlagBean itemItFlagBean;
    private ItemItFlagRecyclerviewAdapter adapter;

    private IWeiboShareAPI iWeiboShareAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_it_flag);
        x.view().inject(this);

        Intent intent = getIntent();
        url = intent.getStringExtra("detailUrl");
        iWeiboShareAPI = WeiboShareSDK.createWeiboAPI(this, Constants.APP_KEY);

        getData();


    }
    @Event(value = {R.id.item_return,R.id.item_share,R.id.itflag_play},type = View.OnClickListener.class)
    private void onCLick(View v){
        switch (v.getId()){
            case R.id.item_return:
                ItemItFlagActivity.this.finish();
                break;
            case R.id.item_share:

                WeiboMultiMessage multiMessage = new WeiboMultiMessage();

                TextObject textObject = new TextObject();
                textObject.text = "我分享了一个图片"+itemItFlagBean.data.liveList.get(0).liveImage;
                multiMessage.textObject = textObject;

                SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
                request.transaction = String.valueOf(System.currentTimeMillis());
                request.multiMessage = multiMessage;
                iWeiboShareAPI.sendRequest(this,request);
                break;
            case R.id.itflag_play:
                itflag_container_other.setVisibility(View.GONE);
                itflag_video.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void getData(){
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        itemItFlagBean = gson.fromJson(result,ItemItFlagBean.class);
                        bindData(itemItFlagBean);
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

    private void bindData(ItemItFlagBean itemItFlagBean1) {
        itemItFlagBean = itemItFlagBean1;
        if (itemItFlagBean.data.liveUrl.equals("")){
            itflag_play.setVisibility(View.GONE);
        }else {
            itflag_play.setVisibility(View.VISIBLE);
        }
        itflag_text.setText(itemItFlagBean.data.liveList.get(0).liveTitle);
        String imgurl = itemItFlagBean.data.liveList.get(0).liveImage;
        if (!imgurl.isEmpty()){
            itflag_pic.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(this).load(imgurl).into(itflag_pic);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false);
        adapter = new ItemItFlagRecyclerviewAdapter(this,itemItFlagBean.msgList);
        itflag_recycleView.setLayoutManager(layoutManager);
        itflag_recycleView.setAdapter(adapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        iWeiboShareAPI.handleWeiboResponse(intent,response);
    }

    private IWeiboHandler.Response response = new IWeiboHandler.Response() {
        @Override
        public void onResponse(BaseResponse baseResponse) {

            switch (baseResponse.errCode) {
                case WBConstants.ErrorCode.ERR_OK:
                    break;
                case WBConstants.ErrorCode.ERR_CANCEL:
                    break;
                case WBConstants.ErrorCode.ERR_FAIL:
                    break;
            }
        }
    };
}
