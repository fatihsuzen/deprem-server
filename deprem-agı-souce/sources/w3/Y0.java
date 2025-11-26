package w3;

import B3.z;
import b3.C2308e;

final class Y0 extends z implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final long f26266e;

    public Y0(long j5, C2308e eVar) {
        super(eVar.getContext(), eVar);
        this.f26266e = j5;
    }

    public String r0() {
        return super.r0() + "(timeMillis=" + this.f26266e + ')';
    }

    public void run() {
        L(Z0.a(this.f26266e, X.c(getContext()), this));
    }
}
