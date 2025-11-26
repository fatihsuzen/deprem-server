package androidx.datastore.core;

import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.jvm.internal.t;

@RequiresApi(26)
final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final boolean move(File file, File file2) {
        t.e(file, "srcFile");
        t.e(file2, "dstFile");
        try {
            Files.move(file.toPath(), file2.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
