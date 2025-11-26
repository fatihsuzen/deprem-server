package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

public interface ListUpdateCallback {
    void onChanged(int i5, int i6, @Nullable Object obj);

    void onInserted(int i5, int i6);

    void onMoved(int i5, int i6);

    void onRemoved(int i5, int i6);
}
