package D2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f18020a;

    public /* synthetic */ m(ImageView imageView) {
        this.f18020a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        n.k(this.f18020a, valueAnimator);
    }
}
