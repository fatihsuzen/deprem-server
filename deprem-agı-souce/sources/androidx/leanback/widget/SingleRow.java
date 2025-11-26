package androidx.leanback.widget;

import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;

class SingleRow extends Grid {
    private final Grid.Location mTmpLocation = new Grid.Location(0);

    SingleRow() {
        setNumRows(1);
    }

    /* access modifiers changed from: protected */
    public final boolean appendVisibleItems(int i5, boolean z4) {
        int i6;
        int i7;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkAppendOverLimit(i5)) {
            return false;
        }
        int startIndexForAppend = getStartIndexForAppend();
        boolean z5 = false;
        while (startIndexForAppend < this.mProvider.getCount()) {
            int createItem = this.mProvider.createItem(startIndexForAppend, true, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                if (this.mReversedFlow) {
                    i7 = Integer.MAX_VALUE;
                } else {
                    i7 = Integer.MIN_VALUE;
                }
                this.mFirstVisibleIndex = startIndexForAppend;
                this.mLastVisibleIndex = startIndexForAppend;
            } else {
                if (this.mReversedFlow) {
                    int i8 = startIndexForAppend - 1;
                    i6 = (this.mProvider.getEdge(i8) - this.mProvider.getSize(i8)) - this.mSpacing;
                } else {
                    int i9 = startIndexForAppend - 1;
                    i6 = this.mProvider.getEdge(i9) + this.mProvider.getSize(i9) + this.mSpacing;
                }
                this.mLastVisibleIndex = startIndexForAppend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForAppend, createItem, 0, i6);
            if (z4 || checkAppendOverLimit(i5)) {
                return true;
            }
            startIndexForAppend++;
            z5 = true;
        }
        return z5;
    }

    public void collectAdjacentPrefetchPositions(int i5, int i6, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i7;
        int i8;
        int i9;
        if (!this.mReversedFlow ? i6 >= 0 : i6 <= 0) {
            if (getLastVisibleIndex() != this.mProvider.getCount() - 1) {
                i7 = getStartIndexForAppend();
                int size = this.mProvider.getSize(this.mLastVisibleIndex) + this.mSpacing;
                int edge = this.mProvider.getEdge(this.mLastVisibleIndex);
                if (this.mReversedFlow) {
                    size = -size;
                }
                i8 = size + edge;
            } else {
                return;
            }
        } else if (getFirstVisibleIndex() != 0) {
            i7 = getStartIndexForPrepend();
            int edge2 = this.mProvider.getEdge(this.mFirstVisibleIndex);
            if (this.mReversedFlow) {
                i9 = this.mSpacing;
            } else {
                i9 = -this.mSpacing;
            }
            i8 = edge2 + i9;
        } else {
            return;
        }
        layoutPrefetchRegistry.addPosition(i7, Math.abs(i8 - i5));
    }

    public final void debugPrint(PrintWriter printWriter) {
        printWriter.print("SingleRow<");
        printWriter.print(this.mFirstVisibleIndex);
        printWriter.print(",");
        printWriter.print(this.mLastVisibleIndex);
        printWriter.print(">");
        printWriter.println();
    }

    /* access modifiers changed from: protected */
    public final int findRowMax(boolean z4, int i5, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i5;
        }
        if (this.mReversedFlow) {
            return this.mProvider.getEdge(i5);
        }
        return this.mProvider.getEdge(i5) + this.mProvider.getSize(i5);
    }

    /* access modifiers changed from: protected */
    public final int findRowMin(boolean z4, int i5, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i5;
        }
        if (this.mReversedFlow) {
            return this.mProvider.getEdge(i5) - this.mProvider.getSize(i5);
        }
        return this.mProvider.getEdge(i5);
    }

    public final CircularIntArray[] getItemPositionsInRows(int i5, int i6) {
        this.mTmpItemPositionsInRows[0].clear();
        this.mTmpItemPositionsInRows[0].addLast(i5);
        this.mTmpItemPositionsInRows[0].addLast(i6);
        return this.mTmpItemPositionsInRows;
    }

    public final Grid.Location getLocation(int i5) {
        return this.mTmpLocation;
    }

    /* access modifiers changed from: package-private */
    public int getStartIndexForAppend() {
        int i5 = this.mLastVisibleIndex;
        if (i5 >= 0) {
            return i5 + 1;
        }
        int i6 = this.mStartIndex;
        if (i6 != -1) {
            return Math.min(i6, this.mProvider.getCount() - 1);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getStartIndexForPrepend() {
        int i5 = this.mFirstVisibleIndex;
        if (i5 >= 0) {
            return i5 - 1;
        }
        int i6 = this.mStartIndex;
        if (i6 != -1) {
            return Math.min(i6, this.mProvider.getCount() - 1);
        }
        return this.mProvider.getCount() - 1;
    }

    /* access modifiers changed from: protected */
    public final boolean prependVisibleItems(int i5, boolean z4) {
        int i6;
        int i7;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkPrependOverLimit(i5)) {
            return false;
        }
        int minIndex = this.mProvider.getMinIndex();
        boolean z5 = false;
        for (int startIndexForPrepend = getStartIndexForPrepend(); startIndexForPrepend >= minIndex; startIndexForPrepend--) {
            int createItem = this.mProvider.createItem(startIndexForPrepend, false, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                if (this.mReversedFlow) {
                    i7 = Integer.MIN_VALUE;
                } else {
                    i7 = Integer.MAX_VALUE;
                }
                this.mFirstVisibleIndex = startIndexForPrepend;
                this.mLastVisibleIndex = startIndexForPrepend;
            } else {
                if (this.mReversedFlow) {
                    i6 = this.mProvider.getEdge(startIndexForPrepend + 1) + this.mSpacing + createItem;
                } else {
                    i6 = (this.mProvider.getEdge(startIndexForPrepend + 1) - this.mSpacing) - createItem;
                }
                this.mFirstVisibleIndex = startIndexForPrepend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForPrepend, createItem, 0, i6);
            z5 = true;
            if (z4 || checkPrependOverLimit(i5)) {
                break;
            }
        }
        return z5;
    }
}
