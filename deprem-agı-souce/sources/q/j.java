package q;

import java.util.Arrays;
import q.t;

final class j extends t {

    /* renamed from: a  reason: collision with root package name */
    private final long f15780a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f15781b;

    /* renamed from: c  reason: collision with root package name */
    private final p f15782c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15783d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f15784e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15785f;

    /* renamed from: g  reason: collision with root package name */
    private final long f15786g;

    /* renamed from: h  reason: collision with root package name */
    private final w f15787h;

    /* renamed from: i  reason: collision with root package name */
    private final q f15788i;

    static final class b extends t.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f15789a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f15790b;

        /* renamed from: c  reason: collision with root package name */
        private p f15791c;

        /* renamed from: d  reason: collision with root package name */
        private Long f15792d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f15793e;

        /* renamed from: f  reason: collision with root package name */
        private String f15794f;

        /* renamed from: g  reason: collision with root package name */
        private Long f15795g;

        /* renamed from: h  reason: collision with root package name */
        private w f15796h;

        /* renamed from: i  reason: collision with root package name */
        private q f15797i;

        b() {
        }

        public t a() {
            String str = "";
            if (this.f15789a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f15792d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f15795g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f15789a.longValue(), this.f15790b, this.f15791c, this.f15792d.longValue(), this.f15793e, this.f15794f, this.f15795g.longValue(), this.f15796h, this.f15797i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public t.a b(p pVar) {
            this.f15791c = pVar;
            return this;
        }

        public t.a c(Integer num) {
            this.f15790b = num;
            return this;
        }

        public t.a d(long j5) {
            this.f15789a = Long.valueOf(j5);
            return this;
        }

        public t.a e(long j5) {
            this.f15792d = Long.valueOf(j5);
            return this;
        }

        public t.a f(q qVar) {
            this.f15797i = qVar;
            return this;
        }

        public t.a g(w wVar) {
            this.f15796h = wVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public t.a h(byte[] bArr) {
            this.f15793e = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public t.a i(String str) {
            this.f15794f = str;
            return this;
        }

        public t.a j(long j5) {
            this.f15795g = Long.valueOf(j5);
            return this;
        }
    }

    public p b() {
        return this.f15782c;
    }

    public Integer c() {
        return this.f15781b;
    }

    public long d() {
        return this.f15780a;
    }

    public long e() {
        return this.f15783d;
    }

    public boolean equals(Object obj) {
        Integer num;
        p pVar;
        byte[] bArr;
        String str;
        w wVar;
        q qVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f15780a == tVar.d() && ((num = this.f15781b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f15782c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f15783d == tVar.e()) {
                byte[] bArr2 = this.f15784e;
                if (tVar instanceof j) {
                    bArr = ((j) tVar).f15784e;
                } else {
                    bArr = tVar.h();
                }
                if (!Arrays.equals(bArr2, bArr) || ((str = this.f15785f) != null ? !str.equals(tVar.i()) : tVar.i() != null) || this.f15786g != tVar.j() || ((wVar = this.f15787h) != null ? !wVar.equals(tVar.g()) : tVar.g() != null) || ((qVar = this.f15788i) != null ? !qVar.equals(tVar.f()) : tVar.f() != null)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public q f() {
        return this.f15788i;
    }

    public w g() {
        return this.f15787h;
    }

    public byte[] h() {
        return this.f15784e;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        long j5 = this.f15780a;
        int i9 = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f15781b;
        int i10 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int i11 = (i9 ^ i5) * 1000003;
        p pVar = this.f15782c;
        if (pVar == null) {
            i6 = 0;
        } else {
            i6 = pVar.hashCode();
        }
        long j6 = this.f15783d;
        int hashCode = (((((i11 ^ i6) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f15784e)) * 1000003;
        String str = this.f15785f;
        if (str == null) {
            i7 = 0;
        } else {
            i7 = str.hashCode();
        }
        long j7 = this.f15786g;
        int i12 = (((hashCode ^ i7) * 1000003) ^ ((int) ((j7 >>> 32) ^ j7))) * 1000003;
        w wVar = this.f15787h;
        if (wVar == null) {
            i8 = 0;
        } else {
            i8 = wVar.hashCode();
        }
        int i13 = (i12 ^ i8) * 1000003;
        q qVar = this.f15788i;
        if (qVar != null) {
            i10 = qVar.hashCode();
        }
        return i13 ^ i10;
    }

    public String i() {
        return this.f15785f;
    }

    public long j() {
        return this.f15786g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f15780a + ", eventCode=" + this.f15781b + ", complianceData=" + this.f15782c + ", eventUptimeMs=" + this.f15783d + ", sourceExtension=" + Arrays.toString(this.f15784e) + ", sourceExtensionJsonProto3=" + this.f15785f + ", timezoneOffsetSeconds=" + this.f15786g + ", networkConnectionInfo=" + this.f15787h + ", experimentIds=" + this.f15788i + "}";
    }

    private j(long j5, Integer num, p pVar, long j6, byte[] bArr, String str, long j7, w wVar, q qVar) {
        this.f15780a = j5;
        this.f15781b = num;
        this.f15782c = pVar;
        this.f15783d = j6;
        this.f15784e = bArr;
        this.f15785f = str;
        this.f15786g = j7;
        this.f15787h = wVar;
        this.f15788i = qVar;
    }
}
