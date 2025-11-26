package androidx.leanback.widget;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchOrbView f373a;

    public /* synthetic */ b(SearchOrbView searchOrbView) {
        this.f373a = searchOrbView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchOrbView.a(this.f373a, valueAnimator);
    }
}
