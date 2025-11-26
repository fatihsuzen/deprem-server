package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 1, byteBuffer);
        return this;
    }

    public byte get(int i5) {
        return this.bb.get(__element(i5));
    }

    public int getAsUnsigned(int i5) {
        return get(i5) & 255;
    }
}
