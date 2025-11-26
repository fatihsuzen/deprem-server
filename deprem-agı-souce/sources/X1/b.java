package x1;

import android.view.View;
import u1.n;

public class b extends d {

    /* renamed from: d  reason: collision with root package name */
    private static b f16971d = new b();

    private b() {
    }

    public static b k() {
        return f16971d;
    }

    public void f(boolean z4) {
        for (n t5 : c.e().c()) {
            t5.t().n(z4);
        }
    }

    public boolean h() {
        for (n n5 : c.e().a()) {
            View n6 = n5.n();
            if (n6 != null && n6.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
