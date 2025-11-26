package androidx.transition;

import androidx.transition.Transition;

public final /* synthetic */ class f implements Transition.TransitionNotification {
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z4) {
        transitionListener.onTransitionStart(transition, z4);
    }
}
