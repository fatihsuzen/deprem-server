package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ReusableBufferedOutputStream;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    private final int bufferSize;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private File file;
    private final long maxCacheFileSize;
    private OutputStream outputStream;
    private long outputStreamBytesWritten;
    private final boolean syncFileDescriptor;
    private FileOutputStream underlyingFileOutputStream;

    public static class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public CacheDataSink(Cache cache2, long j5) {
        this(cache2, j5, DEFAULT_BUFFER_SIZE, true);
    }

    private void closeCurrentOutputStream() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 != null) {
            try {
                outputStream2.flush();
                if (this.syncFileDescriptor) {
                    this.underlyingFileOutputStream.getFD().sync();
                }
                Util.closeQuietly((Closeable) this.outputStream);
                this.outputStream = null;
                File file2 = this.file;
                this.file = null;
                this.cache.commitFile(file2);
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) this.outputStream);
                this.outputStream = null;
                File file3 = this.file;
                this.file = null;
                file3.delete();
                throw th;
            }
        }
    }

    private void openNextOutputStream() throws IOException {
        long min;
        long j5 = this.dataSpec.length;
        if (j5 == -1) {
            min = this.maxCacheFileSize;
        } else {
            min = Math.min(j5 - this.dataSpecBytesWritten, this.maxCacheFileSize);
        }
        long j6 = min;
        Cache cache2 = this.cache;
        DataSpec dataSpec2 = this.dataSpec;
        this.file = cache2.startFile(dataSpec2.key, this.dataSpecBytesWritten + dataSpec2.absoluteStreamPosition, j6);
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        this.underlyingFileOutputStream = fileOutputStream;
        if (this.bufferSize > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
            if (reusableBufferedOutputStream == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(this.underlyingFileOutputStream, this.bufferSize);
            } else {
                reusableBufferedOutputStream.reset(fileOutputStream);
            }
            this.outputStream = this.bufferedOutputStream;
        } else {
            this.outputStream = fileOutputStream;
        }
        this.outputStreamBytesWritten = 0;
    }

    public final void close() throws CacheDataSinkException {
        if (this.dataSpec != null) {
            try {
                closeCurrentOutputStream();
            } catch (IOException e5) {
                throw new CacheDataSinkException(e5);
            }
        }
    }

    public final void open(DataSpec dataSpec2) throws CacheDataSinkException {
        if (dataSpec2.length != -1 || dataSpec2.isFlagSet(2)) {
            this.dataSpec = dataSpec2;
            this.dataSpecBytesWritten = 0;
            try {
                openNextOutputStream();
            } catch (IOException e5) {
                throw new CacheDataSinkException(e5);
            }
        } else {
            this.dataSpec = null;
        }
    }

    public final void write(byte[] bArr, int i5, int i6) throws CacheDataSinkException {
        if (this.dataSpec != null) {
            int i7 = 0;
            while (i7 < i6) {
                try {
                    if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                        closeCurrentOutputStream();
                        openNextOutputStream();
                    }
                    int min = (int) Math.min((long) (i6 - i7), this.maxCacheFileSize - this.outputStreamBytesWritten);
                    this.outputStream.write(bArr, i5 + i7, min);
                    i7 += min;
                    long j5 = (long) min;
                    this.outputStreamBytesWritten += j5;
                    this.dataSpecBytesWritten += j5;
                } catch (IOException e5) {
                    throw new CacheDataSinkException(e5);
                }
            }
        }
    }

    public CacheDataSink(Cache cache2, long j5, boolean z4) {
        this(cache2, j5, DEFAULT_BUFFER_SIZE, z4);
    }

    public CacheDataSink(Cache cache2, long j5, int i5) {
        this(cache2, j5, i5, true);
    }

    public CacheDataSink(Cache cache2, long j5, int i5, boolean z4) {
        this.cache = (Cache) Assertions.checkNotNull(cache2);
        this.maxCacheFileSize = j5;
        this.bufferSize = i5;
        this.syncFileDescriptor = z4;
    }
}
