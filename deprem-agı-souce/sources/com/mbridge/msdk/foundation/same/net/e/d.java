package com.mbridge.msdk.foundation.same.net.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.t;
import com.mbridge.msdk.tracker.v;
import com.mbridge.msdk.tracker.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: A  reason: collision with root package name */
    public String f9340A;

    /* renamed from: B  reason: collision with root package name */
    public String f9341B;

    /* renamed from: C  reason: collision with root package name */
    public String f9342C;

    /* renamed from: D  reason: collision with root package name */
    public String f9343D;

    /* renamed from: E  reason: collision with root package name */
    public String f9344E;

    /* renamed from: F  reason: collision with root package name */
    public String f9345F;

    /* renamed from: G  reason: collision with root package name */
    public String f9346G;

    /* renamed from: H  reason: collision with root package name */
    public String f9347H;

    /* renamed from: I  reason: collision with root package name */
    public String f9348I;

    /* renamed from: J  reason: collision with root package name */
    public String f9349J;

    /* renamed from: K  reason: collision with root package name */
    public String f9350K;

    /* renamed from: L  reason: collision with root package name */
    public String f9351L;

    /* renamed from: M  reason: collision with root package name */
    public String f9352M;

    /* renamed from: N  reason: collision with root package name */
    public String f9353N;

    /* renamed from: O  reason: collision with root package name */
    public String f9354O;

    /* renamed from: P  reason: collision with root package name */
    private final String f9355P;

    /* renamed from: Q  reason: collision with root package name */
    private String f9356Q;

    /* renamed from: R  reason: collision with root package name */
    private String f9357R;

    /* renamed from: S  reason: collision with root package name */
    private String f9358S;

    /* renamed from: T  reason: collision with root package name */
    private String f9359T;

    /* renamed from: U  reason: collision with root package name */
    private String f9360U;

    /* renamed from: V  reason: collision with root package name */
    private String f9361V;

    /* renamed from: W  reason: collision with root package name */
    private String f9362W;

    /* renamed from: X  reason: collision with root package name */
    private String f9363X;

    /* renamed from: Y  reason: collision with root package name */
    private String f9364Y;

    /* renamed from: Z  reason: collision with root package name */
    private String f9365Z;

    /* renamed from: a  reason: collision with root package name */
    public String f9366a;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private boolean ae;
    private int af;

    /* renamed from: b  reason: collision with root package name */
    public String f9367b;

    /* renamed from: c  reason: collision with root package name */
    public String f9368c;

    /* renamed from: d  reason: collision with root package name */
    public String f9369d;

    /* renamed from: e  reason: collision with root package name */
    public String f9370e;

    /* renamed from: f  reason: collision with root package name */
    public String f9371f;

    /* renamed from: g  reason: collision with root package name */
    public String f9372g;

    /* renamed from: h  reason: collision with root package name */
    public String f9373h;

    /* renamed from: i  reason: collision with root package name */
    public String f9374i;

    /* renamed from: j  reason: collision with root package name */
    public String f9375j;

    /* renamed from: k  reason: collision with root package name */
    public String f9376k;

    /* renamed from: l  reason: collision with root package name */
    public String f9377l;

    /* renamed from: m  reason: collision with root package name */
    public int f9378m;

    /* renamed from: n  reason: collision with root package name */
    public int f9379n;

    /* renamed from: o  reason: collision with root package name */
    public int f9380o;

    /* renamed from: p  reason: collision with root package name */
    public int f9381p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f9382q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f9383r;

    /* renamed from: s  reason: collision with root package name */
    public int f9384s;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<String> f9385t;

    /* renamed from: u  reason: collision with root package name */
    public int f9386u;

    /* renamed from: v  reason: collision with root package name */
    public int f9387v;

    /* renamed from: w  reason: collision with root package name */
    public ArrayList<String> f9388w;

    /* renamed from: x  reason: collision with root package name */
    public String f9389x;

    /* renamed from: y  reason: collision with root package name */
    public String f9390y;

    /* renamed from: z  reason: collision with root package name */
    public String f9391z;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f9392a = new d();
    }

    public static d f() {
        return a.f9392a;
    }

    public final boolean a() {
        try {
            if (!this.f9383r) {
                ArrayList<String> arrayList = this.f9385t;
                if (arrayList != null && this.f9386u <= arrayList.size() - 1) {
                    this.f9373h = this.f9385t.get(this.f9386u);
                    b();
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.f9388w;
                if (arrayList2 != null && this.f9387v <= arrayList2.size() - 1) {
                    if (!b(this.f9388w.get(this.f9387v))) {
                        this.f9377l = this.f9388w.get(this.f9387v);
                        c();
                    }
                    return true;
                }
            }
            if (this.f9382q) {
                this.f9386u = 0;
                this.f9387v = 0;
            }
            return false;
        } catch (Throwable th) {
            af.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    public final void b() {
        this.f9346G = this.f9373h + this.f9364Y;
        this.f9390y = this.f9373h + this.f9358S;
        this.f9348I = this.f9373h + this.f9365Z;
        this.f9342C = this.f9373h + this.f9361V;
        this.f9350K = this.f9373h + this.aa;
    }

    public final void c() {
        this.f9347H = this.f9377l + this.f9364Y;
        this.f9391z = this.f9377l + this.f9358S;
        this.f9349J = this.f9377l + this.f9365Z;
        this.f9343D = this.f9377l + this.f9361V;
        this.f9351L = this.f9377l + this.aa;
    }

    public final int d() {
        return this.af;
    }

    public final void e() {
        boolean z4;
        HashMap<String, String> J4;
        o oVar;
        g b5 = h.a().b(c.m().k());
        if (b5 != null) {
            com.mbridge.msdk.c.a q5 = b5.q();
            if (q5 != null) {
                this.f9376k = q5.f();
                this.f9380o = q5.g();
                this.f9372g = q5.e();
                this.f9345F = this.f9372g + this.f9363X;
            }
            com.mbridge.msdk.c.d F4 = b5.F();
            if (F4 != null) {
                this.f9375j = F4.d();
                this.f9379n = F4.e();
                this.f9370e = F4.c();
                this.f9344E = this.f9370e + this.f9362W;
                com.mbridge.msdk.c.d F5 = b5.F();
                if (!(F5 == null || F5.a() == 1)) {
                    int a5 = ah.a().a("monitor", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, ah.a().a("t_r_t", 1));
                    if (!(a5 == 0 || a5 == 1)) {
                        a5 = 0;
                    }
                    w.a a6 = new w.a().a((com.mbridge.msdk.tracker.d) new com.mbridge.msdk.foundation.same.report.d()).a((v) new m());
                    if (a5 == 1) {
                        oVar = new o(new l((byte) 2), a.f9392a.f9375j, a.f9392a.f9379n);
                    } else {
                        oVar = new o(new com.mbridge.msdk.tracker.network.toolbox.h(), a.f9392a.f9344E, 0);
                    }
                    t.a().a(c.m().c(), a6.a(a5, oVar).e(ah.a().a("t_m_e_t", 604800000)).a(ah.a().a("t_m_e_s", 50)).d(ah.a().a("t_m_r_c", 50)).b(ah.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ah.a().a("t_m_r_t_s", 1)).a(), F5.b() * 1000, com.mbridge.msdk.foundation.same.report.c.a());
                }
            }
            if (b5.aq() == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f9383r = z4;
            this.f9384s = b5.aq();
            this.ae = !b5.z(2);
            if (b5.J() != null && b5.J().size() > 0 && (J4 = b5.J()) != null && J4.size() > 0) {
                if (J4.containsKey("v") && !TextUtils.isEmpty(J4.get("v")) && b(J4.get("v"))) {
                    this.f9369d = J4.get("v");
                    this.f9352M = this.f9369d + this.ab;
                    this.f9353N = this.f9369d + this.ac;
                    this.f9354O = this.f9369d + this.ad;
                    this.f9340A = this.f9369d + this.f9359T;
                }
                if (J4.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(J4.get(CampaignEx.JSON_KEY_HB)) && b(J4.get(CampaignEx.JSON_KEY_HB))) {
                    this.f9356Q = J4.get(CampaignEx.JSON_KEY_HB);
                    this.f9389x = this.f9356Q + this.f9357R;
                    this.f9341B = this.f9356Q + this.f9360U;
                }
                if (J4.containsKey("lg") && !TextUtils.isEmpty(J4.get("lg"))) {
                    String str = J4.get("lg");
                    if (b(str)) {
                        this.f9368c = str;
                    } else {
                        this.f9374i = str;
                    }
                }
                if (J4.containsKey("lgt") && !TextUtils.isEmpty(J4.get("lgt"))) {
                    String str2 = J4.get("lgt");
                    if (b(str2)) {
                        String c5 = c(str2);
                        if (!TextUtils.isEmpty(c5)) {
                            this.f9374i = c5;
                        }
                    } else {
                        this.f9374i = str2;
                    }
                }
            }
            String B4 = b5.B();
            if (!TextUtils.isEmpty(B4)) {
                this.f9373h = B4;
                b();
                this.f9385t.add(0, B4);
            }
            String C4 = b5.C();
            if (!TextUtils.isEmpty(C4)) {
                this.f9377l = C4;
                c();
                this.f9388w.add(0, C4);
            }
        }
    }

    private d() {
        this.f9355P = "RequestUrlUtil";
        this.f9366a = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.f9367b = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.f9368c = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.f9369d = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.f9370e = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.f9371f = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.f9372g = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.f9373h = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f9374i = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.f9375j = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.f9376k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.f9377l = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.f9378m = 9377;
        this.f9379n = 9377;
        this.f9380o = 9988;
        this.f9381p = 9377;
        this.f9382q = false;
        this.f9383r = false;
        this.f9384s = 1;
        this.f9385t = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.f9386u = 0;
        this.f9387v = 0;
        this.f9388w = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
        this.f9356Q = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.f9357R = "/bid";
        this.f9389x = this.f9356Q + this.f9357R;
        this.f9358S = "/sdk/customid";
        this.f9390y = this.f9373h + this.f9358S;
        this.f9391z = this.f9377l + this.f9358S;
        this.f9359T = "/image";
        this.f9340A = this.f9369d + this.f9359T;
        this.f9360U = "/load";
        this.f9341B = this.f9356Q + this.f9360U;
        this.f9361V = "/mapping";
        this.f9342C = this.f9373h + this.f9361V;
        this.f9343D = this.f9377l + this.f9361V;
        this.f9362W = "";
        this.f9344E = this.f9372g + this.f9362W;
        this.f9363X = "/batchPaidEvent";
        this.f9345F = this.f9372g + this.f9363X;
        this.f9364Y = "/setting";
        this.f9346G = this.f9373h + this.f9364Y;
        this.f9347H = this.f9377l + this.f9364Y;
        this.f9365Z = "/rewardsetting";
        this.f9348I = this.f9373h + this.f9365Z;
        this.f9349J = this.f9377l + this.f9365Z;
        this.aa = "/appwall/setting";
        this.f9350K = this.f9373h + this.aa;
        this.f9351L = this.f9377l + this.aa;
        this.ab = "/openapi/ad/v3";
        this.f9352M = this.f9369d + this.ab;
        this.ac = "/openapi/ad/v4";
        this.f9353N = this.f9369d + this.ac;
        this.ad = "/openapi/ad/v5";
        this.f9354O = this.f9369d + this.ad;
        this.ae = true;
        this.af = 0;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th) {
            af.b("RequestUrlUtil", th.getMessage());
            return "";
        }
    }

    public final String a(String str, int i5) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return a(true, split[1]);
                }
                return a(true, "");
            }
        } catch (Exception e5) {
            af.b("RequestUrlUtil", e5.getMessage());
        }
        return i5 % 2 == 0 ? this.f9354O : this.f9352M;
    }

    public final String a(boolean z4, String str) {
        if (!z4) {
            return this.f9389x.replace("{}", "");
        }
        if (!this.f9341B.contains("{}") || TextUtils.isEmpty(str)) {
            return this.f9341B.replace("{}", "");
        }
        String str2 = this.f9341B;
        return str2.replace("{}", str + "-");
    }

    public final void a(int i5) {
        this.af = i5;
    }

    public final String a(String str) {
        return a.f9392a.a(str, 1);
    }
}
