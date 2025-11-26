package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.h6  reason: case insensitive filesystem */
abstract class C1117h6 {

    /* renamed from: a  reason: collision with root package name */
    final Unsafe f5369a;

    C1117h6(Unsafe unsafe) {
        this.f5369a = unsafe;
    }

    public abstract void a(Object obj, long j5, byte b5);

    public abstract boolean b(Object obj, long j5);

    public abstract void c(Object obj, long j5, boolean z4);

    public abstract float d(Object obj, long j5);

    public abstract void e(Object obj, long j5, float f5);

    public abstract double f(Object obj, long j5);

    public abstract void g(Object obj, long j5, double d5);
}
