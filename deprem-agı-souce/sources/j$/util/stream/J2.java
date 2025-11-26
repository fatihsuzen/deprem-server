package j$.util.stream;

import java.util.Arrays;

public final class J2 extends C0600x2 {

    /* renamed from: c  reason: collision with root package name */
    public double[] f1510c;

    /* renamed from: d  reason: collision with root package name */
    public int f1511d;

    public final void c(long j5) {
        if (j5 < 2147483639) {
            this.f1510c = new double[((int) j5)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void end() {
        int i5 = 0;
        Arrays.sort(this.f1510c, 0, this.f1511d);
        C0546m2 m2Var = this.f1706a;
        m2Var.c((long) this.f1511d);
        if (!this.f1830b) {
            while (i5 < this.f1511d) {
                m2Var.accept(this.f1510c[i5]);
                i5++;
            }
        } else {
            while (i5 < this.f1511d && !m2Var.e()) {
                m2Var.accept(this.f1510c[i5]);
                i5++;
            }
        }
        m2Var.end();
        this.f1510c = null;
    }

    public final void accept(double d5) {
        double[] dArr = this.f1510c;
        int i5 = this.f1511d;
        this.f1511d = i5 + 1;
        dArr[i5] = d5;
    }
}
