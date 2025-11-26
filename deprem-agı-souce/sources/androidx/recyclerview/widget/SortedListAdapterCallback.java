package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter<?> mAdapter;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> adapter) {
        this.mAdapter = adapter;
    }

    public void onChanged(int i5, int i6) {
        this.mAdapter.notifyItemRangeChanged(i5, i6);
    }

    public void onInserted(int i5, int i6) {
        this.mAdapter.notifyItemRangeInserted(i5, i6);
    }

    public void onMoved(int i5, int i6) {
        this.mAdapter.notifyItemMoved(i5, i6);
    }

    public void onRemoved(int i5, int i6) {
        this.mAdapter.notifyItemRangeRemoved(i5, i6);
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i5, int i6, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i5, i6, obj);
    }
}
