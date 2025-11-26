package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile {
    private static final String TAG = "AtomicFile";
    private final File backupName;
    private final File baseName;

    private static final class AtomicFileOutputStream extends OutputStream {
        private boolean closed = false;
        private final FileOutputStream fileOutputStream;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.fileOutputStream = new FileOutputStream(file);
        }

        public final void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                flush();
                try {
                    this.fileOutputStream.getFD().sync();
                } catch (IOException e5) {
                    Log.w(AtomicFile.TAG, "Failed to sync file descriptor:", e5);
                }
                this.fileOutputStream.close();
            }
        }

        public final void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        public final void write(int i5) throws IOException {
            this.fileOutputStream.write(i5);
        }

        public final void write(@NonNull byte[] bArr) throws IOException {
            this.fileOutputStream.write(bArr);
        }

        public final void write(@NonNull byte[] bArr, int i5, int i6) throws IOException {
            this.fileOutputStream.write(bArr, i5, i6);
        }
    }

    public AtomicFile(File file) {
        this.baseName = file;
        this.backupName = new File(file.getPath() + ".bak");
    }

    private void restoreBackup() {
        if (this.backupName.exists()) {
            this.baseName.delete();
            this.backupName.renameTo(this.baseName);
        }
    }

    public final void delete() {
        this.baseName.delete();
        this.backupName.delete();
    }

    public final void endWrite(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.backupName.delete();
    }

    public final InputStream openRead() throws FileNotFoundException {
        restoreBackup();
        return new FileInputStream(this.baseName);
    }

    public final OutputStream startWrite() throws IOException {
        if (this.baseName.exists()) {
            if (this.backupName.exists()) {
                this.baseName.delete();
            } else if (!this.baseName.renameTo(this.backupName)) {
                Log.w(TAG, "Couldn't rename file " + this.baseName + " to backup file " + this.backupName);
            }
        }
        try {
            return new AtomicFileOutputStream(this.baseName);
        } catch (FileNotFoundException e5) {
            if (this.baseName.getParentFile().mkdirs()) {
                try {
                    return new AtomicFileOutputStream(this.baseName);
                } catch (FileNotFoundException e6) {
                    throw new IOException("Couldn't create " + this.baseName, e6);
                }
            } else {
                throw new IOException("Couldn't create directory " + this.baseName, e5);
            }
        }
    }
}
