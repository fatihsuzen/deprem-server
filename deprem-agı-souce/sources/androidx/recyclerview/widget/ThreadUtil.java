package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.TileList;

interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int i5, int i6);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i5);

        void updateRange(int i5, int i6, int i7, int i8, int i9);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int i5, TileList.Tile<T> tile);

        void removeTile(int i5, int i6);

        void updateItemCount(int i5, int i6);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
