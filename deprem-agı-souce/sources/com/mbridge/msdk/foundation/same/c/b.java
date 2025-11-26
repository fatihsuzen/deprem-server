package com.mbridge.msdk.foundation.same.c;

import android.content.Context;
import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.same.c.d;
import com.mbridge.msdk.foundation.tools.ak;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f9251a;

    private b(Context context) {
    }

    public static b a(Context context) {
        if (f9251a == null) {
            f9251a = new b(context);
        }
        return f9251a;
    }

    public final boolean b(String str) {
        if (ak.k(str)) {
            return false;
        }
        return d.a.f9260a.b(str);
    }

    public final Bitmap a(String str) {
        if (ak.k(str)) {
            return null;
        }
        return d.a.f9260a.a(str);
    }

    public final void a(String str, c cVar) {
        d.a.f9260a.a(str, (g) null, cVar);
    }
}
