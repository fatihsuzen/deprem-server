package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt$doOnPause$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ l $onPause;

    public TransitionKt$doOnPause$$inlined$addListener$default$1(l lVar) {
        this.$onPause = lVar;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
        this.$onPause.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
