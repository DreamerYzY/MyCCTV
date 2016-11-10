package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/10.
 */

public class TvPlus {


    public DataBean data;

    public static TvPlus objectFromData(String str) {

        return new Gson().fromJson(str, TvPlus.class);
    }

    public static TvPlus objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), TvPlus.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class DataBean {
        public String title;

        public List<ColumnListBean> columnList;

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

        public static class ColumnListBean {
            public String columnNo;
            public String columnID;
            public String columnName;
            public String columnImage;
            public String channelLogo;
            public String channelTime;
            public String columnListImage;
            public String columnVideoUrl;
            public String columnVideoDateUrl;
            public String catalog;

            public static ColumnListBean objectFromData(String str) {

                return new Gson().fromJson(str, ColumnListBean.class);
            }

            public static ColumnListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ColumnListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }
}
