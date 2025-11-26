package W2;

import X2.C2242i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class A implements Collection, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f19923a;

    private static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f19924a;

        /* renamed from: b  reason: collision with root package name */
        private int f19925b;

        public a(byte[] bArr) {
            t.e(bArr, "array");
            this.f19924a = bArr;
        }

        public byte a() {
            int i5 = this.f19925b;
            byte[] bArr = this.f19924a;
            if (i5 < bArr.length) {
                this.f19925b = i5 + 1;
                return z.b(bArr[i5]);
            }
            throw new NoSuchElementException(String.valueOf(this.f19925b));
        }

        public boolean hasNext() {
            if (this.f19925b < this.f19924a.length) {
                return true;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return z.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ A(byte[] bArr) {
        this.f19923a = bArr;
    }

    public static final /* synthetic */ A c(byte[] bArr) {
        return new A(bArr);
    }

    public static byte[] f(int i5) {
        return g(new byte[i5]);
    }

    public static byte[] g(byte[] bArr) {
        t.e(bArr, "storage");
        return bArr;
    }

    public static boolean j(byte[] bArr, byte b5) {
        return C2242i.I(bArr, b5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(byte[] r3, java.util.Collection r4) {
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
            boolean r2 = r0 instanceof W2.z
            if (r2 == 0) goto L_0x0031
            W2.z r0 = (W2.z) r0
            byte r0 = r0.f()
            boolean r0 = X2.C2242i.I(r3, r0)
            if (r0 == 0) goto L_0x0031
            goto L_0x0016
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.A.k(byte[], java.util.Collection):boolean");
    }

    public static boolean l(byte[] bArr, Object obj) {
        if ((obj instanceof A) && t.a(bArr, ((A) obj).v())) {
            return true;
        }
        return false;
    }

    public static final byte n(byte[] bArr, int i5) {
        return z.b(bArr[i5]);
    }

    public static int p(byte[] bArr) {
        return bArr.length;
    }

    public static int q(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean r(byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator s(byte[] bArr) {
        return new a(bArr);
    }

    public static final void t(byte[] bArr, int i5, byte b5) {
        bArr[i5] = b5;
    }

    public static String u(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
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
        if (!(obj instanceof z)) {
            return false;
        }
        return i(((z) obj).f());
    }

    public boolean containsAll(Collection collection) {
        t.e(collection, "elements");
        return k(this.f19923a, collection);
    }

    public boolean equals(Object obj) {
        return l(this.f19923a, obj);
    }

    public int hashCode() {
        return q(this.f19923a);
    }

    public boolean i(byte b5) {
        return j(this.f19923a, b5);
    }

    public boolean isEmpty() {
        return r(this.f19923a);
    }

    public Iterator iterator() {
        return s(this.f19923a);
    }

    /* renamed from: o */
    public int size() {
        return p(this.f19923a);
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
        return u(this.f19923a);
    }

    public final /* synthetic */ byte[] v() {
        return this.f19923a;
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        return C2632j.b(this, objArr);
    }
}
