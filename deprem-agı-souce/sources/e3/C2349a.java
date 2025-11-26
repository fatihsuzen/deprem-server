package e3;

import X2.C2242i;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import o3.C2704b;
import o3.C2705c;

/* renamed from: e3.a  reason: case insensitive filesystem */
public abstract class C2349a {

    /* renamed from: e3.a$a  reason: collision with other inner class name */
    private static final class C0220a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0220a f21494a = new C0220a();

        /* renamed from: b  reason: collision with root package name */
        public static final Method f21495b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f21496c;

        static {
            Method method;
            Method method2;
            Class<Throwable> cls = Throwable.class;
            Method[] methods = cls.getMethods();
            t.b(methods);
            int length = methods.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                method = null;
                if (i6 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i6];
                if (t.a(method2.getName(), "addSuppressed")) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    t.d(parameterTypes, "getParameterTypes(...)");
                    if (t.a(C2242i.j0(parameterTypes), cls)) {
                        break;
                    }
                }
                i6++;
            }
            f21495b = method2;
            int length2 = methods.length;
            while (true) {
                if (i5 >= length2) {
                    break;
                }
                Method method3 = methods[i5];
                if (t.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i5++;
            }
            f21496c = method;
        }

        private C0220a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        t.e(th, "cause");
        t.e(th2, "exception");
        Method method = C0220a.f21495b;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    public C2705c b() {
        return new C2704b();
    }
}
