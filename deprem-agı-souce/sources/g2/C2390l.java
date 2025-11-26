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
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.T;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.Z;

/* renamed from: g2.l  reason: case insensitive filesystem */
public final class C2390l {

    /* renamed from: c  reason: collision with root package name */
    public static final b f21950c = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f21951a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f21952b;

    /* renamed from: g2.l$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21953a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2390l f21954b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2390l lVar, C2308e eVar) {
            super(2, eVar);
            this.f21954b = lVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21954b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21953a;
            if (i5 == 0) {
                u.b(obj);
                C2390l lVar = this.f21954b;
                this.f21953a = 1;
                if (lVar.d(this) == f5) {
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

    /* renamed from: g2.l$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final boolean a(long j5) {
            if (System.currentTimeMillis() - j5 > 86400000) {
                return true;
            }
            return false;
        }

        private b() {
        }
    }

    /* renamed from: g2.l$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21955a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2390l f21956b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f21957c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2390l lVar, kotlin.jvm.internal.J j5, C2308e eVar) {
            super(2, eVar);
            this.f21956b = lVar;
            this.f21957c = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21956b, this.f21957c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            boolean z4;
            C2655d dVar;
            long j5;
            int i5;
            String d5;
            C2316b.f();
            if (this.f21955a == 0) {
                u.b(obj);
                boolean z5 = true;
                if (C2390l.f21950c.a(com.uptodown.activities.preferences.a.f15150a.u(this.f21956b.f21952b))) {
                    this.f21957c.f24688a++;
                }
                Iterator it = this.f21956b.f21951a.iterator();
                String str2 = "iterator(...)";
                t.d(it, str2);
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    if (((C2655d) next).y() == 0) {
                        this.f21957c.f24688a++;
                    }
                }
                if (this.f21957c.f24688a > 0) {
                    Z z6 = new Z(this.f21956b.f21952b);
                    com.uptodown.activities.preferences.a.f15150a.U0(this.f21956b.f21952b, System.currentTimeMillis());
                    l2.M p02 = z6.p0();
                    if (!p02.b() && p02.e() != null) {
                        JSONObject e5 = p02.e();
                        t.b(e5);
                        if (!e5.isNull("success")) {
                            JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                            if (e5.optInt("success") == 1 && optJSONArray != null) {
                                C2940B a5 = C2940B.f26458v.a(this.f21956b.f21952b);
                                a5.a();
                                int length = optJSONArray.length();
                                int i6 = 0;
                                while (i6 < length) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                                    if (!optJSONObject.isNull("packageName")) {
                                        String optString = optJSONObject.optString("packageName");
                                        Iterator it2 = this.f21956b.f21951a.iterator();
                                        t.d(it2, str2);
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                dVar = null;
                                                break;
                                            }
                                            Object next2 = it2.next();
                                            t.d(next2, "next(...)");
                                            dVar = (C2655d) next2;
                                            if (s.E(optString, dVar.o(), z5)) {
                                                break;
                                            }
                                        }
                                        if (dVar != null) {
                                            if (!optJSONObject.isNull("appID")) {
                                                j5 = optJSONObject.optLong("appID");
                                            } else {
                                                j5 = 0;
                                            }
                                            str = str2;
                                            long j6 = j5;
                                            if (!optJSONObject.isNull("hasOldVersions")) {
                                                i5 = optJSONObject.optInt("hasOldVersions");
                                            } else {
                                                i5 = 0;
                                            }
                                            if (!(dVar.y() != 0 && dVar.b() == j6 && dVar.h() == i5)) {
                                                t.b(optString);
                                                a5.I1(optString, j6, i5);
                                            }
                                            this.f21956b.f21951a.remove(dVar);
                                            String o5 = dVar.o();
                                            t.b(o5);
                                            T G02 = a5.G0(o5);
                                            if (G02 != null) {
                                                l2.M X4 = z6.X(j6);
                                                if (!(X4.b() || (d5 = X4.d()) == null || d5.length() == 0)) {
                                                    String d6 = X4.d();
                                                    t.b(d6);
                                                    JSONObject jSONObject = new JSONObject(d6);
                                                    JSONObject optJSONObject2 = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                                                    z4 = true;
                                                    if (jSONObject.optInt("success") == 1 && optJSONObject2 != null) {
                                                        C2657f b5 = C2657f.b.b(C2657f.f25002J0, optJSONObject2, (Context) null, 2, (Object) null);
                                                        if (!(b5.O() == null || b5.S() == null)) {
                                                            G02.r(b5.O());
                                                            a5.C1(G02);
                                                        }
                                                    }
                                                    i6++;
                                                    z5 = z4;
                                                    str2 = str;
                                                }
                                            }
                                            z4 = true;
                                            i6++;
                                            z5 = z4;
                                            str2 = str;
                                        }
                                    }
                                    z4 = z5;
                                    str = str2;
                                    i6++;
                                    z5 = z4;
                                    str2 = str;
                                }
                                Iterator it3 = this.f21956b.f21951a.iterator();
                                t.d(it3, str2);
                                while (it3.hasNext()) {
                                    Object next3 = it3.next();
                                    t.d(next3, "next(...)");
                                    C2655d dVar2 = (C2655d) next3;
                                    if (dVar2.o() != null && dVar2.y() == 0) {
                                        String o6 = dVar2.o();
                                        t.b(o6);
                                        a5.I1(o6, dVar2.b(), 0);
                                    }
                                }
                                a5.m();
                            }
                        }
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

    public C2390l(ArrayList arrayList, Context context, M m5) {
        t.e(arrayList, "apps");
        t.e(context, "context");
        t.e(m5, "scope");
        this.f21951a = arrayList;
        this.f21952b = context;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object d(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, new kotlin.jvm.internal.J(), (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
