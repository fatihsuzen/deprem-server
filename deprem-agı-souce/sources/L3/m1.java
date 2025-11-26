package L3;

import W2.H;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class m1 extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private short[] f18561a;

    /* renamed from: b  reason: collision with root package name */
    private int f18562b;

    public /* synthetic */ m1(short[] sArr, C2633k kVar) {
        this(sArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return H.c(f());
    }

    public void b(int i5) {
        if (H.p(this.f18561a) < i5) {
            short[] sArr = this.f18561a;
            short[] copyOf = Arrays.copyOf(sArr, C2729e.c(i5, H.p(sArr) * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18561a = H.g(copyOf);
        }
    }

    public int d() {
        return this.f18562b;
    }

    public final void e(short s5) {
        K0.c(this, 0, 1, (Object) null);
        short[] sArr = this.f18561a;
        int d5 = d();
        this.f18562b = d5 + 1;
        H.t(sArr, d5, s5);
    }

    public short[] f() {
        short[] copyOf = Arrays.copyOf(this.f18561a, d());
        t.d(copyOf, "copyOf(...)");
        return H.g(copyOf);
    }

    private m1(short[] sArr) {
        t.e(sArr, "bufferWithData");
        this.f18561a = sArr;
        this.f18562b = H.p(sArr);
        b(10);
    }
}
