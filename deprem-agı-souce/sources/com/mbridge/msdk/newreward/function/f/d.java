package com.mbridge.msdk.newreward.function.f;

import android.text.TextUtils;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.b.h;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.Map;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f10983a;

    /* renamed from: b  reason: collision with root package name */
    private int f10984b;

    /* renamed from: c  reason: collision with root package name */
    private String f10985c;

    /* renamed from: d  reason: collision with root package name */
    private int f10986d;

    public final void a(String str) {
        this.f10983a = str;
    }

    public final String b() {
        return this.f10983a;
    }

    public final Map<String, String> c() {
        String str;
        e eVar = new e(a());
        if (this.f10986d == h.f10614b && !TextUtils.isEmpty(this.f10983a)) {
            eVar.a("unit_ids", String.format("[%s]", new Object[]{this.f10983a}));
        }
        if (TextUtils.isEmpty(this.f10985c)) {
            str = "";
        } else {
            str = this.f10985c;
        }
        eVar.a("vtag", str);
        if (b.a()) {
            String b5 = Aa.b();
            if (!TextUtils.isEmpty(b5)) {
                eVar.a("keyword", b5);
            }
        }
        com.mbridge.msdk.c.a.d.a(c.m().c(), eVar);
        f.d(eVar);
        f.f(eVar);
        return eVar.a();
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : c().entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
        } catch (Throwable th) {
            af.b("RewardSettingReqParameters", th.getMessage());
        }
        return sb.toString();
    }

    public final void a(int i5) {
        this.f10984b = i5;
    }

    public final void b(String str) {
        this.f10985c = str;
    }

    public final void b(int i5) {
        this.f10986d = i5;
    }
}
