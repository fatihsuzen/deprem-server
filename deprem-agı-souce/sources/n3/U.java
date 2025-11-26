package N3;

import d3.C2344a;
import d3.C2345b;

public enum U {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');
    

    /* renamed from: a  reason: collision with root package name */
    public final char f18773a;

    /* renamed from: b  reason: collision with root package name */
    public final char f18774b;

    static {
        U[] a5;
        f18772h = C2345b.a(a5);
    }

    private U(char c5, char c6) {
        this.f18773a = c5;
        this.f18774b = c6;
    }

    public static C2344a b() {
        return f18772h;
    }
}
