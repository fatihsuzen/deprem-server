package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.r6  reason: case insensitive filesystem */
public final class C1206r6 implements C1198q6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5568a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        f5568a = b5.d("measurement.service.ad_impression.convert_value_to_double", true);
        b5.d("measurement.service.separate_public_internal_event_blacklisting", true);
        b5.d("measurement.service.ad_impression", true);
    }

    public final boolean A() {
        return ((Boolean) f5568a.d()).booleanValue();
    }
}
