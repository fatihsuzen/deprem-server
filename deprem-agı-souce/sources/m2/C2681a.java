package m2;

import S1.k;
import W2.J;
import W2.u;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.UptodownApp;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2641A;
import l2.C2643C;
import l2.C2655d;
import l2.C2661j;
import l2.C2668q;
import l2.C2669s;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.C2962v;
import z2.E;
import z2.F;
import z2.G;
import z2.X;

/* renamed from: m2.a  reason: case insensitive filesystem */
public final class C2681a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final C0253a f25242a = new C0253a((C2633k) null);

    /* renamed from: b  reason: collision with root package name */
    private static String f25243b;

    /* renamed from: c  reason: collision with root package name */
    private static long f25244c;

    /* renamed from: m2.a$a  reason: collision with other inner class name */
    public static final class C0253a {
        public /* synthetic */ C0253a(C2633k kVar) {
            this();
        }

        private C0253a() {
        }
    }

    /* renamed from: m2.a$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25245a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f25246b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25247c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2681a f25248d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f25249e;

        /* renamed from: m2.a$b$a  reason: collision with other inner class name */
        static final class C0254a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f25250a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f25251b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0254a(BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
                super(2, eVar);
                this.f25251b = pendingResult;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0254a(this.f25251b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f25250a == 0) {
                    u.b(obj);
                    this.f25251b.finish();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0254a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, String str, C2681a aVar, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
            super(2, eVar);
            this.f25246b = context;
            this.f25247c = str;
            this.f25248d = aVar;
            this.f25249e = pendingResult;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f25246b, this.f25247c, this.f25248d, this.f25249e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            if (r10.P0(r1, false, r9) == r0) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
            if (w3.C2872g.g(r10, r1, r9) == r0) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0090, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f25245a
                r2 = 0
                r3 = 0
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0021
                if (r1 == r5) goto L_0x001d
                if (r1 != r4) goto L_0x0015
                W2.u.b(r10)
                goto L_0x0091
            L_0x0015:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001d:
                W2.u.b(r10)
                goto L_0x0076
            L_0x0021:
                W2.u.b(r10)
                z2.m r10 = new z2.m
                r10.<init>()
                android.content.Context r1 = r9.f25246b
                java.lang.String r6 = r9.f25247c
                java.lang.String r10 = r10.h(r1, r6)
                android.content.Context r1 = r9.f25246b
                java.lang.String r1 = r1.getPackageName()
                boolean r1 = t3.s.E(r1, r10, r5)
                if (r1 != 0) goto L_0x0053
                if (r10 != 0) goto L_0x0053
                S1.k$a r10 = S1.k.f32g
                Y1.a r10 = r10.i()
                if (r10 == 0) goto L_0x004c
                java.lang.String r10 = r10.b()
                goto L_0x004d
            L_0x004c:
                r10 = r3
            L_0x004d:
                java.lang.String r1 = r9.f25247c
                boolean r1 = t3.s.E(r10, r1, r5)
            L_0x0053:
                z2.m r10 = new z2.m
                r10.<init>()
                android.content.Context r6 = r9.f25246b
                java.lang.String r7 = r9.f25247c
                l2.d r10 = r10.C(r6, r7)
                m2.a r6 = r9.f25248d
                java.lang.String r7 = r9.f25247c
                android.content.Context r8 = r9.f25246b
                r6.e(r1, r10, r7, r8)
                com.uptodown.UptodownApp$a r10 = com.uptodown.UptodownApp.f13477F
                java.lang.String r1 = r9.f25247c
                r9.f25245a = r5
                java.lang.Object r10 = r10.P0(r1, r2, r9)
                if (r10 != r0) goto L_0x0076
                goto L_0x0090
            L_0x0076:
                com.uptodown.UptodownApp$a r10 = com.uptodown.UptodownApp.f13477F
                android.content.Context r1 = r9.f25246b
                com.uptodown.UptodownApp.a.O0(r10, r1, r2, r4, r3)
                w3.I0 r10 = w3.C2865c0.c()
                m2.a$b$a r1 = new m2.a$b$a
                android.content.BroadcastReceiver$PendingResult r2 = r9.f25249e
                r1.<init>(r2, r3)
                r9.f25245a = r4
                java.lang.Object r10 = w3.C2872g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0091
            L_0x0090:
                return r0
            L_0x0091:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: m2.C2681a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: m2.a$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25252a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2681a f25253b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25254c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f25255d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f25256e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2681a aVar, String str, BroadcastReceiver.PendingResult pendingResult, Context context, C2308e eVar) {
            super(2, eVar);
            this.f25253b = aVar;
            this.f25254c = str;
            this.f25255d = pendingResult;
            this.f25256e = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f25253b, this.f25254c, this.f25255d, this.f25256e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f25252a;
            if (i5 == 0) {
                u.b(obj);
                C2681a aVar = this.f25253b;
                String str = this.f25254c;
                BroadcastReceiver.PendingResult pendingResult = this.f25255d;
                t.b(pendingResult);
                Context context = this.f25256e;
                this.f25252a = 1;
                if (aVar.c(str, pendingResult, context, this) == f5) {
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
    public final Object c(String str, BroadcastReceiver.PendingResult pendingResult, Context context, C2308e eVar) {
        Context context2 = context;
        Object g5 = C2872g.g(C2865c0.b(), new b(context2, str, this, pendingResult, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void d(Context context, String str, Bundle bundle) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.m() != null) {
            C2661j m5 = aVar.m();
            t.b(m5);
            String k5 = new E().k(m5.c());
            if (k5 != null && s.E(k5, str, true)) {
                bundle.putString("source", "deeplink");
                aVar.u0((C2661j) null);
                new C2962v().h(context, str, k5);
                return;
            }
            return;
        }
        C2641A b5 = C2641A.f24721f.b(context);
        if (b5 != null && s.E(b5.d(), str, true)) {
            bundle.putString("source", "notification_fcm");
        }
    }

    /* access modifiers changed from: private */
    public final void e(boolean z4, C2655d dVar, String str, Context context) {
        Long l5;
        long j5;
        if (z4) {
            Bundle bundle = new Bundle();
            bundle.putString("packagename", str);
            d(context, str, bundle);
            C2643C.f24734j.b(context, dVar, bundle);
            if (dVar != null) {
                l5 = Long.valueOf(dVar.A());
            } else {
                l5 = null;
            }
            if (l5 != null) {
                C2940B a5 = C2940B.f26458v.a(context);
                a5.a();
                C2668q k02 = a5.k0(str, dVar.A());
                if (k02 == null || k02.o().isEmpty()) {
                    j5 = 0;
                } else {
                    if (k02.h() > 0) {
                        C2669s o02 = a5.o0(k02.h());
                        if (o02 != null) {
                            o02.d(context, "installationFinished");
                        }
                        if (o02 != null) {
                            o02.g(context);
                        }
                    }
                    j5 = k02.z();
                    a5.A(k02);
                    k02.g();
                }
                a5.m();
            } else {
                j5 = 0;
            }
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
            bundle.putInt("update", 0);
            if (j5 > 0) {
                bundle.putString("size", G.f26487a.e(j5));
            }
            new F(context).d("install", bundle);
            z2.M.f26506a.m(context, str);
            new X().g(context);
        }
    }

    public void onReceive(Context context, Intent intent) {
        Uri data;
        t.e(context, "context");
        t.e(intent, "intent");
        Context a5 = k.f32g.a(context);
        String action = intent.getAction();
        if (action != null) {
            boolean z4 = true;
            if (s.E(action, "android.intent.action.PACKAGE_ADDED", true) && (data = intent.getData()) != null) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (schemeSpecificPart != null && !booleanExtra) {
                    String str = action + schemeSpecificPart;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (s.E(str, f25243b, true) && currentTimeMillis - f25244c <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        z4 = false;
                    }
                    f25244c = currentTimeMillis;
                    f25243b = str;
                    if (z4) {
                        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new c(this, schemeSpecificPart, goAsync(), a5, (C2308e) null), 3, (Object) null);
                    }
                }
            }
        }
    }
}
