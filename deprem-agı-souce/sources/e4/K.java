package e4;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import e4.Q;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public class K extends C2369s {
    private final Long p(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    public void a(Q q5, Q q6) {
        t.e(q5, "source");
        t.e(q6, TypedValues.AttributesType.S_TARGET);
        try {
            Path unused = Files.move(q5.l(), q6.l(), new CopyOption[]{C2373w.a(StandardCopyOption.ATOMIC_MOVE), C2373w.a(StandardCopyOption.REPLACE_EXISTING)});
        } catch (NoSuchFileException e5) {
            throw new FileNotFoundException(e5.getMessage());
        } catch (UnsupportedOperationException unused2) {
            throw new IOException("atomic move not supported");
        }
    }

    public C2361j h(Q q5) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return o(q5.l());
    }

    /* access modifiers changed from: protected */
    public final C2361j o(Path path) {
        Path path2;
        Q q5;
        Long l5;
        Long l6;
        Path path3 = path;
        t.e(path3, "nioPath");
        Long l7 = null;
        try {
            BasicFileAttributes a5 = Files.readAttributes(path3, C2370t.a(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (a5.isSymbolicLink()) {
                path2 = Files.readSymbolicLink(path3);
            } else {
                path2 = null;
            }
            boolean a6 = a5.isRegularFile();
            boolean a7 = a5.isDirectory();
            if (path2 != null) {
                q5 = Q.a.f(Q.f21501b, path2, false, 1, (Object) null);
            } else {
                q5 = null;
            }
            Long valueOf = Long.valueOf(a5.size());
            FileTime a8 = a5.creationTime();
            if (a8 != null) {
                l5 = p(a8);
            } else {
                l5 = null;
            }
            FileTime a9 = a5.lastModifiedTime();
            if (a9 != null) {
                l6 = p(a9);
            } else {
                l6 = null;
            }
            FileTime a10 = a5.lastAccessTime();
            if (a10 != null) {
                l7 = p(a10);
            }
            return new C2361j(a6, a7, q5, valueOf, l5, l6, l7, (Map) null, 128, (C2633k) null);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }

    public String toString() {
        return "NioSystemFileSystem";
    }
}
