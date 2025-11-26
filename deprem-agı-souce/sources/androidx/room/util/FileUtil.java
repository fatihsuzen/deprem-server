package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        ReadableByteChannel readableByteChannel2;
        FileChannel fileChannel2;
        t.e(readableByteChannel, "input");
        t.e(fileChannel, "output");
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                readableByteChannel2 = readableByteChannel;
                fileChannel2 = fileChannel;
                InputStream newInputStream = Channels.newInputStream(readableByteChannel2);
                OutputStream newOutputStream = Channels.newOutputStream(fileChannel2);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                readableByteChannel2 = readableByteChannel;
                fileChannel2 = fileChannel;
                try {
                    fileChannel2.transferFrom(readableByteChannel2, 0, Long.MAX_VALUE);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    readableByteChannel2.close();
                    fileChannel2.close();
                    throw th2;
                }
            }
            fileChannel2.force(false);
            readableByteChannel2.close();
            fileChannel2.close();
        } catch (Throwable th3) {
            th = th3;
            readableByteChannel2 = readableByteChannel;
            fileChannel2 = fileChannel;
            Throwable th22 = th;
            readableByteChannel2.close();
            fileChannel2.close();
            throw th22;
        }
    }
}
