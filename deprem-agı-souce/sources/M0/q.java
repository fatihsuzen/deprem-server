package m0;

public abstract class q {
    static Object a(Object obj, int i5) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i5);
        throw new NullPointerException(sb.toString());
    }

    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    static Object[] c(Object[] objArr, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            a(objArr[i6], i6);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, int i5) {
        return s.b(objArr, i5);
    }
}
