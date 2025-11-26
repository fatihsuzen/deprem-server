package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.savedstate.Recreator;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.jvm.internal.t;

public final class SavedStateRegistry {
    private final SavedStateRegistryImpl impl;
    private Recreator.SavedStateProvider recreatorProvider;

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    public SavedStateRegistry(SavedStateRegistryImpl savedStateRegistryImpl) {
        t.e(savedStateRegistryImpl, "impl");
        this.impl = savedStateRegistryImpl;
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String str) {
        t.e(str, "key");
        return this.impl.consumeRestoredStateForKey(str);
    }

    public final SavedStateProvider getSavedStateProvider(String str) {
        t.e(str, "key");
        return this.impl.getSavedStateProvider(str);
    }

    @MainThread
    public final boolean isRestored() {
        return this.impl.isRestored();
    }

    @MainThread
    public final void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        t.e(str, "key");
        t.e(savedStateProvider, "provider");
        this.impl.registerSavedStateProvider(str, savedStateProvider);
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        t.e(cls, "clazz");
        if (this.impl.isAllowingSavingState$savedstate_release()) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                cls.getDeclaredConstructor((Class[]) null);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    String name = cls.getName();
                    t.d(name, "getName(...)");
                    savedStateProvider2.add(name);
                }
            } catch (NoSuchMethodException e5) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @MainThread
    public final void unregisterSavedStateProvider(String str) {
        t.e(str, "key");
        this.impl.unregisterSavedStateProvider(str);
    }
}
