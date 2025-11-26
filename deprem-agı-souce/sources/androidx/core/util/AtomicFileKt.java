package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import k3.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import t3.C2780d;

public final class AtomicFileKt {
    public static final byte[] readBytes(AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    public static final String readText(AtomicFile atomicFile, Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charset = C2780d.f25888b;
        }
        return readText(atomicFile, charset);
    }

    public static final void tryWrite(AtomicFile atomicFile, l lVar) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            lVar.invoke(startWrite);
            r.b(1);
            atomicFile.finishWrite(startWrite);
            r.a(1);
        } catch (Throwable th) {
            r.b(1);
            atomicFile.failWrite(startWrite);
            r.a(1);
            throw th;
        }
    }

    public static final void writeBytes(AtomicFile atomicFile, byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void writeText(AtomicFile atomicFile, String str, Charset charset) {
        byte[] bytes = str.getBytes(charset);
        t.d(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            charset = C2780d.f25888b;
        }
        writeText(atomicFile, str, charset);
    }
}
