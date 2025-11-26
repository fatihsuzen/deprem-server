package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private final Runnable mCheckForGapsRunnable = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    };
    private int mFullSizeSpec;
    private int mGapStrategy = 2;
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    @NonNull
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private int[] mPrefetchDistances;
    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout = false;
    @NonNull
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout = false;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled = true;
    private int mSpanCount = -1;
    Span[] mSpans;
    private final Rect mTmpRect = new Rect();

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            Span span = this.mSpan;
            if (span == null) {
                return -1;
            }
            return span.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean z4) {
            this.mFullSpan = z4;
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
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
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z4 = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z4;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i5, i6);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i5 = this.mSpanCount - 1; i5 >= 0; i5--) {
            this.mSpans[i5].appendToSpan(view);
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        int startAfterPadding;
        SavedState savedState = this.mPendingSavedState;
        int i5 = savedState.mSpanOffsetsSize;
        if (i5 > 0) {
            if (i5 == this.mSpanCount) {
                for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                    this.mSpans[i6].clear();
                    SavedState savedState2 = this.mPendingSavedState;
                    int i7 = savedState2.mSpanOffsets[i6];
                    if (i7 != Integer.MIN_VALUE) {
                        if (savedState2.mAnchorLayoutFromEnd) {
                            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        }
                        i7 += startAfterPadding;
                    }
                    this.mSpans[i6].setLine(i7);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i8 = savedState5.mAnchorPosition;
        if (i8 != -1) {
            this.mPendingScrollPosition = i8;
            anchorInfo.mLayoutFromEnd = savedState5.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            lazySpanLookup.mData = savedState5.mSpanLookup;
            lazySpanLookup.mFullSpanItems = savedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.appendToSpan(view);
            }
        } else if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i5) {
        boolean z4;
        if (getChildCount() != 0) {
            if (i5 < getFirstChildPosition()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 != this.mShouldReverseLayout) {
                return -1;
            }
            return 1;
        } else if (this.mShouldReverseLayout) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean checkSpanForGap(Span span) {
        boolean z4;
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                ArrayList<View> arrayList = span.mViews;
                z4 = span.getLayoutParams(arrayList.get(arrayList.size() - 1)).mFullSpan;
            }
            return false;
        }
        if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            z4 = span.getLayoutParams(span.mViews.get(0)).mFullSpan;
        }
        return false;
        return !z4;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i5) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i5) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i6 = 0; i6 < this.mSpanCount; i6++) {
            fullSpanItem.mGapPerSpan[i6] = i5 - this.mSpans[i6].getEndLine(i5);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i5) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i6 = 0; i6 < this.mSpanCount; i6++) {
            fullSpanItem.mGapPerSpan[i6] = this.mSpans[i6].getStartLine(i5) - i5;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r8v3 */
    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i5;
        int startAfterPadding;
        int i6;
        boolean z4;
        Span span;
        int i7;
        int i8;
        int startAfterPadding2;
        int i9;
        int decoratedMeasurement;
        boolean areAllStartsEqual;
        int startLine;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this;
        RecyclerView.Recycler recycler2 = recycler;
        LayoutState layoutState2 = layoutState;
        ? r8 = 0;
        staggeredGridLayoutManager.mRemainingSpans.set(0, staggeredGridLayoutManager.mSpanCount, true);
        if (staggeredGridLayoutManager.mLayoutState.mInfinite) {
            if (layoutState2.mLayoutDirection == 1) {
                i5 = Integer.MAX_VALUE;
            } else {
                i5 = Integer.MIN_VALUE;
            }
        } else if (layoutState2.mLayoutDirection == 1) {
            i5 = layoutState2.mEndLine + layoutState2.mAvailable;
        } else {
            i5 = layoutState2.mStartLine - layoutState2.mAvailable;
        }
        int i10 = i5;
        staggeredGridLayoutManager.updateAllRemainingSpans(layoutState2.mLayoutDirection, i10);
        if (staggeredGridLayoutManager.mShouldReverseLayout) {
            startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
        } else {
            startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
        }
        int i11 = startAfterPadding;
        boolean z5 = false;
        while (layoutState.hasMore(state) && (staggeredGridLayoutManager.mLayoutState.mInfinite || !staggeredGridLayoutManager.mRemainingSpans.isEmpty())) {
            View next = layoutState2.next(recycler2);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int span2 = staggeredGridLayoutManager.mLazySpanLookup.getSpan(viewLayoutPosition);
            if (span2 == -1) {
                z4 = true;
            } else {
                z4 = r8;
            }
            if (z4) {
                if (layoutParams.mFullSpan) {
                    span = staggeredGridLayoutManager.mSpans[r8];
                } else {
                    span = staggeredGridLayoutManager.getNextSpan(layoutState2);
                }
                staggeredGridLayoutManager.mLazySpanLookup.setSpan(viewLayoutPosition, span);
            } else {
                span = staggeredGridLayoutManager.mSpans[span2];
            }
            Span span3 = span;
            layoutParams.mSpan = span3;
            if (layoutState2.mLayoutDirection == 1) {
                staggeredGridLayoutManager.addView(next);
            } else {
                staggeredGridLayoutManager.addView(next, r8);
            }
            staggeredGridLayoutManager.measureChildWithDecorationsAndMargin(next, layoutParams, r8);
            if (layoutState2.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    i8 = staggeredGridLayoutManager.getMaxEnd(i11);
                } else {
                    i8 = span3.getEndLine(i11);
                }
                i7 = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedMeasurement(next) + i8;
                if (z4 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = staggeredGridLayoutManager.createFullSpanItemFromEnd(i8);
                    createFullSpanItemFromEnd.mGapDir = -1;
                    createFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    staggeredGridLayoutManager.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                }
            } else {
                if (layoutParams.mFullSpan) {
                    startLine = staggeredGridLayoutManager.getMinStart(i11);
                } else {
                    startLine = span3.getStartLine(i11);
                }
                i7 = startLine;
                i8 = i7 - staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z4 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromStart = staggeredGridLayoutManager.createFullSpanItemFromStart(i7);
                    createFullSpanItemFromStart.mGapDir = 1;
                    createFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    staggeredGridLayoutManager.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromStart);
                }
            }
            if (layoutParams.mFullSpan && layoutState2.mItemDirection == -1) {
                if (z4) {
                    staggeredGridLayoutManager.mLaidOutInvalidFullSpan = true;
                } else {
                    if (layoutState2.mLayoutDirection == 1) {
                        areAllStartsEqual = staggeredGridLayoutManager.areAllEndsEqual();
                    } else {
                        areAllStartsEqual = staggeredGridLayoutManager.areAllStartsEqual();
                    }
                    if (!areAllStartsEqual) {
                        LazySpanLookup.FullSpanItem fullSpanItem = staggeredGridLayoutManager.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        staggeredGridLayoutManager.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            staggeredGridLayoutManager.attachViewToSpans(next, layoutParams, layoutState2);
            if (!staggeredGridLayoutManager.isLayoutRTL() || staggeredGridLayoutManager.mOrientation != 1) {
                if (layoutParams.mFullSpan) {
                    startAfterPadding2 = staggeredGridLayoutManager.mSecondaryOrientation.getStartAfterPadding();
                } else {
                    startAfterPadding2 = (span3.mIndex * staggeredGridLayoutManager.mSizePerSpan) + staggeredGridLayoutManager.mSecondaryOrientation.getStartAfterPadding();
                }
                i9 = startAfterPadding2;
                decoratedMeasurement = staggeredGridLayoutManager.mSecondaryOrientation.getDecoratedMeasurement(next) + i9;
            } else {
                if (layoutParams.mFullSpan) {
                    decoratedMeasurement = staggeredGridLayoutManager.mSecondaryOrientation.getEndAfterPadding();
                } else {
                    decoratedMeasurement = staggeredGridLayoutManager.mSecondaryOrientation.getEndAfterPadding() - (((staggeredGridLayoutManager.mSpanCount - 1) - span3.mIndex) * staggeredGridLayoutManager.mSizePerSpan);
                }
                i9 = decoratedMeasurement - staggeredGridLayoutManager.mSecondaryOrientation.getDecoratedMeasurement(next);
            }
            int i12 = decoratedMeasurement;
            int i13 = i9;
            if (staggeredGridLayoutManager.mOrientation == 1) {
                staggeredGridLayoutManager.layoutDecoratedWithMargins(next, i13, i8, i12, i7);
                staggeredGridLayoutManager = this;
            } else {
                staggeredGridLayoutManager.layoutDecoratedWithMargins(next, i8, i13, i7, i12);
            }
            if (layoutParams.mFullSpan) {
                staggeredGridLayoutManager.updateAllRemainingSpans(staggeredGridLayoutManager.mLayoutState.mLayoutDirection, i10);
            } else {
                staggeredGridLayoutManager.updateRemainingSpans(span3, staggeredGridLayoutManager.mLayoutState.mLayoutDirection, i10);
            }
            staggeredGridLayoutManager.recycle(recycler2, staggeredGridLayoutManager.mLayoutState);
            if (staggeredGridLayoutManager.mLayoutState.mStopInFocusable && next.hasFocusable()) {
                if (layoutParams.mFullSpan) {
                    staggeredGridLayoutManager.mRemainingSpans.clear();
                } else {
                    staggeredGridLayoutManager.mRemainingSpans.set(span3.mIndex, false);
                }
            }
            z5 = true;
            r8 = 0;
        }
        if (!z5) {
            staggeredGridLayoutManager.recycle(recycler2, staggeredGridLayoutManager.mLayoutState);
        }
        if (staggeredGridLayoutManager.mLayoutState.mLayoutDirection == -1) {
            i6 = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding() - staggeredGridLayoutManager.getMinStart(staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding());
        } else {
            i6 = staggeredGridLayoutManager.getMaxEnd(staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding()) - staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
        }
        if (i6 > 0) {
            return Math.min(layoutState2.mAvailable, i6);
        }
        return 0;
    }

    private int findFirstReferenceChildPosition(int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            int position = getPosition(getChildAt(i6));
            if (position >= 0 && position < i5) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i5) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i5) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i5 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z4 && i5 > 0) {
                this.mPrimaryOrientation.offsetChildren(i5);
            }
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z4 && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    private int getMaxEnd(int i5) {
        int endLine = this.mSpans[0].getEndLine(i5);
        for (int i6 = 1; i6 < this.mSpanCount; i6++) {
            int endLine2 = this.mSpans[i6].getEndLine(i5);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i5) {
        int startLine = this.mSpans[0].getStartLine(i5);
        for (int i6 = 1; i6 < this.mSpanCount; i6++) {
            int startLine2 = this.mSpans[i6].getStartLine(i5);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i5) {
        int endLine = this.mSpans[0].getEndLine(i5);
        for (int i6 = 1; i6 < this.mSpanCount; i6++) {
            int endLine2 = this.mSpans[i6].getEndLine(i5);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i5) {
        int startLine = this.mSpans[0].getStartLine(i5);
        for (int i6 = 1; i6 < this.mSpanCount; i6++) {
            int startLine2 = this.mSpans[i6].getStartLine(i5);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i5;
        int i6;
        int i7;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i7 = this.mSpanCount - 1;
            i6 = -1;
            i5 = -1;
        } else {
            i6 = this.mSpanCount;
            i7 = 0;
            i5 = 1;
        }
        Span span = null;
        if (layoutState.mLayoutDirection == 1) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int i8 = Integer.MAX_VALUE;
            while (i7 != i6) {
                Span span2 = this.mSpans[i7];
                int endLine = span2.getEndLine(startAfterPadding);
                if (endLine < i8) {
                    span = span2;
                    i8 = endLine;
                }
                i7 += i5;
            }
            return span;
        }
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int i9 = Integer.MIN_VALUE;
        while (i7 != i6) {
            Span span3 = this.mSpans[i7];
            int startLine = span3.getStartLine(endAfterPadding);
            if (startLine > i9) {
                span = span3;
                i9 = startLine;
            }
            i7 += i5;
        }
        return span;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleUpdate(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L_0x0009
            int r0 = r6.getLastChildPosition()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.getFirstChildPosition()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0017
            int r2 = r8 + 1
        L_0x0015:
            r3 = r7
            goto L_0x001e
        L_0x0017:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001e
        L_0x001b:
            int r2 = r7 + r8
            goto L_0x0015
        L_0x001e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.mLazySpanLookup
            r4.invalidateAfter(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003d
            r5 = 2
            if (r9 == r5) goto L_0x0037
            if (r9 == r1) goto L_0x002c
            goto L_0x0042
        L_0x002c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.offsetForAddition(r8, r4)
            goto L_0x0042
        L_0x0037:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForRemoval(r7, r8)
            goto L_0x0042
        L_0x003d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.offsetForAddition(r7, r8)
        L_0x0042:
            if (r2 > r0) goto L_0x0045
            goto L_0x0057
        L_0x0045:
            boolean r7 = r6.mShouldReverseLayout
            if (r7 == 0) goto L_0x004e
            int r7 = r6.getFirstChildPosition()
            goto L_0x0052
        L_0x004e:
            int r7 = r6.getLastChildPosition()
        L_0x0052:
            if (r3 > r7) goto L_0x0057
            r6.requestLayout()
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z4) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z4);
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.mFullSizeSpec, z4);
            }
        } else if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z4);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, layoutParams.height, false), z4);
        }
    }

    private boolean preferLastSpan(int i5) {
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.mOrientation == 0) {
            if (i5 == -1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6 != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (i5 == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 == this.mShouldReverseLayout) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    private void prependViewToAllSpans(View view) {
        for (int i5 = this.mSpanCount - 1; i5 >= 0; i5--) {
            this.mSpans[i5].prependToSpan(view);
        }
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int i5;
        int i6;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable == 0) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleFromEnd(recycler, layoutState.mEndLine);
                } else {
                    recycleFromStart(recycler, layoutState.mStartLine);
                }
            } else if (layoutState.mLayoutDirection == -1) {
                int i7 = layoutState.mStartLine;
                int maxStart = i7 - getMaxStart(i7);
                if (maxStart < 0) {
                    i6 = layoutState.mEndLine;
                } else {
                    i6 = layoutState.mEndLine - Math.min(maxStart, layoutState.mAvailable);
                }
                recycleFromEnd(recycler, i6);
            } else {
                int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
                if (minEnd < 0) {
                    i5 = layoutState.mStartLine;
                } else {
                    i5 = Math.min(minEnd, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(recycler, i5);
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i5) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i5 && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i5) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i6 = 0;
                    while (i6 < this.mSpanCount) {
                        if (this.mSpans[i6].mViews.size() != 1) {
                            i6++;
                        } else {
                            return;
                        }
                    }
                    for (int i7 = 0; i7 < this.mSpanCount; i7++) {
                        this.mSpans[i7].popEnd();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popEnd();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i5) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i5 && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i5) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i6 = 0;
                    while (i6 < this.mSpanCount) {
                        if (this.mSpans[i6].mViews.size() != 1) {
                            i6++;
                        } else {
                            return;
                        }
                    }
                    for (int i7 = 0; i7 < this.mSpanCount; i7++) {
                        this.mSpans[i7].popStart();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popStart();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            int childCount = getChildCount();
            float f5 = 0.0f;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                float decoratedMeasurement = (float) this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f5) {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        decoratedMeasurement = (decoratedMeasurement * 1.0f) / ((float) this.mSpanCount);
                    }
                    f5 = Math.max(f5, decoratedMeasurement);
                }
            }
            int i6 = this.mSizePerSpan;
            int round = Math.round(f5 * ((float) this.mSpanCount));
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            updateMeasureSpecs(round);
            if (this.mSizePerSpan != i6) {
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt2 = getChildAt(i7);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (!isLayoutRTL() || this.mOrientation != 1) {
                            int i8 = layoutParams.mSpan.mIndex;
                            int i9 = this.mSizePerSpan * i8;
                            int i10 = i8 * i6;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i9 - i10);
                            } else {
                                childAt2.offsetTopAndBottom(i9 - i10);
                            }
                        } else {
                            int i11 = this.mSpanCount;
                            int i12 = layoutParams.mSpan.mIndex;
                            childAt2.offsetLeftAndRight(((-((i11 - 1) - i12)) * this.mSizePerSpan) - ((-((i11 - 1) - i12)) * i6));
                        }
                    }
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

    private void setLayoutStateDirection(int i5) {
        boolean z4;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i5;
        boolean z5 = this.mShouldReverseLayout;
        int i6 = 1;
        if (i5 == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z5 != z4) {
            i6 = -1;
        }
        layoutState.mItemDirection = i6;
    }

    private void updateAllRemainingSpans(int i5, int i6) {
        for (int i7 = 0; i7 < this.mSpanCount; i7++) {
            if (!this.mSpans[i7].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i7], i5, i6);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i5;
        if (this.mLastLayoutFromEnd) {
            i5 = findLastReferenceChildPosition(state.getItemCount());
        } else {
            i5 = findFirstReferenceChildPosition(state.getItemCount());
        }
        anchorInfo.mPosition = i5;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    private void updateLayoutState(int i5, RecyclerView.State state) {
        int i6;
        int i7;
        int targetScrollPosition;
        boolean z4;
        LayoutState layoutState = this.mLayoutState;
        boolean z5 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i5;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i7 = 0;
            i6 = 0;
        } else {
            boolean z6 = this.mShouldReverseLayout;
            if (targetScrollPosition < i5) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z6 == z4) {
                i7 = this.mPrimaryOrientation.getTotalSpace();
                i6 = 0;
            } else {
                i6 = this.mPrimaryOrientation.getTotalSpace();
                i7 = 0;
            }
        }
        if (getClipToPadding()) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i6;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i7;
        } else {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i7;
            this.mLayoutState.mStartLine = -i6;
        }
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = false;
        layoutState2.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z5 = true;
        }
        layoutState2.mInfinite = z5;
    }

    private void updateRemainingSpans(Span span, int i5, int i6) {
        int deletedSize = span.getDeletedSize();
        if (i5 == -1) {
            if (span.getStartLine() + deletedSize <= i6) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine() - deletedSize >= i6) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int updateSpecWithExtra(int i5, int i6, int i7) {
        int mode;
        if ((i6 != 0 || i7 != 0) && ((mode = View.MeasureSpec.getMode(i5)) == Integer.MIN_VALUE || mode == 1073741824)) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i5) - i6) - i7), mode);
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i5 = 1; i5 < this.mSpanCount; i5++) {
            if (this.mSpans[i5].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i5 = 1; i5 < this.mSpanCount; i5++) {
            if (this.mSpans[i5].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
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

    /* access modifiers changed from: package-private */
    public boolean checkForGaps() {
        int i5;
        int i6;
        int i7;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            i6 = getLastChildPosition();
            i5 = getFirstChildPosition();
        } else {
            i6 = getFirstChildPosition();
            i5 = getLastChildPosition();
        }
        if (i6 == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return false;
        } else {
            if (this.mShouldReverseLayout) {
                i7 = -1;
            } else {
                i7 = 1;
            }
            int i8 = i5 + 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(i6, i8, i7, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.forceInvalidateAfter(i8);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(i6, firstFullSpanItemInRange.mPosition, i7 * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
            } else {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i5, int i6, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int endLine;
        int i7;
        if (this.mOrientation != 0) {
            i5 = i6;
        }
        if (getChildCount() != 0 && i5 != 0) {
            prepareLayoutStateForDelta(i5, state);
            int[] iArr = this.mPrefetchDistances;
            if (iArr == null || iArr.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.mSpanCount; i9++) {
                LayoutState layoutState = this.mLayoutState;
                if (layoutState.mItemDirection == -1) {
                    endLine = layoutState.mStartLine;
                    i7 = this.mSpans[i9].getStartLine(endLine);
                } else {
                    endLine = this.mSpans[i9].getEndLine(layoutState.mEndLine);
                    i7 = this.mLayoutState.mEndLine;
                }
                int i10 = endLine - i7;
                if (i10 >= 0) {
                    this.mPrefetchDistances[i8] = i10;
                    i8++;
                }
            }
            Arrays.sort(this.mPrefetchDistances, 0, i8);
            for (int i11 = 0; i11 < i8 && this.mLayoutState.hasMore(state); i11++) {
                layoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i11]);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mCurrentPosition += layoutState2.mItemDirection;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public PointF computeScrollVectorForPosition(int i5) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i5);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = (float) calculateScrollDirectionForPosition;
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            iArr[i5] = this.mSpans[i5].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleItemClosestToEnd(boolean z4) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z4) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleItemClosestToStart(boolean z4) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z4) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public int findFirstVisibleItemPositionInt() {
        View view;
        if (this.mShouldReverseLayout) {
            view = findFirstVisibleItemClosestToEnd(true);
        } else {
            view = findFirstVisibleItemClosestToStart(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            iArr[i5] = this.mSpans[i5].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            iArr[i5] = this.mSpans[i5].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            iArr[i5] = this.mSpans[i5].findLastVisibleItemPosition();
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, state.getItemCount());
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    /* access modifiers changed from: package-private */
    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getRowCountForAccessibility(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, state.getItemCount());
        }
        return -1;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* access modifiers changed from: package-private */
    public View hasGapsToFix() {
        char c5;
        int i5;
        boolean z4;
        boolean z5;
        int childCount = getChildCount();
        int i6 = childCount - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        int i7 = -1;
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            c5 = 65535;
        } else {
            c5 = 1;
        }
        if (this.mShouldReverseLayout) {
            childCount = -1;
        } else {
            i6 = 0;
        }
        if (i6 < childCount) {
            i7 = 1;
        }
        while (i6 != childCount) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.mIndex)) {
                if (checkSpanForGap(layoutParams.mSpan)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.mSpan.mIndex);
            }
            if (!layoutParams.mFullSpan && (i5 = i6 + i7) != childCount) {
                View childAt2 = getChildAt(i5);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd != decoratedEnd2) {
                        continue;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart != decoratedStart2) {
                        continue;
                    }
                }
                if (layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (c5 < 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 != z5) {
                    return childAt;
                }
            }
            i6 += i7;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isLayoutReversed() {
        return this.mReverseLayout;
    }

    public void offsetChildrenHorizontal(int i5) {
        super.offsetChildrenHorizontal(i5);
        for (int i6 = 0; i6 < this.mSpanCount; i6++) {
            this.mSpans[i6].onOffset(i5);
        }
    }

    public void offsetChildrenVertical(int i5) {
        super.offsetChildrenVertical(i5);
        for (int i6 = 0; i6 < this.mSpanCount; i6++) {
            this.mSpans[i6].onOffset(i5);
        }
    }

    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.clear();
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            this.mSpans[i5].clear();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            this.mSpans[i5].clear();
        }
        recyclerView.requestLayout();
    }

    @Nullable
    public View onFocusSearchFailed(View view, int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i6;
        boolean z4;
        boolean z5;
        int i7;
        int i8;
        int i9;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i5);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z6 = layoutParams.mFullSpan;
        Span span = layoutParams.mSpan;
        if (convertFocusDirectionToLayoutDirection == 1) {
            i6 = getLastChildPosition();
        } else {
            i6 = getFirstChildPosition();
        }
        updateLayoutState(i6, state);
        setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + i6;
        layoutState.mAvailable = (int) (((float) this.mPrimaryOrientation.getTotalSpace()) * MAX_SCROLL_FACTOR);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = true;
        layoutState2.mRecycle = false;
        fill(recycler, layoutState2, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z6 && (focusableViewAfter = span.getFocusableViewAfter(i6, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i10 = this.mSpanCount - 1; i10 >= 0; i10--) {
                View focusableViewAfter2 = this.mSpans[i10].getFocusableViewAfter(i6, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                View focusableViewAfter3 = this.mSpans[i11].getFocusableViewAfter(i6, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z7 = !this.mReverseLayout;
        if (convertFocusDirectionToLayoutDirection == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z7 == z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z6) {
            if (z5) {
                i9 = span.findFirstPartiallyVisibleItemPosition();
            } else {
                i9 = span.findLastPartiallyVisibleItemPosition();
            }
            View findViewByPosition = findViewByPosition(i9);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i12 = this.mSpanCount - 1; i12 >= 0; i12--) {
                if (i12 != span.mIndex) {
                    if (z5) {
                        i8 = this.mSpans[i12].findFirstPartiallyVisibleItemPosition();
                    } else {
                        i8 = this.mSpans[i12].findLastPartiallyVisibleItemPosition();
                    }
                    View findViewByPosition2 = findViewByPosition(i8);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                if (z5) {
                    i7 = this.mSpans[i13].findFirstPartiallyVisibleItemPosition();
                } else {
                    i7 = this.mSpans[i13].findLastPartiallyVisibleItemPosition();
                }
                View findViewByPosition3 = findViewByPosition(i7);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i5 = 1;
        if (this.mOrientation == 0) {
            int spanIndex = layoutParams2.getSpanIndex();
            if (layoutParams2.mFullSpan) {
                i5 = this.mSpanCount;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanIndex, i5, -1, -1, false, false));
            return;
        }
        int spanIndex2 = layoutParams2.getSpanIndex();
        if (layoutParams2.mFullSpan) {
            i5 = this.mSpanCount;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, spanIndex2, i5, false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i5, int i6) {
        handleUpdate(i5, i6, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i5, int i6, int i7) {
        handleUpdate(i5, i6, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i5, int i6) {
        handleUpdate(i5, i6, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i5, int i6, Object obj) {
        handleUpdate(i5, i6, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.mPendingSavedState.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i5;
        int i6;
        int startAfterPadding;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.mData) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                i5 = getLastChildPosition();
            } else {
                i5 = getFirstChildPosition();
            }
            savedState.mAnchorPosition = i5;
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            int i7 = this.mSpanCount;
            savedState.mSpanOffsetsSize = i7;
            savedState.mSpanOffsets = new int[i7];
            for (int i8 = 0; i8 < this.mSpanCount; i8++) {
                if (this.mLastLayoutFromEnd) {
                    i6 = this.mSpans[i8].getEndLine(Integer.MIN_VALUE);
                    if (i6 != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                    } else {
                        savedState.mSpanOffsets[i8] = i6;
                    }
                } else {
                    i6 = this.mSpans[i8].getStartLine(Integer.MIN_VALUE);
                    if (i6 != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                    } else {
                        savedState.mSpanOffsets[i8] = i6;
                    }
                }
                i6 -= startAfterPadding;
                savedState.mSpanOffsets[i8] = i6;
            }
            return savedState;
        }
        savedState.mAnchorPosition = -1;
        savedState.mVisibleAnchorPosition = -1;
        savedState.mSpanOffsetsSize = 0;
        return savedState;
    }

    public void onScrollStateChanged(int i5) {
        if (i5 == 0) {
            checkForGaps();
        }
    }

    /* access modifiers changed from: package-private */
    public void prepareLayoutStateForDelta(int i5, RecyclerView.State state) {
        int i6;
        int i7;
        if (i5 > 0) {
            i7 = getLastChildPosition();
            i6 = 1;
        } else {
            i7 = getFirstChildPosition();
            i6 = -1;
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(i7, state);
        setLayoutStateDirection(i6);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i7 + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i5);
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i5 == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i5, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= fill) {
            if (i5 < 0) {
                i5 = -fill;
            } else {
                i5 = fill;
            }
        }
        this.mPrimaryOrientation.offsetChildren(-i5);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i5;
    }

    public int scrollHorizontallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i5, recycler, state);
    }

    public void scrollToPosition(int i5) {
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mAnchorPosition == i5)) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i5;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i5, int i6) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i5;
        this.mPendingScrollPositionOffset = i6;
        requestLayout();
    }

    public int scrollVerticallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i5, recycler, state);
    }

    public void setGapStrategy(int i5) {
        assertNotInLayoutOrScroll((String) null);
        if (i5 != this.mGapStrategy) {
            if (i5 == 0 || i5 == 2) {
                this.mGapStrategy = i5;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void setMeasuredDimension(Rect rect, int i5, int i6) {
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i8 = RecyclerView.LayoutManager.chooseSize(i6, rect.height() + paddingTop, getMinimumHeight());
            i7 = RecyclerView.LayoutManager.chooseSize(i5, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            i7 = RecyclerView.LayoutManager.chooseSize(i5, rect.width() + paddingLeft, getMinimumWidth());
            i8 = RecyclerView.LayoutManager.chooseSize(i6, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i7, i8);
    }

    public void setOrientation(int i5) {
        if (i5 == 0 || i5 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i5 != this.mOrientation) {
                this.mOrientation = i5;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z4) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mReverseLayout == z4)) {
            savedState.mReverseLayout = z4;
        }
        this.mReverseLayout = z4;
        requestLayout();
    }

    public void setSpanCount(int i5) {
        assertNotInLayoutOrScroll((String) null);
        if (i5 != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i5;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                this.mSpans[i6] = new Span(i6);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i5) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i5);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i5;
        int i6;
        int i7;
        boolean z4 = false;
        if (!state.isPreLayout() && (i5 = this.mPendingScrollPosition) != -1) {
            if (i5 < 0 || i5 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.mPendingSavedState;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mShouldReverseLayout) {
                            i6 = getLastChildPosition();
                        } else {
                            i6 = getFirstChildPosition();
                        }
                        anchorInfo.mPosition = i6;
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (anchorInfo.mLayoutFromEnd) {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            } else {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            if (anchorInfo.mLayoutFromEnd) {
                                i7 = this.mPrimaryOrientation.getEndAfterPadding();
                            } else {
                                i7 = this.mPrimaryOrientation.getStartAfterPadding();
                            }
                            anchorInfo.mOffset = i7;
                            return true;
                        } else {
                            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                            if (decoratedStart < 0) {
                                anchorInfo.mOffset = -decoratedStart;
                                return true;
                            }
                            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            if (endAfterPadding < 0) {
                                anchorInfo.mOffset = endAfterPadding;
                                return true;
                            }
                            anchorInfo.mOffset = Integer.MIN_VALUE;
                        }
                    } else {
                        int i8 = this.mPendingScrollPosition;
                        anchorInfo.mPosition = i8;
                        int i9 = this.mPendingScrollPositionOffset;
                        if (i9 == Integer.MIN_VALUE) {
                            if (calculateScrollDirectionForPosition(i8) == 1) {
                                z4 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z4;
                            anchorInfo.assignCoordinateFromPadding();
                        } else {
                            anchorInfo.assignCoordinateFromPadding(i9);
                        }
                        anchorInfo.mInvalidateOffsets = true;
                    }
                } else {
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateMeasureSpecs(int i5) {
        this.mSizePerSpan = i5 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i5, this.mSecondaryOrientation.getMode());
    }

    class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        /* access modifiers changed from: package-private */
        public void assignCoordinateFromPadding() {
            int i5;
            if (this.mLayoutFromEnd) {
                i5 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                i5 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = i5;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void saveSpanReferenceLines(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr == null || iArr.length < length) {
                this.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i5 = 0; i5 < length; i5++) {
                this.mSpanReferenceLines[i5] = spanArr[i5].getStartLine(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void assignCoordinateFromPadding(int i5) {
            if (this.mLayoutFromEnd) {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i5;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i5;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0152, code lost:
        if (checkForGaps() != false) goto L_0x0156;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.mPendingSavedState
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.mPendingScrollPosition
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.getItemCount()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.reset()
            return
        L_0x0018:
            boolean r1 = r0.mValid
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.mPendingScrollPosition
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.mPendingSavedState
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.reset()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 == 0) goto L_0x0037
            r8.applyPendingSavedState(r0)
            goto L_0x003e
        L_0x0037:
            r8.resolveShouldLayoutReverse()
            boolean r5 = r8.mShouldReverseLayout
            r0.mLayoutFromEnd = r5
        L_0x003e:
            r8.updateAnchorInfoForLayout(r10, r0)
            r0.mValid = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 != 0) goto L_0x0060
            int r5 = r8.mPendingScrollPosition
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.mLayoutFromEnd
            boolean r6 = r8.mLastLayoutFromEnd
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.mLastLayoutRTL
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.mLazySpanLookup
            r5.clear()
            r0.mInvalidateOffsets = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 == 0) goto L_0x006e
            int r5 = r5.mSpanOffsetsSize
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.mInvalidateOffsets
            if (r5 == 0) goto L_0x008e
            r1 = r3
        L_0x0073:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r5 = r5[r1]
            r5.clear()
            int r5 = r0.mOffset
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r6 = r8.mSpans
            r6 = r6[r1]
            r6.setLine(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.mAnchorInfo
            int[] r1 = r1.mSpanReferenceLines
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r5 = r5[r1]
            r5.clear()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r6 = r8.mAnchorInfo
            int[] r6 = r6.mSpanReferenceLines
            r6 = r6[r1]
            r5.setLine(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = r3
        L_0x00b0:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r5 = r5[r1]
            boolean r6 = r8.mShouldReverseLayout
            int r7 = r0.mOffset
            r5.cacheReferenceLineAndClear(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.mSpans
            r1.saveSpanReferenceLines(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            r1.mRecycle = r3
            r8.mLaidOutInvalidFullSpan = r3
            androidx.recyclerview.widget.OrientationHelper r1 = r8.mSecondaryOrientation
            int r1 = r1.getTotalSpace()
            r8.updateMeasureSpecs(r1)
            int r1 = r0.mPosition
            r8.updateLayoutState(r1, r10)
            boolean r1 = r0.mLayoutFromEnd
            if (r1 == 0) goto L_0x00fc
            r8.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            r8.fill(r9, r1, r10)
            r8.setLayoutStateDirection(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            int r2 = r0.mPosition
            int r5 = r1.mItemDirection
            int r2 = r2 + r5
            r1.mCurrentPosition = r2
            r8.fill(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.setLayoutStateDirection(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            r8.fill(r9, r1, r10)
            r8.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.mLayoutState
            int r2 = r0.mPosition
            int r5 = r1.mItemDirection
            int r2 = r2 + r5
            r1.mCurrentPosition = r2
            r8.fill(r9, r1, r10)
        L_0x0113:
            r8.repositionToWrapContentIfNecessary()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.mShouldReverseLayout
            if (r1 == 0) goto L_0x0127
            r8.fixEndGap(r9, r10, r4)
            r8.fixStartGap(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.fixStartGap(r9, r10, r4)
            r8.fixEndGap(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x0155
            boolean r11 = r10.isPreLayout()
            if (r11 != 0) goto L_0x0155
            int r11 = r8.mGapStrategy
            if (r11 == 0) goto L_0x0155
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x0155
            boolean r11 = r8.mLaidOutInvalidFullSpan
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.hasGapsToFix()
            if (r11 == 0) goto L_0x0155
        L_0x0149:
            java.lang.Runnable r11 = r8.mCheckForGapsRunnable
            r8.removeCallbacks(r11)
            boolean r11 = r8.checkForGaps()
            if (r11 == 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r4 = r3
        L_0x0156:
            boolean r11 = r10.isPreLayout()
            if (r11 == 0) goto L_0x0161
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.mAnchorInfo
            r11.reset()
        L_0x0161:
            boolean r11 = r0.mLayoutFromEnd
            r8.mLastLayoutFromEnd = r11
            boolean r11 = r8.isLayoutRTL()
            r8.mLastLayoutRTL = r11
            if (r4 == 0) goto L_0x0175
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.mAnchorInfo
            r11.reset()
            r8.onLayoutChildren(r9, r10, r3)
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd = Integer.MIN_VALUE;
        int mCachedStart = Integer.MIN_VALUE;
        int mDeletedSize = 0;
        final int mIndex;
        ArrayList<View> mViews = new ArrayList<>();

        Span(int i5) {
            this.mIndex = i5;
        }

        /* access modifiers changed from: package-private */
        public void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void cacheReferenceLineAndClear(boolean z4, int i5) {
            int i6;
            if (z4) {
                i6 = getEndLine(Integer.MIN_VALUE);
            } else {
                i6 = getStartLine(Integer.MIN_VALUE);
            }
            clear();
            if (i6 != Integer.MIN_VALUE) {
                if (z4 && i6 < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                    return;
                }
                if (z4 || i6 <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i5 != Integer.MIN_VALUE) {
                        i6 += i5;
                    }
                    this.mCachedEnd = i6;
                    this.mCachedStart = i6;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.mViews;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        /* access modifiers changed from: package-private */
        public void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, false);
            }
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), true);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
            }
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), false);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        /* access modifiers changed from: package-private */
        public int findOnePartiallyOrCompletelyVisibleChild(int i5, int i6, boolean z4, boolean z5, boolean z6) {
            int i7;
            boolean z7;
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            if (i6 > i5) {
                i7 = 1;
            } else {
                i7 = -1;
            }
            while (i5 != i6) {
                View view = this.mViews.get(i5);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z8 = false;
                if (!z6 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (!z6 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z8 = true;
                }
                if (z7 && z8) {
                    if (!z4 || !z5) {
                        if (z5) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i5 += i7;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int findOnePartiallyVisibleChild(int i5, int i6, boolean z4) {
            return findOnePartiallyOrCompletelyVisibleChild(i5, i6, false, false, z4);
        }

        /* access modifiers changed from: package-private */
        public int findOneVisibleChild(int i5, int i6, boolean z4) {
            return findOnePartiallyOrCompletelyVisibleChild(i5, i6, z4, true, false);
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        /* access modifiers changed from: package-private */
        public int getEndLine(int i5) {
            int i6 = this.mCachedEnd;
            if (i6 != Integer.MIN_VALUE) {
                return i6;
            }
            if (this.mViews.size() == 0) {
                return i5;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int i5, int i6) {
            View view = null;
            if (i6 == -1) {
                int size = this.mViews.size();
                int i7 = 0;
                while (i7 < size) {
                    View view2 = this.mViews.get(i7);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) <= i5) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) >= i5) || !view2.hasFocusable()) {
                        break;
                    }
                    i7++;
                    view = view2;
                }
                return view;
            }
            int size2 = this.mViews.size() - 1;
            while (size2 >= 0) {
                View view3 = this.mViews.get(size2);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) >= i5) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) <= i5) || !view3.hasFocusable()) {
                    break;
                }
                size2--;
                view = view3;
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int getStartLine(int i5) {
            int i6 = this.mCachedStart;
            if (i6 != Integer.MIN_VALUE) {
                return i6;
            }
            if (this.mViews.size() == 0) {
                return i5;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        /* access modifiers changed from: package-private */
        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void onOffset(int i5) {
            int i6 = this.mCachedStart;
            if (i6 != Integer.MIN_VALUE) {
                this.mCachedStart = i6 + i5;
            }
            int i7 = this.mCachedEnd;
            if (i7 != Integer.MIN_VALUE) {
                this.mCachedEnd = i7 + i5;
            }
        }

        /* access modifiers changed from: package-private */
        public void popEnd() {
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void popStart() {
            View remove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void setLine(int i5) {
            this.mCachedStart = i5;
            this.mCachedEnd = i5;
        }

        /* access modifiers changed from: package-private */
        public int getEndLine() {
            int i5 = this.mCachedEnd;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        /* access modifiers changed from: package-private */
        public int getStartLine() {
            int i5 = this.mCachedStart;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }
    }

    static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        LazySpanLookup() {
        }

        private int invalidateFullSpansAfter(int i5) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i5);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    i6 = -1;
                    break;
                } else if (this.mFullSpanItems.get(i6).mPosition >= i5) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 == -1) {
                return -1;
            }
            this.mFullSpanItems.remove(i6);
            return this.mFullSpanItems.get(i6).mPosition;
        }

        private void offsetFullSpansForAddition(int i5, int i6) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    int i7 = fullSpanItem.mPosition;
                    if (i7 >= i5) {
                        fullSpanItem.mPosition = i7 + i6;
                    }
                }
            }
        }

        private void offsetFullSpansForRemoval(int i5, int i6) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                int i7 = i5 + i6;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    int i8 = fullSpanItem.mPosition;
                    if (i8 >= i5) {
                        if (i8 < i7) {
                            this.mFullSpanItems.remove(size);
                        } else {
                            fullSpanItem.mPosition = i8 - i6;
                        }
                    }
                }
            }
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i5);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i5);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i5, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mFullSpanItems = null;
        }

        /* access modifiers changed from: package-private */
        public void ensureSize(int i5) {
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i5, 10) + 1)];
                this.mData = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i5 >= iArr.length) {
                int[] iArr3 = new int[sizeForPosition(i5)];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int forceInvalidateAfter(int i5) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i5) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i5);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i5, int i6, int i7, boolean z4) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i8);
                int i9 = fullSpanItem.mPosition;
                if (i9 >= i6) {
                    return null;
                }
                if (i9 >= i5 && (i7 == 0 || fullSpanItem.mGapDir == i7 || (z4 && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i5) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i5) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getSpan(int i5) {
            int[] iArr = this.mData;
            if (iArr == null || i5 >= iArr.length) {
                return -1;
            }
            return iArr[i5];
        }

        /* access modifiers changed from: package-private */
        public int invalidateAfter(int i5) {
            int[] iArr = this.mData;
            if (iArr == null || i5 >= iArr.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i5);
            if (invalidateFullSpansAfter == -1) {
                int[] iArr2 = this.mData;
                Arrays.fill(iArr2, i5, iArr2.length, -1);
                return this.mData.length;
            }
            int min = Math.min(invalidateFullSpansAfter + 1, this.mData.length);
            Arrays.fill(this.mData, i5, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void offsetForAddition(int i5, int i6) {
            int[] iArr = this.mData;
            if (iArr != null && i5 < iArr.length) {
                int i7 = i5 + i6;
                ensureSize(i7);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i5, iArr2, i7, (iArr2.length - i5) - i6);
                Arrays.fill(this.mData, i5, i7, -1);
                offsetFullSpansForAddition(i5, i6);
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetForRemoval(int i5, int i6) {
            int[] iArr = this.mData;
            if (iArr != null && i5 < iArr.length) {
                int i7 = i5 + i6;
                ensureSize(i7);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i7, iArr2, i5, (iArr2.length - i5) - i6);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i6, iArr3.length, -1);
                offsetFullSpansForRemoval(i5, i6);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSpan(int i5, Span span) {
            ensureSize(i5);
            this.mData[i5] = span.mIndex;
        }

        /* access modifiers changed from: package-private */
        public int sizeForPosition(int i5) {
            int length = this.mData.length;
            while (length <= i5) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] newArray(int i5) {
                    return new FullSpanItem[i5];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            /* access modifiers changed from: package-private */
            public int getGapForSpan(int i5) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i5];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            public void writeToParcel(Parcel parcel, int i5) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i5, int i6) {
        this.mOrientation = i6;
        setSpanCount(i5);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View view, int i5, int i6, boolean z4) {
        boolean z5;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i7 = layoutParams.leftMargin;
        Rect rect = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i5, i7 + rect.left, layoutParams.rightMargin + rect.right);
        int i8 = layoutParams.topMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i6, i8 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z4) {
            z5 = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            z5 = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (z5) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }
}
