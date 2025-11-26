package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;

public final /* synthetic */ class d implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Transition.SeekController f485a;

    public /* synthetic */ d(Transition.SeekController seekController) {
        this.f485a = seekController;
    }

    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z4, float f5, float f6) {
        Transition.SeekController.a(this.f485a, dynamicAnimation, z4, f5, f6);
    }
}
