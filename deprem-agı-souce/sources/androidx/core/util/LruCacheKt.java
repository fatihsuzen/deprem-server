package androidx.core.util;

import android.util.LruCache;
import k3.l;
import k3.p;
import k3.r;

public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i5, p pVar, l lVar, r rVar) {
        return new LruCacheKt$lruCache$4(i5, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i5, p pVar, l lVar, r rVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            pVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i6 & 4) != 0) {
            lVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i6 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        return new LruCacheKt$lruCache$4(i5, pVar, lVar, rVar);
    }
}
