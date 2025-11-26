package com.mbridge.msdk.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class k extends c {
    public static k c(String str) {
        k kVar = new k();
        try {
            kVar.b(str);
            kVar.p(1);
            kVar.n(1);
            kVar.o(5);
            kVar.c(1);
            kVar.d(1);
            return kVar;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("UnitSetting", e5.getMessage());
            }
            return kVar;
        }
    }

    public static k d(String str) {
        k kVar = new k();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        kVar.p(1);
        kVar.b(str);
        kVar.a((List<Integer>) arrayList);
        kVar.b((List<Integer>) arrayList2);
        kVar.n(1);
        kVar.c(-2);
        kVar.d(-2);
        kVar.o(5);
        kVar.a(3600);
        kVar.h(2);
        kVar.a(1);
        kVar.l(100);
        kVar.e(0);
        kVar.f(1);
        kVar.i(0);
        kVar.m(60);
        kVar.j(10);
        kVar.k(60);
        return kVar;
    }

    public static k e(String str) {
        k kVar = new k();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            kVar.a((List<Integer>) arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            kVar.b((List<Integer>) arrayList2);
            kVar.b(str);
            kVar.p(1);
            kVar.n(1);
            kVar.c(-2);
            kVar.d(-2);
            kVar.o(5);
            kVar.a(3600);
            kVar.h(2);
            kVar.a(3);
            return kVar;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("UnitSetting", e5.getMessage());
            }
            return kVar;
        }
    }

    public static k f(String str) {
        k y4 = y();
        y4.a(0);
        return y4;
    }

    public static k g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c.a(new JSONObject(str));
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("UnitSetting", "parseSetting", e5);
            }
            return null;
        }
    }

    public static k y() {
        return new k();
    }
}
