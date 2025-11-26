package androidx.collection;

import X2.C2250q;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class MutableScatterMap$MutableMapWrapper$values$1 implements Collection<V>, C2678b {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$values$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    public boolean add(V v5) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        t.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object obj) {
        return this.this$0.containsValue(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        t.e(collection, "elements");
        Iterable<Object> iterable = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object containsValue : iterable) {
            if (!mutableScatterMap.containsValue(containsValue)) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator<V> iterator() {
        return new MutableScatterMap$MutableMapWrapper$values$1$iterator$1(this.this$0);
    }

    public boolean remove(Object obj) {
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (t.a(mutableScatterMap.values[i8], obj)) {
                                mutableScatterMap.removeValueAt(i8);
                                return true;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        t.e(collection2, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (C2250q.E(collection2, mutableScatterMap.values[i8])) {
                            mutableScatterMap.removeValueAt(i8);
                            z4 = true;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return z4;
                }
            }
            if (i5 == length) {
                return z4;
            }
            i5++;
        }
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        t.e(collection2, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!C2250q.E(collection2, mutableScatterMap.values[i8])) {
                            mutableScatterMap.removeValueAt(i8);
                            z4 = true;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return z4;
                }
            }
            if (i5 == length) {
                return z4;
            }
            i5++;
        }
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        t.e(tArr, "array");
        return C2632j.b(this, tArr);
    }
}
