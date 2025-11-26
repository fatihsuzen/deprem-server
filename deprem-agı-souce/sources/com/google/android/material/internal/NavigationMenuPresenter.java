package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private MenuPresenter.Callback callback;
    @Px
    int dividerInsetEnd;
    @Px
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;
    private int id;
    boolean isBehindStatusBar = true;
    Drawable itemBackground;
    RippleDrawable itemForeground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    /* access modifiers changed from: private */
    public int itemMaxLines;
    @Px
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            boolean z4 = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z4 = false;
            } else {
                NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z4) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };
    private int overScrollMode = -1;
    int paddingSeparator;
    private int paddingTopDefault;
    @Nullable
    ColorStateList subheaderColor;
    @Px
    int subheaderInsetEnd;
    @Px
    int subheaderInsetStart;
    int subheaderTextAppearance = 0;
    int textAppearance = 0;
    boolean textAppearanceActiveBoldEnabled = true;
    ColorStateList textColor;

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList<NavigationMenuItem> items = new ArrayList<>();
        private boolean updateSuspended;

        NavigationMenuAdapter() {
            prepareMenuItems();
        }

        /* access modifiers changed from: private */
        public int adjustItemPositionForA11yDelegate(int i5) {
            int i6 = i5;
            for (int i7 = 0; i7 < i5; i7++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i7) == 2 || NavigationMenuPresenter.this.adapter.getItemViewType(i7) == 3) {
                    i6--;
                }
            }
            return i6;
        }

        private void appendTransparentIconIfMissing(int i5, int i6) {
            while (i5 < i6) {
                ((NavigationMenuTextItem) this.items.get(i5)).needsEmptyIcon = true;
                i5++;
            }
        }

        private void prepareMenuItems() {
            if (!this.updateSuspended) {
                this.updateSuspended = true;
                this.items.clear();
                this.items.add(new NavigationMenuHeaderItem());
                int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
                int i5 = -1;
                boolean z4 = false;
                int i6 = 0;
                for (int i7 = 0; i7 < size; i7++) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.menu.getVisibleItems().get(i7);
                    if (menuItemImpl.isChecked()) {
                        setCheckedItem(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i7 != 0) {
                                this.items.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
                            }
                            this.items.add(new NavigationMenuTextItem(menuItemImpl));
                            int size2 = this.items.size();
                            int size3 = subMenu.size();
                            boolean z5 = false;
                            for (int i8 = 0; i8 < size3; i8++) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i8);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z5 && menuItemImpl2.getIcon() != null) {
                                        z5 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(false);
                                    }
                                    if (menuItemImpl2.isChecked()) {
                                        setCheckedItem(menuItemImpl2);
                                    }
                                    this.items.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                            }
                            if (z5) {
                                appendTransparentIconIfMissing(size2, this.items.size());
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i5) {
                            i6 = this.items.size();
                            if (menuItemImpl.getIcon() != null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i7 != 0) {
                                i6++;
                                ArrayList<NavigationMenuItem> arrayList = this.items;
                                int i9 = NavigationMenuPresenter.this.paddingSeparator;
                                arrayList.add(new NavigationMenuSeparatorItem(i9, i9));
                            }
                        } else if (!z4 && menuItemImpl.getIcon() != null) {
                            appendTransparentIconIfMissing(i6, this.items.size());
                            z4 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.needsEmptyIcon = z4;
                        this.items.add(navigationMenuTextItem);
                        i5 = groupId;
                    }
                }
                this.updateSuspended = false;
            }
        }

        private void setAccessibilityDelegate(View view, final int i5, final boolean z4) {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(NavigationMenuAdapter.this.adjustItemPositionForA11yDelegate(i5), 1, 1, 1, z4, view.isSelected()));
                }
            });
        }

        /* access modifiers changed from: private */
        public void updateAllDividerMenuItems() {
            for (int i5 = 0; i5 < this.items.size(); i5++) {
                if (this.items.get(i5) instanceof NavigationMenuSeparatorItem) {
                    notifyItemChanged(i5);
                }
            }
        }

        /* access modifiers changed from: private */
        public void updateAllSubHeaderMenuItems() {
            for (int i5 = 0; i5 < this.items.size(); i5++) {
                if ((this.items.get(i5) instanceof NavigationMenuTextItem) && getItemViewType(i5) == 1) {
                    notifyItemChanged(i5);
                }
            }
        }

        /* access modifiers changed from: private */
        public void updateAllTextMenuItems() {
            for (int i5 = 0; i5 < this.items.size(); i5++) {
                if ((this.items.get(i5) instanceof NavigationMenuTextItem) && getItemViewType(i5) == 0) {
                    notifyItemChanged(i5);
                }
            }
        }

        @NonNull
        public Bundle createInstanceState() {
            View view;
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.checkedItem;
            if (menuItemImpl != null) {
                bundle.putInt(STATE_CHECKED_ITEM, menuItemImpl.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.items.size();
            for (int i5 = 0; i5 < size; i5++) {
                NavigationMenuItem navigationMenuItem = this.items.get(i5);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItem = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                    if (menuItem != null) {
                        view = menuItem.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
            return bundle;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        public int getItemCount() {
            return this.items.size();
        }

        public long getItemId(int i5) {
            return (long) i5;
        }

        public int getItemViewType(int i5) {
            NavigationMenuItem navigationMenuItem = this.items.get(i5);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (!(navigationMenuItem instanceof NavigationMenuTextItem)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int getRowCount() {
            int i5 = 0;
            for (int i6 = 0; i6 < NavigationMenuPresenter.this.adapter.getItemCount(); i6++) {
                int itemViewType = NavigationMenuPresenter.this.adapter.getItemViewType(i6);
                if (itemViewType == 0 || itemViewType == 1) {
                    i5++;
                }
            }
            return i5;
        }

        public void restoreInstanceState(@NonNull Bundle bundle) {
            MenuItemImpl menuItem;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItem2;
            int i5 = bundle.getInt(STATE_CHECKED_ITEM, 0);
            if (i5 != 0) {
                this.updateSuspended = true;
                int size = this.items.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.items.get(i6);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (menuItem2 = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i5) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i6++;
                }
                this.updateSuspended = false;
                prepareMenuItems();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (sparseParcelableArray != null) {
                int size2 = this.items.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    NavigationMenuItem navigationMenuItem2 = this.items.get(i7);
                    if (!(!(navigationMenuItem2 instanceof NavigationMenuTextItem) || (menuItem = ((NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) == null || (actionView = menuItem.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
            if (this.checkedItem != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.checkedItem;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.checkedItem = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void setUpdateSuspended(boolean z4) {
            this.updateSuspended = z4;
        }

        public void update() {
            int size = this.items.size();
            prepareMenuItems();
            notifyDataSetChanged();
            if (size == this.items.size()) {
                notifyItemRangeChanged(0, this.items.size());
            }
        }

        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i5) {
            int itemViewType = getItemViewType(i5);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
                navigationMenuItemView.setTextAppearance(NavigationMenuPresenter.this.textAppearance);
                ColorStateList colorStateList = NavigationMenuPresenter.this.textColor;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = NavigationMenuPresenter.this.itemBackground;
                navigationMenuItemView.setBackground(drawable != null ? drawable.getConstantState().newDrawable() : null);
                RippleDrawable rippleDrawable = NavigationMenuPresenter.this.itemForeground;
                if (rippleDrawable != null) {
                    navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
                }
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.items.get(i5);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                int i6 = navigationMenuPresenter.itemHorizontalPadding;
                int i7 = navigationMenuPresenter.itemVerticalPadding;
                navigationMenuItemView.setPadding(i6, i7, i6, i7);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                if (navigationMenuPresenter2.hasCustomItemIconSize) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
                navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), NavigationMenuPresenter.this.textAppearanceActiveBoldEnabled);
                setAccessibilityDelegate(navigationMenuItemView, i5, false);
            } else if (itemViewType == 1) {
                TextView textView = (TextView) viewHolder.itemView;
                textView.setText(((NavigationMenuTextItem) this.items.get(i5)).getMenuItem().getTitle());
                TextViewCompat.setTextAppearance(textView, NavigationMenuPresenter.this.subheaderTextAppearance);
                textView.setPaddingRelative(NavigationMenuPresenter.this.subheaderInsetStart, textView.getPaddingTop(), NavigationMenuPresenter.this.subheaderInsetEnd, textView.getPaddingBottom());
                ColorStateList colorStateList2 = NavigationMenuPresenter.this.subheaderColor;
                if (colorStateList2 != null) {
                    textView.setTextColor(colorStateList2);
                }
                setAccessibilityDelegate(textView, i5, true);
            } else if (itemViewType == 2) {
                NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.items.get(i5);
                viewHolder.itemView.setPaddingRelative(NavigationMenuPresenter.this.dividerInsetStart, navigationMenuSeparatorItem.getPaddingTop(), NavigationMenuPresenter.this.dividerInsetEnd, navigationMenuSeparatorItem.getPaddingBottom());
            }
        }

        @Nullable
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
            if (i5 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            } else if (i5 == 1) {
                return new SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            } else {
                if (i5 == 2) {
                    return new SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
                }
                if (i5 != 3) {
                    return null;
                }
                return new HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
            }
        }

        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private interface NavigationMenuItem {
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int i5, int i6) {
            this.paddingTop = i5;
            this.paddingBottom = i6;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {
        private final MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.menuItem = menuItemImpl;
        }

        public MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    private class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        NavigationMenuViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(NavigationMenuPresenter.this.adapter.getRowCount(), 1, false));
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private boolean hasHeader() {
        if (getHeaderCount() > 0) {
            return true;
        }
        return false;
    }

    private void updateAllDividerMenuItems() {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.updateAllDividerMenuItems();
        }
    }

    private void updateAllSubHeaderMenuItems() {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.updateAllSubHeaderMenuItems();
        }
    }

    private void updateAllTextMenuItems() {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.updateAllTextMenuItems();
        }
    }

    private void updateTopPadding() {
        int i5;
        if (hasHeader() || !this.isBehindStatusBar) {
            i5 = 0;
        } else {
            i5 = this.paddingTopDefault;
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i5, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@NonNull View view) {
        this.headerLayout.addView(view);
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.paddingTopDefault != systemWindowInsetTop) {
            this.paddingTopDefault = systemWindowInsetTop;
            updateTopPadding();
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, windowInsetsCompat);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int i5) {
        return this.headerLayout.getChildAt(i5);
    }

    public int getId() {
        return this.id;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.menuView == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.menuView = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.menuView));
            if (this.adapter == null) {
                NavigationMenuAdapter navigationMenuAdapter = new NavigationMenuAdapter();
                this.adapter = navigationMenuAdapter;
                navigationMenuAdapter.setHasStableIds(true);
            }
            int i5 = this.overScrollMode;
            if (i5 != -1) {
                this.menuView.setOverScrollMode(i5);
            }
            LinearLayout linearLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false);
            this.headerLayout = linearLayout;
            linearLayout.setImportantForAccessibility(2);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    public View inflateHeaderView(@LayoutRes int i5) {
        View inflate = this.layoutInflater.inflate(i5, this.headerLayout, false);
        addHeaderView(inflate);
        return inflate;
    }

    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
        MenuPresenter.Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onCloseMenu(menuBuilder, z4);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray sparseArray = new SparseArray();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
        }
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@NonNull View view) {
        this.headerLayout.removeView(view);
        if (!hasHeader()) {
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z4) {
        if (this.isBehindStatusBar != z4) {
            this.isBehindStatusBar = z4;
            updateTopPadding();
        }
    }

    public void setCallback(MenuPresenter.Callback callback2) {
        this.callback = callback2;
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        this.adapter.setCheckedItem(menuItemImpl);
    }

    public void setDividerInsetEnd(@Px int i5) {
        this.dividerInsetEnd = i5;
        updateAllDividerMenuItems();
    }

    public void setDividerInsetStart(@Px int i5) {
        this.dividerInsetStart = i5;
        updateAllDividerMenuItems();
    }

    public void setId(int i5) {
        this.id = i5;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        updateAllTextMenuItems();
    }

    public void setItemForeground(@Nullable RippleDrawable rippleDrawable) {
        this.itemForeground = rippleDrawable;
        updateAllTextMenuItems();
    }

    public void setItemHorizontalPadding(int i5) {
        this.itemHorizontalPadding = i5;
        updateAllTextMenuItems();
    }

    public void setItemIconPadding(int i5) {
        this.itemIconPadding = i5;
        updateAllTextMenuItems();
    }

    public void setItemIconSize(@Dimension int i5) {
        if (this.itemIconSize != i5) {
            this.itemIconSize = i5;
            this.hasCustomItemIconSize = true;
            updateAllTextMenuItems();
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateAllTextMenuItems();
    }

    public void setItemMaxLines(int i5) {
        this.itemMaxLines = i5;
        updateAllTextMenuItems();
    }

    public void setItemTextAppearance(@StyleRes int i5) {
        this.textAppearance = i5;
        updateAllTextMenuItems();
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        this.textAppearanceActiveBoldEnabled = z4;
        updateAllTextMenuItems();
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateAllTextMenuItems();
    }

    public void setItemVerticalPadding(@Px int i5) {
        this.itemVerticalPadding = i5;
        updateAllTextMenuItems();
    }

    public void setOverScrollMode(int i5) {
        this.overScrollMode = i5;
        NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i5);
        }
    }

    public void setSubheaderColor(@Nullable ColorStateList colorStateList) {
        this.subheaderColor = colorStateList;
        updateAllSubHeaderMenuItems();
    }

    public void setSubheaderInsetEnd(@Px int i5) {
        this.subheaderInsetEnd = i5;
        updateAllSubHeaderMenuItems();
    }

    public void setSubheaderInsetStart(@Px int i5) {
        this.subheaderInsetStart = i5;
        updateAllSubHeaderMenuItems();
    }

    public void setSubheaderTextAppearance(@StyleRes int i5) {
        this.subheaderTextAppearance = i5;
        updateAllSubHeaderMenuItems();
    }

    public void setUpdateSuspended(boolean z4) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.setUpdateSuspended(z4);
        }
    }

    public void updateMenuView(boolean z4) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.update();
        }
    }
}
