package A3;

import java.util.concurrent.CancellationException;

public final class a extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient Object f17263a;

    public a(Object obj) {
        super("Flow was aborted, no more elements needed");
        this.f17263a = obj;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
