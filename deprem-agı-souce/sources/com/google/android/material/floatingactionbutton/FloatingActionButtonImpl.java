package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;

class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] ENABLED_STATE_SET = {16842910};
    static final int[] FOCUSED_ENABLED_STATE_SET = {16842908, 16842910};
    private static final int HIDE_ANIM_DURATION_ATTR = R.attr.motionDurationMedium1;
    private static final int HIDE_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.4f;
    static final int[] HOVERED_ENABLED_STATE_SET = {16843623, 16842910};
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {16843623, 16842908, 16842910};
    static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final int SHOW_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int SHOW_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private static final float SPEC_HIDE_ICON_SCALE = 0.0f;
    private static final float SPEC_HIDE_SCALE = 0.0f;
    /* access modifiers changed from: private */
    public int animState = 0;
    @Nullable
    BorderDrawable borderDrawable;
    @Nullable
    Drawable contentBackground;
    /* access modifiers changed from: private */
    @Nullable
    public Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    @Nullable
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    /* access modifiers changed from: private */
    public float imageMatrixScale = 1.0f;
    private int maxImageSize;
    int minTouchTargetSize;
    @Nullable
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    @Nullable
    Drawable rippleDrawable;
    boolean shadowPaddingEnabled = true;
    final ShadowViewDelegate shadowViewDelegate;
    @Nullable
    ShapeAppearanceModel shapeAppearance;
    @Nullable
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;
    @Nullable
    private MotionSpec showMotionSpec;
    @Nullable
    private StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix = new Matrix();
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        public boolean isStateful() {
            return true;
        }
    }

    interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate2) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate2;
    }

    public static /* synthetic */ void a(FloatingActionButtonImpl floatingActionButtonImpl, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Matrix matrix, ValueAnimator valueAnimator) {
        floatingActionButtonImpl.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        floatingActionButtonImpl.view.setAlpha(AnimationUtils.lerp(f5, f6, 0.0f, 0.2f, floatValue));
        floatingActionButtonImpl.view.setScaleX(AnimationUtils.lerp(f7, f8, floatValue));
        floatingActionButtonImpl.view.setScaleY(AnimationUtils.lerp(f9, f8, floatValue));
        floatingActionButtonImpl.imageMatrixScale = AnimationUtils.lerp(f10, f11, floatValue);
        floatingActionButtonImpl.calculateImageMatrixFromScale(AnimationUtils.lerp(f10, f11, floatValue), matrix);
        floatingActionButtonImpl.view.setImageMatrix(matrix);
    }

    private void calculateImageMatrixFromScale(float f5, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.view.getDrawable();
        if (drawable != null && this.maxImageSize != 0) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i5 = this.maxImageSize;
            rectF2.set(0.0f, 0.0f, (float) i5, (float) i5);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i6 = this.maxImageSize;
            matrix.postScale(f5, f5, ((float) i6) / 2.0f, ((float) i6) / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec motionSpec, float f5, float f6, float f7) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{f5});
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{f6});
        motionSpec.getTiming("scale").apply(ofFloat2);
        workAroundOreoBug(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{f6});
        motionSpec.getTiming("scale").apply(ofFloat3);
        workAroundOreoBug(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f7, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator() {
            public Matrix evaluate(float f5, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
                float unused = FloatingActionButtonImpl.this.imageMatrixScale = f5;
                return super.evaluate(f5, matrix, matrix2);
            }
        }, new Matrix[]{new Matrix(this.tmpMatrix)});
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet createDefaultAnimator(float f5, float f6, float f7, int i5, int i6) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a(this, this.view.getAlpha(), f5, this.view.getScaleX(), f6, this.view.getScaleY(), this.imageMatrixScale, f7, new Matrix(this.tmpMatrix)));
        arrayList.add(ofFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration((long) MotionUtils.resolveThemeDuration(this.view.getContext(), i5, this.view.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), i6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    @NonNull
    private StateListAnimator createDefaultStateListAnimator(float f5, float f6, float f7) {
        StateListAnimator stateListAnimator2 = new StateListAnimator();
        stateListAnimator2.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(f5, f7));
        stateListAnimator2.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f5, f6));
        stateListAnimator2.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f5, f6));
        stateListAnimator2.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(f5, f6));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{f5}).setDuration(0));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.view;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        stateListAnimator2.addState(ENABLED_STATE_SET, animatorSet);
        stateListAnimator2.addState(EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        return stateListAnimator2;
    }

    @NonNull
    private Animator createElevationAnimator(float f5, float f6) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{f5}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{f6}).setDuration(100));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    private boolean shouldAnimateVisibilityChange() {
        if (!this.view.isLaidOut() || this.view.isInEditMode()) {
            return false;
        }
        return true;
    }

    private void workAroundOreoBug(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new TypeEvaluator<Float>() {
                final FloatEvaluator floatEvaluator = new FloatEvaluator();

                public Float evaluate(float f5, Float f6, Float f7) {
                    float floatValue = this.floatEvaluator.evaluate(f5, f6, f7).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void addTransformationCallback(@NonNull InternalTransformationCallback internalTransformationCallback) {
        if (this.transformationCallbacks == null) {
            this.transformationCallbacks = new ArrayList<>();
        }
        this.transformationCallbacks.add(internalTransformationCallback);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public BorderDrawable createBorderDrawable(int i5, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        BorderDrawable borderDrawable2 = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        borderDrawable2.setGradientColors(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        borderDrawable2.setBorderWidth((float) i5);
        borderDrawable2.setBorderTint(colorStateList);
        return borderDrawable2;
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    /* access modifiers changed from: package-private */
    public float getElevation() {
        return this.view.getElevation();
    }

    /* access modifiers changed from: package-private */
    public boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    /* access modifiers changed from: package-private */
    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    /* access modifiers changed from: package-private */
    public void getPadding(@NonNull Rect rect) {
        float f5;
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            int touchTargetPadding = getTouchTargetPadding();
            if (this.shadowPaddingEnabled) {
                f5 = getElevation() + this.pressedTranslationZ;
            } else {
                f5 = 0.0f;
            }
            int max = Math.max(touchTargetPadding, (int) Math.ceil((double) f5));
            int max2 = Math.max(touchTargetPadding, (int) Math.ceil((double) (f5 * SHADOW_MULTIPLIER)));
            rect.set(max, max2, max, max2);
        } else if (ignoreExpandBoundsForA11y()) {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    /* access modifiers changed from: package-private */
    public int getTouchTargetPadding() {
        if (this.ensureMinTouchTargetSize) {
            return Math.max((this.minTouchTargetSize - this.view.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void hide(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z4) {
        int i5;
        FloatingActionButtonImpl floatingActionButtonImpl;
        AnimatorSet animatorSet;
        if (isOrWillBeHidden()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (shouldAnimateVisibilityChange()) {
            MotionSpec motionSpec = this.hideMotionSpec;
            if (motionSpec != null) {
                animatorSet = createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
                floatingActionButtonImpl = this;
            } else {
                floatingActionButtonImpl = this;
                animatorSet = floatingActionButtonImpl.createDefaultAnimator(0.0f, 0.4f, 0.4f, HIDE_ANIM_DURATION_ATTR, HIDE_ANIM_EASING_ATTR);
            }
            animatorSet.addListener(new AnimatorListenerAdapter() {
                private boolean cancelled;

                public void onAnimationCancel(Animator animator) {
                    this.cancelled = true;
                }

                public void onAnimationEnd(Animator animator) {
                    int i5;
                    int unused = FloatingActionButtonImpl.this.animState = 0;
                    Animator unused2 = FloatingActionButtonImpl.this.currentAnimator = null;
                    if (!this.cancelled) {
                        FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.view;
                        boolean z4 = z4;
                        if (z4) {
                            i5 = 8;
                        } else {
                            i5 = 4;
                        }
                        floatingActionButton.internalSetVisibility(i5, z4);
                        InternalVisibilityChangedListener internalVisibilityChangedListener = internalVisibilityChangedListener;
                        if (internalVisibilityChangedListener != null) {
                            internalVisibilityChangedListener.onHidden();
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    FloatingActionButtonImpl.this.view.internalSetVisibility(0, z4);
                    int unused = FloatingActionButtonImpl.this.animState = 1;
                    Animator unused2 = FloatingActionButtonImpl.this.currentAnimator = animator;
                    this.cancelled = false;
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = floatingActionButtonImpl.hideListeners;
            if (arrayList != null) {
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Animator.AnimatorListener animatorListener = arrayList.get(i6);
                    i6++;
                    animatorSet.addListener(animatorListener);
                }
            }
            animatorSet.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.view;
        if (z4) {
            i5 = 8;
        } else {
            i5 = 4;
        }
        floatingActionButton.internalSetVisibility(i5, z4);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onHidden();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean ignoreExpandBoundsForA11y() {
        if (!this.ensureMinTouchTargetSize || this.view.getSizeDimension() >= this.minTouchTargetSize) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void initializeBackgroundDrawable(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i5) {
        Drawable drawable;
        MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        this.shapeDrawable = createShapeDrawable;
        createShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i5 > 0) {
            this.borderDrawable = createBorderDrawable(i5, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
        } else {
            this.borderDrawable = null;
            drawable = this.shapeDrawable;
        }
        RippleDrawable rippleDrawable2 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, (Drawable) null);
        this.rippleDrawable = rippleDrawable2;
        this.contentBackground = rippleDrawable2;
    }

    /* access modifiers changed from: package-private */
    public boolean isOrWillBeHidden() {
        if (this.view.getVisibility() == 0) {
            if (this.animState == 1) {
                return true;
            }
            return false;
        } else if (this.animState != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isOrWillBeShown() {
        if (this.view.getVisibility() != 0) {
            if (this.animState == 2) {
                return true;
            }
            return false;
        } else if (this.animState != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.view, materialShapeDrawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void onCompatShadowChanged() {
        updatePadding();
    }

    /* access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.preDrawListener = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onDrawableStateChangedForLollipop() {
        if (this.view.isEnabled()) {
            this.view.setElevation(this.elevation);
            if (this.view.isPressed()) {
                this.view.setTranslationZ(this.pressedTranslationZ);
            } else if (this.view.isFocused() || this.view.isHovered()) {
                this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
            } else {
                this.view.setTranslationZ(0.0f);
            }
        } else {
            this.view.setElevation(0.0f);
            this.view.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void onElevationsChanged(float f5, float f6, float f7) {
        if (this.view.getStateListAnimator() == this.stateListAnimator) {
            StateListAnimator createDefaultStateListAnimator = createDefaultStateListAnimator(f5, f6, f7);
            this.stateListAnimator = createDefaultStateListAnimator;
            this.view.setStateListAnimator(createDefaultStateListAnimator);
        }
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPaddingUpdated(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding()) {
            this.shadowViewDelegate.setBackgroundDrawable(new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    /* access modifiers changed from: package-private */
    public void onScaleChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                InternalTransformationCallback internalTransformationCallback = arrayList.get(i5);
                i5++;
                internalTransformationCallback.onScaleChanged();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                InternalTransformationCallback internalTransformationCallback = arrayList.get(i5);
                i5++;
                internalTransformationCallback.onTranslationChanged();
            }
        }
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeTransformationCallback(@NonNull InternalTransformationCallback internalTransformationCallback) {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            arrayList.remove(internalTransformationCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        BorderDrawable borderDrawable2 = this.borderDrawable;
        if (borderDrawable2 != null) {
            borderDrawable2.setBorderTint(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setElevation(float f5) {
        if (this.elevation != f5) {
            this.elevation = f5;
            onElevationsChanged(f5, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEnsureMinTouchTargetSize(boolean z4) {
        this.ensureMinTouchTargetSize = z4;
    }

    /* access modifiers changed from: package-private */
    public final void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public final void setHoveredFocusedTranslationZ(float f5) {
        if (this.hoveredFocusedTranslationZ != f5) {
            this.hoveredFocusedTranslationZ = f5;
            onElevationsChanged(this.elevation, f5, this.pressedTranslationZ);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setImageMatrixScale(float f5) {
        this.imageMatrixScale = f5;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f5, matrix);
        this.view.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void setMaxImageSize(int i5) {
        if (this.maxImageSize != i5) {
            this.maxImageSize = i5;
            updateImageMatrixScale();
        }
    }

    /* access modifiers changed from: package-private */
    public void setMinTouchTargetSize(int i5) {
        this.minTouchTargetSize = i5;
    }

    /* access modifiers changed from: package-private */
    public final void setPressedTranslationZ(float f5) {
        if (this.pressedTranslationZ != f5) {
            this.pressedTranslationZ = f5;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public void setShadowPaddingEnabled(boolean z4) {
        this.shadowPaddingEnabled = z4;
        updatePadding();
    }

    /* access modifiers changed from: package-private */
    public final void setShapeAppearance(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable2 = this.borderDrawable;
        if (borderDrawable2 != null) {
            borderDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAddPadding() {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() || ignoreExpandBoundsForA11y()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void show(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z4) {
        boolean z5;
        FloatingActionButtonImpl floatingActionButtonImpl;
        AnimatorSet animatorSet;
        float f5;
        float f6;
        if (isOrWillBeShown()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        int i5 = 0;
        if (this.showMotionSpec == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (shouldAnimateVisibilityChange()) {
            if (this.view.getVisibility() != 0) {
                float f7 = 0.0f;
                this.view.setAlpha(0.0f);
                FloatingActionButton floatingActionButton = this.view;
                if (z5) {
                    f5 = 0.4f;
                } else {
                    f5 = 0.0f;
                }
                floatingActionButton.setScaleY(f5);
                FloatingActionButton floatingActionButton2 = this.view;
                if (z5) {
                    f6 = 0.4f;
                } else {
                    f6 = 0.0f;
                }
                floatingActionButton2.setScaleX(f6);
                if (z5) {
                    f7 = 0.4f;
                }
                setImageMatrixScale(f7);
            }
            MotionSpec motionSpec = this.showMotionSpec;
            if (motionSpec != null) {
                animatorSet = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
                floatingActionButtonImpl = this;
            } else {
                floatingActionButtonImpl = this;
                animatorSet = floatingActionButtonImpl.createDefaultAnimator(1.0f, 1.0f, 1.0f, SHOW_ANIM_DURATION_ATTR, SHOW_ANIM_EASING_ATTR);
            }
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    int unused = FloatingActionButtonImpl.this.animState = 0;
                    Animator unused2 = FloatingActionButtonImpl.this.currentAnimator = null;
                    InternalVisibilityChangedListener internalVisibilityChangedListener = internalVisibilityChangedListener;
                    if (internalVisibilityChangedListener != null) {
                        internalVisibilityChangedListener.onShown();
                    }
                }

                public void onAnimationStart(Animator animator) {
                    FloatingActionButtonImpl.this.view.internalSetVisibility(0, z4);
                    int unused = FloatingActionButtonImpl.this.animState = 2;
                    Animator unused2 = FloatingActionButtonImpl.this.currentAnimator = animator;
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = floatingActionButtonImpl.showListeners;
            if (arrayList != null) {
                int size = arrayList.size();
                while (i5 < size) {
                    Animator.AnimatorListener animatorListener = arrayList.get(i5);
                    i5++;
                    animatorSet.addListener(animatorListener);
                }
            }
            animatorSet.start();
            return;
        }
        this.view.internalSetVisibility(0, z4);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onShown();
        }
    }

    /* access modifiers changed from: package-private */
    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    /* access modifiers changed from: package-private */
    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void updateShapeElevation(float f5) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f5);
        }
    }
}
