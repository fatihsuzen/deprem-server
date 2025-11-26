package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import androidx.lifecycle.y;
import j3.C2582a;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        t.e(viewModelInitializerArr, "initializers");
        this.initializers = viewModelInitializerArr;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return y.a(this, cls);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public <VM extends ViewModel> VM create(Class<VM> cls, CreationExtras creationExtras) {
        t.e(cls, "modelClass");
        t.e(creationExtras, "extras");
        ViewModelProviders viewModelProviders = ViewModelProviders.INSTANCE;
        C2733c c5 = C2582a.c(cls);
        ViewModelInitializer<?>[] viewModelInitializerArr = this.initializers;
        return viewModelProviders.createViewModelFromInitializers$lifecycle_viewmodel_release(c5, creationExtras, (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
