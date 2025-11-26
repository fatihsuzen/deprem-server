package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class ViewModelProviderImpl {
    /* access modifiers changed from: private */
    public final CreationExtras defaultExtras;
    /* access modifiers changed from: private */
    public final ViewModelProvider.Factory factory;
    private final SynchronizedObject lock = new SynchronizedObject();
    /* access modifiers changed from: private */
    public final ViewModelStore store;

    public ViewModelProviderImpl(ViewModelStore viewModelStore, ViewModelProvider.Factory factory2, CreationExtras creationExtras) {
        t.e(viewModelStore, "store");
        t.e(factory2, "factory");
        t.e(creationExtras, "defaultExtras");
        this.store = viewModelStore;
        this.factory = factory2;
        this.defaultExtras = creationExtras;
    }

    public static /* synthetic */ ViewModel getViewModel$lifecycle_viewmodel_release$default(ViewModelProviderImpl viewModelProviderImpl, C2733c cVar, String str, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel_release(cVar);
        }
        return viewModelProviderImpl.getViewModel$lifecycle_viewmodel_release(cVar, str);
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel_release(C2733c cVar, String str) {
        T t5;
        t.e(cVar, "modelClass");
        t.e(str, "key");
        synchronized (this.lock) {
            try {
                t5 = this.store.get(str);
                if (cVar.f(t5)) {
                    if (this.factory instanceof ViewModelProvider.OnRequeryFactory) {
                        t.b(t5);
                        ((ViewModelProvider.OnRequeryFactory) this.factory).onRequery(t5);
                    }
                    t.c(t5, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultExtras);
                    mutableCreationExtras.set(ViewModelProvider.VIEW_MODEL_KEY, str);
                    t5 = ViewModelProviderImpl_androidKt.createViewModel(this.factory, cVar, mutableCreationExtras);
                    this.store.put(str, t5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }
}
