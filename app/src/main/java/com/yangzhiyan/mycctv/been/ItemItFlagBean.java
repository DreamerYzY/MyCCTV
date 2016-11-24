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
        public String msgCount;
        public String refresh;
        public String detailUrl;
        public String liveDesc;
        public String liveId;
        public String liveImage;
        public String liveTitle;
        public String liveType;
        public String liveUrl;
        public String liveState;
        public String liveDate;
        public String width;
        public String height;
        public String liveRate;
        public String msgFlag;
        public String topicFlag;
        public String interactFlag;
        public String interactUrl;
        public String vtype;
        public String countFlag;
        public String remark;
        public String msgTag;
        public String topicTag;
        public String interactTag;
        public String whichTag;
        public String coverimg;
        public String covertitle;
        public int whichFlag;
        /**
         * icon :
         */

        public List<IconListBean> iconList;
        /**
         * height : 720
         * width : 1280
         * liveUrl : 47d73f11cf43ce9a5640249589a875bc
         * liveTitle : 西昌发射中心和它的100次飞天
         * liveImage : http://p1.img.cctvpic.com/photoworkspace/2016/11/23/2016112309554474033.jpg
         * liveType : 3
         * liveRate : 1
         * livesort : 1
         */

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

        public static class IconListBean {
            public String icon;

            public static IconListBean objectFromData(String str) {

                return new Gson().fromJson(str, IconListBean.class);
            }

            public static IconListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), IconListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
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
        public String urlDesc;
        public String msgImage;
        /**
         * num : 1
         * photo_url : http://p1.img.cctvpic.com/photoworkspace/2016/11/23/2016112311321743730.jpg
         * width : 626
         * height : 352
         */

        public List<ImgListBean> imgList;

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

        public static class ImgListBean {
            public String num;
            public String photo_url;
            public String width;
            public String height;

            public static ImgListBean objectFromData(String str) {

                return new Gson().fromJson(str, ImgListBean.class);
            }

            public static ImgListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ImgListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }
}
