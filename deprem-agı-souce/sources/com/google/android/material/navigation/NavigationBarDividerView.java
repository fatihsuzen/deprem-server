package com.google.android.material.navigation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarDividerView extends FrameLayout implements NavigationBarMenuItemView {
    private boolean dividersEnabled;
    private boolean expanded;
    boolean onlyShowWhenExpanded;

    NavigationBarDividerView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.m3_navigation_menu_divider, this, true);
        updateVisibility();
    }

    @Nullable
    public MenuItemImpl getItemData() {
        return null;
    }

    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i5) {
        updateVisibility();
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public boolean isOnlyVisibleWhenExpanded() {
        return this.onlyShowWhenExpanded;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setDividersEnabled(boolean z4) {
        this.dividersEnabled = z4;
        updateVisibility();
    }

    public void setEnabled(boolean z4) {
    }

    public void setExpanded(boolean z4) {
        this.expanded = z4;
        updateVisibility();
    }

    public void setIcon(@Nullable Drawable drawable) {
    }

    public void setOnlyShowWhenExpanded(boolean z4) {
        this.onlyShowWhenExpanded = z4;
        updateVisibility();
    }

    public void setShortcut(boolean z4, char c5) {
    }

    public void setTitle(@Nullable CharSequence charSequence) {
    }

    public boolean showsIcon() {
        return false;
    }

    public void updateVisibility() {
        int i5;
        if (!this.dividersEnabled || (!this.expanded && this.onlyShowWhenExpanded)) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        setVisibility(i5);
    }
}
