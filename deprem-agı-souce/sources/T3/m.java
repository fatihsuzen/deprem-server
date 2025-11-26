package T3;

import kotlin.jvm.internal.t;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final String f19298a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19299b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19300c;

    public m(String str, String str2, String str3) {
        this.f19298a = str;
        this.f19299b = str2;
        this.f19300c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (t.a(this.f19298a, mVar.f19298a) && t.a(this.f19299b, mVar.f19299b) && t.a(this.f19300c, mVar.f19300c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        String str = this.f19298a;
        int i7 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i8 = i5 * 31;
        String str2 = this.f19299b;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i9 = (i8 + i6) * 31;
        String str3 = this.f19300c;
        if (str3 != null) {
            i7 = str3.hashCode();
        }
        return i9 + i7;
    }

    public final String toString() {
        return "TranslationUrls(common=" + this.f19298a + ", theme=" + this.f19299b + ", all=" + this.f19300c + ')';
    }

    public /* synthetic */ m() {
        this("", "", "");
    }
}
