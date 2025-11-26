package androidx.lifecycle.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandleDelegate f394a;

    public /* synthetic */ a(SavedStateHandleDelegate savedStateHandleDelegate) {
        this.f394a = savedStateHandleDelegate;
    }

    public final Bundle saveState() {
        return SavedStateHandleDelegate.registerSave$lambda$1(this.f394a);
    }
}
