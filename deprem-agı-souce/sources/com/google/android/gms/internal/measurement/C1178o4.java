package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v4.media.a;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l0.h;

/* renamed from: com.google.android.gms.internal.measurement.o4  reason: case insensitive filesystem */
public final class C1178o4 implements U3 {

    /* renamed from: f  reason: collision with root package name */
    private static final Map f5501f = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f5502a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f5503b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5504c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private volatile Map f5505d;

    /* renamed from: e  reason: collision with root package name */
    private final List f5506e = new ArrayList();

    private C1178o4(SharedPreferences sharedPreferences, Runnable runnable) {
        this.f5502a = sharedPreferences;
    }

    static C1178o4 b(Context context, String str, Runnable runnable) {
        C1178o4 o4Var;
        SharedPreferences a5;
        if (L3.a() && !str.startsWith("direct_boot:") && !L3.c(context)) {
            return null;
        }
        synchronized (C1178o4.class) {
            Map map = f5501f;
            o4Var = (C1178o4) map.get(str);
            if (o4Var == null) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    if (str.startsWith("direct_boot:")) {
                        if (L3.a()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        a5 = C1147l0.a(context, str.substring(12), 0, C1111h0.f5365a);
                    } else {
                        a5 = C1147l0.a(context, str, 0, C1111h0.f5365a);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    o4Var = new C1178o4(a5, runnable);
                    C1169n4 n4Var = new C1169n4(o4Var);
                    o4Var.f5503b = n4Var;
                    o4Var.f5502a.registerOnSharedPreferenceChangeListener(n4Var);
                    map.put(str, o4Var);
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th;
                }
            }
        }
        return o4Var;
    }

    static synchronized void c() {
        synchronized (C1178o4.class) {
            try {
                Map map = f5501f;
                for (C1178o4 o4Var : map.values()) {
                    o4Var.f5502a.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) h.h(o4Var.f5503b));
                }
                map.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final Object a(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Map<String, ?> map = this.f5505d;
        if (map == null) {
            synchronized (this.f5504c) {
                try {
                    map = this.f5505d;
                    if (map == null) {
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        Map<String, ?> all = this.f5502a.getAll();
                        this.f5505d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f5504c) {
            this.f5505d = null;
            C1160m4.c();
        }
        synchronized (this) {
            try {
                Iterator it = this.f5506e.iterator();
                if (it.hasNext()) {
                    a.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
