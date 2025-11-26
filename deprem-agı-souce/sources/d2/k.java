package D2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f18018a;

    public /* synthetic */ k(ImageView imageView) {
        this.f18018a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        n.m(this.f18018a, valueAnimator);
    }
}
