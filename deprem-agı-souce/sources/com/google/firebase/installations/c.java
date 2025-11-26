package com.google.firebase.installations;

import N.C0722p;
import S0.e;
import S0.g;
import T0.d;
import android.text.TextUtils;
import com.google.firebase.installations.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;
import o0.f;
import r0.x;

public class c implements e {

    /* renamed from: m  reason: collision with root package name */
    private static final Object f7235m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadFactory f7236n = new a();

    /* renamed from: a  reason: collision with root package name */
    private final f f7237a;

    /* renamed from: b  reason: collision with root package name */
    private final U0.c f7238b;

    /* renamed from: c  reason: collision with root package name */
    private final T0.c f7239c;

    /* renamed from: d  reason: collision with root package name */
    private final i f7240d;

    /* renamed from: e  reason: collision with root package name */
    private final x f7241e;

    /* renamed from: f  reason: collision with root package name */
    private final g f7242f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f7243g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f7244h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f7245i;

    /* renamed from: j  reason: collision with root package name */
    private String f7246j;

    /* renamed from: k  reason: collision with root package name */
    private Set f7247k;

    /* renamed from: l  reason: collision with root package name */
    private final List f7248l;

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f7249a = new AtomicInteger(1);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f7249a.getAndIncrement())}));
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7250a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7251b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                U0.f$b[] r0 = U0.f.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7251b = r0
                r1 = 1
                U0.f$b r2 = U0.f.b.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f7251b     // Catch:{ NoSuchFieldError -> 0x001d }
                U0.f$b r3 = U0.f.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f7251b     // Catch:{ NoSuchFieldError -> 0x0028 }
                U0.f$b r3 = U0.f.b.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                U0.d$b[] r2 = U0.d.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f7250a = r2
                U0.d$b r3 = U0.d.b.OK     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f7250a     // Catch:{ NoSuchFieldError -> 0x0043 }
                U0.d$b r2 = U0.d.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.b.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    c(o0.f r10, R0.b r11, java.util.concurrent.ExecutorService r12, java.util.concurrent.Executor r13) {
        /*
            r9 = this;
            U0.c r4 = new U0.c
            android.content.Context r0 = r10.k()
            r4.<init>(r0, r11)
            T0.c r5 = new T0.c
            r5.<init>(r10)
            com.google.firebase.installations.i r6 = com.google.firebase.installations.i.c()
            r0.x r7 = new r0.x
            S0.a r11 = new S0.a
            r11.<init>(r10)
            r7.<init>(r11)
            S0.g r8 = new S0.g
            r8.<init>()
            r0 = r9
            r3 = r10
            r1 = r12
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.<init>(o0.f, R0.b, java.util.concurrent.ExecutorService, java.util.concurrent.Executor):void");
    }

    private synchronized void A(String str) {
        this.f7246j = str;
    }

    private synchronized void B(d dVar, d dVar2) {
        if (this.f7247k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator it = this.f7247k.iterator();
            if (it.hasNext()) {
                android.support.v4.media.a.a(it.next());
                dVar2.d();
                throw null;
            }
        }
    }

    public static /* synthetic */ T0.b e(f fVar) {
        return new T0.b(fVar);
    }

    private C1698l f() {
        C1699m mVar = new C1699m();
        h(new e(this.f7240d, mVar));
        return mVar.a();
    }

    private C1698l g() {
        C1699m mVar = new C1699m();
        h(new f(mVar));
        return mVar.a();
    }

    private void h(h hVar) {
        synchronized (this.f7243g) {
            this.f7248l.add(hVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(boolean r3) {
        /*
            r2 = this;
            T0.d r0 = r2.r()
            boolean r1 = r0.i()     // Catch:{ d -> 0x001d }
            if (r1 != 0) goto L_0x0024
            boolean r1 = r0.l()     // Catch:{ d -> 0x001d }
            if (r1 == 0) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            if (r3 != 0) goto L_0x001f
            com.google.firebase.installations.i r3 = r2.f7240d     // Catch:{ d -> 0x001d }
            boolean r3 = r3.f(r0)     // Catch:{ d -> 0x001d }
            if (r3 == 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            return
        L_0x001d:
            r3 = move-exception
            goto L_0x0061
        L_0x001f:
            T0.d r3 = r2.k(r0)     // Catch:{ d -> 0x001d }
            goto L_0x0028
        L_0x0024:
            T0.d r3 = r2.x(r0)     // Catch:{ d -> 0x001d }
        L_0x0028:
            r2.u(r3)
            r2.B(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.d()
            r2.A(r0)
        L_0x003b:
            boolean r0 = r3.i()
            if (r0 == 0) goto L_0x004c
            com.google.firebase.installations.d r3 = new com.google.firebase.installations.d
            com.google.firebase.installations.d$a r0 = com.google.firebase.installations.d.a.BAD_CONFIG
            r3.<init>(r0)
            r2.y(r3)
            return
        L_0x004c:
            boolean r0 = r3.j()
            if (r0 == 0) goto L_0x005d
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            r2.y(r3)
            return
        L_0x005d:
            r2.z(r3)
            return
        L_0x0061:
            r2.y(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.i(boolean):void");
    }

    /* access modifiers changed from: private */
    public final void j(boolean z4) {
        d s5 = s();
        if (z4) {
            s5 = s5.p();
        }
        z(s5);
        this.f7245i.execute(new S0.d(this, z4));
    }

    private d k(d dVar) {
        U0.f e5 = this.f7238b.e(l(), dVar.d(), t(), dVar.f());
        int i5 = b.f7251b[e5.b().ordinal()];
        if (i5 == 1) {
            return dVar.o(e5.c(), e5.d(), this.f7240d.b());
        } else if (i5 == 2) {
            return dVar.q("BAD CONFIG");
        } else {
            if (i5 == 3) {
                A((String) null);
                return dVar.r();
            }
            throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
    }

    private synchronized String n() {
        return this.f7246j;
    }

    private T0.b o() {
        return (T0.b) this.f7241e.get();
    }

    public static c p() {
        return q(f.l());
    }

    public static c q(f fVar) {
        boolean z4;
        if (fVar != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.b(z4, "Null is not a valid value of FirebaseApp.");
        return (c) fVar.j(e.class);
    }

    private T0.d r() {
        b a5;
        T0.d d5;
        synchronized (f7235m) {
            try {
                a5 = b.a(this.f7237a.k(), "generatefid.lock");
                d5 = this.f7239c.d();
                if (a5 != null) {
                    a5.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d5;
    }

    private T0.d s() {
        b a5;
        T0.d d5;
        synchronized (f7235m) {
            try {
                a5 = b.a(this.f7237a.k(), "generatefid.lock");
                d5 = this.f7239c.d();
                if (d5.j()) {
                    d5 = this.f7239c.b(d5.t(w(d5)));
                }
                if (a5 != null) {
                    a5.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d5;
    }

    private void u(T0.d dVar) {
        b a5;
        synchronized (f7235m) {
            try {
                a5 = b.a(this.f7237a.k(), "generatefid.lock");
                this.f7239c.b(dVar);
                if (a5 != null) {
                    a5.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void v() {
        C0722p.f(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0722p.f(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0722p.f(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0722p.b(i.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0722p.b(i.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String w(T0.d dVar) {
        if ((!this.f7237a.m().equals("CHIME_ANDROID_SDK") && !this.f7237a.u()) || !dVar.m()) {
            return this.f7242f.a();
        }
        String f5 = o().f();
        if (TextUtils.isEmpty(f5)) {
            return this.f7242f.a();
        }
        return f5;
    }

    private T0.d x(T0.d dVar) {
        String str;
        if (dVar.d() == null || dVar.d().length() != 11) {
            str = null;
        } else {
            str = o().i();
        }
        U0.d d5 = this.f7238b.d(l(), dVar.d(), t(), m(), str);
        int i5 = b.f7250a[d5.e().ordinal()];
        if (i5 == 1) {
            return dVar.s(d5.c(), d5.d(), this.f7240d.b(), d5.b().c(), d5.b().d());
        } else if (i5 == 2) {
            return dVar.q("BAD CONFIG");
        } else {
            throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
    }

    private void y(Exception exc) {
        synchronized (this.f7243g) {
            try {
                Iterator it = this.f7248l.iterator();
                while (it.hasNext()) {
                    if (((h) it.next()).b(exc)) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    private void z(T0.d dVar) {
        synchronized (this.f7243g) {
            try {
                Iterator it = this.f7248l.iterator();
                while (it.hasNext()) {
                    if (((h) it.next()).a(dVar)) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    public C1698l a(boolean z4) {
        v();
        C1698l f5 = f();
        this.f7244h.execute(new S0.c(this, z4));
        return f5;
    }

    public C1698l getId() {
        v();
        String n5 = n();
        if (n5 != null) {
            return C1701o.e(n5);
        }
        C1698l g5 = g();
        this.f7244h.execute(new S0.b(this));
        return g5;
    }

    /* access modifiers changed from: package-private */
    public String l() {
        return this.f7237a.n().b();
    }

    /* access modifiers changed from: package-private */
    public String m() {
        return this.f7237a.n().c();
    }

    /* access modifiers changed from: package-private */
    public String t() {
        return this.f7237a.n().e();
    }

    c(ExecutorService executorService, Executor executor, f fVar, U0.c cVar, T0.c cVar2, i iVar, x xVar, g gVar) {
        this.f7243g = new Object();
        this.f7247k = new HashSet();
        this.f7248l = new ArrayList();
        this.f7237a = fVar;
        this.f7238b = cVar;
        this.f7239c = cVar2;
        this.f7240d = iVar;
        this.f7241e = xVar;
        this.f7242f = gVar;
        this.f7244h = executorService;
        this.f7245i = executor;
    }
}
