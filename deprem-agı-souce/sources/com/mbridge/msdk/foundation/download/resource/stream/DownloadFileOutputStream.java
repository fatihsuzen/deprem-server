package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.IOException;

public interface DownloadFileOutputStream {
    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j5) throws IOException, IllegalAccessException;

    void setLength(long j5) throws IOException, IllegalAccessException;

    void write(byte[] bArr, int i5, int i6) throws IOException;
}
