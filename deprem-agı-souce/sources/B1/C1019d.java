package b1;

import M0.f;
import d3.C2345b;

/* renamed from: b1.d  reason: case insensitive filesystem */
public enum C1019d implements f {
    COLLECTION_UNKNOWN(0),
    COLLECTION_SDK_NOT_INSTALLED(1),
    COLLECTION_ENABLED(2),
    COLLECTION_DISABLED(3),
    COLLECTION_DISABLED_REMOTE(4),
    COLLECTION_SAMPLED(5);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f4697a;

    static {
        C1019d[] a5;
        f4696i = C2345b.a(a5);
    }

    private C1019d(int i5) {
        this.f4697a = i5;
    }

    public int getNumber() {
        return this.f4697a;
    }
}
