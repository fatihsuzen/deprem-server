package g2;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import k2.Q;
import k2.S;
import k2.T;
import k2.W;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: g2.q  reason: case insensitive filesystem */
public final class C2395q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f22025a;

    /* renamed from: b  reason: collision with root package name */
    private final M f22026b;

    /* renamed from: g2.q$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22027a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2395q f22028b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22029c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Q f22030d;

        /* renamed from: g2.q$a$a  reason: collision with other inner class name */
        static final class C0237a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22031a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f22032b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0237a(Q q5, C2308e eVar) {
                super(2, eVar);
                this.f22032b = q5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0237a(this.f22032b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22031a == 0) {
                    u.b(obj);
                    this.f22032b.d();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0237a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$a$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22033a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f22034b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Q q5, C2308e eVar) {
                super(2, eVar);
                this.f22034b = q5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22034b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22033a == 0) {
                    u.b(obj);
                    this.f22034b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$a$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22035a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f22036b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Q q5, C2308e eVar) {
                super(2, eVar);
                this.f22036b = q5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f22036b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22035a == 0) {
                    u.b(obj);
                    this.f22036b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2395q qVar, long j5, Q q5, C2308e eVar) {
            super(2, eVar);
            this.f22028b = qVar;
            this.f22029c = j5;
            this.f22030d = q5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22028b, this.f22029c, this.f22030d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f22027a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
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
                goto L_0x0097
            L_0x001f:
                W2.u.b(r8)
                z2.Z r8 = new z2.Z
                g2.q r1 = r7.f22028b
                android.content.Context r1 = r1.f22025a
                r8.<init>(r1)
                long r5 = r7.f22029c
                l2.M r8 = r8.c(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r8.d()
                if (r1 == 0) goto L_0x0083
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0047
                goto L_0x0083
            L_0x0047:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r8 = r8.d()
                kotlin.jvm.internal.t.b(r8)
                r1.<init>(r8)
                java.lang.String r8 = "success"
                int r8 = r1.optInt(r8)
                if (r8 != r4) goto L_0x006f
                w3.I0 r8 = w3.C2865c0.c()
                g2.q$a$a r1 = new g2.q$a$a
                k2.Q r2 = r7.f22030d
                r1.<init>(r2, r5)
                r7.f22027a = r4
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x006f:
                w3.I0 r8 = w3.C2865c0.c()
                g2.q$a$b r1 = new g2.q$a$b
                k2.Q r2 = r7.f22030d
                r1.<init>(r2, r5)
                r7.f22027a = r3
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x0083:
                w3.I0 r8 = w3.C2865c0.c()
                g2.q$a$c r1 = new g2.q$a$c
                k2.Q r3 = r7.f22030d
                r1.<init>(r3, r5)
                r7.f22027a = r2
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
            L_0x0096:
                return r0
            L_0x0097:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2395q.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.q$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2395q f22038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22039c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ S f22040d;

        /* renamed from: g2.q$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22041a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S f22042b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S s5, C2308e eVar) {
                super(2, eVar);
                this.f22042b = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22042b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22041a == 0) {
                    u.b(obj);
                    this.f22042b.f();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$b$b  reason: collision with other inner class name */
        static final class C0238b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22043a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S f22044b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0238b(S s5, C2308e eVar) {
                super(2, eVar);
                this.f22044b = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0238b(this.f22044b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22043a == 0) {
                    u.b(obj);
                    this.f22044b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0238b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$b$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22045a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S f22046b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S s5, C2308e eVar) {
                super(2, eVar);
                this.f22046b = s5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f22046b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22045a == 0) {
                    u.b(obj);
                    this.f22046b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2395q qVar, long j5, S s5, C2308e eVar) {
            super(2, eVar);
            this.f22038b = qVar;
            this.f22039c = j5;
            this.f22040d = s5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f22038b, this.f22039c, this.f22040d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
            if (w3.C2872g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f22037a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
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
                goto L_0x0097
            L_0x001f:
                W2.u.b(r8)
                z2.Z r8 = new z2.Z
                g2.q r1 = r7.f22038b
                android.content.Context r1 = r1.f22025a
                r8.<init>(r1)
                long r5 = r7.f22039c
                l2.M r8 = r8.c1(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r8.d()
                if (r1 == 0) goto L_0x0083
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0047
                goto L_0x0083
            L_0x0047:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r8 = r8.d()
                kotlin.jvm.internal.t.b(r8)
                r1.<init>(r8)
                java.lang.String r8 = "success"
                int r8 = r1.optInt(r8)
                if (r8 != r4) goto L_0x006f
                w3.I0 r8 = w3.C2865c0.c()
                g2.q$b$a r1 = new g2.q$b$a
                k2.S r2 = r7.f22040d
                r1.<init>(r2, r5)
                r7.f22037a = r4
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x006f:
                w3.I0 r8 = w3.C2865c0.c()
                g2.q$b$b r1 = new g2.q$b$b
                k2.S r2 = r7.f22040d
                r1.<init>(r2, r5)
                r7.f22037a = r3
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x0083:
                w3.I0 r8 = w3.C2865c0.c()
                g2.q$b$c r1 = new g2.q$b$c
                k2.S r3 = r7.f22040d
                r1.<init>(r3, r5)
                r7.f22037a = r2
                java.lang.Object r8 = w3.C2872g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
            L_0x0096:
                return r0
            L_0x0097:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2395q.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.q$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2395q f22048b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f22049c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f22050d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ W f22051e;

        /* renamed from: g2.q$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22052a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ W f22053b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f22054c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ I f22055d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f22056e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(W w4, ArrayList arrayList, I i5, kotlin.jvm.internal.J j5, C2308e eVar) {
                super(2, eVar);
                this.f22053b = w4;
                this.f22054c = arrayList;
                this.f22055d = i5;
                this.f22056e = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22053b, this.f22054c, this.f22055d, this.f22056e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22052a == 0) {
                    u.b(obj);
                    this.f22053b.b(this.f22054c, this.f22055d.f24687a, this.f22056e.f24688a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22057a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ W f22058b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(W w4, C2308e eVar) {
                super(2, eVar);
                this.f22058b = w4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22058b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22057a == 0) {
                    u.b(obj);
                    this.f22058b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2395q qVar, int i5, int i6, W w4, C2308e eVar) {
            super(2, eVar);
            this.f22048b = qVar;
            this.f22049c = i5;
            this.f22050d = i6;
            this.f22051e = w4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f22048b, this.f22049c, this.f22050d, this.f22051e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b4, code lost:
            if (w3.C2872g.g(r13, r4, r12) == r0) goto L_0x00cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
            if (w3.C2872g.g(r13, r1, r12) == r0) goto L_0x00cb;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r12.f22047a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0017:
                W2.u.b(r13)
                goto L_0x00cc
            L_0x001c:
                W2.u.b(r13)
                z2.Z r13 = new z2.Z
                g2.q r1 = r12.f22048b
                android.content.Context r1 = r1.f22025a
                r13.<init>(r1)
                int r1 = r12.f22049c
                int r4 = r12.f22050d
                l2.M r13 = r13.L(r1, r4)
                boolean r1 = r13.b()
                if (r1 != 0) goto L_0x00b7
                kotlin.jvm.internal.I r7 = new kotlin.jvm.internal.I
                r7.<init>()
                r7.f24687a = r3
                kotlin.jvm.internal.J r8 = new kotlin.jvm.internal.J
                r8.<init>()
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.lang.String r1 = r13.d()
                if (r1 == 0) goto L_0x00a2
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0056
                goto L_0x00a2
            L_0x0056:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r13 = r13.d()
                kotlin.jvm.internal.t.b(r13)
                r1.<init>(r13)
                java.lang.String r13 = "data"
                org.json.JSONObject r13 = r1.optJSONObject(r13)
                if (r13 == 0) goto L_0x00a2
                java.lang.String r1 = "items"
                org.json.JSONArray r1 = r13.optJSONArray(r1)
                r2 = 0
                if (r1 == 0) goto L_0x008f
                int r4 = r1.length()
                r5 = r2
            L_0x0078:
                if (r5 >= r4) goto L_0x008f
                l2.Y$a r9 = l2.Y.f24916k
                org.json.JSONObject r10 = r1.optJSONObject(r5)
                java.lang.String r11 = "optJSONObject(...)"
                kotlin.jvm.internal.t.d(r10, r11)
                l2.Y r9 = r9.a(r10)
                r6.add(r9)
                int r5 = r5 + 1
                goto L_0x0078
            L_0x008f:
                java.lang.String r1 = "isPrivate"
                int r1 = r13.optInt(r1)
                if (r1 != r3) goto L_0x0098
                r2 = r3
            L_0x0098:
                r7.f24687a = r2
                java.lang.String r1 = "countApps"
                int r13 = r13.optInt(r1)
                r8.f24688a = r13
            L_0x00a2:
                w3.I0 r13 = w3.C2865c0.c()
                g2.q$c$a r4 = new g2.q$c$a
                k2.W r5 = r12.f22051e
                r9 = 0
                r4.<init>(r5, r6, r7, r8, r9)
                r12.f22047a = r3
                java.lang.Object r13 = w3.C2872g.g(r13, r4, r12)
                if (r13 != r0) goto L_0x00cc
                goto L_0x00cb
            L_0x00b7:
                w3.I0 r13 = w3.C2865c0.c()
                g2.q$c$b r1 = new g2.q$c$b
                k2.W r3 = r12.f22051e
                r4 = 0
                r1.<init>(r3, r4)
                r12.f22047a = r2
                java.lang.Object r13 = w3.C2872g.g(r13, r1, r12)
                if (r13 != r0) goto L_0x00cc
            L_0x00cb:
                return r0
            L_0x00cc:
                W2.J r13 = W2.J.f19942a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2395q.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.q$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22059a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2395q f22060b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22061c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f22062d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f22063e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ W f22064f;

        /* renamed from: g2.q$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22065a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ W f22066b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f22067c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(W w4, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f22066b = w4;
                this.f22067c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22066b, this.f22067c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22065a == 0) {
                    u.b(obj);
                    this.f22066b.b(this.f22067c, false, 0);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$d$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22068a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ W f22069b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(W w4, C2308e eVar) {
                super(2, eVar);
                this.f22069b = w4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22069b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22068a == 0) {
                    u.b(obj);
                    this.f22069b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2395q qVar, String str, int i5, int i6, W w4, C2308e eVar) {
            super(2, eVar);
            this.f22060b = qVar;
            this.f22061c = str;
            this.f22062d = i5;
            this.f22063e = i6;
            this.f22064f = w4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f22060b, this.f22061c, this.f22062d, this.f22063e, this.f22064f, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
            if (w3.C2872g.g(r1, r2, r9) == r0) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
            if (w3.C2872g.g(r10, r1, r9) == r0) goto L_0x00a4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f22059a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0017:
                W2.u.b(r10)
                goto L_0x00a5
            L_0x001c:
                W2.u.b(r10)
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                z2.Z r1 = new z2.Z
                g2.q r4 = r9.f22060b
                android.content.Context r4 = r4.f22025a
                r1.<init>(r4)
                java.lang.String r4 = r9.f22061c
                int r5 = r9.f22062d
                int r6 = r9.f22063e
                l2.M r1 = r1.b0(r4, r5, r6)
                boolean r4 = r1.b()
                r5 = 0
                if (r4 != 0) goto L_0x0091
                java.lang.String r4 = r1.d()
                if (r4 == 0) goto L_0x0091
                int r4 = r4.length()
                if (r4 != 0) goto L_0x004d
                goto L_0x0091
            L_0x004d:
                org.json.JSONObject r2 = new org.json.JSONObject
                java.lang.String r1 = r1.d()
                kotlin.jvm.internal.t.b(r1)
                r2.<init>(r1)
                java.lang.String r1 = "data"
                org.json.JSONArray r1 = r2.optJSONArray(r1)
                if (r1 == 0) goto L_0x00a5
                int r2 = r1.length()
                r4 = 0
            L_0x0066:
                if (r4 >= r2) goto L_0x007d
                l2.Y$a r6 = l2.Y.f24916k
                org.json.JSONObject r7 = r1.optJSONObject(r4)
                java.lang.String r8 = "optJSONObject(...)"
                kotlin.jvm.internal.t.d(r7, r8)
                l2.Y r6 = r6.a(r7)
                r10.add(r6)
                int r4 = r4 + 1
                goto L_0x0066
            L_0x007d:
                w3.I0 r1 = w3.C2865c0.c()
                g2.q$d$a r2 = new g2.q$d$a
                k2.W r4 = r9.f22064f
                r2.<init>(r4, r10, r5)
                r9.f22059a = r3
                java.lang.Object r10 = w3.C2872g.g(r1, r2, r9)
                if (r10 != r0) goto L_0x00a5
                goto L_0x00a4
            L_0x0091:
                w3.I0 r10 = w3.C2865c0.c()
                g2.q$d$b r1 = new g2.q$d$b
                k2.W r3 = r9.f22064f
                r1.<init>(r3, r5)
                r9.f22059a = r2
                java.lang.Object r10 = w3.C2872g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x00a5
            L_0x00a4:
                return r0
            L_0x00a5:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2395q.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.q$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22070a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2395q f22071b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f22072c;

        /* renamed from: g2.q$e$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22073a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f22074b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(T t5, C2308e eVar) {
                super(2, eVar);
                this.f22074b = t5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22074b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22073a == 0) {
                    u.b(obj);
                    this.f22074b.g();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$e$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22075a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f22076b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(T t5, C2308e eVar) {
                super(2, eVar);
                this.f22076b = t5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22076b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22075a == 0) {
                    u.b(obj);
                    this.f22076b.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2395q qVar, T t5, C2308e eVar) {
            super(2, eVar);
            this.f22071b = qVar;
            this.f22072c = t5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f22071b, this.f22072c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
            if (w3.C2872g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
            if (w3.C2872g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f22070a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0017:
                W2.u.b(r6)
                goto L_0x0069
            L_0x001b:
                W2.u.b(r6)
                z2.Z r6 = new z2.Z
                g2.q r1 = r5.f22071b
                android.content.Context r1 = r1.f22025a
                r6.<init>(r1)
                l2.M r6 = r6.k1()
                boolean r1 = r6.b()
                r4 = 0
                if (r1 != 0) goto L_0x0055
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x0055
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0041
                goto L_0x0055
            L_0x0041:
                w3.I0 r6 = w3.C2865c0.c()
                g2.q$e$a r1 = new g2.q$e$a
                k2.T r2 = r5.f22072c
                r1.<init>(r2, r4)
                r5.f22070a = r3
                java.lang.Object r6 = w3.C2872g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
                goto L_0x0068
            L_0x0055:
                w3.I0 r6 = w3.C2865c0.c()
                g2.q$e$b r1 = new g2.q$e$b
                k2.T r3 = r5.f22072c
                r1.<init>(r3, r4)
                r5.f22070a = r2
                java.lang.Object r6 = w3.C2872g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
            L_0x0068:
                return r0
            L_0x0069:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2395q.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: g2.q$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22077a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2395q f22078b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f22079c;

        /* renamed from: g2.q$f$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22080a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f22081b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(T t5, C2308e eVar) {
                super(2, eVar);
                this.f22081b = t5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f22081b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22080a == 0) {
                    u.b(obj);
                    this.f22081b.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: g2.q$f$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f22082a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f22083b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(T t5, C2308e eVar) {
                super(2, eVar);
                this.f22083b = t5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f22083b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f22082a == 0) {
                    u.b(obj);
                    this.f22083b.g();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C2395q qVar, T t5, C2308e eVar) {
            super(2, eVar);
            this.f22078b = qVar;
            this.f22079c = t5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f22078b, this.f22079c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
            if (w3.C2872g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
            if (w3.C2872g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f22077a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0017:
                W2.u.b(r6)
                goto L_0x0069
            L_0x001b:
                W2.u.b(r6)
                z2.Z r6 = new z2.Z
                g2.q r1 = r5.f22078b
                android.content.Context r1 = r1.f22025a
                r6.<init>(r1)
                l2.M r6 = r6.l1()
                boolean r1 = r6.b()
                r4 = 0
                if (r1 != 0) goto L_0x0055
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x0055
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0041
                goto L_0x0055
            L_0x0041:
                w3.I0 r6 = w3.C2865c0.c()
                g2.q$f$a r1 = new g2.q$f$a
                k2.T r2 = r5.f22079c
                r1.<init>(r2, r4)
                r5.f22077a = r3
                java.lang.Object r6 = w3.C2872g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
                goto L_0x0068
            L_0x0055:
                w3.I0 r6 = w3.C2865c0.c()
                g2.q$f$b r1 = new g2.q$f$b
                k2.T r3 = r5.f22079c
                r1.<init>(r3, r4)
                r5.f22077a = r2
                java.lang.Object r6 = w3.C2872g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
            L_0x0068:
                return r0
            L_0x0069:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2395q.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2395q(Context context, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f22025a = context;
        this.f22026b = m5;
    }

    public final void b(long j5, Q q5) {
        t.e(q5, "listener");
        C2908y0 unused = C2876i.d(this.f22026b, C2865c0.b(), (O) null, new a(this, j5, q5, (C2308e) null), 2, (Object) null);
    }

    public final void c(long j5, S s5) {
        t.e(s5, "listener");
        C2908y0 unused = C2876i.d(this.f22026b, C2865c0.b(), (O) null, new b(this, j5, s5, (C2308e) null), 2, (Object) null);
    }

    public final void d(int i5, int i6, W w4) {
        t.e(w4, "listener");
        C2908y0 unused = C2876i.d(this.f22026b, C2865c0.b(), (O) null, new c(this, i5, i6, w4, (C2308e) null), 2, (Object) null);
    }

    public final void e(String str, int i5, int i6, W w4) {
        t.e(str, "userID");
        t.e(w4, "listener");
        C2908y0 unused = C2876i.d(this.f22026b, C2865c0.b(), (O) null, new d(this, str, i5, i6, w4, (C2308e) null), 2, (Object) null);
    }

    public final void f(T t5) {
        t.e(t5, "listener");
        C2908y0 unused = C2876i.d(this.f22026b, C2865c0.b(), (O) null, new e(this, t5, (C2308e) null), 2, (Object) null);
    }

    public final void g(T t5) {
        t.e(t5, "listener");
        C2908y0 unused = C2876i.d(this.f22026b, C2865c0.b(), (O) null, new f(this, t5, (C2308e) null), 2, (Object) null);
    }
}
