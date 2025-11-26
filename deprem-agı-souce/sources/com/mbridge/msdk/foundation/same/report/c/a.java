package com.mbridge.msdk.foundation.same.report.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9442a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static a f9443b;

    private a() {
    }

    public static a a() {
        if (f9443b == null) {
            synchronized (a.class) {
                try {
                    if (f9443b == null) {
                        f9443b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9443b;
    }
}
