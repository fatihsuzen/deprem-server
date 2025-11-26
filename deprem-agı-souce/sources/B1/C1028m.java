package b1;

import W2.J;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import b3.C2308e;
import b3.C2312i;
import e1.j;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import o0.f;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: b1.m  reason: case insensitive filesystem */
public final class C1028m {

    /* renamed from: c  reason: collision with root package name */
    public static final b f4712c = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f4713a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final j f4714b;

    /* renamed from: b1.m$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4715a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1028m f4716b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ U f4717c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1028m mVar, U u5, C2308e eVar) {
            super(2, eVar);
            this.f4716b = mVar;
            this.f4717c = u5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f4716b, this.f4717c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
            if (r6.f(r5) == r0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if (r6 == r0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f4715a
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r4) goto L_0x001c
                if (r1 != r3) goto L_0x0014
                W2.u.b(r6)
                goto L_0x0069
            L_0x0014:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001c:
                W2.u.b(r6)
                goto L_0x002e
            L_0x0020:
                W2.u.b(r6)
                c1.b r6 = c1.C1045b.f4747a
                r5.f4715a = r4
                java.lang.Object r6 = r6.c(r5)
                if (r6 != r0) goto L_0x002e
                goto L_0x0068
            L_0x002e:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                boolean r1 = r6 instanceof java.util.Collection
                if (r1 == 0) goto L_0x0044
                r1 = r6
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x0044
                goto L_0x0092
            L_0x0044:
                java.util.Iterator r6 = r6.iterator()
            L_0x0048:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0092
                java.lang.Object r1 = r6.next()
                c1.c r1 = (c1.C1046c) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L_0x0048
                b1.m r6 = r5.f4716b
                e1.j r6 = r6.f4714b
                r5.f4715a = r3
                java.lang.Object r6 = r6.f(r5)
                if (r6 != r0) goto L_0x0069
            L_0x0068:
                return r0
            L_0x0069:
                b1.m r6 = r5.f4716b
                e1.j r6 = r6.f4714b
                boolean r6 = r6.c()
                if (r6 != 0) goto L_0x007f
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                kotlin.coroutines.jvm.internal.b.b(r6)
                goto L_0x009b
            L_0x007f:
                b1.m r6 = r5.f4716b
                o0.f r6 = r6.f4713a
                b1.U r0 = r5.f4717c
                b1.l r1 = new b1.l
                r1.<init>(r0)
                r6.h(r1)
                W2.J r6 = W2.J.f19942a
                goto L_0x009b
            L_0x0092:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                kotlin.coroutines.jvm.internal.b.b(r6)
            L_0x009b:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.C1028m.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b1.m$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    public C1028m(f fVar, j jVar, C2312i iVar, U u5) {
        t.e(fVar, "firebaseApp");
        t.e(jVar, "settings");
        t.e(iVar, "backgroundDispatcher");
        t.e(u5, "sessionsActivityLifecycleCallbacks");
        this.f4713a = fVar;
        this.f4714b = jVar;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions 3.0.3.");
        Context applicationContext = fVar.k().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(u5);
            C2908y0 unused = C2876i.d(N.a(iVar), (C2312i) null, (O) null, new a(this, u5, (C2308e) null), 3, (Object) null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }
}
