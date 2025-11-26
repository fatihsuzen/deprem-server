package z3;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

/* renamed from: z3.a  reason: case insensitive filesystem */
public abstract class C2968a implements C2972e {

    /* renamed from: z3.a$a  reason: collision with other inner class name */
    static final class C0267a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26605a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f26606b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2968a f26607c;

        /* renamed from: d  reason: collision with root package name */
        int f26608d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0267a(C2968a aVar, C2308e eVar) {
            super(eVar);
            this.f26607c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f26606b = obj;
            this.f26608d |= Integer.MIN_VALUE;
            return this.f26607c.collect((C2973f) null, this);
        }
    }

    public abstract Object c(C2973f fVar, C2308e eVar);

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(z3.C2973f r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof z3.C2968a.C0267a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            z3.a$a r0 = (z3.C2968a.C0267a) r0
            int r1 = r0.f26608d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26608d = r1
            goto L_0x0018
        L_0x0013:
            z3.a$a r0 = new z3.a$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f26606b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26608d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r6 = r0.f26605a
            A3.t r6 = (A3.t) r6
            W2.u.b(r7)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r7 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            W2.u.b(r7)
            A3.t r7 = new A3.t
            b3.i r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f26605a = r7     // Catch:{ all -> 0x0055 }
            r0.f26608d = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r6 = r5.c(r7, r0)     // Catch:{ all -> 0x0055 }
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r6 = r7
        L_0x004f:
            r6.releaseIntercepted()
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x0055:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0059:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2968a.collect(z3.f, b3.e):java.lang.Object");
    }
}
