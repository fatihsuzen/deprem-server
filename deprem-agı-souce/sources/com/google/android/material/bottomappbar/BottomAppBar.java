package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_DEFAULT = 300;
    private static final int FAB_ALIGNMENT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final float FAB_ALIGNMENT_ANIM_EASING_MIDPOINT = 0.2f;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;
    private static final int NO_FAB_END_MARGIN = -1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    /* access modifiers changed from: private */
    public int bottomInset;
    /* access modifiers changed from: private */
    public int fabAlignmentMode;
    @Px
    private int fabAlignmentModeEndMargin;
    /* access modifiers changed from: private */
    public int fabAnchorMode;
    @NonNull
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    /* access modifiers changed from: private */
    public boolean fabAttached;
    /* access modifiers changed from: private */
    public final int fabOffsetEndMode;
    @NonNull
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    /* access modifiers changed from: private */
    public int leftInset;
    /* access modifiers changed from: private */
    public final MaterialShapeDrawable materialShapeDrawable;
    private int menuAlignmentMode;
    /* access modifiers changed from: private */
    public boolean menuAnimatingWithFabAlignmentMode;
    /* access modifiers changed from: private */
    @Nullable
    public Animator menuAnimator;
    /* access modifiers changed from: private */
    @Nullable
    public Animator modeAnimator;
    @Nullable
    private Integer navigationIconTint;
    /* access modifiers changed from: private */
    public final boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public final boolean paddingLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public final boolean paddingRightSystemWindowInsets;
    /* access modifiers changed from: private */
    @MenuRes
    public int pendingMenuResId;
    /* access modifiers changed from: private */
    public final boolean removeEmbeddedFabElevation;
    /* access modifiers changed from: private */
    public int rightInset;

    interface AnimationListener {
        void onAnimationEnd(BottomAppBar bottomAppBar);

        void onAnimationStart(BottomAppBar bottomAppBar);
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */
        @NonNull
        public final Rect fabContentRect = new Rect();
        private final View.OnLayoutChangeListener fabLayoutListener = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.viewRef.get();
                if (bottomAppBar == null || (!(view instanceof FloatingActionButton) && !(view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.getMeasuredContentRect(Behavior.this.fabContentRect);
                    int height2 = Behavior.this.fabContentRect.height();
                    bottomAppBar.setFabDiameter(height2);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new RectF(Behavior.this.fabContentRect)));
                    height = height2;
                }
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.originalBottomMargin == 0) {
                    if (bottomAppBar.fabAnchorMode == 1) {
                        layoutParams.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    layoutParams.leftMargin = bottomAppBar.getLeftInset();
                    layoutParams.rightMargin = bottomAppBar.getRightInset();
                    if (ViewUtils.isLayoutRtl(view)) {
                        layoutParams.leftMargin += bottomAppBar.fabOffsetEndMode;
                    } else {
                        layoutParams.rightMargin += bottomAppBar.fabOffsetEndMode;
                    }
                }
                bottomAppBar.setCutoutStateAndTranslateFab();
            }
        };
        /* access modifiers changed from: private */
        public int originalBottomMargin;
        /* access modifiers changed from: private */
        public WeakReference<BottomAppBar> viewRef;

        public Behavior() {
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i5) {
            this.viewRef = new WeakReference<>(bottomAppBar);
            View access$3200 = bottomAppBar.findDependentView();
            if (access$3200 != null && !access$3200.isLaidOut()) {
                BottomAppBar.updateFabAnchorGravity(bottomAppBar, access$3200);
                this.originalBottomMargin = ((CoordinatorLayout.LayoutParams) access$3200.getLayoutParams()).bottomMargin;
                if (access$3200 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) access$3200;
                    if (bottomAppBar.fabAnchorMode == 0 && bottomAppBar.removeEmbeddedFabElevation) {
                        floatingActionButton.setElevation(0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.addFabAnimationListeners(floatingActionButton);
                }
                access$3200.addOnLayoutChangeListener(this.fabLayoutListener);
                bottomAppBar.setCutoutStateAndTranslateFab();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i5);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i5);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i5, int i6) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i5, i6);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuAlignmentMode {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }

            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        int fabAlignmentMode;
        boolean fabAttached;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void addFabAnimationListeners(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
                FloatingActionButton access$2300 = BottomAppBar.this.findDependentFab();
                if (access$2300 != null) {
                    access$2300.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    /* access modifiers changed from: private */
    public void cancelAnimations() {
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void createFabTranslationXAnimation(int i5, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(i5)});
        ofFloat.setDuration((long) getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void createMenuViewTranslationAnimation(final int i5, final boolean z4, @NonNull List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            float fabAlignmentAnimationDuration = (float) getFabAlignmentAnimationDuration();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            ofFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
            if (Math.abs(actionMenuView.getTranslationX() - ((float) getActionMenuViewTranslationX(actionMenuView, i5, z4))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                ofFloat2.addListener(new AnimatorListenerAdapter() {
                    public boolean cancelled;

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        boolean z4;
                        if (!this.cancelled) {
                            if (BottomAppBar.this.pendingMenuResId != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            BottomAppBar bottomAppBar = BottomAppBar.this;
                            bottomAppBar.replaceMenu(bottomAppBar.pendingMenuResId);
                            BottomAppBar.this.translateActionMenuView(actionMenuView, i5, z4, z4);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        ArrayList<AnimationListener> arrayList;
        int i5 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i5;
        if (i5 == 0 && (arrayList = this.animationListeners) != null) {
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                AnimationListener animationListener = arrayList.get(i6);
                i6++;
                animationListener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationStart() {
        ArrayList<AnimationListener> arrayList;
        int i5 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i5 + 1;
        if (i5 == 0 && (arrayList = this.animationListeners) != null) {
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                AnimationListener animationListener = arrayList.get(i6);
                i6++;
                animationListener.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public FloatingActionButton findDependentFab() {
        View findDependentView = findDependentView();
        if (findDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) findDependentView;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findDependentView() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.getDependents(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.findDependentView():android.view.View");
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.bottomInset;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.resolveThemeDuration(getContext(), FAB_ALIGNMENT_ANIM_DURATION_ATTR, 300);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX(int i5) {
        int i6;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i7 = 1;
        if (i5 != 1) {
            return 0.0f;
        }
        View findDependentView = findDependentView();
        int i8 = isLayoutRtl ? this.leftInset : this.rightInset;
        if (this.fabAlignmentModeEndMargin == -1 || findDependentView == null) {
            i6 = this.fabOffsetEndMode;
        } else {
            i6 = (findDependentView.getMeasuredWidth() / 2) + this.fabAlignmentModeEndMargin;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (i8 + i6);
        if (isLayoutRtl) {
            i7 = -1;
        }
        return (float) (measuredWidth * i7);
    }

    private float getFabTranslationY() {
        int i5;
        if (this.fabAnchorMode == 1) {
            return -getTopEdgeTreatment().getCradleVerticalOffset();
        }
        View findDependentView = findDependentView();
        if (findDependentView != null) {
            i5 = (-((getMeasuredHeight() + getBottomInset()) - findDependentView.getMeasuredHeight())) / 2;
        } else {
            i5 = 0;
        }
        return (float) i5;
    }

    /* access modifiers changed from: private */
    public int getLeftInset() {
        return this.leftInset;
    }

    /* access modifiers changed from: private */
    public int getRightInset() {
        return this.rightInset;
    }

    /* access modifiers changed from: private */
    @NonNull
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab == null || !findDependentFab.isOrWillBeShown()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void maybeAnimateMenuView(int i5, boolean z4) {
        if (!isLaidOut()) {
            this.menuAnimatingWithFabAlignmentMode = false;
            replaceMenu(this.pendingMenuResId);
            return;
        }
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!isFabVisibleOrWillBeShown()) {
            i5 = 0;
            z4 = false;
        }
        createMenuViewTranslationAnimation(i5, z4, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.menuAnimator = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.dispatchAnimationEnd();
                boolean unused = BottomAppBar.this.menuAnimatingWithFabAlignmentMode = false;
                Animator unused2 = BottomAppBar.this.menuAnimator = null;
            }

            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.dispatchAnimationStart();
            }
        });
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int i5) {
        if (this.fabAlignmentMode != i5 && isLaidOut()) {
            Animator animator = this.modeAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fabAnimationMode == 1) {
                createFabTranslationXAnimation(i5, arrayList);
            } else {
                createFabDefaultXAnimation(i5, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), FAB_ALIGNMENT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_INTERPOLATOR));
            this.modeAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.dispatchAnimationEnd();
                    Animator unused = BottomAppBar.this.modeAnimator = null;
                }

                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.dispatchAnimationStart();
                }
            });
            this.modeAnimator.start();
        }
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable drawable) {
        if (drawable == null || this.navigationIconTint == null) {
            return drawable;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        wrap.setTint(this.navigationIconTint.intValue());
        return wrap;
    }

    /* access modifiers changed from: private */
    public void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.menuAnimator == null) {
            actionMenuView.setAlpha(1.0f);
            if (!isFabVisibleOrWillBeShown()) {
                translateActionMenuView(actionMenuView, 0, false);
            } else {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setCutoutStateAndTranslateFab() {
        float f5;
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
        if (!this.fabAttached || !isFabVisibleOrWillBeShown() || this.fabAnchorMode != 1) {
            f5 = 0.0f;
        } else {
            f5 = 1.0f;
        }
        materialShapeDrawable2.setInterpolation(f5);
        View findDependentView = findDependentView();
        if (findDependentView != null) {
            findDependentView.setTranslationY(getFabTranslationY());
            findDependentView.setTranslationX(getFabTranslationX());
        }
    }

    private void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i5, boolean z4) {
        translateActionMenuView(actionMenuView, i5, z4, false);
    }

    /* access modifiers changed from: private */
    public static void updateFabAnchorGravity(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.anchorGravity = 17;
        int i5 = bottomAppBar.fabAnchorMode;
        if (i5 == 1) {
            layoutParams.anchorGravity = 17 | 48;
        }
        if (i5 == 0) {
            layoutParams.anchorGravity |= 80;
        }
    }

    /* access modifiers changed from: package-private */
    public void addAnimationListener(@NonNull AnimationListener animationListener) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(animationListener);
    }

    public void addOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.OnScrollStateChangedListener onScrollStateChangedListener) {
        getBehavior().addOnScrollStateChangedListener(onScrollStateChangedListener);
    }

    public void clearOnScrollStateChangedListeners() {
        getBehavior().clearOnScrollStateChangedListeners();
    }

    /* access modifiers changed from: protected */
    public void createFabDefaultXAnimation(final int i5, List<Animator> list) {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab != null && !findDependentFab.isOrWillBeHidden()) {
            dispatchAnimationStart();
            findDependentFab.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.getFabTranslationX(i5));
                    floatingActionButton.show(new FloatingActionButton.OnVisibilityChangedListener() {
                        public void onShown(FloatingActionButton floatingActionButton) {
                            BottomAppBar.this.dispatchAnimationEnd();
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public int getActionMenuViewTranslationX(@NonNull ActionMenuView actionMenuView, int i5, boolean z4) {
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        if (this.menuAlignmentMode != 1 && (i5 != 1 || !z4)) {
            return 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            i6 = getMeasuredWidth();
        } else {
            i6 = 0;
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                if (isLayoutRtl) {
                    i6 = Math.min(i6, childAt.getLeft());
                } else {
                    i6 = Math.max(i6, childAt.getRight());
                }
            }
        }
        if (isLayoutRtl) {
            i7 = actionMenuView.getRight();
        } else {
            i7 = actionMenuView.getLeft();
        }
        if (isLayoutRtl) {
            i8 = this.rightInset;
        } else {
            i8 = -this.leftInset;
        }
        if (getNavigationIcon() == null) {
            i9 = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            if (!isLayoutRtl) {
                i9 = -i9;
            }
        }
        return i6 - ((i7 + i8) + i9);
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    @Px
    public int getFabAlignmentModeEndMargin() {
        return this.fabAlignmentModeEndMargin;
    }

    public int getFabAnchorMode() {
        return this.fabAnchorMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public int getMenuAlignmentMode() {
        return this.menuAlignmentMode;
    }

    public boolean isScrolledDown() {
        return getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return getBehavior().isScrolledUp();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (z4) {
            cancelAnimations();
            setCutoutStateAndTranslateFab();
            View findDependentView = findDependentView();
            if (findDependentView != null && findDependentView.isLaidOut()) {
                findDependentView.post(new c(findDependentView));
            }
        }
        setActionMenuViewPosition();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void performHide() {
        performHide(true);
    }

    public void performShow() {
        performShow(true);
    }

    /* access modifiers changed from: package-private */
    public void removeAnimationListener(@NonNull AnimationListener animationListener) {
        ArrayList<AnimationListener> arrayList = this.animationListeners;
        if (arrayList != null) {
            arrayList.remove(animationListener);
        }
    }

    public void removeOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.OnScrollStateChangedListener onScrollStateChangedListener) {
        getBehavior().removeOnScrollStateChangedListener(onScrollStateChangedListener);
    }

    public void replaceMenu(@MenuRes int i5) {
        if (i5 != 0) {
            this.pendingMenuResId = 0;
            getMenu().clear();
            inflateMenu(i5);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        this.materialShapeDrawable.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f5) {
        if (f5 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f5);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutStateAndTranslateFab();
        }
    }

    public void setElevation(float f5) {
        this.materialShapeDrawable.setElevation(f5);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i5) {
        setFabAlignmentModeAndReplaceMenu(i5, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i5, @MenuRes int i6) {
        this.pendingMenuResId = i6;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(i5, this.fabAttached);
        maybeAnimateModeChange(i5);
        this.fabAlignmentMode = i5;
    }

    public void setFabAlignmentModeEndMargin(@Px int i5) {
        if (this.fabAlignmentModeEndMargin != i5) {
            this.fabAlignmentModeEndMargin = i5;
            setCutoutStateAndTranslateFab();
        }
    }

    public void setFabAnchorMode(int i5) {
        this.fabAnchorMode = i5;
        setCutoutStateAndTranslateFab();
        View findDependentView = findDependentView();
        if (findDependentView != null) {
            updateFabAnchorGravity(this, findDependentView);
            findDependentView.requestLayout();
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i5) {
        this.fabAnimationMode = i5;
    }

    /* access modifiers changed from: package-private */
    public void setFabCornerSize(@Dimension float f5) {
        if (f5 != getTopEdgeTreatment().getFabCornerRadius()) {
            getTopEdgeTreatment().setFabCornerSize(f5);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f5) {
        if (f5 != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f5);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f5) {
        if (f5 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f5);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setFabDiameter(@Px int i5) {
        float f5 = (float) i5;
        if (f5 == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f5);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z4) {
        this.hideOnScroll = z4;
    }

    public void setMenuAlignmentMode(int i5) {
        if (this.menuAlignmentMode != i5) {
            this.menuAlignmentMode = i5;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, isFabVisibleOrWillBeShown());
            }
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i5) {
        this.navigationIconTint = Integer.valueOf(i5);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    /* access modifiers changed from: private */
    public void translateActionMenuView(@NonNull final ActionMenuView actionMenuView, final int i5, final boolean z4, boolean z5) {
        AnonymousClass8 r02 = new Runnable() {
            public void run() {
                ActionMenuView actionMenuView = actionMenuView;
                actionMenuView.setTranslationX((float) BottomAppBar.this.getActionMenuViewTranslationX(actionMenuView, i5, z4));
            }
        };
        if (z5) {
            actionMenuView.post(r02);
        } else {
            r02.run();
        }
    }

    @NonNull
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    public void performHide(boolean z4) {
        getBehavior().slideDown(this, z4);
    }

    public void performShow(boolean z4) {
        getBehavior().slideUp(this, z4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r13, @androidx.annotation.Nullable android.util.AttributeSet r14, int r15) {
        /*
            r12 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r13 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r13, r14, r15, r4)
            r12.<init>(r13, r14, r15)
            com.google.android.material.shape.MaterialShapeDrawable r13 = new com.google.android.material.shape.MaterialShapeDrawable
            r13.<init>()
            r12.materialShapeDrawable = r13
            r6 = 0
            r12.animatingModeChangeCounter = r6
            r12.pendingMenuResId = r6
            r12.menuAnimatingWithFabAlignmentMode = r6
            r7 = 1
            r12.fabAttached = r7
            com.google.android.material.bottomappbar.BottomAppBar$1 r0 = new com.google.android.material.bottomappbar.BottomAppBar$1
            r0.<init>()
            r12.fabAnimationListener = r0
            com.google.android.material.bottomappbar.BottomAppBar$2 r0 = new com.google.android.material.bottomappbar.BottomAppBar$2
            r0.<init>()
            r12.fabTransformationCallback = r0
            android.content.Context r0 = r12.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r6]
            r1 = r14
            r3 = r15
            android.content.res.TypedArray r14 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r15 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r15 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r14, (int) r15)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_navigationIconTint
            boolean r5 = r14.hasValue(r2)
            r8 = -1
            if (r5 == 0) goto L_0x004c
            int r2 = r14.getColor(r2, r8)
            r12.setNavigationIconTint(r2)
        L_0x004c:
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r14.getDimensionPixelSize(r2, r6)
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r5 = r14.getDimensionPixelOffset(r5, r6)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r9 = r14.getDimensionPixelOffset(r9, r6)
            float r9 = (float) r9
            int r10 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r10 = r14.getDimensionPixelOffset(r10, r6)
            float r10 = (float) r10
            int r11 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r11 = r14.getInt(r11, r6)
            r12.fabAlignmentMode = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r11 = r14.getInt(r11, r6)
            r12.fabAnimationMode = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_fabAnchorMode
            int r11 = r14.getInt(r11, r7)
            r12.fabAnchorMode = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_removeEmbeddedFabElevation
            boolean r11 = r14.getBoolean(r11, r7)
            r12.removeEmbeddedFabElevation = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_menuAlignmentMode
            int r11 = r14.getInt(r11, r6)
            r12.menuAlignmentMode = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r11 = r14.getBoolean(r11, r6)
            r12.hideOnScroll = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r11 = r14.getBoolean(r11, r6)
            r12.paddingBottomSystemWindowInsets = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r11 = r14.getBoolean(r11, r6)
            r12.paddingLeftSystemWindowInsets = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r11 = r14.getBoolean(r11, r6)
            r12.paddingRightSystemWindowInsets = r11
            int r11 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentModeEndMargin
            int r8 = r14.getDimensionPixelOffset(r11, r8)
            r12.fabAlignmentModeEndMargin = r8
            int r8 = com.google.android.material.R.styleable.BottomAppBar_addElevationShadow
            boolean r8 = r14.getBoolean(r8, r7)
            r14.recycle()
            android.content.res.Resources r14 = r12.getResources()
            int r11 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r14 = r14.getDimensionPixelOffset(r11)
            r12.fabOffsetEndMode = r14
            com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment r14 = new com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
            r14.<init>(r5, r9, r10)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r5 = com.google.android.material.shape.ShapeAppearanceModel.builder()
            com.google.android.material.shape.ShapeAppearanceModel$Builder r14 = r5.setTopEdge(r14)
            com.google.android.material.shape.ShapeAppearanceModel r14 = r14.build()
            r13.setShapeAppearanceModel(r14)
            if (r8 == 0) goto L_0x00e7
            r14 = 2
            r13.setShadowCompatibilityMode(r14)
            goto L_0x00f6
        L_0x00e7:
            r13.setShadowCompatibilityMode(r7)
            int r14 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r14 < r5) goto L_0x00f6
            r12.setOutlineAmbientShadowColor(r6)
            r12.setOutlineSpotShadowColor(r6)
        L_0x00f6:
            android.graphics.Paint$Style r14 = android.graphics.Paint.Style.FILL
            r13.setPaintStyle(r14)
            r13.initializeElevationOverlay(r0)
            r13.setTintList(r15)
            float r14 = (float) r2
            r12.setElevation(r14)
            r12.setBackground(r13)
            com.google.android.material.bottomappbar.BottomAppBar$3 r13 = new com.google.android.material.bottomappbar.BottomAppBar$3
            r13.<init>()
            com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(r12, r1, r3, r4, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
