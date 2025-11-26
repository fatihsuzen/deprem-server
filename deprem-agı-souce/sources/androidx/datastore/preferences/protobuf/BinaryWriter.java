package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import androidx.work.WorkInfo;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator bufferAllocator, int i5) {
            super(bufferAllocator, i5, (AnonymousClass1) null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int i5) {
            ByteBuffer byteBuffer = this.buffer;
            int i6 = this.pos;
            this.pos = i6 - 1;
            byteBuffer.put(i6, (byte) (i5 >>> 28));
            int i7 = this.pos;
            this.pos = i7 - 4;
            this.buffer.putInt(i7 - 3, (i5 & 127) | 128 | ((((i5 >>> 21) & 127) | 128) << 24) | ((((i5 >>> 14) & 127) | 128) << 16) | ((((i5 >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i5) {
            int i6 = this.pos;
            this.pos = i6 - 4;
            this.buffer.putInt(i6 - 3, (i5 & 127) | 128 | ((266338304 & i5) << 3) | (((2080768 & i5) | 2097152) << 2) | (((i5 & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i5) {
            ByteBuffer byteBuffer = this.buffer;
            int i6 = this.pos;
            this.pos = i6 - 1;
            byteBuffer.put(i6, (byte) i5);
        }

        private void writeVarint32ThreeBytes(int i5) {
            int i6 = this.pos - 3;
            this.pos = i6;
            this.buffer.putInt(i6, (((i5 & 127) | 128) << 8) | ((2080768 & i5) << 10) | (((i5 & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i5) {
            int i6 = this.pos;
            this.pos = i6 - 2;
            this.buffer.putShort(i6 - 1, (short) ((i5 & 127) | 128 | ((i5 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j5) {
            int i5 = this.pos;
            this.pos = i5 - 8;
            this.buffer.putLong(i5 - 7, (j5 & 127) | 128 | ((71494644084506624L & j5) << 7) | (((558551906910208L & j5) | 562949953421312L) << 6) | (((4363686772736L & j5) | 4398046511104L) << 5) | (((34091302912L & j5) | 34359738368L) << 4) | (((266338304 & j5) | 268435456) << 3) | (((2080768 & j5) | CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) << 2) | (((16256 & j5) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j5) {
            int i5 = this.pos;
            this.pos = i5 - 8;
            this.buffer.putLong(i5 - 7, (j5 & 127) | 128 | (((71494644084506624L & j5) | 72057594037927936L) << 7) | (((558551906910208L & j5) | 562949953421312L) << 6) | (((4363686772736L & j5) | 4398046511104L) << 5) | (((34091302912L & j5) | 34359738368L) << 4) | (((266338304 & j5) | 268435456) << 3) | (((2080768 & j5) | CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) << 2) | (((16256 & j5) | 16384) << 1));
        }

        private void writeVarint64FiveBytes(long j5) {
            int i5 = this.pos;
            this.pos = i5 - 5;
            this.buffer.putLong(i5 - 7, (((j5 & 127) | 128) << 24) | ((34091302912L & j5) << 28) | (((266338304 & j5) | 268435456) << 27) | (((2080768 & j5) | CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) << 26) | (((16256 & j5) | 16384) << 25));
        }

        private void writeVarint64FourBytes(long j5) {
            writeVarint32FourBytes((int) j5);
        }

        private void writeVarint64NineBytes(long j5) {
            ByteBuffer byteBuffer = this.buffer;
            int i5 = this.pos;
            this.pos = i5 - 1;
            byteBuffer.put(i5, (byte) ((int) (j5 >>> 56)));
            writeVarint64EightBytesWithSign(j5 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j5) {
            writeVarint32OneByte((int) j5);
        }

        private void writeVarint64SevenBytes(long j5) {
            int i5 = this.pos - 7;
            this.pos = i5;
            this.buffer.putLong(i5, (((j5 & 127) | 128) << 8) | ((558551906910208L & j5) << 14) | (((4363686772736L & j5) | 4398046511104L) << 13) | (((34091302912L & j5) | 34359738368L) << 12) | (((266338304 & j5) | 268435456) << 11) | (((2080768 & j5) | CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) << 10) | (((16256 & j5) | 16384) << 9));
        }

        private void writeVarint64SixBytes(long j5) {
            int i5 = this.pos;
            this.pos = i5 - 6;
            this.buffer.putLong(i5 - 7, (((j5 & 127) | 128) << 16) | ((4363686772736L & j5) << 21) | (((34091302912L & j5) | 34359738368L) << 20) | (((266338304 & j5) | 268435456) << 19) | (((2080768 & j5) | CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) << 18) | (((16256 & j5) | 16384) << 17));
        }

        private void writeVarint64TenBytes(long j5) {
            ByteBuffer byteBuffer = this.buffer;
            int i5 = this.pos;
            this.pos = i5 - 1;
            byteBuffer.put(i5, (byte) ((int) (j5 >>> 63)));
            ByteBuffer byteBuffer2 = this.buffer;
            int i6 = this.pos;
            this.pos = i6 - 1;
            byteBuffer2.put(i6, (byte) ((int) (((j5 >>> 56) & 127) | 128)));
            writeVarint64EightBytesWithSign(j5 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j5) {
            writeVarint32ThreeBytes((int) j5);
        }

        private void writeVarint64TwoBytes(long j5) {
            writeVarint32TwoBytes((int) j5);
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                Java8Compatibility.position(this.buffer, this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i5) {
            if (spaceLeft() < i5) {
                nextBuffer(i5);
            }
        }

        public void write(byte b5) {
            ByteBuffer byteBuffer = this.buffer;
            int i5 = this.pos;
            this.pos = i5 - 1;
            byteBuffer.put(i5, b5);
        }

        public void writeBool(int i5, boolean z4) {
            requireSpace(6);
            write(z4 ? (byte) 1 : 0);
            writeTag(i5, 0);
        }

        public void writeBytes(int i5, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i5, 2);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Deprecated
        public void writeEndGroup(int i5) {
            writeTag(i5, 4);
        }

        public void writeFixed32(int i5, int i6) {
            requireSpace(9);
            writeFixed32(i6);
            writeTag(i5, 5);
        }

        public void writeFixed64(int i5, long j5) {
            requireSpace(13);
            writeFixed64(j5);
            writeTag(i5, 1);
        }

        @Deprecated
        public void writeGroup(int i5, Object obj) throws IOException {
            writeTag(i5, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i5, 3);
        }

        public void writeInt32(int i5, int i6) {
            requireSpace(15);
            writeInt32(i6);
            writeTag(i5, 0);
        }

        public void writeLazy(byte[] bArr, int i5, int i6) {
            if (spaceLeft() < i6) {
                this.totalDoneBytes += i6;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i5, i6));
                nextBuffer();
                return;
            }
            int i7 = this.pos - i6;
            this.pos = i7;
            Java8Compatibility.position(this.buffer, i7 + 1);
            this.buffer.put(bArr, i5, i6);
        }

        public void writeMessage(int i5, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        public void writeSInt32(int i5, int i6) {
            requireSpace(10);
            writeSInt32(i6);
            writeTag(i5, 0);
        }

        public void writeSInt64(int i5, long j5) {
            requireSpace(15);
            writeSInt64(j5);
            writeTag(i5, 0);
        }

        @Deprecated
        public void writeStartGroup(int i5) {
            writeTag(i5, 3);
        }

        public void writeString(int i5, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i5, int i6) {
            writeVarint32(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) {
            requireSpace(10);
            writeVarint32(i6);
            writeTag(i5, 0);
        }

        public void writeUInt64(int i5, long j5) {
            requireSpace(15);
            writeVarint64(j5);
            writeTag(i5, 0);
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i5) {
            if ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                writeVarint32OneByte(i5);
            } else if ((i5 & -16384) == 0) {
                writeVarint32TwoBytes(i5);
            } else if ((-2097152 & i5) == 0) {
                writeVarint32ThreeBytes(i5);
            } else if ((-268435456 & i5) == 0) {
                writeVarint32FourBytes(i5);
            } else {
                writeVarint32FiveBytes(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j5) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j5)) {
                case 1:
                    writeVarint64OneByte(j5);
                    return;
                case 2:
                    writeVarint64TwoBytes(j5);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j5);
                    return;
                case 4:
                    writeVarint64FourBytes(j5);
                    return;
                case 5:
                    writeVarint64FiveBytes(j5);
                    return;
                case 6:
                    writeVarint64SixBytes(j5);
                    return;
                case 7:
                    writeVarint64SevenBytes(j5);
                    return;
                case 8:
                    writeVarint64EightBytes(j5);
                    return;
                case 9:
                    writeVarint64NineBytes(j5);
                    return;
                case 10:
                    writeVarint64TenBytes(j5);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i5) {
            nextBuffer(newDirectBuffer(i5));
        }

        public void write(byte[] bArr, int i5, int i6) {
            if (spaceLeft() < i6) {
                nextBuffer(i6);
            }
            int i7 = this.pos - i6;
            this.pos = i7;
            Java8Compatibility.position(this.buffer, i7 + 1);
            this.buffer.put(bArr, i5, i6);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    Java8Compatibility.limit(nioBuffer, nioBuffer.capacity());
                    Java8Compatibility.position(this.buffer, 0);
                    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.buffer.limit() - 1;
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z4) {
            write(z4 ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i5) {
            int i6 = this.pos;
            this.pos = i6 - 4;
            this.buffer.putInt(i6 - 3, i5);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j5) {
            int i5 = this.pos;
            this.pos = i5 - 8;
            this.buffer.putLong(i5 - 7, j5);
        }

        public void writeGroup(int i5, Object obj, Schema schema) throws IOException {
            writeTag(i5, 4);
            schema.writeTo(obj, this);
            writeTag(i5, 3);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i5) {
            if (i5 >= 0) {
                writeVarint32(i5);
            } else {
                writeVarint64((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i5) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i5));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j5) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j5));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i5 = this.pos - remaining;
            this.pos = i5;
            Java8Compatibility.position(this.buffer, i5 + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeMessage(int i5, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            int i5;
            int i6;
            int i7;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i7 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i7 - 1;
                    byteBuffer.put(i7, (byte) charAt2);
                } else if (charAt2 < 2048 && (i6 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i6 - 1;
                    byteBuffer2.put(i6, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i8 = this.pos;
                    this.pos = i8 - 1;
                    byteBuffer3.put(i8, (byte) ((charAt2 >>> 6) | 960));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i5 = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = i5 - 1;
                    byteBuffer4.put(i5, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i9 = this.pos;
                    this.pos = i9 - 1;
                    byteBuffer5.put(i9, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i10 = this.pos;
                    this.pos = i10 - 1;
                    byteBuffer6.put(i10, (byte) ((charAt2 >>> 12) | 480));
                } else if (this.pos > 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            ByteBuffer byteBuffer7 = this.buffer;
                            int i11 = this.pos;
                            this.pos = i11 - 1;
                            byteBuffer7.put(i11, (byte) ((codePoint & 63) | 128));
                            ByteBuffer byteBuffer8 = this.buffer;
                            int i12 = this.pos;
                            this.pos = i12 - 1;
                            byteBuffer8.put(i12, (byte) (((codePoint >>> 6) & 63) | 128));
                            ByteBuffer byteBuffer9 = this.buffer;
                            int i13 = this.pos;
                            this.pos = i13 - 1;
                            byteBuffer9.put(i13, (byte) (((codePoint >>> 12) & 63) | 128));
                            ByteBuffer byteBuffer10 = this.buffer;
                            int i14 = this.pos;
                            this.pos = i14 - 1;
                            byteBuffer10.put(i14, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            int i5 = this.pos - remaining;
            this.pos = i5;
            Java8Compatibility.position(this.buffer, i5 + 1);
            this.buffer.put(byteBuffer);
        }
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator bufferAllocator, int i5) {
            super(bufferAllocator, i5, (AnonymousClass1) null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (i5 >>> 28);
            int i8 = i6 - 2;
            this.pos = i8;
            bArr[i7] = (byte) (((i5 >>> 21) & 127) | 128);
            int i9 = i6 - 3;
            this.pos = i9;
            bArr[i8] = (byte) (((i5 >>> 14) & 127) | 128);
            int i10 = i6 - 4;
            this.pos = i10;
            bArr[i9] = (byte) (((i5 >>> 7) & 127) | 128);
            this.pos = i6 - 5;
            bArr[i10] = (byte) ((i5 & 127) | 128);
        }

        private void writeVarint32FourBytes(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (i5 >>> 21);
            int i8 = i6 - 2;
            this.pos = i8;
            bArr[i7] = (byte) (((i5 >>> 14) & 127) | 128);
            int i9 = i6 - 3;
            this.pos = i9;
            bArr[i8] = (byte) (((i5 >>> 7) & 127) | 128);
            this.pos = i6 - 4;
            bArr[i9] = (byte) ((i5 & 127) | 128);
        }

        private void writeVarint32OneByte(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) i5;
        }

        private void writeVarint32ThreeBytes(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (i5 >>> 14);
            int i8 = i6 - 2;
            this.pos = i8;
            bArr[i7] = (byte) (((i5 >>> 7) & 127) | 128);
            this.pos = i6 - 3;
            bArr[i8] = (byte) ((i5 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (i5 >>> 7);
            this.pos = i6 - 2;
            bArr[i7] = (byte) ((i5 & 127) | 128);
        }

        private void writeVarint64EightBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 49));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 42) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 35) & 127) | 128));
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j5 >>> 28) & 127) | 128));
            int i10 = i5 - 5;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j5 >>> 21) & 127) | 128));
            int i11 = i5 - 6;
            this.pos = i11;
            bArr[i10] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i12 = i5 - 7;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 8;
            bArr[i12] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 28));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 21) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 5;
            bArr[i9] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64FourBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 21));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 4;
            bArr[i8] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64NineBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 56));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 49) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 42) & 127) | 128));
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j5 >>> 35) & 127) | 128));
            int i10 = i5 - 5;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j5 >>> 28) & 127) | 128));
            int i11 = i5 - 6;
            this.pos = i11;
            bArr[i10] = (byte) ((int) (((j5 >>> 21) & 127) | 128));
            int i12 = i5 - 7;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i13 = i5 - 8;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 9;
            bArr[i13] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64OneByte(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((int) j5);
        }

        private void writeVarint64SevenBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 42));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 35) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 28) & 127) | 128));
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j5 >>> 21) & 127) | 128));
            int i10 = i5 - 5;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i11 = i5 - 6;
            this.pos = i11;
            bArr[i10] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 7;
            bArr[i11] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64SixBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 35));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 28) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 21) & 127) | 128));
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i10 = i5 - 5;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 6;
            bArr[i10] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64TenBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 63));
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 56) & 127) | 128));
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j5 >>> 49) & 127) | 128));
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j5 >>> 42) & 127) | 128));
            int i10 = i5 - 5;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j5 >>> 35) & 127) | 128));
            int i11 = i5 - 6;
            this.pos = i11;
            bArr[i10] = (byte) ((int) (((j5 >>> 28) & 127) | 128));
            int i12 = i5 - 7;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (((j5 >>> 21) & 127) | 128));
            int i13 = i5 - 8;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j5 >>> 14) & 127) | 128));
            int i14 = i5 - 9;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 10;
            bArr[i14] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((int) j5) >>> 14);
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j5 >>> 7) & 127) | 128));
            this.pos = i5 - 3;
            bArr[i7] = (byte) ((int) ((j5 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (j5 >>> 7));
            this.pos = i5 - 2;
            bArr[i6] = (byte) ((((int) j5) & 127) | 128);
        }

        /* access modifiers changed from: package-private */
        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer2 = this.allocatedBuffer;
                allocatedBuffer2.position((this.pos - allocatedBuffer2.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i5) {
            if (spaceLeft() < i5) {
                nextBuffer(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        public void write(byte b5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = b5;
        }

        public void writeBool(int i5, boolean z4) throws IOException {
            requireSpace(6);
            write(z4 ? (byte) 1 : 0);
            writeTag(i5, 0);
        }

        public void writeBytes(int i5, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i5, 2);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }

        public void writeEndGroup(int i5) {
            writeTag(i5, 4);
        }

        public void writeFixed32(int i5, int i6) throws IOException {
            requireSpace(9);
            writeFixed32(i6);
            writeTag(i5, 5);
        }

        public void writeFixed64(int i5, long j5) throws IOException {
            requireSpace(13);
            writeFixed64(j5);
            writeTag(i5, 1);
        }

        @Deprecated
        public void writeGroup(int i5, Object obj) throws IOException {
            writeTag(i5, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i5, 3);
        }

        public void writeInt32(int i5, int i6) throws IOException {
            requireSpace(15);
            writeInt32(i6);
            writeTag(i5, 0);
        }

        public void writeLazy(byte[] bArr, int i5, int i6) {
            if (spaceLeft() < i6) {
                this.totalDoneBytes += i6;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i5, i6));
                nextBuffer();
                return;
            }
            int i7 = this.pos - i6;
            this.pos = i7;
            System.arraycopy(bArr, i5, this.buffer, i7 + 1, i6);
        }

        public void writeMessage(int i5, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        public void writeSInt32(int i5, int i6) throws IOException {
            requireSpace(10);
            writeSInt32(i6);
            writeTag(i5, 0);
        }

        public void writeSInt64(int i5, long j5) throws IOException {
            requireSpace(15);
            writeSInt64(j5);
            writeTag(i5, 0);
        }

        public void writeStartGroup(int i5) {
            writeTag(i5, 3);
        }

        public void writeString(int i5, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i5, int i6) {
            writeVarint32(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) throws IOException {
            requireSpace(10);
            writeVarint32(i6);
            writeTag(i5, 0);
        }

        public void writeUInt64(int i5, long j5) throws IOException {
            requireSpace(15);
            writeVarint64(j5);
            writeTag(i5, 0);
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i5) {
            if ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                writeVarint32OneByte(i5);
            } else if ((i5 & -16384) == 0) {
                writeVarint32TwoBytes(i5);
            } else if ((-2097152 & i5) == 0) {
                writeVarint32ThreeBytes(i5);
            } else if ((-268435456 & i5) == 0) {
                writeVarint32FourBytes(i5);
            } else {
                writeVarint32FiveBytes(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j5) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j5)) {
                case 1:
                    writeVarint64OneByte(j5);
                    return;
                case 2:
                    writeVarint64TwoBytes(j5);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j5);
                    return;
                case 4:
                    writeVarint64FourBytes(j5);
                    return;
                case 5:
                    writeVarint64FiveBytes(j5);
                    return;
                case 6:
                    writeVarint64SixBytes(j5);
                    return;
                case 7:
                    writeVarint64SevenBytes(j5);
                    return;
                case 8:
                    writeVarint64EightBytes(j5);
                    return;
                case 9:
                    writeVarint64NineBytes(j5);
                    return;
                case 10:
                    writeVarint64TenBytes(j5);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i5) {
            nextBuffer(newHeapBuffer(i5));
        }

        public void write(byte[] bArr, int i5, int i6) {
            if (spaceLeft() < i6) {
                nextBuffer(i6);
            }
            int i7 = this.pos - i6;
            this.pos = i7;
            System.arraycopy(bArr, i5, this.buffer, i7 + 1, i6);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                int arrayOffset = allocatedBuffer2.arrayOffset();
                this.limit = allocatedBuffer2.limit() + arrayOffset;
                int position = arrayOffset + allocatedBuffer2.position();
                this.offset = position;
                this.offsetMinusOne = position - 1;
                int i5 = this.limit - 1;
                this.limitMinusOne = i5;
                this.pos = i5;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z4) {
            write(z4 ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((i5 >> 24) & 255);
            int i8 = i6 - 2;
            this.pos = i8;
            bArr[i7] = (byte) ((i5 >> 16) & 255);
            int i9 = i6 - 3;
            this.pos = i9;
            bArr[i8] = (byte) ((i5 >> 8) & 255);
            this.pos = i6 - 4;
            bArr[i9] = (byte) (i5 & 255);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((int) (j5 >> 56)) & 255);
            int i7 = i5 - 2;
            this.pos = i7;
            bArr[i6] = (byte) (((int) (j5 >> 48)) & 255);
            int i8 = i5 - 3;
            this.pos = i8;
            bArr[i7] = (byte) (((int) (j5 >> 40)) & 255);
            int i9 = i5 - 4;
            this.pos = i9;
            bArr[i8] = (byte) (((int) (j5 >> 32)) & 255);
            int i10 = i5 - 5;
            this.pos = i10;
            bArr[i9] = (byte) (((int) (j5 >> 24)) & 255);
            int i11 = i5 - 6;
            this.pos = i11;
            bArr[i10] = (byte) (((int) (j5 >> 16)) & 255);
            int i12 = i5 - 7;
            this.pos = i12;
            bArr[i11] = (byte) (((int) (j5 >> 8)) & 255);
            this.pos = i5 - 8;
            bArr[i12] = (byte) (((int) j5) & 255);
        }

        public void writeGroup(int i5, Object obj, Schema schema) throws IOException {
            writeTag(i5, 4);
            schema.writeTo(obj, this);
            writeTag(i5, 3);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i5) {
            if (i5 >= 0) {
                writeVarint32(i5);
            } else {
                writeVarint64((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i5) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i5));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j5) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j5));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i5 = this.pos - remaining;
            this.pos = i5;
            byteBuffer.get(this.buffer, i5 + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i5 = this.pos - remaining;
            this.pos = i5;
            byteBuffer.get(this.buffer, i5 + 1, remaining);
        }

        public void writeMessage(int i5, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            int i5;
            int i6;
            int i7;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i7 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i7 - 1;
                    bArr[i7] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i6 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i8 = i6 - 1;
                    this.pos = i8;
                    bArr2[i6] = (byte) ((charAt2 & '?') | 128);
                    this.pos = i6 - 2;
                    bArr2[i8] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i5 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i9 = i5 - 1;
                    this.pos = i9;
                    bArr3[i5] = (byte) ((charAt2 & '?') | 128);
                    int i10 = i5 - 2;
                    this.pos = i10;
                    bArr3[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.pos = i5 - 3;
                    bArr3[i10] = (byte) ((charAt2 >>> 12) | 480);
                } else if (this.pos > this.offset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.buffer;
                            int i11 = this.pos;
                            int i12 = i11 - 1;
                            this.pos = i12;
                            bArr4[i11] = (byte) ((codePoint & 63) | 128);
                            int i13 = i11 - 2;
                            this.pos = i13;
                            bArr4[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                            int i14 = i11 - 3;
                            this.pos = i14;
                            bArr4[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.pos = i11 - 4;
                            bArr4[i14] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        UnsafeDirectWriter(BufferAllocator bufferAllocator, int i5) {
            super(bufferAllocator, i5, (AnonymousClass1) null);
            nextBuffer();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        /* access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (i5 >>> 28));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((i5 >>> 21) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((i5 >>> 14) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((i5 >>> 7) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (i5 >>> 21));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((i5 >>> 14) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((i5 >>> 7) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint32OneByte(int i5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) i5);
        }

        private void writeVarint32ThreeBytes(int i5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (i5 >>> 14));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((i5 >>> 7) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (i5 >>> 7));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 49)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 42) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 28)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 21)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 56)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 49) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 42) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64OneByte(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) j5));
        }

        private void writeVarint64SevenBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 42)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 35)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 63)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 56) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j5 >>> 49) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j5 >>> 42) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64ThreeBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((int) j5) >>> 14));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64TwoBytes(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (j5 >>> 7)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((((int) j5) & 127) | 128));
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                Java8Compatibility.position(this.buffer, bufferPos() + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i5) {
            if (spaceLeft() < i5) {
                nextBuffer(i5);
            }
        }

        public void write(byte b5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, b5);
        }

        public void writeBool(int i5, boolean z4) {
            requireSpace(6);
            write(z4 ? (byte) 1 : 0);
            writeTag(i5, 0);
        }

        public void writeBytes(int i5, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i5, 2);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Deprecated
        public void writeEndGroup(int i5) {
            writeTag(i5, 4);
        }

        public void writeFixed32(int i5, int i6) {
            requireSpace(9);
            writeFixed32(i6);
            writeTag(i5, 5);
        }

        public void writeFixed64(int i5, long j5) {
            requireSpace(13);
            writeFixed64(j5);
            writeTag(i5, 1);
        }

        public void writeGroup(int i5, Object obj) throws IOException {
            writeTag(i5, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i5, 3);
        }

        public void writeInt32(int i5, int i6) {
            requireSpace(15);
            writeInt32(i6);
            writeTag(i5, 0);
        }

        public void writeLazy(byte[] bArr, int i5, int i6) {
            if (spaceLeft() < i6) {
                this.totalDoneBytes += i6;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i5, i6));
                nextBuffer();
                return;
            }
            this.pos -= (long) i6;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(bArr, i5, i6);
        }

        public void writeMessage(int i5, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        public void writeSInt32(int i5, int i6) {
            requireSpace(10);
            writeSInt32(i6);
            writeTag(i5, 0);
        }

        public void writeSInt64(int i5, long j5) {
            requireSpace(15);
            writeSInt64(j5);
            writeTag(i5, 0);
        }

        @Deprecated
        public void writeStartGroup(int i5) {
            writeTag(i5, 3);
        }

        public void writeString(int i5, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i5, int i6) {
            writeVarint32(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) {
            requireSpace(10);
            writeVarint32(i6);
            writeTag(i5, 0);
        }

        public void writeUInt64(int i5, long j5) {
            requireSpace(15);
            writeVarint64(j5);
            writeTag(i5, 0);
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i5) {
            if ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                writeVarint32OneByte(i5);
            } else if ((i5 & -16384) == 0) {
                writeVarint32TwoBytes(i5);
            } else if ((-2097152 & i5) == 0) {
                writeVarint32ThreeBytes(i5);
            } else if ((-268435456 & i5) == 0) {
                writeVarint32FourBytes(i5);
            } else {
                writeVarint32FiveBytes(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j5) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j5)) {
                case 1:
                    writeVarint64OneByte(j5);
                    return;
                case 2:
                    writeVarint64TwoBytes(j5);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j5);
                    return;
                case 4:
                    writeVarint64FourBytes(j5);
                    return;
                case 5:
                    writeVarint64FiveBytes(j5);
                    return;
                case 6:
                    writeVarint64SixBytes(j5);
                    return;
                case 7:
                    writeVarint64SevenBytes(j5);
                    return;
                case 8:
                    writeVarint64EightBytes(j5);
                    return;
                case 9:
                    writeVarint64NineBytes(j5);
                    return;
                case 10:
                    writeVarint64TenBytes(j5);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i5) {
            nextBuffer(newDirectBuffer(i5));
        }

        public void write(byte[] bArr, int i5, int i6) {
            if (spaceLeft() < i6) {
                nextBuffer(i6);
            }
            this.pos -= (long) i6;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(bArr, i5, i6);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    Java8Compatibility.limit(nioBuffer, nioBuffer.capacity());
                    Java8Compatibility.position(this.buffer, 0);
                    long addressOffset = UnsafeUtil.addressOffset(this.buffer);
                    this.bufferOffset = addressOffset;
                    long limit = addressOffset + ((long) (this.buffer.limit() - 1));
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z4) {
            write(z4 ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i5) {
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((i5 >> 24) & 255));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((i5 >> 16) & 255));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((i5 >> 8) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (i5 & 255));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j5) {
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((int) (j5 >> 56)) & 255));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((int) (j5 >> 48)) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((int) (j5 >> 40)) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((int) (j5 >> 32)) & 255));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((int) (j5 >> 24)) & 255));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((int) (j5 >> 16)) & 255));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((int) (j5 >> 8)) & 255));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((int) j5) & 255));
        }

        public void writeGroup(int i5, Object obj, Schema schema) throws IOException {
            writeTag(i5, 4);
            schema.writeTo(obj, this);
            writeTag(i5, 3);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i5) {
            if (i5 >= 0) {
                writeVarint32(i5);
            } else {
                writeVarint64((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i5) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i5));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j5) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j5));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            this.pos -= (long) remaining;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeMessage(int i5, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    long j5 = this.pos;
                    this.pos = j5 - 1;
                    UnsafeUtil.putByte(j5, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j6 = this.pos;
                        if (j6 >= this.bufferOffset) {
                            this.pos = j6 - 1;
                            UnsafeUtil.putByte(j6, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j7 = this.pos;
                        if (j7 > this.bufferOffset) {
                            this.pos = j7 - 1;
                            UnsafeUtil.putByte(j7, (byte) ((charAt2 & '?') | 128));
                            long j8 = this.pos;
                            this.pos = j8 - 1;
                            UnsafeUtil.putByte(j8, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j9 = this.pos;
                        if (j9 > this.bufferOffset + 1) {
                            this.pos = j9 - 1;
                            UnsafeUtil.putByte(j9, (byte) ((charAt2 & '?') | 128));
                            long j10 = this.pos;
                            this.pos = j10 - 1;
                            UnsafeUtil.putByte(j10, (byte) (((charAt2 >>> 6) & 63) | 128));
                            long j11 = this.pos;
                            this.pos = j11 - 1;
                            UnsafeUtil.putByte(j11, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.pos > this.bufferOffset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                long j12 = this.pos;
                                this.pos = j12 - 1;
                                UnsafeUtil.putByte(j12, (byte) ((codePoint & 63) | 128));
                                long j13 = this.pos;
                                this.pos = j13 - 1;
                                UnsafeUtil.putByte(j13, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j14 = this.pos;
                                this.pos = j14 - 1;
                                UnsafeUtil.putByte(j14, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j15 = this.pos;
                                this.pos = j15 - 1;
                                UnsafeUtil.putByte(j15, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            this.pos -= (long) remaining;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator bufferAllocator, int i5) {
            super(bufferAllocator, i5, (AnonymousClass1) null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, (byte) (i5 >>> 28));
            byte[] bArr2 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr2, j6, (byte) (((i5 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr3, j7, (byte) (((i5 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr4, j8, (byte) (((i5 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr5, j9, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, (byte) (i5 >>> 21));
            byte[] bArr2 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr2, j6, (byte) (((i5 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr3, j7, (byte) (((i5 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr4, j8, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint32OneByte(int i5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, (byte) i5);
        }

        private void writeVarint32ThreeBytes(int i5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, (byte) (i5 >>> 14));
            byte[] bArr2 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr2, j6, (byte) (((i5 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr3, j7, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, (byte) (i5 >>> 7));
            byte[] bArr2 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr2, j6, (byte) ((i5 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 49)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 42) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr6, j11, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr7, j12, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr8, j13, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 28)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 21)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 56)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 49) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 42) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr6, j11, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr7, j12, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr8, j13, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr9, j14, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64OneByte(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) j5));
        }

        private void writeVarint64SevenBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 42)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr6, j11, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr7, j12, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 35)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr6, j11, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 63)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 56) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) (((j5 >>> 49) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((int) (((j5 >>> 42) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((int) (((j5 >>> 35) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr6, j11, (byte) ((int) (((j5 >>> 28) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr7, j12, (byte) ((int) (((j5 >>> 21) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr8, j13, (byte) ((int) (((j5 >>> 14) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr9, j14, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr10 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr10, j15, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64ThreeBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) (((int) j5) >>> 14));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((int) (((j5 >>> 7) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((int) ((j5 & 127) | 128)));
        }

        private void writeVarint64TwoBytes(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) ((int) (j5 >>> 7)));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) ((((int) j5) & 127) | 128));
        }

        /* access modifiers changed from: package-private */
        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i5) {
            if (spaceLeft() < i5) {
                nextBuffer(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        public void write(byte b5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, b5);
        }

        public void writeBool(int i5, boolean z4) {
            requireSpace(6);
            write(z4 ? (byte) 1 : 0);
            writeTag(i5, 0);
        }

        public void writeBytes(int i5, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i5, 2);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }

        public void writeEndGroup(int i5) {
            writeTag(i5, 4);
        }

        public void writeFixed32(int i5, int i6) {
            requireSpace(9);
            writeFixed32(i6);
            writeTag(i5, 5);
        }

        public void writeFixed64(int i5, long j5) {
            requireSpace(13);
            writeFixed64(j5);
            writeTag(i5, 1);
        }

        public void writeGroup(int i5, Object obj) throws IOException {
            writeTag(i5, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i5, 3);
        }

        public void writeInt32(int i5, int i6) {
            requireSpace(15);
            writeInt32(i6);
            writeTag(i5, 0);
        }

        public void writeLazy(byte[] bArr, int i5, int i6) {
            if (i5 < 0 || i5 + i6 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
            } else if (spaceLeft() < i6) {
                this.totalDoneBytes += i6;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i5, i6));
                nextBuffer();
            } else {
                this.pos -= (long) i6;
                System.arraycopy(bArr, i5, this.buffer, arrayPos() + 1, i6);
            }
        }

        public void writeMessage(int i5, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        public void writeSInt32(int i5, int i6) {
            requireSpace(10);
            writeSInt32(i6);
            writeTag(i5, 0);
        }

        public void writeSInt64(int i5, long j5) {
            requireSpace(15);
            writeSInt64(j5);
            writeTag(i5, 0);
        }

        public void writeStartGroup(int i5) {
            writeTag(i5, 3);
        }

        public void writeString(int i5, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i5, int i6) {
            writeVarint32(WireFormat.makeTag(i5, i6));
        }

        public void writeUInt32(int i5, int i6) {
            requireSpace(10);
            writeVarint32(i6);
            writeTag(i5, 0);
        }

        public void writeUInt64(int i5, long j5) {
            requireSpace(15);
            writeVarint64(j5);
            writeTag(i5, 0);
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i5) {
            if ((i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                writeVarint32OneByte(i5);
            } else if ((i5 & -16384) == 0) {
                writeVarint32TwoBytes(i5);
            } else if ((-2097152 & i5) == 0) {
                writeVarint32ThreeBytes(i5);
            } else if ((-268435456 & i5) == 0) {
                writeVarint32FourBytes(i5);
            } else {
                writeVarint32FiveBytes(i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j5) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j5)) {
                case 1:
                    writeVarint64OneByte(j5);
                    return;
                case 2:
                    writeVarint64TwoBytes(j5);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j5);
                    return;
                case 4:
                    writeVarint64FourBytes(j5);
                    return;
                case 5:
                    writeVarint64FiveBytes(j5);
                    return;
                case 6:
                    writeVarint64SixBytes(j5);
                    return;
                case 7:
                    writeVarint64SevenBytes(j5);
                    return;
                case 8:
                    writeVarint64EightBytes(j5);
                    return;
                case 9:
                    writeVarint64NineBytes(j5);
                    return;
                case 10:
                    writeVarint64TenBytes(j5);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i5) {
            nextBuffer(newHeapBuffer(i5));
        }

        public void write(byte[] bArr, int i5, int i6) {
            if (i5 < 0 || i5 + i6 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
            }
            requireSpace(i6);
            this.pos -= (long) i6;
            System.arraycopy(bArr, i5, this.buffer, arrayPos() + 1, i6);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                long arrayOffset = (long) allocatedBuffer2.arrayOffset();
                this.limit = ((long) allocatedBuffer2.limit()) + arrayOffset;
                long position = arrayOffset + ((long) allocatedBuffer2.position());
                this.offset = position;
                this.offsetMinusOne = position - 1;
                long j5 = this.limit - 1;
                this.limitMinusOne = j5;
                this.pos = j5;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z4) {
            write(z4 ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i5) {
            byte[] bArr = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr, j5, (byte) ((i5 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr2, j6, (byte) ((i5 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr3, j7, (byte) ((i5 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr4, j8, (byte) (i5 & 255));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j5) {
            byte[] bArr = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr, j6, (byte) (((int) (j5 >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr2, j7, (byte) (((int) (j5 >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) (((int) (j5 >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) (((int) (j5 >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) (((int) (j5 >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr6, j11, (byte) (((int) (j5 >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr7, j12, (byte) (((int) (j5 >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr8, j13, (byte) (((int) j5) & 255));
        }

        public void writeGroup(int i5, Object obj, Schema schema) throws IOException {
            writeTag(i5, 4);
            schema.writeTo(obj, this);
            writeTag(i5, 3);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i5) {
            if (i5 >= 0) {
                writeVarint32(i5);
            } else {
                writeVarint64((long) i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i5) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i5));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j5) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j5));
        }

        public void writeMessage(int i5, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    byte[] bArr = this.buffer;
                    long j5 = this.pos;
                    this.pos = j5 - 1;
                    UnsafeUtil.putByte(bArr, j5, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j6 = this.pos;
                        if (j6 > this.offsetMinusOne) {
                            byte[] bArr2 = this.buffer;
                            this.pos = j6 - 1;
                            UnsafeUtil.putByte(bArr2, j6, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j7 = this.pos;
                        if (j7 > this.offset) {
                            byte[] bArr3 = this.buffer;
                            this.pos = j7 - 1;
                            UnsafeUtil.putByte(bArr3, j7, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr4 = this.buffer;
                            long j8 = this.pos;
                            this.pos = j8 - 1;
                            UnsafeUtil.putByte(bArr4, j8, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j9 = this.pos;
                        if (j9 > this.offset + 1) {
                            byte[] bArr5 = this.buffer;
                            this.pos = j9 - 1;
                            UnsafeUtil.putByte(bArr5, j9, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr6 = this.buffer;
                            long j10 = this.pos;
                            this.pos = j10 - 1;
                            UnsafeUtil.putByte(bArr6, j10, (byte) (((charAt2 >>> 6) & 63) | 128));
                            byte[] bArr7 = this.buffer;
                            long j11 = this.pos;
                            this.pos = j11 - 1;
                            UnsafeUtil.putByte(bArr7, j11, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr8 = this.buffer;
                                long j12 = this.pos;
                                this.pos = j12 - 1;
                                UnsafeUtil.putByte(bArr8, j12, (byte) ((codePoint & 63) | 128));
                                byte[] bArr9 = this.buffer;
                                long j13 = this.pos;
                                this.pos = j13 - 1;
                                UnsafeUtil.putByte(bArr9, j13, (byte) (((codePoint >>> 6) & 63) | 128));
                                byte[] bArr10 = this.buffer;
                                long j14 = this.pos;
                                this.pos = j14 - 1;
                                UnsafeUtil.putByte(bArr10, j14, (byte) (((codePoint >>> 12) & 63) | 128));
                                byte[] bArr11 = this.buffer;
                                long j15 = this.pos;
                                this.pos = j15 - 1;
                                UnsafeUtil.putByte(bArr11, j15, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            requireSpace(remaining);
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }
    }

    /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i5, AnonymousClass1 r32) {
        this(bufferAllocator, i5);
    }

    /* access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j5) {
        byte b5;
        if ((-128 & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if ((-34359738368L & j5) != 0) {
            b5 = (byte) 6;
            j5 >>>= 28;
        } else {
            b5 = 2;
        }
        if ((-2097152 & j5) != 0) {
            b5 = (byte) (b5 + 2);
            j5 >>>= 14;
        }
        return (j5 & -16384) != 0 ? (byte) (b5 + 1) : b5;
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i5) {
        return new SafeDirectWriter(bufferAllocator, i5);
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i5) {
        return new SafeHeapWriter(bufferAllocator, i5);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i5) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i5);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i5) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i5);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private void writeBoolList_Internal(int i5, List<Boolean> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(list.get(size).booleanValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i5, list.get(size2).booleanValue());
        }
    }

    private void writeDoubleList_Internal(int i5, List<Double> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i5, list.get(size2).doubleValue());
        }
    }

    private void writeFixed32List_Internal(int i5, List<Integer> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i5, list.get(size2).intValue());
        }
    }

    private void writeFixed64List_Internal(int i5, List<Long> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i5, list.get(size2).longValue());
        }
    }

    private void writeFloatList_Internal(int i5, List<Float> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i5, list.get(size2).floatValue());
        }
    }

    private void writeInt32List_Internal(int i5, List<Integer> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i5, list.get(size2).intValue());
        }
    }

    private void writeLazyString(int i5, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i5, (String) obj);
        } else {
            writeBytes(i5, (ByteString) obj);
        }
    }

    static final void writeMapEntryField(Writer writer, int i5, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i5, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i5, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i5, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i5, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i5, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i5, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i5, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i5, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i5, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i5, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i5, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i5, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i5, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i5, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i5, obj);
                return;
            case 16:
                writer.writeBytes(i5, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i5, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else if (obj instanceof Integer) {
                    writer.writeEnum(i5, ((Integer) obj).intValue());
                    return;
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private void writeSInt32List_Internal(int i5, List<Integer> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i5, list.get(size2).intValue());
        }
    }

    private void writeSInt64List_Internal(int i5, List<Long> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i5, list.get(size2).longValue());
        }
    }

    private void writeUInt32List_Internal(int i5, List<Integer> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i5, list.get(size2).intValue());
        }
    }

    private void writeUInt64List_Internal(int i5, List<Long> list, boolean z4) throws IOException {
        if (z4) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i5, list.get(size2).longValue());
        }
    }

    @CanIgnoreReturnValue
    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    /* access modifiers changed from: package-private */
    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    /* access modifiers changed from: package-private */
    public abstract void requireSpace(int i5);

    /* access modifiers changed from: package-private */
    public abstract void writeBool(boolean z4);

    public final void writeBoolList(int i5, List<Boolean> list, boolean z4) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i5, (BooleanArrayList) list, z4);
        } else {
            writeBoolList_Internal(i5, list, z4);
        }
    }

    public final void writeBytesList(int i5, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i5, list.get(size));
        }
    }

    public final void writeDouble(int i5, double d5) throws IOException {
        writeFixed64(i5, Double.doubleToRawLongBits(d5));
    }

    public final void writeDoubleList(int i5, List<Double> list, boolean z4) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i5, (DoubleArrayList) list, z4);
        } else {
            writeDoubleList_Internal(i5, list, z4);
        }
    }

    public final void writeEnum(int i5, int i6) throws IOException {
        writeInt32(i5, i6);
    }

    public final void writeEnumList(int i5, List<Integer> list, boolean z4) throws IOException {
        writeInt32List(i5, list, z4);
    }

    /* access modifiers changed from: package-private */
    public abstract void writeFixed32(int i5);

    public final void writeFixed32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i5, (IntArrayList) list, z4);
        } else {
            writeFixed32List_Internal(i5, list, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeFixed64(long j5);

    public final void writeFixed64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i5, (LongArrayList) list, z4);
        } else {
            writeFixed64List_Internal(i5, list, z4);
        }
    }

    public final void writeFloat(int i5, float f5) throws IOException {
        writeFixed32(i5, Float.floatToRawIntBits(f5));
    }

    public final void writeFloatList(int i5, List<Float> list, boolean z4) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i5, (FloatArrayList) list, z4);
        } else {
            writeFloatList_Internal(i5, list, z4);
        }
    }

    @Deprecated
    public final void writeGroupList(int i5, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i5, list.get(size));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeInt32(int i5);

    public final void writeInt32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i5, (IntArrayList) list, z4);
        } else {
            writeInt32List_Internal(i5, list, z4);
        }
    }

    public final void writeInt64(int i5, long j5) throws IOException {
        writeUInt64(i5, j5);
    }

    public final void writeInt64List(int i5, List<Long> list, boolean z4) throws IOException {
        writeUInt64List(i5, list, z4);
    }

    public <K, V> void writeMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, next.getValue());
            writeMapEntryField(this, 1, metadata.keyType, next.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
        }
    }

    public final void writeMessageList(int i5, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i5, list.get(size));
        }
    }

    public final void writeMessageSetItem(int i5, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i5);
        writeTag(1, 3);
    }

    public final void writeSFixed32(int i5, int i6) throws IOException {
        writeFixed32(i5, i6);
    }

    public final void writeSFixed32List(int i5, List<Integer> list, boolean z4) throws IOException {
        writeFixed32List(i5, list, z4);
    }

    public final void writeSFixed64(int i5, long j5) throws IOException {
        writeFixed64(i5, j5);
    }

    public final void writeSFixed64List(int i5, List<Long> list, boolean z4) throws IOException {
        writeFixed64List(i5, list, z4);
    }

    /* access modifiers changed from: package-private */
    public abstract void writeSInt32(int i5);

    public final void writeSInt32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i5, (IntArrayList) list, z4);
        } else {
            writeSInt32List_Internal(i5, list, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeSInt64(long j5);

    public final void writeSInt64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i5, (LongArrayList) list, z4);
        } else {
            writeSInt64List_Internal(i5, list, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeString(String str);

    public final void writeStringList(int i5, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                writeLazyString(i5, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i5, list.get(size2));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeTag(int i5, int i6);

    public final void writeUInt32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i5, (IntArrayList) list, z4);
        } else {
            writeUInt32List_Internal(i5, list, z4);
        }
    }

    public final void writeUInt64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i5, (LongArrayList) list, z4);
        } else {
            writeUInt64List_Internal(i5, list, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeVarint32(int i5);

    /* access modifiers changed from: package-private */
    public abstract void writeVarint64(long j5);

    private BinaryWriter(BufferAllocator bufferAllocator, int i5) {
        this.buffers = new ArrayDeque<>(4);
        if (i5 > 0) {
            this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
            this.chunkSize = i5;
            return;
        }
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i5) {
        if (isUnsafeDirectSupported()) {
            return newUnsafeDirectInstance(bufferAllocator, i5);
        }
        return newSafeDirectInstance(bufferAllocator, i5);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i5) {
        if (isUnsafeHeapSupported()) {
            return newUnsafeHeapInstance(bufferAllocator, i5);
        }
        return newSafeHeapInstance(bufferAllocator, i5);
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newDirectBuffer(int i5) {
        return this.alloc.allocateDirectBuffer(Math.max(i5, this.chunkSize));
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newHeapBuffer(int i5) {
        return this.alloc.allocateHeapBuffer(Math.max(i5, this.chunkSize));
    }

    @Deprecated
    public final void writeGroupList(int i5, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i5, list.get(size), schema);
        }
    }

    public final void writeMessageList(int i5, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i5, list.get(size), schema);
        }
    }

    private void writeBoolList_Internal(int i5, BooleanArrayList booleanArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i5, booleanArrayList.getBoolean(size2));
        }
    }

    private void writeDoubleList_Internal(int i5, DoubleArrayList doubleArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i5, doubleArrayList.getDouble(size2));
        }
    }

    private void writeFixed32List_Internal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i5, intArrayList.getInt(size2));
        }
    }

    private void writeFixed64List_Internal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i5, longArrayList.getLong(size2));
        }
    }

    private void writeFloatList_Internal(int i5, FloatArrayList floatArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i5, floatArrayList.getFloat(size2));
        }
    }

    private void writeInt32List_Internal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i5, intArrayList.getInt(size2));
        }
    }

    private void writeSInt32List_Internal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i5, intArrayList.getInt(size2));
        }
    }

    private void writeSInt64List_Internal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i5, longArrayList.getLong(size2));
        }
    }

    private void writeUInt32List_Internal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i5, intArrayList.getInt(size2));
        }
    }

    private void writeUInt64List_Internal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        if (z4) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i5, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i5, longArrayList.getLong(size2));
        }
    }
}
