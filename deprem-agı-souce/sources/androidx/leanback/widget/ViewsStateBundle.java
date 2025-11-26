package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.LruCache;
import java.util.Map;

final class ViewsStateBundle {
    private static final int LIMIT_DEFAULT = 100;
    private static final int UNLIMITED = Integer.MAX_VALUE;
    private LruCache<String, SparseArray<Parcelable>> mChildStates;
    private int mLimitNumber = 100;
    private int mSavePolicy = 0;

    ViewsStateBundle() {
    }

    private void applyPolicyChanges() {
        int i5 = this.mSavePolicy;
        if (i5 == 2) {
            if (this.mLimitNumber > 0) {
                LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
                if (lruCache == null || lruCache.maxSize() != this.mLimitNumber) {
                    this.mChildStates = new LruCache<>(this.mLimitNumber);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException();
        } else if (i5 == 3 || i5 == 1) {
            LruCache<String, SparseArray<Parcelable>> lruCache2 = this.mChildStates;
            if (lruCache2 == null || lruCache2.maxSize() != Integer.MAX_VALUE) {
                this.mChildStates = new LruCache<>(Integer.MAX_VALUE);
            }
        } else {
            this.mChildStates = null;
        }
    }

    static String getSaveStatesKey(int i5) {
        return Integer.toString(i5);
    }

    private void saveViewUnchecked(View view, int i5) {
        if (this.mChildStates != null) {
            String saveStatesKey = getSaveStatesKey(i5);
            SparseArray sparseArray = new SparseArray();
            view.saveHierarchyState(sparseArray);
            this.mChildStates.put(saveStatesKey, sparseArray);
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    /* access modifiers changed from: package-private */
    public int getLimitNumber() {
        return this.mLimitNumber;
    }

    /* access modifiers changed from: package-private */
    public int getSavePolicy() {
        return this.mSavePolicy;
    }

    /* access modifiers changed from: package-private */
    public void loadFromBundle(Bundle bundle) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache != null && bundle != null) {
            lruCache.evictAll();
            for (String next : bundle.keySet()) {
                this.mChildStates.put(next, bundle.getSparseParcelableArray(next));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void loadView(View view, int i5) {
        SparseArray remove;
        if (this.mChildStates != null && (remove = this.mChildStates.remove(getSaveStatesKey(i5))) != null) {
            view.restoreHierarchyState(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public void remove(int i5) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache != null && lruCache.size() != 0) {
            this.mChildStates.remove(getSaveStatesKey(i5));
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle saveAsBundle() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return null;
        }
        Map<String, SparseArray<Parcelable>> snapshot = this.mChildStates.snapshot();
        Bundle bundle = new Bundle();
        for (Map.Entry next : snapshot.entrySet()) {
            bundle.putSparseParcelableArray((String) next.getKey(), (SparseArray) next.getValue());
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void saveOffscreenView(View view, int i5) {
        int i6 = this.mSavePolicy;
        if (i6 == 1) {
            remove(i5);
        } else if (i6 == 2 || i6 == 3) {
            saveViewUnchecked(view, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle saveOnScreenView(Bundle bundle, View view, int i5) {
        if (this.mSavePolicy != 0) {
            String saveStatesKey = getSaveStatesKey(i5);
            SparseArray sparseArray = new SparseArray();
            view.saveHierarchyState(sparseArray);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(saveStatesKey, sparseArray);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void setLimitNumber(int i5) {
        this.mLimitNumber = i5;
        applyPolicyChanges();
    }

    /* access modifiers changed from: package-private */
    public void setSavePolicy(int i5) {
        this.mSavePolicy = i5;
        applyPolicyChanges();
    }
}
