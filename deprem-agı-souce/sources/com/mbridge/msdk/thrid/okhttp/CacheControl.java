package com.mbridge.msdk.thrid.okhttp;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder immutable() {
            this.immutable = true;
            return this;
        }

        public Builder maxAge(int i5, TimeUnit timeUnit) {
            int i6;
            if (i5 >= 0) {
                long seconds = timeUnit.toSeconds((long) i5);
                if (seconds > 2147483647L) {
                    i6 = Integer.MAX_VALUE;
                } else {
                    i6 = (int) seconds;
                }
                this.maxAgeSeconds = i6;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i5);
        }

        public Builder maxStale(int i5, TimeUnit timeUnit) {
            int i6;
            if (i5 >= 0) {
                long seconds = timeUnit.toSeconds((long) i5);
                if (seconds > 2147483647L) {
                    i6 = Integer.MAX_VALUE;
                } else {
                    i6 = (int) seconds;
                }
                this.maxStaleSeconds = i6;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i5);
        }

        public Builder minFresh(int i5, TimeUnit timeUnit) {
            int i6;
            if (i5 >= 0) {
                long seconds = timeUnit.toSeconds((long) i5);
                if (seconds > 2147483647L) {
                    i6 = Integer.MAX_VALUE;
                } else {
                    i6 = (int) seconds;
                }
                this.minFreshSeconds = i6;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i5);
        }

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    private CacheControl(boolean z4, boolean z5, int i5, int i6, boolean z6, boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, String str) {
        this.noCache = z4;
        this.noStore = z5;
        this.maxAgeSeconds = i5;
        this.sMaxAgeSeconds = i6;
        this.isPrivate = z6;
        this.isPublic = z7;
        this.mustRevalidate = z8;
        this.maxStaleSeconds = i7;
        this.minFreshSeconds = i8;
        this.onlyIfCached = z9;
        this.noTransform = z10;
        this.immutable = z11;
        this.headerValue = str;
    }

    private String headerValue() {
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.thrid.okhttp.CacheControl parse(com.mbridge.msdk.thrid.okhttp.Headers r23) {
        /*
            r0 = r23
            int r1 = r0.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0147
            java.lang.String r2 = r0.name(r6)
            r22 = 1
            java.lang.String r4 = r0.value(r6)
            java.lang.String r5 = "Cache-Control"
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0034
            if (r8 == 0) goto L_0x0032
        L_0x0030:
            r7 = 0
            goto L_0x003d
        L_0x0032:
            r8 = r4
            goto L_0x003d
        L_0x0034:
            java.lang.String r5 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r5)
            if (r2 == 0) goto L_0x0140
            goto L_0x0030
        L_0x003d:
            r2 = 0
        L_0x003e:
            int r5 = r4.length()
            if (r2 >= r5) goto L_0x0140
            java.lang.String r5 = "=,;"
            int r5 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(r4, r2, r5)
            java.lang.String r2 = r4.substring(r2, r5)
            java.lang.String r2 = r2.trim()
            int r3 = r4.length()
            if (r5 == r3) goto L_0x009b
            char r3 = r4.charAt(r5)
            r0 = 44
            if (r3 == r0) goto L_0x009b
            char r0 = r4.charAt(r5)
            r3 = 59
            if (r0 != r3) goto L_0x0069
            goto L_0x009b
        L_0x0069:
            int r5 = r5 + 1
            int r0 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipWhitespace(r4, r5)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x008c
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x008c
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            int r3 = r3 + 1
            goto L_0x009f
        L_0x008c:
            java.lang.String r3 = ",;"
            int r3 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009f
        L_0x009b:
            int r5 = r5 + 1
            r3 = r5
            r0 = 0
        L_0x009f:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ac
            r9 = r22
        L_0x00a9:
            r5 = -1
            goto L_0x013b
        L_0x00ac:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b7
            r10 = r22
            goto L_0x00a9
        L_0x00b7:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c7
            r5 = -1
            int r0 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            r11 = r0
            goto L_0x013b
        L_0x00c7:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d7
            r5 = -1
            int r0 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            r12 = r0
            goto L_0x013b
        L_0x00d7:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e2
            r13 = r22
            goto L_0x00a9
        L_0x00e2:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ed
            r14 = r22
            goto L_0x00a9
        L_0x00ed:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f8
            r15 = r22
            goto L_0x00a9
        L_0x00f8:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x010a
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r0 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(r0, r2)
            r16 = r0
            goto L_0x00a9
        L_0x010a:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x011a
            r5 = -1
            int r0 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            r17 = r0
            goto L_0x013b
        L_0x011a:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0126
            r18 = r22
            goto L_0x013b
        L_0x0126:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0131
            r19 = r22
            goto L_0x013b
        L_0x0131:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x013b
            r20 = r22
        L_0x013b:
            r0 = r23
            r2 = r3
            goto L_0x003e
        L_0x0140:
            r5 = -1
            int r6 = r6 + 1
            r0 = r23
            goto L_0x001a
        L_0x0147:
            if (r7 != 0) goto L_0x014c
            r21 = 0
            goto L_0x014e
        L_0x014c:
            r21 = r8
        L_0x014e:
            com.mbridge.msdk.thrid.okhttp.CacheControl r8 = new com.mbridge.msdk.thrid.okhttp.CacheControl
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.CacheControl.parse(com.mbridge.msdk.thrid.okhttp.Headers):com.mbridge.msdk.thrid.okhttp.CacheControl");
    }

    public boolean immutable() {
        return this.immutable;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        String headerValue2 = headerValue();
        this.headerValue = headerValue2;
        return headerValue2;
    }

    CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }
}
