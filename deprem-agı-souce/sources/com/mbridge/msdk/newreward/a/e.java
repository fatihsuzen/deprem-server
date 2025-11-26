package com.mbridge.msdk.newreward.a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.e.a;
import com.mbridge.msdk.newreward.function.e.c;
import com.mbridge.msdk.newreward.function.e.d;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import org.json.JSONArray;
import u1.b;

public final class e {

    /* renamed from: A  reason: collision with root package name */
    private String f10432A;

    /* renamed from: B  reason: collision with root package name */
    private String f10433B;

    /* renamed from: C  reason: collision with root package name */
    private String f10434C = "";

    /* renamed from: D  reason: collision with root package name */
    private int f10435D;

    /* renamed from: E  reason: collision with root package name */
    private long f10436E;

    /* renamed from: F  reason: collision with root package name */
    private boolean f10437F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f10438G = false;

    /* renamed from: H  reason: collision with root package name */
    private boolean f10439H = false;

    /* renamed from: I  reason: collision with root package name */
    private a f10440I = new a();

    /* renamed from: J  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.e.e f10441J = new com.mbridge.msdk.newreward.function.e.e();

    /* renamed from: K  reason: collision with root package name */
    private f f10442K = new f();

    /* renamed from: L  reason: collision with root package name */
    private c f10443L = new c();

    /* renamed from: M  reason: collision with root package name */
    private d f10444M = new d();

    /* renamed from: N  reason: collision with root package name */
    private int f10445N = 25000;

    /* renamed from: O  reason: collision with root package name */
    private MBridgeIds f10446O;

    /* renamed from: P  reason: collision with root package name */
    private f f10447P;

    /* renamed from: Q  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.g.c f10448Q;

    /* renamed from: R  reason: collision with root package name */
    private boolean f10449R = false;

    /* renamed from: S  reason: collision with root package name */
    private boolean f10450S = false;

    /* renamed from: T  reason: collision with root package name */
    private boolean f10451T = false;

    /* renamed from: U  reason: collision with root package name */
    private boolean f10452U = false;

    /* renamed from: V  reason: collision with root package name */
    private boolean f10453V = false;

    /* renamed from: W  reason: collision with root package name */
    private boolean f10454W = false;

    /* renamed from: X  reason: collision with root package name */
    private boolean f10455X = false;

    /* renamed from: Y  reason: collision with root package name */
    private boolean f10456Y = false;

    /* renamed from: Z  reason: collision with root package name */
    private b f10457Z;

    /* renamed from: a  reason: collision with root package name */
    public b f10458a;
    private u1.a aa;
    private v1.b ab;
    private boolean ac;
    private int ad = 0;
    private JSONArray ae = new JSONArray();
    private HandlerThread af;
    private RewardVideoListener ag;

    /* renamed from: b  reason: collision with root package name */
    int f10459b;

    /* renamed from: c  reason: collision with root package name */
    private String f10460c;

    /* renamed from: d  reason: collision with root package name */
    private CampaignEx f10461d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10462e;

    /* renamed from: f  reason: collision with root package name */
    private int f10463f;

    /* renamed from: g  reason: collision with root package name */
    private int f10464g;

    /* renamed from: h  reason: collision with root package name */
    private int f10465h;

    /* renamed from: i  reason: collision with root package name */
    private int f10466i;

    /* renamed from: j  reason: collision with root package name */
    private int f10467j = com.mbridge.msdk.foundation.same.a.f9163F;

    /* renamed from: k  reason: collision with root package name */
    private int f10468k = 2;

    /* renamed from: l  reason: collision with root package name */
    private int f10469l = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10470m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10471n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10472o = false;

    /* renamed from: p  reason: collision with root package name */
    private long f10473p;

    /* renamed from: q  reason: collision with root package name */
    private long f10474q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10475r = false;

    /* renamed from: s  reason: collision with root package name */
    private int f10476s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f10477t = 0;

    /* renamed from: u  reason: collision with root package name */
    private String f10478u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10479v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10480w = false;

    /* renamed from: x  reason: collision with root package name */
    private String f10481x;

    /* renamed from: y  reason: collision with root package name */
    private String f10482y;

    /* renamed from: z  reason: collision with root package name */
    private int f10483z;

    public e(boolean z4, int i5, String str, String str2, boolean z5) {
        this.f10462e = z4;
        this.f10483z = i5;
        this.f10481x = str;
        this.f10482y = str2;
        this.f10471n = z5;
    }

    public final int A() {
        return this.f10459b;
    }

    public final String B() {
        return this.f10432A;
    }

    public final String C() {
        return this.f10433B;
    }

    public final a D() {
        return this.f10440I;
    }

    public final d E() {
        return this.f10444M;
    }

    public final com.mbridge.msdk.newreward.function.e.e F() {
        return this.f10441J;
    }

    public final String G() {
        return this.f10460c;
    }

    public final String H() {
        return this.f10482y;
    }

    public final boolean I() {
        return this.f10462e;
    }

    public final String J() {
        return this.f10481x;
    }

    public final RewardVideoListener K() {
        return this.ag;
    }

    public final int L() {
        return this.f10464g;
    }

    public final int M() {
        if (this.f10462e) {
            return 2;
        }
        return 3;
    }

    public final int N() {
        return this.f10463f;
    }

    public final int O() {
        return this.f10468k;
    }

    public final int P() {
        int i5 = this.f10445N;
        if (i5 <= 0) {
            return 25000;
        }
        return i5;
    }

    public final int Q() {
        return this.f10469l;
    }

    public final boolean R() {
        return this.f10471n;
    }

    public final MBridgeIds S() {
        return this.f10446O;
    }

    public final long T() {
        long j5;
        a aVar = this.f10440I;
        if (aVar != null && aVar.b() != null && this.f10440I.b().p() > 0) {
            return this.f10440I.b().p();
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.mbridge.msdk.videocommon.d.a a5 = this.f10442K.a();
        if (a5 == null) {
            j5 = 3600000;
        } else {
            j5 = a5.f();
        }
        return j5 + currentTimeMillis;
    }

    public final CampaignEx U() {
        return this.f10461d;
    }

    public final String V() {
        CampaignEx campaignEx = this.f10461d;
        if (campaignEx == null) {
            return "";
        }
        return campaignEx.getRequestIdNotice();
    }

    public final f W() {
        return this.f10447P;
    }

    public final boolean X() {
        return this.f10449R;
    }

    public final boolean Y() {
        return this.f10450S;
    }

    public final boolean Z() {
        return this.f10452U;
    }

    public final HandlerThread a() {
        return this.af;
    }

    public final boolean aa() {
        return this.f10453V;
    }

    public final boolean ab() {
        return this.f10454W;
    }

    public final boolean ac() {
        return this.f10455X;
    }

    public final b ad() {
        return this.f10457Z;
    }

    public final u1.a ae() {
        return this.aa;
    }

    public final v1.b af() {
        return this.ab;
    }

    public final boolean ag() {
        return this.f10456Y;
    }

    public final boolean ah() {
        return this.f10451T;
    }

    public final String ai() {
        CampaignEx campaignEx = this.f10461d;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return "904";
        }
        String e5 = this.f10461d.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(e5)) {
            return "904";
        }
        if (this.f10461d.getAdSpaceT() == 2) {
            return "HALF_TEMPLATE";
        }
        boolean b5 = com.mbridge.msdk.newreward.function.h.c.b(e5);
        String valueOf = String.valueOf(this.f10461d.getRewardTemplateMode().f());
        if (!b5 && this.ac) {
            return "WEB_TEMPLATE";
        }
        return valueOf;
    }

    public final String aj() {
        boolean z4;
        CampaignEx campaignEx = this.f10461d;
        if (campaignEx == null) {
            return "404";
        }
        boolean b5 = com.mbridge.msdk.newreward.function.h.c.b(campaignEx.getendcard_url());
        if (this.f10461d.isMraid() || !b5) {
            z4 = true;
        } else {
            z4 = false;
        }
        long ecTemplateId = this.f10461d.getEcTemplateId();
        if (ecTemplateId == 0) {
            ecTemplateId = 404;
        }
        if (!z4) {
            return String.valueOf(ecTemplateId);
        }
        if (this.ac) {
            return "WEB_EC";
        }
        return String.valueOf(ecTemplateId);
    }

    public final boolean ak() {
        CampaignEx campaignEx = this.f10461d;
        if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
            return true;
        }
        return false;
    }

    public final String al() {
        boolean z4;
        CampaignEx campaignEx = this.f10461d;
        if (campaignEx == null) {
            return "ONLY_PLAYABLE";
        }
        boolean z5 = false;
        if (campaignEx.getPlayable_ads_without_video() == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f10461d.getAdSpaceT() == 2) {
            z5 = true;
        }
        if (z4 && z5) {
            return "HALF_END_CARD";
        }
        if (this.ac) {
            return "ONLY_PLAYABLE";
        }
        return "404";
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int am() {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.newreward.function.e.a r1 = r5.f10440I     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0037
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0037
            com.mbridge.msdk.newreward.function.e.a r1 = r5.f10440I     // Catch:{ Exception -> 0x0034 }
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0034 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0034 }
            if (r1 != 0) goto L_0x0037
            com.mbridge.msdk.newreward.function.e.a r1 = r5.f10440I     // Catch:{ Exception -> 0x0034 }
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0037
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r1.getRewardTemplateMode()     // Catch:{ Exception -> 0x0034 }
            if (r2 == 0) goto L_0x0037
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r1.getRewardTemplateMode()     // Catch:{ Exception -> 0x0034 }
            int r1 = r1.b()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r1 = move-exception
            r2 = r0
            goto L_0x0053
        L_0x0037:
            r1 = r0
        L_0x0038:
            if (r1 != 0) goto L_0x005b
            com.mbridge.msdk.newreward.function.e.f r2 = r5.f10442K     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x005b
            com.mbridge.msdk.videocommon.d.c r2 = r2.b()     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x005b
            com.mbridge.msdk.newreward.function.e.f r2 = r5.f10442K     // Catch:{ Exception -> 0x004f }
            com.mbridge.msdk.videocommon.d.c r2 = r2.b()     // Catch:{ Exception -> 0x004f }
            int r1 = r2.c()     // Catch:{ Exception -> 0x004f }
            goto L_0x005b
        L_0x004f:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0053:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x005a
            r1.printStackTrace()
        L_0x005a:
            r1 = r2
        L_0x005b:
            r2 = 1
            if (r1 == r2) goto L_0x0063
            r2 = 2
            if (r1 == r2) goto L_0x0064
            r0 = -1
            goto L_0x0064
        L_0x0063:
            r0 = r2
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.e.am():int");
    }

    public final String b() {
        JSONArray jSONArray = this.ae;
        if (jSONArray == null) {
            return "";
        }
        return jSONArray.toString();
    }

    public final com.mbridge.msdk.newreward.function.g.c c() {
        return this.f10448Q;
    }

    public final boolean d() {
        return this.f10439H;
    }

    public final boolean e() {
        return this.f10438G;
    }

    public final boolean f() {
        return this.f10437F;
    }

    public final long g() {
        return this.f10436E;
    }

    public final int h() {
        return this.f10483z;
    }

    public final String i() {
        return this.f10434C;
    }

    public final boolean j() {
        return this.f10479v;
    }

    public final String k() {
        return this.f10478u;
    }

    public final void l() {
        this.f10476s++;
    }

    public final void m() {
        this.f10477t++;
    }

    public final boolean n() {
        return this.f10475r;
    }

    public final long o() {
        return this.f10474q;
    }

    public final long p() {
        return this.f10473p;
    }

    public final boolean q() {
        return this.f10472o;
    }

    public final boolean r() {
        return this.f10470m;
    }

    public final boolean s() {
        return this.f10480w;
    }

    public final int t() {
        return this.f10464g;
    }

    public final int u() {
        return this.f10465h;
    }

    public final int v() {
        return this.f10466i;
    }

    public final int w() {
        return this.f10467j;
    }

    public final f x() {
        return this.f10442K;
    }

    public final int y() {
        return this.f10435D;
    }

    public final c z() {
        return this.f10443L;
    }

    public final void a(HandlerThread handlerThread) {
        this.af = handlerThread;
    }

    public final void c(boolean z4) {
        this.f10437F = z4;
    }

    public final void d(boolean z4) {
        this.f10479v = z4;
    }

    public final void e(boolean z4) {
        this.f10475r = z4;
    }

    public final void f(boolean z4) {
        this.f10472o = z4;
    }

    public final void g(boolean z4) {
        this.f10470m = z4;
    }

    public final void h(boolean z4) {
        this.f10480w = z4;
    }

    public final void i(boolean z4) {
        this.f10449R = z4;
    }

    public final void j(boolean z4) {
        this.f10450S = z4;
    }

    public final void k(boolean z4) {
        this.f10452U = z4;
    }

    public final void l(boolean z4) {
        this.f10453V = z4;
    }

    public final void m(boolean z4) {
        this.f10454W = z4;
    }

    public final void n(boolean z4) {
        this.f10455X = z4;
    }

    public final void o(boolean z4) {
        this.f10456Y = z4;
    }

    public final void p(boolean z4) {
        this.ac = z4;
    }

    public final void q(boolean z4) {
        this.f10451T = z4;
    }

    public final void a(String str) {
        if (this.ae == null) {
            this.ae = new JSONArray();
        }
        this.ae.put(str);
    }

    public final void c(String str) {
        this.f10478u = str;
    }

    public final void d(int i5) {
        this.f10459b = i5;
    }

    public final void e(String str) {
        this.f10433B = str;
    }

    public final void f(String str) {
        this.f10460c = str;
    }

    public final void g(int i5) {
        this.f10469l = i5;
    }

    public final void b(boolean z4) {
        this.f10438G = z4;
    }

    public final void c(long j5) {
        this.f10473p = j5;
    }

    public final void d(String str) {
        this.f10432A = str;
    }

    public final void e(int i5) {
        this.f10468k = i5;
    }

    public final void f(int i5) {
        this.f10445N = i5;
    }

    public final File g(String str) {
        for (com.mbridge.msdk.newreward.function.c.a.a next : this.f10440I.b().u()) {
            if (next.g().equals(str)) {
                return next.d().g();
            }
        }
        return null;
    }

    public final void b(String str) {
        this.f10434C = str;
    }

    public final void c(int i5) {
        this.f10435D = i5;
    }

    public final void a(com.mbridge.msdk.newreward.function.g.c cVar) {
        this.f10448Q = cVar;
    }

    public final void b(long j5) {
        this.f10474q = j5;
    }

    public final void a(boolean z4) {
        this.f10439H = z4;
    }

    public final void b(int i5) {
        this.f10467j = i5;
    }

    public final void a(long j5) {
        this.f10436E = j5;
    }

    public final void a(int i5) {
        this.f10463f = i5;
    }

    public final void a(f fVar) {
        this.f10442K = fVar;
    }

    public final void a(a aVar) {
        this.f10440I = aVar;
    }

    public final void a(RewardVideoListener rewardVideoListener) {
        this.ag = rewardVideoListener;
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.f10446O = mBridgeIds;
    }

    public final void a(f fVar) {
        this.f10447P = fVar;
    }

    public final void a(CampaignEx campaignEx) {
        this.f10461d = campaignEx;
    }

    public final void a(b bVar) {
        this.f10457Z = bVar;
    }

    public final void a(u1.a aVar) {
        this.aa = aVar;
    }

    public final void a(v1.b bVar) {
        this.ab = bVar;
    }

    public final void a(int i5, int i6, int i7) {
        this.f10464g = i5;
        this.f10465h = i6;
        this.f10466i = i7;
    }
}
