package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt$doOnStart$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ l $onStart;

    public AnimatorKt$doOnStart$$inlined$addListener$default$1(l lVar) {
        this.$onStart = lVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.$onStart.invoke(animator);
    }
}
