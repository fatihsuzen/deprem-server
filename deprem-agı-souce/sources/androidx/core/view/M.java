package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class M implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f320a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f321b;

    public /* synthetic */ M(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f320a = viewPropertyAnimatorUpdateListener;
        this.f321b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f320a.onAnimationUpdate(this.f321b);
    }
}
