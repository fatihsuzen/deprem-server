package androidx.savedstate;

import W2.J;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SavedStateRegistryController {
    public static final Companion Companion = new Companion((C2633k) null);
    private final SavedStateRegistryImpl impl;
    private final SavedStateRegistry savedStateRegistry;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final J create$lambda$0(SavedStateRegistryOwner savedStateRegistryOwner) {
            savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(savedStateRegistryOwner));
            return J.f19942a;
        }

        public final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
            t.e(savedStateRegistryOwner, "owner");
            return new SavedStateRegistryController(new SavedStateRegistryImpl(savedStateRegistryOwner, new a(savedStateRegistryOwner)), (C2633k) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl, C2633k kVar) {
        this(savedStateRegistryImpl);
    }

    public static final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        return Companion.create(savedStateRegistryOwner);
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void performAttach() {
        this.impl.performAttach();
    }

    @MainThread
    public final void performRestore(Bundle bundle) {
        this.impl.performRestore$savedstate_release(bundle);
    }

    @MainThread
    public final void performSave(Bundle bundle) {
        t.e(bundle, "outBundle");
        this.impl.performSave$savedstate_release(bundle);
    }

    private SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.impl = savedStateRegistryImpl;
        this.savedStateRegistry = new SavedStateRegistry(savedStateRegistryImpl);
    }
}
