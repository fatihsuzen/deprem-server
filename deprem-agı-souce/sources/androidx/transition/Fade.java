package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;

public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    private static class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mLayerTypeChanged = false;
        private final View mView;

        FadeAnimatorListener(View view) {
            this.mView = view;
        }

        public void onAnimationCancel(Animator animator) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onAnimationStart(Animator animator) {
            if (this.mView.hasOverlappingRendering() && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, (Paint) null);
            }
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionEnd(@NonNull Transition transition) {
        }

        public void onTransitionPause(@NonNull Transition transition) {
            float f5;
            if (this.mView.getVisibility() == 0) {
                f5 = ViewUtils.getTransitionAlpha(this.mView);
            } else {
                f5 = 0.0f;
            }
            this.mView.setTag(R.id.transition_pause_alpha, Float.valueOf(f5));
        }

        public void onTransitionResume(@NonNull Transition transition) {
            this.mView.setTag(R.id.transition_pause_alpha, (Object) null);
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z4) {
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, (Paint) null);
            }
            if (!z4) {
                ViewUtils.setTransitionAlpha(this.mView, 1.0f);
                ViewUtils.clearNonTransitionAlpha(this.mView);
            }
        }

        public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
            e.a(this, transition, z4);
        }

        public void onTransitionStart(@NonNull Transition transition, boolean z4) {
        }
    }

    public Fade(int i5) {
        setMode(i5);
    }

    private Animator createAnimation(View view, float f5, float f6) {
        if (f5 == f6) {
            return null;
        }
        ViewUtils.setTransitionAlpha(view, f5);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.TRANSITION_ALPHA, new float[]{f6});
        FadeAnimatorListener fadeAnimatorListener = new FadeAnimatorListener(view);
        ofFloat.addListener(fadeAnimatorListener);
        getRootTransition().addListener(fadeAnimatorListener);
        return ofFloat;
    }

    private static float getStartAlpha(TransitionValues transitionValues, float f5) {
        Float f6;
        if (transitionValues == null || (f6 = (Float) transitionValues.values.get(PROPNAME_TRANSITION_ALPHA)) == null) {
            return f5;
        }
        return f6.floatValue();
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        Float f5 = (Float) transitionValues.view.getTag(R.id.transition_pause_alpha);
        if (f5 == null) {
            if (transitionValues.view.getVisibility() == 0) {
                f5 = Float.valueOf(ViewUtils.getTransitionAlpha(transitionValues.view));
            } else {
                f5 = Float.valueOf(0.0f);
            }
        }
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, f5);
    }

    public boolean isSeekingSupported() {
        return true;
    }

    @Nullable
    public Animator onAppear(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view);
        return createAnimation(view, getStartAlpha(transitionValues, 0.0f), 1.0f);
    }

    @Nullable
    public Animator onDisappear(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view);
        Animator createAnimation = createAnimation(view, getStartAlpha(transitionValues, 1.0f), 0.0f);
        if (createAnimation == null) {
            ViewUtils.setTransitionAlpha(view, getStartAlpha(transitionValues2, 1.0f));
        }
        return createAnimation;
    }

    public Fade() {
    }

    public Fade(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
