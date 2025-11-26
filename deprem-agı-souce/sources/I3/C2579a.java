package i3;

import W2.C2216e;
import androidx.core.provider.c;

/* renamed from: i3.a  reason: case insensitive filesystem */
public abstract class C2579a {
    public static final void a(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            c.a(autoCloseable);
            return;
        }
        try {
            c.a(autoCloseable);
        } catch (Throwable th2) {
            C2216e.a(th, th2);
        }
    }
}
