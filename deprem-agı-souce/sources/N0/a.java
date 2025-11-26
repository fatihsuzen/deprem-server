package N0;

import N0.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f3161a;

    /* renamed from: b  reason: collision with root package name */
    private d.a f3162b = d.a.DEFAULT;

    /* renamed from: N0.a$a  reason: collision with other inner class name */
    private static final class C0051a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f3163a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f3164b;

        C0051a(int i5, d.a aVar) {
            this.f3163a = i5;
            this.f3164b = aVar;
        }

        public Class annotationType() {
            return d.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f3163a != dVar.tag() || !this.f3164b.equals(dVar.intEncoding())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (14552422 ^ this.f3163a) + (this.f3164b.hashCode() ^ 2041407134);
        }

        public d.a intEncoding() {
            return this.f3164b;
        }

        public int tag() {
            return this.f3163a;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.f3163a + "intEncoding=" + this.f3164b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new C0051a(this.f3161a, this.f3162b);
    }

    public a c(int i5) {
        this.f3161a = i5;
        return this;
    }
}
