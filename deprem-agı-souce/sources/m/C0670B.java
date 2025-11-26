package M;

import K.C0655b;
import K.C0657d;
import L.C0668a;
import L.e;
import L.f;
import L.k;
import N.C0720n;
import N.C0722p;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.a;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import k0.C1699m;

/* renamed from: M.B  reason: case insensitive filesystem */
public final class C0670B implements f.a, f.b {

    /* renamed from: a  reason: collision with root package name */
    private final Queue f2819a = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0668a.f f2820b;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final C0682b f2821k;

    /* renamed from: l  reason: collision with root package name */
    private final C0698s f2822l;

    /* renamed from: m  reason: collision with root package name */
    private final Set f2823m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    private final Map f2824n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    private final int f2825o;

    /* renamed from: p  reason: collision with root package name */
    private final Q f2826p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f2827q;

    /* renamed from: r  reason: collision with root package name */
    private final List f2828r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private C0655b f2829s = null;

    /* renamed from: t  reason: collision with root package name */
    private int f2830t = 0;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ C0685e f2831u;

    public C0670B(C0685e eVar, e eVar2) {
        this.f2831u = eVar;
        C0668a.f m5 = eVar2.m(eVar.f2913n.getLooper(), this);
        this.f2820b = m5;
        this.f2821k = eVar2.g();
        this.f2822l = new C0698s();
        this.f2825o = eVar2.l();
        if (m5.o()) {
            this.f2826p = eVar2.n(eVar.f2904e, eVar.f2913n);
        } else {
            this.f2826p = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(C0670B b5, C0672D d5) {
        if (!b5.f2828r.contains(d5) || b5.f2827q) {
            return;
        }
        if (!b5.f2820b.h()) {
            b5.E();
        } else {
            b5.g();
        }
    }

    static /* bridge */ /* synthetic */ void C(C0670B b5, C0672D d5) {
        C0657d[] g5;
        if (b5.f2828r.remove(d5)) {
            b5.f2831u.f2913n.removeMessages(15, d5);
            b5.f2831u.f2913n.removeMessages(16, d5);
            C0657d a5 = d5.f2833b;
            ArrayList arrayList = new ArrayList(b5.f2819a.size());
            for (Y y4 : b5.f2819a) {
                if ((y4 instanceof C0678J) && (g5 = ((C0678J) y4).g(b5)) != null && b.b(g5, a5)) {
                    arrayList.add(y4);
                }
            }
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                Y y5 = (Y) arrayList.get(i5);
                b5.f2819a.remove(y5);
                y5.b(new k(a5));
            }
        }
    }

    private final C0657d c(C0657d[] dVarArr) {
        if (!(dVarArr == null || dVarArr.length == 0)) {
            C0657d[] m5 = this.f2820b.m();
            if (m5 == null) {
                m5 = new C0657d[0];
            }
            ArrayMap arrayMap = new ArrayMap(m5.length);
            for (C0657d dVar : m5) {
                arrayMap.put(dVar.c(), Long.valueOf(dVar.d()));
            }
            for (C0657d dVar2 : dVarArr) {
                Long l5 = (Long) arrayMap.get(dVar2.c());
                if (l5 == null || l5.longValue() < dVar2.d()) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private final void d(C0655b bVar) {
        Iterator it = this.f2823m.iterator();
        if (it.hasNext()) {
            a.a(it.next());
            if (C0720n.a(bVar, C0655b.f2701e)) {
                this.f2820b.g();
            }
            throw null;
        }
        this.f2823m.clear();
    }

    /* access modifiers changed from: private */
    public final void e(Status status) {
        C0722p.d(this.f2831u.f2913n);
        f(status, (Exception) null, false);
    }

    private final void f(Status status, Exception exc, boolean z4) {
        boolean z5;
        C0722p.d(this.f2831u.f2913n);
        boolean z6 = true;
        if (status != null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (exc != null) {
            z6 = false;
        }
        if (z5 != z6) {
            Iterator it = this.f2819a.iterator();
            while (it.hasNext()) {
                Y y4 = (Y) it.next();
                if (!z4 || y4.f2874a == 2) {
                    if (status != null) {
                        y4.a(status);
                    } else {
                        y4.b(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    private final void g() {
        ArrayList arrayList = new ArrayList(this.f2819a);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Y y4 = (Y) arrayList.get(i5);
            if (this.f2820b.h()) {
                if (p(y4)) {
                    this.f2819a.remove(y4);
                }
                i5++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        D();
        d(C0655b.f2701e);
        o();
        Iterator it = this.f2824n.values().iterator();
        if (!it.hasNext()) {
            g();
            m();
            return;
        }
        a.a(it.next());
        throw null;
    }

    /* access modifiers changed from: private */
    public final void l(int i5) {
        D();
        this.f2827q = true;
        this.f2822l.e(i5, this.f2820b.n());
        C0682b bVar = this.f2821k;
        C0685e eVar = this.f2831u;
        eVar.f2913n.sendMessageDelayed(Message.obtain(eVar.f2913n, 9, bVar), 5000);
        C0682b bVar2 = this.f2821k;
        C0685e eVar2 = this.f2831u;
        eVar2.f2913n.sendMessageDelayed(Message.obtain(eVar2.f2913n, 11, bVar2), 120000);
        this.f2831u.f2906g.c();
        Iterator it = this.f2824n.values().iterator();
        if (it.hasNext()) {
            a.a(it.next());
            throw null;
        }
    }

    private final void m() {
        this.f2831u.f2913n.removeMessages(12, this.f2821k);
        C0682b bVar = this.f2821k;
        C0685e eVar = this.f2831u;
        eVar.f2913n.sendMessageDelayed(eVar.f2913n.obtainMessage(12, bVar), this.f2831u.f2900a);
    }

    private final void n(Y y4) {
        y4.d(this.f2822l, a());
        try {
            y4.c(this);
        } catch (DeadObjectException unused) {
            i(1);
            this.f2820b.d("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void o() {
        if (this.f2827q) {
            C0685e eVar = this.f2831u;
            eVar.f2913n.removeMessages(11, this.f2821k);
            C0685e eVar2 = this.f2831u;
            eVar2.f2913n.removeMessages(9, this.f2821k);
            this.f2827q = false;
        }
    }

    private final boolean p(Y y4) {
        if (!(y4 instanceof C0678J)) {
            n(y4);
            return true;
        }
        C0678J j5 = (C0678J) y4;
        C0657d c5 = c(j5.g(this));
        if (c5 == null) {
            n(y4);
            return true;
        }
        String name = this.f2820b.getClass().getName();
        String c6 = c5.c();
        long d5 = c5.d();
        Log.w("GoogleApiManager", name + " could not execute call because it requires feature (" + c6 + ", " + d5 + ").");
        if (!this.f2831u.f2914o || !j5.f(this)) {
            j5.b(new k(c5));
            return true;
        }
        C0672D d6 = new C0672D(this.f2821k, c5, (C0671C) null);
        int indexOf = this.f2828r.indexOf(d6);
        if (indexOf >= 0) {
            C0672D d7 = (C0672D) this.f2828r.get(indexOf);
            this.f2831u.f2913n.removeMessages(15, d7);
            C0685e eVar = this.f2831u;
            eVar.f2913n.sendMessageDelayed(Message.obtain(eVar.f2913n, 15, d7), 5000);
            return false;
        }
        this.f2828r.add(d6);
        C0685e eVar2 = this.f2831u;
        eVar2.f2913n.sendMessageDelayed(Message.obtain(eVar2.f2913n, 15, d6), 5000);
        C0685e eVar3 = this.f2831u;
        eVar3.f2913n.sendMessageDelayed(Message.obtain(eVar3.f2913n, 16, d6), 120000);
        C0655b bVar = new C0655b(2, (PendingIntent) null);
        if (q(bVar)) {
            return false;
        }
        this.f2831u.f(bVar, this.f2825o);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean q(K.C0655b r4) {
        /*
            r3 = this;
            java.lang.Object r0 = M.C0685e.f2898r
            monitor-enter(r0)
            M.e r1 = r3.f2831u     // Catch:{ all -> 0x0027 }
            M.t r2 = r1.f2910k     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0029
            java.util.Set r1 = r1.f2911l     // Catch:{ all -> 0x0027 }
            M.b r2 = r3.f2821k     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            M.e r1 = r3.f2831u     // Catch:{ all -> 0x0027 }
            M.t r1 = r1.f2910k     // Catch:{ all -> 0x0027 }
            int r2 = r3.f2825o     // Catch:{ all -> 0x0027 }
            r1.s(r4, r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 1
            return r4
        L_0x0027:
            r4 = move-exception
            goto L_0x002c
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 0
            return r4
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: M.C0670B.q(K.b):boolean");
    }

    private final boolean r(boolean z4) {
        C0722p.d(this.f2831u.f2913n);
        if (!this.f2820b.h() || !this.f2824n.isEmpty()) {
            return false;
        }
        if (!this.f2822l.g()) {
            this.f2820b.d("Timing out service connection.");
            return true;
        } else if (!z4) {
            return false;
        } else {
            m();
            return false;
        }
    }

    public final void D() {
        C0722p.d(this.f2831u.f2913n);
        this.f2829s = null;
    }

    public final void E() {
        C0722p.d(this.f2831u.f2913n);
        if (!this.f2820b.h() && !this.f2820b.f()) {
            try {
                C0685e eVar = this.f2831u;
                int b5 = eVar.f2906g.b(eVar.f2904e, this.f2820b);
                if (b5 != 0) {
                    C0655b bVar = new C0655b(b5, (PendingIntent) null);
                    String name = this.f2820b.getClass().getName();
                    String obj = bVar.toString();
                    Log.w("GoogleApiManager", "The service for " + name + " is not available: " + obj);
                    H(bVar, (Exception) null);
                    return;
                }
                C0685e eVar2 = this.f2831u;
                C0668a.f fVar = this.f2820b;
                C0674F f5 = new C0674F(eVar2, fVar, this.f2821k);
                if (fVar.o()) {
                    ((Q) C0722p.k(this.f2826p)).t0(f5);
                }
                try {
                    this.f2820b.e(f5);
                } catch (SecurityException e5) {
                    H(new C0655b(10), e5);
                }
            } catch (IllegalStateException e6) {
                H(new C0655b(10), e6);
            }
        }
    }

    public final void F(Y y4) {
        C0722p.d(this.f2831u.f2913n);
        if (!this.f2820b.h()) {
            this.f2819a.add(y4);
            C0655b bVar = this.f2829s;
            if (bVar == null || !bVar.g()) {
                E();
            } else {
                H(this.f2829s, (Exception) null);
            }
        } else if (p(y4)) {
            m();
        } else {
            this.f2819a.add(y4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G() {
        this.f2830t++;
    }

    public final void H(C0655b bVar, Exception exc) {
        C0722p.d(this.f2831u.f2913n);
        Q q5 = this.f2826p;
        if (q5 != null) {
            q5.u0();
        }
        D();
        this.f2831u.f2906g.c();
        d(bVar);
        if ((this.f2820b instanceof P.e) && bVar.c() != 24) {
            this.f2831u.f2901b = true;
            C0685e eVar = this.f2831u;
            eVar.f2913n.sendMessageDelayed(eVar.f2913n.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (bVar.c() == 4) {
            e(C0685e.f2897q);
        } else if (this.f2819a.isEmpty()) {
            this.f2829s = bVar;
        } else if (exc != null) {
            C0722p.d(this.f2831u.f2913n);
            f((Status) null, exc, false);
        } else if (this.f2831u.f2914o) {
            f(C0685e.g(this.f2821k, bVar), (Exception) null, true);
            if (!this.f2819a.isEmpty() && !q(bVar) && !this.f2831u.f(bVar, this.f2825o)) {
                if (bVar.c() == 18) {
                    this.f2827q = true;
                }
                if (this.f2827q) {
                    C0685e eVar2 = this.f2831u;
                    eVar2.f2913n.sendMessageDelayed(Message.obtain(eVar2.f2913n, 9, this.f2821k), 5000);
                    return;
                }
                e(C0685e.g(this.f2821k, bVar));
            }
        } else {
            e(C0685e.g(this.f2821k, bVar));
        }
    }

    public final void I(C0655b bVar) {
        C0722p.d(this.f2831u.f2913n);
        C0668a.f fVar = this.f2820b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(bVar);
        fVar.d("onSignInFailed for " + name + " with " + valueOf);
        H(bVar, (Exception) null);
    }

    public final void J() {
        C0722p.d(this.f2831u.f2913n);
        if (this.f2827q) {
            E();
        }
    }

    public final void K() {
        C0722p.d(this.f2831u.f2913n);
        e(C0685e.f2896p);
        this.f2822l.f();
        for (C0689i iVar : (C0689i[]) this.f2824n.keySet().toArray(new C0689i[0])) {
            F(new X((C0689i) null, new C1699m()));
        }
        d(new C0655b(4));
        if (this.f2820b.h()) {
            this.f2820b.i(new C0669A(this));
        }
    }

    public final void L() {
        Status status;
        C0722p.d(this.f2831u.f2913n);
        if (this.f2827q) {
            o();
            C0685e eVar = this.f2831u;
            if (eVar.f2905f.g(eVar.f2904e) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            e(status);
            this.f2820b.d("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.f2820b.o();
    }

    public final boolean b() {
        return r(true);
    }

    public final void i(int i5) {
        if (Looper.myLooper() == this.f2831u.f2913n.getLooper()) {
            l(i5);
        } else {
            this.f2831u.f2913n.post(new C0704y(this, i5));
        }
    }

    public final void j(C0655b bVar) {
        H(bVar, (Exception) null);
    }

    public final void k(Bundle bundle) {
        if (Looper.myLooper() == this.f2831u.f2913n.getLooper()) {
            h();
        } else {
            this.f2831u.f2913n.post(new C0703x(this));
        }
    }

    public final int s() {
        return this.f2825o;
    }

    /* access modifiers changed from: package-private */
    public final int t() {
        return this.f2830t;
    }

    public final C0668a.f v() {
        return this.f2820b;
    }

    public final Map x() {
        return this.f2824n;
    }
}
