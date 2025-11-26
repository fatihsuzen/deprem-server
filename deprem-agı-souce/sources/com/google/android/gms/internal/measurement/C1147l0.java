package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import l0.h;

/* renamed from: com.google.android.gms.internal.measurement.l0  reason: case insensitive filesystem */
public abstract class C1147l0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal f5429a = new C1138k0();

    public static SharedPreferences a(Context context, String str, int i5, C1102g0 g0Var) {
        C1129j0 j0Var;
        C1048a0.a();
        if (str.equals("")) {
            j0Var = new C1129j0();
        } else {
            j0Var = null;
        }
        if (j0Var != null) {
            return j0Var;
        }
        ThreadLocal threadLocal = f5429a;
        h.d(((Boolean) threadLocal.get()).booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            threadLocal.set(Boolean.TRUE);
            return sharedPreferences;
        } catch (Throwable th) {
            f5429a.set(Boolean.TRUE);
            throw th;
        }
    }
}
