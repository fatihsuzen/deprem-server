package t1;

import A1.a;
import A1.c;
import A1.e;
import A1.g;
import android.content.Context;
import x1.b;
import x1.i;
import x1.j;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16597a;

    private void c(Context context) {
        g.b(context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        c(context);
        if (!d()) {
            b(true);
            i.d().b(context);
            b.k().a(context);
            a.b(context);
            c.d(context);
            e.c(context);
            x1.g.c().b(context);
            x1.a.a().b(context);
            j.f().b(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z4) {
        this.f16597a = z4;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f16597a;
    }
}
