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
import l2.M;
import l2.O;
import l2.V;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class d0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f14950a;

    /* renamed from: b  reason: collision with root package name */
    private final D f14951b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f14952c;

    /* renamed from: d  reason: collision with root package name */
    private final D f14953d;

    /* renamed from: e  reason: collision with root package name */
    private final w f14954e = F.a(new V());

    /* renamed from: f  reason: collision with root package name */
    private w f14955f = F.a(Boolean.FALSE);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f14956g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14957h;

    /* renamed from: i  reason: collision with root package name */
    private int f14958i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final V f14959a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f14960b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f14961c;

        public a(V v5, ArrayList arrayList, boolean z4) {
            t.e(arrayList, "reviews");
            this.f14959a = v5;
            this.f14960b = arrayList;
            this.f14961c = z4;
        }

        public final ArrayList a() {
            return this.f14960b;
        }

        public final V b() {
            return this.f14959a;
        }

        public final boolean c() {
            return this.f14961c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f14959a, aVar.f14959a) && t.a(this.f14960b, aVar.f14960b) && this.f14961c == aVar.f14961c;
        }

        public int hashCode() {
            V v5 = this.f14959a;
            return ((((v5 == null ? 0 : v5.hashCode()) * 31) + this.f14960b.hashCode()) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f14961c);
        }

        public String toString() {
            return "UserCommentsData(user=" + this.f14959a + ", reviews=" + this.f14960b + ", userExists=" + this.f14961c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14962a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0 f14963b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f14964c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d0 d0Var, Context context, C2308e eVar) {
            super(2, eVar);
            this.f14963b = d0Var;
            this.f14964c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14963b, this.f14964c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14962a == 0) {
                u.b(obj);
                this.f14963b.m(true);
                ArrayList arrayList = new ArrayList();
                Z z4 = new Z(this.f14964c);
                String j5 = ((V) this.f14963b.k().getValue()).j();
                t.b(j5);
                M v02 = z4.v0(j5, 20, this.f14963b.i());
                if (!v02.b() && v02.e() != null) {
                    JSONObject e5 = v02.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("user");
                        if (optJSONObject2 != null) {
                            ((V) this.f14963b.k().getValue()).n(optJSONObject2);
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("comments");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            this.f14963b.f().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        } else {
                            int length = optJSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                O.b bVar = O.f24814p;
                                JSONObject jSONObject = optJSONArray.getJSONObject(i5);
                                t.d(jSONObject, "getJSONObject(...)");
                                arrayList.add(bVar.k(jSONObject));
                            }
                        }
                    }
                } else if (v02.f() == 404) {
                    this.f14963b.f14956g = false;
                }
                d0 d0Var = this.f14963b;
                d0Var.n(d0Var.i() + arrayList.size());
                this.f14963b.f14950a.setValue(new O.c(new a((V) this.f14963b.k().getValue(), arrayList, this.f14963b.f14956g)));
                this.f14963b.m(false);
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
        int f14965a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l2.O f14966b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f14967c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0 f14968d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(l2.O o5, Context context, d0 d0Var, C2308e eVar) {
            super(2, eVar);
            this.f14966b = o5;
            this.f14967c = context;
            this.f14968d = d0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14966b, this.f14967c, this.f14968d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14965a;
            if (i5 == 0) {
                u.b(obj);
                O.b bVar = l2.O.f24814p;
                l2.O o5 = this.f14966b;
                Context context = this.f14967c;
                this.f14965a = 1;
                obj = bVar.f(o5, context, this);
                if (obj == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f14968d.f14952c.setValue(new O.c(new O.c(this.f14966b, ((Number) obj).intValue())));
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public d0() {
        O.a aVar = O.a.f26507a;
        w a5 = F.a(aVar);
        this.f14950a = a5;
        this.f14951b = a5;
        w a6 = F.a(aVar);
        this.f14952c = a6;
        this.f14953d = a6;
    }

    public final void e(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, (C2308e) null), 2, (Object) null);
    }

    public final w f() {
        return this.f14955f;
    }

    public final D g() {
        return this.f14951b;
    }

    public final boolean h() {
        return this.f14957h;
    }

    public final int i() {
        return this.f14958i;
    }

    public final D j() {
        return this.f14953d;
    }

    public final w k() {
        return this.f14954e;
    }

    public final void l(Context context, l2.O o5) {
        t.e(context, "context");
        t.e(o5, "review");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(o5, context, this, (C2308e) null), 2, (Object) null);
    }

    public final void m(boolean z4) {
        this.f14957h = z4;
    }

    public final void n(int i5) {
        this.f14958i = i5;
    }
}
