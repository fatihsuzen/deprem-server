package w3;

import W2.J;
import W2.q;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.h;
import u3.C2795a;
import u3.C2797c;
import u3.C2798d;

public abstract class X {

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f26262a;

        /* renamed from: b  reason: collision with root package name */
        int f26263b;

        a(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26262a = obj;
            this.f26263b |= Integer.MIN_VALUE;
            return X.a(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(b3.C2308e r4) {
        /*
            boolean r0 = r4 instanceof w3.X.a
            if (r0 == 0) goto L_0x0013
            r0 = r4
            w3.X$a r0 = (w3.X.a) r0
            int r1 = r0.f26263b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26263b = r1
            goto L_0x0018
        L_0x0013:
            w3.X$a r0 = new w3.X$a
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.f26262a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26263b
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x002d:
            W2.u.b(r4)
            goto L_0x0052
        L_0x0031:
            W2.u.b(r4)
            r0.f26263b = r3
            w3.n r4 = new w3.n
            b3.e r2 = c3.C2316b.c(r0)
            r4.<init>(r2, r3)
            r4.D()
            java.lang.Object r4 = r4.x()
            java.lang.Object r2 = c3.C2316b.f()
            if (r4 != r2) goto L_0x004f
            kotlin.coroutines.jvm.internal.h.c(r0)
        L_0x004f:
            if (r4 != r1) goto L_0x0052
            return r1
        L_0x0052:
            W2.h r4 = new W2.h
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.X.a(b3.e):java.lang.Object");
    }

    public static final Object b(long j5, C2308e eVar) {
        if (j5 <= 0) {
            return J.f19942a;
        }
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        if (j5 < Long.MAX_VALUE) {
            c(nVar.getContext()).o(j5, nVar);
        }
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    public static final W c(C2312i iVar) {
        W w4;
        C2312i.b bVar = iVar.get(C2309f.f20792a0);
        if (bVar instanceof W) {
            w4 = (W) bVar;
        } else {
            w4 = null;
        }
        if (w4 == null) {
            return T.a();
        }
        return w4;
    }

    public static final long d(long j5) {
        boolean E4 = C2795a.E(j5);
        if (E4) {
            return C2795a.n(C2795a.F(j5, C2797c.t(999999, C2798d.NANOSECONDS)));
        }
        if (!E4) {
            return 0;
        }
        throw new q();
    }
}
