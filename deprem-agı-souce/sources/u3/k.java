package U3;

import V3.c;
import Y3.d;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f19526j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f19527k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f19528l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f19529m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f19530a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19531b;

    /* renamed from: c  reason: collision with root package name */
    private final long f19532c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19533d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19534e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19535f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f19536g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f19537h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f19538i;

    private k(String str, String str2, long j5, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f19530a = str;
        this.f19531b = str2;
        this.f19532c = j5;
        this.f19533d = str3;
        this.f19534e = str4;
        this.f19535f = z4;
        this.f19536g = z5;
        this.f19538i = z6;
        this.f19537h = z7;
    }

    private static int a(String str, int i5, int i6, boolean z4) {
        boolean z5;
        while (i5 < i6) {
            char charAt = str.charAt(i5);
            if ((charAt >= ' ' || charAt == 9) && charAt < 127 && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5 == (!z4)) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || c.D(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static U3.k d(long r26, U3.r r28, java.lang.String r29) {
        /*
            r0 = r29
            int r1 = r0.length()
            r2 = 0
            r3 = 59
            int r4 = V3.c.k(r0, r2, r1, r3)
            r5 = 61
            int r6 = V3.c.k(r0, r2, r4, r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = V3.c.C(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0028
            int r8 = V3.c.t(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002c
        L_0x0028:
            r16 = r7
            goto L_0x0141
        L_0x002c:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = V3.c.C(r0, r6, r4)
            int r11 = V3.c.t(r6)
            if (r11 == r10) goto L_0x0039
            return r7
        L_0x0039:
            int r4 = r4 + r8
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r18 = r2
            r19 = r18
            r21 = r19
            r16 = r7
            r20 = r8
            r22 = r12
            r14 = -1
            r8 = r16
        L_0x004f:
            if (r4 >= r1) goto L_0x00bd
            r24 = -1
            int r10 = V3.c.k(r0, r4, r1, r3)
            int r11 = V3.c.k(r0, r4, r10, r5)
            java.lang.String r4 = V3.c.C(r0, r4, r11)
            if (r11 >= r10) goto L_0x0068
            int r11 = r11 + 1
            java.lang.String r11 = V3.c.C(r0, r11, r10)
            goto L_0x006a
        L_0x0068:
            java.lang.String r11 = ""
        L_0x006a:
            java.lang.String r3 = "expires"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x007d
            int r3 = r11.length()     // Catch:{ IllegalArgumentException -> 0x00b8 }
            long r22 = h(r11, r2, r3)     // Catch:{ IllegalArgumentException -> 0x00b8 }
        L_0x007a:
            r21 = 1
            goto L_0x00b8
        L_0x007d:
            java.lang.String r3 = "max-age"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x008a
            long r14 = i(r11)     // Catch:{  }
            goto L_0x007a
        L_0x008a:
            java.lang.String r3 = "domain"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0099
            java.lang.String r7 = g(r11)     // Catch:{ IllegalArgumentException -> 0x00b8 }
            r20 = r2
            goto L_0x00b8
        L_0x0099:
            java.lang.String r3 = "path"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a3
            r8 = r11
            goto L_0x00b8
        L_0x00a3:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00ae
            r18 = 1
            goto L_0x00b8
        L_0x00ae:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b8
            r19 = 1
        L_0x00b8:
            int r4 = r10 + 1
            r3 = 59
            goto L_0x004f
        L_0x00bd:
            r24 = -1
            r0 = -9223372036854775808
            int r3 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c7
            r11 = r0
            goto L_0x00ee
        L_0x00c7:
            int r0 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x00ec
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x00d8
            r0 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 * r0
            goto L_0x00dd
        L_0x00d8:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00dd:
            long r14 = r26 + r14
            int r0 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r0 < 0) goto L_0x00ea
            int r0 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r11 = r14
            goto L_0x00ee
        L_0x00ea:
            r11 = r12
            goto L_0x00ee
        L_0x00ec:
            r11 = r22
        L_0x00ee:
            java.lang.String r0 = r28.k()
            if (r7 != 0) goto L_0x00f6
            r13 = r0
            goto L_0x00fe
        L_0x00f6:
            boolean r1 = b(r0, r7)
            if (r1 != 0) goto L_0x00fd
            return r16
        L_0x00fd:
            r13 = r7
        L_0x00fe:
            int r0 = r0.length()
            int r1 = r13.length()
            if (r0 == r1) goto L_0x0113
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.c()
            java.lang.String r0 = r0.d(r13)
            if (r0 != 0) goto L_0x0113
            return r16
        L_0x0113:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x0120
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011e
            goto L_0x0120
        L_0x011e:
            r14 = r8
            goto L_0x0132
        L_0x0120:
            java.lang.String r1 = r28.g()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x0130
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x0130:
            r8 = r0
            goto L_0x011e
        L_0x0132:
            U3.k r8 = new U3.k
            r10 = r6
            r15 = r18
            r16 = r19
            r17 = r20
            r18 = r21
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r8
        L_0x0141:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.k.d(long, U3.r, java.lang.String):U3.k");
    }

    public static k e(r rVar, String str) {
        return d(System.currentTimeMillis(), rVar, str);
    }

    public static List f(r rVar, q qVar) {
        List g5 = qVar.g("Set-Cookie");
        int size = g5.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            k e5 = e(rVar, (String) g5.get(i5));
            if (e5 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e5);
            }
        }
        if (arrayList != null) {
            return DesugarCollections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    private static String g(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String b5 = c.b(str);
            if (b5 != null) {
                return b5;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long h(String str, int i5, int i6) {
        int a5 = a(str, i5, i6, false);
        Matcher matcher = f19529m.matcher(str);
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        while (a5 < i6) {
            int a6 = a(str, a5 + 1, i6, true);
            matcher.region(a5, a6);
            if (i8 == -1 && matcher.usePattern(f19529m).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
                i11 = Integer.parseInt(matcher.group(2));
                i12 = Integer.parseInt(matcher.group(3));
            } else if (i9 != -1 || !matcher.usePattern(f19528l).matches()) {
                if (i10 == -1) {
                    Pattern pattern = f19527k;
                    if (matcher.usePattern(pattern).matches()) {
                        i10 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i7 == -1 && matcher.usePattern(f19526j).matches()) {
                    i7 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i9 = Integer.parseInt(matcher.group(1));
            }
            a5 = a(str, a6 + 1, i6, false);
        }
        if (i7 >= 70 && i7 <= 99) {
            i7 += 1900;
        }
        if (i7 >= 0 && i7 <= 69) {
            i7 += 2000;
        }
        if (i7 < 1601) {
            throw new IllegalArgumentException();
        } else if (i10 == -1) {
            throw new IllegalArgumentException();
        } else if (i9 < 1 || i9 > 31) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 23) {
            throw new IllegalArgumentException();
        } else if (i11 < 0 || i11 > 59) {
            throw new IllegalArgumentException();
        } else if (i12 < 0 || i12 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.f19714p);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i7);
            gregorianCalendar.set(2, i10 - 1);
            gregorianCalendar.set(5, i9);
            gregorianCalendar.set(11, i8);
            gregorianCalendar.set(12, i11);
            gregorianCalendar.set(13, i12);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e5) {
            if (!str.matches("-?\\d+")) {
                throw e5;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    public String c() {
        return this.f19530a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (kVar.f19530a.equals(this.f19530a) && kVar.f19531b.equals(this.f19531b) && kVar.f19533d.equals(this.f19533d) && kVar.f19534e.equals(this.f19534e) && kVar.f19532c == this.f19532c && kVar.f19535f == this.f19535f && kVar.f19536g == this.f19536g && kVar.f19537h == this.f19537h && kVar.f19538i == this.f19538i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f19532c;
        return ((((((((((((((((527 + this.f19530a.hashCode()) * 31) + this.f19531b.hashCode()) * 31) + this.f19533d.hashCode()) * 31) + this.f19534e.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.f19535f ^ true ? 1 : 0)) * 31) + (this.f19536g ^ true ? 1 : 0)) * 31) + (this.f19537h ^ true ? 1 : 0)) * 31) + (this.f19538i ^ true ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public String j(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19530a);
        sb.append('=');
        sb.append(this.f19531b);
        if (this.f19537h) {
            if (this.f19532c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(d.a(new Date(this.f19532c)));
            }
        }
        if (!this.f19538i) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.f19533d);
        }
        sb.append("; path=");
        sb.append(this.f19534e);
        if (this.f19535f) {
            sb.append("; secure");
        }
        if (this.f19536g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f19531b;
    }

    public String toString() {
        return j(false);
    }
}
