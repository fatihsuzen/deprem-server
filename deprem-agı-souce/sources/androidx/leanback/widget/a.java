package androidx.leanback.widget;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchOrbView f372a;

    public /* synthetic */ a(SearchOrbView searchOrbView) {
        this.f372a = searchOrbView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchOrbView.b(this.f372a, valueAnimator);
    }
}
