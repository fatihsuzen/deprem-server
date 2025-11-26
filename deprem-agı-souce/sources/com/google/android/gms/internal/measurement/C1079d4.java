package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.d4  reason: case insensitive filesystem */
final class C1079d4 extends C1160m4 {
    C1079d4(C1106g4 g4Var, String str, Boolean bool, boolean z4) {
        super(g4Var, str, bool, true, (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (E3.f4942c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (E3.f4943d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String str2 = this.f5445b;
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder(str2.length() + 28 + obj2.length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(obj2);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
