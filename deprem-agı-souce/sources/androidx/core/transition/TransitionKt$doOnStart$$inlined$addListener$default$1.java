package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt$doOnStart$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ l $onStart;

    public TransitionKt$doOnStart$$inlined$addListener$default$1(l lVar) {
        this.$onStart = lVar;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
        this.$onStart.invoke(transition);
    }
}
