package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        public void onChanged(int i5, int i6) {
            this.mBatchingListUpdateCallback.onChanged(i5, i6, (Object) null);
        }

        public void onInserted(int i5, int i6) {
            this.mBatchingListUpdateCallback.onInserted(i5, i6);
        }

        public void onMoved(int i5, int i6) {
            this.mBatchingListUpdateCallback.onMoved(i5, i6);
        }

        public void onRemoved(int i5, int i6) {
            this.mBatchingListUpdateCallback.onRemoved(i5, i6);
        }

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i5, int i6, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i5, i6, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i5, int i6);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i5, int i6, Object obj) {
            onChanged(i5, i6);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length >= 1) {
            int sortAndDedup = sortAndDedup(tArr);
            if (this.mSize == 0) {
                this.mData = tArr;
                this.mSize = sortAndDedup;
                this.mCallback.onInserted(0, sortAndDedup);
                return;
            }
            merge(tArr, sortAndDedup);
        }
    }

    private void addToData(int i5, T t5) {
        int i6 = this.mSize;
        if (i5 <= i6) {
            T[] tArr = this.mData;
            if (i6 == tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(this.mTClass, tArr.length + 10);
                System.arraycopy(this.mData, 0, tArr2, 0, i5);
                tArr2[i5] = t5;
                System.arraycopy(this.mData, i5, tArr2, i5 + 1, this.mSize - i5);
                this.mData = tArr2;
            } else {
                System.arraycopy(tArr, i5, tArr, i5 + 1, i6 - i5);
                this.mData[i5] = t5;
            }
            this.mSize++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i5 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (Object[]) Array.newInstance(this.mTClass, tArr.length);
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t5, T[] tArr, int i5, int i6, int i7) {
        while (i5 < i6) {
            int i8 = (i5 + i6) / 2;
            T t6 = tArr[i8];
            int compare = this.mCallback.compare(t6, t5);
            if (compare < 0) {
                i5 = i8 + 1;
            } else if (compare == 0) {
                if (!this.mCallback.areItemsTheSame(t6, t5)) {
                    int linearEqualitySearch = linearEqualitySearch(t5, i8, i5, i6);
                    if (!(i7 == 1 && linearEqualitySearch == -1)) {
                        return linearEqualitySearch;
                    }
                }
                return i8;
            } else {
                i6 = i8;
            }
        }
        if (i7 == 1) {
            return i5;
        }
        return -1;
    }

    private int findSameItem(T t5, T[] tArr, int i5, int i6) {
        while (i5 < i6) {
            if (this.mCallback.areItemsTheSame(tArr[i5], t5)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t5, int i5, int i6, int i7) {
        T t6;
        int i8 = i5 - 1;
        while (i8 >= i6) {
            T t7 = this.mData[i8];
            if (this.mCallback.compare(t7, t5) != 0) {
                break;
            } else if (this.mCallback.areItemsTheSame(t7, t5)) {
                return i8;
            } else {
                i8--;
            }
        }
        do {
            i5++;
            if (i5 >= i7) {
                return -1;
            }
            t6 = this.mData[i5];
            if (this.mCallback.compare(t6, t5) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t6, t5));
        return i5;
    }

    private void merge(T[] tArr, int i5) {
        boolean z4 = this.mCallback instanceof BatchedCallback;
        if (!z4) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i6 = 0;
        this.mOldDataStart = 0;
        int i7 = this.mSize;
        this.mOldDataSize = i7;
        this.mData = (Object[]) Array.newInstance(this.mTClass, i7 + i5 + 10);
        this.mNewDataStart = 0;
        while (true) {
            int i8 = this.mOldDataStart;
            int i9 = this.mOldDataSize;
            if (i8 >= i9 && i6 >= i5) {
                break;
            } else if (i8 == i9) {
                int i10 = i5 - i6;
                System.arraycopy(tArr, i6, this.mData, this.mNewDataStart, i10);
                int i11 = this.mNewDataStart + i10;
                this.mNewDataStart = i11;
                this.mSize += i10;
                this.mCallback.onInserted(i11 - i10, i10);
                break;
            } else if (i6 == i5) {
                int i12 = i9 - i8;
                System.arraycopy(this.mOldData, i8, this.mData, this.mNewDataStart, i12);
                this.mNewDataStart += i12;
                break;
            } else {
                T t5 = this.mOldData[i8];
                T t6 = tArr[i6];
                int compare = this.mCallback.compare(t5, t6);
                if (compare > 0) {
                    T[] tArr2 = this.mData;
                    int i13 = this.mNewDataStart;
                    this.mNewDataStart = i13 + 1;
                    tArr2[i13] = t6;
                    this.mSize++;
                    i6++;
                    this.mCallback.onInserted(i13, 1);
                } else if (compare != 0 || !this.mCallback.areItemsTheSame(t5, t6)) {
                    T[] tArr3 = this.mData;
                    int i14 = this.mNewDataStart;
                    this.mNewDataStart = i14 + 1;
                    tArr3[i14] = t5;
                    this.mOldDataStart++;
                } else {
                    T[] tArr4 = this.mData;
                    int i15 = this.mNewDataStart;
                    this.mNewDataStart = i15 + 1;
                    tArr4[i15] = t6;
                    i6++;
                    this.mOldDataStart++;
                    if (!this.mCallback.areContentsTheSame(t5, t6)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t5, t6));
                    }
                }
            }
        }
        this.mOldData = null;
        if (!z4) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i5, boolean z4) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i5 + 1, tArr, i5, (this.mSize - i5) - 1);
        int i6 = this.mSize - 1;
        this.mSize = i6;
        this.mData[i6] = null;
        if (z4) {
            this.mCallback.onRemoved(i5, 1);
        }
    }

    private void replaceAllInsert(T t5) {
        T[] tArr = this.mData;
        int i5 = this.mNewDataStart;
        tArr[i5] = t5;
        this.mNewDataStart = i5 + 1;
        this.mSize++;
        this.mCallback.onInserted(i5, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z4 = this.mCallback instanceof BatchedCallback;
        if (!z4) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (Object[]) Array.newInstance(this.mTClass, sortAndDedup);
        while (true) {
            int i5 = this.mNewDataStart;
            if (i5 >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i6 = this.mOldDataStart;
            int i7 = this.mOldDataSize;
            if (i6 >= i7) {
                int i8 = sortAndDedup - i5;
                System.arraycopy(tArr, i5, this.mData, i5, i8);
                this.mNewDataStart += i8;
                this.mSize += i8;
                this.mCallback.onInserted(i5, i8);
                break;
            } else if (i5 >= sortAndDedup) {
                int i9 = i7 - i6;
                this.mSize -= i9;
                this.mCallback.onRemoved(i5, i9);
                break;
            } else {
                T t5 = this.mOldData[i6];
                T t6 = tArr[i5];
                int compare = this.mCallback.compare(t5, t6);
                if (compare < 0) {
                    replaceAllRemove();
                } else if (compare > 0) {
                    replaceAllInsert(t6);
                } else if (!this.mCallback.areItemsTheSame(t5, t6)) {
                    replaceAllRemove();
                    replaceAllInsert(t6);
                } else {
                    T[] tArr2 = this.mData;
                    int i10 = this.mNewDataStart;
                    tArr2[i10] = t6;
                    this.mOldDataStart++;
                    this.mNewDataStart = i10 + 1;
                    if (!this.mCallback.areContentsTheSame(t5, t6)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t5, t6));
                    }
                }
            }
        }
        this.mOldData = null;
        if (!z4) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i5 = 0;
        int i6 = 1;
        for (int i7 = 1; i7 < tArr.length; i7++) {
            T t5 = tArr[i7];
            if (this.mCallback.compare(tArr[i5], t5) == 0) {
                int findSameItem = findSameItem(t5, tArr, i5, i6);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t5;
                } else {
                    if (i6 != i7) {
                        tArr[i6] = t5;
                    }
                    i6++;
                }
            } else {
                if (i6 != i7) {
                    tArr[i6] = t5;
                }
                i5 = i6;
                i6++;
            }
        }
        return i6;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t5) {
        throwIfInMutationOperation();
        return add(t5, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z4) {
        throwIfInMutationOperation();
        if (tArr.length != 0) {
            if (z4) {
                addAllInternal(tArr);
            } else {
                addAllInternal(copyArray(tArr));
            }
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (!(callback instanceof BatchedCallback)) {
            if (this.mBatchedCallback == null) {
                this.mBatchedCallback = new BatchedCallback(callback);
            }
            this.mCallback = this.mBatchedCallback;
        }
    }

    public void clear() {
        throwIfInMutationOperation();
        int i5 = this.mSize;
        if (i5 != 0) {
            Arrays.fill(this.mData, 0, i5, (Object) null);
            this.mSize = 0;
            this.mCallback.onRemoved(0, i5);
        }
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i5) throws IndexOutOfBoundsException {
        int i6;
        if (i5 >= this.mSize || i5 < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + i5 + " but size is " + this.mSize);
        }
        T[] tArr = this.mOldData;
        if (tArr == null || i5 < (i6 = this.mNewDataStart)) {
            return this.mData[i5];
        }
        return tArr[(i5 - i6) + this.mOldDataStart];
    }

    public int indexOf(T t5) {
        if (this.mOldData != null) {
            T t6 = t5;
            int findIndexOf = findIndexOf(t6, this.mData, 0, this.mNewDataStart, 4);
            T t7 = t6;
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            int findIndexOf2 = findIndexOf(t7, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (findIndexOf2 != -1) {
                return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
            }
            return -1;
        }
        return findIndexOf(t5, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int i5) {
        throwIfInMutationOperation();
        Object obj = get(i5);
        removeItemAtIndex(i5, false);
        int add = add(obj, false);
        if (i5 != add) {
            this.mCallback.onMoved(i5, add);
        }
    }

    public boolean remove(T t5) {
        throwIfInMutationOperation();
        return remove(t5, true);
    }

    public T removeItemAt(int i5) {
        throwIfInMutationOperation();
        T t5 = get(i5);
        removeItemAtIndex(i5, true);
        return t5;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z4) {
        throwIfInMutationOperation();
        if (z4) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i5, T t5) {
        boolean z4;
        throwIfInMutationOperation();
        T t6 = get(i5);
        if (t6 == t5 || !this.mCallback.areContentsTheSame(t6, t5)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (t6 == t5 || this.mCallback.compare(t6, t5) != 0) {
            if (z4) {
                Callback callback = this.mCallback;
                callback.onChanged(i5, 1, callback.getChangePayload(t6, t5));
            }
            removeItemAtIndex(i5, false);
            int add = add(t5, false);
            if (i5 != add) {
                this.mCallback.onMoved(i5, add);
                return;
            }
            return;
        }
        this.mData[i5] = t5;
        if (z4) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i5, 1, callback2.getChangePayload(t6, t5));
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i5) {
        this.mTClass = cls;
        this.mData = (Object[]) Array.newInstance(cls, i5);
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t5, boolean z4) {
        T t6 = t5;
        int findIndexOf = findIndexOf(t6, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t7 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t7, t6)) {
                if (this.mCallback.areContentsTheSame(t7, t6)) {
                    this.mData[findIndexOf] = t6;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t6;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t7, t6));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t6);
        if (z4) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private boolean remove(T t5, boolean z4) {
        int findIndexOf = findIndexOf(t5, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z4);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance(this.mTClass, collection.size())), true);
    }

    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance(this.mTClass, collection.size())), true);
    }
}
