package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

public final class FragmentViewModelLazyKt$activityViewModels$2 extends u implements C2616a {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        t.d(requireActivity, "requireActivity()");
        return requireActivity.getDefaultViewModelProviderFactory();
    }
}
