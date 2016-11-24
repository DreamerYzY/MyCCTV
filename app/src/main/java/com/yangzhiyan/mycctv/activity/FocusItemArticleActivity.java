package com.yangzhiyan.mycctv.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
import com.yangzhiyan.mycctv.utils.DBHelper;

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

    @ViewInject(R.id.collect)
    ImageView collect;

    private IWeiboShareAPI iWeiboShareAPI;
    private Intent intent;
    private boolean flag;

    private SQLiteDatabase sd;
    DBHelper helper = new DBHelper(this);


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

        sd = helper.getReadableDatabase();
        Cursor cursor = sd.query("mycollect",new String[]{"itemID"},"itemID=?",
                new String[]{intent.getStringExtra("itemID")},null,null,null);
        if (cursor.moveToNext()){
            flag = true;
            collect.setImageResource(R.mipmap.icon_fav_done);
        }else {
            flag = false;
            collect.setImageResource(R.mipmap.icon_fav);
        }
        switch (intent.getStringExtra("itemType")){
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
    @Event(value = {R.id.item_return,R.id.item_share,R.id.collect},type = View.OnClickListener.class)
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
            case R.id.collect:
                Log.i("collect","sdsdsdsdsdsdsdsdsd");
                if (flag){
                    sd = helper.getReadableDatabase();
                    int a = sd.delete("mycollect","itemID=?",new String[]{intent.getStringExtra("itemID")});
                    if (a > 0){
                        collect.setImageResource(R.mipmap.icon_fav);
                        Toast.makeText(this, "已删除收藏", Toast.LENGTH_SHORT).show();
                    }
                    
                }else {
                    sd = helper.getReadableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("itemType",intent.getStringExtra("itemType"));
                    values.put("itemTitle",intent.getStringExtra("itemTitle"));
                    values.put("detailUrl",intent.getStringExtra("detailUrl"));
                    values.put("itemID",intent.getStringExtra("itemID"));
                    long b = sd.insert("mycollect",null,values);
                    int c = Integer.parseInt(b+"");
                    if (c > 0){
                        collect.setImageResource(R.mipmap.icon_fav_done);
                        Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                    }
                }
                flag = !flag;
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
