package com.mbridge.msdk.thrid.okhttp.internal.ws;

import androidx.appcompat.R;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void write(Buffer buffer, long j5) throws IOException {
            boolean z4;
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(buffer, j5);
                if (!this.isFirstFrame || this.contentLength == -1 || WebSocketWriter.this.buffer.size() <= this.contentLength - 8192) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                long completeSegmentByteCount = WebSocketWriter.this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z4) {
                    WebSocketWriter.this.writeMessageFrame(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    WebSocketWriter(boolean z4, BufferedSink bufferedSink, Random random2) {
        byte[] bArr;
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random2 != null) {
            this.isClient = z4;
            this.sink = bufferedSink;
            this.sinkBuffer = bufferedSink.buffer();
            this.random = random2;
            Buffer.UnsafeCursor unsafeCursor = null;
            if (z4) {
                bArr = new byte[4];
            } else {
                bArr = null;
            }
            this.maskKey = bArr;
            this.maskCursor = z4 ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    private void writeControlFrame(int i5, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.sinkBuffer.writeByte(i5 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long size2 = this.sinkBuffer.size();
                        this.sinkBuffer.write(byteString);
                        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                        this.maskCursor.seek(size2);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.write(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public Sink newMessageSink(int i5, long j5) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink2 = this.frameSink;
            frameSink2.formatOpcode = i5;
            frameSink2.contentLength = j5;
            frameSink2.isFirstFrame = true;
            frameSink2.closed = false;
            return frameSink2;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public void writeClose(int i5, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i5 == 0 && byteString == null)) {
            if (i5 != 0) {
                WebSocketProtocol.validateCloseCode(i5);
            }
            Buffer buffer2 = new Buffer();
            buffer2.writeShort(i5);
            if (byteString != null) {
                buffer2.write(byteString);
            }
            byteString2 = buffer2.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void writeMessageFrame(int i5, long j5, boolean z4, boolean z5) throws IOException {
        if (!this.writerClosed) {
            int i6 = 0;
            if (!z4) {
                i5 = 0;
            }
            if (z5) {
                i5 |= 128;
            }
            this.sinkBuffer.writeByte(i5);
            if (this.isClient) {
                i6 = 128;
            }
            if (j5 <= 125) {
                this.sinkBuffer.writeByte(((int) j5) | i6);
            } else if (j5 <= 65535) {
                this.sinkBuffer.writeByte(i6 | R.styleable.AppCompatTheme_windowNoTitle);
                this.sinkBuffer.writeShort((int) j5);
            } else {
                this.sinkBuffer.writeByte(i6 | 127);
                this.sinkBuffer.writeLong(j5);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.write(this.maskKey);
                if (j5 > 0) {
                    long size = this.sinkBuffer.size();
                    this.sinkBuffer.write(this.buffer, j5);
                    this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(size);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j5);
            }
            this.sink.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    /* access modifiers changed from: package-private */
    public void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }
}
