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
import l2.L;
import l2.M;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class i0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15058a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15059b;

    /* renamed from: c  reason: collision with root package name */
    private final w f15060c = F.a((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final w f15061d = F.a((Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final w f15062e = F.a((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private final w f15063f = F.a((Object) null);

    /* renamed from: g  reason: collision with root package name */
    private final w f15064g = F.a(0L);

    /* renamed from: h  reason: collision with root package name */
    private final w f15065h = F.a(Boolean.FALSE);

    /* renamed from: i  reason: collision with root package name */
    private final w f15066i = F.a(Boolean.TRUE);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final L f15067a;

        public a(L l5) {
            this.f15067a = l5;
        }

        public final L a() {
            return this.f15067a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f15067a, ((a) obj).f15067a);
        }

        public int hashCode() {
            L l5 = this.f15067a;
            if (l5 == null) {
                return 0;
            }
            return l5.hashCode();
        }

        public String toString() {
            return "VirusTotalReportData(reportVT=" + this.f15067a + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15068a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i0 f15069b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f15070c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f15071d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f15072e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f15073f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i0 i0Var, Context context, boolean z4, long j5, long j6, C2308e eVar) {
            super(2, eVar);
            this.f15069b = i0Var;
            this.f15070c = context;
            this.f15071d = z4;
            this.f15072e = j5;
            this.f15073f = j6;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15069b, this.f15070c, this.f15071d, this.f15072e, this.f15073f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            long j5;
            L l5;
            C2316b.f();
            if (this.f15068a == 0) {
                u.b(obj);
                this.f15069b.f15058a.setValue(O.a.f26507a);
                Z z4 = new Z(this.f15070c);
                if (!this.f15071d) {
                    j5 = this.f15072e;
                } else {
                    j5 = this.f15073f;
                }
                M D02 = z4.D0(String.valueOf(j5));
                if (!D02.b() && D02.e() != null) {
                    JSONObject e5 = D02.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONObject != null) {
                        l5 = new L();
                        l5.a(optJSONObject);
                        this.f15069b.f15058a.setValue(new O.c(new a(l5)));
                        return J.f19942a;
                    }
                }
                l5 = null;
                this.f15069b.f15058a.setValue(new O.c(new a(l5)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public i0() {
        w a5 = F.a(O.b.f26508a);
        this.f15058a = a5;
        this.f15059b = a5;
    }

    public final void b(Context context, long j5, long j6, boolean z4) {
        t.e(context, "context");
        boolean z5 = z4;
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, z5, j5, j6, (C2308e) null), 2, (Object) null);
    }

    public final w c() {
        return this.f15060c;
    }

    public final w d() {
        return this.f15061d;
    }

    public final D e() {
        return this.f15059b;
    }

    public final w f() {
        return this.f15064g;
    }

    public final w g() {
        return this.f15063f;
    }

    public final w h() {
        return this.f15062e;
    }

    public final w i() {
        return this.f15065h;
    }

    public final w j() {
        return this.f15066i;
    }
}
