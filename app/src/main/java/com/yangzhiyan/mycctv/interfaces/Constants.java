package com.yangzhiyan.mycctv.interfaces;

import android.content.Context;

import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.yangzhiyan.mycctv.activity.MainActivity;

/**
 * Created by YZY on 2016/11/20.
 */


public interface Constants {
    public static  final String APP_KEY = "2408677852";
    public static final String REDIRECT_URL = "http://www.sina.com";
    public static final String SCOPE = "email,direct_messages_read,direct_messages_write,"
            +"friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
            + "follow_app_official_microblog," + "invitation_write";

}
