package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import j3.C2582a;
import kotlin.jvm.internal.t;
import r3.C2733c;

public abstract /* synthetic */ class y {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, Class cls) {
        t.e(cls, "modelClass");
        return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel_release();
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        t.e(cls, "modelClass");
        t.e(creationExtras, "extras");
        return factory.create(cls);
    }

    public static ViewModel c(ViewModelProvider.Factory factory, C2733c cVar, CreationExtras creationExtras) {
        t.e(cVar, "modelClass");
        t.e(creationExtras, "extras");
        return factory.create(C2582a.a(cVar), creationExtras);
    }

    public static ViewModelProvider.Factory d(ViewModelInitializer... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
