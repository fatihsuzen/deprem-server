package b1;

import W2.J;
import W2.u;
import android.util.Log;
import androidx.datastore.core.DataStore;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import d3.C2345b;
import e1.j;
import java.util.Map;
import k3.p;
import k3.q;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import u3.C2795a;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z3.C2972e;
import z3.C2973f;
import z3.C2974g;

public final class X implements W {

    /* renamed from: b  reason: collision with root package name */
    private final j f4590b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Q f4591c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final N f4592d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a0 f4593e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final DataStore f4594f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final C1040z f4595g;

    /* renamed from: h  reason: collision with root package name */
    private final C2312i f4596h;

    /* renamed from: i  reason: collision with root package name */
    public H f4597i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4598j;

    /* renamed from: k  reason: collision with root package name */
    private b f4599k = b.GENERAL;

    /* renamed from: l  reason: collision with root package name */
    private String f4600l = "";

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4601a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ X f4602b;

        /* renamed from: b1.X$a$a  reason: collision with other inner class name */
        static final class C0065a extends l implements q {

            /* renamed from: a  reason: collision with root package name */
            int f4603a;

            /* renamed from: b  reason: collision with root package name */
            private /* synthetic */ Object f4604b;

            /* renamed from: c  reason: collision with root package name */
            /* synthetic */ Object f4605c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ X f4606d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0065a(X x4, C2308e eVar) {
                super(3, eVar);
                this.f4606d = x4;
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f4603a;
                if (i5 == 0) {
                    u.b(obj);
                    H h5 = new H(this.f4606d.f4591c.a((K) null), (Z) null, (Map) null, 4, (C2633k) null);
                    Log.d("FirebaseSessions", "Init session datastore failed with exception message: " + ((Throwable) this.f4605c).getMessage() + ". Emit fallback session " + h5.f().b());
                    this.f4604b = null;
                    this.f4603a = 1;
                    if (((C2973f) this.f4604b).emit(h5, this) == f5) {
                        return f5;
                    }
                } else if (i5 == 1) {
                    u.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return J.f19942a;
            }

            public final Object invoke(C2973f fVar, Throwable th, C2308e eVar) {
                C0065a aVar = new C0065a(this.f4606d, eVar);
                aVar.f4604b = fVar;
                aVar.f4605c = th;
                return aVar.invokeSuspend(J.f19942a);
            }
        }

        static final class b implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ X f4607a;

            b(X x4) {
                this.f4607a = x4;
            }

            /* renamed from: b */
            public final Object emit(H h5, C2308e eVar) {
                this.f4607a.r(h5);
                Object l5 = this.f4607a.q(h5.f().b(), b.GENERAL, eVar);
                if (l5 == C2316b.f()) {
                    return l5;
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(X x4, C2308e eVar) {
            super(2, eVar);
            this.f4602b = x4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f4602b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f4601a;
            if (i5 == 0) {
                u.b(obj);
                C2972e e5 = C2974g.e(this.f4602b.f4594f.getData(), new C0065a(this.f4602b, (C2308e) null));
                b bVar = new b(this.f4602b);
                this.f4601a = 1;
                if (e5.collect(bVar, this) == f5) {
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

    public enum b {
        GENERAL,
        FALLBACK;

        static {
            b[] a5;
            f4611d = C2345b.a(a5);
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4612a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                b1.X$b[] r0 = b1.X.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b1.X$b r1 = b1.X.b.GENERAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                b1.X$b r1 = b1.X.b.FALLBACK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f4612a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.X.c.<clinit>():void");
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4613a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ X f4614b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f4615a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4616b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ X f4617c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(X x4, C2308e eVar) {
                super(2, eVar);
                this.f4617c = x4;
            }

            /* renamed from: b */
            public final Object invoke(H h5, C2308e eVar) {
                return ((a) create(h5, eVar)).invokeSuspend(J.f19942a);
            }

            public final C2308e create(Object obj, C2308e eVar) {
                a aVar = new a(this.f4617c, eVar);
                aVar.f4616b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f4615a == 0) {
                    u.b(obj);
                    return H.c((H) this.f4616b, (K) null, this.f4617c.f4593e.a(), (Map) null, 5, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(X x4, C2308e eVar) {
            super(2, eVar);
            this.f4614b = x4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f4614b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f4613a;
            if (i5 == 0) {
                u.b(obj);
                DataStore e5 = this.f4614b.f4594f;
                a aVar = new a(this.f4614b, (C2308e) null);
                this.f4613a = 1;
                if (e5.updateData(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                try {
                    u.b(obj);
                } catch (Exception e6) {
                    Exception exc = e6;
                    Log.d("FirebaseSessions", "App backgrounded, failed to update data. Message: " + exc.getMessage());
                    X x4 = this.f4614b;
                    x4.r(H.c(x4.m(), (K) null, this.f4614b.f4593e.a(), (Map) null, 5, (Object) null));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4618a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ X f4619b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H f4620c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f4621a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4622b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ X f4623c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(X x4, C2308e eVar) {
                super(2, eVar);
                this.f4623c = x4;
            }

            /* renamed from: b */
            public final Object invoke(H h5, C2308e eVar) {
                return ((a) create(h5, eVar)).invokeSuspend(J.f19942a);
            }

            public final C2308e create(Object obj, C2308e eVar) {
                a aVar = new a(this.f4623c, eVar);
                aVar.f4622b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Map map;
                K k5;
                C2316b.f();
                if (this.f4621a == 0) {
                    u.b(obj);
                    H h5 = (H) this.f4622b;
                    boolean k6 = this.f4623c.p(h5);
                    boolean i5 = this.f4623c.n(h5);
                    boolean j5 = this.f4623c.o(h5);
                    if (i5) {
                        map = this.f4623c.f4595g.e();
                    } else if (j5) {
                        map = this.f4623c.f4595g.f(h5.e());
                    } else {
                        map = h5.e();
                    }
                    if (i5) {
                        k5 = null;
                    } else {
                        k5 = h5.f();
                    }
                    if (k6 || i5) {
                        K a5 = this.f4623c.f4591c.a(k5);
                        this.f4623c.f4592d.a(a5);
                        this.f4623c.f4595g.a();
                        return h5.b(a5, (Z) null, map);
                    } else if (j5) {
                        return H.c(h5, (K) null, (Z) null, this.f4623c.f4595g.f(map), 3, (Object) null);
                    } else {
                        return h5;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(X x4, H h5, C2308e eVar) {
            super(2, eVar);
            this.f4619b = x4;
            this.f4620c = h5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f4619b, this.f4620c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
            if (r10.updateData(r0, r9) == r1) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0097, code lost:
            if (b1.X.l(r10, r0, r3, r9) == r1) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0099, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r1 = c3.C2316b.f()
                int r0 = r9.f4618a
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L_0x0023
                if (r0 == r3) goto L_0x001b
                if (r0 != r2) goto L_0x0013
                W2.u.b(r10)
                goto L_0x009a
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                W2.u.b(r10)     // Catch:{ Exception -> 0x0020 }
                goto L_0x009a
            L_0x0020:
                r0 = move-exception
                r10 = r0
                goto L_0x003d
            L_0x0023:
                W2.u.b(r10)
                b1.X r10 = r9.f4619b     // Catch:{ Exception -> 0x0020 }
                androidx.datastore.core.DataStore r10 = r10.f4594f     // Catch:{ Exception -> 0x0020 }
                b1.X$e$a r0 = new b1.X$e$a     // Catch:{ Exception -> 0x0020 }
                b1.X r4 = r9.f4619b     // Catch:{ Exception -> 0x0020 }
                r5 = 0
                r0.<init>(r4, r5)     // Catch:{ Exception -> 0x0020 }
                r9.f4618a = r3     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r10 = r10.updateData(r0, r9)     // Catch:{ Exception -> 0x0020 }
                if (r10 != r1) goto L_0x009a
                goto L_0x0099
            L_0x003d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "App foregrounded, failed to update data. Message: "
                r0.append(r3)
                java.lang.String r10 = r10.getMessage()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "FirebaseSessions"
                android.util.Log.d(r0, r10)
                b1.X r10 = r9.f4619b
                b1.H r0 = r9.f4620c
                boolean r10 = r10.p(r0)
                if (r10 == 0) goto L_0x009a
                b1.X r10 = r9.f4619b
                b1.Q r10 = r10.f4591c
                b1.H r0 = r9.f4620c
                b1.K r0 = r0.f()
                b1.K r4 = r10.a(r0)
                b1.X r10 = r9.f4619b
                b1.H r3 = r9.f4620c
                r7 = 4
                r8 = 0
                r5 = 0
                r6 = 0
                b1.H r0 = b1.H.c(r3, r4, r5, r6, r7, r8)
                r10.r(r0)
                b1.X r10 = r9.f4619b
                b1.N r10 = r10.f4592d
                r10.a(r4)
                b1.X r10 = r9.f4619b
                java.lang.String r0 = r4.b()
                b1.X$b r3 = b1.X.b.FALLBACK
                r9.f4618a = r2
                java.lang.Object r10 = r10.q(r0, r3, r9)
                if (r10 != r1) goto L_0x009a
            L_0x0099:
                return r1
            L_0x009a:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.X.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f4624a;

        /* renamed from: b  reason: collision with root package name */
        Object f4625b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f4626c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ X f4627d;

        /* renamed from: e  reason: collision with root package name */
        int f4628e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(X x4, C2308e eVar) {
            super(eVar);
            this.f4627d = x4;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4626c = obj;
            this.f4628e |= Integer.MIN_VALUE;
            return this.f4627d.q((String) null, (b) null, this);
        }
    }

    public X(j jVar, Q q5, N n5, a0 a0Var, DataStore dataStore, C1040z zVar, C2312i iVar) {
        t.e(jVar, "sessionsSettings");
        t.e(q5, "sessionGenerator");
        t.e(n5, "sessionFirelogPublisher");
        t.e(a0Var, "timeProvider");
        t.e(dataStore, "sessionDataStore");
        t.e(zVar, "processDataManager");
        t.e(iVar, "backgroundDispatcher");
        this.f4590b = jVar;
        this.f4591c = q5;
        this.f4592d = n5;
        this.f4593e = a0Var;
        this.f4594f = dataStore;
        this.f4595g = zVar;
        this.f4596h = iVar;
        C2908y0 unused = C2876i.d(N.a(iVar), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean n(H h5) {
        Map e5 = h5.e();
        if (e5 != null) {
            boolean b5 = this.f4595g.b(e5);
            if (b5) {
                Log.d("FirebaseSessions", "Cold app start detected");
            }
            return b5;
        }
        Log.d("FirebaseSessions", "No process data map");
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean o(H h5) {
        Map e5 = h5.e();
        if (e5 != null) {
            boolean d5 = this.f4595g.d(e5);
            if (d5) {
                Log.d("FirebaseSessions", "Process " + this.f4595g.c() + " is stale");
            }
            return d5;
        }
        Log.d("FirebaseSessions", "No process data for " + this.f4595g.c());
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean p(H h5) {
        Z d5 = h5.d();
        boolean z4 = false;
        if (d5 != null) {
            if (C2795a.g(this.f4593e.a().c(d5), this.f4590b.b()) > 0) {
                z4 = true;
            }
            if (z4) {
                Log.d("FirebaseSessions", "Session " + h5.f().b() + " is expired");
            }
            return z4;
        }
        Log.d("FirebaseSessions", "Session " + h5.f().b() + " has not backgrounded yet");
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: b1.X$b} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q(java.lang.String r6, b1.X.b r7, b3.C2308e r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof b1.X.f
            if (r0 == 0) goto L_0x0013
            r0 = r8
            b1.X$f r0 = (b1.X.f) r0
            int r1 = r0.f4628e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4628e = r1
            goto L_0x0018
        L_0x0013:
            b1.X$f r0 = new b1.X$f
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f4626c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f4628e
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.f4625b
            r7 = r6
            b1.X$b r7 = (b1.X.b) r7
            java.lang.Object r6 = r0.f4624a
            java.lang.String r6 = (java.lang.String) r6
            W2.u.b(r8)
            goto L_0x005b
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            W2.u.b(r8)
            r5.f4599k = r7
            java.lang.String r8 = r5.f4600l
            boolean r8 = kotlin.jvm.internal.t.a(r8, r6)
            if (r8 == 0) goto L_0x004a
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x004a:
            r5.f4600l = r6
            c1.b r8 = c1.C1045b.f4747a
            r0.f4624a = r6
            r0.f4625b = r7
            r0.f4628e = r3
            java.lang.Object r8 = r8.c(r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            java.util.Map r8 = (java.util.Map) r8
            java.util.Collection r8 = r8.values()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0067:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00cd
            java.lang.Object r0 = r8.next()
            c1.c r0 = (c1.C1046c) r0
            c1.c$b r1 = new c1.c$b
            r1.<init>(r6)
            r0.c(r1)
            int[] r1 = b1.X.c.f4612a
            int r2 = r7.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "Notified "
            if (r1 == r3) goto L_0x00ac
            r4 = 2
            if (r1 != r4) goto L_0x00a6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            c1.c$a r0 = r0.b()
            r1.append(r0)
            java.lang.String r0 = " of new fallback session "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00c7
        L_0x00a6:
            W2.q r6 = new W2.q
            r6.<init>()
            throw r6
        L_0x00ac:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            c1.c$a r0 = r0.b()
            r1.append(r0)
            java.lang.String r0 = " of new session "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00c7:
            java.lang.String r1 = "FirebaseSessions"
            android.util.Log.d(r1, r0)
            goto L_0x0067
        L_0x00cd:
            W2.J r6 = W2.J.f19942a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.X.q(java.lang.String, b1.X$b, b3.e):java.lang.Object");
    }

    public boolean a() {
        return this.f4598j;
    }

    public void b() {
        this.f4598j = false;
        if (this.f4597i == null) {
            Log.d("FirebaseSessions", "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d("FirebaseSessions", "App backgrounded on " + this.f4595g.c());
        C2908y0 unused = C2876i.d(N.a(this.f4596h), (C2312i) null, (O) null, new d(this, (C2308e) null), 3, (Object) null);
    }

    public void c() {
        this.f4598j = true;
        if (this.f4597i == null) {
            Log.d("FirebaseSessions", "App foregrounded, but local SessionData not initialized");
            return;
        }
        H m5 = m();
        Log.d("FirebaseSessions", "App foregrounded on " + this.f4595g.c());
        if (p(m5) || o(m5)) {
            C2908y0 unused = C2876i.d(N.a(this.f4596h), (C2312i) null, (O) null, new e(this, m5, (C2308e) null), 3, (Object) null);
        }
    }

    public final H m() {
        H h5 = this.f4597i;
        if (h5 != null) {
            return h5;
        }
        t.w("localSessionData");
        return null;
    }

    public final void r(H h5) {
        t.e(h5, "<set-?>");
        this.f4597i = h5;
    }
}
