package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.Collections;
import java.util.Map;

public final class R4 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile R4 f5162b;

    /* renamed from: c  reason: collision with root package name */
    static final R4 f5163c = new R4(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map f5164a = Collections.EMPTY_MAP;

    R4(boolean z4) {
    }

    public static R4 a() {
        R4 r42 = f5162b;
        if (r42 != null) {
            return r42;
        }
        synchronized (R4.class) {
            try {
                R4 r43 = f5162b;
                if (r43 != null) {
                    return r43;
                }
                int i5 = N5.f5036d;
                R4 a5 = Z4.a(R4.class);
                f5162b = a5;
                return a5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C1080d5 b(F5 f5, int i5) {
        a.a(this.f5164a.get(new Q4(f5, i5)));
        return null;
    }
}
