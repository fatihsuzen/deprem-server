package m2;

import S1.k;
import W2.J;
import W2.u;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: m2.b  reason: case insensitive filesystem */
public final class C2682b extends BroadcastReceiver {

    /* renamed from: b  reason: collision with root package name */
    public static final a f25257b = new a((C2633k) null);

    /* renamed from: c  reason: collision with root package name */
    private static String f25258c;

    /* renamed from: d  reason: collision with root package name */
    private static long f25259d;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f25260a;

    /* renamed from: m2.b$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: m2.b$b  reason: collision with other inner class name */
    static final class C0255b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25261a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2682b f25262b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25263c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f25264d;

        /* renamed from: m2.b$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f25265a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f25266b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
                super(2, eVar);
                this.f25266b = pendingResult;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f25266b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f25265a == 0) {
                    u.b(obj);
                    this.f25266b.finish();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0255b(C2682b bVar, String str, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
            super(2, eVar);
            this.f25262b = bVar;
            this.f25263c = str;
            this.f25264d = pendingResult;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0255b(this.f25262b, this.f25263c, this.f25264d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
            if (w3.X.b(200, r5) == r0) goto L_0x0106;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            r6 = S1.k.f32g.g();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
            if (r6 == null) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
            if ((r6 instanceof com.uptodown.activities.OldVersionsActivity) == false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007f, code lost:
            ((com.uptodown.activities.OldVersionsActivity) r6).K3(r5.f25263c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
            if ((r6 instanceof com.uptodown.activities.AppDetailActivity) == false) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
            r1 = r5.f25263c;
            r5.f25261a = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
            if (((com.uptodown.activities.AppDetailActivity) r6).v3(r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
            if ((r6 instanceof com.uptodown.activities.MainActivity) == false) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
            r1 = r5.f25263c;
            r5.f25261a = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
            if (((com.uptodown.activities.MainActivity) r6).e8(r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
            if ((r6 instanceof com.uptodown.activities.MyApps) == false) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
            r1 = r5.f25263c;
            r5.f25261a = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bd, code lost:
            if (((com.uptodown.activities.MyApps) r6).k5("app_uninstalled", r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
            if ((r6 instanceof com.uptodown.activities.Updates) == false) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
            r1 = r5.f25263c;
            r5.f25261a = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
            if (((com.uptodown.activities.Updates) r6).D5("app_uninstalled", r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d4, code lost:
            if ((r6 instanceof com.uptodown.activities.FreeUpSpaceActivity) == false) goto L_0x00e4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d6, code lost:
            r1 = r5.f25263c;
            r5.f25261a = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e1, code lost:
            if (((com.uptodown.activities.FreeUpSpaceActivity) r6).r3("app_uninstalled", r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e6, code lost:
            if ((r6 instanceof com.uptodown.activities.SecurityActivity) == false) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e8, code lost:
            ((com.uptodown.activities.SecurityActivity) r6).u5();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
            S1.k.f32g.S((java.lang.String) null);
            r6 = w3.C2865c0.c();
            r1 = new m2.C2682b.C0255b.a(r5.f25264d, (b3.C2308e) null);
            r5.f25261a = 7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0104, code lost:
            if (w3.C2872g.g(r6, r1, r5) != r0) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0106, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0109, code lost:
            return W2.J.f19942a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f25261a
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0020;
                    case 1: goto L_0x001c;
                    case 2: goto L_0x0017;
                    case 3: goto L_0x0017;
                    case 4: goto L_0x0017;
                    case 5: goto L_0x0017;
                    case 6: goto L_0x0017;
                    case 7: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0012:
                W2.u.b(r6)
                goto L_0x0107
            L_0x0017:
                W2.u.b(r6)
                goto L_0x00ed
            L_0x001c:
                W2.u.b(r6)
                goto L_0x0073
            L_0x0020:
                W2.u.b(r6)
                m2.b r6 = r5.f25262b
                android.content.Context r6 = r6.f25260a
                if (r6 == 0) goto L_0x0107
                z2.B$a r6 = z2.C2940B.f26458v
                m2.b r1 = r5.f25262b
                android.content.Context r1 = r1.f25260a
                kotlin.jvm.internal.t.b(r1)
                z2.B r6 = r6.a(r1)
                r6.a()
                java.lang.String r1 = r5.f25263c
                l2.T r1 = r6.G0(r1)
                if (r1 == 0) goto L_0x0053
                m2.b r3 = r5.f25262b
                android.content.Context r3 = r3.f25260a
                kotlin.jvm.internal.t.b(r3)
                l2.q r1 = r1.b(r3)
                goto L_0x0054
            L_0x0053:
                r1 = r2
            L_0x0054:
                if (r1 == 0) goto L_0x0059
                r1.g()
            L_0x0059:
                java.lang.String r1 = r5.f25263c
                r6.R(r1)
                java.lang.String r1 = r5.f25263c
                r6.t(r1)
                r6.m()
                r6 = 1
                r5.f25261a = r6
                r3 = 200(0xc8, double:9.9E-322)
                java.lang.Object r6 = w3.X.b(r3, r5)
                if (r6 != r0) goto L_0x0073
                goto L_0x0106
            L_0x0073:
                S1.k$a r6 = S1.k.f32g
                android.app.Activity r6 = r6.g()
                if (r6 == 0) goto L_0x00ed
                boolean r1 = r6 instanceof com.uptodown.activities.OldVersionsActivity
                if (r1 == 0) goto L_0x0087
                com.uptodown.activities.OldVersionsActivity r6 = (com.uptodown.activities.OldVersionsActivity) r6
                java.lang.String r1 = r5.f25263c
                r6.K3(r1)
                goto L_0x00ed
            L_0x0087:
                boolean r1 = r6 instanceof com.uptodown.activities.AppDetailActivity
                if (r1 == 0) goto L_0x009a
                com.uptodown.activities.AppDetailActivity r6 = (com.uptodown.activities.AppDetailActivity) r6
                java.lang.String r1 = r5.f25263c
                r3 = 2
                r5.f25261a = r3
                java.lang.Object r6 = r6.v3(r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x009a:
                boolean r1 = r6 instanceof com.uptodown.activities.MainActivity
                if (r1 == 0) goto L_0x00ac
                com.uptodown.activities.MainActivity r6 = (com.uptodown.activities.MainActivity) r6
                java.lang.String r1 = r5.f25263c
                r3 = 3
                r5.f25261a = r3
                java.lang.Object r6 = r6.e8(r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00ac:
                boolean r1 = r6 instanceof com.uptodown.activities.MyApps
                java.lang.String r3 = "app_uninstalled"
                if (r1 == 0) goto L_0x00c0
                com.uptodown.activities.MyApps r6 = (com.uptodown.activities.MyApps) r6
                java.lang.String r1 = r5.f25263c
                r4 = 4
                r5.f25261a = r4
                java.lang.Object r6 = r6.k5(r3, r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00c0:
                boolean r1 = r6 instanceof com.uptodown.activities.Updates
                if (r1 == 0) goto L_0x00d2
                com.uptodown.activities.Updates r6 = (com.uptodown.activities.Updates) r6
                java.lang.String r1 = r5.f25263c
                r4 = 5
                r5.f25261a = r4
                java.lang.Object r6 = r6.D5(r3, r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00d2:
                boolean r1 = r6 instanceof com.uptodown.activities.FreeUpSpaceActivity
                if (r1 == 0) goto L_0x00e4
                com.uptodown.activities.FreeUpSpaceActivity r6 = (com.uptodown.activities.FreeUpSpaceActivity) r6
                java.lang.String r1 = r5.f25263c
                r4 = 6
                r5.f25261a = r4
                java.lang.Object r6 = r6.r3(r3, r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00e4:
                boolean r1 = r6 instanceof com.uptodown.activities.SecurityActivity
                if (r1 == 0) goto L_0x00ed
                com.uptodown.activities.SecurityActivity r6 = (com.uptodown.activities.SecurityActivity) r6
                r6.u5()
            L_0x00ed:
                S1.k$a r6 = S1.k.f32g
                r6.S(r2)
                w3.I0 r6 = w3.C2865c0.c()
                m2.b$b$a r1 = new m2.b$b$a
                android.content.BroadcastReceiver$PendingResult r3 = r5.f25264d
                r1.<init>(r3, r2)
                r2 = 7
                r5.f25261a = r2
                java.lang.Object r6 = w3.C2872g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0107
            L_0x0106:
                return r0
            L_0x0107:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: m2.C2682b.C0255b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C0255b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: m2.b$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2682b f25268b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25269c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f25270d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2682b bVar, String str, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
            super(2, eVar);
            this.f25268b = bVar;
            this.f25269c = str;
            this.f25270d = pendingResult;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f25268b, this.f25269c, this.f25270d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f25267a;
            if (i5 == 0) {
                u.b(obj);
                C2682b bVar = this.f25268b;
                String str = this.f25269c;
                BroadcastReceiver.PendingResult pendingResult = this.f25270d;
                t.b(pendingResult);
                this.f25267a = 1;
                if (bVar.c(str, pendingResult, this) == f5) {
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

    /* access modifiers changed from: private */
    public final Object c(String str, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new C0255b(this, str, pendingResult, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data;
        String schemeSpecificPart;
        t.e(context, "context");
        t.e(intent, "intent");
        this.f25260a = k.f32g.a(context);
        String action = intent.getAction();
        if (action != null) {
            boolean z4 = true;
            if (s.E(action, "android.intent.action.PACKAGE_REMOVED", true) && !intent.getBooleanExtra("android.intent.extra.REPLACING", false) && (data = intent.getData()) != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
                String str = action + schemeSpecificPart;
                long currentTimeMillis = System.currentTimeMillis();
                if (s.E(str, f25258c, true) && currentTimeMillis - f25259d <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    z4 = false;
                }
                f25259d = currentTimeMillis;
                f25258c = str;
                if (z4) {
                    C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new c(this, schemeSpecificPart, goAsync(), (C2308e) null), 3, (Object) null);
                }
            }
        }
    }
}
