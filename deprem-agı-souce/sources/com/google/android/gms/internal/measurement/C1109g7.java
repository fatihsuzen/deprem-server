package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.g7  reason: case insensitive filesystem */
public final class C1109g7 implements C1100f7 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5362a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.sdk.collection.enable_extend_user_property_size", true);
        f5362a = b5.d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        b5.c("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean A() {
        return ((Boolean) f5362a.d()).booleanValue();
    }
}
