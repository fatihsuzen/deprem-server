package androidx.lifecycle.serialization;

import H3.b;
import H3.l;
import W2.J;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.internal.CanonicalName_jvmKt;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.SavedStateDecoderKt;
import androidx.savedstate.serialization.SavedStateEncoderKt;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import n3.C2701b;
import r3.C2739i;

final class SavedStateHandleDelegate<T> implements C2701b {
    private final SavedStateConfiguration configuration;
    private final C2616a init;
    private final String key;
    private final SavedStateHandle savedStateHandle;
    private final b serializer;
    private T value;

    public SavedStateHandleDelegate(SavedStateHandle savedStateHandle2, b bVar, String str, SavedStateConfiguration savedStateConfiguration, C2616a aVar) {
        t.e(savedStateHandle2, "savedStateHandle");
        t.e(bVar, "serializer");
        t.e(savedStateConfiguration, "configuration");
        t.e(aVar, "init");
        this.savedStateHandle = savedStateHandle2;
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
        Bundle bundle = (Bundle) this.savedStateHandle.get(str);
        if (bundle != null) {
            return SavedStateDecoderKt.decodeFromSavedState(this.serializer, bundle, this.configuration);
        }
        return null;
    }

    private final void registerSave(String str) {
        this.savedStateHandle.setSavedStateProvider(str, new a(this));
    }

    /* access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateHandleDelegate savedStateHandleDelegate) {
        l lVar = savedStateHandleDelegate.serializer;
        T t5 = savedStateHandleDelegate.value;
        if (t5 == null) {
            t.w("value");
            t5 = J.f19942a;
        }
        return SavedStateEncoderKt.encodeToSavedState(lVar, t5, savedStateHandleDelegate.configuration);
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
