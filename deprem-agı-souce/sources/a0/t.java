package A0;

import A0.F;

final class t extends F.e.d.a.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f2234a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2235b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2236c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2237d;

    static final class b extends F.e.d.a.c.C0035a {

        /* renamed from: a  reason: collision with root package name */
        private String f2238a;

        /* renamed from: b  reason: collision with root package name */
        private int f2239b;

        /* renamed from: c  reason: collision with root package name */
        private int f2240c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2241d;

        /* renamed from: e  reason: collision with root package name */
        private byte f2242e;

        b() {
        }

        public F.e.d.a.c a() {
            String str;
            if (this.f2242e == 7 && (str = this.f2238a) != null) {
                return new t(str, this.f2239b, this.f2240c, this.f2241d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2238a == null) {
                sb.append(" processName");
            }
            if ((this.f2242e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f2242e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f2242e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.c.C0035a b(boolean z4) {
            this.f2241d = z4;
            this.f2242e = (byte) (this.f2242e | 4);
            return this;
        }

        public F.e.d.a.c.C0035a c(int i5) {
            this.f2240c = i5;
            this.f2242e = (byte) (this.f2242e | 2);
            return this;
        }

        public F.e.d.a.c.C0035a d(int i5) {
            this.f2239b = i5;
            this.f2242e = (byte) (this.f2242e | 1);
            return this;
        }

        public F.e.d.a.c.C0035a e(String str) {
            if (str != null) {
                this.f2238a = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }
    }

    public int b() {
        return this.f2236c;
    }

    public int c() {
        return this.f2235b;
    }

    public String d() {
        return this.f2234a;
    }

    public boolean e() {
        return this.f2237d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.c) {
            F.e.d.a.c cVar = (F.e.d.a.c) obj;
            if (this.f2234a.equals(cVar.d()) && this.f2235b == cVar.c() && this.f2236c == cVar.b() && this.f2237d == cVar.e()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int hashCode = (((((this.f2234a.hashCode() ^ 1000003) * 1000003) ^ this.f2235b) * 1000003) ^ this.f2236c) * 1000003;
        if (this.f2237d) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        return hashCode ^ i5;
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f2234a + ", pid=" + this.f2235b + ", importance=" + this.f2236c + ", defaultProcess=" + this.f2237d + "}";
    }

    private t(String str, int i5, int i6, boolean z4) {
        this.f2234a = str;
        this.f2235b = i5;
        this.f2236c = i6;
        this.f2237d = z4;
    }
}
