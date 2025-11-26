package androidx.window.layout;

import android.app.Activity;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1 extends u implements C2616a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class access$windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        boolean z4 = false;
        Class<Consumer> cls = Consumer.class;
        Method method = access$windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", new Class[]{Activity.class, cls});
        Method method2 = access$windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", new Class[]{cls});
        t.d(method, "addListenerMethod");
        if (safeWindowLayoutComponentProvider.isPublic(method)) {
            t.d(method2, "removeListenerMethod");
            if (safeWindowLayoutComponentProvider.isPublic(method2)) {
                z4 = true;
            }
        }
        return Boolean.valueOf(z4);
    }
}
