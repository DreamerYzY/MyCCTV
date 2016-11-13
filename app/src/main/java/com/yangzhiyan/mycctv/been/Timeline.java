package com.yangzhiyan.mycctv.been;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YZY on 2016/11/11.
 */

public class Timeline {

    /**
     * total : 8582
     * itemList : [{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIxuMg3Yr9CoOLjFi4ZVh9161111&isfromapp=1","pubDate":"1478855363000","itemID":"ARTIxuMg3Yr9CoOLjFi4ZVh9161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"1","videoLength":"","allow_comment":"1","itemTitle":"\u201c郑和舰\u201d海军学员进入任职岗位综合训练阶段","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116413268796.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIWzfhKpKQs6SaQDWhhxvn161111&isfromapp=1","pubDate":"1478855168000","itemID":"ARTIWzfhKpKQs6SaQDWhhxvn161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"2","videoLength":"","allow_comment":"1","itemTitle":"中国空军在改革强军中全面推进战略转型","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116560141740.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIndaYqWS3ReEGQfjCT5zE161111&isfromapp=1","pubDate":"1478853815000","itemID":"ARTIndaYqWS3ReEGQfjCT5zE161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"3","videoLength":"","allow_comment":"1","itemTitle":"韩检方提请法院批捕崔顺实身边\u201c红人\u201d车恩泽","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116252646846.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIkzSxvBlu95HLirzd8w0L161111&isfromapp=1","pubDate":"1478853796000","itemID":"ARTIkzSxvBlu95HLirzd8w0L161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"4","videoLength":"","allow_comment":"1","itemTitle":"【摩苏尔收复战】伊军前线告捷 后方频遭袭","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116081447398.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIbnhMPCI2pwwAhjp3Acrv161111&isfromapp=1","pubDate":"1478853548000","itemID":"ARTIbnhMPCI2pwwAhjp3Acrv161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"5","videoLength":"","allow_comment":"1","itemTitle":"韩联社：崔顺实之女申请退学","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116332740966.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIO8DavQy7t3Je2j6rMKMH161111&isfromapp=1","pubDate":"1478852168000","itemID":"ARTIO8DavQy7t3Je2j6rMKMH161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"6","videoLength":"","allow_comment":"1","itemTitle":"北京市发改委：新政实施 22万人享临时价格补贴","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116020855592.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIOLI5EJPXPH9HBJTuh9pL161111&isfromapp=1","pubDate":"1478851209000","itemID":"ARTIOLI5EJPXPH9HBJTuh9pL161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"7","videoLength":"","allow_comment":"1","itemTitle":"陆军构建动态火力网 提升炮兵打击能力","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115184599966.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIwfkCHNa1Lq9N2E3o9Hcd161111&isfromapp=1","pubDate":"1478850565000","itemID":"ARTIwfkCHNa1Lq9N2E3o9Hcd161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"8","videoLength":"","allow_comment":"1","itemTitle":"[V观]新闻背景：伟人足迹·孙中山的一生","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115505686632.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIAkwYk3Bi62iaQwIsbGrZ161111&isfromapp=1","pubDate":"1478850506000","itemID":"ARTIAkwYk3Bi62iaQwIsbGrZ161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"9","videoLength":"","allow_comment":"1","itemTitle":"\u201c6·25\u201d特大电信网络诈骗案告破 电话录音揭露行骗伎俩","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111114492786881.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIhmfQJxTb4VUrX7iHY5ov161111&isfromapp=1","pubDate":"1478849468000","itemID":"ARTIhmfQJxTb4VUrX7iHY5ov161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"10","videoLength":"","allow_comment":"1","itemTitle":"探访北京地铁16号线：\u201c古味\u201d新站 彰显人性化设计","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115180340501.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIHriODRRyByCTEDyON2zE161111&isfromapp=1","pubDate":"1478849406000","itemID":"ARTIHriODRRyByCTEDyON2zE161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"11","videoLength":"","allow_comment":"1","itemTitle":"百余张老照片遗落树丛 转发寻找失主！","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115282187998.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIXIGB7CcTPnUpoBSCzzCd161111&isfromapp=1","pubDate":"1478849123000","itemID":"ARTIXIGB7CcTPnUpoBSCzzCd161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"12","videoLength":"","allow_comment":"1","itemTitle":"天呐 | 印度为打击腐败竟废除500、1000面值货币 怎么回事？","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115250456889.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIKTByuZoNGUB8Qkbj0yzT161111&isfromapp=1","pubDate":"1478848761000","itemID":"ARTIKTByuZoNGUB8Qkbj0yzT161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"13","videoLength":"","allow_comment":"1","itemTitle":"中消协：网络外卖食品安全问题、黑餐馆现象仍然存在","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115112329666.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIRvJeu8o4NJRPUtceIdtW161111&isfromapp=1","pubDate":"1478848584000","itemID":"ARTIRvJeu8o4NJRPUtceIdtW161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"14","videoLength":"","allow_comment":"1","itemTitle":"土耳其地方政府大楼遭库尔德武装火箭弹袭击","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115074111946.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTII82NtPTPPYvF1vaskl2C161111&isfromapp=1","pubDate":"1478848528000","itemID":"ARTII82NtPTPPYvF1vaskl2C161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"15","videoLength":"","allow_comment":"1","itemTitle":"国家发展改革委：前10个月我国经济运行总体平稳","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115112231189.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIc5OPIVbldjIY0icEyhHg161111&isfromapp=1","pubDate":"1478848424000","itemID":"ARTIc5OPIVbldjIY0icEyhHg161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"16","videoLength":"","allow_comment":"1","itemTitle":"天量 | 每年快递胶带可绕赤道425圈 \u201c买买买\u201d背后的快递垃圾去哪儿了？","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111115125727657.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIJyGCflKj2O0E0BD20Lap161111&isfromapp=1","pubDate":"1478847339000","itemID":"ARTIJyGCflKj2O0E0BD20Lap161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"17","videoLength":"","allow_comment":"1","itemTitle":"我在北方的寒夜里大雪纷飞 你在南方的艳阳里四季如春","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111114551180423.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIj7PVqtX4TSX1GCzIEIsz161111&isfromapp=1","pubDate":"1478847329000","itemID":"ARTIj7PVqtX4TSX1GCzIEIsz161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"18","videoLength":"","allow_comment":"1","itemTitle":"伊朗学者：美推翻伊核协议可能性不大","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111113384110918.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIRAujekauJxfemPnTLlTz161111&isfromapp=1","pubDate":"1478847329000","itemID":"ARTIRAujekauJxfemPnTLlTz161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"19","videoLength":"","allow_comment":"1","itemTitle":"[V观]央视记者阿勒颇日记：战场旁边唯一一家电影院在上映新片","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111114522242359.png","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""},{"detailUrl":"http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIzcXQqTq6XILQ9FCyW07T161111&isfromapp=1","pubDate":"1478847314000","itemID":"ARTIzcXQqTq6XILQ9FCyW07T161111","tagDesc":"","allow_praise":"1","itemType":"article_flag","videoPlayID":"","photoCount":"","commentNum":"","allow_share":"1","num":"20","videoLength":"","allow_comment":"1","itemTitle":"质检总局启动\u201c双十一\u201d专项抽查 首次揭秘\u201c神秘买家\u201d","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111114140589089.jpg","imgUrl3":"","imgUrl2":""},"brief":"","tagColor":""}]
     * serverTime : 1478855755476
     */

    public int total;
    public long serverTime;
    /**
     * detailUrl : http://app.cntv.cn/special/news/detail/arti/index.html?id=ARTIxuMg3Yr9CoOLjFi4ZVh9161111&isfromapp=1
     * pubDate : 1478855363000
     * itemID : ARTIxuMg3Yr9CoOLjFi4ZVh9161111
     * tagDesc :
     * allow_praise : 1
     * itemType : article_flag
     * videoPlayID :
     * photoCount :
     * commentNum :
     * allow_share : 1
     * num : 1
     * videoLength :
     * allow_comment : 1
     * itemTitle : “郑和舰”海军学员进入任职岗位综合训练阶段
     * itemImage : {"imgUrl1":"http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116413268796.jpg","imgUrl3":"","imgUrl2":""}
     * brief :
     * tagColor :
     */

    public List<ItemListBean> itemList;

    public static Timeline objectFromData(String str) {

        return new Gson().fromJson(str, Timeline.class);
    }

    public static Timeline objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Timeline.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class ItemListBean {
        public String detailUrl;
        public long pubDate;
        public String itemID;
        public String tagDesc;
        public String allow_praise;
        public String itemType;
        public String videoPlayID;
        public String photoCount;
        public String commentNum;
        public String allow_share;
        public String num;
        public String videoLength;
        public String allow_comment;
        public String itemTitle;
        /**
         * imgUrl1 : http://p1.img.cctvpic.com/photoworkspace/2016/11/11/2016111116413268796.jpg
         * imgUrl3 :
         * imgUrl2 :
         */

        public ItemImageBean itemImage;
        public String brief;
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
}
