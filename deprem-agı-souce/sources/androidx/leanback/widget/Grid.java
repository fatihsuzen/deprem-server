package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;
import java.util.Arrays;

abstract class Grid {
    static final int START_DEFAULT = -1;
    protected int mFirstVisibleIndex = -1;
    protected int mLastVisibleIndex = -1;
    protected int mNumRows;
    protected Provider mProvider;
    protected boolean mReversedFlow;
    protected int mSpacing;
    protected int mStartIndex = -1;
    Object[] mTmpItem = new Object[1];
    protected CircularIntArray[] mTmpItemPositionsInRows;

    static class Location {
        int mRow;

        Location(int i5) {
            this.mRow = i5;
        }
    }

    interface Provider {
        void addItem(Object obj, int i5, int i6, int i7, int i8);

        int createItem(int i5, boolean z4, Object[] objArr, boolean z5);

        int getCount();

        int getEdge(int i5);

        int getMinIndex();

        int getSize(int i5);

        void removeItem(int i5);
    }

    Grid() {
    }

    public static Grid createGrid(int i5) {
        if (i5 == 1) {
            return new SingleRow();
        }
        StaggeredGridDefault staggeredGridDefault = new StaggeredGridDefault();
        staggeredGridDefault.setNumRows(i5);
        return staggeredGridDefault;
    }

    private void resetVisibleIndexIfEmpty() {
        if (this.mLastVisibleIndex < this.mFirstVisibleIndex) {
            resetVisibleIndex();
        }
    }

    public boolean appendOneColumnVisibleItems() {
        int i5;
        if (this.mReversedFlow) {
            i5 = Integer.MAX_VALUE;
        } else {
            i5 = Integer.MIN_VALUE;
        }
        return appendVisibleItems(i5, true);
    }

    public final void appendVisibleItems(int i5) {
        appendVisibleItems(i5, false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean appendVisibleItems(int i5, boolean z4);

    /* access modifiers changed from: protected */
    public final boolean checkAppendOverLimit(int i5) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            if (findRowMin(true, (int[]) null) <= i5 + this.mSpacing) {
                return true;
            }
            return false;
        } else if (findRowMax(false, (int[]) null) >= i5 - this.mSpacing) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean checkPrependOverLimit(int i5) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            if (findRowMax(false, (int[]) null) >= i5 - this.mSpacing) {
                return true;
            }
            return false;
        } else if (findRowMin(true, (int[]) null) <= i5 + this.mSpacing) {
            return true;
        } else {
            return false;
        }
    }

    public void collectAdjacentPrefetchPositions(int i5, int i6, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }

    public abstract void debugPrint(PrintWriter printWriter);

    public void fillDisappearingItems(int[] iArr, int i5, SparseIntArray sparseIntArray) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int lastVisibleIndex = getLastVisibleIndex();
        if (lastVisibleIndex >= 0) {
            i6 = Arrays.binarySearch(iArr, 0, i5, lastVisibleIndex);
        } else {
            i6 = 0;
        }
        if (i6 < 0) {
            if (this.mReversedFlow) {
                i11 = (this.mProvider.getEdge(lastVisibleIndex) - this.mProvider.getSize(lastVisibleIndex)) - this.mSpacing;
            } else {
                i11 = this.mProvider.getEdge(lastVisibleIndex) + this.mProvider.getSize(lastVisibleIndex) + this.mSpacing;
            }
            int i13 = i11;
            for (int i14 = (-i6) - 1; i14 < i5; i14++) {
                int i15 = iArr[i14];
                int i16 = sparseIntArray.get(i15);
                if (i16 < 0) {
                    i12 = 0;
                } else {
                    i12 = i16;
                }
                int createItem = this.mProvider.createItem(i15, true, this.mTmpItem, true);
                this.mProvider.addItem(this.mTmpItem[0], i15, createItem, i12, i13);
                if (this.mReversedFlow) {
                    i13 = (i13 - createItem) - this.mSpacing;
                } else {
                    i13 = i13 + createItem + this.mSpacing;
                }
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        if (firstVisibleIndex >= 0) {
            i7 = Arrays.binarySearch(iArr, 0, i5, firstVisibleIndex);
        } else {
            i7 = 0;
        }
        if (i7 < 0) {
            int i17 = (-i7) - 2;
            if (this.mReversedFlow) {
                i8 = this.mProvider.getEdge(firstVisibleIndex);
            } else {
                i8 = this.mProvider.getEdge(firstVisibleIndex);
            }
            while (i17 >= 0) {
                int i18 = iArr[i17];
                int i19 = sparseIntArray.get(i18);
                if (i19 < 0) {
                    i9 = 0;
                } else {
                    i9 = i19;
                }
                int createItem2 = this.mProvider.createItem(i18, false, this.mTmpItem, true);
                if (this.mReversedFlow) {
                    i10 = i8 + this.mSpacing + createItem2;
                } else {
                    i10 = (i8 - this.mSpacing) - createItem2;
                }
                int i20 = i10;
                this.mProvider.addItem(this.mTmpItem[0], i18, createItem2, i9, i20);
                i17--;
                i8 = i20;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract int findRowMax(boolean z4, int i5, int[] iArr);

    public final int findRowMax(boolean z4, int[] iArr) {
        return findRowMax(z4, this.mReversedFlow ? this.mFirstVisibleIndex : this.mLastVisibleIndex, iArr);
    }

    /* access modifiers changed from: protected */
    public abstract int findRowMin(boolean z4, int i5, int[] iArr);

    public final int findRowMin(boolean z4, int[] iArr) {
        return findRowMin(z4, this.mReversedFlow ? this.mLastVisibleIndex : this.mFirstVisibleIndex, iArr);
    }

    public final int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public final CircularIntArray[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public abstract CircularIntArray[] getItemPositionsInRows(int i5, int i6);

    public final int getLastVisibleIndex() {
        return this.mLastVisibleIndex;
    }

    public abstract Location getLocation(int i5);

    public int getNumRows() {
        return this.mNumRows;
    }

    public final int getRowIndex(int i5) {
        Location location = getLocation(i5);
        if (location == null) {
            return -1;
        }
        return location.mRow;
    }

    public void invalidateItemsAfter(int i5) {
        int i6;
        if (i5 >= 0 && (i6 = this.mLastVisibleIndex) >= 0) {
            if (i6 >= i5) {
                this.mLastVisibleIndex = i5 - 1;
            }
            resetVisibleIndexIfEmpty();
            if (getFirstVisibleIndex() < 0) {
                setStart(i5);
            }
        }
    }

    public boolean isReversedFlow() {
        return this.mReversedFlow;
    }

    public final boolean prependOneColumnVisibleItems() {
        int i5;
        if (this.mReversedFlow) {
            i5 = Integer.MIN_VALUE;
        } else {
            i5 = Integer.MAX_VALUE;
        }
        return prependVisibleItems(i5, true);
    }

    public final void prependVisibleItems(int i5) {
        prependVisibleItems(i5, false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean prependVisibleItems(int i5, boolean z4);

    public void removeInvisibleItemsAtEnd(int i5, int i6) {
        while (true) {
            int i7 = this.mLastVisibleIndex;
            if (i7 < this.mFirstVisibleIndex || i7 <= i5) {
                break;
            }
            if (this.mReversedFlow) {
                if (this.mProvider.getEdge(i7) > i6) {
                    break;
                }
            } else if (this.mProvider.getEdge(i7) < i6) {
                break;
            }
            this.mProvider.removeItem(this.mLastVisibleIndex);
            this.mLastVisibleIndex--;
        }
        resetVisibleIndexIfEmpty();
    }

    public void removeInvisibleItemsAtFront(int i5, int i6) {
        while (true) {
            int i7 = this.mLastVisibleIndex;
            int i8 = this.mFirstVisibleIndex;
            if (i7 < i8 || i8 >= i5) {
                break;
            }
            int size = this.mProvider.getSize(i8);
            if (this.mReversedFlow) {
                if (this.mProvider.getEdge(this.mFirstVisibleIndex) - size < i6) {
                    break;
                }
            } else if (this.mProvider.getEdge(this.mFirstVisibleIndex) + size > i6) {
                break;
            }
            this.mProvider.removeItem(this.mFirstVisibleIndex);
            this.mFirstVisibleIndex++;
        }
        resetVisibleIndexIfEmpty();
    }

    public void resetVisibleIndex() {
        this.mLastVisibleIndex = -1;
        this.mFirstVisibleIndex = -1;
    }

    /* access modifiers changed from: package-private */
    public void setNumRows(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException();
        } else if (this.mNumRows != i5) {
            this.mNumRows = i5;
            this.mTmpItemPositionsInRows = new CircularIntArray[i5];
            for (int i6 = 0; i6 < this.mNumRows; i6++) {
                this.mTmpItemPositionsInRows[i6] = new CircularIntArray();
            }
        }
    }

    public void setProvider(Provider provider) {
        this.mProvider = provider;
    }

    public final void setReversedFlow(boolean z4) {
        this.mReversedFlow = z4;
    }

    public final void setSpacing(int i5) {
        this.mSpacing = i5;
    }

    public void setStart(int i5) {
        this.mStartIndex = i5;
    }
}
