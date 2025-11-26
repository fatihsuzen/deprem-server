package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize = 16384;
    private final BufferedSink sink;

    Http2Writer(BufferedSink bufferedSink, boolean z4) {
        this.sink = bufferedSink;
        this.client = z4;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
    }

    private void writeContinuationFrames(int i5, long j5) throws IOException {
        byte b5;
        while (j5 > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j5);
            long j6 = (long) min;
            j5 -= j6;
            if (j5 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            frameHeader(i5, min, (byte) 9, b5);
            this.sink.write(this.hpackBuffer, j6);
        }
    }

    private static void writeMedium(BufferedSink bufferedSink, int i5) throws IOException {
        bufferedSink.writeByte((i5 >>> 16) & 255);
        bufferedSink.writeByte((i5 >>> 8) & 255);
        bufferedSink.writeByte(i5 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        try {
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() != -1) {
                    this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
                }
                frameHeader(0, 0, (byte) 4, (byte) 1);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void data(boolean z4, int i5, Buffer buffer, int i6) throws IOException {
        byte b5;
        if (!this.closed) {
            if (z4) {
                b5 = (byte) 1;
            } else {
                b5 = 0;
            }
            dataFrame(i5, b5, buffer, i6);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void dataFrame(int i5, byte b5, Buffer buffer, int i6) throws IOException {
        frameHeader(i5, i6, (byte) 0, b5);
        if (i6 > 0) {
            this.sink.write(buffer, (long) i6);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void frameHeader(int i5, int i6, byte b5, byte b6) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i5, i6, b5, b6));
        }
        int i7 = this.maxFrameSize;
        if (i6 > i7) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
        } else if ((Integer.MIN_VALUE & i5) == 0) {
            writeMedium(this.sink, i6);
            this.sink.writeByte(b5 & 255);
            this.sink.writeByte(b6 & 255);
            this.sink.writeInt(i5 & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i5));
        }
    }

    public synchronized void goAway(int i5, ErrorCode errorCode, byte[] bArr) throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.sink.writeInt(i5);
                this.sink.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void headers(int i5, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(false, i5, list);
        } else {
            throw new IOException("closed");
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z4, int i5, int i6) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z4 ? (byte) 1 : 0);
            this.sink.writeInt(i5);
            this.sink.writeInt(i6);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void pushPromise(int i5, int i6, List<Header> list) throws IOException {
        byte b5;
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min((long) (this.maxFrameSize - 4), size);
            long j5 = (long) min;
            int i7 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            if (i7 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            frameHeader(i5, min + 4, (byte) 5, b5);
            this.sink.writeInt(i6 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j5);
            if (i7 > 0) {
                writeContinuationFrames(i5, size - j5);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int i5, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(i5, 4, (byte) 3, (byte) 0);
            this.sink.writeInt(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        int i5;
        try {
            if (!this.closed) {
                frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
                for (int i6 = 0; i6 < 10; i6++) {
                    if (settings.isSet(i6)) {
                        if (i6 == 4) {
                            i5 = 3;
                        } else if (i6 == 7) {
                            i5 = 4;
                        } else {
                            i5 = i6;
                        }
                        this.sink.writeShort(i5);
                        this.sink.writeInt(settings.get(i6));
                    }
                }
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public synchronized void synReply(boolean z4, int i5, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z4, i5, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synStream(boolean z4, int i5, int i6, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z4, i5, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void windowUpdate(int i5, long j5) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (j5 == 0 || j5 > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j5));
        } else {
            frameHeader(i5, 4, (byte) 8, (byte) 0);
            this.sink.writeInt((int) j5);
            this.sink.flush();
        }
    }

    /* access modifiers changed from: package-private */
    public void headers(boolean z4, int i5, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min((long) this.maxFrameSize, size);
            long j5 = (long) min;
            int i6 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            byte b5 = i6 == 0 ? (byte) 4 : 0;
            if (z4) {
                b5 = (byte) (b5 | 1);
            }
            frameHeader(i5, min, (byte) 1, b5);
            this.sink.write(this.hpackBuffer, j5);
            if (i6 > 0) {
                writeContinuationFrames(i5, size - j5);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
