package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.b5  reason: case insensitive filesystem */
final class C1062b5 implements D5 {

    /* renamed from: a  reason: collision with root package name */
    private static final C1062b5 f5310a = new C1062b5();

    private C1062b5() {
    }

    public static C1062b5 c() {
        return f5310a;
    }

    public final boolean a(Class cls) {
        return C1089e5.class.isAssignableFrom(cls);
    }

    public final C5 b(Class cls) {
        Class<C1089e5> cls2 = C1089e5.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (C5) C1089e5.s(cls.asSubclass(cls2)).E(3, (Object) null, (Object) null);
            } catch (Exception e5) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e5);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }
}
