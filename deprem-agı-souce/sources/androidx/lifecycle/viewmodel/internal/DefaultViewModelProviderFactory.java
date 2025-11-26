package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import j3.C2582a;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class DefaultViewModelProviderFactory implements ViewModelProvider.Factory {
    public static final DefaultViewModelProviderFactory INSTANCE = new DefaultViewModelProviderFactory();

    private DefaultViewModelProviderFactory() {
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return y.a(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public <T extends ViewModel> T create(C2733c cVar, CreationExtras creationExtras) {
        t.e(cVar, "modelClass");
        t.e(creationExtras, "extras");
        return JvmViewModelProviders.INSTANCE.createViewModel(C2582a.a(cVar));
    }
}
