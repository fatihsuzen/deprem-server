package com.uptodown.activities;

import O1.V3;
import O1.W3;
import O1.X3;
import O1.Y3;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import h2.C2443v0;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.Z;

public final class PasswordRecoveryActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14320K = m.b(new V3(this));

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14321a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f14322b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PasswordRecoveryActivity passwordRecoveryActivity, C2308e eVar) {
            super(2, eVar);
            this.f14322b = passwordRecoveryActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14322b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14321a;
            if (i5 == 0) {
                u.b(obj);
                PasswordRecoveryActivity passwordRecoveryActivity = this.f14322b;
                this.f14321a = 1;
                if (passwordRecoveryActivity.o3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f14323a;

        /* renamed from: b  reason: collision with root package name */
        Object f14324b;

        /* renamed from: c  reason: collision with root package name */
        Object f14325c;

        /* renamed from: d  reason: collision with root package name */
        Object f14326d;

        /* renamed from: e  reason: collision with root package name */
        Object f14327e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f14328f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f14329g;

        /* renamed from: h  reason: collision with root package name */
        int f14330h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PasswordRecoveryActivity passwordRecoveryActivity, C2308e eVar) {
            super(eVar);
            this.f14329g = passwordRecoveryActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f14328f = obj;
            this.f14330h |= Integer.MIN_VALUE;
            return this.f14329g.o3(this);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f14332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f14333c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f14334d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ L f14335e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(L l5, PasswordRecoveryActivity passwordRecoveryActivity, L l6, L l7, C2308e eVar) {
            super(2, eVar);
            this.f14332b = l5;
            this.f14333c = passwordRecoveryActivity;
            this.f14334d = l6;
            this.f14335e = l7;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14332b, this.f14333c, this.f14334d, this.f14335e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14331a == 0) {
                u.b(obj);
                this.f14332b.f24690a = this.f14333c.getString(R.string.error_generico);
                this.f14333c.p3().f23632d.setVisibility(0);
                this.f14334d.f24690a = this.f14333c.p3().f23631c.getText().toString();
                this.f14335e.f24690a = this.f14333c.p3().f23630b.getText().toString();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14336a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f14337b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f14338c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f14339d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ L f14340e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f14341f;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f14342a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f14343b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ l2.M f14344c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ PasswordRecoveryActivity f14345d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ L f14346e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(kotlin.jvm.internal.J j5, l2.M m5, PasswordRecoveryActivity passwordRecoveryActivity, L l5, C2308e eVar) {
                super(2, eVar);
                this.f14343b = j5;
                this.f14344c = m5;
                this.f14345d = passwordRecoveryActivity;
                this.f14346e = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f14343b, this.f14344c, this.f14345d, this.f14346e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f14342a == 0) {
                    u.b(obj);
                    if (this.f14343b.f24688a == 0 || this.f14344c.b()) {
                        this.f14345d.t3((String) this.f14346e.f24690a);
                    } else {
                        PasswordRecoveryActivity passwordRecoveryActivity = this.f14345d;
                        passwordRecoveryActivity.t3(passwordRecoveryActivity.getString(R.string.msg_success_recuperar_pass));
                        this.f14345d.finish();
                    }
                    this.f14345d.p3().f23632d.setVisibility(8);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PasswordRecoveryActivity passwordRecoveryActivity, L l5, L l6, L l7, kotlin.jvm.internal.J j5, C2308e eVar) {
            super(2, eVar);
            this.f14337b = passwordRecoveryActivity;
            this.f14338c = l5;
            this.f14339d = l6;
            this.f14340e = l7;
            this.f14341f = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14337b, this.f14338c, this.f14339d, this.f14340e, this.f14341f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14336a;
            if (i5 == 0) {
                u.b(obj);
                l2.M Z02 = new Z(this.f14337b).Z0((String) this.f14338c.f24690a, (String) this.f14339d.f24690a);
                if (Z02.e() != null) {
                    JSONObject e5 = Z02.e();
                    t.b(e5);
                    this.f14340e.f24690a = Z02.g(e5);
                    if (!e5.isNull("success")) {
                        this.f14341f.f24688a = e5.optInt("success");
                    }
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f14341f, Z02, this.f14337b, this.f14340e, (C2308e) null);
                this.f14336a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final C2443v0 m3(PasswordRecoveryActivity passwordRecoveryActivity) {
        return C2443v0.c(passwordRecoveryActivity.getLayoutInflater());
    }

    private final void n3() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00af, code lost:
        if (w3.C2872g.g(r0, r11, r6) != r7) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o3(b3.C2308e r19) {
        /*
            r18 = this;
            r2 = r18
            r0 = r19
            boolean r1 = r0 instanceof com.uptodown.activities.PasswordRecoveryActivity.b
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.uptodown.activities.PasswordRecoveryActivity$b r1 = (com.uptodown.activities.PasswordRecoveryActivity.b) r1
            int r3 = r1.f14330h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0018
            int r3 = r3 - r4
            r1.f14330h = r3
        L_0x0016:
            r6 = r1
            goto L_0x001e
        L_0x0018:
            com.uptodown.activities.PasswordRecoveryActivity$b r1 = new com.uptodown.activities.PasswordRecoveryActivity$b
            r1.<init>(r2, r0)
            goto L_0x0016
        L_0x001e:
            java.lang.Object r0 = r6.f14328f
            java.lang.Object r7 = c3.C2316b.f()
            int r1 = r6.f14330h
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L_0x0059
            if (r1 == r9) goto L_0x003b
            if (r1 != r8) goto L_0x0033
            W2.u.b(r0)
            goto L_0x00b2
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            java.lang.Object r1 = r6.f14327e
            kotlin.jvm.internal.L r1 = (kotlin.jvm.internal.L) r1
            java.lang.Object r3 = r6.f14326d
            kotlin.jvm.internal.L r3 = (kotlin.jvm.internal.L) r3
            java.lang.Object r4 = r6.f14325c
            kotlin.jvm.internal.L r4 = (kotlin.jvm.internal.L) r4
            java.lang.Object r5 = r6.f14324b
            kotlin.jvm.internal.J r5 = (kotlin.jvm.internal.J) r5
            java.lang.Object r9 = r6.f14323a
            com.uptodown.activities.PasswordRecoveryActivity r9 = (com.uptodown.activities.PasswordRecoveryActivity) r9
            W2.u.b(r0)
            r14 = r1
            r15 = r4
            r16 = r5
            r12 = r9
        L_0x0057:
            r13 = r3
            goto L_0x0093
        L_0x0059:
            W2.u.b(r0)
            kotlin.jvm.internal.J r10 = new kotlin.jvm.internal.J
            r10.<init>()
            kotlin.jvm.internal.L r1 = new kotlin.jvm.internal.L
            r1.<init>()
            kotlin.jvm.internal.L r3 = new kotlin.jvm.internal.L
            r3.<init>()
            kotlin.jvm.internal.L r4 = new kotlin.jvm.internal.L
            r4.<init>()
            w3.I0 r11 = w3.C2865c0.c()
            com.uptodown.activities.PasswordRecoveryActivity$c r0 = new com.uptodown.activities.PasswordRecoveryActivity$c
            r5 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f14323a = r2
            r6.f14324b = r10
            r6.f14325c = r1
            r6.f14326d = r3
            r6.f14327e = r4
            r6.f14330h = r9
            java.lang.Object r0 = w3.C2872g.g(r11, r0, r6)
            if (r0 != r7) goto L_0x008d
            goto L_0x00b1
        L_0x008d:
            r15 = r1
            r12 = r2
            r14 = r4
            r16 = r10
            goto L_0x0057
        L_0x0093:
            w3.I r0 = w3.C2865c0.b()
            com.uptodown.activities.PasswordRecoveryActivity$d r11 = new com.uptodown.activities.PasswordRecoveryActivity$d
            r17 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r1 = 0
            r6.f14323a = r1
            r6.f14324b = r1
            r6.f14325c = r1
            r6.f14326d = r1
            r6.f14327e = r1
            r6.f14330h = r8
            java.lang.Object r0 = w3.C2872g.g(r0, r11, r6)
            if (r0 != r7) goto L_0x00b2
        L_0x00b1:
            return r7
        L_0x00b2:
            W2.J r0 = W2.J.f19942a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordRecoveryActivity.o3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final C2443v0 p3() {
        return (C2443v0) this.f14320K.getValue();
    }

    /* access modifiers changed from: private */
    public static final void q3(PasswordRecoveryActivity passwordRecoveryActivity, View view) {
        passwordRecoveryActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void r3(PasswordRecoveryActivity passwordRecoveryActivity, View view) {
        if (s.E(passwordRecoveryActivity.p3().f23631c.getText().toString(), "", true) || s.E(passwordRecoveryActivity.p3().f23630b.getText().toString(), "", true)) {
            passwordRecoveryActivity.t3(passwordRecoveryActivity.getString(R.string.error_email_vacio_recuperar_pass));
        } else if (!s.E(passwordRecoveryActivity.p3().f23631c.getText().toString(), passwordRecoveryActivity.p3().f23630b.getText().toString(), true)) {
            passwordRecoveryActivity.t3(passwordRecoveryActivity.getString(R.string.error_emails_no_coinciden));
        } else {
            passwordRecoveryActivity.n3();
        }
    }

    /* access modifiers changed from: private */
    public static final void s3(View view) {
    }

    /* access modifiers changed from: private */
    public final void t3(String str) {
        if (str != null) {
            u0(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) p3().getRoot());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_password_recovery);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription((CharSequence) getString(R.string.back));
                toolbar.setNavigationOnClickListener(new W3(this));
            }
            TextView textView = (TextView) findViewById(R.id.tv_title_toolbar_password_recovery);
            if (textView != null) {
                textView.setTypeface(k.f32g.w());
            }
        }
        EditText editText = p3().f23631c;
        k.a aVar = k.f32g;
        editText.setTypeface(aVar.x());
        p3().f23630b.setTypeface(aVar.x());
        p3().f23634f.setTypeface(aVar.w());
        p3().f23634f.setOnClickListener(new X3(this));
        p3().f23632d.setOnClickListener(new Y3());
    }
}
