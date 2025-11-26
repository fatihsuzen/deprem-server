package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScopeKt;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import kotlin.jvm.internal.t;
import w3.M;

public final class ViewModelKt {
    private static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();

    public static final M getViewModelScope(ViewModel viewModel) {
        CloseableCoroutineScope closeableCoroutineScope;
        t.e(viewModel, "<this>");
        synchronized (VIEW_MODEL_SCOPE_LOCK) {
            closeableCoroutineScope = (CloseableCoroutineScope) viewModel.getCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY);
            if (closeableCoroutineScope == null) {
                closeableCoroutineScope = CloseableCoroutineScopeKt.createViewModelScope();
                viewModel.addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, closeableCoroutineScope);
            }
        }
        return closeableCoroutineScope;
    }
}
