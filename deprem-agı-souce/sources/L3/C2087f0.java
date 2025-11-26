package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: L3.f0  reason: case insensitive filesystem */
public final class C2087f0 extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private long[] f18521a;

    /* renamed from: b  reason: collision with root package name */
    private int f18522b;

    public C2087f0(long[] jArr) {
        t.e(jArr, "bufferWithData");
        this.f18521a = jArr;
        this.f18522b = jArr.length;
        b(10);
    }

    public void b(int i5) {
        long[] jArr = this.f18521a;
        if (jArr.length < i5) {
            long[] copyOf = Arrays.copyOf(jArr, C2729e.c(i5, jArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18521a = copyOf;
        }
    }

    public int d() {
        return this.f18522b;
    }

    public final void e(long j5) {
        K0.c(this, 0, 1, (Object) null);
        long[] jArr = this.f18521a;
        int d5 = d();
        this.f18522b = d5 + 1;
        jArr[d5] = j5;
    }

    /* renamed from: f */
    public long[] a() {
        long[] copyOf = Arrays.copyOf(this.f18521a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
