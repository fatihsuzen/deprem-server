package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.activities.preferences.a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import l2.C2667p;
import l2.Q;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.Z;

public final class t {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f22097a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2667p f22098b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Q f22099c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22100a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f22101b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t tVar, C2308e eVar) {
            super(2, eVar);
            this.f22101b = tVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22101b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22100a;
            if (i5 == 0) {
                u.b(obj);
                t tVar = this.f22101b;
                this.f22100a = 1;
                if (tVar.e(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22102a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f22103b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar, C2308e eVar) {
            super(2, eVar);
            this.f22103b = tVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f22103b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f22102a == 0) {
                u.b(obj);
                l2.M h12 = new Z(this.f22103b.f22097a).h1(this.f22103b.f22098b, this.f22103b.f22099c);
                if (h12.e() != null) {
                    JSONObject e5 = h12.e();
                    kotlin.jvm.internal.t.b(e5);
                    a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                    Context a5 = this.f22103b.f22097a;
                    boolean z4 = true;
                    if (e5.optInt("success") != 1) {
                        z4 = false;
                    }
                    aVar.h1(a5, z4);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public t(Context context, C2667p pVar, Q q5) {
        kotlin.jvm.internal.t.e(context, "context");
        kotlin.jvm.internal.t.e(pVar, "deviceInfo");
        kotlin.jvm.internal.t.e(q5, "settingsUTD");
        this.f22097a = context;
        this.f22098b = pVar;
        this.f22099c = q5;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object e(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
