package com.google.android.gms.internal.measurement;

import android.os.Binder;

public abstract /* synthetic */ class T3 {
    public static Object a(S3 s32) {
        long clearCallingIdentity;
        try {
            return s32.A();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            Object A4 = s32.A();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return A4;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
