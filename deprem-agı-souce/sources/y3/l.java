package y3;

import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract /* synthetic */ class l {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i5, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i5, obj, obj2)) {
            if (atomicReferenceArray.get(i5) != obj) {
                return false;
            }
        }
        return true;
    }
}
