package R2;

import J2.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f18947a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18948b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18949c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18950d;

    public a(String str, String str2, String str3, String str4) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(str2, "sectionTitle");
        t.e(str3, "description");
        t.e(str4, "confirm");
        this.f18947a = str;
        this.f18948b = str2;
        this.f18949c = str3;
        this.f18950d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (t.a(this.f18947a, aVar.f18947a) && t.a(this.f18948b, aVar.f18948b) && t.a(this.f18949c, aVar.f18949c) && t.a(this.f18950d, aVar.f18950d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f18950d.hashCode() + v.a(this.f18949c, v.a(this.f18948b, this.f18947a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "Banner(title=" + this.f18947a + ", sectionTitle=" + this.f18948b + ", description=" + this.f18949c + ", confirm=" + this.f18950d + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = r7 & 1
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0007
            r5 = r1
        L_0x0007:
            r0 = r7 & 2
            r2 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r1
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            r3 = r7 & 4
            if (r3 == 0) goto L_0x0014
            r6 = r1
        L_0x0014:
            r7 = r7 & 8
            if (r7 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            r4.<init>(r5, r0, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.a.<init>(java.lang.String, java.lang.String, int):void");
    }
}
