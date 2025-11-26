package h3;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.t;

/* renamed from: h3.a  reason: case insensitive filesystem */
public abstract class C2452a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i5) {
        t.e(inputStream, "<this>");
        t.e(outputStream, "out");
        byte[] bArr = new byte[i5];
        int read = inputStream.read(bArr);
        long j5 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j5 += (long) read;
            read = inputStream.read(bArr);
        }
        return j5;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        return a(inputStream, outputStream, i5);
    }

    public static final byte[] c(InputStream inputStream) {
        t.e(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        t.d(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
