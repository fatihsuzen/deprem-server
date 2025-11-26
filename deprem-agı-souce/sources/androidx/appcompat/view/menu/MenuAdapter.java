package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z4, int i5) {
        this.mOverflowOnly = z4;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = i5;
        findExpandedIndex();
    }

    /* access modifiers changed from: package-private */
    public void findExpandedIndex() {
        MenuItemImpl expandedItem = this.mAdapterMenu.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.mAdapterMenu.getNonActionItems();
            int size = nonActionItems.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (nonActionItems.get(i5) == expandedItem) {
                    this.mExpandedIndex = i5;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    public int getCount() {
        ArrayList<MenuItemImpl> arrayList;
        if (this.mOverflowOnly) {
            arrayList = this.mAdapterMenu.getNonActionItems();
        } else {
            arrayList = this.mAdapterMenu.getVisibleItems();
        }
        if (this.mExpandedIndex < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    public long getItemId(int i5) {
        return (long) i5;
    }

    public View getView(int i5, View view, ViewGroup viewGroup) {
        int i6;
        boolean z4;
        if (view == null) {
            view = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int groupId = getItem(i5).getGroupId();
        int i7 = i5 - 1;
        if (i7 >= 0) {
            i6 = getItem(i7).getGroupId();
        } else {
            i6 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (!this.mAdapterMenu.isGroupDividerEnabled() || groupId == i6) {
            z4 = false;
        } else {
            z4 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z4);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.mForceShowIcon) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i5), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z4) {
        this.mForceShowIcon = z4;
    }

    public MenuItemImpl getItem(int i5) {
        ArrayList<MenuItemImpl> nonActionItems = this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
        int i6 = this.mExpandedIndex;
        if (i6 >= 0 && i5 >= i6) {
            i5++;
        }
        return nonActionItems.get(i5);
    }
}
