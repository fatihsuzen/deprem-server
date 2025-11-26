package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f5) {
            float f6 = f5 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    };
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable = new Runnable() {
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i5, int i6) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i5, int i6) {
            return 0;
        }

        public int getOrderedChildIndex(int i5) {
            return i5;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i5, int i6) {
        }

        public boolean onEdgeLock(int i5) {
            return false;
        }

        public void onEdgeTouched(int i5, int i6) {
        }

        public void onViewCaptured(@NonNull View view, int i5) {
        }

        public void onViewDragStateChanged(int i5) {
        }

        public void onViewPositionChanged(@NonNull View view, int i5, int i6, @Px int i7, @Px int i8) {
        }

        public void onViewReleased(@NonNull View view, float f5, float f6) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i5);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i5 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mDefaultEdgeSize = i5;
            this.mEdgeSize = i5;
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = new OverScroller(context, sInterpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean checkNewEdgeDrag(float f5, float f6, int i5, int i6) {
        float abs = Math.abs(f5);
        float abs2 = Math.abs(f6);
        if (!((this.mInitialEdgesTouched[i5] & i6) != i6 || (this.mTrackingEdges & i6) == 0 || (this.mEdgeDragsLocked[i5] & i6) == i6 || (this.mEdgeDragsInProgress[i5] & i6) == i6)) {
            int i7 = this.mTouchSlop;
            if (abs > ((float) i7) || abs2 > ((float) i7)) {
                if (abs < abs2 * 0.5f && this.mCallback.onEdgeLock(i6)) {
                    int[] iArr = this.mEdgeDragsLocked;
                    iArr[i5] = iArr[i5] | i6;
                    return false;
                } else if ((this.mEdgeDragsInProgress[i5] & i6) != 0 || abs <= ((float) this.mTouchSlop)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f5, float f6) {
        if (view == null) {
            return false;
        }
        boolean z4 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z5 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z4 || !z5) {
            return z4 ? Math.abs(f5) > ((float) this.mTouchSlop) : z5 && Math.abs(f6) > ((float) this.mTouchSlop);
        }
        int i5 = this.mTouchSlop;
        return (f5 * f5) + (f6 * f6) > ((float) (i5 * i5));
    }

    private int clampMag(int i5, int i6, int i7) {
        int abs = Math.abs(i5);
        if (abs < i6) {
            return 0;
        }
        if (abs > i7) {
            return i5 > 0 ? i7 : -i7;
        }
        return i5;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private int computeAxisDuration(int i5, int i6, int i7) {
        int i8;
        if (i5 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f5 = (float) (width / 2);
        float distanceInfluenceForSnapDuration = f5 + (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i5)) / ((float) width))) * f5);
        int abs = Math.abs(i6);
        if (abs > 0) {
            i8 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i8 = (int) (((((float) Math.abs(i5)) / ((float) i7)) + 1.0f) * 256.0f);
        }
        return Math.min(i8, 600);
    }

    private int computeSettleDuration(View view, int i5, int i6, int i7, int i8) {
        float f5;
        float f6;
        float f7;
        float f8;
        int clampMag = clampMag(i7, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i8, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i9 = abs3 + abs4;
        int i10 = abs + abs2;
        if (clampMag != 0) {
            f5 = (float) abs3;
            f6 = (float) i9;
        } else {
            f5 = (float) abs;
            f6 = (float) i10;
        }
        float f9 = f5 / f6;
        if (clampMag2 != 0) {
            f7 = (float) abs4;
            f8 = (float) i9;
        } else {
            f7 = (float) abs2;
            f8 = (float) i10;
        }
        float f10 = f7 / f8;
        return (int) ((((float) computeAxisDuration(i5, clampMag, this.mCallback.getViewHorizontalDragRange(view))) * f9) + (((float) computeAxisDuration(i6, clampMag2, this.mCallback.getViewVerticalDragRange(view))) * f10));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f5, float f6) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f5, f6);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f5) {
        return (float) Math.sin((double) ((f5 - 0.5f) * 0.47123894f));
    }

    private void dragTo(int i5, int i6, int i7, int i8) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i7 != 0) {
            i5 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i5, i7);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i5 - left);
        }
        int i9 = i5;
        if (i8 != 0) {
            i6 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i6, i8);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i6 - top);
        }
        int i10 = i6;
        if (i7 != 0 || i8 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i9, i10, i9 - left, i10 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i5) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i5) {
            int i6 = i5 + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i5, int i6, int i7, int i8) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i9 = i5 - left;
        int i10 = i6 - top;
        if (i9 == 0 && i10 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        int i11 = i10;
        int i12 = i9;
        int computeSettleDuration = computeSettleDuration(this.mCapturedView, i12, i11, i7, i8);
        this.mScroller.startScroll(left, top, i12, i11, computeSettleDuration);
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i5, int i6) {
        int i7;
        if (i5 < this.mParentView.getLeft() + this.mEdgeSize) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        if (i6 < this.mParentView.getTop() + this.mEdgeSize) {
            i7 |= 4;
        }
        if (i5 > this.mParentView.getRight() - this.mEdgeSize) {
            i7 |= 2;
        }
        if (i6 > this.mParentView.getBottom() - this.mEdgeSize) {
            return i7 | 8;
        }
        return i7;
    }

    private boolean isValidPointerForActionMove(int i5) {
        if (isPointerDown(i5)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f5, float f6, int i5) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f5, f6, i5, 1);
        if (checkNewEdgeDrag(f6, f5, i5, 4)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f5, f6, i5, 2)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f6, f5, i5, 8)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i5] = iArr[i5] | checkNewEdgeDrag;
            this.mCallback.onEdgeDragStarted(checkNewEdgeDrag ? 1 : 0, i5);
        }
    }

    private void saveInitialMotion(float f5, float f6, int i5) {
        ensureMotionHistorySizeForId(i5);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i5] = f5;
        fArr[i5] = f5;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i5] = f6;
        fArr2[i5] = f6;
        this.mInitialEdgesTouched[i5] = getEdgesTouched((int) f5, (int) f6);
        this.mPointersDown |= 1 << i5;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i5 = 0; i5 < pointerCount; i5++) {
            int pointerId = motionEvent.getPointerId(i5);
            if (isValidPointerForActionMove(pointerId)) {
                float x4 = motionEvent.getX(i5);
                float y4 = motionEvent.getY(i5);
                this.mLastMotionX[pointerId] = x4;
                this.mLastMotionY[pointerId] = y4;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(@NonNull View view, boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i10 = i7 + scrollX;
                if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && (i9 = i8 + scrollY) >= childAt.getTop() && i9 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i5, i6, i10 - childAt.getLeft(), i9 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z4) {
            return false;
        }
        if (view.canScrollHorizontally(-i5) || view.canScrollVertically(-i6)) {
            return true;
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i5) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i5;
            this.mCallback.onViewCaptured(view, i5);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean z4) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z4) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        if (this.mDragState == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public View findTopChildUnder(int i5, int i6) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i5, int i6, int i7, int i8) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i5, i7, i6, i8);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i5, int i6) {
        return isViewUnder(this.mCapturedView, i5, i6);
    }

    public boolean isEdgeTouched(int i5) {
        int length = this.mInitialEdgesTouched.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (isEdgeTouched(i5, i6)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i5) {
        if (((1 << i5) & this.mPointersDown) != 0) {
            return true;
        }
        return false;
    }

    public boolean isViewUnder(@Nullable View view, int i5, int i6) {
        if (view != null && i5 >= view.getLeft() && i5 < view.getRight() && i6 >= view.getTop() && i6 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i5;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i6 = 0;
        if (actionMasked == 0) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x4, (int) y4);
            saveInitialMotion(x4, y4, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i7 = this.mInitialEdgesTouched[pointerId];
            int i8 = this.mTrackingEdges;
            if ((i7 & i8) != 0) {
                this.mCallback.onEdgeTouched(i7 & i8, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.mDragState == 1) {
                    dispatchViewReleased(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x5 = motionEvent.getX(actionIndex);
                float y5 = motionEvent.getY(actionIndex);
                saveInitialMotion(x5, y5, pointerId2);
                if (this.mDragState == 0) {
                    tryCaptureViewForDrag(findTopChildUnder((int) x5, (int) y5), pointerId2);
                    int i9 = this.mInitialEdgesTouched[pointerId2];
                    int i10 = this.mTrackingEdges;
                    if ((i9 & i10) != 0) {
                        this.mCallback.onEdgeTouched(i9 & i10, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x5, (int) y5)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == 1 && pointerId3 == this.mActivePointerId) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i6 >= pointerCount) {
                            i5 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i6);
                        if (pointerId4 != this.mActivePointerId) {
                            View findTopChildUnder2 = findTopChildUnder((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                            View view = this.mCapturedView;
                            if (findTopChildUnder2 == view && tryCaptureViewForDrag(view, pointerId4)) {
                                i5 = this.mActivePointerId;
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i5 == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId3);
            }
        } else if (this.mDragState != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i6 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i6);
                if (isValidPointerForActionMove(pointerId5)) {
                    float x6 = motionEvent.getX(i6);
                    float y6 = motionEvent.getY(i6);
                    float f5 = x6 - this.mInitialMotionX[pointerId5];
                    float f6 = y6 - this.mInitialMotionY[pointerId5];
                    reportNewEdgeDrags(f5, f6, pointerId5);
                    if (this.mDragState != 1) {
                        View findTopChildUnder3 = findTopChildUnder((int) x6, (int) y6);
                        if (checkTouchSlop(findTopChildUnder3, f5, f6) && tryCaptureViewForDrag(findTopChildUnder3, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6++;
            }
            saveLastMotion(motionEvent);
        } else if (isValidPointerForActionMove(this.mActivePointerId)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            float x7 = motionEvent.getX(findPointerIndex);
            float y7 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.mLastMotionX;
            int i11 = this.mActivePointerId;
            int i12 = (int) (x7 - fArr[i11]);
            int i13 = (int) (y7 - this.mLastMotionY[i11]);
            dragTo(this.mCapturedView.getLeft() + i12, this.mCapturedView.getTop() + i13, i12, i13);
            saveLastMotion(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDragState(int i5) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i5) {
            this.mDragState = i5;
            this.mCallback.onViewDragStateChanged(i5);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@Px @IntRange(from = 0) int i5) {
        this.mEdgeSize = i5;
    }

    public void setEdgeTrackingEnabled(int i5) {
        this.mTrackingEdges = i5;
    }

    public void setMinVelocity(float f5) {
        this.mMinVelocity = f5;
    }

    public boolean settleCapturedViewAt(int i5, int i6) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i5, i6, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e0, code lost:
        if (r12 != r11) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            int r3 = r1.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r0.cancel()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.mVelocityTracker
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.mVelocityTracker = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.mVelocityTracker
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0105
            if (r2 == r6) goto L_0x0101
            if (r2 == r4) goto L_0x0072
            r7 = 3
            if (r2 == r7) goto L_0x0101
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0033
            goto L_0x0136
        L_0x0033:
            int r1 = r1.getPointerId(r3)
            r0.clearMotionHistory(r1)
            goto L_0x0136
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.saveInitialMotion(r7, r1, r2)
            int r3 = r0.mDragState
            if (r3 != 0) goto L_0x0061
            int[] r1 = r0.mInitialEdgesTouched
            r1 = r1[r2]
            int r3 = r0.mTrackingEdges
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0136
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.mCallback
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0136
        L_0x0061:
            if (r3 != r4) goto L_0x0136
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.findTopChildUnder(r3, r1)
            android.view.View r3 = r0.mCapturedView
            if (r1 != r3) goto L_0x0136
            r0.tryCaptureViewForDrag(r1, r2)
            goto L_0x0136
        L_0x0072:
            float[] r2 = r0.mInitialMotionX
            if (r2 == 0) goto L_0x0136
            float[] r2 = r0.mInitialMotionY
            if (r2 != 0) goto L_0x007c
            goto L_0x0136
        L_0x007c:
            int r2 = r1.getPointerCount()
            r3 = 0
        L_0x0081:
            if (r3 >= r2) goto L_0x00fd
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.isValidPointerForActionMove(r4)
            if (r7 != 0) goto L_0x008f
            goto L_0x00fa
        L_0x008f:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.mInitialMotionX
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.mInitialMotionY
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.findTopChildUnder(r7, r8)
            if (r7 == 0) goto L_0x00b3
            boolean r8 = r0.checkTouchSlop(r7, r9, r10)
            if (r8 == 0) goto L_0x00b3
            r8 = r6
            goto L_0x00b4
        L_0x00b3:
            r8 = 0
        L_0x00b4:
            if (r8 == 0) goto L_0x00e9
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.mCallback
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.mCallback
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.mCallback
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.mCallback
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00e2
            if (r14 <= 0) goto L_0x00e9
            if (r12 != r11) goto L_0x00e9
        L_0x00e2:
            if (r15 == 0) goto L_0x00fd
            if (r15 <= 0) goto L_0x00e9
            if (r5 != r13) goto L_0x00e9
            goto L_0x00fd
        L_0x00e9:
            r0.reportNewEdgeDrags(r9, r10, r4)
            int r5 = r0.mDragState
            if (r5 != r6) goto L_0x00f1
            goto L_0x00fd
        L_0x00f1:
            if (r8 == 0) goto L_0x00fa
            boolean r4 = r0.tryCaptureViewForDrag(r7, r4)
            if (r4 == 0) goto L_0x00fa
            goto L_0x00fd
        L_0x00fa:
            int r3 = r3 + 1
            goto L_0x0081
        L_0x00fd:
            r17.saveLastMotion(r18)
            goto L_0x0136
        L_0x0101:
            r0.cancel()
            goto L_0x0136
        L_0x0105:
            float r2 = r1.getX()
            float r3 = r1.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.saveInitialMotion(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.findTopChildUnder(r2, r3)
            android.view.View r3 = r0.mCapturedView
            if (r2 != r3) goto L_0x0126
            int r3 = r0.mDragState
            if (r3 != r4) goto L_0x0126
            r0.tryCaptureViewForDrag(r2, r1)
        L_0x0126:
            int[] r2 = r0.mInitialEdgesTouched
            r2 = r2[r1]
            int r3 = r0.mTrackingEdges
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0136
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.mCallback
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0136:
            int r1 = r0.mDragState
            if (r1 != r6) goto L_0x013b
            return r6
        L_0x013b:
            r16 = 0
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i5, int i6) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i5, i6, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    /* access modifiers changed from: package-private */
    public boolean tryCaptureViewForDrag(View view, int i5) {
        if (view == this.mCapturedView && this.mActivePointerId == i5) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i5)) {
            return false;
        }
        this.mActivePointerId = i5;
        captureChildView(view, i5);
        return true;
    }

    private float clampMag(float f5, float f6, float f7) {
        float abs = Math.abs(f5);
        if (abs < f6) {
            return 0.0f;
        }
        if (abs > f7) {
            return f5 > 0.0f ? f7 : -f7;
        }
        return f5;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f5, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (((float) create.mTouchSlop) * (1.0f / f5));
        return create;
    }

    public boolean isEdgeTouched(int i5, int i6) {
        return isPointerDown(i6) && (i5 & this.mInitialEdgesTouched[i6]) != 0;
    }

    public boolean checkTouchSlop(int i5) {
        int length = this.mInitialMotionX.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (checkTouchSlop(i5, i6)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i5, int i6) {
        if (!isPointerDown(i6)) {
            return false;
        }
        boolean z4 = (i5 & 1) == 1;
        boolean z5 = (i5 & 2) == 2;
        float f5 = this.mLastMotionX[i6] - this.mInitialMotionX[i6];
        float f6 = this.mLastMotionY[i6] - this.mInitialMotionY[i6];
        if (!z4 || !z5) {
            return z4 ? Math.abs(f5) > ((float) this.mTouchSlop) : z5 && Math.abs(f6) > ((float) this.mTouchSlop);
        }
        int i7 = this.mTouchSlop;
        return (f5 * f5) + (f6 * f6) > ((float) (i7 * i7));
    }

    private void clearMotionHistory(int i5) {
        if (this.mInitialMotionX != null && isPointerDown(i5)) {
            this.mInitialMotionX[i5] = 0.0f;
            this.mInitialMotionY[i5] = 0.0f;
            this.mLastMotionX[i5] = 0.0f;
            this.mLastMotionY[i5] = 0.0f;
            this.mInitialEdgesTouched[i5] = 0;
            this.mEdgeDragsInProgress[i5] = 0;
            this.mEdgeDragsLocked[i5] = 0;
            this.mPointersDown = (~(1 << i5)) & this.mPointersDown;
        }
    }
}
