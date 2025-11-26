package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2607q;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.Z;

/* renamed from: g2.e  reason: case insensitive filesystem */
public final class C2383e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21706a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f21707b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2607q f21708c;

    /* renamed from: g2.e$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21709a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2383e f21710b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2383e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f21710b = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21710b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21709a;
            if (i5 == 0) {
                u.b(obj);
                C2383e eVar = this.f21710b;
                this.f21709a = 1;
                if (eVar.e(this) == f5) {
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

    /* renamed from: g2.e$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21711a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2383e f21712b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f21713c;

        /* renamed from: g2.e$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21714a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2383e f21715b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21716c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2383e eVar, ArrayList arrayList, C2308e eVar2) {
                super(2, eVar2);
                this.f21715b = eVar;
                this.f21716c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21715b, this.f21716c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21714a == 0) {
                    u.b(obj);
                    this.f21715b.f21708c.a(this.f21716c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2383e eVar, ArrayList arrayList, C2308e eVar2) {
            super(2, eVar2);
            this.f21712b = eVar;
            this.f21713c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21712b, this.f21713c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            Object f5 = C2316b.f();
            int i5 = this.f21711a;
            if (i5 == 0) {
                u.b(obj);
                Context b5 = this.f21712b.f21706a;
                t.b(b5);
                Z z4 = new Z(b5);
                Iterator it = this.f21712b.f21707b.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    long f6 = new C2657f().f(z4.n((String) next));
                    if (f6 > 0) {
                        l2.M X4 = z4.X(f6);
                        if (!(X4.b() || (d5 = X4.d()) == null || d5.length() == 0)) {
                            String d6 = X4.d();
                            t.b(d6);
                            JSONObject jSONObject = new JSONObject(d6);
                            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                            if (jSONObject.optInt("success") == 1 && optJSONObject != null) {
                                this.f21713c.add(C2657f.f25002J0.a(optJSONObject, this.f21712b.f21706a));
                            }
                        }
                    }
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21712b, this.f21713c, (C2308e) null);
                this.f21711a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2383e(Context context, ArrayList arrayList, C2607q qVar, M m5) {
        t.e(arrayList, "packagenames");
        t.e(qVar, "listener");
        t.e(m5, "scope");
        this.f21706a = context;
        this.f21707b = arrayList;
        this.f21708c = qVar;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object e(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, new ArrayList(), (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
