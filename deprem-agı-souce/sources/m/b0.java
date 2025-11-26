package M;

import K.C0655b;
import N.C0722p;
import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;

final class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Z f2883a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c0 f2884b;

    b0(c0 c0Var, Z z4) {
        this.f2884b = c0Var;
        this.f2883a = z4;
    }

    public final void run() {
        if (this.f2884b.f2890b) {
            C0655b b5 = this.f2883a.b();
            if (b5.g()) {
                c0 c0Var = this.f2884b;
                c0Var.f2922a.startActivityForResult(GoogleApiActivity.a(c0Var.b(), (PendingIntent) C0722p.k(b5.f()), this.f2883a.a(), false), 1);
                return;
            }
            c0 c0Var2 = this.f2884b;
            if (c0Var2.f2893e.b(c0Var2.b(), b5.c(), (String) null) != null) {
                c0 c0Var3 = this.f2884b;
                c0Var3.f2893e.w(c0Var3.b(), c0Var3.f2922a, b5.c(), 2, this.f2884b);
            } else if (b5.c() == 18) {
                c0 c0Var4 = this.f2884b;
                Dialog r5 = c0Var4.f2893e.r(c0Var4.b(), c0Var4);
                c0 c0Var5 = this.f2884b;
                c0Var5.f2893e.s(c0Var5.b().getApplicationContext(), new a0(this, r5));
            } else {
                this.f2884b.l(b5, this.f2883a.a());
            }
        }
    }
}
