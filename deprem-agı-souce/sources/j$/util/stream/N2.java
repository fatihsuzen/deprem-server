package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.l0;
import java.util.Comparator;
import java.util.function.Consumer;

public final class N2 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public int f1547a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1548b;

    /* renamed from: c  reason: collision with root package name */
    public int f1549c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1550d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f1551e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ W2 f1552f;

    public final int characteristics() {
        return 16464;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    static {
        Class<W2> cls = W2.class;
    }

    public N2(W2 w22, int i5, int i6, int i7, int i8) {
        this.f1552f = w22;
        this.f1547a = i5;
        this.f1548b = i6;
        this.f1549c = i7;
        this.f1550d = i8;
        Object[][] objArr = w22.f1599f;
        this.f1551e = objArr == null ? w22.f1598e : objArr[i5];
    }

    public final long estimateSize() {
        int i5 = this.f1547a;
        int i6 = this.f1550d;
        int i7 = this.f1548b;
        if (i5 == i7) {
            return ((long) i6) - ((long) this.f1549c);
        }
        long[] jArr = this.f1552f.f1679d;
        return ((jArr[i7] + ((long) i6)) - jArr[i5]) - ((long) this.f1549c);
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i5 = this.f1547a;
        int i6 = this.f1548b;
        if (i5 >= i6 && (i5 != i6 || this.f1549c >= this.f1550d)) {
            return false;
        }
        Object[] objArr = this.f1551e;
        int i7 = this.f1549c;
        this.f1549c = i7 + 1;
        consumer.accept(objArr[i7]);
        if (this.f1549c == this.f1551e.length) {
            this.f1549c = 0;
            int i8 = this.f1547a + 1;
            this.f1547a = i8;
            Object[][] objArr2 = this.f1552f.f1599f;
            if (objArr2 != null && i8 <= i6) {
                this.f1551e = objArr2[i8];
            }
        }
        return true;
    }

    public final void forEachRemaining(Consumer consumer) {
        W2 w22;
        Objects.requireNonNull(consumer);
        int i5 = this.f1547a;
        int i6 = this.f1550d;
        int i7 = this.f1548b;
        if (i5 < i7 || (i5 == i7 && this.f1549c < i6)) {
            int i8 = this.f1549c;
            while (true) {
                w22 = this.f1552f;
                if (i5 >= i7) {
                    break;
                }
                Object[] objArr = w22.f1599f[i5];
                while (i8 < objArr.length) {
                    consumer.accept(objArr[i8]);
                    i8++;
                }
                i5++;
                i8 = 0;
            }
            Object[] objArr2 = this.f1547a == i7 ? this.f1551e : w22.f1599f[i7];
            while (i8 < i6) {
                consumer.accept(objArr2[i8]);
                i8++;
            }
            this.f1547a = i7;
            this.f1549c = i6;
        }
    }

    public final Spliterator trySplit() {
        int i5 = this.f1547a;
        int i6 = this.f1548b;
        if (i5 < i6) {
            int i7 = i6 - 1;
            int i8 = this.f1549c;
            W2 w22 = this.f1552f;
            N2 n22 = new N2(w22, i5, i7, i8, w22.f1599f[i7].length);
            this.f1547a = i6;
            this.f1549c = 0;
            this.f1551e = w22.f1599f[i6];
            return n22;
        } else if (i5 != i6) {
            return null;
        } else {
            int i9 = this.f1549c;
            int i10 = (this.f1550d - i9) / 2;
            if (i10 == 0) {
                return null;
            }
            l0 v5 = C0469e.v(this.f1551e, i9, i9 + i10);
            this.f1549c += i10;
            return v5;
        }
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }
}
