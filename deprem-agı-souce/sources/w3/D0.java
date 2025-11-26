package w3;

import B3.C1995o;
import kotlin.jvm.internal.t;

public abstract class D0 extends C1995o implements C2869e0, C2900u0 {

    /* renamed from: d  reason: collision with root package name */
    public E0 f26216d;

    public J0 b() {
        return null;
    }

    public void dispose() {
        t().A0(this);
    }

    public boolean isActive() {
        return true;
    }

    public final E0 t() {
        E0 e02 = this.f26216d;
        if (e02 != null) {
            return e02;
        }
        t.w("job");
        return null;
    }

    public String toString() {
        return Q.a(this) + '@' + Q.b(this) + "[job@" + Q.b(t()) + ']';
    }

    public abstract boolean u();

    public abstract void v(Throwable th);

    public final void w(E0 e02) {
        this.f26216d = e02;
    }
}
