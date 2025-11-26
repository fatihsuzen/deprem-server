package z2;

import W2.J;
import android.content.Context;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import c3.C2316b;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.V;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

public final class I {

    /* renamed from: a  reason: collision with root package name */
    private V f26493a;

    /* renamed from: b  reason: collision with root package name */
    private String f26494b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26495c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26496a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f26497b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f26498c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f26499d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f26500e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ I f26501f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, L l5, String str, String str2, I i5, C2308e eVar) {
            super(2, eVar);
            this.f26497b = context;
            this.f26498c = l5;
            this.f26499d = str;
            this.f26500e = str2;
            this.f26501f = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f26497b, this.f26498c, this.f26499d, this.f26500e, this.f26501f, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00da, code lost:
            if (r0.length() > 0) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x011d, code lost:
            if (r0.length() > 0) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0140, code lost:
            if (r1.length() > 0) goto L_0x0142;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                c3.C2316b.f()
                int r0 = r4.f26496a
                if (r0 != 0) goto L_0x0152
                W2.u.b(r5)
                r5 = 2131952026(0x7f13019a, float:1.9540483E38)
                z2.Z r0 = new z2.Z     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r1 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                r0.<init>(r1)     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r1 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r2 = r4.f26499d     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r3 = r4.f26500e     // Catch:{ JSONException -> 0x0077 }
                l2.M r0 = r0.o1(r2, r3)     // Catch:{ JSONException -> 0x0077 }
                r1.f24690a = r0     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r0 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r0 = r0.f24690a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.t.b(r0)     // Catch:{ JSONException -> 0x0077 }
                l2.M r0 = (l2.M) r0     // Catch:{ JSONException -> 0x0077 }
                org.json.JSONObject r0 = r0.e()     // Catch:{ JSONException -> 0x0077 }
                if (r0 == 0) goto L_0x00af
                kotlin.jvm.internal.L r0 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r0 = r0.f24690a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.t.b(r0)     // Catch:{ JSONException -> 0x0077 }
                l2.M r0 = (l2.M) r0     // Catch:{ JSONException -> 0x0077 }
                org.json.JSONObject r0 = r0.e()     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.t.b(r0)     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r1 = "data"
                org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r2 = "success"
                int r2 = r0.optInt(r2)     // Catch:{ JSONException -> 0x0077 }
                r3 = 1
                if (r2 != r3) goto L_0x0094
                if (r1 == 0) goto L_0x0094
                z2.I r0 = r4.f26501f     // Catch:{ JSONException -> 0x0077 }
                l2.V r0 = r0.c()     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.t.b(r0)     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                r0.g(r2, r1)     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                r0.s(r2)     // Catch:{ JSONException -> 0x0077 }
                com.uptodown.activities.preferences.a$a r0 = com.uptodown.activities.preferences.a.f15150a     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r0 = r0.L(r2)     // Catch:{ JSONException -> 0x0077 }
                if (r0 == 0) goto L_0x0079
                int r0 = r0.length()     // Catch:{ JSONException -> 0x0077 }
                if (r0 != 0) goto L_0x00bd
                goto L_0x0079
            L_0x0074:
                r0 = move-exception
                goto L_0x0123
            L_0x0077:
                r0 = move-exception
                goto L_0x00ec
            L_0x0079:
                z2.I r0 = r4.f26501f     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r3 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f24690a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.t.b(r3)     // Catch:{ JSONException -> 0x0077 }
                l2.M r3 = (l2.M) r3     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r1 = r3.g(r1)     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r3 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f24690a     // Catch:{ JSONException -> 0x0077 }
                l2.M r3 = (l2.M) r3     // Catch:{ JSONException -> 0x0077 }
                r0.h(r2, r1, r3)     // Catch:{ JSONException -> 0x0077 }
                goto L_0x00bd
            L_0x0094:
                z2.I r1 = r4.f26501f     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r3 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f24690a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.t.b(r3)     // Catch:{ JSONException -> 0x0077 }
                l2.M r3 = (l2.M) r3     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r0 = r3.g(r0)     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r3 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f24690a     // Catch:{ JSONException -> 0x0077 }
                l2.M r3 = (l2.M) r3     // Catch:{ JSONException -> 0x0077 }
                r1.h(r2, r0, r3)     // Catch:{ JSONException -> 0x0077 }
                goto L_0x00bd
            L_0x00af:
                z2.I r0 = r4.f26501f     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r1 = r4.f26497b     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.L r2 = r4.f26498c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r2 = r2.f24690a     // Catch:{ JSONException -> 0x0077 }
                l2.M r2 = (l2.M) r2     // Catch:{ JSONException -> 0x0077 }
                r3 = 0
                r0.h(r1, r3, r2)     // Catch:{ JSONException -> 0x0077 }
            L_0x00bd:
                z2.I r0 = r4.f26501f
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x0120
                z2.I r0 = r4.f26501f
                java.lang.String r0 = r0.b()
                if (r0 == 0) goto L_0x00dc
                z2.I r0 = r4.f26501f
                java.lang.String r0 = r0.b()
                kotlin.jvm.internal.t.b(r0)
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0120
            L_0x00dc:
                z2.I r0 = r4.f26501f
                android.content.Context r1 = r4.f26497b
                android.content.res.Resources r1 = r1.getResources()
                java.lang.String r5 = r1.getString(r5)
                r0.i(r5)
                goto L_0x0120
            L_0x00ec:
                r0.printStackTrace()     // Catch:{ all -> 0x0074 }
                z2.I r1 = r4.f26501f     // Catch:{ all -> 0x0074 }
                android.content.Context r2 = r4.f26497b     // Catch:{ all -> 0x0074 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0074 }
                kotlin.jvm.internal.L r3 = r4.f26498c     // Catch:{ all -> 0x0074 }
                java.lang.Object r3 = r3.f24690a     // Catch:{ all -> 0x0074 }
                l2.M r3 = (l2.M) r3     // Catch:{ all -> 0x0074 }
                r1.h(r2, r0, r3)     // Catch:{ all -> 0x0074 }
                z2.I r0 = r4.f26501f
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x0120
                z2.I r0 = r4.f26501f
                java.lang.String r0 = r0.b()
                if (r0 == 0) goto L_0x00dc
                z2.I r0 = r4.f26501f
                java.lang.String r0 = r0.b()
                kotlin.jvm.internal.t.b(r0)
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0120
                goto L_0x00dc
            L_0x0120:
                W2.J r5 = W2.J.f19942a
                return r5
            L_0x0123:
                z2.I r1 = r4.f26501f
                boolean r1 = r1.e()
                if (r1 == 0) goto L_0x0151
                z2.I r1 = r4.f26501f
                java.lang.String r1 = r1.b()
                if (r1 == 0) goto L_0x0142
                z2.I r1 = r4.f26501f
                java.lang.String r1 = r1.b()
                kotlin.jvm.internal.t.b(r1)
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0151
            L_0x0142:
                z2.I r1 = r4.f26501f
                android.content.Context r2 = r4.f26497b
                android.content.res.Resources r2 = r2.getResources()
                java.lang.String r5 = r2.getString(r5)
                r1.i(r5)
            L_0x0151:
                throw r0
            L_0x0152:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: z2.I.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final void h(Context context, String str, l2.M m5) {
        this.f26495c = true;
        V.f24870q.c(context);
        this.f26493a = null;
        if (str != null) {
            this.f26494b = str;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
        bundle.putString("loginSource", "google");
        if (m5 != null) {
            bundle.putString("responseCode", String.valueOf(m5.f()));
            if (m5.c() != null) {
                String c5 = m5.c();
                t.b(c5);
                bundle.putString("exception", c5);
            }
        }
        new F(context).d("login", bundle);
    }

    public final String b() {
        return this.f26494b;
    }

    public final V c() {
        return this.f26493a;
    }

    public final b d(Context context) {
        t.e(context, "context");
        GoogleSignInOptions a5 = new GoogleSignInOptions.a(GoogleSignInOptions.f4802l).b().d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com").a();
        t.d(a5, "build(...)");
        b a6 = com.google.android.gms.auth.api.signin.a.a(context, a5);
        t.d(a6, "getClient(...)");
        return a6;
    }

    public final boolean e() {
        return this.f26495c;
    }

    public final void f(Context context) {
        t.e(context, "context");
        new I().d(context).s();
    }

    public final Object g(String str, String str2, Context context, C2308e eVar) {
        this.f26493a = new V();
        Context context2 = context;
        Object g5 = C2872g.g(C2865c0.b(), new a(context2, new L(), str, str2, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final void i(String str) {
        this.f26494b = str;
    }
}
