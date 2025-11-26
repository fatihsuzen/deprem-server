package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt$doOnCancel$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ l $onCancel;

    public AnimatorKt$doOnCancel$$inlined$addListener$default$1(l lVar) {
        this.$onCancel = lVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.$onCancel.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
