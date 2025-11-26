package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    /* access modifiers changed from: protected */
    public int __element(int i5) {
        return this.vector + (i5 * this.element_size);
    }

    /* access modifiers changed from: protected */
    public void __reset(int i5, int i6, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i5;
            this.length = byteBuffer.getInt(i5 - 4);
            this.element_size = i6;
            return;
        }
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    /* access modifiers changed from: protected */
    public int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, (ByteBuffer) null);
    }
}
