package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ l $onPause;
    final /* synthetic */ l $onResume;

    AnimatorKt$addPauseListener$listener$1(l lVar, l lVar2) {
        this.$onPause = lVar;
        this.$onResume = lVar2;
    }

    public void onAnimationPause(Animator animator) {
        this.$onPause.invoke(animator);
    }

    public void onAnimationResume(Animator animator) {
        this.$onResume.invoke(animator);
    }
}
