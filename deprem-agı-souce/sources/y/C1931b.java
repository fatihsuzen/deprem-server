package y;

import B.C0628a;
import java.util.Map;

/* renamed from: y.b  reason: case insensitive filesystem */
final class C1931b extends C1935f {

    /* renamed from: a  reason: collision with root package name */
    private final C0628a f17001a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f17002b;

    C1931b(C0628a aVar, Map map) {
        if (aVar != null) {
            this.f17001a = aVar;
            if (map != null) {
                this.f17002b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public C0628a e() {
        return this.f17001a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1935f) {
            C1935f fVar = (C1935f) obj;
            if (!this.f17001a.equals(fVar.e()) || !this.f17002b.equals(fVar.h())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Map h() {
        return this.f17002b;
    }

    public int hashCode() {
        return ((this.f17001a.hashCode() ^ 1000003) * 1000003) ^ this.f17002b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f17001a + ", values=" + this.f17002b + "}";
    }
}
