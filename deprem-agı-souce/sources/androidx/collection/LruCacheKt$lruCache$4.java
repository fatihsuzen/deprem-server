package androidx.collection;

import k3.l;
import k3.p;
import k3.r;
import kotlin.jvm.internal.t;

public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i5, p pVar, l lVar, r rVar) {
        super(i5);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
    }

    /* access modifiers changed from: protected */
    public V create(K k5) {
        t.e(k5, "key");
        return this.$create.invoke(k5);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z4, K k5, V v5, V v6) {
        t.e(k5, "key");
        t.e(v5, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z4), k5, v5, v6);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k5, V v5) {
        t.e(k5, "key");
        t.e(v5, "value");
        return ((Number) this.$sizeOf.invoke(k5, v5)).intValue();
    }
}
