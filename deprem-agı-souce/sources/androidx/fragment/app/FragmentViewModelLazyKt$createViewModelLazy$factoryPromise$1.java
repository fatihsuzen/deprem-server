package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends u implements C2616a {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        return this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
    }
}
