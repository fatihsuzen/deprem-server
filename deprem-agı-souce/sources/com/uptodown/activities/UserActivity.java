package com.uptodown.activities;

import O1.C0742a6;
import O1.C0751b6;
import O1.C0760c6;
import O1.C0769d6;
import O1.C0777e6;
import O1.C0785f6;
import O1.C0793g6;
import O1.C0801h6;
import O1.C0809i6;
import O1.C0817j6;
import O1.C0825k6;
import O1.C0833l6;
import O1.C0841m6;
import O1.C0849n6;
import O1.C0857o6;
import O1.C0865p6;
import O1.C0873q6;
import O1.C0880r6;
import O1.C0888s6;
import O1.C0896t6;
import O1.C0904u6;
import O1.C0912v6;
import O1.C0920w6;
import O1.C0928x6;
import O1.U5;
import O1.V5;
import O1.W5;
import O1.X5;
import O1.Y5;
import O1.Z5;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.f0;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.util.views.UsernameTextView;
import g2.C2391m;
import h2.C2433q;
import h2.C2436s;
import h2.d1;
import k2.N;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.V;
import l2.X;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2940B;
import z2.C2962v;
import z2.F;
import z2.O;
import z3.C2973f;
import z3.D;

public final class UserActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14637K = m.b(new C0777e6(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14638L = new ViewModelLazy(M.b(g0.class), new g(this), new f(this), new h((C2616a) null, this));

    /* renamed from: M  reason: collision with root package name */
    private final C2223l f14639M = new ViewModelLazy(M.b(f0.class), new j(this), new i(this), new k((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public String f14640N;

    /* renamed from: O  reason: collision with root package name */
    private final ActivityResultLauncher f14641O;

    /* renamed from: P  reason: collision with root package name */
    private final ActivityResultLauncher f14642P;

    /* renamed from: Q  reason: collision with root package name */
    private final ActivityResultLauncher f14643Q;

    /* renamed from: R  reason: collision with root package name */
    private final ActivityResultLauncher f14644R;

    /* renamed from: S  reason: collision with root package name */
    private final ActivityResultLauncher f14645S;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14646a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserActivity f14647b;

        /* renamed from: com.uptodown.activities.UserActivity$a$a  reason: collision with other inner class name */
        static final class C0140a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserActivity f14648a;

            C0140a(UserActivity userActivity) {
                this.f14648a = userActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        X a5 = ((f0.a) ((O.c) o5).a()).a();
                        Intent intent = new Intent(this.f14648a, UserDeviceDetailsActivity.class);
                        intent.putExtra("user_device", a5);
                        UserActivity userActivity = this.f14648a;
                        userActivity.startActivity(intent, UptodownApp.f13477F.a(userActivity));
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(UserActivity userActivity, C2308e eVar) {
            super(2, eVar);
            this.f14647b = userActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14647b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14646a;
            if (i5 == 0) {
                u.b(obj);
                D c5 = this.f14647b.Z3().c();
                C0140a aVar = new C0140a(this.f14647b);
                this.f14646a = 1;
                if (c5.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserActivity f14650b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserActivity f14651a;

            /* renamed from: com.uptodown.activities.UserActivity$b$a$a  reason: collision with other inner class name */
            static final class C0141a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a  reason: collision with root package name */
                Object f14652a;

                /* renamed from: b  reason: collision with root package name */
                Object f14653b;

                /* renamed from: c  reason: collision with root package name */
                /* synthetic */ Object f14654c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ a f14655d;

                /* renamed from: e  reason: collision with root package name */
                int f14656e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0141a(a aVar, C2308e eVar) {
                    super(eVar);
                    this.f14655d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f14654c = obj;
                    this.f14656e |= Integer.MIN_VALUE;
                    return this.f14655d.emit((O) null, this);
                }
            }

            a(UserActivity userActivity) {
                this.f14651a = userActivity;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* renamed from: b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(z2.O r5, b3.C2308e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.uptodown.activities.UserActivity.b.a.C0141a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.uptodown.activities.UserActivity$b$a$a r0 = (com.uptodown.activities.UserActivity.b.a.C0141a) r0
                    int r1 = r0.f14656e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f14656e = r1
                    goto L_0x0018
                L_0x0013:
                    com.uptodown.activities.UserActivity$b$a$a r0 = new com.uptodown.activities.UserActivity$b$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f14654c
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.f14656e
                    r3 = 1
                    if (r2 == 0) goto L_0x0039
                    if (r2 != r3) goto L_0x0031
                    java.lang.Object r5 = r0.f14653b
                    z2.O r5 = (z2.O) r5
                    java.lang.Object r0 = r0.f14652a
                    com.uptodown.activities.UserActivity$b$a r0 = (com.uptodown.activities.UserActivity.b.a) r0
                    W2.u.b(r6)
                    goto L_0x0058
                L_0x0031:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0039:
                    W2.u.b(r6)
                    z2.O$a r6 = z2.O.a.f26507a
                    boolean r6 = kotlin.jvm.internal.t.a(r5, r6)
                    if (r6 != 0) goto L_0x0083
                    boolean r6 = r5 instanceof z2.O.c
                    if (r6 == 0) goto L_0x0074
                    r0.f14652a = r4
                    r0.f14653b = r5
                    r0.f14656e = r3
                    r2 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r6 = w3.X.b(r2, r0)
                    if (r6 != r1) goto L_0x0057
                    return r1
                L_0x0057:
                    r0 = r4
                L_0x0058:
                    com.uptodown.activities.UserActivity r6 = r0.f14651a
                    z2.O$c r5 = (z2.O.c) r5
                    java.lang.Object r0 = r5.a()
                    com.uptodown.activities.g0$a r0 = (com.uptodown.activities.g0.a) r0
                    int r0 = r0.b()
                    java.lang.Object r5 = r5.a()
                    com.uptodown.activities.g0$a r5 = (com.uptodown.activities.g0.a) r5
                    int r5 = r5.a()
                    r6.F4(r0, r5)
                    goto L_0x0083
                L_0x0074:
                    z2.O$b r6 = z2.O.b.f26508a
                    boolean r5 = kotlin.jvm.internal.t.a(r5, r6)
                    if (r5 == 0) goto L_0x007d
                    goto L_0x0083
                L_0x007d:
                    W2.q r5 = new W2.q
                    r5.<init>()
                    throw r5
                L_0x0083:
                    W2.J r5 = W2.J.f19942a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserActivity.b.a.emit(z2.O, b3.e):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UserActivity userActivity, C2308e eVar) {
            super(2, eVar);
            this.f14650b = userActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14650b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14649a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f14650b.a4().j();
                a aVar = new a(this.f14650b);
                this.f14649a = 1;
                if (j5.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14657a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserActivity f14658b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserActivity f14659a;

            a(UserActivity userActivity) {
                this.f14659a = userActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        new C2962v().t(this.f14659a, (String) ((O.c) o5).a(), this.f14659a.getString(R.string.uptodown_turbo));
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UserActivity userActivity, C2308e eVar) {
            super(2, eVar);
            this.f14658b = userActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14658b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14657a;
            if (i5 == 0) {
                u.b(obj);
                D h5 = this.f14658b.a4().h();
                a aVar = new a(this.f14658b);
                this.f14657a = 1;
                if (h5.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserActivity f14661b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserActivity f14662a;

            a(UserActivity userActivity) {
                this.f14662a = userActivity;
            }

            /* access modifiers changed from: private */
            public static final void d(UserActivity userActivity, View view) {
                if (userActivity.f14640N != null) {
                    C2962v vVar = new C2962v();
                    String K32 = userActivity.f14640N;
                    t.b(K32);
                    C2962v.u(vVar, userActivity, K32, (String) null, 4, (Object) null);
                }
            }

            /* renamed from: c */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        this.f14662a.f14640N = (String) ((O.c) o5).a();
                        this.f14662a.Y3().f22937m.setVisibility(0);
                        this.f14662a.Y3().f22937m.setOnClickListener(new b0(this.f14662a));
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UserActivity userActivity, C2308e eVar) {
            super(2, eVar);
            this.f14661b = userActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14661b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14660a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f14661b.a4().f();
                a aVar = new a(this.f14661b);
                this.f14660a = 1;
                if (f6.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e implements N {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserActivity f14663a;

        e(UserActivity userActivity) {
            this.f14663a = userActivity;
        }

        public void a() {
        }

        public void b(V v5) {
            t.e(v5, "user");
            Intent intent = new Intent(this.f14663a, PublicProfileActivity.class);
            intent.putExtra("user", v5);
            UserActivity userActivity = this.f14663a;
            userActivity.startActivity(intent, UptodownApp.f13477F.a(userActivity));
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14664a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14664a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14664a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14665a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14665a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14665a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14667b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14666a = aVar;
            this.f14667b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14666a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14667b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14668a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f14668a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14668a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class j extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14669a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.f14669a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14669a.getViewModelStore();
        }
    }

    public static final class k extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14670a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14671b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14670a = aVar;
            this.f14671b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14670a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14671b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserActivity.k.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public UserActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0793g6(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14641O = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0801h6(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f14642P = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0809i6(this));
        t.d(registerForActivityResult3, "registerForActivityResult(...)");
        this.f14643Q = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0817j6(this));
        t.d(registerForActivityResult4, "registerForActivityResult(...)");
        this.f14644R = registerForActivityResult4;
        ActivityResultLauncher registerForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0825k6(this));
        t.d(registerForActivityResult5, "registerForActivityResult(...)");
        this.f14645S = registerForActivityResult5;
    }

    private final void A4() {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            startActivity(new Intent(this, SecurityActivity.class), aVar.a(this));
        }
    }

    private final void B4() {
        this.f14642P.launch(new Intent(this, PreferencesActivity.class), UptodownApp.f13477F.b(this));
    }

    private final void C4() {
        com.uptodown.activities.preferences.a.f15150a.x0(this, "yes");
        AppCompatDelegate.setDefaultNightMode(2);
        UptodownApp.f13477F.t0(true);
    }

    private final void D4() {
        com.uptodown.activities.preferences.a.f15150a.x0(this, "no");
        AppCompatDelegate.setDefaultNightMode(1);
        UptodownApp.f13477F.t0(true);
    }

    /* access modifiers changed from: private */
    public static final void E4(UserActivity userActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 1003) {
            C2940B a5 = C2940B.f26458v.a(userActivity);
            a5.a();
            a5.s();
            a5.m();
            userActivity.setResult(PointerIconCompat.TYPE_HELP);
            userActivity.finish();
        } else if (resultCode == 1004) {
            UptodownApp.f13477F.e(userActivity);
            userActivity.setResult(PointerIconCompat.TYPE_WAIT);
            userActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void F4(int i5, int i6) {
        if (i5 > 0) {
            Y3().f22913G.setVisibility(0);
            if (i5 > 99) {
                Y3().f22913G.setText(getString(R.string.more_than_99_value));
            } else {
                Y3().f22913G.setText(String.valueOf(i5));
            }
        } else {
            Y3().f22913G.setVisibility(4);
        }
        if (i6 > 0) {
            Y3().f22912F.setVisibility(0);
            if (i6 > 99) {
                Y3().f22912F.setText(getString(R.string.more_than_99_value));
            } else {
                Y3().f22912F.setText(String.valueOf(i6));
            }
        } else {
            Y3().f22912F.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public static final void H4(UserActivity userActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 2) {
            userActivity.P3(userActivity);
            userActivity.z4();
        }
    }

    /* access modifiers changed from: private */
    public static final void I4(UserActivity userActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 5) {
            userActivity.P3(userActivity);
        }
    }

    /* access modifiers changed from: private */
    public static final d1 O3(UserActivity userActivity) {
        return d1.c(userActivity.getLayoutInflater());
    }

    private final void P3(Context context) {
        a4().d(context);
        Y3().f22927c.setImageResource(R.drawable.vector_user_login);
        ImageView imageView = Y3().f22927c;
        t.d(imageView, "ivUserAvatarUser");
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        imageView.setPadding(dimension, dimension, dimension, dimension);
        Y3().f22927c.setBackground((Drawable) null);
        Y3().f22923Q.setText(getString(R.string.sign_in_sign_up));
        UsernameTextView.a aVar = UsernameTextView.f21329k;
        UsernameTextView usernameTextView = Y3().f22923Q;
        t.d(usernameTextView, "tvUsernameUser");
        aVar.b(usernameTextView);
        Y3().f22923Q.setTextColor(ContextCompat.getColor(this, R.color.text_terciary));
        Y3().f22921O.setText(getString(R.string.subscribe_to_uptodown_turbo));
        Y3().f22916J.setVisibility(8);
        Y3().f22908B.setVisibility(8);
        Y3().f22937m.setVisibility(8);
        this.f14640N = null;
        Y3().f22926b.setVisibility(8);
    }

    private final void Q3(Context context) {
        L l5 = new L();
        C2433q c5 = C2433q.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        TextView textView = c5.f23453e;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23451c.setTypeface(aVar.x());
        c5.f23450b.setTypeface(aVar.x());
        c5.f23452d.setTypeface(aVar.x());
        String f5 = com.uptodown.activities.preferences.a.f15150a.f(context);
        if (s.E(f5, "yes", true)) {
            c5.f23451c.setChecked(true);
        } else if (s.E(f5, "no", true)) {
            c5.f23450b.setChecked(true);
        } else {
            c5.f23452d.setChecked(true);
        }
        c5.f23451c.setOnCheckedChangeListener(new C0833l6(l5, this));
        c5.f23450b.setOnCheckedChangeListener(new C0841m6(l5, this));
        c5.f23452d.setOnCheckedChangeListener(new C0849n6(l5, context));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(c5.getRoot());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        l5.f24690a = create;
        if (create != null) {
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            ((AlertDialog) l5.f24690a).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void R3(L l5, UserActivity userActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            Object obj = l5.f24690a;
            t.b(obj);
            ((AlertDialog) obj).dismiss();
            userActivity.C4();
        }
    }

    /* access modifiers changed from: private */
    public static final void S3(L l5, UserActivity userActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            Object obj = l5.f24690a;
            t.b(obj);
            ((AlertDialog) obj).dismiss();
            userActivity.D4();
        }
    }

    /* access modifiers changed from: private */
    public static final void T3(L l5, Context context, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            Object obj = l5.f24690a;
            t.b(obj);
            ((AlertDialog) obj).dismiss();
            com.uptodown.activities.preferences.a.f15150a.x0(context, "system");
            AppCompatDelegate.setDefaultNightMode(-1);
            UptodownApp.f13477F.t0(true);
        }
    }

    private final void U3(Context context) {
        L l5 = new L();
        C2436s c5 = C2436s.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        TextView textView = c5.f23528d;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.x());
        c5.f23528d.setText(getString(R.string.log_out_confirmation_msg));
        c5.f23529e.setTypeface(aVar.w());
        c5.f23529e.setOnClickListener(new C0857o6(this, context, l5));
        c5.f23527c.setTypeface(aVar.w());
        c5.f23527c.setOnClickListener(new C0865p6(l5));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(c5.getRoot());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        l5.f24690a = create;
        if (create != null) {
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            ((AlertDialog) l5.f24690a).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void V3(UserActivity userActivity, Context context, L l5, View view) {
        userActivity.P3(context);
        userActivity.setResult(-1);
        Object obj = l5.f24690a;
        t.b(obj);
        ((AlertDialog) obj).dismiss();
    }

    /* access modifiers changed from: private */
    public static final void W3(L l5, View view) {
        Object obj = l5.f24690a;
        t.b(obj);
        ((AlertDialog) obj).dismiss();
    }

    /* access modifiers changed from: private */
    public static final void X3(UserActivity userActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1) {
            userActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final d1 Y3() {
        return (d1) this.f14637K.getValue();
    }

    /* access modifiers changed from: private */
    public final f0 Z3() {
        return (f0) this.f14639M.getValue();
    }

    private final void b4() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            Y3().f22948x.setNavigationIcon(drawable);
            Y3().f22948x.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        Y3().f22948x.setNavigationOnClickListener(new U5(this));
        Y3().f22948x.inflateMenu(R.menu.toolbar_menu_user);
        Y3().f22948x.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        Y3().f22948x.setOnMenuItemClickListener(new V5(this));
        TextView textView = Y3().f22919M;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        Y3().f22923Q.setTypeface(aVar.w());
        Y3().f22916J.setTypeface(aVar.w());
        Y3().f22909C.setTypeface(aVar.w());
        Y3().f22922P.setTypeface(aVar.w());
        Y3().f22913G.setTypeface(aVar.w());
        Y3().f22949y.setTypeface(aVar.w());
        Y3().f22912F.setTypeface(aVar.w());
        Y3().f22914H.setTypeface(aVar.w());
        Y3().f22950z.setTypeface(aVar.w());
        Y3().f22918L.setTypeface(aVar.w());
        Y3().f22907A.setTypeface(aVar.w());
        Y3().f22915I.setTypeface(aVar.w());
        Y3().f22921O.setTypeface(aVar.w());
        Y3().f22937m.setVisibility(8);
        Y3().f22920N.setTypeface(aVar.x());
        Y3().f22910D.setTypeface(aVar.x());
        Y3().f22917K.setTypeface(aVar.x());
        Y3().f22911E.setTypeface(aVar.x());
        Y3().f22924R.setTypeface(aVar.x());
        Y3().f22908B.setTypeface(aVar.x());
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
        G4();
        Y3().f22927c.setOnClickListener(new W5(this));
        Y3().f22946v.setOnClickListener(new X5(this));
        Y3().f22916J.setOnClickListener(new Y5(this));
        Y3().f22944t.setOnClickListener(new Z5(this));
        Y3().f22930f.setOnClickListener(new C0742a6(this));
        Y3().f22940p.setOnClickListener(new C0751b6(this));
        Y3().f22934j.setOnClickListener(new C0760c6(this));
        Y3().f22933i.setOnClickListener(new C0769d6(this));
        Y3().f22928d.setOnClickListener(new C0785f6(this));
        Y3().f22929e.setOnClickListener(new C0873q6(this));
        Y3().f22936l.setOnClickListener(new C0880r6(this));
        Y3().f22938n.setOnClickListener(new C0888s6(this));
        Y3().f22931g.setOnClickListener(new C0896t6(this));
        Y3().f22932h.setOnClickListener(new C0904u6(this));
        Y3().f22935k.setOnClickListener(new C0912v6(this));
        Y3().f22924R.setOnClickListener(new C0920w6(this));
        Y3().f22908B.setOnClickListener(new C0928x6(this));
        C2908y0 unused4 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new a(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void c4(UserActivity userActivity, View view) {
        userActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void d4(UserActivity userActivity, View view) {
        V h5 = V.f24870q.h(userActivity);
        if (h5 != null) {
            Intent intent = new Intent(userActivity, UserCommentsActivity.class);
            intent.putExtra("userID", h5.j());
            userActivity.startActivity(intent, UptodownApp.f13477F.a(userActivity));
            return;
        }
        userActivity.z4();
    }

    /* access modifiers changed from: private */
    public static final void e4(UserActivity userActivity, View view) {
        if (V.f24870q.h(userActivity) != null) {
            userActivity.startActivity(new Intent(userActivity, FeedActivity.class), UptodownApp.f13477F.a(userActivity));
        } else {
            userActivity.z4();
        }
    }

    /* access modifiers changed from: private */
    public static final void f4(UserActivity userActivity, View view) {
        if (V.f24870q.h(userActivity) != null) {
            userActivity.f14643Q.launch(new Intent(userActivity, ListsActivity.class), UptodownApp.f13477F.b(userActivity));
            return;
        }
        userActivity.z4();
    }

    /* access modifiers changed from: private */
    public static final void g4(UserActivity userActivity, View view) {
        if (V.f24870q.h(userActivity) != null) {
            userActivity.startActivity(new Intent(userActivity, MyStatsActivity.class));
        } else {
            userActivity.z4();
        }
    }

    /* access modifiers changed from: private */
    public static final void h4(UserActivity userActivity, View view) {
        String j5;
        V h5 = V.f24870q.h(userActivity);
        if (h5 == null || (j5 = h5.j()) == null || j5.length() == 0 || !h5.q()) {
            userActivity.d3();
        } else {
            userActivity.a4().i(userActivity);
        }
    }

    /* access modifiers changed from: private */
    public static final void i4(UserActivity userActivity, View view) {
        if (V.f24870q.h(userActivity) != null) {
            userActivity.f14644R.launch(new Intent(userActivity, UserDevicesActivity.class), UptodownApp.f13477F.b(userActivity));
        } else {
            userActivity.z4();
        }
    }

    /* access modifiers changed from: private */
    public static final void j4(UserActivity userActivity, View view) {
        userActivity.startActivity(new Intent(userActivity, NotificationsRegistryActivity.class), UptodownApp.f13477F.a(userActivity));
    }

    /* access modifiers changed from: private */
    public static final void k4(UserActivity userActivity, View view) {
        userActivity.B4();
    }

    /* access modifiers changed from: private */
    public static final void l4(UserActivity userActivity, View view) {
        C2962v.u(new C2962v(), userActivity, userActivity.getString(R.string.url) + "/android", (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void m4(UserActivity userActivity, View view) {
        userActivity.U3(userActivity);
    }

    /* access modifiers changed from: private */
    public static final boolean n4(UserActivity userActivity, MenuItem menuItem) {
        t.e(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_protect) {
            userActivity.A4();
            return true;
        } else if (menuItem.getItemId() == R.id.action_dark_mode) {
            userActivity.Q3(userActivity);
            return true;
        } else if (menuItem.getItemId() != R.id.action_edit_profile) {
            return true;
        } else {
            V h5 = V.f24870q.h(userActivity);
            if (h5 == null || !h5.p(userActivity)) {
                userActivity.z4();
                return true;
            }
            userActivity.f14645S.launch(new Intent(userActivity, UserEditProfileActivity.class), UptodownApp.f13477F.b(userActivity));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static final void o4(UserActivity userActivity, View view) {
        V h5 = V.f24870q.h(userActivity);
        if (h5 != null) {
            userActivity.y4(h5);
        } else {
            userActivity.z4();
        }
    }

    /* access modifiers changed from: private */
    public static final void p4(UserActivity userActivity, View view) {
        if (V.f24870q.h(userActivity) == null) {
            userActivity.z4();
        }
    }

    /* access modifiers changed from: private */
    public static final void q4(UserActivity userActivity, View view) {
        String j5;
        V h5 = V.f24870q.h(userActivity);
        if (h5 != null && (j5 = h5.j()) != null && j5.length() != 0) {
            C2391m mVar = new C2391m(userActivity, LifecycleOwnerKt.getLifecycleScope(userActivity));
            String j6 = h5.j();
            t.b(j6);
            mVar.c(j6, new e(userActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void r4(UserActivity userActivity, View view) {
        userActivity.startActivity(new Intent(userActivity, Updates.class), UptodownApp.f13477F.a(userActivity));
    }

    /* access modifiers changed from: private */
    public static final void s4(UserActivity userActivity, View view) {
        userActivity.startActivity(new Intent(userActivity, MyApps.class), UptodownApp.f13477F.a(userActivity));
    }

    /* access modifiers changed from: private */
    public static final void t4(UserActivity userActivity, View view) {
        userActivity.startActivity(new Intent(userActivity, MyDownloads.class), UptodownApp.f13477F.a(userActivity));
    }

    /* access modifiers changed from: private */
    public static final void u4(UserActivity userActivity, View view) {
        userActivity.startActivity(new Intent(userActivity, RollbackActivity.class), UptodownApp.f13477F.a(userActivity));
    }

    private final void v4(V v5) {
        if (v5.b() != null) {
            com.squareup.picasso.s.h().l(V.f24870q.d(v5.a())).n(UptodownApp.f13477F.g0(this)).i(Y3().f22927c);
            Y3().f22927c.setBackground(ContextCompat.getDrawable(this, R.drawable.shadow_user_icon));
        } else {
            Y3().f22927c.setImageResource(R.drawable.vector_user_profile);
        }
        ImageView imageView = Y3().f22927c;
        t.d(imageView, "ivUserAvatarUser");
        imageView.setPadding(0, 0, 0, 0);
        Y3().f22923Q.setText(v5.k());
        if (!v5.q() || t.a(v5.o(), "type0")) {
            UsernameTextView.a aVar = UsernameTextView.f21329k;
            UsernameTextView usernameTextView = Y3().f22923Q;
            t.d(usernameTextView, "tvUsernameUser");
            aVar.b(usernameTextView);
        } else {
            UsernameTextView.a aVar2 = UsernameTextView.f21329k;
            UsernameTextView usernameTextView2 = Y3().f22923Q;
            t.d(usernameTextView2, "tvUsernameUser");
            aVar2.a(usernameTextView2, v5.q(), v5.o());
        }
        if (v5.q()) {
            Y3().f22926b.setVisibility(0);
            C2962v.a aVar3 = C2962v.f26557a;
            ImageView imageView2 = Y3().f22927c;
            t.d(imageView2, "ivUserAvatarUser");
            aVar3.b(imageView2);
            Y3().f22921O.setText(getString(R.string.turbo_welcome_popup_manage_subscription));
        } else {
            Y3().f22921O.setText(getString(R.string.subscribe_to_uptodown_turbo));
        }
        Y3().f22908B.setVisibility(0);
        if (!v5.q()) {
            Y3().f22937m.setVisibility(8);
        } else if (this.f14640N == null) {
            a4().g(this);
        } else {
            Y3().f22937m.setVisibility(0);
        }
        Y3().f22916J.setVisibility(0);
    }

    private final void w4() {
        String str;
        V h5 = V.f24870q.h(this);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str == null || !h5.p(this)) {
            P3(this);
            return;
        }
        v4(h5);
        UptodownApp.a aVar = UptodownApp.f13477F;
        aVar.l0(this);
        aVar.k0(this);
    }

    /* access modifiers changed from: private */
    public static final void x4(UserActivity userActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            userActivity.P3(userActivity);
            userActivity.setResult(-1);
        } else if (resultCode == 1) {
            userActivity.setResult(1);
        } else if (resultCode == 1002) {
            userActivity.B4();
        }
    }

    private final void y4(V v5) {
        Intent intent = new Intent(this, UserAvatarActivity.class);
        intent.putExtra("user", v5);
        startActivity(intent, UptodownApp.f13477F.a(this));
    }

    private final void z4() {
        this.f14641O.launch(new Intent(this, LoginActivity.class), UptodownApp.f13477F.b(this));
    }

    public final void G4() {
        a4().e(this);
    }

    public final g0 a4() {
        return (g0) this.f14638L.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) Y3().getRoot());
        b4();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        MenuItem menuItem;
        super.onResume();
        new F(this).f("UserFragment");
        G4();
        Menu menu = Y3().f22948x.getMenu();
        if (menu != null) {
            menuItem = menu.findItem(R.id.action_dark_mode);
        } else {
            menuItem = null;
        }
        if (new C2962v().s(this)) {
            if (menuItem != null) {
                menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.vector_moon));
            }
        } else if (menuItem != null) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.vector_sun));
        }
        w4();
    }
}
