package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        Tile(@NonNull Class<T> cls, int i5) {
            this.mItems = (Object[]) Array.newInstance(cls, i5);
        }

        /* access modifiers changed from: package-private */
        public boolean containsPosition(int i5) {
            int i6 = this.mStartPosition;
            if (i6 > i5 || i5 >= i6 + this.mItemCount) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public T getByPosition(int i5) {
            return this.mItems[i5 - this.mStartPosition];
        }
    }

    public TileList(int i5) {
        this.mTileSize = i5;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i5) {
        if (i5 < 0 || i5 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i5);
    }

    public T getItemAt(int i5) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i5)) {
            int indexOfKey = this.mTiles.indexOfKey(i5 - (i5 % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i5);
    }

    public Tile<T> removeAtPos(int i5) {
        Tile<T> tile = this.mTiles.get(i5);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i5);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
