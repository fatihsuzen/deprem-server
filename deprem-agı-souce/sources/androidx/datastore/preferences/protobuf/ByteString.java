package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() {
        public int compare(ByteString byteString, ByteString byteString2) {
            ByteIterator it = byteString.iterator();
            ByteIterator it2 = byteString2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int compareTo = Integer.valueOf(ByteString.toInt(it.nextByte())).compareTo(Integer.valueOf(ByteString.toInt(it2.nextByte())));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
        }
    };
    private static final ByteArrayCopier byteArrayCopier;
    private static final long serialVersionUID = 1;
    private int hash = 0;

    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        public byte[] copyFrom(byte[] bArr, int i5, int i6) {
            return Arrays.copyOfRange(bArr, i5, i6 + i5);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i5, int i6) {
            super(bArr);
            ByteString.checkRange(i5, i5 + i6, bArr.length);
            this.bytesOffset = i5;
            this.bytesLength = i6;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        public byte byteAt(int i5) {
            ByteString.checkIndex(i5, size());
            return this.bytes[this.bytesOffset + i5];
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i5, bArr, i6, i7);
        }

        /* access modifiers changed from: protected */
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        /* access modifiers changed from: package-private */
        public byte internalByteAt(int i5) {
            return this.bytes[this.bytesOffset + i5];
        }

        public int size() {
            return this.bytesLength;
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    private interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i5, int i6);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int i5) {
            byte[] bArr = new byte[i5];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }
    }

    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        /* access modifiers changed from: package-private */
        public abstract boolean equalsRange(ByteString byteString, int i5, int i6);

        /* access modifiers changed from: protected */
        public final int getTreeDepth() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean isBalanced() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ByteString.super.iterator();
        }

        /* access modifiers changed from: package-private */
        public void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }

        private LeafByteString() {
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            super();
            bArr.getClass();
            this.bytes = bArr;
        }

        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public byte byteAt(int i5) {
            return this.bytes[i5];
        }

        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.bytes, i5, bArr, i6, i7);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean equalsRange(ByteString byteString, int i5, int i6) {
            if (i6 <= byteString.size()) {
                int i7 = i5 + i6;
                if (i7 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i5 + ", " + i6 + ", " + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.substring(i5, i7).equals(substring(0, i6));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = literalByteString.bytes;
                    int offsetIntoBytes = getOffsetIntoBytes() + i6;
                    int offsetIntoBytes2 = getOffsetIntoBytes();
                    int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i5;
                    while (offsetIntoBytes2 < offsetIntoBytes) {
                        if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                            return false;
                        }
                        offsetIntoBytes2++;
                        offsetIntoBytes3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i6 + size());
            }
        }

        /* access modifiers changed from: protected */
        public int getOffsetIntoBytes() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public byte internalByteAt(int i5) {
            return this.bytes[i5];
        }

        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        /* access modifiers changed from: protected */
        public final int partialHash(int i5, int i6, int i7) {
            return Internal.partialHash(i5, this.bytes, getOffsetIntoBytes() + i6, i7);
        }

        /* access modifiers changed from: protected */
        public final int partialIsValidUtf8(int i5, int i6, int i7) {
            int offsetIntoBytes = getOffsetIntoBytes() + i6;
            return Utf8.partialIsValidUtf8(i5, this.bytes, offsetIntoBytes, i7 + offsetIntoBytes);
        }

        public int size() {
            return this.bytes.length;
        }

        public final ByteString substring(int i5, int i6) {
            int checkRange = ByteString.checkRange(i5, i6, size());
            if (checkRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i5, checkRange);
        }

        /* access modifiers changed from: protected */
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        /* access modifiers changed from: package-private */
        public final void writeToInternal(OutputStream outputStream, int i5, int i6) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i5, i6);
        }

        /* access modifiers changed from: package-private */
        public final void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    private static final class NioByteString extends LeafByteString {
        /* access modifiers changed from: private */
        public final ByteBuffer buffer;

        NioByteString(ByteBuffer byteBuffer) {
            super();
            Internal.checkNotNull(byteBuffer, "buffer");
            this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
        }

        private ByteBuffer slice(int i5, int i6) {
            if (i5 < this.buffer.position() || i6 > this.buffer.limit() || i5 > i6) {
                throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)}));
            }
            ByteBuffer slice = this.buffer.slice();
            Java8Compatibility.position(slice, i5 - this.buffer.position());
            Java8Compatibility.limit(slice, i6 - this.buffer.position());
            return slice;
        }

        private Object writeReplace() {
            return ByteString.copyFrom(this.buffer.slice());
        }

        public ByteBuffer asReadOnlyByteBuffer() {
            return this.buffer.asReadOnlyBuffer();
        }

        public List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public byte byteAt(int i5) {
            try {
                return this.buffer.get(i5);
            } catch (ArrayIndexOutOfBoundsException e5) {
                throw e5;
            } catch (IndexOutOfBoundsException e6) {
                throw new ArrayIndexOutOfBoundsException(e6.getMessage());
            }
        }

        public void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.buffer.slice());
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
            ByteBuffer slice = this.buffer.slice();
            Java8Compatibility.position(slice, i5);
            slice.get(bArr, i6, i7);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString)) {
                return false;
            }
            ByteString byteString = (ByteString) obj;
            if (size() != byteString.size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof NioByteString) {
                return this.buffer.equals(((NioByteString) obj).buffer);
            }
            if (obj instanceof RopeByteString) {
                return obj.equals(this);
            }
            return this.buffer.equals(byteString.asReadOnlyByteBuffer());
        }

        /* access modifiers changed from: package-private */
        public boolean equalsRange(ByteString byteString, int i5, int i6) {
            return substring(0, i6).equals(byteString.substring(i5, i6 + i5));
        }

        public byte internalByteAt(int i5) {
            return byteAt(i5);
        }

        public boolean isValidUtf8() {
            return Utf8.isValidUtf8(this.buffer);
        }

        public CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.buffer, true);
        }

        public InputStream newInput() {
            return new InputStream() {
                private final ByteBuffer buf;

                {
                    this.buf = NioByteString.this.buffer.slice();
                }

                public int available() throws IOException {
                    return this.buf.remaining();
                }

                public void mark(int i5) {
                    Java8Compatibility.mark(this.buf);
                }

                public boolean markSupported() {
                    return true;
                }

                public int read() throws IOException {
                    if (!this.buf.hasRemaining()) {
                        return -1;
                    }
                    return this.buf.get() & 255;
                }

                public void reset() throws IOException {
                    try {
                        Java8Compatibility.reset(this.buf);
                    } catch (InvalidMarkException e5) {
                        throw new IOException(e5);
                    }
                }

                public int read(byte[] bArr, int i5, int i6) throws IOException {
                    if (!this.buf.hasRemaining()) {
                        return -1;
                    }
                    int min = Math.min(i6, this.buf.remaining());
                    this.buf.get(bArr, i5, min);
                    return min;
                }
            };
        }

        /* access modifiers changed from: protected */
        public int partialHash(int i5, int i6, int i7) {
            for (int i8 = i6; i8 < i6 + i7; i8++) {
                i5 = (i5 * 31) + this.buffer.get(i8);
            }
            return i5;
        }

        /* access modifiers changed from: protected */
        public int partialIsValidUtf8(int i5, int i6, int i7) {
            return Utf8.partialIsValidUtf8(i5, this.buffer, i6, i7 + i6);
        }

        public int size() {
            return this.buffer.remaining();
        }

        public ByteString substring(int i5, int i6) {
            try {
                return new NioByteString(slice(i5, i6));
            } catch (ArrayIndexOutOfBoundsException e5) {
                throw e5;
            } catch (IndexOutOfBoundsException e6) {
                throw new ArrayIndexOutOfBoundsException(e6.getMessage());
            }
        }

        /* access modifiers changed from: protected */
        public String toStringInternal(Charset charset) {
            int i5;
            int i6;
            byte[] bArr;
            if (this.buffer.hasArray()) {
                bArr = this.buffer.array();
                i6 = this.buffer.arrayOffset() + this.buffer.position();
                i5 = this.buffer.remaining();
            } else {
                bArr = toByteArray();
                i5 = bArr.length;
                i6 = 0;
            }
            return new String(bArr, i6, i5, charset);
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        /* access modifiers changed from: package-private */
        public void writeToInternal(OutputStream outputStream, int i5, int i6) throws IOException {
            if (this.buffer.hasArray()) {
                outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i5, i6);
                return;
            }
            ByteBufferWriter.write(slice(i5, i6 + i5), outputStream);
        }

        /* access modifiers changed from: package-private */
        public void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.buffer.slice());
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        public byte[] copyFrom(byte[] bArr, int i5, int i6) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier byteArrayCopier2;
        if (Android.isOnAndroidDevice()) {
            byteArrayCopier2 = new SystemByteArrayCopier();
        } else {
            byteArrayCopier2 = new ArraysByteArrayCopier();
        }
        byteArrayCopier = byteArrayCopier2;
    }

    ByteString() {
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i5)}));
        } else if (i5 == 1) {
            return it.next();
        } else {
            int i6 = i5 >>> 1;
            return balancedConcat(it, i6).concat(balancedConcat(it, i5 - i6));
        }
    }

    static void checkIndex(int i5, int i6) {
        if (((i6 - (i5 + 1)) | i5) >= 0) {
            return;
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
    }

    @CanIgnoreReturnValue
    static int checkRange(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
        } else if (i6 < i5) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i5, int i6) {
        checkRange(i5, i5 + i6, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i5, i6));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.UTF_8));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String str, int i5) {
        int hexDigit = hexDigit(str.charAt(i5));
        if (hexDigit != -1) {
            return hexDigit;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i5) + " at index " + i5);
    }

    public static ByteString fromHex(@CompileTimeConstant String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                bArr[i5] = (byte) (extractHexDigit(str, i6 + 1) | (extractHexDigit(str, i6) << 4));
            }
            return new LiteralByteString(bArr);
        }
        throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
    }

    private static int hexDigit(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        if (c5 >= 'A' && c5 <= 'F') {
            return c5 - '7';
        }
        if (c5 < 'a' || c5 > 'f') {
            return -1;
        }
        return c5 - 'W';
    }

    static CodedBuilder newCodedBuilder(int i5) {
        return new CodedBuilder(i5);
    }

    public static Output newOutput(int i5) {
        return new Output(i5);
    }

    static ByteString nioByteString(ByteBuffer byteBuffer) {
        return new NioByteString(byteBuffer);
    }

    private static ByteString readChunk(InputStream inputStream, int i5) throws IOException {
        byte[] bArr = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            int read = inputStream.read(bArr, i6, i5 - i6);
            if (read == -1) {
                break;
            }
            i6 += read;
        }
        if (i6 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i6);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    /* access modifiers changed from: private */
    public static int toInt(byte b5) {
        return b5 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return TextFormatEscaper.escapeBytes(this);
        }
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i5);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i5) {
        copyTo(bArr, 0, i5, size());
    }

    /* access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i5, int i6, int i7);

    public final boolean endsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(size() - byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getTreeDepth();

    public final int hashCode() {
        int i5 = this.hash;
        if (i5 == 0) {
            int size = size();
            i5 = partialHash(size, 0, size);
            if (i5 == 0) {
                i5 = 1;
            }
            this.hash = i5;
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public abstract byte internalByteAt(int i5);

    /* access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    /* access modifiers changed from: protected */
    public abstract int partialHash(int i5, int i6, int i7);

    /* access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i5, int i6, int i7);

    /* access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public final ByteString substring(int i5) {
        return substring(i5, size());
    }

    public abstract ByteString substring(int i5, int i6);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e5) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e5);
            throw unsupportedEncodingException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    /* access modifiers changed from: package-private */
    public abstract void writeTo(ByteOutput byteOutput) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: package-private */
    public final void writeTo(OutputStream outputStream, int i5, int i6) throws IOException {
        checkRange(i5, i5 + i6, size());
        if (i6 > 0) {
            writeToInternal(outputStream, i5, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i5, int i6) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeToReverse(ByteOutput byteOutput) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i5) throws IOException {
        return readFrom(inputStream, i5, i5);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i5, int i6, int i7) {
        checkRange(i5, i5 + i7, size());
        checkRange(i6, i6 + i7, bArr.length);
        if (i7 > 0) {
            copyToInternal(bArr, i5, i6, i7);
        }
    }

    public ByteIterator iterator() {
        return new AbstractByteIterator() {
            private final int limit;
            private int position = 0;

            {
                this.limit = ByteString.this.size();
            }

            public boolean hasNext() {
                if (this.position < this.limit) {
                    return true;
                }
                return false;
            }

            public byte nextByte() {
                int i5 = this.position;
                if (i5 < this.limit) {
                    this.position = i5 + 1;
                    return ByteString.this.internalByteAt(i5);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i5, int i6) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i5);
            if (readChunk == null) {
                return copyFrom((Iterable<ByteString>) arrayList);
            }
            arrayList.add(readChunk);
            i5 = Math.min(i5 * 2, i6);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        Output(int i5) {
            if (i5 >= 0) {
                this.initialCapacity = i5;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i5];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void flushFullBuffer(int i5) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i5, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i5 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i5 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i5 > 0) {
                this.flushedBuffers.add(new LiteralByteString(Arrays.copyOf(bArr, i5)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom((Iterable<ByteString>) this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        public synchronized void write(int i5) {
            try {
                if (this.bufferPos == this.buffer.length) {
                    flushFullBuffer(1);
                }
                byte[] bArr = this.buffer;
                int i6 = this.bufferPos;
                this.bufferPos = i6 + 1;
                bArr[i6] = (byte) i5;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            int i5;
            ByteString[] byteStringArr;
            byte[] bArr;
            int i6;
            synchronized (this) {
                byteStringArr = (ByteString[]) this.flushedBuffers.toArray(new ByteString[0]);
                bArr = this.buffer;
                i6 = this.bufferPos;
            }
            for (ByteString writeTo : byteStringArr) {
                writeTo.writeTo(outputStream);
            }
            outputStream.write(Arrays.copyOf(bArr, i6));
        }

        public synchronized void write(byte[] bArr, int i5, int i6) {
            try {
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i7 = this.bufferPos;
                if (i6 <= length - i7) {
                    System.arraycopy(bArr, i5, bArr2, i7, i6);
                    this.bufferPos += i6;
                } else {
                    int length2 = bArr2.length - i7;
                    System.arraycopy(bArr, i5, bArr2, i7, length2);
                    int i8 = i6 - length2;
                    flushFullBuffer(i8);
                    System.arraycopy(bArr, i5 + length2, this.buffer, 0, i8);
                    this.bufferPos = i8;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i5) {
        checkRange(0, i5, byteBuffer.remaining());
        byte[] bArr = new byte[i5];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    static ByteString wrap(byte[] bArr, int i5, int i6) {
        return new BoundedByteString(bArr, i5, i6);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i5;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            i5 = 0;
            while (it.hasNext()) {
                it.next();
                i5++;
            }
        } else {
            i5 = ((Collection) iterable).size();
        }
        if (i5 == 0) {
            return EMPTY;
        }
        return balancedConcat(iterable.iterator(), i5);
    }
}
