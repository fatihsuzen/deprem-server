package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r6.getLayoutDirection() == 1) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r6.getLayoutDirection() == 1) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int distance(android.view.View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            r5 = this;
            int r0 = r5.mSide
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r2 = 1
            r3 = 3
            r4 = 5
            if (r0 != r1) goto L_0x0014
            int r6 = r6.getLayoutDirection()
            if (r6 != r2) goto L_0x0012
        L_0x0010:
            r0 = r4
            goto L_0x0020
        L_0x0012:
            r0 = r3
            goto L_0x0020
        L_0x0014:
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r1) goto L_0x0020
            int r6 = r6.getLayoutDirection()
            if (r6 != r2) goto L_0x0010
            goto L_0x0012
        L_0x0020:
            if (r0 == r3) goto L_0x0046
            if (r0 == r4) goto L_0x003e
            r6 = 48
            if (r0 == r6) goto L_0x0036
            r6 = 80
            if (r0 == r6) goto L_0x002e
            r6 = 0
            return r6
        L_0x002e:
            int r8 = r8 - r12
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r8 = r8 + r6
            return r8
        L_0x0036:
            int r14 = r14 - r8
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r14 = r14 + r6
            return r14
        L_0x003e:
            int r7 = r7 - r11
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r7 = r7 + r6
            return r7
        L_0x0046:
            int r13 = r13 - r7
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r13 = r13 + r6
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.distance(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i5 = this.mSide;
        if (i5 == 3 || i5 == 5 || i5 == 8388611 || i5 == 8388613) {
            return viewGroup.getWidth();
        }
        return viewGroup.getHeight();
    }

    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i5;
        int i6;
        int i7;
        int i8;
        ViewGroup viewGroup2;
        int i9;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i5 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i5 = 1;
        }
        Rect rect = epicenter;
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        ViewGroup viewGroup3 = viewGroup;
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = viewGroup.getWidth() + round;
        int height = viewGroup.getHeight() + round2;
        if (rect != null) {
            int i10 = round2;
            i8 = viewY;
            viewGroup2 = viewGroup3;
            i9 = i10;
            int centerX = rect.centerX();
            i7 = rect.centerY();
            i6 = centerX;
        } else {
            i6 = (round + width) / 2;
            i7 = (round2 + height) / 2;
            int i11 = round2;
            i8 = viewY;
            viewGroup2 = viewGroup3;
            i9 = i11;
        }
        float distance = ((float) distance(viewGroup2, viewX, i8, i6, i7, round, i9, width, height)) / ((float) getMaxDistance(viewGroup));
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

    public void setSide(int i5) {
        this.mSide = i5;
    }
}
