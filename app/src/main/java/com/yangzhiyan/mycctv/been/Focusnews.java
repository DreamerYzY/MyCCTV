package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/10.
 */

public class Focusnews {


    public DataBean data;

    public static Focusnews objectFromData(String str) {

        return new Gson().fromJson(str, Focusnews.class);
    }

    public static Focusnews objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Focusnews.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class DataBean {
        public String listUrl;
        /**
         * pubDate : 1478749303000
         * detailUrl : http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIE0aNWGPr9bU13IP3EVYL161110&isfromapp=1
         * itemID : ARTIE0aNWGPr9bU13IP3EVYL161110
         * tagDesc :
         * allow_praise : 1
         * itemType : article_flag
         * videoPlayID :
         * photoCount : 0
         * imageNum : 3
         * commentNum :
         * allow_share : 1
         * num : 1
         * operate_time : 2016-11-09 19:28:25
         * videoLength :
         * allow_comment : 1
         * itemBrief :
         * itemTitle : 习近平将访问南美三国并出席亚太经合组织会议
         * brief :
         * itemImage : {"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/09/2016110919152139788.jpg","imgUrl3":"http://p1.img.cctvpic.com/photoworkspace/2016/11/09/2016110919152139788.jpg","imgUrl2":"http://p1.img.cctvpic.com/photoworkspace/2016/11/09/2016110919152139788.jpg"}
         * tagColor :
         */

        public List<ItemListBean> itemList;
        /**
         * detailUrl : http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTILgMomfxO4wdCdCdC18C3161110&isfromapp=1
         * pubDate : 1478772857000
         * itemID : ARTILgMomfxO4wdCdCdC18C3161110
         * tagDesc :
         * allow_praise : 1
         * itemType : article_flag
         * videoPlayID :
         * photoCount : 0
         * allow_share : 1
         * num : 1
         * operate_time : 2016-11-09 20:23:28
         * videoLength :
         * allow_comment : 1
         * itemBrief :
         * itemTitle : 习近平：建设强大现代化后勤
         * itemImage : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/10/1478773433723_387.jpg
         * brief :
         * tagColor :
         */

        public List<BigImgBean> bigImg;

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

        public static class ItemListBean {
            public String pubDate;
            public String detailUrl;
            public String itemID;
            public String tagDesc;
            public String allow_praise;
            public String itemType;
            public String videoPlayID;
            public String photoCount;
            public String imageNum;
            public String commentNum;
            public String allow_share;
            public String num;
            public String operate_time;
            public String videoLength;
            public String allow_comment;
            public String itemBrief;
            public String itemTitle;
            public String brief;
            /**
             * imgUrl1 : http://p1.img.cctvpic.com/photoworkspace/2016/11/09/2016110919152139788.jpg
             * imgUrl3 : http://p1.img.cctvpic.com/photoworkspace/2016/11/09/2016110919152139788.jpg
             * imgUrl2 : http://p1.img.cctvpic.com/photoworkspace/2016/11/09/2016110919152139788.jpg
             */

            public ItemImageBean itemImage;
            public String tagColor;

            public static ItemListBean objectFromData(String str) {

                return new Gson().fromJson(str, ItemListBean.class);
            }

            public static ItemListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ItemListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static class ItemImageBean {
                public String imgUrl1;
                public String imgUrl3;
                public String imgUrl2;

                public static ItemImageBean objectFromData(String str) {

                    return new Gson().fromJson(str, ItemImageBean.class);
                }

                public static ItemImageBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ItemImageBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            }
        }

        public static class BigImgBean {
            public String detailUrl;
            public String pubDate;
            public String itemID;
            public String tagDesc;
            public String allow_praise;
            public String itemType;
            public String videoPlayID;
            public String photoCount;
            public String allow_share;
            public String num;
            public String operate_time;
            public String videoLength;
            public String allow_comment;
            public String itemBrief;
            public String itemTitle;
            public String itemImage;
            public String brief;
            public String tagColor;

            public static BigImgBean objectFromData(String str) {

                return new Gson().fromJson(str, BigImgBean.class);
            }

            public static BigImgBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), BigImgBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }
    }
}
