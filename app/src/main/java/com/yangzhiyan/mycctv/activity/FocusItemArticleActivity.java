package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.constant.WBConstants;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.interfaces.Constants;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class FocusItemArticleActivity extends AppCompatActivity {

    @ViewInject(R.id.focus_item_default)
    WebView focus_item_default;

    @ViewInject(R.id.item_rl)
    RelativeLayout item_rl;

    @ViewInject(R.id.item_ll)
    LinearLayout item_ll;

    private IWeiboShareAPI iWeiboShareAPI;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_item);

        iWeiboShareAPI = WeiboShareSDK.createWeiboAPI(this, Constants.APP_KEY);

        x.view().inject(this);
        String url;
        focus_item_default.setWebViewClient(new WebViewClient());
        focus_item_default.getSettings().setJavaScriptEnabled(true);

        intent = getIntent();
        switch (intent.getStringExtra("type")){
            case "album_flag":
                item_rl.setBackgroundColor(Color.BLACK);
                item_ll.setBackgroundColor(Color.BLACK);
                url = intent.getStringExtra("detailUrl");
                focus_item_default.loadUrl(url);
                break;
            default:
                url = intent.getStringExtra("detailUrl");
                focus_item_default.loadUrl(url);
                break;
        }

    }
    @Event(value = {R.id.item_return,R.id.item_share},type = View.OnClickListener.class)
    private void OnClick(View view){
        switch (view.getId()){
            case R.id.item_return:
                FocusItemArticleActivity.this.finish();
                break;
            case R.id.item_share:
                WeiboMultiMessage multiMessage = new WeiboMultiMessage();

                TextObject textObject = new TextObject();
                textObject.text = "我分享了一个链接"+'\n'+intent.getStringExtra("detailUrl");
                multiMessage.textObject = textObject;

                SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
                request.transaction = String.valueOf(System.currentTimeMillis());
                request.multiMessage = multiMessage;
                iWeiboShareAPI.sendRequest(this,request);
                break;
        }
    }
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
