package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchBar;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class SearchBarAnimationHelper {
    private static final long COLLAPSE_DURATION_MS = 250;
    private static final long COLLAPSE_FADE_IN_CHILDREN_DURATION_MS = 100;
    private static final long EXPAND_DURATION_MS = 300;
    private static final long EXPAND_FADE_OUT_CHILDREN_DURATION_MS = 75;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS = 500;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS = 750;
    private static final long ON_LOAD_ANIM_SECONDARY_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_SECONDARY_START_DELAY_MS = 250;
    private final Set<AnimatorListenerAdapter> collapseAnimationListeners = new LinkedHashSet();
    /* access modifiers changed from: private */
    public boolean collapsing;
    @Nullable
    private Animator defaultCenterViewAnimator;
    private final Set<AnimatorListenerAdapter> expandAnimationListeners = new LinkedHashSet();
    /* access modifiers changed from: private */
    public boolean expanding;
    private final Set<SearchBar.OnLoadAnimationCallback> onLoadAnimationCallbacks = new LinkedHashSet();
    private boolean onLoadAnimationFadeInEnabled = true;
    /* access modifiers changed from: private */
    public Animator runningExpandOrCollapseAnimator = null;
    @Nullable
    private Animator secondaryViewAnimator;

    private interface OnLoadAnimationInvocation {
        void invoke(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback);
    }

    SearchBarAnimationHelper() {
    }

    public static /* synthetic */ void b(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z4) {
        searchBarAnimationHelper.getClass();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{searchBarAnimationHelper.getFadeOutChildrenAnimator(searchBar, view), searchBarAnimationHelper.getExpandAnimator(searchBar, view, appBarLayout)});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Animator unused = SearchBarAnimationHelper.this.runningExpandOrCollapseAnimator = null;
            }
        });
        for (AnimatorListenerAdapter addListener : searchBarAnimationHelper.expandAnimationListeners) {
            animatorSet.addListener(addListener);
        }
        if (z4) {
            animatorSet.setDuration(0);
        }
        animatorSet.start();
        searchBarAnimationHelper.runningExpandOrCollapseAnimator = animatorSet;
    }

    public static /* synthetic */ void c(MaterialShapeDrawable materialShapeDrawable, View view, ValueAnimator valueAnimator) {
        materialShapeDrawable.setInterpolation(1.0f - valueAnimator.getAnimatedFraction());
        view.setBackground(materialShapeDrawable);
        view.setAlpha(1.0f);
    }

    /* access modifiers changed from: private */
    public void dispatchOnLoadAnimation(OnLoadAnimationInvocation onLoadAnimationInvocation) {
        for (SearchBar.OnLoadAnimationCallback invoke : this.onLoadAnimationCallbacks) {
            onLoadAnimationInvocation.invoke(invoke);
        }
    }

    private Animator getCollapseAnimator(final SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return getExpandCollapseAnimationHelper(searchBar, view, appBarLayout).setDuration(250).addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                searchBar.setVisibility(0);
                boolean unused = SearchBarAnimationHelper.this.collapsing = false;
            }

            public void onAnimationStart(Animator animator) {
                searchBar.stopOnLoadAnimation();
            }
        }).getCollapseAnimator();
    }

    private Animator getDefaultCenterViewAnimator(@Nullable View view) {
        long j5;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        ofFloat.setInterpolator(timeInterpolator);
        long j6 = 0;
        if (this.onLoadAnimationFadeInEnabled) {
            j5 = 250;
        } else {
            j5 = 0;
        }
        ofFloat.setDuration(j5);
        if (this.onLoadAnimationFadeInEnabled) {
            j6 = ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS;
        }
        ofFloat.setStartDelay(j6);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(250);
        ofFloat2.setStartDelay(ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    private List<View> getEndAnchoredViews(View view) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if ((!isLayoutRtl && (childAt instanceof ActionMenuView)) || (isLayoutRtl && !(childAt instanceof ActionMenuView))) {
                    arrayList.add(childAt);
                }
            }
        }
        return arrayList;
    }

    private Animator getExpandAnimator(final SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout) {
        return getExpandCollapseAnimationHelper(searchBar, view, appBarLayout).setDuration(EXPAND_DURATION_MS).addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SearchBarAnimationHelper.this.expanding = false;
            }

            public void onAnimationStart(Animator animator) {
                searchBar.setVisibility(4);
            }
        }).getExpandAnimator();
    }

    private ExpandCollapseAnimationHelper getExpandCollapseAnimationHelper(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout) {
        int i5;
        ExpandCollapseAnimationHelper additionalUpdateListener = new ExpandCollapseAnimationHelper(searchBar, view).setAdditionalUpdateListener(getExpandedViewBackgroundUpdateListener(searchBar, view));
        if (appBarLayout != null) {
            i5 = appBarLayout.getTop();
        } else {
            i5 = 0;
        }
        return additionalUpdateListener.setCollapsedViewOffsetY(i5).addEndAnchoredViews((Collection<View>) getEndAnchoredViews(view));
    }

    private ValueAnimator.AnimatorUpdateListener getExpandedViewBackgroundUpdateListener(SearchBar searchBar, View view) {
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(view.getContext());
        createWithElevationOverlay.setCornerSize(searchBar.getCornerSize());
        createWithElevationOverlay.setElevation(searchBar.getElevation());
        return new C1551g(createWithElevationOverlay, view);
    }

    private List<View> getFadeChildren(SearchBar searchBar) {
        List<View> children = ViewUtils.getChildren(searchBar);
        if (searchBar.getCenterView() != null) {
            children.remove(searchBar.getCenterView());
        }
        return children;
    }

    private Animator getFadeInChildrenAnimator(SearchBar searchBar) {
        List<View> fadeChildren = getFadeChildren(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener((Collection<View>) fadeChildren));
        ofFloat.setDuration(COLLAPSE_FADE_IN_CHILDREN_DURATION_MS);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private Animator getFadeOutChildrenAnimator(SearchBar searchBar, View view) {
        List<View> fadeChildren = getFadeChildren(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener((Collection<View>) fadeChildren));
        ofFloat.addUpdateListener(new C1547c(view));
        ofFloat.setDuration(75);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private Animator getSecondaryActionMenuItemAnimator(@Nullable View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(250);
        return ofFloat;
    }

    private Animator getSecondaryViewAnimator(TextView textView, @Nullable View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(250);
        animatorSet.play(getTextViewAnimator(textView));
        if (view != null) {
            animatorSet.play(getSecondaryActionMenuItemAnimator(view));
        }
        return animatorSet;
    }

    private Animator getTextViewAnimator(TextView textView) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(textView));
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(250);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void addCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.collapseAnimationListeners.add(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public void addExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.expandAnimationListeners.add(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public void addOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        this.onLoadAnimationCallbacks.add(onLoadAnimationCallback);
    }

    /* access modifiers changed from: package-private */
    public boolean isCollapsing() {
        return this.collapsing;
    }

    /* access modifiers changed from: package-private */
    public boolean isExpanding() {
        return this.expanding;
    }

    /* access modifiers changed from: package-private */
    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.onLoadAnimationFadeInEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean removeCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.collapseAnimationListeners.remove(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public boolean removeExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.expandAnimationListeners.remove(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public boolean removeOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.onLoadAnimationCallbacks.remove(onLoadAnimationCallback);
    }

    /* access modifiers changed from: package-private */
    public void setOnLoadAnimationFadeInEnabled(boolean z4) {
        this.onLoadAnimationFadeInEnabled = z4;
    }

    /* access modifiers changed from: package-private */
    public void startCollapseAnimation(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout, boolean z4) {
        Animator animator;
        if (isExpanding() && (animator = this.runningExpandOrCollapseAnimator) != null) {
            animator.cancel();
        }
        this.collapsing = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{getCollapseAnimator(searchBar, view, appBarLayout), getFadeInChildrenAnimator(searchBar)});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Animator unused = SearchBarAnimationHelper.this.runningExpandOrCollapseAnimator = null;
            }
        });
        for (AnimatorListenerAdapter addListener : this.collapseAnimationListeners) {
            animatorSet.addListener(addListener);
        }
        if (z4) {
            animatorSet.setDuration(0);
        }
        animatorSet.start();
        this.runningExpandOrCollapseAnimator = animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void startExpandAnimation(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout, boolean z4) {
        Animator animator;
        if (isCollapsing() && (animator = this.runningExpandOrCollapseAnimator) != null) {
            animator.cancel();
        }
        this.expanding = true;
        view.setVisibility(4);
        View view2 = view;
        view2.post(new C1550f(this, searchBar, view2, appBarLayout, z4));
    }

    /* access modifiers changed from: package-private */
    public void startOnLoadAnimation(SearchBar searchBar) {
        dispatchOnLoadAnimation(new C1548d());
        TextView textView = searchBar.getTextView();
        final View centerView = searchBar.getCenterView();
        View secondaryActionMenuItemView = ToolbarUtils.getSecondaryActionMenuItemView(searchBar);
        final Animator secondaryViewAnimator2 = getSecondaryViewAnimator(textView, secondaryActionMenuItemView);
        secondaryViewAnimator2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchBarAnimationHelper.this.dispatchOnLoadAnimation(new h());
            }
        });
        this.secondaryViewAnimator = secondaryViewAnimator2;
        textView.setAlpha(0.0f);
        if (secondaryActionMenuItemView != null) {
            secondaryActionMenuItemView.setAlpha(0.0f);
        }
        if (centerView instanceof AnimatableView) {
            ((AnimatableView) centerView).startAnimation(new C1549e(secondaryViewAnimator2));
        } else if (centerView != null) {
            centerView.setAlpha(0.0f);
            centerView.setVisibility(0);
            Animator defaultCenterViewAnimator2 = getDefaultCenterViewAnimator(centerView);
            this.defaultCenterViewAnimator = defaultCenterViewAnimator2;
            defaultCenterViewAnimator2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    centerView.setVisibility(8);
                    secondaryViewAnimator2.start();
                }
            });
            defaultCenterViewAnimator2.start();
        } else {
            secondaryViewAnimator2.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopOnLoadAnimation(SearchBar searchBar) {
        Animator animator = this.secondaryViewAnimator;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.defaultCenterViewAnimator;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView instanceof AnimatableView) {
            ((AnimatableView) centerView).stopAnimation();
        }
        if (centerView != null) {
            centerView.setAlpha(0.0f);
        }
    }
}
