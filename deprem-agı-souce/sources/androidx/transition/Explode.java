package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private int[] mTempLoc = new int[2];

    public Explode() {
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float f5, float f6) {
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    private static float calculateMaxDistance(View view, int i5, int i6) {
        return calculateDistance((float) Math.max(i5, view.getWidth() - i5), (float) Math.max(i6, view.getHeight() - i6));
    }

    private void calculateOut(View view, Rect rect, int[] iArr) {
        int i5;
        int i6;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        int i7 = iArr2[0];
        int i8 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i6 = (view.getWidth() / 2) + i7 + Math.round(view.getTranslationX());
            i5 = (view.getHeight() / 2) + i8 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            i5 = epicenter.centerY();
            i6 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i6);
        float centerY = (float) (rect.centerY() - i5);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float calculateDistance = calculateDistance(centerX2, centerY);
        float calculateMaxDistance = calculateMaxDistance(view, i6 - i7, i5 - i8);
        iArr[0] = Math.round((centerX2 / calculateDistance) * calculateMaxDistance);
        iArr[1] = Math.round(calculateMaxDistance * (centerY / calculateDistance));
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr = this.mTempLoc;
        int i5 = iArr[0];
        int i6 = iArr[1];
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(i5, i6, view.getWidth() + i5, view.getHeight() + i6));
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public boolean isSeekingSupported() {
        return true;
    }

    @Nullable
    public Animator onAppear(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, sDecelerate, this);
    }

    @Nullable
    public Animator onDisappear(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        float f5;
        float f6;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int i5 = rect.left;
        int i6 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            int i7 = iArr[0];
            f6 = ((float) (i7 - rect.left)) + translationX;
            int i8 = iArr[1];
            f5 = ((float) (i8 - rect.top)) + translationY;
            rect.offsetTo(i7, i8);
        } else {
            f6 = translationX;
            f5 = translationY;
        }
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(view, transitionValues, i5, i6, translationX, translationY, f6 + ((float) iArr2[0]), f5 + ((float) iArr2[1]), sAccelerate, this);
    }

    public Explode(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        setPropagation(new CircularPropagation());
    }
}
