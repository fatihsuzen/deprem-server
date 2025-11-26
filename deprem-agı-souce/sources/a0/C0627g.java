package A0;

import A0.F;
import java.util.Arrays;

/* renamed from: A0.g  reason: case insensitive filesystem */
final class C0627g extends F.d.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2091a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f2092b;

    /* renamed from: A0.g$b */
    static final class b extends F.d.b.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2093a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f2094b;

        b() {
        }

        public F.d.b a() {
            byte[] bArr;
            String str = this.f2093a;
            if (str != null && (bArr = this.f2094b) != null) {
                return new C0627g(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2093a == null) {
                sb.append(" filename");
            }
            if (this.f2094b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.d.b.a b(byte[] bArr) {
            if (bArr != null) {
                this.f2094b = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public F.d.b.a c(String str) {
            if (str != null) {
                this.f2093a = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }
    }

    public byte[] b() {
        return this.f2092b;
    }

    public String c() {
        return this.f2091a;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.d.b) {
            F.d.b bVar = (F.d.b) obj;
            if (this.f2091a.equals(bVar.c())) {
                byte[] bArr2 = this.f2092b;
                if (bVar instanceof C0627g) {
                    bArr = ((C0627g) bVar).f2092b;
                } else {
                    bArr = bVar.b();
                }
                if (Arrays.equals(bArr2, bArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f2091a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f2092b);
    }

    public String toString() {
        return "File{filename=" + this.f2091a + ", contents=" + Arrays.toString(this.f2092b) + "}";
    }

    private C0627g(String str, byte[] bArr) {
        this.f2091a = str;
        this.f2092b = bArr;
    }
}
