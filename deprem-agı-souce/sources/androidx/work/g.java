package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g implements CallbackToFutureAdapter.Resolver {
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return completer.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for`getForegroundInfoAsync()`"));
    }
}
