package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.e4  reason: case insensitive filesystem */
final class C1088e4 extends C1160m4 {
    C1088e4(C1106g4 g4Var, String str, Double d5, boolean z4) {
        super(g4Var, "measurement.test.double_flag", d5, true, (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.f5445b;
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder(str.length() + 27 + obj2.length());
        sb.append("Invalid double value for ");
        sb.append(str);
        sb.append(": ");
        sb.append(obj2);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
