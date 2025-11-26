package androidx.leanback.widget;

import android.util.SparseArray;

public class SparseArrayObjectAdapter extends ObjectAdapter {
    private SparseArray<Object> mItems = new SparseArray<>();

    public SparseArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
    }

    public void clear(int i5) {
        int indexOfKey = this.mItems.indexOfKey(i5);
        if (indexOfKey >= 0) {
            this.mItems.removeAt(indexOfKey);
            notifyItemRangeRemoved(indexOfKey, 1);
        }
    }

    public Object get(int i5) {
        return this.mItems.valueAt(i5);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOfValue(obj);
    }

    public boolean isImmediateNotifySupported() {
        return true;
    }

    public Object lookup(int i5) {
        return this.mItems.get(i5);
    }

    public void notifyArrayItemRangeChanged(int i5, int i6) {
        notifyItemRangeChanged(i5, i6);
    }

    public void set(int i5, Object obj) {
        int indexOfKey = this.mItems.indexOfKey(i5);
        if (indexOfKey < 0) {
            this.mItems.append(i5, obj);
            notifyItemRangeInserted(this.mItems.indexOfKey(i5), 1);
        } else if (this.mItems.valueAt(indexOfKey) != obj) {
            this.mItems.setValueAt(indexOfKey, obj);
            notifyItemRangeChanged(indexOfKey, 1);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public int indexOf(int i5) {
        return this.mItems.indexOfKey(i5);
    }

    public SparseArrayObjectAdapter(Presenter presenter) {
        super(presenter);
    }

    public void clear() {
        int size = this.mItems.size();
        if (size != 0) {
            this.mItems.clear();
            notifyItemRangeRemoved(0, size);
        }
    }

    public SparseArrayObjectAdapter() {
    }
}
