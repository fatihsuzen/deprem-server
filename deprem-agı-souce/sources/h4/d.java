package h4;

public enum d {
    ALWAYS("always"),
    WIFI_ONLY("wifi_only"),
    EXCEPTION("exception");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f23760a;

    private d(String str) {
        this.f23760a = str;
    }

    public static d b(String str) {
        for (d dVar : values()) {
            if (dVar.f23760a.equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        return this.f23760a;
    }
}
