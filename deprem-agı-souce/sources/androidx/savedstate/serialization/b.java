package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class b implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistryOwnerDelegate f474a;

    public /* synthetic */ b(SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        this.f474a = savedStateRegistryOwnerDelegate;
    }

    public final Bundle saveState() {
        return SavedStateRegistryOwnerDelegate.registerSave$lambda$1(this.f474a);
    }
}
