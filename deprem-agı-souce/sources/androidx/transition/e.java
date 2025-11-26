package androidx.transition;

import androidx.transition.Transition;

public abstract /* synthetic */ class e {
    public static void a(Transition.TransitionListener transitionListener, Transition transition, boolean z4) {
        transitionListener.onTransitionEnd(transition);
    }

    public static void b(Transition.TransitionListener transitionListener, Transition transition, boolean z4) {
        transitionListener.onTransitionStart(transition);
    }
}
