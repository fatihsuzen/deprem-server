package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NavigationBarMenu extends MenuBuilder {
    public static final int NO_MAX_ITEM_LIMIT = Integer.MAX_VALUE;
    private final int maxItemCount;
    private final boolean subMenuSupported;
    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i5, boolean z4) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i5;
        this.subMenuSupported = z4;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public MenuItem addInternal(int i5, int i6, int i7, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i5, i6, i7, charSequence);
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.maxItemCount + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @NonNull
    public SubMenu addSubMenu(int i5, int i6, int i7, @NonNull CharSequence charSequence) {
        if (this.subMenuSupported) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i5, i6, i7, charSequence);
            NavigationBarSubMenu navigationBarSubMenu = new NavigationBarSubMenu(getContext(), this, menuItemImpl);
            menuItemImpl.setSubMenu(navigationBarSubMenu);
            return navigationBarSubMenu;
        }
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
