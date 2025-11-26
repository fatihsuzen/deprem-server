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
import k2.C2609t;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2660i;
import l2.S;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.Z;

/* renamed from: g2.h  reason: case insensitive filesystem */
public final class C2386h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21876a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2609t f21877b;

    /* renamed from: c  reason: collision with root package name */
    private final M f21878c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f21879d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public C2660i f21880e = new C2660i(523, "Games", (String) null, 4, (C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f21881f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f21882g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f21883h = new ArrayList();

    /* renamed from: g2.h$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21884a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2386h f21885b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2386h hVar, C2308e eVar) {
            super(2, eVar);
            this.f21885b = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21885b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21884a;
            if (i5 == 0) {
                u.b(obj);
                C2386h hVar = this.f21885b;
                this.f21884a = 1;
                if (hVar.r(this) == f5) {
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

    /* renamed from: g2.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21886a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f21887b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2386h f21888c;

        /* renamed from: g2.h$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21889a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2386h f21890b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2386h hVar, C2308e eVar) {
                super(2, eVar);
                this.f21890b = hVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21890b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21889a == 0) {
                    u.b(obj);
                    C2609t g5 = this.f21890b.f21877b;
                    if (g5 == null) {
                        return null;
                    }
                    g5.b(this.f21890b.f21882g);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Z z4, C2386h hVar, C2308e eVar) {
            super(2, eVar);
            this.f21887b = z4;
            this.f21888c = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21887b, this.f21888c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21886a;
            if (i5 == 0) {
                u.b(obj);
                l2.M r5 = this.f21887b.r(this.f21888c.f21880e.c());
                this.f21888c.f21882g = new ArrayList();
                if (!r5.b() && r5.e() != null) {
                    JSONObject e5 = r5.e();
                    t.b(e5);
                    if (e5.optInt("success") == 1) {
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i6 = 0; i6 < length; i6++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                                C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                                t.b(optJSONObject);
                                iVar.o(optJSONObject, this.f21888c.f21880e.c());
                                this.f21888c.f21882g.add(iVar);
                            }
                            I0 c5 = C2865c0.c();
                            a aVar = new a(this.f21888c, (C2308e) null);
                            this.f21886a = 1;
                            if (C2872g.g(c5, aVar, this) == f5) {
                                return f5;
                            }
                        }
                    } else {
                        int d5 = this.f21888c.f21879d;
                        this.f21888c.f21879d = d5 + 1;
                        kotlin.coroutines.jvm.internal.b.b(d5);
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

    /* renamed from: g2.h$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21891a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2386h f21892b;

        /* renamed from: g2.h$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21893a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2386h f21894b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Z f21895c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2386h hVar, Z z4, C2308e eVar) {
                super(2, eVar);
                this.f21894b = hVar;
                this.f21895c = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21894b, this.f21895c, eVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
                if (g2.C2386h.m(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
                if (g2.C2386h.a(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
                if (g2.C2386h.j(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
                if (g2.C2386h.k(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
                if (g2.C2386h.l(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
                return r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = c3.C2316b.f()
                    int r1 = r7.f21893a
                    r2 = 5
                    r3 = 4
                    r4 = 3
                    r5 = 2
                    r6 = 1
                    if (r1 == 0) goto L_0x0033
                    if (r1 == r6) goto L_0x002f
                    if (r1 == r5) goto L_0x002b
                    if (r1 == r4) goto L_0x0027
                    if (r1 == r3) goto L_0x0023
                    if (r1 != r2) goto L_0x001b
                    W2.u.b(r8)
                    goto L_0x0077
                L_0x001b:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x0023:
                    W2.u.b(r8)
                    goto L_0x006a
                L_0x0027:
                    W2.u.b(r8)
                    goto L_0x005d
                L_0x002b:
                    W2.u.b(r8)
                    goto L_0x0050
                L_0x002f:
                    W2.u.b(r8)
                    goto L_0x0043
                L_0x0033:
                    W2.u.b(r8)
                    g2.h r8 = r7.f21894b
                    z2.Z r1 = r7.f21895c
                    r7.f21893a = r6
                    java.lang.Object r8 = r8.w(r1, r7)
                    if (r8 != r0) goto L_0x0043
                    goto L_0x0076
                L_0x0043:
                    g2.h r8 = r7.f21894b
                    z2.Z r1 = r7.f21895c
                    r7.f21893a = r5
                    java.lang.Object r8 = r8.q(r1, r7)
                    if (r8 != r0) goto L_0x0050
                    goto L_0x0076
                L_0x0050:
                    g2.h r8 = r7.f21894b
                    z2.Z r1 = r7.f21895c
                    r7.f21893a = r4
                    java.lang.Object r8 = r8.s(r1, r7)
                    if (r8 != r0) goto L_0x005d
                    goto L_0x0076
                L_0x005d:
                    g2.h r8 = r7.f21894b
                    z2.Z r1 = r7.f21895c
                    r7.f21893a = r3
                    java.lang.Object r8 = r8.u(r1, r7)
                    if (r8 != r0) goto L_0x006a
                    goto L_0x0076
                L_0x006a:
                    g2.h r8 = r7.f21894b
                    z2.Z r1 = r7.f21895c
                    r7.f21893a = r2
                    java.lang.Object r8 = r8.v(r1, r7)
                    if (r8 != r0) goto L_0x0077
                L_0x0076:
                    return r0
                L_0x0077:
                    W2.J r8 = W2.J.f19942a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: g2.C2386h.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.h$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21896a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2386h f21897b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2386h hVar, C2308e eVar) {
                super(2, eVar);
                this.f21897b = hVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f21897b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21896a == 0) {
                    u.b(obj);
                    C2609t g5 = this.f21897b.f21877b;
                    if (g5 == null) {
                        return null;
                    }
                    g5.c(this.f21897b.f21883h, this.f21897b.f21882g, this.f21897b.f21881f, this.f21897b.f21879d);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2386h hVar, C2308e eVar) {
            super(2, eVar);
            this.f21892b = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21892b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
            if (r12.l(r11) == r0) goto L_0x005e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f21891a
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001b
                if (r1 != r3) goto L_0x0013
                W2.u.b(r12)
                return r12
            L_0x0013:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001b:
                W2.u.b(r12)
                goto L_0x004b
            L_0x001f:
                W2.u.b(r12)
                z2.Z r12 = new z2.Z
                g2.h r1 = r11.f21892b
                android.content.Context r1 = r1.f21876a
                r12.<init>(r1)
                g2.h r1 = r11.f21892b
                w3.M r5 = r1.t()
                g2.h$c$a r8 = new g2.h$c$a
                g2.h r1 = r11.f21892b
                r8.<init>(r1, r12, r2)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                w3.y0 r12 = w3.C2876i.d(r5, r6, r7, r8, r9, r10)
                r11.f21891a = r4
                java.lang.Object r12 = r12.l(r11)
                if (r12 != r0) goto L_0x004b
                goto L_0x005e
            L_0x004b:
                w3.I0 r12 = w3.C2865c0.c()
                g2.h$c$b r1 = new g2.h$c$b
                g2.h r4 = r11.f21892b
                r1.<init>(r4, r2)
                r11.f21891a = r3
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x005f
            L_0x005e:
                return r0
            L_0x005f:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2386h.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.h$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21898a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f21899b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2386h f21900c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Z z4, C2386h hVar, C2308e eVar) {
            super(2, eVar);
            this.f21899b = z4;
            this.f21900c = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21899b, this.f21900c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            String str;
            C2316b.f();
            if (this.f21898a == 0) {
                u.b(obj);
                l2.M a02 = this.f21899b.a0(this.f21900c.f21880e.c(), 10, 0);
                if (a02.b() || (d5 = a02.d()) == null || d5.length() == 0) {
                    int d6 = this.f21900c.f21879d;
                    this.f21900c.f21879d = d6 + 1;
                    return kotlin.coroutines.jvm.internal.b.b(d6);
                }
                ArrayList V02 = this.f21899b.V0(a02);
                try {
                    str = this.f21900c.f21876a.getString(R.string.the_latest_title);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    str = "The latest";
                }
                C2660i iVar = new C2660i(-2, str, (String) null, 4, (C2633k) null);
                iVar.y(this.f21900c.f21880e.c());
                S s5 = new S(iVar, V02, 0, 4, (C2633k) null);
                s5.f(1);
                return kotlin.coroutines.jvm.internal.b.a(this.f21900c.f21881f.add(s5));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.h$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21901a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2386h f21902b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21903c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2386h hVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21902b = hVar;
            this.f21903c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21902b, this.f21903c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i5;
            String str;
            C2316b.f();
            if (this.f21901a == 0) {
                u.b(obj);
                if (this.f21902b.f21880e.c() == 523) {
                    i5 = 8;
                } else {
                    i5 = 10;
                }
                l2.M l02 = this.f21903c.l0(this.f21902b.f21880e.c(), i5, 0);
                if (l02.b() || l02.e() == null) {
                    int d5 = this.f21902b.f21879d;
                    this.f21902b.f21879d = d5 + 1;
                    return kotlin.coroutines.jvm.internal.b.b(d5);
                }
                ArrayList V02 = this.f21903c.V0(l02);
                try {
                    str = this.f21902b.f21876a.getString(R.string.top_downloads_title);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    str = "Top Downloads";
                }
                C2660i iVar = new C2660i(-1, str, (String) null, 4, (C2633k) null);
                iVar.y(this.f21902b.f21880e.c());
                S s5 = new S(iVar, V02, 0, 4, (C2633k) null);
                if (this.f21902b.f21880e.c() != 523 || UptodownApp.f13477F.P()) {
                    s5.f(5);
                } else {
                    s5.f(4);
                }
                return kotlin.coroutines.jvm.internal.b.a(this.f21902b.f21881f.add(s5));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.h$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21904a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2386h f21905b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Z f21906c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C2386h hVar, Z z4, C2308e eVar) {
            super(2, eVar);
            this.f21905b = hVar;
            this.f21906c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f21905b, this.f21906c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i5;
            C2316b.f();
            if (this.f21904a == 0) {
                u.b(obj);
                Iterator it = this.f21905b.f21882g.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2660i iVar = (C2660i) next;
                    if (iVar.c() == 648 || iVar.c() == 567 || iVar.c() == 563) {
                        i5 = 12;
                    } else {
                        i5 = 10;
                    }
                    l2.M m02 = this.f21906c.m0(iVar.c(), i5, 0);
                    if (m02.b() || m02.e() == null) {
                        int d5 = this.f21905b.f21879d;
                        this.f21905b.f21879d = d5 + 1;
                        kotlin.coroutines.jvm.internal.b.b(d5);
                    } else {
                        S s5 = new S(iVar, this.f21906c.V0(m02), 0, 4, (C2633k) null);
                        if (this.f21905b.f21880e.c() == 523) {
                            int c5 = iVar.c();
                            if (!(c5 == 568 || c5 == 593 || c5 == 645)) {
                                switch (c5) {
                                    case 558:
                                    case 559:
                                    case 560:
                                    case 562:
                                        s5.f(5);
                                        break;
                                    case 561:
                                        break;
                                    default:
                                        switch (c5) {
                                            case 564:
                                            case 565:
                                            case 566:
                                                break;
                                            default:
                                                s5.f(6);
                                                break;
                                        }
                                        s5.f(5);
                                        break;
                                }
                            }
                            s5.f(1);
                        } else {
                            s5.f(1);
                        }
                        kotlin.coroutines.jvm.internal.b.a(this.f21905b.f21881f.add(s5));
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.h$g */
    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21907a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f21908b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2386h f21909c;

        /* renamed from: g2.h$g$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21910a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2386h f21911b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2386h hVar, C2308e eVar) {
                super(2, eVar);
                this.f21911b = hVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21911b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21910a == 0) {
                    u.b(obj);
                    C2609t g5 = this.f21911b.f21877b;
                    if (g5 == null) {
                        return null;
                    }
                    g5.a(this.f21911b.f21883h);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Z z4, C2386h hVar, C2308e eVar) {
            super(2, eVar);
            this.f21908b = z4;
            this.f21909c = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f21908b, this.f21909c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21907a;
            if (i5 == 0) {
                u.b(obj);
                l2.M w4 = this.f21908b.w(this.f21909c.f21880e.c());
                if (w4.b() || w4.e() == null) {
                    int d5 = this.f21909c.f21879d;
                    this.f21909c.f21879d = d5 + 1;
                    return kotlin.coroutines.jvm.internal.b.b(d5);
                }
                this.f21909c.f21883h = this.f21908b.V0(w4);
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21909c, (C2308e) null);
                this.f21907a = 1;
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
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2386h(Context context, C2609t tVar, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f21876a = context;
        this.f21877b = tVar;
        this.f21878c = m5;
        C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object q(Z z4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(z4, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object r(C2308e eVar) {
        return C2872g.g(C2865c0.b(), new c(this, (C2308e) null), eVar);
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
        Object g5 = C2872g.g(C2865c0.b(), new g(z4, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final M t() {
        return this.f21878c;
    }
}
