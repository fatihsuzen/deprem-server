package X2;

import kotlin.jvm.internal.t;

public final class G {

    /* renamed from: a  reason: collision with root package name */
    private final int f20050a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f20051b;

    public G(int i5, Object obj) {
        this.f20050a = i5;
        this.f20051b = obj;
    }

    public final int a() {
        return this.f20050a;
    }

    public final Object b() {
        return this.f20051b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        G g5 = (G) obj;
        if (this.f20050a == g5.f20050a && t.a(this.f20051b, g5.f20051b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int i6 = this.f20050a * 31;
        Object obj = this.f20051b;
        if (obj == null) {
            i5 = 0;
        } else {
            i5 = obj.hashCode();
        }
        return i6 + i5;
    }

    public String toString() {
        return "IndexedValue(index=" + this.f20050a + ", value=" + this.f20051b + ')';
    }
}
