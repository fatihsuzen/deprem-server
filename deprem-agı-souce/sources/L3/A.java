package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class A extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private double[] f18424a;

    /* renamed from: b  reason: collision with root package name */
    private int f18425b;

    public A(double[] dArr) {
        t.e(dArr, "bufferWithData");
        this.f18424a = dArr;
        this.f18425b = dArr.length;
        b(10);
    }

    public void b(int i5) {
        double[] dArr = this.f18424a;
        if (dArr.length < i5) {
            double[] copyOf = Arrays.copyOf(dArr, C2729e.c(i5, dArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18424a = copyOf;
        }
    }

    public int d() {
        return this.f18425b;
    }

    public final void e(double d5) {
        K0.c(this, 0, 1, (Object) null);
        double[] dArr = this.f18424a;
        int d6 = d();
        this.f18425b = d6 + 1;
        dArr[d6] = d5;
    }

    /* renamed from: f */
    public double[] a() {
        double[] copyOf = Arrays.copyOf(this.f18424a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
