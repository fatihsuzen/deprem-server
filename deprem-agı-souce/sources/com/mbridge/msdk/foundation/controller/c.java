package com.mbridge.msdk.foundation.controller;

import android.annotation.SuppressLint;
import com.mbridge.msdk.foundation.controller.a;

public class c extends a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    private static volatile c f8857f;

    private c() {
    }

    public static c m() {
        if (f8857f == null) {
            synchronized (c.class) {
                try {
                    if (f8857f == null) {
                        f8857f = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8857f;
    }

    /* access modifiers changed from: protected */
    public final void a(a.C0085a aVar) {
    }
}
