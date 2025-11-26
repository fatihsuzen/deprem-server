package com.uptodown.activities;

import B2.o;
import B2.v;
import O1.C0750b5;
import O1.C0759c5;
import O1.C0768d5;
import O1.C0776e5;
import O1.C0784f5;
import O1.C0792g5;
import O1.C0800h5;
import O1.C0808i5;
import O1.C0816j5;
import O1.C0824k5;
import O1.C0832l5;
import O1.C0840m5;
import O1.C0848n5;
import O1.C0856o5;
import R1.B;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c3.C2316b;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.L;
import g2.C2391m;
import h2.P0;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2589F;
import k2.N;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.O;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2954m;
import z2.O;
import z2.P;
import z3.C2973f;
import z3.D;
import z3.w;

public final class ReviewsActivity extends C1598a {

    /* renamed from: P  reason: collision with root package name */
    public static final a f14475P = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14476K = m.b(new C0750b5(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14477L = new ViewModelLazy(M.b(L.class), new h(this), new g(this), new i((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public B f14478M;

    /* renamed from: N  reason: collision with root package name */
    private final f f14479N = new f(this);

    /* renamed from: O  reason: collision with root package name */
    private final ActivityResultLauncher f14480O;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14481a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f14482b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f14483a;

            a(ReviewsActivity reviewsActivity) {
                this.f14483a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (t.a(o5, O.a.f26507a)) {
                    this.f14483a.B3().v(true);
                    if (this.f14483a.f14478M == null) {
                        this.f14483a.z3().f22593m.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    this.f14483a.B3().v(false);
                    if (this.f14483a.f14478M == null) {
                        this.f14483a.Q3(((L.b) ((O.c) o5).a()).a());
                        this.f14483a.z3().f22597q.setAdapter(this.f14483a.f14478M);
                    } else {
                        Iterator it = ((L.b) ((O.c) o5).a()).a().iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            B t32 = this.f14483a.f14478M;
                            t.b(t32);
                            t32.a((l2.O) next);
                        }
                    }
                    B t33 = this.f14483a.f14478M;
                    if (t33 != null) {
                        t33.c(false);
                    }
                    this.f14483a.z3().f22593m.setVisibility(8);
                } else if (!t.a(o5, O.b.f26508a)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReviewsActivity reviewsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14482b = reviewsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14482b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14481a;
            if (i5 == 0) {
                u.b(obj);
                D i6 = this.f14482b.B3().i();
                a aVar = new a(this.f14482b);
                this.f14481a = 1;
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f14485b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f14486a;

            a(ReviewsActivity reviewsActivity) {
                this.f14486a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (t.a(o5, O.a.f26507a)) {
                    this.f14486a.B3().v(true);
                    this.f14486a.z3().f22593m.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((L.c) cVar.a()).b() == 1) {
                        ReviewsActivity reviewsActivity = this.f14486a;
                        String string = reviewsActivity.getString(R.string.review_sended);
                        t.d(string, "getString(...)");
                        reviewsActivity.u0(string);
                        this.f14486a.z3().f22582b.setText("");
                    } else if (((L.c) cVar.a()).a() == 403) {
                        ReviewsActivity reviewsActivity2 = this.f14486a;
                        String string2 = reviewsActivity2.getString(R.string.email_validation_msg);
                        t.d(string2, "getString(...)");
                        reviewsActivity2.u0(string2);
                    } else if (((L.c) cVar.a()).b() == 0 && ((L.c) cVar.a()).a() == 0) {
                        ReviewsActivity reviewsActivity3 = this.f14486a;
                        String string3 = reviewsActivity3.getString(R.string.error_review_already_submitted);
                        t.d(string3, "getString(...)");
                        reviewsActivity3.u0(string3);
                    } else {
                        ReviewsActivity reviewsActivity4 = this.f14486a;
                        String string4 = reviewsActivity4.getString(R.string.error_generico);
                        t.d(string4, "getString(...)");
                        reviewsActivity4.u0(string4);
                    }
                } else if (!t.a(o5, O.b.f26508a)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ReviewsActivity reviewsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14485b = reviewsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14485b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14484a;
            if (i5 == 0) {
                u.b(obj);
                D r5 = this.f14485b.B3().r();
                a aVar = new a(this.f14485b);
                this.f14484a = 1;
                if (r5.collect(aVar, this) == f5) {
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
        int f14487a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f14488b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f14489a;

            a(ReviewsActivity reviewsActivity) {
                this.f14489a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((O.c) cVar.a()).b() == 1) {
                            B t32 = this.f14489a.f14478M;
                            if (t32 != null) {
                                t32.d(((O.c) cVar.a()).a());
                            }
                        } else {
                            ReviewsActivity reviewsActivity = this.f14489a;
                            String string = reviewsActivity.getString(R.string.error_generico);
                            t.d(string, "getString(...)");
                            reviewsActivity.u0(string);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ReviewsActivity reviewsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14488b = reviewsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14488b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14487a;
            if (i5 == 0) {
                u.b(obj);
                D p5 = this.f14488b.B3().p();
                a aVar = new a(this.f14488b);
                this.f14487a = 1;
                if (p5.collect(aVar, this) == f5) {
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
        int f14490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f14491b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f14492a;

            a(ReviewsActivity reviewsActivity) {
                this.f14492a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        B t32 = this.f14492a.f14478M;
                        if (t32 != null) {
                            O.c cVar = (O.c) o5;
                            l2.O o6 = (l2.O) t32.b().get(((L.a) cVar.a()).b());
                            if (o6 != null) {
                                o6.v(((L.a) cVar.a()).a());
                            }
                        }
                        B t33 = this.f14492a.f14478M;
                        if (t33 != null) {
                            t33.notifyItemChanged(((L.a) ((O.c) o5).a()).b());
                        }
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ReviewsActivity reviewsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14491b = reviewsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14491b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14490a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f14491b.B3().j();
                a aVar = new a(this.f14491b);
                this.f14490a = 1;
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f implements C2589F {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f14493a;

        public static final class a implements N {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f14494a;

            a(ReviewsActivity reviewsActivity) {
                this.f14494a = reviewsActivity;
            }

            public void a() {
            }

            public void b(V v5) {
                t.e(v5, "user");
                Intent intent = new Intent(this.f14494a, PublicProfileActivity.class);
                intent.putExtra("user", v5);
                ReviewsActivity reviewsActivity = this.f14494a;
                reviewsActivity.startActivity(intent, UptodownApp.f13477F.a(reviewsActivity));
            }
        }

        f(ReviewsActivity reviewsActivity) {
            this.f14493a = reviewsActivity;
        }

        public void a(int i5) {
            l2.O o5;
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (V.f24870q.h(this.f14493a) != null) {
                B t32 = this.f14493a.f14478M;
                if (t32 != null) {
                    o5 = (l2.O) t32.b().get(i5);
                } else {
                    o5 = null;
                }
                if (o5 != null) {
                    this.f14493a.B3().g(this.f14493a, o5.f(), String.valueOf(o5.m()), i5);
                    return;
                }
                return;
            }
            this.f14493a.R3();
        }

        public void b(int i5) {
            l2.O o5;
            ArrayList b5;
            B t32 = this.f14493a.f14478M;
            if (t32 == null || (b5 = t32.b()) == null) {
                o5 = null;
            } else {
                o5 = (l2.O) b5.get(i5);
            }
            if (UptodownApp.f13477F.Z() && o5 != null && !l2.O.f24814p.d(o5.g())) {
                this.f14493a.B3().s(this.f14493a, o5);
            }
        }

        public void c() {
            this.f14493a.d3();
        }

        public void d(int i5) {
            l2.O o5;
            ArrayList b5;
            if (UptodownApp.f13477F.Z()) {
                B t32 = this.f14493a.f14478M;
                if (t32 == null || (b5 = t32.b()) == null) {
                    o5 = null;
                } else {
                    o5 = (l2.O) b5.get(i5);
                }
                if (o5 != null) {
                    ReviewsActivity reviewsActivity = this.f14493a;
                    C2391m mVar = new C2391m(reviewsActivity, LifecycleOwnerKt.getLifecycleScope(reviewsActivity));
                    String m5 = o5.m();
                    t.b(m5);
                    mVar.c(m5, new a(this.f14493a));
                }
            }
        }

        public void e(int i5) {
            l2.O o5;
            String str;
            ArrayList b5;
            B t32 = this.f14493a.f14478M;
            String str2 = null;
            if (t32 == null || (b5 = t32.b()) == null) {
                o5 = null;
            } else {
                o5 = (l2.O) b5.get(i5);
            }
            Intent intent = new Intent(this.f14493a, RepliesActivity.class);
            intent.putExtra("review", o5);
            C2657f fVar = (C2657f) this.f14493a.B3().h().getValue();
            if (fVar != null) {
                str = fVar.E();
            } else {
                str = null;
            }
            intent.putExtra("appIconUrl", str);
            C2657f fVar2 = (C2657f) this.f14493a.B3().h().getValue();
            if (fVar2 != null) {
                str2 = fVar2.N();
            }
            if (!(str2 == null || str2.length() == 0)) {
                Object value = this.f14493a.B3().h().getValue();
                t.b(value);
                intent.putExtra("appName", ((C2657f) value).N());
            }
            ReviewsActivity reviewsActivity = this.f14493a;
            reviewsActivity.startActivity(intent, UptodownApp.f13477F.a(reviewsActivity));
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14495a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14495a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14495a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14496a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f14496a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14496a.getViewModelStore();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14498b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14497a = aVar;
            this.f14498b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14497a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14498b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.ReviewsActivity.i.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public ReviewsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0792g5(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14480O = registerForActivityResult;
    }

    private final void A3() {
        if (B3().k()) {
            B3().e(this);
        }
    }

    /* access modifiers changed from: private */
    public final L B3() {
        return (L) this.f14477L.getValue();
    }

    private final void C3() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            z3().f22598r.setNavigationIcon(drawable);
            z3().f22598r.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        z3().f22598r.setNavigationOnClickListener(new C0800h5(this));
        C2954m mVar = new C2954m();
        C2657f fVar = (C2657f) B3().h().getValue();
        String str6 = null;
        if (fVar != null) {
            str = fVar.S();
        } else {
            str = null;
        }
        if (mVar.v(str, this)) {
            P p5 = P.f26510a;
            C2657f fVar2 = (C2657f) B3().h().getValue();
            if (fVar2 != null) {
                str5 = fVar2.S();
            } else {
                str5 = null;
            }
            z3().f22584d.setImageDrawable(p5.j(this, str5));
        } else {
            s h5 = s.h();
            C2657f fVar3 = (C2657f) B3().h().getValue();
            if (fVar3 != null) {
                str4 = fVar3.H();
            } else {
                str4 = null;
            }
            h5.l(str4).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this)).i(z3().f22584d);
        }
        TextView textView = z3().f22605y;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        z3().f22600t.setTypeface(aVar.w());
        TextView textView2 = z3().f22600t;
        C2657f fVar4 = (C2657f) B3().h().getValue();
        if (fVar4 != null) {
            str2 = fVar4.N();
        } else {
            str2 = null;
        }
        textView2.setText(str2);
        z3().f22601u.setTypeface(aVar.x());
        TextView textView3 = z3().f22601u;
        C2657f fVar5 = (C2657f) B3().h().getValue();
        if (fVar5 != null) {
            str3 = fVar5.B0();
        } else {
            str3 = null;
        }
        textView3.setText(str3);
        z3().f22599s.setTypeface(aVar.x());
        TextView textView4 = z3().f22599s;
        C2657f fVar6 = (C2657f) B3().h().getValue();
        if (fVar6 != null) {
            str6 = fVar6.g();
        }
        textView4.setText(str6);
        z3().f22582b.setTypeface(aVar.x());
        z3().f22585e.setOnClickListener(new C0824k5(this));
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.vector_star_on);
        Drawable drawable3 = ContextCompat.getDrawable(this, R.drawable.vector_star_off);
        if (B3().m().getValue() != null) {
            Object value = B3().m().getValue();
            t.b(value);
            if (((l2.O) value).i() >= 1) {
                z3().f22586f.setImageDrawable(drawable2);
            }
            Object value2 = B3().m().getValue();
            t.b(value2);
            if (((l2.O) value2).i() >= 2) {
                z3().f22587g.setImageDrawable(drawable2);
            }
            Object value3 = B3().m().getValue();
            t.b(value3);
            if (((l2.O) value3).i() >= 3) {
                z3().f22588h.setImageDrawable(drawable2);
            }
            Object value4 = B3().m().getValue();
            t.b(value4);
            if (((l2.O) value4).i() >= 4) {
                z3().f22589i.setImageDrawable(drawable2);
            }
            Object value5 = B3().m().getValue();
            t.b(value5);
            if (((l2.O) value5).i() == 5) {
                z3().f22590j.setImageDrawable(drawable2);
            }
            Object value6 = B3().m().getValue();
            t.b(value6);
            String j5 = ((l2.O) value6).j();
            if (!(j5 == null || j5.length() == 0)) {
                EditText editText = z3().f22582b;
                Object value7 = B3().m().getValue();
                t.b(value7);
                editText.setText(String.valueOf(((l2.O) value7).j()));
            }
        }
        z3().f22586f.setOnClickListener(new C0832l5(this, drawable2, drawable3));
        z3().f22587g.setOnClickListener(new C0840m5(this, drawable2, drawable3));
        z3().f22588h.setOnClickListener(new C0848n5(this, drawable2, drawable3));
        z3().f22589i.setOnClickListener(new C0856o5(this, drawable2, drawable3));
        z3().f22590j.setOnClickListener(new C0759c5(this, drawable2));
        z3().f22603w.setTypeface(aVar.w());
        z3().f22603w.setOnClickListener(new C0768d5(this));
        z3().f22602v.setTypeface(aVar.w());
        z3().f22602v.setOnClickListener(new C0776e5(this));
        z3().f22604x.setTypeface(aVar.w());
        z3().f22604x.setOnClickListener(new C0784f5(this));
        z3().f22597q.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        z3().f22597q.addItemDecoration(new o(dimension, dimension, dimension, dimension));
        z3().f22594n.setOnScrollChangeListener(new C0808i5(this));
        z3().f22593m.setOnClickListener(new C0816j5());
    }

    /* access modifiers changed from: private */
    public static final void D3(ReviewsActivity reviewsActivity, View view) {
        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void E3(ReviewsActivity reviewsActivity, View view) {
        if (!t.a(reviewsActivity.B3().o().getValue(), "most")) {
            reviewsActivity.B3().o().setValue("most");
            TextView textView = reviewsActivity.z3().f22604x;
            t.d(textView, "tvOrderByMostReviews");
            v.a(textView);
            reviewsActivity.z3().f22602v.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.z3().f22602v.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.z3().f22603w.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.z3().f22603w.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.S3();
        }
    }

    /* access modifiers changed from: private */
    public static final void F3(ReviewsActivity reviewsActivity, NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8) {
        t.e(nestedScrollView, "v");
        if (i6 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && !reviewsActivity.B3().l() && reviewsActivity.B3().k()) {
            reviewsActivity.B3().v(true);
            B b5 = reviewsActivity.f14478M;
            if (b5 != null) {
                b5.c(true);
            }
            reviewsActivity.A3();
        }
    }

    /* access modifiers changed from: private */
    public static final void G3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void H3(ReviewsActivity reviewsActivity, View view) {
        String str;
        Object systemService = reviewsActivity.getSystemService("input_method");
        t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.z3().f22582b.getWindowToken(), 0);
        reviewsActivity.z3().f22582b.clearFocus();
        V h5 = V.f24870q.h(reviewsActivity);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            reviewsActivity.R3();
            return;
        }
        Editable text = reviewsActivity.z3().f22582b.getText();
        t.d(text, "getText(...)");
        reviewsActivity.T3(t3.s.W0(text).toString());
    }

    /* access modifiers changed from: private */
    public static final void I3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            reviewsActivity.B3().q().setValue(1);
            reviewsActivity.z3().f22586f.setImageDrawable(drawable);
            reviewsActivity.z3().f22587g.setImageDrawable(drawable2);
            reviewsActivity.z3().f22588h.setImageDrawable(drawable2);
            reviewsActivity.z3().f22589i.setImageDrawable(drawable2);
            reviewsActivity.z3().f22590j.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void J3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            reviewsActivity.B3().q().setValue(2);
            reviewsActivity.z3().f22586f.setImageDrawable(drawable);
            reviewsActivity.z3().f22587g.setImageDrawable(drawable);
            reviewsActivity.z3().f22588h.setImageDrawable(drawable2);
            reviewsActivity.z3().f22589i.setImageDrawable(drawable2);
            reviewsActivity.z3().f22590j.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void K3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            reviewsActivity.B3().q().setValue(3);
            reviewsActivity.z3().f22586f.setImageDrawable(drawable);
            reviewsActivity.z3().f22587g.setImageDrawable(drawable);
            reviewsActivity.z3().f22588h.setImageDrawable(drawable);
            reviewsActivity.z3().f22589i.setImageDrawable(drawable2);
            reviewsActivity.z3().f22590j.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void L3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            reviewsActivity.B3().q().setValue(4);
            reviewsActivity.z3().f22586f.setImageDrawable(drawable);
            reviewsActivity.z3().f22587g.setImageDrawable(drawable);
            reviewsActivity.z3().f22588h.setImageDrawable(drawable);
            reviewsActivity.z3().f22589i.setImageDrawable(drawable);
            reviewsActivity.z3().f22590j.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void M3(ReviewsActivity reviewsActivity, Drawable drawable, View view) {
        if (UptodownApp.f13477F.Z()) {
            reviewsActivity.B3().q().setValue(5);
            reviewsActivity.z3().f22586f.setImageDrawable(drawable);
            reviewsActivity.z3().f22587g.setImageDrawable(drawable);
            reviewsActivity.z3().f22588h.setImageDrawable(drawable);
            reviewsActivity.z3().f22589i.setImageDrawable(drawable);
            reviewsActivity.z3().f22590j.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    public static final void N3(ReviewsActivity reviewsActivity, View view) {
        if (!t.a(reviewsActivity.B3().o().getValue(), "date")) {
            reviewsActivity.B3().o().setValue("date");
            TextView textView = reviewsActivity.z3().f22603w;
            t.d(textView, "tvOrderByDateReviews");
            v.a(textView);
            reviewsActivity.z3().f22602v.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.z3().f22602v.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.z3().f22604x.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.z3().f22604x.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.S3();
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(ReviewsActivity reviewsActivity, View view) {
        if (!t.a(reviewsActivity.B3().o().getValue(), "best")) {
            reviewsActivity.B3().o().setValue("best");
            TextView textView = reviewsActivity.z3().f22602v;
            t.d(textView, "tvOrderByBestReviews");
            v.a(textView);
            reviewsActivity.z3().f22603w.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.z3().f22603w.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.z3().f22604x.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.z3().f22604x.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.S3();
        }
    }

    /* access modifiers changed from: private */
    public static final void P3(ReviewsActivity reviewsActivity, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == 1) {
            V h5 = V.f24870q.h(reviewsActivity);
            if (h5 != null) {
                str = h5.j();
            } else {
                str = null;
            }
            if (str != null && h5.p(reviewsActivity)) {
                UptodownApp.a aVar = UptodownApp.f13477F;
                aVar.l0(reviewsActivity);
                aVar.k0(reviewsActivity);
                reviewsActivity.T3(reviewsActivity.z3().f22582b.getText().toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Q3(ArrayList arrayList) {
        this.f14478M = new B(arrayList, this, this.f14479N);
    }

    /* access modifiers changed from: private */
    public final void R3() {
        this.f14480O.launch(new Intent(this, LoginActivity.class), UptodownApp.f13477F.b(this));
    }

    private final void S3() {
        z3().f22597q.setAdapter((RecyclerView.Adapter) null);
        this.f14478M = null;
        B3().u(true);
        B3().w(0);
        A3();
    }

    private final void T3(String str) {
        int intValue = ((Number) B3().q().getValue()).intValue();
        if (1 > intValue || intValue >= 6) {
            String string = getString(R.string.error_review_no_valoration);
            t.d(string, "getString(...)");
            u0(string);
            return;
        }
        B3().t(this, str);
    }

    /* access modifiers changed from: private */
    public static final P0 y3(ReviewsActivity reviewsActivity) {
        return P0.c(reviewsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final P0 z3() {
        return (P0) this.f14476K.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        setContentView((View) z3().getRoot());
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("appInfo")) {
                w h5 = B3().h();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
                } else {
                    parcelable2 = extras.getParcelable("appInfo");
                }
                t.b(parcelable2);
                h5.setValue(parcelable2);
            }
            if (extras.containsKey("myReview")) {
                w m5 = B3().m();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("myReview", l2.O.class);
                } else {
                    parcelable = extras.getParcelable("myReview");
                }
                m5.setValue(parcelable);
                if (B3().m().getValue() != null) {
                    w q5 = B3().q();
                    Object value = B3().m().getValue();
                    t.b(value);
                    q5.setValue(Integer.valueOf(((l2.O) value).i()));
                }
            }
        }
        C3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused4 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
        A3();
    }
}
