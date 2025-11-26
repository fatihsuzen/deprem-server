package N3;

import kotlin.jvm.internal.t;
import t3.s;

public abstract class S {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f18765a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f18766b;

    static {
        String[] strArr = new String[93];
        for (int i5 = 0; i5 < 32; i5++) {
            strArr[i5] = "\\u" + e(i5 >> 12) + e(i5 >> 8) + e(i5 >> 4) + e(i5);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f18765a = strArr;
        byte[] bArr = new byte[93];
        for (int i6 = 0; i6 < 32; i6++) {
            bArr[i6] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f18766b = bArr;
    }

    public static final byte[] a() {
        return f18766b;
    }

    public static final String[] b() {
        return f18765a;
    }

    public static final void c(StringBuilder sb, String str) {
        t.e(sb, "<this>");
        t.e(str, "value");
        sb.append('\"');
        int length = str.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            String[] strArr = f18765a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append(str, i5, i6);
                sb.append(strArr[charAt]);
                i5 = i6 + 1;
            }
        }
        if (i5 != 0) {
            sb.append(str, i5, str.length());
        } else {
            sb.append(str);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        t.e(str, "<this>");
        if (s.E(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (s.E(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i5) {
        int i6;
        int i7 = i5 & 15;
        if (i7 < 10) {
            i6 = i7 + 48;
        } else {
            i6 = i7 + 87;
        }
        return (char) i6;
    }
}
