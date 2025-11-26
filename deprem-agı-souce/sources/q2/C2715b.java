package q2;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;

/* renamed from: q2.b  reason: case insensitive filesystem */
public final class C2715b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2715b f25683a = new C2715b();

    public final String a(byte[] bArr) {
        t.e(bArr, "s");
        try {
            MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
            instance.update(bArr);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            while (bigInteger.length() < 32) {
                Q q5 = Q.f24695a;
                bigInteger = String.format("0%s", Arrays.copyOf(new Object[]{bigInteger}, 1));
                t.d(bigInteger, "format(...)");
            }
            return bigInteger;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
