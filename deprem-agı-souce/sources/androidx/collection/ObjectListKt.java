package androidx.collection;

import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class ObjectListKt {
    /* access modifiers changed from: private */
    public static final Object[] EmptyArray = new Object[0];
    private static final ObjectList<Object> EmptyObjectList = new MutableObjectList(0);

    /* access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i5) {
        int size = list.size();
        if (i5 < 0 || i5 >= size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i5, int i6) {
        int size = list.size();
        if (i5 > i6) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i5 + ") is greater than toIndex (" + i6 + ").");
        } else if (i5 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i5 + ") is less than 0.");
        } else if (i6 > size) {
            throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is more than than the list size (" + size + ')');
        }
    }

    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<Object> objectList = EmptyObjectList;
        t.c(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList<>(0, 1, (C2633k) null);
    }

    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<Object> objectList = EmptyObjectList;
        t.c(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e5) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e5);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E e5) {
        return mutableObjectListOf(e5);
    }

    public static final <E> ObjectList<E> objectListOf(E e5, E e6) {
        return mutableObjectListOf(e5, e6);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e5, E e6) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(2);
        mutableObjectList.add(e5);
        mutableObjectList.add(e6);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E e5, E e6, E e7) {
        return mutableObjectListOf(e5, e6, e7);
    }

    public static final <E> ObjectList<E> objectListOf(E... eArr) {
        t.e(eArr, "elements");
        MutableObjectList mutableObjectList = new MutableObjectList(eArr.length);
        mutableObjectList.plusAssign(eArr);
        return mutableObjectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e5, E e6, E e7) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(3);
        mutableObjectList.add(e5);
        mutableObjectList.add(e6);
        mutableObjectList.add(e7);
        return mutableObjectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E... eArr) {
        t.e(eArr, "elements");
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(eArr.length);
        mutableObjectList.plusAssign(eArr);
        return mutableObjectList;
    }
}
