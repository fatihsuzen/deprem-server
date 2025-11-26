package com.uptodown.activities;

import B2.u;
import O1.C0752b7;
import O1.C0761c7;
import O1.d7;
import O1.e7;
import O1.f7;
import O1.g7;
import O1.h7;
import O1.i7;
import O1.j7;
import O1.k7;
import O1.l7;
import O1.m7;
import O1.n7;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.m;
import W2.q;
import W2.u;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.activities.h0;
import com.uptodown.util.views.UsernameTextView;
import h2.q1;
import java.util.ArrayList;
import java.util.Iterator;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.V;
import l2.a0;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z2.Z;
import z3.C2973f;
import z3.D;

public final class UsernameEditActivity extends C1598a {

    /* renamed from: N  reason: collision with root package name */
    public static final a f14752N = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private V f14753K;

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14754L = new ViewModelLazy(M.b(h0.class), new g(this), new f(this), new h((C2616a) null, this));

    /* renamed from: M  reason: collision with root package name */
    private final C2223l f14755M = m.b(new C0752b7(this));

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f14756a;

        public b(UsernameEditActivity usernameEditActivity) {
            this.f14756a = usernameEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            this.f14756a.w3().f23483y.setText(charSequence);
            this.f14756a.w3().f23484z.setText(charSequence);
            this.f14756a.w3().f23457A.setText(charSequence);
            this.f14756a.w3().f23458B.setText(charSequence);
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f14757a;

        c(UsernameEditActivity usernameEditActivity) {
            this.f14757a = usernameEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            if (charSequence != null) {
                this.f14757a.L3(charSequence.toString());
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14758a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f14759b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ J f14760c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f14761d;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UsernameEditActivity f14762a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ J f14763b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f14764c;

            a(UsernameEditActivity usernameEditActivity, J j5, L l5) {
                this.f14762a = usernameEditActivity;
                this.f14763b = j5;
                this.f14764c = l5;
            }

            /* renamed from: b */
            public final Object emit(ArrayList arrayList, C2308e eVar) {
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    a0 a0Var = (a0) next;
                    int b5 = a0Var.b();
                    if (b5 == 0) {
                        this.f14762a.w3().f23471m.setChecked(a0Var.d());
                        UsernameTextView.a aVar = UsernameTextView.f21329k;
                        UsernameTextView usernameTextView = this.f14762a.w3().f23483y;
                        t.d(usernameTextView, "tvUsernameType0");
                        aVar.a(usernameTextView, a0Var.e(), a0Var.c());
                    } else if (b5 == 1) {
                        this.f14762a.w3().f23472n.setChecked(a0Var.d());
                        UsernameTextView.a aVar2 = UsernameTextView.f21329k;
                        UsernameTextView usernameTextView2 = this.f14762a.w3().f23484z;
                        t.d(usernameTextView2, "tvUsernameType1");
                        aVar2.a(usernameTextView2, a0Var.e(), a0Var.c());
                    } else if (b5 == 2) {
                        this.f14762a.w3().f23473o.setChecked(a0Var.d());
                        UsernameTextView.a aVar3 = UsernameTextView.f21329k;
                        UsernameTextView usernameTextView3 = this.f14762a.w3().f23457A;
                        t.d(usernameTextView3, "tvUsernameType2");
                        aVar3.a(usernameTextView3, a0Var.e(), a0Var.c());
                    } else if (b5 == 3) {
                        this.f14762a.w3().f23474p.setChecked(a0Var.d());
                        UsernameTextView.a aVar4 = UsernameTextView.f21329k;
                        UsernameTextView usernameTextView4 = this.f14762a.w3().f23458B;
                        t.d(usernameTextView4, "tvUsernameType3");
                        aVar4.a(usernameTextView4, a0Var.e(), a0Var.c());
                    }
                    if (a0Var.d()) {
                        this.f14763b.f24688a = a0Var.b();
                        L l5 = this.f14764c;
                        String c5 = a0Var.c();
                        t.b(c5);
                        if (c5.length() == 0) {
                            c5 = "type0";
                        }
                        l5.f24690a = c5;
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UsernameEditActivity usernameEditActivity, J j5, L l5, C2308e eVar) {
            super(2, eVar);
            this.f14759b = usernameEditActivity;
            this.f14760c = j5;
            this.f14761d = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14759b, this.f14760c, this.f14761d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14758a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f14759b.x3().f();
                a aVar = new a(this.f14759b, this.f14760c, this.f14761d);
                this.f14758a = 1;
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
            return ((d) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14765a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f14766b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UsernameEditActivity f14767a;

            a(UsernameEditActivity usernameEditActivity) {
                this.f14767a = usernameEditActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14767a.w3().f23470l.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((h0.a) cVar.a()).c() == 0 || ((h0.a) cVar.a()).a()) {
                        String b5 = ((h0.a) cVar.a()).b();
                        if (b5 == null || b5.length() == 0) {
                            UsernameEditActivity usernameEditActivity = this.f14767a;
                            String string = usernameEditActivity.getString(R.string.error_generico);
                            t.d(string, "getString(...)");
                            usernameEditActivity.u0(string);
                        } else {
                            this.f14767a.u0(((h0.a) cVar.a()).b());
                        }
                    } else {
                        UsernameEditActivity usernameEditActivity2 = this.f14767a;
                        String string2 = usernameEditActivity2.getString(R.string.username_edit_complete);
                        t.d(string2, "getString(...)");
                        usernameEditActivity2.u0(string2);
                        this.f14767a.setResult(10);
                        this.f14767a.finish();
                    }
                    this.f14767a.w3().f23470l.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(UsernameEditActivity usernameEditActivity, C2308e eVar) {
            super(2, eVar);
            this.f14766b = usernameEditActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14766b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14765a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14766b.x3().e();
                a aVar = new a(this.f14766b);
                this.f14765a = 1;
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
            return ((e) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14768a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14768a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14768a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14769a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14769a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14769a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14770a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14771b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14770a = aVar;
            this.f14771b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14770a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14771b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UsernameEditActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.d3();
    }

    /* access modifiers changed from: private */
    public static final void B3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.d3();
    }

    /* access modifiers changed from: private */
    public static final void C3(UsernameEditActivity usernameEditActivity, J j5, L l5, View view) {
        k.f32g.d(usernameEditActivity, usernameEditActivity.w3().f23460b);
        if (usernameEditActivity.w3().f23460b.getText().toString().length() == 0) {
            String string = usernameEditActivity.getString(R.string.error_email_vacio_recuperar_pass);
            t.d(string, "getString(...)");
            usernameEditActivity.u0(string);
        } else if (usernameEditActivity.w3().f23460b.getText().toString().length() < 3) {
            String string2 = usernameEditActivity.getString(R.string.validation_three_chars_min);
            t.d(string2, "getString(...)");
            usernameEditActivity.u0(string2);
        } else if (usernameEditActivity.w3().f23460b.getText().toString().length() > 99) {
            String string3 = usernameEditActivity.getString(R.string.validation_hundred_chars_max);
            t.d(string3, "getString(...)");
            usernameEditActivity.u0(string3);
        } else {
            if (!new t3.p("^[a-zA-Z0-9_]+$").g(usernameEditActivity.w3().f23460b.getText().toString())) {
                String string4 = usernameEditActivity.getString(R.string.validation_username_chars_type);
                t.d(string4, "getString(...)");
                usernameEditActivity.u0(string4);
                return;
            }
            usernameEditActivity.x3().c(usernameEditActivity, usernameEditActivity.w3().f23460b.getText().toString(), usernameEditActivity.f14753K, j5.f24688a, (String) l5.f24690a);
        }
    }

    /* access modifiers changed from: private */
    public static final void D3(UsernameEditActivity usernameEditActivity, View view) {
        V v5 = usernameEditActivity.f14753K;
        if (v5 != null) {
            t.b(v5);
            if (v5.p(usernameEditActivity)) {
                V v6 = usernameEditActivity.f14753K;
                t.b(v6);
                if (v6.q()) {
                    return;
                }
            }
        }
        C2962v.u(new C2962v(), usernameEditActivity, Z.f26527b.c(usernameEditActivity), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void E3(UsernameEditActivity usernameEditActivity, J j5, L l5, View view) {
        usernameEditActivity.w3().f23472n.setChecked(false);
        usernameEditActivity.w3().f23473o.setChecked(false);
        usernameEditActivity.w3().f23474p.setChecked(false);
        j5.f24688a = 0;
        l5.f24690a = "type0";
    }

    /* access modifiers changed from: private */
    public static final void F3(UsernameEditActivity usernameEditActivity, J j5, L l5, View view) {
        usernameEditActivity.w3().f23471m.setChecked(false);
        usernameEditActivity.w3().f23473o.setChecked(false);
        usernameEditActivity.w3().f23474p.setChecked(false);
        j5.f24688a = 1;
        l5.f24690a = "type1";
    }

    /* access modifiers changed from: private */
    public static final void G3(UsernameEditActivity usernameEditActivity, J j5, L l5, View view) {
        usernameEditActivity.w3().f23471m.setChecked(false);
        usernameEditActivity.w3().f23472n.setChecked(false);
        usernameEditActivity.w3().f23474p.setChecked(false);
        j5.f24688a = 2;
        l5.f24690a = "type2";
    }

    /* access modifiers changed from: private */
    public static final void H3(UsernameEditActivity usernameEditActivity, J j5, L l5, View view) {
        usernameEditActivity.w3().f23471m.setChecked(false);
        usernameEditActivity.w3().f23472n.setChecked(false);
        usernameEditActivity.w3().f23473o.setChecked(false);
        j5.f24688a = 3;
        l5.f24690a = "type3";
    }

    /* access modifiers changed from: private */
    public static final void I3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.d3();
    }

    /* access modifiers changed from: private */
    public static final void J3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.d3();
    }

    /* access modifiers changed from: private */
    public static final void K3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.d3();
    }

    /* access modifiers changed from: private */
    public final void L3(String str) {
        if (str.length() <= 0 || str.length() < 3) {
            w3().f23477s.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            w3().f23477s.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 99) {
            w3().f23476r.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            w3().f23476r.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 0 || !new t3.p("^[a-zA-Z0-9_]+$").g(str)) {
            w3().f23481w.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            w3().f23481w.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* access modifiers changed from: private */
    public static final q1 v3(UsernameEditActivity usernameEditActivity) {
        return q1.c(usernameEditActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final q1 w3() {
        return (q1) this.f14755M.getValue();
    }

    /* access modifiers changed from: private */
    public final h0 x3() {
        return (h0) this.f14754L.getValue();
    }

    private final void y3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            w3().f23475q.setNavigationIcon(drawable);
            w3().f23475q.setNavigationContentDescription((CharSequence) getString(R.string.back));
            w3().f23475q.setNavigationOnClickListener(new f7(this));
        }
        TextView textView = w3().f23478t;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        w3().f23480v.setTypeface(aVar.x());
        w3().f23479u.setTypeface(aVar.x());
        w3().f23464f.setOnClickListener(new i7(this));
        w3().f23460b.setTypeface(aVar.x());
        EditText editText = w3().f23460b;
        V v5 = this.f14753K;
        t.b(v5);
        editText.setText(v5.k());
        w3().f23482x.setTypeface(aVar.w());
        w3().f23477s.setTypeface(aVar.x());
        w3().f23476r.setTypeface(aVar.x());
        w3().f23481w.setTypeface(aVar.x());
        w3().f23483y.setTypeface(aVar.w());
        w3().f23484z.setTypeface(aVar.w());
        w3().f23457A.setTypeface(aVar.w());
        w3().f23458B.setTypeface(aVar.w());
        UsernameTextView usernameTextView = w3().f23483y;
        V v6 = this.f14753K;
        t.b(v6);
        usernameTextView.setText(v6.k());
        UsernameTextView usernameTextView2 = w3().f23484z;
        V v7 = this.f14753K;
        t.b(v7);
        usernameTextView2.setText(v7.k());
        UsernameTextView usernameTextView3 = w3().f23457A;
        V v8 = this.f14753K;
        t.b(v8);
        usernameTextView3.setText(v8.k());
        UsernameTextView usernameTextView4 = w3().f23458B;
        V v9 = this.f14753K;
        t.b(v9);
        usernameTextView4.setText(v9.k());
        J j5 = new J();
        L l5 = new L();
        l5.f24690a = "type0";
        w3().f23471m.setOnClickListener(new j7(this, j5, l5));
        w3().f23472n.setOnClickListener(new k7(this, j5, l5));
        w3().f23473o.setOnClickListener(new l7(this, j5, l5));
        w3().f23474p.setOnClickListener(new m7(this, j5, l5));
        V v10 = this.f14753K;
        t.b(v10);
        if (!v10.q()) {
            w3().f23479u.setVisibility(0);
            TextView textView2 = w3().f23479u;
            u.a aVar2 = B2.u.f17360c;
            String string = getString(R.string.username_turbo_styles_locked);
            t.d(string, "getString(...)");
            textView2.setText(aVar2.a(this, string));
            w3().f23479u.setOnClickListener(new n7(this));
            w3().f23480v.setOnClickListener(new C0761c7(this));
            w3().f23464f.setVisibility(8);
            w3().f23471m.setChecked(true);
            w3().f23461c.setVisibility(0);
            w3().f23472n.setEnabled(false);
            w3().f23462d.setVisibility(0);
            w3().f23473o.setEnabled(false);
            w3().f23463e.setVisibility(0);
            w3().f23474p.setEnabled(false);
            w3().f23466h.setOnClickListener(new d7(this));
            w3().f23467i.setOnClickListener(new e7(this));
            w3().f23468j.setOnClickListener(new g7(this));
        }
        w3().f23460b.addTextChangedListener(new c(this));
        w3().f23482x.setOnClickListener(new h7(this, j5, l5));
        EditText editText2 = w3().f23460b;
        t.d(editText2, "etUsernameEdit");
        editText2.addTextChangedListener(new b(this));
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, j5, l5, (C2308e) null), 2, (Object) null);
        x3().d(this);
    }

    /* access modifiers changed from: private */
    public static final void z3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView((View) w3().getRoot());
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user"))) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f14753K = (V) extras.getParcelable("user", V.class);
            } else {
                this.f14753K = (V) extras.getParcelable("user");
            }
            y3();
        }
        V v5 = this.f14753K;
        if (v5 != null) {
            t.b(v5);
            String k5 = v5.k();
            if (!(k5 == null || k5.length() == 0)) {
                V v6 = this.f14753K;
                t.b(v6);
                String k6 = v6.k();
                t.b(k6);
                L3(k6);
            }
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
    }
}
