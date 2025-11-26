package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.v5  reason: case insensitive filesystem */
final class C1241v5 implements D5 {

    /* renamed from: a  reason: collision with root package name */
    private final D5[] f5613a;

    C1241v5(D5... d5Arr) {
        this.f5613a = d5Arr;
    }

    public final boolean a(Class cls) {
        for (int i5 = 0; i5 < 2; i5++) {
            if (this.f5613a[i5].a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final C5 b(Class cls) {
        for (int i5 = 0; i5 < 2; i5++) {
            D5 d5 = this.f5613a[i5];
            if (d5.a(cls)) {
                return d5.b(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
