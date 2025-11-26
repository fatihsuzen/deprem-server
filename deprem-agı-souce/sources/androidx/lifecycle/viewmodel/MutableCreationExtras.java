package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (C2633k) null);
    }

    public <T> T get(CreationExtras.Key<T> key) {
        t.e(key, "key");
        return getExtras$lifecycle_viewmodel_release().get(key);
    }

    public final <T> void set(CreationExtras.Key<T> key, T t5) {
        t.e(key, "key");
        getExtras$lifecycle_viewmodel_release().put(key, t5);
    }

    public MutableCreationExtras(Map<CreationExtras.Key<?>, ? extends Object> map) {
        t.e(map, "initialExtras");
        getExtras$lifecycle_viewmodel_release().putAll(map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MutableCreationExtras(CreationExtras creationExtras) {
        this((Map<CreationExtras.Key<?>, ? extends Object>) creationExtras.getExtras$lifecycle_viewmodel_release());
        t.e(creationExtras, "initialExtras");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
