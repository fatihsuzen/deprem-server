package com.uptodown.gcm;

import S1.k;
import W2.J;
import W2.u;
import android.app.Activity;
import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.preferences.a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2641A;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.N;
import w3.O;

public final class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: h  reason: collision with root package name */
    public static final a f21134h = new a((C2633k) null);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final boolean a(String str) {
            if (str == null || !s.E(str, "campaign", true)) {
                return false;
            }
            return true;
        }

        public final boolean b(String str) {
            if (str == null || !s.E(str, "notificationApp", true)) {
                return false;
            }
            return true;
        }

        public final boolean c(String str) {
            if (str == null || !s.E(str, "remoteInstall", true)) {
                return false;
            }
            return true;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21135a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyFirebaseMessagingService f21136b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21137c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21138d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f21139e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f21140f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MyFirebaseMessagingService myFirebaseMessagingService, String str, String str2, long j5, String str3, C2308e eVar) {
            super(2, eVar);
            this.f21136b = myFirebaseMessagingService;
            this.f21137c = str;
            this.f21138d = str2;
            this.f21139e = j5;
            this.f21140f = str3;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21136b, this.f21137c, this.f21138d, this.f21139e, this.f21140f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21135a;
            if (i5 == 0) {
                u.b(obj);
                MyFirebaseMessagingService myFirebaseMessagingService = this.f21136b;
                String str = this.f21137c;
                String str2 = this.f21138d;
                long j5 = this.f21139e;
                String str3 = this.f21140f;
                this.f21135a = 1;
                if (myFirebaseMessagingService.w(str, str2, j5, str3, this) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21141a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f21142b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21143c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MyFirebaseMessagingService f21144d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f21145e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f21146f;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21147a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f21148b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f21149c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f21150d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, String str2, long j5, C2308e eVar) {
                super(2, eVar);
                this.f21148b = str;
                this.f21149c = str2;
                this.f21150d = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21148b, this.f21149c, this.f21150d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21147a == 0) {
                    u.b(obj);
                    Activity g5 = k.f32g.g();
                    if (g5 != null && (g5 instanceof C1598a)) {
                        ((C1598a) g5).c2(this.f21148b, this.f21149c, this.f21150d);
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
        c(long j5, String str, MyFirebaseMessagingService myFirebaseMessagingService, String str2, String str3, C2308e eVar) {
            super(2, eVar);
            this.f21142b = j5;
            this.f21143c = str;
            this.f21144d = myFirebaseMessagingService;
            this.f21145e = str2;
            this.f21146f = str3;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21142b, this.f21143c, this.f21144d, this.f21145e, this.f21146f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21141a;
            if (i5 == 0) {
                u.b(obj);
                C2641A a5 = new C2641A();
                a5.j(this.f21142b);
                a5.m(this.f21143c);
                Context applicationContext = this.f21144d.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                a5.n(applicationContext);
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21145e, this.f21146f, this.f21142b, (C2308e) null);
                this.f21141a = 1;
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21151a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f21152b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21153c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21154d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Activity activity, String str, String str2, C2308e eVar) {
            super(2, eVar);
            this.f21152b = activity;
            this.f21153c = str;
            this.f21154d = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21152b, this.f21153c, this.f21154d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21151a == 0) {
                u.b(obj);
                ((C1598a) this.f21152b).e2(this.f21153c, this.f21154d);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    private final void v(String str, String str2, long j5, String str3) {
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new b(this, str, str2, j5, str3, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object w(String str, String str2, long j5, String str3, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(j5, str3, this, str, str2, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(com.google.firebase.messaging.S r14) {
        /*
            r13 = this;
            java.lang.String r0 = "remoteMessage"
            kotlin.jvm.internal.t.e(r14, r0)
            java.util.Map r0 = r14.c()
            java.lang.String r1 = "getData(...)"
            kotlin.jvm.internal.t.d(r0, r1)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x01f7
            java.util.Map r0 = r14.c()
            java.lang.String r1 = "action"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            com.uptodown.gcm.MyFirebaseMessagingService$a r1 = f21134h
            boolean r2 = r1.b(r0)
            r3 = 0
            if (r2 == 0) goto L_0x0087
            java.util.Map r0 = r14.c()
            java.lang.String r1 = "appId"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0042
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x003e }
        L_0x003c:
            r8 = r0
            goto L_0x0045
        L_0x003e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0042:
            r0 = -1
            goto L_0x003c
        L_0x0045:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x01f7
            java.util.Map r0 = r14.c()
            java.lang.String r1 = "packageName"
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            z2.m r0 = new z2.m
            r0.<init>()
            android.content.Context r1 = r13.getApplicationContext()
            boolean r0 = r0.v(r10, r1)
            if (r0 != 0) goto L_0x01f7
            com.google.firebase.messaging.S$b r0 = r14.d()
            if (r0 == 0) goto L_0x01f7
            com.google.firebase.messaging.S$b r0 = r14.d()
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r7 = r0.a()
            com.google.firebase.messaging.S$b r14 = r14.d()
            kotlin.jvm.internal.t.b(r14)
            java.lang.String r6 = r14.c()
            r5 = r13
            r5.v(r6, r7, r8, r10)
            goto L_0x01f7
        L_0x0087:
            boolean r2 = r1.a(r0)
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x00e0
            java.util.Map r0 = r14.c()
            java.lang.String r1 = "campaign"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "BlackFriday"
            boolean r0 = t3.s.E(r0, r1, r5)
            if (r0 == 0) goto L_0x01f7
            com.google.firebase.messaging.S$b r0 = r14.d()
            if (r0 == 0) goto L_0x01f7
            com.google.firebase.messaging.S$b r0 = r14.d()
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.a()
            com.google.firebase.messaging.S$b r14 = r14.d()
            kotlin.jvm.internal.t.b(r14)
            java.lang.String r14 = r14.c()
            S1.k$a r1 = S1.k.f32g
            android.app.Activity r1 = r1.g()
            if (r1 == 0) goto L_0x01f7
            boolean r2 = r1 instanceof com.uptodown.activities.C1598a
            if (r2 == 0) goto L_0x01f7
            w3.I0 r2 = w3.C2865c0.c()
            w3.M r7 = w3.N.a(r2)
            com.uptodown.gcm.MyFirebaseMessagingService$d r10 = new com.uptodown.gcm.MyFirebaseMessagingService$d
            r10.<init>(r1, r14, r0, r6)
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            w3.C2908y0 unused = w3.C2876i.d(r7, r8, r9, r10, r11, r12)
            return
        L_0x00e0:
            boolean r0 = r1.c(r0)
            if (r0 == 0) goto L_0x01f7
            l2.V$b r0 = l2.V.f24870q
            android.content.Context r1 = r13.getApplicationContext()
            java.lang.String r2 = "getApplicationContext(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            l2.V r0 = r0.h(r1)
            if (r0 == 0) goto L_0x01f7
            java.util.Map r0 = r14.c()
            java.lang.String r1 = "remoteInstall.appId"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.util.Map r14 = r14.c()
            java.lang.String r1 = "remoteInstall.sourceDevice"
            java.lang.Object r14 = r14.get(r1)
            java.lang.String r14 = (java.lang.String) r14
            if (r0 == 0) goto L_0x0116
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0116 }
            goto L_0x0117
        L_0x0116:
            r0 = r3
        L_0x0117:
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x01f7
            l2.J r3 = new l2.J
            r3.<init>()
            r3.f(r0)
            r3.h(r14)
            z2.B$a r14 = z2.C2940B.f26458v
            android.content.Context r0 = r13.getApplicationContext()
            kotlin.jvm.internal.t.d(r0, r2)
            z2.B r14 = r14.a(r0)
            r14.a()
            long r0 = r3.a()
            java.util.ArrayList r0 = r14.E0(r0)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x014b
            long r0 = r3.a()
            r14.M(r0)
        L_0x014b:
            r14.a1(r3)
            r14.m()
            z2.Z r0 = new z2.Z
            android.content.Context r1 = r13.getApplicationContext()
            kotlin.jvm.internal.t.d(r1, r2)
            r0.<init>(r1)
            long r7 = r3.a()
            l2.M r0 = r0.X(r7)
            boolean r1 = r0.b()
            if (r1 != 0) goto L_0x01dd
            java.lang.String r1 = r0.d()
            if (r1 == 0) goto L_0x01d6
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0178
            goto L_0x01d6
        L_0x0178:
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r0 = r0.d()
            kotlin.jvm.internal.t.b(r0)
            r1.<init>(r0)
            java.lang.String r0 = "success"
            int r0 = r1.optInt(r0)
            java.lang.String r4 = "data"
            org.json.JSONObject r1 = r1.optJSONObject(r4)
            if (r0 != r5) goto L_0x01dd
            if (r1 == 0) goto L_0x01dd
            l2.f r0 = new l2.f
            r0.<init>()
            r4 = 2
            l2.C2657f.b(r0, r1, r6, r4, r6)
            l2.q r1 = new l2.q
            r1.<init>()
            r1.c(r0)
            android.content.Context r0 = r13.getApplicationContext()
            kotlin.jvm.internal.t.d(r0, r2)
            int r0 = r1.S(r0)
            r3.g(r0)
            r14.H1(r3)
            int r14 = r3.b()
            r0 = -1
            if (r14 == r0) goto L_0x01dd
            z2.H r14 = z2.H.f26488a
            boolean r14 = r14.d()
            if (r14 == 0) goto L_0x01dd
            com.uptodown.workers.DownloadApkWorker$a r14 = com.uptodown.workers.DownloadApkWorker.f21342i
            android.content.Context r0 = r13.getApplicationContext()
            kotlin.jvm.internal.t.d(r0, r2)
            int r1 = r3.b()
            r14.b(r0, r1)
            goto L_0x01dd
        L_0x01d6:
            long r0 = r3.a()
            r14.M(r0)
        L_0x01dd:
            z2.F r14 = new z2.F
            android.content.Context r0 = r13.getApplicationContext()
            r14.<init>(r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "type"
            java.lang.String r2 = "fcm_received"
            r0.putString(r1, r2)
            java.lang.String r1 = "remote_install"
            r14.d(r1, r0)
        L_0x01f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.gcm.MyFirebaseMessagingService.p(com.google.firebase.messaging.S):void");
    }

    public void r(String str) {
        t.e(str, "token");
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        aVar.F0(applicationContext, str);
        Context applicationContext2 = getApplicationContext();
        t.d(applicationContext2, "getApplicationContext(...)");
        aVar.G0(applicationContext2, false);
        Context applicationContext3 = getApplicationContext();
        t.d(applicationContext3, "getApplicationContext(...)");
        new g2.s(applicationContext3, str);
    }
}
