package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.Iterator;
import java.util.Map;

final class U5 extends Y5 {
    U5() {
        super((byte[]) null);
    }

    public final void a() {
        if (!b()) {
            if (c() <= 0) {
                Iterator it = f().iterator();
                if (it.hasNext()) {
                    a.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            } else {
                a.a(((V5) e(0)).a());
                throw null;
            }
        }
        super.a();
    }
}
