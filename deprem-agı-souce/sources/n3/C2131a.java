package N3;

import W2.C2219h;
import W2.q;
import X2.C2250q;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: N3.a  reason: case insensitive filesystem */
public abstract class C2131a {

    /* renamed from: a  reason: collision with root package name */
    public int f18775a;

    /* renamed from: b  reason: collision with root package name */
    public final C f18776b = new C();

    /* renamed from: c  reason: collision with root package name */
    private String f18777c;

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f18778d = new StringBuilder();

    private final int B(CharSequence charSequence, int i5) {
        char charAt = charSequence.charAt(i5);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        x(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    private final String L() {
        String str = this.f18777c;
        t.b(str);
        this.f18777c = null;
        return str;
    }

    public static /* synthetic */ boolean O(C2131a aVar, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                z4 = true;
            }
            return aVar.N(z4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
    }

    private final boolean Q() {
        if (C().charAt(this.f18775a - 1) != '\"') {
            return true;
        }
        return false;
    }

    private final int a(int i5) {
        int H4 = H(i5);
        if (H4 != -1) {
            int i6 = H4 + 1;
            char charAt = C().charAt(H4);
            if (charAt == 'u') {
                return c(C(), i6);
            }
            char b5 = C2132b.b(charAt);
            if (b5 != 0) {
                this.f18778d.append(b5);
                return i6;
            }
            x(this, "Invalid escaped char '" + charAt + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
        x(this, "Expected escape sequence to continue, got EOF", 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    private final int b(int i5, int i6) {
        d(i5, i6);
        return a(i6 + 1);
    }

    private final int c(CharSequence charSequence, int i5) {
        int i6 = i5 + 4;
        if (i6 >= charSequence.length()) {
            this.f18775a = i5;
            u();
            if (this.f18775a + 4 < charSequence.length()) {
                return c(charSequence, this.f18775a);
            }
            x(this, "Unexpected EOF during unicode escape", 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
        this.f18778d.append((char) ((B(charSequence, i5) << 12) + (B(charSequence, i5 + 1) << 8) + (B(charSequence, i5 + 2) << 4) + B(charSequence, i5 + 3)));
        return i6;
    }

    private final boolean f(int i5) {
        int H4 = H(i5);
        if (H4 >= C().length() || H4 == -1) {
            x(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
        int i6 = H4 + 1;
        char charAt = C().charAt(H4) | ' ';
        if (charAt == 'f') {
            h("alse", i6);
            return false;
        } else if (charAt == 't') {
            h("rue", i6);
            return true;
        } else {
            x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    private final void h(String str, int i5) {
        if (C().length() - i5 >= str.length()) {
            int length = str.length();
            int i6 = 0;
            while (i6 < length) {
                if (str.charAt(i6) == (C().charAt(i5 + i6) | ' ')) {
                    i6++;
                } else {
                    x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, (String) null, 6, (Object) null);
                    throw new C2219h();
                }
            }
            this.f18775a = i5 + str.length();
            return;
        }
        x(this, "Unexpected end of boolean literal", 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    private static final double n(long j5, boolean z4) {
        if (!z4) {
            return Math.pow(10.0d, -((double) j5));
        }
        if (z4) {
            return Math.pow(10.0d, (double) j5);
        }
        throw new q();
    }

    private final String s(int i5, int i6) {
        d(i5, i6);
        String sb = this.f18778d.toString();
        t.d(sb, "toString(...)");
        this.f18778d.setLength(0);
        return sb;
    }

    public static /* synthetic */ Void x(C2131a aVar, String str, int i5, String str2, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 2) != 0) {
                i5 = aVar.f18775a;
            }
            if ((i6 & 4) != 0) {
                str2 = "";
            }
            return aVar.w(str, i5, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public static /* synthetic */ Void z(C2131a aVar, byte b5, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                z4 = true;
            }
            return aVar.y(b5, z4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final void A(String str) {
        t.e(str, "key");
        String str2 = str;
        int l02 = s.l0(K(0, this.f18775a), str2, 0, false, 6, (Object) null);
        w("Encountered an unknown key '" + str2 + '\'', l02, "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new C2219h();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence C();

    /* access modifiers changed from: protected */
    public final boolean D(char c5) {
        if (c5 == ',' || c5 == ':' || c5 == ']' || c5 == '}') {
            return false;
        }
        return true;
    }

    public abstract String E(String str, boolean z4);

    public byte F() {
        CharSequence C4 = C();
        int i5 = this.f18775a;
        while (true) {
            int H4 = H(i5);
            if (H4 != -1) {
                char charAt = C4.charAt(H4);
                if (charAt == 9 || charAt == 10 || charAt == 13 || charAt == ' ') {
                    i5 = H4 + 1;
                } else {
                    this.f18775a = H4;
                    return C2132b.a(charAt);
                }
            } else {
                this.f18775a = H4;
                return 10;
            }
        }
    }

    public final String G(boolean z4) {
        String str;
        byte F4 = F();
        if (z4) {
            if (F4 != 1 && F4 != 0) {
                return null;
            }
            str = q();
        } else if (F4 != 1) {
            return null;
        } else {
            str = o();
        }
        this.f18777c = str;
        return str;
    }

    public abstract int H(int i5);

    public final void I(boolean z4) {
        ArrayList arrayList = new ArrayList();
        byte F4 = F();
        if (F4 == 8 || F4 == 6) {
            while (true) {
                byte F5 = F();
                if (F5 != 1) {
                    if (F5 == 8 || F5 == 6) {
                        arrayList.add(Byte.valueOf(F5));
                    } else if (F5 == 9) {
                        if (((Number) C2250q.X(arrayList)).byteValue() == 8) {
                            C2250q.z(arrayList);
                        } else {
                            int i5 = this.f18775a;
                            throw z.e(i5, "found ] instead of } at path: " + this.f18776b, C());
                        }
                    } else if (F5 == 7) {
                        if (((Number) C2250q.X(arrayList)).byteValue() == 6) {
                            C2250q.z(arrayList);
                        } else {
                            int i6 = this.f18775a;
                            throw z.e(i6, "found } instead of ] at path: " + this.f18776b, C());
                        }
                    } else if (F5 == 10) {
                        x(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, (String) null, 6, (Object) null);
                        throw new C2219h();
                    }
                    j();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z4) {
                    q();
                } else {
                    i();
                }
            }
        } else {
            q();
        }
    }

    public abstract int J();

    public String K(int i5, int i6) {
        return C().subSequence(i5, i6).toString();
    }

    public final boolean M() {
        int J4 = J();
        CharSequence C4 = C();
        if (J4 >= C4.length() || J4 == -1 || C4.charAt(J4) != ',') {
            return false;
        }
        this.f18775a++;
        return true;
    }

    public final boolean N(boolean z4) {
        int H4 = H(J());
        int length = C().length() - H4;
        if (length < 4 || H4 == -1) {
            return false;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            if ("null".charAt(i5) != C().charAt(H4 + i5)) {
                return false;
            }
        }
        if (length > 4 && C2132b.a(C().charAt(H4 + 4)) == 0) {
            return false;
        }
        if (!z4) {
            return true;
        }
        this.f18775a = H4 + 4;
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final void P(char c5) {
        int i5 = this.f18775a;
        if (i5 > 0 && c5 == '\"') {
            try {
                this.f18775a = i5 - 1;
                String q5 = q();
                this.f18775a = i5;
                if (t.a(q5, "null")) {
                    w("Expected string literal but 'null' literal was found", this.f18775a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new C2219h();
                }
            } catch (Throwable th) {
                this.f18775a = i5;
                throw th;
            }
        }
        z(this, C2132b.a(c5), false, 2, (Object) null);
        throw new C2219h();
    }

    /* access modifiers changed from: protected */
    public void d(int i5, int i6) {
        this.f18778d.append(C(), i5, i6);
    }

    public abstract boolean e();

    public final boolean g() {
        boolean z4;
        int J4 = J();
        if (J4 != C().length()) {
            if (C().charAt(J4) == '\"') {
                J4++;
                z4 = true;
            } else {
                z4 = false;
            }
            boolean f5 = f(J4);
            if (!z4) {
                return f5;
            }
            if (this.f18775a == C().length()) {
                x(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new C2219h();
            } else if (C().charAt(this.f18775a) == '\"') {
                this.f18775a++;
                return f5;
            } else {
                x(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                throw new C2219h();
            }
        } else {
            x(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public abstract String i();

    public abstract byte j();

    public final byte k(byte b5) {
        byte j5 = j();
        if (j5 == b5) {
            return j5;
        }
        z(this, b5, false, 2, (Object) null);
        throw new C2219h();
    }

    public abstract void l(char c5);

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013f, code lost:
        if (r2 == r1) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0141, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0143, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0144, code lost:
        if (r1 == r2) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0146, code lost:
        if (r9 == false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014a, code lost:
        if (r1 == (r2 - 1)) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014c, code lost:
        if (r0 == false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014e, code lost:
        if (r4 == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0158, code lost:
        if (C().charAt(r2) != '\"') goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015c, code lost:
        r0 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015f, code lost:
        x(r18, "Expected closing quotation mark", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x016f, code lost:
        throw new W2.C2219h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0170, code lost:
        x(r18, "EOF", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0180, code lost:
        throw new W2.C2219h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0181, code lost:
        r0.f18775a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0183, code lost:
        if (r8 == false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0185, code lost:
        r1 = ((double) r10) * n(r12, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x018f, code lost:
        if (r1 > 9.223372036854776E18d) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0195, code lost:
        if (r1 < -9.223372036854776E18d) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019d, code lost:
        if (java.lang.Math.floor(r1) != r1) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019f, code lost:
        r10 = (long) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a1, code lost:
        x(r0, "Can't convert " + r1 + " to Long", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c3, code lost:
        throw new W2.C2219h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c4, code lost:
        x(r18, "Numeric value overflow", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d4, code lost:
        throw new W2.C2219h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d5, code lost:
        if (r9 == false) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d7, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01dc, code lost:
        if (r10 == Long.MIN_VALUE) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01df, code lost:
        return -r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e0, code lost:
        x(r18, "Numeric value overflow", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f0, code lost:
        throw new W2.C2219h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f1, code lost:
        x(r18, "Expected numeric literal", 0, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0201, code lost:
        throw new W2.C2219h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m() {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.J()
            int r1 = r0.H(r1)
            java.lang.CharSequence r2 = r0.C()
            int r2 = r2.length()
            if (r1 >= r2) goto L_0x0202
            r2 = -1
            if (r1 == r2) goto L_0x0202
            java.lang.CharSequence r2 = r0.C()
            char r2 = r2.charAt(r1)
            r3 = 34
            if (r2 != r3) goto L_0x0040
            int r1 = r1 + 1
            java.lang.CharSequence r2 = r0.C()
            int r2 = r2.length()
            if (r1 == r2) goto L_0x0031
            r0 = 1
            goto L_0x0041
        L_0x0031:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "EOF"
            r2 = 0
            r3 = 0
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x0040:
            r0 = 0
        L_0x0041:
            r2 = r1
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
        L_0x0048:
            r14 = 0
        L_0x0049:
            java.lang.CharSequence r15 = r18.C()
            int r15 = r15.length()
            if (r2 == r15) goto L_0x013f
            java.lang.CharSequence r15 = r18.C()
            char r15 = r15.charAt(r2)
            r4 = 101(0x65, float:1.42E-43)
            if (r15 == r4) goto L_0x0063
            r4 = 69
            if (r15 != r4) goto L_0x0091
        L_0x0063:
            if (r8 != 0) goto L_0x0091
            if (r2 == r1) goto L_0x006c
            int r2 = r2 + 1
            r8 = 1
        L_0x006a:
            r14 = 1
            goto L_0x0049
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected symbol "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r1 = " in numeric literal"
            r0.append(r1)
            java.lang.String r1 = r0.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x0091:
            r4 = 45
            if (r15 != r4) goto L_0x00ad
            if (r8 == 0) goto L_0x00ad
            if (r2 == r1) goto L_0x009c
            int r2 = r2 + 1
            goto L_0x0048
        L_0x009c:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Unexpected symbol '-' in numeric literal"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x00ad:
            r5 = 43
            if (r15 != r5) goto L_0x00c9
            if (r8 == 0) goto L_0x00c9
            if (r2 == r1) goto L_0x00b8
            int r2 = r2 + 1
            goto L_0x006a
        L_0x00b8:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Unexpected symbol '+' in numeric literal"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x00c9:
            if (r15 != r4) goto L_0x00e3
            if (r2 != r1) goto L_0x00d2
            int r2 = r2 + 1
            r9 = 1
            goto L_0x0049
        L_0x00d2:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Unexpected symbol '-' in numeric literal"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x00e3:
            byte r4 = N3.C2132b.a(r15)
            if (r4 != 0) goto L_0x013f
            int r2 = r2 + 1
            int r4 = r15 + -48
            if (r4 < 0) goto L_0x011a
            r5 = 10
            if (r4 >= r5) goto L_0x011a
            if (r8 == 0) goto L_0x00fd
            r16 = 0
            long r6 = (long) r5
            long r12 = r12 * r6
            long r4 = (long) r4
            long r12 = r12 + r4
            goto L_0x0049
        L_0x00fd:
            r16 = 0
            long r5 = (long) r5
            long r10 = r10 * r5
            long r4 = (long) r4
            long r10 = r10 - r4
            int r4 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r4 > 0) goto L_0x0109
            goto L_0x0049
        L_0x0109:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Numeric value overflow"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x011a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected symbol '"
            r0.append(r1)
            r0.append(r15)
            java.lang.String r1 = "' in numeric literal"
            r0.append(r1)
            java.lang.String r1 = r0.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x013f:
            if (r2 == r1) goto L_0x0143
            r4 = 1
            goto L_0x0144
        L_0x0143:
            r4 = 0
        L_0x0144:
            if (r1 == r2) goto L_0x01f1
            if (r9 == 0) goto L_0x014c
            int r5 = r2 + -1
            if (r1 == r5) goto L_0x01f1
        L_0x014c:
            if (r0 == 0) goto L_0x015c
            if (r4 == 0) goto L_0x0170
            java.lang.CharSequence r0 = r18.C()
            char r0 = r0.charAt(r2)
            if (r0 != r3) goto L_0x015f
            int r2 = r2 + 1
        L_0x015c:
            r0 = r18
            goto L_0x0181
        L_0x015f:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Expected closing quotation mark"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x0170:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "EOF"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r1 = new W2.h
            r1.<init>()
            throw r1
        L_0x0181:
            r0.f18775a = r2
            if (r8 == 0) goto L_0x01d5
            double r1 = (double) r10
            double r3 = n(r12, r14)
            double r1 = r1 * r3
            r3 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01c4
            r3 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x01c4
            double r3 = java.lang.Math.floor(r1)
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x01a1
            long r10 = (long) r1
            goto L_0x01d5
        L_0x01a1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't convert "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " to Long"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x01c4:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Numeric value overflow"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x01d5:
            if (r9 == 0) goto L_0x01d8
            return r10
        L_0x01d8:
            r0 = -9223372036854775808
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01e0
            long r0 = -r10
            return r0
        L_0x01e0:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Numeric value overflow"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x01f1:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "Expected numeric literal"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x0202:
            r4 = 6
            r5 = 0
            java.lang.String r1 = "EOF"
            r2 = 0
            r3 = 0
            r0 = r18
            x(r0, r1, r2, r3, r4, r5)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.C2131a.m():long");
    }

    public final String o() {
        if (this.f18777c != null) {
            return L();
        }
        return i();
    }

    /* access modifiers changed from: protected */
    public final String p(CharSequence charSequence, int i5, int i6) {
        String str;
        t.e(charSequence, "source");
        char charAt = charSequence.charAt(i6);
        boolean z4 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                int H4 = H(b(i5, i6));
                if (H4 != -1) {
                    z4 = true;
                    i5 = H4;
                    i6 = i5;
                } else {
                    x(this, "Unexpected EOF", H4, (String) null, 4, (Object) null);
                    throw new C2219h();
                }
            } else {
                i6++;
                if (i6 >= charSequence.length()) {
                    d(i5, i6);
                    int H5 = H(i6);
                    if (H5 != -1) {
                        i5 = H5;
                        i6 = i5;
                        z4 = true;
                    } else {
                        x(this, "Unexpected EOF", H5, (String) null, 4, (Object) null);
                        throw new C2219h();
                    }
                } else {
                    continue;
                }
            }
            charAt = charSequence.charAt(i6);
        }
        if (!z4) {
            str = K(i5, i6);
        } else {
            str = s(i5, i6);
        }
        this.f18775a = i6 + 1;
        return str;
    }

    public final String q() {
        String str;
        if (this.f18777c != null) {
            return L();
        }
        int J4 = J();
        if (J4 >= C().length() || J4 == -1) {
            x(this, "EOF", J4, (String) null, 4, (Object) null);
            throw new C2219h();
        }
        byte a5 = C2132b.a(C().charAt(J4));
        if (a5 == 1) {
            return o();
        }
        if (a5 == 0) {
            boolean z4 = false;
            while (C2132b.a(C().charAt(J4)) == 0) {
                J4++;
                if (J4 >= C().length()) {
                    d(this.f18775a, J4);
                    int H4 = H(J4);
                    if (H4 == -1) {
                        this.f18775a = J4;
                        return s(0, 0);
                    }
                    J4 = H4;
                    z4 = true;
                }
            }
            if (!z4) {
                str = K(this.f18775a, J4);
            } else {
                str = s(this.f18775a, J4);
            }
            this.f18775a = J4;
            return str;
        }
        x(this, "Expected beginning of the string, but got " + C().charAt(J4), 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    public final String r() {
        String q5 = q();
        if (!t.a(q5, "null") || !Q()) {
            return q5;
        }
        x(this, "Unexpected 'null' value instead of string literal", 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    public final void t() {
        this.f18777c = null;
    }

    public String toString() {
        return "JsonReader(source='" + C() + "', currentPosition=" + this.f18775a + ')';
    }

    public final void v() {
        if (j() != 10) {
            x(this, "Expected EOF after parsing, but had " + C().charAt(this.f18775a - 1) + " instead", 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public final Void w(String str, int i5, String str2) {
        String str3;
        t.e(str, "message");
        t.e(str2, "hint");
        if (str2.length() == 0) {
            str3 = "";
        } else {
            str3 = 10 + str2;
        }
        throw z.e(i5, str + " at path: " + this.f18776b.a() + str3, C());
    }

    public final Void y(byte b5, boolean z4) {
        int i5;
        String str;
        String c5 = C2132b.c(b5);
        if (z4) {
            i5 = this.f18775a - 1;
        } else {
            i5 = this.f18775a;
        }
        int i6 = i5;
        if (this.f18775a == C().length() || i6 < 0) {
            str = "EOF";
        } else {
            str = String.valueOf(C().charAt(i6));
        }
        x(this, "Expected " + c5 + ", but had '" + str + "' instead", i6, (String) null, 4, (Object) null);
        throw new C2219h();
    }

    public void u() {
    }
}
