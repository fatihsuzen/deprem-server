package androidx.transition;

import androidx.annotation.NonNull;
import androidx.transition.Transition;

public class TransitionListenerAdapter implements Transition.TransitionListener {
    public void onTransitionCancel(@NonNull Transition transition) {
    }

    public void onTransitionEnd(@NonNull Transition transition) {
    }

    public void onTransitionPause(@NonNull Transition transition) {
    }

    public void onTransitionResume(@NonNull Transition transition) {
    }

    public void onTransitionStart(@NonNull Transition transition) {
    }

    public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
        e.a(this, transition, z4);
    }

    public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
        e.b(this, transition, z4);
    }
}
