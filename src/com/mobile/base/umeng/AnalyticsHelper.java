package com.mobile.base.umeng;

import android.content.Context;
import android.widget.Toast;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Iterator;

/**
 * User: 孙伟力
 * Date: 15/10/27
 * Time: 上午11:58
 */
public class AnalyticsHelper {
    private static boolean enable = false;
    private static Context context;
    private static String TAG = "AnalyticsHelper";

    public static void init(Context ctx) {
        if(enable) {
            context = ctx;
            MobclickAgent.openActivityDurationTrack(false); //使用fragment的统计方式，详情见友盟官网相关文档
        }
    }

    /**
     * 添加友盟日志
     */
    public static void addEvent(IEvent event) {
        if (enable) {
            MobclickAgent.onEvent(context, event.getEventId());
        }
    }

    /**
     * 添加友盟统计,子事件分类,以参数归类,减少事件(友盟的事件有限制数量)
     *
     * @param event event;
     * @param key   参数键
     * @param value 参数值
     */
    public static void addEvent(IEvent event, String key, String value) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(key, value);
        addEvent(event, params);
    }

    public static void addEvent(IEvent event, HashMap<String, String> params) {
        if (enable) {
            MobclickAgent.onEvent(context, event.getEventId(), params);
        }
    }

    public static void onPageStart(String pageName) {
        if (enable) {
            MobclickAgent.onPageStart(pageName);
        }
    }

    public static void onPageEnd(String pageName) {
        if (enable) {
            MobclickAgent.onPageEnd(pageName);
        }
    }

    public static void onResume(Context ctx) {
        if (enable) {
            MobclickAgent.onResume(ctx);
        }
    }

    public static void onPause(Context ctx) {
        if (enable) {
            MobclickAgent.onPause(ctx);
        }
    }

    private static void printEventParams(IEvent event, HashMap<String, String> params) {
        String paramsInfo = "";
        if (params != null) {
            Iterator<String> it = params.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                String value = params.get(key);
                paramsInfo += " \n" + key + ":" + value;
            }
        }
        Toast.makeText(context, event.getEventId() + "_" + paramsInfo, Toast.LENGTH_SHORT).show();

    }

    public static class PageName {
        public static String HOME_PAGE_TAB1 = "首页-首页-tab";
        public static String HOME_PAGE_TAB2 = "首页-买车-tab";
        public static String HOME_PAGE_TAB3 = "首页-卖车-tab";
        public static String HOME_PAGE_TAB4 = "首页-我的-tab";
        public static String APP_SPLASH = "启动引导页";
//        public static String WX_PAGE = "微信入口页";
//        public static String WB_PAGE = "微博分享页";
        public static String H5_PAGE = "H5详情页";
        public static String SEARCH_PAGE = "检索页(首页-点击检索框)";
        //public static String DING_YUE_HAO_CHE_LIST = "订阅的好车列表";
    }
}
