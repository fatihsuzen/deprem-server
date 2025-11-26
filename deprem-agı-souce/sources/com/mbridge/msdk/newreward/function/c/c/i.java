package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class i extends c {
    public i(b bVar, a aVar) {
        super(bVar, aVar);
        b(true);
        a(false);
    }

    /* access modifiers changed from: protected */
    public final boolean a_() {
        return true;
    }

    public final int b_() {
        return 3;
    }

    public final String j() {
        if (c() == null) {
            return "";
        }
        String B4 = b().B();
        if (TextUtils.isEmpty(B4)) {
            return "";
        }
        return B4;
    }

    public final q l() {
        return new z(b(), c(), this);
    }
}
