package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.navigation.NavigationBarView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup implements MenuHost {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    MenuBuilder.Callback mMenuBuilderCallback;
    final MenuHostHelper mMenuHostHelper;
    ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList<MenuItem> mProvidedMenuItems;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        @Nullable
        static OnBackInvokedDispatcher findOnBackInvokedDispatcher(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @DoNotInline
        @NonNull
        static OnBackInvokedCallback newOnBackInvokedCallback(@NonNull Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new x(runnable);
        }

        @DoNotInline
        static void tryRegisterOnBackInvokedCallback(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        static void tryUnregisterOnBackInvokedCallback(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        ExpandedActionViewMenuPresenter() {
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            Toolbar.this.updateBackInvokedCallbackState();
            return true;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.gravity = (toolbar4.mButtonGravity & 112) | GravityCompat.START;
                generateDefaultLayoutParams.mViewType = 2;
                toolbar4.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewExpanded();
            }
            Toolbar.this.updateBackInvokedCallbackState();
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (!(menuBuilder2 == null || (menuItemImpl = this.mCurrentExpandedItem) == null)) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        public void updateMenuView(boolean z4) {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i5 = 0;
                    while (i5 < size) {
                        if (this.mMenu.getItem(i5) != this.mCurrentExpandedItem) {
                            i5++;
                        } else {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {
        private int mCollapseContentDescriptionId;
        private int mCollapseIconId;
        private int mContentInsetEndId;
        private int mContentInsetEndWithActionsId;
        private int mContentInsetLeftId;
        private int mContentInsetRightId;
        private int mContentInsetStartId;
        private int mContentInsetStartWithNavigationId;
        private int mLogoDescriptionId;
        private int mLogoId;
        private int mMenuId;
        private int mNavigationContentDescriptionId;
        private int mNavigationIconId;
        private int mPopupThemeId;
        private boolean mPropertiesMapped = false;
        private int mSubtitleId;
        private int mTitleId;
        private int mTitleMarginBottomId;
        private int mTitleMarginEndId;
        private int mTitleMarginStartId;
        private int mTitleMarginTopId;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mCollapseContentDescriptionId = propertyMapper.mapObject("collapseContentDescription", R.attr.collapseContentDescription);
            this.mCollapseIconId = propertyMapper.mapObject("collapseIcon", R.attr.collapseIcon);
            this.mContentInsetEndId = propertyMapper.mapInt("contentInsetEnd", R.attr.contentInsetEnd);
            this.mContentInsetEndWithActionsId = propertyMapper.mapInt("contentInsetEndWithActions", R.attr.contentInsetEndWithActions);
            this.mContentInsetLeftId = propertyMapper.mapInt("contentInsetLeft", R.attr.contentInsetLeft);
            this.mContentInsetRightId = propertyMapper.mapInt("contentInsetRight", R.attr.contentInsetRight);
            this.mContentInsetStartId = propertyMapper.mapInt("contentInsetStart", R.attr.contentInsetStart);
            this.mContentInsetStartWithNavigationId = propertyMapper.mapInt("contentInsetStartWithNavigation", R.attr.contentInsetStartWithNavigation);
            this.mLogoId = propertyMapper.mapObject("logo", R.attr.logo);
            this.mLogoDescriptionId = propertyMapper.mapObject("logoDescription", R.attr.logoDescription);
            this.mMenuId = propertyMapper.mapObject("menu", R.attr.menu);
            this.mNavigationContentDescriptionId = propertyMapper.mapObject("navigationContentDescription", R.attr.navigationContentDescription);
            this.mNavigationIconId = propertyMapper.mapObject("navigationIcon", R.attr.navigationIcon);
            this.mPopupThemeId = propertyMapper.mapResourceId("popupTheme", R.attr.popupTheme);
            this.mSubtitleId = propertyMapper.mapObject("subtitle", R.attr.subtitle);
            this.mTitleId = propertyMapper.mapObject(CampaignEx.JSON_KEY_TITLE, R.attr.title);
            this.mTitleMarginBottomId = propertyMapper.mapInt("titleMarginBottom", R.attr.titleMarginBottom);
            this.mTitleMarginEndId = propertyMapper.mapInt("titleMarginEnd", R.attr.titleMarginEnd);
            this.mTitleMarginStartId = propertyMapper.mapInt("titleMarginStart", R.attr.titleMarginStart);
            this.mTitleMarginTopId = propertyMapper.mapInt("titleMarginTop", R.attr.titleMarginTop);
            this.mPropertiesMapped = true;
        }

        public void readProperties(@NonNull Toolbar toolbar, @NonNull PropertyReader propertyReader) {
            if (this.mPropertiesMapped) {
                propertyReader.readObject(this.mCollapseContentDescriptionId, toolbar.getCollapseContentDescription());
                propertyReader.readObject(this.mCollapseIconId, toolbar.getCollapseIcon());
                propertyReader.readInt(this.mContentInsetEndId, toolbar.getContentInsetEnd());
                propertyReader.readInt(this.mContentInsetEndWithActionsId, toolbar.getContentInsetEndWithActions());
                propertyReader.readInt(this.mContentInsetLeftId, toolbar.getContentInsetLeft());
                propertyReader.readInt(this.mContentInsetRightId, toolbar.getContentInsetRight());
                propertyReader.readInt(this.mContentInsetStartId, toolbar.getContentInsetStart());
                propertyReader.readInt(this.mContentInsetStartWithNavigationId, toolbar.getContentInsetStartWithNavigation());
                propertyReader.readObject(this.mLogoId, toolbar.getLogo());
                propertyReader.readObject(this.mLogoDescriptionId, toolbar.getLogoDescription());
                propertyReader.readObject(this.mMenuId, toolbar.getMenu());
                propertyReader.readObject(this.mNavigationContentDescriptionId, toolbar.getNavigationContentDescription());
                propertyReader.readObject(this.mNavigationIconId, toolbar.getNavigationIcon());
                propertyReader.readResourceId(this.mPopupThemeId, toolbar.getPopupTheme());
                propertyReader.readObject(this.mSubtitleId, toolbar.getSubtitle());
                propertyReader.readObject(this.mTitleId, toolbar.getTitle());
                propertyReader.readInt(this.mTitleMarginBottomId, toolbar.getTitleMarginBottom());
                propertyReader.readInt(this.mTitleMarginEndId, toolbar.getTitleMarginEnd());
                propertyReader.readInt(this.mTitleMarginStartId, toolbar.getTitleMarginStart());
                propertyReader.readInt(this.mTitleMarginTopId, toolbar.getTitleMarginTop());
                return;
            }
            throw c.a();
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addCustomViewsWithGravity(List<View> list, int i5) {
        boolean z4;
        if (getLayoutDirection() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i5, getLayoutDirection());
        list.clear();
        if (z4) {
            for (int i6 = childCount - 1; i6 >= 0; i6--) {
                View childAt = getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view, boolean z4) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.mViewType = 1;
        if (!z4 || this.mExpandedActionView == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.mHiddenViews.add(view);
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            updateBackInvokedCallbackState();
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new MenuBuilder.Callback() {
                public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                    MenuBuilder.Callback callback = Toolbar.this.mMenuBuilderCallback;
                    if (callback == null || !callback.onMenuItemSelected(menuBuilder, menuItem)) {
                        return false;
                    }
                    return true;
                }

                public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
                    if (!Toolbar.this.mMenuView.isOverflowMenuShowing()) {
                        Toolbar.this.mMenuHostHelper.onPrepareMenu(menuBuilder);
                    }
                    MenuBuilder.Callback callback = Toolbar.this.mMenuBuilderCallback;
                    if (callback != null) {
                        callback.onMenuModeChange(menuBuilder);
                    }
                }
            });
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | GravityCompat.END;
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | GravityCompat.START;
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i5) {
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i5, layoutDirection) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        if (layoutDirection == 1) {
            return 5;
        }
        return 3;
    }

    private int getChildTop(View view, int i5) {
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i5 > 0) {
            i6 = (measuredHeight - i5) / 2;
        } else {
            i6 = 0;
        }
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i6;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i7 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i8 = layoutParams.topMargin;
        if (i7 < i8) {
            i7 = i8;
        } else {
            int i9 = (((height - paddingBottom) - measuredHeight) - i7) - paddingTop;
            int i10 = layoutParams.bottomMargin;
            if (i9 < i10) {
                i7 = Math.max(0, i7 - (i10 - i9));
            }
        }
        return paddingTop + i7;
    }

    private int getChildVerticalGravity(int i5) {
        int i6 = i5 & 112;
        if (i6 == 16 || i6 == 48 || i6 == 80) {
            return i6;
        }
        return this.mGravity & 112;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i5 = 0; i5 < menu.size(); i5++) {
            arrayList.add(menu.getItem(i5));
        }
        return arrayList;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i5 = iArr[0];
        int i6 = iArr[1];
        int size = list.size();
        int i7 = 0;
        int i8 = 0;
        while (i7 < size) {
            View view = list.get(i7);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i9 = layoutParams.leftMargin - i5;
            int i10 = layoutParams.rightMargin - i6;
            int max = Math.max(0, i9);
            int max2 = Math.max(0, i10);
            int max3 = Math.max(0, -i9);
            int max4 = Math.max(0, -i10);
            i8 += max + view.getMeasuredWidth() + max2;
            i7++;
            i6 = max4;
            i5 = max3;
        }
        return i8;
    }

    private boolean isChildOrHidden(View view) {
        if (view.getParent() == this || this.mHiddenViews.contains(view)) {
            return true;
        }
        return false;
    }

    private int layoutChildLeft(View view, int i5, int[] iArr, int i6) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i7 = layoutParams.leftMargin - iArr[0];
        int max = i5 + Math.max(0, i7);
        iArr[0] = Math.max(0, -i7);
        int childTop = getChildTop(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int layoutChildRight(View view, int i5, int[] iArr, int i6) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i7 = layoutParams.rightMargin - iArr[1];
        int max = i5 - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int childTop = getChildTop(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i9) + Math.max(0, i10);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + max + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i5, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i9 >= 0) {
            if (mode != 0) {
                i9 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i9);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void onCreateMenu() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.mMenuHostHelper.onCreateMenu(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.mProvidedMenuItems = currentMenuItems2;
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        if (view == null || view.getParent() != this || view.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    @MainThread
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuHostHelper.addMenuProvider(menuProvider);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        if (getVisibility() != 0 || (actionMenuView = this.mMenuView) == null || !actionMenuView.isOverflowReserved()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!super.checkLayoutParams(layoutParams) || !(layoutParams instanceof LayoutParams)) {
            return false;
        }
        return true;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | GravityCompat.START;
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getEnd();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i5 = this.mContentInsetEndWithActions;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getLeft();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getRight();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getStart();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i5 = this.mContentInsetStartWithNavigation;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder peekMenu;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || (peekMenu = actionMenuView.peekMenu()) == null || !peekMenu.hasVisibleItems()) {
            return getContentInsetEnd();
        }
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    }

    public int getCurrentContentInsetLeft() {
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public View getNavButtonView() {
        return this.mNavButtonView;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) {
            return false;
        }
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || !actionMenuView.hideOverflowMenu()) {
            return false;
        }
        return true;
    }

    public void inflateMenu(@MenuRes int i5) {
        getMenuInflater().inflate(i5, getMenu());
    }

    @MainThread
    public void invalidateMenu() {
        ArrayList<MenuItem> arrayList = this.mProvidedMenuItems;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            MenuItem menuItem = arrayList.get(i5);
            i5++;
            getMenu().removeItem(menuItem.getItemId());
        }
        onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || !actionMenuView.isOverflowMenuShowPending()) {
            return false;
        }
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || !actionMenuView.isOverflowMenuShowing()) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i5 = 0; i5 < lineCount; i5++) {
            if (layout.getEllipsisCount(i5) > 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0297 A[LOOP:0: B:101:0x0295->B:102:0x0297, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02b5 A[LOOP:1: B:104:0x02b3->B:105:0x02b5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02ec A[LOOP:2: B:112:0x02ea->B:113:0x02ec, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = r0.getLayoutDirection()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000c
            r1 = r3
            goto L_0x000d
        L_0x000c:
            r1 = r2
        L_0x000d:
            int r4 = r0.getWidth()
            int r5 = r0.getHeight()
            int r6 = r0.getPaddingLeft()
            int r7 = r0.getPaddingRight()
            int r8 = r0.getPaddingTop()
            int r9 = r0.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.mTempMargins
            r11[r3] = r2
            r11[r2] = r2
            int r12 = androidx.core.view.ViewCompat.getMinimumHeight(r0)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = r2
        L_0x003b:
            android.widget.ImageButton r13 = r0.mNavButtonView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x0056
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildRight(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0058
        L_0x004e:
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildLeft(r13, r6, r11, r12)
        L_0x0054:
            r14 = r10
            goto L_0x0058
        L_0x0056:
            r13 = r6
            goto L_0x0054
        L_0x0058:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x006f
            if (r1 == 0) goto L_0x0069
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r14 = r0.layoutChildRight(r15, r14, r11, r12)
            goto L_0x006f
        L_0x0069:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r13 = r0.layoutChildLeft(r15, r13, r11, r12)
        L_0x006f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x0086
            if (r1 == 0) goto L_0x0080
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            int r13 = r0.layoutChildLeft(r15, r13, r11, r12)
            goto L_0x0086
        L_0x0080:
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            int r14 = r0.layoutChildRight(r15, r14, r11, r12)
        L_0x0086:
            int r15 = r0.getCurrentContentInsetLeft()
            int r16 = r0.getCurrentContentInsetRight()
            r20 = r3
            int r3 = r15 - r13
            int r3 = java.lang.Math.max(r2, r3)
            r11[r2] = r3
            int r3 = r10 - r14
            int r3 = r16 - r3
            int r3 = java.lang.Math.max(r2, r3)
            r11[r20] = r3
            int r3 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.mExpandedActionView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x00c3
            if (r1 == 0) goto L_0x00bd
            android.view.View r13 = r0.mExpandedActionView
            int r10 = r0.layoutChildRight(r13, r10, r11, r12)
            goto L_0x00c3
        L_0x00bd:
            android.view.View r13 = r0.mExpandedActionView
            int r3 = r0.layoutChildLeft(r13, r3, r11, r12)
        L_0x00c3:
            android.widget.ImageView r13 = r0.mLogoView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x00da
            if (r1 == 0) goto L_0x00d4
            android.widget.ImageView r13 = r0.mLogoView
            int r10 = r0.layoutChildRight(r13, r10, r11, r12)
            goto L_0x00da
        L_0x00d4:
            android.widget.ImageView r13 = r0.mLogoView
            int r3 = r0.layoutChildLeft(r13, r3, r11, r12)
        L_0x00da:
            android.widget.TextView r13 = r0.mTitleTextView
            boolean r13 = r0.shouldLayout(r13)
            android.widget.TextView r14 = r0.mSubtitleTextView
            boolean r14 = r0.shouldLayout(r14)
            if (r13 == 0) goto L_0x00ff
            android.widget.TextView r15 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r2 = r15.topMargin
            r23 = r1
            android.widget.TextView r1 = r0.mTitleTextView
            int r1 = r1.getMeasuredHeight()
            int r2 = r2 + r1
            int r1 = r15.bottomMargin
            int r1 = r1 + r2
            goto L_0x0102
        L_0x00ff:
            r23 = r1
            r1 = 0
        L_0x0102:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r2 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r2 = (androidx.appcompat.widget.Toolbar.LayoutParams) r2
            int r15 = r2.topMargin
            r22 = r1
            android.widget.TextView r1 = r0.mSubtitleTextView
            int r1 = r1.getMeasuredHeight()
            int r15 = r15 + r1
            int r1 = r2.bottomMargin
            int r15 = r15 + r1
            int r1 = r22 + r15
            goto L_0x011f
        L_0x011d:
            r22 = r1
        L_0x011f:
            if (r13 != 0) goto L_0x0127
            if (r14 == 0) goto L_0x0124
            goto L_0x0127
        L_0x0124:
            r1 = 0
            goto L_0x0287
        L_0x0127:
            if (r13 == 0) goto L_0x012c
            android.widget.TextView r2 = r0.mTitleTextView
            goto L_0x012e
        L_0x012c:
            android.widget.TextView r2 = r0.mSubtitleTextView
        L_0x012e:
            if (r14 == 0) goto L_0x0133
            android.widget.TextView r15 = r0.mSubtitleTextView
            goto L_0x0135
        L_0x0133:
            android.widget.TextView r15 = r0.mTitleTextView
        L_0x0135:
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r2 = (androidx.appcompat.widget.Toolbar.LayoutParams) r2
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            r22 = r1
            if (r13 == 0) goto L_0x014d
            android.widget.TextView r1 = r0.mTitleTextView
            int r1 = r1.getMeasuredWidth()
            if (r1 > 0) goto L_0x0157
        L_0x014d:
            if (r14 == 0) goto L_0x015a
            android.widget.TextView r1 = r0.mSubtitleTextView
            int r1 = r1.getMeasuredWidth()
            if (r1 <= 0) goto L_0x015a
        L_0x0157:
            r24 = r20
            goto L_0x015c
        L_0x015a:
            r24 = 0
        L_0x015c:
            int r1 = r0.mGravity
            r1 = r1 & 112(0x70, float:1.57E-43)
            r16 = r3
            r3 = 48
            if (r1 == r3) goto L_0x01a2
            r3 = 80
            if (r1 == r3) goto L_0x0198
            int r1 = r5 - r8
            int r1 = r1 - r9
            int r1 = r1 - r22
            int r1 = r1 / 2
            int r3 = r2.topMargin
            r17 = r3
            int r3 = r0.mTitleMarginTop
            r18 = r3
            int r3 = r17 + r18
            if (r1 >= r3) goto L_0x0180
            int r1 = r17 + r18
            goto L_0x0196
        L_0x0180:
            int r5 = r5 - r9
            int r5 = r5 - r22
            int r5 = r5 - r1
            int r5 = r5 - r8
            int r2 = r2.bottomMargin
            int r3 = r0.mTitleMarginBottom
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0196
            int r2 = r15.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r1 = r1 - r2
            r2 = 0
            int r1 = java.lang.Math.max(r2, r1)
        L_0x0196:
            int r8 = r8 + r1
            goto L_0x01ad
        L_0x0198:
            int r5 = r5 - r9
            int r1 = r15.bottomMargin
            int r5 = r5 - r1
            int r1 = r0.mTitleMarginBottom
            int r5 = r5 - r1
            int r8 = r5 - r22
            goto L_0x01ad
        L_0x01a2:
            int r1 = r0.getPaddingTop()
            int r2 = r2.topMargin
            int r1 = r1 + r2
            int r2 = r0.mTitleMarginTop
            int r8 = r1 + r2
        L_0x01ad:
            if (r23 == 0) goto L_0x021e
            if (r24 == 0) goto L_0x01b4
            int r1 = r0.mTitleMarginStart
            goto L_0x01b5
        L_0x01b4:
            r1 = 0
        L_0x01b5:
            r2 = r11[r20]
            int r1 = r1 - r2
            r2 = 0
            int r3 = java.lang.Math.max(r2, r1)
            int r10 = r10 - r3
            int r1 = -r1
            int r1 = java.lang.Math.max(r2, r1)
            r11[r20] = r1
            if (r13 == 0) goto L_0x01eb
            android.widget.TextView r1 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.mTitleTextView
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.mTitleTextView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r5 = r0.mTitleTextView
            r5.layout(r2, r8, r10, r3)
            int r5 = r0.mTitleMarginEnd
            int r2 = r2 - r5
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01ec
        L_0x01eb:
            r2 = r10
        L_0x01ec:
            if (r14 == 0) goto L_0x0212
            android.widget.TextView r1 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.mSubtitleTextView
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r5 = r0.mSubtitleTextView
            r5.layout(r1, r8, r10, r3)
            int r1 = r0.mTitleMarginEnd
            int r1 = r10 - r1
            goto L_0x0213
        L_0x0212:
            r1 = r10
        L_0x0213:
            if (r24 == 0) goto L_0x021a
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x021a:
            r3 = r16
            goto L_0x0124
        L_0x021e:
            if (r24 == 0) goto L_0x0224
            int r2 = r0.mTitleMarginStart
        L_0x0222:
            r1 = 0
            goto L_0x0226
        L_0x0224:
            r2 = 0
            goto L_0x0222
        L_0x0226:
            r3 = r11[r1]
            int r2 = r2 - r3
            int r3 = java.lang.Math.max(r1, r2)
            int r3 = r16 + r3
            int r2 = -r2
            int r2 = java.lang.Math.max(r1, r2)
            r11[r1] = r2
            if (r13 == 0) goto L_0x025b
            android.widget.TextView r2 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r2 = (androidx.appcompat.widget.Toolbar.LayoutParams) r2
            android.widget.TextView r5 = r0.mTitleTextView
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r3
            android.widget.TextView r9 = r0.mTitleTextView
            int r9 = r9.getMeasuredHeight()
            int r9 = r9 + r8
            android.widget.TextView r13 = r0.mTitleTextView
            r13.layout(r3, r8, r5, r9)
            int r8 = r0.mTitleMarginEnd
            int r5 = r5 + r8
            int r2 = r2.bottomMargin
            int r8 = r9 + r2
            goto L_0x025c
        L_0x025b:
            r5 = r3
        L_0x025c:
            if (r14 == 0) goto L_0x0280
            android.widget.TextView r2 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r2 = (androidx.appcompat.widget.Toolbar.LayoutParams) r2
            int r2 = r2.topMargin
            int r8 = r8 + r2
            android.widget.TextView r2 = r0.mSubtitleTextView
            int r2 = r2.getMeasuredWidth()
            int r2 = r2 + r3
            android.widget.TextView r9 = r0.mSubtitleTextView
            int r9 = r9.getMeasuredHeight()
            int r9 = r9 + r8
            android.widget.TextView r13 = r0.mSubtitleTextView
            r13.layout(r3, r8, r2, r9)
            int r8 = r0.mTitleMarginEnd
            int r2 = r2 + r8
            goto L_0x0281
        L_0x0280:
            r2 = r3
        L_0x0281:
            if (r24 == 0) goto L_0x0287
            int r3 = java.lang.Math.max(r5, r2)
        L_0x0287:
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            r5 = 3
            r0.addCustomViewsWithGravity(r2, r5)
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            int r2 = r2.size()
            r5 = r3
            r3 = r1
        L_0x0295:
            if (r3 >= r2) goto L_0x02a6
            java.util.ArrayList<android.view.View> r8 = r0.mTempViews
            java.lang.Object r8 = r8.get(r3)
            android.view.View r8 = (android.view.View) r8
            int r5 = r0.layoutChildLeft(r8, r5, r11, r12)
            int r3 = r3 + 1
            goto L_0x0295
        L_0x02a6:
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            r3 = 5
            r0.addCustomViewsWithGravity(r2, r3)
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            int r2 = r2.size()
            r3 = r1
        L_0x02b3:
            if (r3 >= r2) goto L_0x02c4
            java.util.ArrayList<android.view.View> r8 = r0.mTempViews
            java.lang.Object r8 = r8.get(r3)
            android.view.View r8 = (android.view.View) r8
            int r10 = r0.layoutChildRight(r8, r10, r11, r12)
            int r3 = r3 + 1
            goto L_0x02b3
        L_0x02c4:
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            r3 = r20
            r0.addCustomViewsWithGravity(r2, r3)
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            int r2 = r0.getViewListMeasuredWidth(r2, r11)
            int r4 = r4 - r6
            int r4 = r4 - r7
            int r4 = r4 / 2
            int r6 = r6 + r4
            int r3 = r2 / 2
            int r6 = r6 - r3
            int r2 = r2 + r6
            if (r6 >= r5) goto L_0x02dd
            goto L_0x02e4
        L_0x02dd:
            if (r2 <= r10) goto L_0x02e3
            int r2 = r2 - r10
            int r5 = r6 - r2
            goto L_0x02e4
        L_0x02e3:
            r5 = r6
        L_0x02e4:
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            int r2 = r2.size()
        L_0x02ea:
            if (r1 >= r2) goto L_0x02fb
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            java.lang.Object r3 = r3.get(r1)
            android.view.View r3 = (android.view.View) r3
            int r5 = r0.layoutChildLeft(r3, r5, r11, r12)
            int r1 = r1 + 1
            goto L_0x02ea
        L_0x02fb:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr2 = this.mTempMargins;
        char isLayoutRtl = ViewUtils.isLayoutRtl(this);
        char c5 = isLayoutRtl ^ 1;
        int i15 = 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i5, 0, i6, 0, this.mMaxButtonHeight);
            i9 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i8 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i7 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i9 = 0;
            i8 = 0;
            i7 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i5, 0, i6, 0, this.mMaxButtonHeight);
            i9 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i8 = Math.max(i8, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i7 = View.combineMeasuredStates(i7, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i9);
        iArr2[isLayoutRtl] = Math.max(0, currentContentInsetStart - i9);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i5, max, i6, 0, this.mMaxButtonHeight);
            i10 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i8 = Math.max(i8, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i7 = View.combineMeasuredStates(i7, this.mMenuView.getMeasuredState());
        } else {
            i10 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i10);
        iArr2[c5] = Math.max(0, currentContentInsetEnd - i10);
        if (shouldLayout(this.mExpandedActionView)) {
            iArr = iArr2;
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i5, max2, i6, 0, iArr);
            i8 = Math.max(i8, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i7 = View.combineMeasuredStates(i7, this.mExpandedActionView.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i5, max2, i6, 0, iArr);
            i8 = Math.max(i8, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i7 = View.combineMeasuredStates(i7, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType != 0 || !shouldLayout(childAt)) {
                i11 = i11;
            } else {
                i11 += measureChildCollapseMargins(childAt, i5, i11, i6, 0, iArr);
                int max3 = Math.max(i8, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i7 = View.combineMeasuredStates(i7, childAt.getMeasuredState());
                i8 = max3;
            }
        }
        int i17 = i11;
        int i18 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i19 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i5, i17 + i19, i6, i18, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            int measuredHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i14 = measuredWidth;
            i12 = View.combineMeasuredStates(i7, this.mTitleTextView.getMeasuredState());
            i13 = measuredHeight;
        } else {
            i14 = 0;
            i12 = i7;
            i13 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i14 = Math.max(i14, measureChildCollapseMargins(this.mSubtitleTextView, i5, i17 + i19, i6, i18 + i13, iArr));
            i13 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i12 = View.combineMeasuredStates(i12, this.mSubtitleTextView.getMeasuredState());
        }
        int max4 = Math.max(i8, i13);
        int paddingLeft = i17 + i14 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max4 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i5, -16777216 & i12);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i6, i12 << 16);
        if (!shouldCollapse()) {
            i15 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i15);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.peekMenu();
        } else {
            menuBuilder = null;
        }
        int i5 = savedState.expandedMenuItemId;
        if (!(i5 == 0 || this.mExpandedMenuPresenter == null || menuBuilder == null || (findItem = menuBuilder.findItem(i5)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean z4 = true;
        if (i5 != 1) {
            z4 = false;
        }
        rtlSpacingHelper.setDirection(z4);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (!(expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) == null)) {
            savedState.expandedMenuItemId = menuItemImpl.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    @MainThread
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z4) {
        if (this.mBackInvokedCallbackEnabled != z4) {
            this.mBackInvokedCallbackEnabled = z4;
            updateBackInvokedCallbackState();
        }
    }

    public void setCollapseContentDescription(@StringRes int i5) {
        setCollapseContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setCollapseIcon(@DrawableRes int i5) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), i5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z4) {
        this.mCollapsible = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i5, int i6) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(i5, i6);
    }

    public void setContentInsetsRelative(int i5, int i6) {
        ensureContentInsets();
        this.mContentInsets.setRelative(i5, i6);
    }

    public void setLogo(@DrawableRes int i5) {
        setLogo(AppCompatResources.getDrawable(getContext(), i5));
    }

    public void setLogoDescription(@StringRes int i5) {
        setLogoDescription(getContext().getText(i5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, (MenuBuilder) null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, (MenuBuilder) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
                updateBackInvokedCallbackState();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    public void setNavigationContentDescription(@StringRes int i5) {
        setNavigationContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setNavigationIcon(@DrawableRes int i5) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i5));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i5) {
        if (this.mPopupTheme != i5) {
            this.mPopupTheme = i5;
            if (i5 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setSubtitle(@StringRes int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i5) {
        this.mSubtitleTextAppearance = i5;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i5) {
        setSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setTitle(@StringRes int i5) {
        setTitle(getContext().getText(i5));
    }

    public void setTitleMargin(int i5, int i6, int i7, int i8) {
        this.mTitleMarginStart = i5;
        this.mTitleMarginTop = i6;
        this.mTitleMarginEnd = i7;
        this.mTitleMarginBottom = i8;
        requestLayout();
    }

    public void setTitleMarginBottom(int i5) {
        this.mTitleMarginBottom = i5;
        requestLayout();
    }

    public void setTitleMarginEnd(int i5) {
        this.mTitleMarginEnd = i5;
        requestLayout();
    }

    public void setTitleMarginStart(int i5) {
        this.mTitleMarginStart = i5;
        requestLayout();
    }

    public void setTitleMarginTop(int i5) {
        this.mTitleMarginTop = i5;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i5) {
        this.mTitleTextAppearance = i5;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public void setTitleTextColor(@ColorInt int i5) {
        setTitleTextColor(ColorStateList.valueOf(i5));
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || !actionMenuView.showOverflowMenu()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void updateBackInvokedCallbackState() {
        boolean z4;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher = Api33Impl.findOnBackInvokedDispatcher(this);
            if (!hasExpandedActionView() || findOnBackInvokedDispatcher == null || !isAttachedToWindow() || !this.mBackInvokedCallbackEnabled) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4 && this.mBackInvokedDispatcher == null) {
                if (this.mBackInvokedCallback == null) {
                    this.mBackInvokedCallback = Api33Impl.newOnBackInvokedCallback(new v(this));
                }
                Api33Impl.tryRegisterOnBackInvokedCallback(findOnBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = findOnBackInvokedDispatcher;
            } else if (!z4 && (onBackInvokedDispatcher = this.mBackInvokedDispatcher) != null) {
                Api33Impl.tryUnregisterOnBackInvokedCallback(onBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = null;
            }
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
        }

        /* access modifiers changed from: package-private */
        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
            this.mViewType = 0;
            this.gravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        }

        public LayoutParams(int i5, int i6, int i7) {
            super(i5, i6);
            this.mViewType = 0;
            this.gravity = i7;
        }

        public LayoutParams(int i5) {
            this(-2, -1, i5);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    @MainThread
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.mCollapseIcon);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            TooltipCompat.setTooltipText(this.mNavButtonView, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.mSubtitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.mSubtitleTextAppearance;
                if (i5 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.mTitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.mTitleTextAppearance;
                if (i5 != 0) {
                    this.mTitleTextView.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mGravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new w(this));
        this.mProvidedMenuItems = new ArrayList<>();
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.mMenuHostHelper.onMenuItemSelected(menuItem)) {
                    return true;
                }
                OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.mOnMenuItemClickListener;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        Context context2 = getContext();
        int[] iArr = R.styleable.Toolbar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i5, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        int i6 = R.styleable.Toolbar_titleMargins;
        dimensionPixelOffset = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getDimensionPixelOffset(i6, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.mContentInsets.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        int i7 = R.styleable.Toolbar_titleTextColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(i7));
        }
        int i8 = R.styleable.Toolbar_subtitleTextColor;
        if (obtainStyledAttributes.hasValue(i8)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(i8));
        }
        int i9 = R.styleable.Toolbar_menu;
        if (obtainStyledAttributes.hasValue(i9)) {
            inflateMenu(obtainStyledAttributes.getResourceId(i9, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
