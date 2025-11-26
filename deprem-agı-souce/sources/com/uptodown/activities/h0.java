package com.uptodown.activities;

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
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.M;
import l2.V;
import l2.a0;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class h0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15038a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15039b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f15040c;

    /* renamed from: d  reason: collision with root package name */
    private final D f15041d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f15042a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15043b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15044c;

        public a(int i5, boolean z4, String str) {
            this.f15042a = i5;
            this.f15043b = z4;
            this.f15044c = str;
        }

        public final boolean a() {
            return this.f15043b;
        }

        public final String b() {
            return this.f15044c;
        }

        public final int c() {
            return this.f15042a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15042a == aVar.f15042a && this.f15043b == aVar.f15043b && t.a(this.f15044c, aVar.f15044c);
        }

        public int hashCode() {
            int a5 = ((this.f15042a * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f15043b)) * 31;
            String str = this.f15044c;
            return a5 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UsernameEditData(success=" + this.f15042a + ", error=" + this.f15043b + ", regErrors=" + this.f15044c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15045a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f15046b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f15047c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f15048d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f15049e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ L f15050f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ J f15051g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ V f15052h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f15053i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h0 h0Var, Context context, String str, int i5, L l5, J j5, V v5, String str2, C2308e eVar) {
            super(2, eVar);
            this.f15046b = h0Var;
            this.f15047c = context;
            this.f15048d = str;
            this.f15049e = i5;
            this.f15050f = l5;
            this.f15051g = j5;
            this.f15052h = v5;
            this.f15053i = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15046b, this.f15047c, this.f15048d, this.f15049e, this.f15050f, this.f15051g, this.f15052h, this.f15053i, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15045a == 0) {
                u.b(obj);
                this.f15046b.f15038a.setValue(O.a.f26507a);
                M h5 = new Z(this.f15047c).h(this.f15048d, this.f15049e);
                if (h5.e() != null) {
                    JSONObject e5 = h5.e();
                    t.b(e5);
                    this.f15050f.f24690a = h5.g(e5);
                    this.f15051g.f24688a = e5.optInt("success");
                    if (this.f15051g.f24688a == 1) {
                        V v5 = this.f15052h;
                        if (v5 != null) {
                            v5.z(this.f15048d);
                        }
                        V v6 = this.f15052h;
                        if (v6 != null) {
                            v6.D(this.f15053i);
                        }
                        V v7 = this.f15052h;
                        if (v7 != null) {
                            v7.s(this.f15047c);
                        }
                    }
                }
                this.f15046b.f15038a.setValue(new O.c(new a(this.f15051g.f24688a, h5.b(), (String) this.f15050f.f24690a)));
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15055b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f15056c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h0 f15057d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList arrayList, h0 h0Var, C2308e eVar) {
            super(2, eVar);
            this.f15055b = context;
            this.f15056c = arrayList;
            this.f15057d = h0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f15055b, this.f15056c, this.f15057d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15054a == 0) {
                u.b(obj);
                M B02 = new Z(this.f15055b).B0();
                if (!B02.b() && B02.e() != null) {
                    JSONObject e5 = B02.e();
                    t.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            ArrayList arrayList = this.f15056c;
                            a0 a0Var = new a0();
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                            t.d(optJSONObject, "optJSONObject(...)");
                            a0Var.a(optJSONObject);
                            arrayList.add(a0Var);
                        }
                    }
                }
                this.f15057d.f15040c.setValue(this.f15056c);
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public h0() {
        w a5 = F.a(O.b.f26508a);
        this.f15038a = a5;
        this.f15039b = a5;
        w a6 = F.a(new ArrayList());
        this.f15040c = a6;
        this.f15041d = a6;
    }

    public final void c(Context context, String str, V v5, int i5, String str2) {
        t.e(context, "context");
        t.e(str, "newUsername");
        String str3 = str2;
        t.e(str3, "usernameFormat");
        J j5 = new J();
        L l5 = new L();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, str, i5, l5, j5, v5, str3, (C2308e) null), 2, (Object) null);
    }

    public final void d(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(context, new ArrayList(), this, (C2308e) null), 2, (Object) null);
    }

    public final D e() {
        return this.f15039b;
    }

    public final D f() {
        return this.f15041d;
    }
}
