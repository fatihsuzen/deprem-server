package com.uptodown.activities;

import O1.A0;
import O1.B0;
import O1.C0;
import O1.C0922x0;
import O1.C0930y0;
import O1.C0938z0;
import O1.D0;
import O1.E0;
import O1.F0;
import O1.G0;
import O1.H0;
import O1.I0;
import O1.J0;
import O1.K0;
import O1.O0;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1613p;
import h2.C2412f0;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class LoginActivity extends O0 {

    /* renamed from: S  reason: collision with root package name */
    public static final a f13949S = new a((C2633k) null);

    /* renamed from: O  reason: collision with root package name */
    private final C2223l f13950O = m.b(new B0(this));

    /* renamed from: P  reason: collision with root package name */
    private final C2223l f13951P = new ViewModelLazy(M.b(C1613p.class), new i(this), new h(this), new j((C2616a) null, this));

    /* renamed from: Q  reason: collision with root package name */
    private Drawable f13952Q;

    /* renamed from: R  reason: collision with root package name */
    private final c f13953R = new c(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f13954a;

        b(LoginActivity loginActivity) {
            this.f13954a = loginActivity;
        }

        public void onAnimationEnd(Animation animation) {
            t.e(animation, "animation");
            this.f13954a.U3().f23060c.getRoot().setVisibility(8);
            this.f13954a.s4();
        }

        public void onAnimationRepeat(Animation animation) {
            t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            t.e(animation, "animation");
        }
    }

    public static final class c extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f13955a;

        public static final class a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f13956a;

            a(LoginActivity loginActivity) {
                this.f13956a = loginActivity;
            }

            public void onAnimationEnd(Animation animation) {
                t.e(animation, "animation");
                this.f13956a.U3().f23061d.getRoot().setVisibility(8);
                this.f13956a.r4();
            }

            public void onAnimationRepeat(Animation animation) {
                t.e(animation, "animation");
            }

            public void onAnimationStart(Animation animation) {
                t.e(animation, "animation");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(LoginActivity loginActivity) {
            super(true);
            this.f13955a = loginActivity;
        }

        public void handleOnBackPressed() {
            LinearLayout b5 = this.f13955a.U3().f23061d.getRoot();
            t.d(b5, "getRoot(...)");
            if (b5.getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                alphaAnimation.setDuration(200);
                alphaAnimation.setAnimationListener(new a(this.f13955a));
                this.f13955a.U3().f23061d.getRoot().startAnimation(alphaAnimation);
                return;
            }
            this.f13955a.finish();
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13957a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LoginActivity f13958b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f13959a;

            a(LoginActivity loginActivity) {
                this.f13959a = loginActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f13959a.U3().f23059b.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    V h5 = V.f24870q.h(this.f13959a);
                    if (h5 == null || !h5.p(this.f13959a)) {
                        O.c cVar = (O.c) o5;
                        if (((C1613p.a) cVar.a()).b() != null) {
                            this.f13959a.u0(((C1613p.a) cVar.a()).b());
                        } else {
                            LoginActivity loginActivity = this.f13959a;
                            String string = loginActivity.getString(R.string.login_error_message);
                            t.d(string, "getString(...)");
                            loginActivity.u0(string);
                        }
                    } else {
                        O.c cVar2 = (O.c) o5;
                        if (((C1613p.a) cVar2.a()).a() != null) {
                            this.f13959a.u0(((C1613p.a) cVar2.a()).a());
                        }
                        this.f13959a.y3();
                        this.f13959a.setResult(1);
                    }
                    this.f13959a.U3().f23059b.setVisibility(8);
                    if (h5 != null && h5.p(this.f13959a) && ((C1613p.a) ((O.c) o5).a()).a() == null) {
                        this.f13959a.getOnBackPressedDispatcher().onBackPressed();
                    }
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(LoginActivity loginActivity, C2308e eVar) {
            super(2, eVar);
            this.f13958b = loginActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13958b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13957a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f13958b.V3().e();
                a aVar = new a(this.f13958b);
                this.f13957a = 1;
                if (e5.collect(aVar, this) == f5) {
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

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13960a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LoginActivity f13961b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f13962a;

            a(LoginActivity loginActivity) {
                this.f13962a = loginActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f13962a.U3().f23059b.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((C1613p.b) cVar.a()).c() == 1) {
                        String b5 = ((C1613p.b) cVar.a()).b();
                        if (!(b5 == null || b5.length() == 0)) {
                            this.f13962a.u0(((C1613p.b) cVar.a()).b());
                        }
                        this.f13962a.p4();
                        this.f13962a.q4();
                    } else {
                        String a5 = ((C1613p.b) cVar.a()).a();
                        if (a5 == null || a5.length() == 0) {
                            LoginActivity loginActivity = this.f13962a;
                            String string = loginActivity.getString(R.string.signup_error_message);
                            t.d(string, "getString(...)");
                            loginActivity.u0(string);
                        } else {
                            this.f13962a.u0(((C1613p.b) cVar.a()).a());
                        }
                    }
                    this.f13962a.U3().f23059b.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(LoginActivity loginActivity, C2308e eVar) {
            super(2, eVar);
            this.f13961b = loginActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f13961b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13960a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f13961b.V3().f();
                a aVar = new a(this.f13961b);
                this.f13960a = 1;
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f13963a;

        f(LoginActivity loginActivity) {
            this.f13963a = loginActivity;
        }

        public void onAnimationEnd(Animation animation) {
            t.e(animation, "animation");
            this.f13963a.U3().f23060c.getRoot().setVisibility(0);
            this.f13963a.U3().f23063f.setText(R.string.title_login);
        }

        public void onAnimationRepeat(Animation animation) {
            t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            t.e(animation, "animation");
        }
    }

    public static final class g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f13964a;

        g(LoginActivity loginActivity) {
            this.f13964a = loginActivity;
        }

        public void onAnimationEnd(Animation animation) {
            t.e(animation, "animation");
            this.f13964a.U3().f23061d.getRoot().setVisibility(0);
            this.f13964a.U3().f23063f.setText(R.string.title_sign_up);
        }

        public void onAnimationRepeat(Animation animation) {
            t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            t.e(animation, "animation");
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13965a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f13965a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f13965a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13966a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f13966a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f13966a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f13967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13968b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f13967a = aVar;
            this.f13968b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f13967a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f13968b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.LoginActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final C2412f0 T3(LoginActivity loginActivity) {
        return C2412f0.c(loginActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C2412f0 U3() {
        return (C2412f0) this.f13950O.getValue();
    }

    /* access modifiers changed from: private */
    public final C1613p V3() {
        return (C1613p) this.f13951P.getValue();
    }

    private final void W3() {
        Object systemService = getSystemService("input_method");
        t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        inputMethodManager.hideSoftInputFromWindow(U3().f23061d.f22685c.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(U3().f23061d.f22687e.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(U3().f23061d.f22686d.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(U3().f23060c.f23076c.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(U3().f23060c.f23075b.getWindowToken(), 0);
    }

    private final void X3() {
        k.a aVar = k.f32g;
        ((TextView) findViewById(R.id.tv_title_download_benefit)).setTypeface(aVar.w());
        ((TextView) findViewById(R.id.tv_desc_download_benefit)).setTypeface(aVar.x());
        ((TextView) findViewById(R.id.tv_title_discover_benefit)).setTypeface(aVar.w());
        ((TextView) findViewById(R.id.tv_desc_discover_benefit)).setTypeface(aVar.x());
        ((TextView) findViewById(R.id.tv_title_share_benefit)).setTypeface(aVar.w());
        ((TextView) findViewById(R.id.tv_desc_share_benefit)).setTypeface(aVar.x());
    }

    private final void Y3() {
        setContentView((View) U3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        this.f13952Q = drawable;
        if (drawable != null) {
            t.b(drawable);
            X2(drawable, ContextCompat.getColor(this, R.color.toolbar_icon));
            U3().f23062e.setNavigationIcon(this.f13952Q);
            U3().f23062e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        U3().f23062e.setNavigationOnClickListener(new C0922x0(this));
        TextView textView = U3().f23063f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        U3().f23060c.f23083j.setTypeface(aVar.w());
        U3().f23060c.f23080g.setTypeface(aVar.x());
        U3().f23061d.f22692j.setTypeface(aVar.x());
        U3().f23059b.setOnClickListener(new F0());
        U3().f23060c.f23083j.setOnClickListener(new G0(this));
        U3().f23060c.f23081h.setTypeface(aVar.w());
        U3().f23060c.f23081h.setOnClickListener(new H0(this));
        U3().f23060c.f23076c.setTypeface(aVar.x());
        U3().f23060c.f23076c.setOnFocusChangeListener(new I0(this));
        U3().f23060c.f23075b.setTypeface(aVar.x());
        U3().f23060c.f23075b.setImeOptions(6);
        U3().f23060c.f23075b.setOnEditorActionListener(new J0(this));
        U3().f23060c.f23075b.setOnFocusChangeListener(new K0(this));
        Drawable[] compoundDrawables = U3().f23060c.f23075b.getCompoundDrawables();
        t.d(compoundDrawables, "getCompoundDrawables(...)");
        Drawable drawable2 = compoundDrawables[0];
        if (drawable2 != null) {
            t.b(drawable2);
            drawable2.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        }
        TextView textView2 = (TextView) findViewById(R.id.tv_pass_forget_login);
        if (textView2 != null) {
            textView2.setTypeface(aVar.w());
            textView2.setOnClickListener(new C0930y0(this));
        }
        U3().f23061d.f22694l.setTypeface(aVar.w());
        U3().f23061d.f22694l.setOnClickListener(new C0938z0(this));
        U3().f23061d.f22687e.setTypeface(aVar.x());
        U3().f23061d.f22687e.setOnFocusChangeListener(new A0(this));
        U3().f23061d.f22691i.setTypeface(aVar.w());
        U3().f23061d.f22691i.setOnClickListener(new C0(this));
        U3().f23061d.f22685c.setTypeface(aVar.x());
        U3().f23061d.f22685c.setOnFocusChangeListener(new D0(this));
        U3().f23061d.f22686d.setTypeface(aVar.x());
        U3().f23061d.f22686d.setOnFocusChangeListener(new E0(this));
        Drawable[] compoundDrawables2 = U3().f23061d.f22686d.getCompoundDrawables();
        t.d(compoundDrawables2, "getCompoundDrawables(...)");
        Drawable drawable3 = compoundDrawables2[0];
        if (drawable3 != null) {
            t.b(drawable3);
            drawable3.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        }
        U3().f23061d.f22684b.setTypeface(aVar.x());
        U3().f23061d.f22684b.setMovementMethod(LinkMovementMethod.getInstance());
        n3(U3());
        X3();
    }

    /* access modifiers changed from: private */
    public static final void Z3(LoginActivity loginActivity, View view) {
        loginActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void a4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.U3().f23061d.f22687e.setHint("");
        } else {
            loginActivity.U3().f23061d.f22687e.setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(LoginActivity loginActivity, View view) {
        loginActivity.f13953R.handleOnBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void c4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.U3().f23061d.f22685c.setHint("");
        } else {
            loginActivity.U3().f23061d.f22685c.setHint(loginActivity.getString(R.string.hint_email_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void d4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.U3().f23061d.f22686d.setHint("");
        } else {
            loginActivity.U3().f23061d.f22686d.setHint(loginActivity.getString(R.string.hint_pass_login_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void e4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void f4(LoginActivity loginActivity, View view) {
        if (loginActivity.U3().f23061d.getRoot().getVisibility() != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(200);
            alphaAnimation.setAnimationListener(new b(loginActivity));
            loginActivity.U3().f23060c.getRoot().startAnimation(alphaAnimation);
        }
    }

    /* access modifiers changed from: private */
    public static final void g4(LoginActivity loginActivity, View view) {
        loginActivity.o4();
    }

    /* access modifiers changed from: private */
    public static final void h4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.U3().f23060c.f23076c.setHint("");
        } else {
            loginActivity.U3().f23060c.f23076c.setHint(loginActivity.getString(R.string.hint_email_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean i4(LoginActivity loginActivity, TextView textView, int i5, KeyEvent keyEvent) {
        if (i5 != 6) {
            return false;
        }
        loginActivity.o4();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void j4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.U3().f23060c.f23075b.setHint("");
        } else {
            loginActivity.U3().f23060c.f23075b.setHint(loginActivity.getString(R.string.hint_pass_login_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void k4(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent(loginActivity.getApplicationContext(), PasswordRecoveryActivity.class), UptodownApp.f13477F.a(loginActivity));
    }

    /* access modifiers changed from: private */
    public static final void l4(LoginActivity loginActivity, View view) {
        loginActivity.t4();
    }

    private final void m4(String str, String str2) {
        V3().c(this, str, str2);
    }

    private final void n4(String str, String str2, String str3) {
        V3().d(this, str, str2, str3);
    }

    private final void o4() {
        W3();
        if (V3().g(U3().f23060c.f23076c.getText().toString(), U3().f23060c.f23075b.getText().toString())) {
            m4(U3().f23060c.f23076c.getText().toString(), U3().f23060c.f23075b.getText().toString());
            return;
        }
        String string = getString(R.string.faltan_datos_login);
        t.d(string, "getString(...)");
        u0(string);
    }

    /* access modifiers changed from: private */
    public final void p4() {
        C2412f0 U32 = U3();
        U32.f23061d.f22687e.setText("");
        U32.f23060c.f23076c.setText("");
        U32.f23061d.f22685c.setText("");
        U32.f23061d.f22685c.setEnabled(true);
        U32.f23061d.f22686d.setText("");
        U32.f23060c.f23075b.setText("");
        U32.f23061d.f22684b.setChecked(false);
    }

    /* access modifiers changed from: private */
    public final void q4() {
        C2412f0 U32 = U3();
        U32.f23063f.setText(getString(R.string.title_login));
        U32.f23060c.getRoot().setVisibility(0);
        U32.f23061d.getRoot().setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void r4() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new f(this));
        TextView j32 = j3();
        if (j32 != null) {
            j32.setText(getString(R.string.title_login));
        }
        U3().f23060c.getRoot().setVisibility(0);
        U3().f23060c.getRoot().startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: private */
    public final void s4() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new g(this));
        TextView j32 = j3();
        if (j32 != null) {
            j32.setText(getString(R.string.sign_up_with_google));
        }
        U3().f23061d.getRoot().setVisibility(0);
        U3().f23061d.getRoot().startAnimation(alphaAnimation);
    }

    private final void t4() {
        W3();
        boolean i5 = V3().i(U3().f23061d.f22685c.getText().toString());
        if (V3().h(U3().f23061d.f22687e.getText().toString(), U3().f23061d.f22685c.getText().toString(), U3().f23061d.f22686d.getText().toString()) && i5 && U3().f23061d.f22684b.isChecked()) {
            n4(U3().f23061d.f22687e.getText().toString(), U3().f23061d.f22685c.getText().toString(), U3().f23061d.f22686d.getText().toString());
        } else if (!U3().f23061d.f22684b.isChecked()) {
            String string = getString(R.string.falta_condiciones_uso);
            t.d(string, "getString(...)");
            u0(string);
        } else if (U3().f23061d.f22686d.length() < 6) {
            String string2 = getString(R.string.validation_six_chars_min);
            t.d(string2, "getString(...)");
            u0(string2);
        } else if (U3().f23061d.f22686d.length() > 99) {
            String string3 = getString(R.string.validation_hundred_chars_max);
            t.d(string3, "getString(...)");
            u0(string3);
        } else if (!i5) {
            String string4 = getString(R.string.error_email_not_valid);
            t.d(string4, "getString(...)");
            u0(string4);
        } else {
            String string5 = getString(R.string.faltan_datos_registro);
            t.d(string5, "getString(...)");
            u0(string5);
        }
    }

    /* access modifiers changed from: protected */
    public void m3() {
        U3().f23059b.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(this, this.f13953R);
        Y3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Drawable drawable = this.f13952Q;
        if (drawable != null) {
            t.b(drawable);
            DrawableCompat.setTintList(drawable, (ColorStateList) null);
        }
        getWindow().getDecorView().setSystemUiVisibility(0);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        W3();
        V h5 = V.f24870q.h(this);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str != null && h5.p(this)) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void u3(V v5) {
        String str;
        if (v5 != null) {
            v5.s(this);
        }
        if (v5 != null) {
            try {
                str = v5.k();
            } catch (Exception e5) {
                e5.printStackTrace();
                return;
            }
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (str.length() != 0) {
            t.b(v5);
            String k5 = v5.k();
            t.b(k5);
            AccountManager.get(getBaseContext()).addAccountExplicitly(new Account(k5, getString(R.string.account)), (String) null, (Bundle) null);
        }
    }

    /* access modifiers changed from: protected */
    public void w3(V v5, String str) {
        String str2;
        m3();
        EditText editText = U3().f23061d.f22687e;
        String str3 = null;
        if (v5 != null) {
            str2 = v5.k();
        } else {
            str2 = null;
        }
        editText.setText(str2);
        EditText editText2 = U3().f23061d.f22685c;
        if (v5 != null) {
            str3 = v5.h();
        }
        editText2.setText(str3);
        U3().f23061d.f22685c.setEnabled(false);
        if (str != null) {
            u0(str);
        }
    }

    /* access modifiers changed from: protected */
    public void x3() {
        U3().f23059b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void y3() {
        String string = getString(R.string.login_successful);
        t.d(string, "getString(...)");
        u0(string);
    }
}
