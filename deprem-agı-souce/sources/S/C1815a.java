package s;

import java.util.Arrays;
import s.f;

/* renamed from: s.a  reason: case insensitive filesystem */
final class C1815a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable f16452a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f16453b;

    /* renamed from: s.a$b */
    static final class b extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private Iterable f16454a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f16455b;

        b() {
        }

        public f a() {
            String str = "";
            if (this.f16454a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new C1815a(this.f16454a, this.f16455b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.a b(Iterable iterable) {
            if (iterable != null) {
                this.f16454a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public f.a c(byte[] bArr) {
            this.f16455b = bArr;
            return this;
        }
    }

    public Iterable b() {
        return this.f16452a;
    }

    public byte[] c() {
        return this.f16453b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f16452a.equals(fVar.b())) {
                byte[] bArr2 = this.f16453b;
                if (fVar instanceof C1815a) {
                    bArr = ((C1815a) fVar).f16453b;
                } else {
                    bArr = fVar.c();
                }
                if (Arrays.equals(bArr2, bArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f16452a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f16453b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f16452a + ", extras=" + Arrays.toString(this.f16453b) + "}";
    }

    private C1815a(Iterable iterable, byte[] bArr) {
        this.f16452a = iterable;
        this.f16453b = bArr;
    }
}
