package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i5, int i6, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i5, i6, obj);
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
}
