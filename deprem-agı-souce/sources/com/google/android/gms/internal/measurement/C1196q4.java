package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.q4  reason: case insensitive filesystem */
public enum C1196q4 implements C1107g5 {
    PURPOSE_RESTRICTION_NOT_ALLOWED(0),
    PURPOSE_RESTRICTION_REQUIRE_CONSENT(1),
    PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST(2),
    PURPOSE_RESTRICTION_UNDEFINED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f5550a;

    private C1196q4(int i5) {
        this.f5550a = i5;
    }

    public final int A() {
        if (this != UNRECOGNIZED) {
            return this.f5550a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final String toString() {
        return Integer.toString(this.f5550a);
    }
}
