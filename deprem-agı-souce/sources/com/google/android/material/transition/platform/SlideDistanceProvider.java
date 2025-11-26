package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i5) {
        this.slideEdge = i5;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i5, @Px int i6) {
        float f5;
        float f6;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i5 == 3) {
            return createTranslationXAnimator(view2, ((float) i6) + translationX, translationX, translationX);
        }
        if (i5 == 5) {
            return createTranslationXAnimator(view2, translationX - ((float) i6), translationX, translationX);
        }
        if (i5 == 48) {
            return createTranslationYAnimator(view2, translationY - ((float) i6), translationY, translationY);
        }
        if (i5 == 80) {
            return createTranslationYAnimator(view2, ((float) i6) + translationY, translationY, translationY);
        }
        if (i5 == 8388611) {
            if (isRtl(view)) {
                f5 = ((float) i6) + translationX;
            } else {
                f5 = translationX - ((float) i6);
            }
            return createTranslationXAnimator(view2, f5, translationX, translationX);
        } else if (i5 == 8388613) {
            if (isRtl(view)) {
                f6 = translationX - ((float) i6);
            } else {
                f6 = ((float) i6) + translationX;
            }
            return createTranslationXAnimator(view2, f6, translationX, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i5);
        }
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i5, @Px int i6) {
        float f5;
        float f6;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i5 == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - ((float) i6), translationX);
        }
        if (i5 == 5) {
            return createTranslationXAnimator(view2, translationX, ((float) i6) + translationX, translationX);
        }
        if (i5 == 48) {
            return createTranslationYAnimator(view2, translationY, ((float) i6) + translationY, translationY);
        }
        if (i5 == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - ((float) i6), translationY);
        }
        if (i5 == 8388611) {
            if (isRtl(view)) {
                f5 = translationX - ((float) i6);
            } else {
                f5 = ((float) i6) + translationX;
            }
            return createTranslationXAnimator(view2, translationX, f5, translationX);
        } else if (i5 == 8388613) {
            if (isRtl(view)) {
                f6 = ((float) i6) + translationX;
            } else {
                f6 = translationX - ((float) i6);
            }
            return createTranslationXAnimator(view2, translationX, f6, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i5);
        }
    }

    private static Animator createTranslationXAnimator(final View view, float f5, float f6, final float f7) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f5, f6})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f7);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f5, float f6, final float f7) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f5, f6})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f7);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i5 = this.slideDistance;
        if (i5 != -1) {
            return i5;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i5) {
        if (i5 >= 0) {
            this.slideDistance = i5;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i5) {
        this.slideEdge = i5;
    }
}
