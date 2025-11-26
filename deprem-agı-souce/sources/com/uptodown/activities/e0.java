package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.M;
import l2.X;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class e0 extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final w f14971a = F.a(new X());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final w f14972b;

    /* renamed from: c  reason: collision with root package name */
    private final D f14973c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final w f14974d;

    /* renamed from: e  reason: collision with root package name */
    private final D f14975e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final w f14976f;

    /* renamed from: g  reason: collision with root package name */
    private final D f14977g;

    /* renamed from: h  reason: collision with root package name */
    private final w f14978h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final X f14979a;

        public a(X x4) {
            t.e(x4, "userDevice");
            this.f14979a = x4;
        }

        public final X a() {
            return this.f14979a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f14979a, ((a) obj).f14979a);
        }

        public int hashCode() {
            return this.f14979a.hashCode();
        }

        public String toString() {
            return "UserDeviceData(userDevice=" + this.f14979a + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f14980a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14981b;

        /* renamed from: c  reason: collision with root package name */
        private final long f14982c;

        /* renamed from: d  reason: collision with root package name */
        private final String f14983d;

        public b(int i5, String str, long j5, String str2) {
            t.e(str2, "newName");
            this.f14980a = i5;
            this.f14981b = str;
            this.f14982c = j5;
            this.f14983d = str2;
        }

        public final String a() {
            return this.f14981b;
        }

        public final String b() {
            return this.f14983d;
        }

        public final int c() {
            return this.f14980a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14980a == bVar.f14980a && t.a(this.f14981b, bVar.f14981b) && this.f14982c == bVar.f14982c && t.a(this.f14983d, bVar.f14983d);
        }

        public int hashCode() {
            int i5 = this.f14980a * 31;
            String str = this.f14981b;
            return ((((i5 + (str == null ? 0 : str.hashCode())) * 31) + androidx.collection.a.a(this.f14982c)) * 31) + this.f14983d.hashCode();
        }

        public String toString() {
            return "UserDeviceRenameActionData(success=" + this.f14980a + ", msg=" + this.f14981b + ", deviceID=" + this.f14982c + ", newName=" + this.f14983d + ')';
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f14984a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14985b;

        /* renamed from: c  reason: collision with root package name */
        private final String f14986c;

        public c(int i5, String str, String str2) {
            this.f14984a = i5;
            this.f14985b = str;
            this.f14986c = str2;
        }

        public final String a() {
            return this.f14986c;
        }

        public final String b() {
            return this.f14985b;
        }

        public final int c() {
            return this.f14984a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f14984a == cVar.f14984a && t.a(this.f14985b, cVar.f14985b) && t.a(this.f14986c, cVar.f14986c);
        }

        public int hashCode() {
            int i5 = this.f14984a * 31;
            String str = this.f14985b;
            int i6 = 0;
            int hashCode = (i5 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f14986c;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return hashCode + i6;
        }

        public String toString() {
            return "UserDeviceUnlinkActionData(success=" + this.f14984a + ", msg=" + this.f14985b + ", identifier=" + this.f14986c + ')';
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14987a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f14988b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ X f14989c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e0 f14990d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, X x4, e0 e0Var, C2308e eVar) {
            super(2, eVar);
            this.f14988b = context;
            this.f14989c = x4;
            this.f14990d = e0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14988b, this.f14989c, this.f14990d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14987a == 0) {
                u.b(obj);
                M z02 = new Z(this.f14988b).z0(String.valueOf(this.f14989c.b()));
                if (!z02.b() && z02.e() != null) {
                    JSONObject e5 = z02.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONObject != null) {
                        X.f24900l.b(this.f14989c, optJSONObject);
                    }
                }
                this.f14990d.h().setValue(this.f14989c);
                this.f14990d.f14972b.setValue(new O.c(new a(this.f14989c)));
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
        int f14991a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f14992b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f14993c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f14994d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ e0 f14995e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, long j5, String str, e0 e0Var, C2308e eVar) {
            super(2, eVar);
            this.f14992b = context;
            this.f14993c = j5;
            this.f14994d = str;
            this.f14995e = e0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14992b, this.f14993c, this.f14994d, this.f14995e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14991a == 0) {
                u.b(obj);
                M s12 = new Z(this.f14992b).s1(String.valueOf(this.f14993c), this.f14994d);
                if (s12.e() != null) {
                    JSONObject e5 = s12.e();
                    t.b(e5);
                    int optInt = e5.optInt("success");
                    if (s12.b()) {
                        this.f14995e.f14974d.setValue(new O.c(new b(optInt, s12.g(e5), this.f14993c, this.f14994d)));
                    } else {
                        String string = this.f14992b.getString(R.string.device_rename);
                        t.d(string, "getString(...)");
                        this.f14995e.f14974d.setValue(new O.c(new b(optInt, string, this.f14993c, this.f14994d)));
                    }
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
        int f14996a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f14997b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f14998c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e0 f14999d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f15000e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Context context, long j5, e0 e0Var, String str, C2308e eVar) {
            super(2, eVar);
            this.f14997b = context;
            this.f14998c = j5;
            this.f14999d = e0Var;
            this.f15000e = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f14997b, this.f14998c, this.f14999d, this.f15000e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14996a == 0) {
                u.b(obj);
                M r12 = new Z(this.f14997b).r1(String.valueOf(this.f14998c));
                if (r12.e() != null) {
                    JSONObject e5 = r12.e();
                    t.b(e5);
                    int optInt = e5.optInt("success");
                    if (r12.b()) {
                        this.f14999d.f14976f.setValue(new O.c(new c(optInt, r12.g(e5), this.f15000e)));
                    } else {
                        String string = this.f14997b.getString(R.string.unlinked_device);
                        t.d(string, "getString(...)");
                        this.f14999d.f14976f.setValue(new O.c(new c(optInt, string, this.f15000e)));
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public e0() {
        w a5 = F.a(O.a.f26507a);
        this.f14972b = a5;
        this.f14973c = a5;
        O.b bVar = O.b.f26508a;
        w a6 = F.a(bVar);
        this.f14974d = a6;
        this.f14975e = a6;
        w a7 = F.a(bVar);
        this.f14976f = a7;
        this.f14977g = a7;
        this.f14978h = F.a(Boolean.TRUE);
    }

    public final void d(Context context, X x4) {
        t.e(context, "context");
        t.e(x4, "userDevice");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(context, x4, this, (C2308e) null), 2, (Object) null);
    }

    public final D e() {
        return this.f14973c;
    }

    public final D f() {
        return this.f14975e;
    }

    public final D g() {
        return this.f14977g;
    }

    public final w h() {
        return this.f14971a;
    }

    public final w i() {
        return this.f14978h;
    }

    public final void j(Context context, long j5, String str) {
        t.e(context, "context");
        t.e(str, "newName");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(context, j5, str, this, (C2308e) null), 2, (Object) null);
    }

    public final void k(Context context, long j5, String str) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new f(context, j5, this, str, (C2308e) null), 2, (Object) null);
    }
}
