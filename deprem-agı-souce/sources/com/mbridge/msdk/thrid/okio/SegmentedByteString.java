package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(Buffer buffer, int i5) {
        super((byte[]) null);
        Util.checkOffsetAndCount(buffer.size, 0, (long) i5);
        Segment segment = buffer.head;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = segment.limit;
            int i10 = segment.pos;
            if (i9 != i10) {
                i7 += i9 - i10;
                i8++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i8][];
        this.directory = new int[(i8 * 2)];
        Segment segment2 = buffer.head;
        int i11 = 0;
        while (i6 < i5) {
            byte[][] bArr = this.segments;
            bArr[i11] = segment2.data;
            int i12 = segment2.limit;
            int i13 = segment2.pos;
            i6 += i12 - i13;
            if (i6 > i5) {
                i6 = i5;
            }
            int[] iArr = this.directory;
            iArr[i11] = i6;
            iArr[bArr.length + i11] = i13;
            segment2.shared = true;
            i11++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i5) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i5 + 1);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return ~binarySearch;
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public String base64() {
        return toByteString().base64();
    }

    public String base64Url() {
        return toByteString().base64Url();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() != size() || !rangeEquals(0, byteString, 0, size())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte getByte(int i5) {
        int i6;
        Util.checkOffsetAndCount((long) this.directory[this.segments.length - 1], (long) i5, 1);
        int segment = segment(i5);
        if (segment == 0) {
            i6 = 0;
        } else {
            i6 = this.directory[segment - 1];
        }
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i5 - i6) + iArr[bArr.length + segment]];
    }

    public int hashCode() {
        int i5 = this.hashCode;
        if (i5 != 0) {
            return i5;
        }
        int length = this.segments.length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            byte[] bArr = this.segments[i6];
            int[] iArr = this.directory;
            int i9 = iArr[length + i6];
            int i10 = iArr[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        this.hashCode = i7;
        return i7;
    }

    public String hex() {
        return toByteString().hex();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    public int indexOf(byte[] bArr, int i5) {
        return toByteString().indexOf(bArr, i5);
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return toByteArray();
    }

    public int lastIndexOf(byte[] bArr, int i5) {
        return toByteString().lastIndexOf(bArr, i5);
    }

    public ByteString md5() {
        return toByteString().md5();
    }

    public boolean rangeEquals(int i5, ByteString byteString, int i6, int i7) {
        int i8;
        if (i5 < 0 || i5 > size() - i7) {
            return false;
        }
        int segment = segment(i5);
        while (i7 > 0) {
            if (segment == 0) {
                i8 = 0;
            } else {
                i8 = this.directory[segment - 1];
            }
            int min = Math.min(i7, ((this.directory[segment] - i8) + i8) - i5);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i6, bArr[segment], (i5 - i8) + iArr[bArr.length + segment], min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            i7 -= min;
            segment++;
        }
        return true;
    }

    public ByteString sha1() {
        return toByteString().sha1();
    }

    public ByteString sha256() {
        return toByteString().sha256();
    }

    public int size() {
        return this.directory[this.segments.length - 1];
    }

    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    public ByteString substring(int i5) {
        return toByteString().substring(i5);
    }

    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr2 = this.directory;
            int i7 = iArr2[length + i5];
            int i8 = iArr2[i5];
            System.arraycopy(this.segments[i5], i7, bArr2, i6, i8 - i6);
            i5++;
            i6 = i8;
        }
        return bArr2;
    }

    public String toString() {
        return toByteString().toString();
    }

    public String utf8() {
        return toByteString().utf8();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int[] iArr = this.directory;
                int i7 = iArr[length + i5];
                int i8 = iArr[i5];
                outputStream.write(this.segments[i5], i7, i8 - i6);
                i5++;
                i6 = i8;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public ByteString substring(int i5, int i6) {
        return toByteString().substring(i5, i6);
    }

    /* access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr = this.directory;
            int i7 = iArr[length + i5];
            int i8 = iArr[i5];
            Segment segment = new Segment(this.segments[i5], i7, (i7 + i8) - i6, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i5++;
            i6 = i8;
        }
        buffer.size += (long) i6;
    }

    public boolean rangeEquals(int i5, byte[] bArr, int i6, int i7) {
        int i8;
        if (i5 < 0 || i5 > size() - i7 || i6 < 0 || i6 > bArr.length - i7) {
            return false;
        }
        int segment = segment(i5);
        while (i7 > 0) {
            if (segment == 0) {
                i8 = 0;
            } else {
                i8 = this.directory[segment - 1];
            }
            int min = Math.min(i7, ((this.directory[segment] - i8) + i8) - i5);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[segment], (i5 - i8) + iArr[bArr2.length + segment], bArr, i6, min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            i7 -= min;
            segment++;
        }
        return true;
    }
}
