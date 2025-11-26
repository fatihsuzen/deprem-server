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
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.Z;

/* renamed from: g2.o  reason: case insensitive filesystem */
public final class C2393o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21993a;

    /* renamed from: g2.o$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21994a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2393o f21995b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2393o oVar, C2308e eVar) {
            super(2, eVar);
            this.f21995b = oVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21995b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21994a;
            if (i5 == 0) {
                u.b(obj);
                C2393o oVar = this.f21995b;
                this.f21994a = 1;
                if (oVar.c(this) == f5) {
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

    /* renamed from: g2.o$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21996a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2393o f21997b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2393o oVar, C2308e eVar) {
            super(2, eVar);
            this.f21997b = oVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21997b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21996a == 0) {
                u.b(obj);
                l2.M J02 = new Z(this.f21997b.f21993a).J0();
                if (!J02.b() && J02.e() != null) {
                    JSONObject e5 = J02.e();
                    t.b(e5);
                    if (!e5.isNull("is_request_in_eea_or_unknown")) {
                        boolean optBoolean = e5.optBoolean("is_request_in_eea_or_unknown");
                        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                        aVar.I0(this.f21997b.f21993a, optBoolean);
                        aVar.J0(this.f21997b.f21993a, true);
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2393o(Context context) {
        t.e(context, "context");
        this.f21993a = context;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object c(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
