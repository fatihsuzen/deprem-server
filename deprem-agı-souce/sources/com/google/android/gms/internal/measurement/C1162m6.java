package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m6  reason: case insensitive filesystem */
public enum C1162m6 {
    DOUBLE(C1171n6.DOUBLE, 1),
    FLOAT(C1171n6.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(C1171n6.BOOLEAN, 0),
    STRING(C1171n6.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(C1171n6.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(C1171n6.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    

    /* renamed from: a  reason: collision with root package name */
    private final C1171n6 f5469a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5470b;

    private C1162m6(C1171n6 n6Var, int i5) {
        this.f5469a = n6Var;
        this.f5470b = i5;
    }

    public final C1171n6 a() {
        return this.f5469a;
    }

    public final int b() {
        return this.f5470b;
    }
}
