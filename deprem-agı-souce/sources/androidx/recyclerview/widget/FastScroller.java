package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;

class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    int mAnimationState;
    private int mDragState = 0;
    private final Runnable mHideRunnable;
    @VisibleForTesting
    float mHorizontalDragX;
    private final int[] mHorizontalRange = new int[2];
    @VisibleForTesting
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    @VisibleForTesting
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar = false;
    private boolean mNeedVerticalScrollbar = false;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight = 0;
    private int mRecyclerViewWidth = 0;
    private final int mScrollbarMinimumRange;
    final ValueAnimator mShowHideAnimator;
    private int mState = 0;
    @VisibleForTesting
    float mVerticalDragY;
    private final int[] mVerticalRange = new int[2];
    @VisibleForTesting
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;
    @VisibleForTesting
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    private class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;

        AnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
            } else if (((Float) FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.mAnimationState = 2;
                fastScroller2.requestRedraw();
            }
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.mVerticalThumbDrawable.setAlpha(floatValue);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(floatValue);
            FastScroller.this.requestRedraw();
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i5, int i6, int i7) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mShowHideAnimator = ofFloat;
        this.mAnimationState = 0;
        this.mHideRunnable = new Runnable() {
            public void run() {
                FastScroller.this.hide(500);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
                FastScroller.this.updateScrollPosition(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i5, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i5, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i5, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i5, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i6;
        this.mMargin = i7;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas canvas) {
        int i5 = this.mRecyclerViewHeight;
        int i6 = this.mHorizontalThumbHeight;
        int i7 = i5 - i6;
        int i8 = this.mHorizontalThumbCenterX;
        int i9 = this.mHorizontalThumbWidth;
        int i10 = i8 - (i9 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, i9, i6);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        canvas.translate(0.0f, (float) i7);
        this.mHorizontalTrackDrawable.draw(canvas);
        canvas.translate((float) i10, 0.0f);
        this.mHorizontalThumbDrawable.draw(canvas);
        canvas.translate((float) (-i10), (float) (-i7));
    }

    private void drawVerticalScrollbar(Canvas canvas) {
        int i5 = this.mRecyclerViewWidth;
        int i6 = this.mVerticalThumbWidth;
        int i7 = i5 - i6;
        int i8 = this.mVerticalThumbCenterY;
        int i9 = this.mVerticalThumbHeight;
        int i10 = i8 - (i9 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, i6, i9);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL()) {
            this.mVerticalTrackDrawable.draw(canvas);
            canvas.translate((float) this.mVerticalThumbWidth, (float) i10);
            canvas.scale(-1.0f, 1.0f);
            this.mVerticalThumbDrawable.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float) (-this.mVerticalThumbWidth), (float) (-i10));
            return;
        }
        canvas.translate((float) i7, 0.0f);
        this.mVerticalTrackDrawable.draw(canvas);
        canvas.translate(0.0f, (float) i10);
        this.mVerticalThumbDrawable.draw(canvas);
        canvas.translate((float) (-i7), (float) (-i10));
    }

    private int[] getHorizontalRange() {
        int[] iArr = this.mHorizontalRange;
        int i5 = this.mMargin;
        iArr[0] = i5;
        iArr[1] = this.mRecyclerViewWidth - i5;
        return iArr;
    }

    private int[] getVerticalRange() {
        int[] iArr = this.mVerticalRange;
        int i5 = this.mMargin;
        iArr[0] = i5;
        iArr[1] = this.mRecyclerViewHeight - i5;
        return iArr;
    }

    private void horizontalScrollTo(float f5) {
        int[] horizontalRange = getHorizontalRange();
        float max = Math.max((float) horizontalRange[0], Math.min((float) horizontalRange[1], f5));
        if (Math.abs(((float) this.mHorizontalThumbCenterX) - max) >= 2.0f) {
            int scrollTo = scrollTo(this.mHorizontalDragX, max, horizontalRange, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
            if (scrollTo != 0) {
                this.mRecyclerView.scrollBy(scrollTo, 0);
            }
            this.mHorizontalDragX = max;
        }
    }

    private boolean isLayoutRTL() {
        if (this.mRecyclerView.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void resetHideDelay(int i5) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, (long) i5);
    }

    private int scrollTo(float f5, float f6, int[] iArr, int i5, int i6, int i7) {
        int i8 = iArr[1] - iArr[0];
        if (i8 == 0) {
            return 0;
        }
        int i9 = i5 - i7;
        int i10 = (int) (((f6 - f5) / ((float) i8)) * ((float) i9));
        int i11 = i6 + i10;
        if (i11 >= i9 || i11 < 0) {
            return 0;
        }
        return i10;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void verticalScrollTo(float f5) {
        int[] verticalRange = getVerticalRange();
        float max = Math.max((float) verticalRange[0], Math.min((float) verticalRange[1], f5));
        if (Math.abs(((float) this.mVerticalThumbCenterY) - max) >= 2.0f) {
            int scrollTo = scrollTo(this.mVerticalDragY, max, verticalRange, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
            if (scrollTo != 0) {
                this.mRecyclerView.scrollBy(0, scrollTo);
            }
            this.mVerticalDragY = max;
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void hide(int i5) {
        int i6 = this.mAnimationState;
        if (i6 == 1) {
            this.mShowHideAnimator.cancel();
        } else if (i6 != 2) {
            return;
        }
        this.mAnimationState = 3;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.mShowHideAnimator.setDuration((long) i5);
        this.mShowHideAnimator.start();
    }

    public boolean isDragging() {
        if (this.mState == 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isPointInsideHorizontalThumb(float f5, float f6) {
        if (f6 < ((float) (this.mRecyclerViewHeight - this.mHorizontalThumbHeight))) {
            return false;
        }
        int i5 = this.mHorizontalThumbCenterX;
        int i6 = this.mHorizontalThumbWidth;
        if (f5 < ((float) (i5 - (i6 / 2))) || f5 > ((float) (i5 + (i6 / 2)))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isPointInsideVerticalThumb(float f5, float f6) {
        if (isLayoutRTL()) {
            if (f5 > ((float) this.mVerticalThumbWidth)) {
                return false;
            }
        } else if (f5 < ((float) (this.mRecyclerViewWidth - this.mVerticalThumbWidth))) {
            return false;
        }
        int i5 = this.mVerticalThumbCenterY;
        int i6 = this.mVerticalThumbHeight;
        if (f6 < ((float) (i5 - (i6 / 2))) || f6 > ((float) (i5 + (i6 / 2)))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isVisible() {
        if (this.mState == 1) {
            return true;
        }
        return false;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mRecyclerViewWidth != this.mRecyclerView.getWidth() || this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) {
            this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
            this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.mAnimationState != 0) {
            if (this.mNeedVerticalScrollbar) {
                drawVerticalScrollbar(canvas);
            }
            if (this.mNeedHorizontalScrollbar) {
                drawHorizontalScrollbar(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i5 = this.mState;
        if (i5 == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0 || (!isPointInsideVerticalThumb && !isPointInsideHorizontalThumb)) {
                return false;
            }
            if (isPointInsideHorizontalThumb) {
                this.mDragState = 1;
                this.mHorizontalDragX = (float) ((int) motionEvent.getX());
            } else if (isPointInsideVerticalThumb) {
                this.mDragState = 2;
                this.mVerticalDragY = (float) ((int) motionEvent.getY());
            }
            setState(2);
            return true;
        } else if (i5 == 2) {
            return true;
        } else {
            return false;
        }
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z4) {
    }

    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                    if (isPointInsideHorizontalThumb) {
                        this.mDragState = 1;
                        this.mHorizontalDragX = (float) ((int) motionEvent.getX());
                    } else if (isPointInsideVerticalThumb) {
                        this.mDragState = 2;
                        this.mVerticalDragY = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.mVerticalDragY = 0.0f;
                this.mHorizontalDragX = 0.0f;
                setState(1);
                this.mDragState = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                show();
                if (this.mDragState == 1) {
                    horizontalScrollTo(motionEvent.getX());
                }
                if (this.mDragState == 2) {
                    verticalScrollTo(motionEvent.getY());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setState(int i5) {
        if (i5 == 2 && this.mState != 2) {
            this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
            cancelHide();
        }
        if (i5 == 0) {
            requestRedraw();
        } else {
            show();
        }
        if (this.mState == 2 && i5 != 2) {
            this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
            resetHideDelay(HIDE_DELAY_AFTER_DRAGGING_MS);
        } else if (i5 == 1) {
            resetHideDelay(HIDE_DELAY_AFTER_VISIBLE_MS);
        }
        this.mState = i5;
    }

    public void show() {
        int i5 = this.mAnimationState;
        if (i5 != 0) {
            if (i5 == 3) {
                this.mShowHideAnimator.cancel();
            } else {
                return;
            }
        }
        this.mAnimationState = 1;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
    }

    /* access modifiers changed from: package-private */
    public void updateScrollPosition(int i5, int i6) {
        boolean z4;
        boolean z5;
        int computeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange();
        int i7 = this.mRecyclerViewHeight;
        if (computeVerticalScrollRange - i7 <= 0 || i7 < this.mScrollbarMinimumRange) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.mNeedVerticalScrollbar = z4;
        int computeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange();
        int i8 = this.mRecyclerViewWidth;
        if (computeHorizontalScrollRange - i8 <= 0 || i8 < this.mScrollbarMinimumRange) {
            z5 = false;
        } else {
            z5 = true;
        }
        this.mNeedHorizontalScrollbar = z5;
        boolean z6 = this.mNeedVerticalScrollbar;
        if (z6 || z5) {
            if (z6) {
                float f5 = (float) i7;
                this.mVerticalThumbCenterY = (int) ((f5 * (((float) i6) + (f5 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.mVerticalThumbHeight = Math.min(i7, (i7 * i7) / computeVerticalScrollRange);
            }
            if (this.mNeedHorizontalScrollbar) {
                float f6 = (float) i8;
                this.mHorizontalThumbCenterX = (int) ((f6 * (((float) i5) + (f6 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.mHorizontalThumbWidth = Math.min(i8, (i8 * i8) / computeHorizontalScrollRange);
            }
            int i9 = this.mState;
            if (i9 == 0 || i9 == 1) {
                setState(1);
            }
        } else if (this.mState != 0) {
            setState(0);
        }
    }
}
