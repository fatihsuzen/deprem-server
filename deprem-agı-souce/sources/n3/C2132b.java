package N3;

/* renamed from: N3.b  reason: case insensitive filesystem */
public abstract class C2132b {
    public static final byte a(char c5) {
        if (c5 < '~') {
            return C2137g.f18789c[c5];
        }
        return 0;
    }

    public static final char b(int i5) {
        if (i5 < 117) {
            return C2137g.f18788b[i5];
        }
        return 0;
    }

    public static final String c(byte b5) {
        if (b5 == 1) {
            return "quotation mark '\"'";
        }
        if (b5 == 2) {
            return "string escape sequence '\\'";
        }
        if (b5 == 4) {
            return "comma ','";
        }
        if (b5 == 5) {
            return "colon ':'";
        }
        if (b5 == 6) {
            return "start of the object '{'";
        }
        if (b5 == 7) {
            return "end of the object '}'";
        }
        if (b5 == 8) {
            return "start of the array '['";
        }
        if (b5 == 9) {
            return "end of the array ']'";
        }
        if (b5 == 10) {
            return "end of the input";
        }
        if (b5 == Byte.MAX_VALUE) {
            return "invalid token";
        }
        return "valid token";
    }
}
