package androidx.window.layout;

import android.graphics.Rect;
import java.lang.reflect.Method;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends u implements C2616a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        boolean z4;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class access$foldingFeatureClass = safeWindowLayoutComponentProvider.foldingFeatureClass(this.$classLoader);
        Method method = access$foldingFeatureClass.getMethod("getBounds", (Class[]) null);
        Method method2 = access$foldingFeatureClass.getMethod("getType", (Class[]) null);
        Method method3 = access$foldingFeatureClass.getMethod("getState", (Class[]) null);
        t.d(method, "getBoundsMethod");
        if (safeWindowLayoutComponentProvider.doesReturn(method, M.b(Rect.class)) && safeWindowLayoutComponentProvider.isPublic(method)) {
            t.d(method2, "getTypeMethod");
            Class cls = Integer.TYPE;
            if (safeWindowLayoutComponentProvider.doesReturn(method2, M.b(cls)) && safeWindowLayoutComponentProvider.isPublic(method2)) {
                t.d(method3, "getStateMethod");
                if (safeWindowLayoutComponentProvider.doesReturn(method3, M.b(cls)) && safeWindowLayoutComponentProvider.isPublic(method3)) {
                    z4 = true;
                    return Boolean.valueOf(z4);
                }
            }
        }
        z4 = false;
        return Boolean.valueOf(z4);
    }
}
