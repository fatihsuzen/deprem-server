package M;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: M.I  reason: case insensitive filesystem */
public final class C0677I extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f2843a;

    /* renamed from: b  reason: collision with root package name */
    private final C0676H f2844b;

    public C0677I(C0676H h5) {
        this.f2844b = h5;
    }

    public final void a(Context context) {
        this.f2843a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f2843a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f2843a = null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        } else {
            str = null;
        }
        if ("com.google.android.gms".equals(str)) {
            this.f2844b.a();
            b();
        }
    }
}
