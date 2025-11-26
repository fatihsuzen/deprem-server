package N3;

import W2.C2219h;
import kotlin.jvm.internal.t;
import t3.s;

public class O extends C2131a {

    /* renamed from: e  reason: collision with root package name */
    private final String f18764e;

    public O(String str) {
        t.e(str, "source");
        this.f18764e = str;
    }

    public String E(String str, boolean z4) {
        t.e(str, "keyToMatch");
        int i5 = this.f18775a;
        try {
            if (j() == 6) {
                if (t.a(G(z4), str)) {
                    t();
                    if (j() == 5) {
                        String G4 = G(z4);
                        this.f18775a = i5;
                        t();
                        return G4;
                    }
                }
            }
            return null;
        } finally {
            this.f18775a = i5;
            t();
        }
    }

    public int H(int i5) {
        if (i5 < C().length()) {
            return i5;
        }
        return -1;
    }

    public int J() {
        int i5 = this.f18775a;
        if (i5 == -1) {
            return i5;
        }
        String R4 = C();
        while (i5 < R4.length() && ((r2 = R4.charAt(i5)) == ' ' || r2 == 10 || r2 == 13 || r2 == 9)) {
            i5++;
        }
        this.f18775a = i5;
        return i5;
    }

    /* access modifiers changed from: protected */
    /* renamed from: R */
    public String C() {
        return this.f18764e;
    }

    public boolean e() {
        int i5 = this.f18775a;
        if (i5 == -1) {
            return false;
        }
        String R4 = C();
        while (i5 < R4.length()) {
            char charAt = R4.charAt(i5);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i5++;
            } else {
                this.f18775a = i5;
                return D(charAt);
            }
        }
        this.f18775a = i5;
        return false;
    }

    public String i() {
        l('\"');
        int i5 = this.f18775a;
        int e02 = s.e0(C(), '\"', i5, false, 4, (Object) null);
        if (e02 != -1) {
            for (int i6 = i5; i6 < e02; i6++) {
                if (C().charAt(i6) == '\\') {
                    return p(C(), this.f18775a, i6);
                }
            }
            this.f18775a = e02 + 1;
            String substring = C().substring(i5, e02);
            t.d(substring, "substring(...)");
            return substring;
        }
        q();
        y((byte) 1, false);
        throw new C2219h();
    }

    public byte j() {
        String R4 = C();
        int i5 = this.f18775a;
        while (i5 != -1 && i5 < R4.length()) {
            int i6 = i5 + 1;
            char charAt = R4.charAt(i5);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i5 = i6;
            } else {
                this.f18775a = i6;
                return C2132b.a(charAt);
            }
        }
        this.f18775a = R4.length();
        return 10;
    }

    public void l(char c5) {
        if (this.f18775a == -1) {
            P(c5);
        }
        String R4 = C();
        int i5 = this.f18775a;
        while (i5 < R4.length()) {
            int i6 = i5 + 1;
            char charAt = R4.charAt(i5);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                this.f18775a = i6;
                if (charAt != c5) {
                    P(c5);
                } else {
                    return;
                }
            }
            i5 = i6;
        }
        this.f18775a = -1;
        P(c5);
    }
}
