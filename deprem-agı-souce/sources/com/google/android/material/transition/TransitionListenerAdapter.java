package com.google.android.material.transition;

import androidx.transition.Transition;
import androidx.transition.e;

abstract class TransitionListenerAdapter implements Transition.TransitionListener {
    TransitionListenerAdapter() {
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
    }

    public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
        e.a(this, transition, z4);
    }

    public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
        e.b(this, transition, z4);
    }
}
