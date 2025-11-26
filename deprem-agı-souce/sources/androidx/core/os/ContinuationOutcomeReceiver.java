package androidx.core.os;

import W2.t;
import W2.u;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import b3.C2308e;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver {
    private final C2308e continuation;

    public ContinuationOutcomeReceiver(C2308e eVar) {
        super(false);
        this.continuation = eVar;
    }

    public void onError(E e5) {
        if (compareAndSet(false, true)) {
            C2308e eVar = this.continuation;
            t.a aVar = t.f19966b;
            eVar.resumeWith(t.b(u.a(e5)));
        }
    }

    public void onResult(R r5) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t.b(r5));
        }
    }

    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
