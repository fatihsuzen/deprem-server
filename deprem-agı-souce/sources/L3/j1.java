package L3;

import W2.E;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class j1 extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private long[] f18545a;

    /* renamed from: b  reason: collision with root package name */
    private int f18546b;

    public /* synthetic */ j1(long[] jArr, C2633k kVar) {
        this(jArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return E.c(f());
    }

    public void b(int i5) {
        if (E.p(this.f18545a) < i5) {
            long[] jArr = this.f18545a;
            long[] copyOf = Arrays.copyOf(jArr, C2729e.c(i5, E.p(jArr) * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18545a = E.g(copyOf);
        }
    }

    public int d() {
        return this.f18546b;
    }

    public final void e(long j5) {
        K0.c(this, 0, 1, (Object) null);
        long[] jArr = this.f18545a;
        int d5 = d();
        this.f18546b = d5 + 1;
        E.t(jArr, d5, j5);
    }

    public long[] f() {
        long[] copyOf = Arrays.copyOf(this.f18545a, d());
        t.d(copyOf, "copyOf(...)");
        return E.g(copyOf);
    }

    private j1(long[] jArr) {
        t.e(jArr, "bufferWithData");
        this.f18545a = jArr;
        this.f18546b = E.p(jArr);
        b(10);
    }
}
