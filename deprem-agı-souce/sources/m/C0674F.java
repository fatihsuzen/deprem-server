package M;

import K.C0655b;
import L.C0668a;
import N.C0709c;
import N.C0716j;
import android.util.Log;
import java.util.Set;

/* renamed from: M.F  reason: case insensitive filesystem */
final class C0674F implements C0709c.C0050c, P {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C0668a.f f2836a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0682b f2837b;

    /* renamed from: c  reason: collision with root package name */
    private C0716j f2838c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set f2839d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f2840e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C0685e f2841f;

    public C0674F(C0685e eVar, C0668a.f fVar, C0682b bVar) {
        this.f2841f = eVar;
        this.f2836a = fVar;
        this.f2837b = bVar;
    }

    /* access modifiers changed from: private */
    public final void i() {
        C0716j jVar;
        if (this.f2840e && (jVar = this.f2838c) != null) {
            this.f2836a.l(jVar, this.f2839d);
        }
    }

    public final void a(C0655b bVar) {
        this.f2841f.f2913n.post(new C0673E(this, bVar));
    }

    public final void b(C0655b bVar) {
        C0670B b5 = (C0670B) this.f2841f.f2909j.get(this.f2837b);
        if (b5 != null) {
            b5.I(bVar);
        }
    }

    public final void c(C0716j jVar, Set set) {
        if (jVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new C0655b(4));
            return;
        }
        this.f2838c = jVar;
        this.f2839d = set;
        i();
    }

    public final void d(int i5) {
        C0670B b5 = (C0670B) this.f2841f.f2909j.get(this.f2837b);
        if (b5 == null) {
            return;
        }
        if (b5.f2827q) {
            b5.I(new C0655b(17));
        } else {
            b5.i(i5);
        }
    }
}
