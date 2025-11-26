package e1;

import F3.g;
import S0.e;
import W2.J;
import W2.u;
import android.util.Log;
import b1.C1017b;
import b1.a0;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import t3.p;
import u3.C2795a;
import u3.C2797c;
import u3.C2798d;

/* renamed from: e1.d  reason: case insensitive filesystem */
public final class C1630d implements o {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final a f15232g = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final int f15233h = ((int) C2795a.p(C2797c.s(24, C2798d.HOURS)));

    /* renamed from: i  reason: collision with root package name */
    private static final p f15234i = new p("/");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a0 f15235a;

    /* renamed from: b  reason: collision with root package name */
    private final e f15236b;

    /* renamed from: c  reason: collision with root package name */
    private final C1017b f15237c;

    /* renamed from: d  reason: collision with root package name */
    private final C1627a f15238d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final l f15239e;

    /* renamed from: f  reason: collision with root package name */
    private final F3.a f15240f = g.b(false, 1, (Object) null);

    /* renamed from: e1.d$a */
    private static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final int a() {
            return C1630d.f15233h;
        }

        private a() {
        }
    }

    /* renamed from: e1.d$b */
    static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f15241a;

        /* renamed from: b  reason: collision with root package name */
        Object f15242b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f15243c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1630d f15244d;

        /* renamed from: e  reason: collision with root package name */
        int f15245e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1630d dVar, C2308e eVar) {
            super(eVar);
            this.f15244d = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f15243c = obj;
            this.f15245e |= Integer.MIN_VALUE;
            return this.f15244d.a(this);
        }
    }

    /* renamed from: e1.d$c */
    static final class c extends l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f15246a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f15247b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1630d f15248c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1630d dVar, C2308e eVar) {
            super(2, eVar);
            this.f15248c = dVar;
        }

        /* renamed from: b */
        public final Object invoke(JSONObject jSONObject, C2308e eVar) {
            return ((c) create(jSONObject, eVar)).invokeSuspend(J.f19942a);
        }

        public final C2308e create(Object obj, C2308e eVar) {
            c cVar = new c(this.f15248c, eVar);
            cVar.f15247b = obj;
            return cVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Double} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.Integer} */
        /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.Boolean] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00f0 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.String r0 = "cache_duration"
                java.lang.String r2 = "session_timeout_seconds"
                java.lang.String r3 = "sampling_rate"
                java.lang.String r4 = "sessions_enabled"
                java.lang.Object r5 = c3.C2316b.f()
                int r6 = r1.f15246a
                r7 = 1
                if (r6 == 0) goto L_0x0022
                if (r6 != r7) goto L_0x001a
                W2.u.b(r20)
                goto L_0x00f1
            L_0x001a:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0022:
                W2.u.b(r20)
                java.lang.Object r6 = r1.f15247b
                org.json.JSONObject r6 = (org.json.JSONObject) r6
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "Fetched settings: "
                r8.append(r9)
                r8.append(r6)
                java.lang.String r8 = r8.toString()
                java.lang.String r9 = "FirebaseSessions"
                android.util.Log.d(r9, r8)
                java.lang.String r8 = "app_quality"
                boolean r10 = r6.has(r8)
                r11 = 0
                if (r10 == 0) goto L_0x00b5
                java.lang.Object r6 = r6.get(r8)
                java.lang.String r8 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.t.c(r6, r8)
                org.json.JSONObject r6 = (org.json.JSONObject) r6
                boolean r8 = r6.has(r4)     // Catch:{ JSONException -> 0x0060 }
                if (r8 == 0) goto L_0x0065
                java.lang.Object r4 = r6.get(r4)     // Catch:{ JSONException -> 0x0060 }
                java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ JSONException -> 0x0060 }
                goto L_0x0066
            L_0x0060:
                r0 = move-exception
                r2 = r11
                r3 = r2
            L_0x0063:
                r4 = r3
                goto L_0x00a7
            L_0x0065:
                r4 = r11
            L_0x0066:
                boolean r8 = r6.has(r3)     // Catch:{ JSONException -> 0x0073 }
                if (r8 == 0) goto L_0x0078
                java.lang.Object r3 = r6.get(r3)     // Catch:{ JSONException -> 0x0073 }
                java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ JSONException -> 0x0073 }
                goto L_0x0079
            L_0x0073:
                r0 = move-exception
                r2 = r11
                r3 = r2
                r11 = r4
                goto L_0x0063
            L_0x0078:
                r3 = r11
            L_0x0079:
                boolean r8 = r6.has(r2)     // Catch:{ JSONException -> 0x0086 }
                if (r8 == 0) goto L_0x008b
                java.lang.Object r2 = r6.get(r2)     // Catch:{ JSONException -> 0x0086 }
                java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ JSONException -> 0x0086 }
                goto L_0x008c
            L_0x0086:
                r0 = move-exception
                r2 = r11
                r11 = r4
                r4 = r2
                goto L_0x00a7
            L_0x008b:
                r2 = r11
            L_0x008c:
                boolean r8 = r6.has(r0)     // Catch:{ JSONException -> 0x009a }
                if (r8 == 0) goto L_0x00a1
                java.lang.Object r0 = r6.get(r0)     // Catch:{ JSONException -> 0x009a }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ JSONException -> 0x009a }
                r11 = r0
                goto L_0x00a1
            L_0x009a:
                r0 = move-exception
                r18 = r11
                r11 = r4
                r4 = r18
                goto L_0x00a7
            L_0x00a1:
                W2.J r0 = W2.J.f19942a     // Catch:{ JSONException -> 0x009a }
                r15 = r2
                r14 = r3
                r13 = r4
                goto L_0x00b8
            L_0x00a7:
                java.lang.String r6 = "Error parsing the configs remotely fetched: "
                int r0 = android.util.Log.e(r9, r6, r0)
                kotlin.coroutines.jvm.internal.b.b(r0)
                r15 = r2
                r14 = r3
                r13 = r11
                r11 = r4
                goto L_0x00b8
            L_0x00b5:
                r13 = r11
                r14 = r13
                r15 = r14
            L_0x00b8:
                e1.d r0 = r1.f15248c
                e1.l r0 = r0.f15239e
                if (r11 == 0) goto L_0x00c5
                int r2 = r11.intValue()
                goto L_0x00cd
            L_0x00c5:
                e1.d$a r2 = e1.C1630d.f15232g
                int r2 = r2.a()
            L_0x00cd:
                e1.d r3 = r1.f15248c
                b1.a0 r3 = r3.f15235a
                b1.Z r3 = r3.a()
                long r3 = r3.a()
                e1.h r12 = new e1.h
                java.lang.Integer r16 = kotlin.coroutines.jvm.internal.b.b(r2)
                java.lang.Long r17 = kotlin.coroutines.jvm.internal.b.c(r3)
                r12.<init>(r13, r14, r15, r16, r17)
                r1.f15246a = r7
                java.lang.Object r0 = r0.c(r12, r1)
                if (r0 != r5) goto L_0x00f1
                return r5
            L_0x00f1:
                W2.J r0 = W2.J.f19942a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: e1.C1630d.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: e1.d$d  reason: collision with other inner class name */
    static final class C0149d extends l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f15249a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f15250b;

        C0149d(C2308e eVar) {
            super(2, eVar);
        }

        /* renamed from: b */
        public final Object invoke(String str, C2308e eVar) {
            return ((C0149d) create(str, eVar)).invokeSuspend(J.f19942a);
        }

        public final C2308e create(Object obj, C2308e eVar) {
            C0149d dVar = new C0149d(eVar);
            dVar.f15250b = obj;
            return dVar;
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15249a == 0) {
                u.b(obj);
                Log.e("FirebaseSessions", "Error failed to fetch the remote configs: " + ((String) this.f15250b));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        C2795a.C0262a aVar = C2795a.f25994b;
    }

    public C1630d(a0 a0Var, e eVar, C1017b bVar, C1627a aVar, l lVar) {
        t.e(a0Var, "timeProvider");
        t.e(eVar, "firebaseInstallationsApi");
        t.e(bVar, "appInfo");
        t.e(aVar, "configsFetcher");
        t.e(lVar, "settingsCache");
        this.f15235a = a0Var;
        this.f15236b = eVar;
        this.f15237c = bVar;
        this.f15238d = aVar;
        this.f15239e = lVar;
    }

    private final String i(String str) {
        return f15234i.h(str, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092 A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d A[SYNTHETIC, Splitter:B:38:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(b3.C2308e r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            boolean r2 = r0 instanceof e1.C1630d.b
            if (r2 == 0) goto L_0x0017
            r2 = r0
            e1.d$b r2 = (e1.C1630d.b) r2
            int r3 = r2.f15245e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f15245e = r3
            goto L_0x001c
        L_0x0017:
            e1.d$b r2 = new e1.d$b
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f15243c
            java.lang.Object r3 = c3.C2316b.f()
            int r4 = r2.f15245e
            r5 = 3
            r6 = 2
            r7 = 1
            java.lang.String r8 = "FirebaseSessions"
            r9 = 0
            if (r4 == 0) goto L_0x0062
            if (r4 == r7) goto L_0x0056
            if (r4 == r6) goto L_0x0046
            if (r4 != r5) goto L_0x003e
            java.lang.Object r2 = r2.f15241a
            F3.a r2 = (F3.a) r2
            W2.u.b(r0)     // Catch:{ all -> 0x003b }
            goto L_0x014c
        L_0x003b:
            r0 = move-exception
            goto L_0x0154
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0046:
            java.lang.Object r4 = r2.f15242b
            F3.a r4 = (F3.a) r4
            java.lang.Object r10 = r2.f15241a
            e1.d r10 = (e1.C1630d) r10
            W2.u.b(r0)     // Catch:{ all -> 0x0052 }
            goto L_0x00af
        L_0x0052:
            r0 = move-exception
            r2 = r4
            goto L_0x0154
        L_0x0056:
            java.lang.Object r4 = r2.f15242b
            F3.a r4 = (F3.a) r4
            java.lang.Object r10 = r2.f15241a
            e1.d r10 = (e1.C1630d) r10
            W2.u.b(r0)
            goto L_0x008a
        L_0x0062:
            W2.u.b(r0)
            F3.a r0 = r1.f15240f
            boolean r0 = r0.isLocked()
            if (r0 != 0) goto L_0x0078
            e1.l r0 = r1.f15239e
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x0078
            W2.J r0 = W2.J.f19942a
            return r0
        L_0x0078:
            F3.a r0 = r1.f15240f
            r2.f15241a = r1
            r2.f15242b = r0
            r2.f15245e = r7
            java.lang.Object r4 = r0.lock(r9, r2)
            if (r4 != r3) goto L_0x0088
            goto L_0x014a
        L_0x0088:
            r4 = r0
            r10 = r1
        L_0x008a:
            e1.l r0 = r10.f15239e     // Catch:{ all -> 0x0052 }
            boolean r0 = r0.d()     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x009d
            java.lang.String r0 = "Remote settings cache not expired. Using cached values."
            android.util.Log.d(r8, r0)     // Catch:{ all -> 0x0052 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0052 }
            r4.unlock(r9)
            return r0
        L_0x009d:
            b1.w$a r0 = b1.C1037w.f4725c     // Catch:{ all -> 0x0052 }
            S0.e r11 = r10.f15236b     // Catch:{ all -> 0x0052 }
            r2.f15241a = r10     // Catch:{ all -> 0x0052 }
            r2.f15242b = r4     // Catch:{ all -> 0x0052 }
            r2.f15245e = r6     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.a(r11, r2)     // Catch:{ all -> 0x0052 }
            if (r0 != r3) goto L_0x00af
            goto L_0x014a
        L_0x00af:
            b1.w r0 = (b1.C1037w) r0     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0052 }
            java.lang.String r11 = ""
            boolean r11 = kotlin.jvm.internal.t.a(r0, r11)     // Catch:{ all -> 0x0052 }
            if (r11 == 0) goto L_0x00c8
            java.lang.String r0 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r8, r0)     // Catch:{ all -> 0x0052 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0052 }
            r4.unlock(r9)
            return r0
        L_0x00c8:
            java.lang.String r11 = "X-Crashlytics-Installation-ID"
            W2.s r0 = W2.y.a(r11, r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r11 = "X-Crashlytics-Device-Model"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r12.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r13 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0052 }
            r12.append(r13)     // Catch:{ all -> 0x0052 }
            java.lang.String r13 = android.os.Build.MODEL     // Catch:{ all -> 0x0052 }
            r12.append(r13)     // Catch:{ all -> 0x0052 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0052 }
            java.lang.String r12 = r10.i(r12)     // Catch:{ all -> 0x0052 }
            W2.s r11 = W2.y.a(r11, r12)     // Catch:{ all -> 0x0052 }
            java.lang.String r12 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r13 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0052 }
            java.lang.String r14 = "INCREMENTAL"
            kotlin.jvm.internal.t.d(r13, r14)     // Catch:{ all -> 0x0052 }
            java.lang.String r13 = r10.i(r13)     // Catch:{ all -> 0x0052 }
            W2.s r12 = W2.y.a(r12, r13)     // Catch:{ all -> 0x0052 }
            java.lang.String r13 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r14 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0052 }
            java.lang.String r15 = "RELEASE"
            kotlin.jvm.internal.t.d(r14, r15)     // Catch:{ all -> 0x0052 }
            java.lang.String r14 = r10.i(r14)     // Catch:{ all -> 0x0052 }
            W2.s r13 = W2.y.a(r13, r14)     // Catch:{ all -> 0x0052 }
            java.lang.String r14 = "X-Crashlytics-API-Client-Version"
            b1.b r15 = r10.f15237c     // Catch:{ all -> 0x0052 }
            java.lang.String r15 = r15.f()     // Catch:{ all -> 0x0052 }
            W2.s r14 = W2.y.a(r14, r15)     // Catch:{ all -> 0x0052 }
            r15 = 5
            W2.s[] r15 = new W2.s[r15]     // Catch:{ all -> 0x0052 }
            r16 = 0
            r15[r16] = r0     // Catch:{ all -> 0x0052 }
            r15[r7] = r11     // Catch:{ all -> 0x0052 }
            r15[r6] = r12     // Catch:{ all -> 0x0052 }
            r15[r5] = r13     // Catch:{ all -> 0x0052 }
            r0 = 4
            r15[r0] = r14     // Catch:{ all -> 0x0052 }
            java.util.Map r0 = X2.M.k(r15)     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = "Fetching settings from server."
            android.util.Log.d(r8, r6)     // Catch:{ all -> 0x0052 }
            e1.a r6 = r10.f15238d     // Catch:{ all -> 0x0052 }
            e1.d$c r7 = new e1.d$c     // Catch:{ all -> 0x0052 }
            r7.<init>(r10, r9)     // Catch:{ all -> 0x0052 }
            e1.d$d r8 = new e1.d$d     // Catch:{ all -> 0x0052 }
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            r2.f15241a = r4     // Catch:{ all -> 0x0052 }
            r2.f15242b = r9     // Catch:{ all -> 0x0052 }
            r2.f15245e = r5     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r6.a(r0, r7, r8, r2)     // Catch:{ all -> 0x0052 }
            if (r0 != r3) goto L_0x014b
        L_0x014a:
            return r3
        L_0x014b:
            r2 = r4
        L_0x014c:
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x003b }
            r2.unlock(r9)
            W2.J r0 = W2.J.f19942a
            return r0
        L_0x0154:
            r2.unlock(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.C1630d.a(b3.e):java.lang.Object");
    }

    public Boolean b() {
        return this.f15239e.e();
    }

    public C2795a c() {
        Integer b5 = this.f15239e.b();
        if (b5 == null) {
            return null;
        }
        C2795a.C0262a aVar = C2795a.f25994b;
        return C2795a.e(C2797c.s(b5.intValue(), C2798d.SECONDS));
    }

    public Double d() {
        return this.f15239e.a();
    }
}
