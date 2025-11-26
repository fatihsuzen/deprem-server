package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.InternalFrame;
import com.mbridge.msdk.system.NoProGuard;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class SameMD5 implements NoProGuard {
    public static final String TAG = "MD5";

    public static String ByteArrayToHexString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int length = bArr.length * 2;
        byte[] bArr2 = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr2[i5] = 48;
        }
        byte[] bArr3 = new byte[(bArr.length + 1)];
        bArr3[0] = 0;
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        byte[] bytes = new BigInteger(bArr3).toString(16).getBytes();
        System.arraycopy(bytes, 0, bArr2, length - bytes.length, bytes.length);
        return new String(bArr2);
    }

    private static String UpHexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b5 : bArr) {
            sb.append(Integer.toHexString((b5 & 240) >>> 4));
            sb.append(Integer.toHexString(b5 & 15));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            af.a(TAG, str);
            MessageDigest instance = MessageDigest.getInstance(TAG);
            instance.reset();
            instance.update(str.getBytes());
            return hexEncode(instance.digest());
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String getQftJSMD5(String str) {
        try {
            byte[] qftJSMD5Bytes = getQftJSMD5Bytes(str);
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            MessageDigest instance = MessageDigest.getInstance(TAG);
            instance.update(qftJSMD5Bytes);
            char[] cArr2 = new char[(r1 * 2)];
            int i5 = 0;
            for (byte b5 : instance.digest()) {
                int i6 = i5 + 1;
                cArr2[i5] = cArr[(b5 >>> 4) & 15];
                i5 += 2;
                cArr2[i6] = cArr[b5 & 15];
            }
            return new String(cArr2);
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static byte[] getQftJSMD5Bytes(String str) throws UnsupportedEncodingException {
        int length = str.length();
        byte[] bytes = str.getBytes("UTF-16LE");
        af.c(InternalFrame.ID, "b = " + ByteArrayToHexString(bytes));
        byte[] bArr = new byte[length];
        int i5 = 0;
        for (int i6 = 0; i6 < bytes.length; i6 += 2) {
            byte b5 = bytes[i6];
            if (!(b5 == -1 || b5 == -2)) {
                bArr[i5] = b5;
                i5++;
                if (i5 == length) {
                    break;
                }
            }
        }
        af.c(InternalFrame.ID, "source = " + ByteArrayToHexString(bArr));
        return bArr;
    }

    public static String getUPMD5(String str) {
        try {
            af.a(TAG, str);
            MessageDigest instance = MessageDigest.getInstance(TAG);
            instance.reset();
            instance.update(str.getBytes());
            return UpHexEncode(instance.digest());
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String hexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b5 : bArr) {
            sb.append(Integer.toHexString((b5 & 240) >>> 4));
            sb.append(Integer.toHexString(b5 & 15));
        }
        return sb.toString().toLowerCase(Locale.US);
    }
}
