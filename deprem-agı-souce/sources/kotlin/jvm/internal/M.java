package kotlin.jvm.internal;

import r3.C2733c;
import r3.C2735e;
import r3.C2736f;
import r3.C2738h;
import r3.C2740j;
import r3.C2741k;
import r3.C2742l;

public abstract class M {

    /* renamed from: a  reason: collision with root package name */
    private static final N f24691a;

    /* renamed from: b  reason: collision with root package name */
    private static final C2733c[] f24692b = new C2733c[0];

    static {
        N n5 = null;
        try {
            n5 = (N) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (n5 == null) {
            n5 = new N();
        }
        f24691a = n5;
    }

    public static C2736f a(C2638p pVar) {
        return f24691a.a(pVar);
    }

    public static C2733c b(Class cls) {
        return f24691a.b(cls);
    }

    public static C2735e c(Class cls) {
        return f24691a.c(cls, "");
    }

    public static C2738h d(x xVar) {
        return f24691a.d(xVar);
    }

    public static C2740j e(B b5) {
        return f24691a.e(b5);
    }

    public static C2741k f(D d5) {
        return f24691a.f(d5);
    }

    public static C2742l g(F f5) {
        return f24691a.g(f5);
    }

    public static String h(C2637o oVar) {
        return f24691a.h(oVar);
    }

    public static String i(u uVar) {
        return f24691a.i(uVar);
    }
}
