package j$.util;

import java.security.PrivilegedAction;

public final /* synthetic */ class w0 implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1858a;

    public /* synthetic */ w0(int i5) {
        this.f1858a = i5;
    }

    public final Object run() {
        switch (this.f1858a) {
            case 0:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
            case 1:
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            default:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    }
}
