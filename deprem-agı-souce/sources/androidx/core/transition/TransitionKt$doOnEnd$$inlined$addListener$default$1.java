package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt$doOnEnd$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ l $onEnd;

    public TransitionKt$doOnEnd$$inlined$addListener$default$1(l lVar) {
        this.$onEnd = lVar;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
