package g2;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.preferences.a;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2670t;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.H;
import z2.Z;

public final class r {

    /* renamed from: b  reason: collision with root package name */
    public static final b f22084b = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f22085a;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22086a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f22087b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(r rVar, C2308e eVar) {
            super(2, eVar);
            this.f22087b = rVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22087b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22086a;
            if (i5 == 0) {
                u.b(obj);
                r rVar = this.f22087b;
                this.f22086a = 1;
                if (rVar.g(this) == f5) {
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

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f22089b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(r rVar, C2308e eVar) {
            super(2, eVar);
            this.f22089b = rVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f22089b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONObject optJSONObject;
            C2316b.f();
            if (this.f22088a == 0) {
                u.b(obj);
                if (this.f22089b.e()) {
                    C2940B a5 = C2940B.f26458v.a(this.f22089b.f22085a);
                    a5.a();
                    ArrayList q02 = a5.q0();
                    ArrayList r02 = a5.r0();
                    a5.m();
                    if (q02.size() > 0 || r02.size() > 0) {
                        Z z4 = new Z(this.f22089b.f22085a);
                        l2.M e5 = z4.e();
                        if (z4.i(e5) && e5.e() != null) {
                            JSONObject e6 = e5.e();
                            t.b(e6);
                            if (e6.optInt("success") == 1 && (optJSONObject = e6.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null && optJSONObject.optInt("result") == 1) {
                                if (q02.size() > 0) {
                                    l2.M M02 = z4.M0(q02);
                                    if (z4.i(M02) && M02.e() != null) {
                                        JSONObject e7 = M02.e();
                                        t.b(e7);
                                        if (e7.optInt("success") == 1) {
                                            a5.a();
                                            Iterator it = q02.iterator();
                                            t.d(it, "iterator(...)");
                                            while (it.hasNext()) {
                                                Object next = it.next();
                                                t.d(next, "next(...)");
                                                a5.C(((C2670t) next).a());
                                            }
                                            a5.m();
                                        }
                                    }
                                }
                                if (r02.size() > 0) {
                                    l2.M N02 = z4.N0(r02);
                                    if (z4.i(N02) && N02.e() != null) {
                                        JSONObject e8 = N02.e();
                                        t.b(e8);
                                        if (e8.optInt("success") == 1) {
                                            a5.a();
                                            Iterator it2 = r02.iterator();
                                            t.d(it2, "iterator(...)");
                                            while (it2.hasNext()) {
                                                Object next2 = it2.next();
                                                t.d(next2, "next(...)");
                                                a5.F(((C2670t) next2).a());
                                            }
                                            a5.m();
                                        }
                                    }
                                }
                            }
                        }
                        r rVar = this.f22089b;
                        rVar.f(rVar.f22085a);
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public r(Context context) {
        t.e(context, "context");
        this.f22085a = context;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean e() {
        if (H.f26488a.d()) {
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            long t5 = aVar.t(this.f22085a);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - t5 > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                aVar.T0(this.f22085a, currentTimeMillis);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void f(Context context) {
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        a5.I();
        a5.J();
        a5.m();
    }

    /* access modifiers changed from: private */
    public final Object g(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
