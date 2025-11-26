package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        /* access modifiers changed from: package-private */
        public void assignCoordinateFromPadding() {
            int i5;
            if (this.mLayoutFromEnd) {
                i5 = this.mOrientationHelper.getEndAfterPadding();
            } else {
                i5 = this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = i5;
        }

        public void assignFromView(View view, int i5) {
            if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mOrientationHelper.getDecoratedEnd(view) + this.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = i5;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int i5) {
            int totalSpaceChange = this.mOrientationHelper.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view, i5);
                return;
            }
            this.mPosition = i5;
            if (this.mLayoutFromEnd) {
                int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view);
                    int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.mCoordinate += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view))) - (decoratedStart + this.mOrientationHelper.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isViewValidAsAnchor(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.isItemRemoved() || layoutParams.getViewLayoutPosition() < 0 || layoutParams.getViewLayoutPosition() >= state.getItemCount()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }
    }

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace = 0;
        boolean mInfinite;
        boolean mIsPreLayout = false;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace = 0;
        int mOffset;
        boolean mRecycle = true;
        List<RecyclerView.ViewHolder> mScrapList = null;
        int mScrollingOffset;

        LayoutState() {
        }

        private View nextViewFromScrapList() {
            int size = this.mScrapList.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = this.mScrapList.get(i5).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList((View) null);
        }

        /* access modifiers changed from: package-private */
        public boolean hasMore(RecyclerView.State state) {
            int i5 = this.mCurrentPosition;
            if (i5 < 0 || i5 >= state.getItemCount()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        /* access modifiers changed from: package-private */
        public View next(RecyclerView.Recycler recycler) {
            if (this.mScrapList != null) {
                return nextViewFromScrapList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }

        public View nextViewInLimitedList(View view) {
            int viewLayoutPosition;
            int size = this.mScrapList.size();
            View view2 = null;
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < size; i6++) {
                View view3 = this.mScrapList.get(i6).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection) >= 0 && viewLayoutPosition < i5) {
                    if (viewLayoutPosition == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i5 = viewLayoutPosition;
                }
            }
            return view2;
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            if (nextViewInLimitedList == null) {
                this.mCurrentPosition = -1;
            } else {
                this.mCurrentPosition = ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasValidAnchor() {
            if (this.mAnchorPosition >= 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i5, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i5;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i6 = -scrollBy(-endAfterPadding2, recycler, state);
        int i7 = i5 + i6;
        if (!z4 || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i7) <= 0) {
            return i6;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + i6;
    }

    private int fixLayoutStartGap(int i5, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4) {
        int startAfterPadding;
        int startAfterPadding2 = i5 - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i6 = -scrollBy(startAfterPadding2, recycler, state);
        int i7 = i5 + i6;
        if (!z4 || (startAfterPadding = i7 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return i6;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return i6 - startAfterPadding;
    }

    private View getChildClosestToEnd() {
        int i5;
        if (this.mShouldReverseLayout) {
            i5 = 0;
        } else {
            i5 = getChildCount() - 1;
        }
        return getChildAt(i5);
    }

    private View getChildClosestToStart() {
        int i5;
        if (this.mShouldReverseLayout) {
            i5 = getChildCount() - 1;
        } else {
            i5 = 0;
        }
        return getChildAt(i5);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i5, int i6) {
        boolean z4;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i9);
                if (!viewHolder.isRemoved()) {
                    if (viewHolder.getLayoutPosition() < position) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4 != this.mShouldReverseLayout) {
                        i7 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i8 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.mScrapList = scrapList;
            if (i7 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i5);
                LayoutState layoutState = this.mLayoutState;
                layoutState.mExtraFillSpace = i7;
                layoutState.mAvailable = 0;
                layoutState.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            if (i8 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i6);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtraFillSpace = i8;
                layoutState2.mAvailable = 0;
                layoutState2.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            int i5 = layoutState.mScrollingOffset;
            int i6 = layoutState.mNoRecycleSpace;
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, i5, i6);
            } else {
                recycleViewsFromStart(recycler, i5, i6);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i5, int i6) {
        if (i5 != i6) {
            if (i6 > i5) {
                for (int i7 = i6 - 1; i7 >= i5; i7--) {
                    removeAndRecycleViewAt(i7, recycler);
                }
                return;
            }
            while (i5 > i6) {
                removeAndRecycleViewAt(i5, recycler);
                i5--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i5, int i6) {
        int childCount = getChildCount();
        if (i5 >= 0) {
            int end = (this.mOrientationHelper.getEnd() - i5) + i6;
            if (this.mShouldReverseLayout) {
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                        recycleChildren(recycler, 0, i7);
                        return;
                    }
                }
                return;
            }
            int i8 = childCount - 1;
            for (int i9 = i8; i9 >= 0; i9--) {
                View childAt2 = getChildAt(i9);
                if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                    recycleChildren(recycler, i8, i9);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i5, int i6) {
        if (i5 >= 0) {
            int i7 = i5 - i6;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i8 = childCount - 1;
                for (int i9 = i8; i9 >= 0; i9--) {
                    View childAt = getChildAt(i9);
                    if (this.mOrientationHelper.getDecoratedEnd(childAt) > i7 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i7) {
                        recycleChildren(recycler, i8, i9);
                        return;
                    }
                }
                return;
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt2 = getChildAt(i10);
                if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i7 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i7) {
                    recycleChildren(recycler, 0, i10);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChild;
        boolean z4;
        boolean z5 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null || !anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
            boolean z6 = this.mLastStackFromEnd;
            boolean z7 = this.mStackFromEnd;
            if (z6 != z7 || (findReferenceChild = findReferenceChild(recycler, state, anchorInfo.mLayoutFromEnd, z7)) == null) {
                return false;
            }
            anchorInfo.assignFromView(findReferenceChild, getPosition(findReferenceChild));
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                int decoratedStart = this.mOrientationHelper.getDecoratedStart(findReferenceChild);
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findReferenceChild);
                int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                if (decoratedEnd > startAfterPadding || decoratedStart >= startAfterPadding) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                    z5 = true;
                }
                if (z4 || z5) {
                    if (anchorInfo.mLayoutFromEnd) {
                        startAfterPadding = endAfterPadding;
                    }
                    anchorInfo.mCoordinate = startAfterPadding;
                }
            }
            return true;
        }
        anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i5;
        boolean z4;
        int i6;
        boolean z5 = false;
        if (!state.isPreLayout() && (i5 = this.mPendingScrollPosition) != -1) {
            if (i5 < 0 || i5 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z6 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    anchorInfo.mLayoutFromEnd = z6;
                    if (z6) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4 == this.mShouldReverseLayout) {
                                z5 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z5;
                        }
                        anchorInfo.assignCoordinateFromPadding();
                    } else if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                        anchorInfo.assignCoordinateFromPadding();
                        return true;
                    } else if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                        anchorInfo.mLayoutFromEnd = false;
                        return true;
                    } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                        anchorInfo.mLayoutFromEnd = true;
                        return true;
                    } else {
                        if (anchorInfo.mLayoutFromEnd) {
                            i6 = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                        } else {
                            i6 = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                        }
                        anchorInfo.mCoordinate = i6;
                    }
                    return true;
                } else {
                    boolean z7 = this.mShouldReverseLayout;
                    anchorInfo.mLayoutFromEnd = z7;
                    if (z7) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i5;
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            if (this.mStackFromEnd) {
                i5 = state.getItemCount() - 1;
            } else {
                i5 = 0;
            }
            anchorInfo.mPosition = i5;
        }
    }

    private void updateLayoutState(int i5, int i6, boolean z4, RecyclerView.State state) {
        int i7;
        int i8;
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = i5;
        int[] iArr = this.mReusableIntPair;
        boolean z5 = false;
        iArr[0] = 0;
        int i9 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i5 == 1) {
            z5 = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (z5) {
            i7 = max2;
        } else {
            i7 = max;
        }
        layoutState.mExtraFillSpace = i7;
        if (!z5) {
            max = max2;
        }
        layoutState.mNoRecycleSpace = max;
        if (z5) {
            layoutState.mExtraFillSpace = i7 + this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i9 = -1;
            }
            layoutState2.mItemDirection = i9;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.mCurrentPosition = position + layoutState3.mItemDirection;
            layoutState3.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            i8 = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
            LayoutState layoutState4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i9 = -1;
            }
            layoutState4.mItemDirection = i9;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState5 = this.mLayoutState;
            layoutState4.mCurrentPosition = position2 + layoutState5.mItemDirection;
            layoutState5.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            i8 = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        LayoutState layoutState6 = this.mLayoutState;
        layoutState6.mAvailable = i6;
        if (z4) {
            layoutState6.mAvailable = i6 - i8;
        }
        layoutState6.mScrollingOffset = i8;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i5;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLayoutDirection == -1) {
            i5 = 0;
        } else {
            i5 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i5;
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i5, int i6, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i7;
        if (this.mOrientation != 0) {
            i5 = i6;
        }
        if (getChildCount() != 0 && i5 != 0) {
            ensureLayoutState();
            if (i5 > 0) {
                i7 = 1;
            } else {
                i7 = -1;
            }
            updateLayoutState(i7, Math.abs(i5), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i5, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z4;
        int i6;
        SavedState savedState = this.mPendingSavedState;
        int i7 = -1;
        if (savedState == null || !savedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z4 = this.mShouldReverseLayout;
            i6 = this.mPendingScrollPosition;
            if (i6 == -1) {
                if (z4) {
                    i6 = i5 - 1;
                } else {
                    i6 = 0;
                }
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z4 = savedState2.mAnchorLayoutFromEnd;
            i6 = savedState2.mAnchorPosition;
        }
        if (!z4) {
            i7 = 1;
        }
        for (int i8 = 0; i8 < this.mInitialPrefetchItemCount && i6 >= 0 && i6 < i5; i8++) {
            layoutPrefetchRegistry.addPosition(i6, 0);
            i6 += i7;
        }
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i5 = layoutState.mCurrentPosition;
        if (i5 >= 0 && i5 < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i5, Math.max(0, layoutState.mScrollingOffset));
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i5) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z4 = false;
        int i6 = 1;
        if (i5 < getPosition(getChildAt(0))) {
            z4 = true;
        }
        if (z4 != this.mShouldReverseLayout) {
            i6 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i6, 0.0f);
        }
        return new PointF(0.0f, (float) i6);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i5) {
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 17) {
                    if (i5 != 33) {
                        if (i5 != 66) {
                            if (i5 == 130 && this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z4) {
        int i5 = layoutState.mAvailable;
        int i6 = layoutState.mScrollingOffset;
        if (i6 != Integer.MIN_VALUE) {
            if (i5 < 0) {
                layoutState.mScrollingOffset = i6 + i5;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i7 = layoutState.mAvailable + layoutState.mExtraFillSpace;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.mInfinite && i7 <= 0) || !layoutState.hasMore(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null || !state.isPreLayout()) {
                    int i8 = layoutState.mAvailable;
                    int i9 = layoutChunkResult.mConsumed;
                    layoutState.mAvailable = i8 - i9;
                    i7 -= i9;
                }
                int i10 = layoutState.mScrollingOffset;
                if (i10 != Integer.MIN_VALUE) {
                    int i11 = i10 + layoutChunkResult.mConsumed;
                    layoutState.mScrollingOffset = i11;
                    int i12 = layoutState.mAvailable;
                    if (i12 < 0) {
                        layoutState.mScrollingOffset = i11 + i12;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z4 && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i5 - layoutState.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z4, boolean z5) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z4, z5);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z4, z5);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z4, boolean z5) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z4, z5);
        }
        return findOneVisibleChild(0, getChildCount(), z4, z5);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i5, int i6) {
        int i7;
        int i8;
        ensureLayoutState();
        if (i6 <= i5 && i6 >= i5) {
            return getChildAt(i5);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i5)) < this.mOrientationHelper.getStartAfterPadding()) {
            i8 = 16644;
            i7 = 16388;
        } else {
            i8 = 4161;
            i7 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i5, i6, i8, i7);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i5, i6, i8, i7);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i5, int i6, boolean z4, boolean z5) {
        int i7;
        ensureLayoutState();
        int i8 = 320;
        if (z4) {
            i7 = 24579;
        } else {
            i7 = 320;
        }
        if (!z5) {
            i8 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i5, i6, i7, i8);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i5, i6, i7, i8);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4, boolean z5) {
        int i5;
        int i6;
        int i7;
        boolean z6;
        boolean z7;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z5) {
            i7 = getChildCount() - 1;
            i6 = -1;
            i5 = -1;
        } else {
            i6 = childCount;
            i7 = 0;
            i5 = 1;
        }
        int itemCount = state.getItemCount();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i7 != i6) {
            View childAt = getChildAt(i7);
            int position = getPosition(childAt);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (position >= 0 && position < itemCount) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (decoratedEnd > startAfterPadding || decoratedStart >= startAfterPadding) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (decoratedStart < endAfterPadding || decoratedEnd <= endAfterPadding) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (!z6 && !z7) {
                        return childAt;
                    }
                    if (z4) {
                        if (!z7) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                    } else if (!z6) {
                        if (view != null) {
                        }
                        view = childAt;
                    }
                    view2 = childAt;
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i7 += i5;
        }
        if (view != null) {
            return view;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i5) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i5 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i5) {
                return childAt;
            }
        }
        return super.findViewByPosition(i5);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isLayoutReversed() {
        return this.mReverseLayout;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        boolean z5;
        View next = layoutState.next(recycler);
        if (next == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
        if (layoutState.mScrapList == null) {
            boolean z6 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z6 == z5) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            boolean z7 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z7 == z4) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i10 = getWidth() - getPaddingRight();
                i9 = i10 - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                i9 = getPaddingLeft();
                i10 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + i9;
            }
            if (layoutState.mLayoutDirection == -1) {
                i12 = layoutState.mOffset;
                i11 = i12 - layoutChunkResult.mConsumed;
            } else {
                i11 = layoutState.mOffset;
                i12 = layoutChunkResult.mConsumed + i11;
            }
            int i13 = i9;
            i8 = i11;
            i7 = i13;
            i6 = i12;
            i5 = i10;
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
            if (layoutState.mLayoutDirection == -1) {
                int i14 = layoutState.mOffset;
                i7 = i14 - layoutChunkResult.mConsumed;
                i5 = i14;
                i6 = decoratedMeasurementInOther;
            } else {
                int i15 = layoutState.mOffset;
                i5 = layoutChunkResult.mConsumed + i15;
                i6 = decoratedMeasurementInOther;
                i7 = i15;
            }
            i8 = paddingTop;
        }
        layoutDecoratedWithMargins(next, i7, i8, i5, i6);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i5) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i5)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.getTotalSpace()) * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
        layoutState.mRecycle = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        RecyclerView.Adapter adapter = this.mRecyclerView.mAdapter;
        if (adapter != null && adapter.getItemCount() > 0) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_TO_POSITION);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int fixLayoutEndGap;
        int i10;
        View findViewByPosition;
        int decoratedStart;
        int i11;
        int i12 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!anchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            anchorInfo.reset();
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo2);
            this.mAnchorInfo.mValid = true;
        } else if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
            this.mAnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
        }
        LayoutState layoutState = this.mLayoutState;
        if (layoutState.mLastScrollDelta >= 0) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        layoutState.mLayoutDirection = i5;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (!(!state.isPreLayout() || (i10 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i10)) == null)) {
            if (this.mShouldReverseLayout) {
                i11 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                i11 = this.mPendingScrollPositionOffset;
            }
            int i13 = i11 - decoratedStart;
            if (i13 > 0) {
                max += i13;
            } else {
                max2 -= i13;
            }
        }
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (!anchorInfo3.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i12 = 1;
        }
        onAnchorReady(recycler, state, anchorInfo3, i12);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo anchorInfo4 = this.mAnchorInfo;
        if (anchorInfo4.mLayoutFromEnd) {
            updateLayoutStateToFillStart(anchorInfo4);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mExtraFillSpace = max;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i7 = layoutState3.mOffset;
            int i14 = layoutState3.mCurrentPosition;
            int i15 = layoutState3.mAvailable;
            if (i15 > 0) {
                max2 += i15;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.mExtraFillSpace = max2;
            layoutState4.mCurrentPosition += layoutState4.mItemDirection;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i6 = layoutState5.mOffset;
            int i16 = layoutState5.mAvailable;
            if (i16 > 0) {
                updateLayoutStateToFillStart(i14, i7);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.mExtraFillSpace = i16;
                fill(recycler, layoutState6, state, false);
                i7 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo4);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.mExtraFillSpace = max2;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            i6 = layoutState8.mOffset;
            int i17 = layoutState8.mCurrentPosition;
            int i18 = layoutState8.mAvailable;
            if (i18 > 0) {
                max += i18;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.mExtraFillSpace = max;
            layoutState9.mCurrentPosition += layoutState9.mItemDirection;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            i7 = layoutState10.mOffset;
            int i19 = layoutState10.mAvailable;
            if (i19 > 0) {
                updateLayoutStateToFillEnd(i17, i6);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.mExtraFillSpace = i19;
                fill(recycler, layoutState11, state, false);
                i6 = this.mLayoutState.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i6, recycler, state, true);
                i8 = i7 + fixLayoutEndGap2;
                i9 = i6 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i8, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i7, recycler, state, true);
                i8 = i7 + fixLayoutStartGap;
                i9 = i6 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i9, recycler, state, false);
            }
            i7 = i8 + fixLayoutEndGap;
            i6 = i9 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, i7, i6);
        if (!state.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z4 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z4;
            if (z4) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
                return savedState;
            }
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            return savedState;
        }
        savedState.invalidateAnchor();
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public boolean performAccessibilityAction(int i5, @Nullable Bundle bundle) {
        int i6;
        if (super.performAccessibilityAction(i5, bundle)) {
            return true;
        }
        if (i5 == 16908343 && bundle != null) {
            if (this.mOrientation == 1) {
                int i7 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT, -1);
                if (i7 < 0) {
                    return false;
                }
                RecyclerView recyclerView = this.mRecyclerView;
                i6 = Math.min(i7, getRowCountForAccessibility(recyclerView.mRecycler, recyclerView.mState) - 1);
            } else {
                int i8 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT, -1);
                if (i8 < 0) {
                    return false;
                }
                RecyclerView recyclerView2 = this.mRecyclerView;
                i6 = Math.min(i8, getColumnCountForAccessibility(recyclerView2.mRecycler, recyclerView2.mState) - 1);
            }
            if (i6 >= 0) {
                scrollToPositionWithOffset(i6, 0);
                return true;
            }
        }
        return false;
    }

    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i5, int i6) {
        boolean z4;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (this.mShouldReverseLayout) {
            if (z4) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (z4) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i6;
        if (getChildCount() == 0 || i5 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (i5 > 0) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        int abs = Math.abs(i5);
        updateLayoutState(i6, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = layoutState.mScrollingOffset + fill(recycler, layoutState, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i5 = i6 * fill;
        }
        this.mOrientationHelper.offsetChildren(-i5);
        this.mLayoutState.mLastScrollDelta = i5;
        return i5;
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i5, recycler, state);
    }

    public void scrollToPosition(int i5) {
        this.mPendingScrollPosition = i5;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i5, int i6) {
        this.mPendingScrollPosition = i5;
        this.mPendingScrollPositionOffset = i6;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i5, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i5) {
        this.mInitialPrefetchItemCount = i5;
    }

    public void setOrientation(int i5) {
        if (i5 == 0 || i5 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i5 != this.mOrientation || this.mOrientationHelper == null) {
                OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i5);
                this.mOrientationHelper = createOrientationHelper;
                this.mAnchorInfo.mOrientationHelper = createOrientationHelper;
                this.mOrientation = i5;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i5);
    }

    public void setRecycleChildrenOnDetach(boolean z4) {
        this.mRecycleChildrenOnDetach = z4;
    }

    public void setReverseLayout(boolean z4) {
        assertNotInLayoutOrScroll((String) null);
        if (z4 != this.mReverseLayout) {
            this.mReverseLayout = z4;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z4) {
        this.mSmoothScrollbarEnabled = z4;
    }

    public void setStackFromEnd(boolean z4) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z4) {
            this.mStackFromEnd = z4;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i5) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i5);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z4 = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i5 = 1;
                while (i5 < getChildCount()) {
                    View childAt = getChildAt(i5);
                    int position2 = getPosition(childAt);
                    int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (decoratedStart2 >= decoratedStart) {
                            z4 = false;
                        }
                        sb.append(z4);
                        throw new RuntimeException(sb.toString());
                    } else if (decoratedStart2 <= decoratedStart) {
                        i5++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i6 = 1;
            while (i6 < getChildCount()) {
                View childAt2 = getChildAt(i6);
                int position3 = getPosition(childAt2);
                int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (decoratedStart3 >= decoratedStart) {
                        z4 = false;
                    }
                    sb2.append(z4);
                    throw new RuntimeException(sb2.toString());
                } else if (decoratedStart3 >= decoratedStart) {
                    i6++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i5, boolean z4) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i5);
        setReverseLayout(z4);
    }

    private void updateLayoutStateToFillEnd(int i5, int i6) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i6;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
        layoutState.mCurrentPosition = i5;
        layoutState.mLayoutDirection = 1;
        layoutState.mOffset = i6;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i5, int i6) {
        this.mLayoutState.mAvailable = i6 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i5;
        layoutState.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
        layoutState.mLayoutDirection = -1;
        layoutState.mOffset = i6;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i5, i6);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
