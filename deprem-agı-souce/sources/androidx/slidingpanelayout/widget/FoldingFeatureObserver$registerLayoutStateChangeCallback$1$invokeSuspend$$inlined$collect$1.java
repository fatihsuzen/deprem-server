package androidx.slidingpanelayout.widget;

import W2.J;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.FoldingFeature;
import b3.C2308e;
import c3.C2316b;
import z3.C2973f;

public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 implements C2973f {
    final /* synthetic */ FoldingFeatureObserver this$0;

    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1(FoldingFeatureObserver foldingFeatureObserver) {
        this.this$0 = foldingFeatureObserver;
    }

    public Object emit(FoldingFeature foldingFeature, C2308e eVar) {
        J j5;
        FoldingFeature foldingFeature2 = foldingFeature;
        FoldingFeatureObserver.OnFoldingFeatureChangeListener access$getOnFoldingFeatureChangeListener$p = this.this$0.onFoldingFeatureChangeListener;
        if (access$getOnFoldingFeatureChangeListener$p == null) {
            j5 = null;
        } else {
            access$getOnFoldingFeatureChangeListener$p.onFoldingFeatureChange(foldingFeature2);
            j5 = J.f19942a;
        }
        if (j5 == C2316b.f()) {
            return j5;
        }
        return J.f19942a;
    }
}
