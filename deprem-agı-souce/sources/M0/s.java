package m0;

import java.lang.reflect.Array;
import java.util.Arrays;

abstract class s {
    static Object[] a(Object[] objArr, int i5, int i6, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i5, i6, objArr2.getClass());
    }

    static Object[] b(Object[] objArr, int i5) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i5);
    }
}
