package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.c4  reason: case insensitive filesystem */
final class C1070c4 extends C1160m4 {
    C1070c4(C1106g4 g4Var, String str, Long l5, boolean z4) {
        super(g4Var, str, l5, true, (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.f5445b;
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder(str.length() + 25 + obj2.length());
        sb.append("Invalid long value for ");
        sb.append(str);
        sb.append(": ");
        sb.append(obj2);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
