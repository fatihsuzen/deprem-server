package androidx.leanback.widget;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayObjectAdapter extends ObjectAdapter {
    /* access modifiers changed from: private */
    public static final Boolean DEBUG = Boolean.FALSE;
    private static final String TAG = "ArrayObjectAdapter";
    private final List<Object> mItems = new ArrayList();
    ListUpdateCallback mListUpdateCallback;
    final List<Object> mOldItems = new ArrayList();
    private List<?> mUnmodifiableItems;

    public ArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
    }

    public void add(Object obj) {
        add(this.mItems.size(), obj);
    }

    public void addAll(int i5, Collection<?> collection) {
        int size = collection.size();
        if (size != 0) {
            this.mItems.addAll(i5, collection);
            notifyItemRangeInserted(i5, size);
        }
    }

    public void clear() {
        int size = this.mItems.size();
        if (size != 0) {
            this.mItems.clear();
            notifyItemRangeRemoved(0, size);
        }
    }

    public Object get(int i5) {
        return this.mItems.get(i5);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOf(obj);
    }

    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void move(int i5, int i6) {
        if (i5 != i6) {
            this.mItems.add(i6, this.mItems.remove(i5));
            notifyItemMoved(i5, i6);
        }
    }

    public void notifyArrayItemRangeChanged(int i5, int i6) {
        notifyItemRangeChanged(i5, i6);
    }

    public boolean remove(Object obj) {
        int indexOf = this.mItems.indexOf(obj);
        if (indexOf >= 0) {
            this.mItems.remove(indexOf);
            notifyItemRangeRemoved(indexOf, 1);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public int removeItems(int i5, int i6) {
        int min = Math.min(i6, this.mItems.size() - i5);
        if (min <= 0) {
            return 0;
        }
        for (int i7 = 0; i7 < min; i7++) {
            this.mItems.remove(i5);
        }
        notifyItemRangeRemoved(i5, min);
        return min;
    }

    public void replace(int i5, Object obj) {
        this.mItems.set(i5, obj);
        notifyItemRangeChanged(i5, 1);
    }

    public void setItems(final List list, final DiffCallback diffCallback) {
        if (diffCallback == null) {
            this.mItems.clear();
            this.mItems.addAll(list);
            notifyChanged();
            return;
        }
        this.mOldItems.clear();
        this.mOldItems.addAll(this.mItems);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            public boolean areContentsTheSame(int i5, int i6) {
                return diffCallback.areContentsTheSame(ArrayObjectAdapter.this.mOldItems.get(i5), list.get(i6));
            }

            public boolean areItemsTheSame(int i5, int i6) {
                return diffCallback.areItemsTheSame(ArrayObjectAdapter.this.mOldItems.get(i5), list.get(i6));
            }

            public Object getChangePayload(int i5, int i6) {
                return diffCallback.getChangePayload(ArrayObjectAdapter.this.mOldItems.get(i5), list.get(i6));
            }

            public int getNewListSize() {
                return list.size();
            }

            public int getOldListSize() {
                return ArrayObjectAdapter.this.mOldItems.size();
            }
        });
        this.mItems.clear();
        this.mItems.addAll(list);
        if (this.mListUpdateCallback == null) {
            this.mListUpdateCallback = new ListUpdateCallback() {
                public void onChanged(int i5, int i6, Object obj) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onChanged");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeChanged(i5, i6, obj);
                }

                public void onInserted(int i5, int i6) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onInserted");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeInserted(i5, i6);
                }

                public void onMoved(int i5, int i6) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onMoved");
                    }
                    ArrayObjectAdapter.this.notifyItemMoved(i5, i6);
                }

                public void onRemoved(int i5, int i6) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onRemoved");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeRemoved(i5, i6);
                }
            };
        }
        calculateDiff.dispatchUpdatesTo(this.mListUpdateCallback);
        this.mOldItems.clear();
    }

    public int size() {
        return this.mItems.size();
    }

    public <E> List<E> unmodifiableList() {
        if (this.mUnmodifiableItems == null) {
            this.mUnmodifiableItems = DesugarCollections.unmodifiableList(this.mItems);
        }
        return this.mUnmodifiableItems;
    }

    public void add(int i5, Object obj) {
        this.mItems.add(i5, obj);
        notifyItemRangeInserted(i5, 1);
    }

    public ArrayObjectAdapter(Presenter presenter) {
        super(presenter);
    }

    public ArrayObjectAdapter() {
    }
}
