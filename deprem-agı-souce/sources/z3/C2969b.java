package z3;

import A3.e;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2633k;
import y3.C2928a;
import y3.v;

/* renamed from: z3.b  reason: case insensitive filesystem */
final class C2969b extends C2970c {

    /* renamed from: e  reason: collision with root package name */
    private final p f26609e;

    /* renamed from: z3.b$a */
    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26610a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f26611b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2969b f26612c;

        /* renamed from: d  reason: collision with root package name */
        int f26613d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2969b bVar, C2308e eVar) {
            super(eVar);
            this.f26612c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f26611b = obj;
            this.f26613d |= Integer.MIN_VALUE;
            return this.f26612c.e((v) null, this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2969b(p pVar, C2312i iVar, int i5, C2928a aVar, int i6, C2633k kVar) {
        this(pVar, (i6 & 2) != 0 ? C2313j.f20794a : iVar, (i6 & 4) != 0 ? -2 : i5, (i6 & 8) != 0 ? C2928a.SUSPEND : aVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(y3.v r5, b3.C2308e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof z3.C2969b.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            z3.b$a r0 = (z3.C2969b.a) r0
            int r1 = r0.f26613d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26613d = r1
            goto L_0x0018
        L_0x0013:
            z3.b$a r0 = new z3.b$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26611b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26613d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f26610a
            y3.v r5 = (y3.v) r5
            W2.u.b(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            W2.u.b(r6)
            r0.f26610a = r5
            r0.f26613d = r3
            java.lang.Object r6 = super.e(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            boolean r5 = r5.D()
            if (r5 == 0) goto L_0x004c
            W2.J r5 = W2.J.f19942a
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.C2969b.e(y3.v, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public e f(C2312i iVar, int i5, C2928a aVar) {
        return new C2969b(this.f26609e, iVar, i5, aVar);
    }

    public C2969b(p pVar, C2312i iVar, int i5, C2928a aVar) {
        super(pVar, iVar, i5, aVar);
        this.f26609e = pVar;
    }
}
