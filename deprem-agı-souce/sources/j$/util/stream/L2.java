package j$.util.stream;

import java.util.Arrays;

public final class L2 extends C0610z2 {

    /* renamed from: c  reason: collision with root package name */
    public long[] f1531c;

    /* renamed from: d  reason: collision with root package name */
    public int f1532d;

    public final void c(long j5) {
        if (j5 < 2147483639) {
            this.f1531c = new long[((int) j5)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void end() {
        int i5 = 0;
        Arrays.sort(this.f1531c, 0, this.f1532d);
        C0546m2 m2Var = this.f1713a;
        m2Var.c((long) this.f1532d);
        if (!this.f1838b) {
            while (i5 < this.f1532d) {
                m2Var.accept(this.f1531c[i5]);
                i5++;
            }
        } else {
            while (i5 < this.f1532d && !m2Var.e()) {
                m2Var.accept(this.f1531c[i5]);
                i5++;
            }
        }
        m2Var.end();
        this.f1531c = null;
    }

    public final void accept(long j5) {
        long[] jArr = this.f1531c;
        int i5 = this.f1532d;
        this.f1532d = i5 + 1;
        jArr[i5] = j5;
    }
}
