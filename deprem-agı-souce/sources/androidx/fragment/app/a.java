package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f354a;

    public /* synthetic */ a(FragmentActivity fragmentActivity) {
        this.f354a = fragmentActivity;
    }

    public final Bundle saveState() {
        return FragmentActivity.j(this.f354a);
    }
}
