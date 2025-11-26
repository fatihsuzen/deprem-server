package com.google.android.material.navigation;

import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarMenuBuilder {
    private int contentItemCount = 0;
    private final List<MenuItem> items;
    private final MenuBuilder menuBuilder;
    private int visibleContentItemCount = 0;
    private int visibleMainItemCount = 0;

    NavigationBarMenuBuilder(MenuBuilder menuBuilder2) {
        this.menuBuilder = menuBuilder2;
        this.items = new ArrayList();
        refreshItems();
    }

    public int getContentItemCount() {
        return this.contentItemCount;
    }

    @NonNull
    public MenuItem getItemAt(int i5) {
        return this.items.get(i5);
    }

    public int getVisibleContentItemCount() {
        return this.visibleContentItemCount;
    }

    public int getVisibleMainContentItemCount() {
        return this.visibleMainItemCount;
    }

    public boolean performItemAction(@NonNull MenuItem menuItem, @NonNull MenuPresenter menuPresenter, int i5) {
        return this.menuBuilder.performItemAction(menuItem, menuPresenter, i5);
    }

    public void refreshItems() {
        this.items.clear();
        this.contentItemCount = 0;
        this.visibleContentItemCount = 0;
        this.visibleMainItemCount = 0;
        for (int i5 = 0; i5 < this.menuBuilder.size(); i5++) {
            MenuItem item = this.menuBuilder.getItem(i5);
            if (item.hasSubMenu()) {
                if (!this.items.isEmpty()) {
                    List<MenuItem> list = this.items;
                    if (!(list.get(list.size() - 1) instanceof DividerMenuItem) && item.isVisible()) {
                        this.items.add(new DividerMenuItem());
                    }
                }
                this.items.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i6 = 0; i6 < subMenu.size(); i6++) {
                    MenuItem item2 = subMenu.getItem(i6);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    this.items.add(item2);
                    this.contentItemCount++;
                    if (item2.isVisible()) {
                        this.visibleContentItemCount++;
                    }
                }
                this.items.add(new DividerMenuItem());
            } else {
                this.items.add(item);
                this.contentItemCount++;
                if (item.isVisible()) {
                    this.visibleContentItemCount++;
                    this.visibleMainItemCount++;
                }
            }
        }
        if (!this.items.isEmpty()) {
            List<MenuItem> list2 = this.items;
            if (list2.get(list2.size() - 1) instanceof DividerMenuItem) {
                List<MenuItem> list3 = this.items;
                list3.remove(list3.size() - 1);
            }
        }
    }

    public int size() {
        return this.items.size();
    }
}
