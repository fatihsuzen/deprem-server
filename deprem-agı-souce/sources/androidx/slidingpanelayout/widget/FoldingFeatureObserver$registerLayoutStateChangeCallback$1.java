package androidx.slidingpanelayout.widget;

import W2.J;
import W2.u;
import android.app.Activity;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import z3.C2972e;
import z3.C2974g;

@f(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends l implements p {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ FoldingFeatureObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver foldingFeatureObserver, Activity activity, C2308e eVar) {
        super(2, eVar);
        this.this$0 = foldingFeatureObserver;
        this.$activity = activity;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.this$0, this.$activity, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2972e j5 = C2974g.j(new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1(this.this$0.windowInfoTracker.windowLayoutInfo(this.$activity), this.this$0));
            FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 foldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 = new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1(this.this$0);
            this.label = 1;
            if (j5.collect(foldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
