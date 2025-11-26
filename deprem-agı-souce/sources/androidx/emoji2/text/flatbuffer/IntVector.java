package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class IntVector extends BaseVector {
    public IntVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 4, byteBuffer);
        return this;
    }

    public int get(int i5) {
        return this.bb.getInt(__element(i5));
    }

    public long getAsUnsigned(int i5) {
        return ((long) get(i5)) & 4294967295L;
    }
}
