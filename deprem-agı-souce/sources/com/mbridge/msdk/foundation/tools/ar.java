package com.mbridge.msdk.foundation.tools;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

final class ar {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final char[] f9667a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        /* renamed from: b  reason: collision with root package name */
        static final SecureRandom f9668b = new SecureRandom();
    }

    static void a(File file) {
        try {
            if (file.exists()) {
                d(file);
            }
        } catch (Exception unused) {
        }
    }

    static byte[] b(File file) throws IOException {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i5 = (int) length;
            byte[] bArr = new byte[i5];
            a(file, bArr, i5);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    static boolean c(File file) throws IOException {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        if ((parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile()) {
            return true;
        }
        return false;
    }

    private static void d(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File d5 : listFiles) {
                d(d5);
            }
        }
        file.delete();
    }

    static void a(File file, byte[] bArr, int i5) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i6 = 0;
        while (i6 < i5) {
            try {
                int read = randomAccessFile.read(bArr, i6, i5 - i6);
                if (read < 0) {
                    break;
                }
                i6 += read;
            } catch (Throwable th) {
                a((Closeable) randomAccessFile);
                throw th;
            }
        }
        a((Closeable) randomAccessFile);
    }

    static String b() {
        byte[] bArr = new byte[16];
        a.f9668b.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i5 = 0; i5 < 16; i5++) {
            byte b5 = bArr[i5];
            int i6 = i5 << 1;
            char[] cArr2 = a.f9667a;
            cArr[i6] = cArr2[(b5 >> 4) & 15];
            cArr[i6 + 1] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    static int a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", (Class[]) null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get((Object) null), (Object[]) null)).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    static boolean a(File file, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        try {
            String parent = file.getParent();
            File file2 = new File(parent, file.getName() + ".tmp");
            if (!c(file2)) {
                return false;
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            randomAccessFile.setLength((long) bArr.length);
            randomAccessFile.write(bArr);
            a((Closeable) randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Exception unused) {
        } catch (Throwable th) {
            a((Closeable) randomAccessFile);
            throw th;
        }
    }
}
