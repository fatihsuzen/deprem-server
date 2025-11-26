package f0;

/* renamed from: f0.K  reason: case insensitive filesystem */
public enum C1643K {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f15313a;

    private C1643K(int i5) {
        this.f15313a = i5;
    }

    public static C1643K a(int i5) {
        for (C1643K k5 : values()) {
            if (k5.f15313a == i5) {
                return k5;
            }
        }
        return UNKNOWN;
    }

    public final int A() {
        return this.f15313a;
    }
}
