package androidx.leanback.widget;

import androidx.collection.CircularArray;
import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import java.io.PrintWriter;

abstract class StaggeredGrid extends Grid {
    protected int mFirstIndex = -1;
    protected CircularArray<Location> mLocations = new CircularArray<>(64);
    protected Object mPendingItem;
    protected int mPendingItemSize;

    static class Location extends Grid.Location {
        int mOffset;
        int mSize;

        Location(int i5, int i6, int i7) {
            super(i5);
            this.mOffset = i6;
            this.mSize = i7;
        }
    }

    StaggeredGrid() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int calculateOffsetAfterLastItem(int r3) {
        /*
            r2 = this;
            int r0 = r2.getLastIndex()
        L_0x0004:
            int r1 = r2.mFirstIndex
            if (r0 < r1) goto L_0x0014
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation((int) r0)
            int r1 = r1.mRow
            if (r1 != r3) goto L_0x0011
            goto L_0x0018
        L_0x0011:
            int r0 = r0 + -1
            goto L_0x0004
        L_0x0014:
            int r0 = r2.getLastIndex()
        L_0x0018:
            boolean r3 = r2.isReversedFlow()
            if (r3 == 0) goto L_0x0028
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation((int) r0)
            int r3 = r3.mSize
            int r3 = -r3
            int r1 = r2.mSpacing
            goto L_0x003f
        L_0x0028:
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation((int) r0)
            int r3 = r3.mSize
            int r1 = r2.mSpacing
            int r3 = r3 + r1
        L_0x0031:
            int r0 = r0 + 1
            int r1 = r2.getLastIndex()
            if (r0 > r1) goto L_0x0041
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation((int) r0)
            int r1 = r1.mOffset
        L_0x003f:
            int r3 = r3 - r1
            goto L_0x0031
        L_0x0041:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGrid.calculateOffsetAfterLastItem(int):int");
    }

    /* access modifiers changed from: protected */
    public final boolean appendVisbleItemsWithCache(int i5, boolean z4) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int count = this.mProvider.getCount();
        int i10 = this.mLastVisibleIndex;
        if (i10 >= 0) {
            i6 = i10 + 1;
            i7 = this.mProvider.getEdge(i10);
        } else {
            int i11 = this.mStartIndex;
            if (i11 != -1) {
                i6 = i11;
            } else {
                i6 = 0;
            }
            if (i6 > getLastIndex() + 1 || i6 < getFirstIndex()) {
                this.mLocations.clear();
                return false;
            } else if (i6 > getLastIndex()) {
                return false;
            } else {
                i7 = Integer.MAX_VALUE;
            }
        }
        int lastIndex = getLastIndex();
        int i12 = i6;
        while (i12 < count && i12 <= lastIndex) {
            Location location = getLocation(i12);
            if (i7 != Integer.MAX_VALUE) {
                i7 += location.mOffset;
            }
            int i13 = i7;
            int i14 = location.mRow;
            int createItem = this.mProvider.createItem(i12, true, this.mTmpItem, false);
            if (createItem != location.mSize) {
                location.mSize = createItem;
                this.mLocations.removeFromEnd(lastIndex - i12);
                i8 = i12;
            } else {
                i8 = lastIndex;
            }
            this.mLastVisibleIndex = i12;
            if (this.mFirstVisibleIndex < 0) {
                this.mFirstVisibleIndex = i12;
            }
            this.mProvider.addItem(this.mTmpItem[0], i12, createItem, i14, i13);
            if (!z4 && checkAppendOverLimit(i5)) {
                return true;
            }
            if (i13 == Integer.MAX_VALUE) {
                i9 = this.mProvider.getEdge(i12);
            } else {
                i9 = i13;
            }
            if (i14 == this.mNumRows - 1 && z4) {
                return true;
            }
            i12++;
            lastIndex = i8;
            i7 = i9;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int appendVisibleItemToRow(int i5, int i6, int i7) {
        int i8;
        int i9 = this.mLastVisibleIndex;
        if (i9 < 0 || (i9 == getLastIndex() && this.mLastVisibleIndex == i5 - 1)) {
            int i10 = this.mLastVisibleIndex;
            if (i10 >= 0) {
                i8 = i7 - this.mProvider.getEdge(i10);
            } else if (this.mLocations.size() <= 0 || i5 != getLastIndex() + 1) {
                i8 = 0;
            } else {
                i8 = calculateOffsetAfterLastItem(i6);
            }
            Location location = new Location(i6, i8, 0);
            this.mLocations.addLast(location);
            Object obj = this.mPendingItem;
            if (obj != null) {
                location.mSize = this.mPendingItemSize;
                this.mPendingItem = null;
            } else {
                location.mSize = this.mProvider.createItem(i5, true, this.mTmpItem, false);
                obj = this.mTmpItem[0];
            }
            Object obj2 = obj;
            if (this.mLocations.size() == 1) {
                this.mLastVisibleIndex = i5;
                this.mFirstVisibleIndex = i5;
                this.mFirstIndex = i5;
            } else {
                int i11 = this.mLastVisibleIndex;
                if (i11 < 0) {
                    this.mLastVisibleIndex = i5;
                    this.mFirstVisibleIndex = i5;
                } else {
                    this.mLastVisibleIndex = i11 + 1;
                }
            }
            this.mProvider.addItem(obj2, i5, location.mSize, i6, i7);
            return location.mSize;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final boolean appendVisibleItems(int i5, boolean z4) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkAppendOverLimit(i5)) {
            return false;
        }
        try {
            if (appendVisbleItemsWithCache(i5, z4)) {
                this.mTmpItem[0] = null;
                this.mPendingItem = null;
                return true;
            }
            boolean appendVisibleItemsWithoutCache = appendVisibleItemsWithoutCache(i5, z4);
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            return appendVisibleItemsWithoutCache;
        } catch (Throwable th) {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean appendVisibleItemsWithoutCache(int i5, boolean z4);

    public final void debugPrint(PrintWriter printWriter) {
        int size = this.mLocations.size();
        for (int i5 = 0; i5 < size; i5++) {
            printWriter.print("<" + (this.mFirstIndex + i5) + "," + this.mLocations.get(i5).mRow + ">");
            printWriter.print(" ");
            printWriter.println();
        }
    }

    public final int getFirstIndex() {
        return this.mFirstIndex;
    }

    public final CircularIntArray[] getItemPositionsInRows(int i5, int i6) {
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            this.mTmpItemPositionsInRows[i7].clear();
        }
        if (i5 >= 0) {
            while (i5 <= i6) {
                CircularIntArray circularIntArray = this.mTmpItemPositionsInRows[getLocation(i5).mRow];
                if (circularIntArray.size() <= 0 || circularIntArray.getLast() != i5 - 1) {
                    circularIntArray.addLast(i5);
                    circularIntArray.addLast(i5);
                } else {
                    circularIntArray.popLast();
                    circularIntArray.addLast(i5);
                }
                i5++;
            }
        }
        return this.mTmpItemPositionsInRows;
    }

    public final int getLastIndex() {
        return (this.mFirstIndex + this.mLocations.size()) - 1;
    }

    public final int getSize() {
        return this.mLocations.size();
    }

    public void invalidateItemsAfter(int i5) {
        super.invalidateItemsAfter(i5);
        this.mLocations.removeFromEnd((getLastIndex() - i5) + 1);
        if (this.mLocations.size() == 0) {
            this.mFirstIndex = -1;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean prependVisbleItemsWithCache(int i5, boolean z4) {
        int i6;
        int i7;
        int i8;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int i9 = this.mFirstVisibleIndex;
        if (i9 >= 0) {
            i8 = this.mProvider.getEdge(i9);
            i7 = getLocation(this.mFirstVisibleIndex).mOffset;
            i6 = this.mFirstVisibleIndex - 1;
        } else {
            int i10 = this.mStartIndex;
            if (i10 != -1) {
                i6 = i10;
            } else {
                i6 = 0;
            }
            if (i6 > getLastIndex() || i6 < getFirstIndex() - 1) {
                this.mLocations.clear();
                return false;
            } else if (i6 < getFirstIndex()) {
                return false;
            } else {
                i8 = Integer.MAX_VALUE;
                i7 = 0;
            }
        }
        int max = Math.max(this.mProvider.getMinIndex(), this.mFirstIndex);
        for (int i11 = i6; i11 >= max; i11--) {
            Location location = getLocation(i11);
            int i12 = location.mRow;
            int createItem = this.mProvider.createItem(i11, false, this.mTmpItem, false);
            if (createItem != location.mSize) {
                this.mLocations.removeFromStart((i11 + 1) - this.mFirstIndex);
                this.mFirstIndex = this.mFirstVisibleIndex;
                this.mPendingItem = this.mTmpItem[0];
                this.mPendingItemSize = createItem;
                return false;
            }
            this.mFirstVisibleIndex = i11;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i11;
            }
            this.mProvider.addItem(this.mTmpItem[0], i11, createItem, i12, i8 - i7);
            if (!z4 && checkPrependOverLimit(i5)) {
                return true;
            }
            i8 = this.mProvider.getEdge(i11);
            i7 = location.mOffset;
            if (i12 == 0 && z4) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int prependVisibleItemToRow(int i5, int i6, int i7) {
        Location location;
        int i8;
        int i9 = this.mFirstVisibleIndex;
        if (i9 < 0 || (i9 == getFirstIndex() && this.mFirstVisibleIndex == i5 + 1)) {
            int i10 = this.mFirstIndex;
            if (i10 >= 0) {
                location = getLocation(i10);
            } else {
                location = null;
            }
            int edge = this.mProvider.getEdge(this.mFirstIndex);
            Location location2 = new Location(i6, 0, 0);
            this.mLocations.addFirst(location2);
            Object obj = this.mPendingItem;
            if (obj != null) {
                location2.mSize = this.mPendingItemSize;
                this.mPendingItem = null;
            } else {
                location2.mSize = this.mProvider.createItem(i5, false, this.mTmpItem, false);
                obj = this.mTmpItem[0];
            }
            Object obj2 = obj;
            this.mFirstVisibleIndex = i5;
            this.mFirstIndex = i5;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i5;
            }
            if (!this.mReversedFlow) {
                i8 = i7 - location2.mSize;
            } else {
                i8 = i7 + location2.mSize;
            }
            int i11 = i8;
            if (location != null) {
                location.mOffset = edge - i11;
            }
            this.mProvider.addItem(obj2, i5, location2.mSize, i6, i11);
            return location2.mSize;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final boolean prependVisibleItems(int i5, boolean z4) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkPrependOverLimit(i5)) {
            return false;
        }
        try {
            if (prependVisbleItemsWithCache(i5, z4)) {
                this.mTmpItem[0] = null;
                this.mPendingItem = null;
                return true;
            }
            boolean prependVisibleItemsWithoutCache = prependVisibleItemsWithoutCache(i5, z4);
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            return prependVisibleItemsWithoutCache;
        } catch (Throwable th) {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean prependVisibleItemsWithoutCache(int i5, boolean z4);

    public final Location getLocation(int i5) {
        int i6 = i5 - this.mFirstIndex;
        if (i6 < 0 || i6 >= this.mLocations.size()) {
            return null;
        }
        return this.mLocations.get(i6);
    }
}
