package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/18.
 */

public class ClasstopicFlagBean {

    /**
     * topicList : [{"forumTotal":"8","forumName":"焦点新闻","forumUrl":"http://hot.news.cntv.cn/index.php?controller=list&action=topicblocklist&pageid=PAGEQHUlhqlgUxplewVBD3st161116&fourmid=TDAT1479329957338771","list":[{"pubDate":"1479417727000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIQ0l4sfs9KaoyW162nu77161118&isfromapp=1","itemID":"ARTIQ0l4sfs9KaoyW162nu77161118","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"1","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平抵达基多 开始对厄瓜多尔进行国事访问","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/18/2016111806310337785.jpeg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479339838000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIniN6ujmX7RRWb12kZIfc161117&isfromapp=1","itemID":"ARTIniN6ujmX7RRWb12kZIfc161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"2","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平出访拉美经停撒丁岛 会见意大利总理","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111708280877792.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479314996000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIzNvZ9tI8ODOHiervtkTI161117&isfromapp=1","itemID":"ARTIzNvZ9tI8ODOHiervtkTI161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"3","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平在厄瓜多尔媒体发表署名文章","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/17/1479333178694_571.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479236651000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIFMwhleUnI76nHZXsS4Fp161116&isfromapp=1","itemID":"ARTIFMwhleUnI76nHZXsS4Fp161116","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"4","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平访问拉美：迎接中拉命运与共的历史新时期","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/17/1479330120196_742.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""}],"forumID":"TDAT1479329957338771"},{"forumTotal":"3","forumName":"独家V观","forumUrl":"http://hot.news.cntv.cn/index.php?controller=list&action=topicblocklist&pageid=PAGEQHUlhqlgUxplewVBD3st161116&fourmid=TDAT1479329990649774","list":[{"pubDate":"1479421705000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIi0m0ubf2yCr5ldQyFq9t161118&isfromapp=1","itemID":"ARTIi0m0ubf2yCr5ldQyFq9t161118","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"1","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平主席抵达厄瓜多尔 厄总统破例到机场迎接","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/18/2016111807144217004.png","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479261126000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIKuoolWAkgE5vLHTDu8sk161116&isfromapp=1","itemID":"ARTIKuoolWAkgE5vLHTDu8sk161116","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"2","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"厄瓜多尔总统府卫兵演练迎接习近平主席来访","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/16/2016111609515918987.png","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479175512000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTI4KZuFymwjy0TdVD2viG2161115&isfromapp=1","itemID":"ARTI4KZuFymwjy0TdVD2viG2161115","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"3","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"厄瓜多尔悬挂起中国国旗 欢迎中国国家主席来访","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/15/2016111509481210702.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""}],"forumID":"TDAT1479329990649774"},{"forumTotal":"6","forumName":"各方期待","forumUrl":"http://hot.news.cntv.cn/index.php?controller=list&action=topicblocklist&pageid=PAGEQHUlhqlgUxplewVBD3st161116&fourmid=TDAT1479352356311172","list":[{"pubDate":"1479375019000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIRW5Ju9wNhlnzCsk59OSI161117&isfromapp=1","itemID":"ARTIRW5Ju9wNhlnzCsk59OSI161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"1","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"秘鲁各界热切期盼习主席访问","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111717253388546.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479344664000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIc792kaxYPG0maEBCT1vI161117&isfromapp=1","itemID":"ARTIc792kaxYPG0maEBCT1vI161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"2","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"秘鲁社会各界期待APEC会议带来红利","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111708523336619.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479347718000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIQofuzOVr357MIyvNtXS5161117&isfromapp=1","itemID":"ARTIQofuzOVr357MIyvNtXS5161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"3","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平第三次拉美之行有何看点？","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111709550120980.png","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479344099000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIqbcofaQRetc2ASU04Y0k161117&isfromapp=1","itemID":"ARTIqbcofaQRetc2ASU04Y0k161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"4","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"厄瓜多尔民众期待习近平主席到访","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111708405392883.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""}],"forumID":"TDAT1479352356311172"},{"forumTotal":"6","forumName":"出访解读","forumUrl":"http://hot.news.cntv.cn/index.php?controller=list&action=topicblocklist&pageid=PAGEQHUlhqlgUxplewVBD3st161116&fourmid=TDAT1479330019433588","list":[{"pubDate":"1479349634000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTI7m3urNl3FWtbbP9OxJEu161117&isfromapp=1","itemID":"ARTI7m3urNl3FWtbbP9OxJEu161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"1","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"厄瓜多尔驻华大使：中厄友谊对厄具有战略意义","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111710010484192.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479350875000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIzHseBOxZSzV2ioNUI2JQ161117&isfromapp=1","itemID":"ARTIzHseBOxZSzV2ioNUI2JQ161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"2","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"专家解读：习近平拉美行 引领中拉关系再升级","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111710143739343.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479344997000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIG3NWWEFSIe57zdA5hmfT161117&isfromapp=1","itemID":"ARTIG3NWWEFSIe57zdA5hmfT161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"3","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"俄专家谈APEC会议：中国激发亚太发展活力","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111709000828579.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479290611000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTI2uXrPyOHKzvfODBTTnem161116&isfromapp=1","itemID":"ARTI2uXrPyOHKzvfODBTTnem161116","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"4","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"专访驻厄瓜多尔大使王玉林：中厄关系正处于历史最好时期","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/16/2016111617192658378.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""}],"forumID":"TDAT1479330019433588"}]
     * topicInfo : {"num":"1","topicTitle":"11月17日-23日 习近平访拉美并出席APEC会","topicImg":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/17/1479388367457_751.jpg","topicID":"PAGEQHUlhqlgUxplewVBD3st161116","topicBrief":"11月17日-23日 习近平访拉美并出席APEC会"}
     */

    public DataBean data;

    public static ClasstopicFlagBean objectFromData(String str) {

        return new Gson().fromJson(str, ClasstopicFlagBean.class);
    }

    public static ClasstopicFlagBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ClasstopicFlagBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class DataBean {
        /**
         * num : 1
         * topicTitle : 11月17日-23日 习近平访拉美并出席APEC会
         * topicImg : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/17/1479388367457_751.jpg
         * topicID : PAGEQHUlhqlgUxplewVBD3st161116
         * topicBrief : 11月17日-23日 习近平访拉美并出席APEC会
         */

        public TopicInfoBean topicInfo;
        /**
         * forumTotal : 8
         * forumName : 焦点新闻
         * forumUrl : http://hot.news.cntv.cn/index.php?controller=list&action=topicblocklist&pageid=PAGEQHUlhqlgUxplewVBD3st161116&fourmid=TDAT1479329957338771
         * list : [{"pubDate":"1479417727000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIQ0l4sfs9KaoyW162nu77161118&isfromapp=1","itemID":"ARTIQ0l4sfs9KaoyW162nu77161118","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"1","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平抵达基多 开始对厄瓜多尔进行国事访问","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/18/2016111806310337785.jpeg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479339838000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIniN6ujmX7RRWb12kZIfc161117&isfromapp=1","itemID":"ARTIniN6ujmX7RRWb12kZIfc161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"2","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平出访拉美经停撒丁岛 会见意大利总理","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/17/2016111708280877792.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479314996000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIzNvZ9tI8ODOHiervtkTI161117&isfromapp=1","itemID":"ARTIzNvZ9tI8ODOHiervtkTI161117","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"3","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平在厄瓜多尔媒体发表署名文章","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/17/1479333178694_571.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""},{"pubDate":"1479236651000","detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIFMwhleUnI76nHZXsS4Fp161116&isfromapp=1","itemID":"ARTIFMwhleUnI76nHZXsS4Fp161116","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"0","imageNum":"1","commentNum":"","allow_share":"1","num":"4","videoLength":"","allow_comment":"1","itemBrief":"","itemTitle":"习近平访问拉美：迎接中拉命运与共的历史新时期","brief":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/11/17/1479330120196_742.jpg","imgUrl3":"","imgUrl2":""},"tagColor":""}]
         * forumID : TDAT1479329957338771
         */

        public List<TopicListBean> topicList;

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

        public static class TopicInfoBean {
            public String num;
            public String topicTitle;
            public String topicImg;
            public String topicID;
            public String topicBrief;

            public static TopicInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, TopicInfoBean.class);
            }

            public static TopicInfoBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), TopicInfoBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        public static class TopicListBean {
            public String forumTotal;
            public String forumName;
            public String forumUrl;
            public String forumID;
            /**
             * pubDate : 1479417727000
             * detailUrl : http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIQ0l4sfs9KaoyW162nu77161118&isfromapp=1
             * itemID : ARTIQ0l4sfs9KaoyW162nu77161118
             * tagDesc :
             * allow_praise : 1
             * itemType : article_flag
             * videoPlayID :
             * photoCount : 0
             * imageNum : 1
             * commentNum :
             * allow_share : 1
             * num : 1
             * videoLength :
             * allow_comment : 1
             * itemBrief :
             * itemTitle : 习近平抵达基多 开始对厄瓜多尔进行国事访问
             * brief :
             * itemImage : {"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/18/2016111806310337785.jpeg","imgUrl3":"","imgUrl2":""}
             * tagColor :
             */

            public List<ListBean> list;

            public static TopicListBean objectFromData(String str) {

                return new Gson().fromJson(str, TopicListBean.class);
            }

            public static TopicListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), TopicListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static class ListBean {
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
                public String videoLength;
                public String allow_comment;
                public String itemBrief;
                public String itemTitle;
                public String brief;
                /**
                 * imgUrl1 : http://p1.img.cctvpic.com/photoworkspace/2016/11/18/2016111806310337785.jpeg
                 * imgUrl3 :
                 * imgUrl2 :
                 */

                public ItemImageBean itemImage;
                public String tagColor;

                public static ListBean objectFromData(String str) {

                    return new Gson().fromJson(str, ListBean.class);
                }

                public static ListBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ListBean.class);
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
        }
    }
}
