package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ l $onCancel;
    final /* synthetic */ l $onEnd;
    final /* synthetic */ l $onRepeat;
    final /* synthetic */ l $onStart;

    public AnimatorKt$addListener$listener$1(l lVar, l lVar2, l lVar3, l lVar4) {
        this.$onRepeat = lVar;
        this.$onEnd = lVar2;
        this.$onCancel = lVar3;
        this.$onStart = lVar4;
    }

    public void onAnimationCancel(Animator animator) {
        this.$onCancel.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        this.$onEnd.invoke(animator);
    }

    public void onAnimationRepeat(Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.$onStart.invoke(animator);
    }
}
