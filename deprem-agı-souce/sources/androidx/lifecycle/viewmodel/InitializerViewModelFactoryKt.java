package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import k3.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, l lVar) {
        t.e(initializerViewModelFactoryBuilder, "<this>");
        t.e(lVar, "initializer");
        t.k(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(M.b(ViewModel.class), lVar);
    }

    public static final ViewModelProvider.Factory viewModelFactory(l lVar) {
        t.e(lVar, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        lVar.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
