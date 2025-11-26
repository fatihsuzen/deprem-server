package e1;

import W2.C2218g;
import W2.J;
import W2.u;
import androidx.datastore.core.DataStore;
import b1.a0;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicReference;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2623a;
import kotlin.jvm.internal.C2636n;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z3.C2972e;
import z3.C2973f;
import z3.C2974g;

public final class m implements l {

    /* renamed from: a  reason: collision with root package name */
    private final C2312i f15283a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f15284b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final DataStore f15285c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f15286d = new AtomicReference();

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f15288b;

        /* renamed from: e1.m$a$a  reason: collision with other inner class name */
        /* synthetic */ class C0150a implements C2973f, C2636n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AtomicReference f15289a;

            C0150a(AtomicReference atomicReference) {
                this.f15289a = atomicReference;
            }

            /* renamed from: b */
            public final Object emit(h hVar, C2308e eVar) {
                Object b5 = this.f15289a.set(hVar);
                if (b5 == C2316b.f()) {
                    return b5;
                }
                return J.f19942a;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof C2973f) || !(obj instanceof C2636n)) {
                    return false;
                }
                return t.a(getFunctionDelegate(), ((C2636n) obj).getFunctionDelegate());
            }

            public final C2218g getFunctionDelegate() {
                return new C2623a(2, this.f15289a, AtomicReference.class, "set", "set(Ljava/lang/Object;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m mVar, C2308e eVar) {
            super(2, eVar);
            this.f15288b = mVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f15288b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f15287a;
            if (i5 == 0) {
                u.b(obj);
                C2972e data = this.f15288b.f15285c.getData();
                C0150a aVar = new C0150a(this.f15288b.f15286d);
                this.f15287a = 1;
                if (data.collect(aVar, this) == f5) {
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
        int f15290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f15291b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar, C2308e eVar) {
            super(2, eVar);
            this.f15291b = mVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15291b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f15290a;
            if (i5 == 0) {
                u.b(obj);
                C2972e data = this.f15291b.f15285c.getData();
                this.f15290a = 1;
                Object o5 = C2974g.o(data, this);
                if (o5 == f5) {
                    return f5;
                }
                return o5;
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

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f15292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f15293b;

        /* renamed from: c  reason: collision with root package name */
        int f15294c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(m mVar, C2308e eVar) {
            super(eVar);
            this.f15293b = mVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f15292a = obj;
            this.f15294c |= Integer.MIN_VALUE;
            return this.f15293b.c((h) null, this);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15295a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f15296b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar, C2308e eVar) {
            super(2, eVar);
            this.f15296b = hVar;
        }

        /* renamed from: b */
        public final Object invoke(h hVar, C2308e eVar) {
            return ((d) create(hVar, eVar)).invokeSuspend(J.f19942a);
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f15296b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15295a == 0) {
                u.b(obj);
                return this.f15296b;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public m(C2312i iVar, a0 a0Var, DataStore dataStore) {
        t.e(iVar, "backgroundDispatcher");
        t.e(a0Var, "timeProvider");
        t.e(dataStore, "sessionConfigsDataStore");
        this.f15283a = iVar;
        this.f15284b = a0Var;
        this.f15285c = dataStore;
        C2908y0 unused = C2876i.d(N.a(iVar), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    private final h h() {
        if (this.f15286d.get() == null) {
            androidx.lifecycle.a.a(this.f15286d, (Object) null, C2874h.b((C2312i) null, new b(this, (C2308e) null), 1, (Object) null));
        }
        Object obj = this.f15286d.get();
        t.d(obj, "get(...)");
        return (h) obj;
    }

    public Double a() {
        return h().c();
    }

    public Integer b() {
        return h().d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(e1.h r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof e1.m.c
            if (r0 == 0) goto L_0x0013
            r0 = r7
            e1.m$c r0 = (e1.m.c) r0
            int r1 = r0.f15294c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f15294c = r1
            goto L_0x0018
        L_0x0013:
            e1.m$c r0 = new e1.m$c
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f15292a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f15294c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            W2.u.b(r7)     // Catch:{ IOException -> 0x0029 }
            goto L_0x005d
        L_0x0029:
            r6 = move-exception
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            W2.u.b(r7)
            androidx.datastore.core.DataStore r7 = r5.f15285c     // Catch:{ IOException -> 0x0029 }
            e1.m$d r2 = new e1.m$d     // Catch:{ IOException -> 0x0029 }
            r4 = 0
            r2.<init>(r6, r4)     // Catch:{ IOException -> 0x0029 }
            r0.f15294c = r3     // Catch:{ IOException -> 0x0029 }
            java.lang.Object r6 = r7.updateData(r2, r0)     // Catch:{ IOException -> 0x0029 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x0047:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Failed to update config values: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L_0x005d:
            W2.J r6 = W2.J.f19942a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.c(e1.h, b3.e):java.lang.Object");
    }

    public boolean d() {
        Long b5 = h().b();
        Integer a5 = h().a();
        if (b5 == null || a5 == null || this.f15284b.a().a() - b5.longValue() >= ((long) a5.intValue())) {
            return true;
        }
        return false;
    }

    public Boolean e() {
        return h().e();
    }
}
