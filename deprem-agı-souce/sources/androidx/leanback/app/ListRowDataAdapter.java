package androidx.leanback.app;

import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Row;

class ListRowDataAdapter extends ObjectAdapter {
    public static final int ON_CHANGED = 16;
    public static final int ON_ITEM_RANGE_CHANGED = 2;
    public static final int ON_ITEM_RANGE_INSERTED = 4;
    public static final int ON_ITEM_RANGE_REMOVED = 8;
    private final ObjectAdapter mAdapter;
    final ObjectAdapter.DataObserver mDataObserver;
    int mLastVisibleRowIndex;

    private class QueueBasedDataObserver extends ObjectAdapter.DataObserver {
        QueueBasedDataObserver() {
        }

        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            ListRowDataAdapter.this.notifyChanged();
        }
    }

    private class SimpleDataObserver extends ObjectAdapter.DataObserver {
        SimpleDataObserver() {
        }

        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            onEventFired(16, -1, -1);
        }

        /* access modifiers changed from: protected */
        public void onEventFired(int i5, int i6, int i7) {
            ListRowDataAdapter.this.doNotify(i5, i6, i7);
        }

        public void onItemRangeChanged(int i5, int i6) {
            int i7 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i5 <= i7) {
                onEventFired(2, i5, Math.min(i6, (i7 - i5) + 1));
            }
        }

        public void onItemRangeInserted(int i5, int i6) {
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i7 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i5 <= i7) {
                listRowDataAdapter.mLastVisibleRowIndex = i7 + i6;
                onEventFired(4, i5, i6);
                return;
            }
            listRowDataAdapter.initialize();
            int i8 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i8 > i7) {
                onEventFired(4, i7 + 1, i8 - i7);
            }
        }

        public void onItemRangeRemoved(int i5, int i6) {
            int i7 = (i5 + i6) - 1;
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i8 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i7 < i8) {
                listRowDataAdapter.mLastVisibleRowIndex = i8 - i6;
                onEventFired(8, i5, i6);
                return;
            }
            listRowDataAdapter.initialize();
            int i9 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            int i10 = i8 - i9;
            if (i10 > 0) {
                onEventFired(8, Math.min(i9 + 1, i5), i10);
            }
        }
    }

    public ListRowDataAdapter(ObjectAdapter objectAdapter) {
        super(objectAdapter.getPresenterSelector());
        this.mAdapter = objectAdapter;
        initialize();
        if (objectAdapter.isImmediateNotifySupported()) {
            this.mDataObserver = new SimpleDataObserver();
        } else {
            this.mDataObserver = new QueueBasedDataObserver();
        }
        attach();
    }

    /* access modifiers changed from: package-private */
    public void attach() {
        initialize();
        this.mAdapter.registerObserver(this.mDataObserver);
    }

    /* access modifiers changed from: package-private */
    public void detach() {
        this.mAdapter.unregisterObserver(this.mDataObserver);
    }

    /* access modifiers changed from: package-private */
    public void doNotify(int i5, int i6, int i7) {
        if (i5 == 2) {
            notifyItemRangeChanged(i6, i7);
        } else if (i5 == 4) {
            notifyItemRangeInserted(i6, i7);
        } else if (i5 == 8) {
            notifyItemRangeRemoved(i6, i7);
        } else if (i5 == 16) {
            notifyChanged();
        } else {
            throw new IllegalArgumentException("Invalid event type " + i5);
        }
    }

    public Object get(int i5) {
        return this.mAdapter.get(i5);
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        this.mLastVisibleRowIndex = -1;
        for (int size = this.mAdapter.size() - 1; size >= 0; size--) {
            if (((Row) this.mAdapter.get(size)).isRenderedAsRowView()) {
                this.mLastVisibleRowIndex = size;
                return;
            }
        }
    }

    public int size() {
        return this.mLastVisibleRowIndex + 1;
    }
}
