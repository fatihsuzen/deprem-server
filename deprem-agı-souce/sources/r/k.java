package r;

import java.util.concurrent.Executor;
import t.C1876b;
import t.C1878d;

public final class k implements C1876b {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f16288a = new k();
    }

    public static k a() {
        return a.f16288a;
    }

    public static Executor b() {
        return (Executor) C1878d.d(j.a());
    }

    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
