package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: L3.j  reason: case insensitive filesystem */
public final class C2094j extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f18540a;

    /* renamed from: b  reason: collision with root package name */
    private int f18541b;

    public C2094j(byte[] bArr) {
        t.e(bArr, "bufferWithData");
        this.f18540a = bArr;
        this.f18541b = bArr.length;
        b(10);
    }

    public void b(int i5) {
        byte[] bArr = this.f18540a;
        if (bArr.length < i5) {
            byte[] copyOf = Arrays.copyOf(bArr, C2729e.c(i5, bArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18540a = copyOf;
        }
    }

    public int d() {
        return this.f18541b;
    }

    public final void e(byte b5) {
        K0.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f18540a;
        int d5 = d();
        this.f18541b = d5 + 1;
        bArr[d5] = b5;
    }

    /* renamed from: f */
    public byte[] a() {
        byte[] copyOf = Arrays.copyOf(this.f18540a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
