package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import j3.C2582a;
import k3.l;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class ViewModelInitializer<T extends ViewModel> {
    private final C2733c clazz;
    private final l initializer;

    public ViewModelInitializer(C2733c cVar, l lVar) {
        t.e(cVar, "clazz");
        t.e(lVar, "initializer");
        this.clazz = cVar;
        this.initializer = lVar;
    }

    public final C2733c getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelInitializer(Class<T> cls, l lVar) {
        this(C2582a.c(cls), lVar);
        t.e(cls, "clazz");
        t.e(lVar, "initializer");
    }
}
