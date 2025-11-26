package x0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import u0.g;

/* renamed from: x0.f  reason: case insensitive filesystem */
class C1910f {

    /* renamed from: a  reason: collision with root package name */
    private final Float f16857a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f16858b;

    private C1910f(Float f5, boolean z4) {
        this.f16858b = z4;
        this.f16857a = f5;
    }

    public static C1910f a(Context context) {
        boolean z4 = false;
        Float f5 = null;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z4 = e(registerReceiver);
                f5 = d(registerReceiver);
            }
        } catch (IllegalStateException e5) {
            g.f().e("An error occurred getting battery state.", e5);
        }
        return new C1910f(f5, z4);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == -1) {
            return false;
        }
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    public Float b() {
        return this.f16857a;
    }

    public int c() {
        Float f5;
        if (!this.f16858b || (f5 = this.f16857a) == null) {
            return 1;
        }
        if (((double) f5.floatValue()) < 0.99d) {
            return 2;
        }
        return 3;
    }
}
