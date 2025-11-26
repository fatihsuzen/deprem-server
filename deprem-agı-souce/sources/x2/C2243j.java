package X2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.util.Arrays;
import kotlin.jvm.internal.t;

/* renamed from: X2.j  reason: case insensitive filesystem */
abstract class C2243j {
    public static final Object[] a(Object[] objArr, int i5) {
        t.e(objArr, TypedValues.Custom.S_REFERENCE);
        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i5);
        t.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }

    public static int b(Object[] objArr) {
        return Arrays.deepHashCode(objArr);
    }

    public static final void c(int i5, int i6) {
        if (i5 > i6) {
            throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + i6 + ").");
        }
    }
}
