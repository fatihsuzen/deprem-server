package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt$doOnResume$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ l $onResume;

    public TransitionKt$doOnResume$$inlined$addListener$default$1(l lVar) {
        this.$onResume = lVar;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
    }
}
