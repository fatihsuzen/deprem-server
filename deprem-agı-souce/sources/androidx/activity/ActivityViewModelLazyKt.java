package androidx.activity;

import W2.C2223l;
import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class ActivityViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> C2223l viewModels(ComponentActivity componentActivity, C2616a aVar) {
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        t.k(4, "VM");
        return new ViewModelLazy(M.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), aVar, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    public static /* synthetic */ C2223l viewModels$default(ComponentActivity componentActivity, C2616a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        t.k(4, "VM");
        return new ViewModelLazy(M.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), aVar, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> C2223l viewModels(ComponentActivity componentActivity, C2616a aVar, C2616a aVar2) {
        if (aVar2 == null) {
            aVar2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        t.k(4, "VM");
        return new ViewModelLazy(M.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), aVar2, new ActivityViewModelLazyKt$viewModels$4(aVar, componentActivity));
    }

    public static /* synthetic */ C2223l viewModels$default(ComponentActivity componentActivity, C2616a aVar, C2616a aVar2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            aVar = null;
        }
        if ((i5 & 2) != 0) {
            aVar2 = null;
        }
        if (aVar2 == null) {
            aVar2 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        t.k(4, "VM");
        return new ViewModelLazy(M.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), aVar2, new ActivityViewModelLazyKt$viewModels$4(aVar, componentActivity));
    }
}
