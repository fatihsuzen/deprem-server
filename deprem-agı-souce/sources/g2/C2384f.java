package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import k2.r;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.N;
import l2.S;
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

/* renamed from: g2.f  reason: case insensitive filesystem */
public final class C2384f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21717a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final r f21718b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2660i f21719c;

    /* renamed from: d  reason: collision with root package name */
    private final M f21720d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f21721e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f21722f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f21723g = new ArrayList();

    /* renamed from: g2.f$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21724a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2384f f21725b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2384f fVar, C2308e eVar) {
            super(2, eVar);
            this.f21725b = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21725b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21724a;
            if (i5 == 0) {
                u.b(obj);
                C2384f fVar = this.f21725b;
                this.f21724a = 1;
                if (fVar.r(this) == f5) {
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

    /* renamed from: g2.f$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21726a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2384f f21727b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21728c;

        /* renamed from: g2.f$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21729a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21730b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21731c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2384f fVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21730b = fVar;
                this.f21731c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21730b, this.f21731c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21729a == 0) {
                    u.b(obj);
                    this.f21730b.f21718b.c((ArrayList) this.f21731c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2384f fVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21727b = fVar;
            this.f21728c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21727b, this.f21728c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21726a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                l5.f24690a = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f21727b.f21717a);
                a5.a();
                String str = "features_by_category_" + this.f21727b.f21719c.c();
                N F02 = a5.F0(str);
                if (F02 == null || !F02.a()) {
                    l2.M w4 = this.f21728c.w(this.f21727b.f21719c.c());
                    if (!w4.b() && w4.e() != null) {
                        l5.f24690a = this.f21728c.V0(w4);
                        String d5 = w4.d();
                        t.b(d5);
                        N n5 = new N(str, d5);
                        a5.Q(str);
                        a5.b1(n5);
                    }
                } else {
                    l5.f24690a = this.f21728c.V0(F02.c());
                }
                a5.m();
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21727b, l5, (C2308e) null);
                this.f21726a = 1;
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

    /* renamed from: g2.f$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21732a;

        /* renamed from: b  reason: collision with root package name */
        int f21733b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2384f f21734c;

        /* renamed from: g2.f$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21735a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21736b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Z f21737c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2384f fVar, Z z4, C2308e eVar) {
                super(2, eVar);
                this.f21736b = fVar;
                this.f21737c = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21736b, this.f21737c, eVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
                if (g2.C2384f.a(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
                if (g2.C2384f.h(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
                if (g2.C2384f.k(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
                if (g2.C2384f.l(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
                return r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = c3.C2316b.f()
                    int r1 = r6.f21735a
                    r2 = 4
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L_0x002c
                    if (r1 == r5) goto L_0x0028
                    if (r1 == r4) goto L_0x0024
                    if (r1 == r3) goto L_0x0020
                    if (r1 != r2) goto L_0x0018
                    W2.u.b(r7)
                    goto L_0x0063
                L_0x0018:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L_0x0020:
                    W2.u.b(r7)
                    goto L_0x0056
                L_0x0024:
                    W2.u.b(r7)
                    goto L_0x0049
                L_0x0028:
                    W2.u.b(r7)
                    goto L_0x003c
                L_0x002c:
                    W2.u.b(r7)
                    g2.f r7 = r6.f21736b
                    z2.Z r1 = r6.f21737c
                    r6.f21735a = r5
                    java.lang.Object r7 = r7.q(r1, r6)
                    if (r7 != r0) goto L_0x003c
                    goto L_0x0062
                L_0x003c:
                    g2.f r7 = r6.f21736b
                    z2.Z r1 = r6.f21737c
                    r6.f21735a = r4
                    java.lang.Object r7 = r7.t(r1, r6)
                    if (r7 != r0) goto L_0x0049
                    goto L_0x0062
                L_0x0049:
                    g2.f r7 = r6.f21736b
                    z2.Z r1 = r6.f21737c
                    r6.f21735a = r3
                    java.lang.Object r7 = r7.u(r1, r6)
                    if (r7 != r0) goto L_0x0056
                    goto L_0x0062
                L_0x0056:
                    g2.f r7 = r6.f21736b
                    z2.Z r1 = r6.f21737c
                    r6.f21735a = r2
                    java.lang.Object r7 = r7.w(r1, r6)
                    if (r7 != r0) goto L_0x0063
                L_0x0062:
                    return r0
                L_0x0063:
                    W2.J r7 = W2.J.f19942a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: g2.C2384f.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.f$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21738a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21739b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2384f fVar, C2308e eVar) {
                super(2, eVar);
                this.f21739b = fVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21739b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21738a == 0) {
                    u.b(obj);
                    this.f21739b.f21718b.g();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.f$c$c  reason: collision with other inner class name */
        static final class C0227c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21740a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21741b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Z f21742c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0227c(C2384f fVar, Z z4, C2308e eVar) {
                super(2, eVar);
                this.f21741b = fVar;
                this.f21742c = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0227c(this.f21741b, this.f21742c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f21740a;
                if (i5 == 0) {
                    u.b(obj);
                    C2384f fVar = this.f21741b;
                    Z z4 = this.f21742c;
                    ArrayList g5 = fVar.f21723g;
                    this.f21740a = 1;
                    if (fVar.y(z4, g5, this) == f5) {
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
                return ((C0227c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2384f fVar, C2308e eVar) {
            super(2, eVar);
            this.f21734c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21734c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0059, code lost:
            if (r1.l(r11) == r0) goto L_0x0071;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f21733b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0028
                if (r1 == r4) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                java.lang.Object r0 = r11.f21732a
                z2.Z r0 = (z2.Z) r0
                W2.u.b(r12)
                goto L_0x0073
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                java.lang.Object r1 = r11.f21732a
                z2.Z r1 = (z2.Z) r1
                W2.u.b(r12)
                r12 = r1
                goto L_0x005c
            L_0x0028:
                W2.u.b(r12)
                g2.f r12 = r11.f21734c
                r1 = 0
                r12.f21722f = r1
                z2.Z r12 = new z2.Z
                g2.f r1 = r11.f21734c
                android.content.Context r1 = r1.f21717a
                r12.<init>(r1)
                g2.f r1 = r11.f21734c
                w3.M r5 = r1.v()
                g2.f$c$a r8 = new g2.f$c$a
                g2.f r1 = r11.f21734c
                r8.<init>(r1, r12, r3)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                w3.y0 r1 = w3.C2876i.d(r5, r6, r7, r8, r9, r10)
                r11.f21732a = r12
                r11.f21733b = r4
                java.lang.Object r1 = r1.l(r11)
                if (r1 != r0) goto L_0x005c
                goto L_0x0071
            L_0x005c:
                w3.I0 r1 = w3.C2865c0.c()
                g2.f$c$b r5 = new g2.f$c$b
                g2.f r6 = r11.f21734c
                r5.<init>(r6, r3)
                r11.f21732a = r12
                r11.f21733b = r2
                java.lang.Object r1 = w3.C2872g.g(r1, r5, r11)
                if (r1 != r0) goto L_0x0072
            L_0x0071:
                return r0
            L_0x0072:
                r0 = r12
            L_0x0073:
                g2.f r12 = r11.f21734c
                int r12 = r12.f21722f
                if (r12 < r4) goto L_0x008f
                g2.f r12 = r11.f21734c
                w3.M r4 = r12.v()
                g2.f$c$c r7 = new g2.f$c$c
                g2.f r12 = r11.f21734c
                r7.<init>(r12, r0, r3)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                w3.C2908y0 unused = w3.C2876i.d(r4, r5, r6, r7, r8, r9)
            L_0x008f:
                W2.J r12 = W2.J.f19942a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2384f.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.f$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21743a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f21744b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2384f f21745c;

        /* renamed from: g2.f$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21746a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f21747b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2384f f21748c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(ArrayList arrayList, C2384f fVar, C2308e eVar) {
                super(2, eVar);
                this.f21747b = arrayList;
                this.f21748c = fVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21747b, this.f21748c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21746a == 0) {
                    u.b(obj);
                    if (!this.f21747b.isEmpty()) {
                        this.f21748c.f21718b.d(this.f21747b);
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
        d(Z z4, C2384f fVar, C2308e eVar) {
            super(2, eVar);
            this.f21744b = z4;
            this.f21745c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21744b, this.f21745c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21743a;
            if (i5 == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                l2.M A4 = this.f21744b.A(this.f21745c.f21719c.c());
                if (!A4.b() && A4.e() != null) {
                    JSONObject e5 = A4.e();
                    t.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i6 = 0; i6 < length; i6++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                            C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                            t.b(optJSONObject);
                            iVar.p(optJSONObject);
                            arrayList.add(iVar);
                        }
                    }
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(arrayList, this.f21745c, (C2308e) null);
                this.f21743a = 1;
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.f$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21749a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2384f f21750b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21751c;

        /* renamed from: g2.f$e$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21752a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21753b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2384f fVar, C2308e eVar) {
                super(2, eVar);
                this.f21753b = fVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21753b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21752a == 0) {
                    u.b(obj);
                    this.f21753b.f21718b.i(this.f21753b.f21723g);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2384f fVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21750b = fVar;
            this.f21751c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21750b, this.f21751c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21749a;
            if (i5 == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f21750b.f21717a);
                a5.a();
                String str = "leaf_categories_" + this.f21750b.f21719c.c();
                N F02 = a5.F0(str);
                if (F02 == null || !F02.a()) {
                    l2.M r5 = this.f21751c.r(this.f21750b.f21719c.c());
                    if (!r5.b() && r5.e() != null) {
                        C2384f fVar = this.f21750b;
                        C2660i.b bVar = C2660i.f25094i;
                        JSONObject e5 = r5.e();
                        t.b(e5);
                        fVar.f21723g = bVar.c(e5, this.f21750b.f21719c.c());
                        String d5 = r5.d();
                        t.b(d5);
                        N n5 = new N(str, d5);
                        a5.Q(str);
                        a5.b1(n5);
                    }
                } else {
                    this.f21750b.f21723g = C2660i.f25094i.a(F02.b(), this.f21750b.f21719c.c());
                }
                a5.m();
                if (!this.f21750b.f21723g.isEmpty()) {
                    this.f21750b.f21722f = this.f21750b.f21722f + 1;
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21750b, (C2308e) null);
                    this.f21749a = 1;
                    if (C2872g.g(c5, aVar, this) == f5) {
                        return f5;
                    }
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.f$f  reason: collision with other inner class name */
    static final class C0228f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21754a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2384f f21755b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21756c;

        /* renamed from: g2.f$f$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21757a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21758b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21759c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2384f fVar, S s5, C2308e eVar) {
                super(2, eVar);
                this.f21758b = fVar;
                this.f21759c = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21758b, this.f21759c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21757a == 0) {
                    u.b(obj);
                    this.f21758b.f21718b.h(this.f21759c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0228f(C2384f fVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21755b = fVar;
            this.f21756c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0228f(this.f21755b, this.f21756c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            String d5;
            Object f5 = C2316b.f();
            int i5 = this.f21754a;
            if (i5 == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f21755b.f21717a);
                a5.a();
                String str = "recent_by_category_" + this.f21755b.f21719c.c();
                N F02 = a5.F0(str);
                if (F02 == null || !F02.a()) {
                    l2.M a02 = this.f21756c.a0(this.f21755b.f21719c.c(), 20, 0);
                    if (a02.b() || (d5 = a02.d()) == null || d5.length() == 0) {
                        arrayList = null;
                    } else {
                        ArrayList V02 = this.f21756c.V0(a02);
                        String d6 = a02.d();
                        t.b(d6);
                        N n5 = new N(str, d6);
                        a5.Q(str);
                        a5.b1(n5);
                        arrayList = V02;
                    }
                } else {
                    arrayList = this.f21756c.V0(F02.c());
                }
                a5.m();
                if (arrayList != null && !arrayList.isEmpty()) {
                    String string = this.f21755b.f21717a.getString(R.string.the_latest_title);
                    t.d(string, "getString(...)");
                    C2660i iVar = new C2660i(-2, string, (String) null, 4, (C2633k) null);
                    iVar.y(this.f21755b.f21719c.c());
                    S s5 = new S(iVar, arrayList, 0, 4, (C2633k) null);
                    s5.f(1);
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21755b, s5, (C2308e) null);
                    this.f21754a = 1;
                    if (C2872g.g(c5, aVar, this) == f5) {
                        return f5;
                    }
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C0228f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.f$g */
    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21760a;

        /* renamed from: b  reason: collision with root package name */
        Object f21761b;

        /* renamed from: c  reason: collision with root package name */
        int f21762c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2384f f21763d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Z f21764e;

        /* renamed from: g2.f$g$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21765a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21766b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21767c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2384f fVar, S s5, C2308e eVar) {
                super(2, eVar);
                this.f21766b = fVar;
                this.f21767c = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21766b, this.f21767c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21765a == 0) {
                    u.b(obj);
                    this.f21766b.f21718b.a(this.f21767c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.f$g$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21768a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21769b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21770c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2384f fVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21769b = fVar;
                this.f21770c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21769b, this.f21770c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21768a == 0) {
                    u.b(obj);
                    this.f21769b.f21718b.e((C2657f) this.f21770c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C2384f fVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21763d = fVar;
            this.f21764e = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f21763d, this.f21764e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2940B b5;
            C2940B b6;
            ArrayList arrayList;
            Object f5 = C2316b.f();
            int i5 = this.f21762c;
            if (i5 == 0) {
                u.b(obj);
                ArrayList arrayList2 = new ArrayList();
                b5 = C2940B.f26458v.a(this.f21763d.f21717a);
                b5.a();
                String str = "top_downloads_" + this.f21763d.f21719c.c();
                N F02 = b5.F0(str);
                if (F02 == null || !F02.a()) {
                    l2.M l02 = this.f21764e.l0(this.f21763d.f21719c.c(), 20, 0);
                    if (!l02.b() && l02.e() != null) {
                        arrayList2 = this.f21764e.V0(l02);
                        String d5 = l02.d();
                        t.b(d5);
                        N n5 = new N(str, d5);
                        b5.Q(str);
                        b5.b1(n5);
                    }
                } else {
                    arrayList2 = this.f21764e.V0(F02.c());
                }
                ArrayList arrayList3 = arrayList2;
                if (!arrayList3.isEmpty()) {
                    String string = this.f21763d.f21717a.getString(R.string.top_downloads_title);
                    t.d(string, "getString(...)");
                    S s5 = new S(this.f21763d.f21719c, arrayList3, 0, 4, (C2633k) null);
                    s5.b().x(string);
                    if (this.f21763d.f21719c.c() != 523 || UptodownApp.f13477F.P()) {
                        s5.f(5);
                    } else {
                        s5.f(4);
                    }
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21763d, s5, (C2308e) null);
                    this.f21760a = arrayList3;
                    this.f21761b = b5;
                    this.f21762c = 1;
                    if (C2872g.g(c5, aVar, this) != f5) {
                        arrayList = arrayList3;
                    }
                    return f5;
                }
                b5.m();
                return J.f19942a;
            } else if (i5 == 1) {
                b5 = (C2940B) this.f21761b;
                arrayList = (ArrayList) this.f21760a;
                u.b(obj);
            } else if (i5 == 2) {
                b6 = (C2940B) this.f21760a;
                u.b(obj);
                b5 = b6;
                b5.m();
                return J.f19942a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (this.f21763d.f21721e > -1) {
                L l5 = new L();
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2657f fVar = (C2657f) next;
                    if (!s.E(fVar.S(), this.f21763d.f21717a.getPackageName(), true)) {
                        l5.f24690a = fVar;
                        break;
                    }
                }
                if (l5.f24690a != null) {
                    I0 c6 = C2865c0.c();
                    b bVar = new b(this.f21763d, l5, (C2308e) null);
                    this.f21760a = b5;
                    this.f21761b = null;
                    this.f21762c = 2;
                    if (C2872g.g(c6, bVar, this) != f5) {
                        b6 = b5;
                        b5 = b6;
                    }
                    return f5;
                }
            }
            b5.m();
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.f$h */
    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21771a;

        /* renamed from: b  reason: collision with root package name */
        Object f21772b;

        /* renamed from: c  reason: collision with root package name */
        Object f21773c;

        /* renamed from: d  reason: collision with root package name */
        int f21774d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C2384f f21775e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f21776f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Z f21777g;

        /* renamed from: g2.f$h$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21778a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21779b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21780c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2384f fVar, S s5, C2308e eVar) {
                super(2, eVar);
                this.f21779b = fVar;
                this.f21780c = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21779b, this.f21780c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21778a == 0) {
                    u.b(obj);
                    if (this.f21779b.f21719c.c() != 523) {
                        this.f21779b.f21718b.f(this.f21780c);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.f$h$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21781a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2384f f21782b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21783c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Z f21784d;

            /* renamed from: g2.f$h$b$a */
            static final class a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f21785a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C2384f f21786b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Z f21787c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(C2384f fVar, Z z4, C2308e eVar) {
                    super(2, eVar);
                    this.f21786b = fVar;
                    this.f21787c = z4;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new a(this.f21786b, this.f21787c, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object f5 = C2316b.f();
                    int i5 = this.f21785a;
                    if (i5 == 0) {
                        u.b(obj);
                        C2384f fVar = this.f21786b;
                        Z z4 = this.f21787c;
                        this.f21785a = 1;
                        if (fVar.s(z4, this) == f5) {
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

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2384f fVar, ArrayList arrayList, Z z4, C2308e eVar) {
                super(2, eVar);
                this.f21782b = fVar;
                this.f21783c = arrayList;
                this.f21784d = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21782b, this.f21783c, this.f21784d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21781a == 0) {
                    u.b(obj);
                    if (this.f21782b.f21719c.c() == 523) {
                        this.f21782b.f21718b.b(this.f21783c);
                    }
                    return C2876i.d(this.f21782b.v(), (C2312i) null, (O) null, new a(this.f21782b, this.f21784d, (C2308e) null), 3, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C2384f fVar, ArrayList arrayList, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21775e = fVar;
            this.f21776f = arrayList;
            this.f21777g = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f21775e, this.f21776f, this.f21777g, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            C2940B b5;
            Iterator it;
            Object f5 = C2316b.f();
            int i5 = this.f21774d;
            if (i5 == 0) {
                u.b(obj);
                ArrayList arrayList2 = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f21775e.f21717a);
                a5.a();
                Iterator it2 = this.f21776f.iterator();
                t.d(it2, "iterator(...)");
                Iterator it3 = it2;
                b5 = a5;
                it = it3;
                arrayList = arrayList2;
            } else if (i5 == 1) {
                it = (Iterator) this.f21773c;
                b5 = (C2940B) this.f21772b;
                arrayList = (ArrayList) this.f21771a;
                u.b(obj);
            } else if (i5 == 2) {
                u.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    S m5 = this.f21775e.x((C2660i) next, this.f21777g, b5);
                    arrayList.add(m5);
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21775e, m5, (C2308e) null);
                    this.f21771a = arrayList;
                    this.f21772b = b5;
                    this.f21773c = it;
                    this.f21774d = 1;
                    if (C2872g.g(c5, aVar, this) == f5) {
                        break;
                    }
                } else {
                    b5.m();
                    I0 c6 = C2865c0.c();
                    b bVar = new b(this.f21775e, arrayList, this.f21777g, (C2308e) null);
                    this.f21771a = null;
                    this.f21772b = null;
                    this.f21773c = null;
                    this.f21774d = 2;
                    Object g5 = C2872g.g(c6, bVar, this);
                    if (g5 == f5) {
                        return f5;
                    }
                    return g5;
                }
            }
            return f5;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2384f(Context context, r rVar, C2660i iVar, M m5) {
        t.e(context, "context");
        t.e(rVar, "listener");
        t.e(iVar, "category");
        t.e(m5, "scope");
        this.f21717a = context;
        this.f21718b = rVar;
        this.f21719c = iVar;
        this.f21720d = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object q(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object r(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object s(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(z4, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object t(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new e(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object u(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new C0228f(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object w(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new g(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final S x(C2660i iVar, Z z4, C2940B b5) {
        String str = "category_top_" + iVar.c();
        int d5 = iVar.d();
        int g5 = iVar.g();
        ArrayList arrayList = new ArrayList();
        N F02 = b5.F0(str);
        if (F02 == null || !F02.a()) {
            l2.M m02 = z4.m0(iVar.c(), d5, 0);
            if (!m02.b() && m02.e() != null) {
                arrayList = z4.V0(m02);
                String d6 = m02.d();
                t.b(d6);
                N n5 = new N(str, d6);
                b5.Q(str);
                b5.b1(n5);
            }
        } else {
            arrayList = z4.V0(F02.c());
        }
        S s5 = new S(iVar, arrayList, 0, 4, (C2633k) null);
        s5.f(g5);
        return s5;
    }

    /* access modifiers changed from: private */
    public final Object y(Z z4, ArrayList arrayList, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new h(this, arrayList, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final M v() {
        return this.f21720d;
    }
}
