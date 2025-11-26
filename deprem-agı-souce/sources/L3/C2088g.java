package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: L3.g  reason: case insensitive filesystem */
public final class C2088g extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f18525a;

    /* renamed from: b  reason: collision with root package name */
    private int f18526b;

    public C2088g(boolean[] zArr) {
        t.e(zArr, "bufferWithData");
        this.f18525a = zArr;
        this.f18526b = zArr.length;
        b(10);
    }

    public void b(int i5) {
        boolean[] zArr = this.f18525a;
        if (zArr.length < i5) {
            boolean[] copyOf = Arrays.copyOf(zArr, C2729e.c(i5, zArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18525a = copyOf;
        }
    }

    public int d() {
        return this.f18526b;
    }

    public final void e(boolean z4) {
        K0.c(this, 0, 1, (Object) null);
        boolean[] zArr = this.f18525a;
        int d5 = d();
        this.f18526b = d5 + 1;
        zArr[d5] = z4;
    }

    /* renamed from: f */
    public boolean[] a() {
        boolean[] copyOf = Arrays.copyOf(this.f18525a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
