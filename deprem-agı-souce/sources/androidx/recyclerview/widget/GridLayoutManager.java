package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "GridLayoutManager";
    private static final Set<Integer> sSupportedDirectionsForActionScrollInDirection = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{17, 66, 33, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS)})));
    int[] mCachedBorders;
    int mColumnWithAccessibilityFocus = -1;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    private int mPositionTargetedByScrollInDirection = -1;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    int mRowWithAccessibilityFocus = -1;
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        static boolean isAccessibilityFocused(@NonNull View view) {
            return view.isAccessibilityFocused();
        }
    }

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i5, int i6) {
            return i5 % i6;
        }

        public int getSpanSize(int i5) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i5) {
            int size = sparseIntArray.size() - 1;
            int i6 = 0;
            while (i6 <= size) {
                int i7 = (i6 + size) >>> 1;
                if (sparseIntArray.keyAt(i7) < i5) {
                    i6 = i7 + 1;
                } else {
                    size = i7 - 1;
                }
            }
            int i8 = i6 - 1;
            if (i8 < 0 || i8 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i8);
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanGroupIndex(int i5, int i6) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i5, i6);
            }
            int i7 = this.mSpanGroupIndexCache.get(i5, -1);
            if (i7 != -1) {
                return i7;
            }
            int spanGroupIndex = getSpanGroupIndex(i5, i6);
            this.mSpanGroupIndexCache.put(i5, spanGroupIndex);
            return spanGroupIndex;
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanIndex(int i5, int i6) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i5, i6);
            }
            int i7 = this.mSpanIndexCache.get(i5, -1);
            if (i7 != -1) {
                return i7;
            }
            int spanIndex = getSpanIndex(i5, i6);
            this.mSpanIndexCache.put(i5, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i5, int i6) {
            int i7;
            int i8;
            int i9;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i5)) == -1) {
                i9 = 0;
                i8 = 0;
                i7 = 0;
            } else {
                i9 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i8 = findFirstKeyLessThan + 1;
                i7 = getCachedSpanIndex(findFirstKeyLessThan, i6) + getSpanSize(findFirstKeyLessThan);
                if (i7 == i6) {
                    i9++;
                    i7 = 0;
                }
            }
            int spanSize = getSpanSize(i5);
            while (i8 < i5) {
                int spanSize2 = getSpanSize(i8);
                int i10 = i7 + spanSize2;
                if (i10 == i6) {
                    i9++;
                    i10 = 0;
                } else if (i10 > i6) {
                    i9++;
                    i10 = spanSize2;
                }
                i8++;
            }
            if (i7 + spanSize > i6) {
                return i9 + 1;
            }
            return i9;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = r1
                r3 = r2
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = r1
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i5);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z4) {
            if (!z4) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z4;
        }

        public void setSpanIndexCacheEnabled(boolean z4) {
            if (!z4) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z4;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i5, i6).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i5, boolean z4) {
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        if (z4) {
            i8 = 1;
            i6 = i5;
            i7 = 0;
        } else {
            i7 = i5 - 1;
            i6 = -1;
            i8 = -1;
        }
        while (i7 != i6) {
            View view = this.mSet[i7];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i9;
            i9 += spanSize;
            i7 += i8;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i5) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i5);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        int i5;
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i5 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i5 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i5;
                }
                return Math.round((((float) i5) * (((float) Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) decoratedEnd) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i5) {
        boolean z4;
        if (i5 == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z4) {
            while (spanIndex > 0) {
                int i6 = anchorInfo.mPosition;
                if (i6 > 0) {
                    int i7 = i6 - 1;
                    anchorInfo.mPosition = i7;
                    spanIndex = getSpanIndex(recycler, state, i7);
                } else {
                    return;
                }
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i8 = anchorInfo.mPosition;
        while (i8 < itemCount) {
            int i9 = i8 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i9);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i8 = i9;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i8;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    @Nullable
    private View findChildWithAccessibilityFocus() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            Objects.requireNonNull(childAt);
            if (Api21Impl.isAccessibilityFocused(childAt)) {
                return getChildAt(i5);
            }
        }
        return null;
    }

    private int findScrollTargetPositionAbove(int i5, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            int rowIndex = getRowIndex(i8);
            int columnIndex = getColumnIndex(i8);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if (rowIndex < i5 && getColumnIndices(i8).contains(Integer.valueOf(i6))) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i8;
                }
            } else if (rowIndex < i5 && columnIndex == i6) {
                this.mRowWithAccessibilityFocus = ((Integer) Collections.max(getRowIndices(i8))).intValue();
                return i8;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionBelow(int i5, int i6, int i7) {
        for (int i8 = i7 + 1; i8 < getItemCount(); i8++) {
            int rowIndex = getRowIndex(i8);
            int columnIndex = getColumnIndex(i8);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if (rowIndex > i5 && (columnIndex == i6 || getColumnIndices(i8).contains(Integer.valueOf(i6)))) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i8;
                }
            } else if (rowIndex > i5 && columnIndex == i6) {
                this.mRowWithAccessibilityFocus = getRowIndex(i8);
                return i8;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheLeft(int i5, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            int rowIndex = getRowIndex(i8);
            int columnIndex = getColumnIndex(i8);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i5 && columnIndex < i6) || rowIndex < i5) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i8;
                }
            } else if (getRowIndices(i8).contains(Integer.valueOf(i5)) && columnIndex < i6) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i8;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheRight(int i5, int i6, int i7) {
        for (int i8 = i7 + 1; i8 < getItemCount(); i8++) {
            int rowIndex = getRowIndex(i8);
            int columnIndex = getColumnIndex(i8);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i5 && columnIndex > i6) || rowIndex > i5) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i8;
                }
            } else if (columnIndex > i6 && getRowIndices(i8).contains(Integer.valueOf(i5))) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i8;
            }
        }
        return -1;
    }

    private int getColumnIndex(int i5) {
        if (this.mOrientation == 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            return getSpanGroupIndex(recyclerView.mRecycler, recyclerView.mState, i5);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        return getSpanIndex(recyclerView2.mRecycler, recyclerView2.mState, i5);
    }

    private Set<Integer> getColumnIndices(int i5) {
        return getRowOrColumnIndices(getColumnIndex(i5), i5);
    }

    private int getRowIndex(int i5) {
        if (this.mOrientation == 1) {
            RecyclerView recyclerView = this.mRecyclerView;
            return getSpanGroupIndex(recyclerView.mRecycler, recyclerView.mState, i5);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        return getSpanIndex(recyclerView2.mRecycler, recyclerView2.mState, i5);
    }

    private Set<Integer> getRowIndices(int i5) {
        return getRowOrColumnIndices(getRowIndex(i5), i5);
    }

    private Set<Integer> getRowOrColumnIndices(int i5, int i6) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.mRecyclerView;
        int spanSize = getSpanSize(recyclerView.mRecycler, recyclerView.mState, i6);
        for (int i7 = i5; i7 < i5 + spanSize; i7++) {
            hashSet.add(Integer.valueOf(i7));
        }
        return hashSet;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i5) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i5, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i5);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i5);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i5) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i5, this.mSpanCount);
        }
        int i6 = this.mPreLayoutSpanIndexCache.get(i5, -1);
        if (i6 != -1) {
            return i6;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i5);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i5);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i5) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i5);
        }
        int i6 = this.mPreLayoutSpanSizeCache.get(i5, -1);
        if (i6 != -1) {
            return i6;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i5);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i5);
        return 1;
    }

    private void guessMeasurement(float f5, int i5) {
        calculateItemBorders(Math.max(Math.round(f5 * ((float) this.mSpanCount)), i5));
    }

    private boolean hasAccessibilityFocusChanged(int i5) {
        if (!getRowIndices(i5).contains(Integer.valueOf(this.mRowWithAccessibilityFocus)) || !getColumnIndices(i5).contains(Integer.valueOf(this.mColumnWithAccessibilityFocus))) {
            return true;
        }
        return false;
    }

    private void measureChild(View view, int i5, boolean z4) {
        int i6;
        int i7;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i8 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i9 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i6 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i5, i9, layoutParams.width, false);
            i7 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i8, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i5, i8, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i9, layoutParams.width, true);
            i7 = childMeasureSpec;
            i6 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i6, i7, z4);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i5, int i6, boolean z4) {
        boolean z5;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z4) {
            z5 = shouldReMeasureChild(view, i5, i6, layoutParams);
        } else {
            z5 = shouldMeasureChild(view, i5, i6, layoutParams);
        }
        if (z5) {
            view.measure(i5, i6);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i5 = this.mSpanCount;
        for (int i6 = 0; i6 < this.mSpanCount && layoutState.hasMore(state) && i5 > 0; i6++) {
            int i7 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i7, Math.max(0, layoutState.mScrollingOffset));
            i5 -= this.mSpanSizeLookup.getSpanSize(i7);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public int findPositionOfFirstItemOnARowBelowForHorizontalGrid(int i5) {
        if (i5 < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap();
        for (int i6 = 0; i6 < getItemCount(); i6++) {
            for (Integer next : getRowIndices(i6)) {
                if (next.intValue() < 0) {
                    return -1;
                }
                if (!treeMap.containsKey(next)) {
                    treeMap.put(next, Integer.valueOf(i6));
                }
            }
        }
        for (Integer num : treeMap.keySet()) {
            int intValue = num.intValue();
            if (intValue > i5) {
                int intValue2 = ((Integer) treeMap.get(num)).intValue();
                this.mRowWithAccessibilityFocus = intValue;
                this.mColumnWithAccessibilityFocus = 0;
                return intValue2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int findPositionOfLastItemOnARowAboveForHorizontalGrid(int i5) {
        if (i5 < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        for (int i6 = 0; i6 < getItemCount(); i6++) {
            for (Integer next : getRowIndices(i6)) {
                if (next.intValue() < 0) {
                    return -1;
                }
                treeMap.put(next, Integer.valueOf(i6));
            }
        }
        for (Integer num : treeMap.keySet()) {
            int intValue = num.intValue();
            if (intValue < i5) {
                int intValue2 = ((Integer) treeMap.get(num)).intValue();
                this.mRowWithAccessibilityFocus = intValue;
                this.mColumnWithAccessibilityFocus = getColumnIndex(intValue2);
                return intValue2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4, boolean z5) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = 1;
        if (z5) {
            i6 = getChildCount() - 1;
            i5 = -1;
            i7 = -1;
        } else {
            i5 = childCount;
            i6 = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i6 != i5) {
            View childAt = getChildAt(i6);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i6 += i7;
        }
        if (view != null) {
            return view;
        }
        return view2;
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

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    /* access modifiers changed from: package-private */
    public int getSpaceForSpanRange(int i5, int i6) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i6 + i5] - iArr[i5];
        }
        int[] iArr2 = this.mCachedBorders;
        int i7 = this.mSpanCount;
        return iArr2[i7 - i5] - iArr2[(i7 - i5) - i6];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        View next;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.LayoutState layoutState2 = layoutState;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        if (modeInOther != 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (getChildCount() > 0) {
            i5 = this.mCachedBorders[this.mSpanCount];
        } else {
            i5 = 0;
        }
        if (z4) {
            updateMeasurements();
        }
        if (layoutState2.mItemDirection == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i15 = this.mSpanCount;
        if (!z5) {
            i15 = getSpanIndex(recycler2, state2, layoutState2.mCurrentPosition) + getSpanSize(recycler2, state2, layoutState2.mCurrentPosition);
        }
        int i16 = 0;
        while (i16 < this.mSpanCount && layoutState2.hasMore(state2) && i15 > 0) {
            int i17 = layoutState2.mCurrentPosition;
            int spanSize = getSpanSize(recycler2, state2, i17);
            if (spanSize <= this.mSpanCount) {
                i15 -= spanSize;
                if (i15 < 0 || (next = layoutState2.next(recycler2)) == null) {
                    break;
                }
                this.mSet[i16] = next;
                i16++;
            } else {
                throw new IllegalArgumentException("Item at position " + i17 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (i16 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        assignSpans(recycler2, state2, i16, z5);
        float f5 = 0.0f;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            View view = this.mSet[i19];
            if (layoutState2.mScrapList == null) {
                if (z5) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z5) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i18) {
                i18 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f5) {
                f5 = decoratedMeasurementInOther;
            }
        }
        if (z4) {
            guessMeasurement(f5, i5);
            i18 = 0;
            for (int i20 = 0; i20 < i16; i20++) {
                View view2 = this.mSet[i20];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i18) {
                    i18 = decoratedMeasurement2;
                }
            }
        }
        for (int i21 = 0; i21 < i16; i21++) {
            View view3 = this.mSet[i21];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i18) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i22 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i23 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i14 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i23, layoutParams.width, false);
                    i13 = View.MeasureSpec.makeMeasureSpec(i18 - i22, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i23, 1073741824);
                    i13 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i22, layoutParams.height, false);
                    i14 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i14, i13, true);
            }
        }
        layoutChunkResult2.mConsumed = i18;
        if (this.mOrientation == 1) {
            if (layoutState2.mLayoutDirection == -1) {
                i9 = layoutState2.mOffset;
                i12 = i9 - i18;
            } else {
                i12 = layoutState2.mOffset;
                i9 = i12 + i18;
            }
            i6 = i12;
            i8 = 0;
            i7 = 0;
        } else {
            if (layoutState2.mLayoutDirection == -1) {
                i11 = layoutState2.mOffset;
                i10 = i11 - i18;
            } else {
                i10 = layoutState2.mOffset;
                i11 = i10 + i18;
            }
            i7 = i10;
            i6 = 0;
            i8 = i11;
            i9 = 0;
        }
        for (int i24 = 0; i24 < i16; i24++) {
            View view4 = this.mSet[i24];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                i6 = this.mCachedBorders[layoutParams2.mSpanIndex] + getPaddingTop();
                i9 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + i6;
            } else if (isLayoutRTL()) {
                i8 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                i7 = i8 - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
            } else {
                i7 = this.mCachedBorders[layoutParams2.mSpanIndex] + getPaddingLeft();
                i8 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + i7;
            }
            View view5 = view4;
            int i25 = i9;
            View view6 = view5;
            int i26 = i6;
            int i27 = i8;
            int i28 = i7;
            int i29 = i26;
            layoutDecoratedWithMargins(view6, i28, i29, i27, i25);
            int i30 = i25;
            View view7 = view6;
            i9 = i30;
            int i31 = i29;
            i7 = i28;
            i8 = i27;
            i6 = i31;
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult2.mIgnoreConsumed = true;
            }
            layoutChunkResult2.mFocusable = view7.hasFocusable() | layoutChunkResult2.mFocusable;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i5) {
        super.onAnchorReady(recycler, state, anchorInfo, i5);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i5);
        }
        ensureViewSet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d3, code lost:
        if (r13 == r4) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f3, code lost:
        if (r13 == r8) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.mSpanIndex
            int r5 = r5.mSpanSize
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            r11 = -1
            if (r7 == r10) goto L_0x0039
            int r7 = r0.getChildCount()
            int r7 = r7 - r9
            r10 = r11
            r12 = r10
            goto L_0x0040
        L_0x0039:
            int r7 = r0.getChildCount()
            r10 = r7
            r12 = r9
            r7 = 0
        L_0x0040:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x004c
            boolean r13 = r0.isLayoutRTL()
            if (r13 == 0) goto L_0x004c
            r13 = r9
            goto L_0x004d
        L_0x004c:
            r13 = 0
        L_0x004d:
            int r14 = r0.getSpanGroupIndex(r1, r2, r7)
            r15 = r11
            r16 = r15
            r8 = 0
            r17 = 0
            r11 = r7
            r7 = r4
        L_0x0059:
            if (r11 == r10) goto L_0x0065
            int r9 = r0.getSpanGroupIndex(r1, r2, r11)
            android.view.View r1 = r0.getChildAt(r11)
            if (r1 != r3) goto L_0x006b
        L_0x0065:
            r21 = r4
            r19 = r7
            goto L_0x0138
        L_0x006b:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0084
            if (r9 == r14) goto L_0x0084
            if (r4 == 0) goto L_0x0076
            goto L_0x0065
        L_0x0076:
            r18 = r3
            r21 = r4
        L_0x007a:
            r19 = r7
            r20 = r8
        L_0x007e:
            r4 = r16
            r7 = r17
            goto L_0x0127
        L_0x0084:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.mSpanIndex
            r18 = r3
            int r3 = r9.mSpanSize
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009c
            if (r2 != r6) goto L_0x009c
            if (r3 != r5) goto L_0x009c
            return r1
        L_0x009c:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a4
            if (r4 == 0) goto L_0x00ac
        L_0x00a4:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00b7
            if (r7 != 0) goto L_0x00b7
        L_0x00ac:
            r21 = r4
        L_0x00ae:
            r19 = r7
            r20 = r8
            r4 = r16
            r7 = r17
            goto L_0x00f5
        L_0x00b7:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r4
            int r4 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d6
            if (r4 <= r8) goto L_0x00cc
        L_0x00cb:
            goto L_0x00ae
        L_0x00cc:
            if (r4 != r8) goto L_0x007a
            if (r2 <= r15) goto L_0x00d2
            r4 = 1
            goto L_0x00d3
        L_0x00d2:
            r4 = 0
        L_0x00d3:
            if (r13 != r4) goto L_0x007a
            goto L_0x00cb
        L_0x00d6:
            if (r21 != 0) goto L_0x007a
            r19 = r7
            r20 = r8
            r7 = 0
            r8 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r7, r8)
            if (r22 == 0) goto L_0x007e
            r7 = r17
            if (r4 <= r7) goto L_0x00eb
            r4 = r16
            goto L_0x00f5
        L_0x00eb:
            if (r4 != r7) goto L_0x0125
            r4 = r16
            if (r2 <= r4) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r8 = 0
        L_0x00f3:
            if (r13 != r8) goto L_0x0127
        L_0x00f5:
            boolean r8 = r1.hasFocusable()
            if (r8 == 0) goto L_0x0111
            int r8 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r16 = r4
            r17 = r7
            r15 = r8
            r7 = r19
            r4 = r1
            r8 = r2
            goto L_0x012e
        L_0x0111:
            int r4 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r7 = r1
            r16 = r4
        L_0x0120:
            r8 = r20
            r4 = r21
            goto L_0x012e
        L_0x0125:
            r4 = r16
        L_0x0127:
            r16 = r4
            r17 = r7
            r7 = r19
            goto L_0x0120
        L_0x012e:
            int r11 = r11 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r9 = 1
            goto L_0x0059
        L_0x0138:
            if (r21 == 0) goto L_0x013b
            return r21
        L_0x013b:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        RecyclerView.Adapter adapter = this.mRecyclerView.mAdapter;
        if (adapter != null && adapter.getItemCount() > 1) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION);
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
            return;
        }
        int i5 = spanGroupIndex;
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i5, int i6) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i5, int i6, int i7) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i5, int i6) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i5, int i6, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        View findViewByPosition;
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
        int i5 = this.mPositionTargetedByScrollInDirection;
        if (i5 != -1 && (findViewByPosition = findViewByPosition(i5)) != null) {
            findViewByPosition.sendAccessibilityEvent(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            this.mPositionTargetedByScrollInDirection = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean performAccessibilityAction(int i5, @Nullable Bundle bundle) {
        RecyclerView.ViewHolder childViewHolder;
        int i6;
        if (i5 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION.getId() && i5 != -1) {
            View findChildWithAccessibilityFocus = findChildWithAccessibilityFocus();
            if (findChildWithAccessibilityFocus == null || bundle == null) {
                return false;
            }
            int i7 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
            if (!sSupportedDirectionsForActionScrollInDirection.contains(Integer.valueOf(i7)) || (childViewHolder = this.mRecyclerView.getChildViewHolder(findChildWithAccessibilityFocus)) == null) {
                return false;
            }
            int absoluteAdapterPosition = childViewHolder.getAbsoluteAdapterPosition();
            int rowIndex = getRowIndex(absoluteAdapterPosition);
            int columnIndex = getColumnIndex(absoluteAdapterPosition);
            if (rowIndex >= 0 && columnIndex >= 0) {
                if (hasAccessibilityFocusChanged(absoluteAdapterPosition)) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                }
                int i8 = this.mRowWithAccessibilityFocus;
                if (i8 == -1) {
                    i8 = rowIndex;
                }
                int i9 = this.mColumnWithAccessibilityFocus;
                if (i9 != -1) {
                    columnIndex = i9;
                }
                if (i7 == 17) {
                    i6 = findScrollTargetPositionOnTheLeft(i8, columnIndex, absoluteAdapterPosition);
                } else if (i7 == 33) {
                    i6 = findScrollTargetPositionAbove(i8, columnIndex, absoluteAdapterPosition);
                } else if (i7 == 66) {
                    i6 = findScrollTargetPositionOnTheRight(i8, columnIndex, absoluteAdapterPosition);
                } else if (i7 != 130) {
                    return false;
                } else {
                    i6 = findScrollTargetPositionBelow(i8, columnIndex, absoluteAdapterPosition);
                }
                if (i6 == -1 && this.mOrientation == 0) {
                    if (i7 == 17) {
                        i6 = findPositionOfLastItemOnARowAboveForHorizontalGrid(rowIndex);
                    } else if (i7 == 66) {
                        i6 = findPositionOfFirstItemOnARowBelowForHorizontalGrid(rowIndex);
                    }
                }
                if (i6 != -1) {
                    scrollToPosition(i6);
                    this.mPositionTargetedByScrollInDirection = i6;
                    return true;
                }
            }
            return false;
        } else if (i5 != 16908343 || bundle == null) {
            return super.performAccessibilityAction(i5, bundle);
        } else {
            int i10 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT, -1);
            int i11 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT, -1);
            if (!(i10 == -1 || i11 == -1)) {
                int itemCount = this.mRecyclerView.mAdapter.getItemCount();
                int i12 = 0;
                while (true) {
                    if (i12 >= itemCount) {
                        i12 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.mRecyclerView;
                    int spanIndex = getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i12);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    int spanGroupIndex = getSpanGroupIndex(recyclerView2.mRecycler, recyclerView2.mState, i12);
                    if (this.mOrientation != 1) {
                        if (spanIndex == i10 && spanGroupIndex == i11) {
                            break;
                        }
                    } else if (spanIndex == i11 && spanGroupIndex == i10) {
                        break;
                    }
                    i12++;
                }
                if (i12 > -1) {
                    scrollToPositionWithOffset(i12, 0);
                    return true;
                }
            }
            return false;
        }
    }

    public int scrollHorizontallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i5, recycler, state);
    }

    public int scrollVerticallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i5, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i5, int i6) {
        int i7;
        int i8;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i5, i6);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i8 = RecyclerView.LayoutManager.chooseSize(i6, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i7 = RecyclerView.LayoutManager.chooseSize(i5, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i7 = RecyclerView.LayoutManager.chooseSize(i5, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i8 = RecyclerView.LayoutManager.chooseSize(i6, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i7, i8);
    }

    public void setSpanCount(int i5) {
        if (i5 != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i5 >= 1) {
                this.mSpanCount = i5;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i5);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z4) {
        if (!z4) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z4) {
        this.mUsingSpansToEstimateScrollBarDimensions = z4;
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null || this.mPendingSpanCountChange) {
            return false;
        }
        return true;
    }

    static int[] calculateItemBorders(int[] iArr, int i5, int i6) {
        int i7;
        if (!(iArr != null && iArr.length == i5 + 1 && iArr[iArr.length - 1] == i6)) {
            iArr = new int[(i5 + 1)];
        }
        int i8 = 0;
        iArr[0] = 0;
        int i9 = i6 / i5;
        int i10 = i6 % i5;
        int i11 = 0;
        for (int i12 = 1; i12 <= i5; i12++) {
            i8 += i10;
            if (i8 <= 0 || i5 - i8 >= i10) {
                i7 = i9;
            } else {
                i7 = i9 + 1;
                i8 -= i5;
            }
            i11 += i7;
            iArr[i12] = i11;
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex = -1;
        int mSpanSize = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
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

    public GridLayoutManager(Context context, int i5) {
        super(context);
        setSpanCount(i5);
    }

    public GridLayoutManager(Context context, int i5, int i6, boolean z4) {
        super(context, i6, z4);
        setSpanCount(i5);
    }
}
