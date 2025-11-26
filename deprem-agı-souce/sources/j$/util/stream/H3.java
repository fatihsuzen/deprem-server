package j$.util.stream;

import j$.util.w0;
import java.security.AccessController;

public abstract class H3 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1490a = ((Boolean) AccessController.doPrivileged(new w0(2))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
