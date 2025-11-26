package com.google.android.material.textfield;

import android.view.accessibility.AccessibilityManager;

public final /* synthetic */ class l implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f7128a;

    public /* synthetic */ l(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f7128a = dropdownMenuEndIconDelegate;
    }

    public final void onTouchExplorationStateChanged(boolean z4) {
        DropdownMenuEndIconDelegate.b(this.f7128a, z4);
    }
}
