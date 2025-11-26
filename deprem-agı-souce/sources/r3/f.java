package R3;

import R2.a;
import java.util.List;
import kotlin.jvm.internal.t;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f18985a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f18986b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f18987c;

    /* renamed from: d  reason: collision with root package name */
    public final a f18988d;

    /* renamed from: e  reason: collision with root package name */
    public final List f18989e;

    /* renamed from: f  reason: collision with root package name */
    public List f18990f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f18991g;

    public f(Integer num, String str, Boolean bool, Boolean bool2, a aVar, List list, List list2, boolean z4) {
        this.f18985a = num;
        this.f18986b = bool;
        this.f18987c = bool2;
        this.f18988d = aVar;
        this.f18989e = list;
        this.f18990f = list2;
        this.f18991g = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (t.a(this.f18985a, fVar.f18985a) && t.a("", "") && t.a(this.f18986b, fVar.f18986b) && t.a(this.f18987c, fVar.f18987c) && t.a(this.f18988d, fVar.f18988d) && t.a(this.f18989e, fVar.f18989e) && t.a(this.f18990f, fVar.f18990f) && this.f18991g == fVar.f18991g) {
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
        Integer num = this.f18985a;
        int i10 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int i11 = i5 * 961;
        Boolean bool = this.f18986b;
        if (bool == null) {
            i6 = 0;
        } else {
            i6 = bool.hashCode();
        }
        int i12 = (i11 + i6) * 31;
        Boolean bool2 = this.f18987c;
        if (bool2 == null) {
            i7 = 0;
        } else {
            i7 = bool2.hashCode();
        }
        int i13 = (i12 + i7) * 31;
        a aVar = this.f18988d;
        if (aVar == null) {
            i8 = 0;
        } else {
            i8 = aVar.hashCode();
        }
        int i14 = (i13 + i8) * 31;
        List list = this.f18989e;
        if (list == null) {
            i9 = 0;
        } else {
            i9 = list.hashCode();
        }
        int i15 = (i14 + i9) * 31;
        List list2 = this.f18990f;
        if (list2 != null) {
            i10 = list2.hashCode();
        }
        int i16 = (i15 + i10) * 31;
        boolean z4 = this.f18991g;
        if (z4) {
            z4 = true;
        }
        return i16 + (z4 ? 1 : 0);
    }

    public final String toString() {
        return "MSPAPurpose(id=" + this.f18985a + ", category=, defaultValue=" + this.f18986b + ", value=" + this.f18987c + ", consentBanner=" + this.f18988d + ", purposes=" + this.f18989e + ", applicableSensitivePurposes=" + this.f18990f + ", noticeOnly=" + this.f18991g + ')';
    }
}
