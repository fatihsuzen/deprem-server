package com.uptodown.activities;

import O1.Q3;
import O1.R3;
import O1.S3;
import O1.T3;
import O1.U3;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.uptodown.R;
import h2.C2441u0;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class PasswordEditActivity extends C1598a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f14304M = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14305K = new ViewModelLazy(M.b(C.class), new f(this), new e(this), new g((C2616a) null, this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14306L = m.b(new Q3(this));

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PasswordEditActivity f14307a;

        b(PasswordEditActivity passwordEditActivity) {
            this.f14307a = passwordEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            if (charSequence != null) {
                this.f14307a.v3(charSequence.toString());
            }
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PasswordEditActivity f14308a;

        c(PasswordEditActivity passwordEditActivity) {
            this.f14308a = passwordEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            if (charSequence != null) {
                PasswordEditActivity passwordEditActivity = this.f14308a;
                passwordEditActivity.v3(passwordEditActivity.o3().f23577c.getText().toString());
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14309a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PasswordEditActivity f14310b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PasswordEditActivity f14311a;

            /* renamed from: com.uptodown.activities.PasswordEditActivity$d$a$a  reason: collision with other inner class name */
            static final class C0130a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a  reason: collision with root package name */
                Object f14312a;

                /* renamed from: b  reason: collision with root package name */
                /* synthetic */ Object f14313b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ a f14314c;

                /* renamed from: d  reason: collision with root package name */
                int f14315d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0130a(a aVar, C2308e eVar) {
                    super(eVar);
                    this.f14314c = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f14313b = obj;
                    this.f14315d |= Integer.MIN_VALUE;
                    return this.f14314c.emit((O) null, this);
                }
            }

            a(PasswordEditActivity passwordEditActivity) {
                this.f14311a = passwordEditActivity;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* renamed from: b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(z2.O r5, b3.C2308e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.uptodown.activities.PasswordEditActivity.d.a.C0130a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.uptodown.activities.PasswordEditActivity$d$a$a r0 = (com.uptodown.activities.PasswordEditActivity.d.a.C0130a) r0
                    int r1 = r0.f14315d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f14315d = r1
                    goto L_0x0018
                L_0x0013:
                    com.uptodown.activities.PasswordEditActivity$d$a$a r0 = new com.uptodown.activities.PasswordEditActivity$d$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f14313b
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.f14315d
                    r3 = 1
                    if (r2 == 0) goto L_0x0035
                    if (r2 != r3) goto L_0x002d
                    java.lang.Object r5 = r0.f14312a
                    com.uptodown.activities.PasswordEditActivity$d$a r5 = (com.uptodown.activities.PasswordEditActivity.d.a) r5
                    W2.u.b(r6)
                    goto L_0x0088
                L_0x002d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0035:
                    W2.u.b(r6)
                    boolean r6 = r5 instanceof z2.O.a
                    if (r6 == 0) goto L_0x004a
                    com.uptodown.activities.PasswordEditActivity r5 = r4.f14311a
                    h2.u0 r5 = r5.o3()
                    android.view.View r5 = r5.f23580f
                    r6 = 0
                    r5.setVisibility(r6)
                    goto L_0x00d9
                L_0x004a:
                    boolean r6 = r5 instanceof z2.O.c
                    if (r6 == 0) goto L_0x00d5
                    z2.O$c r5 = (z2.O.c) r5
                    java.lang.Object r6 = r5.a()
                    com.uptodown.activities.C$a r6 = (com.uptodown.activities.C.a) r6
                    int r6 = r6.c()
                    java.lang.String r2 = "getString(...)"
                    if (r6 == 0) goto L_0x0094
                    java.lang.Object r6 = r5.a()
                    com.uptodown.activities.C$a r6 = (com.uptodown.activities.C.a) r6
                    boolean r6 = r6.a()
                    if (r6 == 0) goto L_0x006b
                    goto L_0x0094
                L_0x006b:
                    com.uptodown.activities.PasswordEditActivity r5 = r4.f14311a
                    r6 = 2131952526(0x7f13038e, float:1.9541497E38)
                    java.lang.String r6 = r5.getString(r6)
                    kotlin.jvm.internal.t.d(r6, r2)
                    r5.u0(r6)
                    r0.f14312a = r4
                    r0.f14315d = r3
                    r5 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r5 = w3.X.b(r5, r0)
                    if (r5 != r1) goto L_0x0087
                    return r1
                L_0x0087:
                    r5 = r4
                L_0x0088:
                    com.uptodown.activities.PasswordEditActivity r6 = r5.f14311a
                    r0 = 2
                    r6.setResult(r0)
                    com.uptodown.activities.PasswordEditActivity r6 = r5.f14311a
                    r6.finish()
                    goto L_0x00c7
                L_0x0094:
                    java.lang.Object r6 = r5.a()
                    com.uptodown.activities.C$a r6 = (com.uptodown.activities.C.a) r6
                    java.lang.String r6 = r6.b()
                    if (r6 == 0) goto L_0x00b7
                    int r6 = r6.length()
                    if (r6 != 0) goto L_0x00a7
                    goto L_0x00b7
                L_0x00a7:
                    com.uptodown.activities.PasswordEditActivity r6 = r4.f14311a
                    java.lang.Object r5 = r5.a()
                    com.uptodown.activities.C$a r5 = (com.uptodown.activities.C.a) r5
                    java.lang.String r5 = r5.b()
                    r6.u0(r5)
                    goto L_0x00c6
                L_0x00b7:
                    com.uptodown.activities.PasswordEditActivity r5 = r4.f14311a
                    r6 = 2131952026(0x7f13019a, float:1.9540483E38)
                    java.lang.String r6 = r5.getString(r6)
                    kotlin.jvm.internal.t.d(r6, r2)
                    r5.u0(r6)
                L_0x00c6:
                    r5 = r4
                L_0x00c7:
                    com.uptodown.activities.PasswordEditActivity r5 = r5.f14311a
                    h2.u0 r5 = r5.o3()
                    android.view.View r5 = r5.f23580f
                    r6 = 8
                    r5.setVisibility(r6)
                    goto L_0x00d9
                L_0x00d5:
                    boolean r5 = r5 instanceof z2.O.b
                    if (r5 == 0) goto L_0x00dc
                L_0x00d9:
                    W2.J r5 = W2.J.f19942a
                    return r5
                L_0x00dc:
                    W2.q r5 = new W2.q
                    r5.<init>()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordEditActivity.d.a.emit(z2.O, b3.e):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PasswordEditActivity passwordEditActivity, C2308e eVar) {
            super(2, eVar);
            this.f14310b = passwordEditActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14310b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14309a;
            if (i5 == 0) {
                u.b(obj);
                D c5 = this.f14310b.p3().c();
                a aVar = new a(this.f14310b);
                this.f14309a = 1;
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14316a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f14316a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14316a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14317a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14317a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14317a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14318a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14319b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14318a = aVar;
            this.f14319b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14318a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14319b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordEditActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final C2441u0 n3(PasswordEditActivity passwordEditActivity) {
        return C2441u0.c(passwordEditActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C2441u0 o3() {
        return (C2441u0) this.f14306L.getValue();
    }

    /* access modifiers changed from: private */
    public final C p3() {
        return (C) this.f14305K.getValue();
    }

    private final void q3() {
        setContentView((View) o3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o3().f23581g.setNavigationIcon(drawable);
            o3().f23581g.setNavigationContentDescription((CharSequence) getString(R.string.back));
            o3().f23581g.setNavigationOnClickListener(new R3(this));
        }
        TextView textView = o3().f23586l;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        o3().f23577c.setTypeface(aVar.x());
        o3().f23576b.setTypeface(aVar.x());
        o3().f23585k.setTypeface(aVar.w());
        o3().f23584j.setTypeface(aVar.x());
        o3().f23583i.setTypeface(aVar.x());
        o3().f23582h.setTypeface(aVar.x());
        o3().f23579e.setOnClickListener(new S3(this));
        o3().f23578d.setOnClickListener(new T3(this));
        o3().f23577c.addTextChangedListener(new b(this));
        o3().f23576b.addTextChangedListener(new c(this));
        o3().f23585k.setOnClickListener(new U3(this));
    }

    /* access modifiers changed from: private */
    public static final void r3(PasswordEditActivity passwordEditActivity, View view) {
        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void s3(PasswordEditActivity passwordEditActivity, View view) {
        EditText editText = passwordEditActivity.o3().f23577c;
        t.d(editText, "etPasswordEdit");
        ImageView imageView = passwordEditActivity.o3().f23579e;
        t.d(imageView, "ivPasswordEdit");
        passwordEditActivity.w3(editText, imageView);
    }

    /* access modifiers changed from: private */
    public static final void t3(PasswordEditActivity passwordEditActivity, View view) {
        EditText editText = passwordEditActivity.o3().f23576b;
        t.d(editText, "etConfirmPasswordEdit");
        ImageView imageView = passwordEditActivity.o3().f23578d;
        t.d(imageView, "ivConfirmPasswordEdit");
        passwordEditActivity.w3(editText, imageView);
    }

    /* access modifiers changed from: private */
    public static final void u3(PasswordEditActivity passwordEditActivity, View view) {
        k.f32g.d(passwordEditActivity, passwordEditActivity.o3().f23577c);
        if (passwordEditActivity.o3().f23577c.getText().toString().length() == 0 || passwordEditActivity.o3().f23576b.getText().toString().length() == 0) {
            String string = passwordEditActivity.getString(R.string.error_email_vacio_recuperar_pass);
            t.d(string, "getString(...)");
            passwordEditActivity.u0(string);
        } else if (passwordEditActivity.o3().f23577c.getText().toString().length() < 6) {
            String string2 = passwordEditActivity.getString(R.string.validation_six_chars_min);
            t.d(string2, "getString(...)");
            passwordEditActivity.u0(string2);
        } else if (passwordEditActivity.o3().f23577c.getText().toString().length() > 99) {
            String string3 = passwordEditActivity.getString(R.string.validation_hundred_chars_max);
            t.d(string3, "getString(...)");
            passwordEditActivity.u0(string3);
        } else if (!t.a(passwordEditActivity.o3().f23577c.getText().toString(), passwordEditActivity.o3().f23576b.getText().toString())) {
            String string4 = passwordEditActivity.getString(R.string.password_edit_not_match);
            t.d(string4, "getString(...)");
            passwordEditActivity.u0(string4);
        } else {
            passwordEditActivity.p3().b(passwordEditActivity, passwordEditActivity.o3().f23577c.getText().toString(), passwordEditActivity.o3().f23576b.getText().toString());
        }
    }

    /* access modifiers changed from: private */
    public final void v3(String str) {
        if (str.length() <= 0 || str.length() < 6) {
            o3().f23584j.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            o3().f23584j.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 0 || str.length() > 99) {
            o3().f23583i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            o3().f23583i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (t.a(str, o3().f23576b.getText().toString())) {
            o3().f23582h.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            o3().f23582h.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private final void w3(EditText editText, ImageView imageView) {
        if (editText.getInputType() == 129) {
            editText.setInputType(145);
            imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_password_visible));
            editText.setSelection(editText.length());
            return;
        }
        editText.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_password_hidden));
        editText.setSelection(editText.length());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) o3().getRoot());
        q3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }
}
