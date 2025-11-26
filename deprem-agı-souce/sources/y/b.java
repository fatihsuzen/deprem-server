package Y;

import android.util.Base64;
import java.security.SecureRandom;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SecureRandom f4483a = new SecureRandom();

    public static String a() {
        byte[] bArr = new byte[16];
        f4483a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
