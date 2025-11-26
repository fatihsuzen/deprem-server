package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt {
    public static final Transition.TransitionListener addListener(Transition transition, l lVar, l lVar2, l lVar3, l lVar4, l lVar5) {
        l lVar6 = lVar4;
        l lVar7 = lVar5;
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar6, lVar7, lVar3, lVar2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            lVar = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            lVar2 = TransitionKt$addListener$2.INSTANCE;
        }
        l lVar6 = lVar2;
        if ((i5 & 4) != 0) {
            lVar3 = TransitionKt$addListener$3.INSTANCE;
        }
        if ((i5 & 8) != 0) {
            lVar4 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i5 & 16) != 0) {
            lVar5 = TransitionKt$addListener$5.INSTANCE;
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar3, lVar6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static final Transition.TransitionListener doOnCancel(Transition transition, l lVar) {
        TransitionKt$doOnCancel$$inlined$addListener$default$1 transitionKt$doOnCancel$$inlined$addListener$default$1 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(lVar);
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$default$1);
        return transitionKt$doOnCancel$$inlined$addListener$default$1;
    }

    public static final Transition.TransitionListener doOnEnd(Transition transition, l lVar) {
        TransitionKt$doOnEnd$$inlined$addListener$default$1 transitionKt$doOnEnd$$inlined$addListener$default$1 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(lVar);
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$default$1);
        return transitionKt$doOnEnd$$inlined$addListener$default$1;
    }

    public static final Transition.TransitionListener doOnPause(Transition transition, l lVar) {
        TransitionKt$doOnPause$$inlined$addListener$default$1 transitionKt$doOnPause$$inlined$addListener$default$1 = new TransitionKt$doOnPause$$inlined$addListener$default$1(lVar);
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$default$1);
        return transitionKt$doOnPause$$inlined$addListener$default$1;
    }

    public static final Transition.TransitionListener doOnResume(Transition transition, l lVar) {
        TransitionKt$doOnResume$$inlined$addListener$default$1 transitionKt$doOnResume$$inlined$addListener$default$1 = new TransitionKt$doOnResume$$inlined$addListener$default$1(lVar);
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$default$1);
        return transitionKt$doOnResume$$inlined$addListener$default$1;
    }

    public static final Transition.TransitionListener doOnStart(Transition transition, l lVar) {
        TransitionKt$doOnStart$$inlined$addListener$default$1 transitionKt$doOnStart$$inlined$addListener$default$1 = new TransitionKt$doOnStart$$inlined$addListener$default$1(lVar);
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$default$1);
        return transitionKt$doOnStart$$inlined$addListener$default$1;
    }
}
