package com.google.android.gms.common.util;

import T.e;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class a {
    public static byte[] a(Context context, String str) {
        MessageDigest b5;
        PackageInfo e5 = e.a(context).e(str, 64);
        Signature[] signatureArr = e5.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b5 = b("SHA1")) == null) {
            return null;
        }
        return b5.digest(e5.signatures[0].toByteArray());
    }

    public static MessageDigest b(String str) {
        int i5 = 0;
        while (i5 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i5++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
