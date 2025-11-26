package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okio.Buffer;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel2) {
        this.fileChannel = fileChannel2;
    }

    public void read(long j5, Buffer buffer, long j6) throws IOException {
        if (j6 >= 0) {
            long j7 = j5;
            long j8 = j6;
            while (j8 > 0) {
                long transferTo = this.fileChannel.transferTo(j7, j8, buffer);
                j7 += transferTo;
                j8 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void write(long j5, Buffer buffer, long j6) throws IOException {
        if (j6 < 0 || j6 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j7 = j5;
        long j8 = j6;
        while (j8 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j7, j8);
            j7 += transferFrom;
            j8 -= transferFrom;
        }
    }
}
