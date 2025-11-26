package h1;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* renamed from: h1.a  reason: case insensitive filesystem */
public abstract class C1671a {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f15366a = DesugarTimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i5, char c5) {
        if (i5 >= str.length() || str.charAt(i5) != c5) {
            return false;
        }
        return true;
    }

    private static int b(String str, int i5) {
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            if (charAt < '0' || charAt > '9') {
                return i5;
            }
            i5++;
        }
        return str.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00df A[Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c3 A[Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date c(java.lang.String r18, java.text.ParsePosition r19) {
        /*
            r1 = r18
            r2 = r19
            int r0 = r2.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r3 = r0 + 4
            int r4 = d(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r5 = 45
            boolean r6 = a(r1, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r7 = 5
            if (r6 == 0) goto L_0x0019
            int r3 = r0 + 5
        L_0x0019:
            int r0 = r3 + 2
            int r6 = d(r1, r3, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r8 = a(r1, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r8 == 0) goto L_0x0027
            int r0 = r3 + 3
        L_0x0027:
            int r3 = r0 + 2
            int r8 = d(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r9 = 84
            boolean r9 = a(r1, r3, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r10 = 1
            r11 = 0
            if (r9 != 0) goto L_0x0054
            int r12 = r1.length()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 > r3) goto L_0x0054
            java.util.GregorianCalendar r0 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r6 = r6 - r10
            r0.<init>(r4, r6, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0.setLenient(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r2.setIndex(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.util.Date r0 = r0.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            return r0
        L_0x004e:
            r0 = move-exception
            goto L_0x01cb
        L_0x0051:
            r0 = move-exception
            goto L_0x01cb
        L_0x0054:
            r12 = 43
            r13 = 90
            r14 = 2
            if (r9 == 0) goto L_0x00d6
            int r3 = r0 + 3
            int r9 = r0 + 5
            int r3 = d(r1, r3, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r15 = 58
            boolean r16 = a(r1, r9, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r16 == 0) goto L_0x006d
            int r9 = r0 + 6
        L_0x006d:
            int r0 = r9 + 2
            int r16 = d(r1, r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r15 = a(r1, r0, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r15 == 0) goto L_0x007c
            int r9 = r9 + 3
            r0 = r9
        L_0x007c:
            int r9 = r1.length()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r9 <= r0) goto L_0x00ce
            char r9 = r1.charAt(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r9 == r13) goto L_0x00ce
            if (r9 == r12) goto L_0x00ce
            if (r9 == r5) goto L_0x00ce
            int r9 = r0 + 2
            int r15 = d(r1, r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r11 = 59
            if (r15 <= r11) goto L_0x009c
            r11 = 63
            if (r15 >= r11) goto L_0x009c
            r15 = 59
        L_0x009c:
            r11 = 46
            boolean r11 = a(r1, r9, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r11 == 0) goto L_0x00c8
            int r9 = r0 + 3
            int r11 = r0 + 4
            int r11 = b(r1, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r0 = r0 + 6
            int r0 = java.lang.Math.min(r11, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r17 = d(r1, r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r0 = r0 - r9
            if (r0 == r10) goto L_0x00bf
            if (r0 == r14) goto L_0x00bc
            goto L_0x00c1
        L_0x00bc:
            int r17 = r17 * 10
            goto L_0x00c1
        L_0x00bf:
            int r17 = r17 * 100
        L_0x00c1:
            r0 = r3
            r3 = r11
            r9 = r16
            r11 = r17
            goto L_0x00d9
        L_0x00c8:
            r0 = r3
            r3 = r9
            r9 = r16
            r11 = 0
            goto L_0x00d9
        L_0x00ce:
            r9 = r3
            r3 = r0
            r0 = r9
            r9 = r16
        L_0x00d3:
            r11 = 0
            r15 = 0
            goto L_0x00d9
        L_0x00d6:
            r0 = 0
            r9 = 0
            goto L_0x00d3
        L_0x00d9:
            int r14 = r1.length()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r14 <= r3) goto L_0x01c3
            char r14 = r1.charAt(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r14 != r13) goto L_0x00ea
            java.util.TimeZone r5 = f15366a     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r3 = r3 + r10
            goto L_0x0192
        L_0x00ea:
            if (r14 == r12) goto L_0x010b
            if (r14 != r5) goto L_0x00ef
            goto L_0x010b
        L_0x00ef:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = "Invalid time zone indicator '"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x010b:
            java.lang.String r5 = r1.substring(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r12 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 < r7) goto L_0x0116
            goto L_0x0127
        L_0x0116:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r5 = "00"
            r12.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r5 = r12.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x0127:
            int r12 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r3 = r3 + r12
            java.lang.String r12 = "+0000"
            boolean r12 = r5.equals(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 != 0) goto L_0x0190
            java.lang.String r12 = "+00:00"
            boolean r12 = r5.equals(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 == 0) goto L_0x013d
            goto L_0x0190
        L_0x013d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r13 = "GMT"
            r12.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r5 = r12.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.util.TimeZone r12 = j$.util.DesugarTimeZone.getTimeZone(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r13 = r12.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r14 = r13.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r14 != 0) goto L_0x018e
            java.lang.String r14 = ":"
            java.lang.String r7 = ""
            java.lang.String r7 = r13.replace(r14, r7)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r7 = r7.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r7 == 0) goto L_0x016b
            goto L_0x018e
        L_0x016b:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = "Mismatching time zone indicator: "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = " given, resolves to "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = r12.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x018e:
            r5 = r12
            goto L_0x0192
        L_0x0190:
            java.util.TimeZone r5 = f15366a     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x0192:
            java.util.GregorianCalendar r7 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r7.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r5 = 0
            r7.setLenient(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r7.set(r10, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r6 = r6 - r10
            r4 = 2
            r7.set(r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r4 = 5
            r7.set(r4, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r4 = 11
            r7.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0 = 12
            r7.set(r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0 = 13
            r7.set(r0, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0 = 14
            r7.set(r0, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            r2.setIndex(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.util.Date r0 = r7.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            return r0
        L_0x01c3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x01cb:
            if (r1 != 0) goto L_0x01cf
            r1 = 0
            goto L_0x01e3
        L_0x01cf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 34
            r3.append(r4)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x01e3:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01ef
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x020d
        L_0x01ef:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "("
            r3.append(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x020d:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r2.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.C1671a.c(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int d(String str, int i5, int i6) {
        int i7;
        int i8;
        if (i5 < 0 || i6 > str.length() || i5 > i6) {
            throw new NumberFormatException(str);
        }
        if (i5 < i6) {
            i8 = i5 + 1;
            int digit = Character.digit(str.charAt(i5), 10);
            if (digit >= 0) {
                i7 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i5, i6));
            }
        } else {
            i7 = 0;
            i8 = i5;
        }
        while (i8 < i6) {
            int i9 = i8 + 1;
            int digit2 = Character.digit(str.charAt(i8), 10);
            if (digit2 >= 0) {
                i7 = (i7 * 10) - digit2;
                i8 = i9;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i5, i6));
            }
        }
        return -i7;
    }
}
