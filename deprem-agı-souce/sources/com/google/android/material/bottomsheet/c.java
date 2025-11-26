package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final /* synthetic */ class c implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetDragHandleView f6957a;

    public /* synthetic */ c(BottomSheetDragHandleView bottomSheetDragHandleView) {
        this.f6957a = bottomSheetDragHandleView;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f6957a.expandOrCollapseBottomSheetIfPossible();
    }
}
