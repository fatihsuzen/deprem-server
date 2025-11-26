package c;

import J2.v;
import P3.e;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.t;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final e f894a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f895b;

    /* renamed from: c  reason: collision with root package name */
    public final l f896c;

    /* renamed from: d  reason: collision with root package name */
    public final k f897d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f898e;

    /* renamed from: f  reason: collision with root package name */
    public final String f899f;

    /* renamed from: g  reason: collision with root package name */
    public final Integer f900g;

    public i(e eVar, Boolean bool, l lVar, k kVar, boolean z4, String str, Integer num) {
        t.e(eVar, "value");
        t.e(lVar, "viewType");
        t.e(kVar, "itemType");
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        this.f894a = eVar;
        this.f895b = bool;
        this.f896c = lVar;
        this.f897d = kVar;
        this.f898e = z4;
        this.f899f = str;
        this.f900g = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (t.a(this.f894a, iVar.f894a) && t.a(this.f895b, iVar.f895b) && this.f896c == iVar.f896c && this.f897d == iVar.f897d && this.f898e == iVar.f898e && t.a(this.f899f, iVar.f899f) && t.a(this.f900g, iVar.f900g)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = this.f894a.hashCode() * 31;
        Boolean bool = this.f895b;
        int i6 = 0;
        if (bool == null) {
            i5 = 0;
        } else {
            i5 = bool.hashCode();
        }
        int hashCode2 = (this.f897d.hashCode() + ((this.f896c.hashCode() + ((hashCode + i5) * 31)) * 31)) * 31;
        boolean z4 = this.f898e;
        if (z4) {
            z4 = true;
        }
        int a5 = v.a(this.f899f, (hashCode2 + (z4 ? 1 : 0)) * 31, 31);
        Integer num = this.f900g;
        if (num != null) {
            i6 = num.hashCode();
        }
        return a5 + i6;
    }

    public final String toString() {
        return "SwitchItemData(value=" + this.f894a + ", selectedState=" + this.f895b + ", viewType=" + this.f896c + ", itemType=" + this.f897d + ", isTagEnabled=" + this.f898e + ", text=" + this.f899f + ", counter=" + this.f900g + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i(P3.e r9, java.lang.Boolean r10, c.l r11, c.k r12, java.lang.String r13, java.lang.Integer r14, int r15) {
        /*
            r8 = this;
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0009
            P3.e r9 = new P3.e
            r9.<init>()
        L_0x0009:
            r1 = r9
            r9 = r15 & 2
            r0 = 0
            if (r9 == 0) goto L_0x0011
            r2 = r0
            goto L_0x0012
        L_0x0011:
            r2 = r10
        L_0x0012:
            r9 = r15 & 4
            if (r9 == 0) goto L_0x0018
            c.l r11 = c.l.NORMAL
        L_0x0018:
            r3 = r11
            r9 = r15 & 8
            if (r9 == 0) goto L_0x001f
            c.k r12 = c.k.IAB_VENDOR
        L_0x001f:
            r4 = r12
            r9 = r15 & 16
            if (r9 == 0) goto L_0x0027
            r9 = 1
        L_0x0025:
            r5 = r9
            goto L_0x0029
        L_0x0027:
            r9 = 0
            goto L_0x0025
        L_0x0029:
            r9 = r15 & 32
            if (r9 == 0) goto L_0x002f
            java.lang.String r13 = ""
        L_0x002f:
            r6 = r13
            r9 = r15 & 64
            if (r9 == 0) goto L_0x0037
            r7 = r0
        L_0x0035:
            r0 = r8
            goto L_0x0039
        L_0x0037:
            r7 = r14
            goto L_0x0035
        L_0x0039:
            r0.<init>((P3.e) r1, (java.lang.Boolean) r2, (c.l) r3, (c.k) r4, (boolean) r5, (java.lang.String) r6, (java.lang.Integer) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.<init>(P3.e, java.lang.Boolean, c.l, c.k, java.lang.String, java.lang.Integer, int):void");
    }
}
