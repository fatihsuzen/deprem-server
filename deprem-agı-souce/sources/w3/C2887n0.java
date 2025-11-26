package w3;

import java.util.concurrent.CancellationException;

/* renamed from: w3.n0  reason: case insensitive filesystem */
public abstract class C2887n0 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
