package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator;
import androidx.dynamicanimation.animation.AnimationHandler;

public final /* synthetic */ class e implements ValueAnimator.DurationScaleChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnimationHandler.DurationScaleChangeListener33 f344a;

    public /* synthetic */ e(AnimationHandler.DurationScaleChangeListener33 durationScaleChangeListener33) {
        this.f344a = durationScaleChangeListener33;
    }

    public final void onChanged(float f5) {
        AnimationHandler.this.mDurationScale = f5;
    }
}
