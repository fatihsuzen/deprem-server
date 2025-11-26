package M2;

import J2.v;
import android.os.Parcel;
import android.os.Parcelable;
import c.k;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

public final class b implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f18606a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18607b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18608c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18609d;

    /* renamed from: e  reason: collision with root package name */
    public final String f18610e;

    /* renamed from: f  reason: collision with root package name */
    public final String f18611f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18612g;

    /* renamed from: h  reason: collision with root package name */
    public final String f18613h;

    /* renamed from: i  reason: collision with root package name */
    public final String f18614i;

    /* renamed from: j  reason: collision with root package name */
    public final String f18615j;

    /* renamed from: k  reason: collision with root package name */
    public final String f18616k;

    /* renamed from: l  reason: collision with root package name */
    public final String f18617l;

    /* renamed from: m  reason: collision with root package name */
    public final int f18618m;

    /* renamed from: n  reason: collision with root package name */
    public final k f18619n;

    /* renamed from: o  reason: collision with root package name */
    public final String f18620o;

    /* renamed from: p  reason: collision with root package name */
    public final String f18621p;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i5, k kVar, String str13, String str14) {
        String str15 = str;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        String str21 = str8;
        String str22 = str9;
        String str23 = str10;
        String str24 = str11;
        String str25 = str12;
        k kVar2 = kVar;
        String str26 = str13;
        String str27 = str14;
        t.e(str15, RewardPlus.NAME);
        t.e(str16, "purposes");
        t.e(str17, "legitimateInterests");
        t.e(str18, "specialPurposes");
        t.e(str19, "features");
        t.e(str20, "specialFeatures");
        t.e(str21, "dataDeclarations");
        t.e(str22, "privacyPolicy");
        t.e(str23, "cookieMaxAge");
        t.e(str24, "usesNonCookieAccess");
        t.e(str25, "dataRetention");
        t.e(kVar2, "switchItemType");
        t.e(str26, "disclosuresUrl");
        t.e(str27, "disclosuresErrorLabel");
        this.f18606a = str15;
        this.f18607b = str2;
        this.f18608c = str16;
        this.f18609d = str17;
        this.f18610e = str18;
        this.f18611f = str19;
        this.f18612g = str20;
        this.f18613h = str21;
        this.f18614i = str22;
        this.f18615j = str23;
        this.f18616k = str24;
        this.f18617l = str25;
        this.f18618m = i5;
        this.f18619n = kVar2;
        this.f18620o = str26;
        this.f18621p = str27;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (t.a(this.f18606a, bVar.f18606a) && t.a(this.f18607b, bVar.f18607b) && t.a(this.f18608c, bVar.f18608c) && t.a(this.f18609d, bVar.f18609d) && t.a(this.f18610e, bVar.f18610e) && t.a(this.f18611f, bVar.f18611f) && t.a(this.f18612g, bVar.f18612g) && t.a(this.f18613h, bVar.f18613h) && t.a(this.f18614i, bVar.f18614i) && t.a(this.f18615j, bVar.f18615j) && t.a(this.f18616k, bVar.f18616k) && t.a(this.f18617l, bVar.f18617l) && this.f18618m == bVar.f18618m && this.f18619n == bVar.f18619n && t.a(this.f18620o, bVar.f18620o) && t.a(this.f18621p, bVar.f18621p)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = this.f18606a.hashCode() * 31;
        String str = this.f18607b;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int a5 = v.a(this.f18617l, v.a(this.f18616k, v.a(this.f18615j, v.a(this.f18614i, v.a(this.f18613h, v.a(this.f18612g, v.a(this.f18611f, v.a(this.f18610e, v.a(this.f18609d, v.a(this.f18608c, (hashCode + i5) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        int hashCode2 = this.f18619n.hashCode();
        return this.f18621p.hashCode() + v.a(this.f18620o, (hashCode2 + ((this.f18618m + a5) * 31)) * 31, 31);
    }

    public final String toString() {
        return "PartnersDetailDialogArgs(name=" + this.f18606a + ", description=" + this.f18607b + ", purposes=" + this.f18608c + ", legitimateInterests=" + this.f18609d + ", specialPurposes=" + this.f18610e + ", features=" + this.f18611f + ", specialFeatures=" + this.f18612g + ", dataDeclarations=" + this.f18613h + ", privacyPolicy=" + this.f18614i + ", cookieMaxAge=" + this.f18615j + ", usesNonCookieAccess=" + this.f18616k + ", dataRetention=" + this.f18617l + ", vendorId=" + this.f18618m + ", switchItemType=" + this.f18619n + ", disclosuresUrl=" + this.f18620o + ", disclosuresErrorLabel=" + this.f18621p + ')';
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f18606a);
        parcel.writeString(this.f18607b);
        parcel.writeString(this.f18608c);
        parcel.writeString(this.f18609d);
        parcel.writeString(this.f18610e);
        parcel.writeString(this.f18611f);
        parcel.writeString(this.f18612g);
        parcel.writeString(this.f18613h);
        parcel.writeString(this.f18614i);
        parcel.writeString(this.f18615j);
        parcel.writeString(this.f18616k);
        parcel.writeString(this.f18617l);
        parcel.writeInt(this.f18618m);
        parcel.writeInt(this.f18619n.f914a);
        parcel.writeString(this.f18620o);
        parcel.writeString(this.f18621p);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, c.k r31, java.lang.String r32, java.lang.String r33, int r34) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r18
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r19
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r20
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r21
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r22
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r23
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r2
            goto L_0x003c
        L_0x003a:
            r8 = r24
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r2
            goto L_0x0044
        L_0x0042:
            r9 = r25
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r2
            goto L_0x004c
        L_0x004a:
            r10 = r26
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            r11 = r2
            goto L_0x0054
        L_0x0052:
            r11 = r27
        L_0x0054:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005a
            r12 = r2
            goto L_0x005c
        L_0x005a:
            r12 = r28
        L_0x005c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0062
            r13 = r2
            goto L_0x0064
        L_0x0062:
            r13 = r29
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = 0
            goto L_0x006c
        L_0x006a:
            r14 = r30
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0073
            c.k r15 = c.k.IAB_VENDOR
            goto L_0x0075
        L_0x0073:
            r15 = r31
        L_0x0075:
            r18 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x007d
            r1 = r2
            goto L_0x007f
        L_0x007d:
            r1 = r32
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x00a9
            r34 = r2
        L_0x0088:
            r19 = r18
            r33 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r18 = r17
            goto L_0x00ac
        L_0x00a9:
            r34 = r33
            goto L_0x0088
        L_0x00ac:
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.b.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, c.k, java.lang.String, java.lang.String, int):void");
    }
}
