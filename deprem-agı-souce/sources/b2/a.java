package B2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f17331a;

    public /* synthetic */ a(ImageView imageView) {
        this.f17331a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c.d(this.f17331a, valueAnimator);
    }
}
