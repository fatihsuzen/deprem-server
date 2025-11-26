package androidx.savedstate.serialization;

import H3.b;
import H3.l;
import W2.J;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.internal.CanonicalName_jvmKt;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import n3.C2701b;
import r3.C2739i;

final class SavedStateRegistryOwnerDelegate<T> implements C2701b {
    private final SavedStateConfiguration configuration;
    private final C2616a init;
    private final String key;
    private final SavedStateRegistry registry;
    private final b serializer;
    private T value;

    public SavedStateRegistryOwnerDelegate(SavedStateRegistry savedStateRegistry, b bVar, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar) {
        t.e(savedStateRegistry, "registry");
        t.e(bVar, "serializer");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        this.registry = savedStateRegistry;
        this.serializer = bVar;
        this.key = str;
        this.configuration = savedStateConfiguration;
        this.init = aVar;
    }

    private final String createDefaultKey(Object obj, C2739i iVar) {
        String str;
        if (obj != null) {
            str = CanonicalName_jvmKt.getCanonicalName(M.b(obj.getClass())) + '.';
        } else {
            str = "";
        }
        return str + iVar.getName();
    }

    private final T loadValue(String str) {
        Bundle consumeRestoredStateForKey = this.registry.consumeRestoredStateForKey(str);
        if (consumeRestoredStateForKey != null) {
            return SavedStateDecoderKt.decodeFromSavedState(this.serializer, consumeRestoredStateForKey, this.configuration);
        }
        return null;
    }

    private final void registerSave(String str) {
        this.registry.registerSavedStateProvider(str, new b(this));
    }

    /* access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        l lVar = savedStateRegistryOwnerDelegate.serializer;
        T t5 = savedStateRegistryOwnerDelegate.value;
        if (t5 == null) {
            t.w("value");
            t5 = J.f19942a;
        }
        return SavedStateEncoderKt.encodeToSavedState(lVar, t5, savedStateRegistryOwnerDelegate.configuration);
    }

    public T getValue(Object obj, C2739i iVar) {
        t.e(iVar, "property");
        if (this.value == null) {
            String str = this.key;
            if (str == null) {
                str = createDefaultKey(obj, iVar);
            }
            registerSave(str);
            T loadValue = loadValue(str);
            if (loadValue == null) {
                loadValue = this.init.invoke();
            }
            this.value = loadValue;
        }
        T t5 = this.value;
        if (t5 != null) {
            return t5;
        }
        t.w("value");
        return J.f19942a;
    }

    public void setValue(Object obj, C2739i iVar, T t5) {
        t.e(iVar, "property");
        t.e(t5, "value");
        if (this.value == null) {
            String str = this.key;
            if (str == null) {
                str = createDefaultKey(obj, iVar);
            }
            registerSave(str);
        }
        this.value = t5;
    }
}
