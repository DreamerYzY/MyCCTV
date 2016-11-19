package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/18.
 */

public class ItemItFlagBean {


    public DataBean data;

    public List<MsgListBean> msgList;

    public static ItemItFlagBean objectFromData(String str) {

        return new Gson().fromJson(str, ItemItFlagBean.class);
    }

    public static ItemItFlagBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ItemItFlagBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class DataBean {

        public List<LiveListBean> liveList;

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

        public static class LiveListBean {
            public String height;
            public String width;
            public String liveUrl;
            public String liveTitle;
            public String liveImage;
            public String liveType;
            public String liveRate;
            public String livesort;

            public static LiveListBean objectFromData(String str) {

                return new Gson().fromJson(str, LiveListBean.class);
            }

            public static LiveListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), LiveListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }

    public static class MsgListBean {
        public String detailUrl;
        public String msgTitle;
        public String videoImg;
        public String videoUrl;
        public String rwName;
        public String topFlag;
        public long msgTime;
        public String type;
        public String msg;
        public String msgId;
        public String liveUrl;
        public String rwImg;
        public String msgImage;

        public static MsgListBean objectFromData(String str) {

            return new Gson().fromJson(str, MsgListBean.class);
        }

        public static MsgListBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), MsgListBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
