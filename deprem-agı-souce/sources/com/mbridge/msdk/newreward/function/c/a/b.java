package com.mbridge.msdk.newreward.function.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.e;
import com.mbridge.msdk.newreward.function.c.c.i;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.h.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class b {

    /* renamed from: A  reason: collision with root package name */
    private String f10546A;

    /* renamed from: B  reason: collision with root package name */
    private int f10547B;

    /* renamed from: C  reason: collision with root package name */
    private int f10548C;

    /* renamed from: D  reason: collision with root package name */
    private List<CampaignEx> f10549D;

    /* renamed from: E  reason: collision with root package name */
    private int f10550E;

    /* renamed from: F  reason: collision with root package name */
    private int f10551F = 0;

    /* renamed from: G  reason: collision with root package name */
    private long f10552G;

    /* renamed from: H  reason: collision with root package name */
    private Map<String, Object> f10553H;

    /* renamed from: I  reason: collision with root package name */
    private String f10554I;

    /* renamed from: J  reason: collision with root package name */
    private boolean f10555J = false;

    /* renamed from: K  reason: collision with root package name */
    private int f10556K = 0;

    /* renamed from: L  reason: collision with root package name */
    private int f10557L = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f10558a;

    /* renamed from: b  reason: collision with root package name */
    private String f10559b;

    /* renamed from: c  reason: collision with root package name */
    private String f10560c;

    /* renamed from: d  reason: collision with root package name */
    private String f10561d;

    /* renamed from: e  reason: collision with root package name */
    private String f10562e;

    /* renamed from: f  reason: collision with root package name */
    private String f10563f;

    /* renamed from: g  reason: collision with root package name */
    private String f10564g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10565h;

    /* renamed from: i  reason: collision with root package name */
    private long f10566i = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;

    /* renamed from: j  reason: collision with root package name */
    private int f10567j;

    /* renamed from: k  reason: collision with root package name */
    private String f10568k;

    /* renamed from: l  reason: collision with root package name */
    private String f10569l;

    /* renamed from: m  reason: collision with root package name */
    private String f10570m;

    /* renamed from: n  reason: collision with root package name */
    private String f10571n;

    /* renamed from: o  reason: collision with root package name */
    private int f10572o;

    /* renamed from: p  reason: collision with root package name */
    private long f10573p;

    /* renamed from: q  reason: collision with root package name */
    private long f10574q;

    /* renamed from: r  reason: collision with root package name */
    private long f10575r;

    /* renamed from: s  reason: collision with root package name */
    private double f10576s;

    /* renamed from: t  reason: collision with root package name */
    private int f10577t;

    /* renamed from: u  reason: collision with root package name */
    private List<a> f10578u;

    /* renamed from: v  reason: collision with root package name */
    private JSONObject f10579v;

    /* renamed from: w  reason: collision with root package name */
    private d<?> f10580w;

    /* renamed from: x  reason: collision with root package name */
    private int f10581x = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: y  reason: collision with root package name */
    private int f10582y = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: z  reason: collision with root package name */
    private Context f10583z;

    public b(int i5, String str, String str2, String str3) {
        this.f10558a = i5;
        this.f10559b = str;
        this.f10560c = str2;
        this.f10561d = str3;
    }

    public final boolean A() {
        if (this.f10573p > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final String B() {
        return this.f10546A;
    }

    public final int C() {
        return this.f10548C;
    }

    public final int D() {
        return this.f10547B;
    }

    public final List<CampaignEx> E() {
        return this.f10549D;
    }

    public final int F() {
        int i5 = this.f10550E;
        if (i5 <= 0) {
            return 1;
        }
        return i5;
    }

    public final int G() {
        return this.f10551F;
    }

    public final Map<String, Object> H() {
        if (this.f10553H == null) {
            this.f10553H = new HashMap();
        }
        return this.f10553H;
    }

    public final long I() {
        return this.f10552G;
    }

    public final String J() {
        return this.f10554I;
    }

    public final boolean K() {
        return this.f10555J;
    }

    public final int a() {
        return this.f10556K;
    }

    public final int b() {
        return this.f10557L;
    }

    public final int c() {
        return this.f10558a;
    }

    public final String d() {
        return this.f10560c;
    }

    public final String e() {
        return this.f10561d;
    }

    public final String f() {
        return this.f10562e;
    }

    public final String g() {
        return this.f10563f;
    }

    public final String h() {
        return this.f10564g;
    }

    public final boolean i() {
        return this.f10565h;
    }

    public final int j() {
        return this.f10567j;
    }

    public final String k() {
        return this.f10568k;
    }

    public final String l() {
        return this.f10569l;
    }

    public final String m() {
        return this.f10570m;
    }

    public final String n() {
        return this.f10571n;
    }

    public final int o() {
        return this.f10572o;
    }

    public final long p() {
        return this.f10573p;
    }

    public final long q() {
        return this.f10574q;
    }

    public final long r() {
        return this.f10575r;
    }

    public final double s() {
        return this.f10576s;
    }

    public final int t() {
        return this.f10577t;
    }

    public final List<a> u() {
        return this.f10578u;
    }

    public final JSONObject v() {
        return this.f10579v;
    }

    public final d<?> w() {
        d<?> dVar = this.f10580w;
        if (dVar != null) {
            return dVar;
        }
        String str = this.f10546A;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f10580w == null) {
            if (c.b(str)) {
                this.f10580w = new e(this, (a) null);
            } else {
                this.f10580w = new i(this, (a) null);
            }
        }
        return this.f10580w;
    }

    public final Context x() {
        return this.f10583z;
    }

    public final boolean y() {
        List<a> list;
        boolean z4;
        boolean z5;
        d<?> dVar = this.f10580w;
        if ((dVar == null || dVar.d()) && (list = this.f10578u) != null && !list.isEmpty()) {
            int size = this.f10578u.size();
            Iterator<a> it = this.f10578u.iterator();
            int i5 = 0;
            while (true) {
                boolean z6 = true;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                n d5 = next.d();
                if (d5 == null || d5.d()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                d<?> f5 = next.f();
                if (f5 == null || f5.d()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                d<?> c5 = next.c();
                if (c5 != null && !c5.d()) {
                    z6 = false;
                }
                if (z4 && z5 && z6) {
                    i5++;
                }
            }
            if (i5 == size) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ab A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean z() {
        /*
            r10 = this;
            boolean r0 = r10.A()
            boolean r1 = r10.y()
            com.mbridge.msdk.newreward.function.c.c.d<?> r2 = r10.f10580w
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0014
            boolean r2 = r2.d()
            if (r2 == 0) goto L_0x0076
        L_0x0014:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r2 = r10.f10578u
            if (r2 == 0) goto L_0x0076
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0020
            goto L_0x0076
        L_0x0020:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r2 = r10.f10578u
            int r2 = r2.size()
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f10578u
            java.util.Iterator r5 = r5.iterator()
            r6 = r4
        L_0x002d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0072
            java.lang.Object r7 = r5.next()
            com.mbridge.msdk.newreward.function.c.a.a r7 = (com.mbridge.msdk.newreward.function.c.a.a) r7
            com.mbridge.msdk.newreward.function.c.c.n r8 = r7.d()
            if (r8 == 0) goto L_0x0048
            boolean r8 = r8.e()
            if (r8 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r8 = r4
            goto L_0x0049
        L_0x0048:
            r8 = r3
        L_0x0049:
            com.mbridge.msdk.newreward.function.c.c.d r9 = r7.f()
            if (r9 == 0) goto L_0x0058
            boolean r9 = r9.e()
            if (r9 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r9 = r4
            goto L_0x0059
        L_0x0058:
            r9 = r3
        L_0x0059:
            com.mbridge.msdk.newreward.function.c.c.d r7 = r7.c()
            if (r7 == 0) goto L_0x0068
            boolean r7 = r7.e()
            if (r7 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r7 = r4
            goto L_0x0069
        L_0x0068:
            r7 = r3
        L_0x0069:
            if (r8 == 0) goto L_0x002d
            if (r9 == 0) goto L_0x002d
            if (r7 == 0) goto L_0x002d
            int r6 = r6 + 1
            goto L_0x002d
        L_0x0072:
            if (r6 != r2) goto L_0x0076
            r2 = r3
            goto L_0x0077
        L_0x0076:
            r2 = r4
        L_0x0077:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f10578u
            if (r5 == 0) goto L_0x00a8
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0082
            goto L_0x00a8
        L_0x0082:
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r5 = r10.f10578u
            int r5 = r5.size()
            java.util.List<com.mbridge.msdk.newreward.function.c.a.a> r6 = r10.f10578u
            java.util.Iterator r6 = r6.iterator()
            r7 = r4
        L_0x008f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00a4
            java.lang.Object r8 = r6.next()
            com.mbridge.msdk.newreward.function.c.a.a r8 = (com.mbridge.msdk.newreward.function.c.a.a) r8
            boolean r8 = r8.l()
            if (r8 != 0) goto L_0x008f
            int r7 = r7 + 1
            goto L_0x008f
        L_0x00a4:
            if (r7 != r5) goto L_0x00a8
            r5 = r3
            goto L_0x00a9
        L_0x00a8:
            r5 = r4
        L_0x00a9:
            if (r0 == 0) goto L_0x00b2
            if (r1 == 0) goto L_0x00b2
            if (r2 == 0) goto L_0x00b2
            if (r5 == 0) goto L_0x00b2
            return r3
        L_0x00b2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.a.b.z():boolean");
    }

    public final void a(int i5) {
        this.f10556K = i5;
    }

    public final void b(int i5) {
        this.f10557L = i5;
    }

    public final void c(String str) {
        this.f10564g = str;
    }

    public final void d(String str) {
        this.f10568k = str;
    }

    public final void e(String str) {
        this.f10569l = str;
    }

    public final void f(String str) {
        this.f10570m = str;
    }

    public final void g(String str) {
        this.f10571n = str;
    }

    public final void h(String str) {
        this.f10546A = str;
    }

    public final void i(int i5) {
        this.f10547B = i5;
    }

    public final void j(int i5) {
        this.f10550E = i5;
    }

    public final void k(int i5) {
        this.f10551F = i5;
    }

    public final void a(String str) {
        this.f10562e = str;
    }

    public final void b(String str) {
        this.f10563f = str;
    }

    public final void c(int i5) {
        this.f10567j = i5;
    }

    public final void d(int i5) {
        this.f10572o = i5;
    }

    public final void e(int i5) {
        this.f10577t = i5;
    }

    public final void f(int i5) {
        this.f10581x = i5;
    }

    public final void g(int i5) {
        this.f10582y = i5;
    }

    public final void h(int i5) {
        this.f10548C = i5;
    }

    public final void i(String str) {
        this.f10554I = str;
    }

    public final void a(boolean z4) {
        this.f10565h = z4;
    }

    public final void b(long j5) {
        this.f10573p = j5;
    }

    public final void c(long j5) {
        this.f10574q = j5;
    }

    public final void d(long j5) {
        this.f10575r = j5;
    }

    public final void e(long j5) {
        this.f10552G = j5;
    }

    public final void a(long j5) {
        this.f10566i = j5;
    }

    public final void b(List<CampaignEx> list) {
        this.f10549D = list;
    }

    public final void a(double d5) {
        this.f10576s = d5;
    }

    public final void b(boolean z4) {
        this.f10555J = z4;
    }

    public final void a(List<a> list) {
        this.f10578u = list;
    }

    public final void a(JSONObject jSONObject) {
        this.f10579v = jSONObject;
    }
}
