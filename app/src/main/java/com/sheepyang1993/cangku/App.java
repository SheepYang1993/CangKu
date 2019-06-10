package com.sheepyang1993.cangku;

import android.app.Application;

import com.sheepyang1993.cangku.utils.ChannelUtil;
import com.sheepyang1993.sheepbmob.SheepBmob;
import com.sheepyang1993.sheepcommon.SheepCommon;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/10 10:12
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SheepCommon.init(this, ChannelUtil.getChannel(),
                Constants.BUGLY_APP_ID, Constants.UMENG_APP_KEY);
        SheepBmob.init(this, Constants.BMOB_APP_ID);
    }
}
