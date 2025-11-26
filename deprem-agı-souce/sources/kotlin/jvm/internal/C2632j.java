package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: kotlin.jvm.internal.j  reason: case insensitive filesystem */
public abstract class C2632j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f24716a = new Object[0];

    public static final Object[] a(Collection collection) {
        t.e(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return f24716a;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return f24716a;
        }
        Object[] objArr = new Object[size];
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            objArr[i5] = it.next();
            if (i6 >= objArr.length) {
                if (!it.hasNext()) {
                    return objArr;
                }
                int i7 = ((i6 * 3) + 1) >>> 1;
                if (i7 <= i6) {
                    i7 = 2147483645;
                    if (i6 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr = Arrays.copyOf(objArr, i7);
                t.d(objArr, "copyOf(...)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr, i6);
                t.d(copyOf, "copyOf(...)");
                return copyOf;
            }
            i5 = i6;
        }
    }

    public static final Object[] b(Collection collection, Object[] objArr) {
        Object[] objArr2;
        t.e(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i5 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    t.c(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i6 = i5 + 1;
                    objArr2[i5] = it.next();
                    if (i6 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i7 = ((i6 * 3) + 1) >>> 1;
                        if (i7 <= i6) {
                            i7 = 2147483645;
                            if (i6 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i7);
                        t.d(objArr2, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i6] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i6);
                        t.d(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i5 = i6;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }
}
