package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private ArrayList<MenuItemImpl> mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction = 0;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled = false;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing = false;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mOptionalIconsVisible = false;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<>();
    private ArrayList<MenuItemImpl> mVisibleItems;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        return new MenuItemImpl(this, i5, i6, i7, i8, charSequence, i9);
    }

    private void dispatchPresenterUpdate(boolean z4) {
        if (!this.mPresenters.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    menuPresenter.updateMenuView(z4);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray != null && !this.mPresenters.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.mPresenters.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
        }
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z4 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z4 = menuPresenter.onSubMenuSelected(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.mPresenters.remove(next);
            } else if (!z4) {
                z4 = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
        }
        return z4;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> arrayList, int i5) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i5) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int getOrdering(int i5) {
        int i6 = (-65536 & i5) >> 16;
        if (i6 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i6 < iArr.length) {
                return (i5 & 65535) | (iArr[i6] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int i5, boolean z4) {
        if (i5 >= 0 && i5 < this.mItems.size()) {
            this.mItems.remove(i5);
            if (z4) {
                onItemsChanged(true);
            }
        }
    }

    private void setHeaderInternal(int i5, CharSequence charSequence, int i6, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i5 > 0) {
                this.mHeaderTitle = resources.getText(i5);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i6 > 0) {
                this.mHeaderIcon = ContextCompat.getDrawable(getContext(), i6);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(android.view.ViewConfiguration.get(r2.mContext), r2.mContext) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setShortcutsVisibleInner(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x001c
            android.content.res.Resources r3 = r2.mResources
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L_0x001c
            android.content.Context r3 = r2.mContext
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.mContext
            boolean r3 = androidx.core.view.ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(r3, r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r2.mShortcutsVisible = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.setShortcutsVisibleInner(boolean):void");
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        Intent intent2;
        int i10;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i9 = queryIntentActivityOptions.size();
        } else {
            i9 = 0;
        }
        if ((i8 & 1) == 0) {
            removeGroup(i5);
        }
        for (int i11 = 0; i11 < i9; i11++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i11);
            int i12 = resolveInfo.specificIndex;
            if (i12 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i12];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i5, i6, i7, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i10 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i10] = intent4;
            }
        }
        return i9;
    }

    /* access modifiers changed from: protected */
    public MenuItem addInternal(int i5, int i6, int i7, CharSequence charSequence) {
        int ordering = getOrdering(i7);
        MenuItemImpl createNewMenuItem = createNewMenuItem(i5, i6, i7, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.setMenuInfo(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.mContext);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    public void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z4) {
        if (!this.mIsClosing) {
            this.mIsClosing = true;
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z4);
                }
            }
            this.mIsClosing = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z4 = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z4 = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z4) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z4) {
                this.mExpandedItem = null;
            }
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        Callback callback = this.mCallback;
        if (callback == null || !callback.onMenuItemSelected(menuBuilder, menuItem)) {
            return false;
        }
        return true;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z4 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter = (MenuPresenter) next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                z4 = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z4) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z4) {
            this.mExpandedItem = menuItemImpl;
        }
        return z4;
    }

    public int findGroupIndex(int i5) {
        return findGroupIndex(i5, 0);
    }

    public MenuItem findItem(int i5) {
        MenuItem findItem;
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i6);
            if (menuItemImpl.getItemId() == i5) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i5)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (this.mItems.get(i6).getItemId() == i5) {
                return i6;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public MenuItemImpl findItemWithShortcutForKey(int i5, KeyEvent keyEvent) {
        char c5;
        ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i5, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItemImpl menuItemImpl = arrayList.get(i6);
            if (isQwertyMode) {
                c5 = menuItemImpl.getAlphabeticShortcut();
            } else {
                c5 = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c5 == cArr[0] && (metaState & 2) == 0) || ((c5 == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c5 == 8 && i5 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void findItemsWithShortcutForKey(List<MenuItemImpl> list, int i5, KeyEvent keyEvent) {
        char c5;
        int i6;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i5 == 67) {
            int size = this.mItems.size();
            for (int i7 = 0; i7 < size; i7++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i7);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(list, i5, keyEvent);
                }
                if (isQwertyMode) {
                    c5 = menuItemImpl.getAlphabeticShortcut();
                } else {
                    c5 = menuItemImpl.getNumericShortcut();
                }
                if (isQwertyMode) {
                    i6 = menuItemImpl.getAlphabeticModifiers();
                } else {
                    i6 = menuItemImpl.getNumericModifiers();
                }
                if ((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == (i6 & SupportMenu.SUPPORTED_MODIFIERS_MASK) && c5 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c5 == cArr[0] || c5 == cArr[2] || (isQwertyMode && c5 == 8 && i5 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z4 |= menuPresenter.flagActionItems();
                }
            }
            if (z4) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i5 = 0; i5 < size; i5++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i5);
                    if (menuItemImpl.isActionButton()) {
                        this.mActionItems.add(menuItemImpl);
                    } else {
                        this.mNonActionItems.add(menuItemImpl);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    /* access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public MenuItem getItem(int i5) {
        return this.mItems.get(i5);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    /* access modifiers changed from: package-private */
    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    /* access modifiers changed from: package-private */
    public Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i5);
            if (menuItemImpl.isVisible()) {
                this.mVisibleItems.add(menuItemImpl);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.mItems.get(i5).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDispatchingItemsChanged() {
        return !this.mPreventDispatchingItemsChanged;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        if (findItemWithShortcutForKey(i5, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    /* access modifiers changed from: package-private */
    public void onItemActionRequestChanged(MenuItemImpl menuItemImpl) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    /* access modifiers changed from: package-private */
    public void onItemVisibleChanged(MenuItemImpl menuItemImpl) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z4) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z4) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z4);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z4) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public boolean performIdentifierAction(int i5, int i6) {
        return performItemAction(findItem(i5), i6);
    }

    public boolean performItemAction(MenuItem menuItem, int i5) {
        return performItemAction(menuItem, (MenuPresenter) null, i5);
    }

    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        boolean z4;
        MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(i5, keyEvent);
        if (findItemWithShortcutForKey != null) {
            z4 = performItemAction(findItemWithShortcutForKey, i6);
        } else {
            z4 = false;
        }
        if ((i6 & 2) != 0) {
            close(true);
        }
        return z4;
    }

    public void removeGroup(int i5) {
        int findGroupIndex = findGroupIndex(i5);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                if (i6 >= size || this.mItems.get(findGroupIndex).getGroupId() != i5) {
                    onItemsChanged(true);
                } else {
                    removeItemAtInt(findGroupIndex, false);
                    i6 = i7;
                }
            }
            onItemsChanged(true);
        }
    }

    public void removeItem(int i5) {
        removeItemAtInt(findItemIndex(i5), true);
    }

    public void removeItemAt(int i5) {
        removeItemAtInt(i5, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                MenuItem item = getItem(i5);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i6 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
            if (i6 > 0 && (findItem = findItem(i6)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i5) {
        this.mDefaultShowAsAction = i5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setExclusiveItemChecked(MenuItem menuItem) {
        boolean z4;
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i5);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                if (menuItemImpl == menuItem) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                menuItemImpl.setCheckedInt(z4);
            }
        }
        startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int i5, boolean z4, boolean z5) {
        int size = this.mItems.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i6);
            if (menuItemImpl.getGroupId() == i5) {
                menuItemImpl.setExclusiveCheckable(z5);
                menuItemImpl.setCheckable(z4);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z4) {
        this.mGroupDividerEnabled = z4;
    }

    public void setGroupEnabled(int i5, boolean z4) {
        int size = this.mItems.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i6);
            if (menuItemImpl.getGroupId() == i5) {
                menuItemImpl.setEnabled(z4);
            }
        }
    }

    public void setGroupVisible(int i5, boolean z4) {
        int size = this.mItems.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i6);
            if (menuItemImpl.getGroupId() == i5 && menuItemImpl.setVisibleInt(z4)) {
                z5 = true;
            }
        }
        if (z5) {
            onItemsChanged(true);
        }
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z4) {
        this.mOptionalIconsVisible = z4;
    }

    public void setOverrideVisibleItems(boolean z4) {
        this.mOverrideVisibleItems = z4;
    }

    public void setQwertyMode(boolean z4) {
        this.mQwertyMode = z4;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z4) {
        if (this.mShortcutsVisible != z4) {
            setShortcutsVisibleInner(z4);
            onItemsChanged(false);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    public MenuItem add(int i5) {
        return addInternal(0, 0, 0, this.mResources.getString(i5));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.mPresenters.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int i5) {
        return addSubMenu(0, 0, 0, (CharSequence) this.mResources.getString(i5));
    }

    public int findGroupIndex(int i5, int i6) {
        int size = size();
        if (i6 < 0) {
            i6 = 0;
        }
        while (i6 < size) {
            if (this.mItems.get(i6).getGroupId() == i5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i5) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z4 = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            boolean expandActionView = menuItemImpl.expandActionView() | invoke;
            if (expandActionView) {
                close(true);
            }
            return expandActionView;
        } else if (menuItemImpl.hasSubMenu() || z4) {
            if ((i5 & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z4) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            boolean dispatchSubMenuSelected = dispatchSubMenuSelected(subMenuBuilder, menuPresenter) | invoke;
            if (!dispatchSubMenuSelected) {
                close(true);
            }
            return dispatchSubMenuSelected;
        } else {
            if ((i5 & 1) == 0) {
                close(true);
            }
            return invoke;
        }
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(int i5) {
        setHeaderInternal(0, (CharSequence) null, i5, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(int i5) {
        setHeaderInternal(i5, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return addInternal(i5, i6, i7, charSequence);
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i5, i6, i7, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    public MenuItem add(int i5, int i6, int i7, int i8) {
        return addInternal(i5, i6, i7, this.mResources.getString(i8));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return addSubMenu(i5, i6, i7, (CharSequence) this.mResources.getString(i8));
    }

    public void close() {
        close(true);
    }
}
