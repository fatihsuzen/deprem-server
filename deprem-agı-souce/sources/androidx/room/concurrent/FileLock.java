package androidx.room.concurrent;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.t;

public final class FileLock {
    private FileChannel lockChannel;
    private final String lockFilename;

    public FileLock(String str) {
        t.e(str, "filename");
        this.lockFilename = str + ".lck";
    }

    public final void lock() {
        if (this.lockChannel == null) {
            try {
                File file = new File(this.lockFilename);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                this.lockChannel = channel;
                if (channel != null) {
                    channel.lock();
                }
            } catch (Throwable th) {
                FileChannel fileChannel = this.lockChannel;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                this.lockChannel = null;
                throw new IllegalStateException("Unable to lock file: '" + this.lockFilename + "'.", th);
            }
        }
    }

    public final void unlock() {
        FileChannel fileChannel = this.lockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } finally {
                this.lockChannel = null;
            }
        }
    }
}
