package androidx.work.impl.utils;

import W2.J;
import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class WakeLocks {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WakeLocks");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public static final void checkWakeLocks() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        WakeLocksHolder wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            linkedHashMap.putAll(wakeLocksHolder.getWakeLocks());
            J j5 = J.f19942a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.warning(str2, "WakeLock held for " + str);
            }
        }
    }

    public static final PowerManager.WakeLock newWakeLock(Context context, String str) {
        t.e(context, "context");
        t.e(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        t.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, str2);
        WakeLocksHolder wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            String put = wakeLocksHolder.getWakeLocks().put(newWakeLock, str2);
        }
        t.b(newWakeLock);
        return newWakeLock;
    }
}
