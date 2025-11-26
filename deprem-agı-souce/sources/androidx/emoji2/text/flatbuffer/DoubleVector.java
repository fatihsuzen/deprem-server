package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 8, byteBuffer);
        return this;
    }

    public double get(int i5) {
        return this.bb.getDouble(__element(i5));
    }
}
