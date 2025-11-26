package k4;

import W2.s;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends m {

    /* renamed from: h  reason: collision with root package name */
    public final List f24625h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24626i;

    /* renamed from: j  reason: collision with root package name */
    public final String f24627j;

    /* renamed from: k  reason: collision with root package name */
    public final String f24628k;

    /* renamed from: l  reason: collision with root package name */
    public final String f24629l;

    /* renamed from: m  reason: collision with root package name */
    public final String f24630m;

    /* renamed from: n  reason: collision with root package name */
    public final String f24631n;

    /* renamed from: o  reason: collision with root package name */
    public final String f24632o;

    /* renamed from: p  reason: collision with root package name */
    public final String f24633p;

    /* renamed from: q  reason: collision with root package name */
    public final String f24634q;

    /* renamed from: r  reason: collision with root package name */
    public final List f24635r;

    /* renamed from: s  reason: collision with root package name */
    public final Boolean f24636s;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ o(java.util.ArrayList r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.ArrayList r24, java.lang.Boolean r25, int r26) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x000b:
            r1 = r14
            r14 = r0 & 2
            r2 = 0
            if (r14 == 0) goto L_0x0012
            r15 = r2
        L_0x0012:
            r14 = r0 & 4
            if (r14 == 0) goto L_0x0018
            r3 = r2
            goto L_0x001a
        L_0x0018:
            r3 = r16
        L_0x001a:
            r14 = r0 & 8
            if (r14 == 0) goto L_0x0020
            r4 = r2
            goto L_0x0022
        L_0x0020:
            r4 = r17
        L_0x0022:
            r14 = r0 & 16
            if (r14 == 0) goto L_0x0028
            r5 = r2
            goto L_0x002a
        L_0x0028:
            r5 = r18
        L_0x002a:
            r14 = r0 & 32
            if (r14 == 0) goto L_0x0030
            r6 = r2
            goto L_0x0032
        L_0x0030:
            r6 = r19
        L_0x0032:
            r14 = r0 & 64
            if (r14 == 0) goto L_0x0038
            r7 = r2
            goto L_0x003a
        L_0x0038:
            r7 = r20
        L_0x003a:
            r14 = r0 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0040
            r8 = r2
            goto L_0x0042
        L_0x0040:
            r8 = r21
        L_0x0042:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x0048
            r9 = r2
            goto L_0x004a
        L_0x0048:
            r9 = r22
        L_0x004a:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0050
            r10 = r2
            goto L_0x0052
        L_0x0050:
            r10 = r23
        L_0x0052:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0058
            r11 = r2
            goto L_0x005a
        L_0x0058:
            r11 = r24
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r12 = r2
        L_0x005f:
            r0 = r13
            r2 = r15
            goto L_0x0065
        L_0x0062:
            r12 = r25
            goto L_0x005f
        L_0x0065:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.o.<init>(java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.Boolean, int):void");
    }

    public final String d() {
        ArrayList arrayList;
        JSONArray jSONArray = null;
        if (this.f24635r == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (s sVar : this.f24635r) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(((Number) sVar.c()).intValue()), sVar.d());
                arrayList.add(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        ArrayList arrayList2 = new ArrayList();
        for (C2622a d5 : this.f24625h) {
            arrayList2.add(new JSONObject(d5.d()));
        }
        jSONObject2.put("userEvents", new JSONArray(arrayList2));
        jSONObject2.putOpt("acceptanceState", this.f24626i);
        jSONObject2.putOpt("objectionState", this.f24627j);
        jSONObject2.putOpt("tcData", this.f24628k);
        jSONObject2.putOpt("gppData", this.f24629l);
        jSONObject2.putOpt(MRAIDCommunicatorUtil.KEY_STATE, this.f24630m);
        jSONObject2.putOpt("jurisdiction", this.f24631n);
        jSONObject2.putOpt("nonIabConsentData", this.f24632o);
        jSONObject2.putOpt("uspData", this.f24633p);
        jSONObject2.putOpt("gbcAcceptanceState", this.f24634q);
        if (arrayList != null) {
            jSONArray = new JSONArray(arrayList);
        }
        jSONObject2.putOpt("gbcData", jSONArray);
        jSONObject2.putOpt("paidUserIndicated", this.f24636s);
        c(jSONObject2);
        String jSONObject3 = jSONObject2.toString();
        t.d(jSONObject3, "jsonObject.toString()");
        return jSONObject3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (t.a(this.f24625h, oVar.f24625h) && t.a(this.f24626i, oVar.f24626i) && t.a(this.f24627j, oVar.f24627j) && t.a(this.f24628k, oVar.f24628k) && t.a(this.f24629l, oVar.f24629l) && t.a(this.f24630m, oVar.f24630m) && t.a(this.f24631n, oVar.f24631n) && t.a(this.f24632o, oVar.f24632o) && t.a(this.f24633p, oVar.f24633p) && t.a(this.f24634q, oVar.f24634q) && t.a(this.f24635r, oVar.f24635r) && t.a(this.f24636s, oVar.f24636s)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int hashCode = this.f24625h.hashCode() * 31;
        String str = this.f24626i;
        int i15 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i16 = (hashCode + i5) * 31;
        String str2 = this.f24627j;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i17 = (i16 + i6) * 31;
        String str3 = this.f24628k;
        if (str3 == null) {
            i7 = 0;
        } else {
            i7 = str3.hashCode();
        }
        int i18 = (i17 + i7) * 31;
        String str4 = this.f24629l;
        if (str4 == null) {
            i8 = 0;
        } else {
            i8 = str4.hashCode();
        }
        int i19 = (i18 + i8) * 31;
        String str5 = this.f24630m;
        if (str5 == null) {
            i9 = 0;
        } else {
            i9 = str5.hashCode();
        }
        int i20 = (i19 + i9) * 31;
        String str6 = this.f24631n;
        if (str6 == null) {
            i10 = 0;
        } else {
            i10 = str6.hashCode();
        }
        int i21 = (i20 + i10) * 31;
        String str7 = this.f24632o;
        if (str7 == null) {
            i11 = 0;
        } else {
            i11 = str7.hashCode();
        }
        int i22 = (i21 + i11) * 31;
        String str8 = this.f24633p;
        if (str8 == null) {
            i12 = 0;
        } else {
            i12 = str8.hashCode();
        }
        int i23 = (i22 + i12) * 31;
        String str9 = this.f24634q;
        if (str9 == null) {
            i13 = 0;
        } else {
            i13 = str9.hashCode();
        }
        int i24 = (i23 + i13) * 31;
        List list = this.f24635r;
        if (list == null) {
            i14 = 0;
        } else {
            i14 = list.hashCode();
        }
        int i25 = (i24 + i14) * 31;
        Boolean bool = this.f24636s;
        if (bool != null) {
            i15 = bool.hashCode();
        }
        return i25 + i15;
    }

    public final String toString() {
        return "TrackingUserDoneLog(userEvents=" + this.f24625h + ", acceptanceState=" + this.f24626i + ", objectionState=" + this.f24627j + ", tcData=" + this.f24628k + ", gppData=" + this.f24629l + ", state=" + this.f24630m + ", jurisdiction=" + this.f24631n + ", nonIabConsentData=" + this.f24632o + ", uspData=" + this.f24633p + ", gbcAcceptanceState=" + this.f24634q + ", gbcData=" + this.f24635r + ", paidUserIndicated=" + this.f24636s + ')';
    }

    public o(List list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list2, Boolean bool) {
        t.e(list, "userEvents");
        this.f24625h = list;
        this.f24626i = str;
        this.f24627j = str2;
        this.f24628k = str3;
        this.f24629l = str4;
        this.f24630m = str5;
        this.f24631n = str6;
        this.f24632o = str7;
        this.f24633p = str8;
        this.f24634q = str9;
        this.f24635r = list2;
        this.f24636s = bool;
    }
}
