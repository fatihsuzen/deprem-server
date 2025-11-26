package i;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandleImpl f934a;

    public /* synthetic */ a(SavedStateHandleImpl savedStateHandleImpl) {
        this.f934a = savedStateHandleImpl;
    }

    public final Bundle saveState() {
        return SavedStateHandleImpl.savedStateProvider$lambda$0(this.f934a);
    }
}
