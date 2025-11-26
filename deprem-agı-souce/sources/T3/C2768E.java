package t3;

import X2.C2236c;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: t3.E  reason: case insensitive filesystem */
abstract class C2768E extends C2767D {
    public static String A(byte[] bArr) {
        t.e(bArr, "<this>");
        return new String(bArr, C2780d.f25888b);
    }

    public static byte[] B(String str) {
        t.e(str, "<this>");
        byte[] bytes = str.getBytes(C2780d.f25888b);
        t.d(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean C(String str, String str2, boolean z4) {
        t.e(str, "<this>");
        t.e(str2, "suffix");
        if (!z4) {
            return str.endsWith(str2);
        }
        return G(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean D(String str, String str2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return C(str, str2, z4);
    }

    public static boolean E(String str, String str2, boolean z4) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z4) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean F(String str, String str2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return E(str, str2, z4);
    }

    public static boolean G(String str, int i5, String str2, int i6, int i7, boolean z4) {
        t.e(str, "<this>");
        t.e(str2, "other");
        if (!z4) {
            return str.regionMatches(i5, str2, i6, i7);
        }
        return str.regionMatches(z4, i5, str2, i6, i7);
    }

    public static String H(CharSequence charSequence, int i5) {
        t.e(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i5 + '.').toString());
        } else if (i5 == 0) {
            return "";
        } else {
            int i6 = 1;
            if (i5 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i5);
                if (1 <= i5) {
                    while (true) {
                        sb.append(charSequence);
                        if (i6 == i5) {
                            break;
                        }
                        i6++;
                    }
                }
                String sb2 = sb.toString();
                t.b(sb2);
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                cArr[i7] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String I(String str, char c5, char c6, boolean z4) {
        t.e(str, "<this>");
        if (!z4) {
            String replace = str.replace(c5, c6);
            t.d(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (C2779c.f(charAt, c5, z4)) {
                charAt = c6;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String J(String str, String str2, String str3, boolean z4) {
        t.e(str, "<this>");
        t.e(str2, "oldValue");
        t.e(str3, "newValue");
        int i5 = 0;
        int b02 = C2771H.b0(str, str2, 0, z4);
        if (b02 < 0) {
            return str;
        }
        int length = str2.length();
        int c5 = C2729e.c(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i5, b02);
                sb.append(str3);
                i5 = b02 + length;
                if (b02 >= str.length() || (b02 = C2771H.b0(str, str2, b02 + c5, z4)) <= 0) {
                    sb.append(str, i5, str.length());
                    String sb2 = sb.toString();
                    t.d(sb2, "toString(...)");
                }
                sb.append(str, i5, b02);
                sb.append(str3);
                i5 = b02 + length;
                break;
            } while ((b02 = C2771H.b0(str, str2, b02 + c5, z4)) <= 0);
            sb.append(str, i5, str.length());
            String sb22 = sb.toString();
            t.d(sb22, "toString(...)");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String K(String str, char c5, char c6, boolean z4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return I(str, c5, c6, z4);
    }

    public static /* synthetic */ String L(String str, String str2, String str3, boolean z4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return J(str, str2, str3, z4);
    }

    public static final boolean M(String str, String str2, int i5, boolean z4) {
        t.e(str, "<this>");
        t.e(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2, i5);
        }
        return G(str, i5, str2, 0, str2.length(), z4);
    }

    public static boolean N(String str, String str2, boolean z4) {
        t.e(str, "<this>");
        t.e(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2);
        }
        return G(str, 0, str2, 0, str2.length(), z4);
    }

    public static /* synthetic */ boolean O(String str, String str2, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return M(str, str2, i5, z4);
    }

    public static /* synthetic */ boolean P(String str, String str2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return N(str, str2, z4);
    }

    public static int x(String str, String str2, boolean z4) {
        t.e(str, "<this>");
        t.e(str2, "other");
        if (z4) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    public static String y(char[] cArr) {
        t.e(cArr, "<this>");
        return new String(cArr);
    }

    public static String z(char[] cArr, int i5, int i6) {
        t.e(cArr, "<this>");
        C2236c.Companion.a(i5, i6, cArr.length);
        return new String(cArr, i5, i6 - i5);
    }
}
