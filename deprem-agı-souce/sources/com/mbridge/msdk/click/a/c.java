package com.mbridge.msdk.click.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, b> f8095a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8096b;

    /* renamed from: c  reason: collision with root package name */
    private int f8097c;

    public c(int i5) {
        if (i5 > 0) {
            this.f8096b = i5;
            this.f8095a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final b a(String str) {
        if (str != null) {
            synchronized (this) {
                try {
                    b bVar = this.f8095a.get(str);
                    if (bVar != null) {
                        return bVar;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            throw new NullPointerException("key == null");
        }
    }

    public final void b(String str) {
        if (str != null) {
            synchronized (this) {
                try {
                    if (this.f8095a.remove(str) != null) {
                        this.f8097c--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.f8096b)});
    }

    public final boolean a(String str, b bVar) {
        if (str == null || bVar == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f8097c++;
                if (this.f8095a.put(str, bVar) != null) {
                    this.f8097c--;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        a(this.f8096b);
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        throw new java.lang.IllegalStateException(com.mbridge.msdk.click.a.c.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r3) {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            int r0 = r2.f8097c     // Catch:{ all -> 0x0012 }
            if (r0 < 0) goto L_0x0050
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f8095a     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            int r0 = r2.f8097c     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0050
            goto L_0x0014
        L_0x0012:
            r3 = move-exception
            goto L_0x006d
        L_0x0014:
            int r0 = r2.f8097c     // Catch:{ all -> 0x0012 }
            if (r0 <= r3) goto L_0x004e
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f8095a     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0021
            goto L_0x004e
        L_0x0021:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f8095a     // Catch:{ all -> 0x0012 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0012 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0012 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0012 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0035
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            goto L_0x004f
        L_0x0035:
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0012 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0012 }
            com.mbridge.msdk.click.a.b r0 = (com.mbridge.msdk.click.a.b) r0     // Catch:{ all -> 0x0012 }
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f8095a     // Catch:{ all -> 0x004c }
            r0.remove(r1)     // Catch:{ all -> 0x004c }
            int r0 = r2.f8097c     // Catch:{ all -> 0x004c }
            int r0 = r0 + -1
            r2.f8097c = r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            goto L_0x0000
        L_0x004e:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
        L_0x004f:
            return
        L_0x0050:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0012 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r0.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.Class<com.mbridge.msdk.click.a.c> r1 = com.mbridge.msdk.click.a.c.class
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0012 }
            r0.append(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0012 }
            r3.<init>(r0)     // Catch:{ all -> 0x0012 }
            throw r3     // Catch:{ all -> 0x0012 }
        L_0x006d:
            monitor-exit(r2)     // Catch:{ all -> 0x0012 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.c.a(int):void");
    }

    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f8095a.keySet());
        }
        return hashSet;
    }
}
