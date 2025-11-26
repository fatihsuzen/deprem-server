package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int DEFAULT_ACCESSIBILITY_PANE_TITLE = R.string.side_sheet_accessibility_pane_title;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SideSheet;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    @Nullable
    private ColorStateList backgroundTint;
    @NonNull
    private final Set<SideSheetCallback> callbacks = new LinkedHashSet();
    /* access modifiers changed from: private */
    public int childWidth;
    @IdRes
    private int coplanarSiblingViewId = -1;
    @Nullable
    private WeakReference<View> coplanarSiblingViewRef;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        public int clampViewPositionHorizontal(@NonNull View view, int i5, int i6) {
            return MathUtils.clamp(i5, SideSheetBehavior.this.sheetDelegate.getMinViewPositionHorizontal(), SideSheetBehavior.this.sheetDelegate.getMaxViewPositionHorizontal());
        }

        public int clampViewPositionVertical(@NonNull View view, int i5, int i6) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return SideSheetBehavior.this.childWidth + SideSheetBehavior.this.getInnerMargin();
        }

        public void onViewDragStateChanged(int i5) {
            if (i5 == 1 && SideSheetBehavior.this.draggable) {
                SideSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(@NonNull View view, int i5, int i6, int i7, int i8) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View coplanarSiblingView = SideSheetBehavior.this.getCoplanarSiblingView();
            if (!(coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null)) {
                SideSheetBehavior.this.sheetDelegate.updateCoplanarSiblingLayoutParams(marginLayoutParams, view.getLeft(), view.getRight());
                coplanarSiblingView.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.dispatchOnSlide(view, i5);
        }

        public void onViewReleased(@NonNull View view, float f5, float f6) {
            int access$500 = SideSheetBehavior.this.calculateTargetStateOnViewReleased(view, f5, f6);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.startSettling(view, access$500, sideSheetBehavior.shouldSkipSmoothAnimation());
        }

        public boolean tryCaptureView(@NonNull View view, int i5) {
            if (SideSheetBehavior.this.state == 1 || SideSheetBehavior.this.viewRef == null || SideSheetBehavior.this.viewRef.get() != view) {
                return false;
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public boolean draggable = true;
    private float elevation;
    private float hideFriction = 0.1f;
    private boolean ignoreEvents;
    private int initialX;
    private int innerMargin;
    private int lastStableState = 5;
    @Nullable
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private int parentInnerEdge;
    private int parentWidth;
    private ShapeAppearanceModel shapeAppearanceModel;
    /* access modifiers changed from: private */
    public SheetDelegate sheetDelegate;
    @Nullable
    private MaterialSideContainerBackHelper sideContainerBackHelper;
    /* access modifiers changed from: private */
    public int state = 5;
    private final SideSheetBehavior<V>.StateSettlingTracker stateSettlingTracker = new StateSettlingTracker();
    @Nullable
    private VelocityTracker velocityTracker;
    /* access modifiers changed from: private */
    @Nullable
    public ViewDragHelper viewDragHelper;
    /* access modifiers changed from: private */
    @Nullable
    public WeakReference<V> viewRef;

    protected static class SavedState extends AbsSavedState {
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
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.state);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = sideSheetBehavior.state;
        }
    }

    class StateSettlingTracker {
        private final Runnable continueSettlingRunnable = new e(this);
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        StateSettlingTracker() {
        }

        public static /* synthetic */ void a(StateSettlingTracker stateSettlingTracker) {
            stateSettlingTracker.isContinueSettlingRunnablePosted = false;
            if (SideSheetBehavior.this.viewDragHelper != null && SideSheetBehavior.this.viewDragHelper.continueSettling(true)) {
                stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
            } else if (SideSheetBehavior.this.state == 2) {
                SideSheetBehavior.this.setStateInternal(stateSettlingTracker.targetState);
            }
        }

        /* access modifiers changed from: package-private */
        public void continueSettlingToState(int i5) {
            if (SideSheetBehavior.this.viewRef != null && SideSheetBehavior.this.viewRef.get() != null) {
                this.targetState = i5;
                if (!this.isContinueSettlingRunnablePosted) {
                    ((View) SideSheetBehavior.this.viewRef.get()).postOnAnimation(this.continueSettlingRunnable);
                    this.isContinueSettlingRunnablePosted = true;
                }
            }
        }
    }

    public SideSheetBehavior() {
    }

    public static /* synthetic */ void b(SideSheetBehavior sideSheetBehavior, int i5) {
        View view = (View) sideSheetBehavior.viewRef.get();
        if (view != null) {
            sideSheetBehavior.startSettling(view, i5, false);
        }
    }

    public static /* synthetic */ void c(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i5, View view, ValueAnimator valueAnimator) {
        sideSheetBehavior.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, AnimationUtils.lerp(i5, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    private int calculateCurrentOffset(int i5, V v5) {
        int i6 = this.state;
        if (i6 == 1 || i6 == 2) {
            return i5 - this.sheetDelegate.getOuterEdge(v5);
        }
        if (i6 == 3) {
            return 0;
        }
        if (i6 == 5) {
            return this.sheetDelegate.getHiddenOffset();
        }
        throw new IllegalStateException("Unexpected value: " + this.state);
    }

    private float calculateDragDistance(float f5, float f6) {
        return Math.abs(f5 - f6);
    }

    /* access modifiers changed from: private */
    public int calculateTargetStateOnViewReleased(@NonNull View view, float f5, float f6) {
        if (isExpandingOutwards(f5)) {
            return 3;
        }
        if (shouldHide(view, f5)) {
            if (this.sheetDelegate.isSwipeSignificant(f5, f6) || this.sheetDelegate.isReleasedCloseToInnerEdge(view)) {
                return 5;
            }
            return 3;
        } else if (f5 != 0.0f && SheetUtils.isSwipeMostlyHorizontal(f5, f6)) {
            return 5;
        } else {
            int left = view.getLeft();
            if (Math.abs(left - getExpandedOffset()) < Math.abs(left - this.sheetDelegate.getHiddenOffset())) {
                return 3;
            }
            return 5;
        }
    }

    private void clearCoplanarSiblingView() {
        WeakReference<View> weakReference = this.coplanarSiblingViewRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.coplanarSiblingViewRef = null;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int i5) {
        return new c(this, i5);
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context context) {
        if (this.shapeAppearanceModel != null) {
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.backgroundTint;
            if (colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    /* access modifiers changed from: private */
    public void dispatchOnSlide(@NonNull View view, int i5) {
        if (!this.callbacks.isEmpty()) {
            float calculateSlideOffset = this.sheetDelegate.calculateSlideOffset(i5);
            for (SideSheetCallback onSlide : this.callbacks) {
                onSlide.onSlide(view, calculateSlideOffset);
            }
        }
    }

    private void ensureAccessibilityPaneTitleIsSet(View view) {
        if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
            ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(DEFAULT_ACCESSIBILITY_PANE_TITLE));
        }
    }

    @NonNull
    public static <V extends View> SideSheetBehavior<V> from(@NonNull V v5) {
        ViewGroup.LayoutParams layoutParams = v5.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof SideSheetBehavior) {
                return (SideSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i5, int i6, int i7, int i8) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, i6, i8);
        if (i7 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i7), 1073741824);
        }
        if (size != 0) {
            i7 = Math.min(size, i7);
        }
        return View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
    }

    @Nullable
    private ValueAnimator.AnimatorUpdateListener getCoplanarFinishAnimatorUpdateListener() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            return null;
        }
        return new d(this, marginLayoutParams, this.sheetDelegate.getCoplanarSiblingAdjacentMargin(marginLayoutParams), coplanarSiblingView);
    }

    @GravityInt
    private int getGravityFromSheetEdge() {
        SheetDelegate sheetDelegate2 = this.sheetDelegate;
        if (sheetDelegate2 == null || sheetDelegate2.getSheetEdge() == 0) {
            return 5;
        }
        return 3;
    }

    @Nullable
    private CoordinatorLayout.LayoutParams getViewLayoutParams() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) view.getLayoutParams();
    }

    private boolean hasLeftMargin() {
        CoordinatorLayout.LayoutParams viewLayoutParams = getViewLayoutParams();
        if (viewLayoutParams == null || viewLayoutParams.leftMargin <= 0) {
            return false;
        }
        return true;
    }

    private boolean hasRightMargin() {
        CoordinatorLayout.LayoutParams viewLayoutParams = getViewLayoutParams();
        if (viewLayoutParams == null || viewLayoutParams.rightMargin <= 0) {
            return false;
        }
        return true;
    }

    private boolean isDraggedFarEnough(@NonNull MotionEvent motionEvent) {
        if (shouldHandleDraggingWithHelper() && calculateDragDistance((float) this.initialX, motionEvent.getX()) > ((float) this.viewDragHelper.getTouchSlop())) {
            return true;
        }
        return false;
    }

    private boolean isExpandingOutwards(float f5) {
        return this.sheetDelegate.isExpandingOutwards(f5);
    }

    private boolean isLayingOut(@NonNull V v5) {
        ViewParent parent = v5.getParent();
        if (parent == null || !parent.isLayoutRequested() || !v5.isAttachedToWindow()) {
            return false;
        }
        return true;
    }

    private boolean isSettling(View view, int i5, boolean z4) {
        int outerEdgeOffsetForState = getOuterEdgeOffsetForState(i5);
        ViewDragHelper viewDragHelper2 = getViewDragHelper();
        if (viewDragHelper2 == null) {
            return false;
        }
        if (z4) {
            if (viewDragHelper2.settleCapturedViewAt(outerEdgeOffsetForState, view.getTop())) {
                return true;
            }
            return false;
        } else if (viewDragHelper2.smoothSlideViewTo(view, outerEdgeOffsetForState, view.getTop())) {
            return true;
        } else {
            return false;
        }
    }

    private void maybeAssignCoplanarSiblingViewBasedId(@NonNull CoordinatorLayout coordinatorLayout) {
        int i5;
        View findViewById;
        if (this.coplanarSiblingViewRef == null && (i5 = this.coplanarSiblingViewId) != -1 && (findViewById = coordinatorLayout.findViewById(i5)) != null) {
            this.coplanarSiblingViewRef = new WeakReference<>(findViewById);
        }
    }

    private void replaceAccessibilityActionForState(V v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i5) {
        ViewCompat.replaceAccessibilityAction(v5, accessibilityActionCompat, (CharSequence) null, createAccessibilityViewCommandForState(i5));
    }

    private void resetVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void runAfterLayout(@NonNull V v5, Runnable runnable) {
        if (isLayingOut(v5)) {
            v5.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setSheetEdge(@NonNull V v5, int i5) {
        setSheetEdge(Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) v5.getLayoutParams()).gravity, i5) == 3 ? 1 : 0);
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper == null) {
            return false;
        }
        if (this.draggable || this.state == 1) {
            return true;
        }
        return false;
    }

    private boolean shouldInterceptTouchEvent(@NonNull V v5) {
        if ((v5.isShown() || ViewCompat.getAccessibilityPaneTitle(v5) != null) && this.draggable) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void startSettling(View view, int i5, boolean z4) {
        if (isSettling(view, i5, z4)) {
            setStateInternal(2);
            this.stateSettlingTracker.continueSettlingToState(i5);
            return;
        }
        setStateInternal(i5);
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ViewCompat.removeAccessibilityAction(view, 262144);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            if (this.state != 5) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            if (this.state != 3) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    private void updateCoplanarSiblingBackProgress() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && weakReference.get() != null) {
            View view = (View) this.viewRef.get();
            View coplanarSiblingView = getCoplanarSiblingView();
            if (coplanarSiblingView != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) != null) {
                this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, (int) ((((float) this.childWidth) * view.getScaleX()) + ((float) this.innerMargin)));
                coplanarSiblingView.requestLayout();
            }
        }
    }

    private void updateMaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel2) {
        MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    private void updateSheetVisibility(@NonNull View view) {
        int i5;
        if (this.state == 5) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        if (view.getVisibility() != i5) {
            view.setVisibility(i5);
        }
    }

    public void cancelBackProgress() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.cancelBackProgress();
        }
    }

    public void expand() {
        setState(3);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    /* access modifiers changed from: package-private */
    public int getChildWidth() {
        return this.childWidth;
    }

    @Nullable
    public View getCoplanarSiblingView() {
        WeakReference<View> weakReference = this.coplanarSiblingViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getExpandedOffset() {
        return this.sheetDelegate.getExpandedOffset();
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    /* access modifiers changed from: package-private */
    public float getHideThreshold() {
        return 0.5f;
    }

    /* access modifiers changed from: package-private */
    public int getInnerMargin() {
        return this.innerMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    /* access modifiers changed from: package-private */
    public int getOuterEdgeOffsetForState(int i5) {
        if (i5 == 3) {
            return getExpandedOffset();
        }
        if (i5 == 5) {
            return this.sheetDelegate.getHiddenOffset();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i5);
    }

    /* access modifiers changed from: package-private */
    public int getParentInnerEdge() {
        return this.parentInnerEdge;
    }

    /* access modifiers changed from: package-private */
    public int getParentWidth() {
        return this.parentWidth;
    }

    /* access modifiers changed from: package-private */
    public int getSignificantVelocityThreshold() {
        return SIGNIFICANT_VEL_THRESHOLD;
    }

    public int getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    /* access modifiers changed from: package-private */
    public float getXVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getXVelocity();
    }

    public void handleBackInvoked() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            BackEventCompat onHandleBackInvoked = materialSideContainerBackHelper.onHandleBackInvoked();
            if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
                setState(5);
            } else {
                this.sideContainerBackHelper.finishBackProgress(onHandleBackInvoked, getGravityFromSheetEdge(), new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SideSheetBehavior.this.setStateInternal(5);
                        if (SideSheetBehavior.this.viewRef != null && SideSheetBehavior.this.viewRef.get() != null) {
                            ((View) SideSheetBehavior.this.viewRef.get()).requestLayout();
                        }
                    }
                }, getCoplanarFinishAnimatorUpdateListener());
            }
        }
    }

    public void hide() {
        setState(5);
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2;
        if (!shouldInterceptTouchEvent(v5)) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetVelocity();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.initialX = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.ignoreEvents) {
            this.ignoreEvents = false;
            return false;
        }
        if (this.ignoreEvents || (viewDragHelper2 = this.viewDragHelper) == null || !viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
        int i6;
        if (coordinatorLayout.getFitsSystemWindows() && !v5.getFitsSystemWindows()) {
            v5.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.viewRef = new WeakReference<>(v5);
            this.sideContainerBackHelper = new MaterialSideContainerBackHelper(v5);
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                v5.setBackground(materialShapeDrawable2);
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                float f5 = this.elevation;
                if (f5 == -1.0f) {
                    f5 = v5.getElevation();
                }
                materialShapeDrawable3.setElevation(f5);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v5, colorStateList);
                }
            }
            updateSheetVisibility(v5);
            updateAccessibilityActions();
            if (v5.getImportantForAccessibility() == 0) {
                v5.setImportantForAccessibility(1);
            }
            ensureAccessibilityPaneTitleIsSet(v5);
        }
        setSheetEdge(v5, i5);
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int outerEdge = this.sheetDelegate.getOuterEdge(v5);
        coordinatorLayout.onLayoutChild(v5, i5);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentInnerEdge = this.sheetDelegate.getParentInnerEdge(coordinatorLayout);
        this.childWidth = v5.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        if (marginLayoutParams != null) {
            i6 = this.sheetDelegate.calculateInnerMargin(marginLayoutParams);
        } else {
            i6 = 0;
        }
        this.innerMargin = i6;
        ViewCompat.offsetLeftAndRight(v5, calculateCurrentOffset(outerEdge, v5));
        maybeAssignCoplanarSiblingViewBasedId(coordinatorLayout);
        for (SheetCallback next : this.callbacks) {
            if (next instanceof SideSheetCallback) {
                ((SideSheetCallback) next).onLayout(v5);
            }
        }
        return true;
    }

    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        v5.measure(getChildMeasureSpec(i5, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, -1, marginLayoutParams.width), getChildMeasureSpec(i7, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, -1, marginLayoutParams.height));
        return true;
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v5, savedState.getSuperState());
        }
        int i5 = savedState.state;
        if (i5 == 1 || i5 == 2) {
            i5 = 5;
        }
        this.state = i5;
        this.lastStableState = i5;
    }

    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v5), (SideSheetBehavior<?>) this);
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        if (!v5.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            resetVelocity();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && isDraggedFarEnough(motionEvent)) {
            this.viewDragHelper.captureChildView(v5, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void setCoplanarSiblingView(@Nullable View view) {
        this.coplanarSiblingViewId = -1;
        if (view == null) {
            clearCoplanarSiblingView();
            return;
        }
        this.coplanarSiblingViewRef = new WeakReference<>(view);
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            if (view2.isLaidOut()) {
                view2.requestLayout();
            }
        }
    }

    public void setCoplanarSiblingViewId(@IdRes int i5) {
        this.coplanarSiblingViewId = i5;
        clearCoplanarSiblingView();
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i5 != -1 && view.isLaidOut()) {
                view.requestLayout();
            }
        }
    }

    public void setDraggable(boolean z4) {
        this.draggable = z4;
    }

    public void setHideFriction(float f5) {
        this.hideFriction = f5;
    }

    public void setState(int i5) {
        String str;
        if (i5 == 1 || i5 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            if (i5 == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            sb.append(str);
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            setStateInternal(i5);
        } else {
            runAfterLayout((View) this.viewRef.get(), new b(this, i5));
        }
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i5) {
        View view;
        if (this.state != i5) {
            this.state = i5;
            if (i5 == 3 || i5 == 5) {
                this.lastStableState = i5;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                updateSheetVisibility(view);
                for (SideSheetCallback onStateChanged : this.callbacks) {
                    onStateChanged.onStateChanged(view, i5);
                }
                updateAccessibilityActions();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(@NonNull View view, float f5) {
        return this.sheetDelegate.shouldHide(view, f5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.startBackProgress(backEventCompat);
        }
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.updateBackProgress(backEventCompat, getGravityFromSheetEdge());
            updateCoplanarSiblingBackProgress();
        }
    }

    public void addCallback(@NonNull SideSheetCallback sideSheetCallback) {
        this.callbacks.add(sideSheetCallback);
    }

    public void removeCallback(@NonNull SideSheetCallback sideSheetCallback) {
        this.callbacks.remove(sideSheetCallback);
    }

    private void setSheetEdge(int i5) {
        SheetDelegate sheetDelegate2 = this.sheetDelegate;
        if (sheetDelegate2 != null && sheetDelegate2.getSheetEdge() == i5) {
            return;
        }
        if (i5 == 0) {
            this.sheetDelegate = new RightSheetDelegate(this);
            if (this.shapeAppearanceModel != null && !hasRightMargin()) {
                ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
                builder.setTopRightCornerSize(0.0f).setBottomRightCornerSize(0.0f);
                updateMaterialShapeDrawable(builder.build());
            }
        } else if (i5 == 1) {
            this.sheetDelegate = new LeftSheetDelegate(this);
            if (this.shapeAppearanceModel != null && !hasLeftMargin()) {
                ShapeAppearanceModel.Builder builder2 = this.shapeAppearanceModel.toBuilder();
                builder2.setTopLeftCornerSize(0.0f).setBottomLeftCornerSize(0.0f);
                updateMaterialShapeDrawable(builder2.build());
            }
        } else {
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i5 + ". Must be " + 0 + " or " + 1 + ".");
        }
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SideSheetBehavior_Layout);
        int i5 = R.styleable.SideSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModel = ShapeAppearanceModel.builder(context, attributeSet, 0, DEF_STYLE_RES).build();
        }
        int i6 = R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (obtainStyledAttributes.hasValue(i6)) {
            setCoplanarSiblingViewId(obtainStyledAttributes.getResourceId(i6, -1));
        }
        createMaterialShapeDrawableIfNeeded(context);
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
