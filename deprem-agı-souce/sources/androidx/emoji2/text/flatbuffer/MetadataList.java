package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i5, int i6, ByteBuffer byteBuffer) {
            __reset(i5, i6, byteBuffer);
            return this;
        }

        public MetadataList get(int i5) {
            return get(new MetadataList(), i5);
        }

        public MetadataList get(MetadataList metadataList, int i5) {
            return metadataList.__assign(Table.__indirect(__element(i5), this.bb), this.bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addList(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.addOffset(1, i5, 0);
    }

    public static void addSourceSha(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.addOffset(2, i5, 0);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.addInt(0, i5, 0);
    }

    public static int createListVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataList(FlatBufferBuilder flatBufferBuilder, int i5, int i6, int i7) {
        flatBufferBuilder.startTable(3);
        addSourceSha(flatBufferBuilder, i7);
        addList(flatBufferBuilder, i6);
        addVersion(flatBufferBuilder, i5);
        return endMetadataList(flatBufferBuilder);
    }

    public static int endMetadataList(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.finish(i5);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.finishSizePrefixed(i5);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer) {
        return getRootAsMetadataList(byteBuffer, new MetadataList());
    }

    public static void startListVector(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.startVector(4, i5, 4);
    }

    public static void startMetadataList(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public MetadataList __assign(int i5, ByteBuffer byteBuffer) {
        __init(i5, byteBuffer);
        return this;
    }

    public void __init(int i5, ByteBuffer byteBuffer) {
        __reset(i5, byteBuffer);
    }

    public MetadataItem list(int i5) {
        return list(new MetadataItem(), i5);
    }

    public int listLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public String sourceSha() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public int version() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataItem list(MetadataItem metadataItem, int i5) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return metadataItem.__assign(__indirect(__vector(__offset) + (i5 * 4)), this.bb);
        }
        return null;
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector vector) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }
}
