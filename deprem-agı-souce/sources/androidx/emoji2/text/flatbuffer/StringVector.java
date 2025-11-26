package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i5, int i6, ByteBuffer byteBuffer) {
        __reset(i5, i6, byteBuffer);
        return this;
    }

    public String get(int i5) {
        return Table.__string(__element(i5), this.bb, this.utf8);
    }
}
