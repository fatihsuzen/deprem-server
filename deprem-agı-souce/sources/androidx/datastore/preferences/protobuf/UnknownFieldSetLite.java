package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity(int i5) {
        int[] iArr = this.tags;
        if (i5 > iArr.length) {
            int i6 = this.count;
            int i7 = i6 + (i6 / 2);
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.tags = Arrays.copyOf(iArr, i5);
            this.objects = Arrays.copyOf(this.objects, i5);
        }
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] iArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        return i6;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private androidx.datastore.preferences.protobuf.UnknownFieldSetLite mergeFrom(androidx.datastore.preferences.protobuf.CodedInputStream r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mergeFieldFrom(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UnknownFieldSetLite.mergeFrom(androidx.datastore.preferences.protobuf.CodedInputStream):androidx.datastore.preferences.protobuf.UnknownFieldSetLite");
    }

    static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i5 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.tags, i5);
        System.arraycopy(unknownFieldSetLite2.tags, 0, copyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.objects, i5);
        System.arraycopy(unknownFieldSetLite2.objects, 0, copyOf2, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        return new UnknownFieldSetLite(i5, copyOf, copyOf2, true);
    }

    static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] objArr, Object[] objArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (!objArr[i6].equals(objArr2[i6])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tagsEquals(int[] iArr, int[] iArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (iArr[i6] != iArr2[i6]) {
                return false;
            }
        }
        return true;
    }

    private static void writeField(int i5, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
        int tagWireType = WireFormat.getTagWireType(i5);
        if (tagWireType == 0) {
            writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
        } else if (tagWireType == 1) {
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
        } else if (tagWireType == 2) {
            writer.writeBytes(tagFieldNumber, (ByteString) obj);
        } else if (tagWireType != 3) {
            if (tagWireType == 5) {
                writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeEndGroup(tagFieldNumber);
        } else {
            writer.writeEndGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeStartGroup(tagFieldNumber);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i5 = this.count;
        if (i5 != unknownFieldSetLite.count || !tagsEquals(this.tags, unknownFieldSetLite.tags, i5) || !objectsEquals(this.objects, unknownFieldSetLite.objects, this.count)) {
            return false;
        }
        return true;
    }

    public int getSerializedSize() {
        int computeUInt64Size;
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.count; i7++) {
            int i8 = this.tags[i7];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i8);
            int tagWireType = WireFormat.getTagWireType(i8);
            if (tagWireType == 0) {
                computeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.objects[i7]).longValue());
            } else if (tagWireType == 1) {
                computeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.objects[i7]).longValue());
            } else if (tagWireType == 2) {
                computeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.objects[i7]);
            } else if (tagWireType == 3) {
                computeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.objects[i7]).getSerializedSize();
            } else if (tagWireType == 5) {
                computeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.objects[i7]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
            }
            i6 += computeUInt64Size;
        }
        this.memoizedSerializedSize = i6;
        return i6;
    }

    public int getSerializedSizeAsMessageSet() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.count; i7++) {
            i6 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i7]), (ByteString) this.objects[i7]);
        }
        this.memoizedSerializedSize = i6;
        return i6;
    }

    public void makeImmutable() {
        if (this.isMutable) {
            this.isMutable = false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean mergeFieldFrom(int i5, CodedInputStream codedInputStream) throws IOException {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
        int tagWireType = WireFormat.getTagWireType(i5);
        if (tagWireType == 0) {
            storeField(i5, Long.valueOf(codedInputStream.readInt64()));
            return true;
        } else if (tagWireType == 1) {
            storeField(i5, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        } else if (tagWireType == 2) {
            storeField(i5, codedInputStream.readBytes());
            return true;
        } else if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
            storeField(i5, unknownFieldSetLite);
            return true;
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                storeField(i5, Integer.valueOf(codedInputStream.readFixed32()));
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite mergeLengthDelimitedField(int i5, ByteString byteString) {
        checkMutable();
        if (i5 != 0) {
            storeField(WireFormat.makeTag(i5, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite mergeVarintField(int i5, int i6) {
        checkMutable();
        if (i5 != 0) {
            storeField(WireFormat.makeTag(i5, 0), Long.valueOf((long) i6));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public final void printWithIndent(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.count; i6++) {
            MessageLiteToString.printField(sb, i5, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i6])), this.objects[i6]);
        }
    }

    /* access modifiers changed from: package-private */
    public void storeField(int i5, Object obj) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] iArr = this.tags;
        int i6 = this.count;
        iArr[i6] = i5;
        this.objects[i6] = obj;
        this.count = i6 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i5 = 0; i5 < this.count; i5++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[i5]), (ByteString) this.objects[i5]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i5 = 0; i5 < this.count; i5++) {
            int i6 = this.tags[i5];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i6);
            int tagWireType = WireFormat.getTagWireType(i6);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.objects[i5]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.objects[i5]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.objects[i5]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.objects[i5]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.objects[i5]).intValue());
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    private UnknownFieldSetLite(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.memoizedSerializedSize = -1;
        this.count = i5;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z4;
    }

    private static int hashCode(Object[] objArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + objArr[i7].hashCode();
        }
        return i6;
    }

    public int hashCode() {
        int i5 = this.count;
        return ((((527 + i5) * 31) + hashCode(this.tags, i5)) * 31) + hashCode(this.objects, this.count);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public UnknownFieldSetLite mergeFrom(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(getDefaultInstance())) {
            return this;
        }
        checkMutable();
        int i5 = this.count + unknownFieldSetLite.count;
        ensureCapacity(i5);
        System.arraycopy(unknownFieldSetLite.tags, 0, this.tags, this.count, unknownFieldSetLite.count);
        System.arraycopy(unknownFieldSetLite.objects, 0, this.objects, this.count, unknownFieldSetLite.count);
        this.count = i5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i5 = this.count - 1; i5 >= 0; i5--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i5]), this.objects[i5]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.count; i6++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i6]), this.objects[i6]);
        }
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.count != 0) {
            if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                for (int i5 = 0; i5 < this.count; i5++) {
                    writeField(this.tags[i5], this.objects[i5], writer);
                }
                return;
            }
            for (int i6 = this.count - 1; i6 >= 0; i6--) {
                writeField(this.tags[i6], this.objects[i6], writer);
            }
        }
    }
}
