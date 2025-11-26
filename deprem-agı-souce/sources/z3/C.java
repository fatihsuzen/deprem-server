package z3;

import A3.d;
import b3.C2308e;

public final class C extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f26589a = -1;

    /* renamed from: b  reason: collision with root package name */
    public C2308e f26590b;

    /* renamed from: c */
    public boolean a(C2967A a5) {
        if (this.f26589a >= 0) {
            return false;
        }
        this.f26589a = a5.U();
        return true;
    }

    /* renamed from: d */
    public C2308e[] b(C2967A a5) {
        long j5 = this.f26589a;
        this.f26589a = -1;
        this.f26590b = null;
        return a5.T(j5);
    }
}
