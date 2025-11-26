package f0;

public enum v {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f15325a;

    private v(String str) {
        this.f15325a = str;
    }

    public final String toString() {
        return this.f15325a;
    }
}
