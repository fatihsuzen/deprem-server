package A0;

import A0.F;
import java.util.List;

/* renamed from: A0.c  reason: case insensitive filesystem */
final class C0623c extends F.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f2058a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2059b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2060c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2061d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2062e;

    /* renamed from: f  reason: collision with root package name */
    private final long f2063f;

    /* renamed from: g  reason: collision with root package name */
    private final long f2064g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2065h;

    /* renamed from: i  reason: collision with root package name */
    private final List f2066i;

    /* renamed from: A0.c$b */
    static final class b extends F.a.b {

        /* renamed from: a  reason: collision with root package name */
        private int f2067a;

        /* renamed from: b  reason: collision with root package name */
        private String f2068b;

        /* renamed from: c  reason: collision with root package name */
        private int f2069c;

        /* renamed from: d  reason: collision with root package name */
        private int f2070d;

        /* renamed from: e  reason: collision with root package name */
        private long f2071e;

        /* renamed from: f  reason: collision with root package name */
        private long f2072f;

        /* renamed from: g  reason: collision with root package name */
        private long f2073g;

        /* renamed from: h  reason: collision with root package name */
        private String f2074h;

        /* renamed from: i  reason: collision with root package name */
        private List f2075i;

        /* renamed from: j  reason: collision with root package name */
        private byte f2076j;

        b() {
        }

        public F.a a() {
            String str;
            if (this.f2076j == 63 && (str = this.f2068b) != null) {
                return new C0623c(this.f2067a, str, this.f2069c, this.f2070d, this.f2071e, this.f2072f, this.f2073g, this.f2074h, this.f2075i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f2076j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f2068b == null) {
                sb.append(" processName");
            }
            if ((this.f2076j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f2076j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f2076j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f2076j & 16) == 0) {
                sb.append(" rss");
            }
            if ((this.f2076j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.a.b b(List list) {
            this.f2075i = list;
            return this;
        }

        public F.a.b c(int i5) {
            this.f2070d = i5;
            this.f2076j = (byte) (this.f2076j | 4);
            return this;
        }

        public F.a.b d(int i5) {
            this.f2067a = i5;
            this.f2076j = (byte) (this.f2076j | 1);
            return this;
        }

        public F.a.b e(String str) {
            if (str != null) {
                this.f2068b = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public F.a.b f(long j5) {
            this.f2071e = j5;
            this.f2076j = (byte) (this.f2076j | 8);
            return this;
        }

        public F.a.b g(int i5) {
            this.f2069c = i5;
            this.f2076j = (byte) (this.f2076j | 2);
            return this;
        }

        public F.a.b h(long j5) {
            this.f2072f = j5;
            this.f2076j = (byte) (this.f2076j | 16);
            return this;
        }

        public F.a.b i(long j5) {
            this.f2073g = j5;
            this.f2076j = (byte) (this.f2076j | 32);
            return this;
        }

        public F.a.b j(String str) {
            this.f2074h = str;
            return this;
        }
    }

    public List b() {
        return this.f2066i;
    }

    public int c() {
        return this.f2061d;
    }

    public int d() {
        return this.f2058a;
    }

    public String e() {
        return this.f2059b;
    }

    public boolean equals(Object obj) {
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.a) {
            F.a aVar = (F.a) obj;
            if (this.f2058a == aVar.d() && this.f2059b.equals(aVar.e()) && this.f2060c == aVar.g() && this.f2061d == aVar.c() && this.f2062e == aVar.f() && this.f2063f == aVar.h() && this.f2064g == aVar.i() && ((str = this.f2065h) != null ? str.equals(aVar.j()) : aVar.j() == null) && ((list = this.f2066i) != null ? list.equals(aVar.b()) : aVar.b() == null)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public long f() {
        return this.f2062e;
    }

    public int g() {
        return this.f2060c;
    }

    public long h() {
        return this.f2063f;
    }

    public int hashCode() {
        int i5;
        long j5 = this.f2062e;
        long j6 = this.f2063f;
        long j7 = this.f2064g;
        int hashCode = (((((((((((((this.f2058a ^ 1000003) * 1000003) ^ this.f2059b.hashCode()) * 1000003) ^ this.f2060c) * 1000003) ^ this.f2061d) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        String str = this.f2065h;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i7 = (hashCode ^ i5) * 1000003;
        List list = this.f2066i;
        if (list != null) {
            i6 = list.hashCode();
        }
        return i7 ^ i6;
    }

    public long i() {
        return this.f2064g;
    }

    public String j() {
        return this.f2065h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f2058a + ", processName=" + this.f2059b + ", reasonCode=" + this.f2060c + ", importance=" + this.f2061d + ", pss=" + this.f2062e + ", rss=" + this.f2063f + ", timestamp=" + this.f2064g + ", traceFile=" + this.f2065h + ", buildIdMappingForArch=" + this.f2066i + "}";
    }

    private C0623c(int i5, String str, int i6, int i7, long j5, long j6, long j7, String str2, List list) {
        this.f2058a = i5;
        this.f2059b = str;
        this.f2060c = i6;
        this.f2061d = i7;
        this.f2062e = j5;
        this.f2063f = j6;
        this.f2064g = j7;
        this.f2065h = str2;
        this.f2066i = list;
    }
}
