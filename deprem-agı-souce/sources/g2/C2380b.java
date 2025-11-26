package g2;

import W2.J;
import W2.u;
import android.content.Context;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.workers.DownloadApkWorker;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2650J;
import l2.C2657f;
import l2.C2667p;
import l2.C2668q;
import l2.V;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.F;
import z2.H;
import z2.Z;

/* renamed from: g2.b  reason: case insensitive filesystem */
public final class C2380b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21667a;

    /* renamed from: b  reason: collision with root package name */
    private final M f21668b;

    /* renamed from: g2.b$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21669a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2380b f21670b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2380b bVar, C2308e eVar) {
            super(2, eVar);
            this.f21670b = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21670b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21669a;
            if (i5 == 0) {
                u.b(obj);
                C2380b bVar = this.f21670b;
                this.f21669a = 1;
                if (bVar.c(this) == f5) {
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

    /* renamed from: g2.b$b  reason: collision with other inner class name */
    static final class C0225b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21671a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2380b f21672b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0225b(C2380b bVar, C2308e eVar) {
            super(2, eVar);
            this.f21672b = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0225b(this.f21672b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            V h5;
            String d5;
            C2316b.f();
            if (this.f21671a == 0) {
                u.b(obj);
                String k5 = com.uptodown.activities.preferences.a.f15150a.k(this.f21672b.f21667a);
                if ((k5 == null || k5.length() == 0) && (h5 = V.f24870q.h(this.f21672b.f21667a)) != null && h5.p(this.f21672b.f21667a)) {
                    C2667p pVar = new C2667p();
                    pVar.j(this.f21672b.f21667a);
                    Z z4 = new Z(this.f21672b.f21667a);
                    if (pVar.d() != null) {
                        String d6 = pVar.d();
                        t.b(d6);
                        l2.M d02 = z4.d0(d6);
                        if (!d02.b() && d02.e() != null) {
                            JSONObject e5 = d02.e();
                            t.b(e5);
                            int optInt = e5.optInt("success");
                            JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                            if (optInt == 1 && optJSONArray != null) {
                                C2940B a5 = C2940B.f26458v.a(this.f21672b.f21667a);
                                a5.a();
                                int length = optJSONArray.length();
                                for (int i5 = 0; i5 < length; i5++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                                    C2650J j5 = new C2650J();
                                    t.b(optJSONObject);
                                    j5.d(optJSONObject);
                                    if (!a5.E0(j5.a()).isEmpty()) {
                                        a5.M(j5.a());
                                    }
                                    a5.a1(j5);
                                    F f5 = new F(this.f21672b.f21667a);
                                    Bundle bundle = new Bundle();
                                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "polling_received");
                                    f5.d("remote_install", bundle);
                                }
                                a5.m();
                            }
                        }
                        C2940B a6 = C2940B.f26458v.a(this.f21672b.f21667a);
                        a6.a();
                        Iterator it = a6.v0().iterator();
                        t.d(it, "iterator(...)");
                        int i6 = -1;
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            C2650J j6 = (C2650J) next;
                            l2.M X4 = z4.X(j6.a());
                            if (X4.b() || (d5 = X4.d()) == null || d5.length() == 0) {
                                a6.M(j6.a());
                            } else {
                                String d7 = X4.d();
                                t.b(d7);
                                JSONObject jSONObject = new JSONObject(d7);
                                int optInt2 = jSONObject.optInt("success");
                                JSONObject optJSONObject2 = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                                if (optInt2 == 1 && optJSONObject2 != null) {
                                    C2657f fVar = new C2657f();
                                    C2657f.b(fVar, optJSONObject2, (Context) null, 2, (Object) null);
                                    C2668q qVar = new C2668q();
                                    qVar.c(fVar);
                                    j6.g(qVar.S(this.f21672b.f21667a));
                                    a6.H1(j6);
                                    if (i6 == -1) {
                                        i6 = j6.b();
                                    }
                                }
                            }
                        }
                        a6.m();
                        if (i6 != -1 && H.f26488a.d()) {
                            DownloadApkWorker.f21342i.b(this.f21672b.f21667a, i6);
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C0225b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2380b(Context context, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f21667a = context;
        this.f21668b = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object c(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new C0225b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
