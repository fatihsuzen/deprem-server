package t3;

import d3.C2345b;

public enum r {
    IGNORE_CASE(2, 0, 2, (int) null),
    MULTILINE(8, 0, 2, (int) null),
    LITERAL(16, 0, 2, (int) null),
    UNIX_LINES(1, 0, 2, (int) null),
    COMMENTS(4, 0, 2, (int) null),
    DOT_MATCHES_ALL(32, 0, 2, (int) null),
    CANON_EQ(128, 0, 2, (int) null);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f25964a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25965b;

    static {
        r[] a5;
        f25963k = C2345b.a(a5);
    }

    private r(int i5, int i6) {
        this.f25964a = i5;
        this.f25965b = i6;
    }

    public int b() {
        return this.f25964a;
    }
}
