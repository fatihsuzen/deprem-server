package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.util.zip.Deflater;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(Sink sink2, Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
    }

    private void deflate(boolean z4) throws IOException {
        Segment writableSegment;
        int i5;
        Buffer buffer = this.sink.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            if (z4) {
                Deflater deflater2 = this.deflater;
                byte[] bArr = writableSegment.data;
                int i6 = writableSegment.limit;
                i5 = deflater2.deflate(bArr, i6, 8192 - i6, 2);
            } else {
                Deflater deflater3 = this.deflater;
                byte[] bArr2 = writableSegment.data;
                int i7 = writableSegment.limit;
                i5 = deflater3.deflate(bArr2, i7, 8192 - i7);
            }
            if (i5 > 0) {
                writableSegment.limit += i5;
                buffer.size += (long) i5;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment.pos == writableSegment.limit) {
            buffer.head = writableSegment.pop();
            SegmentPool.recycle(writableSegment);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                finishDeflate();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.deflater.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                Util.sneakyRethrow(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void finishDeflate() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }

    public void write(Buffer buffer, long j5) throws IOException {
        Util.checkOffsetAndCount(buffer.size, 0, j5);
        while (j5 > 0) {
            Segment segment = buffer.head;
            int min = (int) Math.min(j5, (long) (segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j6 = (long) min;
            buffer.size -= j6;
            int i5 = segment.pos + min;
            segment.pos = i5;
            if (i5 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j5 -= j6;
        }
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater2 != null) {
            this.sink = bufferedSink;
            this.deflater = deflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
