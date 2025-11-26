package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;

public final /* synthetic */ class b implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HideViewOnScrollBehavior f6954a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f6955b;

    public /* synthetic */ b(HideViewOnScrollBehavior hideViewOnScrollBehavior, View view) {
        this.f6954a = hideViewOnScrollBehavior;
        this.f6955b = view;
    }

    public final void onTouchExplorationStateChanged(boolean z4) {
        HideViewOnScrollBehavior.a(this.f6954a, this.f6955b, z4);
    }
}
