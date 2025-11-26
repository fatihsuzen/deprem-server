package v1;

public enum c {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f16753a;

    private c(String str) {
        this.f16753a = str;
    }

    public String toString() {
        return this.f16753a;
    }
}
