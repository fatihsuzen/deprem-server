package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import androidx.work.WorkInfo;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    /* access modifiers changed from: private */
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int i5) {
            super();
            if (i5 >= 0) {
                byte[] bArr = new byte[Math.max(i5, 20)];
                this.buffer = bArr;
                this.limit = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void buffer(byte b5) {
            byte[] bArr = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = b5;
            this.totalBytesWritten++;
        }

        /* access modifiers changed from: package-private */
        public final void bufferFixed32NoTag(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.position;
            int i7 = i6 + 1;
            this.position = i7;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i6 + 2;
            this.position = i8;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i6 + 3;
            this.position = i9;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.position = i6 + 4;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        /* access modifiers changed from: package-private */
        public final void bufferFixed64NoTag(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.position;
            int i6 = i5 + 1;
            this.position = i6;
            bArr[i5] = (byte) ((int) (j5 & 255));
            int i7 = i5 + 2;
            this.position = i7;
            bArr[i6] = (byte) ((int) ((j5 >> 8) & 255));
            int i8 = i5 + 3;
            this.position = i8;
            bArr[i7] = (byte) ((int) ((j5 >> 16) & 255));
            int i9 = i5 + 4;
            this.position = i9;
            bArr[i8] = (byte) ((int) (255 & (j5 >> 24)));
            int i10 = i5 + 5;
            this.position = i10;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
            int i11 = i5 + 6;
            this.position = i11;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
            int i12 = i5 + 7;
            this.position = i12;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
            this.position = i5 + 8;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        /* access modifiers changed from: package-private */
        public final void bufferInt32NoTag(int i5) {
            if (i5 >= 0) {
                bufferUInt32NoTag(i5);
            } else {
                bufferUInt64NoTag((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public final void bufferTag(int i5, int i6) {
            bufferUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        /* access modifiers changed from: package-private */
        public final void bufferUInt32NoTag(int i5) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j5 = (long) this.position;
                while ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                    byte[] bArr = this.buffer;
                    int i6 = this.position;
                    this.position = i6 + 1;
                    UnsafeUtil.putByte(bArr, (long) i6, (byte) ((i5 | 128) & 255));
                    i5 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                UnsafeUtil.putByte(bArr2, (long) i7, (byte) i5);
                this.totalBytesWritten += (int) (((long) this.position) - j5);
                return;
            }
            while ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                byte[] bArr3 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr3[i8] = (byte) ((i5 | 128) & 255);
                this.totalBytesWritten++;
                i5 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i9 = this.position;
            this.position = i9 + 1;
            bArr4[i9] = (byte) i5;
            this.totalBytesWritten++;
        }

        /* access modifiers changed from: package-private */
        public final void bufferUInt64NoTag(long j5) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j6 = (long) this.position;
                while ((j5 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    UnsafeUtil.putByte(bArr, (long) i5, (byte) ((((int) j5) | 128) & 255));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                UnsafeUtil.putByte(bArr2, (long) i6, (byte) ((int) j5));
                this.totalBytesWritten += (int) (((long) this.position) - j6);
                return;
            }
            while ((j5 & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr3[i7] = (byte) ((((int) j5) | 128) & 255);
                this.totalBytesWritten++;
                j5 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            bArr4[i8] = (byte) ((int) j5);
            this.totalBytesWritten++;
        }

        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        ArrayEncoder(byte[] bArr, int i5, int i6) {
            super();
            if (bArr != null) {
                int i7 = i5 + i6;
                if ((i5 | i6 | (bArr.length - i7)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i5;
                    this.position = i5;
                    this.limit = i7;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        public final int spaceLeft() {
            return this.limit - this.position;
        }

        public final void write(byte b5) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr[i5] = b5;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeBool(int i5, boolean z4) throws IOException {
            writeTag(i5, 0);
            write(z4 ? (byte) 1 : 0);
        }

        public final void writeByteArray(int i5, byte[] bArr) throws IOException {
            writeByteArray(i5, bArr, 0, bArr.length);
        }

        public final void writeByteArrayNoTag(byte[] bArr, int i5, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        public final void writeByteBuffer(int i5, ByteBuffer byteBuffer) throws IOException {
            writeTag(i5, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public final void writeBytes(int i5, ByteString byteString) throws IOException {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public final void writeFixed32(int i5, int i6) throws IOException {
            writeTag(i5, 5);
            writeFixed32NoTag(i6);
        }

        public final void writeFixed32NoTag(int i5) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i6 = this.position;
                int i7 = i6 + 1;
                this.position = i7;
                bArr[i6] = (byte) (i5 & 255);
                int i8 = i6 + 2;
                this.position = i8;
                bArr[i7] = (byte) ((i5 >> 8) & 255);
                int i9 = i6 + 3;
                this.position = i9;
                bArr[i8] = (byte) ((i5 >> 16) & 255);
                this.position = i6 + 4;
                bArr[i9] = (byte) ((i5 >> 24) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeFixed64(int i5, long j5) throws IOException {
            writeTag(i5, 1);
            writeFixed64NoTag(j5);
        }

        public final void writeFixed64NoTag(long j5) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) (((int) j5) & 255);
                int i7 = i5 + 2;
                this.position = i7;
                bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
                int i8 = i5 + 3;
                this.position = i8;
                bArr[i7] = (byte) (((int) (j5 >> 16)) & 255);
                int i9 = i5 + 4;
                this.position = i9;
                bArr[i8] = (byte) (((int) (j5 >> 24)) & 255);
                int i10 = i5 + 5;
                this.position = i10;
                bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
                int i11 = i5 + 6;
                this.position = i11;
                bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
                int i12 = i5 + 7;
                this.position = i12;
                bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
                this.position = i5 + 8;
                bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeInt32(int i5, int i6) throws IOException {
            writeTag(i5, 0);
            writeInt32NoTag(i6);
        }

        public final void writeInt32NoTag(int i5) throws IOException {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag((long) i5);
            }
        }

        public final void writeLazy(byte[] bArr, int i5, int i6) throws IOException {
            write(bArr, i5, i6);
        }

        public final void writeMessage(int i5, MessageLite messageLite) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public final void writeMessageSetExtension(int i5, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public final void writeRawMessageSetExtension(int i5, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public final void writeString(int i5, String str) throws IOException {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        public final void writeStringNoTag(String str) throws IOException {
            int i5 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i6 = i5 + computeUInt32SizeNoTag2;
                    this.position = i6;
                    int encode = Utf8.encode(str, this.buffer, i6, spaceLeft());
                    this.position = i5;
                    writeUInt32NoTag((encode - i5) - computeUInt32SizeNoTag2);
                    this.position = encode;
                    return;
                }
                writeUInt32NoTag(Utf8.encodedLength(str));
                this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.position = i5;
                inefficientWriteStringNoTag(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        public final void writeTag(int i5, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        public final void writeUInt32(int i5, int i6) throws IOException {
            writeTag(i5, 0);
            writeUInt32NoTag(i6);
        }

        public final void writeUInt32NoTag(int i5) throws IOException {
            while ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                byte[] bArr = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr[i6] = (byte) ((i5 | 128) & 255);
                i5 >>>= 7;
            }
            try {
                byte[] bArr2 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr2[i7] = (byte) i5;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeUInt64(int i5, long j5) throws IOException {
            writeTag(i5, 0);
            writeUInt64NoTag(j5);
        }

        public final void writeUInt64NoTag(long j5) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || spaceLeft() < 10) {
                while ((j5 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    bArr[i5] = (byte) ((((int) j5) | 128) & 255);
                    j5 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i6 = this.position;
                    this.position = i6 + 1;
                    bArr2[i6] = (byte) ((int) j5);
                } catch (IndexOutOfBoundsException e5) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
                }
            } else {
                while ((j5 & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    UnsafeUtil.putByte(bArr3, (long) i7, (byte) ((((int) j5) | 128) & 255));
                    j5 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                UnsafeUtil.putByte(bArr4, (long) i8, (byte) ((int) j5));
            }
        }

        public final void writeByteArray(int i5, byte[] bArr, int i6, int i7) throws IOException {
            writeTag(i5, 2);
            writeByteArrayNoTag(bArr, i6, i7);
        }

        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public final void writeMessage(int i5, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i5, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        /* access modifiers changed from: package-private */
        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public final void write(byte[] bArr, int i5, int i6) throws IOException {
            try {
                System.arraycopy(bArr, i5, this.buffer, this.position, i6);
                this.position += i6;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i6)}), e5);
            }
        }

        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)}), e5);
            }
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput byteOutput, int i5) {
            super(i5);
            if (byteOutput != null) {
                this.out = byteOutput;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i5) throws IOException {
            if (this.limit - this.position < i5) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public void write(byte b5) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b5);
        }

        public void writeBool(int i5, boolean z4) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i5, 0);
            buffer(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i5, byte[] bArr) throws IOException {
            writeByteArray(i5, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i5, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        public void writeByteBuffer(int i5, ByteBuffer byteBuffer) throws IOException {
            writeTag(i5, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i5, ByteString byteString) throws IOException {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i5, int i6) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i5, 5);
            bufferFixed32NoTag(i6);
        }

        public void writeFixed32NoTag(int i5) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i5);
        }

        public void writeFixed64(int i5, long j5) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i5, 1);
            bufferFixed64NoTag(j5);
        }

        public void writeFixed64NoTag(long j5) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j5);
        }

        public void writeInt32(int i5, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferInt32NoTag(i6);
        }

        public void writeInt32NoTag(int i5) throws IOException {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag((long) i5);
            }
        }

        public void writeLazy(byte[] bArr, int i5, int i6) throws IOException {
            flush();
            this.out.writeLazy(bArr, i5, i6);
            this.totalBytesWritten += i6;
        }

        public void writeMessage(int i5, MessageLite messageLite) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i5, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i5, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i5, String str) throws IOException {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i5 = computeUInt32SizeNoTag + length;
            int i6 = this.limit;
            if (i5 > i6) {
                byte[] bArr = new byte[length];
                int encode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(encode);
                writeLazy(bArr, 0, encode);
                return;
            }
            if (i5 > i6 - this.position) {
                doFlush();
            }
            int i7 = this.position;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i8 = i7 + computeUInt32SizeNoTag2;
                    this.position = i8;
                    int encode2 = Utf8.encode(str, this.buffer, i8, this.limit - i8);
                    this.position = i7;
                    int i9 = (encode2 - i7) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i9);
                    this.position = encode2;
                    this.totalBytesWritten += i9;
                    return;
                }
                int encodedLength = Utf8.encodedLength(str);
                bufferUInt32NoTag(encodedLength);
                this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                this.totalBytesWritten += encodedLength;
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.totalBytesWritten -= this.position - i7;
                this.position = i7;
                inefficientWriteStringNoTag(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        public void writeTag(int i5, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferUInt32NoTag(i6);
        }

        public void writeUInt32NoTag(int i5) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i5);
        }

        public void writeUInt64(int i5, long j5) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferUInt64NoTag(j5);
        }

        public void writeUInt64NoTag(long j5) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j5);
        }

        public void writeByteArray(int i5, byte[] bArr, int i6, int i7) throws IOException {
            writeTag(i5, 2);
            writeByteArrayNoTag(bArr, i6, i7);
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i5, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i5, int i6) throws IOException {
            flush();
            this.out.write(bArr, i5, i6);
            this.totalBytesWritten += i6;
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += remaining;
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer byteBuffer2) {
            super(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), byteBuffer2.remaining());
            this.byteBuffer = byteBuffer2;
            this.initialPosition = byteBuffer2.position();
        }

        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream outputStream, int i5) {
            super(i5);
            if (outputStream != null) {
                this.out = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i5) throws IOException {
            if (this.limit - this.position < i5) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public void write(byte b5) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b5);
        }

        public void writeBool(int i5, boolean z4) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i5, 0);
            buffer(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i5, byte[] bArr) throws IOException {
            writeByteArray(i5, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i5, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        public void writeByteBuffer(int i5, ByteBuffer byteBuffer) throws IOException {
            writeTag(i5, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i5, ByteString byteString) throws IOException {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i5, int i6) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i5, 5);
            bufferFixed32NoTag(i6);
        }

        public void writeFixed32NoTag(int i5) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i5);
        }

        public void writeFixed64(int i5, long j5) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i5, 1);
            bufferFixed64NoTag(j5);
        }

        public void writeFixed64NoTag(long j5) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j5);
        }

        public void writeInt32(int i5, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferInt32NoTag(i6);
        }

        public void writeInt32NoTag(int i5) throws IOException {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag((long) i5);
            }
        }

        public void writeLazy(byte[] bArr, int i5, int i6) throws IOException {
            write(bArr, i5, i6);
        }

        public void writeMessage(int i5, MessageLite messageLite) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i5, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i5, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i5, String str) throws IOException {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int i5;
            int i6;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i7 = computeUInt32SizeNoTag + length;
                int i8 = this.limit;
                if (i7 > i8) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i7 > i8 - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                i5 = this.position;
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i9 = i5 + computeUInt32SizeNoTag2;
                    this.position = i9;
                    int encode2 = Utf8.encode(str, this.buffer, i9, this.limit - i9);
                    this.position = i5;
                    i6 = (encode2 - i5) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i6);
                    this.position = encode2;
                } else {
                    i6 = Utf8.encodedLength(str);
                    bufferUInt32NoTag(i6);
                    this.position = Utf8.encode(str, this.buffer, this.position, i6);
                }
                this.totalBytesWritten += i6;
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.totalBytesWritten -= this.position - i5;
                this.position = i5;
                throw e5;
            } catch (ArrayIndexOutOfBoundsException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            } catch (Utf8.UnpairedSurrogateException e7) {
                inefficientWriteStringNoTag(str, e7);
            }
        }

        public void writeTag(int i5, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferUInt32NoTag(i6);
        }

        public void writeUInt32NoTag(int i5) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i5);
        }

        public void writeUInt64(int i5, long j5) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferUInt64NoTag(j5);
        }

        public void writeUInt64NoTag(long j5) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j5);
        }

        public void writeByteArray(int i5, byte[] bArr, int i6, int i7) throws IOException {
            writeTag(i5, 2);
            writeByteArrayNoTag(bArr, i6, i7);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i5, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i5, int i6) throws IOException {
            int i7 = this.limit;
            int i8 = this.position;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i5, this.buffer, i8, i6);
                this.position += i6;
                this.totalBytesWritten += i6;
                return;
            }
            int i9 = i7 - i8;
            System.arraycopy(bArr, i5, this.buffer, i8, i9);
            int i10 = i5 + i9;
            int i11 = i6 - i9;
            this.position = this.limit;
            this.totalBytesWritten += i9;
            doFlush();
            if (i11 <= this.limit) {
                System.arraycopy(bArr, i10, this.buffer, 0, i11);
                this.position = i11;
            } else {
                this.out.write(bArr, i10, i11);
            }
            this.totalBytesWritten += i11;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i5 = this.limit;
            int i6 = this.position;
            if (i5 - i6 >= remaining) {
                byteBuffer.get(this.buffer, i6, remaining);
                this.position += remaining;
                this.totalBytesWritten += remaining;
                return;
            }
            int i7 = i5 - i6;
            byteBuffer.get(this.buffer, i6, i7);
            int i8 = remaining - i7;
            this.position = this.limit;
            this.totalBytesWritten += i7;
            doFlush();
            while (true) {
                int i9 = this.limit;
                if (i8 > i9) {
                    byteBuffer.get(this.buffer, 0, i9);
                    this.out.write(this.buffer, 0, this.limit);
                    int i10 = this.limit;
                    i8 -= i10;
                    this.totalBytesWritten += i10;
                } else {
                    byteBuffer.get(this.buffer, 0, i8);
                    this.position = i8;
                    this.totalBytesWritten += i8;
                    return;
                }
            }
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        public int spaceLeft() {
            return this.buffer.remaining();
        }

        public void write(byte b5) throws IOException {
            try {
                this.buffer.put(b5);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeBool(int i5, boolean z4) throws IOException {
            writeTag(i5, 0);
            write(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i5, byte[] bArr) throws IOException {
            writeByteArray(i5, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i5, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        public void writeByteBuffer(int i5, ByteBuffer byteBuffer) throws IOException {
            writeTag(i5, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i5, ByteString byteString) throws IOException {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i5, int i6) throws IOException {
            writeTag(i5, 5);
            writeFixed32NoTag(i6);
        }

        public void writeFixed32NoTag(int i5) throws IOException {
            try {
                this.buffer.putInt(i5);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeFixed64(int i5, long j5) throws IOException {
            writeTag(i5, 1);
            writeFixed64NoTag(j5);
        }

        public void writeFixed64NoTag(long j5) throws IOException {
            try {
                this.buffer.putLong(j5);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeInt32(int i5, int i6) throws IOException {
            writeTag(i5, 0);
            writeInt32NoTag(i6);
        }

        public void writeInt32NoTag(int i5) throws IOException {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag((long) i5);
            }
        }

        public void writeLazy(byte[] bArr, int i5, int i6) throws IOException {
            write(bArr, i5, i6);
        }

        public void writeMessage(int i5, MessageLite messageLite) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i5, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i5, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i5, String str) throws IOException {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, position2);
                    encode(str);
                    int position3 = this.buffer.position();
                    Java8Compatibility.position(this.buffer, position);
                    writeUInt32NoTag(position3 - position2);
                    Java8Compatibility.position(this.buffer, position3);
                    return;
                }
                writeUInt32NoTag(Utf8.encodedLength(str));
                encode(str);
            } catch (Utf8.UnpairedSurrogateException e5) {
                Java8Compatibility.position(this.buffer, position);
                inefficientWriteStringNoTag(str, e5);
            } catch (IllegalArgumentException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        public void writeTag(int i5, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) throws IOException {
            writeTag(i5, 0);
            writeUInt32NoTag(i6);
        }

        public void writeUInt32NoTag(int i5) throws IOException {
            while ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                this.buffer.put((byte) ((i5 | 128) & 255));
                i5 >>>= 7;
            }
            try {
                this.buffer.put((byte) i5);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeUInt64(int i5, long j5) throws IOException {
            writeTag(i5, 0);
            writeUInt64NoTag(j5);
        }

        public void writeUInt64NoTag(long j5) throws IOException {
            while ((-128 & j5) != 0) {
                this.buffer.put((byte) ((((int) j5) | 128) & 255));
                j5 >>>= 7;
            }
            try {
                this.buffer.put((byte) ((int) j5));
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeByteArray(int i5, byte[] bArr, int i6, int i7) throws IOException {
            writeTag(i5, 2);
            writeByteArrayNoTag(bArr, i6, i7);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i5, int i6) throws IOException {
            try {
                this.buffer.put(bArr, i5, i6);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            } catch (BufferOverflowException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i5, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            long position2 = ((long) byteBuffer.position()) + addressOffset;
            this.initialPosition = position2;
            long limit2 = addressOffset + ((long) byteBuffer.limit());
            this.limit = limit2;
            this.oneVarintLimit = limit2 - 10;
            this.position = position2;
        }

        private int bufferPos(long j5) {
            return (int) (j5 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j5) {
            Java8Compatibility.position(this.buffer, bufferPos(j5));
        }

        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        public void write(byte b5) throws IOException {
            long j5 = this.position;
            if (j5 < this.limit) {
                this.position = 1 + j5;
                UnsafeUtil.putByte(j5, b5);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        public void writeBool(int i5, boolean z4) throws IOException {
            writeTag(i5, 0);
            write(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i5, byte[] bArr) throws IOException {
            writeByteArray(i5, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i5, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        public void writeByteBuffer(int i5, ByteBuffer byteBuffer) throws IOException {
            writeTag(i5, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i5, ByteString byteString) throws IOException {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i5, int i6) throws IOException {
            writeTag(i5, 5);
            writeFixed32NoTag(i6);
        }

        public void writeFixed32NoTag(int i5) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i5);
            this.position += 4;
        }

        public void writeFixed64(int i5, long j5) throws IOException {
            writeTag(i5, 1);
            writeFixed64NoTag(j5);
        }

        public void writeFixed64NoTag(long j5) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j5);
            this.position += 8;
        }

        public void writeInt32(int i5, int i6) throws IOException {
            writeTag(i5, 0);
            writeInt32NoTag(i6);
        }

        public void writeInt32NoTag(int i5) throws IOException {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag((long) i5);
            }
        }

        public void writeLazy(byte[] bArr, int i5, int i6) throws IOException {
            write(bArr, i5, i6);
        }

        public void writeMessage(int i5, MessageLite messageLite) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i5, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i5, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i5, String str) throws IOException {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            long j5 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, bufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int position2 = this.buffer.position() - bufferPos;
                    writeUInt32NoTag(position2);
                    this.position += (long) position2;
                    return;
                }
                int encodedLength = Utf8.encodedLength(str);
                writeUInt32NoTag(encodedLength);
                repositionBuffer(this.position);
                Utf8.encodeUtf8(str, this.buffer);
                this.position += (long) encodedLength;
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.position = j5;
                repositionBuffer(j5);
                inefficientWriteStringNoTag(str, e5);
            } catch (IllegalArgumentException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            } catch (IndexOutOfBoundsException e7) {
                throw new OutOfSpaceException((Throwable) e7);
            }
        }

        public void writeTag(int i5, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) throws IOException {
            writeTag(i5, 0);
            writeUInt32NoTag(i6);
        }

        public void writeUInt32NoTag(int i5) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                    long j5 = this.position;
                    this.position = j5 + 1;
                    UnsafeUtil.putByte(j5, (byte) ((i5 | 128) & 255));
                    i5 >>>= 7;
                }
                long j6 = this.position;
                this.position = 1 + j6;
                UnsafeUtil.putByte(j6, (byte) i5);
                return;
            }
            while (true) {
                long j7 = this.position;
                if (j7 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                    this.position = 1 + j7;
                    UnsafeUtil.putByte(j7, (byte) i5);
                    return;
                } else {
                    this.position = j7 + 1;
                    UnsafeUtil.putByte(j7, (byte) ((i5 | 128) & 255));
                    i5 >>>= 7;
                }
            }
        }

        public void writeUInt64(int i5, long j5) throws IOException {
            writeTag(i5, 0);
            writeUInt64NoTag(j5);
        }

        public void writeUInt64NoTag(long j5) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j5 & -128) != 0) {
                    long j6 = this.position;
                    this.position = j6 + 1;
                    UnsafeUtil.putByte(j6, (byte) ((((int) j5) | 128) & 255));
                    j5 >>>= 7;
                }
                long j7 = this.position;
                this.position = 1 + j7;
                UnsafeUtil.putByte(j7, (byte) ((int) j5));
                return;
            }
            while (true) {
                long j8 = this.position;
                if (j8 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((j5 & -128) == 0) {
                    this.position = 1 + j8;
                    UnsafeUtil.putByte(j8, (byte) ((int) j5));
                    return;
                } else {
                    this.position = j8 + 1;
                    UnsafeUtil.putByte(j8, (byte) ((((int) j5) | 128) & 255));
                    j5 >>>= 7;
                }
            }
        }

        public void writeByteArray(int i5, byte[] bArr, int i6, int i7) throws IOException {
            writeTag(i5, 2);
            writeByteArrayNoTag(bArr, i6, i7);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i5, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i5, int i6) throws IOException {
            if (bArr != null && i5 >= 0 && i6 >= 0 && bArr.length - i6 >= i5) {
                long j5 = (long) i6;
                long j6 = this.position;
                if (this.limit - j5 >= j6) {
                    UnsafeUtil.copyMemory(bArr, (long) i5, j6, j5);
                    this.position += j5;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i6)}));
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += (long) remaining;
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }
    }

    public static int computeBoolSize(int i5, boolean z4) {
        return computeTagSize(i5) + computeBoolSizeNoTag(z4);
    }

    public static int computeBoolSizeNoTag(boolean z4) {
        return 1;
    }

    public static int computeByteArraySize(int i5, byte[] bArr) {
        return computeTagSize(i5) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i5, ByteBuffer byteBuffer) {
        return computeTagSize(i5) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i5, ByteString byteString) {
        return computeTagSize(i5) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i5, double d5) {
        return computeTagSize(i5) + computeDoubleSizeNoTag(d5);
    }

    public static int computeDoubleSizeNoTag(double d5) {
        return 8;
    }

    public static int computeEnumSize(int i5, int i6) {
        return computeTagSize(i5) + computeEnumSizeNoTag(i6);
    }

    public static int computeEnumSizeNoTag(int i5) {
        return computeInt32SizeNoTag(i5);
    }

    public static int computeFixed32Size(int i5, int i6) {
        return computeTagSize(i5) + computeFixed32SizeNoTag(i6);
    }

    public static int computeFixed32SizeNoTag(int i5) {
        return 4;
    }

    public static int computeFixed64Size(int i5, long j5) {
        return computeTagSize(i5) + computeFixed64SizeNoTag(j5);
    }

    public static int computeFixed64SizeNoTag(long j5) {
        return 8;
    }

    public static int computeFloatSize(int i5, float f5) {
        return computeTagSize(i5) + computeFloatSizeNoTag(f5);
    }

    public static int computeFloatSizeNoTag(float f5) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i5, MessageLite messageLite) {
        return (computeTagSize(i5) * 2) + messageLite.getSerializedSize();
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeInt32SizeNoTag(i6);
    }

    public static int computeInt32SizeNoTag(int i5) {
        return computeUInt64SizeNoTag((long) i5);
    }

    public static int computeInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeInt64SizeNoTag(j5);
    }

    public static int computeInt64SizeNoTag(long j5) {
        return computeUInt64SizeNoTag(j5);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i5, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i5) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i5, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i5) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    static int computeLengthDelimitedFieldSize(int i5) {
        return computeUInt32SizeNoTag(i5) + i5;
    }

    public static int computeMessageSetExtensionSize(int i5, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i5) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i5, MessageLite messageLite) {
        return computeTagSize(i5) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    static int computePreferredBufferSize(int i5) {
        if (i5 > 4096) {
            return 4096;
        }
        return i5;
    }

    public static int computeRawMessageSetExtensionSize(int i5, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i5) + computeBytesSize(3, byteString);
    }

    @InlineMe(imports = {"androidx.datastore.preferences.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i5) {
        return computeUInt32SizeNoTag(i5);
    }

    @InlineMe(imports = {"androidx.datastore.preferences.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j5) {
        return computeUInt64SizeNoTag(j5);
    }

    public static int computeSFixed32Size(int i5, int i6) {
        return computeTagSize(i5) + computeSFixed32SizeNoTag(i6);
    }

    public static int computeSFixed32SizeNoTag(int i5) {
        return 4;
    }

    public static int computeSFixed64Size(int i5, long j5) {
        return computeTagSize(i5) + computeSFixed64SizeNoTag(j5);
    }

    public static int computeSFixed64SizeNoTag(long j5) {
        return 8;
    }

    public static int computeSInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeSInt32SizeNoTag(i6);
    }

    public static int computeSInt32SizeNoTag(int i5) {
        return computeUInt32SizeNoTag(encodeZigZag32(i5));
    }

    public static int computeSInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeSInt64SizeNoTag(j5);
    }

    public static int computeSInt64SizeNoTag(long j5) {
        return computeUInt64SizeNoTag(encodeZigZag64(j5));
    }

    public static int computeStringSize(int i5, String str) {
        return computeTagSize(i5) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int i5;
        try {
            i5 = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i5 = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(i5);
    }

    public static int computeTagSize(int i5) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i5, 0));
    }

    public static int computeUInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeUInt32SizeNoTag(i6);
    }

    public static int computeUInt32SizeNoTag(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int computeUInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeUInt64SizeNoTag(j5);
    }

    public static int computeUInt64SizeNoTag(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public static int encodeZigZag32(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long encodeZigZag64(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    /* access modifiers changed from: package-private */
    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new OutOfSpaceException((Throwable) e5);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    public abstract void write(byte b5) throws IOException;

    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    public abstract void write(byte[] bArr, int i5, int i6) throws IOException;

    public abstract void writeBool(int i5, boolean z4) throws IOException;

    public final void writeBoolNoTag(boolean z4) throws IOException {
        write(z4 ? (byte) 1 : 0);
    }

    public abstract void writeByteArray(int i5, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i5, byte[] bArr, int i6, int i7) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public abstract void writeByteArrayNoTag(byte[] bArr, int i5, int i6) throws IOException;

    public abstract void writeByteBuffer(int i5, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i5, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i5, double d5) throws IOException {
        writeFixed64(i5, Double.doubleToRawLongBits(d5));
    }

    public final void writeDoubleNoTag(double d5) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d5));
    }

    public final void writeEnum(int i5, int i6) throws IOException {
        writeInt32(i5, i6);
    }

    public final void writeEnumNoTag(int i5) throws IOException {
        writeInt32NoTag(i5);
    }

    public abstract void writeFixed32(int i5, int i6) throws IOException;

    public abstract void writeFixed32NoTag(int i5) throws IOException;

    public abstract void writeFixed64(int i5, long j5) throws IOException;

    public abstract void writeFixed64NoTag(long j5) throws IOException;

    public final void writeFloat(int i5, float f5) throws IOException {
        writeFixed32(i5, Float.floatToRawIntBits(f5));
    }

    public final void writeFloatNoTag(float f5) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f5));
    }

    @Deprecated
    public final void writeGroup(int i5, MessageLite messageLite) throws IOException {
        writeTag(i5, 3);
        writeGroupNoTag(messageLite);
        writeTag(i5, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i5, int i6) throws IOException;

    public abstract void writeInt32NoTag(int i5) throws IOException;

    public final void writeInt64(int i5, long j5) throws IOException {
        writeUInt64(i5, j5);
    }

    public final void writeInt64NoTag(long j5) throws IOException {
        writeUInt64NoTag(j5);
    }

    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    public abstract void writeLazy(byte[] bArr, int i5, int i6) throws IOException;

    public abstract void writeMessage(int i5, MessageLite messageLite) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeMessage(int i5, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int i5, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b5) throws IOException {
        write(b5);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i5) throws IOException {
        writeFixed32NoTag(i5);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j5) throws IOException {
        writeFixed64NoTag(j5);
    }

    public abstract void writeRawMessageSetExtension(int i5, ByteString byteString) throws IOException;

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i5) throws IOException {
        writeUInt32NoTag(i5);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j5) throws IOException {
        writeUInt64NoTag(j5);
    }

    public final void writeSFixed32(int i5, int i6) throws IOException {
        writeFixed32(i5, i6);
    }

    public final void writeSFixed32NoTag(int i5) throws IOException {
        writeFixed32NoTag(i5);
    }

    public final void writeSFixed64(int i5, long j5) throws IOException {
        writeFixed64(i5, j5);
    }

    public final void writeSFixed64NoTag(long j5) throws IOException {
        writeFixed64NoTag(j5);
    }

    public final void writeSInt32(int i5, int i6) throws IOException {
        writeUInt32(i5, encodeZigZag32(i6));
    }

    public final void writeSInt32NoTag(int i5) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i5));
    }

    public final void writeSInt64(int i5, long j5) throws IOException {
        writeUInt64(i5, encodeZigZag64(j5));
    }

    public final void writeSInt64NoTag(long j5) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j5));
    }

    public abstract void writeString(int i5, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i5, int i6) throws IOException;

    public abstract void writeUInt32(int i5, int i6) throws IOException;

    public abstract void writeUInt32NoTag(int i5) throws IOException;

    public abstract void writeUInt64(int i5, long j5) throws IOException;

    public abstract void writeUInt64NoTag(long j5) throws IOException;

    private CodedOutputStream() {
    }

    @Deprecated
    static int computeGroupSize(int i5, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i5) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    static int computeMessageSize(int i5, MessageLite messageLite, Schema schema) {
        return computeTagSize(i5) + computeMessageSizeNoTag(messageLite, schema);
    }

    static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i5) {
        return new OutputStreamEncoder(outputStream, i5);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    public final void writeRawByte(int i5) throws IOException {
        write((byte) i5);
    }

    public final void writeRawBytes(byte[] bArr, int i5, int i6) throws IOException {
        write(bArr, i5, i6);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo((ByteOutput) this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i5, int i6) {
        return new ArrayEncoder(bArr, i5, i6);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void writeGroup(int i5, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i5, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i5, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (UnsafeDirectNioEncoder.isSupported()) {
            return newUnsafeInstance(byteBuffer);
        } else {
            return newSafeInstance(byteBuffer);
        }
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i5) {
        return newInstance(byteBuffer);
    }

    static CodedOutputStream newInstance(ByteOutput byteOutput, int i5) {
        if (i5 >= 0) {
            return new ByteOutputEncoder(byteOutput, i5);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
