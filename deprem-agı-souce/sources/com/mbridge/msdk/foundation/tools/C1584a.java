package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.mbridge.msdk.foundation.tools.a  reason: case insensitive filesystem */
public final class C1584a {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f9574a = new byte[16];

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f9575b = new byte[32];

    /* renamed from: com.mbridge.msdk.foundation.tools.a$a  reason: collision with other inner class name */
    public static class C0090a extends Provider {
        public C0090a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    static {
        String a5 = z.a("HkzwDFeD4QuyLdx5igfZYcu9xTM9NN==");
        if (!TextUtils.isEmpty(a5)) {
            try {
                byte[] digest = MessageDigest.getInstance("sha-384").digest(a5.getBytes());
                System.arraycopy(digest, 0, f9575b, 0, 32);
                System.arraycopy(digest, 32, f9574a, 0, 16);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static String a(String str) {
        return a(str, f9575b, f9574a);
    }

    private static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0090a());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(instance.doFinal(str.getBytes()), 0));
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
