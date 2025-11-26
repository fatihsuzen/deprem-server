package M;

import K.C0655b;
import L.C0668a;
import L.f;
import N.C0710d;
import N.C0722p;
import N.O;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import h0.C1670d;
import h0.e;
import i0.C1675d;
import i0.l;
import java.util.Set;

public final class Q extends C1675d implements f.a, f.b {

    /* renamed from: p  reason: collision with root package name */
    private static final C0668a.C0048a f2860p = C1670d.f15360c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2861a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2862b;

    /* renamed from: k  reason: collision with root package name */
    private final C0668a.C0048a f2863k;

    /* renamed from: l  reason: collision with root package name */
    private final Set f2864l;

    /* renamed from: m  reason: collision with root package name */
    private final C0710d f2865m;

    /* renamed from: n  reason: collision with root package name */
    private e f2866n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public P f2867o;

    public Q(Context context, Handler handler, C0710d dVar) {
        C0668a.C0048a aVar = f2860p;
        this.f2861a = context;
        this.f2862b = handler;
        this.f2865m = (C0710d) C0722p.l(dVar, "ClientSettings must not be null");
        this.f2864l = dVar.g();
        this.f2863k = aVar;
    }

    static /* bridge */ /* synthetic */ void s0(Q q5, l lVar) {
        C0655b c5 = lVar.c();
        if (c5.i()) {
            O o5 = (O) C0722p.k(lVar.d());
            C0655b c6 = o5.c();
            if (!c6.i()) {
                String valueOf = String.valueOf(c6);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                q5.f2867o.b(c6);
                q5.f2866n.b();
                return;
            }
            q5.f2867o.c(o5.d(), q5.f2864l);
        } else {
            q5.f2867o.b(c5);
        }
        q5.f2866n.b();
    }

    public final void c0(l lVar) {
        this.f2862b.post(new O(this, lVar));
    }

    public final void i(int i5) {
        this.f2867o.d(i5);
    }

    public final void j(C0655b bVar) {
        this.f2867o.b(bVar);
    }

    public final void k(Bundle bundle) {
        this.f2866n.a(this);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [L.a$f, h0.e] */
    public final void t0(P p5) {
        e eVar = this.f2866n;
        if (eVar != null) {
            eVar.b();
        }
        this.f2865m.k(Integer.valueOf(System.identityHashCode(this)));
        C0668a.C0048a aVar = this.f2863k;
        Context context = this.f2861a;
        Handler handler = this.f2862b;
        C0710d dVar = this.f2865m;
        this.f2866n = aVar.a(context, handler.getLooper(), dVar, dVar.h(), this, this);
        this.f2867o = p5;
        Set set = this.f2864l;
        if (set == null || set.isEmpty()) {
            this.f2862b.post(new N(this));
        } else {
            this.f2866n.p();
        }
    }

    public final void u0() {
        e eVar = this.f2866n;
        if (eVar != null) {
            eVar.b();
        }
    }
}
