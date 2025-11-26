package com.google.android.material.navigation;

import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface NavigationBarMenuItemView extends MenuView.ItemView {
    boolean isExpanded();

    boolean isOnlyVisibleWhenExpanded();

    void setExpanded(boolean z4);

    void setOnlyShowWhenExpanded(boolean z4);
}
