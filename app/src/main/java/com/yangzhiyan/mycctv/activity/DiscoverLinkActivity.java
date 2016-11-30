package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yangzhiyan.mycctv.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class DiscoverLinkActivity extends AppCompatActivity {

    private String detailurl;
    @ViewInject(R.id.discover_webview)
    WebView discover_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_link);
        x.view().inject(this);
        Intent intent = getIntent();
        detailurl = intent.getStringExtra("detailUrl");
        discover_webview.setWebViewClient(new WebViewClient());
        discover_webview.getSettings().setJavaScriptEnabled(true);
        discover_webview.loadUrl(detailurl);

    }
    @Event(value = {R.id.item_return,R.id.item_close,R.id.item_share},type = View.OnClickListener.class)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.item_return:case R.id.item_close:
                DiscoverLinkActivity.this.finish();
                break;
            case R.id.item_share:
                break;

        }
    }
}
