package B2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f17332a;

    public /* synthetic */ b(ImageView imageView) {
        this.f17332a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c.f(this.f17332a, valueAnimator);
    }
}
