package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LogDecelerateInterpolator implements TimeInterpolator {
    int mBase;
    int mDrift;
    final float mLogScale;

    public LogDecelerateInterpolator(int i5, int i6) {
        this.mBase = i5;
        this.mDrift = i6;
        this.mLogScale = 1.0f / computeLog(1.0f, i5, i6);
    }

    static float computeLog(float f5, int i5, int i6) {
        return ((float) (-Math.pow((double) i5, (double) (-f5)))) + 1.0f + (((float) i6) * f5);
    }

    public float getInterpolation(float f5) {
        return computeLog(f5, this.mBase, this.mDrift) * this.mLogScale;
    }
}
