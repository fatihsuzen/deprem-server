package h3;

import W2.C2216e;
import java.io.Closeable;

/* renamed from: h3.b  reason: case insensitive filesystem */
public abstract class C2453b {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            C2216e.a(th, th2);
        }
    }
}
