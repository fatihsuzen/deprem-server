package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

@CheckReturnValue
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1  reason: invalid class name */
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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.AnonymousClass1.<clinit>():void");
        }
    }

    /* synthetic */ BinaryReader(AnonymousClass1 r12) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z4) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z4);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    private static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z4) {
            super((AnonymousClass1) null);
            this.bufferIsImmutable = z4;
            this.buffer = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean isAtEnd() {
            if (this.pos == this.limit) {
                return true;
            }
            return false;
        }

        private byte readByte() throws IOException {
            int i5 = this.pos;
            if (i5 != this.limit) {
                byte[] bArr = this.buffer;
                this.pos = i5 + 1;
                return bArr[i5];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i5 = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int i5 = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i5 + 8;
            return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
        }

        private int readVarint32() throws IOException {
            byte b5;
            byte b6;
            int i5 = this.pos;
            int i6 = this.limit;
            if (i6 != i5) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b7 = bArr[i5];
                if (b7 >= 0) {
                    this.pos = i7;
                    return b7;
                } else if (i6 - i7 < 9) {
                    return (int) readVarint64SlowPath();
                } else {
                    int i8 = i5 + 2;
                    byte b8 = (bArr[i7] << 7) ^ b7;
                    if (b8 < 0) {
                        b5 = b8 ^ Byte.MIN_VALUE;
                    } else {
                        int i9 = i5 + 3;
                        byte b9 = (bArr[i8] << 14) ^ b8;
                        if (b9 >= 0) {
                            b6 = b9 ^ 16256;
                        } else {
                            int i10 = i5 + 4;
                            byte b10 = b9 ^ (bArr[i9] << 21);
                            if (b10 < 0) {
                                b5 = -2080896 ^ b10;
                            } else {
                                i9 = i5 + 5;
                                byte b11 = bArr[i10];
                                byte b12 = (b10 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i10 = i5 + 6;
                                    if (bArr[i9] < 0) {
                                        i9 = i5 + 7;
                                        if (bArr[i10] < 0) {
                                            i10 = i5 + 8;
                                            if (bArr[i9] < 0) {
                                                i9 = i5 + 9;
                                                if (bArr[i10] < 0) {
                                                    int i11 = i5 + 10;
                                                    if (bArr[i9] >= 0) {
                                                        byte b13 = b12;
                                                        i8 = i11;
                                                        b5 = b13;
                                                    } else {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b5 = b12;
                                }
                                b6 = b12;
                            }
                            i8 = i10;
                        }
                        i8 = i9;
                    }
                    this.pos = i8;
                    return b5;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private long readVarint64SlowPath() throws IOException {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte readByte = readByte();
                j5 |= ((long) (readByte & Byte.MAX_VALUE)) << i5;
                if ((readByte & 128) == 0) {
                    return j5;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int i5) throws IOException {
            if (i5 < 0 || i5 > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requirePosition(int i5) throws IOException {
            if (this.pos != i5) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i5) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != i5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void skipBytes(int i5) throws IOException {
            requireBytes(i5);
            this.pos += i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void skipGroup() throws java.io.IOException {
            /*
                r3 = this;
                int r0 = r3.endGroupTag
                int r1 = r3.tag
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.getTagFieldNumber(r1)
                r2 = 4
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.makeTag(r1, r2)
                r3.endGroupTag = r1
            L_0x000f:
                int r1 = r3.getFieldNumber()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.skipField()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.tag
                int r2 = r3.endGroupTag
                if (r1 != r2) goto L_0x0027
                r3.endGroupTag = r0
                return
            L_0x0027:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.SafeHeapReader.skipGroup():void");
        }

        private void skipVarint() throws IOException {
            int i5 = this.limit;
            int i6 = this.pos;
            if (i5 - i6 >= 10) {
                byte[] bArr = this.buffer;
                int i7 = 0;
                while (i7 < 10) {
                    int i8 = i6 + 1;
                    if (bArr[i6] >= 0) {
                        this.pos = i8;
                        return;
                    } else {
                        i7++;
                        i6 = i8;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            int i5 = 0;
            while (i5 < 10) {
                if (readByte() < 0) {
                    i5++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int i5) throws IOException {
            requireBytes(i5);
            if ((i5 & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed64Length(int i5) throws IOException {
            requireBytes(i5);
            if ((i5 & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        public int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        public int getTag() {
            return this.tag;
        }

        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        public <T> void mergeGroupField(T t5, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i5 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(t5, this, extensionRegistryLite);
                if (this.tag != this.endGroupTag) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i5;
            }
        }

        public <T> void mergeMessageField(T t5, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i5 = this.limit;
            int i6 = this.pos + readVarint32;
            this.limit = i6;
            try {
                schema.mergeFrom(t5, this, extensionRegistryLite);
                if (this.pos != i6) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = i5;
            }
        }

        public boolean readBool() throws IOException {
            requireWireType(0);
            if (readVarint32() != 0) {
                return true;
            }
            return false;
        }

        public void readBoolList(List<Boolean> list) throws IOException {
            int i5;
            boolean z4;
            int i6;
            boolean z5;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        booleanArrayList.addBoolean(readBool());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        if (readVarint32() != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        booleanArrayList.addBoolean(z5);
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Boolean.valueOf(readBool()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        if (readVarint32() != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        list.add(Boolean.valueOf(z4));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public ByteString readBytes() throws IOException {
            ByteString byteString;
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            if (this.bufferIsImmutable) {
                byteString = ByteString.wrap(this.buffer, this.pos, readVarint32);
            } else {
                byteString = ByteString.copyFrom(this.buffer, this.pos, readVarint32);
            }
            this.pos += readVarint32;
            return byteString;
        }

        public void readBytesList(List<ByteString> list) throws IOException {
            int i5;
            if (WireFormat.getTagWireType(this.tag) == 2) {
                do {
                    list.add(readBytes());
                    if (!isAtEnd()) {
                        i5 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i5;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        public void readDoubleList(List<Double> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        doubleArrayList.addDouble(readDouble());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i7 = this.pos + readVarint32;
                    while (this.pos < i7) {
                        doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i8 = this.pos + readVarint322;
                    while (this.pos < i8) {
                        list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public void readEnumList(List<Integer> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readEnum());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readEnum()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        public void readFixed32List(List<Integer> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i7 = this.pos + readVarint32;
                    while (this.pos < i7) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                } else if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(readFixed32());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i8 = this.pos + readVarint322;
                    while (this.pos < i8) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readFixed32()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        public void readFixed64List(List<Long> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        longArrayList.addLong(readFixed64());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i7 = this.pos + readVarint32;
                    while (this.pos < i7) {
                        longArrayList.addLong(readLittleEndian64_NoCheck());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i8 = this.pos + readVarint322;
                    while (this.pos < i8) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        public void readFloatList(List<Float> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i7 = this.pos + readVarint32;
                    while (this.pos < i7) {
                        floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType == 5) {
                    do {
                        floatArrayList.addFloat(readFloat());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i8 = this.pos + readVarint322;
                    while (this.pos < i8) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return readGroup(Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return readGroup(schema, extensionRegistryLite);
        }

        @Deprecated
        public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readGroupList(list, Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public void readInt32List(List<Integer> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readInt32());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        public void readInt64List(List<Long> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readInt64());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(readVarint64());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|(2:23|35)(3:30|24|25)) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            if (skipField() != false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <K, V> void readMap(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r9, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 2
                r7.requireWireType(r0)
                int r1 = r7.readVarint32()
                r7.requireBytes(r1)
                int r2 = r7.limit
                int r3 = r7.pos
                int r3 = r3 + r1
                r7.limit = r3
                K r1 = r9.defaultKey     // Catch:{ all -> 0x0025 }
                V r3 = r9.defaultValue     // Catch:{ all -> 0x0025 }
            L_0x0016:
                int r4 = r7.getFieldNumber()     // Catch:{ all -> 0x0025 }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0027
                r8.put(r1, r3)     // Catch:{ all -> 0x0025 }
                r7.limit = r2
                return
            L_0x0025:
                r8 = move-exception
                goto L_0x005d
            L_0x0027:
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0048
                if (r4 == r0) goto L_0x003b
                boolean r4 = r7.skipField()     // Catch:{ InvalidWireTypeException -> 0x0050 }
                if (r4 == 0) goto L_0x0035
                goto L_0x0016
            L_0x0035:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x0050 }
                r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x0050 }
            L_0x003b:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.valueType     // Catch:{ InvalidWireTypeException -> 0x0050 }
                V r5 = r9.defaultValue     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x0050 }
                java.lang.Object r3 = r7.readField(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                goto L_0x0016
            L_0x0048:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.keyType     // Catch:{ InvalidWireTypeException -> 0x0050 }
                r5 = 0
                java.lang.Object r1 = r7.readField(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x0050 }
                goto L_0x0016
            L_0x0050:
                boolean r4 = r7.skipField()     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0057
                goto L_0x0016
            L_0x0057:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0025 }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0025 }
                throw r8     // Catch:{ all -> 0x0025 }
            L_0x005d:
                r7.limit = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryReader.SafeHeapReader.readMap(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
        }

        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return readMessage(Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return readMessage(schema, extensionRegistryLite);
        }

        public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readMessageList(list, Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        public void readSFixed32List(List<Integer> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i7 = this.pos + readVarint32;
                    while (this.pos < i7) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                } else if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(readSFixed32());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i8 = this.pos + readVarint322;
                    while (this.pos < i8) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readSFixed32()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        public void readSFixed64List(List<Long> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        longArrayList.addLong(readSFixed64());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i7 = this.pos + readVarint32;
                    while (this.pos < i7) {
                        longArrayList.addLong(readLittleEndian64_NoCheck());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i8 = this.pos + readVarint322;
                    while (this.pos < i8) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        public void readSInt32List(List<Integer> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readSInt32());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readSInt32()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        public void readSInt64List(List<Long> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readSInt64());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readSInt64()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public String readString() throws IOException {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z4) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (z4) {
                byte[] bArr = this.buffer;
                int i5 = this.pos;
                if (!Utf8.isValidUtf8(bArr, i5, i5 + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        public void readStringList(List<String> list) throws IOException {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z4) throws IOException {
            int i5;
            int i6;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            } else if (!(list instanceof LazyStringList) || z4) {
                do {
                    list.add(readStringInternal(z4));
                    if (!isAtEnd()) {
                        i5 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i5;
            } else {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (!isAtEnd()) {
                        i6 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
            }
        }

        public void readStringListRequireUtf8(List<String> list) throws IOException {
            readStringListInternal(list, true);
        }

        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public void readUInt32List(List<Integer> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readUInt32());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readUInt32()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        public void readUInt64List(List<Long> list) throws IOException {
            int i5;
            int i6;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readUInt64());
                        if (!isAtEnd()) {
                            i6 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i6;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(readVarint64());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (!isAtEnd()) {
                            i5 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i5;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readVarint64() throws IOException {
            long j5;
            long j6;
            long j7;
            long j8;
            int i5 = this.pos;
            int i6 = this.limit;
            if (i6 != i5) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 >= 0) {
                    this.pos = i7;
                    return (long) b5;
                } else if (i6 - i7 < 9) {
                    return readVarint64SlowPath();
                } else {
                    int i8 = i5 + 2;
                    byte b6 = (bArr[i7] << 7) ^ b5;
                    if (b6 < 0) {
                        j5 = (long) (b6 ^ Byte.MIN_VALUE);
                    } else {
                        int i9 = i5 + 3;
                        byte b7 = (bArr[i8] << 14) ^ b6;
                        if (b7 >= 0) {
                            j5 = (long) (b7 ^ 16256);
                            i8 = i9;
                        } else {
                            int i10 = i5 + 4;
                            byte b8 = b7 ^ (bArr[i9] << 21);
                            if (b8 < 0) {
                                j8 = (long) (-2080896 ^ b8);
                            } else {
                                long j9 = (long) b8;
                                int i11 = i5 + 5;
                                long j10 = j9 ^ (((long) bArr[i10]) << 28);
                                if (j10 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    i10 = i5 + 6;
                                    long j11 = j10 ^ (((long) bArr[i11]) << 35);
                                    if (j11 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        i11 = i5 + 7;
                                        j10 = j11 ^ (((long) bArr[i10]) << 42);
                                        if (j10 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            i10 = i5 + 8;
                                            j11 = j10 ^ (((long) bArr[i11]) << 49);
                                            if (j11 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j12 = (j11 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                                if (j12 < 0) {
                                                    int i12 = i5 + 10;
                                                    if (((long) bArr[i8]) >= 0) {
                                                        i8 = i12;
                                                    } else {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
                                                }
                                                j5 = j12;
                                            }
                                        }
                                    }
                                    j8 = j6 ^ j11;
                                }
                                j5 = j7 ^ j10;
                            }
                            i8 = i10;
                            j5 = j8;
                        }
                    }
                    this.pos = i8;
                    return j5;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public boolean skipField() throws IOException {
            int i5;
            if (isAtEnd() || (i5 = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            } else if (tagWireType == 1) {
                skipBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipGroup();
                return true;
            } else if (tagWireType == 5) {
                skipBytes(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Deprecated
        public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i5;
            if (WireFormat.getTagWireType(this.tag) == 3) {
                int i6 = this.tag;
                do {
                    list.add(readGroup(schema, extensionRegistryLite));
                    if (!isAtEnd()) {
                        i5 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == i6);
                this.pos = i5;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i5;
            if (WireFormat.getTagWireType(this.tag) == 2) {
                int i6 = this.tag;
                do {
                    list.add(readMessage(schema, extensionRegistryLite));
                    if (!isAtEnd()) {
                        i5 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == i6);
                this.pos = i5;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private BinaryReader() {
    }
}
