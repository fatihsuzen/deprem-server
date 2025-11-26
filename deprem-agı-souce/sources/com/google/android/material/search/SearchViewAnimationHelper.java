package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.search.SearchView;
import j$.util.Objects;

class SearchViewAnimationHelper {
    private static final float CONTENT_FROM_SCALE = 0.95f;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS = 42;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_ALPHA_DURATION_MS = 83;
    private static final long HIDE_CONTENT_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_SCALE_DURATION_MS = 250;
    private static final long HIDE_DURATION_MS = 250;
    private static final long HIDE_TRANSLATE_DURATION_MS = 300;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS = 50;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 250;
    private static final long SHOW_CONTENT_ALPHA_DURATION_MS = 150;
    private static final long SHOW_CONTENT_ALPHA_START_DELAY_MS = 75;
    private static final long SHOW_CONTENT_SCALE_DURATION_MS = 300;
    private static final long SHOW_DURATION_MS = 300;
    private static final long SHOW_SCRIM_ALPHA_DURATION_MS = 100;
    private static final long SHOW_TRANSLATE_DURATION_MS = 350;
    private static final long SHOW_TRANSLATE_KEYBOARD_START_DELAY_MS = 150;
    /* access modifiers changed from: private */
    public final MaterialMainContainerBackHelper backHelper;
    @Nullable
    private AnimatorSet backProgressAnimatorSet;
    private final ImageButton clearButton;
    private final TouchObserverFrameLayout contentContainer;
    private final View divider;
    private final Toolbar dummyToolbar;
    /* access modifiers changed from: private */
    public final EditText editText;
    private final FrameLayout headerContainer;
    /* access modifiers changed from: private */
    public final ClippableRoundedCornerLayout rootView;
    private final View scrim;
    /* access modifiers changed from: private */
    public SearchBar searchBar;
    private final TextView searchPrefix;
    /* access modifiers changed from: private */
    public final SearchView searchView;
    private final LinearLayout textContainer;
    private final Toolbar toolbar;
    private final FrameLayout toolbarContainer;

    SearchViewAnimationHelper(SearchView searchView2) {
        this.searchView = searchView2;
        this.scrim = searchView2.scrim;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView2.rootView;
        this.rootView = clippableRoundedCornerLayout;
        this.headerContainer = searchView2.headerContainer;
        this.toolbarContainer = searchView2.toolbarContainer;
        this.toolbar = searchView2.toolbar;
        this.dummyToolbar = searchView2.dummyToolbar;
        this.searchPrefix = searchView2.searchPrefix;
        this.editText = searchView2.editText;
        this.clearButton = searchView2.clearButton;
        this.divider = searchView2.divider;
        this.contentContainer = searchView2.contentContainer;
        this.textContainer = searchView2.textContainer;
        this.backHelper = new MaterialMainContainerBackHelper(clippableRoundedCornerLayout);
    }

    public static /* synthetic */ void a(SearchViewAnimationHelper searchViewAnimationHelper) {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchViewAnimationHelper.rootView;
        clippableRoundedCornerLayout.setTranslationY((float) clippableRoundedCornerLayout.getHeight());
        AnimatorSet translateAnimatorSet = searchViewAnimationHelper.getTranslateAnimatorSet(true);
        translateAnimatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.requestFocusAndShowKeyboardIfNeeded();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.SHOWN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.rootView.setVisibility(0);
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
            }
        });
        translateAnimatorSet.start();
    }

    private void addActionMenuViewAnimatorIfNeeded(AnimatorSet animatorSet) {
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this.toolbar);
        if (actionMenuView != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) getTranslationXBetweenViews(ToolbarUtils.getActionMenuView(this.searchBar), actionMenuView), 0.0f});
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(actionMenuView));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) getFromTranslationY(), 0.0f});
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(actionMenuView));
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }
    }

    private void addBackButtonAnimatorIfNeeded(AnimatorSet animatorSet, ImageButton imageButton) {
        SearchBar searchBar2 = this.searchBar;
        if (searchBar2 != null && searchBar2.getNavigationIcon() == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new y(imageButton));
            animatorSet.playTogether(new Animator[]{ofFloat});
        }
    }

    private void addBackButtonProgressAnimatorIfNeeded(AnimatorSet animatorSet) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (navigationIconButton != null) {
            Drawable unwrap = DrawableCompat.unwrap(navigationIconButton.getDrawable());
            if (this.searchView.isAnimatedNavigationIcon()) {
                addDrawerArrowDrawableAnimatorIfNeeded(animatorSet, unwrap);
                addFadeThroughDrawableAnimatorIfNeeded(animatorSet, unwrap);
                addBackButtonAnimatorIfNeeded(animatorSet, navigationIconButton);
                return;
            }
            setFullDrawableProgressIfNeeded(unwrap);
        }
    }

    private void addBackButtonTranslationAnimatorIfNeeded(AnimatorSet animatorSet) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (navigationIconButton != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) getTranslationXBetweenViews(ToolbarUtils.getNavigationIconButton(this.searchBar), navigationIconButton), 0.0f});
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(navigationIconButton));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) getFromTranslationY(), 0.0f});
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(navigationIconButton));
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }
    }

    private void addDrawerArrowDrawableAnimatorIfNeeded(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new B((DrawerArrowDrawable) drawable));
            animatorSet.playTogether(new Animator[]{ofFloat});
        }
    }

    private void addEditTextClipAnimator(AnimatorSet animatorSet) {
        if (this.searchBar != null && TextUtils.equals(this.editText.getText(), this.searchBar.getText())) {
            Rect rect = new Rect(0, 0, this.editText.getWidth(), this.editText.getHeight());
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.searchBar.getTextView().getWidth(), this.editText.getWidth()});
            ofInt.addUpdateListener(new z(this, rect));
            animatorSet.playTogether(new Animator[]{ofInt});
        }
    }

    private void addFadeThroughDrawableAnimatorIfNeeded(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof FadeThroughDrawable) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new D((FadeThroughDrawable) drawable));
            animatorSet.playTogether(new Animator[]{ofFloat});
        }
    }

    private void addTextFadeAnimatorIfNeeded(AnimatorSet animatorSet) {
        if (this.searchBar != null && !TextUtils.equals(this.editText.getText(), this.searchBar.getText())) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new E(this));
            animatorSet.playTogether(new Animator[]{ofFloat});
        }
    }

    public static /* synthetic */ void b(SearchViewAnimationHelper searchViewAnimationHelper, ValueAnimator valueAnimator) {
        searchViewAnimationHelper.editText.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        searchViewAnimationHelper.searchBar.getTextView().setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void c(SearchViewAnimationHelper searchViewAnimationHelper, Rect rect, ValueAnimator valueAnimator) {
        searchViewAnimationHelper.getClass();
        rect.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        searchViewAnimationHelper.editText.setClipBounds(rect);
    }

    public static /* synthetic */ void d(SearchViewAnimationHelper searchViewAnimationHelper) {
        AnimatorSet expandCollapseAnimatorSet = searchViewAnimationHelper.getExpandCollapseAnimatorSet(true);
        expandCollapseAnimatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.requestFocusAndShowKeyboardIfNeeded();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.SHOWN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.rootView.setVisibility(0);
                SearchViewAnimationHelper.this.searchBar.stopOnLoadAnimation();
            }
        });
        expandCollapseAnimatorSet.start();
    }

    public static /* synthetic */ void g(SearchViewAnimationHelper searchViewAnimationHelper, float f5, float[] fArr, Rect rect, ValueAnimator valueAnimator) {
        searchViewAnimationHelper.getClass();
        searchViewAnimationHelper.rootView.updateClipBoundsAndCornerRadii(rect, lerpCornerRadii(f5, fArr, valueAnimator.getAnimatedFraction()));
    }

    private Animator getActionMenuViewsAlphaAnimator(boolean z4) {
        long j5;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        ofFloat.setDuration(j5);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.searchView.isMenuItemsAnimated()) {
            ofFloat.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(this.dummyToolbar), ToolbarUtils.getActionMenuView(this.toolbar)));
        }
        return ofFloat;
    }

    private AnimatorSet getButtonsProgressAnimator(boolean z4) {
        long j5;
        AnimatorSet animatorSet = new AnimatorSet();
        addBackButtonProgressAnimatorIfNeeded(animatorSet);
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        animatorSet.setDuration(j5);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private AnimatorSet getButtonsTranslationAnimator(boolean z4) {
        long j5;
        AnimatorSet animatorSet = new AnimatorSet();
        addBackButtonTranslationAnimatorIfNeeded(animatorSet);
        addActionMenuViewAnimatorIfNeeded(animatorSet);
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        animatorSet.setDuration(j5);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private Animator getClearButtonAnimator(boolean z4) {
        long j5;
        long j6;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (z4) {
            j5 = SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS;
        } else {
            j5 = HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS;
        }
        ofFloat.setDuration(j5);
        if (z4) {
            j6 = 250;
        } else {
            j6 = 0;
        }
        ofFloat.setStartDelay(j6);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.LINEAR_INTERPOLATOR));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.clearButton));
        return ofFloat;
    }

    private Animator getContentAlphaAnimator(boolean z4) {
        long j5;
        long j6;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (z4) {
            j5 = 150;
        } else {
            j5 = HIDE_CONTENT_ALPHA_DURATION_MS;
        }
        ofFloat.setDuration(j5);
        if (z4) {
            j6 = 75;
        } else {
            j6 = 0;
        }
        ofFloat.setStartDelay(j6);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.LINEAR_INTERPOLATOR));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.divider, this.contentContainer));
        return ofFloat;
    }

    private Animator getContentAnimator(boolean z4) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{getContentAlphaAnimator(z4), getDividerAnimator(z4), getContentScaleAnimator(z4)});
        return animatorSet;
    }

    private Animator getContentScaleAnimator(boolean z4) {
        long j5;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{CONTENT_FROM_SCALE, 1.0f});
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        ofFloat.setDuration(j5);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        ofFloat.addUpdateListener(MultiViewUpdateListener.scaleListener(this.contentContainer));
        return ofFloat;
    }

    private Animator getDividerAnimator(boolean z4) {
        long j5;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(((float) this.contentContainer.getHeight()) * 0.050000012f) / 2.0f, 0.0f});
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        ofFloat.setDuration(j5);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(this.divider));
        return ofFloat;
    }

    private Animator getDummyToolbarAnimator(boolean z4) {
        Toolbar toolbar2 = this.dummyToolbar;
        return getTranslationAnimator(z4, toolbar2, getFromTranslationXEnd(toolbar2), getFromTranslationY());
    }

    private Animator getEditTextAnimator(boolean z4) {
        return getTranslationAnimatorForText(z4, this.editText);
    }

    private AnimatorSet getExpandCollapseAnimatorSet(boolean z4) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.backProgressAnimatorSet == null) {
            animatorSet.playTogether(new Animator[]{getButtonsProgressAnimator(z4), getButtonsTranslationAnimator(z4)});
        }
        animatorSet.playTogether(new Animator[]{getScrimAlphaAnimator(z4), getRootViewAnimator(z4), getClearButtonAnimator(z4), getContentAnimator(z4), getHeaderContainerAnimator(z4), getDummyToolbarAnimator(z4), getActionMenuViewsAlphaAnimator(z4), getEditTextAnimator(z4), getSearchPrefixAnimator(z4), getTextAnimator(z4)});
        final boolean z5 = z4;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                float f5;
                SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
                if (z5) {
                    f5 = 1.0f;
                } else {
                    f5 = 0.0f;
                }
                searchViewAnimationHelper.setContentViewsAlpha(f5);
                SearchViewAnimationHelper.this.editText.setAlpha(1.0f);
                if (SearchViewAnimationHelper.this.searchBar != null) {
                    SearchViewAnimationHelper.this.searchBar.getTextView().setAlpha(1.0f);
                }
                SearchViewAnimationHelper.this.editText.setClipBounds((Rect) null);
                SearchViewAnimationHelper.this.rootView.resetClipBoundsAndCornerRadii();
                if (!z5) {
                    SearchViewAnimationHelper.this.backHelper.clearExpandedCornerRadii();
                }
            }

            public void onAnimationStart(Animator animator) {
                float f5;
                SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
                if (z5) {
                    f5 = 0.0f;
                } else {
                    f5 = 1.0f;
                }
                searchViewAnimationHelper.setContentViewsAlpha(f5);
            }
        });
        return animatorSet;
    }

    private int getFromTranslationXEnd(View view) {
        int marginEnd = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
        int viewLeftFromSearchViewParent = getViewLeftFromSearchViewParent(this.searchBar);
        if (ViewUtils.isLayoutRtl(this.searchBar)) {
            return viewLeftFromSearchViewParent - marginEnd;
        }
        return ((viewLeftFromSearchViewParent + this.searchBar.getWidth()) + marginEnd) - this.searchView.getWidth();
    }

    private int getFromTranslationY() {
        return (getViewTopFromSearchViewParent(this.searchBar) + (this.searchBar.getHeight() / 2)) - (this.toolbarContainer.getTop() + (this.toolbarContainer.getHeight() / 2));
    }

    private Animator getHeaderContainerAnimator(boolean z4) {
        FrameLayout frameLayout = this.headerContainer;
        return getTranslationAnimator(z4, frameLayout, getFromTranslationXEnd(frameLayout), getFromTranslationY());
    }

    private Animator getRootViewAnimator(boolean z4) {
        long j5;
        Rect initialHideToClipBounds = this.backHelper.getInitialHideToClipBounds();
        Rect initialHideFromClipBounds = this.backHelper.getInitialHideFromClipBounds();
        if (initialHideToClipBounds == null) {
            initialHideToClipBounds = ViewUtils.calculateRectFromBounds(this.searchView);
        }
        if (initialHideFromClipBounds == null) {
            initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(this.rootView, this.searchBar);
        }
        Rect rect = new Rect(initialHideFromClipBounds);
        float cornerSize = this.searchBar.getCornerSize();
        float[] maxCornerRadii = maxCornerRadii(this.rootView.getCornerRadii(), this.backHelper.getExpandedCornerRadii());
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), new Object[]{initialHideFromClipBounds, initialHideToClipBounds});
        ofObject.addUpdateListener(new A(this, cornerSize, maxCornerRadii, rect));
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        ofObject.setDuration(j5);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ofObject;
    }

    private Animator getScrimAlphaAnimator(boolean z4) {
        TimeInterpolator timeInterpolator;
        long j5;
        long j6;
        if (z4) {
            timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        } else {
            timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        ofFloat.setDuration(j5);
        if (z4) {
            j6 = SHOW_SCRIM_ALPHA_DURATION_MS;
        } else {
            j6 = 0;
        }
        ofFloat.setStartDelay(j6);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, timeInterpolator));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.scrim));
        return ofFloat;
    }

    private Animator getSearchPrefixAnimator(boolean z4) {
        return getTranslationAnimatorForText(z4, this.searchPrefix);
    }

    private AnimatorSet getTextAnimator(boolean z4) {
        long j5;
        AnimatorSet animatorSet = new AnimatorSet();
        addTextFadeAnimatorIfNeeded(animatorSet);
        addEditTextClipAnimator(animatorSet);
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        animatorSet.setDuration(j5);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.LINEAR_INTERPOLATOR));
        return animatorSet;
    }

    private AnimatorSet getTranslateAnimatorSet(boolean z4) {
        long j5;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{getTranslationYAnimator()});
        addBackButtonProgressAnimatorIfNeeded(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (z4) {
            j5 = SHOW_TRANSLATE_DURATION_MS;
        } else {
            j5 = 300;
        }
        animatorSet.setDuration(j5);
        return animatorSet;
    }

    private Animator getTranslationAnimator(boolean z4, View view, int i5, int i6) {
        long j5;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i5, 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(view));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) i6, 0.0f});
        ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        animatorSet.setDuration(j5);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private Animator getTranslationAnimatorForText(boolean z4, View view) {
        TextView placeholderTextView = this.searchBar.getPlaceholderTextView();
        if (TextUtils.isEmpty(placeholderTextView.getText()) || z4) {
            placeholderTextView = this.searchBar.getTextView();
        }
        return getTranslationAnimator(z4, view, getViewLeftFromSearchViewParent(placeholderTextView) - (view.getLeft() + this.textContainer.getLeft()), getFromTranslationY());
    }

    private int getTranslationXBetweenViews(@Nullable View view, @NonNull View view2) {
        if (view != null) {
            return getViewLeftFromSearchViewParent(view) - getViewLeftFromSearchViewParent(view2);
        }
        int marginStart = ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).getMarginStart();
        int paddingStart = this.searchBar.getPaddingStart();
        int viewLeftFromSearchViewParent = getViewLeftFromSearchViewParent(this.searchBar);
        if (ViewUtils.isLayoutRtl(this.searchBar)) {
            return (((viewLeftFromSearchViewParent + this.searchBar.getWidth()) + marginStart) - paddingStart) - this.searchView.getRight();
        }
        return (viewLeftFromSearchViewParent - marginStart) + paddingStart;
    }

    private Animator getTranslationYAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.rootView.getHeight(), 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(this.rootView));
        return ofFloat;
    }

    private int getViewLeftFromSearchViewParent(@NonNull View view) {
        int left = view.getLeft();
        ViewParent parent = view.getParent();
        while ((parent instanceof View) && parent != this.searchView.getParent()) {
            left += ((View) parent).getLeft();
            parent = parent.getParent();
        }
        return left;
    }

    private int getViewTopFromSearchViewParent(@NonNull View view) {
        int top = view.getTop();
        ViewParent parent = view.getParent();
        while ((parent instanceof View) && parent != this.searchView.getParent()) {
            top += ((View) parent).getTop();
            parent = parent.getParent();
        }
        return top;
    }

    private static float[] lerpCornerRadii(float f5, float[] fArr, float f6) {
        float f7 = f5;
        float f8 = f6;
        return new float[]{AnimationUtils.lerp(f7, fArr[0], f8), AnimationUtils.lerp(f7, fArr[1], f8), AnimationUtils.lerp(f7, fArr[2], f8), AnimationUtils.lerp(f7, fArr[3], f8), AnimationUtils.lerp(f7, fArr[4], f8), AnimationUtils.lerp(f7, fArr[5], f8), AnimationUtils.lerp(f7, fArr[6], f8), AnimationUtils.lerp(f7, fArr[7], f8)};
    }

    private static float[] maxCornerRadii(float[] fArr, float[] fArr2) {
        return new float[]{Math.max(fArr[0], fArr2[0]), Math.max(fArr[1], fArr2[1]), Math.max(fArr[2], fArr2[2]), Math.max(fArr[3], fArr2[3]), Math.max(fArr[4], fArr2[4]), Math.max(fArr[5], fArr2[5]), Math.max(fArr[6], fArr2[6]), Math.max(fArr[7], fArr2[7])};
    }

    private void setActionMenuViewAlphaIfNeeded(float f5) {
        ActionMenuView actionMenuView;
        if (this.searchView.isMenuItemsAnimated() && (actionMenuView = ToolbarUtils.getActionMenuView(this.toolbar)) != null) {
            actionMenuView.setAlpha(f5);
        }
    }

    /* access modifiers changed from: private */
    public void setContentViewsAlpha(float f5) {
        this.clearButton.setAlpha(f5);
        this.divider.setAlpha(f5);
        this.contentContainer.setAlpha(f5);
        setActionMenuViewAlphaIfNeeded(f5);
    }

    private void setFullDrawableProgressIfNeeded(Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawable).setProgress(1.0f);
        }
        if (drawable instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawable).setProgress(1.0f);
        }
    }

    private void setMenuItemsNotClickable(Toolbar toolbar2) {
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(toolbar2);
        if (actionMenuView != null) {
            for (int i5 = 0; i5 < actionMenuView.getChildCount(); i5++) {
                View childAt = actionMenuView.getChildAt(i5);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private void setUpDummyToolbarIfNeeded() {
        Menu menu = this.dummyToolbar.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.searchBar.getMenuResId() == -1 || !this.searchView.isMenuItemsAnimated()) {
            this.dummyToolbar.setVisibility(8);
            return;
        }
        this.dummyToolbar.inflateMenu(this.searchBar.getMenuResId());
        setMenuItemsNotClickable(this.dummyToolbar);
        this.dummyToolbar.setVisibility(0);
    }

    private AnimatorSet startHideAnimationCollapse() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.clearFocusAndHideKeyboard();
        }
        AnimatorSet expandCollapseAnimatorSet = getExpandCollapseAnimatorSet(false);
        expandCollapseAnimatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.rootView.setVisibility(8);
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.clearFocusAndHideKeyboard();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDDEN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDING);
            }
        });
        expandCollapseAnimatorSet.start();
        return expandCollapseAnimatorSet;
    }

    private AnimatorSet startHideAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.clearFocusAndHideKeyboard();
        }
        AnimatorSet translateAnimatorSet = getTranslateAnimatorSet(false);
        translateAnimatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.rootView.setVisibility(8);
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.clearFocusAndHideKeyboard();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDDEN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDING);
            }
        });
        translateAnimatorSet.start();
        return translateAnimatorSet;
    }

    private void startShowAnimationExpand() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.requestFocusAndShowKeyboardIfNeeded();
        }
        this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
        setUpDummyToolbarIfNeeded();
        this.editText.setText(this.searchBar.getText());
        EditText editText2 = this.editText;
        editText2.setSelection(editText2.getText().length());
        this.rootView.setVisibility(4);
        this.rootView.post(new C(this));
    }

    private void startShowAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            SearchView searchView2 = this.searchView;
            Objects.requireNonNull(searchView2);
            searchView2.postDelayed(new F(searchView2), 150);
        }
        this.rootView.setVisibility(4);
        this.rootView.post(new G(this));
    }

    @RequiresApi(34)
    public void cancelBackProgress() {
        this.backHelper.cancelBackProgress(this.searchBar);
        AnimatorSet animatorSet = this.backProgressAnimatorSet;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.backProgressAnimatorSet = null;
    }

    @RequiresApi(34)
    public void finishBackProgress() {
        this.backHelper.finishBackProgress(hide().getTotalDuration(), this.searchBar);
        if (this.backProgressAnimatorSet != null) {
            getButtonsTranslationAnimator(false).start();
            this.backProgressAnimatorSet.resume();
        }
        this.backProgressAnimatorSet = null;
    }

    /* access modifiers changed from: package-private */
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.backHelper;
    }

    /* access modifiers changed from: package-private */
    public AnimatorSet hide() {
        if (this.searchBar != null) {
            return startHideAnimationCollapse();
        }
        return startHideAnimationTranslate();
    }

    @Nullable
    public BackEventCompat onHandleBackInvoked() {
        return this.backHelper.onHandleBackInvoked();
    }

    /* access modifiers changed from: package-private */
    public void setSearchBar(SearchBar searchBar2) {
        this.searchBar = searchBar2;
    }

    /* access modifiers changed from: package-private */
    public void show() {
        if (this.searchBar != null) {
            startShowAnimationExpand();
        } else {
            startShowAnimationTranslate();
        }
    }

    /* access modifiers changed from: package-private */
    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        this.backHelper.startBackProgress(backEventCompat, (View) this.searchBar);
    }

    @RequiresApi(34)
    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        if (backEventCompat.getProgress() > 0.0f) {
            MaterialMainContainerBackHelper materialMainContainerBackHelper = this.backHelper;
            SearchBar searchBar2 = this.searchBar;
            materialMainContainerBackHelper.updateBackProgress(backEventCompat, searchBar2, searchBar2.getCornerSize());
            AnimatorSet animatorSet = this.backProgressAnimatorSet;
            if (animatorSet == null) {
                if (this.searchView.isAdjustNothingSoftInputMode()) {
                    this.searchView.clearFocusAndHideKeyboard();
                }
                if (this.searchView.isAnimatedNavigationIcon()) {
                    AnimatorSet buttonsProgressAnimator = getButtonsProgressAnimator(false);
                    this.backProgressAnimatorSet = buttonsProgressAnimator;
                    buttonsProgressAnimator.start();
                    this.backProgressAnimatorSet.pause();
                    return;
                }
                return;
            }
            animatorSet.setCurrentPlayTime((long) (backEventCompat.getProgress() * ((float) this.backProgressAnimatorSet.getDuration())));
        }
    }
}
