package L3;

import W2.C;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class g1 extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private int[] f18528a;

    /* renamed from: b  reason: collision with root package name */
    private int f18529b;

    public /* synthetic */ g1(int[] iArr, C2633k kVar) {
        this(iArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return C.c(f());
    }

    public void b(int i5) {
        if (C.p(this.f18528a) < i5) {
            int[] iArr = this.f18528a;
            int[] copyOf = Arrays.copyOf(iArr, C2729e.c(i5, C.p(iArr) * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18528a = C.g(copyOf);
        }
    }

    public int d() {
        return this.f18529b;
    }

    public final void e(int i5) {
        K0.c(this, 0, 1, (Object) null);
        int[] iArr = this.f18528a;
        int d5 = d();
        this.f18529b = d5 + 1;
        C.t(iArr, d5, i5);
    }

    public int[] f() {
        int[] copyOf = Arrays.copyOf(this.f18528a, d());
        t.d(copyOf, "copyOf(...)");
        return C.g(copyOf);
    }

    private g1(int[] iArr) {
        t.e(iArr, "bufferWithData");
        this.f18528a = iArr;
        this.f18529b = C.p(iArr);
        b(10);
    }
}
