package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i5, int i6, ByteBuffer byteBuffer) {
        __reset(i5, i6, byteBuffer);
        return this;
    }

    public Table get(Table table, int i5) {
        return Table.__union(table, __element(i5), this.bb);
    }
}
