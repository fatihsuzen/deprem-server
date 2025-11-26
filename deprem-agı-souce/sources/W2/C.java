package W2;

import X2.C2242i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class C implements Collection, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f19928a;

    private static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f19929a;

        /* renamed from: b  reason: collision with root package name */
        private int f19930b;

        public a(int[] iArr) {
            t.e(iArr, "array");
            this.f19929a = iArr;
        }

        public int a() {
            int i5 = this.f19930b;
            int[] iArr = this.f19929a;
            if (i5 < iArr.length) {
                this.f19930b = i5 + 1;
                return B.b(iArr[i5]);
            }
            throw new NoSuchElementException(String.valueOf(this.f19930b));
        }

        public boolean hasNext() {
            if (this.f19930b < this.f19929a.length) {
                return true;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return B.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ C(int[] iArr) {
        this.f19928a = iArr;
    }

    public static final /* synthetic */ C c(int[] iArr) {
        return new C(iArr);
    }

    public static int[] f(int i5) {
        return g(new int[i5]);
    }

    public static int[] g(int[] iArr) {
        t.e(iArr, "storage");
        return iArr;
    }

    public static boolean j(int[] iArr, int i5) {
        return C2242i.J(iArr, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(int[] r3, java.util.Collection r4) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            java.util.Iterator r4 = r4.iterator()
        L_0x0016:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = r4.next()
            boolean r2 = r0 instanceof W2.B
            if (r2 == 0) goto L_0x0031
            W2.B r0 = (W2.B) r0
            int r0 = r0.f()
            boolean r0 = X2.C2242i.J(r3, r0)
            if (r0 == 0) goto L_0x0031
            goto L_0x0016
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.C.k(int[], java.util.Collection):boolean");
    }

    public static boolean l(int[] iArr, Object obj) {
        if ((obj instanceof C) && t.a(iArr, ((C) obj).v())) {
            return true;
        }
        return false;
    }

    public static final int n(int[] iArr, int i5) {
        return B.b(iArr[i5]);
    }

    public static int p(int[] iArr) {
        return iArr.length;
    }

    public static int q(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean r(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator s(int[] iArr) {
        return new a(iArr);
    }

    public static final void t(int[] iArr, int i5, int i6) {
        iArr[i5] = i6;
    }

    public static String u(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        return i(((B) obj).f());
    }

    public boolean containsAll(Collection collection) {
        t.e(collection, "elements");
        return k(this.f19928a, collection);
    }

    public boolean equals(Object obj) {
        return l(this.f19928a, obj);
    }

    public int hashCode() {
        return q(this.f19928a);
    }

    public boolean i(int i5) {
        return j(this.f19928a, i5);
    }

    public boolean isEmpty() {
        return r(this.f19928a);
    }

    public Iterator iterator() {
        return s(this.f19928a);
    }

    /* renamed from: o */
    public int size() {
        return p(this.f19928a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public String toString() {
        return u(this.f19928a);
    }

    public final /* synthetic */ int[] v() {
        return this.f19928a;
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        return C2632j.b(this, objArr);
    }
}
