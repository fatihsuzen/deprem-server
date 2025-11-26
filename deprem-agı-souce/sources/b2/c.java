package B2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import kotlin.jvm.internal.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f17333a = new c();

    private c() {
    }

    /* access modifiers changed from: private */
    public static final void d(ImageView imageView, ValueAnimator valueAnimator) {
        t.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(floatValue);
        imageView.setScaleY(floatValue);
        int i5 = (int) (((float) 10) * (((float) 1) - floatValue));
        imageView.setPadding(i5, i5, i5, i5);
    }

    /* access modifiers changed from: private */
    public static final void f(ImageView imageView, ValueAnimator valueAnimator) {
        t.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(floatValue);
        imageView.setScaleY(floatValue);
        int i5 = (int) (((float) 10) * (((float) 1) - floatValue));
        imageView.setPadding(i5, i5, i5, i5);
    }

    public final void c(ProgressBar progressBar, ImageView imageView) {
        t.e(progressBar, "progressBar");
        t.e(imageView, "imageView");
        if (progressBar.getVisibility() == 0) {
            progressBar.setVisibility(8);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.4f, 1.0f});
            ofFloat.setStartDelay(200);
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new a(imageView));
            t.b(ofFloat);
            ofFloat.addListener(new a(progressBar));
            ofFloat.start();
        }
    }

    public final void e(ProgressBar progressBar, ImageView imageView) {
        t.e(progressBar, "progressBar");
        t.e(imageView, "imageView");
        if (progressBar.getVisibility() == 8) {
            progressBar.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new b(imageView));
            ofFloat.start();
        }
    }

    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f17334a;

        public a(ProgressBar progressBar) {
            this.f17334a = progressBar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f17334a.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }
}
