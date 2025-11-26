package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f9116a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f9117b;

    /* renamed from: A  reason: collision with root package name */
    private String f9118A;

    /* renamed from: B  reason: collision with root package name */
    private String f9119B;

    /* renamed from: C  reason: collision with root package name */
    private String f9120C;

    /* renamed from: D  reason: collision with root package name */
    private String f9121D;

    /* renamed from: E  reason: collision with root package name */
    private int f9122E;

    /* renamed from: F  reason: collision with root package name */
    private String f9123F;

    /* renamed from: G  reason: collision with root package name */
    private String f9124G;

    /* renamed from: H  reason: collision with root package name */
    private int f9125H = 0;

    /* renamed from: I  reason: collision with root package name */
    private String f9126I;

    /* renamed from: J  reason: collision with root package name */
    private String f9127J;

    /* renamed from: K  reason: collision with root package name */
    private String f9128K;

    /* renamed from: L  reason: collision with root package name */
    private int f9129L;

    /* renamed from: M  reason: collision with root package name */
    private long f9130M;

    /* renamed from: N  reason: collision with root package name */
    private String f9131N;

    /* renamed from: O  reason: collision with root package name */
    private int f9132O;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f9133c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f9134d;

    /* renamed from: e  reason: collision with root package name */
    private int f9135e;

    /* renamed from: f  reason: collision with root package name */
    private int f9136f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f9137g;

    /* renamed from: h  reason: collision with root package name */
    private String f9138h;

    /* renamed from: i  reason: collision with root package name */
    private String f9139i;

    /* renamed from: j  reason: collision with root package name */
    private String f9140j;

    /* renamed from: k  reason: collision with root package name */
    private String f9141k;

    /* renamed from: l  reason: collision with root package name */
    private String f9142l;

    /* renamed from: m  reason: collision with root package name */
    private String f9143m;

    /* renamed from: n  reason: collision with root package name */
    private String f9144n;

    /* renamed from: o  reason: collision with root package name */
    private String f9145o;

    /* renamed from: p  reason: collision with root package name */
    private String f9146p;

    /* renamed from: q  reason: collision with root package name */
    private String f9147q;

    /* renamed from: r  reason: collision with root package name */
    private int f9148r;

    /* renamed from: s  reason: collision with root package name */
    private String f9149s;

    /* renamed from: t  reason: collision with root package name */
    private String f9150t;

    /* renamed from: u  reason: collision with root package name */
    private String f9151u;

    /* renamed from: v  reason: collision with root package name */
    private int f9152v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f9153w;

    /* renamed from: x  reason: collision with root package name */
    private String f9154x;

    /* renamed from: y  reason: collision with root package name */
    private String f9155y;

    /* renamed from: z  reason: collision with root package name */
    private String f9156z;

    public n(String str, int i5, int i6, int i7, int i8, String str2, String str3, int i9, String str4, int i10, String str5) {
        this.f9149s = str;
        this.f9153w = i5;
        this.f9154x = str5;
        this.f9148r = i6;
        this.f9132O = i7;
        this.f9129L = i8;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f9155y = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
        this.f9156z = str3;
        this.f9122E = i9;
        this.f9141k = str4;
        this.f9130M = (long) i10;
    }

    public final int A() {
        return this.f9132O;
    }

    public final int B() {
        return this.f9152v;
    }

    public final int C() {
        return this.f9137g;
    }

    public final String D() {
        return this.f9126I;
    }

    public final String E() {
        return this.f9144n;
    }

    public final int F() {
        return this.f9125H;
    }

    public final String a() {
        return this.f9149s;
    }

    public final String b() {
        return this.f9120C;
    }

    public final String c() {
        return this.f9128K;
    }

    public final String d() {
        return this.f9134d;
    }

    public final String e() {
        return this.f9138h;
    }

    public final String f() {
        return this.f9118A;
    }

    public final String g() {
        return this.f9119B;
    }

    public final String h() {
        return TextUtils.isEmpty(this.f9156z) ? "" : this.f9156z;
    }

    public final String i() {
        return this.f9139i;
    }

    public final String j() {
        return this.f9140j;
    }

    public final int k() {
        return this.f9153w;
    }

    public final String l() {
        return this.f9154x;
    }

    public final int m() {
        return this.f9122E;
    }

    public final String n() {
        return this.f9141k;
    }

    public final long o() {
        return this.f9130M;
    }

    public final int p() {
        return this.f9129L;
    }

    public final String q() {
        return this.f9131N;
    }

    public final String r() {
        return this.f9155y;
    }

    public final String s() {
        return this.f9143m;
    }

    public final String t() {
        return this.f9142l;
    }

    @NonNull
    public final String toString() {
        return "RewardReportData [key=" + this.f9149s + ", networkType=" + this.f9153w + ", isCompleteView=" + this.f9148r + ", watchedMillis=" + this.f9132O + ", videoLength=" + this.f9129L + ", offerUrl=" + this.f9155y + ", reason=" + this.f9156z + ", result=" + this.f9122E + ", duration=" + this.f9141k + ", videoSize=" + this.f9130M + "]";
    }

    public final int u() {
        return this.f9135e;
    }

    public final String v() {
        return this.f9145o;
    }

    public final String w() {
        return this.f9127J;
    }

    public final String x() {
        return this.f9150t;
    }

    public final String y() {
        return this.f9147q;
    }

    public final int z() {
        return this.f9148r;
    }

    public final void a(String str) {
        this.f9149s = str;
    }

    public final void b(String str) {
        this.f9120C = str;
    }

    public final void c(String str) {
        this.f9128K = str;
    }

    public final void d(String str) {
        this.f9134d = str;
    }

    public final void e(String str) {
        this.f9138h = str;
    }

    public final void f(String str) {
        this.f9118A = str;
    }

    public final void g(String str) {
        this.f9119B = str;
    }

    public final void h(String str) {
        this.f9156z = str;
    }

    public final void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f9139i = URLEncoder.encode(str);
        }
    }

    public final void j(String str) {
        this.f9140j = str;
    }

    public final void k(String str) {
        this.f9154x = str;
    }

    public final void l(String str) {
        this.f9141k = str;
    }

    public final void m(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f9131N = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void n(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f9143m = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void o(String str) {
        this.f9142l = str;
    }

    public final void p(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f9147q = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void q(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f9126I = URLEncoder.encode(str, "utf-8");
            }
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
    }

    public final void r(String str) {
        this.f9144n = str;
    }

    public final void s(String str) {
        this.f9151u = str;
    }

    public final void t(String str) {
        this.f9121D = str;
    }

    public final void u(String str) {
        this.f9123F = str;
    }

    public final void v(String str) {
        this.f9124G = str;
    }

    public final void a(int i5) {
        this.f9153w = i5;
    }

    public final void b(int i5) {
        this.f9122E = i5;
    }

    public final void c(int i5) {
        this.f9135e = i5;
    }

    public final void d(int i5) {
        this.f9152v = i5;
    }

    public final void e(int i5) {
        this.f9125H = i5;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.f9133c == null) {
                this.f9133c = new HashMap();
            }
            try {
                this.f9133c.put(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public final String b(String str, String str2) {
        Map<String, String> map;
        if (!TextUtils.isEmpty(str) && (map = this.f9133c) != null) {
            try {
                String str3 = map.get(str);
                return TextUtils.isEmpty(str3) ? str2 : str3;
            } catch (Exception unused) {
            }
        }
    }

    public n() {
    }

    public n(String str, int i5, String str2, String str3, String str4) {
        this.f9149s = str;
        this.f9154x = str4;
        this.f9153w = i5;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f9155y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        this.f9156z = str3;
    }

    public n(String str, int i5, int i6, String str2, int i7, String str3, int i8, String str4) {
        this.f9149s = str;
        this.f9153w = i5;
        this.f9154x = str4;
        this.f9129L = i6;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f9155y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        this.f9122E = i7;
        this.f9141k = str3;
        this.f9130M = (long) i8;
    }

    public n(Context context, CampaignEx campaignEx, int i5, String str, long j5, int i6) {
        if (i6 == 1 || i6 == 287 || i6 == 94) {
            this.f9149s = "m_download_end";
        } else if (i6 == 95) {
            this.f9149s = "2000025";
        }
        int m5 = ab.m(context);
        this.f9153w = m5;
        this.f9154x = ab.a(context, m5);
        this.f9129L = campaignEx.getVideoLength();
        this.f9118A = campaignEx.getRequestId();
        this.f9119B = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.f9155y)) {
            try {
                this.f9155y = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        this.f9122E = i5;
        this.f9141k = str;
        this.f9130M = j5 == 0 ? (long) campaignEx.getVideoSize() : j5;
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i5, String str7) {
        this.f9149s = str;
        this.f9145o = str2;
        this.f9127J = str3;
        this.f9150t = str4;
        this.f9128K = str5;
        this.f9138h = str6;
        this.f9153w = i5;
        this.f9154x = str7;
    }

    public n(String str) {
        this.f9146p = str;
    }

    public n(String str, int i5, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f9149s = str;
        this.f9122E = i5;
        this.f9141k = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f9143m = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
        this.f9138h = str4;
        this.f9128K = str5;
        this.f9156z = str6;
        this.f9142l = str7;
        if (Integer.valueOf(str2).intValue() > a.f9169L) {
            this.f9122E = 2;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, int i5) {
        this.f9149s = str;
        this.f9138h = str2;
        this.f9118A = str3;
        this.f9119B = str4;
        this.f9128K = str5;
        this.f9153w = i5;
    }

    public n(String str, String str2, String str3, String str4, String str5, int i5, int i6, String str6) {
        this.f9149s = str;
        this.f9138h = str2;
        this.f9118A = str3;
        this.f9119B = str4;
        this.f9128K = str5;
        this.f9153w = i5;
        this.f9156z = str6;
        this.f9137g = i6;
    }
}
