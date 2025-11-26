package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
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

public final class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f22090a;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22091a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f22092b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22093c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(s sVar, String str, C2308e eVar) {
            super(2, eVar);
            this.f22092b = sVar;
            this.f22093c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22092b, this.f22093c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22091a;
            if (i5 == 0) {
                u.b(obj);
                s sVar = this.f22092b;
                String str = this.f22093c;
                this.f22091a = 1;
                if (sVar.c(str, this) == f5) {
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
        int f22094a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f22095b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22096c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(s sVar, String str, C2308e eVar) {
            super(2, eVar);
            this.f22095b = sVar;
            this.f22096c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f22095b, this.f22096c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f22094a == 0) {
                u.b(obj);
                l2.M g12 = new Z(this.f22095b.f22090a).g1(this.f22096c);
                boolean z4 = false;
                if (g12.e() != null) {
                    JSONObject e5 = g12.e();
                    t.b(e5);
                    if (e5.optInt("success") == 1) {
                        z4 = true;
                    }
                }
                com.uptodown.activities.preferences.a.f15150a.G0(this.f22095b.f22090a, z4);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public s(Context context, String str) {
        t.e(context, "context");
        t.e(str, "token");
        this.f22090a = context;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, str, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object c(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
