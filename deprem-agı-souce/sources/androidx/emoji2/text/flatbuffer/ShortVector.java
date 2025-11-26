package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 2, byteBuffer);
        return this;
    }

    public short get(int i5) {
        return this.bb.getShort(__element(i5));
    }

    public int getAsUnsigned(int i5) {
        return get(i5) & 65535;
    }
}
