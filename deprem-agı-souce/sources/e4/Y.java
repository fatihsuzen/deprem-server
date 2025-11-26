package e4;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.t;

final class Y extends C2354c {

    /* renamed from: o  reason: collision with root package name */
    private final Socket f21527o;

    public Y(Socket socket) {
        t.e(socket, "socket");
        this.f21527o = socket;
    }

    /* access modifiers changed from: protected */
    public void B() {
        try {
            this.f21527o.close();
        } catch (Exception e5) {
            Logger a5 = M.f21498a;
            Level level = Level.WARNING;
            a5.log(level, "Failed to close timed out socket " + this.f21527o, e5);
        } catch (AssertionError e6) {
            if (L.e(e6)) {
                Logger a6 = M.f21498a;
                Level level2 = Level.WARNING;
                a6.log(level2, "Failed to close timed out socket " + this.f21527o, e6);
                return;
            }
            throw e6;
        }
    }

    /* access modifiers changed from: protected */
    public IOException x(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
