package j$.util.stream;

import java.util.Arrays;

public final class C2 extends C0605y2 {

    /* renamed from: c  reason: collision with root package name */
    public R2 f1454c;

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
            j$.util.stream.R2 r0 = new j$.util.stream.R2
            int r3 = (int) r3
            r0.<init>(r3)
            goto L_0x0019
        L_0x0014:
            j$.util.stream.R2 r0 = new j$.util.stream.R2
            r0.<init>()
        L_0x0019:
            r2.f1454c = r0
            return
        L_0x001c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Stream size exceeds max array size"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C2.c(long):void");
    }

    public final void end() {
        int[] iArr = (int[]) this.f1454c.b();
        Arrays.sort(iArr);
        C0546m2 m2Var = this.f1710a;
        m2Var.c((long) iArr.length);
        int i5 = 0;
        if (!this.f1835b) {
            int length = iArr.length;
            while (i5 < length) {
                m2Var.accept(iArr[i5]);
                i5++;
            }
        } else {
            int length2 = iArr.length;
            while (i5 < length2) {
                int i6 = iArr[i5];
                if (m2Var.e()) {
                    break;
                }
                m2Var.accept(i6);
                i5++;
            }
        }
        m2Var.end();
    }

    public final void accept(int i5) {
        this.f1454c.accept(i5);
    }
}
