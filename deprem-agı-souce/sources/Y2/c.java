package Y2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;

public abstract class c {
    public static final Object[] d(int i5) {
        if (i5 >= 0) {
            return new Object[i5];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final Object[] e(Object[] objArr, int i5) {
        t.e(objArr, "<this>");
        Object[] copyOf = Arrays.copyOf(objArr, i5);
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final void f(Object[] objArr, int i5) {
        t.e(objArr, "<this>");
        objArr[i5] = null;
    }

    public static final void g(Object[] objArr, int i5, int i6) {
        t.e(objArr, "<this>");
        while (i5 < i6) {
            f(objArr, i5);
            i5++;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean h(Object[] objArr, int i5, int i6, List list) {
        if (i6 != list.size()) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!t.a(objArr[i5 + i7], list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int i(Object[] objArr, int i5, int i6) {
        int i7;
        int i8 = 1;
        for (int i9 = 0; i9 < i6; i9++) {
            Object obj = objArr[i5 + i9];
            int i10 = i8 * 31;
            if (obj != null) {
                i7 = obj.hashCode();
            } else {
                i7 = 0;
            }
            i8 = i10 + i7;
        }
        return i8;
    }

    /* access modifiers changed from: private */
    public static final String j(Object[] objArr, int i5, int i6, Collection collection) {
        StringBuilder sb = new StringBuilder((i6 * 3) + 2);
        sb.append("[");
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            Collection collection2 = objArr[i5 + i7];
            if (collection2 == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(collection2);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }
}
