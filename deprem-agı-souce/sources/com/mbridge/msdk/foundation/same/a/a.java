package com.mbridge.msdk.foundation.same.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, JSONObject> f9208a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9209b;

    /* renamed from: c  reason: collision with root package name */
    private int f9210c;

    public a(int i5) {
        if (i5 > 0) {
            this.f9209b = i5;
            this.f9208a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final boolean a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f9210c++;
                if (this.f9208a.put(str, jSONObject) != null) {
                    this.f9210c--;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        a(this.f9209b);
        return true;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.f9209b)});
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject;
        if (str != null) {
            synchronized (this) {
                jSONObject = this.f9208a.get(str);
            }
            return jSONObject;
        }
        throw new NullPointerException("key == null");
    }

    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f9208a.keySet());
        }
        return hashSet;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        throw new java.lang.IllegalStateException(com.mbridge.msdk.foundation.same.a.a.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r3) {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            int r0 = r2.f9210c     // Catch:{ all -> 0x0012 }
            if (r0 < 0) goto L_0x0053
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f9208a     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            int r0 = r2.f9210c     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0053
            goto L_0x0014
        L_0x0012:
            r3 = move-exception
            goto L_0x0070
        L_0x0014:
            int r0 = r2.f9210c     // Catch:{ all -> 0x0012 }
            if (r0 <= r3) goto L_0x0051
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f9208a     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0051
        L_0x0021:
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f9208a     // Catch:{ all -> 0x0012 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0012 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0012 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0012 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0035
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            goto L_0x0052
        L_0x0035:
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0012 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0012 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x0012 }
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f9208a     // Catch:{ all -> 0x004f }
            java.lang.Object r0 = r0.remove(r1)     // Catch:{ all -> 0x004f }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x004f }
            int r0 = r2.f9210c     // Catch:{ all -> 0x004f }
            int r0 = r0 + -1
            r2.f9210c = r0     // Catch:{ all -> 0x004f }
        L_0x004f:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            goto L_0x0000
        L_0x0051:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
        L_0x0052:
            return
        L_0x0053:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0012 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r0.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.Class<com.mbridge.msdk.foundation.same.a.a> r1 = com.mbridge.msdk.foundation.same.a.a.class
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0012 }
            r0.append(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0012 }
            r3.<init>(r0)     // Catch:{ all -> 0x0012 }
            throw r3     // Catch:{ all -> 0x0012 }
        L_0x0070:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.a.a.a(int):void");
    }
}
