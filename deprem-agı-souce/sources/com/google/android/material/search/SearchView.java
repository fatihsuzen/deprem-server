package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.shape.MaterialShapeUtils;
import j$.util.Objects;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior, MaterialBackHandler {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SearchView;
    private static final long TALKBACK_FOCUS_CHANGE_DELAY_MS = 100;
    private boolean animatedMenuItems;
    private boolean animatedNavigationIcon;
    private boolean autoShowKeyboard;
    private final boolean backHandlingEnabled;
    @NonNull
    private final MaterialBackOrchestrator backOrchestrator;
    @ColorInt
    private final int backgroundColor;
    final View backgroundView;
    private Map<View, Integer> childImportantForAccessibilityMap;
    final ImageButton clearButton;
    final TouchObserverFrameLayout contentContainer;
    @NonNull
    private TransitionState currentTransitionState;
    final View divider;
    final Toolbar dummyToolbar;
    final EditText editText;
    private final ElevationOverlayProvider elevationOverlayProvider;
    final FrameLayout headerContainer;
    private final boolean layoutInflated;
    final ClippableRoundedCornerLayout rootView;
    final View scrim;
    @Nullable
    private SearchBar searchBar;
    final TextView searchPrefix;
    private final SearchViewAnimationHelper searchViewAnimationHelper;
    private int softInputMode;
    final View statusBarSpacer;
    private boolean statusBarSpacerEnabledOverride;
    final LinearLayout textContainer;
    final MaterialToolbar toolbar;
    final FrameLayout toolbarContainer;
    private final Set<TransitionListener> transitionListeners;
    private boolean useWindowInsetsController;

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchView searchView, @NonNull View view) {
            if (searchView.isSetupWithSearchBar() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        String text;
        int visibility;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.text);
            parcel.writeInt(this.visibility);
        }

        public SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.text = parcel.readString();
            this.visibility = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface TransitionListener {
        void onStateChanged(@NonNull SearchView searchView, @NonNull TransitionState transitionState, @NonNull TransitionState transitionState2);
    }

    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ WindowInsetsCompat b(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        marginLayoutParams.leftMargin = i5 + insets.left;
        marginLayoutParams.rightMargin = i6 + insets.right;
        return windowInsetsCompat;
    }

    public static /* synthetic */ boolean c(SearchView searchView, View view, MotionEvent motionEvent) {
        if (!searchView.isAdjustNothingSoftInputMode()) {
            return false;
        }
        searchView.clearFocusAndHideKeyboard();
        return false;
    }

    public static /* synthetic */ void d(SearchView searchView) {
        searchView.editText.clearFocus();
        ViewUtils.hideKeyboard(searchView.editText, searchView.useWindowInsetsController);
    }

    public static /* synthetic */ void e(SearchView searchView) {
        if (searchView.editText.requestFocus()) {
            searchView.editText.sendAccessibilityEvent(8);
        }
        ViewUtils.showKeyboard(searchView.editText, searchView.useWindowInsetsController);
    }

    public static /* synthetic */ void f(SearchView searchView, View view) {
        searchView.clearText();
        searchView.requestFocusAndShowKeyboardIfNeeded();
    }

    public static /* synthetic */ WindowInsetsCompat g(SearchView searchView, View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        int i5;
        int i6;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(searchView.toolbar);
        if (isLayoutRtl) {
            i5 = relativePadding.end;
        } else {
            i5 = relativePadding.start;
        }
        if (isLayoutRtl) {
            i6 = relativePadding.start;
        } else {
            i6 = relativePadding.end;
        }
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        int i7 = i6 + insets.right;
        searchView.toolbar.setPadding(i5 + insets.left, relativePadding.top, i7, relativePadding.bottom);
        return windowInsetsCompat;
    }

    @Nullable
    private Window getActivityWindow() {
        Activity activity = ContextUtils.getActivity(getContext());
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar2 = this.searchBar;
        if (searchBar2 != null) {
            return searchBar2.getCompatElevation();
        }
        return getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    @Px
    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static /* synthetic */ WindowInsetsCompat h(SearchView searchView, View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z4;
        searchView.getClass();
        int i5 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()).top;
        searchView.setUpStatusBarSpacer(i5);
        if (!searchView.statusBarSpacerEnabledOverride) {
            if (i5 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            searchView.setStatusBarSpacerEnabledInternal(z4);
        }
        return windowInsetsCompat;
    }

    public static /* synthetic */ boolean i(View view, MotionEvent motionEvent) {
        return true;
    }

    private boolean isHiddenOrHiding() {
        if (this.currentTransitionState.equals(TransitionState.HIDDEN) || this.currentTransitionState.equals(TransitionState.HIDING)) {
            return true;
        }
        return false;
    }

    private boolean isNavigationIconDrawerArrowDrawable(@NonNull Toolbar toolbar2) {
        return DrawableCompat.unwrap(toolbar2.getNavigationIcon()) instanceof DrawerArrowDrawable;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z4) {
        int i5;
        View view = this.statusBarSpacer;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        view.setVisibility(i5);
    }

    private void setUpBackButton(boolean z4, boolean z5) {
        if (z5) {
            this.toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        this.toolbar.setNavigationOnClickListener(new k(this));
        if (z4) {
            DrawerArrowDrawable drawerArrowDrawable = new DrawerArrowDrawable(getContext());
            drawerArrowDrawable.setColor(MaterialColors.getColor(this, R.attr.colorOnSurface));
            this.toolbar.setNavigationIcon(drawerArrowDrawable);
        }
    }

    private void setUpBackgroundViewElevationOverlay() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void setUpClearButton() {
        this.clearButton.setOnClickListener(new n(this));
        this.editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                int i8;
                ImageButton imageButton = SearchView.this.clearButton;
                if (charSequence.length() > 0) {
                    i8 = 0;
                } else {
                    i8 = 8;
                }
                imageButton.setVisibility(i8);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpContentOnTouchListener() {
        this.contentContainer.setOnTouchListener(new v(this));
    }

    private void setUpDividerInsetListener() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.divider.getLayoutParams();
        ViewCompat.setOnApplyWindowInsetsListener(this.divider, new o(marginLayoutParams, marginLayoutParams.leftMargin, marginLayoutParams.rightMargin));
    }

    private void setUpEditText(@StyleRes int i5, String str, String str2) {
        if (i5 != -1) {
            TextViewCompat.setTextAppearance(this.editText, i5);
        }
        this.editText.setText(str);
        this.editText.setHint(str2);
    }

    private void setUpHeaderLayout(int i5) {
        if (i5 != -1) {
            addHeaderView(LayoutInflater.from(getContext()).inflate(i5, this.headerContainer, false));
        }
    }

    private void setUpInsetListeners() {
        setUpToolbarInsetListener();
        setUpDividerInsetListener();
        setUpStatusBarSpacerInsetListener();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpRootView() {
        this.rootView.setOnTouchListener(new u());
    }

    private void setUpStatusBarSpacer(@Px int i5) {
        if (this.statusBarSpacer.getLayoutParams().height != i5) {
            this.statusBarSpacer.getLayoutParams().height = i5;
            this.statusBarSpacer.requestLayout();
        }
    }

    private void setUpStatusBarSpacerInsetListener() {
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.setOnApplyWindowInsetsListener(this.statusBarSpacer, new r(this));
    }

    private void setUpToolbarInsetListener() {
        ViewUtils.doOnApplyWindowInsets(this.toolbar, new q(this));
    }

    @SuppressLint({"InlinedApi"})
    private void updateChildImportantForAccessibility(ViewGroup viewGroup, boolean z4) {
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt != this) {
                if (childAt.findViewById(this.rootView.getId()) != null) {
                    updateChildImportantForAccessibility((ViewGroup) childAt, z4);
                } else if (!z4) {
                    Map<View, Integer> map = this.childImportantForAccessibilityMap;
                    if (map != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(this.childImportantForAccessibilityMap.get(childAt).intValue());
                    }
                } else {
                    this.childImportantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    childAt.setImportantForAccessibility(4);
                }
            }
        }
    }

    private void updateListeningForBackCallbacks(@NonNull TransitionState transitionState) {
        if (this.searchBar != null && this.backHandlingEnabled) {
            if (transitionState.equals(TransitionState.SHOWN)) {
                this.backOrchestrator.startListeningForBackCallbacks();
            } else if (transitionState.equals(TransitionState.HIDDEN)) {
                this.backOrchestrator.stopListeningForBackCallbacks();
            }
        }
    }

    private void updateModalForAccessibility(@NonNull TransitionState transitionState) {
        if (transitionState == TransitionState.SHOWN) {
            setModalForAccessibility(true);
        } else if (transitionState == TransitionState.HIDDEN) {
            setModalForAccessibility(false);
        }
    }

    private void updateNavigationIconIfNeeded() {
        MaterialToolbar materialToolbar = this.toolbar;
        if (materialToolbar != null && !isNavigationIconDrawerArrowDrawable(materialToolbar)) {
            int defaultNavigationIconResource = getDefaultNavigationIconResource();
            if (this.searchBar == null) {
                this.toolbar.setNavigationIcon(defaultNavigationIconResource);
                return;
            }
            Drawable wrap = DrawableCompat.wrap(AppCompatResources.getDrawable(getContext(), defaultNavigationIconResource).mutate());
            if (this.toolbar.getNavigationIconTint() != null) {
                wrap.setTint(this.toolbar.getNavigationIconTint().intValue());
            }
            DrawableCompat.setLayoutDirection(wrap, getLayoutDirection());
            this.toolbar.setNavigationIcon(new FadeThroughDrawable(this.searchBar.getNavigationIcon(), wrap));
            updateNavigationIconProgressIfNeeded();
        }
    }

    private void updateNavigationIconProgressIfNeeded() {
        int i5;
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (navigationIconButton != null) {
            if (this.rootView.getVisibility() == 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            Drawable unwrap = DrawableCompat.unwrap(navigationIconButton.getDrawable());
            if (unwrap instanceof DrawerArrowDrawable) {
                ((DrawerArrowDrawable) unwrap).setProgress((float) i5);
            }
            if (unwrap instanceof FadeThroughDrawable) {
                ((FadeThroughDrawable) unwrap).setProgress((float) i5);
            }
        }
    }

    public void addHeaderView(@NonNull View view) {
        this.headerContainer.addView(view);
        this.headerContainer.setVisibility(0);
    }

    public void addTransitionListener(@NonNull TransitionListener transitionListener) {
        this.transitionListeners.add(transitionListener);
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (this.layoutInflated) {
            this.contentContainer.addView(view, i5, layoutParams);
        } else {
            super.addView(view, i5, layoutParams);
        }
    }

    public void cancelBackProgress() {
        if (!isHiddenOrHiding() && this.searchBar != null && Build.VERSION.SDK_INT >= 34) {
            this.searchViewAnimationHelper.cancelBackProgress();
        }
    }

    public void clearFocusAndHideKeyboard() {
        this.editText.post(new l(this));
    }

    public void clearText() {
        this.editText.setText("");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.searchViewAnimationHelper.getBackHelper();
    }

    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.currentTransitionState;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    @NonNull
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getHint() {
        return this.editText.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.searchPrefix;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.searchPrefix.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.softInputMode;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @NonNull
    public Editable getText() {
        return this.editText.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public void handleBackInvoked() {
        if (!isHiddenOrHiding()) {
            BackEventCompat onHandleBackInvoked = this.searchViewAnimationHelper.onHandleBackInvoked();
            if (Build.VERSION.SDK_INT < 34 || this.searchBar == null || onHandleBackInvoked == null) {
                hide();
            } else {
                this.searchViewAnimationHelper.finishBackProgress();
            }
        }
    }

    public void hide() {
        if (!this.currentTransitionState.equals(TransitionState.HIDDEN) && !this.currentTransitionState.equals(TransitionState.HIDING)) {
            SearchBar searchBar2 = this.searchBar;
            if (searchBar2 == null || !searchBar2.isAttachedToWindow()) {
                this.searchViewAnimationHelper.hide();
                return;
            }
            this.searchBar.setPlaceholderText(this.editText.getText().toString());
            SearchBar searchBar3 = this.searchBar;
            SearchViewAnimationHelper searchViewAnimationHelper2 = this.searchViewAnimationHelper;
            Objects.requireNonNull(searchViewAnimationHelper2);
            searchBar3.post(new m(searchViewAnimationHelper2));
        }
    }

    public void inflateMenu(@MenuRes int i5) {
        this.toolbar.inflateMenu(i5);
    }

    /* access modifiers changed from: package-private */
    public boolean isAdjustNothingSoftInputMode() {
        if (this.softInputMode == 48) {
            return true;
        }
        return false;
    }

    public boolean isAnimatedNavigationIcon() {
        return this.animatedNavigationIcon;
    }

    public boolean isAutoShowKeyboard() {
        return this.autoShowKeyboard;
    }

    public boolean isMenuItemsAnimated() {
        return this.animatedMenuItems;
    }

    public boolean isSetupWithSearchBar() {
        if (this.searchBar != null) {
            return true;
        }
        return false;
    }

    public boolean isShowing() {
        if (this.currentTransitionState.equals(TransitionState.SHOWN) || this.currentTransitionState.equals(TransitionState.SHOWING)) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUseWindowInsetsController() {
        return this.useWindowInsetsController;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        TransitionState currentTransitionState2 = getCurrentTransitionState();
        updateModalForAccessibility(currentTransitionState2);
        updateListeningForBackCallbacks(currentTransitionState2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setModalForAccessibility(false);
        this.backOrchestrator.stopListeningForBackCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        updateSoftInputMode();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean z4;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText((CharSequence) savedState.text);
        if (savedState.visibility == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        setVisible(z4);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        String str;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        if (text == null) {
            str = null;
        } else {
            str = text.toString();
        }
        savedState.text = str;
        savedState.visibility = this.rootView.getVisibility();
        return savedState;
    }

    public void removeAllHeaderViews() {
        this.headerContainer.removeAllViews();
        this.headerContainer.setVisibility(8);
    }

    public void removeHeaderView(@NonNull View view) {
        this.headerContainer.removeView(view);
        if (this.headerContainer.getChildCount() == 0) {
            this.headerContainer.setVisibility(8);
        }
    }

    public void removeTransitionListener(@NonNull TransitionListener transitionListener) {
        this.transitionListeners.remove(transitionListener);
    }

    public void requestFocusAndShowKeyboard() {
        this.editText.postDelayed(new p(this), TALKBACK_FOCUS_CHANGE_DELAY_MS);
    }

    /* access modifiers changed from: package-private */
    public void requestFocusAndShowKeyboardIfNeeded() {
        if (this.autoShowKeyboard) {
            requestFocusAndShowKeyboard();
        }
    }

    public void setAnimatedNavigationIcon(boolean z4) {
        this.animatedNavigationIcon = z4;
    }

    public void setAutoShowKeyboard(boolean z4) {
        this.autoShowKeyboard = z4;
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        setUpBackgroundViewElevationOverlay(f5);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.editText.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z4) {
        this.animatedMenuItems = z4;
    }

    public void setModalForAccessibility(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z4) {
            this.childImportantForAccessibilityMap = new HashMap(viewGroup.getChildCount());
        }
        updateChildImportantForAccessibility(viewGroup, z4);
        if (!z4) {
            this.childImportantForAccessibilityMap = null;
        }
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        int i5;
        this.searchPrefix.setText(charSequence);
        TextView textView = this.searchPrefix;
        if (TextUtils.isEmpty(charSequence)) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        textView.setVisibility(i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStatusBarSpacerEnabled(boolean z4) {
        this.statusBarSpacerEnabledOverride = true;
        setStatusBarSpacerEnabledInternal(z4);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.editText.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z4) {
        this.toolbar.setTouchscreenBlocksFocus(z4);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionState(@NonNull TransitionState transitionState) {
        setTransitionState(transitionState, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setUseWindowInsetsController(boolean z4) {
        this.useWindowInsetsController = z4;
    }

    public void setVisible(boolean z4) {
        boolean z5;
        int i5;
        TransitionState transitionState;
        boolean z6 = true;
        if (this.rootView.getVisibility() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.rootView;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        clippableRoundedCornerLayout.setVisibility(i5);
        updateNavigationIconProgressIfNeeded();
        if (z4) {
            transitionState = TransitionState.SHOWN;
        } else {
            transitionState = TransitionState.HIDDEN;
        }
        if (z5 == z4) {
            z6 = false;
        }
        setTransitionState(transitionState, z6);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar2) {
        this.searchBar = searchBar2;
        this.searchViewAnimationHelper.setSearchBar(searchBar2);
        if (searchBar2 != null) {
            searchBar2.setOnClickListener(new s(this));
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar2.setHandwritingDelegatorCallback(new t(this));
                    this.editText.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        updateNavigationIconIfNeeded();
        setUpBackgroundViewElevationOverlay();
        updateListeningForBackCallbacks(getCurrentTransitionState());
    }

    public void show() {
        if (!this.currentTransitionState.equals(TransitionState.SHOWN) && !this.currentTransitionState.equals(TransitionState.SHOWING)) {
            this.searchViewAnimationHelper.show();
        }
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        SearchBar searchBar2;
        if (!isHiddenOrHiding() && (searchBar2 = this.searchBar) != null) {
            if (searchBar2 != null) {
                searchBar2.setPlaceholderText(this.editText.getText().toString());
            }
            this.searchViewAnimationHelper.startBackProgress(backEventCompat);
        }
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        if (!isHiddenOrHiding() && this.searchBar != null && Build.VERSION.SDK_INT >= 34) {
            this.searchViewAnimationHelper.updateBackProgress(backEventCompat);
        }
    }

    public void updateSoftInputMode() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.softInputMode = activityWindow.getAttributes().softInputMode;
        }
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchViewStyle);
    }

    private void setTransitionState(@NonNull TransitionState transitionState, boolean z4) {
        if (!this.currentTransitionState.equals(transitionState)) {
            if (z4) {
                updateModalForAccessibility(transitionState);
            }
            TransitionState transitionState2 = this.currentTransitionState;
            this.currentTransitionState = transitionState;
            for (TransitionListener onStateChanged : new LinkedHashSet(this.transitionListeners)) {
                onStateChanged.onStateChanged(this, transitionState2, transitionState);
            }
            updateListeningForBackCallbacks(transitionState);
            SearchBar searchBar2 = this.searchBar;
            if (searchBar2 != null && transitionState == TransitionState.HIDDEN) {
                searchBar2.sendAccessibilityEvent(8);
            }
        }
    }

    private void setUpBackgroundViewElevationOverlay(float f5) {
        ElevationOverlayProvider elevationOverlayProvider2 = this.elevationOverlayProvider;
        if (elevationOverlayProvider2 != null && this.backgroundView != null) {
            this.backgroundView.setBackgroundColor(elevationOverlayProvider2.compositeOverlayIfNeeded(this.backgroundColor, f5));
        }
    }

    public void setHint(@StringRes int i5) {
        this.editText.setHint(i5);
    }

    public void setText(@StringRes int i5) {
        this.editText.setText(i5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchView(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            com.google.android.material.motion.MaterialBackOrchestrator r9 = new com.google.android.material.motion.MaterialBackOrchestrator
            r9.<init>(r8)
            r8.backOrchestrator = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.transitionListeners = r9
            r9 = 16
            r8.softInputMode = r9
            com.google.android.material.search.SearchView$TransitionState r9 = com.google.android.material.search.SearchView.TransitionState.HIDDEN
            r8.currentTransitionState = r9
            android.content.Context r0 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.SearchView
            r9 = 0
            int[] r5 = new int[r9]
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R.styleable.SearchView_backgroundTint
            int r11 = r10.getColor(r11, r9)
            r8.backgroundColor = r11
            int r11 = com.google.android.material.R.styleable.SearchView_headerLayout
            r1 = -1
            int r11 = r10.getResourceId(r11, r1)
            int r2 = com.google.android.material.R.styleable.SearchView_android_textAppearance
            int r1 = r10.getResourceId(r2, r1)
            int r2 = com.google.android.material.R.styleable.SearchView_android_text
            java.lang.String r2 = r10.getString(r2)
            int r3 = com.google.android.material.R.styleable.SearchView_android_hint
            java.lang.String r3 = r10.getString(r3)
            int r4 = com.google.android.material.R.styleable.SearchView_searchPrefixText
            java.lang.String r4 = r10.getString(r4)
            int r5 = com.google.android.material.R.styleable.SearchView_useDrawerArrowDrawable
            boolean r5 = r10.getBoolean(r5, r9)
            int r6 = com.google.android.material.R.styleable.SearchView_animateNavigationIcon
            r7 = 1
            boolean r6 = r10.getBoolean(r6, r7)
            r8.animatedNavigationIcon = r6
            int r6 = com.google.android.material.R.styleable.SearchView_animateMenuItems
            boolean r6 = r10.getBoolean(r6, r7)
            r8.animatedMenuItems = r6
            int r6 = com.google.android.material.R.styleable.SearchView_hideNavigationIcon
            boolean r9 = r10.getBoolean(r6, r9)
            int r6 = com.google.android.material.R.styleable.SearchView_autoShowKeyboard
            boolean r6 = r10.getBoolean(r6, r7)
            r8.autoShowKeyboard = r6
            int r6 = com.google.android.material.R.styleable.SearchView_backHandlingEnabled
            boolean r6 = r10.getBoolean(r6, r7)
            r8.backHandlingEnabled = r6
            r10.recycle()
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r0)
            int r6 = com.google.android.material.R.layout.mtrl_search_view
            r10.inflate(r6, r8)
            r8.layoutInflated = r7
            int r10 = com.google.android.material.R.id.open_search_view_scrim
            android.view.View r10 = r8.findViewById(r10)
            r8.scrim = r10
            int r10 = com.google.android.material.R.id.open_search_view_root
            android.view.View r10 = r8.findViewById(r10)
            com.google.android.material.internal.ClippableRoundedCornerLayout r10 = (com.google.android.material.internal.ClippableRoundedCornerLayout) r10
            r8.rootView = r10
            int r10 = com.google.android.material.R.id.open_search_view_background
            android.view.View r10 = r8.findViewById(r10)
            r8.backgroundView = r10
            int r10 = com.google.android.material.R.id.open_search_view_status_bar_spacer
            android.view.View r10 = r8.findViewById(r10)
            r8.statusBarSpacer = r10
            int r10 = com.google.android.material.R.id.open_search_view_header_container
            android.view.View r10 = r8.findViewById(r10)
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            r8.headerContainer = r10
            int r10 = com.google.android.material.R.id.open_search_view_toolbar_container
            android.view.View r10 = r8.findViewById(r10)
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            r8.toolbarContainer = r10
            int r10 = com.google.android.material.R.id.open_search_view_toolbar
            android.view.View r10 = r8.findViewById(r10)
            com.google.android.material.appbar.MaterialToolbar r10 = (com.google.android.material.appbar.MaterialToolbar) r10
            r8.toolbar = r10
            int r10 = com.google.android.material.R.id.open_search_view_dummy_toolbar
            android.view.View r10 = r8.findViewById(r10)
            androidx.appcompat.widget.Toolbar r10 = (androidx.appcompat.widget.Toolbar) r10
            r8.dummyToolbar = r10
            int r10 = com.google.android.material.R.id.open_search_view_search_prefix
            android.view.View r10 = r8.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r8.searchPrefix = r10
            int r10 = com.google.android.material.R.id.open_search_view_text_container
            android.view.View r10 = r8.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r8.textContainer = r10
            int r10 = com.google.android.material.R.id.open_search_view_edit_text
            android.view.View r10 = r8.findViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            r8.editText = r10
            int r10 = com.google.android.material.R.id.open_search_view_clear_button
            android.view.View r10 = r8.findViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            r8.clearButton = r10
            int r10 = com.google.android.material.R.id.open_search_view_divider
            android.view.View r10 = r8.findViewById(r10)
            r8.divider = r10
            int r10 = com.google.android.material.R.id.open_search_view_content_container
            android.view.View r10 = r8.findViewById(r10)
            com.google.android.material.internal.TouchObserverFrameLayout r10 = (com.google.android.material.internal.TouchObserverFrameLayout) r10
            r8.contentContainer = r10
            com.google.android.material.search.SearchViewAnimationHelper r10 = new com.google.android.material.search.SearchViewAnimationHelper
            r10.<init>(r8)
            r8.searchViewAnimationHelper = r10
            com.google.android.material.elevation.ElevationOverlayProvider r10 = new com.google.android.material.elevation.ElevationOverlayProvider
            r10.<init>(r0)
            r8.elevationOverlayProvider = r10
            r8.setUpRootView()
            r8.setUpBackgroundViewElevationOverlay()
            r8.setUpHeaderLayout(r11)
            r8.setSearchPrefixText(r4)
            r8.setUpEditText(r1, r2, r3)
            r8.setUpBackButton(r5, r9)
            r8.setUpClearButton()
            r8.setUpContentOnTouchListener()
            r8.setUpInsetListeners()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
