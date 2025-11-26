package j$.util;

import java.security.AccessController;

public abstract class x0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1861a = ((Boolean) AccessController.doPrivileged(new w0(0))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
