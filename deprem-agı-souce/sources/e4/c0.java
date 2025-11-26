package e4;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;
import t3.C2780d;

public abstract class c0 {
    public static final byte[] a(String str) {
        t.e(str, "<this>");
        byte[] bytes = str.getBytes(C2780d.f25888b);
        t.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        t.e(bArr, "<this>");
        return new String(bArr, C2780d.f25888b);
    }
}
