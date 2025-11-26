package O1;

import S1.k;
import W2.J;
import W2.u;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.uptodown.R;
import com.uptodown.activities.C1598a;
import h2.C2412f0;
import k0.C1698l;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.V;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.F;
import z2.I;

public abstract class O0 extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private TextView f3366K;

    /* renamed from: L  reason: collision with root package name */
    private com.google.android.gms.auth.api.signin.b f3367L;

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f3368M;

    /* renamed from: N  reason: collision with root package name */
    private final ActivityResultLauncher f3369N;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f3370a;

        /* renamed from: b  reason: collision with root package name */
        int f3371b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GoogleSignInAccount f3372c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ O0 f3373d;

        /* renamed from: O1.O0$a$a  reason: collision with other inner class name */
        static final class C0052a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f3374a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O0 f3375b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0052a(O0 o02, C2308e eVar) {
                super(2, eVar);
                this.f3375b = o02;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0052a(this.f3375b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f3374a == 0) {
                    u.b(obj);
                    this.f3375b.x3();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0052a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f3376a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ I f3377b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ O0 f3378c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(I i5, O0 o02, C2308e eVar) {
                super(2, eVar);
                this.f3377b = i5;
                this.f3378c = o02;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f3377b, this.f3378c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f3376a == 0) {
                    u.b(obj);
                    if (this.f3377b.e()) {
                        this.f3378c.w3(this.f3377b.c(), this.f3377b.b());
                        this.f3378c.setResult(-1);
                    } else {
                        this.f3378c.u3(this.f3377b.c());
                        this.f3378c.y3();
                        this.f3378c.setResult(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                        bundle.putString("loginSource", "google");
                        F s22 = this.f3378c.s2();
                        if (s22 != null) {
                            s22.d("login", bundle);
                        }
                    }
                    this.f3378c.m3();
                    V h5 = V.f24870q.h(this.f3378c);
                    if (h5 == null || !h5.p(this.f3378c)) {
                        this.f3378c.getOnBackPressedDispatcher().onBackPressed();
                    } else {
                        this.f3378c.finish();
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(GoogleSignInAccount googleSignInAccount, O0 o02, C2308e eVar) {
            super(2, eVar);
            this.f3372c = googleSignInAccount;
            this.f3373d = o02;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f3372c, this.f3373d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
            if (r1.g(r9, "google", r4, r8) == r0) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
            if (w3.C2872g.g(r9, r3, r8) != r0) goto L_0x008b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r8.f3371b
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x002f
                if (r1 == r4) goto L_0x0027
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                W2.u.b(r9)
                goto L_0x008b
            L_0x0017:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x001f:
                java.lang.Object r1 = r8.f3370a
                z2.I r1 = (z2.I) r1
                W2.u.b(r9)
                goto L_0x0075
            L_0x0027:
                java.lang.Object r1 = r8.f3370a
                z2.I r1 = (z2.I) r1
                W2.u.b(r9)
                goto L_0x004e
            L_0x002f:
                W2.u.b(r9)
                z2.I r9 = new z2.I
                r9.<init>()
                w3.I0 r1 = w3.C2865c0.c()
                O1.O0$a$a r6 = new O1.O0$a$a
                O1.O0 r7 = r8.f3373d
                r6.<init>(r7, r5)
                r8.f3370a = r9
                r8.f3371b = r4
                java.lang.Object r1 = w3.C2872g.g(r1, r6, r8)
                if (r1 != r0) goto L_0x004d
                goto L_0x008a
            L_0x004d:
                r1 = r9
            L_0x004e:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r9 = r8.f3372c
                java.lang.String r9 = r9.j()
                if (r9 == 0) goto L_0x0075
                int r9 = r9.length()
                if (r9 != 0) goto L_0x005d
                goto L_0x0075
            L_0x005d:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r9 = r8.f3372c
                java.lang.String r9 = r9.j()
                kotlin.jvm.internal.t.b(r9)
                O1.O0 r4 = r8.f3373d
                r8.f3370a = r1
                r8.f3371b = r3
                java.lang.String r3 = "google"
                java.lang.Object r9 = r1.g(r9, r3, r4, r8)
                if (r9 != r0) goto L_0x0075
                goto L_0x008a
            L_0x0075:
                w3.I0 r9 = w3.C2865c0.c()
                O1.O0$a$b r3 = new O1.O0$a$b
                O1.O0 r4 = r8.f3373d
                r3.<init>(r1, r4, r5)
                r8.f3370a = r5
                r8.f3371b = r2
                java.lang.Object r9 = w3.C2872g.g(r9, r3, r8)
                if (r9 != r0) goto L_0x008b
            L_0x008a:
                return r0
            L_0x008b:
                W2.J r9 = W2.J.f19942a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: O1.O0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f3379a;

        /* renamed from: b  reason: collision with root package name */
        int f3380b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GoogleSignInAccount f3381c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ O0 f3382d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f3383a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ I f3384b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ O0 f3385c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(I i5, O0 o02, C2308e eVar) {
                super(2, eVar);
                this.f3384b = i5;
                this.f3385c = o02;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f3384b, this.f3385c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f3383a == 0) {
                    u.b(obj);
                    if (this.f3384b.e()) {
                        this.f3385c.setResult(-1);
                    } else {
                        this.f3385c.v3(this.f3384b.c());
                        this.f3385c.y3();
                        this.f3385c.setResult(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                        bundle.putString("loginSource", "google");
                        F s22 = this.f3385c.s2();
                        if (s22 != null) {
                            s22.d("login", bundle);
                        }
                    }
                    V h5 = V.f24870q.h(this.f3385c);
                    if (h5 != null && h5.p(this.f3385c)) {
                        this.f3385c.o3();
                        this.f3385c.t3();
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GoogleSignInAccount googleSignInAccount, O0 o02, C2308e eVar) {
            super(2, eVar);
            this.f3381c = googleSignInAccount;
            this.f3382d = o02;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f3381c, this.f3382d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
            if (r1.g(r7, "google", r4, r6) == r0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0065, code lost:
            if (w3.C2872g.g(r7, r3, r6) == r0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f3380b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                W2.u.b(r7)
                goto L_0x0068
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                java.lang.Object r1 = r6.f3379a
                z2.I r1 = (z2.I) r1
                W2.u.b(r7)
                goto L_0x0051
            L_0x0022:
                W2.u.b(r7)
                z2.I r1 = new z2.I
                r1.<init>()
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r7 = r6.f3381c
                java.lang.String r7 = r7.j()
                if (r7 == 0) goto L_0x0051
                int r7 = r7.length()
                if (r7 != 0) goto L_0x0039
                goto L_0x0051
            L_0x0039:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r7 = r6.f3381c
                java.lang.String r7 = r7.j()
                kotlin.jvm.internal.t.b(r7)
                O1.O0 r4 = r6.f3382d
                r6.f3379a = r1
                r6.f3380b = r3
                java.lang.String r3 = "google"
                java.lang.Object r7 = r1.g(r7, r3, r4, r6)
                if (r7 != r0) goto L_0x0051
                goto L_0x0067
            L_0x0051:
                w3.I0 r7 = w3.C2865c0.c()
                O1.O0$b$a r3 = new O1.O0$b$a
                O1.O0 r4 = r6.f3382d
                r5 = 0
                r3.<init>(r1, r4, r5)
                r6.f3379a = r5
                r6.f3380b = r2
                java.lang.Object r7 = w3.C2872g.g(r7, r3, r6)
                if (r7 != r0) goto L_0x0068
            L_0x0067:
                return r0
            L_0x0068:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: O1.O0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public O0() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new M0(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f3368M = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new N0(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f3369N = registerForActivityResult2;
    }

    private final void k3(RelativeLayout relativeLayout) {
        relativeLayout.setOnClickListener(new L0(this));
    }

    /* access modifiers changed from: private */
    public static final void l3(O0 o02, View view) {
        o02.x3();
        o02.r3();
    }

    /* access modifiers changed from: private */
    public static final void p3(O0 o02, ActivityResult activityResult) {
        GoogleSignInAccount googleSignInAccount;
        if (activityResult.getData() != null) {
            C1698l b5 = com.google.android.gms.auth.api.signin.a.b(activityResult.getData());
            t.d(b5, "getSignedInAccountFromIntent(...)");
            if (b5.n() && (googleSignInAccount = (GoogleSignInAccount) b5.j()) != null) {
                C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(o02), (C2312i) null, (O) null, new a(googleSignInAccount, o02, (C2308e) null), 3, (Object) null);
            }
        }
        o02.m3();
    }

    /* access modifiers changed from: private */
    public static final void q3(O0 o02, ActivityResult activityResult) {
        GoogleSignInAccount googleSignInAccount;
        if (activityResult.getData() != null) {
            C1698l b5 = com.google.android.gms.auth.api.signin.a.b(activityResult.getData());
            t.d(b5, "getSignedInAccountFromIntent(...)");
            if (b5.n() && (googleSignInAccount = (GoogleSignInAccount) b5.j()) != null) {
                C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(o02), (C2312i) null, (O) null, new b(googleSignInAccount, o02, (C2308e) null), 3, (Object) null);
            }
        }
    }

    private final void r3() {
        com.google.android.gms.auth.api.signin.b bVar = this.f3367L;
        t.b(bVar);
        Intent q5 = bVar.q();
        t.d(q5, "getSignInIntent(...)");
        this.f3368M.launch(q5);
    }

    /* access modifiers changed from: private */
    public final void v3(V v5) {
        String str;
        if (v5 != null) {
            v5.s(this);
        }
        if (v5 != null) {
            try {
                str = v5.k();
            } catch (Exception e5) {
                e5.printStackTrace();
                return;
            }
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (str.length() != 0) {
            String k5 = v5.k();
            t.b(k5);
            AccountManager.get(getBaseContext()).addAccountExplicitly(new Account(k5, getString(R.string.account)), (String) null, (Bundle) null);
        }
    }

    public final TextView j3() {
        return this.f3366K;
    }

    /* access modifiers changed from: protected */
    public abstract void m3();

    public final void n3(C2412f0 f0Var) {
        t.e(f0Var, "binding");
        TextView textView = f0Var.f23060c.f23082i;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        RelativeLayout relativeLayout = f0Var.f23060c.f23079f;
        t.d(relativeLayout, "rlGoogleLogin");
        k3(relativeLayout);
        f0Var.f23061d.f22693k.setTypeface(aVar.w());
        RelativeLayout relativeLayout2 = f0Var.f23061d.f22690h;
        t.d(relativeLayout2, "rlGoogleLogin");
        k3(relativeLayout2);
    }

    public V o3() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3367L = new I().d(this);
    }

    public final void s3() {
        Intent q5 = new I().d(this).q();
        t.d(q5, "getSignInIntent(...)");
        this.f3369N.launch(q5);
    }

    /* access modifiers changed from: protected */
    public abstract void u3(V v5);

    /* access modifiers changed from: protected */
    public abstract void w3(V v5, String str);

    /* access modifiers changed from: protected */
    public abstract void x3();

    /* access modifiers changed from: protected */
    public abstract void y3();

    public void t3() {
    }
}
