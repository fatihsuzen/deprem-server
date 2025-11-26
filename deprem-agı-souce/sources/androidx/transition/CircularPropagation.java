package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f5, float f6, float f7, float f8) {
        float f9 = f7 - f5;
        float f10 = f8 - f6;
        return (float) Math.sqrt((double) ((f9 * f9) + (f10 * f10)));
    }

    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i5;
        int i6;
        int i7;
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i5 = -1;
        } else {
            transitionValues = transitionValues2;
            i5 = 1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i7 = epicenter.centerX();
            i6 = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i6 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i7 = round;
        }
        float distance = distance((float) viewX, (float) viewY, (float) i7, (float) i6) / distance(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i5))) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f5) {
        if (f5 != 0.0f) {
            this.mPropagationSpeed = f5;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
