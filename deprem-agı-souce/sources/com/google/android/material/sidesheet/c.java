package com.google.android.material.sidesheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final /* synthetic */ class c implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f7105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7106b;

    public /* synthetic */ c(SideSheetBehavior sideSheetBehavior, int i5) {
        this.f7105a = sideSheetBehavior;
        this.f7106b = i5;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f7105a.setState(this.f7106b);
    }
}
