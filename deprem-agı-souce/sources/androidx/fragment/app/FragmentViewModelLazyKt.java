package androidx.fragment.app;

import W2.C2223l;
import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class FragmentViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> C2223l activityViewModels(Fragment fragment, C2616a aVar) {
        t.e(fragment, "$this$activityViewModels");
        t.k(4, "VM");
        C2733c b5 = M.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b5, fragmentViewModelLazyKt$activityViewModels$1, aVar);
    }

    public static /* synthetic */ C2223l activityViewModels$default(Fragment fragment, C2616a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            aVar = null;
        }
        t.e(fragment, "$this$activityViewModels");
        t.k(4, "VM");
        C2733c b5 = M.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b5, fragmentViewModelLazyKt$activityViewModels$1, aVar);
    }

    @MainThread
    public static final <VM extends ViewModel> C2223l createViewModelLazy(Fragment fragment, C2733c cVar, C2616a aVar, C2616a aVar2) {
        t.e(fragment, "$this$createViewModelLazy");
        t.e(cVar, "viewModelClass");
        t.e(aVar, "storeProducer");
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(cVar, aVar, aVar2);
    }

    public static /* synthetic */ C2223l createViewModelLazy$default(Fragment fragment, C2733c cVar, C2616a aVar, C2616a aVar2, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, cVar, aVar, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> C2223l viewModels(Fragment fragment, C2616a aVar, C2616a aVar2) {
        t.e(fragment, "$this$viewModels");
        t.e(aVar, "ownerProducer");
        t.k(4, "VM");
        return createViewModelLazy(fragment, M.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(aVar), aVar2);
    }

    public static /* synthetic */ C2223l viewModels$default(Fragment fragment, C2616a aVar, C2616a aVar2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            aVar = new FragmentViewModelLazyKt$viewModels$1(fragment);
        }
        if ((i5 & 2) != 0) {
            aVar2 = null;
        }
        t.e(fragment, "$this$viewModels");
        t.e(aVar, "ownerProducer");
        t.k(4, "VM");
        return createViewModelLazy(fragment, M.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(aVar), aVar2);
    }
}
