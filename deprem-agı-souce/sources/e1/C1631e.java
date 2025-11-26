package e1;

import W2.J;
import android.net.Uri;
import b1.C1017b;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.net.URL;
import java.util.Map;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.M;

/* renamed from: e1.e  reason: case insensitive filesystem */
public final class C1631e implements C1627a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f15251c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final C1017b f15252a;

    /* renamed from: b  reason: collision with root package name */
    private final C2312i f15253b;

    /* renamed from: e1.e$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: e1.e$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15254a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1631e f15255b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f15256c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p f15257d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ p f15258e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1631e eVar, Map map, p pVar, p pVar2, C2308e eVar2) {
            super(2, eVar2);
            this.f15255b = eVar;
            this.f15256c = map;
            this.f15257d = pVar;
            this.f15258e = pVar2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15255b, this.f15256c, this.f15257d, this.f15258e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cb, code lost:
            if (r8.invoke(r1, r7) == r0) goto L_0x00e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e0, code lost:
            if (r1.invoke(r3, r7) != r0) goto L_0x00e3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f15254a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0026
                if (r1 == r4) goto L_0x001e
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                W2.u.b(r8)
                goto L_0x00e3
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                W2.u.b(r8)     // Catch:{ Exception -> 0x0023 }
                goto L_0x00e3
            L_0x0023:
                r8 = move-exception
                goto L_0x00ce
            L_0x0026:
                W2.u.b(r8)
                e1.e r8 = r7.f15255b     // Catch:{ Exception -> 0x0023 }
                java.net.URL r8 = r8.c()     // Catch:{ Exception -> 0x0023 }
                java.net.URLConnection r8 = r8.openConnection()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection"
                kotlin.jvm.internal.t.c(r8, r1)     // Catch:{ Exception -> 0x0023 }
                javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = "GET"
                r8.setRequestMethod(r1)     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = "Accept"
                java.lang.String r5 = "application/json"
                r8.setRequestProperty(r1, r5)     // Catch:{ Exception -> 0x0023 }
                java.util.Map r1 = r7.f15256c     // Catch:{ Exception -> 0x0023 }
                java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x0023 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0023 }
            L_0x0050:
                boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x0023 }
                if (r5 == 0) goto L_0x006c
                java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x0023 }
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r6 = r5.getKey()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0023 }
                r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x0023 }
                goto L_0x0050
            L_0x006c:
                int r1 = r8.getResponseCode()     // Catch:{ Exception -> 0x0023 }
                r5 = 200(0xc8, float:2.8E-43)
                if (r1 != r5) goto L_0x00b2
                java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0023 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0023 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0023 }
                r3.<init>(r8)     // Catch:{ Exception -> 0x0023 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x0023 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
                r3.<init>()     // Catch:{ Exception -> 0x0023 }
                kotlin.jvm.internal.L r5 = new kotlin.jvm.internal.L     // Catch:{ Exception -> 0x0023 }
                r5.<init>()     // Catch:{ Exception -> 0x0023 }
            L_0x008c:
                java.lang.String r6 = r1.readLine()     // Catch:{ Exception -> 0x0023 }
                r5.f24690a = r6     // Catch:{ Exception -> 0x0023 }
                if (r6 == 0) goto L_0x0098
                r3.append(r6)     // Catch:{ Exception -> 0x0023 }
                goto L_0x008c
            L_0x0098:
                r1.close()     // Catch:{ Exception -> 0x0023 }
                r8.close()     // Catch:{ Exception -> 0x0023 }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0023 }
                r8.<init>(r1)     // Catch:{ Exception -> 0x0023 }
                k3.p r1 = r7.f15257d     // Catch:{ Exception -> 0x0023 }
                r7.f15254a = r4     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r8 = r1.invoke(r8, r7)     // Catch:{ Exception -> 0x0023 }
                if (r8 != r0) goto L_0x00e3
                goto L_0x00e2
            L_0x00b2:
                k3.p r8 = r7.f15258e     // Catch:{ Exception -> 0x0023 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
                r4.<init>()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r5 = "Bad response code: "
                r4.append(r5)     // Catch:{ Exception -> 0x0023 }
                r4.append(r1)     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0023 }
                r7.f15254a = r3     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r8 = r8.invoke(r1, r7)     // Catch:{ Exception -> 0x0023 }
                if (r8 != r0) goto L_0x00e3
                goto L_0x00e2
            L_0x00ce:
                k3.p r1 = r7.f15258e
                java.lang.String r3 = r8.getMessage()
                if (r3 != 0) goto L_0x00da
                java.lang.String r3 = r8.toString()
            L_0x00da:
                r7.f15254a = r2
                java.lang.Object r8 = r1.invoke(r3, r7)
                if (r8 != r0) goto L_0x00e3
            L_0x00e2:
                return r0
            L_0x00e3:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: e1.C1631e.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C1631e(C1017b bVar, C2312i iVar) {
        t.e(bVar, "appInfo");
        t.e(iVar, "blockingDispatcher");
        this.f15252a = bVar;
        this.f15253b = iVar;
    }

    /* access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f15252a.b()).appendPath("settings").appendQueryParameter("build_version", this.f15252a.a().a()).appendQueryParameter("display_version", this.f15252a.a().f()).build().toString());
    }

    public Object a(Map map, p pVar, p pVar2, C2308e eVar) {
        Object g5 = C2872g.g(this.f15253b, new b(this, map, pVar, pVar2, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
