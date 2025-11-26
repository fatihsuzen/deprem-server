package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.leanback.R;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FadeAndShortSlide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:fadeAndShortSlideTransition:screenPosition";
    static final CalculateSlide sCalculateBottom = new CalculateSlide() {
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() + fadeAndShortSlide.getVerticalDistance(viewGroup);
        }
    };
    static final CalculateSlide sCalculateEnd = new CalculateSlide() {
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return view.getTranslationX() + fadeAndShortSlide.getHorizontalDistance(viewGroup);
        }
    };
    static final CalculateSlide sCalculateStart = new CalculateSlide() {
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() + fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
        }
    };
    static final CalculateSlide sCalculateStartEnd = new CalculateSlide() {
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int i5;
            int width = iArr[0] + (view.getWidth() / 2);
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = fadeAndShortSlide.getEpicenter();
            if (epicenter == null) {
                i5 = iArr[0] + (viewGroup.getWidth() / 2);
            } else {
                i5 = epicenter.centerX();
            }
            if (width < i5) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return view.getTranslationX() + fadeAndShortSlide.getHorizontalDistance(viewGroup);
        }
    };
    static final CalculateSlide sCalculateTop = new CalculateSlide() {
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
        }
    };
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private float mDistance;
    private Visibility mFade;
    private CalculateSlide mSlideCalculator;
    final CalculateSlide sCalculateTopBottom;

    private static abstract class CalculateSlide {
        CalculateSlide() {
        }

        /* access modifiers changed from: package-private */
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationX();
        }

        /* access modifiers changed from: package-private */
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY();
        }
    }

    public FadeAndShortSlide() {
        this(GravityCompat.START);
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
    }

    public Transition addListener(Transition.TransitionListener transitionListener) {
        this.mFade.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.mFade.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.mFade.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public float getDistance() {
        return this.mDistance;
    }

    /* access modifiers changed from: package-private */
    public float getHorizontalDistance(ViewGroup viewGroup) {
        float f5 = this.mDistance;
        if (f5 >= 0.0f) {
            return f5;
        }
        return (float) (viewGroup.getWidth() / 4);
    }

    /* access modifiers changed from: package-private */
    public float getVerticalDistance(ViewGroup viewGroup) {
        float f5 = this.mDistance;
        if (f5 >= 0.0f) {
            return f5;
        }
        return (float) (viewGroup.getHeight() / 4);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        TransitionValues transitionValues3 = transitionValues2;
        if (transitionValues3 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues3.values.get(PROPNAME_SCREEN_POSITION);
        int i5 = iArr[0];
        int i6 = iArr[1];
        float translationX = view.getTranslationX();
        float goneX = this.mSlideCalculator.getGoneX(this, viewGroup, view, iArr);
        float translationY = view.getTranslationY();
        float f5 = goneX;
        float goneY = this.mSlideCalculator.getGoneY(this, viewGroup, view, iArr);
        int i7 = i5;
        int i8 = i6;
        float f6 = f5;
        Animator createAnimation = TranslationAnimationCreator.createAnimation(view, transitionValues3, i7, i8, f6, goneY, translationX, translationY, sDecelerate, this);
        Animator onAppear = this.mFade.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (createAnimation == null) {
            return onAppear;
        }
        if (onAppear == null) {
            return createAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createAnimation).with(onAppear);
        return animatorSet;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        int i5 = iArr[0];
        int i6 = iArr[1];
        float translationX = view.getTranslationX();
        float goneX = this.mSlideCalculator.getGoneX(this, viewGroup, view, iArr);
        int i7 = i5;
        float translationY = view.getTranslationY();
        int i8 = i7;
        float goneY = this.mSlideCalculator.getGoneY(this, viewGroup, view, iArr);
        int i9 = i8;
        Animator createAnimation = TranslationAnimationCreator.createAnimation(view, transitionValues, i9, i6, translationX, translationY, goneX, goneY, sDecelerate, this);
        TransitionValues transitionValues3 = transitionValues2;
        Animator onDisappear = this.mFade.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (createAnimation == null) {
            return onDisappear;
        }
        if (onDisappear == null) {
            return createAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createAnimation).with(onDisappear);
        return animatorSet;
    }

    public Transition removeListener(Transition.TransitionListener transitionListener) {
        this.mFade.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    public void setDistance(float f5) {
        this.mDistance = f5;
    }

    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.mFade.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    public void setSlideEdge(int i5) {
        if (i5 == 48) {
            this.mSlideCalculator = sCalculateTop;
        } else if (i5 == 80) {
            this.mSlideCalculator = sCalculateBottom;
        } else if (i5 == 112) {
            this.mSlideCalculator = this.sCalculateTopBottom;
        } else if (i5 == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else if (i5 == 8388613) {
            this.mSlideCalculator = sCalculateEnd;
        } else if (i5 == 8388615) {
            this.mSlideCalculator = sCalculateStartEnd;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
    }

    public FadeAndShortSlide(int i5) {
        this.mFade = new Fade();
        this.mDistance = -1.0f;
        this.sCalculateTopBottom = new CalculateSlide() {
            public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
                int i5;
                int height = iArr[1] + (view.getHeight() / 2);
                viewGroup.getLocationOnScreen(iArr);
                Rect epicenter = FadeAndShortSlide.this.getEpicenter();
                if (epicenter == null) {
                    i5 = iArr[1] + (viewGroup.getHeight() / 2);
                } else {
                    i5 = epicenter.centerY();
                }
                if (height < i5) {
                    return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
                }
                return view.getTranslationY() + fadeAndShortSlide.getVerticalDistance(viewGroup);
            }
        };
        setSlideEdge(i5);
    }

    public Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.mFade = (Visibility) this.mFade.clone();
        return fadeAndShortSlide;
    }

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFade = new Fade();
        this.mDistance = -1.0f;
        this.sCalculateTopBottom = new CalculateSlide() {
            public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
                int i5;
                int height = iArr[1] + (view.getHeight() / 2);
                viewGroup.getLocationOnScreen(iArr);
                Rect epicenter = FadeAndShortSlide.this.getEpicenter();
                if (epicenter == null) {
                    i5 = iArr[1] + (viewGroup.getHeight() / 2);
                } else {
                    i5 = epicenter.centerY();
                }
                if (height < i5) {
                    return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
                }
                return view.getTranslationY() + fadeAndShortSlide.getVerticalDistance(viewGroup);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(obtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, GravityCompat.START));
        obtainStyledAttributes.recycle();
    }
}
