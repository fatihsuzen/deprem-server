package j$.time.temporal;

import j$.com.android.tools.r8.a;

public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);
    
    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a  reason: collision with root package name */
    public final transient String f1193a;

    /* renamed from: b  reason: collision with root package name */
    public final transient u f1194b;

    /* renamed from: c  reason: collision with root package name */
    public final transient long f1195c;

    public final boolean isDateBased() {
        return true;
    }

    /* access modifiers changed from: public */
    k(String str, long j5) {
        this.f1193a = str;
        this.f1194b = u.e(-365243219162L + j5, 365241780471L + j5);
        this.f1195c = j5;
    }

    public final m h(m mVar, long j5) {
        if (this.f1194b.d(j5)) {
            return mVar.a(a.C(j5, this.f1195c), a.EPOCH_DAY);
        }
        throw new RuntimeException("Invalid value: " + this.f1193a + " " + j5);
    }

    public final u range() {
        return this.f1194b;
    }

    public final boolean e(n nVar) {
        return nVar.c(a.EPOCH_DAY);
    }

    public final u f(n nVar) {
        if (nVar.c(a.EPOCH_DAY)) {
            return this.f1194b;
        }
        throw new RuntimeException("Unsupported field: " + this);
    }

    public final long g(n nVar) {
        return nVar.q(a.EPOCH_DAY) + this.f1195c;
    }

    public final String toString() {
        return this.f1193a;
    }
}
