package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt$doOnEnd$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ l $onEnd;

    public AnimatorKt$doOnEnd$$inlined$addListener$default$1(l lVar) {
        this.$onEnd = lVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.$onEnd.invoke(animator);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
