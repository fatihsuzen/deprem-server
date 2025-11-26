package b1;

import S0.e;
import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2633k;

/* renamed from: b1.w  reason: case insensitive filesystem */
public final class C1037w {

    /* renamed from: c  reason: collision with root package name */
    public static final a f4725c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f4726a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4727b;

    /* renamed from: b1.w$a */
    public static final class a {

        /* renamed from: b1.w$a$a  reason: collision with other inner class name */
        static final class C0067a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f4728a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4729b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f4730c;

            /* renamed from: d  reason: collision with root package name */
            int f4731d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0067a(a aVar, C2308e eVar) {
                super(eVar);
                this.f4730c = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4729b = obj;
                this.f4731d |= Integer.MIN_VALUE;
                return this.f4730c.a((e) null, this);
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
            if (r10 != r1) goto L_0x0085;
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(S0.e r9, b3.C2308e r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof b1.C1037w.a.C0067a
                if (r0 == 0) goto L_0x0013
                r0 = r10
                b1.w$a$a r0 = (b1.C1037w.a.C0067a) r0
                int r1 = r0.f4731d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4731d = r1
                goto L_0x0018
            L_0x0013:
                b1.w$a$a r0 = new b1.w$a$a
                r0.<init>(r8, r10)
            L_0x0018:
                java.lang.Object r10 = r0.f4729b
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f4731d
                java.lang.String r3 = "FirebaseSessions"
                r4 = 2
                r5 = 1
                java.lang.String r6 = ""
                if (r2 == 0) goto L_0x0048
                if (r2 == r5) goto L_0x003e
                if (r2 != r4) goto L_0x0036
                java.lang.Object r9 = r0.f4728a
                java.lang.String r9 = (java.lang.String) r9
                W2.u.b(r10)     // Catch:{ Exception -> 0x0034 }
                goto L_0x0085
            L_0x0034:
                r10 = move-exception
                goto L_0x008c
            L_0x0036:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x003e:
                java.lang.Object r9 = r0.f4728a
                S0.e r9 = (S0.e) r9
                W2.u.b(r10)     // Catch:{ Exception -> 0x0046 }
                goto L_0x0060
            L_0x0046:
                r10 = move-exception
                goto L_0x006a
            L_0x0048:
                W2.u.b(r10)
                r10 = 0
                k0.l r10 = r9.a(r10)     // Catch:{ Exception -> 0x0046 }
                java.lang.String r2 = "getToken(...)"
                kotlin.jvm.internal.t.d(r10, r2)     // Catch:{ Exception -> 0x0046 }
                r0.f4728a = r9     // Catch:{ Exception -> 0x0046 }
                r0.f4731d = r5     // Catch:{ Exception -> 0x0046 }
                java.lang.Object r10 = G3.b.a(r10, r0)     // Catch:{ Exception -> 0x0046 }
                if (r10 != r1) goto L_0x0060
                goto L_0x0084
            L_0x0060:
                com.google.firebase.installations.g r10 = (com.google.firebase.installations.g) r10     // Catch:{ Exception -> 0x0046 }
                java.lang.String r10 = r10.b()     // Catch:{ Exception -> 0x0046 }
                r7 = r10
                r10 = r9
                r9 = r7
                goto L_0x0071
            L_0x006a:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r3, r2, r10)
                r10 = r9
                r9 = r6
            L_0x0071:
                k0.l r10 = r10.getId()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r2 = "getId(...)"
                kotlin.jvm.internal.t.d(r10, r2)     // Catch:{ Exception -> 0x0034 }
                r0.f4728a = r9     // Catch:{ Exception -> 0x0034 }
                r0.f4731d = r4     // Catch:{ Exception -> 0x0034 }
                java.lang.Object r10 = G3.b.a(r10, r0)     // Catch:{ Exception -> 0x0034 }
                if (r10 != r1) goto L_0x0085
            L_0x0084:
                return r1
            L_0x0085:
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0034 }
                if (r10 != 0) goto L_0x008a
                goto L_0x0091
            L_0x008a:
                r6 = r10
                goto L_0x0091
            L_0x008c:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r3, r0, r10)
            L_0x0091:
                b1.w r10 = new b1.w
                r0 = 0
                r10.<init>(r6, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.C1037w.a.a(S0.e, b3.e):java.lang.Object");
        }

        private a() {
        }
    }

    public /* synthetic */ C1037w(String str, String str2, C2633k kVar) {
        this(str, str2);
    }

    public final String a() {
        return this.f4727b;
    }

    public final String b() {
        return this.f4726a;
    }

    private C1037w(String str, String str2) {
        this.f4726a = str;
        this.f4727b = str2;
    }
}
