package N3;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class F implements C2149t {

    /* renamed from: a  reason: collision with root package name */
    private char[] f18715a = C2135e.f18784c.d();

    /* renamed from: b  reason: collision with root package name */
    private int f18716b;

    private final void d(int i5, int i6, String str) {
        int i7;
        int length = str.length();
        while (i5 < length) {
            int f5 = f(i6, 2);
            char charAt = str.charAt(i5);
            if (charAt < S.a().length) {
                byte b5 = S.a()[charAt];
                if (b5 == 0) {
                    i7 = f5 + 1;
                    this.f18715a[f5] = (char) charAt;
                } else {
                    if (b5 == 1) {
                        String str2 = S.b()[charAt];
                        t.b(str2);
                        int f6 = f(f5, str2.length());
                        str2.getChars(0, str2.length(), this.f18715a, f6);
                        i6 = f6 + str2.length();
                        this.f18716b = i6;
                    } else {
                        char[] cArr = this.f18715a;
                        cArr[f5] = '\\';
                        cArr[f5 + 1] = (char) b5;
                        i6 = f5 + 2;
                        this.f18716b = i6;
                    }
                    i5++;
                }
            } else {
                i7 = f5 + 1;
                this.f18715a[f5] = (char) charAt;
            }
            i6 = i7;
            i5++;
        }
        int f7 = f(i6, 1);
        this.f18715a[f7] = '\"';
        this.f18716b = f7 + 1;
    }

    private final void e(int i5) {
        f(this.f18716b, i5);
    }

    private final int f(int i5, int i6) {
        int i7 = i6 + i5;
        char[] cArr = this.f18715a;
        if (cArr.length <= i7) {
            char[] copyOf = Arrays.copyOf(cArr, C2729e.c(i7, i5 * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18715a = copyOf;
        }
        return i5;
    }

    public void a(char c5) {
        e(1);
        char[] cArr = this.f18715a;
        int i5 = this.f18716b;
        this.f18716b = i5 + 1;
        cArr[i5] = c5;
    }

    public void b(String str) {
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        e(str.length() + 2);
        char[] cArr = this.f18715a;
        int i5 = this.f18716b;
        int i6 = i5 + 1;
        cArr[i5] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i6);
        int i7 = length + i6;
        int i8 = i6;
        while (i8 < i7) {
            char c5 = cArr[i8];
            if (c5 >= S.a().length || S.a()[c5] == 0) {
                i8++;
            } else {
                d(i8 - i6, i8, str);
                return;
            }
        }
        cArr[i7] = '\"';
        this.f18716b = i7 + 1;
    }

    public void c(String str) {
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        int length = str.length();
        if (length != 0) {
            e(length);
            str.getChars(0, str.length(), this.f18715a, this.f18716b);
            this.f18716b += length;
        }
    }

    public void g() {
        C2135e.f18784c.c(this.f18715a);
    }

    public String toString() {
        return new String(this.f18715a, 0, this.f18716b);
    }

    public void writeLong(long j5) {
        c(String.valueOf(j5));
    }
}
