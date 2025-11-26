package w3;

import B3.D;
import B3.N;

public final class W0 {

    /* renamed from: a  reason: collision with root package name */
    public static final W0 f26260a = new W0();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f26261b = N.a(new D("ThreadLocalEventLoop"));

    private W0() {
    }

    public final C2877i0 a() {
        return (C2877i0) f26261b.get();
    }

    public final C2877i0 b() {
        ThreadLocal threadLocal = f26261b;
        C2877i0 i0Var = (C2877i0) threadLocal.get();
        if (i0Var != null) {
            return i0Var;
        }
        C2877i0 a5 = C2883l0.a();
        threadLocal.set(a5);
        return a5;
    }

    public final void c() {
        f26261b.set((Object) null);
    }

    public final void d(C2877i0 i0Var) {
        f26261b.set(i0Var);
    }
}
