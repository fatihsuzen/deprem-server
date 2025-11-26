package W2;

import X2.C2242i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class H implements Collection, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final short[] f19939a;

    private static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final short[] f19940a;

        /* renamed from: b  reason: collision with root package name */
        private int f19941b;

        public a(short[] sArr) {
            t.e(sArr, "array");
            this.f19940a = sArr;
        }

        public short a() {
            int i5 = this.f19941b;
            short[] sArr = this.f19940a;
            if (i5 < sArr.length) {
                this.f19941b = i5 + 1;
                return G.b(sArr[i5]);
            }
            throw new NoSuchElementException(String.valueOf(this.f19941b));
        }

        public boolean hasNext() {
            if (this.f19941b < this.f19940a.length) {
                return true;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return G.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ H(short[] sArr) {
        this.f19939a = sArr;
    }

    public static final /* synthetic */ H c(short[] sArr) {
        return new H(sArr);
    }

    public static short[] f(int i5) {
        return g(new short[i5]);
    }

    public static short[] g(short[] sArr) {
        t.e(sArr, "storage");
        return sArr;
    }

    public static boolean j(short[] sArr, short s5) {
        return C2242i.M(sArr, s5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(short[] r3, java.util.Collection r4) {
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
            boolean r2 = r0 instanceof W2.G
            if (r2 == 0) goto L_0x0031
            W2.G r0 = (W2.G) r0
            short r0 = r0.f()
            boolean r0 = X2.C2242i.M(r3, r0)
            if (r0 == 0) goto L_0x0031
            goto L_0x0016
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.H.k(short[], java.util.Collection):boolean");
    }

    public static boolean l(short[] sArr, Object obj) {
        if ((obj instanceof H) && t.a(sArr, ((H) obj).v())) {
            return true;
        }
        return false;
    }

    public static final short n(short[] sArr, int i5) {
        return G.b(sArr[i5]);
    }

    public static int p(short[] sArr) {
        return sArr.length;
    }

    public static int q(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean r(short[] sArr) {
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator s(short[] sArr) {
        return new a(sArr);
    }

    public static final void t(short[] sArr, int i5, short s5) {
        sArr[i5] = s5;
    }

    public static String u(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
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
        if (!(obj instanceof G)) {
            return false;
        }
        return i(((G) obj).f());
    }

    public boolean containsAll(Collection collection) {
        t.e(collection, "elements");
        return k(this.f19939a, collection);
    }

    public boolean equals(Object obj) {
        return l(this.f19939a, obj);
    }

    public int hashCode() {
        return q(this.f19939a);
    }

    public boolean i(short s5) {
        return j(this.f19939a, s5);
    }

    public boolean isEmpty() {
        return r(this.f19939a);
    }

    public Iterator iterator() {
        return s(this.f19939a);
    }

    /* renamed from: o */
    public int size() {
        return p(this.f19939a);
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
        return u(this.f19939a);
    }

    public final /* synthetic */ short[] v() {
        return this.f19939a;
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        return C2632j.b(this, objArr);
    }
}
