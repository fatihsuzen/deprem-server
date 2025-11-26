package r;

import java.util.Arrays;
import p.f;
import r.p;

final class d extends p {

    /* renamed from: a  reason: collision with root package name */
    private final String f16265a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f16266b;

    /* renamed from: c  reason: collision with root package name */
    private final f f16267c;

    static final class b extends p.a {

        /* renamed from: a  reason: collision with root package name */
        private String f16268a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f16269b;

        /* renamed from: c  reason: collision with root package name */
        private f f16270c;

        b() {
        }

        public p a() {
            String str = "";
            if (this.f16268a == null) {
                str = str + " backendName";
            }
            if (this.f16270c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f16268a, this.f16269b, this.f16270c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public p.a b(String str) {
            if (str != null) {
                this.f16268a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public p.a c(byte[] bArr) {
            this.f16269b = bArr;
            return this;
        }

        public p.a d(f fVar) {
            if (fVar != null) {
                this.f16270c = fVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public String b() {
        return this.f16265a;
    }

    public byte[] c() {
        return this.f16266b;
    }

    public f d() {
        return this.f16267c;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f16265a.equals(pVar.b())) {
                byte[] bArr2 = this.f16266b;
                if (pVar instanceof d) {
                    bArr = ((d) pVar).f16266b;
                } else {
                    bArr = pVar.c();
                }
                if (!Arrays.equals(bArr2, bArr) || !this.f16267c.equals(pVar.d())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f16265a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f16266b)) * 1000003) ^ this.f16267c.hashCode();
    }

    private d(String str, byte[] bArr, f fVar) {
        this.f16265a = str;
        this.f16266b = bArr;
        this.f16267c = fVar;
    }
}
