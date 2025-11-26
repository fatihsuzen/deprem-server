package m2;

import S1.k;
import W2.J;
import W2.u;
import Y1.C2257a;
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
import l2.C2653b;
import l2.C2655d;
import l2.C2661j;
import l2.C2668q;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.E;
import z2.F;
import z2.G;
import z2.M;
import z2.X;

/* renamed from: m2.c  reason: case insensitive filesystem */
public final class C2683c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25271a = new a((C2633k) null);

    /* renamed from: b  reason: collision with root package name */
    private static String f25272b;

    /* renamed from: c  reason: collision with root package name */
    private static long f25273c;

    /* renamed from: m2.c$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: m2.c$b */
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f25274a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f25275b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2683c f25276c;

        /* renamed from: d  reason: collision with root package name */
        int f25277d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2683c cVar, C2308e eVar) {
            super(eVar);
            this.f25276c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f25275b = obj;
            this.f25277d |= Integer.MIN_VALUE;
            return this.f25276c.c((String) null, (BroadcastReceiver.PendingResult) null, (Context) null, this);
        }
    }

    /* renamed from: m2.c$c  reason: collision with other inner class name */
    static final class C0256c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25278a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f25279b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25280c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2683c f25281d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0256c(Context context, String str, C2683c cVar, C2308e eVar) {
            super(2, eVar);
            this.f25279b = context;
            this.f25280c = str;
            this.f25281d = cVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0256c(this.f25279b, this.f25280c, this.f25281d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            long j5;
            String str;
            C2668q b5;
            Object f5 = C2316b.f();
            int i5 = this.f25278a;
            if (i5 == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f25279b);
                a5.a();
                T G02 = a5.G0(this.f25280c);
                if (G02 == null || (b5 = G02.b(this.f25279b)) == null) {
                    j5 = 0;
                } else {
                    j5 = b5.z();
                    b5.g();
                    a5.R(this.f25280c);
                    a5.A(b5);
                }
                long j6 = j5;
                a5.m();
                String h5 = new C2954m().h(this.f25279b, this.f25280c);
                boolean E4 = s.E(this.f25279b.getPackageName(), h5, true);
                if (!E4 && h5 == null) {
                    C2257a i6 = k.f32g.i();
                    if (i6 != null) {
                        str = i6.b();
                    } else {
                        str = null;
                    }
                    E4 = s.E(str, this.f25280c, true);
                }
                C2655d C4 = new C2954m().C(this.f25279b, this.f25280c);
                if (E4) {
                    this.f25281d.e(C4, this.f25280c, this.f25279b, j6);
                } else {
                    kotlin.coroutines.jvm.internal.b.a(UptodownApp.a.O0(UptodownApp.f13477F, this.f25279b, false, 2, (Object) null));
                }
                UptodownApp.a aVar = UptodownApp.f13477F;
                String str2 = this.f25280c;
                this.f25278a = 1;
                if (aVar.P0(str2, true, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            M.f26506a.f(this.f25279b);
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C0256c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: m2.c$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f25283b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
            super(2, eVar);
            this.f25283b = pendingResult;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f25283b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f25282a == 0) {
                u.b(obj);
                this.f25283b.finish();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: m2.c$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25284a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2683c f25285b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25286c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f25287d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f25288e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2683c cVar, String str, BroadcastReceiver.PendingResult pendingResult, Context context, C2308e eVar) {
            super(2, eVar);
            this.f25285b = cVar;
            this.f25286c = str;
            this.f25287d = pendingResult;
            this.f25288e = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f25285b, this.f25286c, this.f25287d, this.f25288e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f25284a;
            if (i5 == 0) {
                u.b(obj);
                C2683c cVar = this.f25285b;
                String str = this.f25286c;
                BroadcastReceiver.PendingResult pendingResult = this.f25287d;
                t.b(pendingResult);
                Context context = this.f25288e;
                this.f25284a = 1;
                if (cVar.c(str, pendingResult, context, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.content.BroadcastReceiver$PendingResult} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (w3.C2872g.g(r10, r2, r0) == r1) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (w3.C2872g.g(r7, r9, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        return r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(java.lang.String r7, android.content.BroadcastReceiver.PendingResult r8, android.content.Context r9, b3.C2308e r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof m2.C2683c.b
            if (r0 == 0) goto L_0x0013
            r0 = r10
            m2.c$b r0 = (m2.C2683c.b) r0
            int r1 = r0.f25277d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25277d = r1
            goto L_0x0018
        L_0x0013:
            m2.c$b r0 = new m2.c$b
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f25275b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25277d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r10)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.f25274a
            r8 = r7
            android.content.BroadcastReceiver$PendingResult r8 = (android.content.BroadcastReceiver.PendingResult) r8
            W2.u.b(r10)
            goto L_0x0055
        L_0x003e:
            W2.u.b(r10)
            w3.I r10 = w3.C2865c0.b()
            m2.c$c r2 = new m2.c$c
            r2.<init>(r9, r7, r6, r5)
            r0.f25274a = r8
            r0.f25277d = r4
            java.lang.Object r7 = w3.C2872g.g(r10, r2, r0)
            if (r7 != r1) goto L_0x0055
            goto L_0x0068
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            m2.c$d r9 = new m2.c$d
            r9.<init>(r8, r5)
            r0.f25274a = r5
            r0.f25277d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r9, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.C2683c.c(java.lang.String, android.content.BroadcastReceiver$PendingResult, android.content.Context, b3.e):java.lang.Object");
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
    public final void e(C2655d dVar, String str, Context context, long j5) {
        Bundle bundle = new Bundle();
        bundle.putString("packagename", str);
        d(context, str, bundle);
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
        bundle.putInt("update", 1);
        if (j5 > 0) {
            bundle.putString("size", G.f26487a.e(j5));
        }
        new F(context).d("install", bundle);
        f(context, dVar);
        new X().h(context);
    }

    private final void f(Context context, C2655d dVar) {
        if (dVar != null) {
            C2653b bVar = new C2653b();
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            bVar.k(dVar, a5);
            a5.m();
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
            if (s.E(action, "android.intent.action.PACKAGE_REPLACED", true) && (data = intent.getData()) != null) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (schemeSpecificPart != null && booleanExtra) {
                    String str = action + schemeSpecificPart;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (s.E(str, f25272b, true) && currentTimeMillis - f25273c <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        z4 = false;
                    }
                    f25273c = currentTimeMillis;
                    f25272b = str;
                    if (z4) {
                        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new e(this, schemeSpecificPart, goAsync(), a5, (C2308e) null), 3, (Object) null);
                    }
                }
            }
        }
    }
}
