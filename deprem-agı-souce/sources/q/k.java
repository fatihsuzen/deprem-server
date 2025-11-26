package q;

import java.util.List;
import q.u;

final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    private final long f15798a;

    /* renamed from: b  reason: collision with root package name */
    private final long f15799b;

    /* renamed from: c  reason: collision with root package name */
    private final o f15800c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f15801d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15802e;

    /* renamed from: f  reason: collision with root package name */
    private final List f15803f;

    /* renamed from: g  reason: collision with root package name */
    private final x f15804g;

    static final class b extends u.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f15805a;

        /* renamed from: b  reason: collision with root package name */
        private Long f15806b;

        /* renamed from: c  reason: collision with root package name */
        private o f15807c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f15808d;

        /* renamed from: e  reason: collision with root package name */
        private String f15809e;

        /* renamed from: f  reason: collision with root package name */
        private List f15810f;

        /* renamed from: g  reason: collision with root package name */
        private x f15811g;

        b() {
        }

        public u a() {
            String str = "";
            if (this.f15805a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f15806b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f15805a.longValue(), this.f15806b.longValue(), this.f15807c, this.f15808d, this.f15809e, this.f15810f, this.f15811g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public u.a b(o oVar) {
            this.f15807c = oVar;
            return this;
        }

        public u.a c(List list) {
            this.f15810f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public u.a d(Integer num) {
            this.f15808d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public u.a e(String str) {
            this.f15809e = str;
            return this;
        }

        public u.a f(x xVar) {
            this.f15811g = xVar;
            return this;
        }

        public u.a g(long j5) {
            this.f15805a = Long.valueOf(j5);
            return this;
        }

        public u.a h(long j5) {
            this.f15806b = Long.valueOf(j5);
            return this;
        }
    }

    public o b() {
        return this.f15800c;
    }

    public List c() {
        return this.f15803f;
    }

    public Integer d() {
        return this.f15801d;
    }

    public String e() {
        return this.f15802e;
    }

    public boolean equals(Object obj) {
        o oVar;
        Integer num;
        String str;
        List list;
        x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f15798a != uVar.g() || this.f15799b != uVar.h() || ((oVar = this.f15800c) != null ? !oVar.equals(uVar.b()) : uVar.b() != null) || ((num = this.f15801d) != null ? !num.equals(uVar.d()) : uVar.d() != null) || ((str = this.f15802e) != null ? !str.equals(uVar.e()) : uVar.e() != null) || ((list = this.f15803f) != null ? !list.equals(uVar.c()) : uVar.c() != null) || ((xVar = this.f15804g) != null ? !xVar.equals(uVar.f()) : uVar.f() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public x f() {
        return this.f15804g;
    }

    public long g() {
        return this.f15798a;
    }

    public long h() {
        return this.f15799b;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        long j5 = this.f15798a;
        long j6 = this.f15799b;
        int i9 = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        o oVar = this.f15800c;
        int i10 = 0;
        if (oVar == null) {
            i5 = 0;
        } else {
            i5 = oVar.hashCode();
        }
        int i11 = (i9 ^ i5) * 1000003;
        Integer num = this.f15801d;
        if (num == null) {
            i6 = 0;
        } else {
            i6 = num.hashCode();
        }
        int i12 = (i11 ^ i6) * 1000003;
        String str = this.f15802e;
        if (str == null) {
            i7 = 0;
        } else {
            i7 = str.hashCode();
        }
        int i13 = (i12 ^ i7) * 1000003;
        List list = this.f15803f;
        if (list == null) {
            i8 = 0;
        } else {
            i8 = list.hashCode();
        }
        int i14 = (i13 ^ i8) * 1000003;
        x xVar = this.f15804g;
        if (xVar != null) {
            i10 = xVar.hashCode();
        }
        return i14 ^ i10;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f15798a + ", requestUptimeMs=" + this.f15799b + ", clientInfo=" + this.f15800c + ", logSource=" + this.f15801d + ", logSourceName=" + this.f15802e + ", logEvents=" + this.f15803f + ", qosTier=" + this.f15804g + "}";
    }

    private k(long j5, long j6, o oVar, Integer num, String str, List list, x xVar) {
        this.f15798a = j5;
        this.f15799b = j6;
        this.f15800c = oVar;
        this.f15801d = num;
        this.f15802e = str;
        this.f15803f = list;
        this.f15804g = xVar;
    }
}
