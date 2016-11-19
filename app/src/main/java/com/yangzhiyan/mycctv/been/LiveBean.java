package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/15.
 */

public class LiveBean {

    /**
     * listUrl : http://hot.news.cntv.cn/index.php?controller=list&action=getHandDataListInfoNew&handdata_id=TDAT1471405480888405&toutuNum=1
     * itemList : [{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1479086774692493&isfromapp=1","itemID":"INTE1479086774692493","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"1","operate_time":"2016-11-14 10:00:14","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/14/1479090581339_155.jpg","imgUrl3":"","imgUrl2":""},"tagColor":"1"},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1479039327476820&isfromapp=1","itemID":"INTE1479039327476820","tagDesc":"1","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"2","operate_time":"2016-11-14 07:43:25","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"新西兰发生强烈地震","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/14/1479080895543_779.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478913026008639&isfromapp=1","itemID":"INTE1478913026008639","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"3","operate_time":"2016-11-12 09:56:22","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"2016年\u201c中国智能车未来挑战赛\u201d开赛","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/12/1478915794505_993.png","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478831640855324&isfromapp=1","itemID":"INTE1478831640855324","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"4","operate_time":"2016-11-11 12:31:08","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"央视校招在线宣讲会：新媒体专场","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/11/1478838706595_769.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478825784368368&isfromapp=1","itemID":"INTE1478825784368368","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"5","operate_time":"2016-11-11 09:31:24","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"纪念孙中山先生诞辰150周年大会","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/11/1478827892770_827.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478754902788492&isfromapp=1","itemID":"INTE1478754902788492","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"6","operate_time":"2016-11-10 15:21:13","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"逛逛\u201c南疆第一巴扎\u201d","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/10/1478762480871_705.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478741986960354&isfromapp=1","itemID":"INTE1478741986960354","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"7","operate_time":"2016-11-10 10:16:09","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"上海地铁消防实战演练","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/10/1478744181210_88.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478669852038218&isfromapp=1","itemID":"INTE1478669852038218","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"8","operate_time":"2016-11-09 16:10:00","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"筑梦天宫 见证天地对话","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/9/1478680329440_599.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478598484190353&isfromapp=1","itemID":"INTE1478598484190353","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"9","operate_time":"2016-11-08 18:49:03","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"河北保定坠井男童找到 已无生命体征","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/9/1478678953524_936.png","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478583149932229&isfromapp=1","itemID":"INTE1478583149932229","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"10","operate_time":"2016-11-08 16:04:45","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"有耳福！维吾尔族神秘乐器亮相","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/8/1478592393377_960.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478499575157172&isfromapp=1","itemID":"INTE1478499575157172","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"11","operate_time":"2016-11-07 15:14:06","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"俄罗斯在红场举行阅兵式纪念1941年阅兵","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/7/1478510707218_68.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478483693846898&isfromapp=1","itemID":"INTE1478483693846898","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"12","operate_time":"2016-11-07 10:26:22","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"全国人大常委会办公厅新闻发布会","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/7/1478497251570_735.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478392591911144&isfromapp=1","itemID":"INTE1478392591911144","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"13","operate_time":"2016-11-06 10:50:27","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"步步惊心！高空百米倒走扁带","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/6/1478400636866_905.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478392823128271&isfromapp=1","itemID":"INTE1478392823128271","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"14","operate_time":"2016-11-06 09:30:46","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"候鸟迁徙，观鸟赏鸟还是关鸟伤鸟？","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/6/1478395868745_356.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478314673806236&isfromapp=1","itemID":"INTE1478314673806236","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"15","operate_time":"2016-11-05 13:43:40","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"看英俄飞行队如何上演\u201c天空芭蕾\u201d","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/5/1478324641455_390.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1477789215658685&isfromapp=1","itemID":"INTE1477789215658685","tagDesc":"2","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"16","operate_time":"2016-10-30 14:00:40","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"闺蜜干政？朴槿惠面临上任以来最大危机","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/10/30/1477828525189_703.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478305173960845&isfromapp=1","itemID":"INTE1478305173960845","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"17","operate_time":"2016-11-05 09:23:28","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"候鸟迁徙\u2014\u2014不该折翼的候鸟","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/5/1478309028789_285.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478222219115732&isfromapp=1","itemID":"INTE1478222219115732","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"18","operate_time":"2016-11-04 09:25:35","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"候鸟迁徙\u2014\u2014栖息地，鸟的天堂","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/4/1478222780519_779.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478222036835933&isfromapp=1","itemID":"INTE1478222036835933","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"19","operate_time":"2016-11-04 09:27:06","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"中英俄三国表演队同台献艺 竞飞天","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/4/1478222959096_572.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"0","detailUrl":"http://hot.news.cntv.cn/api/list/liveMessageList?id=INTE1478146724900850&isfromapp=1","itemID":"INTE1478146724900850","tagDesc":"3","allow_praise":"1","itemType":"it_flag","videoPlayID":"","photoCount":"","imageNum":"1","commentNum":"","allow_share":"1","num":"20","operate_time":"2016-11-03 14:01:37","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"\u201c红箭\u201d\u201c勇士\u201d飞行表演队上演力与美传奇","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/3/1478152906779_68.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""}]
     * bigImg : [{"detailUrl":"&isfromapp=1","pubDate":"0","itemID":"","tagDesc":"","allow_praise":"1","itemType":"","videoPlayID":"","photoCount":"","allow_share":"1","num":"1","operate_time":"2016-09-03 08:20:11","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"占位（置顶勿动）","itemImage":"","brief":"","tagColor":""}]
     */

    public DataBean data;

    public static LiveBean objectFromData(String str) {

        return new Gson().fromJson(str, LiveBean.class);
    }

    public static LiveBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LiveBean.class);
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
            /**
             * imgUrl1 : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/14/1479090581339_155.jpg
             * imgUrl3 :
             * imgUrl2 :
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
