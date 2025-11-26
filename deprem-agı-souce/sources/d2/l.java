package D2;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class l implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f18019a;

    public /* synthetic */ l(View view) {
        this.f18019a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        n.e(this.f18019a, valueAnimator);
    }
}
