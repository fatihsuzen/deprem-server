package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.M;
import l2.O;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class L extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f13872a;

    /* renamed from: b  reason: collision with root package name */
    private final D f13873b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f13874c;

    /* renamed from: d  reason: collision with root package name */
    private final D f13875d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final w f13876e;

    /* renamed from: f  reason: collision with root package name */
    private final D f13877f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final w f13878g;

    /* renamed from: h  reason: collision with root package name */
    private final D f13879h;

    /* renamed from: i  reason: collision with root package name */
    private w f13880i = F.a((Object) null);

    /* renamed from: j  reason: collision with root package name */
    private w f13881j = F.a((Object) null);

    /* renamed from: k  reason: collision with root package name */
    private w f13882k = F.a("date");

    /* renamed from: l  reason: collision with root package name */
    private w f13883l = F.a(-1);

    /* renamed from: m  reason: collision with root package name */
    private boolean f13884m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13885n;

    /* renamed from: o  reason: collision with root package name */
    private int f13886o;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f13887a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13888b;

        public a(int i5, int i6) {
            this.f13887a = i5;
            this.f13888b = i6;
        }

        public final int a() {
            return this.f13887a;
        }

        public final int b() {
            return this.f13888b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13887a == aVar.f13887a && this.f13888b == aVar.f13888b;
        }

        public int hashCode() {
            return (this.f13887a * 31) + this.f13888b;
        }

        public String toString() {
            return "FollowUserData(following=" + this.f13887a + ", itemPosition=" + this.f13888b + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f13889a;

        public b(ArrayList arrayList) {
            t.e(arrayList, "reviews");
            this.f13889a = arrayList;
        }

        public final ArrayList a() {
            return this.f13889a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && t.a(this.f13889a, ((b) obj).f13889a);
        }

        public int hashCode() {
            return this.f13889a.hashCode();
        }

        public String toString() {
            return "ReviewsData(reviews=" + this.f13889a + ')';
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f13890a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13891b;

        public c(int i5, int i6) {
            this.f13890a = i5;
            this.f13891b = i6;
        }

        public final int a() {
            return this.f13891b;
        }

        public final int b() {
            return this.f13890a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f13890a == cVar.f13890a && this.f13891b == cVar.f13891b;
        }

        public int hashCode() {
            return (this.f13890a * 31) + this.f13891b;
        }

        public String toString() {
            return "SendReviewData(success=" + this.f13890a + ", statusCode=" + this.f13891b + ')';
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f13893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13894c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(L l5, Context context, C2308e eVar) {
            super(2, eVar);
            this.f13893b = l5;
            this.f13894c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13893b, this.f13894c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13892a == 0) {
                u.b(obj);
                this.f13893b.f13872a.setValue(O.a.f26507a);
                ArrayList arrayList = new ArrayList();
                Z z4 = new Z(this.f13894c);
                Object value = this.f13893b.h().getValue();
                t.b(value);
                M f02 = z4.f0(((C2657f) value).e(), 20, this.f13893b.n(), (String) this.f13893b.o().getValue());
                if (f02.b() || f02.e() == null) {
                    this.f13893b.u(false);
                } else {
                    JSONObject e5 = f02.e();
                    t.b(e5);
                    int optInt = e5.optInt("success");
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optInt == 1 && optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            O.b bVar = l2.O.f24814p;
                            JSONObject jSONObject = optJSONArray.getJSONObject(i5);
                            t.d(jSONObject, "getJSONObject(...)");
                            arrayList.add(bVar.c(jSONObject));
                        }
                    }
                }
                this.f13893b.f13872a.setValue(new O.c(new b(arrayList)));
                L l5 = this.f13893b;
                l5.w(l5.n() + arrayList.size());
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13895a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13896b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13897c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f13898d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f13899e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, String str, L l5, int i5, C2308e eVar) {
            super(2, eVar);
            this.f13896b = context;
            this.f13897c = str;
            this.f13898d = l5;
            this.f13899e = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f13896b, this.f13897c, this.f13898d, this.f13899e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f13895a == 0) {
                u.b(obj);
                M k5 = new Z(this.f13896b).k(this.f13897c);
                if (!(k5.b() || (d5 = k5.d()) == null || d5.length() == 0)) {
                    this.f13898d.f13878g.setValue(new O.c(new a(1, this.f13899e)));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13900a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l2.O f13901b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13902c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f13903d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(l2.O o5, Context context, L l5, C2308e eVar) {
            super(2, eVar);
            this.f13901b = o5;
            this.f13902c = context;
            this.f13903d = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13901b, this.f13902c, this.f13903d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13900a;
            if (i5 == 0) {
                u.b(obj);
                O.b bVar = l2.O.f24814p;
                l2.O o5 = this.f13901b;
                Context context = this.f13902c;
                this.f13900a = 1;
                obj = bVar.f(o5, context, this);
                if (obj == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f13903d.f13876e.setValue(new O.c(new O.c(this.f13901b, ((Number) obj).intValue())));
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13904a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13905b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13906c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f13907d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Context context, String str, L l5, C2308e eVar) {
            super(2, eVar);
            this.f13905b = context;
            this.f13906c = str;
            this.f13907d = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f13905b, this.f13906c, this.f13907d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i5;
            C2316b.f();
            if (this.f13904a == 0) {
                u.b(obj);
                O.b bVar = l2.O.f24814p;
                int i6 = 0;
                if (!bVar.e(this.f13905b, this.f13906c)) {
                    bVar.j(this.f13905b, this.f13906c, String.valueOf(System.currentTimeMillis()));
                    Z z4 = new Z(this.f13905b);
                    l2.O o5 = new l2.O();
                    o5.z(this.f13906c);
                    o5.y(((Number) this.f13907d.q().getValue()).intValue());
                    Object value = this.f13907d.h().getValue();
                    t.b(value);
                    M Y02 = z4.Y0(((C2657f) value).e(), o5);
                    i5 = Y02.f();
                    if (!Y02.b() && Y02.e() != null) {
                        JSONObject e5 = Y02.e();
                        t.b(e5);
                        i6 = e5.optInt("success");
                    }
                } else {
                    i5 = 0;
                }
                this.f13907d.f13874c.setValue(new O.c(new c(i6, i5)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13909b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13910c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f13911d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f13912e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Context context, String str, L l5, int i5, C2308e eVar) {
            super(2, eVar);
            this.f13909b = context;
            this.f13910c = str;
            this.f13911d = l5;
            this.f13912e = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f13909b, this.f13910c, this.f13911d, this.f13912e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f13908a == 0) {
                u.b(obj);
                M q12 = new Z(this.f13909b).q1(this.f13910c);
                if (!(q12.b() || (d5 = q12.d()) == null || d5.length() == 0)) {
                    this.f13911d.f13878g.setValue(new O.c(new a(0, this.f13912e)));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public L() {
        w a5 = F.a(O.a.f26507a);
        this.f13872a = a5;
        this.f13873b = a5;
        O.b bVar = O.b.f26508a;
        w a6 = F.a(bVar);
        this.f13874c = a6;
        this.f13875d = a6;
        w a7 = F.a(bVar);
        this.f13876e = a7;
        this.f13877f = a7;
        w a8 = F.a(bVar);
        this.f13878g = a8;
        this.f13879h = a8;
    }

    private final void f(Context context, String str, int i5) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(context, str, this, i5, (C2308e) null), 2, (Object) null);
    }

    private final void x(Context context, String str, int i5) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new h(context, str, this, i5, (C2308e) null), 2, (Object) null);
    }

    public final void e(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(this, context, (C2308e) null), 2, (Object) null);
    }

    public final void g(Context context, int i5, String str, int i6) {
        t.e(context, "context");
        t.e(str, "userID");
        if (i5 == 1) {
            x(context, str, i6);
        } else {
            f(context, str, i6);
        }
    }

    public final w h() {
        return this.f13880i;
    }

    public final D i() {
        return this.f13873b;
    }

    public final D j() {
        return this.f13879h;
    }

    public final boolean k() {
        return this.f13884m;
    }

    public final boolean l() {
        return this.f13885n;
    }

    public final w m() {
        return this.f13881j;
    }

    public final int n() {
        return this.f13886o;
    }

    public final w o() {
        return this.f13882k;
    }

    public final D p() {
        return this.f13877f;
    }

    public final w q() {
        return this.f13883l;
    }

    public final D r() {
        return this.f13875d;
    }

    public final void s(Context context, l2.O o5) {
        t.e(context, "context");
        t.e(o5, "review");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new f(o5, context, this, (C2308e) null), 2, (Object) null);
    }

    public final void t(Context context, String str) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new g(context, str, this, (C2308e) null), 2, (Object) null);
    }

    public final void u(boolean z4) {
        this.f13884m = z4;
    }

    public final void v(boolean z4) {
        this.f13885n = z4;
    }

    public final void w(int i5) {
        this.f13886o = i5;
    }
}
