package u1;

import A1.g;
import android.view.View;

public abstract class b {
    public static b b(c cVar, d dVar) {
        g.a();
        g.b(cVar, "AdSessionConfiguration is null");
        g.b(dVar, "AdSessionContext is null");
        return new n(cVar, dVar);
    }

    public abstract void a(View view, h hVar, String str);

    public abstract void c();

    public abstract void d(View view);

    public abstract void e();

    public abstract void f(View view);

    public abstract void g();
}
