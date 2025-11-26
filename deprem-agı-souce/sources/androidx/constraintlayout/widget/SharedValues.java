package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues = new SparseIntArray();
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners = new HashMap<>();

    public interface SharedValuesListener {
        void onNewValue(int i5, int i6, int i7);
    }

    public void addListener(int i5, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i5));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.mValuesListeners.put(Integer.valueOf(i5), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public void fireNewValue(int i5, int i6) {
        int i7 = this.mValues.get(i5, -1);
        if (i7 != i6) {
            this.mValues.put(i5, i6);
            HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i5));
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                boolean z4 = false;
                while (it.hasNext()) {
                    SharedValuesListener sharedValuesListener = (SharedValuesListener) ((WeakReference) it.next()).get();
                    if (sharedValuesListener != null) {
                        sharedValuesListener.onNewValue(i5, i6, i7);
                    } else {
                        z4 = true;
                    }
                }
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        WeakReference weakReference = (WeakReference) it2.next();
                        if (((SharedValuesListener) weakReference.get()) == null) {
                            arrayList.add(weakReference);
                        }
                    }
                    hashSet.removeAll(arrayList);
                }
            }
        }
    }

    public int getValue(int i5) {
        return this.mValues.get(i5, -1);
    }

    public void removeListener(int i5, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i5));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
                if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        for (Integer intValue : this.mValuesListeners.keySet()) {
            removeListener(intValue.intValue(), sharedValuesListener);
        }
    }
}
