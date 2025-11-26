package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.video.bt.module.MBTempContainer;

public final class e extends MBTempContainer.a.C0109a {

    /* renamed from: a  reason: collision with root package name */
    private h f12026a;

    /* renamed from: b  reason: collision with root package name */
    private c f12027b;

    public e(c cVar, h hVar) {
        this.f12026a = hVar;
        this.f12027b = cVar;
    }

    public final void a(String str) {
        super.a(str);
        h hVar = this.f12026a;
        if (hVar != null) {
            hVar.a(this.f12027b, str);
        }
    }
}
