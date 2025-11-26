package e4;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: e4.s  reason: case insensitive filesystem */
public class C2369s extends C2362k {
    private final void m(Q q5) {
        if (g(q5)) {
            throw new IOException(q5 + " already exists.");
        }
    }

    private final void n(Q q5) {
        if (!g(q5)) {
            throw new IOException(q5 + " doesn't exist.");
        }
    }

    public void a(Q q5, Q q6) {
        t.e(q5, "source");
        t.e(q6, TypedValues.AttributesType.S_TARGET);
        if (!q5.toFile().renameTo(q6.toFile())) {
            throw new IOException("failed to move " + q5 + " to " + q6);
        }
    }

    public void d(Q q5, boolean z4) {
        t.e(q5, "dir");
        if (!q5.toFile().mkdir()) {
            C2361j h5 = h(q5);
            if (h5 == null || !h5.c()) {
                throw new IOException("failed to create directory: " + q5);
            } else if (z4) {
                throw new IOException(q5 + " already exist.");
            }
        }
    }

    public void f(Q q5, boolean z4) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (!Thread.interrupted()) {
            File file = q5.toFile();
            if (file.delete()) {
                return;
            }
            if (file.exists()) {
                throw new IOException("failed to delete " + q5);
            } else if (z4) {
                throw new FileNotFoundException("no such file: " + q5);
            }
        } else {
            throw new InterruptedIOException("interrupted");
        }
    }

    public C2361j h(Q q5) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        File file = q5.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new C2361j(isFile, isDirectory, (Q) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, (Map) null, 128, (C2633k) null);
    }

    public C2360i i(Q q5) {
        t.e(q5, "file");
        return new r(false, new RandomAccessFile(q5.toFile(), CampaignEx.JSON_KEY_AD_R));
    }

    public C2360i k(Q q5, boolean z4, boolean z5) {
        t.e(q5, "file");
        if (!z4 || !z5) {
            if (z4) {
                m(q5);
            }
            if (z5) {
                n(q5);
            }
            return new r(true, new RandomAccessFile(q5.toFile(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
    }

    public Z l(Q q5) {
        t.e(q5, "file");
        return L.k(q5.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
