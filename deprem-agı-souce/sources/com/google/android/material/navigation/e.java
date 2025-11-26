package com.google.android.material.navigation;

import com.google.android.material.motion.MaterialBackOrchestrator;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialBackOrchestrator f7059a;

    public /* synthetic */ e(MaterialBackOrchestrator materialBackOrchestrator) {
        this.f7059a = materialBackOrchestrator;
    }

    public final void run() {
        this.f7059a.startListeningForBackCallbacksWithPriorityOverlay();
    }
}
