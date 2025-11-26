package N3;

import androidx.appcompat.R;

/* renamed from: N3.g  reason: case insensitive filesystem */
public final class C2137g {

    /* renamed from: a  reason: collision with root package name */
    public static final C2137g f18787a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f18788b = new char[117];

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f18789c = new byte[R.styleable.AppCompatTheme_windowNoTitle];

    static {
        C2137g gVar = new C2137g();
        f18787a = gVar;
        gVar.f();
        gVar.e();
    }

    private C2137g() {
    }

    private final void a(char c5, char c6) {
        b(c5, c6);
    }

    private final void b(int i5, char c5) {
        if (c5 != 'u') {
            f18788b[c5] = (char) i5;
        }
    }

    private final void c(char c5, byte b5) {
        d(c5, b5);
    }

    private final void d(int i5, byte b5) {
        f18789c[i5] = b5;
    }

    private final void e() {
        for (int i5 = 0; i5 < 33; i5++) {
            d(i5, Byte.MAX_VALUE);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    private final void f() {
        for (int i5 = 0; i5 < 32; i5++) {
            b(i5, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
