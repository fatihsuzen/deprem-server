package K;

import N.C0722p;
import N.S;
import N.w0;
import U.a;
import U.b;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class z extends w0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f2738a;

    protected z(byte[] bArr) {
        boolean z4;
        if (bArr.length == 25) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.a(z4);
        this.f2738a = Arrays.hashCode(bArr);
    }

    protected static byte[] k(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    public final a C() {
        return b.q0(q0());
    }

    public final int b() {
        return this.f2738a;
    }

    public final boolean equals(Object obj) {
        a C4;
        if (obj != null && (obj instanceof S)) {
            try {
                S s5 = (S) obj;
                if (s5.b() != this.f2738a || (C4 = s5.C()) == null) {
                    return false;
                }
                return Arrays.equals(q0(), (byte[]) b.k(C4));
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2738a;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] q0();
}
