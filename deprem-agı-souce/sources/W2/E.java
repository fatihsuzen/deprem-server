package W2;

import X2.C2242i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class E implements Collection, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f19933a;

    private static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final long[] f19934a;

        /* renamed from: b  reason: collision with root package name */
        private int f19935b;

        public a(long[] jArr) {
            t.e(jArr, "array");
            this.f19934a = jArr;
        }

        public long a() {
            int i5 = this.f19935b;
            long[] jArr = this.f19934a;
            if (i5 < jArr.length) {
                this.f19935b = i5 + 1;
                return D.b(jArr[i5]);
            }
            throw new NoSuchElementException(String.valueOf(this.f19935b));
        }

        public boolean hasNext() {
            if (this.f19935b < this.f19934a.length) {
                return true;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return D.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ E(long[] jArr) {
        this.f19933a = jArr;
    }

    public static final /* synthetic */ E c(long[] jArr) {
        return new E(jArr);
    }

    public static long[] f(int i5) {
        return g(new long[i5]);
    }

    public static long[] g(long[] jArr) {
        t.e(jArr, "storage");
        return jArr;
    }

    public static boolean j(long[] jArr, long j5) {
        return C2242i.K(jArr, j5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(long[] r4, java.util.Collection r5) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.t.e(r5, r0)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            java.util.Iterator r5 = r5.iterator()
        L_0x0016:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = r5.next()
            boolean r2 = r0 instanceof W2.D
            if (r2 == 0) goto L_0x0031
            W2.D r0 = (W2.D) r0
            long r2 = r0.f()
            boolean r0 = X2.C2242i.K(r4, r2)
            if (r0 == 0) goto L_0x0031
            goto L_0x0016
        L_0x0031:
            r4 = 0
            return r4
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.E.k(long[], java.util.Collection):boolean");
    }

    public static boolean l(long[] jArr, Object obj) {
        if ((obj instanceof E) && t.a(jArr, ((E) obj).v())) {
            return true;
        }
        return false;
    }

    public static final long n(long[] jArr, int i5) {
        return D.b(jArr[i5]);
    }

    public static int p(long[] jArr) {
        return jArr.length;
    }

    public static int q(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean r(long[] jArr) {
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator s(long[] jArr) {
        return new a(jArr);
    }

    public static final void t(long[] jArr, int i5, long j5) {
        jArr[i5] = j5;
    }

    public static String u(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
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
        if (!(obj instanceof D)) {
            return false;
        }
        return i(((D) obj).f());
    }

    public boolean containsAll(Collection collection) {
        t.e(collection, "elements");
        return k(this.f19933a, collection);
    }

    public boolean equals(Object obj) {
        return l(this.f19933a, obj);
    }

    public int hashCode() {
        return q(this.f19933a);
    }

    public boolean i(long j5) {
        return j(this.f19933a, j5);
    }

    public boolean isEmpty() {
        return r(this.f19933a);
    }

    public Iterator iterator() {
        return s(this.f19933a);
    }

    /* renamed from: o */
    public int size() {
        return p(this.f19933a);
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
        return u(this.f19933a);
    }

    public final /* synthetic */ long[] v() {
        return this.f19933a;
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        return C2632j.b(this, objArr);
    }
}
