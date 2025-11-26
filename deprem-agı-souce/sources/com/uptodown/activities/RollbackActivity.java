package com.uptodown.activities;

import O1.C0864p5;
import O1.C0872q5;
import O1.C0879r5;
import O1.C0887s5;
import O1.C0895t5;
import O1.T2;
import R1.C;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.M;
import h2.Q0;
import java.util.ArrayList;
import k2.C2590G;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2655d;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class RollbackActivity extends T2 implements C2590G {

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14499W = m.b(new C0864p5(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14500X = new ViewModelLazy(M.b(M.class), new d(this), new c(this), new e((C2616a) null, this));

    /* renamed from: Y  reason: collision with root package name */
    private C f14501Y;

    /* renamed from: Z  reason: collision with root package name */
    private final ActivityResultLauncher f14502Z;

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            RollbackActivity.this.k5(false);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14504a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RollbackActivity f14505b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RollbackActivity f14506a;

            a(RollbackActivity rollbackActivity) {
                this.f14506a = rollbackActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14506a.e5().f22613b.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    this.f14506a.c5(((M.a) ((O.c) o5).a()).a());
                    this.f14506a.e5().f22618g.setVisibility(0);
                    this.f14506a.e5().f22613b.setVisibility(8);
                } else if (o5 instanceof O.b) {
                    this.f14506a.e5().f22613b.setVisibility(8);
                    this.f14506a.e5().f22617f.setVisibility(0);
                    this.f14506a.e5().f22617f.setText(this.f14506a.getString(R.string.no_results));
                } else {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RollbackActivity rollbackActivity, C2308e eVar) {
            super(2, eVar);
            this.f14505b = rollbackActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14505b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14504a;
            if (i5 == 0) {
                u.b(obj);
                D d5 = this.f14505b.f5().d();
                a aVar = new a(this.f14505b);
                this.f14504a = 1;
                if (d5.collect(aVar, this) == f5) {
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

    public static final class c extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14507a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f14507a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14507a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14508a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f14508a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14508a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14509a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14510b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14509a = aVar;
            this.f14510b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14509a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14510b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.RollbackActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public RollbackActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0872q5(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14502Z = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final Q0 b5(RollbackActivity rollbackActivity) {
        return Q0.c(rollbackActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void c5(ArrayList arrayList) {
        C c5 = this.f14501Y;
        if (c5 == null) {
            this.f14501Y = new C(arrayList, this, this);
            e5().f22614c.setAdapter(this.f14501Y);
            return;
        }
        t.b(c5);
        c5.d(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void d5(RollbackActivity rollbackActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            rollbackActivity.Q2();
            rollbackActivity.e5().f22616e.setVisibility(8);
            rollbackActivity.e5().f22617f.setText(rollbackActivity.getString(R.string.msg_checking_device_rollback));
        }
    }

    /* access modifiers changed from: private */
    public final Q0 e5() {
        return (Q0) this.f14499W.getValue();
    }

    /* access modifiers changed from: private */
    public final M f5() {
        return (M) this.f14500X.getValue();
    }

    private final void g5() {
        setContentView((View) e5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            e5().f22615d.setNavigationIcon(drawable);
            e5().f22615d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        e5().f22615d.setNavigationOnClickListener(new C0879r5(this));
        TextView textView = e5().f22619h;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        e5().f22614c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        e5().f22614c.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        e5().f22614c.addItemDecoration(new B2.l(dimension, dimension));
        e5().f22617f.setTypeface(aVar.x());
        if (!com.uptodown.activities.preferences.a.f15150a.k0(this)) {
            e5().f22617f.setText(getString(R.string.msg_permissions_rollback));
        }
        e5().f22618g.setTypeface(aVar.x());
        e5().f22616e.setTypeface(aVar.x());
        e5().f22616e.setOnClickListener(new C0887s5(this));
        e5().f22613b.setOnClickListener(new C0895t5());
    }

    /* access modifiers changed from: private */
    public static final void h5(RollbackActivity rollbackActivity, View view) {
        rollbackActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void i5(RollbackActivity rollbackActivity, View view) {
        rollbackActivity.l5();
    }

    /* access modifiers changed from: private */
    public static final void j5(View view) {
    }

    /* access modifiers changed from: private */
    public final void k5(boolean z4) {
        f5().c(this, z4);
    }

    private final void l5() {
        this.f14502Z.launch(new Intent(getApplicationContext(), GdprPrivacySettings.class), UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: protected */
    public void M4() {
    }

    public void a(int i5) {
        C c5;
        if (UptodownApp.f13477F.Z() && (c5 = this.f14501Y) != null) {
            t.b(c5);
            if (i5 < c5.a().size()) {
                C c6 = this.f14501Y;
                t.b(c6);
                if (((C2655d) c6.a().get(i5)).b() != 0) {
                    C c7 = this.f14501Y;
                    t.b(c7);
                    Object obj = c7.a().get(i5);
                    t.d(obj, "get(...)");
                    K4((C2655d) obj);
                }
            }
        }
    }

    public void b(int i5) {
        C c5;
        if (UptodownApp.f13477F.Z() && (c5 = this.f14501Y) != null) {
            t.b(c5);
            if (i5 < c5.a().size()) {
                C c6 = this.f14501Y;
                t.b(c6);
                if (((C2655d) c6.a().get(i5)).b() != 0) {
                    C c7 = this.f14501Y;
                    t.b(c7);
                    H2(((C2655d) c7.a().get(i5)).b());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g5();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        k5(true);
    }
}
