package j4;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;

public abstract class b {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b5 : bArr) {
            sb.append("0123456789ABCDEF".charAt((b5 & 240) >> 4));
            sb.append("0123456789ABCDEF".charAt(b5 & 15));
        }
        return sb.toString();
    }

    public static String b(String str) {
        MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
        instance.update(str.getBytes());
        return a(instance.digest());
    }
}
