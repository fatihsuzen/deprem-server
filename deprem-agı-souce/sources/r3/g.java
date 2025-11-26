package R3;

import java.util.List;
import kotlin.jvm.internal.t;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f18992a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f18993b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18994c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f18995d;

    /* renamed from: e  reason: collision with root package name */
    public final String f18996e;

    /* renamed from: f  reason: collision with root package name */
    public final List f18997f;

    public g(Integer num, Integer num2, String str, Boolean bool, String str2, List list) {
        this.f18992a = num;
        this.f18993b = num2;
        this.f18994c = str;
        this.f18995d = bool;
        this.f18996e = str2;
        this.f18997f = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (t.a(this.f18992a, gVar.f18992a) && t.a(this.f18993b, gVar.f18993b) && t.a(this.f18994c, gVar.f18994c) && t.a(this.f18995d, gVar.f18995d) && t.a(this.f18996e, gVar.f18996e) && t.a(this.f18997f, gVar.f18997f)) {
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
        Integer num = this.f18992a;
        int i10 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int i11 = i5 * 31;
        Integer num2 = this.f18993b;
        if (num2 == null) {
            i6 = 0;
        } else {
            i6 = num2.hashCode();
        }
        int i12 = (i11 + i6) * 31;
        String str = this.f18994c;
        if (str == null) {
            i7 = 0;
        } else {
            i7 = str.hashCode();
        }
        int i13 = (i12 + i7) * 31;
        Boolean bool = this.f18995d;
        if (bool == null) {
            i8 = 0;
        } else {
            i8 = bool.hashCode();
        }
        int i14 = (i13 + i8) * 31;
        String str2 = this.f18996e;
        if (str2 == null) {
            i9 = 0;
        } else {
            i9 = str2.hashCode();
        }
        int i15 = (i14 + i9) * 31;
        List list = this.f18997f;
        if (list != null) {
            i10 = list.hashCode();
        }
        return i15 + i10;
    }

    public final String toString() {
        return "MSPASensitivePurpose(id=" + this.f18992a + ", order=" + this.f18993b + ", title=" + this.f18994c + ", value=" + this.f18995d + ", description=" + this.f18996e + ", nationalIds=" + this.f18997f + ')';
    }
}
