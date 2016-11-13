package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/12.
 */

public class Discover {



    public DataBean data;

    public static Discover objectFromData(String str) {

        return new Gson().fromJson(str, Discover.class);
    }

    public static Discover objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Discover.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class DataBean {
        public String listUrl;

        public List<ItemListBean> itemList;

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
