package b1;

import M0.f;
import d3.C2345b;

/* renamed from: b1.x  reason: case insensitive filesystem */
public enum C1038x implements f {
    LOG_ENVIRONMENT_UNKNOWN(0),
    LOG_ENVIRONMENT_AUTOPUSH(1),
    LOG_ENVIRONMENT_STAGING(2),
    LOG_ENVIRONMENT_PROD(3);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4738a;

    static {
        C1038x[] a5;
        f4737g = C2345b.a(a5);
    }

    private C1038x(int i5) {
        this.f4738a = i5;
    }

    public int getNumber() {
        return this.f4738a;
    }
}
