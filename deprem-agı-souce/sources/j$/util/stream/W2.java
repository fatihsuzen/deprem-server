package j$.util.stream;

import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class W2 extends C0493c implements Consumer, Iterable {

    /* renamed from: e  reason: collision with root package name */
    public Object[] f1598e = new Object[(1 << 4)];

    /* renamed from: f  reason: collision with root package name */
    public Object[][] f1599f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final void p(long j5) {
        long j6;
        int i5 = this.f1678c;
        if (i5 == 0) {
            j6 = (long) this.f1598e.length;
        } else {
            j6 = this.f1679d[i5] + ((long) this.f1599f[i5].length);
        }
        if (j5 > j6) {
            if (this.f1599f == null) {
                Object[][] objArr = new Object[8][];
                this.f1599f = objArr;
                this.f1679d = new long[8];
                objArr[0] = this.f1598e;
            }
            int i6 = i5 + 1;
            while (j5 > j6) {
                Object[][] objArr2 = this.f1599f;
                if (i6 >= objArr2.length) {
                    int length = objArr2.length * 2;
                    this.f1599f = (Object[][]) Arrays.copyOf(objArr2, length);
                    this.f1679d = Arrays.copyOf(this.f1679d, length);
                }
                int i7 = this.f1676a;
                if (!(i6 == 0 || i6 == 1)) {
                    i7 = Math.min((i7 + i6) - 1, 30);
                }
                int i8 = 1 << i7;
                Object[][] objArr3 = this.f1599f;
                objArr3[i6] = new Object[i8];
                long[] jArr = this.f1679d;
                int i9 = i6 - 1;
                jArr[i6] = jArr[i9] + ((long) objArr3[i9].length);
                j6 += (long) i8;
                i6++;
            }
        }
    }

    public final void clear() {
        Object[][] objArr = this.f1599f;
        if (objArr != null) {
            this.f1598e = objArr[0];
            int i5 = 0;
            while (true) {
                Object[] objArr2 = this.f1598e;
                if (i5 >= objArr2.length) {
                    break;
                }
                objArr2[i5] = null;
                i5++;
            }
            this.f1599f = null;
            this.f1679d = null;
        } else {
            for (int i6 = 0; i6 < this.f1677b; i6++) {
                this.f1598e[i6] = null;
            }
        }
        this.f1677b = 0;
        this.f1678c = 0;
    }

    public final Iterator iterator() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new h0(spliterator);
    }

    public void forEach(Consumer consumer) {
        for (int i5 = 0; i5 < this.f1678c; i5++) {
            for (Object accept : this.f1599f[i5]) {
                consumer.accept(accept);
            }
        }
        for (int i6 = 0; i6 < this.f1677b; i6++) {
            consumer.accept(this.f1598e[i6]);
        }
    }

    public void accept(Object obj) {
        long j5;
        int i5 = this.f1677b;
        Object[] objArr = this.f1598e;
        if (i5 == objArr.length) {
            if (this.f1599f == null) {
                Object[][] objArr2 = new Object[8][];
                this.f1599f = objArr2;
                this.f1679d = new long[8];
                objArr2[0] = objArr;
            }
            int i6 = this.f1678c;
            int i7 = i6 + 1;
            Object[][] objArr3 = this.f1599f;
            if (i7 >= objArr3.length || objArr3[i7] == null) {
                if (i6 == 0) {
                    j5 = (long) objArr.length;
                } else {
                    j5 = ((long) objArr3[i6].length) + this.f1679d[i6];
                }
                p(j5 + 1);
            }
            this.f1677b = 0;
            int i8 = this.f1678c + 1;
            this.f1678c = i8;
            this.f1598e = this.f1599f[i8];
        }
        Object[] objArr4 = this.f1598e;
        int i9 = this.f1677b;
        this.f1677b = i9 + 1;
        objArr4[i9] = obj;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        forEach(new C0481q(9, arrayList));
        String obj = arrayList.toString();
        return "SpinedBuffer:" + obj;
    }

    public Spliterator spliterator() {
        return new N2(this, 0, this.f1678c, 0, this.f1677b);
    }
}
