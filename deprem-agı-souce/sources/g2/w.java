package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.ArrayList;
import k2.Q;
import k2.S;
import k2.U;
import k2.W;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;

public final class w {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f22115a;

    /* renamed from: b  reason: collision with root package name */
    private final M f22116b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22118b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22119c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Q f22120d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar, long j5, Q q5, C2308e eVar) {
            super(2, eVar);
            this.f22118b = wVar;
            this.f22119c = j5;
            this.f22120d = q5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22118b, this.f22119c, this.f22120d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22117a;
            if (i5 == 0) {
                u.b(obj);
                w wVar = this.f22118b;
                long j5 = this.f22119c;
                Q q5 = this.f22120d;
                this.f22117a = 1;
                if (wVar.f(j5, q5, this) == f5) {
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
        int f22121a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22122b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22123c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Q f22124d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22125a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f22126b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Q q5, C2308e eVar) {
                super(2, eVar);
                this.f22126b = q5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22126b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22125a == 0) {
                    u.b(obj);
                    this.f22126b.d();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.w$b$b  reason: collision with other inner class name */
        static final class C0239b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22127a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f22128b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0239b(Q q5, C2308e eVar) {
                super(2, eVar);
                this.f22128b = q5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0239b(this.f22128b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22127a == 0) {
                    u.b(obj);
                    this.f22128b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0239b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22129a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f22130b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Q q5, C2308e eVar) {
                super(2, eVar);
                this.f22130b = q5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f22130b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22129a == 0) {
                    u.b(obj);
                    this.f22130b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar, long j5, Q q5, C2308e eVar) {
            super(2, eVar);
            this.f22122b = wVar;
            this.f22123c = j5;
            this.f22124d = q5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f22122b, this.f22123c, this.f22124d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f22121a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                W2.u.b(r8)
                goto L_0x008a
            L_0x001e:
                W2.u.b(r8)
                z2.Z r8 = new z2.Z
                g2.w r1 = r7.f22122b
                android.content.Context r1 = r1.f22115a
                r8.<init>(r1)
                long r5 = r7.f22123c
                l2.M r8 = r8.t1(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0076
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x0076
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.t.b(r8)
                java.lang.String r1 = "success"
                int r8 = r8.optInt(r1)
                if (r8 != r4) goto L_0x0062
                w3.I0 r8 = w3.C2865c0.c()
                g2.w$b$a r1 = new g2.w$b$a
                k2.Q r2 = r7.f22124d
                r1.<init>(r2, r5)
                r7.f22121a = r4
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0062:
                w3.I0 r8 = w3.C2865c0.c()
                g2.w$b$b r1 = new g2.w$b$b
                k2.Q r2 = r7.f22124d
                r1.<init>(r2, r5)
                r7.f22121a = r3
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0076:
                w3.I0 r8 = w3.C2865c0.c()
                g2.w$b$c r1 = new g2.w$b$c
                k2.Q r3 = r7.f22124d
                r1.<init>(r3, r5)
                r7.f22121a = r2
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
            L_0x0089:
                return r0
            L_0x008a:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.w.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22131a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22132b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22133c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ S f22134d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(w wVar, long j5, S s5, C2308e eVar) {
            super(2, eVar);
            this.f22132b = wVar;
            this.f22133c = j5;
            this.f22134d = s5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f22132b, this.f22133c, this.f22134d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22131a;
            if (i5 == 0) {
                u.b(obj);
                w wVar = this.f22132b;
                long j5 = this.f22133c;
                S s5 = this.f22134d;
                this.f22131a = 1;
                if (wVar.h(j5, s5, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22135a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22136b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22137c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ S f22138d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22139a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S f22140b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S s5, C2308e eVar) {
                super(2, eVar);
                this.f22140b = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22140b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22139a == 0) {
                    u.b(obj);
                    this.f22140b.f();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22141a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S f22142b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S s5, C2308e eVar) {
                super(2, eVar);
                this.f22142b = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22142b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22141a == 0) {
                    u.b(obj);
                    this.f22142b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22143a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S f22144b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S s5, C2308e eVar) {
                super(2, eVar);
                this.f22144b = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f22144b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22143a == 0) {
                    u.b(obj);
                    this.f22144b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(w wVar, long j5, S s5, C2308e eVar) {
            super(2, eVar);
            this.f22136b = wVar;
            this.f22137c = j5;
            this.f22138d = s5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f22136b, this.f22137c, this.f22138d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f22135a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                W2.u.b(r8)
                goto L_0x008a
            L_0x001e:
                W2.u.b(r8)
                z2.Z r8 = new z2.Z
                g2.w r1 = r7.f22136b
                android.content.Context r1 = r1.f22115a
                r8.<init>(r1)
                long r5 = r7.f22137c
                l2.M r8 = r8.u1(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0076
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x0076
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.t.b(r8)
                java.lang.String r1 = "success"
                int r8 = r8.optInt(r1)
                if (r8 != r4) goto L_0x0062
                w3.I0 r8 = w3.C2865c0.c()
                g2.w$d$a r1 = new g2.w$d$a
                k2.S r2 = r7.f22138d
                r1.<init>(r2, r5)
                r7.f22135a = r4
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0062:
                w3.I0 r8 = w3.C2865c0.c()
                g2.w$d$b r1 = new g2.w$d$b
                k2.S r2 = r7.f22138d
                r1.<init>(r2, r5)
                r7.f22135a = r3
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0076:
                w3.I0 r8 = w3.C2865c0.c()
                g2.w$d$c r1 = new g2.w$d$c
                k2.S r3 = r7.f22138d
                r1.<init>(r3, r5)
                r7.f22135a = r2
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
            L_0x0089:
                return r0
            L_0x008a:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.w.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22145a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22146b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ U f22147c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22148a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ U f22149b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f22150c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(U u5, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f22149b = u5;
                this.f22150c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22149b, this.f22150c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22148a == 0) {
                    u.b(obj);
                    this.f22149b.e(this.f22150c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22151a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ U f22152b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(U u5, C2308e eVar) {
                super(2, eVar);
                this.f22152b = u5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22152b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22151a == 0) {
                    u.b(obj);
                    this.f22152b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(w wVar, U u5, C2308e eVar) {
            super(2, eVar);
            this.f22146b = wVar;
            this.f22147c = u5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f22146b, this.f22147c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
            if (w3.C2872g.g(r11, r2, r10) == r0) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
            if (w3.C2872g.g(r11, r1, r10) == r0) goto L_0x0094;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r10.f22145a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0017:
                W2.u.b(r11)
                goto L_0x0095
            L_0x001c:
                W2.u.b(r11)
                z2.Z r11 = new z2.Z
                g2.w r1 = r10.f22146b
                android.content.Context r1 = r1.f22115a
                r11.<init>(r1)
                r1 = 20
                r4 = 0
                l2.M r11 = r11.W(r1, r4)
                boolean r1 = r11.b()
                r5 = 0
                if (r1 != 0) goto L_0x0081
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                org.json.JSONObject r6 = r11.e()
                if (r6 == 0) goto L_0x006d
                org.json.JSONObject r11 = r11.e()
                kotlin.jvm.internal.t.b(r11)
                java.lang.String r6 = "data"
                org.json.JSONArray r11 = r11.optJSONArray(r6)
                if (r11 == 0) goto L_0x006d
                int r6 = r11.length()
            L_0x0056:
                if (r4 >= r6) goto L_0x006d
                l2.f$b r7 = l2.C2657f.f25002J0
                org.json.JSONObject r8 = r11.optJSONObject(r4)
                java.lang.String r9 = "optJSONObject(...)"
                kotlin.jvm.internal.t.d(r8, r9)
                l2.f r7 = l2.C2657f.b.b(r7, r8, r5, r2, r5)
                r1.add(r7)
                int r4 = r4 + 1
                goto L_0x0056
            L_0x006d:
                w3.I0 r11 = w3.C2865c0.c()
                g2.w$e$a r2 = new g2.w$e$a
                k2.U r4 = r10.f22147c
                r2.<init>(r4, r1, r5)
                r10.f22145a = r3
                java.lang.Object r11 = w3.C2872g.g(r11, r2, r10)
                if (r11 != r0) goto L_0x0095
                goto L_0x0094
            L_0x0081:
                w3.I0 r11 = w3.C2865c0.c()
                g2.w$e$b r1 = new g2.w$e$b
                k2.U r3 = r10.f22147c
                r1.<init>(r3, r5)
                r10.f22145a = r2
                java.lang.Object r11 = w3.C2872g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x0095
            L_0x0094:
                return r0
            L_0x0095:
                W2.J r11 = W2.J.f19942a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.w.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22153a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22154b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f22155c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f22156d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ W f22157e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(w wVar, int i5, int i6, W w4, C2308e eVar) {
            super(2, eVar);
            this.f22154b = wVar;
            this.f22155c = i5;
            this.f22156d = i6;
            this.f22157e = w4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f22154b, this.f22155c, this.f22156d, this.f22157e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22153a;
            if (i5 == 0) {
                u.b(obj);
                w wVar = this.f22154b;
                int i6 = this.f22155c;
                int i7 = this.f22156d;
                W w4 = this.f22157e;
                this.f22153a = 1;
                if (wVar.k(i6, i7, w4, this) == f5) {
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

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22158a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f22159b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f22160c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f22161d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ W f22162e;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22163a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ W f22164b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f22165c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f22166d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(W w4, ArrayList arrayList, kotlin.jvm.internal.J j5, C2308e eVar) {
                super(2, eVar);
                this.f22164b = w4;
                this.f22165c = arrayList;
                this.f22166d = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22164b, this.f22165c, this.f22166d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22163a == 0) {
                    u.b(obj);
                    this.f22164b.b(this.f22165c, false, this.f22166d.f24688a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22167a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ W f22168b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(W w4, C2308e eVar) {
                super(2, eVar);
                this.f22168b = w4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22168b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22167a == 0) {
                    u.b(obj);
                    this.f22168b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(w wVar, int i5, int i6, W w4, C2308e eVar) {
            super(2, eVar);
            this.f22159b = wVar;
            this.f22160c = i5;
            this.f22161d = i6;
            this.f22162e = w4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f22159b, this.f22160c, this.f22161d, this.f22162e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0095, code lost:
            if (w3.C2872g.g(r12, r5, r11) == r0) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a9, code lost:
            if (w3.C2872g.g(r12, r1, r11) == r0) goto L_0x00ab;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f22158a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0017:
                W2.u.b(r12)
                goto L_0x00ac
            L_0x001c:
                W2.u.b(r12)
                z2.Z r12 = new z2.Z
                g2.w r1 = r11.f22159b
                android.content.Context r1 = r1.f22115a
                r12.<init>(r1)
                int r1 = r11.f22160c
                int r4 = r11.f22161d
                l2.M r12 = r12.F0(r1, r4)
                boolean r1 = r12.b()
                r4 = 0
                if (r1 != 0) goto L_0x0098
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                kotlin.jvm.internal.J r2 = new kotlin.jvm.internal.J
                r2.<init>()
                org.json.JSONObject r5 = r12.e()
                if (r5 == 0) goto L_0x0084
                org.json.JSONObject r12 = r12.e()
                kotlin.jvm.internal.t.b(r12)
                java.lang.String r5 = "data"
                org.json.JSONObject r12 = r12.optJSONObject(r5)
                if (r12 == 0) goto L_0x0084
                java.lang.String r5 = "apps"
                org.json.JSONArray r5 = r12.optJSONArray(r5)
                if (r5 == 0) goto L_0x007c
                int r6 = r5.length()
                r7 = 0
            L_0x0065:
                if (r7 >= r6) goto L_0x007c
                l2.Y$a r8 = l2.Y.f24916k
                org.json.JSONObject r9 = r5.optJSONObject(r7)
                java.lang.String r10 = "optJSONObject(...)"
                kotlin.jvm.internal.t.d(r9, r10)
                l2.Y r8 = r8.a(r9)
                r1.add(r8)
                int r7 = r7 + 1
                goto L_0x0065
            L_0x007c:
                java.lang.String r5 = "countApps"
                int r12 = r12.optInt(r5)
                r2.f24688a = r12
            L_0x0084:
                w3.I0 r12 = w3.C2865c0.c()
                g2.w$g$a r5 = new g2.w$g$a
                k2.W r6 = r11.f22162e
                r5.<init>(r6, r1, r2, r4)
                r11.f22158a = r3
                java.lang.Object r12 = w3.C2872g.g(r12, r5, r11)
                if (r12 != r0) goto L_0x00ac
                goto L_0x00ab
            L_0x0098:
                w3.I0 r12 = w3.C2865c0.c()
                g2.w$g$b r1 = new g2.w$g$b
                k2.W r3 = r11.f22162e
                r1.<init>(r3, r4)
                r11.f22158a = r2
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00ac
            L_0x00ab:
                return r0
            L_0x00ac:
                W2.J r12 = W2.J.f19942a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.w.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public w(Context context, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f22115a = context;
        this.f22116b = m5;
    }

    /* access modifiers changed from: private */
    public final Object f(long j5, Q q5, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, j5, q5, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object h(long j5, S s5, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(this, j5, s5, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object k(int i5, int i6, W w4, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new g(this, i5, i6, w4, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final void e(long j5, Q q5) {
        t.e(q5, "listener");
        C2908y0 unused = C2876i.d(this.f22116b, (C2312i) null, (O) null, new a(this, j5, q5, (C2308e) null), 3, (Object) null);
    }

    public final void g(long j5, S s5) {
        t.e(s5, "listener");
        C2908y0 unused = C2876i.d(this.f22116b, (C2312i) null, (O) null, new c(this, j5, s5, (C2308e) null), 3, (Object) null);
    }

    public final void i(U u5) {
        t.e(u5, "listener");
        C2908y0 unused = C2876i.d(this.f22116b, C2865c0.b(), (O) null, new e(this, u5, (C2308e) null), 2, (Object) null);
    }

    public final void j(int i5, int i6, W w4) {
        t.e(w4, "listener");
        C2908y0 unused = C2876i.d(this.f22116b, (C2312i) null, (O) null, new f(this, i5, i6, w4, (C2308e) null), 3, (Object) null);
    }
}
