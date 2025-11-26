package M;

import android.app.Dialog;

final class a0 extends C0676H {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f2877a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b0 f2878b;

    a0(b0 b0Var, Dialog dialog) {
        this.f2878b = b0Var;
        this.f2877a = dialog;
    }

    public final void a() {
        this.f2878b.f2884b.o();
        if (this.f2877a.isShowing()) {
            this.f2877a.dismiss();
        }
    }
}
