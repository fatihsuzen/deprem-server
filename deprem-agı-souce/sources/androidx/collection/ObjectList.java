package androidx.collection;

import androidx.annotation.IntRange;
import java.util.List;
import java.util.NoSuchElementException;
import k3.l;
import k3.p;
import k3.q;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int i5, C2633k kVar) {
        this(i5);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                charSequence = ", ";
            }
            if ((i6 & 2) != 0) {
                charSequence2 = "";
            }
            if ((i6 & 4) != 0) {
                charSequence3 = "";
            }
            if ((i6 & 8) != 0) {
                i5 = -1;
            }
            if ((i6 & 16) != 0) {
                charSequence4 = "...";
            }
            if ((i6 & 32) != 0) {
                lVar = null;
            }
            CharSequence charSequence5 = charSequence4;
            l lVar2 = lVar;
            int i7 = i5;
            CharSequence charSequence6 = charSequence2;
            return objectList.joinToString(charSequence, charSequence6, charSequence3, i7, charSequence5, lVar2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public abstract List<E> asList();

    public final boolean contains(E e5) {
        if (indexOf(e5) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsAll(E[] eArr) {
        t.e(eArr, "elements");
        for (E contains : eArr) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E elementAt(@IntRange(from = 0) int i5) {
        if (i5 >= 0 && i5 < this._size) {
            return this.content[i5];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i5);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final E elementAtOrElse(@IntRange(from = 0) int i5, l lVar) {
        t.e(lVar, "defaultValue");
        if (i5 < 0 || i5 >= this._size) {
            return lVar.invoke(Integer.valueOf(i5));
        }
        return this.content[i5];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r7 = (androidx.collection.ObjectList) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.collection.ObjectList
            r1 = 0
            if (r0 == 0) goto L_0x0032
            androidx.collection.ObjectList r7 = (androidx.collection.ObjectList) r7
            int r0 = r7._size
            int r2 = r6._size
            if (r0 == r2) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            java.lang.Object[] r0 = r6.content
            java.lang.Object[] r7 = r7.content
            q3.d r2 = q3.C2729e.l(r1, r2)
            int r3 = r2.c()
            int r2 = r2.f()
            if (r3 > r2) goto L_0x0030
        L_0x0020:
            r4 = r0[r3]
            r5 = r7[r3]
            boolean r4 = kotlin.jvm.internal.t.a(r4, r5)
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            if (r3 == r2) goto L_0x0030
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0030:
            r7 = 1
            return r7
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.equals(java.lang.Object):boolean");
    }

    public final E first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final <R> R fold(R r5, p pVar) {
        t.e(pVar, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r5 = pVar.invoke(r5, objArr[i6]);
        }
        return r5;
    }

    public final <R> R foldIndexed(R r5, q qVar) {
        t.e(qVar, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r5 = qVar.invoke(Integer.valueOf(i6), r5, objArr[i6]);
        }
        return r5;
    }

    public final <R> R foldRight(R r5, p pVar) {
        t.e(pVar, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r5;
            }
            r5 = pVar.invoke(objArr[i5], r5);
        }
    }

    public final <R> R foldRightIndexed(R r5, q qVar) {
        t.e(qVar, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r5;
            }
            r5 = qVar.invoke(Integer.valueOf(i5), objArr[i5], r5);
        }
    }

    public final void forEach(l lVar) {
        t.e(lVar, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            lVar.invoke(objArr[i6]);
        }
    }

    public final void forEachIndexed(p pVar) {
        t.e(pVar, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            pVar.invoke(Integer.valueOf(i6), objArr[i6]);
        }
    }

    public final void forEachReversed(l lVar) {
        t.e(lVar, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                lVar.invoke(objArr[i5]);
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        t.e(pVar, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                pVar.invoke(Integer.valueOf(i5), objArr[i5]);
            } else {
                return;
            }
        }
    }

    public final E get(@IntRange(from = 0) int i5) {
        if (i5 >= 0 && i5 < this._size) {
            return this.content[i5];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i5);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final C2728d getIndices() {
        return C2729e.l(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i5;
        Object[] objArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != null) {
                i5 = obj.hashCode();
            } else {
                i5 = 0;
            }
            i7 += i5 * 31;
        }
        return i7;
    }

    public final int indexOf(E e5) {
        int i5 = 0;
        if (e5 == null) {
            Object[] objArr = this.content;
            int i6 = this._size;
            while (i5 < i6) {
                if (objArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i7 = this._size;
        while (i5 < i7) {
            if (e5.equals(objArr2[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        t.e(lVar, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) lVar.invoke(objArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        t.e(lVar, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
            if (((Boolean) lVar.invoke(objArr[i5])).booleanValue()) {
                return i5;
            }
        }
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 63, (Object) null);
    }

    public final E last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final int lastIndexOf(E e5) {
        if (e5 == null) {
            Object[] objArr = this.content;
            for (int i5 = this._size - 1; -1 < i5; i5--) {
                if (objArr[i5] == null) {
                    return i5;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i6 = this._size - 1; -1 < i6; i6--) {
                if (e5.equals(objArr2[i6])) {
                    return i6;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        t.e(lVar, "predicate");
        Object[] objArr = this.content;
        for (int i5 = this._size - 1; -1 < i5; i5--) {
            if (((Boolean) lVar.invoke(objArr[i5])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, new ObjectList$toString$1(this), 25, (Object) null);
    }

    private ObjectList(int i5) {
        Object[] objArr;
        if (i5 == 0) {
            objArr = ObjectListKt.EmptyArray;
        } else {
            objArr = new Object[i5];
        }
        this.content = objArr;
    }

    public final boolean any(l lVar) {
        t.e(lVar, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) lVar.invoke(objArr[i6])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l lVar) {
        t.e(lVar, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (((Boolean) lVar.invoke(objArr[i7])).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final E firstOrNull(l lVar) {
        t.e(lVar, "predicate");
        E[] eArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            E e5 = eArr[i6];
            if (((Boolean) lVar.invoke(e5)).booleanValue()) {
                return e5;
            }
        }
        return null;
    }

    public final String joinToString(CharSequence charSequence) {
        t.e(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
    }

    public final boolean containsAll(List<? extends E> list) {
        t.e(list, "elements");
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!contains(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, (l) null, 60, (Object) null);
    }

    public final E lastOrNull(l lVar) {
        t.e(lVar, "predicate");
        E[] eArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return null;
            }
            E e5 = eArr[i5];
            if (((Boolean) lVar.invoke(e5)).booleanValue()) {
                return e5;
            }
        }
    }

    public final E first(l lVar) {
        t.e(lVar, "predicate");
        E[] eArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            E e5 = eArr[i6];
            if (((Boolean) lVar.invoke(e5)).booleanValue()) {
                return e5;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, (l) null, 56, (Object) null);
    }

    public final boolean containsAll(Iterable<? extends E> iterable) {
        t.e(iterable, "elements");
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i5, (CharSequence) null, (l) null, 48, (Object) null);
    }

    public final E last(l lVar) {
        t.e(lVar, "predicate");
        E[] eArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                E e5 = eArr[i5];
                if (((Boolean) lVar.invoke(e5)).booleanValue()) {
                    return e5;
                }
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        }
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i5, charSequence4, (l) null, 32, (Object) null);
    }

    public final boolean containsAll(ObjectList<E> objectList) {
        t.e(objectList, "elements");
        Object[] objArr = objectList.content;
        int i5 = objectList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (!contains(objArr[i6])) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        Object[] objArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            Object obj = objArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            if (lVar == null) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) lVar.invoke(obj));
            }
            i7++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
