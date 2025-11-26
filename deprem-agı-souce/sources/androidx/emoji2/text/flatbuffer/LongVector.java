package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class LongVector extends BaseVector {
    public LongVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 8, byteBuffer);
        return this;
    }

    public long get(int i5) {
        return this.bb.getLong(__element(i5));
    }
}
