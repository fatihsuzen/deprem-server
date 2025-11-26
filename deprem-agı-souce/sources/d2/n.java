package D2;

import B2.j;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18021b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f18022a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public n(Context context) {
        t.e(context, "context");
        this.f18022a = context;
    }

    /* access modifiers changed from: private */
    public static final void e(View view, ValueAnimator valueAnimator) {
        t.e(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* access modifiers changed from: private */
    public static final void k(ImageView imageView, ValueAnimator valueAnimator) {
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
    public static final void m(ImageView imageView, ValueAnimator valueAnimator) {
        t.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(floatValue);
        imageView.setScaleY(floatValue);
        int i5 = (int) (((float) 10) * (((float) 1) - floatValue));
        imageView.setPadding(i5, i5, i5, i5);
    }

    public final void d(View view, float f5) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (f5 == 1.0f) {
            view.setClickable(true);
        } else if (f5 == 0.3f) {
            view.setClickable(false);
        }
        if (!com.uptodown.activities.preferences.a.f15150a.P(this.f18022a) || UptodownApp.f13477F.P()) {
            view.setAlpha(f5);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{view.getAlpha(), f5});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new l(view));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    public final void f(int i5, View view, int i6) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f18022a, i6);
        loadAnimation.setRepeatCount(i5);
        view.startAnimation(loadAnimation);
    }

    public final void g(View view, int i5, Animation.AnimationListener animationListener) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(animationListener, "callback");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f18022a, i5);
        if (!com.uptodown.activities.preferences.a.f15150a.P(this.f18022a) || UptodownApp.f13477F.P()) {
            animationListener.onAnimationEnd(loadAnimation);
            return;
        }
        loadAnimation.setAnimationListener(animationListener);
        view.startAnimation(loadAnimation);
    }

    public final void h(View view, int i5) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (!com.uptodown.activities.preferences.a.f15150a.P(this.f18022a) || UptodownApp.f13477F.P()) {
            view.setVisibility(0);
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(this.f18022a, i5));
        view.setVisibility(0);
    }

    public final void i(View view, int i5) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (!com.uptodown.activities.preferences.a.f15150a.P(this.f18022a) || UptodownApp.f13477F.P()) {
            view.setVisibility(8);
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(this.f18022a, i5));
        view.setVisibility(8);
    }

    public final void j(ImageView imageView, C2616a aVar) {
        t.e(imageView, "iconView");
        t.e(aVar, "doOnEnd");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.6f, 1.0f});
        ofFloat.setStartDelay(200);
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new m(imageView));
        t.b(ofFloat);
        ofFloat.addListener(new b(aVar));
        ofFloat.start();
    }

    public final void l(ImageView imageView, C2616a aVar) {
        t.e(imageView, "iconView");
        t.e(aVar, "doOnEnd");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.6f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new k(imageView));
        t.b(ofFloat);
        ofFloat.addListener(new c(aVar));
        ofFloat.start();
    }

    public final void n(ImageView imageView) {
        t.e(imageView, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (com.uptodown.activities.preferences.a.f15150a.P(this.f18022a) && !UptodownApp.f13477F.P()) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this.f18022a, R.drawable.vector_heart_red));
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f18022a, R.anim.like_bounce);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f18022a, R.anim.like_bounce_back);
            j jVar = new j(0.2d, 10.0d);
            loadAnimation.setInterpolator(jVar);
            loadAnimation2.setInterpolator(jVar);
            loadAnimation.setAnimationListener(new d(imageView, loadAnimation2));
            imageView.startAnimation(loadAnimation);
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f18023a;

        public b(C2616a aVar) {
            this.f18023a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f18023a.invoke();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f18024a;

        public c(C2616a aVar) {
            this.f18024a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f18024a.invoke();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f18025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Animation f18026b;

        d(ImageView imageView, Animation animation) {
            this.f18025a = imageView;
            this.f18026b = animation;
        }

        public void onAnimationEnd(Animation animation) {
            this.f18025a.startAnimation(this.f18026b);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }
}
