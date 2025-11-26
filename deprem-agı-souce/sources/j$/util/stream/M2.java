package j$.util.stream;

import java.util.Arrays;

public final class M2 extends A2 {

    /* renamed from: d  reason: collision with root package name */
    public Object[] f1538d;

    /* renamed from: e  reason: collision with root package name */
    public int f1539e;

    public final void c(long j5) {
        if (j5 < 2147483639) {
            this.f1538d = new Object[((int) j5)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void end() {
        int i5 = 0;
        Arrays.sort(this.f1538d, 0, this.f1539e, this.f1435b);
        C0546m2 m2Var = this.f1716a;
        m2Var.c((long) this.f1539e);
        if (!this.f1436c) {
            while (i5 < this.f1539e) {
                m2Var.accept(this.f1538d[i5]);
                i5++;
            }
        } else {
            while (i5 < this.f1539e && !m2Var.e()) {
                m2Var.accept(this.f1538d[i5]);
                i5++;
            }
        }
        m2Var.end();
        this.f1538d = null;
    }

    public final void accept(Object obj) {
        Object[] objArr = this.f1538d;
        int i5 = this.f1539e;
        this.f1539e = i5 + 1;
        objArr[i5] = obj;
    }
}
