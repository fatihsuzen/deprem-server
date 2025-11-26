package com.uptodown.activities;

import O1.C0885s3;
import O1.C0893t3;
import O1.C0901u3;
import O1.C0909v3;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
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
import b3.C2308e;
import c3.C2316b;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1621y;
import com.uptodown.workers.SendUserUsageStatsWorker;
import h2.C2424l0;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.V;
import l2.W;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z2.P;
import z2.X;
import z3.C2973f;
import z3.D;

public final class MyStatsActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14211K = m.b(new C0885s3(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14212L = new ViewModelLazy(M.b(C1621y.class), new c(this), new b(this), new d((C2616a) null, this));

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f14213M;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14214a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyStatsActivity f14215b;

        /* renamed from: com.uptodown.activities.MyStatsActivity$a$a  reason: collision with other inner class name */
        static final class C0129a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyStatsActivity f14216a;

            C0129a(MyStatsActivity myStatsActivity) {
                this.f14216a = myStatsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        this.f14216a.u3(((C1621y.a) ((O.c) o5).a()).a());
                        this.f14216a.o3().f23308f.setVisibility(0);
                        this.f14216a.o3().f23302D.setBackground(ContextCompat.getDrawable(this.f14216a, R.drawable.shape_bg_gradient_my_stats));
                        this.f14216a.o3().f23302D.setVisibility(0);
                        this.f14216a.o3().f23307e.setVisibility(8);
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MyStatsActivity myStatsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14215b = myStatsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14215b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14214a;
            if (i5 == 0) {
                u.b(obj);
                D c5 = this.f14215b.p3().c();
                C0129a aVar = new C0129a(this.f14215b);
                this.f14214a = 1;
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

    public static final class b extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14217a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.f14217a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14217a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class c extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14218a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f14218a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14218a.getViewModelStore();
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14219a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14220b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14219a = aVar;
            this.f14220b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14219a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14220b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyStatsActivity.d.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public MyStatsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0893t3(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14213M = registerForActivityResult;
    }

    private final void m3() {
        int color = ContextCompat.getColor(this, R.color.turbo_main);
        int color2 = ContextCompat.getColor(this, R.color.main_blue);
        TextView textView = o3().f23328z;
        t.d(textView, "tvTotalDownloadsValueMyStats");
        String obj = textView.getText().toString();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, textView.getPaint().measureText(o3().f23328z.getText().toString()), (float) textView.getHeight(), new int[]{color, color2}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        SpannableString spannableString = new SpannableString(obj);
        spannableString.setSpan(new C2962v.a.C0266a(linearGradient, getResources().getDimension(R.dimen.font_size_46)), 0, o3().f23328z.length(), 33);
        textView.setText(spannableString);
    }

    /* access modifiers changed from: private */
    public static final C2424l0 n3(MyStatsActivity myStatsActivity) {
        return C2424l0.c(myStatsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C2424l0 o3() {
        return (C2424l0) this.f14211K.getValue();
    }

    /* access modifiers changed from: private */
    public final C1621y p3() {
        return (C1621y) this.f14212L.getValue();
    }

    private final void q3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o3().f23309g.setNavigationIcon(drawable);
            o3().f23309g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        o3().f23309g.setNavigationOnClickListener(new C0901u3(this));
        TextView textView = o3().f23326x;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        o3().f23327y.setTypeface(aVar.w());
        o3().f23328z.setTypeface(aVar.w());
        o3().f23311i.setTypeface(aVar.x());
        o3().f23312j.setTypeface(aVar.w());
        o3().f23299A.setTypeface(aVar.x());
        o3().f23300B.setTypeface(aVar.w());
        o3().f23310h.setTypeface(aVar.x());
        o3().f23323u.setTypeface(aVar.w());
        o3().f23324v.setTypeface(aVar.w());
        o3().f23315m.setTypeface(aVar.w());
        o3().f23316n.setTypeface(aVar.w());
        o3().f23321s.setTypeface(aVar.w());
        o3().f23322t.setTypeface(aVar.w());
        o3().f23313k.setTypeface(aVar.w());
        o3().f23314l.setTypeface(aVar.w());
        o3().f23319q.setTypeface(aVar.w());
        o3().f23320r.setTypeface(aVar.w());
        o3().f23317o.setTypeface(aVar.w());
        o3().f23318p.setTypeface(aVar.w());
        o3().f23301C.setTypeface(aVar.w());
        o3().f23325w.setTypeface(aVar.w());
        o3().f23307e.setOnClickListener(new C0909v3());
    }

    /* access modifiers changed from: private */
    public static final void r3(MyStatsActivity myStatsActivity, View view) {
        myStatsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void s3(View view) {
    }

    private final void t3() {
        p3().b(this);
    }

    /* access modifiers changed from: private */
    public final void u3(W w4) {
        String a5 = w4.a();
        if (!(a5 == null || a5.length() == 0)) {
            s.h().l(V.f24870q.d(w4.b())).n(UptodownApp.f13477F.i0(this)).i(o3().f23304b);
            o3().f23304b.setBackground(ContextCompat.getDrawable(this, R.drawable.shadow_user_icon));
        }
        if (w4.m()) {
            C2962v.a aVar = C2962v.f26557a;
            ImageView imageView = o3().f23304b;
            t.d(imageView, "ivUserAvatarMyStats");
            aVar.c(imageView);
        }
        X x4 = new X();
        x4.j(this);
        o3().f23328z.setText(new C2962v().k(x4.a() + w4.c()));
        m3();
        o3().f23312j.setText(new C2962v().k(x4.b() + w4.d()));
        o3().f23300B.setText(new C2962v().k(x4.c() + w4.k()));
        o3().f23324v.setText(String.valueOf(w4.j()));
        o3().f23316n.setText(String.valueOf(w4.e()));
        o3().f23322t.setText(String.valueOf(w4.h()));
        o3().f23314l.setText(String.valueOf(w4.f()));
        o3().f23320r.setText(String.valueOf(w4.i()));
        o3().f23318p.setText(String.valueOf(w4.g()));
        o3().f23325w.setText(P.f26510a.b(x4.d() + w4.l(), this));
    }

    /* access modifiers changed from: private */
    public static final void v3(MyStatsActivity myStatsActivity, ActivityResult activityResult) {
        if (X.f26521e.a(myStatsActivity)) {
            myStatsActivity.q3();
            myStatsActivity.t3();
            new X().l(myStatsActivity, true);
            SendUserUsageStatsWorker.f21410b.b(myStatsActivity);
            return;
        }
        SendUserUsageStatsWorker.f21410b.a(myStatsActivity);
        myStatsActivity.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) o3().getRoot());
        if (!X.f26521e.a(this)) {
            this.f14213M.launch(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        } else {
            SendUserUsageStatsWorker.f21410b.b(this);
            q3();
            t3();
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new a(this, (C2308e) null), 2, (Object) null);
    }
}
