package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

public final class ExpandableWidgetHelper {
    private boolean expanded = false;
    @IdRes
    private int expandedComponentIdHint = 0;
    @NonNull
    private final View widget;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.widget = (View) expandableWidget;
    }

    private void dispatchExpandedStateChanged() {
        ViewParent parent = this.widget.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.widget);
        }
    }

    @IdRes
    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        this.expanded = bundle.getBoolean(MRAIDCommunicatorUtil.STATES_EXPANDED, false);
        this.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
        if (this.expanded) {
            dispatchExpandedStateChanged();
        }
    }

    @NonNull
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(MRAIDCommunicatorUtil.STATES_EXPANDED, this.expanded);
        bundle.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return bundle;
    }

    public boolean setExpanded(boolean z4) {
        if (this.expanded == z4) {
            return false;
        }
        this.expanded = z4;
        dispatchExpandedStateChanged();
        return true;
    }

    public void setExpandedComponentIdHint(@IdRes int i5) {
        this.expandedComponentIdHint = i5;
    }
}
