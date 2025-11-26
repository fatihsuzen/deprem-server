package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

public final class FragmentViewModelLazyKt$activityViewModels$1 extends u implements C2616a {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelStore invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        t.d(requireActivity, "requireActivity()");
        ViewModelStore viewModelStore = requireActivity.getViewModelStore();
        t.d(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
