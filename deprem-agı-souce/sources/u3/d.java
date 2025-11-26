package U3;

import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: n  reason: collision with root package name */
    public static final d f19364n = new a().c().a();

    /* renamed from: o  reason: collision with root package name */
    public static final d f19365o = new a().e().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f19366a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19367b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19368c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19369d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f19370e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19371f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f19372g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19373h;

    /* renamed from: i  reason: collision with root package name */
    private final int f19374i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f19375j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f19376k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f19377l;

    /* renamed from: m  reason: collision with root package name */
    String f19378m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f19379a;

        /* renamed from: b  reason: collision with root package name */
        boolean f19380b;

        /* renamed from: c  reason: collision with root package name */
        int f19381c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f19382d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f19383e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f19384f;

        /* renamed from: g  reason: collision with root package name */
        boolean f19385g;

        /* renamed from: h  reason: collision with root package name */
        boolean f19386h;

        public d a() {
            return new d(this);
        }

        public a b(int i5, TimeUnit timeUnit) {
            int i6;
            if (i5 >= 0) {
                long seconds = timeUnit.toSeconds((long) i5);
                if (seconds > 2147483647L) {
                    i6 = Integer.MAX_VALUE;
                } else {
                    i6 = (int) seconds;
                }
                this.f19382d = i6;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i5);
        }

        public a c() {
            this.f19379a = true;
            return this;
        }

        public a d() {
            this.f19380b = true;
            return this;
        }

        public a e() {
            this.f19384f = true;
            return this;
        }
    }

    private d(boolean z4, boolean z5, int i5, int i6, boolean z6, boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, String str) {
        this.f19366a = z4;
        this.f19367b = z5;
        this.f19368c = i5;
        this.f19369d = i6;
        this.f19370e = z6;
        this.f19371f = z7;
        this.f19372g = z8;
        this.f19373h = i7;
        this.f19374i = i8;
        this.f19375j = z9;
        this.f19376k = z10;
        this.f19377l = z11;
        this.f19378m = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f19366a) {
            sb.append("no-cache, ");
        }
        if (this.f19367b) {
            sb.append("no-store, ");
        }
        if (this.f19368c != -1) {
            sb.append("max-age=");
            sb.append(this.f19368c);
            sb.append(", ");
        }
        if (this.f19369d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f19369d);
            sb.append(", ");
        }
        if (this.f19370e) {
            sb.append("private, ");
        }
        if (this.f19371f) {
            sb.append("public, ");
        }
        if (this.f19372g) {
            sb.append("must-revalidate, ");
        }
        if (this.f19373h != -1) {
            sb.append("max-stale=");
            sb.append(this.f19373h);
            sb.append(", ");
        }
        if (this.f19374i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f19374i);
            sb.append(", ");
        }
        if (this.f19375j) {
            sb.append("only-if-cached, ");
        }
        if (this.f19376k) {
            sb.append("no-transform, ");
        }
        if (this.f19377l) {
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
    public static U3.d l(U3.q r23) {
        /*
            r0 = r23
            int r1 = r0.e()
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
            java.lang.String r2 = r0.c(r6)
            r22 = 1
            java.lang.String r4 = r0.f(r6)
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
            int r5 = Y3.e.h(r4, r2, r5)
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
            int r0 = Y3.e.i(r4, r5)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x008c
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x008c
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = Y3.e.h(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            int r3 = r3 + 1
            goto L_0x009f
        L_0x008c:
            java.lang.String r3 = ",;"
            int r3 = Y3.e.h(r4, r0, r3)
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
            int r0 = Y3.e.f(r0, r5)
            r11 = r0
            goto L_0x013b
        L_0x00c7:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d7
            r5 = -1
            int r0 = Y3.e.f(r0, r5)
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
            int r0 = Y3.e.f(r0, r2)
            r16 = r0
            goto L_0x00a9
        L_0x010a:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x011a
            r5 = -1
            int r0 = Y3.e.f(r0, r5)
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
            U3.d r8 = new U3.d
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.d.l(U3.q):U3.d");
    }

    public boolean b() {
        return this.f19377l;
    }

    public boolean c() {
        return this.f19370e;
    }

    public boolean d() {
        return this.f19371f;
    }

    public int e() {
        return this.f19368c;
    }

    public int f() {
        return this.f19373h;
    }

    public int g() {
        return this.f19374i;
    }

    public boolean h() {
        return this.f19372g;
    }

    public boolean i() {
        return this.f19366a;
    }

    public boolean j() {
        return this.f19367b;
    }

    public boolean k() {
        return this.f19375j;
    }

    public String toString() {
        String str = this.f19378m;
        if (str != null) {
            return str;
        }
        String a5 = a();
        this.f19378m = a5;
        return a5;
    }

    d(a aVar) {
        this.f19366a = aVar.f19379a;
        this.f19367b = aVar.f19380b;
        this.f19368c = aVar.f19381c;
        this.f19369d = -1;
        this.f19370e = false;
        this.f19371f = false;
        this.f19372g = false;
        this.f19373h = aVar.f19382d;
        this.f19374i = aVar.f19383e;
        this.f19375j = aVar.f19384f;
        this.f19376k = aVar.f19385g;
        this.f19377l = aVar.f19386h;
    }
}
