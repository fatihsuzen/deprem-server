package com.google.android.gms.internal.measurement;

public abstract class G3 {

    /* renamed from: a  reason: collision with root package name */
    private static F3 f4951a;

    public static synchronized void a(F3 f32) {
        synchronized (G3.class) {
            if (f4951a == null) {
                f4951a = f32;
            } else {
                throw new IllegalStateException("init() already called");
            }
        }
    }

    public static synchronized F3 b() {
        F3 f32;
        synchronized (G3.class) {
            try {
                if (f4951a == null) {
                    a(new J3());
                }
                f32 = f4951a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f32;
    }
}
