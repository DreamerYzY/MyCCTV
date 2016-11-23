package com.yangzhiyan.mycctv.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.UsersAPI;
import com.sina.weibo.sdk.openapi.models.User;
import com.squareup.picasso.Picasso;
import com.yangzhiyan.mycctv.R;
import com.yangzhiyan.mycctv.interfaces.Constants;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class LoginActivity extends AppCompatActivity {
    @ViewInject(R.id.login_no)
    EditText login_no;
    @ViewInject(R.id.login_pass)
    EditText login_pass;
    @ViewInject(R.id.btn_login)
    ImageButton btn_login;
    @ViewInject(R.id.weibo_logo)
    ImageView weibo_logo;


    private AuthInfo authInfo;
    private Oauth2AccessToken accessToken;
    private SsoHandler ssoHandler;
    private UsersAPI usersAPI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        x.view().inject(this);

        authInfo = new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);

        login_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login_pass.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (!login_no.getText().toString().equals("")) {
                            if (!login_pass.getText().toString().equals("")) {
                                btn_login.setClickable(true);
                                btn_login.setBackgroundResource(R.mipmap.deng_lu1);
                            }

                        }
                        if (login_pass.getText().toString().equals("") ||
                                login_no.getText().toString().equals("")) {
                            btn_login.setClickable(false);
                            btn_login.setBackgroundResource(R.mipmap.deng_lu2);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!login_no.getText().toString().equals("")) {
                            if (!login_pass.getText().toString().equals("")) {
                                btn_login.setClickable(true);
                                btn_login.setBackgroundResource(R.mipmap.deng_lu1);
                            }

                        }
                        if (login_pass.getText().toString().equals("") ||
                                login_no.getText().toString().equals("")) {
                            btn_login.setClickable(false);
                            btn_login.setBackgroundResource(R.mipmap.deng_lu2);
                        }
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    class AuthListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle bundle) {
            accessToken = Oauth2AccessToken.parseAccessToken(bundle);
            if (accessToken.isSessionValid()){

                String userToken = accessToken.getToken();
                String userId = accessToken.getUid();

                Log.i("Tag","userToken is "+userToken+",and userId is "+userId);

                usersAPI = new UsersAPI(LoginActivity.this,Constants.APP_KEY,accessToken);
                usersAPI.show(Long.parseLong(userId),requestListener);
            }else {
                String code = bundle.getString("code","");
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {

            e.printStackTrace();
        }

        @Override
        public void onCancel() {

        }
    }
    private RequestListener requestListener = new RequestListener() {
        @Override
        public void onComplete(String s) {

            if (!TextUtils.isEmpty(s)){
                User user = User.parse(s);
                Picasso.with(LoginActivity.this).load(user.avatar_hd).into(weibo_logo);
                Intent returnintent = new Intent();
                returnintent.putExtra("nickname",user.name+"");
                returnintent.putExtra("imgurl",user.avatar_hd+"");
                setResult(30,returnintent);
                LoginActivity.this.finish();
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {

        }
    };

    @Event(value = {R.id.tv_register, R.id.btn_login, R.id.fogetpass, R.id.weibo_logo, R.id.iv_return},
            type = View.OnClickListener.class)
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_return:
                LoginActivity.this.finish();
                break;
            case R.id.tv_register:
                break;
            case R.id.btn_login:
                break;
            case R.id.fogetpass:
                break;
            case R.id.weibo_logo:
                ssoHandler = new SsoHandler(LoginActivity.this,authInfo);
                ssoHandler.authorize(new AuthListener());
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ssoHandler != null){

            ssoHandler.authorizeCallBack(requestCode,resultCode,data);
        }
    }
}
