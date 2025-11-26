package com.uptodown.activities;

import O1.C0740a4;
import O1.C0749b4;
import O1.C0758c4;
import O1.C0767d4;
import O1.C0775e4;
import O1.C0783f4;
import O1.C0791g4;
import O1.C0799h4;
import O1.C0807i4;
import O1.C0815j4;
import O1.C0823k4;
import O1.Z3;
import R1.C0992x;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.C2446x;
import h2.E0;
import i2.f2;
import java.util.ArrayList;
import k2.Y;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2660i;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import w3.N;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;

public final class PreregistrationActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14347K = new ViewModelLazy(M.b(C0823k4.class), new d(this), new c(this), new e((C2616a) null, this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14348L = m.b(new Z3(this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0992x f14349M;

    /* renamed from: N  reason: collision with root package name */
    private final f f14350N = new f(this);

    /* renamed from: O  reason: collision with root package name */
    private final ActivityResultLauncher f14351O;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14352a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreregistrationActivity f14353b;

        /* renamed from: com.uptodown.activities.PreregistrationActivity$a$a  reason: collision with other inner class name */
        static final class C0131a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PreregistrationActivity f14354a;

            C0131a(PreregistrationActivity preregistrationActivity) {
                this.f14354a = preregistrationActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    if (this.f14354a.f14349M == null) {
                        this.f14354a.B3().f22337c.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    this.f14354a.A3((ArrayList) cVar.a());
                    if (((ArrayList) cVar.a()).isEmpty()) {
                        this.f14354a.B3().f22342h.setVisibility(0);
                    }
                    this.f14354a.B3().f22341g.setVisibility(0);
                    this.f14354a.B3().f22339e.setVisibility(0);
                    this.f14354a.B3().f22337c.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PreregistrationActivity preregistrationActivity, C2308e eVar) {
            super(2, eVar);
            this.f14353b = preregistrationActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14353b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14352a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14353b.C3().e();
                C0131a aVar = new C0131a(this.f14353b);
                this.f14352a = 1;
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
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14355a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreregistrationActivity f14356b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2647G f14357c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PreregistrationActivity preregistrationActivity, C2647G g5, C2308e eVar) {
            super(2, eVar);
            this.f14356b = preregistrationActivity;
            this.f14357c = g5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14356b, this.f14357c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14355a == 0) {
                u.b(obj);
                this.f14356b.y3(this.f14357c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14358a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f14358a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14358a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14359a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f14359a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14359a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14361b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14360a = aVar;
            this.f14361b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14360a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14361b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PreregistrationActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class f implements Y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PreregistrationActivity f14362a;

        f(PreregistrationActivity preregistrationActivity) {
            this.f14362a = preregistrationActivity;
        }

        public void a(int i5) {
            if (UptodownApp.f13477F.Z() && this.f14362a.f14349M != null) {
                C0992x s32 = this.f14362a.f14349M;
                t.b(s32);
                if (!s32.b().isEmpty()) {
                    C0992x s33 = this.f14362a.f14349M;
                    t.b(s33);
                    Object obj = s33.b().get(i5);
                    t.d(obj, "get(...)");
                    this.f14362a.H2(((C2647G) obj).b());
                }
            }
        }

        public void f(int i5) {
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (V.f24870q.h(this.f14362a) == null) {
                this.f14362a.N3();
                return;
            }
            C0992x s32 = this.f14362a.f14349M;
            t.b(s32);
            Object obj = s32.b().get(i5);
            t.d(obj, "get(...)");
            this.f14362a.J3((C2647G) obj);
        }
    }

    public PreregistrationActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0749b4(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14351O = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public final void A3(ArrayList arrayList) {
        C0992x xVar = this.f14349M;
        if (xVar == null) {
            this.f14349M = new C0992x(arrayList, this, this.f14350N);
            B3().f22339e.setAdapter(this.f14349M);
            return;
        }
        t.b(xVar);
        xVar.c(arrayList);
    }

    /* access modifiers changed from: private */
    public final E0 B3() {
        return (E0) this.f14348L.getValue();
    }

    /* access modifiers changed from: private */
    public final C0823k4 C3() {
        return (C0823k4) this.f14347K.getValue();
    }

    private final void D3() {
        setContentView((View) B3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        E0 B32 = B3();
        if (drawable != null) {
            B32.f22340f.setNavigationIcon(drawable);
            B32.f22340f.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        B32.f22340f.setNavigationOnClickListener(new C0758c4(this));
        TextView textView = B32.f22343i;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        B32.f22341g.setTypeface(aVar.w());
        B32.f22339e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        B32.f22339e.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        B3().f22339e.addItemDecoration(new B2.l(dimension, dimension));
        B32.f22342h.setTypeface(aVar.x());
        B32.f22337c.setOnClickListener(new C0767d4());
        B32.f22341g.setOnClickListener(new C0775e4(this));
    }

    /* access modifiers changed from: private */
    public static final void E3(PreregistrationActivity preregistrationActivity, View view) {
        preregistrationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void F3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void G3(PreregistrationActivity preregistrationActivity, View view) {
        C2660i iVar = new C2660i(1090, (String) null, (String) null, 6, (C2633k) null);
        iVar.v(true);
        preregistrationActivity.Q3(iVar);
    }

    private final void H3(boolean z4) {
        C3().d(this, z4);
    }

    /* access modifiers changed from: private */
    public static final void I3(PreregistrationActivity preregistrationActivity, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == 1) {
            V h5 = V.f24870q.h(preregistrationActivity);
            if (h5 != null) {
                str = h5.j();
            } else {
                str = null;
            }
            if (str != null && h5.p(preregistrationActivity)) {
                UptodownApp.a aVar = UptodownApp.f13477F;
                aVar.l0(preregistrationActivity);
                aVar.k0(preregistrationActivity);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void J3(C2647G g5) {
        AlertDialog p22;
        if (!isFinishing()) {
            if (!(p2() == null || (p22 = p2()) == null)) {
                p22.dismiss();
            }
            C2446x c5 = C2446x.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23667f;
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            c5.f23667f.setText(getString(R.string.cancel_registration));
            c5.f23665d.setTypeface(aVar.x());
            TextView textView2 = c5.f23665d;
            C2962v vVar = new C2962v();
            String string = getString(R.string.confirm_cancel_preregister, new Object[]{g5.f()});
            t.d(string, "getString(...)");
            String f5 = g5.f();
            t.b(f5);
            textView2.setText(vVar.d(string, f5, this));
            c5.f23664c.setTypeface(aVar.w());
            c5.f23666e.setTypeface(aVar.w());
            c5.f23666e.setText(getString(R.string.dialog_confirmation_verify_afirmative));
            c5.f23664c.setVisibility(0);
            c5.f23664c.setOnClickListener(new C0799h4(this));
            c5.f23666e.setOnClickListener(new C0807i4(this, g5));
            c5.f23663b.setOnClickListener(new C0815j4(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            P2(builder.create());
            if (p2() != null) {
                AlertDialog p23 = p2();
                t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p24 = p2();
                t.b(p24);
                p24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void K3(PreregistrationActivity preregistrationActivity, View view) {
        AlertDialog p22 = preregistrationActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void L3(PreregistrationActivity preregistrationActivity, C2647G g5, View view) {
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new b(preregistrationActivity, g5, (C2308e) null), 3, (Object) null);
        AlertDialog p22 = preregistrationActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void M3(PreregistrationActivity preregistrationActivity, View view) {
        AlertDialog p22 = preregistrationActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public final void N3() {
        AlertDialog p22;
        if (!isFinishing()) {
            if (!(p2() == null || (p22 = p2()) == null)) {
                p22.dismiss();
            }
            C2446x c5 = C2446x.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23667f;
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            c5.f23665d.setTypeface(aVar.x());
            c5.f23666e.setTypeface(aVar.w());
            c5.f23666e.setOnClickListener(new C0783f4(this));
            c5.f23663b.setOnClickListener(new C0791g4(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            P2(builder.create());
            if (p2() != null) {
                AlertDialog p23 = p2();
                t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p24 = p2();
                t.b(p24);
                p24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(PreregistrationActivity preregistrationActivity, View view) {
        preregistrationActivity.f14351O.launch(new Intent(preregistrationActivity.getApplicationContext(), LoginActivity.class), UptodownApp.f13477F.b(preregistrationActivity));
        AlertDialog p22 = preregistrationActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void P3(PreregistrationActivity preregistrationActivity, View view) {
        AlertDialog p22 = preregistrationActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final E0 x3(PreregistrationActivity preregistrationActivity) {
        return E0.c(preregistrationActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void y3(C2647G g5) {
        C3().c(this, g5, new C0740a4(this));
    }

    /* access modifiers changed from: private */
    public static final J z3(PreregistrationActivity preregistrationActivity) {
        preregistrationActivity.H3(true);
        return J.f19942a;
    }

    public final void Q3(C2660i iVar) {
        t.e(iVar, "category");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(16908290, (Fragment) f2.f24166k.a(iVar), (String) null).addToBackStack(String.valueOf(iVar.c())).commit();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new a(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        H3(false);
    }
}
