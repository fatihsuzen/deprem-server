package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.g6  reason: case insensitive filesystem */
final class C1108g6 extends C1117h6 {
    C1108g6(Unsafe unsafe) {
        super(unsafe);
    }

    public final void a(Object obj, long j5, byte b5) {
        if (C1126i6.f5386h) {
            C1126i6.d(obj, j5, b5);
        } else {
            C1126i6.e(obj, j5, b5);
        }
    }

    public final boolean b(Object obj, long j5) {
        if (C1126i6.f5386h) {
            return C1126i6.z(obj, j5);
        }
        return C1126i6.A(obj, j5);
    }

    public final void c(Object obj, long j5, boolean z4) {
        if (C1126i6.f5386h) {
            C1126i6.d(obj, j5, r3 ? (byte) 1 : 0);
        } else {
            C1126i6.e(obj, j5, r3 ? (byte) 1 : 0);
        }
    }

    public final float d(Object obj, long j5) {
        return Float.intBitsToFloat(this.f5369a.getInt(obj, j5));
    }

    public final void e(Object obj, long j5, float f5) {
        this.f5369a.putInt(obj, j5, Float.floatToIntBits(f5));
    }

    public final double f(Object obj, long j5) {
        return Double.longBitsToDouble(this.f5369a.getLong(obj, j5));
    }

    public final void g(Object obj, long j5, double d5) {
        this.f5369a.putLong(obj, j5, Double.doubleToLongBits(d5));
    }
}
