package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public final class SimpleCache implements Cache {
    private static final String TAG = "SimpleCache";
    private static boolean cacheFolderLockingDisabled;
    private static final HashSet<File> lockedCacheDirs = new HashSet<>();
    private final File cacheDir;
    /* access modifiers changed from: private */
    public final CacheEvictor evictor;
    private final CachedContentIndex index;
    private final HashMap<String, ArrayList<Cache.Listener>> listeners;
    private boolean released;
    private long totalSpace;

    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, (byte[]) null, false);
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.index.getOrAdd(simpleCacheSpan.key).addSpan(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        notifySpanAdded(simpleCacheSpan);
    }

    @Deprecated
    public static synchronized void disableCacheFolderLocking() {
        synchronized (SimpleCache.class) {
            cacheFolderLockingDisabled = true;
            lockedCacheDirs.clear();
        }
    }

    private SimpleCacheSpan getSpan(String str, long j5) throws Cache.CacheException {
        SimpleCacheSpan span;
        CachedContent cachedContent = this.index.get(str);
        if (cachedContent == null) {
            return SimpleCacheSpan.createOpenHole(str, j5);
        }
        while (true) {
            span = cachedContent.getSpan(j5);
            if (!span.isCached || span.file.exists()) {
                return span;
            }
            removeStaleSpansAndCachedContents();
        }
        return span;
    }

    /* access modifiers changed from: private */
    public void initialize() {
        SimpleCacheSpan simpleCacheSpan;
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
            return;
        }
        this.index.load();
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.getName().equals(CachedContentIndex.FILE_NAME)) {
                    if (file.length() > 0) {
                        simpleCacheSpan = SimpleCacheSpan.createCacheEntry(file, this.index);
                    } else {
                        simpleCacheSpan = null;
                    }
                    if (simpleCacheSpan != null) {
                        addSpan(simpleCacheSpan);
                    } else {
                        file.delete();
                    }
                }
            }
            this.index.removeEmpty();
            try {
                this.index.store();
            } catch (Cache.CacheException e5) {
                Log.e(TAG, "Storing index file failed", e5);
            }
        }
    }

    public static synchronized boolean isCacheFolderLocked(File file) {
        boolean contains;
        synchronized (SimpleCache.class) {
            contains = lockedCacheDirs.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    private static synchronized boolean lockFolder(File file) {
        synchronized (SimpleCache.class) {
            if (cacheFolderLockingDisabled) {
                return true;
            }
            boolean add = lockedCacheDirs.add(file.getAbsoluteFile());
            return add;
        }
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    private void removeStaleSpansAndCachedContents() throws Cache.CacheException {
        ArrayList arrayList = new ArrayList();
        for (CachedContent spans : this.index.getAll()) {
            Iterator<SimpleCacheSpan> it = spans.getSpans().iterator();
            while (it.hasNext()) {
                CacheSpan next = it.next();
                if (!next.file.exists()) {
                    arrayList.add(next);
                }
            }
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            removeSpan((CacheSpan) arrayList.get(i5), false);
        }
        this.index.removeEmpty();
        this.index.store();
    }

    private static synchronized void unlockFolder(File file) {
        synchronized (SimpleCache.class) {
            if (!cacheFolderLockingDisabled) {
                lockedCacheDirs.remove(file.getAbsoluteFile());
            }
        }
    }

    public final synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        try {
            Assertions.checkState(!this.released);
            ArrayList arrayList = this.listeners.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.listeners.put(str, arrayList);
            }
            arrayList.add(listener);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return getCachedSpans(str);
    }

    public final synchronized void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        Assertions.checkState(!this.released);
        this.index.applyContentMetadataMutations(str, contentMetadataMutations);
        this.index.store();
    }

    public final synchronized void commitFile(File file) throws Cache.CacheException {
        boolean z4;
        boolean z5 = true;
        Assertions.checkState(!this.released);
        SimpleCacheSpan createCacheEntry = SimpleCacheSpan.createCacheEntry(file, this.index);
        if (createCacheEntry != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        CachedContent cachedContent = this.index.get(createCacheEntry.key);
        Assertions.checkNotNull(cachedContent);
        Assertions.checkState(cachedContent.isLocked());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long contentLength = ContentMetadataInternal.getContentLength(cachedContent.getMetadata());
            if (contentLength != -1) {
                if (createCacheEntry.position + createCacheEntry.length > contentLength) {
                    z5 = false;
                }
                Assertions.checkState(z5);
            }
            addSpan(createCacheEntry);
            this.index.store();
            notifyAll();
        }
    }

    public final synchronized long getCacheSpace() {
        Assertions.checkState(!this.released);
        return this.totalSpace;
    }

    public final synchronized long getCachedLength(String str, long j5, long j6) {
        long j7;
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.index.get(str);
        if (cachedContent != null) {
            j7 = cachedContent.getCachedBytesLength(j5, j6);
        } else {
            j7 = -j6;
        }
        return j7;
    }

    @NonNull
    public final synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        TreeSet treeSet;
        try {
            Assertions.checkState(!this.released);
            CachedContent cachedContent = this.index.get(str);
            if (cachedContent != null) {
                if (!cachedContent.isEmpty()) {
                    treeSet = new TreeSet(cachedContent.getSpans());
                }
            }
            treeSet = new TreeSet();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return treeSet;
    }

    public final synchronized long getContentLength(String str) {
        return ContentMetadataInternal.getContentLength(getContentMetadata(str));
    }

    public final synchronized ContentMetadata getContentMetadata(String str) {
        Assertions.checkState(!this.released);
        return this.index.getContentMetadata(str);
    }

    public final synchronized Set<String> getKeys() {
        Assertions.checkState(!this.released);
        return new HashSet(this.index.getKeys());
    }

    public final synchronized boolean isCached(String str, long j5, long j6) {
        boolean z4;
        z4 = true;
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.index.get(str);
        if (cachedContent == null || cachedContent.getCachedBytesLength(j5, j6) < j6) {
            z4 = false;
        }
        return z4;
    }

    public final synchronized void release() throws Cache.CacheException {
        if (!this.released) {
            this.listeners.clear();
            try {
                removeStaleSpansAndCachedContents();
            } finally {
                unlockFolder(this.cacheDir);
                this.released = true;
            }
        }
    }

    public final synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.index.get(cacheSpan.key);
        Assertions.checkNotNull(cachedContent);
        Assertions.checkState(cachedContent.isLocked());
        cachedContent.setLocked(false);
        this.index.maybeRemove(cachedContent.key);
        notifyAll();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void removeListener(java.lang.String r2, com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache.Listener r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.released     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache$Listener>> r0 = r1.listeners     // Catch:{ all -> 0x0020 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0020 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0022
            r0.remove(r3)     // Catch:{ all -> 0x0020 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0022
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache$Listener>> r3 = r1.listeners     // Catch:{ all -> 0x0020 }
            r3.remove(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x0022
        L_0x0020:
            r2 = move-exception
            goto L_0x0024
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.SimpleCache.removeListener(java.lang.String, com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache$Listener):void");
    }

    public final synchronized void removeSpan(CacheSpan cacheSpan) throws Cache.CacheException {
        Assertions.checkState(!this.released);
        removeSpan(cacheSpan, true);
    }

    public final synchronized void setContentLength(String str, long j5) throws Cache.CacheException {
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        ContentMetadataInternal.setContentLength(contentMetadataMutations, j5);
        applyContentMetadataMutations(str, contentMetadataMutations);
    }

    public final synchronized File startFile(String str, long j5, long j6) throws Cache.CacheException {
        Throwable th;
        try {
            Assertions.checkState(!this.released);
            CachedContent cachedContent = this.index.get(str);
            Assertions.checkNotNull(cachedContent);
            Assertions.checkState(cachedContent.isLocked());
            if (!this.cacheDir.exists()) {
                try {
                    this.cacheDir.mkdirs();
                    removeStaleSpansAndCachedContents();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            long j7 = j5;
            try {
                this.evictor.onStartFile(this, str, j7, j6);
                long j8 = j7;
                return SimpleCacheSpan.getCacheFile(this.cacheDir, cachedContent.id, j8, System.currentTimeMillis());
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    public final synchronized SimpleCacheSpan startReadWrite(String str, long j5) throws InterruptedException, Cache.CacheException {
        SimpleCacheSpan startReadWriteNonBlocking;
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j5);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    public final synchronized SimpleCacheSpan startReadWriteNonBlocking(String str, long j5) throws Cache.CacheException {
        Assertions.checkState(!this.released);
        SimpleCacheSpan span = getSpan(str, j5);
        if (span.isCached) {
            SimpleCacheSpan simpleCacheSpan = this.index.get(str).touch(span);
            notifySpanTouched(span, simpleCacheSpan);
            return simpleCacheSpan;
        }
        CachedContent orAdd = this.index.getOrAdd(str);
        if (orAdd.isLocked()) {
            return null;
        }
        orAdd.setLocked(true);
        return span;
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr, boolean z4) {
        this(file, cacheEvictor, new CachedContentIndex(file, bArr, z4));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex) {
        if (lockFolder(file)) {
            this.cacheDir = file;
            this.evictor = cacheEvictor;
            this.index = cachedContentIndex;
            this.listeners = new HashMap<>();
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("SimpleCache.initialize()") {
                public void run() {
                    synchronized (SimpleCache.this) {
                        conditionVariable.open();
                        SimpleCache.this.initialize();
                        SimpleCache.this.evictor.onCacheInitialized();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }

    private void removeSpan(CacheSpan cacheSpan, boolean z4) throws Cache.CacheException {
        CachedContent cachedContent = this.index.get(cacheSpan.key);
        if (cachedContent != null && cachedContent.removeSpan(cacheSpan)) {
            this.totalSpace -= cacheSpan.length;
            if (z4) {
                try {
                    this.index.maybeRemove(cachedContent.key);
                    this.index.store();
                } catch (Throwable th) {
                    notifySpanRemoved(cacheSpan);
                    throw th;
                }
            }
            notifySpanRemoved(cacheSpan);
        }
    }
}
