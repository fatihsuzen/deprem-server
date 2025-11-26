package androidx.datastore.core;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.t;

public final class UncloseableOutputStream extends OutputStream {
    private final FileOutputStream fileOutputStream;

    public UncloseableOutputStream(FileOutputStream fileOutputStream2) {
        t.e(fileOutputStream2, "fileOutputStream");
        this.fileOutputStream = fileOutputStream2;
    }

    public void close() {
    }

    public void flush() {
        this.fileOutputStream.flush();
    }

    public final FileOutputStream getFileOutputStream() {
        return this.fileOutputStream;
    }

    public void write(int i5) {
        this.fileOutputStream.write(i5);
    }

    public void write(byte[] bArr) {
        t.e(bArr, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
        this.fileOutputStream.write(bArr);
    }

    public void write(byte[] bArr, int i5, int i6) {
        t.e(bArr, "bytes");
        this.fileOutputStream.write(bArr, i5, i6);
    }
}
