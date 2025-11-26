package g2;

import W2.J;
import W2.u;
import X2.C2250q;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2600j;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2646F;
import l2.C2655d;
import l2.C2667p;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.Z;

/* renamed from: g2.c  reason: case insensitive filesystem */
public final class C2381c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21673a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2600j f21674b;

    /* renamed from: c  reason: collision with root package name */
    private final M f21675c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f21676d;

    /* renamed from: g2.c$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21677a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2381c f21678b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2381c cVar, C2308e eVar) {
            super(2, eVar);
            this.f21678b = cVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21678b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21677a;
            if (i5 == 0) {
                u.b(obj);
                C2381c cVar = this.f21678b;
                this.f21677a = 1;
                if (cVar.f(this) == f5) {
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

    /* renamed from: g2.c$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21679a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2381c f21680b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f21681c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f21682d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ L f21683e;

        /* renamed from: g2.c$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21684a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2381c f21685b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21686c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ L f21687d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f21688e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2381c cVar, ArrayList arrayList, L l5, kotlin.jvm.internal.J j5, C2308e eVar) {
                super(2, eVar);
                this.f21685b = cVar;
                this.f21686c = arrayList;
                this.f21687d = l5;
                this.f21688e = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21685b, this.f21686c, this.f21687d, this.f21688e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21684a == 0) {
                    u.b(obj);
                    ArrayList d5 = this.f21685b.f21676d;
                    if (d5 == null || d5.isEmpty()) {
                        C2600j c5 = this.f21685b.f21674b;
                        if (c5 == null) {
                            return null;
                        }
                        c5.b();
                        return J.f19942a;
                    }
                    if (this.f21685b.f21674b == null) {
                        if (!this.f21686c.isEmpty()) {
                            z2.M.f26506a.p(this.f21685b.f21673a, this.f21686c.size(), (String) this.f21687d.f24690a);
                        }
                    } else if (this.f21688e.f24688a == 1) {
                        C2600j c6 = this.f21685b.f21674b;
                        t.b(c6);
                        ArrayList d6 = this.f21685b.f21676d;
                        t.b(d6);
                        c6.a(d6);
                    } else {
                        C2600j c7 = this.f21685b.f21674b;
                        t.b(c7);
                        c7.b();
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2381c cVar, kotlin.jvm.internal.J j5, ArrayList arrayList, L l5, C2308e eVar) {
            super(2, eVar);
            this.f21680b = cVar;
            this.f21681c = j5;
            this.f21682d = arrayList;
            this.f21683e = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21680b, this.f21681c, this.f21682d, this.f21683e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            Object f5 = C2316b.f();
            int i5 = this.f21679a;
            if (i5 == 0) {
                u.b(obj);
                C2667p pVar = new C2667p();
                pVar.j(this.f21680b.f21673a);
                Z z4 = new Z(this.f21680b.f21673a);
                int i6 = 0;
                if (pVar.d() != null) {
                    String d5 = pVar.d();
                    t.b(d5);
                    l2.M T4 = z4.T(d5);
                    if (!T4.b() && T4.e() != null) {
                        JSONObject e5 = T4.e();
                        t.b(e5);
                        this.f21681c.f24688a = e5.optInt("success");
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (this.f21681c.f24688a == 1 && optJSONArray != null) {
                            this.f21680b.f21676d = new ArrayList();
                            int length = optJSONArray.length();
                            for (int i7 = 0; i7 < length; i7++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i7);
                                C2646F f6 = new C2646F();
                                t.b(optJSONObject);
                                f6.a(optJSONObject);
                                ArrayList d6 = this.f21680b.f21676d;
                                t.b(d6);
                                d6.add(f6);
                            }
                        }
                    }
                }
                ArrayList d7 = this.f21680b.f21676d;
                if (d7 != null && !d7.isEmpty()) {
                    C2940B a5 = C2940B.f26458v.a(this.f21680b.f21673a);
                    a5.a();
                    ArrayList d02 = a5.d0();
                    ArrayList arrayList = new ArrayList();
                    ArrayList d8 = this.f21680b.f21676d;
                    t.b(d8);
                    int size = d8.size();
                    int i8 = 0;
                    while (true) {
                        str = null;
                        if (i8 >= size) {
                            break;
                        }
                        int size2 = d02.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size2) {
                                break;
                            }
                            String r5 = ((C2655d) d02.get(i9)).r();
                            if (r5 != null) {
                                ArrayList d9 = this.f21680b.f21676d;
                                t.b(d9);
                                if (s.E(r5, ((C2646F) d9.get(i8)).c(), true)) {
                                    ArrayList d10 = this.f21680b.f21676d;
                                    t.b(d10);
                                    arrayList.add(d10.get(i8));
                                    Object obj3 = d02.get(i9);
                                    t.d(obj3, "get(...)");
                                    C2655d dVar = (C2655d) obj3;
                                    if (dVar.q() == 0) {
                                        dVar.Y(1);
                                        a5.y1(dVar);
                                        ArrayList d11 = this.f21680b.f21676d;
                                        t.b(d11);
                                        Iterator it = d11.iterator();
                                        t.d(it, "iterator(...)");
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            t.d(next, "next(...)");
                                            C2646F f7 = (C2646F) next;
                                            if (s.F(f7.c(), dVar.r(), false, 2, (Object) null)) {
                                                this.f21682d.add(f7);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            i9++;
                        }
                        i8++;
                    }
                    a5.m();
                    this.f21680b.f21676d = arrayList;
                    if (this.f21682d.size() == 1) {
                        ArrayList arrayList2 = this.f21682d;
                        int size3 = d02.size();
                        while (true) {
                            if (i6 >= size3) {
                                obj2 = null;
                                break;
                            }
                            obj2 = d02.get(i6);
                            i6++;
                            if (t.a(((C2655d) obj2).r(), ((C2646F) C2250q.M(arrayList2)).c())) {
                                break;
                            }
                        }
                        C2655d dVar2 = (C2655d) obj2;
                        L l5 = this.f21683e;
                        if (dVar2 != null) {
                            str = dVar2.m();
                        }
                        l5.f24690a = str;
                    }
                }
                com.uptodown.activities.preferences.a.f15150a.P0(this.f21680b.f21673a, System.currentTimeMillis());
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21680b, this.f21682d, this.f21683e, this.f21681c, (C2308e) null);
                this.f21679a = 1;
                Object g5 = C2872g.g(c5, aVar, this);
                if (g5 == f5) {
                    return f5;
                }
                return g5;
            } else if (i5 == 1) {
                u.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2381c(Context context, C2600j jVar, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f21673a = context;
        this.f21674b = jVar;
        this.f21675c = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(C2308e eVar) {
        return C2872g.g(C2865c0.b(), new b(this, new kotlin.jvm.internal.J(), new ArrayList(), new L(), (C2308e) null), eVar);
    }
}
