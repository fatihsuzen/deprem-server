package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.n  reason: case insensitive filesystem */
enum C1378n {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');
    

    /* renamed from: a  reason: collision with root package name */
    private final char f6571a;

    private C1378n(char c5) {
        this.f6571a = c5;
    }

    public static C1378n a(char c5) {
        for (C1378n nVar : values()) {
            if (nVar.f6571a == c5) {
                return nVar;
            }
        }
        return UNSET;
    }
}
