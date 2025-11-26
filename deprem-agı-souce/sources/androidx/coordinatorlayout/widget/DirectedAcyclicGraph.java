package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t5, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t5)) {
            if (!hashSet.contains(t5)) {
                hashSet.add(t5);
                ArrayList arrayList2 = this.mGraph.get(t5);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        dfs(arrayList2.get(i5), arrayList, hashSet);
                    }
                }
                hashSet.remove(t5);
                arrayList.add(t5);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t5, @NonNull T t6) {
        if (!this.mGraph.containsKey(t5) || !this.mGraph.containsKey(t6)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.mGraph.get(t5);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t5, arrayList);
        }
        arrayList.add(t6);
    }

    public void addNode(@NonNull T t5) {
        if (!this.mGraph.containsKey(t5)) {
            this.mGraph.put(t5, null);
        }
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i5 = 0; i5 < size; i5++) {
            ArrayList valueAt = this.mGraph.valueAt(i5);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t5) {
        return this.mGraph.containsKey(t5);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t5) {
        return this.mGraph.get(t5);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t5) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            ArrayList valueAt = this.mGraph.valueAt(i5);
            if (valueAt != null && valueAt.contains(t5)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i5));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i5 = 0; i5 < size; i5++) {
            dfs(this.mGraph.keyAt(i5), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t5) {
        int size = this.mGraph.size();
        for (int i5 = 0; i5 < size; i5++) {
            ArrayList valueAt = this.mGraph.valueAt(i5);
            if (valueAt != null && valueAt.contains(t5)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.mGraph.size();
    }
}
