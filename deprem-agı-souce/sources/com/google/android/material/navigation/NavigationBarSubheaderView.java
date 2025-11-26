package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarSubheaderView extends FrameLayout implements NavigationBarMenuItemView {
    private boolean expanded;
    @Nullable
    private MenuItemImpl itemData;
    boolean onlyShowWhenExpanded;
    private final TextView subheaderLabel = ((TextView) findViewById(R.id.navigation_menu_subheader_label));
    @Nullable
    private ColorStateList textColor;

    NavigationBarSubheaderView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.m3_navigation_menu_subheader, this, true);
    }

    private void updateVisibility() {
        int i5;
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            if (!menuItemImpl.isVisible() || (!this.expanded && this.onlyShowWhenExpanded)) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            setVisibility(i5);
        }
    }

    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i5) {
        this.itemData = menuItemImpl;
        menuItemImpl.setCheckable(false);
        this.subheaderLabel.setText(menuItemImpl.getTitle());
        updateVisibility();
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public boolean isOnlyVisibleWhenExpanded() {
        return this.onlyShowWhenExpanded;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
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

    public void setTextAppearance(@StyleRes int i5) {
        TextViewCompat.setTextAppearance(this.subheaderLabel, i5);
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            this.subheaderLabel.setTextColor(colorStateList);
        }
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        if (colorStateList != null) {
            this.subheaderLabel.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
    }

    public boolean showsIcon() {
        return false;
    }
}
