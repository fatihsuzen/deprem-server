package com.mbridge.msdk.dycreator.binding;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f8626a;

    private c() {
    }

    public static c a() {
        if (f8626a == null) {
            synchronized (c.class) {
                try {
                    if (f8626a == null) {
                        f8626a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8626a;
    }
}
