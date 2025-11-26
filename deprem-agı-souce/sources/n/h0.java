package N;

import K.C0655b;
import android.os.Bundle;

public final class h0 extends Q {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C0709c f3099g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(C0709c cVar, int i5, Bundle bundle) {
        super(cVar, i5, bundle);
        this.f3099g = cVar;
    }

    /* access modifiers changed from: protected */
    public final void f(C0655b bVar) {
        if (!this.f3099g.t() || !C0709c.h0(this.f3099g)) {
            this.f3099g.f3031p.a(bVar);
            this.f3099g.L(bVar);
            return;
        }
        C0709c.d0(this.f3099g, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        this.f3099g.f3031p.a(C0655b.f2701e);
        return true;
    }
}
