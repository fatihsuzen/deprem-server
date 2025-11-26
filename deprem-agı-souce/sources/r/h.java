package r;

import java.util.Arrays;
import p.C1745c;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final C1745c f16286a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f16287b;

    public h(C1745c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f16286a = cVar;
            this.f16287b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public byte[] a() {
        return this.f16287b;
    }

    public C1745c b() {
        return this.f16286a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f16286a.equals(hVar.f16286a)) {
            return false;
        }
        return Arrays.equals(this.f16287b, hVar.f16287b);
    }

    public int hashCode() {
        return ((this.f16286a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f16287b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f16286a + ", bytes=[...]}";
    }
}
