package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.w;
import java.nio.charset.StandardCharsets;

public final class l extends i<String> implements w.a {

    /* renamed from: b  reason: collision with root package name */
    private final k<String> f11600b;

    public l(int i5, String str, String str2, long j5, k<String> kVar) {
        super(i5, str, 0, str2, j5);
        this.f11600b = kVar;
        a((w.a) this);
    }

    private void b(w<String> wVar) {
        k<String> kVar = this.f11600b;
        if (kVar != null) {
            try {
                kVar.b(this, wVar, wVar.f11722c.f11562a);
            } catch (Exception e5) {
                af.b(i.f11593a, "parseNetworkResponse error: ", e5);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        String str = (String) obj;
    }

    /* access modifiers changed from: protected */
    public final w<String> a(r rVar) {
        w<String> a5;
        try {
            a5 = w.a(new String(rVar.f11656b, StandardCharsets.UTF_8), f.a(rVar));
            k<String> kVar = this.f11600b;
            if (kVar != null) {
                kVar.a(this, a5, rVar);
                return a5;
            }
        } catch (Exception e5) {
            af.b(i.f11593a, "parseNetworkResponse error: ", e5);
        } catch (Throwable th) {
            af.b(i.f11593a, "parseNetworkResponse error: ", th);
            w<String> a6 = w.a(new ac(th));
            b(a6);
            return a6;
        }
        return a5;
    }

    public final void a(ad adVar) {
        b(w.a(adVar));
    }
}
