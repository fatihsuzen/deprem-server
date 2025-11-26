package com.uptodown.receivers;

import S1.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.UptodownApp;
import t3.s;
import z2.M;

public final class BootDeviceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && s.E(intent.getAction(), "android.intent.action.BOOT_COMPLETED", true) && context != null) {
                    UptodownApp.f13477F.n0(context);
                    M.f26506a.G(k.f32g.a(context));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
