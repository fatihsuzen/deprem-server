package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final int animationDuration;
    private final TimeInterpolator animationInterpolator;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private int currentLevel;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private boolean isMultiLevel;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    @NonNull
    private final ValueAnimator rotationAnimator;
    private final int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    @Px
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f5, boolean z4);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f5, boolean z4);
    }

    public ClockHandView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, ValueAnimator valueAnimator) {
        clockHandView.getClass();
        clockHandView.setHandRotationInternal(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void adjustLevel(float f5, float f6) {
        int i5 = 2;
        if (MathUtils.dist((float) (getWidth() / 2), (float) (getHeight() / 2), f5, f6) > ((float) getLeveledCircleRadius(2)) + ViewUtils.dpToPx(getContext(), 12)) {
            i5 = 1;
        }
        this.currentLevel = i5;
    }

    private void drawSelector(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int leveledCircleRadius = getLeveledCircleRadius(this.currentLevel);
        float f5 = (float) width;
        float f6 = (float) leveledCircleRadius;
        float cos = (((float) Math.cos(this.degRad)) * f6) + f5;
        float f7 = (float) height;
        this.paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, (f6 * ((float) Math.sin(this.degRad))) + f7, (float) this.selectorRadius, this.paint);
        double sin = Math.sin(this.degRad);
        double cos2 = Math.cos(this.degRad);
        double d5 = (double) ((float) (leveledCircleRadius - this.selectorRadius));
        float f8 = (float) (height + ((int) (d5 * sin)));
        this.paint.setStrokeWidth((float) this.selectorStrokeWidth);
        Canvas canvas2 = canvas;
        canvas2.drawLine(f5, f7, (float) (width + ((int) (cos2 * d5))), f8, this.paint);
        canvas2.drawCircle(f5, f7, this.centerDotRadius, this.paint);
    }

    private int getDegreesFromXY(float f5, float f6) {
        int degrees = (int) Math.toDegrees(Math.atan2((double) (f6 - ((float) (getHeight() / 2))), (double) (f5 - ((float) (getWidth() / 2)))));
        int i5 = degrees + 90;
        if (i5 < 0) {
            return degrees + 450;
        }
        return i5;
    }

    @Dimension
    private int getLeveledCircleRadius(int i5) {
        if (i5 == 2) {
            return Math.round(((float) this.circleRadius) * 0.66f);
        }
        return this.circleRadius;
    }

    private Pair<Float, Float> getValuesForAnimation(float f5) {
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f5) > 180.0f) {
            if (handRotation > 180.0f && f5 < 180.0f) {
                f5 += 360.0f;
            }
            if (handRotation < 180.0f && f5 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(handRotation), Float.valueOf(f5));
    }

    private boolean handleTouchInput(float f5, float f6, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        float degreesFromXY = (float) getDegreesFromXY(f5, f6);
        boolean z8 = false;
        if (getHandRotation() != degreesFromXY) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z5 && z7) {
            return true;
        }
        if (!z7 && !z4) {
            return false;
        }
        if (z6 && this.animatingOnTouchUp) {
            z8 = true;
        }
        setHandRotation(degreesFromXY, z8);
        return true;
    }

    private void initRotationAnimator() {
        this.rotationAnimator.addUpdateListener(new b(this));
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
    }

    private void setHandRotationInternal(@FloatRange(from = 0.0d, to = 360.0d) float f5, boolean z4) {
        float f6 = f5 % 360.0f;
        this.originalDeg = f6;
        this.degRad = Math.toRadians((double) (f6 - 90.0f));
        float leveledCircleRadius = (float) getLeveledCircleRadius(this.currentLevel);
        float width = ((float) (getWidth() / 2)) + (((float) Math.cos(this.degRad)) * leveledCircleRadius);
        float height = ((float) (getHeight() / 2)) + (leveledCircleRadius * ((float) Math.sin(this.degRad)));
        RectF rectF = this.selectorBox;
        int i5 = this.selectorRadius;
        rectF.set(width - ((float) i5), height - ((float) i5), width + ((float) i5), height + ((float) i5));
        for (OnRotateListener onRotate : this.listeners) {
            onRotate.onRotate(f6, z4);
        }
        invalidate();
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.listeners.add(onRotateListener);
    }

    /* access modifiers changed from: package-private */
    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float getHandRotation() {
        return this.originalDeg;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSelector(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (!this.rotationAnimator.isRunning()) {
            setHandRotation(getHandRotation());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        boolean z6;
        OnActionUpListener onActionUpListener2;
        boolean z7;
        boolean z8;
        int actionMasked = motionEvent.getActionMasked();
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        if (actionMasked == 0) {
            this.downX = x4;
            this.downY = y4;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z5 = true;
            z6 = false;
            z4 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i5 = (int) (x4 - this.downX);
            int i6 = (int) (y4 - this.downY);
            if ((i5 * i5) + (i6 * i6) > this.scaledTouchSlop) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.isInTapRegion = z7;
            z6 = this.changedDuringTouch;
            if (actionMasked == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (this.isMultiLevel) {
                adjustLevel(x4, y4);
            }
            z4 = z8;
            z5 = false;
        } else {
            z6 = false;
            z5 = false;
            z4 = false;
        }
        boolean handleTouchInput = this.changedDuringTouch | handleTouchInput(x4, y4, z6, z5, z4);
        this.changedDuringTouch = handleTouchInput;
        if (handleTouchInput && z4 && (onActionUpListener2 = this.onActionUpListener) != null) {
            onActionUpListener2.onActionUp((float) getDegreesFromXY(x4, y4), this.isInTapRegion);
        }
        return true;
    }

    public void setAnimateOnTouchUp(boolean z4) {
        this.animatingOnTouchUp = z4;
    }

    public void setCircleRadius(@Dimension int i5) {
        this.circleRadius = i5;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setCurrentLevel(int i5) {
        this.currentLevel = i5;
        invalidate();
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f5) {
        setHandRotation(f5, false);
    }

    /* access modifiers changed from: package-private */
    public void setMultiLevel(boolean z4) {
        if (this.isMultiLevel && !z4) {
            this.currentLevel = 1;
        }
        this.isMultiLevel = z4;
        invalidate();
    }

    public void setOnActionUpListener(OnActionUpListener onActionUpListener2) {
        this.onActionUpListener = onActionUpListener2;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f5, boolean z4) {
        this.rotationAnimator.cancel();
        if (!z4) {
            setHandRotationInternal(f5, false);
            return;
        }
        Pair<Float, Float> valuesForAnimation = getValuesForAnimation(f5);
        this.rotationAnimator.setFloatValues(new float[]{((Float) valuesForAnimation.first).floatValue(), ((Float) valuesForAnimation.second).floatValue()});
        this.rotationAnimator.setDuration((long) this.animationDuration);
        this.rotationAnimator.setInterpolator(this.animationInterpolator);
        this.rotationAnimator.start();
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.rotationAnimator = new ValueAnimator();
        this.listeners = new ArrayList();
        Paint paint2 = new Paint();
        this.paint = paint2;
        this.selectorBox = new RectF();
        this.currentLevel = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i5, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.animationDuration = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationLong2, 200);
        this.animationInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint2.setAntiAlias(true);
        paint2.setColor(color);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
        initRotationAnimator();
    }
}
