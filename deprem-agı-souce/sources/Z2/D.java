package z2;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.os.PowerManager;
import android.view.Display;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;

public final class D {
    public final long a(Context context) {
        t.e(context, "context");
        return new E().h(context).getFreeSpace();
    }

    public final long b(Context context) {
        t.e(context, "context");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService("activity");
        t.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public final boolean c(Context context) {
        boolean z4;
        t.e(context, "context");
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra3 == 1 || intExtra3 == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (((int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f)) < 25 && !z4) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean d(Context context) {
        t.e(context, "context");
        Object systemService = context.getSystemService("power");
        t.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode();
    }

    public final boolean e(Context context) {
        t.e(context, "context");
        Object systemService = context.getSystemService("display");
        t.c(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Iterator a5 = C2625c.a(((DisplayManager) systemService).getDisplays());
        while (a5.hasNext()) {
            if (((Display) a5.next()).getState() != 1) {
                return true;
            }
        }
        return false;
    }

    public final long f(Context context) {
        t.e(context, "context");
        return new E().h(context).getTotalSpace();
    }

    public final long g(Context context) {
        t.e(context, "context");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService("activity");
        t.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }
}
