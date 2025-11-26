package M;

import android.os.Bundle;

final class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0687g f2915a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2916b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f0 f2917c;

    e0(f0 f0Var, C0687g gVar, String str) {
        this.f2915a = gVar;
        this.f2916b = str;
        this.f2917c = f0Var;
    }

    public final void run() {
        Bundle bundle;
        f0 f0Var = this.f2917c;
        if (f0Var.f2920b > 0) {
            C0687g gVar = this.f2915a;
            if (f0Var.f2921c != null) {
                bundle = f0Var.f2921c.getBundle(this.f2916b);
            } else {
                bundle = null;
            }
            gVar.f(bundle);
        }
        if (this.f2917c.f2920b >= 2) {
            this.f2915a.j();
        }
        if (this.f2917c.f2920b >= 3) {
            this.f2915a.h();
        }
        if (this.f2917c.f2920b >= 4) {
            this.f2915a.k();
        }
        if (this.f2917c.f2920b >= 5) {
            this.f2915a.g();
        }
    }
}
