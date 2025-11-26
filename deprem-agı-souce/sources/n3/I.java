package N3;

import J3.f;
import M3.h;
import M3.i;
import M3.z;
import X2.M;
import java.util.List;
import kotlin.jvm.internal.t;

final class I extends G {

    /* renamed from: k  reason: collision with root package name */
    private final z f18724k;

    /* renamed from: l  reason: collision with root package name */
    private final List f18725l;

    /* renamed from: m  reason: collision with root package name */
    private final int f18726m;

    /* renamed from: n  reason: collision with root package name */
    private int f18727n = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public I(M3.C2128b r9, M3.z r10) {
        /*
            r8 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.t.e(r10, r0)
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r1.f18724k = r3
            M3.z r9 = r8.T()
            java.util.Set r9 = r9.keySet()
            java.util.List r9 = X2.C2250q.n0(r9)
            r1.f18725l = r9
            int r9 = r9.size()
            int r9 = r9 * 2
            r1.f18726m = r9
            r9 = -1
            r1.f18727n = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.I.<init>(M3.b, M3.z):void");
    }

    /* access modifiers changed from: protected */
    public h F(String str) {
        t.e(str, "tag");
        if (this.f18727n % 2 == 0) {
            return i.a(str);
        }
        return (h) M.i(T(), str);
    }

    /* renamed from: Y */
    public z T() {
        return this.f18724k;
    }

    public int decodeElementIndex(f fVar) {
        t.e(fVar, "descriptor");
        int i5 = this.f18727n;
        if (i5 >= this.f18726m - 1) {
            return -1;
        }
        int i6 = i5 + 1;
        this.f18727n = i6;
        return i6;
    }

    public void endStructure(f fVar) {
        t.e(fVar, "descriptor");
    }

    /* access modifiers changed from: protected */
    public String z(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return (String) this.f18725l.get(i5 / 2);
    }
}
