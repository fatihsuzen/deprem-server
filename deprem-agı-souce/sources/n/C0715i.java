package N;

/* renamed from: N.i  reason: case insensitive filesystem */
public final class C0715i {

    /* renamed from: a  reason: collision with root package name */
    private final String f3100a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3101b;

    public C0715i(String str) {
        this(str, (String) null);
    }

    public C0715i(String str, String str2) {
        C0722p.l(str, "log tag cannot be null");
        C0722p.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f3100a = str;
        this.f3101b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
