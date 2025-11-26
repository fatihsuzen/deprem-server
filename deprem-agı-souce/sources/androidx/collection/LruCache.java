package androidx.collection;

import W2.J;
import androidx.annotation.IntRange;
import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(@IntRange(from = 1, to = Long.MAX_VALUE) int i5) {
        this.maxSize = i5;
        if (i5 > 0) {
            this.map = new LruHashMap<>(0, 0.75f);
            this.lock = new Lock();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private final int safeSizeOf(K k5, V v5) {
        int sizeOf = sizeOf(k5, v5);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k5 + '=' + v5).toString());
    }

    /* access modifiers changed from: protected */
    public V create(K k5) {
        t.e(k5, "key");
        return null;
    }

    public final int createCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.createCount;
        }
        return i5;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z4, K k5, V v5, V v6) {
        t.e(k5, "key");
        t.e(v5, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.evictionCount;
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r0 = create(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r0 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r1 = r5.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5.createCount++;
        r2 = r5.map.put(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r2 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r5.map.put(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        r5.size += safeSizeOf(r6, r0);
        r3 = W2.J.f19942a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r2 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        entryRemoved(false, r6, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
        trimToSize(r5.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005c, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r6) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.t.e(r6, r0)
            androidx.collection.internal.Lock r0 = r5.lock
            monitor-enter(r0)
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x001a
            int r6 = r5.hitCount     // Catch:{ all -> 0x0018 }
            int r6 = r6 + 1
            r5.hitCount = r6     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            return r1
        L_0x0018:
            r6 = move-exception
            goto L_0x005d
        L_0x001a:
            int r1 = r5.missCount     // Catch:{ all -> 0x0018 }
            int r1 = r1 + 1
            r5.missCount = r1     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            java.lang.Object r0 = r5.create(r6)
            if (r0 != 0) goto L_0x0029
            r6 = 0
            return r6
        L_0x0029:
            androidx.collection.internal.Lock r1 = r5.lock
            monitor-enter(r1)
            int r2 = r5.createCount     // Catch:{ all -> 0x0040 }
            int r2 = r2 + 1
            r5.createCount = r2     // Catch:{ all -> 0x0040 }
            androidx.collection.internal.LruHashMap<K, V> r2 = r5.map     // Catch:{ all -> 0x0040 }
            java.lang.Object r2 = r2.put(r6, r0)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0042
            androidx.collection.internal.LruHashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0040 }
            r3.put(r6, r2)     // Catch:{ all -> 0x0040 }
            goto L_0x004d
        L_0x0040:
            r6 = move-exception
            goto L_0x005b
        L_0x0042:
            int r3 = r5.size     // Catch:{ all -> 0x0040 }
            int r4 = r5.safeSizeOf(r6, r0)     // Catch:{ all -> 0x0040 }
            int r3 = r3 + r4
            r5.size = r3     // Catch:{ all -> 0x0040 }
            W2.J r3 = W2.J.f19942a     // Catch:{ all -> 0x0040 }
        L_0x004d:
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0055
            r1 = 0
            r5.entryRemoved(r1, r6, r0, r2)
            return r2
        L_0x0055:
            int r6 = r5.maxSize
            r5.trimToSize(r6)
            return r0
        L_0x005b:
            monitor-exit(r1)
            throw r6
        L_0x005d:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final int hitCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.hitCount;
        }
        return i5;
    }

    public final int maxSize() {
        int i5;
        synchronized (this.lock) {
            i5 = this.maxSize;
        }
        return i5;
    }

    public final int missCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.missCount;
        }
        return i5;
    }

    public final V put(K k5, V v5) {
        V put;
        t.e(k5, "key");
        t.e(v5, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += safeSizeOf(k5, v5);
                put = this.map.put(k5, v5);
                if (put != null) {
                    this.size -= safeSizeOf(k5, put);
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (put != null) {
            entryRemoved(false, k5, put, v5);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final int putCount() {
        int i5;
        synchronized (this.lock) {
            i5 = this.putCount;
        }
        return i5;
    }

    public final V remove(K k5) {
        V remove;
        t.e(k5, "key");
        synchronized (this.lock) {
            try {
                remove = this.map.remove(k5);
                if (remove != null) {
                    this.size -= safeSizeOf(k5, remove);
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (remove != null) {
            entryRemoved(false, k5, remove, (V) null);
        }
        return remove;
    }

    public void resize(@IntRange(from = 1, to = Long.MAX_VALUE) int i5) {
        if (i5 > 0) {
            synchronized (this.lock) {
                this.maxSize = i5;
                J j5 = J.f19942a;
            }
            trimToSize(i5);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int size() {
        int i5;
        synchronized (this.lock) {
            i5 = this.size;
        }
        return i5;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k5, V v5) {
        t.e(k5, "key");
        t.e(v5, "value");
        return 1;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            try {
                for (Map.Entry entry : this.map.getEntries()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        int i5;
        String str;
        synchronized (this.lock) {
            try {
                int i6 = this.hitCount;
                int i7 = this.missCount + i6;
                if (i7 != 0) {
                    i5 = (i6 * 100) / i7;
                } else {
                    i5 = 0;
                }
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i5 + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L_0x0000:
            androidx.collection.internal.Lock r0 = r5.lock
            monitor-enter(r0)
            int r1 = r5.size     // Catch:{ all -> 0x0014 }
            if (r1 < 0) goto L_0x0057
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0014 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0016
            int r1 = r5.size     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0057
            goto L_0x0016
        L_0x0014:
            r6 = move-exception
            goto L_0x005f
        L_0x0016:
            int r1 = r5.size     // Catch:{ all -> 0x0014 }
            if (r1 <= r6) goto L_0x0055
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0014 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0023
            goto L_0x0055
        L_0x0023:
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0014 }
            java.util.Set r1 = r1.getEntries()     // Catch:{ all -> 0x0014 }
            java.lang.Object r1 = X2.C2250q.N(r1)     // Catch:{ all -> 0x0014 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0033
            monitor-exit(r0)
            return
        L_0x0033:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x0014 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0014 }
            androidx.collection.internal.LruHashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0014 }
            r3.remove(r2)     // Catch:{ all -> 0x0014 }
            int r3 = r5.size     // Catch:{ all -> 0x0014 }
            int r4 = r5.safeSizeOf(r2, r1)     // Catch:{ all -> 0x0014 }
            int r3 = r3 - r4
            r5.size = r3     // Catch:{ all -> 0x0014 }
            int r3 = r5.evictionCount     // Catch:{ all -> 0x0014 }
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)
            r0 = 0
            r5.entryRemoved(r4, r2, r1, r0)
            goto L_0x0000
        L_0x0055:
            monitor-exit(r0)
            return
        L_0x0057:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            r1.<init>(r6)     // Catch:{ all -> 0x0014 }
            throw r1     // Catch:{ all -> 0x0014 }
        L_0x005f:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
