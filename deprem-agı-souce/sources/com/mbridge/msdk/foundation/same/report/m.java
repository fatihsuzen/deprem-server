package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.v;
import java.io.UnsupportedEncodingException;

public final class m extends v {
    /* access modifiers changed from: protected */
    public final w<String> a(r rVar) {
        String str;
        try {
            str = new String(rVar.f11656b, f.a(rVar.f11657c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(rVar.f11656b);
        }
        return w.a(str, f.a(rVar));
    }
}
