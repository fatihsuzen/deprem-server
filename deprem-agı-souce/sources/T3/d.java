package T3;

import kotlin.jvm.internal.t;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f19262a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f19263b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f19264c;

    public d(Boolean bool, Boolean bool2, Boolean bool3) {
        this.f19262a = bool;
        this.f19263b = bool2;
        this.f19264c = bool3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (t.a(this.f19262a, dVar.f19262a) && t.a(this.f19263b, dVar.f19263b) && t.a(this.f19264c, dVar.f19264c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        Boolean bool = this.f19262a;
        int i7 = 0;
        if (bool == null) {
            i5 = 0;
        } else {
            i5 = bool.hashCode();
        }
        int i8 = i5 * 31;
        Boolean bool2 = this.f19263b;
        if (bool2 == null) {
            i6 = 0;
        } else {
            i6 = bool2.hashCode();
        }
        int i9 = (i8 + i6) * 31;
        Boolean bool3 = this.f19264c;
        if (bool3 != null) {
            i7 = bool3.hashCode();
        }
        return i9 + i7;
    }

    public final String toString() {
        return "Features(visitEvents=" + this.f19262a + ", advancedCustomizations=" + this.f19263b + ", consentOrPay=" + this.f19264c + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ d() {
        /*
            r1 = this;
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r1.<init>(r0, r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T3.d.<init>():void");
    }
}
