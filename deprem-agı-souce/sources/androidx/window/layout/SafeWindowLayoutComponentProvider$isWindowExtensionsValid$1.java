package androidx.window.layout;

import java.lang.reflect.Method;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1 extends u implements C2616a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        boolean z4;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Method method = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader).getMethod("getWindowLayoutComponent", (Class[]) null);
        Class access$windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        t.d(method, "getWindowLayoutComponentMethod");
        if (safeWindowLayoutComponentProvider.isPublic(method)) {
            t.d(access$windowLayoutComponentClass, "windowLayoutComponentClass");
            if (safeWindowLayoutComponentProvider.doesReturn(method, (Class<?>) access$windowLayoutComponentClass)) {
                z4 = true;
                return Boolean.valueOf(z4);
            }
        }
        z4 = false;
        return Boolean.valueOf(z4);
    }
}
