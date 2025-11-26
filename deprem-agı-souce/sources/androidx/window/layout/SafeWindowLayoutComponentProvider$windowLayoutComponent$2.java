package androidx.window.layout;

import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class SafeWindowLayoutComponentProvider$windowLayoutComponent$2 extends u implements C2616a {
    public static final SafeWindowLayoutComponentProvider$windowLayoutComponent$2 INSTANCE = new SafeWindowLayoutComponentProvider$windowLayoutComponent$2();

    SafeWindowLayoutComponentProvider$windowLayoutComponent$2() {
        super(0);
    }

    public final WindowLayoutComponent invoke() {
        ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
        if (classLoader == null || !SafeWindowLayoutComponentProvider.INSTANCE.canUseWindowLayoutComponent(classLoader)) {
            WindowLayoutComponent windowLayoutComponent = null;
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            WindowLayoutComponent windowLayoutComponent2 = null;
            return null;
        }
    }
}
