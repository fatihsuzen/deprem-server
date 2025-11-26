package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PagingIndicator extends View {
    private static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final Property<Dot, Float> DOT_ALPHA;
    private static final Property<Dot, Float> DOT_DIAMETER;
    private static final Property<Dot, Float> DOT_TRANSLATION_X;
    private static final long DURATION_ALPHA = 167;
    private static final long DURATION_DIAMETER = 417;
    private static final long DURATION_TRANSLATION_X = 417;
    private final AnimatorSet mAnimator;
    Bitmap mArrow;
    final int mArrowDiameter;
    private final int mArrowGap;
    Paint mArrowPaint;
    final int mArrowRadius;
    final Rect mArrowRect;
    final float mArrowToBgRatio;
    final Paint mBgPaint;
    private int mCurrentPage;
    int mDotCenterY;
    final int mDotDiameter;
    @ColorInt
    int mDotFgSelectColor;
    private final int mDotGap;
    final int mDotRadius;
    private int[] mDotSelectedNextX;
    private int[] mDotSelectedPrevX;
    private int[] mDotSelectedX;
    private Dot[] mDots;
    final Paint mFgPaint;
    private final AnimatorSet mHideAnimator;
    boolean mIsLtr;
    private int mPageCount;
    private int mPreviousPage;
    private final int mShadowRadius;
    private final AnimatorSet mShowAnimator;

    public class Dot {
        static final float LEFT = -1.0f;
        static final float LTR = 1.0f;
        static final float RIGHT = 1.0f;
        static final float RTL = -1.0f;
        float mAlpha;
        float mArrowImageRadius;
        float mCenterX;
        float mDiameter;
        float mDirection = 1.0f;
        @ColorInt
        int mFgColor;
        float mLayoutDirection;
        float mRadius;
        float mTranslationX;

        public Dot() {
            float f5 = 1.0f;
            this.mLayoutDirection = !PagingIndicator.this.mIsLtr ? -1.0f : f5;
        }

        public void adjustAlpha() {
            this.mFgColor = Color.argb(Math.round(this.mAlpha * 255.0f), Color.red(PagingIndicator.this.mDotFgSelectColor), Color.green(PagingIndicator.this.mDotFgSelectColor), Color.blue(PagingIndicator.this.mDotFgSelectColor));
        }

        /* access modifiers changed from: package-private */
        public void deselect() {
            this.mTranslationX = 0.0f;
            this.mCenterX = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mDiameter = (float) pagingIndicator.mDotDiameter;
            float f5 = (float) pagingIndicator.mDotRadius;
            this.mRadius = f5;
            this.mArrowImageRadius = f5 * pagingIndicator.mArrowToBgRatio;
            this.mAlpha = 0.0f;
            adjustAlpha();
        }

        /* access modifiers changed from: package-private */
        public void draw(Canvas canvas) {
            float f5 = this.mCenterX + this.mTranslationX;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            canvas.drawCircle(f5, (float) pagingIndicator.mDotCenterY, this.mRadius, pagingIndicator.mBgPaint);
            if (this.mAlpha > 0.0f) {
                PagingIndicator.this.mFgPaint.setColor(this.mFgColor);
                PagingIndicator pagingIndicator2 = PagingIndicator.this;
                canvas.drawCircle(f5, (float) pagingIndicator2.mDotCenterY, this.mRadius, pagingIndicator2.mFgPaint);
                PagingIndicator pagingIndicator3 = PagingIndicator.this;
                Bitmap bitmap = pagingIndicator3.mArrow;
                Rect rect = pagingIndicator3.mArrowRect;
                float f6 = this.mArrowImageRadius;
                int i5 = PagingIndicator.this.mDotCenterY;
                canvas.drawBitmap(bitmap, rect, new Rect((int) (f5 - f6), (int) (((float) i5) - f6), (int) (f5 + f6), (int) (((float) i5) + f6)), PagingIndicator.this.mArrowPaint);
            }
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public float getDiameter() {
            return this.mDiameter;
        }

        public float getTranslationX() {
            return this.mTranslationX;
        }

        /* access modifiers changed from: package-private */
        public void onRtlPropertiesChanged() {
            float f5;
            if (PagingIndicator.this.mIsLtr) {
                f5 = 1.0f;
            } else {
                f5 = -1.0f;
            }
            this.mLayoutDirection = f5;
        }

        /* access modifiers changed from: package-private */
        public void select() {
            this.mTranslationX = 0.0f;
            this.mCenterX = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mDiameter = (float) pagingIndicator.mArrowDiameter;
            float f5 = (float) pagingIndicator.mArrowRadius;
            this.mRadius = f5;
            this.mArrowImageRadius = f5 * pagingIndicator.mArrowToBgRatio;
            this.mAlpha = 1.0f;
            adjustAlpha();
        }

        public void setAlpha(float f5) {
            this.mAlpha = f5;
            adjustAlpha();
            PagingIndicator.this.invalidate();
        }

        public void setDiameter(float f5) {
            this.mDiameter = f5;
            float f6 = f5 / 2.0f;
            this.mRadius = f6;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mArrowImageRadius = f6 * pagingIndicator.mArrowToBgRatio;
            pagingIndicator.invalidate();
        }

        public void setTranslationX(float f5) {
            this.mTranslationX = f5 * this.mDirection * this.mLayoutDirection;
            PagingIndicator.this.invalidate();
        }
    }

    static {
        Class<Float> cls = Float.class;
        DOT_ALPHA = new Property<Dot, Float>(cls, "alpha") {
            public Float get(Dot dot) {
                return Float.valueOf(dot.getAlpha());
            }

            public void set(Dot dot, Float f5) {
                dot.setAlpha(f5.floatValue());
            }
        };
        DOT_DIAMETER = new Property<Dot, Float>(cls, "diameter") {
            public Float get(Dot dot) {
                return Float.valueOf(dot.getDiameter());
            }

            public void set(Dot dot, Float f5) {
                dot.setDiameter(f5.floatValue());
            }
        };
        DOT_TRANSLATION_X = new Property<Dot, Float>(cls, "translation_x") {
            public Float get(Dot dot) {
                return Float.valueOf(dot.getTranslationX());
            }

            public void set(Dot dot, Float f5) {
                dot.setTranslationX(f5.floatValue());
            }
        };
    }

    public PagingIndicator(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void adjustDotPosition() {
        int i5;
        float f5;
        int i6 = 0;
        while (true) {
            i5 = this.mCurrentPage;
            f5 = -1.0f;
            if (i6 >= i5) {
                break;
            }
            this.mDots[i6].deselect();
            Dot dot = this.mDots[i6];
            if (i6 != this.mPreviousPage) {
                f5 = 1.0f;
            }
            dot.mDirection = f5;
            dot.mCenterX = (float) this.mDotSelectedPrevX[i6];
            i6++;
        }
        this.mDots[i5].select();
        Dot[] dotArr = this.mDots;
        int i7 = this.mCurrentPage;
        Dot dot2 = dotArr[i7];
        if (this.mPreviousPage >= i7) {
            f5 = 1.0f;
        }
        dot2.mDirection = f5;
        dot2.mCenterX = (float) this.mDotSelectedX[i7];
        while (true) {
            i7++;
            if (i7 < this.mPageCount) {
                this.mDots[i7].deselect();
                Dot dot3 = this.mDots[i7];
                dot3.mDirection = 1.0f;
                dot3.mCenterX = (float) this.mDotSelectedNextX[i7];
            } else {
                return;
            }
        }
    }

    private void calculateDotPositions() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i5 = (paddingLeft + width) / 2;
        int i6 = this.mPageCount;
        int[] iArr = new int[i6];
        this.mDotSelectedX = iArr;
        int[] iArr2 = new int[i6];
        this.mDotSelectedPrevX = iArr2;
        int[] iArr3 = new int[i6];
        this.mDotSelectedNextX = iArr3;
        int i7 = 1;
        if (this.mIsLtr) {
            int i8 = i5 - (requiredWidth / 2);
            int i9 = this.mDotRadius;
            int i10 = this.mDotGap;
            int i11 = this.mArrowGap;
            iArr[0] = ((i8 + i9) - i10) + i11;
            iArr2[0] = i8 + i9;
            iArr3[0] = ((i8 + i9) - (i10 * 2)) + (i11 * 2);
            while (i7 < this.mPageCount) {
                int[] iArr4 = this.mDotSelectedX;
                int[] iArr5 = this.mDotSelectedPrevX;
                int i12 = i7 - 1;
                int i13 = iArr5[i12];
                int i14 = this.mArrowGap;
                iArr4[i7] = i13 + i14;
                iArr5[i7] = iArr5[i12] + this.mDotGap;
                this.mDotSelectedNextX[i7] = iArr4[i12] + i14;
                i7++;
            }
        } else {
            int i15 = i5 + (requiredWidth / 2);
            int i16 = this.mDotRadius;
            int i17 = this.mDotGap;
            int i18 = this.mArrowGap;
            iArr[0] = ((i15 - i16) + i17) - i18;
            iArr2[0] = i15 - i16;
            iArr3[0] = ((i15 - i16) + (i17 * 2)) - (i18 * 2);
            while (i7 < this.mPageCount) {
                int[] iArr6 = this.mDotSelectedX;
                int[] iArr7 = this.mDotSelectedPrevX;
                int i19 = i7 - 1;
                int i20 = iArr7[i19];
                int i21 = this.mArrowGap;
                iArr6[i7] = i20 - i21;
                iArr7[i7] = iArr7[i19] - this.mDotGap;
                this.mDotSelectedNextX[i7] = iArr6[i19] - i21;
                i7++;
            }
        }
        this.mDotCenterY = paddingTop + this.mArrowRadius;
        adjustDotPosition();
    }

    private Animator createDotAlphaAnimator(float f5, float f6) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_ALPHA, new float[]{f5, f6});
        ofFloat.setDuration(DURATION_ALPHA);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private Animator createDotDiameterAnimator(float f5, float f6) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_DIAMETER, new float[]{f5, f6});
        ofFloat.setDuration(417);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private Animator createDotTranslationXAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_TRANSLATION_X, new float[]{(float) ((-this.mArrowGap) + this.mDotGap), 0.0f});
        ofFloat.setDuration(417);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private int getColorFromTypedArray(TypedArray typedArray, int i5, int i6) {
        return typedArray.getColor(i5, getResources().getColor(i6));
    }

    private int getDesiredHeight() {
        return getPaddingTop() + this.mArrowDiameter + getPaddingBottom() + this.mShadowRadius;
    }

    private int getDesiredWidth() {
        return getPaddingLeft() + getRequiredWidth() + getPaddingRight();
    }

    private int getDimensionFromTypedArray(TypedArray typedArray, int i5, int i6) {
        return typedArray.getDimensionPixelOffset(i5, getResources().getDimensionPixelOffset(i6));
    }

    private int getRequiredWidth() {
        return (this.mDotRadius * 2) + (this.mArrowGap * 2) + ((this.mPageCount - 3) * this.mDotGap);
    }

    private Bitmap loadArrow() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lb_ic_nav_arrow);
        if (this.mIsLtr) {
            return decodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
    }

    private void setSelectedPage(int i5) {
        if (i5 != this.mCurrentPage) {
            this.mCurrentPage = i5;
            adjustDotPosition();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int[] getDotSelectedLeftX() {
        return this.mDotSelectedPrevX;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int[] getDotSelectedRightX() {
        return this.mDotSelectedNextX;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int[] getDotSelectedX() {
        return this.mDotSelectedX;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getPageCount() {
        return this.mPageCount;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i5 = 0; i5 < this.mPageCount; i5++) {
            this.mDots[i5].draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i6);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i6));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i6);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i5));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i5);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    public void onPageSelected(int i5, boolean z4) {
        if (this.mCurrentPage != i5) {
            if (this.mAnimator.isStarted()) {
                this.mAnimator.end();
            }
            int i6 = this.mCurrentPage;
            this.mPreviousPage = i6;
            if (z4) {
                this.mHideAnimator.setTarget(this.mDots[i6]);
                this.mShowAnimator.setTarget(this.mDots[i5]);
                this.mAnimator.start();
            }
            setSelectedPage(i5);
        }
    }

    public void onRtlPropertiesChanged(int i5) {
        boolean z4;
        super.onRtlPropertiesChanged(i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.mIsLtr != z4) {
            this.mIsLtr = z4;
            this.mArrow = loadArrow();
            Dot[] dotArr = this.mDots;
            if (dotArr != null) {
                for (Dot onRtlPropertiesChanged : dotArr) {
                    onRtlPropertiesChanged.onRtlPropertiesChanged();
                }
            }
            calculateDotPositions();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        setMeasuredDimension(i5, i6);
        calculateDotPositions();
    }

    public void setArrowBackgroundColor(@ColorInt int i5) {
        this.mDotFgSelectColor = i5;
    }

    public void setArrowColor(@ColorInt int i5) {
        if (this.mArrowPaint == null) {
            this.mArrowPaint = new Paint();
        }
        this.mArrowPaint.setColorFilter(new PorterDuffColorFilter(i5, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(@ColorInt int i5) {
        this.mBgPaint.setColor(i5);
    }

    public void setPageCount(int i5) {
        if (i5 > 0) {
            this.mPageCount = i5;
            this.mDots = new Dot[i5];
            for (int i6 = 0; i6 < this.mPageCount; i6++) {
                this.mDots[i6] = new Dot();
            }
            calculateDotPositions();
            setSelectedPage(0);
            return;
        }
        throw new IllegalArgumentException("The page count should be a positive integer");
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimator = animatorSet;
        Resources resources = getResources();
        int[] iArr = R.styleable.PagingIndicator;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i5, 0);
        int dimensionFromTypedArray = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_lbDotRadius, R.dimen.lb_page_indicator_dot_radius);
        this.mDotRadius = dimensionFromTypedArray;
        this.mDotDiameter = dimensionFromTypedArray * 2;
        int dimensionFromTypedArray2 = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_arrowRadius, R.dimen.lb_page_indicator_arrow_radius);
        this.mArrowRadius = dimensionFromTypedArray2;
        int i6 = dimensionFromTypedArray2 * 2;
        this.mArrowDiameter = i6;
        this.mDotGap = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_dotToDotGap, R.dimen.lb_page_indicator_dot_gap);
        this.mArrowGap = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_dotToArrowGap, R.dimen.lb_page_indicator_arrow_gap);
        int colorFromTypedArray = getColorFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_dotBgColor, R.color.lb_page_indicator_dot);
        Paint paint = new Paint(1);
        this.mBgPaint = paint;
        paint.setColor(colorFromTypedArray);
        this.mDotFgSelectColor = getColorFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_arrowBgColor, R.color.lb_page_indicator_arrow_background);
        if (this.mArrowPaint == null) {
            int i7 = R.styleable.PagingIndicator_arrowColor;
            if (obtainStyledAttributes.hasValue(i7)) {
                setArrowColor(obtainStyledAttributes.getColor(i7, 0));
            }
        }
        obtainStyledAttributes.recycle();
        this.mIsLtr = resources.getConfiguration().getLayoutDirection() == 0;
        int color = resources.getColor(R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.mShadowRadius = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.mFgPaint = paint2;
        float dimensionPixelSize2 = (float) resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer((float) dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color);
        this.mArrow = loadArrow();
        this.mArrowRect = new Rect(0, 0, this.mArrow.getWidth(), this.mArrow.getHeight());
        this.mArrowToBgRatio = ((float) this.mArrow.getWidth()) / ((float) i6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mShowAnimator = animatorSet2;
        animatorSet2.playTogether(new Animator[]{createDotAlphaAnimator(0.0f, 1.0f), createDotDiameterAnimator((float) (dimensionFromTypedArray * 2), (float) (dimensionFromTypedArray2 * 2)), createDotTranslationXAnimator()});
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.mHideAnimator = animatorSet3;
        animatorSet3.playTogether(new Animator[]{createDotAlphaAnimator(1.0f, 0.0f), createDotDiameterAnimator((float) (dimensionFromTypedArray2 * 2), (float) (dimensionFromTypedArray * 2)), createDotTranslationXAnimator()});
        animatorSet.playTogether(new Animator[]{animatorSet2, animatorSet3});
        setLayerType(1, (Paint) null);
    }
}
