package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.t;

public final class JvmViewModelProviders {
    public static final JvmViewModelProviders INSTANCE = new JvmViewModelProviders();

    private JvmViewModelProviders() {
    }

    public final <T extends ViewModel> T createViewModel(Class<T> cls) {
        t.e(cls, "modelClass");
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            if (Modifier.isPublic(declaredConstructor.getModifiers())) {
                try {
                    T newInstance = declaredConstructor.newInstance((Object[]) null);
                    t.b(newInstance);
                    return (ViewModel) newInstance;
                } catch (InstantiationException e5) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e5);
                } catch (IllegalAccessException e6) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e6);
                }
            } else {
                throw new RuntimeException("Cannot create an instance of " + cls);
            }
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }
}
