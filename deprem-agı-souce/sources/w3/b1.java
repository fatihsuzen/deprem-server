package w3;

import B3.K;
import B3.z;
import W2.J;
import W2.s;
import W2.y;
import b3.C2308e;
import b3.C2312i;

public final class b1 extends z {

    /* renamed from: e  reason: collision with root package name */
    private final ThreadLocal f26271e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b1(b3.C2312i r3, b3.C2308e r4) {
        /*
            r2 = this;
            w3.c1 r0 = w3.c1.f26275a
            b3.i$b r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000d
            b3.i r0 = r3.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f26271e = r0
            b3.i r4 = r4.getContext()
            b3.f$b r0 = b3.C2309f.f20792a0
            b3.i$b r4 = r4.get(r0)
            boolean r4 = r4 instanceof w3.I
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = B3.K.i(r3, r4)
            B3.K.f(r3, r4)
            r2.R0(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.b1.<init>(b3.i, b3.e):void");
    }

    /* access modifiers changed from: protected */
    public void M0(Object obj) {
        if (this.threadLocalIsSet) {
            s sVar = (s) this.f26271e.get();
            if (sVar != null) {
                K.f((C2312i) sVar.a(), sVar.b());
            }
            this.f26271e.remove();
        }
        Object a5 = C2856C.a(obj, this.f17429d);
        C2308e eVar = this.f17429d;
        C2312i context = eVar.getContext();
        b1 b1Var = null;
        Object i5 = K.i(context, (Object) null);
        if (i5 != K.f17373a) {
            b1Var = G.m(eVar, context, i5);
        }
        try {
            this.f17429d.resumeWith(a5);
            J j5 = J.f19942a;
            if (b1Var == null || b1Var.Q0()) {
                K.f(context, i5);
            }
        } catch (Throwable th) {
            if (b1Var == null || b1Var.Q0()) {
                K.f(context, i5);
            }
            throw th;
        }
    }

    public final boolean Q0() {
        boolean z4;
        if (!this.threadLocalIsSet || this.f26271e.get() != null) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.f26271e.remove();
        return !z4;
    }

    public final void R0(C2312i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f26271e.set(y.a(iVar, obj));
    }
}
