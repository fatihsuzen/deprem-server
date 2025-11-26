package androidx.collection;

import X2.C2242i;
import X2.C2250q;
import androidx.annotation.IntRange;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import k3.l;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;
import l3.C2678b;
import q3.C2728d;
import q3.C2729e;
import s3.C2751e;
import s3.C2754h;

public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    private static final class MutableObjectListIterator<T> implements ListIterator<T>, C2677a {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list2, int i5) {
            t.e(list2, "list");
            this.list = list2;
            this.prevIndex = i5 - 1;
        }

        public void add(T t5) {
            List<T> list2 = this.list;
            int i5 = this.prevIndex + 1;
            this.prevIndex = i5;
            list2.add(i5, t5);
        }

        public boolean hasNext() {
            if (this.prevIndex < this.list.size() - 1) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            if (this.prevIndex >= 0) {
                return true;
            }
            return false;
        }

        public T next() {
            List<T> list2 = this.list;
            int i5 = this.prevIndex + 1;
            this.prevIndex = i5;
            return list2.get(i5);
        }

        public int nextIndex() {
            return this.prevIndex + 1;
        }

        public T previous() {
            List<T> list2 = this.list;
            int i5 = this.prevIndex;
            this.prevIndex = i5 - 1;
            return list2.get(i5);
        }

        public int previousIndex() {
            return this.prevIndex;
        }

        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        public void set(T t5) {
            this.list.set(this.prevIndex, t5);
        }
    }

    private static final class ObjectListMutableList<T> implements List<T>, C2678b {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> mutableObjectList) {
            t.e(mutableObjectList, "objectList");
            this.objectList = mutableObjectList;
        }

        public boolean add(T t5) {
            return this.objectList.add(t5);
        }

        public boolean addAll(int i5, Collection<? extends T> collection) {
            t.e(collection, "elements");
            return this.objectList.addAll(i5, collection);
        }

        public void clear() {
            this.objectList.clear();
        }

        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            return this.objectList.containsAll(collection);
        }

        public T get(int i5) {
            ObjectListKt.checkIndex(this, i5);
            return this.objectList.get(i5);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        public final /* bridge */ T remove(int i5) {
            return removeAt(i5);
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            return this.objectList.removeAll(collection);
        }

        public T removeAt(int i5) {
            ObjectListKt.checkIndex(this, i5);
            return this.objectList.removeAt(i5);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            return this.objectList.retainAll(collection);
        }

        public T set(int i5, T t5) {
            ObjectListKt.checkIndex(this, i5);
            return this.objectList.set(i5, t5);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public List<T> subList(int i5, int i6) {
            ObjectListKt.checkSubIndex(this, i5, i6);
            return new SubList(this, i5, i6);
        }

        public Object[] toArray() {
            return C2632j.a(this);
        }

        public void add(int i5, T t5) {
            this.objectList.add(i5, t5);
        }

        public boolean addAll(Collection<? extends T> collection) {
            t.e(collection, "elements");
            return this.objectList.addAll(collection);
        }

        public ListIterator<T> listIterator(int i5) {
            return new MutableObjectListIterator(this, i5);
        }

        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        public <T> T[] toArray(T[] tArr) {
            t.e(tArr, "array");
            return C2632j.b(this, tArr);
        }
    }

    private static final class SubList<T> implements List<T>, C2678b {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list2, int i5, int i6) {
            t.e(list2, "list");
            this.list = list2;
            this.start = i5;
            this.end = i6;
        }

        public boolean add(T t5) {
            List<T> list2 = this.list;
            int i5 = this.end;
            this.end = i5 + 1;
            list2.add(i5, t5);
            return true;
        }

        public boolean addAll(int i5, Collection<? extends T> collection) {
            t.e(collection, "elements");
            this.list.addAll(i5 + this.start, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }

        public void clear() {
            int i5 = this.end - 1;
            int i6 = this.start;
            if (i6 <= i5) {
                while (true) {
                    this.list.remove(i5);
                    if (i5 == i6) {
                        break;
                    }
                    i5--;
                }
            }
            this.end = this.start;
        }

        public boolean contains(Object obj) {
            int i5 = this.end;
            for (int i6 = this.start; i6 < i5; i6++) {
                if (t.a(this.list.get(i6), obj)) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public T get(int i5) {
            ObjectListKt.checkIndex(this, i5);
            return this.list.get(i5 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        public int indexOf(Object obj) {
            int i5 = this.end;
            for (int i6 = this.start; i6 < i5; i6++) {
                if (t.a(this.list.get(i6), obj)) {
                    return i6 - this.start;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            if (this.end == this.start) {
                return true;
            }
            return false;
        }

        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        public int lastIndexOf(Object obj) {
            int i5 = this.end - 1;
            int i6 = this.start;
            if (i6 > i5) {
                return -1;
            }
            while (!t.a(this.list.get(i5), obj)) {
                if (i5 == i6) {
                    return -1;
                }
                i5--;
            }
            return i5 - this.start;
        }

        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        public final /* bridge */ T remove(int i5) {
            return removeAt(i5);
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            int i5 = this.end;
            for (Object remove : collection) {
                remove(remove);
            }
            if (i5 != this.end) {
                return true;
            }
            return false;
        }

        public T removeAt(int i5) {
            ObjectListKt.checkIndex(this, i5);
            this.end--;
            return this.list.remove(i5 + this.start);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            t.e(collection, "elements");
            int i5 = this.end;
            int i6 = i5 - 1;
            int i7 = this.start;
            if (i7 <= i6) {
                while (true) {
                    if (!collection.contains(this.list.get(i6))) {
                        this.list.remove(i6);
                        this.end--;
                    }
                    if (i6 == i7) {
                        break;
                    }
                    i6--;
                }
            }
            if (i5 != this.end) {
                return true;
            }
            return false;
        }

        public T set(int i5, T t5) {
            ObjectListKt.checkIndex(this, i5);
            return this.list.set(i5 + this.start, t5);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public List<T> subList(int i5, int i6) {
            ObjectListKt.checkSubIndex(this, i5, i6);
            return new SubList(this, i5, i6);
        }

        public Object[] toArray() {
            return C2632j.a(this);
        }

        public void add(int i5, T t5) {
            this.list.add(i5 + this.start, t5);
            this.end++;
        }

        public ListIterator<T> listIterator(int i5) {
            return new MutableObjectListIterator(this, i5);
        }

        public boolean remove(Object obj) {
            int i5 = this.end;
            for (int i6 = this.start; i6 < i5; i6++) {
                if (t.a(this.list.get(i6), obj)) {
                    this.list.remove(i6);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        public <T> T[] toArray(T[] tArr) {
            t.e(tArr, "array");
            return C2632j.b(this, tArr);
        }

        public boolean addAll(Collection<? extends T> collection) {
            t.e(collection, "elements");
            this.list.addAll(this.end, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }
    }

    public MutableObjectList() {
        this(0, 1, (C2633k) null);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableObjectList._size;
        }
        mutableObjectList.trim(i5);
    }

    public final boolean add(E e5) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i5 = this._size;
        objArr[i5] = e5;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, E[] eArr) {
        int i6;
        t.e(eArr, "elements");
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (eArr.length == 0) {
            return false;
        } else {
            ensureCapacity(i6 + eArr.length);
            Object[] objArr = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                C2242i.l(objArr, objArr, eArr.length + i5, i5, i7);
            }
            E[] eArr2 = eArr;
            C2242i.q(eArr2, objArr, i5, 0, 0, 12, (Object) null);
            this._size += eArr2.length;
            return true;
        }
    }

    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        C2242i.v(this.content, (Object) null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        Object[] objArr = this.content;
        if (objArr.length < i5) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i5, (objArr.length * 3) / 2));
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(E e5) {
        remove(e5);
    }

    public final void plusAssign(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        if (!objectList.isEmpty()) {
            ensureCapacity(this._size + objectList._size);
            C2242i.l(objectList.content, this.content, this._size, 0, objectList._size);
            this._size += objectList._size;
        }
    }

    public final boolean remove(E e5) {
        int indexOf = indexOf(e5);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(E[] eArr) {
        t.e(eArr, "elements");
        int i5 = this._size;
        for (E remove : eArr) {
            remove(remove);
        }
        if (i5 != this._size) {
            return true;
        }
        return false;
    }

    public final E removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i5);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        E[] eArr = this.content;
        E e5 = eArr[i5];
        if (i5 != i6 - 1) {
            C2242i.l(eArr, eArr, i5, i5 + 1, i6);
        }
        int i7 = this._size - 1;
        this._size = i7;
        eArr[i7] = null;
        return e5;
    }

    public final void removeIf(l lVar) {
        t.e(lVar, "predicate");
        int i5 = this._size;
        Object[] objArr = this.content;
        int i6 = 0;
        C2728d l5 = C2729e.l(0, i5);
        int c5 = l5.c();
        int f5 = l5.f();
        if (c5 <= f5) {
            while (true) {
                objArr[c5 - i6] = objArr[c5];
                if (((Boolean) lVar.invoke(objArr[c5])).booleanValue()) {
                    i6++;
                }
                if (c5 == f5) {
                    break;
                }
                c5++;
            }
        }
        C2242i.v(objArr, (Object) null, i5 - i6, i5);
        this._size -= i6;
    }

    public final void removeRange(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size) || i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException("Start (" + i5 + ") and end (" + i6 + ") must be in 0.." + this._size);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("Start (" + i5 + ") is more than end (" + i6 + ')');
        } else if (i6 != i5) {
            if (i6 < i7) {
                Object[] objArr = this.content;
                C2242i.l(objArr, objArr, i5, i6, i7);
            }
            int i8 = this._size;
            int i9 = i8 - (i6 - i5);
            C2242i.v(this.content, (Object) null, i9, i8);
            this._size = i9;
        }
    }

    public final boolean retainAll(E[] eArr) {
        t.e(eArr, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (C2242i.X(eArr, objArr[i6]) < 0) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final E set(@IntRange(from = 0) int i5, E e5) {
        if (i5 < 0 || i5 >= this._size) {
            StringBuilder sb = new StringBuilder();
            sb.append("set index ");
            sb.append(i5);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        E[] eArr = this.content;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        return e6;
    }

    public final void trim(int i5) {
        int max = Math.max(i5, this._size);
        Object[] objArr = this.content;
        if (objArr.length > max) {
            Object[] copyOf = Arrays.copyOf(objArr, max);
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableObjectList(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(List<? extends E> list2) {
        t.e(list2, "elements");
        int size = list2.size();
        for (int i5 = 0; i5 < size; i5++) {
            remove(list2.get(i5));
        }
    }

    public MutableObjectList(int i5) {
        super(i5, (C2633k) null);
    }

    public final void add(@IntRange(from = 0) int i5, E e5) {
        int i6;
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        }
        ensureCapacity(i6 + 1);
        Object[] objArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            C2242i.l(objArr, objArr, i5 + 1, i5, i7);
        }
        objArr[i5] = e5;
        this._size++;
    }

    public final void minusAssign(E[] eArr) {
        t.e(eArr, "elements");
        for (E remove : eArr) {
            remove(remove);
        }
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        int i5 = this._size;
        minusAssign(objectList);
        return i5 != this._size;
    }

    public final void minusAssign(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        Object[] objArr = objectList.content;
        int i5 = objectList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(objArr[i6]);
        }
    }

    public final boolean retainAll(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!objectList.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        int i5 = this._size;
        minusAssign(scatterSet);
        return i5 != this._size;
    }

    public final void plusAssign(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        if (!scatterSet.isEmpty()) {
            ensureCapacity(this._size + scatterSet.getSize());
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                add(objArr[(i5 << 3) + i7]);
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            return;
                        }
                    }
                    if (i5 != length) {
                        i5++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final boolean addAll(@IntRange(from = 0) int i5, Collection<? extends E> collection) {
        t.e(collection, "elements");
        if (i5 < 0 || i5 > this._size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        }
        int i6 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + collection.size());
        Object[] objArr = this.content;
        if (i5 != this._size) {
            C2242i.l(objArr, objArr, collection.size() + i5, i5, this._size);
        }
        for (Object next : collection) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                C2250q.o();
            }
            objArr[i6 + i5] = next;
            i6 = i7;
        }
        this._size += collection.size();
        return true;
    }

    public final void minusAssign(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            remove(objArr[(i5 << 3) + i7]);
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 != length) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean removeAll(List<? extends E> list2) {
        t.e(list2, "elements");
        int i5 = this._size;
        minusAssign(list2);
        return i5 != this._size;
    }

    public final boolean retainAll(Collection<? extends E> collection) {
        t.e(collection, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!collection.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        int i5 = this._size;
        minusAssign(iterable);
        return i5 != this._size;
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    public final void plusAssign(E[] eArr) {
        t.e(eArr, "elements");
        if (eArr.length != 0) {
            ensureCapacity(this._size + eArr.length);
            E[] eArr2 = eArr;
            C2242i.q(eArr2, this.content, this._size, 0, 0, 12, (Object) null);
            this._size += eArr2.length;
        }
    }

    public final boolean removeAll(C2751e eVar) {
        t.e(eVar, "elements");
        int i5 = this._size;
        minusAssign(eVar);
        return i5 != this._size;
    }

    public final void minusAssign(C2751e eVar) {
        t.e(eVar, "elements");
        for (Object remove : eVar) {
            remove(remove);
        }
    }

    public final boolean retainAll(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!C2250q.E(iterable, objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final void plusAssign(List<? extends E> list2) {
        t.e(list2, "elements");
        if (!list2.isEmpty()) {
            int i5 = this._size;
            ensureCapacity(list2.size() + i5);
            Object[] objArr = this.content;
            int size = list2.size();
            for (int i6 = 0; i6 < size; i6++) {
                objArr[i6 + i5] = list2.get(i6);
            }
            this._size += list2.size();
        }
    }

    public final boolean addAll(@IntRange(from = 0) int i5, ObjectList<E> objectList) {
        t.e(objectList, "elements");
        if (i5 < 0 || i5 > this._size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (objectList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + objectList._size);
            Object[] objArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                C2242i.l(objArr, objArr, objectList._size + i5, i5, i6);
            }
            C2242i.l(objectList.content, objArr, i5, 0, objectList._size);
            this._size += objectList._size;
            return true;
        }
    }

    public final boolean retainAll(C2751e eVar) {
        t.e(eVar, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!C2754h.k(eVar, objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final void plusAssign(E e5) {
        add(e5);
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        for (Object add : iterable) {
            add(add);
        }
    }

    public final void plusAssign(C2751e eVar) {
        t.e(eVar, "elements");
        for (Object add : eVar) {
            add(add);
        }
    }

    public final boolean addAll(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        int i5 = this._size;
        plusAssign(objectList);
        return i5 != this._size;
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        t.e(scatterSet, "elements");
        int i5 = this._size;
        plusAssign(scatterSet);
        return i5 != this._size;
    }

    public final boolean addAll(E[] eArr) {
        t.e(eArr, "elements");
        int i5 = this._size;
        plusAssign(eArr);
        return i5 != this._size;
    }

    public final boolean addAll(List<? extends E> list2) {
        t.e(list2, "elements");
        int i5 = this._size;
        plusAssign(list2);
        return i5 != this._size;
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        int i5 = this._size;
        plusAssign(iterable);
        return i5 != this._size;
    }

    public final boolean addAll(C2751e eVar) {
        t.e(eVar, "elements");
        int i5 = this._size;
        plusAssign(eVar);
        return i5 != this._size;
    }
}
