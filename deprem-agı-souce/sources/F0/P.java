package f0;

import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.HashSet;
import java.util.Set;

public abstract /* synthetic */ class P {
    public static /* synthetic */ Set a(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        int length = objArr.length;
        int i5 = 0;
        while (i5 < length) {
            Object obj = objArr[i5];
            Objects.requireNonNull(obj);
            if (hashSet.add(obj)) {
                i5++;
            } else {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        return DesugarCollections.unmodifiableSet(hashSet);
    }
}
