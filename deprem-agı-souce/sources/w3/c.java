package W3;

import U3.q;
import U3.x;
import U3.z;
import Y3.d;
import Y3.e;
import com.mbridge.msdk.foundation.download.Command;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final x f19988a;

    /* renamed from: b  reason: collision with root package name */
    public final z f19989b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f19990a;

        /* renamed from: b  reason: collision with root package name */
        final x f19991b;

        /* renamed from: c  reason: collision with root package name */
        final z f19992c;

        /* renamed from: d  reason: collision with root package name */
        private Date f19993d;

        /* renamed from: e  reason: collision with root package name */
        private String f19994e;

        /* renamed from: f  reason: collision with root package name */
        private Date f19995f;

        /* renamed from: g  reason: collision with root package name */
        private String f19996g;

        /* renamed from: h  reason: collision with root package name */
        private Date f19997h;

        /* renamed from: i  reason: collision with root package name */
        private long f19998i;

        /* renamed from: j  reason: collision with root package name */
        private long f19999j;

        /* renamed from: k  reason: collision with root package name */
        private String f20000k;

        /* renamed from: l  reason: collision with root package name */
        private int f20001l = -1;

        public a(long j5, x xVar, z zVar) {
            this.f19990a = j5;
            this.f19991b = xVar;
            this.f19992c = zVar;
            if (zVar != null) {
                this.f19998i = zVar.B();
                this.f19999j = zVar.z();
                q q5 = zVar.q();
                int e5 = q5.e();
                for (int i5 = 0; i5 < e5; i5++) {
                    String c5 = q5.c(i5);
                    String f5 = q5.f(i5);
                    if ("Date".equalsIgnoreCase(c5)) {
                        this.f19993d = d.b(f5);
                        this.f19994e = f5;
                    } else if ("Expires".equalsIgnoreCase(c5)) {
                        this.f19997h = d.b(f5);
                    } else if ("Last-Modified".equalsIgnoreCase(c5)) {
                        this.f19995f = d.b(f5);
                        this.f19996g = f5;
                    } else if (Command.HTTP_HEADER_ETAG.equalsIgnoreCase(c5)) {
                        this.f20000k = f5;
                    } else if ("Age".equalsIgnoreCase(c5)) {
                        this.f20001l = e.f(f5, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f19993d;
            long j5 = 0;
            if (date != null) {
                j5 = Math.max(0, this.f19999j - date.getTime());
            }
            int i5 = this.f20001l;
            if (i5 != -1) {
                j5 = Math.max(j5, TimeUnit.SECONDS.toMillis((long) i5));
            }
            long j6 = this.f19999j;
            return j5 + (j6 - this.f19998i) + (this.f19990a - j6);
        }

        private long b() {
            long j5;
            long j6;
            U3.d d5 = this.f19992c.d();
            if (d5.e() != -1) {
                return TimeUnit.SECONDS.toMillis((long) d5.e());
            }
            if (this.f19997h != null) {
                Date date = this.f19993d;
                if (date != null) {
                    j6 = date.getTime();
                } else {
                    j6 = this.f19999j;
                }
                long time = this.f19997h.getTime() - j6;
                if (time > 0) {
                    return time;
                }
                return 0;
            }
            if (this.f19995f != null && this.f19992c.A().i().x() == null) {
                Date date2 = this.f19993d;
                if (date2 != null) {
                    j5 = date2.getTime();
                } else {
                    j5 = this.f19998i;
                }
                long time2 = j5 - this.f19995f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0;
        }

        private c d() {
            long j5;
            String str;
            if (this.f19992c == null) {
                return new c(this.f19991b, (z) null);
            }
            if (this.f19991b.f() && this.f19992c.n() == null) {
                return new c(this.f19991b, (z) null);
            }
            if (!c.a(this.f19992c, this.f19991b)) {
                return new c(this.f19991b, (z) null);
            }
            U3.d b5 = this.f19991b.b();
            if (b5.i() || e(this.f19991b)) {
                return new c(this.f19991b, (z) null);
            }
            U3.d d5 = this.f19992c.d();
            if (d5.b()) {
                return new c((x) null, this.f19992c);
            }
            long a5 = a();
            long b6 = b();
            if (b5.e() != -1) {
                b6 = Math.min(b6, TimeUnit.SECONDS.toMillis((long) b5.e()));
            }
            long j6 = 0;
            if (b5.g() != -1) {
                j5 = TimeUnit.SECONDS.toMillis((long) b5.g());
            } else {
                j5 = 0;
            }
            if (!d5.h() && b5.f() != -1) {
                j6 = TimeUnit.SECONDS.toMillis((long) b5.f());
            }
            if (!d5.i()) {
                long j7 = j5 + a5;
                if (j7 < j6 + b6) {
                    z.a v5 = this.f19992c.v();
                    if (j7 >= b6) {
                        v5.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a5 > 86400000 && f()) {
                        v5.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c((x) null, v5.c());
                }
            }
            String str2 = this.f20000k;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f19995f != null) {
                    str2 = this.f19996g;
                } else if (this.f19993d == null) {
                    return new c(this.f19991b, (z) null);
                } else {
                    str2 = this.f19994e;
                }
                str = "If-Modified-Since";
            }
            q.a d6 = this.f19991b.d().d();
            V3.a.f19697a.b(d6, str, str2);
            return new c(this.f19991b.h().d(d6.d()).a(), this.f19992c);
        }

        private static boolean e(x xVar) {
            if (xVar.c("If-Modified-Since") == null && xVar.c("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        private boolean f() {
            if (this.f19992c.d().e() == -1 && this.f19997h == null) {
                return true;
            }
            return false;
        }

        public c c() {
            c d5 = d();
            if (d5.f19988a == null || !this.f19991b.b().k()) {
                return d5;
            }
            return new c((x) null, (z) null);
        }
    }

    c(x xVar, z zVar) {
        this.f19988a = xVar;
        this.f19989b = zVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.d().c() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(U3.z r3, U3.x r4) {
        /*
            int r0 = r3.m()
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
            java.lang.String r0 = r3.o(r0)
            if (r0 != 0) goto L_0x005a
            U3.d r0 = r3.d()
            int r0 = r0.e()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            U3.d r0 = r3.d()
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x005a
            U3.d r0 = r3.d()
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            U3.d r3 = r3.d()
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x0070
            U3.d r3 = r4.b()
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x0070
            r3 = 1
            return r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.c.a(U3.z, U3.x):boolean");
    }
}
