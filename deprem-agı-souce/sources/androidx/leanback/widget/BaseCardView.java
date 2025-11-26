package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.leanback.R;
import java.util.ArrayList;

public class BaseCardView extends FrameLayout {
    public static final int CARD_REGION_VISIBLE_ACTIVATED = 1;
    public static final int CARD_REGION_VISIBLE_ALWAYS = 0;
    public static final int CARD_REGION_VISIBLE_SELECTED = 2;
    public static final int CARD_TYPE_INFO_OVER = 1;
    public static final int CARD_TYPE_INFO_UNDER = 2;
    public static final int CARD_TYPE_INFO_UNDER_WITH_EXTRA = 3;
    private static final int CARD_TYPE_INVALID = 4;
    public static final int CARD_TYPE_MAIN_ONLY = 0;
    private static final boolean DEBUG = false;
    private static final int[] LB_PRESSED_STATE_SET = {16842919};
    private static final String TAG = "BaseCardView";
    private final int mActivatedAnimDuration;
    private Animation mAnim;
    private final Runnable mAnimationTrigger;
    private int mCardType;
    private boolean mDelaySelectedAnim;
    ArrayList<View> mExtraViewList;
    private int mExtraVisibility;
    float mInfoAlpha;
    float mInfoOffset;
    ArrayList<View> mInfoViewList;
    float mInfoVisFraction;
    private int mInfoVisibility;
    private ArrayList<View> mMainViewList;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private final int mSelectedAnimDuration;
    private int mSelectedAnimationDelay;

    class AnimationBase extends Animation {
        AnimationBase() {
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public final void mockEnd() {
            applyTransformation(1.0f, (Transformation) null);
            BaseCardView.this.cancelAnimations();
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public final void mockStart() {
            getTransformation(0, (Transformation) null);
        }
    }

    final class InfoAlphaAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoAlphaAnimation(float f5, float f6) {
            super();
            this.mStartValue = f5;
            this.mDelta = f6 - f5;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f5, Transformation transformation) {
            BaseCardView.this.mInfoAlpha = this.mStartValue + (f5 * this.mDelta);
            for (int i5 = 0; i5 < BaseCardView.this.mInfoViewList.size(); i5++) {
                BaseCardView.this.mInfoViewList.get(i5).setAlpha(BaseCardView.this.mInfoAlpha);
            }
        }
    }

    final class InfoHeightAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoHeightAnimation(float f5, float f6) {
            super();
            this.mStartValue = f5;
            this.mDelta = f6 - f5;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f5, Transformation transformation) {
            BaseCardView baseCardView = BaseCardView.this;
            baseCardView.mInfoVisFraction = this.mStartValue + (f5 * this.mDelta);
            baseCardView.requestLayout();
        }
    }

    final class InfoOffsetAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoOffsetAnimation(float f5, float f6) {
            super();
            this.mStartValue = f5;
            this.mDelta = f6 - f5;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f5, Transformation transformation) {
            BaseCardView baseCardView = BaseCardView.this;
            baseCardView.mInfoOffset = this.mStartValue + (f5 * this.mDelta);
            baseCardView.requestLayout();
        }
    }

    public BaseCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateInfoAlpha(boolean z4) {
        float f5;
        cancelAnimations();
        if (z4) {
            for (int i5 = 0; i5 < this.mInfoViewList.size(); i5++) {
                this.mInfoViewList.get(i5).setVisibility(0);
            }
        }
        float f6 = 0.0f;
        if (z4) {
            f5 = 1.0f;
        } else {
            f5 = 0.0f;
        }
        if (f5 != this.mInfoAlpha) {
            float f7 = this.mInfoAlpha;
            if (z4) {
                f6 = 1.0f;
            }
            InfoAlphaAnimation infoAlphaAnimation = new InfoAlphaAnimation(f7, f6);
            this.mAnim = infoAlphaAnimation;
            infoAlphaAnimation.setDuration((long) this.mActivatedAnimDuration);
            this.mAnim.setInterpolator(new DecelerateInterpolator());
            this.mAnim.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (((double) BaseCardView.this.mInfoAlpha) == 0.0d) {
                        for (int i5 = 0; i5 < BaseCardView.this.mInfoViewList.size(); i5++) {
                            BaseCardView.this.mInfoViewList.get(i5).setVisibility(8);
                        }
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            startAnimation(this.mAnim);
        }
    }

    private void animateInfoHeight(boolean z4) {
        float f5;
        cancelAnimations();
        if (z4) {
            for (int i5 = 0; i5 < this.mInfoViewList.size(); i5++) {
                this.mInfoViewList.get(i5).setVisibility(0);
            }
        }
        if (z4) {
            f5 = 1.0f;
        } else {
            f5 = 0.0f;
        }
        if (this.mInfoVisFraction != f5) {
            InfoHeightAnimation infoHeightAnimation = new InfoHeightAnimation(this.mInfoVisFraction, f5);
            this.mAnim = infoHeightAnimation;
            infoHeightAnimation.setDuration((long) this.mSelectedAnimDuration);
            this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mAnim.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (BaseCardView.this.mInfoVisFraction == 0.0f) {
                        for (int i5 = 0; i5 < BaseCardView.this.mInfoViewList.size(); i5++) {
                            BaseCardView.this.mInfoViewList.get(i5).setVisibility(8);
                        }
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            startAnimation(this.mAnim);
        }
    }

    private void applyActiveState() {
        int i5;
        if (hasInfoRegion() && (i5 = this.mInfoVisibility) == 1) {
            setInfoViewVisibility(isRegionVisible(i5));
        }
    }

    private void applySelectedState(boolean z4) {
        removeCallbacks(this.mAnimationTrigger);
        if (this.mCardType == 3) {
            if (!z4) {
                animateInfoOffset(false);
            } else if (!this.mDelaySelectedAnim) {
                post(this.mAnimationTrigger);
                this.mDelaySelectedAnim = true;
            } else {
                postDelayed(this.mAnimationTrigger, (long) this.mSelectedAnimationDelay);
            }
        } else if (this.mInfoVisibility == 2) {
            setInfoViewVisibility(z4);
        }
    }

    private void findChildrenViews() {
        boolean z4;
        boolean z5;
        this.mMainViewList.clear();
        this.mInfoViewList.clear();
        this.mExtraViewList.clear();
        int childCount = getChildCount();
        if (!hasInfoRegion() || !isCurrentRegionVisible(this.mInfoVisibility)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!hasExtraRegion() || this.mInfoOffset <= 0.0f) {
            z5 = false;
        } else {
            z5 = true;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int i6 = ((LayoutParams) childAt.getLayoutParams()).viewType;
                int i7 = 8;
                if (i6 == 1) {
                    childAt.setAlpha(this.mInfoAlpha);
                    this.mInfoViewList.add(childAt);
                    if (z4) {
                        i7 = 0;
                    }
                    childAt.setVisibility(i7);
                } else if (i6 == 2) {
                    this.mExtraViewList.add(childAt);
                    if (z5) {
                        i7 = 0;
                    }
                    childAt.setVisibility(i7);
                } else {
                    this.mMainViewList.add(childAt);
                    childAt.setVisibility(0);
                }
            }
        }
    }

    private boolean hasExtraRegion() {
        if (this.mCardType == 3) {
            return true;
        }
        return false;
    }

    private boolean hasInfoRegion() {
        if (this.mCardType != 0) {
            return true;
        }
        return false;
    }

    private boolean isCurrentRegionVisible(int i5) {
        if (i5 == 0) {
            return true;
        }
        if (i5 == 1) {
            return isActivated();
        }
        if (i5 != 2) {
            return false;
        }
        if (this.mCardType != 2) {
            return isSelected();
        }
        if (this.mInfoVisFraction > 0.0f) {
            return true;
        }
        return false;
    }

    private boolean isRegionVisible(int i5) {
        if (i5 == 0) {
            return true;
        }
        if (i5 == 1) {
            return isActivated();
        }
        if (i5 != 2) {
            return false;
        }
        return isSelected();
    }

    private void setInfoViewVisibility(boolean z4) {
        int i5;
        int i6 = this.mCardType;
        if (i6 == 3) {
            if (z4) {
                for (int i7 = 0; i7 < this.mInfoViewList.size(); i7++) {
                    this.mInfoViewList.get(i7).setVisibility(0);
                }
                return;
            }
            for (int i8 = 0; i8 < this.mInfoViewList.size(); i8++) {
                this.mInfoViewList.get(i8).setVisibility(8);
            }
            for (int i9 = 0; i9 < this.mExtraViewList.size(); i9++) {
                this.mExtraViewList.get(i9).setVisibility(8);
            }
            this.mInfoOffset = 0.0f;
        } else if (i6 == 2) {
            if (this.mInfoVisibility == 2) {
                animateInfoHeight(z4);
                return;
            }
            for (int i10 = 0; i10 < this.mInfoViewList.size(); i10++) {
                View view = this.mInfoViewList.get(i10);
                if (z4) {
                    i5 = 0;
                } else {
                    i5 = 8;
                }
                view.setVisibility(i5);
            }
        } else if (i6 == 1) {
            animateInfoAlpha(z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void animateInfoOffset(boolean z4) {
        float f5;
        cancelAnimations();
        int i5 = 0;
        if (z4) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mMeasuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int i6 = 0;
            for (int i7 = 0; i7 < this.mExtraViewList.size(); i7++) {
                View view = this.mExtraViewList.get(i7);
                view.setVisibility(0);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i6 = Math.max(i6, view.getMeasuredHeight());
            }
            i5 = i6;
        }
        float f6 = this.mInfoOffset;
        if (z4) {
            f5 = (float) i5;
        } else {
            f5 = 0.0f;
        }
        InfoOffsetAnimation infoOffsetAnimation = new InfoOffsetAnimation(f6, f5);
        this.mAnim = infoOffsetAnimation;
        infoOffsetAnimation.setDuration((long) this.mSelectedAnimDuration);
        this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnim.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (BaseCardView.this.mInfoOffset == 0.0f) {
                    for (int i5 = 0; i5 < BaseCardView.this.mExtraViewList.size(); i5++) {
                        BaseCardView.this.mExtraViewList.get(i5).setVisibility(8);
                    }
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(this.mAnim);
    }

    /* access modifiers changed from: package-private */
    public void cancelAnimations() {
        Animation animation = this.mAnim;
        if (animation != null) {
            animation.cancel();
            this.mAnim = null;
            clearAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getCardType() {
        return this.mCardType;
    }

    @Deprecated
    public int getExtraVisibility() {
        return this.mExtraVisibility;
    }

    /* access modifiers changed from: package-private */
    public final float getFinalInfoAlpha() {
        if (this.mCardType == 1 && this.mInfoVisibility == 2 && !isSelected()) {
            return 0.0f;
        }
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    public final float getFinalInfoVisFraction() {
        if (this.mCardType == 2 && this.mInfoVisibility == 2 && !isSelected()) {
            return 0.0f;
        }
        return 1.0f;
    }

    public int getInfoVisibility() {
        return this.mInfoVisibility;
    }

    public boolean isSelectedAnimationDelayed() {
        return this.mDelaySelectedAnim;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i5) {
        boolean z4 = false;
        boolean z5 = false;
        for (int i6 : super.onCreateDrawableState(i5)) {
            if (i6 == 16842919) {
                z4 = true;
            }
            if (i6 == 16842910) {
                z5 = true;
            }
        }
        if (z4 && z5) {
            return View.PRESSED_ENABLED_STATE_SET;
        }
        if (z4) {
            return LB_PRESSED_STATE_SET;
        }
        if (z5) {
            return View.ENABLED_STATE_SET;
        }
        return View.EMPTY_STATE_SET;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mAnimationTrigger);
        cancelAnimations();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        float paddingTop = (float) getPaddingTop();
        for (int i9 = 0; i9 < this.mMainViewList.size(); i9++) {
            View view = this.mMainViewList.get(i9);
            if (view.getVisibility() != 8) {
                view.layout(getPaddingLeft(), (int) paddingTop, this.mMeasuredWidth + getPaddingLeft(), (int) (((float) view.getMeasuredHeight()) + paddingTop));
                paddingTop += (float) view.getMeasuredHeight();
            }
        }
        if (hasInfoRegion()) {
            float f5 = 0.0f;
            for (int i10 = 0; i10 < this.mInfoViewList.size(); i10++) {
                f5 += (float) this.mInfoViewList.get(i10).getMeasuredHeight();
            }
            int i11 = this.mCardType;
            if (i11 == 1) {
                paddingTop -= f5;
                if (paddingTop < 0.0f) {
                    paddingTop = 0.0f;
                }
            } else if (i11 != 2) {
                paddingTop -= this.mInfoOffset;
            } else if (this.mInfoVisibility == 2) {
                f5 *= this.mInfoVisFraction;
            }
            for (int i12 = 0; i12 < this.mInfoViewList.size(); i12++) {
                View view2 = this.mInfoViewList.get(i12);
                if (view2.getVisibility() != 8) {
                    int measuredHeight = view2.getMeasuredHeight();
                    if (((float) measuredHeight) > f5) {
                        measuredHeight = (int) f5;
                    }
                    float f6 = (float) measuredHeight;
                    paddingTop += f6;
                    view2.layout(getPaddingLeft(), (int) paddingTop, this.mMeasuredWidth + getPaddingLeft(), (int) paddingTop);
                    f5 -= f6;
                    if (f5 <= 0.0f) {
                        break;
                    }
                }
            }
            if (hasExtraRegion()) {
                for (int i13 = 0; i13 < this.mExtraViewList.size(); i13++) {
                    View view3 = this.mExtraViewList.get(i13);
                    if (view3.getVisibility() != 8) {
                        view3.layout(getPaddingLeft(), (int) paddingTop, this.mMeasuredWidth + getPaddingLeft(), (int) (((float) view3.getMeasuredHeight()) + paddingTop));
                        paddingTop += (float) view3.getMeasuredHeight();
                    }
                }
            }
        }
        onSizeChanged(0, 0, i7 - i5, i8 - i6);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        float f5;
        boolean z4 = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        findChildrenViews();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < this.mMainViewList.size(); i11++) {
            View view = this.mMainViewList.get(i11);
            if (view.getVisibility() != 8) {
                measureChild(view, makeMeasureSpec, makeMeasureSpec);
                this.mMeasuredWidth = Math.max(this.mMeasuredWidth, view.getMeasuredWidth());
                i9 += view.getMeasuredHeight();
                i10 = View.combineMeasuredStates(i10, view.getMeasuredState());
            }
        }
        setPivotX((float) (this.mMeasuredWidth / 2));
        setPivotY((float) (i9 / 2));
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mMeasuredWidth, 1073741824);
        if (hasInfoRegion()) {
            i8 = 0;
            for (int i12 = 0; i12 < this.mInfoViewList.size(); i12++) {
                View view2 = this.mInfoViewList.get(i12);
                if (view2.getVisibility() != 8) {
                    measureChild(view2, makeMeasureSpec2, makeMeasureSpec);
                    if (this.mCardType != 1) {
                        i8 += view2.getMeasuredHeight();
                    }
                    i10 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                }
            }
            if (hasExtraRegion()) {
                i7 = 0;
                for (int i13 = 0; i13 < this.mExtraViewList.size(); i13++) {
                    View view3 = this.mExtraViewList.get(i13);
                    if (view3.getVisibility() != 8) {
                        measureChild(view3, makeMeasureSpec2, makeMeasureSpec);
                        i7 += view3.getMeasuredHeight();
                        i10 = View.combineMeasuredStates(i10, view3.getMeasuredState());
                    }
                }
            } else {
                i7 = 0;
            }
        } else {
            i8 = 0;
            i7 = 0;
        }
        if (hasInfoRegion() && this.mInfoVisibility == 2) {
            z4 = true;
        }
        float f6 = (float) i9;
        float f7 = (float) i8;
        if (z4) {
            f7 *= this.mInfoVisFraction;
        }
        float f8 = f6 + f7 + ((float) i7);
        if (z4) {
            f5 = 0.0f;
        } else {
            f5 = this.mInfoOffset;
        }
        this.mMeasuredHeight = (int) (f8 - f5);
        setMeasuredDimension(View.resolveSizeAndState(this.mMeasuredWidth + getPaddingLeft() + getPaddingRight(), i5, i10), View.resolveSizeAndState(this.mMeasuredHeight + getPaddingTop() + getPaddingBottom(), i6, i10 << 16));
    }

    public void setActivated(boolean z4) {
        if (z4 != isActivated()) {
            super.setActivated(z4);
            applyActiveState();
        }
    }

    public void setCardType(int i5) {
        if (this.mCardType != i5) {
            if (i5 < 0 || i5 >= 4) {
                Log.e(TAG, "Invalid card type specified: " + i5 + ". Defaulting to type CARD_TYPE_MAIN_ONLY.");
                this.mCardType = 0;
            } else {
                this.mCardType = i5;
            }
            requestLayout();
        }
    }

    @Deprecated
    public void setExtraVisibility(int i5) {
        if (this.mExtraVisibility != i5) {
            this.mExtraVisibility = i5;
        }
    }

    public void setInfoVisibility(int i5) {
        if (this.mInfoVisibility != i5) {
            cancelAnimations();
            this.mInfoVisibility = i5;
            this.mInfoVisFraction = getFinalInfoVisFraction();
            requestLayout();
            float finalInfoAlpha = getFinalInfoAlpha();
            if (finalInfoAlpha != this.mInfoAlpha) {
                this.mInfoAlpha = finalInfoAlpha;
                for (int i6 = 0; i6 < this.mInfoViewList.size(); i6++) {
                    this.mInfoViewList.get(i6).setAlpha(this.mInfoAlpha);
                }
            }
        }
    }

    public void setSelected(boolean z4) {
        if (z4 != isSelected()) {
            super.setSelected(z4);
            applySelectedState(isSelected());
        }
    }

    public void setSelectedAnimationDelayed(boolean z4) {
        this.mDelaySelectedAnim = z4;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public String toString() {
        return super.toString();
    }

    public BaseCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.baseCardViewStyle);
    }

    @SuppressLint({"CustomViewStyleable"})
    public BaseCardView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mAnimationTrigger = new Runnable() {
            public void run() {
                BaseCardView.this.animateInfoOffset(true);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseCardView, i5, 0);
        try {
            this.mCardType = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_cardType, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.lbBaseCardView_cardForeground);
            if (drawable != null) {
                setForeground(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.lbBaseCardView_cardBackground);
            if (drawable2 != null) {
                setBackground(drawable2);
            }
            this.mInfoVisibility = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_infoVisibility, 1);
            int integer = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_extraVisibility, 2);
            this.mExtraVisibility = integer;
            int i6 = this.mInfoVisibility;
            if (integer < i6) {
                this.mExtraVisibility = i6;
            }
            this.mSelectedAnimationDelay = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_selectedAnimationDelay, getResources().getInteger(R.integer.lb_card_selected_animation_delay));
            this.mSelectedAnimDuration = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_selectedAnimationDuration, getResources().getInteger(R.integer.lb_card_selected_animation_duration));
            this.mActivatedAnimDuration = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_activatedAnimationDuration, getResources().getInteger(R.integer.lb_card_activated_animation_duration));
            obtainStyledAttributes.recycle();
            this.mDelaySelectedAnim = true;
            this.mMainViewList = new ArrayList<>();
            this.mInfoViewList = new ArrayList<>();
            this.mExtraViewList = new ArrayList<>();
            this.mInfoOffset = 0.0f;
            this.mInfoVisFraction = getFinalInfoVisFraction();
            this.mInfoAlpha = getFinalInfoAlpha();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int VIEW_TYPE_EXTRA = 2;
        public static final int VIEW_TYPE_INFO = 1;
        public static final int VIEW_TYPE_MAIN = 0;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = 0, to = "MAIN"), @ViewDebug.IntToString(from = 1, to = "INFO"), @ViewDebug.IntToString(from = 2, to = "EXTRA")})
        public int viewType = 0;

        @SuppressLint({"CustomViewStyleable"})
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseCardView_Layout);
            this.viewType = obtainStyledAttributes.getInt(R.styleable.lbBaseCardView_Layout_layout_viewType, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.viewType = layoutParams.viewType;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
