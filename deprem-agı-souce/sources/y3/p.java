package y3;

import java.util.concurrent.CancellationException;
import w3.C2887n0;

abstract /* synthetic */ class p {
    public static final void a(x xVar, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = C2887n0.a("Channel was consumed, consumer had failed", th);
            }
        }
        xVar.a(cancellationException);
    }
}
