package com.uptodown.activities;

import O1.C0882s0;
import O1.C0890t0;
import O1.C0898u0;
import O1.C0906v0;
import O1.C0914w0;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import b3.C2308e;
import c3.C2316b;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1612o;
import h2.C2408d0;
import h2.C2410e0;
import i2.f2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2660i;
import l2.C2671u;
import l2.V;
import l2.Y;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class ListsActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13930K = m.b(new C0906v0(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f13931L = new ViewModelLazy(M.b(C1612o.class), new f(this), new e(this), new g((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public final ActivityResultLauncher f13932M;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13933a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ListsActivity f13934b;

        /* renamed from: com.uptodown.activities.ListsActivity$a$a  reason: collision with other inner class name */
        static final class C0125a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ListsActivity f13935a;

            C0125a(ListsActivity listsActivity) {
                this.f13935a = listsActivity;
            }

            /* access modifiers changed from: private */
            public static final void d(ListsActivity listsActivity, View view) {
                listsActivity.f13932M.launch(new Intent(listsActivity, WishlistActivity.class), UptodownApp.f13477F.b(listsActivity));
            }

            /* renamed from: c */
            public final Object emit(O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        if (!this.f13935a.u3().p()) {
                            O.c cVar = (O.c) o5;
                            if (!((C1612o.a) cVar.a()).b().isEmpty()) {
                                int i5 = 0;
                                for (Y y4 : ((C1612o.a) cVar.a()).b()) {
                                    int i6 = i5 + 1;
                                    if (i5 == 0) {
                                        s.h().l(y4.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f13935a)).i(this.f13935a.t3().f22903g.f22962b);
                                    } else {
                                        String d5 = y4.d();
                                        if (!(d5 == null || d5.length() == 0)) {
                                            ListsActivity listsActivity = this.f13935a;
                                            String e5 = y4.e();
                                            t.b(e5);
                                            LinearLayout linearLayout = this.f13935a.t3().f22903g.f22964d;
                                            t.d(linearLayout, "llAppsContainer");
                                            listsActivity.p3(e5, linearLayout, i5);
                                        }
                                    }
                                    i5 = i6;
                                }
                            } else {
                                this.f13935a.t3().f22903g.f22962b.setImageDrawable(ContextCompat.getDrawable(this.f13935a, R.drawable.shape_bg_placeholder));
                            }
                            this.f13935a.u3().t(true);
                            this.f13935a.t3().f22903g.f22967g.setText(this.f13935a.v3(((C1612o.a) cVar.a()).a()));
                            this.f13935a.t3().f22903g.f22966f.setVisibility(0);
                            this.f13935a.t3().f22903g.f22965e.setVisibility(8);
                            this.f13935a.t3().f22904h.setVisibility(8);
                            this.f13935a.t3().f22903g.getRoot().setOnClickListener(new C1609l(this.f13935a));
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ListsActivity listsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13934b = listsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f13934b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13933a;
            if (i5 == 0) {
                u.b(obj);
                D l5 = this.f13934b.u3().l();
                C0125a aVar = new C0125a(this.f13934b);
                this.f13933a = 1;
                if (l5.collect(aVar, this) == f5) {
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
        int f13936a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ListsActivity f13937b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ListsActivity f13938a;

            a(ListsActivity listsActivity) {
                this.f13938a = listsActivity;
            }

            /* access modifiers changed from: private */
            public static final void d(ListsActivity listsActivity, View view) {
                listsActivity.startActivity(new Intent(listsActivity, RecommendedActivity.class));
            }

            /* renamed from: c */
            public final Object emit(O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        if (!this.f13938a.u3().o()) {
                            O.c cVar = (O.c) o5;
                            if (!((C1612o.a) cVar.a()).b().isEmpty()) {
                                int i5 = 0;
                                for (Y y4 : ((C1612o.a) cVar.a()).b()) {
                                    int i6 = i5 + 1;
                                    if (i5 == 0) {
                                        s.h().l(y4.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f13938a)).i(this.f13938a.t3().f22902f.f22962b);
                                    } else {
                                        String d5 = y4.d();
                                        if (!(d5 == null || d5.length() == 0)) {
                                            ListsActivity listsActivity = this.f13938a;
                                            String e5 = y4.e();
                                            t.b(e5);
                                            LinearLayout linearLayout = this.f13938a.t3().f22902f.f22964d;
                                            t.d(linearLayout, "llAppsContainer");
                                            listsActivity.p3(e5, linearLayout, i5);
                                        }
                                    }
                                    i5 = i6;
                                }
                            } else {
                                this.f13938a.t3().f22902f.f22962b.setImageDrawable(ContextCompat.getDrawable(this.f13938a, R.drawable.shape_bg_placeholder));
                            }
                            this.f13938a.u3().s(true);
                            this.f13938a.t3().f22902f.f22967g.setText(this.f13938a.v3(((C1612o.a) cVar.a()).a()));
                            this.f13938a.t3().f22902f.f22966f.setVisibility(0);
                            this.f13938a.t3().f22902f.f22965e.setVisibility(8);
                            this.f13938a.t3().f22904h.setVisibility(8);
                            this.f13938a.t3().f22902f.getRoot().setOnClickListener(new C1610m(this.f13938a));
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ListsActivity listsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13937b = listsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13937b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13936a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f13937b.u3().j();
                a aVar = new a(this.f13937b);
                this.f13936a = 1;
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
        int f13939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ListsActivity f13940b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ListsActivity f13941a;

            a(ListsActivity listsActivity) {
                this.f13941a = listsActivity;
            }

            /* access modifiers changed from: private */
            public static final void d(ListsActivity listsActivity, View view) {
                listsActivity.startActivity(new Intent(listsActivity, PreregistrationActivity.class), UptodownApp.f13477F.a(listsActivity));
            }

            /* renamed from: c */
            public final Object emit(O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        if (!this.f13941a.u3().n()) {
                            O.c cVar = (O.c) o5;
                            if (!((C1612o.b) cVar.a()).b().isEmpty()) {
                                int i5 = 0;
                                for (C2647G g5 : ((C1612o.b) cVar.a()).b()) {
                                    int i6 = i5 + 1;
                                    if (i5 == 0) {
                                        s.h().l(g5.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f13941a)).i(this.f13941a.t3().f22901e.f22962b);
                                    } else {
                                        String e5 = g5.e();
                                        if (!(e5 == null || e5.length() == 0)) {
                                            ListsActivity listsActivity = this.f13941a;
                                            String e6 = g5.e();
                                            t.b(e6);
                                            LinearLayout linearLayout = this.f13941a.t3().f22901e.f22964d;
                                            t.d(linearLayout, "llAppsContainer");
                                            listsActivity.p3(e6, linearLayout, i5);
                                        }
                                    }
                                    i5 = i6;
                                }
                            } else {
                                this.f13941a.t3().f22901e.f22962b.setImageDrawable(ContextCompat.getDrawable(this.f13941a, R.drawable.shape_bg_placeholder));
                            }
                            this.f13941a.u3().r(true);
                            this.f13941a.t3().f22901e.f22967g.setText(this.f13941a.v3(((C1612o.b) cVar.a()).a()));
                            this.f13941a.t3().f22901e.f22966f.setVisibility(0);
                            this.f13941a.t3().f22901e.f22965e.setVisibility(8);
                            this.f13941a.t3().f22904h.setVisibility(8);
                            this.f13941a.t3().f22901e.getRoot().setOnClickListener(new C1611n(this.f13941a));
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ListsActivity listsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13940b = listsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13940b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13939a;
            if (i5 == 0) {
                u.b(obj);
                D i6 = this.f13940b.u3().i();
                a aVar = new a(this.f13940b);
                this.f13939a = 1;
                if (i6.collect(aVar, this) == f5) {
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
        int f13942a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ListsActivity f13943b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ListsActivity f13944a;

            a(ListsActivity listsActivity) {
                this.f13944a = listsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        if (!this.f13944a.u3().m()) {
                            O.c cVar = (O.c) o5;
                            if (!((Collection) cVar.a()).isEmpty()) {
                                Iterator it = ((ArrayList) cVar.a()).iterator();
                                t.d(it, "iterator(...)");
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    t.d(next, "next(...)");
                                    this.f13944a.q3((C2671u) next);
                                }
                            }
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ListsActivity listsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13943b = listsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13943b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13942a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f13943b.u3().g();
                a aVar = new a(this.f13943b);
                this.f13942a = 1;
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13945a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f13945a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f13945a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13946a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f13946a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f13946a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f13947a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13948b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f13947a = aVar;
            this.f13948b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f13947a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f13948b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.ListsActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public ListsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0914w0(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f13932M = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final C2408d0 o3(ListsActivity listsActivity) {
        return C2408d0.c(listsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public static final void r3(C2671u uVar, ListsActivity listsActivity, View view) {
        C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
        iVar.w(uVar.b());
        iVar.x(uVar.d());
        iVar.v(true);
        listsActivity.A3(iVar);
    }

    /* access modifiers changed from: private */
    public static final void s3(ListsActivity listsActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1) {
            listsActivity.setResult(1);
            listsActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final C2408d0 t3() {
        return (C2408d0) this.f13930K.getValue();
    }

    /* access modifiers changed from: private */
    public final C1612o u3() {
        return (C1612o) this.f13931L.getValue();
    }

    /* access modifiers changed from: private */
    public final String v3(int i5) {
        if (i5 == 1) {
            String string = getString(R.string.apps_count_1);
            t.d(string, "getString(...)");
            return string;
        }
        String string2 = getString(R.string.apps_count, new Object[]{String.valueOf(i5)});
        t.d(string2, "getString(...)");
        return string2;
    }

    private final void w3() {
        setContentView((View) t3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        C2408d0 t32 = t3();
        if (drawable != null) {
            t32.f22905i.setNavigationIcon(drawable);
            t32.f22905i.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t32.f22905i.setNavigationOnClickListener(new C0890t0(this));
        TextView textView = t32.f22906j;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        t32.f22903g.f22968h.setTypeface(aVar.w());
        t32.f22903g.f22967g.setTypeface(aVar.x());
        t32.f22903g.f22968h.setText(getString(R.string.my_wishlist));
        t32.f22902f.f22968h.setTypeface(aVar.w());
        t32.f22902f.f22967g.setTypeface(aVar.x());
        t32.f22902f.f22968h.setText(getString(R.string.my_recommended_apps));
        t32.f22901e.f22968h.setTypeface(aVar.w());
        t32.f22901e.f22967g.setTypeface(aVar.x());
        t32.f22901e.f22968h.setText(getString(R.string.my_preregistrations));
        t32.f22904h.setOnClickListener(new C0898u0());
    }

    /* access modifiers changed from: private */
    public static final void x3(ListsActivity listsActivity, View view) {
        listsActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void y3(View view) {
    }

    private final void z3() {
        V h5 = V.f24870q.h(this);
        if (h5 != null && h5.p(this)) {
            u3().f(this);
        }
    }

    public final void A3(C2660i iVar) {
        t.e(iVar, "category");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add((int) R.id.fl_lists, (Fragment) f2.f24166k.a(iVar), (String) null).addToBackStack(String.valueOf(iVar.c())).commit();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new a(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused4 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        z3();
    }

    public final void p3(String str, LinearLayout linearLayout, int i5) {
        t.e(str, "iconUrl");
        t.e(linearLayout, "llParent");
        ImageView imageView = new ImageView(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.icon_size_l);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins((int) getResources().getDimension(R.dimen.lists_items_iv_margin), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setContentDescription((CharSequence) null);
        imageView.setElevation(getResources().getDimension(R.dimen.button_elevation));
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_logo_google));
        imageView.setElevation(-((float) i5));
        s.h().l(str).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this)).i(imageView);
        linearLayout.addView(imageView);
    }

    public final void q3(C2671u uVar) {
        t.e(uVar, "favoriteCategory");
        C2410e0 c5 = C2410e0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        c5.f22968h.setTypeface(k.f32g.w());
        c5.f22968h.setText(uVar.d());
        int i5 = 0;
        for (String str : uVar.c()) {
            int i6 = i5 + 1;
            if (i5 == 0) {
                s.h().l(str).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this)).i(c5.f22962b);
            } else if (str.length() > 0) {
                LinearLayout linearLayout = c5.f22964d;
                t.d(linearLayout, "llAppsContainer");
                p3(str, linearLayout, i5);
            }
            i5 = i6;
        }
        u3().q(true);
        c5.f22967g.setText(v3(uVar.a()));
        c5.f22967g.setTypeface(k.f32g.x());
        c5.f22966f.setVisibility(0);
        c5.f22965e.setVisibility(8);
        t3().f22904h.setVisibility(8);
        c5.getRoot().setOnClickListener(new C0882s0(uVar, this));
        t3().f22899c.addView(c5.getRoot());
    }
}
