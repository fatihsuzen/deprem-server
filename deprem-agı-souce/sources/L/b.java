package L;

import com.google.android.gms.common.api.Status;

public class b extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected final Status f2768a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(com.google.android.gms.common.api.Status r4) {
        /*
            r3 = this;
            int r0 = r4.d()
            java.lang.String r1 = r4.f()
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = r4.f()
            goto L_0x0011
        L_0x000f:
            java.lang.String r1 = ""
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r3.<init>(r0)
            r3.f2768a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: L.b.<init>(com.google.android.gms.common.api.Status):void");
    }

    public Status a() {
        return this.f2768a;
    }
}
