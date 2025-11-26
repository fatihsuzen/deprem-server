package com.uptodown.activities;

import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import k2.U;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.O;
import l2.V;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class J extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f13768a;

    /* renamed from: b  reason: collision with root package name */
    private final D f13769b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f13770c;

    /* renamed from: d  reason: collision with root package name */
    private final D f13771d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final w f13772e;

    /* renamed from: f  reason: collision with root package name */
    private final D f13773f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final w f13774g;

    /* renamed from: h  reason: collision with root package name */
    private final D f13775h;

    /* renamed from: i  reason: collision with root package name */
    private int f13776i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f13777a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f13778b;

        public a(ArrayList arrayList, ArrayList arrayList2) {
            t.e(arrayList, "recommendedApps");
            t.e(arrayList2, "userReviews");
            this.f13777a = arrayList;
            this.f13778b = arrayList2;
        }

        public final ArrayList a() {
            return this.f13777a;
        }

        public final ArrayList b() {
            return this.f13778b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f13777a, aVar.f13777a) && t.a(this.f13778b, aVar.f13778b);
        }

        public int hashCode() {
            return (this.f13777a.hashCode() * 31) + this.f13778b.hashCode();
        }

        public String toString() {
            return "PublicProfileData(recommendedApps=" + this.f13777a + ", userReviews=" + this.f13778b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f13779a;

        /* renamed from: b  reason: collision with root package name */
        int f13780b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ J f13781c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f13782d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f13783e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f13784f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f13785g;

        public static final class a implements U {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ J f13786a;

            a(J j5) {
                this.f13786a = j5;
            }

            public void a() {
            }

            public void e(ArrayList arrayList) {
                t.e(arrayList, "userList");
                this.f13786a.f13770c.setValue(new O.c(arrayList));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(J j5, int i5, Context context, String str, int i6, C2308e eVar) {
            super(2, eVar);
            this.f13781c = j5;
            this.f13782d = i5;
            this.f13783e = context;
            this.f13784f = str;
            this.f13785g = i6;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13781c, this.f13782d, this.f13783e, this.f13784f, this.f13785g, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
            if (r6 == r0) goto L_0x007c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f13780b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                java.lang.Object r0 = r5.f13779a
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                W2.u.b(r6)
                goto L_0x007f
            L_0x0016:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001e:
                W2.u.b(r6)
                goto L_0x006a
            L_0x0022:
                W2.u.b(r6)
                com.uptodown.activities.J r6 = r5.f13781c
                int r1 = r5.f13782d
                r6.r(r1)
                l2.V$b r6 = l2.V.f24870q
                android.content.Context r1 = r5.f13783e
                l2.V r6 = r6.h(r1)
                java.lang.String r1 = r5.f13784f
                if (r6 == 0) goto L_0x003d
                java.lang.String r6 = r6.j()
                goto L_0x003e
            L_0x003d:
                r6 = 0
            L_0x003e:
                boolean r6 = kotlin.jvm.internal.t.a(r1, r6)
                if (r6 == 0) goto L_0x005b
                g2.w r6 = new g2.w
                android.content.Context r1 = r5.f13783e
                com.uptodown.activities.J r4 = r5.f13781c
                w3.M r4 = androidx.lifecycle.ViewModelKt.getViewModelScope(r4)
                r6.<init>(r1, r4)
                com.uptodown.activities.J$b$a r1 = new com.uptodown.activities.J$b$a
                com.uptodown.activities.J r4 = r5.f13781c
                r1.<init>(r4)
                r6.i(r1)
            L_0x005b:
                com.uptodown.activities.J r6 = r5.f13781c
                android.content.Context r1 = r5.f13783e
                java.lang.String r4 = r5.f13784f
                r5.f13780b = r3
                java.lang.Object r6 = r6.o(r1, r4, r5)
                if (r6 != r0) goto L_0x006a
                goto L_0x007c
            L_0x006a:
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                com.uptodown.activities.J r1 = r5.f13781c
                android.content.Context r3 = r5.f13783e
                java.lang.String r4 = r5.f13784f
                r5.f13779a = r6
                r5.f13780b = r2
                java.lang.Object r1 = r1.n(r3, r4, r5)
                if (r1 != r0) goto L_0x007d
            L_0x007c:
                return r0
            L_0x007d:
                r0 = r6
                r6 = r1
            L_0x007f:
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                com.uptodown.activities.J r1 = r5.f13781c
                z3.w r1 = r1.f13768a
                z2.O$c r2 = new z2.O$c
                com.uptodown.activities.J$a r3 = new com.uptodown.activities.J$a
                r3.<init>(r6, r0)
                r2.<init>(r3)
                r1.setValue(r2)
                com.uptodown.activities.J r6 = r5.f13781c
                z3.w r6 = r6.f13774g
                int r0 = r5.f13785g
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.b.b(r0)
                r6.setValue(r0)
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.J.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13787a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13788b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13789c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ J f13790d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, String str, J j5, C2308e eVar) {
            super(2, eVar);
            this.f13788b = context;
            this.f13789c = str;
            this.f13790d = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13788b, this.f13789c, this.f13790d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f13787a == 0) {
                u.b(obj);
                l2.M k5 = new Z(this.f13788b).k(this.f13789c);
                if (!(k5.b() || (d5 = k5.d()) == null || d5.length() == 0)) {
                    this.f13790d.f13774g.setValue(kotlin.coroutines.jvm.internal.b.b(1));
                    J j5 = this.f13790d;
                    j5.r(j5.k() + 1);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13792b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13793c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f13792b = context;
            this.f13793c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13792b, this.f13793c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f13791a == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                l2.M b02 = new Z(this.f13792b).b0(this.f13793c, 20, 0);
                if (!(b02.b() || (d5 = b02.d()) == null || d5.length() == 0)) {
                    String d6 = b02.d();
                    t.b(d6);
                    JSONArray optJSONArray = new JSONObject(d6).optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            C2657f.b bVar = C2657f.f25002J0;
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                            t.d(optJSONObject, "optJSONObject(...)");
                            arrayList.add(C2657f.b.b(bVar, optJSONObject, (Context) null, 2, (Object) null));
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13794a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13795b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13796c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f13795b = context;
            this.f13796c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f13795b, this.f13796c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            V v5;
            JSONArray jSONArray;
            String str;
            C2316b.f();
            if (this.f13794a == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                l2.M v02 = new Z(this.f13795b).v0(this.f13796c, 10, 0);
                if (!v02.b() && v02.e() != null) {
                    JSONObject e5 = v02.e();
                    t.b(e5);
                    if (!e5.isNull(DataSchemeDataSource.SCHEME_DATA)) {
                        JSONObject jSONObject = e5.getJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (!jSONObject.isNull("user")) {
                            v5 = new V();
                            JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                            t.d(jSONObject2, "getJSONObject(...)");
                            v5.n(jSONObject2);
                        } else {
                            v5 = null;
                        }
                        if (!jSONObject.isNull("comments")) {
                            jSONArray = jSONObject.getJSONArray("comments");
                        } else {
                            jSONArray = null;
                        }
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int length = jSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                O.b bVar = l2.O.f24814p;
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                t.d(jSONObject3, "getJSONObject(...)");
                                l2.O k5 = bVar.k(jSONObject3);
                                if (v5 != null) {
                                    str = v5.k();
                                } else {
                                    str = null;
                                }
                                if (!(str == null || str.length() == 0)) {
                                    k5.D(v5.k());
                                    if (v5.r()) {
                                        k5.B(1);
                                    }
                                }
                                arrayList.add(k5);
                            }
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13797a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l2.O f13798b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13799c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ J f13800d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(l2.O o5, Context context, J j5, C2308e eVar) {
            super(2, eVar);
            this.f13798b = o5;
            this.f13799c = context;
            this.f13800d = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13798b, this.f13799c, this.f13800d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13797a;
            if (i5 == 0) {
                u.b(obj);
                O.b bVar = l2.O.f24814p;
                l2.O o5 = this.f13798b;
                Context context = this.f13799c;
                this.f13797a = 1;
                obj = bVar.f(o5, context, this);
                if (obj == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f13800d.f13772e.setValue(new O.c(new O.c(this.f13798b, ((Number) obj).intValue())));
            return W2.J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13801a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13802b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13803c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ J f13804d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Context context, String str, J j5, C2308e eVar) {
            super(2, eVar);
            this.f13802b = context;
            this.f13803c = str;
            this.f13804d = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f13802b, this.f13803c, this.f13804d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f13801a == 0) {
                u.b(obj);
                l2.M q12 = new Z(this.f13802b).q1(this.f13803c);
                if (!(q12.b() || (d5 = q12.d()) == null || d5.length() == 0)) {
                    this.f13804d.f13774g.setValue(kotlin.coroutines.jvm.internal.b.b(0));
                    J j5 = this.f13804d;
                    j5.r(j5.k() - 1);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public J() {
        w a5 = F.a(O.b.f26508a);
        this.f13768a = a5;
        this.f13769b = a5;
        O.a aVar = O.a.f26507a;
        w a6 = F.a(aVar);
        this.f13770c = a6;
        this.f13771d = a6;
        w a7 = F.a(aVar);
        this.f13772e = a7;
        this.f13773f = a7;
        w a8 = F.a(0);
        this.f13774g = a8;
        this.f13775h = a8;
    }

    private final void h(Context context, String str) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(context, str, this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object n(Context context, String str, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new d(context, str, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    public final Object o(Context context, String str, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new e(context, str, (C2308e) null), eVar);
    }

    private final void s(Context context, String str) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new g(context, str, this, (C2308e) null), 2, (Object) null);
    }

    public final void g(Context context, String str, int i5, int i6) {
        t.e(context, "context");
        t.e(str, "userID");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, i6, context, str, i5, (C2308e) null), 2, (Object) null);
    }

    public final void i(Context context, String str) {
        t.e(context, "context");
        t.e(str, "userID");
        if (((Number) this.f13774g.getValue()).intValue() == 1) {
            s(context, str);
        } else {
            h(context, str);
        }
    }

    public final D j() {
        return this.f13775h;
    }

    public final int k() {
        return this.f13776i;
    }

    public final D l() {
        return this.f13773f;
    }

    public final D m() {
        return this.f13769b;
    }

    public final D p() {
        return this.f13771d;
    }

    public final void q(Context context, l2.O o5) {
        t.e(context, "context");
        t.e(o5, "review");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new f(o5, context, this, (C2308e) null), 2, (Object) null);
    }

    public final void r(int i5) {
        this.f13776i = i5;
    }
}
