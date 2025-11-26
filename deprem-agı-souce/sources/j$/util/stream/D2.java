package j$.util.stream;

import java.util.Arrays;

public final class D2 extends C0610z2 {

    /* renamed from: c  reason: collision with root package name */
    public T2 f1460c;

    /* JADX WARNING: type inference failed for: r0v5, types: [j$.util.stream.V2] */
    /* JADX WARNING: type inference failed for: r0v6, types: [j$.util.stream.V2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(long r3) {
        /*
            r2 = this;
            r0 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x001c
            r0 = 0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0014
            j$.util.stream.T2 r0 = new j$.util.stream.T2
            int r3 = (int) r3
            r0.<init>(r3)
            goto L_0x0019
        L_0x0014:
            j$.util.stream.T2 r0 = new j$.util.stream.T2
            r0.<init>()
        L_0x0019:
            r2.f1460c = r0
            return
        L_0x001c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Stream size exceeds max array size"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.D2.c(long):void");
    }

    public final void end() {
        long[] jArr = (long[]) this.f1460c.b();
        Arrays.sort(jArr);
        C0546m2 m2Var = this.f1713a;
        m2Var.c((long) jArr.length);
        int i5 = 0;
        if (!this.f1838b) {
            int length = jArr.length;
            while (i5 < length) {
                m2Var.accept(jArr[i5]);
                i5++;
            }
        } else {
            int length2 = jArr.length;
            while (i5 < length2) {
                long j5 = jArr[i5];
                if (m2Var.e()) {
                    break;
                }
                m2Var.accept(j5);
                i5++;
            }
        }
        m2Var.end();
    }

    public final void accept(long j5) {
        this.f1460c.accept(j5);
    }
}
