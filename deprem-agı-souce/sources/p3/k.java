package P3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class k extends e {

    /* renamed from: c  reason: collision with root package name */
    public final String f18887c;

    /* renamed from: d  reason: collision with root package name */
    public final Set f18888d;

    /* renamed from: e  reason: collision with root package name */
    public final Set f18889e;

    /* renamed from: f  reason: collision with root package name */
    public final Set f18890f;

    /* renamed from: g  reason: collision with root package name */
    public final Set f18891g;

    /* renamed from: h  reason: collision with root package name */
    public final Set f18892h;

    /* renamed from: i  reason: collision with root package name */
    public final Set f18893i;

    /* renamed from: j  reason: collision with root package name */
    public final String f18894j;

    /* renamed from: k  reason: collision with root package name */
    public final String f18895k;

    /* renamed from: l  reason: collision with root package name */
    public final int f18896l;

    /* renamed from: m  reason: collision with root package name */
    public final Boolean f18897m;

    /* renamed from: n  reason: collision with root package name */
    public final Set f18898n;

    /* renamed from: o  reason: collision with root package name */
    public final b f18899o;

    /* renamed from: p  reason: collision with root package name */
    public final String f18900p;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ k(int r20, java.lang.String r21, java.lang.String r22, java.util.Set r23, java.util.Set r24, java.util.Set r25, java.util.Set r26, java.util.Set r27, java.util.Set r28, java.lang.String r29, java.lang.String r30, P3.g r31, int r32, boolean r33, boolean r34, java.lang.Boolean r35, java.util.Set r36, P3.b r37, java.util.LinkedHashSet r38, java.lang.String r39, int r40) {
        /*
            r19 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0012
            r2 = r3
            goto L_0x0014
        L_0x0012:
            r2 = r21
        L_0x0014:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001b
            r4 = r5
            goto L_0x001d
        L_0x001b:
            r4 = r22
        L_0x001d:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0027
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet
            r6.<init>()
            goto L_0x0029
        L_0x0027:
            r6 = r23
        L_0x0029:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0033
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            goto L_0x0035
        L_0x0033:
            r7 = r24
        L_0x0035:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x003f
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            goto L_0x0041
        L_0x003f:
            r8 = r25
        L_0x0041:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x004b
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            goto L_0x004d
        L_0x004b:
            r9 = r26
        L_0x004d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0057
            java.util.LinkedHashSet r10 = new java.util.LinkedHashSet
            r10.<init>()
            goto L_0x0059
        L_0x0057:
            r10 = r27
        L_0x0059:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0063
            java.util.LinkedHashSet r11 = new java.util.LinkedHashSet
            r11.<init>()
            goto L_0x0065
        L_0x0063:
            r11 = r28
        L_0x0065:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x006b
            r12 = r3
            goto L_0x006d
        L_0x006b:
            r12 = r29
        L_0x006d:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0073
            r13 = r5
            goto L_0x0075
        L_0x0073:
            r13 = r30
        L_0x0075:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x007b
            r14 = -1
            goto L_0x007d
        L_0x007b:
            r14 = r32
        L_0x007d:
            r15 = 32768(0x8000, float:4.5918E-41)
            r15 = r15 & r0
            if (r15 == 0) goto L_0x0085
            r15 = r5
            goto L_0x0087
        L_0x0085:
            r15 = r35
        L_0x0087:
            r16 = 65536(0x10000, float:9.18355E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0093
            java.util.LinkedHashSet r16 = new java.util.LinkedHashSet
            r16.<init>()
            goto L_0x0095
        L_0x0093:
            r16 = r36
        L_0x0095:
            r17 = 131072(0x20000, float:1.83671E-40)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r5 = r37
        L_0x009e:
            r17 = 262144(0x40000, float:3.67342E-40)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00aa
            java.util.LinkedHashSet r17 = new java.util.LinkedHashSet
            r17.<init>()
            goto L_0x00ac
        L_0x00aa:
            r17 = r38
        L_0x00ac:
            r18 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x00d7
            r37 = r3
        L_0x00b4:
            r20 = r19
            r21 = r1
            r22 = r2
            r23 = r4
            r35 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r16
            r36 = r17
            goto L_0x00da
        L_0x00d7:
            r37 = r39
            goto L_0x00b4
        L_0x00da:
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.k.<init>(int, java.lang.String, java.lang.String, java.util.Set, java.util.Set, java.util.Set, java.util.Set, java.util.Set, java.util.Set, java.lang.String, java.lang.String, P3.g, int, boolean, boolean, java.lang.Boolean, java.util.Set, P3.b, java.util.LinkedHashSet, java.lang.String, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(int i5, String str, String str2, Set set, Set set2, Set set3, Set set4, Set set5, Set set6, String str3, String str4, int i6, Boolean bool, Set set7, b bVar, Set set8, String str5) {
        super(i5, str);
        Set set9 = set4;
        Set set10 = set5;
        Set set11 = set6;
        String str6 = str3;
        Set set12 = set7;
        String str7 = str5;
        t.e(str, RewardPlus.NAME);
        t.e(set, "purposes");
        t.e(set2, "legIntPurposes");
        t.e(set3, "flexiblePurposes");
        t.e(set9, "specialPurposes");
        t.e(set10, "features");
        t.e(set11, "specialFeatures");
        t.e(str6, "policyUrl");
        t.e(set12, "dataDeclaration");
        t.e(set8, "urls");
        t.e(str7, "deviceStorageDisclosureUrl");
        this.f18887c = str2;
        this.f18888d = set;
        this.f18889e = set2;
        this.f18890f = set3;
        this.f18891g = set9;
        this.f18892h = set10;
        this.f18893i = set11;
        this.f18894j = str6;
        this.f18895k = str4;
        this.f18896l = i6;
        this.f18897m = bool;
        this.f18898n = set12;
        this.f18899o = bVar;
        this.f18900p = str7;
    }
}
