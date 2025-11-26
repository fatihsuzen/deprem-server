package L3;

import J3.f;
import J3.j;
import J3.m;
import J3.n;
import J3.o;
import W2.C2223l;
import X2.C2250q;
import k3.l;
import kotlin.jvm.internal.t;

public final class G extends H0 {

    /* renamed from: m  reason: collision with root package name */
    private final n f18444m = n.b.f18389a;

    /* renamed from: n  reason: collision with root package name */
    private final C2223l f18445n;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public G(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.t.e(r8, r0)
            r5 = 2
            r6 = 0
            r3 = 0
            r1 = r7
            r2 = r8
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            J3.n$b r8 = J3.n.b.f18389a
            r1.f18444m = r8
            L3.F r8 = new L3.F
            r8.<init>(r4, r2, r7)
            W2.l r8 = W2.m.b(r8)
            r1.f18445n = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: L3.G.<init>(java.lang.String, int):void");
    }

    /* access modifiers changed from: private */
    public static final f[] y(int i5, String str, G g5) {
        f[] fVarArr = new f[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            fVarArr[i6] = m.i(str + '.' + g5.f(i6), o.d.f18393a, new f[0], (l) null, 8, (Object) null);
        }
        return fVarArr;
    }

    private final f[] z() {
        return (f[]) this.f18445n.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.getKind() == n.b.f18389a && t.a(a(), fVar.a()) && t.a(B0.a(this), B0.a(fVar))) {
            return true;
        }
        return false;
    }

    public n getKind() {
        return this.f18444m;
    }

    public f h(int i5) {
        return z()[i5];
    }

    public int hashCode() {
        int i5;
        int hashCode = a().hashCode();
        int i6 = 1;
        for (String str : j.b(this)) {
            int i7 = i6 * 31;
            if (str != null) {
                i5 = str.hashCode();
            } else {
                i5 = 0;
            }
            i6 = i7 + i5;
        }
        return (hashCode * 31) + i6;
    }

    public String toString() {
        Iterable b5 = j.b(this);
        return C2250q.V(b5, ", ", a() + '(', ")", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
