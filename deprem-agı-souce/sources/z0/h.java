package Z0;

import android.content.Context;
import r0.C1786c;
import r0.r;

public abstract class h {

    public interface a {
        String a(Object obj);
    }

    public static C1786c b(String str, String str2) {
        return C1786c.l(f.a(str, str2), f.class);
    }

    public static C1786c c(String str, a aVar) {
        return C1786c.m(f.class).b(r.k(Context.class)).f(new g(str, aVar)).d();
    }
}
