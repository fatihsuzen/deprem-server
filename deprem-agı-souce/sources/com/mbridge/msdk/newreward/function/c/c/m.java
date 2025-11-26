package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class m extends c {

    /* renamed from: c  reason: collision with root package name */
    private final String f10632c;

    public m(b bVar, a aVar, String str) {
        super(bVar, aVar);
        this.f10632c = str;
        b(true);
    }

    /* access modifiers changed from: protected */
    public final boolean a_() {
        return true;
    }

    public final int b_() {
        return 7;
    }

    public final String j() {
        if (TextUtils.isEmpty(this.f10632c)) {
            return "";
        }
        return this.f10632c;
    }

    public final q l() {
        return new v(b(), c(), this);
    }
}
