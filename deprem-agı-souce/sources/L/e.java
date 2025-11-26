package L;

import L.C0668a;
import M.C0670B;
import M.C0675G;
import M.C0681a;
import M.C0682b;
import M.C0685e;
import M.C0690j;
import M.C0694n;
import M.C0696p;
import M.C0699t;
import M.Q;
import N.C0709c;
import N.C0710d;
import N.C0722p;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.util.Collections;
import k0.C1698l;
import k0.C1699m;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2769a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2770b;

    /* renamed from: c  reason: collision with root package name */
    private final C0668a f2771c;

    /* renamed from: d  reason: collision with root package name */
    private final C0668a.d f2772d;

    /* renamed from: e  reason: collision with root package name */
    private final C0682b f2773e;

    /* renamed from: f  reason: collision with root package name */
    private final Looper f2774f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2775g;

    /* renamed from: h  reason: collision with root package name */
    private final f f2776h;

    /* renamed from: i  reason: collision with root package name */
    private final C0694n f2777i;

    /* renamed from: j  reason: collision with root package name */
    protected final C0685e f2778j;

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f2779c = new C0049a().a();

        /* renamed from: a  reason: collision with root package name */
        public final C0694n f2780a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f2781b;

        /* renamed from: L.e$a$a  reason: collision with other inner class name */
        public static class C0049a {

            /* renamed from: a  reason: collision with root package name */
            private C0694n f2782a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f2783b;

            public a a() {
                if (this.f2782a == null) {
                    this.f2782a = new C0681a();
                }
                if (this.f2783b == null) {
                    this.f2783b = Looper.getMainLooper();
                }
                return new a(this.f2782a, this.f2783b);
            }

            public C0049a b(C0694n nVar) {
                C0722p.l(nVar, "StatusExceptionMapper must not be null.");
                this.f2782a = nVar;
                return this;
            }
        }

        private a(C0694n nVar, Account account, Looper looper) {
            this.f2780a = nVar;
            this.f2781b = looper;
        }
    }

    private e(Context context, Activity activity, C0668a aVar, C0668a.d dVar, a aVar2) {
        String str;
        C0722p.l(context, "Null context is not permitted.");
        C0722p.l(aVar, "Api must not be null.");
        C0722p.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) C0722p.l(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f2769a = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            str = context.getAttributionTag();
        } else {
            str = f(context);
        }
        this.f2770b = str;
        this.f2771c = aVar;
        this.f2772d = dVar;
        this.f2774f = aVar2.f2781b;
        C0682b a5 = C0682b.a(aVar, dVar, str);
        this.f2773e = a5;
        this.f2776h = new C0675G(this);
        C0685e u5 = C0685e.u(context2);
        this.f2778j = u5;
        this.f2775g = u5.l();
        this.f2777i = aVar2.f2780a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            C0699t.u(activity, u5, a5);
        }
        u5.F(this);
    }

    private final com.google.android.gms.common.api.internal.a o(int i5, com.google.android.gms.common.api.internal.a aVar) {
        aVar.i();
        this.f2778j.A(this, i5, aVar);
        return aVar;
    }

    private final C1698l p(int i5, C0696p pVar) {
        C1699m mVar = new C1699m();
        this.f2778j.B(this, i5, pVar, mVar, this.f2777i);
        return mVar.a();
    }

    public f b() {
        return this.f2776h;
    }

    /* access modifiers changed from: protected */
    public C0710d.a c() {
        C0710d.a aVar = new C0710d.a();
        aVar.d((Account) null);
        aVar.c(Collections.EMPTY_SET);
        aVar.e(this.f2769a.getClass().getName());
        aVar.b(this.f2769a.getPackageName());
        return aVar;
    }

    public C1698l d(C0696p pVar) {
        return p(2, pVar);
    }

    public com.google.android.gms.common.api.internal.a e(com.google.android.gms.common.api.internal.a aVar) {
        o(1, aVar);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public String f(Context context) {
        return null;
    }

    public final C0682b g() {
        return this.f2773e;
    }

    public C0668a.d h() {
        return this.f2772d;
    }

    public Context i() {
        return this.f2769a;
    }

    /* access modifiers changed from: protected */
    public String j() {
        return this.f2770b;
    }

    public Looper k() {
        return this.f2774f;
    }

    public final int l() {
        return this.f2775g;
    }

    public final C0668a.f m(Looper looper, C0670B b5) {
        Looper looper2 = looper;
        C0668a.f a5 = ((C0668a.C0048a) C0722p.k(this.f2771c.a())).a(this.f2769a, looper2, c().a(), this.f2772d, b5, b5);
        String j5 = j();
        if (j5 != null && (a5 instanceof C0709c)) {
            ((C0709c) a5).P(j5);
        }
        if (j5 == null || !(a5 instanceof C0690j)) {
            return a5;
        }
        android.support.v4.media.a.a(a5);
        throw null;
    }

    public final Q n(Context context, Handler handler) {
        return new Q(context, handler, c().a());
    }

    public e(Context context, C0668a aVar, C0668a.d dVar, a aVar2) {
        this(context, (Activity) null, aVar, dVar, aVar2);
    }
}
