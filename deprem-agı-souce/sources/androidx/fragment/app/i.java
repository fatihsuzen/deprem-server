package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class i implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f362a;

    public /* synthetic */ i(FragmentManager fragmentManager) {
        this.f362a = fragmentManager;
    }

    public final Bundle saveState() {
        return this.f362a.saveAllStateInternal();
    }
}
