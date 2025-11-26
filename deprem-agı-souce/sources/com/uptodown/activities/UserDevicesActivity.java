package com.uptodown.activities;

import O1.P6;
import O1.Q6;
import O1.R6;
import O1.S6;
import R1.S;
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
import com.uptodown.activities.f0;
import h2.l1;
import k2.O;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.X;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;

public final class UserDevicesActivity extends C1598a {

    /* renamed from: N  reason: collision with root package name */
    public static final a f14735N = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14736K = m.b(new R6(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14737L = new ViewModelLazy(M.b(f0.class), new d(this), new c(this), new e((C2616a) null, this));

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f14738M;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14739a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDevicesActivity f14740b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDevicesActivity f14741a;

            /* renamed from: com.uptodown.activities.UserDevicesActivity$b$a$a  reason: collision with other inner class name */
            public static final class C0142a implements O {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ UserDevicesActivity f14742a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ z2.O f14743b;

                C0142a(UserDevicesActivity userDevicesActivity, z2.O o5) {
                    this.f14742a = userDevicesActivity;
                    this.f14743b = o5;
                }

                public void a(int i5) {
                    UserDevicesActivity userDevicesActivity = this.f14742a;
                    Object obj = ((f0.a) ((O.c) this.f14743b).a()).b().get(i5);
                    t.d(obj, "get(...)");
                    userDevicesActivity.q3((X) obj);
                }
            }

            a(UserDevicesActivity userDevicesActivity) {
                this.f14741a = userDevicesActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (t.a(o5, O.a.f26507a)) {
                    this.f14741a.m3().f23330b.setVisibility(0);
                    this.f14741a.m3().f23331c.setVisibility(8);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    this.f14741a.r3(((f0.a) cVar.a()).a());
                    if (!((f0.a) cVar.a()).b().isEmpty()) {
                        this.f14741a.m3().f23332d.setAdapter(new S(((f0.a) cVar.a()).b(), new C0142a(this.f14741a, o5)));
                    } else {
                        this.f14741a.m3().f23334f.setVisibility(8);
                    }
                    this.f14741a.m3().f23330b.setVisibility(8);
                    this.f14741a.m3().f23331c.setVisibility(0);
                } else if (!t.a(o5, O.b.f26508a)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UserDevicesActivity userDevicesActivity, C2308e eVar) {
            super(2, eVar);
            this.f14740b = userDevicesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14740b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14739a;
            if (i5 == 0) {
                u.b(obj);
                D c5 = this.f14740b.n3().c();
                a aVar = new a(this.f14740b);
                this.f14739a = 1;
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14744a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f14744a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14744a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14745a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f14745a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14745a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14746a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14747b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14746a = aVar;
            this.f14747b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14746a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14747b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserDevicesActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public UserDevicesActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new S6(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14738M = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final l1 l3(UserDevicesActivity userDevicesActivity) {
        return l1.c(userDevicesActivity.getLayoutInflater());
    }

    private final void o3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            m3().f23333e.setNavigationIcon(drawable);
            m3().f23333e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        m3().f23333e.setNavigationOnClickListener(new Q6(this));
        TextView textView = m3().f23336h;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        m3().f23335g.setTypeface(aVar.x());
        m3().f23334f.setTypeface(aVar.x());
        m3().f23332d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        m3().f23332d.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        m3().f23332d.addItemDecoration(new B2.l(dimension, dimension));
    }

    /* access modifiers changed from: private */
    public static final void p3(UserDevicesActivity userDevicesActivity, View view) {
        userDevicesActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public final void q3(X x4) {
        Intent intent = new Intent(this, UserDeviceDetailsActivity.class);
        intent.putExtra("user_device", x4);
        this.f14738M.launch(intent, UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: private */
    public final void r3(X x4) {
        TextView textView = m3().f23337i.f23291f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        m3().f23337i.f23290e.setTypeface(aVar.x());
        m3().f23337i.f23291f.setText(x4.g());
        m3().f23337i.f23290e.setText(new C2962v().p(x4.e()));
        m3().f23337i.getRoot().setOnClickListener(new P6(this, x4));
    }

    /* access modifiers changed from: private */
    public static final void s3(UserDevicesActivity userDevicesActivity, X x4, View view) {
        userDevicesActivity.q3(x4);
    }

    /* access modifiers changed from: private */
    public static final void t3(UserDevicesActivity userDevicesActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 3 || resultCode == 4) {
            userDevicesActivity.n3().b(userDevicesActivity);
        } else if (resultCode == 5) {
            userDevicesActivity.setResult(5);
            userDevicesActivity.finish();
        }
    }

    public final l1 m3() {
        return (l1) this.f14736K.getValue();
    }

    public final f0 n3() {
        return (f0) this.f14737L.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) m3().getRoot());
        o3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        n3().b(this);
    }
}
