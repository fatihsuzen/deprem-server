package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public final class ViewModelProviderGetKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        t.e(viewModelProvider, "<this>");
        t.k(4, "VM");
        return viewModelProvider.get(M.b(ViewModel.class));
    }
}
