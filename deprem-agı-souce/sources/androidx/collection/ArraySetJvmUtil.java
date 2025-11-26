package androidx.collection;

import java.lang.reflect.Array;

class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    static <T> T[] resizeForToArray(T[] tArr, int i5) {
        if (tArr.length < i5) {
            return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5);
        }
        if (tArr.length > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }
}
