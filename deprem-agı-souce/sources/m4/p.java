package m4;

import J2.v;
import R3.m;
import java.util.List;
import kotlin.jvm.internal.t;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final String f25475a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25476b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25477c;

    /* renamed from: d  reason: collision with root package name */
    public final List f25478d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25479e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25480f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25481g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25482h;

    /* renamed from: i  reason: collision with root package name */
    public final String f25483i;

    /* renamed from: j  reason: collision with root package name */
    public final List f25484j;

    public p(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, List list2) {
        t.e(str, "linksTitle");
        t.e(str2, "nonIabVendorsLabel");
        t.e(str3, "uspDnsTitle");
        t.e(list, "uspDnsText");
        t.e(str4, "uspDoNotSellToggleText");
        t.e(str5, "uspPrivacyPolicyLinkText");
        t.e(str6, "uspDeleteDataLinkText");
        t.e(str7, "uspAccessDataLinkText");
        t.e(str8, "uspAcceptButton");
        t.e(list2, "initScreenCustomLinks");
        this.f25475a = str;
        this.f25476b = str2;
        this.f25477c = str3;
        this.f25478d = list;
        this.f25479e = str4;
        this.f25480f = str5;
        this.f25481g = str6;
        this.f25482h = str7;
        this.f25483i = str8;
        this.f25484j = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (t.a(this.f25475a, pVar.f25475a) && t.a(this.f25476b, pVar.f25476b) && t.a(this.f25477c, pVar.f25477c) && t.a(this.f25478d, pVar.f25478d) && t.a(this.f25479e, pVar.f25479e) && t.a(this.f25480f, pVar.f25480f) && t.a(this.f25481g, pVar.f25481g) && t.a(this.f25482h, pVar.f25482h) && t.a(this.f25483i, pVar.f25483i) && t.a(this.f25484j, pVar.f25484j)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25484j.hashCode() + v.a(this.f25483i, v.a(this.f25482h, v.a(this.f25481g, v.a(this.f25480f, v.a(this.f25479e, m.a(this.f25478d, v.a(this.f25477c, v.a(this.f25476b, this.f25475a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "PremiumUiLabels(linksTitle=" + this.f25475a + ", nonIabVendorsLabel=" + this.f25476b + ", uspDnsTitle=" + this.f25477c + ", uspDnsText=" + this.f25478d + ", uspDoNotSellToggleText=" + this.f25479e + ", uspPrivacyPolicyLinkText=" + this.f25480f + ", uspDeleteDataLinkText=" + this.f25481g + ", uspAccessDataLinkText=" + this.f25482h + ", uspAcceptButton=" + this.f25483i + ", initScreenCustomLinks=" + this.f25484j + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ p(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.ArrayList r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.util.ArrayList r12, int r13) {
        /*
            r2 = this;
            r0 = r13 & 1
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0007
            r3 = r1
        L_0x0007:
            r0 = r13 & 2
            if (r0 == 0) goto L_0x000c
            r4 = r1
        L_0x000c:
            r0 = r13 & 4
            if (r0 == 0) goto L_0x0011
            r5 = r1
        L_0x0011:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0019
            java.util.List r6 = X2.C2250q.g()
        L_0x0019:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x001e
            r7 = r1
        L_0x001e:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x0023
            r8 = r1
        L_0x0023:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0028
            r9 = r1
        L_0x0028:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002d
            r10 = r1
        L_0x002d:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0032
            r11 = r1
        L_0x0032:
            r13 = r13 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x003b
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x003b:
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.p.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, int):void");
    }
}
