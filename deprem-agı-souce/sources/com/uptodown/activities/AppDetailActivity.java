package com.uptodown.activities;

import O1.C0744b;
import O1.C0753c;
import W2.J;
import W2.u;
import X2.C2250q;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.GetUserDataWorker;
import i2.C2497h;
import i2.C2540v1;
import i2.f2;
import java.util.ArrayList;
import java.util.List;
import k2.P;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2654c;
import l2.C2657f;
import l2.C2660i;
import l2.C2668q;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;

public final class AppDetailActivity extends C1598a {

    /* renamed from: Q  reason: collision with root package name */
    public static final a f13552Q = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private C2660i f13553K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public ArrayList f13554L = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public ArrayList f13555M = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public ArrayList f13556N = new ArrayList();

    /* renamed from: O  reason: collision with root package name */
    private final ActivityResultLauncher f13557O;

    /* renamed from: P  reason: collision with root package name */
    private final e f13558P;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f13559a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13560b;

        public b(int i5, String str) {
            this.f13559a = i5;
            this.f13560b = str;
        }

        public void run() {
            C2540v1 k32;
            if (this.f13560b != null && (k32 = AppDetailActivity.this.p3()) != null && k32.isResumed() && s.F(k32.a4().S(), this.f13560b, false, 2, (Object) null)) {
                C2940B.a aVar = C2940B.f26458v;
                Context baseContext = AppDetailActivity.this.getBaseContext();
                t.d(baseContext, "getBaseContext(...)");
                C2940B a5 = aVar.a(baseContext);
                a5.a();
                T G02 = a5.G0(this.f13560b);
                a5.m();
                if (G02 != null) {
                    AppDetailActivity.this.runOnUiThread(new C2540v1.C2542b(this.f13559a, G02));
                }
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f13562a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13563b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f13564c;

        public c(AppDetailActivity appDetailActivity, String str, int i5) {
            t.e(str, "packagename");
            this.f13564c = appDetailActivity;
            this.f13562a = str;
            this.f13563b = i5;
        }

        public void run() {
            List<Fragment> fragments = this.f13564c.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            Fragment fragment = (Fragment) C2250q.X(fragments);
            if (fragment != null && (fragment instanceof C2540v1)) {
                new C2540v1.C2543c((C2540v1) fragment, this.f13562a, this.f13563b);
            }
        }
    }

    public final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f13565a;

        /* renamed from: b  reason: collision with root package name */
        private final C2668q f13566b;

        public d(int i5, C2668q qVar) {
            this.f13565a = i5;
            this.f13566b = qVar;
        }

        public void run() {
            D2.g q22;
            String str;
            C2540v1 k32 = AppDetailActivity.this.p3();
            if (k32 != null && k32.isResumed()) {
                AppDetailActivity.this.runOnUiThread(new C2540v1.C2544d(this.f13565a, this.f13566b));
            }
            String str2 = null;
            if (AppDetailActivity.this.q3() != null) {
                f2 l32 = AppDetailActivity.this.q3();
                t.b(l32);
                C2668q qVar = this.f13566b;
                if (qVar != null) {
                    str = qVar.w();
                } else {
                    str = null;
                }
                l32.b0(str);
            }
            if (AppDetailActivity.this.o3() != null) {
                C2497h j32 = AppDetailActivity.this.o3();
                t.b(j32);
                C2668q qVar2 = this.f13566b;
                if (qVar2 != null) {
                    str2 = qVar2.w();
                }
                j32.t(str2);
            }
            if (this.f13566b != null && (q22 = AppDetailActivity.this.q2()) != null) {
                q22.N(this.f13566b, this.f13565a, AppDetailActivity.this);
            }
        }
    }

    public static final class e extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f13568a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppDetailActivity appDetailActivity) {
            super(true);
            this.f13568a = appDetailActivity;
        }

        public void handleOnBackPressed() {
            D2.g q22 = this.f13568a.q2();
            if (q22 == null || !q22.l(this.f13568a)) {
                if (this.f13568a.f13555M.size() > 0) {
                    this.f13568a.f13555M.remove(C2250q.i(this.f13568a.f13555M));
                    if (this.f13568a.f13555M.size() == 0 && this.f13568a.r3() != null && this.f13568a.f13554L.size() == 1) {
                        this.f13568a.finish();
                    } else {
                        this.f13568a.getSupportFragmentManager().popBackStackImmediate();
                    }
                } else if (this.f13568a.f13556N.size() > 0) {
                    this.f13568a.f13556N.remove(C2250q.i(this.f13568a.f13556N));
                    this.f13568a.getSupportFragmentManager().popBackStackImmediate();
                } else if (this.f13568a.f13554L.size() > 0) {
                    this.f13568a.f13554L.remove(C2250q.i(this.f13568a.f13554L));
                    this.f13568a.getSupportFragmentManager().popBackStackImmediate();
                    if (this.f13568a.f13554L.size() == 0) {
                        this.f13568a.finish();
                    }
                } else {
                    this.f13568a.finish();
                }
                if (this.f13568a.f13554L.size() > 0) {
                    ((C2540v1) C2250q.X(this.f13568a.f13554L)).T2(this.f13568a);
                }
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13569a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f13570b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppDetailActivity appDetailActivity, C2308e eVar) {
            super(2, eVar);
            this.f13570b = appDetailActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13570b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13569a;
            if (i5 == 0) {
                u.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f21373b;
                AppDetailActivity appDetailActivity = this.f13570b;
                this.f13569a = 1;
                if (GetUserDataWorker.a.b(aVar, appDetailActivity, (P) null, this, 2, (Object) null) == f5) {
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
        int f13571a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f13572b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13573c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppDetailActivity appDetailActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f13572b = appDetailActivity;
            this.f13573c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f13572b, this.f13573c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13571a == 0) {
                u.b(obj);
                C2540v1 k32 = this.f13572b.p3();
                if (k32 != null && k32.isResumed()) {
                    k32.p7(this.f13573c);
                    k32.n7(this.f13573c);
                }
                if (!this.f13572b.f13555M.isEmpty()) {
                    ((f2) C2250q.X(this.f13572b.f13555M)).b0(this.f13573c);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13574a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f13575b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13576c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppDetailActivity appDetailActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f13575b = appDetailActivity;
            this.f13576c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f13575b, this.f13576c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13574a == 0) {
                u.b(obj);
                C2540v1 k32 = this.f13575b.p3();
                if (k32 != null && k32.isResumed()) {
                    k32.q7(this.f13576c);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public AppDetailActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0753c(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f13557O = registerForActivityResult;
        this.f13558P = new e(this);
    }

    /* access modifiers changed from: private */
    public static final void n3(AppDetailActivity appDetailActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            UptodownApp.a.O0(UptodownApp.f13477F, appDetailActivity, false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final C2497h o3() {
        if (this.f13556N.size() > 0) {
            return (C2497h) C2250q.X(this.f13556N);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final C2540v1 p3() {
        if (this.f13554L.size() > 0) {
            return (C2540v1) C2250q.X(this.f13554L);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final f2 q3() {
        if (this.f13555M.size() > 0) {
            return (f2) C2250q.X(this.f13555M);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void t3(AppDetailActivity appDetailActivity, ActivityResult activityResult) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(appDetailActivity), C2865c0.b(), (O) null, new f(appDetailActivity, (C2308e) null), 2, (Object) null);
    }

    public void e3(C2657f fVar) {
        t.e(fVar, "appInfo");
        C2540v1 a5 = C2540v1.f24347o.a(fVar);
        getSupportFragmentManager().beginTransaction().add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).addToBackStack(String.valueOf(fVar.e())).commit();
        this.f13554L.add(a5);
    }

    public void onCreate(Bundle bundle) {
        C2657f fVar;
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        setContentView((int) R.layout.app_detail_activity);
        Intent intent = getIntent();
        R2((RelativeLayout) findViewById(R.id.app_info_selected_popup));
        if (intent == null || (extras = intent.getExtras()) == null) {
            fVar = null;
        } else {
            if (extras.containsKey("appInfo")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
                } else {
                    parcelable2 = extras.getParcelable("appInfo");
                }
                fVar = (C2657f) parcelable2;
            } else {
                fVar = null;
            }
            if (extras.containsKey("viewCategory")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("viewCategory", C2660i.class);
                } else {
                    parcelable = extras.getParcelable("viewCategory");
                }
                this.f13553K = (C2660i) parcelable;
            }
        }
        C2540v1 a5 = C2540v1.f24347o.a(fVar);
        getSupportFragmentManager().beginTransaction().add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).commit();
        getOnBackPressedDispatcher().addCallback(this, this.f13558P);
        Y2(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0744b(this)));
        this.f13554L.add(a5);
        C2660i iVar = this.f13553K;
        if (iVar != null) {
            t.b(iVar);
            y3(iVar);
        }
    }

    public final C2660i r3() {
        return this.f13553K;
    }

    public final ActivityResultLauncher s3() {
        return this.f13557O;
    }

    public final void u3() {
        C2540v1 p32 = p3();
        if (p32 != null) {
            p32.h6();
        }
    }

    public final Object v3(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new g(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object w3(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new h(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final void x3(C2654c cVar) {
        t.e(cVar, "alternatives");
        C2497h a5 = C2497h.f24213f.a(cVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        t.d(beginTransaction, "beginTransaction(...)");
        UptodownApp.f13477F.o0(beginTransaction, this);
        beginTransaction.add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).addToBackStack(cVar.c()).commit();
        this.f13556N.add(a5);
    }

    public final void y3(C2660i iVar) {
        t.e(iVar, "category");
        f2 a5 = f2.f24166k.a(iVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        t.d(beginTransaction, "beginTransaction(...)");
        UptodownApp.f13477F.o0(beginTransaction, this);
        beginTransaction.add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).addToBackStack(String.valueOf(iVar.c())).commit();
        this.f13555M.add(a5);
    }
}
