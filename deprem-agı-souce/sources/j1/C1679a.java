package j1;

import com.google.gson.internal.F;
import com.google.gson.internal.w;
import com.google.gson.r;
import j$.util.Objects;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Reader;
import java.util.Arrays;

/* renamed from: j1.a  reason: case insensitive filesystem */
public class C1679a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Reader f15410a;

    /* renamed from: b  reason: collision with root package name */
    private r f15411b = r.LEGACY_STRICT;

    /* renamed from: c  reason: collision with root package name */
    private int f15412c = 255;

    /* renamed from: d  reason: collision with root package name */
    private final char[] f15413d = new char[1024];

    /* renamed from: e  reason: collision with root package name */
    private int f15414e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f15415f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f15416g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f15417h = 0;

    /* renamed from: i  reason: collision with root package name */
    int f15418i = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f15419j;

    /* renamed from: k  reason: collision with root package name */
    private int f15420k;

    /* renamed from: l  reason: collision with root package name */
    private String f15421l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f15422m;

    /* renamed from: n  reason: collision with root package name */
    private int f15423n;

    /* renamed from: o  reason: collision with root package name */
    private String[] f15424o;

    /* renamed from: p  reason: collision with root package name */
    private int[] f15425p;

    /* renamed from: j1.a$a  reason: collision with other inner class name */
    class C0152a extends w {
        C0152a() {
        }

        public void a(C1679a aVar) {
            int i5 = aVar.f15418i;
            if (i5 == 0) {
                i5 = aVar.o();
            }
            if (i5 == 13) {
                aVar.f15418i = 9;
            } else if (i5 == 12) {
                aVar.f15418i = 8;
            } else if (i5 == 14) {
                aVar.f15418i = 10;
            } else {
                throw aVar.Z("a name");
            }
        }
    }

    static {
        w.f7781a = new C0152a();
    }

    public C1679a(Reader reader) {
        int[] iArr = new int[32];
        this.f15422m = iArr;
        this.f15423n = 1;
        iArr[0] = 6;
        this.f15424o = new String[32];
        this.f15425p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f15410a = reader;
    }

    private int I(boolean z4) {
        char c5;
        char[] cArr = this.f15413d;
        int i5 = this.f15414e;
        int i6 = this.f15415f;
        while (true) {
            if (i5 == i6) {
                this.f15414e = i5;
                if (s(1)) {
                    i5 = this.f15414e;
                    i6 = this.f15415f;
                } else if (!z4) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + A());
                }
            }
            int i7 = i5 + 1;
            c5 = cArr[i5];
            if (c5 == 10) {
                this.f15416g++;
                this.f15417h = i7;
            } else if (!(c5 == ' ' || c5 == 13 || c5 == 9)) {
                if (c5 == '/') {
                    this.f15414e = i7;
                    if (i7 == i6) {
                        this.f15414e = i5;
                        boolean s5 = s(2);
                        this.f15414e++;
                        if (!s5) {
                            break;
                        }
                    }
                    m();
                    int i8 = this.f15414e;
                    char c6 = cArr[i8];
                    if (c6 == '*') {
                        this.f15414e = i8 + 1;
                        if (U("*/")) {
                            i5 = this.f15414e + 2;
                            i6 = this.f15415f;
                        } else {
                            throw Y("Unterminated comment");
                        }
                    } else if (c6 != '/') {
                        break;
                    } else {
                        this.f15414e = i8 + 1;
                        V();
                        i5 = this.f15414e;
                        i6 = this.f15415f;
                    }
                } else if (c5 == '#') {
                    this.f15414e = i7;
                    m();
                    V();
                    i5 = this.f15414e;
                    i6 = this.f15415f;
                } else {
                    this.f15414e = i7;
                    return c5;
                }
            }
            i5 = i7;
        }
        return c5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        if (r1 != null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        r1.append(r0, r3, r2 - r3);
        r10.f15414e = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String K(char r11) {
        /*
            r10 = this;
            char[] r0 = r10.f15413d
            r1 = 0
        L_0x0003:
            int r2 = r10.f15414e
            int r3 = r10.f15415f
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x006c
            int r7 = r2 + 1
            char r2 = r0[r2]
            com.google.gson.r r8 = r10.f15411b
            com.google.gson.r r9 = com.google.gson.r.STRICT
            if (r8 != r9) goto L_0x0024
            r8 = 32
            if (r2 < r8) goto L_0x001d
            goto L_0x0024
        L_0x001d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            j1.d r11 = r10.Y(r11)
            throw r11
        L_0x0024:
            if (r2 != r11) goto L_0x003a
            r10.f15414e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0032
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r3, r7)
            return r11
        L_0x0032:
            r1.append(r0, r3, r7)
            java.lang.String r11 = r1.toString()
            return r11
        L_0x003a:
            r8 = 92
            if (r2 != r8) goto L_0x005f
            r10.f15414e = r7
            int r7 = r7 - r3
            int r2 = r7 + -1
            if (r1 != 0) goto L_0x0050
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L_0x0050:
            r1.append(r0, r3, r2)
            char r2 = r10.R()
            r1.append(r2)
            int r2 = r10.f15414e
            int r3 = r10.f15415f
            goto L_0x0007
        L_0x005f:
            r5 = 10
            if (r2 != r5) goto L_0x006a
            int r2 = r10.f15416g
            int r2 = r2 + r6
            r10.f15416g = r2
            r10.f15417h = r7
        L_0x006a:
            r2 = r7
            goto L_0x0009
        L_0x006c:
            if (r1 != 0) goto L_0x007c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x007c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r10.f15414e = r2
            boolean r2 = r10.s(r6)
            if (r2 == 0) goto L_0x008b
            goto L_0x0003
        L_0x008b:
            java.lang.String r11 = "Unterminated string"
            j1.d r11 = r10.Y(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.C1679a.K(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        m();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String M() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r1
        L_0x0003:
            int r3 = r6.f15414e
            int r4 = r3 + r2
            int r5 = r6.f15415f
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.f15413d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.m()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.f15413d
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.s(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.f15413d
            int r4 = r6.f15414e
            r0.append(r3, r4, r2)
            int r3 = r6.f15414e
            int r3 = r3 + r2
            r6.f15414e = r3
            r2 = 1
            boolean r2 = r6.s(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f15413d
            int r3 = r6.f15414e
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.f15413d
            int r3 = r6.f15414e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.f15414e
            int r2 = r2 + r1
            r6.f15414e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.C1679a.M():java.lang.String");
    }

    private int O() {
        int i5;
        String str;
        String str2;
        boolean z4;
        char c5 = this.f15413d[this.f15414e];
        if (c5 == 't' || c5 == 'T') {
            str2 = "true";
            str = "TRUE";
            i5 = 5;
        } else if (c5 == 'f' || c5 == 'F') {
            str2 = "false";
            str = "FALSE";
            i5 = 6;
        } else if (c5 != 'n' && c5 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i5 = 7;
        }
        if (this.f15411b != r.STRICT) {
            z4 = true;
        } else {
            z4 = false;
        }
        int length = str2.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (this.f15414e + i6 >= this.f15415f && !s(i6 + 1)) {
                return 0;
            }
            char c6 = this.f15413d[this.f15414e + i6];
            if (c6 != str2.charAt(i6) && (!z4 || c6 != str.charAt(i6))) {
                return 0;
            }
        }
        if ((this.f15414e + length < this.f15415f || s(length + 1)) && z(this.f15413d[this.f15414e + length])) {
            return 0;
        }
        this.f15414e += length;
        this.f15418i = i5;
        return i5;
    }

    private int P() {
        int i5;
        char c5;
        int i6;
        char[] cArr = this.f15413d;
        int i7 = this.f15414e;
        int i8 = this.f15415f;
        int i9 = 0;
        int i10 = 0;
        char c6 = 0;
        boolean z4 = false;
        int i11 = 1;
        long j5 = 0;
        while (true) {
            char c7 = 2;
            if (i7 + i10 == i8) {
                if (i10 == cArr.length) {
                    return i9;
                }
                if (!s(i10 + 1)) {
                    i5 = i9;
                    break;
                }
                i7 = this.f15414e;
                i8 = this.f15415f;
            }
            c5 = cArr[i7 + i10];
            i5 = i9;
            if (c5 == '+') {
                c7 = 6;
                if (c6 != 5) {
                    return i5;
                }
            } else if (c5 == 'E' || c5 == 'e') {
                if (c6 != 2 && c6 != 4) {
                    return i5;
                }
                c6 = 5;
                i10++;
                i9 = i5;
            } else if (c5 != '-') {
                if (c5 != '.') {
                    if (c5 >= '0' && c5 <= '9') {
                        if (c6 == 1 || c6 == 0) {
                            j5 = (long) (-(c5 - '0'));
                        } else if (c6 == 2) {
                            if (j5 == 0) {
                                return i5;
                            }
                            long j6 = (10 * j5) - ((long) (c5 - '0'));
                            int i12 = (j5 > -922337203685477580L ? 1 : (j5 == -922337203685477580L ? 0 : -1));
                            if (i12 > 0 || (i12 == 0 && j6 < j5)) {
                                i6 = 1;
                            } else {
                                i6 = i5;
                            }
                            i11 &= i6;
                            j5 = j6;
                        } else if (c6 == 3) {
                            c6 = 4;
                        } else if (c6 == 5 || c6 == 6) {
                            c6 = 7;
                        }
                    }
                } else if (c6 != 2) {
                    return i5;
                } else {
                    c6 = 3;
                }
                i10++;
                i9 = i5;
            } else {
                c7 = 6;
                if (c6 == 0) {
                    c6 = 1;
                    z4 = true;
                    i10++;
                    i9 = i5;
                } else if (c6 != 5) {
                    return i5;
                }
            }
            c6 = c7;
            i10++;
            i9 = i5;
        }
        if (z(c5)) {
            return i5;
        }
        if (c6 == 2 && i11 != 0 && ((j5 != Long.MIN_VALUE || z4) && (j5 != 0 || !z4))) {
            if (!z4) {
                j5 = -j5;
            }
            this.f15419j = j5;
            this.f15414e += i10;
            this.f15418i = 15;
            return 15;
        } else if (c6 != 2 && c6 != 4 && c6 != 7) {
            return i5;
        } else {
            this.f15420k = i10;
            this.f15418i = 16;
            return 16;
        }
    }

    private void Q(int i5) {
        int i6 = this.f15423n;
        if (i6 - 1 < this.f15412c) {
            int[] iArr = this.f15422m;
            if (i6 == iArr.length) {
                int i7 = i6 * 2;
                this.f15422m = Arrays.copyOf(iArr, i7);
                this.f15425p = Arrays.copyOf(this.f15425p, i7);
                this.f15424o = (String[]) Arrays.copyOf(this.f15424o, i7);
            }
            int[] iArr2 = this.f15422m;
            int i8 = this.f15423n;
            this.f15423n = i8 + 1;
            iArr2[i8] = i5;
            return;
        }
        throw new d("Nesting limit " + this.f15412c + " reached" + A());
    }

    private char R() {
        int i5;
        if (this.f15414e != this.f15415f || s(1)) {
            char[] cArr = this.f15413d;
            int i6 = this.f15414e;
            int i7 = i6 + 1;
            this.f15414e = i7;
            char c5 = cArr[i6];
            if (c5 != 10) {
                if (c5 != '\"') {
                    if (c5 != '\'') {
                        if (!(c5 == '/' || c5 == '\\')) {
                            if (c5 == 'b') {
                                return 8;
                            }
                            if (c5 == 'f') {
                                return 12;
                            }
                            if (c5 == 'n') {
                                return 10;
                            }
                            if (c5 == 'r') {
                                return 13;
                            }
                            if (c5 == 't') {
                                return 9;
                            }
                            if (c5 != 'u') {
                                throw Y("Invalid escape sequence");
                            } else if (i6 + 5 <= this.f15415f || s(4)) {
                                int i8 = this.f15414e;
                                int i9 = i8 + 4;
                                int i10 = 0;
                                while (i8 < i9) {
                                    char c6 = this.f15413d[i8];
                                    int i11 = i10 << 4;
                                    if (c6 >= '0' && c6 <= '9') {
                                        i5 = c6 - '0';
                                    } else if (c6 >= 'a' && c6 <= 'f') {
                                        i5 = c6 - 'W';
                                    } else if (c6 < 'A' || c6 > 'F') {
                                        throw Y("Malformed Unicode escape \\u" + new String(this.f15413d, this.f15414e, 4));
                                    } else {
                                        i5 = c6 - '7';
                                    }
                                    i10 = i11 + i5;
                                    i8++;
                                }
                                this.f15414e += 4;
                                return (char) i10;
                            } else {
                                throw Y("Unterminated escape sequence");
                            }
                        }
                    }
                }
                return c5;
            } else if (this.f15411b != r.STRICT) {
                this.f15416g++;
                this.f15417h = i7;
            } else {
                throw Y("Cannot escape a newline character in strict mode");
            }
            if (this.f15411b == r.STRICT) {
                throw Y("Invalid escaped character \"'\" in strict mode");
            }
            return c5;
        }
        throw Y("Unterminated escape sequence");
    }

    private void T(char c5) {
        char[] cArr = this.f15413d;
        do {
            int i5 = this.f15414e;
            int i6 = this.f15415f;
            while (i5 < i6) {
                int i7 = i5 + 1;
                char c6 = cArr[i5];
                if (c6 == c5) {
                    this.f15414e = i7;
                    return;
                } else if (c6 == '\\') {
                    this.f15414e = i7;
                    R();
                    i5 = this.f15414e;
                    i6 = this.f15415f;
                } else {
                    if (c6 == 10) {
                        this.f15416g++;
                        this.f15417h = i7;
                    }
                    i5 = i7;
                }
            }
            this.f15414e = i5;
        } while (s(1));
        throw Y("Unterminated string");
    }

    private boolean U(String str) {
        int length = str.length();
        while (true) {
            int i5 = 0;
            if (this.f15414e + length > this.f15415f && !s(length)) {
                return false;
            }
            char[] cArr = this.f15413d;
            int i6 = this.f15414e;
            if (cArr[i6] == 10) {
                this.f15416g++;
                this.f15417h = i6 + 1;
            } else {
                while (i5 < length) {
                    if (this.f15413d[this.f15414e + i5] == str.charAt(i5)) {
                        i5++;
                    }
                }
                return true;
            }
            this.f15414e++;
        }
    }

    private void V() {
        char c5;
        do {
            if (this.f15414e < this.f15415f || s(1)) {
                char[] cArr = this.f15413d;
                int i5 = this.f15414e;
                int i6 = i5 + 1;
                this.f15414e = i6;
                c5 = cArr[i5];
                if (c5 == 10) {
                    this.f15416g++;
                    this.f15417h = i6;
                    return;
                }
            } else {
                return;
            }
        } while (c5 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        m();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void W() {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.f15414e
            int r2 = r1 + r0
            int r3 = r4.f15415f
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.f15413d
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.m()
        L_0x004b:
            int r1 = r4.f15414e
            int r1 = r1 + r0
            r4.f15414e = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.f15414e = r1
            r0 = 1
            boolean r0 = r4.s(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.C1679a.W():void");
    }

    private d Y(String str) {
        throw new d(str + A() + "\nSee " + F.a("malformed-json"));
    }

    /* access modifiers changed from: private */
    public IllegalStateException Z(String str) {
        String str2;
        if (N() == b.NULL) {
            str2 = "adapter-not-null-safe";
        } else {
            str2 = "unexpected-json-structure";
        }
        return new IllegalStateException("Expected " + str + " but was " + N() + A() + "\nSee " + F.a(str2));
    }

    private void m() {
        if (this.f15411b != r.LENIENT) {
            throw Y("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private void n() {
        I(true);
        int i5 = this.f15414e;
        this.f15414e = i5 - 1;
        if (i5 + 4 <= this.f15415f || s(5)) {
            int i6 = this.f15414e;
            char[] cArr = this.f15413d;
            if (cArr[i6] == ')' && cArr[i6 + 1] == ']' && cArr[i6 + 2] == '}' && cArr[i6 + 3] == '\'' && cArr[i6 + 4] == 10) {
                this.f15414e = i6 + 5;
            }
        }
    }

    private boolean s(int i5) {
        int i6;
        int i7;
        char[] cArr = this.f15413d;
        int i8 = this.f15417h;
        int i9 = this.f15414e;
        this.f15417h = i8 - i9;
        int i10 = this.f15415f;
        if (i10 != i9) {
            int i11 = i10 - i9;
            this.f15415f = i11;
            System.arraycopy(cArr, i9, cArr, 0, i11);
        } else {
            this.f15415f = 0;
        }
        this.f15414e = 0;
        do {
            Reader reader = this.f15410a;
            int i12 = this.f15415f;
            int read = reader.read(cArr, i12, cArr.length - i12);
            if (read == -1) {
                return false;
            }
            i6 = this.f15415f + read;
            this.f15415f = i6;
            if (this.f15416g == 0 && (i7 = this.f15417h) == 0 && i6 > 0 && cArr[0] == 65279) {
                this.f15414e++;
                this.f15417h = i7 + 1;
                i5++;
                continue;
            }
        } while (i6 < i5);
        return true;
    }

    private String t(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i5 = 0;
        while (true) {
            int i6 = this.f15423n;
            if (i5 >= i6) {
                return sb.toString();
            }
            int i7 = this.f15422m[i5];
            switch (i7) {
                case 1:
                case 2:
                    int i8 = this.f15425p[i5];
                    if (z4 && i8 > 0 && i5 == i6 - 1) {
                        i8--;
                    }
                    sb.append('[');
                    sb.append(i8);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.f15424o[i5];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i7);
            }
            i5++;
        }
    }

    private boolean z(char c5) {
        if (c5 == 9 || c5 == 10 || c5 == 12 || c5 == 13 || c5 == ' ') {
            return false;
        }
        if (c5 != '#') {
            if (c5 == ',') {
                return false;
            }
            if (!(c5 == '/' || c5 == '=')) {
                if (c5 == '{' || c5 == '}' || c5 == ':') {
                    return false;
                }
                if (c5 != ';') {
                    switch (c5) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m();
        return false;
    }

    /* access modifiers changed from: package-private */
    public String A() {
        return " at line " + (this.f15416g + 1) + " column " + ((this.f15414e - this.f15417h) + 1) + " path " + getPath();
    }

    public boolean B() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 5) {
            this.f15418i = 0;
            int[] iArr = this.f15425p;
            int i6 = this.f15423n - 1;
            iArr[i6] = iArr[i6] + 1;
            return true;
        } else if (i5 == 6) {
            this.f15418i = 0;
            int[] iArr2 = this.f15425p;
            int i7 = this.f15423n - 1;
            iArr2[i7] = iArr2[i7] + 1;
            return false;
        } else {
            throw Z("a boolean");
        }
    }

    public double C() {
        char c5;
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 15) {
            this.f15418i = 0;
            int[] iArr = this.f15425p;
            int i6 = this.f15423n - 1;
            iArr[i6] = iArr[i6] + 1;
            return (double) this.f15419j;
        }
        if (i5 == 16) {
            this.f15421l = new String(this.f15413d, this.f15414e, this.f15420k);
            this.f15414e += this.f15420k;
        } else if (i5 == 8 || i5 == 9) {
            if (i5 == 8) {
                c5 = '\'';
            } else {
                c5 = '\"';
            }
            this.f15421l = K(c5);
        } else if (i5 == 10) {
            this.f15421l = M();
        } else if (i5 != 11) {
            throw Z("a double");
        }
        this.f15418i = 11;
        double parseDouble = Double.parseDouble(this.f15421l);
        if (this.f15411b == r.LENIENT || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f15421l = null;
            this.f15418i = 0;
            int[] iArr2 = this.f15425p;
            int i7 = this.f15423n - 1;
            iArr2[i7] = iArr2[i7] + 1;
            return parseDouble;
        }
        throw Y("JSON forbids NaN and infinities: " + parseDouble);
    }

    public int F() {
        char c5;
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 15) {
            long j5 = this.f15419j;
            int i6 = (int) j5;
            if (j5 == ((long) i6)) {
                this.f15418i = 0;
                int[] iArr = this.f15425p;
                int i7 = this.f15423n - 1;
                iArr[i7] = iArr[i7] + 1;
                return i6;
            }
            throw new NumberFormatException("Expected an int but was " + this.f15419j + A());
        }
        if (i5 == 16) {
            this.f15421l = new String(this.f15413d, this.f15414e, this.f15420k);
            this.f15414e += this.f15420k;
        } else if (i5 == 8 || i5 == 9 || i5 == 10) {
            if (i5 == 10) {
                this.f15421l = M();
            } else {
                if (i5 == 8) {
                    c5 = '\'';
                } else {
                    c5 = '\"';
                }
                this.f15421l = K(c5);
            }
            try {
                int parseInt = Integer.parseInt(this.f15421l);
                this.f15418i = 0;
                int[] iArr2 = this.f15425p;
                int i8 = this.f15423n - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw Z("an int");
        }
        this.f15418i = 11;
        double parseDouble = Double.parseDouble(this.f15421l);
        int i9 = (int) parseDouble;
        if (((double) i9) == parseDouble) {
            this.f15421l = null;
            this.f15418i = 0;
            int[] iArr3 = this.f15425p;
            int i10 = this.f15423n - 1;
            iArr3[i10] = iArr3[i10] + 1;
            return i9;
        }
        throw new NumberFormatException("Expected an int but was " + this.f15421l + A());
    }

    public long G() {
        char c5;
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 15) {
            this.f15418i = 0;
            int[] iArr = this.f15425p;
            int i6 = this.f15423n - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f15419j;
        }
        if (i5 == 16) {
            this.f15421l = new String(this.f15413d, this.f15414e, this.f15420k);
            this.f15414e += this.f15420k;
        } else if (i5 == 8 || i5 == 9 || i5 == 10) {
            if (i5 == 10) {
                this.f15421l = M();
            } else {
                if (i5 == 8) {
                    c5 = '\'';
                } else {
                    c5 = '\"';
                }
                this.f15421l = K(c5);
            }
            try {
                long parseLong = Long.parseLong(this.f15421l);
                this.f15418i = 0;
                int[] iArr2 = this.f15425p;
                int i7 = this.f15423n - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw Z("a long");
        }
        this.f15418i = 11;
        double parseDouble = Double.parseDouble(this.f15421l);
        long j5 = (long) parseDouble;
        if (((double) j5) == parseDouble) {
            this.f15421l = null;
            this.f15418i = 0;
            int[] iArr3 = this.f15425p;
            int i8 = this.f15423n - 1;
            iArr3[i8] = iArr3[i8] + 1;
            return j5;
        }
        throw new NumberFormatException("Expected a long but was " + this.f15421l + A());
    }

    public String H() {
        String str;
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 14) {
            str = M();
        } else if (i5 == 12) {
            str = K('\'');
        } else if (i5 == 13) {
            str = K('\"');
        } else {
            throw Z("a name");
        }
        this.f15418i = 0;
        this.f15424o[this.f15423n - 1] = str;
        return str;
    }

    public void J() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 7) {
            this.f15418i = 0;
            int[] iArr = this.f15425p;
            int i6 = this.f15423n - 1;
            iArr[i6] = iArr[i6] + 1;
            return;
        }
        throw Z("null");
    }

    public String L() {
        String str;
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 10) {
            str = M();
        } else if (i5 == 8) {
            str = K('\'');
        } else if (i5 == 9) {
            str = K('\"');
        } else if (i5 == 11) {
            str = this.f15421l;
            this.f15421l = null;
        } else if (i5 == 15) {
            str = Long.toString(this.f15419j);
        } else if (i5 == 16) {
            str = new String(this.f15413d, this.f15414e, this.f15420k);
            this.f15414e += this.f15420k;
        } else {
            throw Z("a string");
        }
        this.f15418i = 0;
        int[] iArr = this.f15425p;
        int i6 = this.f15423n - 1;
        iArr[i6] = iArr[i6] + 1;
        return str;
    }

    public b N() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        switch (i5) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void S(r rVar) {
        Objects.requireNonNull(rVar);
        this.f15411b = rVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r7.f15418i = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X() {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r7.f15418i
            if (r2 != 0) goto L_0x000a
            int r2 = r7.o()
        L_0x000a:
            r3 = 39
            r4 = 34
            java.lang.String r5 = "<skipped>"
            r6 = 1
            switch(r2) {
                case 1: goto L_0x006f;
                case 2: goto L_0x005f;
                case 3: goto L_0x0059;
                case 4: goto L_0x0051;
                case 5: goto L_0x0014;
                case 6: goto L_0x0014;
                case 7: goto L_0x0014;
                case 8: goto L_0x004d;
                case 9: goto L_0x0049;
                case 10: goto L_0x0045;
                case 11: goto L_0x0014;
                case 12: goto L_0x0038;
                case 13: goto L_0x002b;
                case 14: goto L_0x001e;
                case 15: goto L_0x0014;
                case 16: goto L_0x0016;
                case 17: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0074
        L_0x0015:
            return
        L_0x0016:
            int r2 = r7.f15414e
            int r3 = r7.f15420k
            int r2 = r2 + r3
            r7.f15414e = r2
            goto L_0x0074
        L_0x001e:
            r7.W()
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.f15424o
            int r3 = r7.f15423n
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x002b:
            r7.T(r4)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.f15424o
            int r3 = r7.f15423n
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0038:
            r7.T(r3)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.f15424o
            int r3 = r7.f15423n
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0045:
            r7.W()
            goto L_0x0074
        L_0x0049:
            r7.T(r4)
            goto L_0x0074
        L_0x004d:
            r7.T(r3)
            goto L_0x0074
        L_0x0051:
            int r2 = r7.f15423n
            int r2 = r2 - r6
            r7.f15423n = r2
        L_0x0056:
            int r1 = r1 + -1
            goto L_0x0074
        L_0x0059:
            r7.Q(r6)
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x0074
        L_0x005f:
            if (r1 != 0) goto L_0x0069
            java.lang.String[] r2 = r7.f15424o
            int r3 = r7.f15423n
            int r3 = r3 - r6
            r4 = 0
            r2[r3] = r4
        L_0x0069:
            int r2 = r7.f15423n
            int r2 = r2 - r6
            r7.f15423n = r2
            goto L_0x0056
        L_0x006f:
            r2 = 3
            r7.Q(r2)
            goto L_0x005c
        L_0x0074:
            r7.f15418i = r0
            if (r1 > 0) goto L_0x0002
            int[] r0 = r7.f15425p
            int r1 = r7.f15423n
            int r1 = r1 - r6
            r2 = r0[r1]
            int r2 = r2 + r6
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.C1679a.X():void");
    }

    public void close() {
        this.f15418i = 0;
        this.f15422m[0] = 8;
        this.f15423n = 1;
        this.f15410a.close();
    }

    public void d() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 3) {
            Q(1);
            this.f15425p[this.f15423n - 1] = 0;
            this.f15418i = 0;
            return;
        }
        throw Z("BEGIN_ARRAY");
    }

    public String getPath() {
        return t(false);
    }

    public void l() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 1) {
            Q(3);
            this.f15418i = 0;
            return;
        }
        throw Z("BEGIN_OBJECT");
    }

    /* access modifiers changed from: package-private */
    public int o() {
        int I4;
        int[] iArr = this.f15422m;
        int i5 = this.f15423n;
        int i6 = iArr[i5 - 1];
        if (i6 == 1) {
            iArr[i5 - 1] = 2;
        } else if (i6 == 2) {
            int I5 = I(true);
            if (I5 != 44) {
                if (I5 == 59) {
                    m();
                } else if (I5 == 93) {
                    this.f15418i = 4;
                    return 4;
                } else {
                    throw Y("Unterminated array");
                }
            }
        } else if (i6 == 3 || i6 == 5) {
            iArr[i5 - 1] = 4;
            if (i6 == 5 && (I4 = I(true)) != 44) {
                if (I4 == 59) {
                    m();
                } else if (I4 == 125) {
                    this.f15418i = 2;
                    return 2;
                } else {
                    throw Y("Unterminated object");
                }
            }
            int I6 = I(true);
            if (I6 == 34) {
                this.f15418i = 13;
                return 13;
            } else if (I6 == 39) {
                m();
                this.f15418i = 12;
                return 12;
            } else if (I6 != 125) {
                m();
                this.f15414e--;
                if (z((char) I6)) {
                    this.f15418i = 14;
                    return 14;
                }
                throw Y("Expected name");
            } else if (i6 != 5) {
                this.f15418i = 2;
                return 2;
            } else {
                throw Y("Expected name");
            }
        } else if (i6 == 4) {
            iArr[i5 - 1] = 5;
            int I7 = I(true);
            if (I7 != 58) {
                if (I7 == 61) {
                    m();
                    if (this.f15414e < this.f15415f || s(1)) {
                        char[] cArr = this.f15413d;
                        int i7 = this.f15414e;
                        if (cArr[i7] == '>') {
                            this.f15414e = i7 + 1;
                        }
                    }
                } else {
                    throw Y("Expected ':'");
                }
            }
        } else if (i6 == 6) {
            if (this.f15411b == r.LENIENT) {
                n();
            }
            this.f15422m[this.f15423n - 1] = 7;
        } else if (i6 == 7) {
            if (I(false) == -1) {
                this.f15418i = 17;
                return 17;
            }
            m();
            this.f15414e--;
        } else if (i6 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int I8 = I(true);
        if (I8 == 34) {
            this.f15418i = 9;
            return 9;
        } else if (I8 != 39) {
            if (!(I8 == 44 || I8 == 59)) {
                if (I8 == 91) {
                    this.f15418i = 3;
                    return 3;
                } else if (I8 != 93) {
                    if (I8 != 123) {
                        this.f15414e--;
                        int O4 = O();
                        if (O4 != 0) {
                            return O4;
                        }
                        int P4 = P();
                        if (P4 != 0) {
                            return P4;
                        }
                        if (z(this.f15413d[this.f15414e])) {
                            m();
                            this.f15418i = 10;
                            return 10;
                        }
                        throw Y("Expected value");
                    }
                    this.f15418i = 1;
                    return 1;
                } else if (i6 == 1) {
                    this.f15418i = 4;
                    return 4;
                }
            }
            if (i6 == 1 || i6 == 2) {
                m();
                this.f15414e--;
                this.f15418i = 7;
                return 7;
            }
            throw Y("Unexpected value");
        } else {
            m();
            this.f15418i = 8;
            return 8;
        }
    }

    public void p() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 4) {
            int i6 = this.f15423n;
            this.f15423n = i6 - 1;
            int[] iArr = this.f15425p;
            int i7 = i6 - 2;
            iArr[i7] = iArr[i7] + 1;
            this.f15418i = 0;
            return;
        }
        throw Z("END_ARRAY");
    }

    public void q() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 2) {
            int i6 = this.f15423n;
            int i7 = i6 - 1;
            this.f15423n = i7;
            this.f15424o[i7] = null;
            int[] iArr = this.f15425p;
            int i8 = i6 - 2;
            iArr[i8] = iArr[i8] + 1;
            this.f15418i = 0;
            return;
        }
        throw Z("END_OBJECT");
    }

    public String toString() {
        return getClass().getSimpleName() + A();
    }

    public String u() {
        return t(true);
    }

    public final r v() {
        return this.f15411b;
    }

    public boolean x() {
        int i5 = this.f15418i;
        if (i5 == 0) {
            i5 = o();
        }
        if (i5 == 2 || i5 == 4 || i5 == 17) {
            return false;
        }
        return true;
    }

    public final boolean y() {
        if (this.f15411b == r.LENIENT) {
            return true;
        }
        return false;
    }
}
