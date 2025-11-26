package m0;

import java.io.Serializable;
import l0.c;
import l0.f;
import l0.h;

/* renamed from: m0.c  reason: case insensitive filesystem */
final class C1714c extends r implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final c f15550a;

    /* renamed from: b  reason: collision with root package name */
    final r f15551b;

    C1714c(c cVar, r rVar) {
        this.f15550a = (c) h.h(cVar);
        this.f15551b = (r) h.h(rVar);
    }

    public int compare(Object obj, Object obj2) {
        return this.f15551b.compare(this.f15550a.apply(obj), this.f15550a.apply(obj2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1714c) {
            C1714c cVar = (C1714c) obj;
            if (!this.f15550a.equals(cVar.f15550a) || !this.f15551b.equals(cVar.f15551b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return f.b(this.f15550a, this.f15551b);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f15551b);
        String valueOf2 = String.valueOf(this.f15550a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}
