package androidx.core.transition;

import android.transition.Transition;
import k3.l;

public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ l $onCancel;
    final /* synthetic */ l $onEnd;
    final /* synthetic */ l $onPause;
    final /* synthetic */ l $onResume;
    final /* synthetic */ l $onStart;

    public TransitionKt$addListener$listener$1(l lVar, l lVar2, l lVar3, l lVar4, l lVar5) {
        this.$onEnd = lVar;
        this.$onResume = lVar2;
        this.$onPause = lVar3;
        this.$onCancel = lVar4;
        this.$onStart = lVar5;
    }

    public void onTransitionCancel(Transition transition) {
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
        this.$onPause.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
        this.$onStart.invoke(transition);
    }
}
