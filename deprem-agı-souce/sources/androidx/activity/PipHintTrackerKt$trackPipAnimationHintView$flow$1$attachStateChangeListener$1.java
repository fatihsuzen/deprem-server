package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import y3.v;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ v $$this$callbackFlow;
    final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
    final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
    final /* synthetic */ View $view;

    PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(v vVar, View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener) {
        this.$$this$callbackFlow = vVar;
        this.$view = view;
        this.$scrollChangeListener = onScrollChangedListener;
        this.$layoutChangeListener = onLayoutChangeListener;
    }

    public void onViewAttachedToWindow(View view) {
        this.$$this$callbackFlow.r(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(this.$scrollChangeListener);
        this.$view.addOnLayoutChangeListener(this.$layoutChangeListener);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
        view.removeOnLayoutChangeListener(this.$layoutChangeListener);
    }
}
