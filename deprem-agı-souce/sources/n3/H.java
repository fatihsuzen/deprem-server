package N3;

import J3.f;
import M3.C2129c;
import M3.h;
import kotlin.jvm.internal.t;

final class H extends C2133c {

    /* renamed from: g  reason: collision with root package name */
    private final C2129c f18721g;

    /* renamed from: h  reason: collision with root package name */
    private final int f18722h = T().size();

    /* renamed from: i  reason: collision with root package name */
    private int f18723i = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public H(M3.C2128b r8, M3.C2129c r9) {
        /*
            r7 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.t.e(r9, r0)
            r5 = 4
            r6 = 0
            r4 = 0
            r1 = r7
            r2 = r8
            r3 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r1.f18721g = r3
            M3.c r8 = r7.T()
            int r8 = r8.size()
            r1.f18722h = r8
            r8 = -1
            r1.f18723i = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.H.<init>(M3.b, M3.c):void");
    }

    /* access modifiers changed from: protected */
    public h F(String str) {
        t.e(str, "tag");
        return T().get(Integer.parseInt(str));
    }

    /* renamed from: W */
    public C2129c T() {
        return this.f18721g;
    }

    public int decodeElementIndex(f fVar) {
        t.e(fVar, "descriptor");
        int i5 = this.f18723i;
        if (i5 >= this.f18722h - 1) {
            return -1;
        }
        int i6 = i5 + 1;
        this.f18723i = i6;
        return i6;
    }

    /* access modifiers changed from: protected */
    public String z(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return String.valueOf(i5);
    }
}
