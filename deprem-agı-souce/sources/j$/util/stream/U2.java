package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.f0;
import java.util.Comparator;

public abstract class U2 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f1587a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1588b;

    /* renamed from: c  reason: collision with root package name */
    public int f1589c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1590d;

    /* renamed from: e  reason: collision with root package name */
    public Object f1591e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ V2 f1592f;

    public abstract void a(int i5, Object obj, Object obj2);

    public abstract f0 b(Object obj, int i5, int i6);

    public abstract f0 c(int i5, int i6, int i7, int i8);

    public final int characteristics() {
        return 16464;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    static {
        Class<W2> cls = W2.class;
    }

    public U2(V2 v22, int i5, int i6, int i7, int i8) {
        this.f1592f = v22;
        this.f1587a = i5;
        this.f1588b = i6;
        this.f1589c = i7;
        this.f1590d = i8;
        Object[] objArr = v22.f1596f;
        this.f1591e = objArr == null ? v22.f1595e : objArr[i5];
    }

    public final long estimateSize() {
        int i5 = this.f1587a;
        int i6 = this.f1590d;
        int i7 = this.f1588b;
        if (i5 == i7) {
            return ((long) i6) - ((long) this.f1589c);
        }
        long[] jArr = this.f1592f.f1679d;
        return ((jArr[i7] + ((long) i6)) - jArr[i5]) - ((long) this.f1589c);
    }

    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        int i5 = this.f1587a;
        int i6 = this.f1588b;
        if (i5 >= i6 && (i5 != i6 || this.f1589c >= this.f1590d)) {
            return false;
        }
        Object obj2 = this.f1591e;
        int i7 = this.f1589c;
        this.f1589c = i7 + 1;
        a(i7, obj2, obj);
        int i8 = this.f1589c;
        Object obj3 = this.f1591e;
        V2 v22 = this.f1592f;
        if (i8 == v22.q(obj3)) {
            this.f1589c = 0;
            int i9 = this.f1587a + 1;
            this.f1587a = i9;
            Object[] objArr = v22.f1596f;
            if (objArr != null && i9 <= i6) {
                this.f1591e = objArr[i9];
            }
        }
        return true;
    }

    public final void forEachRemaining(Object obj) {
        V2 v22;
        Objects.requireNonNull(obj);
        int i5 = this.f1587a;
        int i6 = this.f1590d;
        int i7 = this.f1588b;
        if (i5 < i7 || (i5 == i7 && this.f1589c < i6)) {
            int i8 = this.f1589c;
            while (true) {
                v22 = this.f1592f;
                if (i5 >= i7) {
                    break;
                }
                Object obj2 = v22.f1596f[i5];
                v22.p(obj2, i8, v22.q(obj2), obj);
                i5++;
                i8 = 0;
            }
            v22.p(this.f1587a == i7 ? this.f1591e : v22.f1596f[i7], i8, i6, obj);
            this.f1587a = i7;
            this.f1589c = i6;
        }
    }

    public final f0 trySplit() {
        int i5 = this.f1587a;
        int i6 = this.f1588b;
        if (i5 < i6) {
            int i7 = i6 - 1;
            int i8 = this.f1589c;
            V2 v22 = this.f1592f;
            f0 c5 = c(i5, i7, i8, v22.q(v22.f1596f[i7]));
            this.f1587a = i6;
            this.f1589c = 0;
            this.f1591e = v22.f1596f[i6];
            return c5;
        } else if (i5 != i6) {
            return null;
        } else {
            int i9 = this.f1589c;
            int i10 = (this.f1590d - i9) / 2;
            if (i10 == 0) {
                return null;
            }
            f0 b5 = b(this.f1591e, i9, i10);
            this.f1589c += i10;
            return b5;
        }
    }
}
