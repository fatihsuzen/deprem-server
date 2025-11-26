package T3;

import androidx.collection.a;
import kotlin.jvm.internal.t;
import m4.g;
import m4.k;
import m4.p;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public j f19280a;

    /* renamed from: b  reason: collision with root package name */
    public c f19281b;

    /* renamed from: c  reason: collision with root package name */
    public h f19282c;

    /* renamed from: d  reason: collision with root package name */
    public g f19283d;

    /* renamed from: e  reason: collision with root package name */
    public final k f19284e;

    /* renamed from: f  reason: collision with root package name */
    public p f19285f;

    /* renamed from: g  reason: collision with root package name */
    public final l f19286g;

    /* renamed from: h  reason: collision with root package name */
    public long f19287h;

    public i(j jVar, c cVar, h hVar, g gVar, k kVar, p pVar, l lVar, long j5) {
        t.e(jVar, "premiumProperties");
        t.e(cVar, "coreConfig");
        t.e(hVar, "nonIabVendorsInfo");
        t.e(gVar, "coreUiLabels");
        t.e(kVar, "mobileUiLabels");
        t.e(pVar, "premiumUiLabels");
        this.f19280a = jVar;
        this.f19281b = cVar;
        this.f19282c = hVar;
        this.f19283d = gVar;
        this.f19284e = kVar;
        this.f19285f = pVar;
        this.f19286g = lVar;
        this.f19287h = j5;
    }

    public final c a() {
        return this.f19281b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (t.a(this.f19280a, iVar.f19280a) && t.a(this.f19281b, iVar.f19281b) && t.a(this.f19282c, iVar.f19282c) && t.a(this.f19283d, iVar.f19283d) && t.a(this.f19284e, iVar.f19284e) && t.a(this.f19285f, iVar.f19285f) && t.a(this.f19286g, iVar.f19286g) && this.f19287h == iVar.f19287h) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = this.f19281b.hashCode();
        int hashCode2 = this.f19282c.hashCode();
        int hashCode3 = this.f19283d.hashCode();
        int hashCode4 = this.f19284e.hashCode();
        int hashCode5 = (this.f19285f.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f19280a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        l lVar = this.f19286g;
        if (lVar == null) {
            i5 = 0;
        } else {
            i5 = lVar.hashCode();
        }
        return a.a(this.f19287h) + ((hashCode5 + i5) * 31);
    }

    public final String toString() {
        return "PortalConfig(premiumProperties=" + this.f19280a + ", coreConfig=" + this.f19281b + ", nonIabVendorsInfo=" + this.f19282c + ", coreUiLabels=" + this.f19283d + ", mobileUiLabels=" + this.f19284e + ", premiumUiLabels=" + this.f19285f + ", theme=" + this.f19286g + ", currentTimeStamp=" + this.f19287h + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i(T3.j r21, T3.c r22, T3.h r23, m4.g r24, m4.p r25, T3.l r26, long r27, int r29) {
        /*
            r20 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            T3.j r1 = new T3.j
            r1.<init>()
            r3 = r1
            goto L_0x000f
        L_0x000d:
            r3 = r21
        L_0x000f:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x001a
            T3.c r1 = new T3.c
            r1.<init>()
            r4 = r1
            goto L_0x001c
        L_0x001a:
            r4 = r22
        L_0x001c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0027
            T3.h r1 = new T3.h
            r1.<init>()
            r5 = r1
            goto L_0x0029
        L_0x0027:
            r5 = r23
        L_0x0029:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0034
            m4.g r1 = new m4.g
            r1.<init>()
            r6 = r1
            goto L_0x0036
        L_0x0034:
            r6 = r24
        L_0x0036:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0042
            m4.k r1 = new m4.k
            r1.<init>()
            r7 = r1
            goto L_0x0043
        L_0x0042:
            r7 = r2
        L_0x0043:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x005c
            m4.p r8 = new m4.p
            r18 = 0
            r19 = 1023(0x3ff, float:1.434E-42)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x005e
        L_0x005c:
            r8 = r25
        L_0x005e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0064
            r9 = r2
            goto L_0x0066
        L_0x0064:
            r9 = r26
        L_0x0066:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0070
            r0 = 0
            r10 = r0
        L_0x006d:
            r2 = r20
            goto L_0x0073
        L_0x0070:
            r10 = r27
            goto L_0x006d
        L_0x0073:
            r2.<init>((T3.j) r3, (T3.c) r4, (T3.h) r5, (m4.g) r6, (m4.k) r7, (m4.p) r8, (T3.l) r9, (long) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T3.i.<init>(T3.j, T3.c, T3.h, m4.g, m4.p, T3.l, long, int):void");
    }
}
