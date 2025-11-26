package N;

import K.C0655b;
import K.C0657d;
import K.C0661h;
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: N.c  reason: case insensitive filesystem */
public abstract class C0709c {

    /* renamed from: D  reason: collision with root package name */
    public static final String[] f3011D = {"service_esmobile", "service_googleme"};

    /* renamed from: E  reason: collision with root package name */
    private static final C0657d[] f3012E = new C0657d[0];
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public boolean f3013A;

    /* renamed from: B  reason: collision with root package name */
    private volatile i0 f3014B;

    /* renamed from: C  reason: collision with root package name */
    protected AtomicInteger f3015C;

    /* renamed from: a  reason: collision with root package name */
    private int f3016a;

    /* renamed from: b  reason: collision with root package name */
    private long f3017b;

    /* renamed from: c  reason: collision with root package name */
    private long f3018c;

    /* renamed from: d  reason: collision with root package name */
    private int f3019d;

    /* renamed from: e  reason: collision with root package name */
    private long f3020e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f3021f;

    /* renamed from: g  reason: collision with root package name */
    t0 f3022g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f3023h;

    /* renamed from: i  reason: collision with root package name */
    private final Looper f3024i;

    /* renamed from: j  reason: collision with root package name */
    private final C0714h f3025j;

    /* renamed from: k  reason: collision with root package name */
    private final C0661h f3026k;

    /* renamed from: l  reason: collision with root package name */
    final Handler f3027l;

    /* renamed from: m  reason: collision with root package name */
    private final Object f3028m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Object f3029n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public C0718l f3030o;

    /* renamed from: p  reason: collision with root package name */
    protected C0050c f3031p;

    /* renamed from: q  reason: collision with root package name */
    private IInterface f3032q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f3033r;

    /* renamed from: s  reason: collision with root package name */
    private f0 f3034s;

    /* renamed from: t  reason: collision with root package name */
    private int f3035t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final a f3036u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final b f3037v;

    /* renamed from: w  reason: collision with root package name */
    private final int f3038w;

    /* renamed from: x  reason: collision with root package name */
    private final String f3039x;

    /* renamed from: y  reason: collision with root package name */
    private volatile String f3040y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public C0655b f3041z;

    /* renamed from: N.c$a */
    public interface a {
        void i(int i5);

        void k(Bundle bundle);
    }

    /* renamed from: N.c$b */
    public interface b {
        void j(C0655b bVar);
    }

    /* renamed from: N.c$c  reason: collision with other inner class name */
    public interface C0050c {
        void a(C0655b bVar);
    }

    /* renamed from: N.c$d */
    protected class d implements C0050c {
        public d() {
        }

        public final void a(C0655b bVar) {
            if (bVar.i()) {
                C0709c cVar = C0709c.this;
                cVar.l((C0716j) null, cVar.C());
            } else if (C0709c.this.f3037v != null) {
                C0709c.this.f3037v.j(bVar);
            }
        }
    }

    /* renamed from: N.c$e */
    public interface e {
        void a();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected C0709c(android.content.Context r10, android.os.Looper r11, int r12, N.C0709c.a r13, N.C0709c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            N.h r3 = N.C0714h.a(r10)
            K.h r4 = K.C0661h.f()
            N.C0722p.k(r13)
            N.C0722p.k(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N.C0709c.<init>(android.content.Context, android.os.Looper, int, N.c$a, N.c$b, java.lang.String):void");
    }

    static /* bridge */ /* synthetic */ void c0(C0709c cVar, i0 i0Var) {
        r rVar;
        cVar.f3014B = i0Var;
        if (cVar.S()) {
            C0711e eVar = i0Var.f3105d;
            C0723q b5 = C0723q.b();
            if (eVar == null) {
                rVar = null;
            } else {
                rVar = eVar.j();
            }
            b5.c(rVar);
        }
    }

    static /* bridge */ /* synthetic */ void d0(C0709c cVar, int i5) {
        int i6;
        int i7;
        synchronized (cVar.f3028m) {
            i6 = cVar.f3035t;
        }
        if (i6 == 3) {
            cVar.f3013A = true;
            i7 = 5;
        } else {
            i7 = 4;
        }
        Handler handler = cVar.f3027l;
        handler.sendMessage(handler.obtainMessage(i7, cVar.f3015C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean g0(C0709c cVar, int i5, int i6, IInterface iInterface) {
        synchronized (cVar.f3028m) {
            try {
                if (cVar.f3035t != i5) {
                    return false;
                }
                cVar.i0(i6, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean h0(C0709c cVar) {
        if (cVar.f3013A || TextUtils.isEmpty(cVar.E()) || TextUtils.isEmpty(cVar.B())) {
            return false;
        }
        try {
            Class.forName(cVar.E());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void i0(int i5, IInterface iInterface) {
        boolean z4;
        boolean z5;
        t0 t0Var;
        int i6;
        t0 t0Var2;
        boolean z6 = false;
        if (i5 != 4) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (iInterface == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z4 == z5) {
            z6 = true;
        }
        C0722p.a(z6);
        synchronized (this.f3028m) {
            try {
                this.f3035t = i5;
                this.f3032q = iInterface;
                Bundle bundle = null;
                if (i5 == 1) {
                    f0 f0Var = this.f3034s;
                    if (f0Var != null) {
                        C0714h hVar = this.f3025j;
                        String b5 = this.f3022g.b();
                        C0722p.k(b5);
                        hVar.e(b5, this.f3022g.a(), 4225, f0Var, X(), this.f3022g.c());
                        this.f3034s = null;
                    }
                } else if (i5 == 2 || i5 == 3) {
                    f0 f0Var2 = this.f3034s;
                    if (!(f0Var2 == null || (t0Var2 = this.f3022g) == null)) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + t0Var2.b() + " on " + t0Var2.a());
                        C0714h hVar2 = this.f3025j;
                        String b6 = this.f3022g.b();
                        C0722p.k(b6);
                        hVar2.e(b6, this.f3022g.a(), 4225, f0Var2, X(), this.f3022g.c());
                        this.f3015C.incrementAndGet();
                    }
                    f0 f0Var3 = new f0(this, this.f3015C.get());
                    this.f3034s = f0Var3;
                    if (this.f3035t != 3 || B() == null) {
                        t0Var = new t0(G(), F(), false, 4225, I());
                    } else {
                        t0Var = new t0(y().getPackageName(), B(), true, 4225, false);
                    }
                    this.f3022g = t0Var;
                    if (t0Var.c()) {
                        if (k() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f3022g.b())));
                        }
                    }
                    C0714h hVar3 = this.f3025j;
                    String b7 = this.f3022g.b();
                    C0722p.k(b7);
                    String a5 = this.f3022g.a();
                    C0655b c5 = hVar3.c(new m0(b7, a5, 4225, this.f3022g.c()), f0Var3, X(), w());
                    if (!c5.i()) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f3022g.b() + " on " + this.f3022g.a());
                        if (c5.c() == -1) {
                            i6 = 16;
                        } else {
                            i6 = c5.c();
                        }
                        if (c5.f() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", c5.f());
                        }
                        e0(i6, bundle, this.f3015C.get());
                    }
                } else if (i5 == 4) {
                    C0722p.k(iInterface);
                    K(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Bundle A() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public String B() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Set C() {
        return Collections.EMPTY_SET;
    }

    public final IInterface D() {
        IInterface iInterface;
        synchronized (this.f3028m) {
            try {
                if (this.f3035t != 5) {
                    r();
                    iInterface = this.f3032q;
                    C0722p.l(iInterface, "Client is connected but service is null");
                } else {
                    throw new DeadObjectException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    /* access modifiers changed from: protected */
    public abstract String E();

    /* access modifiers changed from: protected */
    public abstract String F();

    /* access modifiers changed from: protected */
    public String G() {
        return "com.google.android.gms";
    }

    public C0711e H() {
        i0 i0Var = this.f3014B;
        if (i0Var == null) {
            return null;
        }
        return i0Var.f3105d;
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        if (k() >= 211700000) {
            return true;
        }
        return false;
    }

    public boolean J() {
        if (this.f3014B != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void K(IInterface iInterface) {
        this.f3018c = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void L(C0655b bVar) {
        this.f3019d = bVar.c();
        this.f3020e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void M(int i5) {
        this.f3016a = i5;
        this.f3017b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void N(int i5, IBinder iBinder, Bundle bundle, int i6) {
        this.f3027l.sendMessage(this.f3027l.obtainMessage(1, i6, -1, new g0(this, i5, iBinder, bundle)));
    }

    public boolean O() {
        return false;
    }

    public void P(String str) {
        this.f3040y = str;
    }

    public void Q(int i5) {
        this.f3027l.sendMessage(this.f3027l.obtainMessage(6, this.f3015C.get(), i5));
    }

    /* access modifiers changed from: protected */
    public void R(C0050c cVar, int i5, PendingIntent pendingIntent) {
        C0722p.l(cVar, "Connection progress callbacks cannot be null.");
        this.f3031p = cVar;
        this.f3027l.sendMessage(this.f3027l.obtainMessage(3, this.f3015C.get(), i5, pendingIntent));
    }

    public boolean S() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String X() {
        String str = this.f3039x;
        if (str == null) {
            return this.f3023h.getClass().getName();
        }
        return str;
    }

    public void b() {
        this.f3015C.incrementAndGet();
        synchronized (this.f3033r) {
            try {
                int size = this.f3033r.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((d0) this.f3033r.get(i5)).d();
                }
                this.f3033r.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        synchronized (this.f3029n) {
            this.f3030o = null;
        }
        i0(1, (IInterface) null);
    }

    public void d(String str) {
        this.f3021f = str;
        b();
    }

    public void e(C0050c cVar) {
        C0722p.l(cVar, "Connection progress callbacks cannot be null.");
        this.f3031p = cVar;
        i0(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public final void e0(int i5, Bundle bundle, int i6) {
        this.f3027l.sendMessage(this.f3027l.obtainMessage(7, i6, -1, new h0(this, i5, bundle)));
    }

    public boolean f() {
        boolean z4;
        synchronized (this.f3028m) {
            int i5 = this.f3035t;
            z4 = true;
            if (i5 != 2) {
                if (i5 != 3) {
                    z4 = false;
                }
            }
        }
        return z4;
    }

    public String g() {
        t0 t0Var;
        if (h() && (t0Var = this.f3022g) != null) {
            return t0Var.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public boolean h() {
        boolean z4;
        synchronized (this.f3028m) {
            if (this.f3035t == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public void i(e eVar) {
        eVar.a();
    }

    public boolean j() {
        return true;
    }

    public abstract int k();

    public void l(C0716j jVar, Set set) {
        String str;
        Set set2 = set;
        Bundle A4 = A();
        if (Build.VERSION.SDK_INT < 31) {
            str = this.f3040y;
        } else {
            str = this.f3040y;
        }
        String str2 = str;
        int i5 = this.f3038w;
        int i6 = C0661h.f2716a;
        Scope[] scopeArr = C0712f.f3070o;
        Bundle bundle = new Bundle();
        C0657d[] dVarArr = C0712f.f3071p;
        C0712f fVar = new C0712f(6, i5, i6, (String) null, (IBinder) null, scopeArr, bundle, (Account) null, dVarArr, dVarArr, true, 0, false, str2);
        fVar.f3075d = this.f3023h.getPackageName();
        fVar.f3078g = A4;
        if (set2 != null) {
            fVar.f3077f = (Scope[]) set2.toArray(new Scope[0]);
        }
        if (o()) {
            Account u5 = u();
            if (u5 == null) {
                u5 = new Account("<<default account>>", "com.google");
            }
            fVar.f3079h = u5;
            if (jVar != null) {
                fVar.f3076e = jVar.asBinder();
            }
        } else if (O()) {
            fVar.f3079h = u();
        }
        fVar.f3080i = f3012E;
        fVar.f3081j = v();
        if (S()) {
            fVar.f3084m = true;
        }
        try {
            synchronized (this.f3029n) {
                C0718l lVar = this.f3030o;
                if (lVar != null) {
                    lVar.E(new e0(this, this.f3015C.get()), fVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            Q(3);
        } catch (SecurityException e6) {
            throw e6;
        } catch (RemoteException | RuntimeException e7) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e7);
            N(8, (IBinder) null, (Bundle) null, this.f3015C.get());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final C0657d[] m() {
        i0 i0Var = this.f3014B;
        if (i0Var == null) {
            return null;
        }
        return i0Var.f3103b;
    }

    public String n() {
        return this.f3021f;
    }

    public boolean o() {
        return false;
    }

    public void q() {
        int h5 = this.f3026k.h(this.f3023h, k());
        if (h5 != 0) {
            i0(1, (IInterface) null);
            R(new d(), h5, (PendingIntent) null);
            return;
        }
        e(new d());
    }

    /* access modifiers changed from: protected */
    public final void r() {
        if (!h()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract IInterface s(IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean t() {
        return false;
    }

    public Account u() {
        return null;
    }

    public C0657d[] v() {
        return f3012E;
    }

    /* access modifiers changed from: protected */
    public Executor w() {
        return null;
    }

    public Bundle x() {
        return null;
    }

    public final Context y() {
        return this.f3023h;
    }

    public int z() {
        return this.f3038w;
    }

    protected C0709c(Context context, Looper looper, C0714h hVar, C0661h hVar2, int i5, a aVar, b bVar, String str) {
        this.f3021f = null;
        this.f3028m = new Object();
        this.f3029n = new Object();
        this.f3033r = new ArrayList();
        this.f3035t = 1;
        this.f3041z = null;
        this.f3013A = false;
        this.f3014B = null;
        this.f3015C = new AtomicInteger(0);
        C0722p.l(context, "Context must not be null");
        this.f3023h = context;
        C0722p.l(looper, "Looper must not be null");
        this.f3024i = looper;
        C0722p.l(hVar, "Supervisor must not be null");
        this.f3025j = hVar;
        C0722p.l(hVar2, "API availability must not be null");
        this.f3026k = hVar2;
        this.f3027l = new c0(this, looper);
        this.f3038w = i5;
        this.f3036u = aVar;
        this.f3037v = bVar;
        this.f3039x = str;
    }
}
