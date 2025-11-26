package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.a7  reason: case insensitive filesystem */
public final class C1055a7 implements Z6 {

    /* renamed from: a  reason: collision with root package name */
    public static final C1160m4 f5301a;

    static {
        C1106g4 b5 = new C1106g4(C1061b4.a("com.google.android.gms.measurement")).a().b();
        b5.d("measurement.gbraid_campaign.gbraid.client", true);
        f5301a = b5.d("measurement.gbraid_campaign.stop_lgclid", false);
    }

    public final boolean A() {
        return ((Boolean) f5301a.d()).booleanValue();
    }
}
