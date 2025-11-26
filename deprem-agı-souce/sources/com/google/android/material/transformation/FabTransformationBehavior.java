package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray = new int[2];
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();

    protected static class FabTransformationSpec {
        public Positioning positioning;
        @Nullable
        public MotionSpec timings;

        protected FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
    }

    @Nullable
    private ViewGroup calculateChildContentContainer(@NonNull View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            return toViewGroupOrNull(findViewById);
        }
        if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
            return toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
        }
        return toViewGroupOrNull(view);
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@NonNull View view, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, @NonNull MotionTiming motionTiming2, float f5, float f6, float f7, float f8, @NonNull RectF rectF) {
        float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, f5, f7);
        float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, f6, f8);
        Rect rect = this.tmpRect;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.tmpRectF1;
        rectF2.set(rect);
        RectF rectF3 = this.tmpRectF2;
        calculateWindowBounds(view, rectF3);
        rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void calculateDependencyWindowBounds(@NonNull View view, @NonNull RectF rectF) {
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float f5, float f6, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        int i5;
        if (f5 == 0.0f || f6 == 0.0f) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        } else if ((!z4 || f6 >= 0.0f) && (z4 || i5 <= 0)) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
        } else {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
        }
        return new Pair<>(motionTiming2, motionTiming);
    }

    private float calculateRevealCenterX(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(-calculateTranslationX(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float calculateRevealCenterY(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(0.0f, -calculateTranslationY(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float calculateTranslationX(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float f5;
        float centerX;
        float centerX2;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i5 = positioning.gravity & 7;
        if (i5 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i5 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i5 != 5) {
            f5 = 0.0f;
            return f5 + positioning.xAdjustment;
        } else {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f5 = centerX - centerX2;
        return f5 + positioning.xAdjustment;
    }

    private float calculateTranslationY(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float f5;
        float centerY;
        float centerY2;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i5 = positioning.gravity & 112;
        if (i5 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i5 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i5 != 80) {
            f5 = 0.0f;
            return f5 + positioning.yAdjustment;
        } else {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f5 = centerY - centerY2;
        return f5 + positioning.yAdjustment;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, float f5, float f6) {
        long delay = motionTiming.getDelay();
        long duration = motionTiming.getDuration();
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return AnimationUtils.lerp(f5, f6, motionTiming.getInterpolator().getInterpolation(((float) (((timing.getDelay() + timing.getDuration()) + 17) - delay)) / ((float) duration)));
    }

    private void calculateWindowBounds(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void createChildrenFadeAnimation(View view, View view2, boolean z4, boolean z5, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup calculateChildContentContainer;
        ObjectAnimator objectAnimator;
        if ((view2 instanceof ViewGroup) && (calculateChildContentContainer = calculateChildContentContainer(view2)) != null) {
            if (z4) {
                if (!z5) {
                    ChildrenAlphaProperty.CHILDREN_ALPHA.set(calculateChildContentContainer, Float.valueOf(0.0f));
                }
                objectAnimator = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
            } else {
                objectAnimator = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
            }
            fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void createColorAnimation(@NonNull View view, View view2, boolean z4, boolean z5, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int backgroundTint = getBackgroundTint(view);
            int i5 = 16777215 & backgroundTint;
            if (z4) {
                if (!z5) {
                    circularRevealWidget.setCircularRevealScrimColor(backgroundTint);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{i5});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{backgroundTint});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.getInstance());
            fabTransformationSpec.timings.getTiming("color").apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void createDependencyTranslationAnimation(@NonNull View view, @NonNull View view2, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list) {
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z4, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        Property property = View.TRANSLATION_X;
        if (!z4) {
            calculateTranslationX = this.dependencyOriginalTranslationX;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{calculateTranslationX});
        Property property2 = View.TRANSLATION_Y;
        if (!z4) {
            calculateTranslationY = this.dependencyOriginalTranslationY;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, new float[]{calculateTranslationY});
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private void createElevationAnimation(View view, @NonNull View view2, boolean z4, boolean z5, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float elevation = view2.getElevation() - view.getElevation();
        if (z4) {
            if (!z5) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-elevation});
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    private void createExpansionAnimation(@NonNull View view, View view2, boolean z4, boolean z5, @NonNull FabTransformationSpec fabTransformationSpec, float f5, float f6, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        if (view4 instanceof CircularRevealWidget) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view4;
            float calculateRevealCenterX = calculateRevealCenterX(view3, view4, fabTransformationSpec2.positioning);
            float calculateRevealCenterY = calculateRevealCenterY(view3, view4, fabTransformationSpec2.positioning);
            ((FloatingActionButton) view3).getMeasuredContentRect(this.tmpRect);
            float width = ((float) this.tmpRect.width()) / 2.0f;
            MotionTiming timing = fabTransformationSpec2.timings.getTiming("expansion");
            if (z4) {
                if (!z5) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(calculateRevealCenterX, calculateRevealCenterY, width));
                }
                if (z5) {
                    width = circularRevealWidget.getRevealInfo().radius;
                }
                animator = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, MathUtils.distanceToFurthestCorner(calculateRevealCenterX, calculateRevealCenterY, 0.0f, 0.0f, f5, f6));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget.setRevealInfo(revealInfo);
                    }
                });
                createPreFillRadialExpansion(view4, timing.getDelay(), (int) calculateRevealCenterX, (int) calculateRevealCenterY, width, list);
            } else {
                float f7 = circularRevealWidget.getRevealInfo().radius;
                Animator createCircularReveal = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, width);
                int i5 = (int) calculateRevealCenterY;
                int i6 = (int) calculateRevealCenterX;
                long delay = timing.getDelay();
                View view5 = view2;
                createPreFillRadialExpansion(view5, delay, i6, i5, f7, list);
                long delay2 = timing.getDelay();
                int i7 = i6;
                long duration = timing.getDuration();
                long totalDuration = fabTransformationSpec2.timings.getTotalDuration();
                int i8 = i7;
                createPostFillRadialExpansion(view2, delay2, duration, totalDuration, i8, i5, width, list);
                animator = createCircularReveal;
            }
            timing.apply(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget));
        }
    }

    private void createIconFadeAnimation(View view, final View view2, boolean z4, boolean z5, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z4) {
                    if (!z5) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpec.timings.getTiming("iconFade").apply(objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable((Drawable) null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
    }

    private void createPostFillRadialExpansion(View view, long j5, long j6, long j7, int i5, int i6, float f5, @NonNull List<Animator> list) {
        long j8 = j5 + j6;
        if (j8 < j7) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i5, i6, f5, f5);
            createCircularReveal.setStartDelay(j8);
            createCircularReveal.setDuration(j7 - j8);
            list.add(createCircularReveal);
        }
    }

    private void createPreFillRadialExpansion(View view, long j5, int i5, int i6, float f5, @NonNull List<Animator> list) {
        if (j5 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i5, i6, f5, f5);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j5);
            list.add(createCircularReveal);
        }
    }

    private void createTranslationAnimation(@NonNull View view, @NonNull View view2, boolean z4, boolean z5, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        boolean z6 = z4;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        List<Animator> list3 = list;
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec2.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec2.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z6, fabTransformationSpec2);
        MotionTiming motionTiming3 = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming4 = (MotionTiming) calculateMotionTiming.second;
        if (z6) {
            if (!z5) {
                view2.setTranslationX(-calculateTranslationX);
                view2.setTranslationY(-calculateTranslationY);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f});
            MotionTiming motionTiming5 = motionTiming3;
            motionTiming = motionTiming4;
            motionTiming2 = motionTiming5;
            calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationSpec2, motionTiming2, motionTiming, -calculateTranslationX, -calculateTranslationY, 0.0f, 0.0f, rectF);
        } else {
            MotionTiming motionTiming6 = motionTiming3;
            motionTiming = motionTiming4;
            motionTiming2 = motionTiming6;
            View view3 = view2;
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{-calculateTranslationX});
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{-calculateTranslationY});
        }
        motionTiming2.apply(objectAnimator2);
        motionTiming.apply(objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private int getBackgroundTint(@NonNull View view) {
        ColorStateList backgroundTintList = view.getBackgroundTintList();
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    private ViewGroup toViewGroupOrNull(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View view, @NonNull View view2, boolean z4, boolean z5) {
        FabTransformationSpec onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z4);
        if (z4) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final View view3 = view;
        final View view4 = view2;
        final boolean z6 = z4;
        boolean z7 = z5;
        createElevationAnimation(view3, view4, z6, z7, onCreateMotionSpec, arrayList, arrayList2);
        RectF rectF = this.tmpRectF1;
        createTranslationAnimation(view3, view4, z6, z7, onCreateMotionSpec, arrayList, arrayList2, rectF);
        boolean z8 = z7;
        float width = rectF.width();
        float height = rectF.height();
        FabTransformationSpec fabTransformationSpec = onCreateMotionSpec;
        createDependencyTranslationAnimation(view3, view4, z6, fabTransformationSpec, arrayList);
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        boolean z9 = z8;
        createIconFadeAnimation(view3, view4, z6, z9, fabTransformationSpec2, arrayList, arrayList2);
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        createExpansionAnimation(view3, view4, z6, z9, fabTransformationSpec2, width, height, arrayList3, arrayList4);
        ArrayList arrayList5 = arrayList3;
        ArrayList arrayList6 = arrayList4;
        createColorAnimation(view3, view4, z6, z9, fabTransformationSpec2, arrayList5, arrayList6);
        createChildrenFadeAnimation(view3, view4, z6, z9, fabTransformationSpec2, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList5);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z6) {
                    view4.setVisibility(4);
                    view3.setAlpha(1.0f);
                    view3.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z6) {
                    view4.setVisibility(0);
                    view3.setAlpha(0.0f);
                    view3.setVisibility(4);
                }
            }
        });
        int size = arrayList6.size();
        for (int i5 = 0; i5 < size; i5++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList6.get(i5));
        }
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z4);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
