package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions = new SparseIntArray();
    final int[] mPrevRange = new int[2];
    int mRequestedGeneration = 0;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i5, int i6);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i5) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i5) {
            int i6;
            int i7 = iArr[1];
            int i8 = iArr[0];
            int i9 = (i7 - i8) + 1;
            int i10 = i9 / 2;
            if (i5 == 1) {
                i6 = i9;
            } else {
                i6 = i10;
            }
            iArr2[0] = i8 - i6;
            if (i5 != 2) {
                i9 = i10;
            }
            iArr2[1] = i7 + i9;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i5);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i5, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        AnonymousClass1 r02 = new ThreadUtil.MainThreadCallback<T>() {
            private boolean isRequestedGeneration(int i5) {
                if (i5 == AsyncListUtil.this.mRequestedGeneration) {
                    return true;
                }
                return false;
            }

            private void recycleAllTiles() {
                for (int i5 = 0; i5 < AsyncListUtil.this.mTileList.size(); i5++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i5));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            public void addTile(int i5, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i5)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                int i6 = tile.mStartPosition + tile.mItemCount;
                int i7 = 0;
                while (i7 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i7);
                    if (tile.mStartPosition > keyAt || keyAt >= i6) {
                        i7++;
                    } else {
                        AsyncListUtil.this.mMissingPositions.removeAt(i7);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    }
                }
            }

            public void removeTile(int i5, int i6) {
                if (isRequestedGeneration(i5)) {
                    TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i6);
                    if (removeAtPos == null) {
                        Log.e(AsyncListUtil.TAG, "tile not found @" + i6);
                        return;
                    }
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
                }
            }

            public void updateItemCount(int i5, int i6) {
                if (isRequestedGeneration(i5)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mItemCount = i6;
                    asyncListUtil.mViewCallback.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                    recycleAllTiles();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.mAllowScrollHints = false;
                    asyncListUtil3.updateRange();
                }
            }
        };
        this.mMainThreadCallback = r02;
        AnonymousClass2 r12 = new ThreadUtil.BackgroundCallback<T>() {
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i5) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int keyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i6 = this.mFirstRequiredTileStart - keyAt;
                    int i7 = keyAt2 - this.mLastRequiredTileStart;
                    if (i6 > 0 && (i6 >= i7 || i5 == 2)) {
                        removeTile(keyAt);
                    } else if (i7 <= 0) {
                        return;
                    } else {
                        if (i6 < i7 || i5 == 1) {
                            removeTile(keyAt2);
                        } else {
                            return;
                        }
                    }
                }
            }

            private int getTileStart(int i5) {
                return i5 - (i5 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i5) {
                return this.mLoadedTiles.get(i5);
            }

            private void log(String str, Object... objArr) {
                Log.d(AsyncListUtil.TAG, "[BKGR] " + String.format(str, objArr));
            }

            private void removeTile(int i5) {
                this.mLoadedTiles.delete(i5);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i5);
            }

            private void requestTiles(int i5, int i6, int i7, boolean z4) {
                int i8;
                int i9 = i5;
                while (i9 <= i6) {
                    if (z4) {
                        i8 = (i6 + i5) - i9;
                    } else {
                        i8 = i9;
                    }
                    AsyncListUtil.this.mBackgroundProxy.loadTile(i8, i7);
                    i9 += AsyncListUtil.this.mTileSize;
                }
            }

            public void loadTile(int i5, int i6) {
                if (!isTileLoaded(i5)) {
                    TileList.Tile acquireTile = acquireTile();
                    acquireTile.mStartPosition = i5;
                    int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i5);
                    acquireTile.mItemCount = min;
                    AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                    flushTileCache(i6);
                    addTile(acquireTile);
                }
            }

            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            public void refresh(int i5) {
                this.mGeneration = i5;
                this.mLoadedTiles.clear();
                int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = refreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
            }

            public void updateRange(int i5, int i6, int i7, int i8, int i9) {
                if (i5 <= i6) {
                    int tileStart = getTileStart(i5);
                    int tileStart2 = getTileStart(i6);
                    this.mFirstRequiredTileStart = getTileStart(i7);
                    int tileStart3 = getTileStart(i8);
                    this.mLastRequiredTileStart = tileStart3;
                    if (i9 == 1) {
                        requestTiles(this.mFirstRequiredTileStart, tileStart2, i9, true);
                        requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i9, false);
                        return;
                    }
                    requestTiles(tileStart, tileStart3, i9, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i9, true);
                }
            }
        };
        this.mBackgroundCallback = r12;
        this.mTClass = cls;
        this.mTileSize = i5;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i5);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(r02);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(r12);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration != this.mDisplayedGeneration) {
            return true;
        }
        return false;
    }

    @Nullable
    public T getItem(int i5) {
        if (i5 < 0 || i5 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i5 + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i5);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i5, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    /* access modifiers changed from: package-private */
    public void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] " + String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (!isRefreshPending()) {
            updateRange();
            this.mAllowScrollHints = true;
        }
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i5 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i5;
        backgroundCallback.refresh(i5);
    }

    /* access modifiers changed from: package-private */
    public void updateRange() {
        int i5;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (i6 <= i7 && i6 >= 0 && i7 < this.mItemCount) {
            if (!this.mAllowScrollHints) {
                this.mScrollHint = 0;
            } else {
                int[] iArr2 = this.mPrevRange;
                if (i6 > iArr2[1] || (i5 = iArr2[0]) > i7) {
                    this.mScrollHint = 0;
                } else if (i6 < i5) {
                    this.mScrollHint = 1;
                } else if (i6 > i5) {
                    this.mScrollHint = 2;
                }
            }
            int[] iArr3 = this.mPrevRange;
            iArr3[0] = i6;
            iArr3[1] = i7;
            this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
            int[] iArr4 = this.mTmpRangeExtended;
            iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
            int[] iArr5 = this.mTmpRangeExtended;
            iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
            ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
            int[] iArr6 = this.mTmpRange;
            int i8 = iArr6[0];
            int i9 = iArr6[1];
            int[] iArr7 = this.mTmpRangeExtended;
            backgroundCallback.updateRange(i8, i9, iArr7[0], iArr7[1], this.mScrollHint);
        }
    }
}
