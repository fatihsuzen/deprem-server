package m0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import m0.h;

public abstract class i extends h implements List, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final C1711A f15557b = new b(t.f15580e, 0);

    public static final class a extends h.a {
        public a() {
            this(4);
        }

        public a e(Object... objArr) {
            super.b(objArr);
            return this;
        }

        public i f() {
            this.f15556c = true;
            return i.j(this.f15554a, this.f15555b);
        }

        a(int i5) {
            super(i5);
        }
    }

    static class b extends C1712a {

        /* renamed from: c  reason: collision with root package name */
        private final i f15558c;

        b(i iVar, int i5) {
            super(iVar.size(), i5);
            this.f15558c = iVar;
        }

        /* access modifiers changed from: protected */
        public Object a(int i5) {
            return this.f15558c.get(i5);
        }
    }

    class c extends i {

        /* renamed from: c  reason: collision with root package name */
        final transient int f15559c;

        /* renamed from: d  reason: collision with root package name */
        final transient int f15560d;

        c(int i5, int i6) {
            this.f15559c = i5;
            this.f15560d = i6;
        }

        /* access modifiers changed from: package-private */
        public Object[] d() {
            return i.this.d();
        }

        /* access modifiers changed from: package-private */
        public int f() {
            return i.this.g() + this.f15559c + this.f15560d;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return i.this.g() + this.f15559c;
        }

        public Object get(int i5) {
            l0.h.f(i5, this.f15560d);
            return i.this.get(i5 + this.f15559c);
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return i.super.iterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return i.super.listIterator();
        }

        public int size() {
            return this.f15560d;
        }

        /* renamed from: u */
        public i subList(int i5, int i6) {
            l0.h.l(i5, i6, this.f15560d);
            i iVar = i.this;
            int i7 = this.f15559c;
            return iVar.subList(i5 + i7, i6 + i7);
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i5) {
            return i.super.listIterator(i5);
        }
    }

    i() {
    }

    static i i(Object[] objArr) {
        return j(objArr, objArr.length);
    }

    static i j(Object[] objArr, int i5) {
        if (i5 == 0) {
            return p();
        }
        return new t(objArr, i5);
    }

    private static i k(Object... objArr) {
        return i(q.b(objArr));
    }

    public static i p() {
        return t.f15580e;
    }

    public static i q(Object obj, Object obj2) {
        return k(obj, obj2);
    }

    public static i r(Object obj, Object obj2, Object obj3) {
        return k(obj, obj2, obj3);
    }

    public static i s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return k(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static i t(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        boolean z4;
        Object[] objArr2 = objArr;
        if (objArr2.length <= 2147483635) {
            z4 = true;
        } else {
            z4 = false;
        }
        l0.h.e(z4, "the total number of elements must fit in an int");
        Object[] objArr3 = new Object[(objArr2.length + 12)];
        objArr3[0] = obj;
        objArr3[1] = obj2;
        objArr3[2] = obj3;
        objArr3[3] = obj4;
        objArr3[4] = obj5;
        objArr3[5] = obj6;
        objArr3[6] = obj7;
        objArr3[7] = obj8;
        objArr3[8] = obj9;
        objArr3[9] = obj10;
        objArr3[10] = obj11;
        objArr3[11] = obj12;
        System.arraycopy(objArr2, 0, objArr3, 12, objArr2.length);
        return k(objArr3);
    }

    public final void add(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i5 + i6] = get(i6);
        }
        return i5 + size;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        return m.a(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = ~(~((i5 * 31) + get(i6).hashCode()));
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return m.b(this, obj);
    }

    /* renamed from: l */
    public z iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return m.d(this, obj);
    }

    /* renamed from: n */
    public C1711A listIterator() {
        return listIterator(0);
    }

    /* renamed from: o */
    public C1711A listIterator(int i5) {
        l0.h.j(i5, size());
        if (isEmpty()) {
            return f15557b;
        }
        return new b(this, i5);
    }

    public final Object remove(int i5) {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: u */
    public i subList(int i5, int i6) {
        l0.h.l(i5, i6, size());
        int i7 = i6 - i5;
        if (i7 == size()) {
            return this;
        }
        if (i7 == 0) {
            return p();
        }
        return v(i5, i6);
    }

    /* access modifiers changed from: package-private */
    public i v(int i5, int i6) {
        return new c(i5, i6 - i5);
    }
}
