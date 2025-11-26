package com.mbridge.msdk.foundation.same.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.v;

public class NetWorkChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction()) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            v.a().c();
        }
    }
}
