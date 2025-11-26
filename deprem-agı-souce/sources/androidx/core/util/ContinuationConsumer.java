package androidx.core.util;

import W2.t;
import androidx.annotation.RequiresApi;
import b3.C2308e;
import j$.util.function.Consumer$CC;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final C2308e continuation;

    public ContinuationConsumer(C2308e eVar) {
        super(false);
        this.continuation = eVar;
    }

    public void accept(T t5) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t.b(t5));
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
