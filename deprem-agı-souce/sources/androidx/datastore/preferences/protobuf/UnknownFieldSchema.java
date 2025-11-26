package androidx.datastore.preferences.protobuf;

import java.io.IOException;

@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    UnknownFieldSchema() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void mergeFrom(B r3, androidx.datastore.preferences.protobuf.Reader r4, int r5) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.getFieldNumber()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.mergeOneFieldFrom(r3, r4, r5)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UnknownFieldSchema.mergeFrom(java.lang.Object, androidx.datastore.preferences.protobuf.Reader, int):void");
    }

    /* access modifiers changed from: package-private */
    public abstract void addFixed32(B b5, int i5, int i6);

    /* access modifiers changed from: package-private */
    public abstract void addFixed64(B b5, int i5, long j5);

    /* access modifiers changed from: package-private */
    public abstract void addGroup(B b5, int i5, T t5);

    /* access modifiers changed from: package-private */
    public abstract void addLengthDelimited(B b5, int i5, ByteString byteString);

    /* access modifiers changed from: package-private */
    public abstract void addVarint(B b5, int i5, long j5);

    /* access modifiers changed from: package-private */
    public abstract B getBuilderFromMessage(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T getFromMessage(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int getSerializedSize(T t5);

    /* access modifiers changed from: package-private */
    public abstract int getSerializedSizeAsMessageSet(T t5);

    /* access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T merge(T t5, T t6);

    /* access modifiers changed from: package-private */
    public final boolean mergeOneFieldFrom(B b5, Reader reader, int i5) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b5, tagFieldNumber, reader.readInt64());
            return true;
        } else if (tagWireType == 1) {
            addFixed64(b5, tagFieldNumber, reader.readFixed64());
            return true;
        } else if (tagWireType == 2) {
            addLengthDelimited(b5, tagFieldNumber, reader.readBytes());
            return true;
        } else if (tagWireType == 3) {
            Object newBuilder = newBuilder();
            int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
            int i6 = i5 + 1;
            if (i6 < recursionLimit) {
                mergeFrom(newBuilder, reader, i6);
                if (makeTag == reader.getTag()) {
                    addGroup(b5, tagFieldNumber, toImmutable(newBuilder));
                    return true;
                }
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                addFixed32(b5, tagFieldNumber, reader.readFixed32());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract B newBuilder();

    /* access modifiers changed from: package-private */
    public abstract void setBuilderToMessage(Object obj, B b5);

    public void setRecursionLimit(int i5) {
        recursionLimit = i5;
    }

    /* access modifiers changed from: package-private */
    public abstract void setToMessage(Object obj, T t5);

    /* access modifiers changed from: package-private */
    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    /* access modifiers changed from: package-private */
    public abstract T toImmutable(B b5);

    /* access modifiers changed from: package-private */
    public abstract void writeAsMessageSetTo(T t5, Writer writer) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeTo(T t5, Writer writer) throws IOException;
}
