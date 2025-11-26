package q;

import java.util.Arrays;
import q.q;

final class g extends q {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f15772a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f15773b;

    static final class b extends q.a {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f15774a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f15775b;

        b() {
        }

        public q a() {
            return new g(this.f15774a, this.f15775b);
        }

        public q.a b(byte[] bArr) {
            this.f15774a = bArr;
            return this;
        }

        public q.a c(byte[] bArr) {
            this.f15775b = bArr;
            return this;
        }
    }

    public byte[] b() {
        return this.f15772a;
    }

    public byte[] c() {
        return this.f15773b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            byte[] bArr3 = this.f15772a;
            boolean z4 = qVar instanceof g;
            if (z4) {
                bArr = ((g) qVar).f15772a;
            } else {
                bArr = qVar.b();
            }
            if (Arrays.equals(bArr3, bArr)) {
                byte[] bArr4 = this.f15773b;
                if (z4) {
                    bArr2 = ((g) qVar).f15773b;
                } else {
                    bArr2 = qVar.c();
                }
                if (Arrays.equals(bArr4, bArr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f15772a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f15773b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f15772a) + ", encryptedBlob=" + Arrays.toString(this.f15773b) + "}";
    }

    private g(byte[] bArr, byte[] bArr2) {
        this.f15772a = bArr;
        this.f15773b = bArr2;
    }
}
