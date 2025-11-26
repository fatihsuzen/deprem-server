package kotlin.coroutines.jvm.internal;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;

final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f24679a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final a f24680b = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: c  reason: collision with root package name */
    private static a f24681c;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f24682a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f24683b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f24684c;

        public a(Method method, Method method2, Method method3) {
            this.f24682a = method;
            this.f24683b = method2;
            this.f24684c = method3;
        }
    }

    private i() {
    }

    private final a a(a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", (Class[]) null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", (Class[]) null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(RewardPlus.NAME, (Class[]) null));
            f24681c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f24680b;
            f24681c = aVar3;
            return aVar3;
        }
    }

    public final String b(a aVar) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Object obj;
        t.e(aVar, "continuation");
        a aVar2 = f24681c;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (!(aVar2 == f24680b || (method = aVar2.f24682a) == null || (invoke = method.invoke(aVar.getClass(), (Object[]) null)) == null || (method2 = aVar2.f24683b) == null || (invoke2 = method2.invoke(invoke, (Object[]) null)) == null)) {
            Method method3 = aVar2.f24684c;
            if (method3 != null) {
                obj = method3.invoke(invoke2, (Object[]) null);
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }
}
