package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags = 16;
    private final int mGroup;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private Drawable mIconDrawable;
    private int mIconResId = 0;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded = false;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint = false;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers = 4096;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers = 4096;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    MenuItemImpl(MenuBuilder menuBuilder, int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        this.mMenu = menuBuilder;
        this.mId = i6;
        this.mGroup = i5;
        this.mCategoryOrder = i7;
        this.mOrdering = i8;
        this.mTitle = charSequence;
        this.mShowAsAction = i9;
    }

    private static void appendModifier(StringBuilder sb, int i5, int i6, String str) {
        if ((i5 & i6) == i6) {
            sb.append(str);
        }
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.mHasIconTint) {
                DrawableCompat.setTintList(drawable, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                DrawableCompat.setTintMode(drawable, this.mIconTintMode);
            }
            this.mNeedToApplyIconTint = false;
        }
        return drawable;
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
        }
        return false;
    }

    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.mMenu.expandItemActionView(this);
        }
        return false;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.mActionView;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider == null) {
            return null;
        }
        View onCreateActionView = actionProvider.onCreateActionView(this);
        this.mActionView = onCreateActionView;
        return onCreateActionView;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    /* access modifiers changed from: package-private */
    public Runnable getCallback() {
        return this.mItemCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            return applyIconTintIfNecessary(drawable);
        }
        if (this.mIconResId == 0) {
            return null;
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = drawable2;
        return applyIconTintIfNecessary(drawable2);
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    /* access modifiers changed from: package-private */
    public char getShortcut() {
        if (this.mMenu.isQwertyMode()) {
            return this.mShortcutAlphabeticChar;
        }
        return this.mShortcutNumericChar;
    }

    /* access modifiers changed from: package-private */
    public String getShortcutLabel() {
        int i5;
        char shortcut = getShortcut();
        if (shortcut == 0) {
            return "";
        }
        Resources resources = this.mMenu.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        if (this.mMenu.isQwertyMode()) {
            i5 = this.mShortcutAlphabeticModifiers;
        } else {
            i5 = this.mShortcutNumericModifiers;
        }
        appendModifier(sb, i5, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        appendModifier(sb, i5, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        appendModifier(sb, i5, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        appendModifier(sb, i5, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        appendModifier(sb, i5, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        appendModifier(sb, i5, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (shortcut == 8) {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (shortcut == 10) {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (shortcut != ' ') {
            sb.append(shortcut);
        } else {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence != null) {
            return charSequence;
        }
        return this.mTitle;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        if (itemView == null || !itemView.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.mShowAsAction & 8) != 0) {
            if (this.mActionView == null && (actionProvider = this.mActionProvider) != null) {
                this.mActionView = actionProvider.onCreateActionView(this);
            }
            if (this.mActionView != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSubMenu() {
        if (this.mSubMenu != null) {
            return true;
        }
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder.dispatchMenuItemSelected(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.mItemCallback;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.mMenu.getContext().startActivity(this.mIntent);
                return true;
            } catch (ActivityNotFoundException e5) {
                Log.e(TAG, "Can't find activity to handle intent; ignoring", e5);
            }
        }
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider == null || !actionProvider.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isActionButton() {
        if ((this.mFlags & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public boolean isCheckable() {
        if ((this.mFlags & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        if ((this.mFlags & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        if ((this.mFlags & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isExclusiveCheckable() {
        if ((this.mFlags & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        ActionProvider actionProvider = this.mActionProvider;
        if (actionProvider == null || !actionProvider.overridesItemVisibility()) {
            if ((this.mFlags & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.mFlags & 8) != 0 || !this.mActionProvider.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean requestsActionButton() {
        if ((this.mShowAsAction & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean requiresActionButton() {
        if ((this.mShowAsAction & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean requiresOverflow() {
        if (requiresActionButton() || requestsActionButton()) {
            return false;
        }
        return true;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z4) {
        this.mIsActionViewExpanded = z4;
        this.mMenu.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c5) {
        if (this.mShortcutAlphabeticChar == c5) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c5);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean z4) {
        int i5 = this.mFlags;
        boolean z5 = z4 | (i5 & true);
        this.mFlags = z5 ? 1 : 0;
        if (i5 != z5) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z4) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked(this);
            return this;
        }
        setCheckedInt(z4);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setCheckedInt(boolean z4) {
        int i5;
        int i6 = this.mFlags;
        int i7 = i6 & -3;
        if (z4) {
            i5 = 2;
        } else {
            i5 = 0;
        }
        int i8 = i5 | i7;
        this.mFlags = i8;
        if (i6 != i8) {
            this.mMenu.onItemsChanged(false);
        }
    }

    public MenuItem setEnabled(boolean z4) {
        if (z4) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z4) {
        int i5;
        int i6 = this.mFlags & -5;
        if (z4) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        this.mFlags = i5 | i6;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public void setIsActionButton(boolean z4) {
        if (z4) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    /* access modifiers changed from: package-private */
    public void setMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    public MenuItem setNumericShortcut(char c5) {
        if (this.mShortcutNumericChar == c5) {
            return this;
        }
        this.mShortcutNumericChar = c5;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c5, char c6) {
        this.mShortcutNumericChar = c5;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c6);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i5) {
        int i6 = i5 & 3;
        if (i6 == 0 || i6 == 1 || i6 == 2) {
            this.mShowAsAction = i5;
            this.mMenu.onItemActionRequestChanged(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @NonNull
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.mActionProvider;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.mMenu.onItemsChanged(true);
        ActionProvider actionProvider3 = this.mActionProvider;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z4) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.mMenu.onItemVisibleChanged(menuItemImpl);
                }
            });
        }
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z4) {
        if (setVisibleInt(z4)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInt(boolean z4) {
        int i5;
        int i6 = this.mFlags;
        int i7 = i6 & -9;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        int i8 = i5 | i7;
        this.mFlags = i8;
        if (i6 != i8) {
            return true;
        }
        return false;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldShowShortcut() {
        if (!this.mMenu.isShortcutsVisible() || getShortcut() == 0) {
            return false;
        }
        return true;
    }

    public boolean showsTextAsAction() {
        if ((this.mShowAsAction & 4) == 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        CharSequence charSequence = this.mTitle;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @NonNull
    public SupportMenuItem setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @NonNull
    public SupportMenuItem setActionView(View view) {
        int i5;
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && (i5 = this.mId) > 0) {
            view.setId(i5);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c5, int i5) {
        if (this.mShortcutAlphabeticChar == c5 && this.mShortcutAlphabeticModifiers == i5) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c5);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i5);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c5, int i5) {
        if (this.mShortcutNumericChar == c5 && this.mShortcutNumericModifiers == i5) {
            return this;
        }
        this.mShortcutNumericChar = c5;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i5);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c5, char c6, int i5, int i6) {
        this.mShortcutNumericChar = c5;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i5);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c6);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i6);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i5) {
        this.mIconDrawable = null;
        this.mIconResId = i5;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setTitle(int i5) {
        return setTitle((CharSequence) this.mMenu.getContext().getString(i5));
    }

    @NonNull
    public SupportMenuItem setActionView(int i5) {
        Context context = this.mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i5, new LinearLayout(context), false));
        return this;
    }
}
