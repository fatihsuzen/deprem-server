package B3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import q3.C2729e;

public final class y {
    private volatile AtomicReferenceArray<Object> array;

    public y(int i5) {
        this.array = new AtomicReferenceArray<>(i5);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int i5) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i5 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i5);
        }
        return null;
    }

    public final void c(int i5, Object obj) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i5 < length) {
            atomicReferenceArray.set(i5, obj);
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(C2729e.c(i5 + 1, length * 2));
        for (int i6 = 0; i6 < length; i6++) {
            atomicReferenceArray2.set(i6, atomicReferenceArray.get(i6));
        }
        atomicReferenceArray2.set(i5, obj);
        this.array = atomicReferenceArray2;
    }
}
