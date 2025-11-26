package androidx.activity;

import androidx.lifecycle.viewmodel.CreationExtras;
import k3.C2616a;
import kotlin.jvm.internal.u;

public final class ActivityViewModelLazyKt$viewModels$2 extends u implements C2616a {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final CreationExtras invoke() {
        return this.$this_viewModels.getDefaultViewModelCreationExtras();
    }
}
