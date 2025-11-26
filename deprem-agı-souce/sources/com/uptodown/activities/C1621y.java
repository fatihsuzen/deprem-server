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
import l2.M;
import l2.W;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

/* renamed from: com.uptodown.activities.y  reason: case insensitive filesystem */
public final class C1621y extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15200a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15201b;

    /* renamed from: com.uptodown.activities.y$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final W f15202a;

        public a(W w4) {
            t.e(w4, "userDataStats");
            this.f15202a = w4;
        }

        public final W a() {
            return this.f15202a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f15202a, ((a) obj).f15202a);
        }

        public int hashCode() {
            return this.f15202a.hashCode();
        }

        public String toString() {
            return "UserStatsData(userDataStats=" + this.f15202a + ')';
        }
    }

    /* renamed from: com.uptodown.activities.y$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15203a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1621y f15204b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f15205c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1621y yVar, Context context, C2308e eVar) {
            super(2, eVar);
            this.f15204b = yVar;
            this.f15205c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15204b, this.f15205c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15203a == 0) {
                u.b(obj);
                this.f15204b.f15200a.setValue(O.a.f26507a);
                M y02 = new Z(this.f15205c).y0();
                if (!y02.b() && y02.e() != null) {
                    JSONObject e5 = y02.e();
                    t.b(e5);
                    if (e5.optInt("success") == 1) {
                        JSONObject jSONObject = e5.getJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        w a5 = this.f15204b.f15200a;
                        W.b bVar = W.f24887m;
                        t.b(jSONObject);
                        a5.setValue(new O.c(new a(bVar.a(jSONObject))));
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C1621y() {
        w a5 = F.a(O.a.f26507a);
        this.f15200a = a5;
        this.f15201b = a5;
    }

    public final void b(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, (C2308e) null), 2, (Object) null);
    }

    public final D c() {
        return this.f15201b;
    }
}
