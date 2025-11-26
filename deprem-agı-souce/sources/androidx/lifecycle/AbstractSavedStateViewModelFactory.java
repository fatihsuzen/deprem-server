package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.t;
import r3.C2733c;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Bundle defaultArgs;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public AbstractSavedStateViewModelFactory() {
    }

    /* access modifiers changed from: protected */
    public abstract <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle);

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        t.e(viewModel, "viewModel");
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        if (savedStateRegistry2 != null) {
            t.b(savedStateRegistry2);
            Lifecycle lifecycle2 = this.lifecycle;
            t.b(lifecycle2);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry2, lifecycle2);
        }
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        t.e(savedStateRegistryOwner, "owner");
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        t.e(cls, "modelClass");
        t.e(creationExtras, "extras");
        String str = (String) creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (this.savedStateRegistry != null) {
            return create(str, cls);
        } else {
            return create(str, cls, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
        }
    }

    private final <T extends ViewModel> T create(String str, Class<T> cls) {
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        t.b(savedStateRegistry2);
        Lifecycle lifecycle2 = this.lifecycle;
        t.b(lifecycle2);
        SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry2, lifecycle2, str, this.defaultArgs);
        T create2 = create(str, cls, create.getHandle());
        create2.addCloseable(LegacySavedStateHandleController.TAG_SAVED_STATE_HANDLE_CONTROLLER, create);
        return create2;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        t.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.lifecycle != null) {
            return create(canonicalName, cls);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }
}
