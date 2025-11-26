package androidx.core.animation;

import android.animation.Animator;
import k3.l;

public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator animator, l lVar, l lVar2, l lVar3, l lVar4) {
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, l lVar, l lVar2, l lVar3, l lVar4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            lVar = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            lVar2 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i5 & 4) != 0) {
            lVar3 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i5 & 8) != 0) {
            lVar4 = AnimatorKt$addListener$4.INSTANCE;
        }
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, l lVar, l lVar2) {
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(lVar2, lVar);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, l lVar, l lVar2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            lVar = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            lVar2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        return addPauseListener(animator, lVar, lVar2);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, l lVar) {
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 animatorKt$doOnCancel$$inlined$addListener$default$1 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(lVar);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$default$1);
        return animatorKt$doOnCancel$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, l lVar) {
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 animatorKt$doOnEnd$$inlined$addListener$default$1 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(lVar);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$default$1);
        return animatorKt$doOnEnd$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, l lVar) {
        return addPauseListener$default(animator, (l) null, lVar, 1, (Object) null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, l lVar) {
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 animatorKt$doOnRepeat$$inlined$addListener$default$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(lVar);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$default$1);
        return animatorKt$doOnRepeat$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, l lVar) {
        return addPauseListener$default(animator, lVar, (l) null, 2, (Object) null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, l lVar) {
        AnimatorKt$doOnStart$$inlined$addListener$default$1 animatorKt$doOnStart$$inlined$addListener$default$1 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(lVar);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$default$1);
        return animatorKt$doOnStart$$inlined$addListener$default$1;
    }
}
