package z2;

/* renamed from: z2.w  reason: case insensitive filesystem */
public final class C2963w {

    /* renamed from: a  reason: collision with root package name */
    public static final C2963w f26560a = new C2963w();

    /* renamed from: b  reason: collision with root package name */
    private static String f26561b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f26562c = "";

    private C2963w() {
    }

    public final String a() {
        String str = f26561b;
        if (str.length() == 0) {
            return "https://www.uptodown.app:443";
        }
        return str;
    }

    public final String b() {
        return "https://www.uptodown.com:443";
    }

    public final String c() {
        String str = f26562c;
        if (str.length() == 0) {
            return "https://t.uptodown.app:443";
        }
        return str;
    }

    public final String d() {
        return "https://u.uptodown.app:443";
    }
}
