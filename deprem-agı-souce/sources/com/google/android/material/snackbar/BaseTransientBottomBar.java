package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    static final int DEFAULT_ANIMATION_FADE_DURATION = 180;
    private static final TimeInterpolator DEFAULT_ANIMATION_FADE_INTERPOLATOR = AnimationUtils.LINEAR_INTERPOLATOR;
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 150;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 75;
    private static final TimeInterpolator DEFAULT_ANIMATION_SCALE_INTERPOLATOR = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    private static final TimeInterpolator DEFAULT_ANIMATION_SLIDE_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    static final int DEFAULT_SLIDE_ANIMATION_DURATION = 250;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR = {R.attr.snackbarStyle};
    /* access modifiers changed from: private */
    public static final String TAG = BaseTransientBottomBar.class.getSimpleName();
    @NonNull
    static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(@NonNull Message message) {
            int i5 = message.what;
            if (i5 == 0) {
                ((BaseTransientBottomBar) message.obj).showView();
                return true;
            } else if (i5 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
                return true;
            }
        }
    });
    @Nullable
    private final AccessibilityManager accessibilityManager;
    @Nullable
    private Anchor anchor;
    /* access modifiers changed from: private */
    public boolean anchorViewLayoutListenerEnabled;
    /* access modifiers changed from: private */
    public final int animationFadeInDuration;
    private final TimeInterpolator animationFadeInterpolator;
    /* access modifiers changed from: private */
    public final int animationFadeOutDuration;
    private final TimeInterpolator animationScaleInterpolator;
    /* access modifiers changed from: private */
    public final int animationSlideDuration;
    private final TimeInterpolator animationSlideInterpolator;
    /* access modifiers changed from: private */
    public int appliedBottomMarginGestureInset;
    private Behavior behavior;
    @RequiresApi(29)
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseCallback<B>> callbacks;
    /* access modifiers changed from: private */
    @NonNull
    public final ContentViewCallback contentViewCallback;
    /* access modifiers changed from: private */
    public final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    /* access modifiers changed from: private */
    public int extraBottomMarginGestureInset;
    /* access modifiers changed from: private */
    public int extraBottomMarginWindowInset;
    /* access modifiers changed from: private */
    public int extraLeftMarginWindowInset;
    /* access modifiers changed from: private */
    public int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;
    @NonNull
    SnackbarManager.Callback managerCallback;
    private boolean pendingShowingView;
    @NonNull
    private final ViewGroup targetParent;
    @NonNull
    protected final SnackbarBaseLayout view;

    static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        @NonNull
        private final WeakReference<View> anchorView;
        @NonNull
        private final WeakReference<BaseTransientBottomBar> transientBottomBar;

        private Anchor(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            this.transientBottomBar = new WeakReference<>(baseTransientBottomBar);
            this.anchorView = new WeakReference<>(view);
        }

        static Anchor anchor(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            Anchor anchor = new Anchor(baseTransientBottomBar, view);
            if (view.isAttachedToWindow()) {
                ViewUtils.addOnGlobalLayoutListener(view, anchor);
            }
            view.addOnAttachStateChangeListener(anchor);
            return anchor;
        }

        private boolean unanchorIfNoTransientBottomBar() {
            if (this.transientBottomBar.get() != null) {
                return false;
            }
            unanchor();
            return true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public View getAnchorView() {
            return this.anchorView.get();
        }

        public void onGlobalLayout() {
            if (!unanchorIfNoTransientBottomBar() && this.transientBottomBar.get().anchorViewLayoutListenerEnabled) {
                this.transientBottomBar.get().recalculateAndUpdateMargins();
            }
        }

        public void onViewAttachedToWindow(View view) {
            if (!unanchorIfNoTransientBottomBar()) {
                ViewUtils.addOnGlobalLayoutListener(view, this);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            if (!unanchorIfNoTransientBottomBar()) {
                ViewUtils.removeOnGlobalLayoutListener(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
            }
        }

        /* access modifiers changed from: package-private */
        public void unanchor() {
            if (this.anchorView.get() != null) {
                this.anchorView.get().removeOnAttachStateChangeListener(this);
                ViewUtils.removeOnGlobalLayoutListener(this.anchorView.get(), (ViewTreeObserver.OnGlobalLayoutListener) this);
            }
            this.anchorView.clear();
            this.transientBottomBar.clear();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void onDismissed(B b5, int i5) {
        }

        public void onShown(B b5) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull
        private final BehaviorDelegate delegate = new BehaviorDelegate(this);

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
        }

        public boolean canSwipeDismissView(View view) {
            return this.delegate.canSwipeDismissView(view);
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        private SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            }
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.managerCallback = baseTransientBottomBar.managerCallback;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends ContentViewCallback {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @IntRange(from = -2)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        private final float actionTextColorAlpha;
        private boolean addingToTargetParent;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;
        @Nullable
        private BaseTransientBottomBar<?> baseTransientBottomBar;
        private final int maxInlineActionWidth;
        private final int maxWidth;
        /* access modifiers changed from: private */
        @Nullable
        public Rect originalMargins;
        @Nullable
        ShapeAppearanceModel shapeAppearanceModel;

        protected SnackbarBaseLayout(@NonNull Context context) {
            this(context, (AttributeSet) null);
        }

        @NonNull
        private Drawable createThemedBackground() {
            Drawable drawable;
            int layer = MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel shapeAppearanceModel2 = this.shapeAppearanceModel;
            if (shapeAppearanceModel2 != null) {
                drawable = BaseTransientBottomBar.createMaterialShapeDrawableBackground(layer, shapeAppearanceModel2);
            } else {
                drawable = BaseTransientBottomBar.createGradientDrawableBackground(layer, getResources());
            }
            if (this.backgroundTint == null) {
                return DrawableCompat.wrap(drawable);
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            wrap.setTintList(this.backgroundTint);
            return wrap;
        }

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar2) {
            this.baseTransientBottomBar = baseTransientBottomBar2;
        }

        private void updateOriginalMargins(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* access modifiers changed from: package-private */
        public void addToTargetParent(ViewGroup viewGroup) {
            this.addingToTargetParent = true;
            viewGroup.addView(this);
            this.addingToTargetParent = false;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.animationMode;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        /* access modifiers changed from: package-private */
        public int getMaxInlineActionWidth() {
            return this.maxInlineActionWidth;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth() {
            return this.maxWidth;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
            if (baseTransientBottomBar2 != null) {
                baseTransientBottomBar2.onAttachedToWindow();
            }
            requestApplyInsets();
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
            if (baseTransientBottomBar2 != null) {
                baseTransientBottomBar2.onDetachedFromWindow();
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
            super.onLayout(z4, i5, i6, i7, i8);
            BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
            if (baseTransientBottomBar2 != null) {
                baseTransientBottomBar2.onLayoutChange();
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i5, int i6) {
            int i7;
            super.onMeasure(i5, i6);
            if (this.maxWidth > 0 && getMeasuredWidth() > (i7 = this.maxWidth)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), i6);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i5) {
            this.animationMode = i5;
        }

        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (!(drawable == null || this.backgroundTint == null)) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                drawable.setTintList(this.backgroundTint);
                drawable.setTintMode(this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                wrap.setTintList(colorStateList);
                wrap.setTintMode(this.backgroundTintMode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                wrap.setTintMode(mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.addingToTargetParent && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                updateOriginalMargins((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
                if (baseTransientBottomBar2 != null) {
                    baseTransientBottomBar2.updateMargins();
                }
            }
        }

        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = consumeAllTouchListener;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }

        protected SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i5 = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i5)) {
                setElevation((float) obtainStyledAttributes.getDimensionPixelSize(i5, 0));
            }
            this.animationMode = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearance) || obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, 0, 0).build();
            }
            this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                setBackground(createThemedBackground());
            }
        }
    }

    protected BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull ContentViewCallback contentViewCallback2) {
        this(viewGroup.getContext(), viewGroup, view2, contentViewCallback2);
    }

    private void animateViewOut(int i5) {
        if (this.view.getAnimationMode() == 1) {
            startFadeOutAnimation(i5);
        } else {
            startSlideOutAnimation(i5);
        }
    }

    private int calculateBottomMarginForAnchorView() {
        if (getAnchorView() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        getAnchorView().getLocationOnScreen(iArr);
        int i5 = iArr[1];
        int[] iArr2 = new int[2];
        this.targetParent.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.targetParent.getHeight()) - i5;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static GradientDrawable createGradientDrawableBackground(@ColorInt int i5, @NonNull Resources resources) {
        float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i5);
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static MaterialShapeDrawable createMaterialShapeDrawableBackground(@ColorInt int i5, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(i5));
        return materialShapeDrawable;
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.animationFadeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.animationScaleInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.view.setScaleX(floatValue);
                BaseTransientBottomBar.this.view.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    private int getTranslationYBottom() {
        int height = this.view.getHeight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    /* access modifiers changed from: private */
    public int getViewAbsoluteBottom() {
        int[] iArr = new int[2];
        this.view.getLocationInWindow(iArr);
        return iArr[1] + this.view.getHeight();
    }

    private boolean isSwipeDismissable() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams) || !(((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void recalculateAndUpdateMargins() {
        this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
        updateMargins();
    }

    private void setUpBehavior(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior swipeDismissBehavior = this.behavior;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = getNewBehavior();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).setBaseTransientBottomBar(this);
        }
        swipeDismissBehavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            public void onDismiss(@NonNull View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.dispatchDismiss(0);
            }

            public void onDragStateChanged(int i5) {
                if (i5 == 0) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.managerCallback);
                } else if (i5 == 1 || i5 == 2) {
                    SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.managerCallback);
                }
            }
        });
        layoutParams.setBehavior(swipeDismissBehavior);
        if (getAnchorView() == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean shouldUpdateGestureInset() {
        if (this.extraBottomMarginGestureInset <= 0 || this.gestureInsetBottomIgnored || !isSwipeDismissable()) {
            return false;
        }
        return true;
    }

    private void showViewImpl() {
        if (shouldAnimate()) {
            animateViewIn();
            return;
        }
        if (this.view.getParent() != null) {
            this.view.setVisibility(0);
        }
        onViewShown();
    }

    /* access modifiers changed from: private */
    public void startFadeInAnimation() {
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        ValueAnimator scaleAnimator = getScaleAnimator(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{alphaAnimator, scaleAnimator});
        animatorSet.setDuration((long) this.animationFadeInDuration);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewShown();
            }
        });
        animatorSet.start();
    }

    private void startFadeOutAnimation(final int i5) {
        ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
        alphaAnimator.setDuration((long) this.animationFadeOutDuration);
        alphaAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewHidden(i5);
            }
        });
        alphaAnimator.start();
    }

    /* access modifiers changed from: private */
    public void startSlideInAnimation() {
        int translationYBottom = getTranslationYBottom();
        this.view.setTranslationY((float) translationYBottom);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{translationYBottom, 0});
        valueAnimator.setInterpolator(this.animationSlideInterpolator);
        valueAnimator.setDuration((long) this.animationSlideDuration);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewShown();
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.contentViewCallback.animateContentIn(BaseTransientBottomBar.this.animationSlideDuration - BaseTransientBottomBar.this.animationFadeInDuration, BaseTransientBottomBar.this.animationFadeInDuration);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.view.setTranslationY((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimator.start();
    }

    private void startSlideOutAnimation(final int i5) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, getTranslationYBottom()});
        valueAnimator.setInterpolator(this.animationSlideInterpolator);
        valueAnimator.setDuration((long) this.animationSlideDuration);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewHidden(i5);
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, BaseTransientBottomBar.this.animationFadeOutDuration);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.view.setTranslationY((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public void updateMargins() {
        int i5;
        boolean z4;
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
        } else if (this.view.originalMargins == null) {
            Log.w(TAG, "Unable to update margins because original view margins are not set");
        } else if (this.view.getParent() != null) {
            if (getAnchorView() != null) {
                i5 = this.extraBottomMarginAnchorView;
            } else {
                i5 = this.extraBottomMarginWindowInset;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i6 = this.view.originalMargins.bottom + i5;
            int i7 = this.view.originalMargins.left + this.extraLeftMarginWindowInset;
            int i8 = this.view.originalMargins.right + this.extraRightMarginWindowInset;
            int i9 = this.view.originalMargins.top;
            if (marginLayoutParams.bottomMargin == i6 && marginLayoutParams.leftMargin == i7 && marginLayoutParams.rightMargin == i8 && marginLayoutParams.topMargin == i9) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                marginLayoutParams.bottomMargin = i6;
                marginLayoutParams.leftMargin = i7;
                marginLayoutParams.rightMargin = i8;
                marginLayoutParams.topMargin = i9;
                this.view.requestLayout();
            }
            if ((z4 || this.appliedBottomMarginGestureInset != this.extraBottomMarginGestureInset) && Build.VERSION.SDK_INT >= 29 && shouldUpdateGestureInset()) {
                this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
                this.view.post(this.bottomMarginGestureInsetRunnable);
            }
        }
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.callbacks == null) {
            this.callbacks = new ArrayList();
        }
        this.callbacks.add(baseCallback);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void animateViewIn() {
        this.view.post(new Runnable() {
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.view;
                if (snackbarBaseLayout != null) {
                    if (snackbarBaseLayout.getParent() != null) {
                        BaseTransientBottomBar.this.view.setVisibility(0);
                    }
                    if (BaseTransientBottomBar.this.view.getAnimationMode() == 1) {
                        BaseTransientBottomBar.this.startFadeInAnimation();
                    } else {
                        BaseTransientBottomBar.this.startSlideInAnimation();
                    }
                }
            }
        });
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    /* access modifiers changed from: protected */
    public void dispatchDismiss(int i5) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, i5);
    }

    @Nullable
    public View getAnchorView() {
        Anchor anchor2 = this.anchor;
        if (anchor2 == null) {
            return null;
        }
        return anchor2.getAnchorView();
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        if (hasSnackbarStyleAttr()) {
            return R.layout.mtrl_layout_snackbar;
        }
        return R.layout.design_layout_snackbar;
    }

    @NonNull
    public View getView() {
        return this.view;
    }

    /* access modifiers changed from: protected */
    public boolean hasSnackbarStyleAttr() {
        TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void hideView(int i5) {
        if (!shouldAnimate() || this.view.getVisibility() != 0) {
            onViewHidden(i5);
        } else {
            animateViewOut(i5);
        }
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    /* access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = this.view.getRootWindowInsets()) != null) {
            this.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            updateMargins();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        if (isShownOrQueued()) {
            handler.post(new Runnable() {
                public void run() {
                    BaseTransientBottomBar.this.onViewHidden(3);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void onLayoutChange() {
        if (this.pendingShowingView) {
            showViewImpl();
            this.pendingShowingView = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewHidden(int i5) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List<BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onDismissed(this, i5);
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onShown(this);
            }
        }
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> baseCallback) {
        List<BaseCallback<B>> list;
        if (baseCallback == null || (list = this.callbacks) == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View view2) {
        Anchor anchor2;
        Anchor anchor3 = this.anchor;
        if (anchor3 != null) {
            anchor3.unanchor();
        }
        if (view2 == null) {
            anchor2 = null;
        } else {
            anchor2 = Anchor.anchor(this, view2);
        }
        this.anchor = anchor2;
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean z4) {
        this.anchorViewLayoutListenerEnabled = z4;
    }

    @NonNull
    public B setAnimationMode(int i5) {
        this.view.setAnimationMode(i5);
        return this;
    }

    @NonNull
    public B setBehavior(Behavior behavior2) {
        this.behavior = behavior2;
        return this;
    }

    @NonNull
    public B setDuration(int i5) {
        this.duration = i5;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean z4) {
        this.gestureInsetBottomIgnored = z4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAnimate() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager2.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void show() {
        SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    /* access modifiers changed from: package-private */
    public final void showView() {
        if (this.view.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                setUpBehavior((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.view.addToTargetParent(this.targetParent);
            recalculateAndUpdateMargins();
            this.view.setVisibility(4);
        }
        if (this.view.isLaidOut()) {
            showViewImpl();
        } else {
            this.pendingShowingView = true;
        }
    }

    protected BaseTransientBottomBar(@NonNull Context context2, @NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull ContentViewCallback contentViewCallback2) {
        this.anchorViewLayoutListenerEnabled = false;
        this.bottomMarginGestureInsetRunnable = new Runnable() {
            public void run() {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (baseTransientBottomBar.view != null && baseTransientBottomBar.context != null) {
                    int height = (WindowUtils.getCurrentWindowBounds(BaseTransientBottomBar.this.context).height() - BaseTransientBottomBar.this.getViewAbsoluteBottom()) + ((int) BaseTransientBottomBar.this.view.getTranslationY());
                    if (height >= BaseTransientBottomBar.this.extraBottomMarginGestureInset) {
                        BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                        int unused = baseTransientBottomBar2.appliedBottomMarginGestureInset = baseTransientBottomBar2.extraBottomMarginGestureInset;
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.view.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        Log.w(BaseTransientBottomBar.TAG, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                        return;
                    }
                    BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                    int unused2 = baseTransientBottomBar3.appliedBottomMarginGestureInset = baseTransientBottomBar3.extraBottomMarginGestureInset;
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.extraBottomMarginGestureInset - height;
                    BaseTransientBottomBar.this.view.requestLayout();
                }
            }
        };
        this.managerCallback = new SnackbarManager.Callback() {
            public void dismiss(int i5) {
                Handler handler = BaseTransientBottomBar.handler;
                handler.sendMessage(handler.obtainMessage(1, i5, 0, BaseTransientBottomBar.this));
            }

            public void show() {
                Handler handler = BaseTransientBottomBar.handler;
                handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
            }
        };
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback2 != null) {
            this.targetParent = viewGroup;
            this.contentViewCallback = contentViewCallback2;
            this.context = context2;
            ThemeEnforcement.checkAppCompatTheme(context2);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context2).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
            this.view = snackbarBaseLayout;
            snackbarBaseLayout.setBaseTransientBottomBar(this);
            if (view2 instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view2;
                snackbarContentLayout.updateActionTextColorAlphaIfNeeded(snackbarBaseLayout.getActionTextColorAlpha());
                snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
            }
            snackbarBaseLayout.addView(view2);
            snackbarBaseLayout.setAccessibilityLiveRegion(1);
            snackbarBaseLayout.setImportantForAccessibility(1);
            snackbarBaseLayout.setFitsSystemWindows(true);
            ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new OnApplyWindowInsetsListener() {
                @NonNull
                public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                    int unused = BaseTransientBottomBar.this.extraBottomMarginWindowInset = windowInsetsCompat.getSystemWindowInsetBottom();
                    int unused2 = BaseTransientBottomBar.this.extraLeftMarginWindowInset = windowInsetsCompat.getSystemWindowInsetLeft();
                    int unused3 = BaseTransientBottomBar.this.extraRightMarginWindowInset = windowInsetsCompat.getSystemWindowInsetRight();
                    BaseTransientBottomBar.this.updateMargins();
                    return windowInsetsCompat;
                }
            });
            ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                }

                public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
                    if (i5 != 1048576) {
                        return super.performAccessibilityAction(view, i5, bundle);
                    }
                    BaseTransientBottomBar.this.dismiss();
                    return true;
                }
            });
            this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
            int i5 = R.attr.motionDurationLong2;
            this.animationSlideDuration = MotionUtils.resolveThemeDuration(context2, i5, 250);
            this.animationFadeInDuration = MotionUtils.resolveThemeDuration(context2, i5, DEFAULT_ANIMATION_FADE_IN_DURATION);
            this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(context2, R.attr.motionDurationMedium1, 75);
            int i6 = R.attr.motionEasingEmphasizedInterpolator;
            this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(context2, i6, DEFAULT_ANIMATION_FADE_INTERPOLATOR);
            this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(context2, i6, DEFAULT_ANIMATION_SCALE_INTERPOLATOR);
            this.animationSlideInterpolator = MotionUtils.resolveThemeInterpolator(context2, i6, DEFAULT_ANIMATION_SLIDE_INTERPOLATOR);
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    @NonNull
    public B setAnchorView(@IdRes int i5) {
        View findViewById = this.targetParent.findViewById(i5);
        if (findViewById != null) {
            return setAnchorView(findViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i5);
    }
}
