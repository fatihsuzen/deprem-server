package j$.util.stream;

import java.util.Arrays;

public final class K2 extends C0605y2 {

    /* renamed from: c  reason: collision with root package name */
    public int[] f1523c;

    /* renamed from: d  reason: collision with root package name */
    public int f1524d;

    public final void c(long j5) {
        if (j5 < 2147483639) {
            this.f1523c = new int[((int) j5)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void end() {
        int i5 = 0;
        Arrays.sort(this.f1523c, 0, this.f1524d);
        C0546m2 m2Var = this.f1710a;
        m2Var.c((long) this.f1524d);
        if (!this.f1835b) {
            while (i5 < this.f1524d) {
                m2Var.accept(this.f1523c[i5]);
                i5++;
            }
        } else {
            while (i5 < this.f1524d && !m2Var.e()) {
                m2Var.accept(this.f1523c[i5]);
                i5++;
            }
        }
        m2Var.end();
        this.f1523c = null;
    }

    public final void accept(int i5) {
        int[] iArr = this.f1523c;
        int i6 = this.f1524d;
        this.f1524d = i6 + 1;
        iArr[i6] = i5;
    }
}
