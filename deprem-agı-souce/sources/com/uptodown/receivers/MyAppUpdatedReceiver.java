package com.uptodown.receivers;

import S1.k;
import W2.J;
import W2.u;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.activities.preferences.a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.F;

public final class MyAppUpdatedReceiver extends BroadcastReceiver {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21156a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21157b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f21158c;

        /* renamed from: com.uptodown.receivers.MyAppUpdatedReceiver$a$a  reason: collision with other inner class name */
        static final class C0215a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21159a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f21160b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0215a(BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
                super(2, eVar);
                this.f21160b = pendingResult;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0215a(this.f21160b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21159a == 0) {
                    u.b(obj);
                    this.f21160b.finish();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0215a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
            super(2, eVar);
            this.f21157b = context;
            this.f21158c = pendingResult;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21157b, this.f21158c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2668q b5;
            Object f5 = C2316b.f();
            int i5 = this.f21156a;
            if (i5 == 0) {
                u.b(obj);
                String packageName = this.f21157b.getPackageName();
                C2940B a5 = C2940B.f26458v.a(this.f21157b);
                a5.a();
                t.b(packageName);
                T G02 = a5.G0(packageName);
                if (!(G02 == null || (b5 = G02.b(this.f21157b)) == null)) {
                    b5.g();
                    a5.R(packageName);
                    a5.A(b5);
                }
                a5.t(packageName);
                a5.w1(0);
                a5.y();
                a5.m();
                Bundle bundle = new Bundle();
                bundle.putString("packagename", this.f21157b.getPackageName());
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                bundle.putInt("update", 1);
                new F(this.f21157b).d("install", bundle);
                I0 c5 = C2865c0.c();
                C0215a aVar = new C0215a(this.f21158c, (C2308e) null);
                this.f21156a = 1;
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
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21161a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyAppUpdatedReceiver f21162b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f21163c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f21164d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MyAppUpdatedReceiver myAppUpdatedReceiver, Context context, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
            super(2, eVar);
            this.f21162b = myAppUpdatedReceiver;
            this.f21163c = context;
            this.f21164d = pendingResult;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21162b, this.f21163c, this.f21164d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21161a;
            if (i5 == 0) {
                u.b(obj);
                MyAppUpdatedReceiver myAppUpdatedReceiver = this.f21162b;
                Context context = this.f21163c;
                BroadcastReceiver.PendingResult pendingResult = this.f21164d;
                t.b(pendingResult);
                this.f21161a = 1;
                if (myAppUpdatedReceiver.b(context, pendingResult, this) == f5) {
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

    /* access modifiers changed from: private */
    public final Object b(Context context, BroadcastReceiver.PendingResult pendingResult, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new a(context, pendingResult, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public void onReceive(Context context, Intent intent) {
        t.e(context, "context");
        t.e(intent, "intent");
        Context a5 = k.f32g.a(context);
        if (t.a(intent.getAction(), "android.intent.action.MY_PACKAGE_REPLACED")) {
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            aVar.z0(context, (String) null);
            aVar.Q0(a5, "0");
            aVar.h1(a5, false);
            aVar.m1(a5, false);
            aVar.r1(a5, (String) null);
            z2.M.f26506a.g(a5);
            String j5 = aVar.j(a5);
            if (!s.E(j5, "0", true) && !s.E(j5, "1", true) && !s.E(j5, "2", true)) {
                aVar.D0(a5, "2");
            }
            C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new b(this, a5, goAsync(), (C2308e) null), 3, (Object) null);
        }
    }
}
