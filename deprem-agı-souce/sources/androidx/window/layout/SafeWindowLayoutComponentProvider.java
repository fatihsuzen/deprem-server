package androidx.window.layout;

import W2.C2223l;
import W2.m;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.layout.WindowLayoutComponent;
import j3.C2582a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import k3.C2616a;
import r3.C2733c;

public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider INSTANCE = new SafeWindowLayoutComponentProvider();
    private static final C2223l windowLayoutComponent$delegate = m.b(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);

    private SafeWindowLayoutComponentProvider() {
    }

    /* access modifiers changed from: private */
    public final boolean canUseWindowLayoutComponent(ClassLoader classLoader) {
        if (Build.VERSION.SDK_INT < 24 || !isWindowLayoutProviderValid(classLoader) || !isWindowExtensionsValid(classLoader) || !isWindowLayoutComponentValid(classLoader) || !isFoldingFeatureValid(classLoader)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean doesReturn(Method method, C2733c cVar) {
        return doesReturn(method, (Class<?>) C2582a.a(cVar));
    }

    /* access modifiers changed from: private */
    public final Class<?> foldingFeatureClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean isFoldingFeatureValid(ClassLoader classLoader) {
        return validate(new SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(classLoader));
    }

    /* access modifiers changed from: private */
    public final boolean isPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean isWindowExtensionsValid(ClassLoader classLoader) {
        return validate(new SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(classLoader));
    }

    @RequiresApi(24)
    private final boolean isWindowLayoutComponentValid(ClassLoader classLoader) {
        return validate(new SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(classLoader));
    }

    private final boolean isWindowLayoutProviderValid(ClassLoader classLoader) {
        return validate(new SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(classLoader));
    }

    private final boolean validate(C2616a aVar) {
        try {
            return ((Boolean) aVar.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final Class<?> windowExtensionsClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* access modifiers changed from: private */
    public final Class<?> windowExtensionsProviderClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* access modifiers changed from: private */
    public final Class<?> windowLayoutComponentClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        return (WindowLayoutComponent) windowLayoutComponent$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean doesReturn(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
