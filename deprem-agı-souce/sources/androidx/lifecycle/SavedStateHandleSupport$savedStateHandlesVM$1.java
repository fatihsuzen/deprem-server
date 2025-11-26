package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class SavedStateHandleSupport$savedStateHandlesVM$1 implements ViewModelProvider.Factory {
    SavedStateHandleSupport$savedStateHandlesVM$1() {
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return y.a(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public <T extends ViewModel> T create(C2733c cVar, CreationExtras creationExtras) {
        t.e(cVar, "modelClass");
        t.e(creationExtras, "extras");
        return new SavedStateHandlesVM();
    }
}
