package z;

import r.i;
import r.p;

/* renamed from: z.b  reason: case insensitive filesystem */
final class C1950b extends C1959k {

    /* renamed from: a  reason: collision with root package name */
    private final long f17143a;

    /* renamed from: b  reason: collision with root package name */
    private final p f17144b;

    /* renamed from: c  reason: collision with root package name */
    private final i f17145c;

    C1950b(long j5, p pVar, i iVar) {
        this.f17143a = j5;
        if (pVar != null) {
            this.f17144b = pVar;
            if (iVar != null) {
                this.f17145c = iVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public i b() {
        return this.f17145c;
    }

    public long c() {
        return this.f17143a;
    }

    public p d() {
        return this.f17144b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1959k) {
            C1959k kVar = (C1959k) obj;
            if (this.f17143a != kVar.c() || !this.f17144b.equals(kVar.d()) || !this.f17145c.equals(kVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f17143a;
        return ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f17144b.hashCode()) * 1000003) ^ this.f17145c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f17143a + ", transportContext=" + this.f17144b + ", event=" + this.f17145c + "}";
    }
}
