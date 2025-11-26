package androidx.activity;

import W2.J;
import W2.u;
import android.view.View;
import b3.C2308e;
import c3.C2316b;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import y3.t;
import y3.v;

@f(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {85}, m = "invokeSuspend")
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends l implements p {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, C2308e eVar) {
        super(2, eVar);
        this.$view = view;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(v vVar, View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        if (i5 != i9 || i7 != i11 || i6 != i10 || i8 != i12) {
            vVar.r(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(v vVar, View view) {
        vVar.r(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
    }

    public final C2308e create(Object obj, C2308e eVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, eVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            v vVar = (v) this.L$0;
            final l lVar = new l(vVar);
            final m mVar = new m(vVar, this.$view);
            final PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(vVar, this.$view, mVar, lVar);
            if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view)) {
                vVar.r(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(mVar);
                this.$view.addOnLayoutChangeListener(lVar);
            }
            this.$view.addOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
            final View view = this.$view;
            AnonymousClass1 r5 = new C2616a() {
                public final void invoke() {
                    view.getViewTreeObserver().removeOnScrollChangedListener(mVar);
                    view.removeOnLayoutChangeListener(lVar);
                    view.removeOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
                }
            };
            this.label = 1;
            if (t.a(vVar, r5, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(v vVar, C2308e eVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(vVar, eVar)).invokeSuspend(J.f19942a);
    }
}
