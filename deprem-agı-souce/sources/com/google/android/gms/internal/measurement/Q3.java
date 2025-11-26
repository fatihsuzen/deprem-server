package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.support.v4.media.a;
import android.util.Log;
import androidx.collection.ArrayMap;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import l0.h;

public final class Q3 implements U3 {

    /* renamed from: i  reason: collision with root package name */
    private static final ConcurrentMap f5140i = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f5141j = {"key", "value"};

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f5142a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f5143b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f5144c;

    /* renamed from: d  reason: collision with root package name */
    private ContentObserver f5145d = null;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f5146e = true;

    /* renamed from: f  reason: collision with root package name */
    private final Object f5147f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private volatile Map f5148g;

    /* renamed from: h  reason: collision with root package name */
    private final List f5149h = new ArrayList();

    private Q3(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        h.h(contentResolver);
        h.h(uri);
        this.f5142a = contentResolver;
        this.f5143b = uri;
        this.f5144c = runnable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        if (r3 == null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.Q3 b(android.content.ContentResolver r3, android.net.Uri r4, java.lang.Runnable r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x0014
            java.util.concurrent.ConcurrentMap r0 = f5140i
            com.google.android.gms.internal.measurement.P3 r1 = new com.google.android.gms.internal.measurement.P3
            r1.<init>(r3, r4, r5)
            java.lang.Object r3 = j$.util.concurrent.ConcurrentMap$EL.computeIfAbsent(r0, r4, r1)
            com.google.android.gms.internal.measurement.Q3 r3 = (com.google.android.gms.internal.measurement.Q3) r3
            goto L_0x002c
        L_0x0014:
            java.util.concurrent.ConcurrentMap r0 = f5140i
            java.lang.Object r1 = r0.get(r4)
            com.google.android.gms.internal.measurement.Q3 r1 = (com.google.android.gms.internal.measurement.Q3) r1
            if (r1 != 0) goto L_0x002b
            com.google.android.gms.internal.measurement.Q3 r1 = new com.google.android.gms.internal.measurement.Q3
            r1.<init>(r3, r4, r5)
            java.lang.Object r3 = r0.putIfAbsent(r4, r1)
            com.google.android.gms.internal.measurement.Q3 r3 = (com.google.android.gms.internal.measurement.Q3) r3
            if (r3 != 0) goto L_0x002c
        L_0x002b:
            r3 = r1
        L_0x002c:
            r4 = 0
            boolean r5 = r3.f5146e     // Catch:{ SecurityException -> 0x004f }
            if (r5 == 0) goto L_0x004e
            monitor-enter(r3)     // Catch:{ SecurityException -> 0x004f }
            boolean r5 = r3.f5146e     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x004a
            com.google.android.gms.internal.measurement.N3 r5 = new com.google.android.gms.internal.measurement.N3     // Catch:{ all -> 0x0048 }
            r5.<init>(r3, r4)     // Catch:{ all -> 0x0048 }
            android.content.ContentResolver r0 = r3.f5142a     // Catch:{ all -> 0x0048 }
            android.net.Uri r1 = r3.f5143b     // Catch:{ all -> 0x0048 }
            r2 = 0
            r0.registerContentObserver(r1, r2, r5)     // Catch:{ all -> 0x0048 }
            r3.f5145d = r5     // Catch:{ all -> 0x0048 }
            r3.f5146e = r2     // Catch:{ all -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            r5 = move-exception
            goto L_0x004c
        L_0x004a:
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            return r3
        L_0x004c:
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            throw r5     // Catch:{ SecurityException -> 0x004f }
        L_0x004e:
            return r3
        L_0x004f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Q3.b(android.content.ContentResolver, android.net.Uri, java.lang.Runnable):com.google.android.gms.internal.measurement.Q3");
    }

    static void e() {
        Iterator it = f5140i.values().iterator();
        while (it.hasNext()) {
            Q3 q32 = (Q3) it.next();
            synchronized (q32) {
                try {
                    if (q32.f5146e) {
                        q32.f5146e = false;
                    } else {
                        ContentObserver contentObserver = q32.f5145d;
                        if (contentObserver != null) {
                            q32.f5142a.unregisterContentObserver(contentObserver);
                            q32.f5145d = null;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            it.remove();
        }
    }

    static /* synthetic */ Q3 f(ContentResolver contentResolver, Uri uri, Runnable runnable, Uri uri2) {
        return new Q3(contentResolver, uri, runnable);
    }

    public final /* bridge */ /* synthetic */ Object a(String str) {
        return (String) c().get(str);
    }

    public final Map c() {
        Map map;
        Map map2 = this.f5148g;
        if (map2 == null) {
            synchronized (this.f5147f) {
                map2 = this.f5148g;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) T3.a(new O3(this));
                    } catch (SQLiteException | IllegalStateException | SecurityException e5) {
                        try {
                            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e5);
                            map = Collections.EMPTY_MAP;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    this.f5148g = map;
                    map2 = map;
                }
            }
        }
        if (map2 != null) {
            return map2;
        }
        return Collections.EMPTY_MAP;
    }

    public final void d() {
        synchronized (this.f5147f) {
            this.f5148g = null;
            this.f5144c.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f5149h.iterator();
                if (it.hasNext()) {
                    a.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map g() {
        Cursor query;
        Map map;
        Throwable th;
        ContentResolver contentResolver = this.f5142a;
        Uri uri = this.f5143b;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (acquireUnstableContentProviderClient == null) {
            Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
            return Collections.EMPTY_MAP;
        }
        try {
            query = acquireUnstableContentProviderClient.query(uri, f5141j, (String) null, (String[]) null, (String) null);
            if (query == null) {
                Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                Map map2 = Collections.EMPTY_MAP;
                acquireUnstableContentProviderClient.release();
                return map2;
            }
            int count = query.getCount();
            if (count == 0) {
                Map map3 = Collections.EMPTY_MAP;
                query.close();
                acquireUnstableContentProviderClient.release();
                return map3;
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            if (!query.isAfterLast()) {
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map map4 = Collections.EMPTY_MAP;
                query.close();
                acquireUnstableContentProviderClient.release();
                return map4;
            }
            query.close();
            acquireUnstableContentProviderClient.release();
            return map;
        } catch (RemoteException e5) {
            try {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e5);
                return Collections.EMPTY_MAP;
            } finally {
                acquireUnstableContentProviderClient.release();
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
