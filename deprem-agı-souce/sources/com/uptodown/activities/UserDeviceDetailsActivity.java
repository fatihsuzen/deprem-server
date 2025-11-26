package com.uptodown.activities;

import O1.E6;
import O1.F6;
import O1.G6;
import O1.H6;
import O1.I6;
import O1.J6;
import O1.K6;
import O1.L6;
import O1.M6;
import O1.N6;
import O1.O6;
import R1.Q;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.q;
import W2.u;
import X2.C2250q;
import a3.C2265a;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
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
import com.uptodown.activities.e0;
import g2.C2389k;
import h2.C2450z;
import h2.j1;
import java.util.ArrayList;
import java.util.Comparator;
import k2.C2592b;
import k2.C2610u;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2667p;
import l2.X;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;
import z3.w;

public final class UserDeviceDetailsActivity extends C1598a {

    /* renamed from: Q  reason: collision with root package name */
    public static final a f14712Q = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14713K = W2.m.b(new E6(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14714L = new ViewModelLazy(M.b(e0.class), new o(this), new n(this), new p((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public Q f14715M;

    /* renamed from: N  reason: collision with root package name */
    private final b f14716N = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public final j f14717O = new j(this);
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public final i f14718P = new i(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements C2592b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f14719a;

        b(UserDeviceDetailsActivity userDeviceDetailsActivity) {
            this.f14719a = userDeviceDetailsActivity;
        }

        public void a(int i5) {
            if (this.f14719a.f14715M != null) {
                Q t32 = this.f14719a.f14715M;
                t.b(t32);
                String d5 = ((X.c) t32.a().get(i5)).d();
                if (d5 != null && d5.length() != 0) {
                    UserDeviceDetailsActivity userDeviceDetailsActivity = this.f14719a;
                    Q t33 = userDeviceDetailsActivity.f14715M;
                    t.b(t33);
                    String d6 = ((X.c) t33.a().get(i5)).d();
                    t.b(d6);
                    new C2389k(userDeviceDetailsActivity, d6, this.f14719a.f14718P, LifecycleOwnerKt.getLifecycleScope(this.f14719a));
                }
            }
        }

        public void b(int i5) {
        }
    }

    public static final class c implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((X.c) obj).b()), Long.valueOf(((X.c) obj2).b()));
        }
    }

    public static final class d implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((X.c) obj).b()), Long.valueOf(((X.c) obj2).b()));
        }
    }

    public static final class e implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((X.c) obj2).b()), Long.valueOf(((X.c) obj).b()));
        }
    }

    public static final class f implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((X.c) obj2).b()), Long.valueOf(((X.c) obj).b()));
        }
    }

    public static final class g implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((X.c) obj).b()), Long.valueOf(((X.c) obj2).b()));
        }
    }

    public static final class h implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((X.c) obj2).b()), Long.valueOf(((X.c) obj).b()));
        }
    }

    public static final class i implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f14720a;

        i(UserDeviceDetailsActivity userDeviceDetailsActivity) {
            this.f14720a = userDeviceDetailsActivity;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f14720a.isFinishing()) {
                Intent intent = new Intent(this.f14720a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                UserDeviceDetailsActivity userDeviceDetailsActivity = this.f14720a;
                userDeviceDetailsActivity.startActivity(intent, UptodownApp.f13477F.a(userDeviceDetailsActivity));
            }
        }

        public void d(int i5) {
            UserDeviceDetailsActivity userDeviceDetailsActivity = this.f14720a;
            String string = userDeviceDetailsActivity.getString(R.string.msg_app_not_found);
            t.d(string, "getString(...)");
            userDeviceDetailsActivity.u0(string);
        }
    }

    public static final class j extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f14721a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(UserDeviceDetailsActivity userDeviceDetailsActivity) {
            super(true);
            this.f14721a = userDeviceDetailsActivity;
        }

        public void handleOnBackPressed() {
            this.f14721a.finish();
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14722a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f14723b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDeviceDetailsActivity f14724a;

            a(UserDeviceDetailsActivity userDeviceDetailsActivity) {
                this.f14724a = userDeviceDetailsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (t.a(o5, O.a.f26507a)) {
                    this.f14724a.B3().f23259f.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    this.f14724a.z3(((e0.a) ((O.c) o5).a()).a());
                    this.f14724a.B3().f23259f.setVisibility(8);
                    this.f14724a.B3().f23258e.setVisibility(0);
                } else if (!t.a(o5, O.b.f26508a)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(UserDeviceDetailsActivity userDeviceDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14723b = userDeviceDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f14723b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14722a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14723b.C3().e();
                a aVar = new a(this.f14723b);
                this.f14722a = 1;
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
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14725a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f14726b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDeviceDetailsActivity f14727a;

            a(UserDeviceDetailsActivity userDeviceDetailsActivity) {
                this.f14727a = userDeviceDetailsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        String a5 = ((e0.b) cVar.a()).a();
                        if (!(a5 == null || a5.length() == 0)) {
                            this.f14727a.u0(((e0.b) cVar.a()).a());
                        }
                        if (((e0.b) cVar.a()).c() == 1) {
                            this.f14727a.B3().f23268o.setText(((e0.b) cVar.a()).b());
                            this.f14727a.setResult(3);
                        }
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(UserDeviceDetailsActivity userDeviceDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14726b = userDeviceDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new l(this.f14726b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14725a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f14726b.C3().f();
                a aVar = new a(this.f14726b);
                this.f14725a = 1;
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
            return ((l) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14728a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f14729b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDeviceDetailsActivity f14730a;

            a(UserDeviceDetailsActivity userDeviceDetailsActivity) {
                this.f14730a = userDeviceDetailsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        String b5 = ((e0.c) cVar.a()).b();
                        if (!(b5 == null || b5.length() == 0)) {
                            this.f14730a.u0(((e0.c) cVar.a()).b());
                        }
                        if (((e0.c) cVar.a()).c() == 1) {
                            C2667p pVar = new C2667p();
                            pVar.j(this.f14730a);
                            if (t.a(((e0.c) cVar.a()).a(), pVar.d())) {
                                this.f14730a.setResult(5);
                                this.f14730a.f14717O.handleOnBackPressed();
                            } else {
                                this.f14730a.setResult(4);
                                this.f14730a.f14717O.handleOnBackPressed();
                            }
                        }
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(UserDeviceDetailsActivity userDeviceDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14729b = userDeviceDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new m(this.f14729b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14728a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f14729b.C3().g();
                a aVar = new a(this.f14729b);
                this.f14728a = 1;
                if (g5.collect(aVar, this) == f5) {
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
            return ((m) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class n extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14731a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(ComponentActivity componentActivity) {
            super(0);
            this.f14731a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14731a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class o extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14732a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(ComponentActivity componentActivity) {
            super(0);
            this.f14732a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14732a.getViewModelStore();
        }
    }

    public static final class p extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14733a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14734b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14733a = aVar;
            this.f14734b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14733a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14734b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserDeviceDetailsActivity.p.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(UserDeviceDetailsActivity userDeviceDetailsActivity, X x4, RadioGroup radioGroup, int i5) {
        if (i5 == userDeviceDetailsActivity.B3().f23260g.getId()) {
            if (((Boolean) userDeviceDetailsActivity.C3().i().getValue()).booleanValue()) {
                ArrayList d5 = x4.d();
                if (d5.size() > 1) {
                    C2250q.t(d5, new e());
                }
            } else {
                ArrayList d6 = x4.d();
                if (d6.size() > 1) {
                    C2250q.t(d6, new c());
                }
            }
            Q q5 = userDeviceDetailsActivity.f14715M;
            if (q5 != null) {
                q5.d(x4.d());
            }
            RadioButton radioButton = userDeviceDetailsActivity.B3().f23260g;
            t.d(radioButton, "rbInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.K3(radioButton);
            RadioButton radioButton2 = userDeviceDetailsActivity.B3().f23261h;
            t.d(radioButton2, "rbNotInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.L3(radioButton2);
        } else if (i5 == userDeviceDetailsActivity.B3().f23261h.getId()) {
            if (((Boolean) userDeviceDetailsActivity.C3().i().getValue()).booleanValue()) {
                ArrayList h5 = x4.h();
                if (h5.size() > 1) {
                    C2250q.t(h5, new f());
                }
            } else {
                ArrayList h6 = x4.h();
                if (h6.size() > 1) {
                    C2250q.t(h6, new d());
                }
            }
            Q q6 = userDeviceDetailsActivity.f14715M;
            if (q6 != null) {
                q6.d(x4.h());
            }
            RadioButton radioButton3 = userDeviceDetailsActivity.B3().f23261h;
            t.d(radioButton3, "rbNotInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.K3(radioButton3);
            RadioButton radioButton4 = userDeviceDetailsActivity.B3().f23260g;
            t.d(radioButton4, "rbInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.L3(radioButton4);
        }
        userDeviceDetailsActivity.B3().f23263j.smoothScrollToPosition(0);
    }

    private final void D3(X x4) {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            B3().f23264k.setNavigationIcon(drawable);
            B3().f23264k.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        B3().f23264k.setNavigationOnClickListener(new H6(this));
        TextView textView = B3().f23278y;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        B3().f23264k.setNavigationOnClickListener(new I6(this));
        B3().f23268o.setTypeface(aVar.w());
        B3().f23274u.setTypeface(aVar.x());
        B3().f23275v.setTypeface(aVar.x());
        B3().f23265l.setTypeface(aVar.x());
        B3().f23266m.setTypeface(aVar.x());
        B3().f23271r.setTypeface(aVar.x());
        B3().f23272s.setTypeface(aVar.x());
        B3().f23269p.setTypeface(aVar.x());
        B3().f23270q.setTypeface(aVar.x());
        B3().f23277x.setTypeface(aVar.x());
        B3().f23276w.setTypeface(aVar.w());
        B3().f23267n.setTypeface(aVar.w());
        B3().f23260g.setTypeface(aVar.x());
        B3().f23261h.setTypeface(aVar.x());
        B3().f23276w.setOnClickListener(new J6(this, x4));
        B3().f23255b.setOnClickListener(new K6(this, x4));
        B3().f23256c.setOnClickListener(new L6(this));
        B3().f23268o.setText(x4.g());
        B3().f23275v.setText(x4.i());
        B3().f23266m.setText(x4.a());
        B3().f23272s.setText(x4.f());
        B3().f23270q.setText(new C2962v().o(x4.e()));
        B3().f23263j.setLayoutManager(new LinearLayoutManager(this, 1, false));
        B3().f23263j.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        B3().f23263j.addItemDecoration(new B2.l(dimension, dimension));
        C3().d(this, x4);
    }

    /* access modifiers changed from: private */
    public static final void E3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void F3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void G3(UserDeviceDetailsActivity userDeviceDetailsActivity, X x4, View view) {
        String string = userDeviceDetailsActivity.getString(R.string.unlink_device_confirmation);
        t.d(string, "getString(...)");
        userDeviceDetailsActivity.U1(string, new M6(userDeviceDetailsActivity, x4));
    }

    /* access modifiers changed from: private */
    public static final J H3(UserDeviceDetailsActivity userDeviceDetailsActivity, X x4) {
        userDeviceDetailsActivity.C3().k(userDeviceDetailsActivity, x4.b(), x4.c());
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void I3(UserDeviceDetailsActivity userDeviceDetailsActivity, X x4, View view) {
        userDeviceDetailsActivity.v3(x4);
    }

    /* access modifiers changed from: private */
    public static final void J3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        ArrayList a5;
        ArrayList a6;
        if (((Boolean) userDeviceDetailsActivity.C3().i().getValue()).booleanValue()) {
            Q q5 = userDeviceDetailsActivity.f14715M;
            if (!(q5 == null || (a6 = q5.a()) == null || a6.size() <= 1)) {
                C2250q.t(a6, new g());
            }
            Q q6 = userDeviceDetailsActivity.f14715M;
            if (q6 != null) {
                q6.notifyDataSetChanged();
            }
            userDeviceDetailsActivity.B3().f23256c.animate().rotation(180.0f).setDuration(200).start();
        } else {
            Q q7 = userDeviceDetailsActivity.f14715M;
            if (!(q7 == null || (a5 = q7.a()) == null || a5.size() <= 1)) {
                C2250q.t(a5, new h());
            }
            Q q8 = userDeviceDetailsActivity.f14715M;
            if (q8 != null) {
                q8.notifyDataSetChanged();
            }
            userDeviceDetailsActivity.B3().f23256c.animate().rotation(0.0f).setDuration(200).start();
        }
        userDeviceDetailsActivity.C3().i().setValue(Boolean.valueOf(!((Boolean) userDeviceDetailsActivity.C3().i().getValue()).booleanValue()));
        userDeviceDetailsActivity.B3().f23263j.setAdapter(userDeviceDetailsActivity.f14715M);
    }

    private final void K3(RadioButton radioButton) {
        radioButton.setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_checkbox_selected_button));
        radioButton.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_check_blue), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void L3(RadioButton radioButton) {
        radioButton.setBackground(ContextCompat.getDrawable(this, R.drawable.core_ripple_bg_card));
        radioButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: private */
    public static final j1 u3(UserDeviceDetailsActivity userDeviceDetailsActivity) {
        return j1.c(userDeviceDetailsActivity.getLayoutInflater());
    }

    private final void v3(X x4) {
        if (!isFinishing()) {
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2450z c5 = C2450z.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23695e;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.w());
            c5.f23694d.setTypeface(aVar.w());
            c5.f23694d.setOnClickListener(new N6(this, x4, c5));
            c5.f23693c.setTypeface(aVar.w());
            c5.f23693c.setOnClickListener(new O6(this));
            builder.setView(c5.getRoot());
            P2(builder.create());
            if (!isFinishing() && p2() != null) {
                b3();
                c5.f23692b.postDelayed(new F6(x4, c5, this), 100);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void w3(UserDeviceDetailsActivity userDeviceDetailsActivity, X x4, C2450z zVar, View view) {
        userDeviceDetailsActivity.C3().j(userDeviceDetailsActivity, x4.b(), zVar.f23692b.getText().toString());
        userDeviceDetailsActivity.o2();
    }

    /* access modifiers changed from: private */
    public static final void x3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        userDeviceDetailsActivity.o2();
    }

    /* access modifiers changed from: private */
    public static final void y3(X x4, C2450z zVar, UserDeviceDetailsActivity userDeviceDetailsActivity) {
        String g5 = x4.g();
        if (!(g5 == null || g5.length() == 0)) {
            zVar.f23692b.requestFocus();
            zVar.f23692b.setText(x4.g());
            zVar.f23692b.selectAll();
        }
        EditText editText = zVar.f23692b;
        t.d(editText, "etDialogRename");
        userDeviceDetailsActivity.showKeyboard(editText);
    }

    /* access modifiers changed from: private */
    public final void z3(X x4) {
        B3().f23268o.setText(x4.g());
        B3().f23266m.setText(x4.a());
        B3().f23272s.setText(x4.f());
        if (x4.k() > 0) {
            B3().f23257d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_unchecked));
        } else {
            B3().f23257d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_checked));
        }
        B3().f23262i.setOnCheckedChangeListener(new G6(this, x4));
        this.f14715M = new Q(x4.d(), this.f14716N);
        B3().f23263j.setAdapter(this.f14715M);
    }

    public final j1 B3() {
        return (j1) this.f14713K.getValue();
    }

    public final e0 C3() {
        return (e0) this.f14714L.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        setContentView((View) B3().getRoot());
        getOnBackPressedDispatcher().addCallback(this.f14717O);
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user_device"))) {
            w h5 = C3().h();
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable("user_device", X.class);
            } else {
                parcelable = extras.getParcelable("user_device");
            }
            t.b(parcelable);
            h5.setValue(parcelable);
            D3((X) C3().h().getValue());
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new k(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new l(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new m(this, (C2308e) null), 2, (Object) null);
    }
}
