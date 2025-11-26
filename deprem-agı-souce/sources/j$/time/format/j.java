package j$.time.format;

import j$.time.temporal.a;
import j$.util.Objects;

public final class j implements f {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f1113d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e  reason: collision with root package name */
    public static final j f1114e = new j("+HH:MM:ss", "Z");

    /* renamed from: a  reason: collision with root package name */
    public final String f1115a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1116b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1117c;

    static {
        new j("+HH:MM:ss", "0");
    }

    public j(String str, String str2) {
        Objects.requireNonNull(str, "pattern");
        Objects.requireNonNull(str2, "noOffsetText");
        for (int i5 = 0; i5 < 22; i5++) {
            if (f1113d[i5].equals(str)) {
                this.f1116b = i5;
                this.f1117c = i5 % 11;
                this.f1115a = str2;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
    }

    public final boolean e(p pVar, StringBuilder sb) {
        String str;
        Long a5 = pVar.a(a.OFFSET_SECONDS);
        boolean z4 = false;
        if (a5 == null) {
            return false;
        }
        long longValue = a5.longValue();
        int i5 = (int) longValue;
        if (longValue == ((long) i5)) {
            String str2 = this.f1115a;
            if (i5 == 0) {
                sb.append(str2);
                return true;
            }
            int abs = Math.abs((i5 / 3600) % 100);
            int abs2 = Math.abs((i5 / 60) % 60);
            int abs3 = Math.abs(i5 % 60);
            int length = sb.length();
            if (i5 < 0) {
                str = "-";
            } else {
                str = "+";
            }
            sb.append(str);
            if (this.f1116b >= 11 && abs < 10) {
                sb.append((char) (abs + 48));
            } else {
                a(false, abs, sb);
            }
            int i6 = this.f1117c;
            if ((i6 >= 3 && i6 <= 8) || ((i6 >= 9 && abs3 > 0) || (i6 >= 1 && abs2 > 0))) {
                a(i6 > 0 && i6 % 2 == 0, abs2, sb);
                abs += abs2;
                if (i6 == 7 || i6 == 8 || (i6 >= 5 && abs3 > 0)) {
                    if (i6 > 0 && i6 % 2 == 0) {
                        z4 = true;
                    }
                    a(z4, abs3, sb);
                    abs += abs3;
                }
            }
            if (abs == 0) {
                sb.setLength(length);
                sb.append(str2);
            }
            return true;
        }
        throw new ArithmeticException();
    }

    public static void a(boolean z4, int i5, StringBuilder sb) {
        sb.append(z4 ? ":" : "");
        sb.append((char) ((i5 / 10) + 48));
        sb.append((char) ((i5 % 10) + 48));
    }

    public final String toString() {
        String replace = this.f1115a.replace("'", "''");
        String str = f1113d[this.f1116b];
        return "Offset(" + str + ",'" + replace + "')";
    }
}
