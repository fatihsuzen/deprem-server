package androidx.activity;

import k3.C2616a;
import kotlin.jvm.internal.u;

public final class ActivityViewModelLazyKt$viewModels$4 extends u implements C2616a {
    final /* synthetic */ C2616a $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$4(C2616a aVar, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = aVar;
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            k3.a r0 = r1.$extrasProducer
            if (r0 == 0) goto L_0x000e
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            return r0
        L_0x000e:
            androidx.activity.ComponentActivity r0 = r1.$this_viewModels
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ActivityViewModelLazyKt$viewModels$4.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
