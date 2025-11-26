package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class T0 extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private short[] f18484a;

    /* renamed from: b  reason: collision with root package name */
    private int f18485b;

    public T0(short[] sArr) {
        t.e(sArr, "bufferWithData");
        this.f18484a = sArr;
        this.f18485b = sArr.length;
        b(10);
    }

    public void b(int i5) {
        short[] sArr = this.f18484a;
        if (sArr.length < i5) {
            short[] copyOf = Arrays.copyOf(sArr, C2729e.c(i5, sArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18484a = copyOf;
        }
    }

    public int d() {
        return this.f18485b;
    }

    public final void e(short s5) {
        K0.c(this, 0, 1, (Object) null);
        short[] sArr = this.f18484a;
        int d5 = d();
        this.f18485b = d5 + 1;
        sArr[d5] = s5;
    }

    /* renamed from: f */
    public short[] a() {
        short[] copyOf = Arrays.copyOf(this.f18484a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
