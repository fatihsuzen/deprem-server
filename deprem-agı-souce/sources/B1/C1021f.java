package b1;

import kotlin.jvm.internal.t;

/* renamed from: b1.f  reason: case insensitive filesystem */
public final class C1021f {

    /* renamed from: a  reason: collision with root package name */
    private final C1019d f4699a;

    /* renamed from: b  reason: collision with root package name */
    private final C1019d f4700b;

    /* renamed from: c  reason: collision with root package name */
    private final double f4701c;

    public C1021f(C1019d dVar, C1019d dVar2, double d5) {
        t.e(dVar, "performance");
        t.e(dVar2, "crashlytics");
        this.f4699a = dVar;
        this.f4700b = dVar2;
        this.f4701c = d5;
    }

    public final C1019d a() {
        return this.f4700b;
    }

    public final C1019d b() {
        return this.f4699a;
    }

    public final double c() {
        return this.f4701c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1021f)) {
            return false;
        }
        C1021f fVar = (C1021f) obj;
        if (this.f4699a == fVar.f4699a && this.f4700b == fVar.f4700b && Double.compare(this.f4701c, fVar.f4701c) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f4699a.hashCode() * 31) + this.f4700b.hashCode()) * 31) + Double.doubleToLongBits(this.f4701c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f4699a + ", crashlytics=" + this.f4700b + ", sessionSamplingRate=" + this.f4701c + ')';
    }
}
