package b2;

import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import t3.C2777a;
import t3.C2780d;

/* renamed from: b2.f  reason: case insensitive filesystem */
public final class C2286f {

    /* renamed from: a  reason: collision with root package name */
    public static final C2286f f20690a = new C2286f();

    private C2286f() {
    }

    private final String a(String str, String str2) {
        Charset forName = Charset.forName(C.UTF8_NAME);
        t.d(forName, "forName(...)");
        byte[] bytes = str.getBytes(forName);
        t.d(bytes, "getBytes(...)");
        return b(bytes, str2);
    }

    private final String b(byte[] bArr, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b5 : digest) {
                String num = Integer.toString((b5 & 255) + 256, C2777a.a(16));
                t.d(num, "toString(...)");
                String substring = num.substring(1);
                t.d(substring, "substring(...)");
                sb.append(substring);
            }
            return sb.toString();
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String c(String str) {
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        return a(str, "SHA-256");
    }

    public final String d(byte[] bArr) {
        t.e(bArr, "byteArray");
        return b(bArr, "SHA-256");
    }

    public final String e(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                while (bigInteger.length() < 64) {
                    bigInteger = '0' + bigInteger;
                }
                return bigInteger;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public final String f(String str) {
        t.e(str, "s");
        byte[] bytes = str.getBytes(C2780d.f25888b);
        t.d(bytes, "getBytes(...)");
        return g(bytes);
    }

    public final String g(byte[] bArr) {
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
