package com.mobile.base.openapi;

import android.content.Context;
import android.util.Log;

/**
 * User: 孙伟力
 * Date: 15/10/23
 * Time: 上午10:15
 */
public abstract class BaseCommand {
    private final static String TAG = "OPEN_API";
    public IBaseRequest baseRequest;

    public abstract void exec(Context context);

    public abstract boolean checkParams();

    public void setBaseRequest(IBaseRequest req) {
        this.baseRequest = req;
    }

    public void execute(Context context) {
        if (baseRequest == null) {
            Log.d(TAG, "request is null");
            return;
        }

        if (!checkParams()) {
            Log.d(TAG, "open api params is error");
            return;
        }

        exec(context);
    }
}
