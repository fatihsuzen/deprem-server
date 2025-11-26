package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

public final class FragmentViewModelLazyKt$viewModels$2 extends u implements C2616a {
    final /* synthetic */ C2616a $ownerProducer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$2(C2616a aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
        t.d(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
