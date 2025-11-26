package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i5, int i6, ByteBuffer byteBuffer) {
            __reset(i5, i6, byteBuffer);
            return this;
        }

        public MetadataItem get(int i5) {
            return get(new MetadataItem(), i5);
        }

        public MetadataItem get(MetadataItem metadataItem, int i5) {
            return metadataItem.__assign(Table.__indirect(__element(i5), this.bb), this.bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addCodepoints(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.addOffset(6, i5, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder flatBufferBuilder, short s5) {
        flatBufferBuilder.addShort(3, s5, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder flatBufferBuilder, boolean z4) {
        flatBufferBuilder.addBoolean(1, z4, false);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, short s5) {
        flatBufferBuilder.addShort(5, s5, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.addInt(0, i5, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder flatBufferBuilder, short s5) {
        flatBufferBuilder.addShort(2, s5, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, short s5) {
        flatBufferBuilder.addShort(4, s5, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder flatBufferBuilder, int i5, boolean z4, short s5, short s6, short s7, short s8, int i6) {
        flatBufferBuilder.startTable(7);
        addCodepoints(flatBufferBuilder, i6);
        addId(flatBufferBuilder, i5);
        addHeight(flatBufferBuilder, s8);
        addWidth(flatBufferBuilder, s7);
        addCompatAdded(flatBufferBuilder, s6);
        addSdkAdded(flatBufferBuilder, s5);
        addEmojiStyle(flatBufferBuilder, z4);
        return endMetadataItem(flatBufferBuilder);
    }

    public static int endMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer) {
        return getRootAsMetadataItem(byteBuffer, new MetadataItem());
    }

    public static void startCodepointsVector(FlatBufferBuilder flatBufferBuilder, int i5) {
        flatBufferBuilder.startVector(4, i5, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public MetadataItem __assign(int i5, ByteBuffer byteBuffer) {
        __init(i5, byteBuffer);
        return this;
    }

    public void __init(int i5, ByteBuffer byteBuffer) {
        __reset(i5, byteBuffer);
    }

    public int codepoints(int i5) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i5 * 4));
        }
        return 0;
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 4);
    }

    public int codepointsLength() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public short compatAdded() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean emojiStyle() {
        int __offset = __offset(6);
        if (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) {
            return false;
        }
        return true;
    }

    public short height() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return 0;
    }

    public int id() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public short sdkAdded() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return 0;
    }

    public short width() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return 0;
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public IntVector codepointsVector(IntVector intVector) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }
}
