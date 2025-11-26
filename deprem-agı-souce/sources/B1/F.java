package b1;

import androidx.privacysandbox.ads.adservices.adid.a;
import kotlin.jvm.internal.t;

public final class F {

    /* renamed from: a  reason: collision with root package name */
    private final String f4527a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4528b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4529c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4530d;

    public F(String str, int i5, int i6, boolean z4) {
        t.e(str, "processName");
        this.f4527a = str;
        this.f4528b = i5;
        this.f4529c = i6;
        this.f4530d = z4;
    }

    public final int a() {
        return this.f4529c;
    }

    public final int b() {
        return this.f4528b;
    }

    public final String c() {
        return this.f4527a;
    }

    public final boolean d() {
        return this.f4530d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F)) {
            return false;
        }
        F f5 = (F) obj;
        if (t.a(this.f4527a, f5.f4527a) && this.f4528b == f5.f4528b && this.f4529c == f5.f4529c && this.f4530d == f5.f4530d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f4527a.hashCode() * 31) + this.f4528b) * 31) + this.f4529c) * 31) + a.a(this.f4530d);
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f4527a + ", pid=" + this.f4528b + ", importance=" + this.f4529c + ", isDefaultProcess=" + this.f4530d + ')';
    }
}
