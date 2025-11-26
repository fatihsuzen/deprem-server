package androidx.slidingpanelayout.widget;

import W2.J;
import b3.C2308e;
import c3.C2316b;
import z3.C2972e;
import z3.C2973f;

public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1 implements C2972e {
    final /* synthetic */ C2972e $this_unsafeTransform$inlined;
    final /* synthetic */ FoldingFeatureObserver this$0;

    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1(C2972e eVar, FoldingFeatureObserver foldingFeatureObserver) {
        this.$this_unsafeTransform$inlined = eVar;
        this.this$0 = foldingFeatureObserver;
    }

    public Object collect(final C2973f fVar, C2308e eVar) {
        C2972e eVar2 = this.$this_unsafeTransform$inlined;
        final FoldingFeatureObserver foldingFeatureObserver = this.this$0;
        Object collect = eVar2.collect(new C2973f() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r5, b3.C2308e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    W2.u.b(r6)
                    goto L_0x004a
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    W2.u.b(r6)
                    z3.f r6 = r4
                    androidx.window.layout.WindowLayoutInfo r5 = (androidx.window.layout.WindowLayoutInfo) r5
                    androidx.slidingpanelayout.widget.FoldingFeatureObserver r2 = r2
                    androidx.window.layout.FoldingFeature r5 = r2.getFoldingFeature(r5)
                    if (r5 != 0) goto L_0x0041
                    goto L_0x004a
                L_0x0041:
                    r0.label = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x004a
                    return r1
                L_0x004a:
                    W2.J r5 = W2.J.f19942a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, b3.e):java.lang.Object");
            }
        }, eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }
}
