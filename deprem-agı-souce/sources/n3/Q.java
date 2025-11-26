package N3;

import W2.C2219h;
import kotlin.jvm.internal.t;
import t3.s;

public final class Q extends O {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Q(String str) {
        super(str);
        t.e(str, "source");
    }

    public byte F() {
        String R4 = C();
        int J4 = J();
        if (J4 >= R4.length() || J4 == -1) {
            return 10;
        }
        this.f18775a = J4;
        return C2132b.a(R4.charAt(J4));
    }

    public int J() {
        int i5;
        int i6 = this.f18775a;
        if (i6 == -1) {
            return i6;
        }
        String R4 = C();
        while (i6 < R4.length()) {
            char charAt = R4.charAt(i6);
            if (charAt != ' ' && charAt != 10 && charAt != 13 && charAt != 9) {
                if (charAt != '/' || (i5 = i6 + 1) >= R4.length()) {
                    break;
                }
                char charAt2 = R4.charAt(i5);
                if (charAt2 == '*') {
                    int f02 = s.f0(R4, "*/", i6 + 2, false, 4, (Object) null);
                    if (f02 != -1) {
                        i6 = f02 + 2;
                    } else {
                        this.f18775a = R4.length();
                        C2131a.x(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, (String) null, 6, (Object) null);
                        throw new C2219h();
                    }
                } else if (charAt2 != '/') {
                    break;
                } else {
                    i6 = s.e0(R4, 10, i6 + 2, false, 4, (Object) null);
                    if (i6 == -1) {
                        i6 = R4.length();
                    }
                }
            }
            i6++;
        }
        this.f18775a = i6;
        return i6;
    }

    public boolean e() {
        int J4 = J();
        if (J4 >= C().length() || J4 == -1) {
            return false;
        }
        return D(C().charAt(J4));
    }

    public byte j() {
        String R4 = C();
        int J4 = J();
        if (J4 >= R4.length() || J4 == -1) {
            return 10;
        }
        this.f18775a = J4 + 1;
        return C2132b.a(R4.charAt(J4));
    }

    public void l(char c5) {
        String R4 = C();
        int J4 = J();
        if (J4 >= R4.length() || J4 == -1) {
            this.f18775a = -1;
            P(c5);
        }
        char charAt = R4.charAt(J4);
        this.f18775a = J4 + 1;
        if (charAt != c5) {
            P(c5);
        }
    }
}
