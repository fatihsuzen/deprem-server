package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import l0.h;

final class X3 implements U3 {

    /* renamed from: d  reason: collision with root package name */
    private static X3 f5212d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f5213a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentObserver f5214b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5215c;

    private X3() {
        this.f5215c = false;
        this.f5213a = null;
        this.f5214b = null;
    }

    static X3 b(Context context) {
        X3 x32;
        X3 x33;
        synchronized (X3.class) {
            try {
                if (f5212d == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        x33 = new X3(context);
                    } else {
                        x33 = new X3();
                    }
                    f5212d = x33;
                }
                X3 x34 = f5212d;
                if (!(x34 == null || x34.f5214b == null || x34.f5215c)) {
                    context.getContentResolver().registerContentObserver(E3.f4940a, true, f5212d.f5214b);
                    ((X3) h.h(f5212d)).f5215c = true;
                }
            } catch (SecurityException e5) {
                Log.e("GservicesLoader", "Unable to register Gservices content observer", e5);
            } catch (Throwable th) {
                throw th;
            }
            x32 = (X3) h.h(f5212d);
        }
        return x32;
    }

    static synchronized void d() {
        Context context;
        synchronized (X3.class) {
            try {
                X3 x32 = f5212d;
                if (!(x32 == null || (context = x32.f5213a) == null || x32.f5214b == null || !x32.f5215c)) {
                    context.getContentResolver().unregisterContentObserver(f5212d.f5214b);
                }
                f5212d = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: c */
    public final String a(String str) {
        Context context = this.f5213a;
        if (context != null && !L3.b(context)) {
            try {
                return (String) T3.a(new W3(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e5) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e5);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String e(String str) {
        return D3.a(((Context) h.h(this.f5213a)).getContentResolver(), str, (String) null);
    }

    private X3(Context context) {
        this.f5215c = false;
        this.f5213a = context;
        this.f5214b = new V3(this, (Handler) null);
    }
}
