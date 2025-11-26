package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.thrid.okhttp.CacheControl;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    public static class Factory {
        private int ageSeconds = -1;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j5, Request request2, Response response) {
            this.nowMillis = j5;
            this.request = request2;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i5 = 0; i5 < size; i5++) {
                    String name = headers.name(i5);
                    String value = headers.value(i5);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.servedDate = HttpDate.parse(value);
                        this.servedDateString = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.expires = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.lastModified = HttpDate.parse(value);
                        this.lastModifiedString = value;
                    } else if (Command.HTTP_HEADER_ETAG.equalsIgnoreCase(name)) {
                        this.etag = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.ageSeconds = HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            Date date = this.servedDate;
            long j5 = 0;
            if (date != null) {
                j5 = Math.max(0, this.receivedResponseMillis - date.getTime());
            }
            int i5 = this.ageSeconds;
            if (i5 != -1) {
                j5 = Math.max(j5, TimeUnit.SECONDS.toMillis((long) i5));
            }
            long j6 = this.receivedResponseMillis;
            return j5 + (j6 - this.sentRequestMillis) + (this.nowMillis - j6);
        }

        private long computeFreshnessLifetime() {
            long j5;
            long j6;
            CacheControl cacheControl = this.cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            if (this.expires != null) {
                Date date = this.servedDate;
                if (date != null) {
                    j6 = date.getTime();
                } else {
                    j6 = this.receivedResponseMillis;
                }
                long time = this.expires.getTime() - j6;
                if (time > 0) {
                    return time;
                }
                return 0;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                Date date2 = this.servedDate;
                if (date2 != null) {
                    j5 = date2.getTime();
                } else {
                    j5 = this.sentRequestMillis;
                }
                long time2 = j5 - this.lastModified.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0;
        }

        private CacheStrategy getCandidate() {
            long j5;
            String str;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, (Response) null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, (Response) null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, (Response) null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, (Response) null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            long j6 = 0;
            if (cacheControl.minFreshSeconds() != -1) {
                j5 = TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds());
            } else {
                j5 = 0;
            }
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j6 = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j7 = j5 + cacheResponseAge;
                if (j7 < j6 + computeFreshnessLifetime) {
                    Response.Builder newBuilder = this.cacheResponse.newBuilder();
                    if (j7 >= computeFreshnessLifetime) {
                        newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy((Request) null, newBuilder.build());
                }
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else if (this.servedDate == null) {
                    return new CacheStrategy(this.request, (Response) null);
                } else {
                    str2 = this.servedDateString;
                }
                str = "If-Modified-Since";
            }
            Headers.Builder newBuilder2 = this.request.headers().newBuilder();
            Internal.instance.addLenient(newBuilder2, str, str2);
            return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
        }

        private static boolean hasConditions(Request request2) {
            if (request2.header("If-Modified-Since") == null && request2.header("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            if (this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null) {
                return true;
            }
            return false;
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            if (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) {
                return candidate;
            }
            return new CacheStrategy((Request) null, (Response) null);
        }
    }

    CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.cacheControl().isPrivate() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCacheable(com.mbridge.msdk.thrid.okhttp.Response r3, com.mbridge.msdk.thrid.okhttp.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L_0x005a
            com.mbridge.msdk.thrid.okhttp.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            com.mbridge.msdk.thrid.okhttp.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L_0x005a
            com.mbridge.msdk.thrid.okhttp.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            com.mbridge.msdk.thrid.okhttp.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L_0x0070
            com.mbridge.msdk.thrid.okhttp.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L_0x0070
            r3 = 1
            return r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.CacheStrategy.isCacheable(com.mbridge.msdk.thrid.okhttp.Response, com.mbridge.msdk.thrid.okhttp.Request):boolean");
    }
}
