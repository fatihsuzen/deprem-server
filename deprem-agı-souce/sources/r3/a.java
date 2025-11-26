package R3;

import java.util.List;
import kotlin.jvm.internal.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f18956a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18957b;

    /* renamed from: c  reason: collision with root package name */
    public final List f18958c;

    /* renamed from: d  reason: collision with root package name */
    public List f18959d;

    public a(String str, String str2, List list, List list2) {
        this.f18956a = str;
        this.f18957b = str2;
        this.f18958c = list;
        this.f18959d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (t.a(this.f18956a, aVar.f18956a) && t.a(this.f18957b, aVar.f18957b) && t.a(this.f18958c, aVar.f18958c) && t.a(this.f18959d, aVar.f18959d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        int i7;
        String str = this.f18956a;
        int i8 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i9 = i5 * 31;
        String str2 = this.f18957b;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i10 = (i9 + i6) * 31;
        List list = this.f18958c;
        if (list == null) {
            i7 = 0;
        } else {
            i7 = list.hashCode();
        }
        int i11 = (i10 + i7) * 31;
        List list2 = this.f18959d;
        if (list2 != null) {
            i8 = list2.hashCode();
        }
        return i11 + i8;
    }

    public final String toString() {
        return "MSPAConfig(jurisdiction=" + this.f18956a + ", state=" + this.f18957b + ", purposes=" + this.f18958c + ", applicablePurposes=" + this.f18959d + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r4, java.util.ArrayList r5, int r6) {
        /*
            r3 = this;
            r0 = r6 & 1
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0007
            r4 = r1
        L_0x0007:
            r0 = r6 & 2
            r2 = 0
            if (r0 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            r0 = r6 & 4
            if (r0 == 0) goto L_0x0016
            java.util.List r5 = X2.C2250q.g()
        L_0x0016:
            r6 = r6 & 8
            if (r6 == 0) goto L_0x001e
            java.util.List r2 = X2.C2250q.g()
        L_0x001e:
            r3.<init>(r4, r1, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R3.a.<init>(java.lang.String, java.util.ArrayList, int):void");
    }
}
