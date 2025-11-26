package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i5) {
            if (i5 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i5);
            } else if (i5 <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j5 = buffer2.size;
                    Segment writableSegment = buffer2.writableSegment(i5);
                    int i6 = 8192 - writableSegment.limit;
                    writableSegment.limit = 8192;
                    long j6 = (long) i6;
                    this.buffer.size = j5 + j6;
                    this.segment = writableSegment;
                    this.offset = j5;
                    this.data = writableSegment.data;
                    this.start = 8192 - i6;
                    this.end = 8192;
                    return j6;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i5);
            }
        }

        public final int next() {
            long j5 = this.offset;
            if (j5 == this.buffer.size) {
                throw new IllegalStateException();
            } else if (j5 == -1) {
                return seek(0);
            } else {
                return seek(j5 + ((long) (this.end - this.start)));
            }
        }

        public final long resizeBuffer(long j5) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j6 = buffer2.size;
                int i5 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
                if (i5 <= 0) {
                    if (j5 >= 0) {
                        long j7 = j6 - j5;
                        while (true) {
                            if (j7 <= 0) {
                                break;
                            }
                            Buffer buffer3 = this.buffer;
                            Segment segment2 = buffer3.head.prev;
                            int i6 = segment2.limit;
                            long j8 = (long) (i6 - segment2.pos);
                            if (j8 > j7) {
                                segment2.limit = (int) (((long) i6) - j7);
                                break;
                            }
                            buffer3.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j7 -= j8;
                        }
                        this.segment = null;
                        this.offset = j5;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j5);
                    }
                } else if (i5 > 0) {
                    long j9 = j5 - j6;
                    boolean z4 = true;
                    while (j9 > 0) {
                        Segment writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j9, (long) (8192 - writableSegment.limit));
                        int i7 = writableSegment.limit + min;
                        writableSegment.limit = i7;
                        j9 -= (long) min;
                        if (z4) {
                            this.segment = writableSegment;
                            this.offset = j6;
                            this.data = writableSegment.data;
                            this.start = i7 - min;
                            this.end = i7;
                            z4 = false;
                        }
                    }
                }
                this.buffer.size = j5;
                return j6;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j5) {
            int i5 = (j5 > -1 ? 1 : (j5 == -1 ? 0 : -1));
            if (i5 >= 0) {
                Buffer buffer2 = this.buffer;
                long j6 = buffer2.size;
                if (j5 <= j6) {
                    if (i5 == 0 || j5 == j6) {
                        this.segment = null;
                        this.offset = j5;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment2 = buffer2.head;
                    Segment segment3 = this.segment;
                    long j7 = 0;
                    if (segment3 != null) {
                        long j8 = this.offset - ((long) (this.start - segment3.pos));
                        if (j8 > j5) {
                            Segment segment4 = segment3;
                            segment3 = segment2;
                            segment2 = segment4;
                            j6 = j8;
                        } else {
                            j7 = j8;
                        }
                    } else {
                        segment3 = segment2;
                    }
                    if (j6 - j5 > j5 - j7) {
                        while (true) {
                            int i6 = segment3.limit;
                            int i7 = segment3.pos;
                            if (j5 < ((long) (i6 - i7)) + j7) {
                                break;
                            }
                            j7 += (long) (i6 - i7);
                            segment3 = segment3.next;
                        }
                    } else {
                        while (j6 > j5) {
                            segment2 = segment2.prev;
                            j6 -= (long) (segment2.limit - segment2.pos);
                        }
                        segment3 = segment2;
                        j7 = j6;
                    }
                    if (this.readWrite && segment3.shared) {
                        Segment unsharedCopy = segment3.unsharedCopy();
                        Buffer buffer3 = this.buffer;
                        if (buffer3.head == segment3) {
                            buffer3.head = unsharedCopy;
                        }
                        segment3 = segment3.push(unsharedCopy);
                        segment3.prev.pop();
                    }
                    this.segment = segment3;
                    this.offset = j5;
                    this.data = segment3.data;
                    int i8 = segment3.pos + ((int) (j5 - j7));
                    this.start = i8;
                    int i9 = segment3.limit;
                    this.end = i9;
                    return i9 - i8;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j5), Long.valueOf(this.buffer.size)}));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i5 = segment.pos;
                instance.update(bArr, i5, segment.limit - i5);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i6 = segment2.pos;
                    instance.update(bArr2, i6, segment2.limit - i6);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i5 = segment.pos;
                instance.update(bArr, i5, segment.limit - i5);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i6 = segment2.pos;
                    instance.update(bArr2, i6, segment2.limit - i6);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j5 = this.size;
        if (j5 == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        int i5 = segment.limit;
        if (i5 >= 8192 || !segment.owner) {
            return j5;
        }
        return j5 - ((long) (i5 - segment.pos));
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.size);
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j5 = this.size;
        if (j5 != buffer.size) {
            return false;
        }
        long j6 = 0;
        if (j5 == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i5 = segment.pos;
        int i6 = segment2.pos;
        while (j6 < this.size) {
            long min = (long) Math.min(segment.limit - i5, segment2.limit - i6);
            int i7 = 0;
            while (((long) i7) < min) {
                int i8 = i5 + 1;
                int i9 = i6 + 1;
                if (segment.data[i5] != segment2.data[i6]) {
                    return false;
                }
                i7++;
                i5 = i8;
                i6 = i9;
            }
            if (i5 == segment.limit) {
                segment = segment.next;
                i5 = segment.pos;
            }
            if (i6 == segment2.limit) {
                segment2 = segment2.next;
                i6 = segment2.pos;
            }
            j6 += min;
        }
        return true;
    }

    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void flush() {
    }

    public final byte getByte(long j5) {
        int i5;
        long j6 = j5;
        Util.checkOffsetAndCount(this.size, j6, 1);
        long j7 = this.size;
        if (j7 - j6 > j6) {
            Segment segment = this.head;
            while (true) {
                int i6 = segment.limit;
                int i7 = segment.pos;
                long j8 = (long) (i6 - i7);
                if (j6 < j8) {
                    return segment.data[i7 + ((int) j6)];
                }
                j6 -= j8;
                segment = segment.next;
            }
        } else {
            long j9 = j6 - j7;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i8 = segment2.limit;
                i5 = segment2.pos;
                j9 += (long) (i8 - i5);
            } while (j9 < 0);
            return segment2.data[i5 + ((int) j9)];
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = segment.limit;
            for (int i7 = segment.pos; i7 < i6; i7++) {
                i5 = (i5 * 31) + segment.data[i7];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i5;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b5) {
        return indexOf(b5, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public void close() {
            }

            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i5, int i6) {
                return Buffer.this.read(bArr, i5, i6);
            }
        };
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(SameMD5.TAG);
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            public void write(int i5) {
                Buffer.this.writeByte((int) (byte) i5);
            }

            public void write(byte[] bArr, int i5, int i6) {
                Buffer.this.write(bArr, i5, i6);
            }
        };
    }

    public boolean rangeEquals(long j5, ByteString byteString) {
        return rangeEquals(j5, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) throws IOException {
        long j5 = this.size;
        if (j5 > 0) {
            sink.write(this, j5);
        }
        return j5;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public byte readByte() {
        long j5 = this.size;
        if (j5 != 0) {
            Segment segment = this.head;
            int i5 = segment.pos;
            int i6 = segment.limit;
            int i7 = i5 + 1;
            byte b5 = segment.data[i5];
            this.size = j5 - 1;
            if (i7 == i6) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return b5;
            }
            segment.pos = i7;
            return b5;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r1 != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        r0.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r0.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0098 A[EDGE_INSN: B:49:0x0098->B:29:0x0098 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b7
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        L_0x000f:
            com.mbridge.msdk.thrid.okio.Segment r7 = r15.head
            byte[] r8 = r7.data
            int r9 = r7.pos
            int r10 = r7.limit
        L_0x0017:
            if (r9 >= r10) goto L_0x0098
            byte r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L_0x0069
            r12 = 57
            if (r11 > r12) goto L_0x0069
            int r12 = 48 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L_0x003c
            if (r13 != 0) goto L_0x0036
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L_0x0074
        L_0x003c:
            com.mbridge.msdk.thrid.okio.Buffer r0 = new com.mbridge.msdk.thrid.okio.Buffer
            r0.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeDecimalLong((long) r3)
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeByte((int) r11)
            if (r1 != 0) goto L_0x004e
            r0.readByte()
        L_0x004e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0069:
            r12 = 45
            r13 = 1
            if (r11 != r12) goto L_0x0079
            if (r0 != 0) goto L_0x0079
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L_0x0074:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0079:
            if (r0 == 0) goto L_0x007d
            r2 = r13
            goto L_0x0098
        L_0x007d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r11)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            if (r9 != r10) goto L_0x00a4
            com.mbridge.msdk.thrid.okio.Segment r8 = r7.pop()
            r15.head = r8
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r7)
            goto L_0x00a6
        L_0x00a4:
            r7.pos = r9
        L_0x00a6:
            if (r2 != 0) goto L_0x00ac
            com.mbridge.msdk.thrid.okio.Segment r7 = r15.head
            if (r7 != 0) goto L_0x000f
        L_0x00ac:
            long r5 = r15.size
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.size = r5
            if (r1 == 0) goto L_0x00b5
            return r3
        L_0x00b5:
            long r0 = -r3
            return r0
        L_0x00b7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(Buffer buffer, long j5) throws EOFException {
        long j6 = this.size;
        if (j6 >= j5) {
            buffer.write(this, j5);
        } else {
            buffer.write(this, j6);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        if (r8 != r9) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r14.head = r6.pop();
        com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (r1 != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r14 = this;
            long r0 = r14.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a9
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000b:
            com.mbridge.msdk.thrid.okio.Segment r6 = r14.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0013:
            if (r8 >= r9) goto L_0x008e
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0037
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -87
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006f
            r11 = 70
            if (r10 > r11) goto L_0x006f
            int r11 = r10 + -55
        L_0x0037:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0047
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0047:
            com.mbridge.msdk.thrid.okio.Buffer r0 = new com.mbridge.msdk.thrid.okio.Buffer
            r0.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006f:
            if (r0 == 0) goto L_0x0073
            r1 = 1
            goto L_0x008e
        L_0x0073:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008e:
            if (r8 != r9) goto L_0x009a
            com.mbridge.msdk.thrid.okio.Segment r7 = r6.pop()
            r14.head = r7
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r6)
            goto L_0x009c
        L_0x009a:
            r6.pos = r8
        L_0x009c:
            if (r1 != 0) goto L_0x00a2
            com.mbridge.msdk.thrid.okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x000b
        L_0x00a2:
            long r1 = r14.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.size = r1
            return r4
        L_0x00a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        long j5 = this.size;
        if (j5 >= 4) {
            Segment segment = this.head;
            int i5 = segment.pos;
            int i6 = segment.limit;
            if (i6 - i5 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            byte b5 = ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5] & 255) << 24);
            int i7 = i5 + 3;
            int i8 = i5 + 4;
            byte b6 = (bArr[i7] & 255) | b5 | ((bArr[i5 + 2] & 255) << 8);
            this.size = j5 - 4;
            if (i8 == i6) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return b6;
            }
            segment.pos = i8;
            return b6;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    public long readLong() {
        long j5 = this.size;
        if (j5 >= 8) {
            Segment segment = this.head;
            int i5 = segment.pos;
            int i6 = segment.limit;
            if (i6 - i5 < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            long j6 = ((((long) bArr[i5 + 1]) & 255) << 48) | ((((long) bArr[i5]) & 255) << 56) | ((((long) bArr[i5 + 2]) & 255) << 40) | ((((long) bArr[i5 + 3]) & 255) << 32) | ((((long) bArr[i5 + 4]) & 255) << 24);
            int i7 = i5 + 7;
            int i8 = i5 + 8;
            long j7 = j6 | ((((long) bArr[i5 + 5]) & 255) << 16) | ((((long) bArr[i5 + 6]) & 255) << 8) | (((long) bArr[i7]) & 255);
            this.size = j5 - 8;
            if (i8 == i6) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return j7;
            }
            segment.pos = i8;
            return j7;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    public short readShort() {
        long j5 = this.size;
        if (j5 >= 2) {
            Segment segment = this.head;
            int i5 = segment.pos;
            int i6 = segment.limit;
            if (i6 - i5 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i7 = i5 + 1;
            int i8 = i5 + 2;
            byte b5 = (bArr[i7] & 255) | ((bArr[i5] & 255) << 8);
            this.size = j5 - 2;
            if (i8 == i6) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return (short) b5;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b5;
        int i5;
        byte b6;
        if (this.size != 0) {
            byte b7 = getByte(0);
            int i6 = 1;
            if ((b7 & 128) == 0) {
                b6 = b7 & Byte.MAX_VALUE;
                b5 = 0;
                i5 = 1;
            } else if ((b7 & 224) == 192) {
                b6 = b7 & 31;
                i5 = 2;
                b5 = 128;
            } else if ((b7 & 240) == 224) {
                b6 = b7 & 15;
                i5 = 3;
                b5 = 2048;
            } else if ((b7 & 248) == 240) {
                b6 = b7 & 7;
                i5 = 4;
                b5 = 65536;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j5 = (long) i5;
            if (this.size >= j5) {
                while (i6 < i5) {
                    long j6 = (long) i6;
                    byte b8 = getByte(j6);
                    if ((b8 & 192) == 128) {
                        b6 = (b6 << 6) | (b8 & 63);
                        i6++;
                    } else {
                        skip(j6);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j5);
                if (b6 > 1114111) {
                    return REPLACEMENT_CHARACTER;
                }
                if ((b6 < 55296 || b6 > 57343) && b6 >= b5) {
                    return b6;
                }
                return REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i5 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b7) + ")");
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j5 = this.size;
        if (j5 != 0) {
            return readUtf8(j5);
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j5) {
        if (this.size >= j5) {
            return true;
        }
        return false;
    }

    public void require(long j5) throws EOFException {
        if (this.size < j5) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r19 == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int selectPrefix(com.mbridge.msdk.thrid.okio.Options r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            com.mbridge.msdk.thrid.okio.Segment r2 = r1.head
            r3 = -2
            if (r2 != 0) goto L_0x0013
            if (r19 == 0) goto L_0x000c
            return r3
        L_0x000c:
            com.mbridge.msdk.thrid.okio.ByteString r2 = com.mbridge.msdk.thrid.okio.ByteString.EMPTY
            int r0 = r0.indexOf(r2)
            return r0
        L_0x0013:
            byte[] r4 = r2.data
            int r5 = r2.pos
            int r6 = r2.limit
            int[] r0 = r0.trie
            r7 = 0
            r8 = -1
            r10 = r2
            r9 = r7
            r11 = r8
        L_0x0020:
            int r12 = r9 + 1
            r13 = r0[r9]
            int r9 = r9 + 2
            r12 = r0[r12]
            if (r12 == r8) goto L_0x002b
            r11 = r12
        L_0x002b:
            if (r10 != 0) goto L_0x002e
            goto L_0x0055
        L_0x002e:
            r12 = 0
            if (r13 >= 0) goto L_0x0071
            int r13 = r13 * -1
            int r14 = r9 + r13
        L_0x0035:
            int r13 = r5 + 1
            byte r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + 1
            r9 = r0[r9]
            if (r5 == r9) goto L_0x0042
            goto L_0x007b
        L_0x0042:
            if (r15 != r14) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = r7
        L_0x0047:
            if (r13 != r6) goto L_0x0061
            com.mbridge.msdk.thrid.okio.Segment r4 = r10.next
            int r6 = r4.pos
            byte[] r9 = r4.data
            int r10 = r4.limit
            if (r4 != r2) goto L_0x005b
            if (r5 != 0) goto L_0x0058
        L_0x0055:
            if (r19 == 0) goto L_0x007b
            return r3
        L_0x0058:
            r4 = r9
            r9 = r12
            goto L_0x0064
        L_0x005b:
            r16 = r9
            r9 = r4
            r4 = r16
            goto L_0x0064
        L_0x0061:
            r9 = r10
            r10 = r6
            r6 = r13
        L_0x0064:
            if (r5 == 0) goto L_0x006c
            r5 = r0[r15]
            r3 = r6
            r6 = r10
            r10 = r9
            goto L_0x0092
        L_0x006c:
            r5 = r6
            r6 = r10
            r10 = r9
            r9 = r15
            goto L_0x0035
        L_0x0071:
            int r14 = r5 + 1
            byte r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + r13
        L_0x0079:
            if (r9 != r15) goto L_0x007c
        L_0x007b:
            return r11
        L_0x007c:
            r3 = r0[r9]
            if (r5 != r3) goto L_0x0099
            int r9 = r9 + r13
            r5 = r0[r9]
            if (r14 != r6) goto L_0x0091
            com.mbridge.msdk.thrid.okio.Segment r10 = r10.next
            int r3 = r10.pos
            byte[] r4 = r10.data
            int r6 = r10.limit
            if (r10 != r2) goto L_0x0092
            r10 = r12
            goto L_0x0092
        L_0x0091:
            r3 = r14
        L_0x0092:
            if (r5 < 0) goto L_0x0095
            return r5
        L_0x0095:
            int r9 = -r5
            r5 = r3
            r3 = -2
            goto L_0x0020
        L_0x0099:
            int r9 = r9 + 1
            r3 = -2
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.selectPrefix(com.mbridge.msdk.thrid.okio.Options, boolean):int");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j5) throws EOFException {
        while (j5 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j5, (long) (segment.limit - segment.pos));
                long j6 = (long) min;
                this.size -= j6;
                j5 -= j6;
                Segment segment2 = this.head;
                int i5 = segment2.pos + min;
                segment2.pos = i5;
                if (i5 == segment2.limit) {
                    this.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j5 = this.size;
        if (j5 <= 2147483647L) {
            return snapshot((int) j5);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* access modifiers changed from: package-private */
    public Segment writableSegment(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        if (segment2.limit + i5 > 8192 || !segment2.owner) {
            return segment2.push(SegmentPool.take());
        }
        return segment2;
    }

    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j5 = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j5;
                }
                j5 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j5, long j6) throws IOException {
        if (outputStream != null) {
            long j7 = j5;
            long j8 = j6;
            Util.checkOffsetAndCount(this.size, j7, j8);
            if (j8 != 0) {
                Segment segment = this.head;
                while (true) {
                    int i5 = segment.limit;
                    int i6 = segment.pos;
                    if (j7 < ((long) (i5 - i6))) {
                        break;
                    }
                    j7 -= (long) (i5 - i6);
                    segment = segment.next;
                }
                Segment segment2 = segment;
                long j9 = j8;
                while (j9 > 0) {
                    int i7 = (int) (((long) segment2.pos) + j7);
                    int min = (int) Math.min((long) (segment2.limit - i7), j9);
                    outputStream.write(segment2.data, i7, min);
                    j9 -= (long) min;
                    segment2 = segment2.next;
                    j7 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long indexOf(byte b5, long j5) {
        return indexOf(b5, j5, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j5) {
        int i5;
        int i6;
        long j6 = 0;
        if (j5 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            long j7 = this.size;
            if (j7 - j5 < j5) {
                while (j7 > j5) {
                    segment = segment.prev;
                    j7 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j8 = ((long) (segment.limit - segment.pos)) + j6;
                    if (j8 >= j5) {
                        break;
                    }
                    segment = segment.next;
                    j6 = j8;
                }
                j7 = j6;
            }
            if (byteString.size() == 2) {
                byte b5 = byteString.getByte(0);
                byte b6 = byteString.getByte(1);
                while (j7 < this.size) {
                    byte[] bArr = segment.data;
                    i5 = (int) ((((long) segment.pos) + j5) - j7);
                    int i7 = segment.limit;
                    while (i5 < i7) {
                        byte b7 = bArr[i5];
                        if (b7 == b5 || b7 == b6) {
                            i6 = segment.pos;
                        } else {
                            i5++;
                        }
                    }
                    j7 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j5 = j7;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j7 < this.size) {
                byte[] bArr2 = segment.data;
                int i8 = (int) ((((long) segment.pos) + j5) - j7);
                int i9 = segment.limit;
                while (i5 < i9) {
                    byte b8 = bArr2[i5];
                    int length = internalArray.length;
                    int i10 = 0;
                    while (i10 < length) {
                        if (b8 == internalArray[i10]) {
                            i6 = segment.pos;
                        } else {
                            i10++;
                        }
                    }
                    i8 = i5 + 1;
                }
                j7 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j5 = j7;
            }
            return -1;
            return ((long) (i5 - i6)) + j7;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean rangeEquals(long j5, ByteString byteString, int i5, int i6) {
        if (j5 < 0 || i5 < 0 || i6 < 0 || this.size - j5 < ((long) i6) || byteString.size() - i5 < i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (getByte(((long) i7) + j5) != byteString.getByte(i5 + i7)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr, int i5, int i6) {
        Util.checkOffsetAndCount((long) bArr.length, (long) i5, (long) i6);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i6, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i5, min);
        int i7 = segment.pos + min;
        segment.pos = i7;
        this.size -= (long) min;
        if (i7 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public ByteString readByteString(long j5) throws EOFException {
        return new ByteString(readByteArray(j5));
    }

    public final Buffer readFrom(InputStream inputStream, long j5) throws IOException {
        if (j5 >= 0) {
            readFrom(inputStream, j5, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j5);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public String readUtf8LineStrict(long j5) throws EOFException {
        if (j5 >= 0) {
            long j6 = Long.MAX_VALUE;
            if (j5 != Long.MAX_VALUE) {
                j6 = j5 + 1;
            }
            long j7 = j6;
            long indexOf = indexOf((byte) 10, 0, j7);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j7 < size() && getByte(j7 - 1) == 13 && getByte(j7) == 10) {
                return readUtf8Line(j7);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j5) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j5);
    }

    public Buffer writeByte(int i5) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i6 = writableSegment.limit;
        writableSegment.limit = i6 + 1;
        bArr[i6] = (byte) i5;
        this.size++;
        return this;
    }

    public Buffer writeDecimalLong(long j5) {
        boolean z4;
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 == 0) {
            return writeByte(48);
        }
        int i6 = 1;
        if (i5 < 0) {
            j5 = -j5;
            if (j5 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z4 = true;
        } else {
            z4 = false;
        }
        if (j5 >= 100000000) {
            i6 = j5 < 1000000000000L ? j5 < 10000000000L ? j5 < C.NANOS_PER_SECOND ? 9 : 10 : j5 < 100000000000L ? 11 : 12 : j5 < 1000000000000000L ? j5 < 10000000000000L ? 13 : j5 < 100000000000000L ? 14 : 15 : j5 < 100000000000000000L ? j5 < 10000000000000000L ? 16 : 17 : j5 < 1000000000000000000L ? 18 : 19;
        } else if (j5 >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i6 = j5 < 1000000 ? j5 < 100000 ? 5 : 6 : j5 < 10000000 ? 7 : 8;
        } else if (j5 >= 100) {
            i6 = j5 < 1000 ? 3 : 4;
        } else if (j5 >= 10) {
            i6 = 2;
        }
        if (z4) {
            i6++;
        }
        Segment writableSegment = writableSegment(i6);
        byte[] bArr = writableSegment.data;
        int i7 = writableSegment.limit + i6;
        while (j5 != 0) {
            i7--;
            bArr[i7] = DIGITS[(int) (j5 % 10)];
            j5 /= 10;
        }
        if (z4) {
            bArr[i7 - 1] = 45;
        }
        writableSegment.limit += i6;
        this.size += (long) i6;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j5) {
        if (j5 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j5)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        for (int i6 = (i5 + numberOfTrailingZeros) - 1; i6 >= i5; i6--) {
            bArr[i6] = DIGITS[(int) (15 & j5)];
            j5 >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    public Buffer writeInt(int i5) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i6 = writableSegment.limit;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i5 & 255);
        writableSegment.limit = i6 + 4;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i5) {
        return writeInt(Util.reverseBytesInt(i5));
    }

    public Buffer writeLong(long j5) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        bArr[i5] = (byte) ((int) ((j5 >>> 56) & 255));
        bArr[i5 + 1] = (byte) ((int) ((j5 >>> 48) & 255));
        bArr[i5 + 2] = (byte) ((int) ((j5 >>> 40) & 255));
        bArr[i5 + 3] = (byte) ((int) ((j5 >>> 32) & 255));
        bArr[i5 + 4] = (byte) ((int) ((j5 >>> 24) & 255));
        bArr[i5 + 5] = (byte) ((int) ((j5 >>> 16) & 255));
        bArr[i5 + 6] = (byte) ((int) ((j5 >>> 8) & 255));
        bArr[i5 + 7] = (byte) ((int) (j5 & 255));
        writableSegment.limit = i5 + 8;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j5) {
        return writeLong(Util.reverseBytesLong(j5));
    }

    public Buffer writeShort(int i5) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i6 = writableSegment.limit;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i5 & 255);
        writableSegment.limit = i6 + 2;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i5) {
        return writeShort((int) Util.reverseBytesShort((short) i5));
    }

    public final Buffer writeTo(OutputStream outputStream, long j5) throws IOException {
        if (outputStream != null) {
            long j6 = j5;
            Util.checkOffsetAndCount(this.size, 0, j6);
            Segment segment = this.head;
            long j7 = j6;
            while (j7 > 0) {
                int min = (int) Math.min(j7, (long) (segment.limit - segment.pos));
                outputStream.write(segment.data, segment.pos, min);
                int i5 = segment.pos + min;
                segment.pos = i5;
                long j8 = (long) min;
                this.size -= j8;
                j7 -= j8;
                if (i5 == segment.limit) {
                    Segment pop = segment.pop();
                    this.head = pop;
                    SegmentPool.recycle(segment);
                    segment = pop;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer writeUtf8CodePoint(int i5) {
        if (i5 < 128) {
            writeByte(i5);
            return this;
        } else if (i5 < 2048) {
            writeByte((i5 >> 6) | PsExtractor.AUDIO_STREAM);
            writeByte((i5 & 63) | 128);
            return this;
        } else if (i5 < 65536) {
            if (i5 < 55296 || i5 > 57343) {
                writeByte((i5 >> 12) | 224);
                writeByte(((i5 >> 6) & 63) | 128);
                writeByte((i5 & 63) | 128);
                return this;
            }
            writeByte(63);
            return this;
        } else if (i5 <= 1114111) {
            writeByte((i5 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            writeByte(((i5 >> 12) & 63) | 128);
            writeByte(((i5 >> 6) & 63) | 128);
            writeByte((i5 & 63) | 128);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i5));
        }
    }

    public long indexOf(byte b5, long j5, long j6) {
        Segment segment;
        long j7 = 0;
        if (j5 < 0 || j6 < j5) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j5), Long.valueOf(j6)}));
        }
        long j8 = this.size;
        long j9 = j6 > j8 ? j8 : j6;
        if (j5 == j9 || (segment = this.head) == null) {
            return -1;
        }
        if (j8 - j5 < j5) {
            while (j8 > j5) {
                segment = segment.prev;
                j8 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j10 = ((long) (segment.limit - segment.pos)) + j7;
                if (j10 >= j5) {
                    break;
                }
                segment = segment.next;
                j7 = j10;
            }
            j8 = j7;
        }
        long j11 = j5;
        while (j8 < j9) {
            byte[] bArr = segment.data;
            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j9) - j8);
            for (int i5 = (int) ((((long) segment.pos) + j11) - j8); i5 < min; i5++) {
                if (bArr[i5] == b5) {
                    return ((long) (i5 - segment.pos)) + j8;
                }
            }
            j8 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j11 = j8;
        }
        return -1;
    }

    public byte[] readByteArray(long j5) throws EOFException {
        long j6 = j5;
        Util.checkOffsetAndCount(this.size, 0, j6);
        if (j6 <= 2147483647L) {
            byte[] bArr = new byte[((int) j6)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j6);
    }

    public String readString(long j5, Charset charset) throws EOFException {
        long j6 = j5;
        Util.checkOffsetAndCount(this.size, 0, j6);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j6 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j6);
        } else if (j6 == 0) {
            return "";
        } else {
            Segment segment = this.head;
            int i5 = segment.pos;
            if (((long) i5) + j6 > ((long) segment.limit)) {
                return new String(readByteArray(j6), charset);
            }
            String str = new String(segment.data, i5, (int) j6, charset);
            int i6 = (int) (((long) segment.pos) + j6);
            segment.pos = i6;
            this.size -= j6;
            if (i6 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    public String readUtf8(long j5) throws EOFException {
        return readString(j5, Util.UTF_8);
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j5, boolean z4) throws IOException {
        if (inputStream != null) {
            while (true) {
                if (j5 > 0 || z4) {
                    Segment writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j5, (long) (8192 - writableSegment.limit)));
                    if (read != -1) {
                        writableSegment.limit += read;
                        long j6 = (long) read;
                        this.size += j6;
                        j5 -= j6;
                    } else if (!z4) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long j5) throws EOFException {
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (getByte(j6) == 13) {
                String readUtf8 = readUtf8(j6);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j5);
        skip(1);
        return readUtf82;
    }

    public final ByteString snapshot(int i5) {
        if (i5 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i5);
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer writeString(String str, int i5, int i6, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i5 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i5);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i6 + " < " + i5);
        } else if (i6 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i6 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i5, i6);
        } else {
            byte[] bytes = str.substring(i5, i6).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeUtf8(String str, int i5, int i6) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i5 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i5);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i6 + " < " + i5);
        } else if (i6 <= str.length()) {
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    Segment writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.data;
                    int i7 = writableSegment.limit - i5;
                    int min = Math.min(i6, 8192 - i7);
                    int i8 = i5 + 1;
                    bArr[i5 + i7] = (byte) charAt;
                    while (i8 < min) {
                        char charAt2 = str.charAt(i8);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i8 + i7] = (byte) charAt2;
                        i8++;
                    }
                    int i9 = writableSegment.limit;
                    int i10 = (i7 + i8) - i9;
                    writableSegment.limit = i9 + i10;
                    this.size += (long) i10;
                    i5 = i8;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | PsExtractor.AUDIO_STREAM);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i11 = i5 + 1;
                        char charAt3 = i11 < i6 ? str.charAt(i11) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i5 = i11;
                        } else {
                            int i12 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i12 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            writeByte(((i12 >> 12) & 63) | 128);
                            writeByte(((i12 >> 6) & 63) | 128);
                            writeByte((i12 & 63) | 128);
                            i5 += 2;
                        }
                    }
                    i5++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i6 + " > " + str.length());
        }
    }

    private boolean rangeEquals(Segment segment, int i5, ByteString byteString, int i6, int i7) {
        int i8 = segment.limit;
        byte[] bArr = segment.data;
        while (i6 < i7) {
            if (i5 == i8) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                int i9 = segment.pos;
                bArr = bArr2;
                i5 = i9;
                i8 = segment.limit;
            }
            if (bArr[i5] != byteString.getByte(i6)) {
                return false;
            }
            i5++;
            i6++;
        }
        return true;
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i5 = 0;
        while (i5 < bArr.length) {
            int read = read(bArr, i5, bArr.length - i5);
            if (read != -1) {
                i5 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            long j5 = (long) i6;
            Util.checkOffsetAndCount((long) bArr.length, (long) i5, j5);
            int i7 = i6 + i5;
            while (i5 < i7) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i7 - i5, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i5, writableSegment.data, writableSegment.limit, min);
                i5 += min;
                writableSegment.limit += min;
            }
            this.size += j5;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j5, long j6) {
        if (buffer != null) {
            long j7 = j5;
            long j8 = j6;
            Util.checkOffsetAndCount(this.size, j7, j8);
            if (j8 != 0) {
                buffer.size += j8;
                Segment segment = this.head;
                while (true) {
                    int i5 = segment.limit;
                    int i6 = segment.pos;
                    if (j7 < ((long) (i5 - i6))) {
                        break;
                    }
                    j7 -= (long) (i5 - i6);
                    segment = segment.next;
                }
                Segment segment2 = segment;
                long j9 = j8;
                while (j9 > 0) {
                    Segment sharedCopy = segment2.sharedCopy();
                    int i7 = (int) (((long) sharedCopy.pos) + j7);
                    sharedCopy.pos = i7;
                    sharedCopy.limit = Math.min(i7 + ((int) j9), sharedCopy.limit);
                    Segment segment3 = buffer.head;
                    if (segment3 == null) {
                        sharedCopy.prev = sharedCopy;
                        sharedCopy.next = sharedCopy;
                        buffer.head = sharedCopy;
                    } else {
                        segment3.prev.push(sharedCopy);
                    }
                    j9 -= (long) (sharedCopy.limit - sharedCopy.pos);
                    segment2 = segment2.next;
                    j7 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i5 = segment.pos + min;
        segment.pos = i5;
        this.size -= (long) min;
        if (i5 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i5 = remaining;
            while (i5 > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i5, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i5 -= min;
                writableSegment.limit += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j5) throws IOException {
        Buffer buffer = this;
        if (byteString.size() != 0) {
            long j6 = 0;
            if (j5 >= 0) {
                Segment segment = buffer.head;
                long j7 = -1;
                if (segment == null) {
                    return -1;
                }
                long j8 = buffer.size;
                if (j8 - j5 < j5) {
                    while (j8 > j5) {
                        segment = segment.prev;
                        j8 -= (long) (segment.limit - segment.pos);
                    }
                } else {
                    while (true) {
                        long j9 = ((long) (segment.limit - segment.pos)) + j6;
                        if (j9 >= j5) {
                            break;
                        }
                        segment = segment.next;
                        j6 = j9;
                    }
                    j8 = j6;
                }
                ByteString byteString2 = byteString;
                byte b5 = byteString2.getByte(0);
                long j10 = j8;
                int size2 = byteString2.size();
                long j11 = (buffer.size - ((long) size2)) + 1;
                Segment segment2 = segment;
                long j12 = j5;
                while (j10 < j11) {
                    byte[] bArr = segment2.data;
                    long j13 = j7;
                    int min = (int) Math.min((long) segment2.limit, (((long) segment2.pos) + j11) - j10);
                    int i5 = (int) ((((long) segment2.pos) + j12) - j10);
                    while (i5 < min) {
                        if (bArr[i5] == b5 && buffer.rangeEquals(segment2, i5 + 1, byteString, 1, size2)) {
                            return ((long) (i5 - segment2.pos)) + j10;
                        }
                        i5++;
                        buffer = this;
                        ByteString byteString3 = byteString;
                    }
                    j10 += (long) (segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    buffer = this;
                    ByteString byteString4 = byteString;
                    j12 = j10;
                    j7 = j13;
                }
                return j7;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long read(Buffer buffer, long j5) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j5 >= 0) {
            long j6 = this.size;
            if (j6 == 0) {
                return -1;
            }
            if (j5 > j6) {
                j5 = j6;
            }
            buffer.write(this, j5);
            return j5;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        }
    }

    public BufferedSink write(Source source, long j5) throws IOException {
        while (j5 > 0) {
            long read = source.read(this, j5);
            if (read != -1) {
                j5 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public void write(Buffer buffer, long j5) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0, j5);
            while (j5 > 0) {
                Segment segment = buffer.head;
                if (j5 < ((long) (segment.limit - segment.pos))) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((((long) segment3.limit) + j5) - ((long) (segment3.shared ? 0 : segment3.pos)) <= 8192) {
                            segment.writeTo(segment3, (int) j5);
                            buffer.size -= j5;
                            this.size += j5;
                            return;
                        }
                    }
                    buffer.head = segment.split((int) j5);
                }
                Segment segment4 = buffer.head;
                long j6 = (long) (segment4.limit - segment4.pos);
                buffer.head = segment4.pop();
                Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j6;
                this.size += j6;
                j5 -= j6;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
