package j$.util;

import java.util.Arrays;

public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1852a = "";

    /* renamed from: b  reason: collision with root package name */
    public final String f1853b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1854c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f1855d;

    /* renamed from: e  reason: collision with root package name */
    public int f1856e;

    /* renamed from: f  reason: collision with root package name */
    public int f1857f;

    public v0(CharSequence charSequence) {
        Objects.requireNonNull("", "The prefix must not be null");
        Objects.requireNonNull(charSequence, "The delimiter must not be null");
        Objects.requireNonNull("", "The suffix must not be null");
        this.f1853b = charSequence.toString();
        this.f1854c = "";
    }

    public static int c(String str, char[] cArr, int i5) {
        int length = str.length();
        str.getChars(0, length, cArr, i5);
        return length;
    }

    public final String toString() {
        String[] strArr = this.f1855d;
        int i5 = this.f1856e;
        String str = this.f1852a;
        int length = str.length();
        String str2 = this.f1854c;
        int length2 = str2.length() + length;
        if (length2 == 0) {
            b();
            return i5 == 0 ? "" : strArr[0];
        }
        char[] cArr = new char[(this.f1857f + length2)];
        int c5 = c(str, cArr, 0);
        if (i5 > 0) {
            int c6 = c(strArr[0], cArr, c5) + c5;
            for (int i6 = 1; i6 < i5; i6++) {
                int c7 = c(this.f1853b, cArr, c6) + c6;
                c6 = c(strArr[i6], cArr, c7) + c7;
            }
            c5 = c6;
        }
        c(str2, cArr, c5);
        return new String(cArr);
    }

    public final void a(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        String[] strArr = this.f1855d;
        if (strArr == null) {
            this.f1855d = new String[8];
        } else {
            int i5 = this.f1856e;
            if (i5 == strArr.length) {
                this.f1855d = (String[]) Arrays.copyOf(strArr, i5 * 2);
            }
            this.f1857f = this.f1853b.length() + this.f1857f;
        }
        this.f1857f = valueOf.length() + this.f1857f;
        String[] strArr2 = this.f1855d;
        int i6 = this.f1856e;
        this.f1856e = i6 + 1;
        strArr2[i6] = valueOf;
    }

    public final void b() {
        String[] strArr;
        if (this.f1856e > 1) {
            char[] cArr = new char[this.f1857f];
            int c5 = c(this.f1855d[0], cArr, 0);
            int i5 = 1;
            do {
                int c6 = c(this.f1853b, cArr, c5) + c5;
                c5 = c(this.f1855d[i5], cArr, c6) + c6;
                strArr = this.f1855d;
                strArr[i5] = null;
                i5++;
            } while (i5 < this.f1856e);
            this.f1856e = 1;
            strArr[0] = new String(cArr);
        }
    }
}
