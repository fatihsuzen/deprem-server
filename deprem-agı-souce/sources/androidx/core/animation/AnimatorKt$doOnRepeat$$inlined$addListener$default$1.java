package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt$doOnRepeat$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ l $onRepeat;

    public AnimatorKt$doOnRepeat$$inlined$addListener$default$1(l lVar) {
        this.$onRepeat = lVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
    }
}
