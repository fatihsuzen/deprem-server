package androidx.browser.trusted;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionHolder f232a;

    public /* synthetic */ a(ConnectionHolder connectionHolder) {
        this.f232a = connectionHolder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ConnectionHolder.a(this.f232a, completer);
    }
}
