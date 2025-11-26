package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;

public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HideBottomViewOnScrollBehavior f6952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f6953b;

    public /* synthetic */ a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, View view) {
        this.f6952a = hideBottomViewOnScrollBehavior;
        this.f6953b = view;
    }

    public final void onTouchExplorationStateChanged(boolean z4) {
        HideBottomViewOnScrollBehavior.a(this.f6952a, this.f6953b, z4);
    }
}
