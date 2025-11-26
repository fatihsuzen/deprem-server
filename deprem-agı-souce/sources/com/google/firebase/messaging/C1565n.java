package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.i;
import com.google.android.gms.common.util.k;
import java.util.concurrent.Executor;
import k0.C1698l;
import k0.C1701o;

/* renamed from: com.google.firebase.messaging.n  reason: case insensitive filesystem */
public class C1565n {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f7456c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static n0 f7457d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7458a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f7459b = new i();

    public C1565n(Context context) {
        this.f7458a = context;
    }

    public static /* synthetic */ C1698l a(Context context, Intent intent, boolean z4, C1698l lVar) {
        if (!k.e() || ((Integer) lVar.j()).intValue() != 402) {
            return lVar;
        }
        return e(context, intent, z4).g(new i(), new C1563l());
    }

    public static /* synthetic */ Integer c(C1698l lVar) {
        return -1;
    }

    public static /* synthetic */ Integer d(C1698l lVar) {
        return 403;
    }

    private static C1698l e(Context context, Intent intent, boolean z4) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        n0 f5 = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z4) {
            return f5.d(intent).g(new i(), new C1564m());
        }
        if (X.b().e(context)) {
            i0.e(context, f5, intent);
        } else {
            f5.d(intent);
        }
        return C1701o.e(-1);
    }

    private static n0 f(Context context, String str) {
        n0 n0Var;
        synchronized (f7456c) {
            try {
                if (f7457d == null) {
                    f7457d = new n0(context, str);
                }
                n0Var = f7457d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n0Var;
    }

    public C1698l g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f7458a, intent);
    }

    public C1698l h(Context context, Intent intent) {
        boolean z4;
        boolean z5 = false;
        if (!k.e() || context.getApplicationInfo().targetSdkVersion < 26) {
            z4 = false;
        } else {
            z4 = true;
        }
        if ((intent.getFlags() & 268435456) != 0) {
            z5 = true;
        }
        if (!z4 || z5) {
            return C1701o.c(this.f7459b, new C1561j(context, intent)).h(this.f7459b, new C1562k(context, intent, z5));
        }
        return e(context, intent, z5);
    }
}
