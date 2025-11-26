package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2644D;
import l2.M;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class B extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f13639a;

    /* renamed from: b  reason: collision with root package name */
    private final D f13640b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f13641c = F.a(new C2644D());

    /* renamed from: d  reason: collision with root package name */
    private final w f13642d = F.a(0L);

    /* renamed from: e  reason: collision with root package name */
    private final w f13643e = F.a("");

    /* renamed from: f  reason: collision with root package name */
    private boolean f13644f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13645g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13646h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f13647i = 2;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2644D f13648a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f13649b;

        public a(C2644D d5, boolean z4) {
            t.e(d5, "organization");
            this.f13648a = d5;
            this.f13649b = z4;
        }

        public final boolean a() {
            return this.f13649b;
        }

        public final C2644D b() {
            return this.f13648a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f13648a, aVar.f13648a) && this.f13649b == aVar.f13649b;
        }

        public int hashCode() {
            return (this.f13648a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f13649b);
        }

        public String toString() {
            return "OrganizationData(organization=" + this.f13648a + ", moreDataAdded=" + this.f13649b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13650a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ B f13651b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13652c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(B b5, Context context, C2308e eVar) {
            super(2, eVar);
            this.f13651b = b5;
            this.f13652c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13651b, this.f13652c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13650a == 0) {
                u.b(obj);
                this.f13651b.n(true);
                this.f13651b.m(false);
                M Q4 = new Z(this.f13652c).Q(((Number) this.f13651b.j().getValue()).longValue());
                if (!Q4.b() && Q4.e() != null) {
                    JSONObject e5 = Q4.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        ((C2644D) this.f13651b.f13641c.getValue()).p(optJSONObject);
                    } else if (e5.optInt("success") == 1) {
                        this.f13651b.m(true);
                    }
                }
                this.f13651b.f13639a.setValue(new O.c(new a((C2644D) this.f13651b.f13641c.getValue(), false)));
                this.f13651b.n(false);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ B f13654b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13655c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(B b5, Context context, C2308e eVar) {
            super(2, eVar);
            this.f13654b = b5;
            this.f13655c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13654b, this.f13655c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13653a == 0) {
                u.b(obj);
                this.f13654b.f13639a.setValue(O.a.f26507a);
                this.f13654b.n(true);
                M P4 = new Z(this.f13655c).P(((Number) this.f13654b.j().getValue()).longValue(), this.f13654b.f13647i);
                if (P4.b() || P4.e() == null) {
                    this.f13654b.m(true);
                    this.f13654b.f13639a.setValue(O.b.f26508a);
                } else {
                    JSONObject e5 = P4.e();
                    t.b(e5);
                    if (!e5.isNull(DataSchemeDataSource.SCHEME_DATA)) {
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONArray != null) {
                            ((C2644D) this.f13654b.f13641c.getValue()).q(((C2644D) this.f13654b.f13641c.getValue()).o(optJSONArray));
                        }
                    } else if (P4.b() && P4.f() == 404) {
                        this.f13654b.m(true);
                        this.f13654b.f13639a.setValue(O.b.f26508a);
                    }
                    this.f13654b.f13639a.setValue(new O.c(new a((C2644D) this.f13654b.f13641c.getValue(), true)));
                    int a5 = this.f13654b.f13647i;
                    this.f13654b.f13647i = a5 + 1;
                    kotlin.coroutines.jvm.internal.b.b(a5);
                }
                this.f13654b.n(false);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public B() {
        w a5 = F.a(O.a.f26507a);
        this.f13639a = a5;
        this.f13640b = a5;
    }

    public final void e(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, (C2308e) null), 2, (Object) null);
    }

    public final void f(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(this, context, (C2308e) null), 2, (Object) null);
    }

    public final boolean g() {
        return this.f13645g;
    }

    public final D h() {
        return this.f13640b;
    }

    public final boolean i() {
        return this.f13644f;
    }

    public final w j() {
        return this.f13642d;
    }

    public final w k() {
        return this.f13643e;
    }

    public final boolean l() {
        return this.f13646h;
    }

    public final void m(boolean z4) {
        this.f13645g = z4;
    }

    public final void n(boolean z4) {
        this.f13644f = z4;
    }

    public final void o(boolean z4) {
        this.f13646h = z4;
    }
}
