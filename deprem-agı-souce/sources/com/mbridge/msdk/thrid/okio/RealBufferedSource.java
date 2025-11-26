package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    RealBufferedSource(Source source2) {
        if (source2 != null) {
            this.source = source2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public Buffer buffer() {
        return this.buffer;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.buffer.clear();
        }
    }

    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (!this.buffer.exhausted() || this.source.read(this.buffer, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public long indexOf(byte b5) throws IOException {
        return indexOf(b5, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    return (int) Math.min(realBufferedSource.buffer.size, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i5, int i6) throws IOException {
                if (!RealBufferedSource.this.closed) {
                    Util.checkOffsetAndCount((long) bArr.length, (long) i5, (long) i6);
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.read(bArr, i5, i6);
                }
                throw new IOException("closed");
            }
        };
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public boolean rangeEquals(long j5, ByteString byteString) throws IOException {
        return rangeEquals(j5, byteString, 0, byteString.size());
    }

    public long read(Buffer buffer2, long j5) throws IOException {
        if (buffer2 == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (!this.closed) {
            Buffer buffer3 = this.buffer;
            if (buffer3.size == 0 && this.source.read(buffer3, 8192) == -1) {
                return -1;
            }
            return this.buffer.read(buffer2, Math.min(j5, this.buffer.size));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j5 = 0;
            while (this.source.read(this.buffer, 8192) != -1) {
                long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j5 += completeSegmentByteCount;
                    sink.write(this.buffer, completeSegmentByteCount);
                }
            }
            if (this.buffer.size() <= 0) {
                return j5;
            }
            long size = j5 + this.buffer.size();
            Buffer buffer2 = this.buffer;
            sink.write(buffer2, buffer2.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public byte readByte() throws IOException {
        require(1);
        return this.buffer.readByte();
    }

    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = r0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L_0x0040
            com.mbridge.msdk.thrid.okio.Buffer r3 = r6.buffer
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.Byte r2 = java.lang.Byte.valueOf(r3)
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r0] = r2
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            com.mbridge.msdk.thrid.okio.Buffer r0 = r6.buffer
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.RealBufferedSource.readDecimalLong():long");
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e5) {
            int i5 = 0;
            while (true) {
                Buffer buffer2 = this.buffer;
                long j5 = buffer2.size;
                if (j5 > 0) {
                    int read = buffer2.read(bArr, i5, (int) j5);
                    if (read != -1) {
                        i5 += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e5;
                }
            }
        }
    }

    public long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (!request((long) i6)) {
                break;
            }
            byte b5 = this.buffer.getByte((long) i5);
            if ((b5 >= 48 && b5 <= 57) || ((b5 >= 97 && b5 <= 102) || (b5 >= 65 && b5 <= 70))) {
                i5 = i6;
            } else if (i5 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b5)}));
            }
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    public int readInt() throws IOException {
        require(4);
        return this.buffer.readInt();
    }

    public int readIntLe() throws IOException {
        require(4);
        return this.buffer.readIntLe();
    }

    public long readLong() throws IOException {
        require(8);
        return this.buffer.readLong();
    }

    public long readLongLe() throws IOException {
        require(8);
        return this.buffer.readLongLe();
    }

    public short readShort() throws IOException {
        require(2);
        return this.buffer.readShort();
    }

    public short readShortLe() throws IOException {
        require(2);
        return this.buffer.readShortLe();
    }

    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    public int readUtf8CodePoint() throws IOException {
        require(1);
        byte b5 = this.buffer.getByte(0);
        if ((b5 & 224) == 192) {
            require(2);
        } else if ((b5 & 240) == 224) {
            require(3);
        } else if ((b5 & 248) == 240) {
            require(4);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        long j5 = this.buffer.size;
        if (j5 != 0) {
            return readUtf8(j5);
        }
        return null;
    }

    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j5) throws IOException {
        Buffer buffer2;
        if (j5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (!this.closed) {
            do {
                buffer2 = this.buffer;
                if (buffer2.size >= j5) {
                    return true;
                }
            } while (this.source.read(buffer2, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j5) throws IOException {
        if (!request(j5)) {
            throw new EOFException();
        }
    }

    public int select(Options options) throws IOException {
        if (!this.closed) {
            do {
                int selectPrefix = this.buffer.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.buffer.skip((long) options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.source.read(this.buffer, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public void skip(long j5) throws IOException {
        if (!this.closed) {
            while (j5 > 0) {
                Buffer buffer2 = this.buffer;
                if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j5, this.buffer.size());
                this.buffer.skip(min);
                j5 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }

    public long indexOf(byte b5, long j5) throws IOException {
        return indexOf(b5, j5, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j5) throws IOException {
        if (!this.closed) {
            while (true) {
                long indexOfElement = this.buffer.indexOfElement(byteString, j5);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                Buffer buffer2 = this.buffer;
                long j6 = buffer2.size;
                if (this.source.read(buffer2, 8192) == -1) {
                    return -1;
                }
                j5 = Math.max(j5, j6);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean rangeEquals(long j5, ByteString byteString, int i5, int i6) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j5 < 0 || i5 < 0 || i6 < 0 || byteString.size() - i5 < i6) {
            return false;
        } else {
            for (int i7 = 0; i7 < i6; i7++) {
                long j6 = ((long) i7) + j5;
                if (!request(1 + j6) || this.buffer.getByte(j6) != byteString.getByte(i5 + i7)) {
                    return false;
                }
            }
            return true;
        }
    }

    public String readUtf8LineStrict(long j5) throws IOException {
        if (j5 >= 0) {
            long j6 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
            long indexOf = indexOf((byte) 10, 0, j6);
            if (indexOf != -1) {
                return this.buffer.readUtf8Line(indexOf);
            }
            if (j6 < Long.MAX_VALUE && request(j6) && this.buffer.getByte(j6 - 1) == 13 && request(j6 + 1) && this.buffer.getByte(j6) == 10) {
                return this.buffer.readUtf8Line(j6);
            }
            Buffer buffer2 = new Buffer();
            Buffer buffer3 = this.buffer;
            buffer3.copyTo(buffer2, 0, Math.min(32, buffer3.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j5) + " content=" + buffer2.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j5);
    }

    public long indexOf(byte b5, long j5, long j6) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j5 < 0 || j6 < j5) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j5), Long.valueOf(j6)}));
        } else {
            long j7 = j5;
            while (j7 < j6) {
                byte b6 = b5;
                long j8 = j6;
                long indexOf = this.buffer.indexOf(b6, j7, j8);
                if (indexOf == -1) {
                    Buffer buffer2 = this.buffer;
                    long j9 = buffer2.size;
                    if (j9 >= j8 || this.source.read(buffer2, 8192) == -1) {
                        break;
                    }
                    j7 = Math.max(j7, j9);
                    b5 = b6;
                    j6 = j8;
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public byte[] readByteArray(long j5) throws IOException {
        require(j5);
        return this.buffer.readByteArray(j5);
    }

    public ByteString readByteString(long j5) throws IOException {
        require(j5);
        return this.buffer.readByteString(j5);
    }

    public String readUtf8(long j5) throws IOException {
        require(j5);
        return this.buffer.readUtf8(j5);
    }

    public String readString(long j5, Charset charset) throws IOException {
        require(j5);
        if (charset != null) {
            return this.buffer.readString(j5, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public void readFully(Buffer buffer2, long j5) throws IOException {
        try {
            require(j5);
            this.buffer.readFully(buffer2, j5);
        } catch (EOFException e5) {
            buffer2.writeAll(this.buffer);
            throw e5;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i5, int i6) throws IOException {
        long j5 = (long) i6;
        Util.checkOffsetAndCount((long) bArr.length, (long) i5, j5);
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i5, (int) Math.min(j5, this.buffer.size));
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j5) throws IOException {
        if (!this.closed) {
            while (true) {
                long indexOf = this.buffer.indexOf(byteString, j5);
                if (indexOf != -1) {
                    return indexOf;
                }
                Buffer buffer2 = this.buffer;
                long j6 = buffer2.size;
                if (this.source.read(buffer2, 8192) == -1) {
                    return -1;
                }
                j5 = Math.max(j5, (j6 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }
}
