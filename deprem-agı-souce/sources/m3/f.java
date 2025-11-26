package M3;

import kotlin.jvm.internal.t;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18675a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18676b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18677c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18678d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18679e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f18680f;

    /* renamed from: g  reason: collision with root package name */
    private final String f18681g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f18682h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f18683i;

    /* renamed from: j  reason: collision with root package name */
    private final String f18684j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f18685k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f18686l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f18687m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f18688n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f18689o;

    /* renamed from: p  reason: collision with root package name */
    private C2127a f18690p;

    public f(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str, boolean z10, boolean z11, String str2, boolean z12, boolean z13, v vVar, boolean z14, boolean z15, boolean z16, C2127a aVar) {
        C2127a aVar2 = aVar;
        t.e(str, "prettyPrintIndent");
        t.e(str2, "classDiscriminator");
        t.e(aVar2, "classDiscriminatorMode");
        this.f18675a = z4;
        this.f18676b = z5;
        this.f18677c = z6;
        this.f18678d = z7;
        this.f18679e = z8;
        this.f18680f = z9;
        this.f18681g = str;
        this.f18682h = z10;
        this.f18683i = z11;
        this.f18684j = str2;
        this.f18685k = z12;
        this.f18686l = z13;
        this.f18687m = z14;
        this.f18688n = z15;
        this.f18689o = z16;
        this.f18690p = aVar2;
    }

    public final boolean a() {
        return this.f18689o;
    }

    public final boolean b() {
        return this.f18685k;
    }

    public final boolean c() {
        return this.f18678d;
    }

    public final boolean d() {
        return this.f18688n;
    }

    public final String e() {
        return this.f18684j;
    }

    public final C2127a f() {
        return this.f18690p;
    }

    public final boolean g() {
        return this.f18682h;
    }

    public final boolean h() {
        return this.f18687m;
    }

    public final boolean i() {
        return this.f18675a;
    }

    public final boolean j() {
        return this.f18680f;
    }

    public final boolean k() {
        return this.f18676b;
    }

    public final v l() {
        return null;
    }

    public final boolean m() {
        return this.f18679e;
    }

    public final String n() {
        return this.f18681g;
    }

    public final boolean o() {
        return this.f18686l;
    }

    public final boolean p() {
        return this.f18683i;
    }

    public final boolean q() {
        return this.f18677c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f18675a + ", ignoreUnknownKeys=" + this.f18676b + ", isLenient=" + this.f18677c + ", allowStructuredMapKeys=" + this.f18678d + ", prettyPrint=" + this.f18679e + ", explicitNulls=" + this.f18680f + ", prettyPrintIndent='" + this.f18681g + "', coerceInputValues=" + this.f18682h + ", useArrayPolymorphism=" + this.f18683i + ", classDiscriminator='" + this.f18684j + "', allowSpecialFloatingPointValues=" + this.f18685k + ", useAlternativeNames=" + this.f18686l + ", namingStrategy=" + null + ", decodeEnumsCaseInsensitive=" + this.f18687m + ", allowTrailingComma=" + this.f18688n + ", allowComments=" + this.f18689o + ", classDiscriminatorMode=" + this.f18690p + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, java.lang.String r25, boolean r26, boolean r27, java.lang.String r28, boolean r29, boolean r30, M3.v r31, boolean r32, boolean r33, boolean r34, M3.C2127a r35, int r36, kotlin.jvm.internal.C2633k r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            r8 = 1
            if (r7 == 0) goto L_0x0031
            r7 = r8
            goto L_0x0033
        L_0x0031:
            r7 = r24
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            java.lang.String r9 = "    "
            goto L_0x003c
        L_0x003a:
            r9 = r25
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r26
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r27
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0053
            java.lang.String r12 = "type"
            goto L_0x0055
        L_0x0053:
            r12 = r28
        L_0x0055:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005b
            r13 = 0
            goto L_0x005d
        L_0x005b:
            r13 = r29
        L_0x005d:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r8 = r30
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = 0
            goto L_0x006c
        L_0x006a:
            r14 = r31
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0072
            r15 = 0
            goto L_0x0074
        L_0x0072:
            r15 = r32
        L_0x0074:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007a
            r2 = 0
            goto L_0x007c
        L_0x007a:
            r2 = r33
        L_0x007c:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0086
            r16 = 0
            goto L_0x0088
        L_0x0086:
            r16 = r34
        L_0x0088:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00b5
            M3.a r0 = M3.C2127a.POLYMORPHIC
            r36 = r0
        L_0x0092:
            r19 = r18
            r20 = r1
            r34 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r31 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r32 = r14
            r33 = r15
            r35 = r16
            goto L_0x00b8
        L_0x00b5:
            r36 = r35
            goto L_0x0092
        L_0x00b8:
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M3.f.<init>(boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, boolean, java.lang.String, boolean, boolean, M3.v, boolean, boolean, boolean, M3.a, int, kotlin.jvm.internal.k):void");
    }
}
