package x1;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import u1.n;

public class j {

    /* renamed from: d  reason: collision with root package name */
    private static j f16996d = new j();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f16997a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f16998b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f16999c = false;

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            j jVar;
            boolean d5;
            boolean z4;
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                jVar = j.this;
                d5 = jVar.f16999c;
                z4 = true;
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                jVar = j.this;
                d5 = jVar.f16999c;
                z4 = false;
            } else {
                return;
            }
            jVar.c(z4, d5);
            boolean unused = j.this.f16998b = z4;
        }
    }

    public static j f() {
        return f16996d;
    }

    public void a() {
        Context context = (Context) this.f16997a.get();
        if (context != null) {
            boolean isDeviceLocked = ((KeyguardManager) context.getSystemService("keyguard")).isDeviceLocked();
            c(this.f16998b, isDeviceLocked);
            this.f16999c = isDeviceLocked;
        }
    }

    public void b(Context context) {
        if (context != null) {
            this.f16997a = new WeakReference(context);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            context.registerReceiver(new a(), intentFilter);
        }
    }

    public void c(boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8;
        if (z5 || z4) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.f16999c || this.f16998b) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z6 != z7) {
            for (n t5 : c.e().c()) {
                z1.a t6 = t5.t();
                if (z5 || z4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                t6.q(z8);
            }
        }
    }
}
