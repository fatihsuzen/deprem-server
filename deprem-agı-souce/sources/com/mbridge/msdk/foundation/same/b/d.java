package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

public final class d extends b {
    public d(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    public final List<a> a() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a a5 = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        a5.a(c.MBRIDGE_700_IMG, "mb/res/img");
        a5.a(c.MBRIDGE_700_IMG_PICASSO, "mb/res/picasso");
        a5.a(c.MBRIDGE_700_RES, "mb/res/res");
        a5.a(c.MBRIDGE_700_HTML, "mb/res/html");
        a5.a(c.MBRIDGE_700_XML, "mb/res/xml");
        a5.a(c.MBRIDGE_700_CONFIG, "mb/config");
        c cVar = c.MBRIDGE_OTHER;
        a(arrayList, cVar, "mb/other");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, cVar, "mb/other");
        return arrayList;
    }
}
