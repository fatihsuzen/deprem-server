package com.google.android.gms.internal.measurement;

public enum X4 {
    DOUBLE(0, 1, r6),
    FLOAT(1, 1, r13),
    INT64(2, 1, r20),
    UINT64(3, 1, r20),
    INT32(4, 1, r28),
    FIXED64(5, 1, r20),
    FIXED32(6, 1, r28),
    BOOL(7, 1, r37),
    STRING(8, 1, r43),
    MESSAGE(9, 1, r50),
    BYTES(10, 1, r49),
    UINT32(11, 1, r28),
    ENUM(12, 1, r65),
    SFIXED32(13, 1, r28),
    SFIXED64(14, 1, r20),
    SINT32(15, 1, r28),
    SINT64(16, 1, r20),
    GROUP(17, 1, r50),
    DOUBLE_LIST(18, 2, r6),
    FLOAT_LIST(19, 2, r13),
    INT64_LIST(20, 2, r20),
    UINT64_LIST(21, 2, r20),
    INT32_LIST(22, 2, r28),
    FIXED64_LIST(23, 2, r20),
    FIXED32_LIST(24, 2, r28),
    BOOL_LIST(25, 2, r37),
    STRING_LIST(26, 2, r43),
    MESSAGE_LIST(27, 2, r50),
    BYTES_LIST(28, 2, r49),
    UINT32_LIST(29, 2, r28),
    ENUM_LIST(30, 2, r65),
    SFIXED32_LIST(31, 2, r28),
    SFIXED64_LIST(32, 2, r20),
    SINT32_LIST(33, 2, r28),
    SINT64_LIST(34, 2, r20),
    DOUBLE_LIST_PACKED(35, 3, r6),
    FLOAT_LIST_PACKED(36, 3, r13),
    INT64_LIST_PACKED(37, 3, r20),
    UINT64_LIST_PACKED(38, 3, r20),
    INT32_LIST_PACKED(39, 3, r28),
    FIXED64_LIST_PACKED(40, 3, r20),
    FIXED32_LIST_PACKED(41, 3, r28),
    BOOL_LIST_PACKED(42, 3, r37),
    UINT32_LIST_PACKED(43, 3, r28),
    ENUM_LIST_PACKED(44, 3, r65),
    SFIXED32_LIST_PACKED(45, 3, r28),
    SFIXED64_LIST_PACKED(46, 3, r20),
    SINT32_LIST_PACKED(47, 3, r28),
    SINT64_LIST_PACKED(48, 3, r20),
    GROUP_LIST(49, 2, r50),
    MAP(50, 4, C1179o5.VOID);
    

    /* renamed from: m0  reason: collision with root package name */
    private static final X4[] f5254m0 = null;

    /* renamed from: a  reason: collision with root package name */
    private final int f5269a;

    static {
        int i5;
        f5254m0 = new X4[r1];
        for (X4 x4 : values()) {
            f5254m0[x4.f5269a] = x4;
        }
    }

    private X4(int i5, int i6, C1179o5 o5Var) {
        this.f5269a = i5;
        int i7 = i6 - 1;
        if (i7 == 1) {
            o5Var.a();
        } else if (i7 == 3) {
            o5Var.a();
        }
        if (i6 == 1) {
            C1179o5 o5Var2 = C1179o5.VOID;
            o5Var.ordinal();
        }
    }

    public final int A() {
        return this.f5269a;
    }
}
