package P0;

import java.util.List;

final class a extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f3870a;

    /* renamed from: b  reason: collision with root package name */
    private final List f3871b;

    a(String str, List list) {
        if (str != null) {
            this.f3870a = str;
            if (list != null) {
                this.f3871b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public List b() {
        return this.f3871b;
    }

    public String c() {
        return this.f3870a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (!this.f3870a.equals(qVar.c()) || !this.f3871b.equals(qVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3870a.hashCode() ^ 1000003) * 1000003) ^ this.f3871b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f3870a + ", usedDates=" + this.f3871b + "}";
    }
}
