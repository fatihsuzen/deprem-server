package y3;

import W2.J;
import W2.t;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import k3.C2616a;
import k3.l;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import w3.C2882l;
import w3.G;
import w3.M;
import w3.O;

public abstract class t {

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26449a;

        /* renamed from: b  reason: collision with root package name */
        Object f26450b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f26451c;

        /* renamed from: d  reason: collision with root package name */
        int f26452d;

        a(C2308e eVar) {
            super(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f26451c = obj;
            this.f26452d |= Integer.MIN_VALUE;
            return t.a((v) null, (C2616a) null, this);
        }
    }

    static final class b implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2882l f26453a;

        b(C2882l lVar) {
            this.f26453a = lVar;
        }

        public final void a(Throwable th) {
            C2882l lVar = this.f26453a;
            t.a aVar = W2.t.f19966b;
            lVar.resumeWith(W2.t.b(J.f19942a));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return J.f19942a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: k3.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(y3.v r4, k3.C2616a r5, b3.C2308e r6) {
        /*
            boolean r0 = r6 instanceof y3.t.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            y3.t$a r0 = (y3.t.a) r0
            int r1 = r0.f26452d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26452d = r1
            goto L_0x0018
        L_0x0013:
            y3.t$a r0 = new y3.t$a
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26451c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26452d
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.f26450b
            r5 = r4
            k3.a r5 = (k3.C2616a) r5
            java.lang.Object r4 = r0.f26449a
            y3.v r4 = (y3.v) r4
            W2.u.b(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x0075
        L_0x0032:
            r4 = move-exception
            goto L_0x007b
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            W2.u.b(r6)
            b3.i r6 = r0.getContext()
            w3.y0$b r2 = w3.C2908y0.f26320k0
            b3.i$b r6 = r6.get(r2)
            if (r6 != r4) goto L_0x007f
            r0.f26449a = r4     // Catch:{ all -> 0x0032 }
            r0.f26450b = r5     // Catch:{ all -> 0x0032 }
            r0.f26452d = r3     // Catch:{ all -> 0x0032 }
            w3.n r6 = new w3.n     // Catch:{ all -> 0x0032 }
            b3.e r2 = c3.C2316b.c(r0)     // Catch:{ all -> 0x0032 }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x0032 }
            r6.D()     // Catch:{ all -> 0x0032 }
            y3.t$b r2 = new y3.t$b     // Catch:{ all -> 0x0032 }
            r2.<init>(r6)     // Catch:{ all -> 0x0032 }
            r4.w(r2)     // Catch:{ all -> 0x0032 }
            java.lang.Object r4 = r6.x()     // Catch:{ all -> 0x0032 }
            java.lang.Object r6 = c3.C2316b.f()     // Catch:{ all -> 0x0032 }
            if (r4 != r6) goto L_0x0072
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch:{ all -> 0x0032 }
        L_0x0072:
            if (r4 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r5.invoke()
            W2.J r4 = W2.J.f19942a
            return r4
        L_0x007b:
            r5.invoke()
            throw r4
        L_0x007f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.t.a(y3.v, k3.a, b3.e):java.lang.Object");
    }

    public static final x b(M m5, C2312i iVar, int i5, p pVar) {
        return c(m5, iVar, i5, C2928a.SUSPEND, O.DEFAULT, (l) null, pVar);
    }

    public static final x c(M m5, C2312i iVar, int i5, C2928a aVar, O o5, l lVar, p pVar) {
        u uVar = new u(G.k(m5, iVar), C2937j.b(i5, aVar, (l) null, 4, (Object) null));
        if (lVar != null) {
            uVar.s(lVar);
        }
        uVar.P0(o5, uVar, pVar);
        return uVar;
    }

    public static /* synthetic */ x d(M m5, C2312i iVar, int i5, C2928a aVar, O o5, l lVar, p pVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            aVar = C2928a.SUSPEND;
        }
        if ((i6 & 8) != 0) {
            o5 = O.DEFAULT;
        }
        if ((i6 & 16) != 0) {
            lVar = null;
        }
        l lVar2 = lVar;
        p pVar2 = pVar;
        O o6 = o5;
        int i7 = i5;
        return c(m5, iVar, i7, aVar, o6, lVar2, pVar2);
    }
}
