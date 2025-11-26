package u1;

import A1.g;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final String f16720a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16721b;

    private l(String str, String str2) {
        this.f16720a = str;
        this.f16721b = str2;
    }

    public static l a(String str, String str2) {
        g.d(str, "Name is null or empty");
        g.d(str2, "Version is null or empty");
        return new l(str, str2);
    }

    public String b() {
        return this.f16720a;
    }

    public String c() {
        return this.f16721b;
    }
}
