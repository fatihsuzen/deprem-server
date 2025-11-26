package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    private int mActionState = 0;
    int mActivePointerId = -1;
    @NonNull
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetector mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() {
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation findAnimation;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.mSelected == null && (findAnimation = itemTouchHelper.findAnimation(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.mInitialTouchX -= findAnimation.mX;
                    itemTouchHelper2.mInitialTouchY -= findAnimation.mY;
                    itemTouchHelper2.endRecoverAnimation(findAnimation.mViewHolder, true);
                    if (ItemTouchHelper.this.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.mCallback.clearView(itemTouchHelper3.mRecyclerView, findAnimation.mViewHolder);
                    }
                    ItemTouchHelper.this.select(findAnimation.mViewHolder, findAnimation.mActionState);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.updateDxDy(motionEvent, itemTouchHelper4.mSelectedFlags, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.mActivePointerId = -1;
                itemTouchHelper5.select((RecyclerView.ViewHolder) null, 0);
            } else {
                int i5 = ItemTouchHelper.this.mActivePointerId;
                if (i5 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i5)) >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mSelected != null) {
                return true;
            }
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z4) {
            if (z4) {
                ItemTouchHelper.this.select((RecyclerView.ViewHolder) null, 0);
            }
        }

        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper.mSelected;
                if (viewHolder != null) {
                    int i5 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                                if (pointerId == itemTouchHelper2.mActivePointerId) {
                                    if (actionIndex == 0) {
                                        i5 = 1;
                                    }
                                    itemTouchHelper2.mActivePointerId = motionEvent.getPointerId(i5);
                                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                    itemTouchHelper3.updateDxDy(motionEvent, itemTouchHelper3.mSelectedFlags, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.mSelectedFlags, findPointerIndex);
                            ItemTouchHelper.this.moveIfNecessary(viewHolder);
                            ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                            itemTouchHelper4.mRecyclerView.removeCallbacks(itemTouchHelper4.mScrollRunnable);
                            ItemTouchHelper.this.mScrollRunnable.run();
                            ItemTouchHelper.this.mRecyclerView.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    ItemTouchHelper.this.select((RecyclerView.ViewHolder) null, 0);
                    ItemTouchHelper.this.mActivePointerId = -1;
                }
            }
        }
    };
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    final List<View> mPendingCleanup = new ArrayList();
    @VisibleForTesting
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable = new Runnable() {
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.mSelected != null && itemTouchHelper.scrollIfNecessary()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.mSelected;
                if (viewHolder != null) {
                    itemTouchHelper2.moveIfNecessary(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
            }
        }
    };
    RecyclerView.ViewHolder mSelected = null;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private final float[] mTmpPosition = new float[2];
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() {
            public float getInterpolation(float f5) {
                return f5 * f5 * f5 * f5 * f5;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() {
            public float getInterpolation(float f5) {
                float f6 = f5 - 1.0f;
                return (f6 * f6 * f6 * f6 * f6) + 1.0f;
            }
        };
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i5, int i6) {
            int i7;
            int i8 = i5 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i8 == 0) {
                return i5;
            }
            int i9 = i5 & (~i8);
            if (i6 == 0) {
                i7 = i8 << 2;
            } else {
                int i10 = i8 << 1;
                i9 |= -789517 & i10;
                i7 = (i10 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i9 | i7;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i5, int i6) {
            return i6 << (i5 * 8);
        }

        public static int makeMovementFlags(int i5, int i6) {
            int makeFlag = makeFlag(0, i6 | i5);
            return makeFlag(2, i5) | makeFlag(1, i6) | makeFlag;
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i5, int i6) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = viewHolder.itemView.getWidth() + i5;
            int height = i6 + viewHolder.itemView.getHeight();
            int left2 = i5 - viewHolder.itemView.getLeft();
            int top2 = i6 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i7 = -1;
            for (int i8 = 0; i8 < size; i8++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i8);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i7) {
                    viewHolder2 = viewHolder3;
                    i7 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i5) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i7) {
                    viewHolder2 = viewHolder3;
                    i7 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i6) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i7) {
                    viewHolder2 = viewHolder3;
                    i7 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i7) {
                    viewHolder2 = viewHolder3;
                    i7 = abs;
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i5, int i6) {
            int i7;
            int i8 = i5 & RELATIVE_DIR_FLAGS;
            if (i8 == 0) {
                return i5;
            }
            int i9 = i5 & (~i8);
            if (i6 == 0) {
                i7 = i8 >> 2;
            } else {
                int i10 = i8 >> 1;
                i9 |= -3158065 & i10;
                i7 = (i10 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i9 | i7;
        }

        /* access modifiers changed from: package-private */
        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), recyclerView.getLayoutDirection());
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i5, float f5, float f6) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (i5 == 8) {
                    return 200;
                }
                return 250;
            } else if (i5 == 8) {
                return itemAnimator.getMoveDuration();
            } else {
                return itemAnimator.getRemoveDuration();
            }
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f5) {
            return f5;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f5) {
            return f5;
        }

        /* access modifiers changed from: package-private */
        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0) {
                return true;
            }
            return false;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i5, int i6, int i7, long j5) {
            float f5 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i6)) * getMaxDragScroll(recyclerView))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i6)) * 1.0f) / ((float) i5))));
            if (j5 <= 2000) {
                f5 = ((float) j5) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * sDragScrollInterpolator.getInterpolation(f5));
            if (interpolation != 0) {
                return interpolation;
            }
            if (i6 > 0) {
                return 1;
            }
            return -1;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f5, float f6, int i5, boolean z4) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(canvas, recyclerView, viewHolder.itemView, f5, f6, i5, z4);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @SuppressLint({"UnknownNullness"}) RecyclerView.ViewHolder viewHolder, float f5, float f6, int i5, boolean z4) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(canvas, recyclerView, viewHolder.itemView, f5, f6, i5, z4);
        }

        /* access modifiers changed from: package-private */
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i5, float f5, float f6) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                RecoverAnimation recoverAnimation = list.get(i6);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f5, f6, i5, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i5, float f5, float f6) {
            List<RecoverAnimation> list2 = list;
            int size = list2.size();
            boolean z4 = false;
            for (int i6 = 0; i6 < size; i6++) {
                RecoverAnimation recoverAnimation = list2.get(i6);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f5, f6, i5, true);
                canvas.restoreToCount(save2);
            }
            for (int i7 = size - 1; i7 >= 0; i7--) {
                RecoverAnimation recoverAnimation2 = list2.get(i7);
                boolean z5 = recoverAnimation2.mEnded;
                if (z5 && !recoverAnimation2.mIsPendingCleanup) {
                    list2.remove(i7);
                } else if (!z5) {
                    z4 = true;
                }
            }
            if (z4) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i5, @NonNull RecyclerView.ViewHolder viewHolder2, int i6, int i7, int i8) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i7, i8);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i6);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i6);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i6);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i6);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i5) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.INSTANCE.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i5);
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress = true;

        ItemTouchHelperGestureListener() {
        }

        /* access modifiers changed from: package-private */
        public void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View findChildView;
            RecyclerView.ViewHolder childViewHolder;
            int i5;
            if (this.mShouldReactToLongPress && (findChildView = ItemTouchHelper.this.findChildView(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder) && motionEvent.getPointerId(0) == (i5 = ItemTouchHelper.this.mActivePointerId)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i5);
                    float x4 = motionEvent.getX(findPointerIndex);
                    float y4 = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.mInitialTouchX = x4;
                    itemTouchHelper2.mInitialTouchY = y4;
                    itemTouchHelper2.mDy = 0.0f;
                    itemTouchHelper2.mDx = 0.0f;
                    if (itemTouchHelper2.mCallback.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    static class RecoverAnimation implements Animator.AnimatorListener {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded = false;
        private float mFraction;
        boolean mIsPendingCleanup;
        boolean mOverridden = false;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        @VisibleForTesting
        final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i5, int i6, float f5, float f6, float f7, float f8) {
            this.mActionState = i6;
            this.mAnimationType = i5;
            this.mViewHolder = viewHolder;
            this.mStartDx = f5;
            this.mStartDy = f6;
            this.mTargetX = f7;
            this.mTargetY = f8;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mValueAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void setDuration(long j5) {
            this.mValueAnimator.setDuration(j5);
        }

        public void setFraction(float f5) {
            this.mFraction = f5;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float f5 = this.mStartDx;
            float f6 = this.mTargetX;
            if (f5 == f6) {
                this.mX = this.mViewHolder.itemView.getTranslationX();
            } else {
                this.mX = f5 + (this.mFraction * (f6 - f5));
            }
            float f7 = this.mStartDy;
            float f8 = this.mTargetY;
            if (f7 == f8) {
                this.mY = this.mViewHolder.itemView.getTranslationY();
            } else {
                this.mY = f7 + (this.mFraction * (f8 - f7));
            }
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i5, int i6) {
            this.mDefaultSwipeDirs = i6;
            this.mDefaultDragDirs = i5;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i5) {
            this.mDefaultDragDirs = i5;
        }

        public void setDefaultSwipeDirs(int i5) {
            this.mDefaultSwipeDirs = i5;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i5, int i6);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.mCallback = callback;
    }

    private void addChildDrawingOrderCallback() {
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i5) {
        int i6;
        if ((i5 & 12) == 0) {
            return 0;
        }
        int i7 = 4;
        if (this.mDx > 0.0f) {
            i6 = 8;
        } else {
            i6 = 4;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            if (xVelocity > 0.0f) {
                i7 = 8;
            }
            float abs = Math.abs(xVelocity);
            if ((i7 & i5) != 0 && i6 == i7 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                return i7;
            }
        }
        float width = ((float) this.mRecyclerView.getWidth()) * this.mCallback.getSwipeThreshold(viewHolder);
        if ((i5 & i6) == 0 || Math.abs(this.mDx) <= width) {
            return 0;
        }
        return i6;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i5) {
        int i6;
        if ((i5 & 3) == 0) {
            return 0;
        }
        int i7 = 1;
        if (this.mDy > 0.0f) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            if (yVelocity > 0.0f) {
                i7 = 2;
            }
            float abs = Math.abs(yVelocity);
            if ((i7 & i5) != 0 && i7 == i6 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                return i7;
            }
        }
        float height = ((float) this.mRecyclerView.getHeight()) * this.mCallback.getSwipeThreshold(viewHolder);
        if ((i5 & i6) == 0 || Math.abs(this.mDy) <= height) {
            return 0;
        }
        return i6;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(0);
            recoverAnimation.cancel();
            this.mCallback.clearView(this.mRecyclerView, recoverAnimation.mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.mSwapTargets;
        if (list == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            list.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int i5 = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i5;
        int height = viewHolder2.itemView.getHeight() + round2 + i5;
        int i6 = (round + width) / 2;
        int i7 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = layoutManager.getChildAt(i8);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(i6 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i7 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i9 = (abs * abs) + (abs2 * abs2);
                    int size = this.mSwapTargets.size();
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < size && i9 > this.mDistances.get(i10).intValue()) {
                        i11++;
                        i10++;
                        RecyclerView.ViewHolder viewHolder3 = viewHolder;
                    }
                    this.mSwapTargets.add(i11, childViewHolder);
                    this.mDistances.add(i11, Integer.valueOf(i9));
                }
            }
            i8++;
            viewHolder2 = viewHolder;
        }
        return this.mSwapTargets;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i5 = this.mActivePointerId;
        if (i5 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i5);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.mInitialTouchX);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialTouchY);
        int i6 = this.mSlop;
        if (abs < ((float) i6) && abs2 < ((float) i6)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (findChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(findChildView);
        }
        return null;
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - ((float) this.mSelected.itemView.getLeft());
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - ((float) this.mSelected.itemView.getTop());
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f5, float f6, float f7, float f8) {
        if (f5 < f7 || f5 > f7 + ((float) view.getWidth()) || f6 < f8 || f6 > f8 + ((float) view.getHeight())) {
            return false;
        }
        return true;
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
        this.mGestureDetector = new GestureDetector(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = null;
        }
        if (this.mGestureDetector != null) {
            this.mGestureDetector = null;
        }
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, this.mRecyclerView.getLayoutDirection()) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i5 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe <= 0) {
                int checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
                if (checkVerticalSwipe > 0) {
                    return checkVerticalSwipe;
                }
            } else if ((i5 & checkHorizontalSwipe) == 0) {
                return Callback.convertToRelativeDirection(checkHorizontalSwipe, this.mRecyclerView.getLayoutDirection());
            } else {
                return checkHorizontalSwipe;
            }
        } else {
            int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe2 > 0) {
                return checkVerticalSwipe2;
            }
            int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe2 > 0) {
                if ((i5 & checkHorizontalSwipe2) == 0) {
                    return Callback.convertToRelativeDirection(checkHorizontalSwipe2, this.mRecyclerView.getLayoutDirection());
                }
                return checkHorizontalSwipe2;
            }
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.mMaxSwipeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                setupCallbacks();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSelectForSwipe(int i5, MotionEvent motionEvent, int i6) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected == null && i5 == 2 && this.mActionState != 2 && this.mCallback.isItemViewSwipeEnabled() && this.mRecyclerView.getScrollState() != 1 && (findSwipedView = findSwipedView(motionEvent)) != null && (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) != 0) {
            float x4 = motionEvent.getX(i6);
            float y4 = motionEvent.getY(i6);
            float f5 = x4 - this.mInitialTouchX;
            float f6 = y4 - this.mInitialTouchY;
            float abs = Math.abs(f5);
            float abs2 = Math.abs(f6);
            int i7 = this.mSlop;
            if (abs >= ((float) i7) || abs2 >= ((float) i7)) {
                if (abs > abs2) {
                    if (f5 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                        return;
                    }
                    if (f5 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                        return;
                    }
                } else if (f6 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                } else {
                    if (f6 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                        return;
                    }
                }
                this.mDy = 0.0f;
                this.mDx = 0.0f;
                this.mActivePointerId = motionEvent.getPointerId(0);
                select(findSwipedView, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z4) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z4;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == findChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View findChildView(MotionEvent motionEvent) {
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x4, y4, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x4, y4, recoverAnimation.mX, recoverAnimation.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x4, y4);
    }

    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!this.mRecoverAnimations.get(i5).mEnded) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i5 = (int) (this.mSelectedStartX + this.mDx);
            int i6 = (int) (this.mSelectedStartY + this.mDy);
            if (((float) Math.abs(i6 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i5 - viewHolder.itemView.getLeft())) >= ((float) viewHolder.itemView.getWidth()) * moveThreshold) {
                List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
                if (findSwapTargets.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i5, i6);
                    if (chooseDropTarget == null) {
                        this.mSwapTargets.clear();
                        this.mDistances.clear();
                        return;
                    }
                    int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
                    int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
                    if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
                        this.mCallback.onMoved(this.mRecyclerView, viewHolder, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i5, i6);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    public void onChildViewAttachedToWindow(@NonNull View view) {
    }

    public void onChildViewDetachedFromWindow(@NonNull View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.ViewHolder viewHolder = this.mSelected;
            if (viewHolder == null || childViewHolder != viewHolder) {
                endRecoverAnimation(childViewHolder, false);
                if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
                    this.mCallback.clearView(this.mRecyclerView, childViewHolder);
                    return;
                }
                return;
            }
            select((RecyclerView.ViewHolder) null, 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f5;
        float f6;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f7 = fArr[0];
            f5 = fArr[1];
            f6 = f7;
        } else {
            f6 = 0.0f;
            f5 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f6, f5);
    }

    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        float f5;
        float f6;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f7 = fArr[0];
            f5 = fArr[1];
            f6 = f7;
        } else {
            f6 = 0.0f;
            f5 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f6, f5);
    }

    /* access modifiers changed from: package-private */
    public void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i5) {
        this.mRecyclerView.post(new Runnable() {
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.mRecyclerView;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    RecoverAnimation recoverAnimation = recoverAnimation;
                    if (!recoverAnimation.mOverridden && recoverAnimation.mViewHolder.getAbsoluteAdapterPosition() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                            ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i5);
                        } else {
                            ItemTouchHelper.this.mRecyclerView.post(this);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        if (r6 < 0) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        if (r6 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scrollIfNecessary() {
        /*
            r15 = this;
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r15.mSelected
            r1 = 0
            r2 = -9223372036854775808
            if (r0 != 0) goto L_0x000a
            r15.mDragScrollStartTimeInMs = r2
            return r1
        L_0x000a:
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r15.mDragScrollStartTimeInMs
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0018
            r6 = 0
        L_0x0016:
            r13 = r6
            goto L_0x001b
        L_0x0018:
            long r6 = r4 - r6
            goto L_0x0016
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r0 = r15.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            android.graphics.Rect r6 = r15.mTmpRect
            if (r6 != 0) goto L_0x002c
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            r15.mTmpRect = r6
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = r15.mSelected
            android.view.View r6 = r6.itemView
            android.graphics.Rect r7 = r15.mTmpRect
            r0.calculateItemDecorationsForChild(r6, r7)
            boolean r6 = r0.canScrollHorizontally()
            r7 = 0
            if (r6 == 0) goto L_0x007d
            float r6 = r15.mSelectedStartX
            float r8 = r15.mDx
            float r6 = r6 + r8
            int r6 = (int) r6
            android.graphics.Rect r8 = r15.mTmpRect
            int r8 = r8.left
            int r8 = r6 - r8
            androidx.recyclerview.widget.RecyclerView r9 = r15.mRecyclerView
            int r9 = r9.getPaddingLeft()
            int r8 = r8 - r9
            float r9 = r15.mDx
            int r10 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r10 >= 0) goto L_0x0059
            if (r8 >= 0) goto L_0x0059
        L_0x0057:
            r11 = r8
            goto L_0x007e
        L_0x0059:
            int r8 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$ViewHolder r8 = r15.mSelected
            android.view.View r8 = r8.itemView
            int r8 = r8.getWidth()
            int r6 = r6 + r8
            android.graphics.Rect r8 = r15.mTmpRect
            int r8 = r8.right
            int r6 = r6 + r8
            androidx.recyclerview.widget.RecyclerView r8 = r15.mRecyclerView
            int r8 = r8.getWidth()
            androidx.recyclerview.widget.RecyclerView r9 = r15.mRecyclerView
            int r9 = r9.getPaddingRight()
            int r8 = r8 - r9
            int r8 = r6 - r8
            if (r8 <= 0) goto L_0x007d
            goto L_0x0057
        L_0x007d:
            r11 = r1
        L_0x007e:
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L_0x00c4
            float r0 = r15.mSelectedStartY
            float r6 = r15.mDy
            float r0 = r0 + r6
            int r0 = (int) r0
            android.graphics.Rect r6 = r15.mTmpRect
            int r6 = r6.top
            int r6 = r0 - r6
            androidx.recyclerview.widget.RecyclerView r8 = r15.mRecyclerView
            int r8 = r8.getPaddingTop()
            int r6 = r6 - r8
            float r8 = r15.mDy
            int r9 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a0
            if (r6 >= 0) goto L_0x00a0
            goto L_0x00c5
        L_0x00a0:
            int r6 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = r15.mSelected
            android.view.View r6 = r6.itemView
            int r6 = r6.getHeight()
            int r0 = r0 + r6
            android.graphics.Rect r6 = r15.mTmpRect
            int r6 = r6.bottom
            int r0 = r0 + r6
            androidx.recyclerview.widget.RecyclerView r6 = r15.mRecyclerView
            int r6 = r6.getHeight()
            androidx.recyclerview.widget.RecyclerView r7 = r15.mRecyclerView
            int r7 = r7.getPaddingBottom()
            int r6 = r6 - r7
            int r6 = r0 - r6
            if (r6 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r6 = r1
        L_0x00c5:
            if (r11 == 0) goto L_0x00dd
            androidx.recyclerview.widget.ItemTouchHelper$Callback r8 = r15.mCallback
            androidx.recyclerview.widget.RecyclerView r9 = r15.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r15.mSelected
            android.view.View r0 = r0.itemView
            int r10 = r0.getWidth()
            androidx.recyclerview.widget.RecyclerView r0 = r15.mRecyclerView
            int r12 = r0.getWidth()
            int r11 = r8.interpolateOutOfBoundsScroll(r9, r10, r11, r12, r13)
        L_0x00dd:
            r0 = r11
            if (r6 == 0) goto L_0x00f8
            androidx.recyclerview.widget.ItemTouchHelper$Callback r8 = r15.mCallback
            androidx.recyclerview.widget.RecyclerView r9 = r15.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = r15.mSelected
            android.view.View r7 = r7.itemView
            int r10 = r7.getHeight()
            androidx.recyclerview.widget.RecyclerView r7 = r15.mRecyclerView
            int r12 = r7.getHeight()
            r11 = r6
            int r6 = r8.interpolateOutOfBoundsScroll(r9, r10, r11, r12, r13)
            goto L_0x00f9
        L_0x00f8:
            r11 = r6
        L_0x00f9:
            if (r0 != 0) goto L_0x0101
            if (r6 == 0) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r15.mDragScrollStartTimeInMs = r2
            return r1
        L_0x0101:
            long r7 = r15.mDragScrollStartTimeInMs
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0109
            r15.mDragScrollStartTimeInMs = r4
        L_0x0109:
            androidx.recyclerview.widget.RecyclerView r1 = r15.mRecyclerView
            r1.scrollBy(r0, r6)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.scrollIfNecessary():boolean");
    }

    /* access modifiers changed from: package-private */
    public void select(@Nullable RecyclerView.ViewHolder viewHolder, int i5) {
        boolean z4;
        final int i6;
        float f5;
        float f6;
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        int i7 = i5;
        if (viewHolder2 != this.mSelected || i7 != this.mActionState) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            int i8 = this.mActionState;
            endRecoverAnimation(viewHolder2, true);
            this.mActionState = i7;
            if (i7 == 2) {
                if (viewHolder2 != null) {
                    this.mOverdrawChild = viewHolder2.itemView;
                    addChildDrawingOrderCallback();
                } else {
                    throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
                }
            }
            int i9 = (1 << ((i7 * 8) + 8)) - 1;
            RecyclerView.ViewHolder viewHolder3 = this.mSelected;
            boolean z5 = false;
            if (viewHolder3 != null) {
                if (viewHolder3.itemView.getParent() != null) {
                    if (i8 == 2) {
                        i6 = 0;
                    } else {
                        i6 = swipeIfNecessary(viewHolder3);
                    }
                    releaseVelocityTracker();
                    int i10 = 4;
                    if (i6 == 1 || i6 == 2) {
                        f6 = 0.0f;
                        f5 = Math.signum(this.mDy) * ((float) this.mRecyclerView.getHeight());
                    } else if (i6 == 4 || i6 == 8 || i6 == 16 || i6 == 32) {
                        f5 = 0.0f;
                        f6 = Math.signum(this.mDx) * ((float) this.mRecyclerView.getWidth());
                    } else {
                        f6 = 0.0f;
                        f5 = 0.0f;
                    }
                    if (i8 == 2) {
                        i10 = 8;
                    } else if (i6 > 0) {
                        i10 = 2;
                    }
                    getSelectedDxDy(this.mTmpPosition);
                    float[] fArr = this.mTmpPosition;
                    float f7 = fArr[0];
                    float f8 = fArr[1];
                    final RecyclerView.ViewHolder viewHolder4 = viewHolder3;
                    z4 = false;
                    AnonymousClass3 r02 = new RecoverAnimation(viewHolder3, i10, i8, f7, f8, f6, f5) {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            if (!this.mOverridden) {
                                if (i6 <= 0) {
                                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                                    itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, viewHolder4);
                                } else {
                                    ItemTouchHelper.this.mPendingCleanup.add(viewHolder4.itemView);
                                    this.mIsPendingCleanup = true;
                                    int i5 = i6;
                                    if (i5 > 0) {
                                        ItemTouchHelper.this.postDispatchSwipe(this, i5);
                                    }
                                }
                                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                                View view = itemTouchHelper2.mOverdrawChild;
                                View view2 = viewHolder4.itemView;
                                if (view == view2) {
                                    itemTouchHelper2.removeChildDrawingOrderCallbackIfNecessary(view2);
                                }
                            }
                        }
                    };
                    r02.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i10, f6 - f7, f5 - f8));
                    this.mRecoverAnimations.add(r02);
                    r02.start();
                    z5 = true;
                } else {
                    z4 = false;
                    removeChildDrawingOrderCallbackIfNecessary(viewHolder3.itemView);
                    this.mCallback.clearView(this.mRecyclerView, viewHolder3);
                    z5 = false;
                }
                this.mSelected = null;
            } else {
                z4 = false;
            }
            if (viewHolder2 != null) {
                this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder2) & i9) >> (this.mActionState * 8);
                this.mSelectedStartX = (float) viewHolder2.itemView.getLeft();
                this.mSelectedStartY = (float) viewHolder2.itemView.getTop();
                this.mSelected = viewHolder2;
                if (i7 == 2) {
                    viewHolder2.itemView.performHapticFeedback(z4 ? 1 : 0);
                }
            }
            ViewParent parent = this.mRecyclerView.getParent();
            if (parent != null) {
                if (this.mSelected != null) {
                    z4 = true;
                }
                parent.requestDisallowInterceptTouchEvent(z4);
            }
            if (!z5) {
                this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
            this.mRecyclerView.invalidate();
        }
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start drag has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start swipe has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateDxDy(MotionEvent motionEvent, int i5, int i6) {
        float x4 = motionEvent.getX(i6);
        float y4 = motionEvent.getY(i6);
        float f5 = x4 - this.mInitialTouchX;
        this.mDx = f5;
        this.mDy = y4 - this.mInitialTouchY;
        if ((i5 & 4) == 0) {
            this.mDx = Math.max(0.0f, f5);
        }
        if ((i5 & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i5 & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i5 & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }
}
