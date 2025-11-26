package androidx.lifecycle;

import X2.C2242i;
import X2.C2250q;
import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactory_androidKt {
    /* access modifiers changed from: private */
    public static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    /* access modifiers changed from: private */
    public static final List<Class<?>> VIEWMODEL_SIGNATURE;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        ANDROID_VIEWMODEL_SIGNATURE = C2250q.j(Application.class, cls);
        VIEWMODEL_SIGNATURE = C2250q.d(cls);
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> list) {
        t.e(cls, "modelClass");
        t.e(list, "signature");
        Iterator a5 = C2625c.a(cls.getConstructors());
        while (a5.hasNext()) {
            Constructor<T> constructor = (Constructor) a5.next();
            Class[] parameterTypes = constructor.getParameterTypes();
            t.d(parameterTypes, "getParameterTypes(...)");
            List q02 = C2242i.q0(parameterTypes);
            if (t.a(list, q02)) {
                t.c(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactory_androidKt.findMatchingConstructor>");
                return constructor;
            } else if (list.size() == q02.size() && q02.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        t.e(cls, "modelClass");
        t.e(constructor, "constructor");
        t.e(objArr, "params");
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Failed to access " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e7.getCause());
        }
    }
}
