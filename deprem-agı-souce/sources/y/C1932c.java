package y;

import java.util.Set;
import y.C1935f;

/* renamed from: y.c  reason: case insensitive filesystem */
final class C1932c extends C1935f.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f17003a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17004b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f17005c;

    /* renamed from: y.c$b */
    static final class b extends C1935f.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f17006a;

        /* renamed from: b  reason: collision with root package name */
        private Long f17007b;

        /* renamed from: c  reason: collision with root package name */
        private Set f17008c;

        b() {
        }

        public C1935f.b a() {
            String str = "";
            if (this.f17006a == null) {
                str = str + " delta";
            }
            if (this.f17007b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f17008c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C1932c(this.f17006a.longValue(), this.f17007b.longValue(), this.f17008c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public C1935f.b.a b(long j5) {
            this.f17006a = Long.valueOf(j5);
            return this;
        }

        public C1935f.b.a c(Set set) {
            if (set != null) {
                this.f17008c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public C1935f.b.a d(long j5) {
            this.f17007b = Long.valueOf(j5);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f17003a;
    }

    /* access modifiers changed from: package-private */
    public Set c() {
        return this.f17005c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.f17004b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1935f.b) {
            C1935f.b bVar = (C1935f.b) obj;
            if (this.f17003a == bVar.b() && this.f17004b == bVar.d() && this.f17005c.equals(bVar.c())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f17003a;
        long j6 = this.f17004b;
        return ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f17005c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f17003a + ", maxAllowedDelay=" + this.f17004b + ", flags=" + this.f17005c + "}";
    }

    private C1932c(long j5, long j6, Set set) {
        this.f17003a = j5;
        this.f17004b = j6;
        this.f17005c = set;
    }
}
