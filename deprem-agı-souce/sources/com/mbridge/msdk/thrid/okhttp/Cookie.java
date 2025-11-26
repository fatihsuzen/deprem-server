package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {
        String domain;
        long expiresAt = HttpDate.MAX_DATE;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = "/";
        boolean persistent;
        boolean secure;
        String value;

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder expiresAt(long j5) {
            if (j5 <= 0) {
                j5 = Long.MIN_VALUE;
            }
            if (j5 > HttpDate.MAX_DATE) {
                j5 = 253402300799999L;
            }
            this.expiresAt = j5;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder path(String str) {
            if (str.startsWith("/")) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        private Builder domain(String str, boolean z4) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.domain = canonicalizeHost;
                    this.hostOnly = z4;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }
    }

    private Cookie(String str, String str2, long j5, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j5;
        this.domain = str3;
        this.path = str4;
        this.secure = z4;
        this.httpOnly = z5;
        this.hostOnly = z6;
        this.persistent = z7;
    }

    private static int dateCharacterOffset(String str, int i5, int i6, boolean z4) {
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

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.verifyAsIpAddress(str)) {
            return false;
        }
        return true;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            Cookie parse = parse(httpUrl, values.get(i5));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return DesugarCollections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    private static String parseDomain(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                return canonicalizeHost;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i5, int i6) {
        int dateCharacterOffset = dateCharacterOffset(str, i5, i6, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        while (dateCharacterOffset < i6) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i6, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i8 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
                i11 = Integer.parseInt(matcher.group(2));
                i12 = Integer.parseInt(matcher.group(3));
            } else if (i9 != -1 || !matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                if (i10 == -1) {
                    Pattern pattern = MONTH_PATTERN;
                    if (matcher.usePattern(pattern).matches()) {
                        i10 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i7 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i7 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i9 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i6, false);
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
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
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

    private static long parseMaxAge(String str) {
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

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str)) {
            return false;
        }
        if (!str.endsWith("/") && encodedPath.charAt(str.length()) != '/') {
            return false;
        }
        return true;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            return true;
        }
        return false;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        long j5 = this.expiresAt;
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.secure ^ true ? 1 : 0)) * 31) + (this.httpOnly ^ true ? 1 : 0)) * 31) + (this.persistent ^ true ? 1 : 0)) * 31) + (this.hostOnly ^ true ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean z4;
        if (this.hostOnly) {
            z4 = httpUrl.host().equals(this.domain);
        } else {
            z4 = domainMatch(httpUrl.host(), this.domain);
        }
        if (!z4 || !pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString(false);
    }

    public String value() {
        return this.value;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.mbridge.msdk.thrid.okhttp.Cookie parse(long r26, com.mbridge.msdk.thrid.okhttp.HttpUrl r28, java.lang.String r29) {
        /*
            r0 = r29
            int r1 = r0.length()
            r2 = 0
            r3 = 59
            int r4 = com.mbridge.msdk.thrid.okhttp.internal.Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r1, (char) r3)
            r5 = 61
            int r6 = com.mbridge.msdk.thrid.okhttp.internal.Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = com.mbridge.msdk.thrid.okhttp.internal.Util.trimSubstring(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0028
            int r8 = com.mbridge.msdk.thrid.okhttp.internal.Util.indexOfControlOrNonAscii(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002c
        L_0x0028:
            r16 = r7
            goto L_0x0141
        L_0x002c:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = com.mbridge.msdk.thrid.okhttp.internal.Util.trimSubstring(r0, r6, r4)
            int r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.indexOfControlOrNonAscii(r6)
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
            int r10 = com.mbridge.msdk.thrid.okhttp.internal.Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r1, (char) r3)
            int r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r10, (char) r5)
            java.lang.String r4 = com.mbridge.msdk.thrid.okhttp.internal.Util.trimSubstring(r0, r4, r11)
            if (r11 >= r10) goto L_0x0068
            int r11 = r11 + 1
            java.lang.String r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.trimSubstring(r0, r11, r10)
            goto L_0x006a
        L_0x0068:
            java.lang.String r11 = ""
        L_0x006a:
            java.lang.String r3 = "expires"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x007d
            int r3 = r11.length()     // Catch:{ IllegalArgumentException -> 0x00b8 }
            long r22 = parseExpires(r11, r2, r3)     // Catch:{ IllegalArgumentException -> 0x00b8 }
        L_0x007a:
            r21 = 1
            goto L_0x00b8
        L_0x007d:
            java.lang.String r3 = "max-age"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x008a
            long r14 = parseMaxAge(r11)     // Catch:{  }
            goto L_0x007a
        L_0x008a:
            java.lang.String r3 = "domain"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0099
            java.lang.String r7 = parseDomain(r11)     // Catch:{ IllegalArgumentException -> 0x00b8 }
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
            java.lang.String r0 = r28.host()
            if (r7 != 0) goto L_0x00f6
            r13 = r0
            goto L_0x00fe
        L_0x00f6:
            boolean r1 = domainMatch(r0, r7)
            if (r1 != 0) goto L_0x00fd
            return r16
        L_0x00fd:
            r13 = r7
        L_0x00fe:
            int r0 = r0.length()
            int r1 = r13.length()
            if (r0 == r1) goto L_0x0113
            com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase r0 = com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase.get()
            java.lang.String r0 = r0.getEffectiveTldPlusOne(r13)
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
            java.lang.String r1 = r28.encodedPath()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x0130
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x0130:
            r8 = r0
            goto L_0x011e
        L_0x0132:
            com.mbridge.msdk.thrid.okhttp.Cookie r8 = new com.mbridge.msdk.thrid.okhttp.Cookie
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.Cookie.parse(long, com.mbridge.msdk.thrid.okhttp.HttpUrl, java.lang.String):com.mbridge.msdk.thrid.okhttp.Cookie");
    }

    /* access modifiers changed from: package-private */
    public String toString(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    Cookie(Builder builder) {
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
