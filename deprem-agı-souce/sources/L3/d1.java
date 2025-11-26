package L3;

import W2.A;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class d1 extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f18515a;

    /* renamed from: b  reason: collision with root package name */
    private int f18516b;

    public /* synthetic */ d1(byte[] bArr, C2633k kVar) {
        this(bArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return A.c(f());
    }

    public void b(int i5) {
        if (A.p(this.f18515a) < i5) {
            byte[] bArr = this.f18515a;
            byte[] copyOf = Arrays.copyOf(bArr, C2729e.c(i5, A.p(bArr) * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18515a = A.g(copyOf);
        }
    }

    public int d() {
        return this.f18516b;
    }

    public final void e(byte b5) {
        K0.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f18515a;
        int d5 = d();
        this.f18516b = d5 + 1;
        A.t(bArr, d5, b5);
    }

    public byte[] f() {
        byte[] copyOf = Arrays.copyOf(this.f18515a, d());
        t.d(copyOf, "copyOf(...)");
        return A.g(copyOf);
    }

    private d1(byte[] bArr) {
        t.e(bArr, "bufferWithData");
        this.f18515a = bArr;
        this.f18516b = A.p(bArr);
        b(10);
    }
}
