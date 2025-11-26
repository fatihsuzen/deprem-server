package androidx.window.layout;

import java.lang.reflect.Method;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1 extends u implements C2616a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Method declaredMethod = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(this.$classLoader).getDeclaredMethod("getWindowExtensions", (Class[]) null);
        Class access$windowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader);
        t.d(declaredMethod, "getWindowExtensionsMethod");
        t.d(access$windowExtensionsClass, "windowExtensionsClass");
        return Boolean.valueOf(safeWindowLayoutComponentProvider.doesReturn(declaredMethod, (Class<?>) access$windowExtensionsClass) && safeWindowLayoutComponentProvider.isPublic(declaredMethod));
    }
}
