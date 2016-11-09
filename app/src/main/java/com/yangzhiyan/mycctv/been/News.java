package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/9.
 */

public class News {

    /**
     * title : 要闻
     * identify :
     * url : http://hot.news.cntv.cn/index.php?controller=list&action=getHandDataInfoNew&handdata_id=TDAT1372928688333145&n1=3&n2=20&toutuNum=3
     * isShow : 1
     * iosImgUrl : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2014/3/17/1395024170876_519.png
     * androidImgUrl : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2014/3/17/1395024311351_411.png
     * itemType : news_flag
     * order : 1
     */

    public List<DataBean> data;

    public static News objectFromData(String str) {

        return new Gson().fromJson(str, News.class);
    }

    public static News objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), News.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class DataBean {
        public String title;
        public String identify;
        public String url;
        public String isShow;
        public String iosImgUrl;
        public String androidImgUrl;
        public String itemType;
        public String order;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
