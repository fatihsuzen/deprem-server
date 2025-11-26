package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.c;
import com.mbridge.msdk.tracker.network.u;

public final class e implements c {
    public final String a(u<?> uVar) {
        String k5 = uVar.k();
        int i5 = uVar.i();
        if (i5 == 0) {
            return k5;
        }
        return Integer.toString(i5) + '-' + k5;
    }
}
