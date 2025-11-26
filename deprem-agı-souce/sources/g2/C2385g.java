package g2;

import W2.J;
import W2.u;
import X2.C2250q;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k2.C2608s;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.N;
import l2.S;
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

/* renamed from: g2.g  reason: case insensitive filesystem */
public final class C2385g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21788a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2608s f21789b;

    /* renamed from: c  reason: collision with root package name */
    private final M f21790c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f21791d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f21792e;

    /* renamed from: g2.g$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21793a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21794b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2385g gVar, C2308e eVar) {
            super(2, eVar);
            this.f21794b = gVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21794b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21793a;
            if (i5 == 0) {
                u.b(obj);
                C2385g gVar = this.f21794b;
                this.f21793a = 1;
                if (gVar.s(this) == f5) {
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

    /* renamed from: g2.g$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21795a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21796b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21797c;

        /* renamed from: g2.g$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21798a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21799b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21800c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Z f21801d;

            /* renamed from: g2.g$b$a$a  reason: collision with other inner class name */
            static final class C0229a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f21802a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C2385g f21803b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Z f21804c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ L f21805d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0229a(C2385g gVar, Z z4, L l5, C2308e eVar) {
                    super(2, eVar);
                    this.f21803b = gVar;
                    this.f21804c = z4;
                    this.f21805d = l5;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0229a(this.f21803b, this.f21804c, this.f21805d, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object f5 = C2316b.f();
                    int i5 = this.f21802a;
                    if (i5 == 0) {
                        u.b(obj);
                        this.f21802a = 1;
                        if (this.f21803b.C(this.f21804c, (ArrayList) this.f21805d.f24690a, this) == f5) {
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
                    return ((C0229a) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, L l5, Z z4, C2308e eVar) {
                super(2, eVar);
                this.f21799b = gVar;
                this.f21800c = l5;
                this.f21801d = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21799b, this.f21800c, this.f21801d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21798a == 0) {
                    u.b(obj);
                    this.f21799b.f21789b.k((ArrayList) this.f21800c.f24690a);
                    return C2876i.d(this.f21799b.y(), (C2312i) null, (O) null, new C0229a(this.f21799b, this.f21801d, this.f21800c, (C2308e) null), 3, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21796b = gVar;
            this.f21797c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21796b, this.f21797c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21795a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                l5.f24690a = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f21796b.f21788a);
                a5.a();
                N F02 = a5.F0("categories");
                if (F02 == null || !F02.a()) {
                    l2.M q5 = this.f21797c.q();
                    if (!q5.b() && q5.d() != null) {
                        C2660i.b bVar = C2660i.f25094i;
                        JSONObject e5 = q5.e();
                        t.b(e5);
                        l5.f24690a = bVar.b(e5);
                        String d5 = q5.d();
                        t.b(d5);
                        N n5 = new N("categories", d5);
                        a5.Q("categories");
                        a5.b1(n5);
                    }
                } else {
                    l5.f24690a = C2660i.f25094i.b(new JSONObject(F02.b()));
                }
                a5.m();
                if (!((Collection) l5.f24690a).isEmpty()) {
                    this.f21796b.f21792e = this.f21796b.f21792e + 1;
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21796b, l5, this.f21797c, (C2308e) null);
                    this.f21795a = 1;
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21806a;

        /* renamed from: b  reason: collision with root package name */
        int f21807b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2385g f21808c;

        /* renamed from: g2.g$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21809a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21810b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Z f21811c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, Z z4, C2308e eVar) {
                super(2, eVar);
                this.f21810b = gVar;
                this.f21811c = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21810b, this.f21811c, eVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
                if (g2.C2385g.e(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
                if (g2.C2385g.a(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
                if (g2.C2385g.d(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
                if (g2.C2385g.k(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
                return r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = c3.C2316b.f()
                    int r1 = r6.f21809a
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
                    g2.g r7 = r6.f21810b
                    z2.Z r1 = r6.f21811c
                    r6.f21809a = r5
                    java.lang.Object r7 = r7.u(r1, r6)
                    if (r7 != r0) goto L_0x003c
                    goto L_0x0062
                L_0x003c:
                    g2.g r7 = r6.f21810b
                    z2.Z r1 = r6.f21811c
                    r6.f21809a = r4
                    java.lang.Object r7 = r7.r(r1, r6)
                    if (r7 != r0) goto L_0x0049
                    goto L_0x0062
                L_0x0049:
                    g2.g r7 = r6.f21810b
                    z2.Z r1 = r6.f21811c
                    r6.f21809a = r3
                    java.lang.Object r7 = r7.t(r1, r6)
                    if (r7 != r0) goto L_0x0056
                    goto L_0x0062
                L_0x0056:
                    g2.g r7 = r6.f21810b
                    z2.Z r1 = r6.f21811c
                    r6.f21809a = r2
                    java.lang.Object r7 = r7.x(r1, r6)
                    if (r7 != r0) goto L_0x0063
                L_0x0062:
                    return r0
                L_0x0063:
                    W2.J r7 = W2.J.f19942a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: g2.C2385g.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.g$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21812a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21813b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2385g gVar, C2308e eVar) {
                super(2, eVar);
                this.f21813b = gVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21813b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21812a == 0) {
                    u.b(obj);
                    this.f21813b.f21789b.h();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2385g gVar, C2308e eVar) {
            super(2, eVar);
            this.f21808c = gVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21808c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008f, code lost:
            if (w3.C2872g.g(r15, r5, r14) == r0) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a4, code lost:
            if (g2.C2385g.g(r15, r1, r14) == r0) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b1, code lost:
            if (g2.C2385g.n(r15, r1, r14) == r0) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00be, code lost:
            if (g2.C2385g.i(r15, r1, r14) == r0) goto L_0x00c0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r14.f21807b
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 1
                r6 = 0
                r7 = 2
                if (r1 == 0) goto L_0x0047
                if (r1 == r5) goto L_0x003f
                if (r1 == r7) goto L_0x0037
                if (r1 == r4) goto L_0x002e
                if (r1 == r3) goto L_0x0025
                if (r1 != r2) goto L_0x001d
                W2.u.b(r15)
                goto L_0x00c1
            L_0x001d:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0025:
                java.lang.Object r1 = r14.f21806a
                z2.Z r1 = (z2.Z) r1
                W2.u.b(r15)
                goto L_0x00b4
            L_0x002e:
                java.lang.Object r1 = r14.f21806a
                z2.Z r1 = (z2.Z) r1
                W2.u.b(r15)
                goto L_0x00a7
            L_0x0037:
                java.lang.Object r1 = r14.f21806a
                z2.Z r1 = (z2.Z) r1
                W2.u.b(r15)
                goto L_0x0092
            L_0x003f:
                java.lang.Object r1 = r14.f21806a
                z2.Z r1 = (z2.Z) r1
                W2.u.b(r15)
                goto L_0x007c
            L_0x0047:
                W2.u.b(r15)
                g2.g r15 = r14.f21808c
                r1 = 0
                r15.f21792e = r1
                z2.Z r15 = new z2.Z
                g2.g r1 = r14.f21808c
                android.content.Context r1 = r1.f21788a
                r15.<init>(r1)
                g2.g r1 = r14.f21808c
                w3.M r8 = r1.y()
                g2.g$c$a r11 = new g2.g$c$a
                g2.g r1 = r14.f21808c
                r11.<init>(r1, r15, r6)
                r12 = 3
                r13 = 0
                r9 = 0
                r10 = 0
                w3.y0 r1 = w3.C2876i.d(r8, r9, r10, r11, r12, r13)
                r14.f21806a = r15
                r14.f21807b = r5
                java.lang.Object r1 = r1.l(r14)
                if (r1 != r0) goto L_0x007b
                goto L_0x00c0
            L_0x007b:
                r1 = r15
            L_0x007c:
                w3.I0 r15 = w3.C2865c0.c()
                g2.g$c$b r5 = new g2.g$c$b
                g2.g r8 = r14.f21808c
                r5.<init>(r8, r6)
                r14.f21806a = r1
                r14.f21807b = r7
                java.lang.Object r15 = w3.C2872g.g(r15, r5, r14)
                if (r15 != r0) goto L_0x0092
                goto L_0x00c0
            L_0x0092:
                g2.g r15 = r14.f21808c
                int r15 = r15.f21792e
                if (r15 < r7) goto L_0x00c1
                g2.g r15 = r14.f21808c
                r14.f21806a = r1
                r14.f21807b = r4
                java.lang.Object r15 = r15.v(r1, r14)
                if (r15 != r0) goto L_0x00a7
                goto L_0x00c0
            L_0x00a7:
                g2.g r15 = r14.f21808c
                r14.f21806a = r1
                r14.f21807b = r3
                java.lang.Object r15 = r15.B(r1, r14)
                if (r15 != r0) goto L_0x00b4
                goto L_0x00c0
            L_0x00b4:
                g2.g r15 = r14.f21808c
                r14.f21806a = r6
                r14.f21807b = r2
                java.lang.Object r15 = r15.w(r1, r14)
                if (r15 != r0) goto L_0x00c1
            L_0x00c0:
                return r0
            L_0x00c1:
                W2.J r15 = W2.J.f19942a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2385g.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21814a;

        /* renamed from: b  reason: collision with root package name */
        int f21815b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2385g f21816c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Z f21817d;

        /* renamed from: g2.g$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21818a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21819b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21820c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Z f21821d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ L f21822e;

            /* renamed from: g2.g$d$a$a  reason: collision with other inner class name */
            static final class C0230a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f21823a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C2385g f21824b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Z f21825c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ L f21826d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0230a(C2385g gVar, Z z4, L l5, C2308e eVar) {
                    super(2, eVar);
                    this.f21824b = gVar;
                    this.f21825c = z4;
                    this.f21826d = l5;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0230a(this.f21824b, this.f21825c, this.f21826d, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object f5 = C2316b.f();
                    int i5 = this.f21823a;
                    if (i5 == 0) {
                        u.b(obj);
                        this.f21823a = 1;
                        if (this.f21824b.A(this.f21825c, (ArrayList) this.f21826d.f24690a, this) == f5) {
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
                    return ((C0230a) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, S s5, Z z4, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21819b = gVar;
                this.f21820c = s5;
                this.f21821d = z4;
                this.f21822e = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21819b, this.f21820c, this.f21821d, this.f21822e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21818a == 0) {
                    u.b(obj);
                    this.f21819b.f21789b.j(this.f21820c);
                    return C2876i.d(this.f21819b.y(), (C2312i) null, (O) null, new C0230a(this.f21819b, this.f21821d, this.f21822e, (C2308e) null), 3, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21816c = gVar;
            this.f21817d = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21816c, this.f21817d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2940B b5;
            C2940B b6;
            Object f5 = C2316b.f();
            int i5 = this.f21815b;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                l5.f24690a = new ArrayList();
                b5 = C2940B.f26458v.a(this.f21816c.f21788a);
                b5.a();
                N F02 = b5.F0("home_categories");
                if (F02 == null || !F02.a()) {
                    l2.M D4 = this.f21817d.D();
                    if (!D4.b() && D4.e() != null) {
                        C2660i.b bVar = C2660i.f25094i;
                        JSONObject e5 = D4.e();
                        t.b(e5);
                        l5.f24690a = bVar.e(e5);
                        String d5 = D4.d();
                        t.b(d5);
                        N n5 = new N("home_categories", d5);
                        b5.Q("home_categories");
                        b5.b1(n5);
                    }
                } else {
                    l5.f24690a = C2660i.f25094i.d(F02.b());
                }
                if (!((Collection) l5.f24690a).isEmpty()) {
                    S l6 = this.f21816c.z((C2660i) C2250q.M((List) l5.f24690a), this.f21817d, b5);
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21816c, l6, this.f21817d, l5, (C2308e) null);
                    this.f21814a = b5;
                    this.f21815b = 1;
                    if (C2872g.g(c5, aVar, this) == f5) {
                        return f5;
                    }
                    b6 = b5;
                }
                b5.m();
                return J.f19942a;
            } else if (i5 == 1) {
                b6 = (C2940B) this.f21814a;
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b5 = b6;
            b5.m();
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21827a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21828b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21829c;

        /* renamed from: g2.g$e$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21830a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21831b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21832c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21831b = gVar;
                this.f21832c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21831b, this.f21832c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21830a == 0) {
                    u.b(obj);
                    this.f21831b.f21789b.e((ArrayList) this.f21832c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21828b = gVar;
            this.f21829c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21828b, this.f21829c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21827a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                l5.f24690a = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f21828b.f21788a);
                a5.a();
                N F02 = a5.F0("home_features");
                if (F02 == null || !F02.a()) {
                    l2.M E4 = this.f21829c.E();
                    if (!E4.b()) {
                        l5.f24690a = this.f21829c.V0(E4);
                        String d5 = E4.d();
                        t.b(d5);
                        N n5 = new N("home_features", d5);
                        a5.Q("home_features");
                        a5.b1(n5);
                    }
                } else {
                    l5.f24690a = this.f21829c.V0(F02.c());
                }
                a5.m();
                if (!((Collection) l5.f24690a).isEmpty()) {
                    this.f21828b.f21792e = this.f21828b.f21792e + 1;
                    this.f21828b.f21791d = -1;
                    int i6 = 0;
                    for (C2657f S4 : (Iterable) l5.f24690a) {
                        int i7 = i6 + 1;
                        if (s.E(S4.S(), this.f21828b.f21788a.getPackageName(), true)) {
                            this.f21828b.f21791d = i6;
                        }
                        i6 = i7;
                    }
                    if (this.f21828b.f21791d > -1 && this.f21828b.f21791d < ((ArrayList) l5.f24690a).size()) {
                        ((ArrayList) l5.f24690a).remove(this.f21828b.f21791d);
                    }
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21828b, l5, (C2308e) null);
                this.f21827a = 1;
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21833a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21834b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21835c;

        /* renamed from: g2.g$f$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21836a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21837b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21838c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, S s5, C2308e eVar) {
                super(2, eVar);
                this.f21837b = gVar;
                this.f21838c = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21837b, this.f21838c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21836a == 0) {
                    u.b(obj);
                    this.f21837b.f21789b.d(this.f21838c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21834b = gVar;
            this.f21835c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f21834b, this.f21835c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21833a;
            if (i5 == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f21834b.f21788a);
                a5.a();
                N F02 = a5.F0("last_updates");
                if (F02 == null || !F02.a()) {
                    l2.M K4 = this.f21835c.K(20, 0);
                    if (!K4.b() && K4.e() != null) {
                        arrayList = this.f21835c.V0(K4);
                        String d5 = K4.d();
                        t.b(d5);
                        N n5 = new N("last_updates", d5);
                        a5.Q("last_updates");
                        a5.b1(n5);
                    }
                } else {
                    arrayList = this.f21835c.V0(F02.c());
                }
                ArrayList arrayList2 = arrayList;
                a5.m();
                String string = this.f21834b.f21788a.getString(R.string.latest_updates);
                t.d(string, "getString(...)");
                S s5 = new S(new C2660i(-3, string, (String) null, 4, (C2633k) null), arrayList2, 0, 4, (C2633k) null);
                s5.f(1);
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21834b, s5, (C2308e) null);
                this.f21833a = 1;
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
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$g  reason: collision with other inner class name */
    static final class C0231g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21840b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21841c;

        /* renamed from: g2.g$g$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21842a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ L f21843b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2385g f21844c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(L l5, C2385g gVar, C2308e eVar) {
                super(2, eVar);
                this.f21843b = l5;
                this.f21844c = gVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21843b, this.f21844c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21842a == 0) {
                    u.b(obj);
                    if (this.f21843b.f24690a != null) {
                        this.f21844c.f21789b.i((C2657f) this.f21843b.f24690a);
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
        C0231g(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21840b = gVar;
            this.f21841c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0231g(this.f21840b, this.f21841c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21839a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                C2940B a5 = C2940B.f26458v.a(this.f21840b.f21788a);
                a5.a();
                N F02 = a5.F0("main_app");
                if (F02 == null || !F02.a()) {
                    l2.M Q02 = this.f21841c.Q0();
                    if (!Q02.b() && Q02.e() != null) {
                        JSONObject e5 = Q02.e();
                        t.b(e5);
                        JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONObject != null) {
                            C2657f fVar = new C2657f();
                            l5.f24690a = fVar;
                            C2657f.b(fVar, optJSONObject, (Context) null, 2, (Object) null);
                        }
                        String d5 = Q02.d();
                        t.b(d5);
                        N n5 = new N("main_app", d5);
                        a5.Q("main_app");
                        a5.b1(n5);
                    }
                } else {
                    JSONObject optJSONObject2 = new JSONObject(F02.b()).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject2 != null) {
                        C2657f fVar2 = new C2657f();
                        l5.f24690a = fVar2;
                        C2657f.b(fVar2, optJSONObject2, (Context) null, 2, (Object) null);
                    }
                }
                a5.m();
                I0 c5 = C2865c0.c();
                a aVar = new a(l5, this.f21840b, (C2308e) null);
                this.f21839a = 1;
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
            return ((C0231g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$h */
    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21845a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21846b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21847c;

        /* renamed from: g2.g$h$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21848a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21849b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21850c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, S s5, C2308e eVar) {
                super(2, eVar);
                this.f21849b = gVar;
                this.f21850c = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21849b, this.f21850c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21848a == 0) {
                    u.b(obj);
                    this.f21849b.f21789b.g(this.f21850c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21846b = gVar;
            this.f21847c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f21846b, this.f21847c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            Object f5 = C2316b.f();
            int i5 = this.f21845a;
            if (i5 == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f21846b.f21788a);
                a5.a();
                N F02 = a5.F0("new_releases");
                if (F02 == null || !F02.a()) {
                    l2.M O4 = this.f21847c.O(20, 0);
                    if (O4.b() || O4.e() == null) {
                        arrayList = null;
                    } else {
                        ArrayList V02 = this.f21847c.V0(O4);
                        String d5 = O4.d();
                        t.b(d5);
                        N n5 = new N("new_releases", d5);
                        a5.Q("new_releases");
                        a5.b1(n5);
                        arrayList = V02;
                    }
                } else {
                    arrayList = this.f21847c.V0(F02.c());
                }
                a5.m();
                if (arrayList != null && !arrayList.isEmpty()) {
                    String string = this.f21846b.f21788a.getString(R.string.new_releases);
                    t.d(string, "getString(...)");
                    S s5 = new S(new C2660i(-2, string, (String) null, 4, (C2633k) null), arrayList, 0, 4, (C2633k) null);
                    s5.f(1);
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21846b, s5, (C2308e) null);
                    this.f21845a = 1;
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
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$i */
    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f21852b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2385g f21853c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Z f21854d;

        /* renamed from: g2.g$i$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21855a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21856b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21857c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f21856b = gVar;
                this.f21857c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21856b, this.f21857c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21855a == 0) {
                    u.b(obj);
                    this.f21856b.f21789b.f(this.f21857c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ArrayList arrayList, C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21852b = arrayList;
            this.f21853c = gVar;
            this.f21854d = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f21852b, this.f21853c, this.f21854d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21851a;
            if (i5 == 0) {
                u.b(obj);
                if (!this.f21852b.isEmpty()) {
                    C2940B a5 = C2940B.f26458v.a(this.f21853c.f21788a);
                    a5.a();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.f21852b.iterator();
                    t.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        t.d(next, "next(...)");
                        arrayList.add(this.f21853c.z((C2660i) next, this.f21854d, a5));
                    }
                    a5.m();
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21853c, arrayList, (C2308e) null);
                    this.f21851a = 1;
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
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$j */
    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21858a;

        /* renamed from: b  reason: collision with root package name */
        Object f21859b;

        /* renamed from: c  reason: collision with root package name */
        int f21860c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2385g f21861d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Z f21862e;

        /* renamed from: g2.g$j$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21863a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21864b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f21865c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, S s5, C2308e eVar) {
                super(2, eVar);
                this.f21864b = gVar;
                this.f21865c = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21864b, this.f21865c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21863a == 0) {
                    u.b(obj);
                    this.f21864b.f21789b.a(this.f21865c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.g$j$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21866a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21867b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21868c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2385g gVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21867b = gVar;
                this.f21868c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21867b, this.f21868c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21866a == 0) {
                    u.b(obj);
                    this.f21867b.f21789b.c((C2657f) this.f21868c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(C2385g gVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21861d = gVar;
            this.f21862e = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f21861d, this.f21862e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2940B b5;
            C2940B b6;
            ArrayList arrayList;
            C2940B b7;
            Object f5 = C2316b.f();
            int i5 = this.f21860c;
            if (i5 == 0) {
                u.b(obj);
                ArrayList arrayList2 = new ArrayList();
                b5 = C2940B.f26458v.a(this.f21861d.f21788a);
                b5.a();
                N F02 = b5.F0("top_downloads");
                if (F02 == null || !F02.a()) {
                    l2.M k02 = this.f21862e.k0(20, 0);
                    if (!k02.b() && k02.e() != null) {
                        arrayList2 = this.f21862e.V0(k02);
                        String d5 = k02.d();
                        t.b(d5);
                        N n5 = new N("top_downloads", d5);
                        b5.Q("top_downloads");
                        b5.b1(n5);
                    }
                } else {
                    arrayList2 = this.f21862e.V0(F02.c());
                }
                ArrayList arrayList3 = arrayList2;
                if (!arrayList3.isEmpty()) {
                    String string = this.f21861d.f21788a.getString(R.string.top_downloads_title);
                    t.d(string, "getString(...)");
                    S s5 = new S(new C2660i(-1, string, (String) null, 4, (C2633k) null), arrayList3, 0, 4, (C2633k) null);
                    s5.f(8);
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21861d, s5, (C2308e) null);
                    this.f21858a = arrayList3;
                    this.f21859b = b5;
                    this.f21860c = 1;
                    if (C2872g.g(c5, aVar, this) != f5) {
                        b7 = b5;
                        arrayList = arrayList3;
                    }
                    return f5;
                }
                b5.m();
                return J.f19942a;
            } else if (i5 == 1) {
                b7 = (C2940B) this.f21859b;
                arrayList = (ArrayList) this.f21858a;
                u.b(obj);
            } else if (i5 == 2) {
                b6 = (C2940B) this.f21858a;
                u.b(obj);
                b5 = b6;
                b5.m();
                return J.f19942a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (this.f21861d.f21791d > -1) {
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
                    if (!s.E(fVar.S(), this.f21861d.f21788a.getPackageName(), true)) {
                        l5.f24690a = fVar;
                        break;
                    }
                }
                if (l5.f24690a != null) {
                    I0 c6 = C2865c0.c();
                    b bVar = new b(this.f21861d, l5, (C2308e) null);
                    this.f21858a = b7;
                    this.f21859b = null;
                    this.f21860c = 2;
                    if (C2872g.g(c6, bVar, this) != f5) {
                        b6 = b7;
                        b5 = b6;
                        b5.m();
                        return J.f19942a;
                    }
                    return f5;
                }
            }
            b5 = b7;
            b5.m();
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.g$k */
    static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21869a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2385g f21870b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f21871c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Z f21872d;

        /* renamed from: g2.g$k$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21873a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2385g f21874b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21875c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2385g gVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f21874b = gVar;
                this.f21875c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21874b, this.f21875c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21873a == 0) {
                    u.b(obj);
                    this.f21874b.f21789b.b(this.f21875c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(C2385g gVar, ArrayList arrayList, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21870b = gVar;
            this.f21871c = arrayList;
            this.f21872d = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f21870b, this.f21871c, this.f21872d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList a5;
            Object f5 = C2316b.f();
            int i5 = this.f21869a;
            if (i5 == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                C2940B a6 = C2940B.f26458v.a(this.f21870b.f21788a);
                a6.a();
                Iterator it = this.f21871c.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2660i iVar = (C2660i) next;
                    if (iVar.c() == 523) {
                        arrayList.add(this.f21870b.z(iVar, this.f21872d, a6));
                    } else if (iVar.c() == 831 && (a5 = iVar.a()) != null && !a5.isEmpty()) {
                        Iterator it2 = iVar.a().iterator();
                        t.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            t.d(next2, "next(...)");
                            arrayList.add(this.f21870b.z((C2660i) next2, this.f21872d, a6));
                        }
                    }
                }
                a6.m();
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21870b, arrayList, (C2308e) null);
                this.f21869a = 1;
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
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2385g(Context context, C2608s sVar, M m5) {
        t.e(context, "context");
        t.e(sVar, "listener");
        t.e(m5, "scope");
        this.f21788a = context;
        this.f21789b = sVar;
        this.f21790c = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object A(Z z4, ArrayList arrayList, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new i(arrayList, this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object B(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new j(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object C(Z z4, ArrayList arrayList, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new k(this, arrayList, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object r(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object s(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object t(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object u(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new e(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object v(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new f(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object w(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new C0231g(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object x(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new h(this, z4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final S z(C2660i iVar, Z z4, C2940B b5) {
        String str;
        l2.M m5;
        int i5 = 5;
        int i6 = 20;
        if (iVar.i()) {
            str = "floating_category_top_" + iVar.c();
        } else if (iVar.l()) {
            str = "leaf_category_top_" + iVar.c();
        } else {
            str = "category_top_" + iVar.c();
            int c5 = iVar.c();
            if (c5 != 521) {
                if (c5 == 523) {
                    if (!UptodownApp.f13477F.P()) {
                        i5 = 4;
                    }
                    i6 = 8;
                } else if (c5 != 524) {
                    i6 = 12;
                    i5 = 6;
                }
            }
            i5 = 1;
        }
        ArrayList arrayList = new ArrayList();
        N F02 = b5.F0(str);
        if (F02 == null || !F02.a()) {
            if (iVar.i()) {
                m5 = z4.n0(iVar.c(), i6, 0);
            } else {
                m5 = z4.l0(iVar.c(), i6, 0);
            }
            if (!m5.b() && m5.e() != null) {
                arrayList = z4.V0(m5);
                String d5 = m5.d();
                t.b(d5);
                N n5 = new N(str, d5);
                b5.Q(str);
                b5.b1(n5);
            }
        } else {
            arrayList = z4.V0(F02.c());
        }
        S s5 = new S(iVar, arrayList, 0, 4, (C2633k) null);
        s5.f(i5);
        return s5;
    }

    public final M y() {
        return this.f21790c;
    }
}
