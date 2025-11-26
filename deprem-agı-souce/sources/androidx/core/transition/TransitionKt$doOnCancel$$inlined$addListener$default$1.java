package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt$doOnCancel$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ l $onCancel;

    public TransitionKt$doOnCancel$$inlined$addListener$default$1(l lVar) {
        this.$onCancel = lVar;
    }

    public void onTransitionCancel(Transition transition) {
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
