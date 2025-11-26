package androidx.collection;

import b3.C2308e;
import java.util.Iterator;
import l3.C2677a;
import s3.C2754h;

public final class MutableScatterMap$MutableMapWrapper$values$1$iterator$1 implements Iterator<V>, C2677a {
    private int current = -1;
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$values$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = C2754h.a(new MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(mutableScatterMap, (C2308e) null));
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public V next() {
        int intValue = this.iterator.next().intValue();
        this.current = intValue;
        return this.this$0.values[intValue];
    }

    public void remove() {
        int i5 = this.current;
        if (i5 >= 0) {
            this.this$0.removeValueAt(i5);
            this.current = -1;
        }
    }
}
