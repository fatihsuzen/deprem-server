package com.mbridge.msdk.d;

import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.d.a;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;

public class b {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static b f8230a = new b();
    }

    public static b getInstance() {
        return a.f8230a;
    }

    public void addInterstitialList(String str, String str2) {
        try {
            a.C0081a.f8229a.b(str, str2);
        } catch (Exception e5) {
            af.b("TimerController", "addInterstitialList error:" + e5.getMessage());
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            a.C0081a.f8229a.a(str, str2);
        } catch (Exception e5) {
            af.b("TimerController", "addRewardList error:" + e5.getMessage());
        }
    }

    public void start() {
        g b5 = h.a().b(c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        int o5 = b5.o();
        if (o5 > 0) {
            a.C0081a.f8229a.a((long) (o5 * 1000));
        }
    }

    private b() {
    }
}
